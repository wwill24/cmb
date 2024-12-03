package net.bytebuddy.dynamic.scaffold.subclass;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.FilterableList;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class SubclassImplementationTarget extends Implementation.Target.AbstractBase {
    protected final OriginTypeResolver originTypeResolver;

    public enum Factory implements Implementation.Target.Factory {
        SUPER_CLASS(OriginTypeResolver.SUPER_CLASS),
        LEVEL_TYPE(OriginTypeResolver.LEVEL_TYPE);
        
        private final OriginTypeResolver originTypeResolver;

        private Factory(OriginTypeResolver originTypeResolver2) {
            this.originTypeResolver = originTypeResolver2;
        }

        public Implementation.Target make(TypeDescription typeDescription, MethodGraph.Linked linked, ClassFileVersion classFileVersion) {
            return new SubclassImplementationTarget(typeDescription, linked, Implementation.Target.AbstractBase.DefaultMethodInvocation.of(classFileVersion), this.originTypeResolver);
        }
    }

    public enum OriginTypeResolver {
        SUPER_CLASS {
            /* access modifiers changed from: protected */
            @SuppressFBWarnings(justification = "Assuming super class for given instance.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public TypeDefinition identify(TypeDescription typeDescription) {
                return typeDescription.getSuperClass();
            }
        },
        LEVEL_TYPE {
            /* access modifiers changed from: protected */
            public TypeDefinition identify(TypeDescription typeDescription) {
                return typeDescription;
            }
        };

        /* access modifiers changed from: protected */
        public abstract TypeDefinition identify(TypeDescription typeDescription);
    }

    protected SubclassImplementationTarget(TypeDescription typeDescription, MethodGraph.Linked linked, Implementation.Target.AbstractBase.DefaultMethodInvocation defaultMethodInvocation, OriginTypeResolver originTypeResolver2) {
        super(typeDescription, linked, defaultMethodInvocation);
        this.originTypeResolver = originTypeResolver2;
    }

    private Implementation.SpecialMethodInvocation invokeConstructor(MethodDescription.SignatureToken signatureToken) {
        FilterableList filterableList;
        TypeDescription.Generic superClass = this.instrumentedType.getSuperClass();
        if (superClass == null) {
            filterableList = new MethodList.Empty();
        } else {
            filterableList = (MethodList) superClass.getDeclaredMethods().filter(ElementMatchers.hasSignature(signatureToken).and(ElementMatchers.isVisibleTo(this.instrumentedType)));
        }
        if (filterableList.size() == 1) {
            return Implementation.SpecialMethodInvocation.Simple.of((MethodDescription) filterableList.getOnly(), superClass.asErasure());
        }
        return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
    }

    @SuppressFBWarnings(justification = "Assuming super class for given instance.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
    private Implementation.SpecialMethodInvocation invokeMethod(MethodDescription.SignatureToken signatureToken) {
        MethodGraph.Node locate = this.methodGraph.getSuperClassGraph().locate(signatureToken);
        if (locate.getSort().isUnique()) {
            return Implementation.SpecialMethodInvocation.Simple.of(locate.getRepresentative(), this.instrumentedType.getSuperClass().asErasure());
        }
        return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.originTypeResolver.equals(((SubclassImplementationTarget) obj).originTypeResolver);
    }

    public TypeDefinition getOriginType() {
        return this.originTypeResolver.identify(this.instrumentedType);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.originTypeResolver.hashCode();
    }

    public Implementation.SpecialMethodInvocation invokeSuper(MethodDescription.SignatureToken signatureToken) {
        if (signatureToken.getName().equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
            return invokeConstructor(signatureToken);
        }
        return invokeMethod(signatureToken);
    }
}
