package net.bytebuddy.implementation.bytecode.constant;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.auxiliary.PrivilegedMemberLookupAction;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

public abstract class MethodConstant extends StackManipulation.AbstractBase {
    @MaybeNull
    protected static final MethodDescription.InDefinedShape DO_PRIVILEGED = doPrivileged();
    protected final MethodDescription.InDefinedShape methodDescription;

    protected static class CachedConstructor implements StackManipulation {
        private static final TypeDescription CONSTRUCTOR_TYPE = TypeDescription.ForLoadedType.of(Constructor.class);
        private final StackManipulation constructorConstant;

        protected CachedConstructor(StackManipulation stackManipulation) {
            this.constructorConstant = stackManipulation;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return FieldAccess.forField(context.cache(this.constructorConstant, CONSTRUCTOR_TYPE)).read().apply(methodVisitor, context);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.constructorConstant.equals(((CachedConstructor) obj).constructorConstant);
        }

        public int hashCode() {
            return this.constructorConstant.hashCode();
        }

        public boolean isValid() {
            return this.constructorConstant.isValid();
        }
    }

    protected static class CachedMethod implements StackManipulation {
        private static final TypeDescription METHOD_TYPE = TypeDescription.ForLoadedType.of(Method.class);
        private final StackManipulation methodConstant;

        protected CachedMethod(StackManipulation stackManipulation) {
            this.methodConstant = stackManipulation;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return FieldAccess.forField(context.cache(this.methodConstant, METHOD_TYPE)).read().apply(methodVisitor, context);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.methodConstant.equals(((CachedMethod) obj).methodConstant);
        }

        public int hashCode() {
            return this.methodConstant.hashCode();
        }

        public boolean isValid() {
            return this.methodConstant.isValid();
        }
    }

    public interface CanCache extends StackManipulation {
        StackManipulation cached();
    }

    protected enum CanCacheIllegal implements CanCache {
        INSTANCE;

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return StackManipulation.Illegal.INSTANCE.apply(methodVisitor, context);
        }

        public StackManipulation cached() {
            return StackManipulation.Illegal.INSTANCE;
        }

        public boolean isValid() {
            return false;
        }
    }

    protected static class ForConstructor extends MethodConstant implements CanCache {
        private static final MethodDescription.InDefinedShape GET_CONSTRUCTOR;
        private static final MethodDescription.InDefinedShape GET_DECLARED_CONSTRUCTOR;

        static {
            try {
                GET_CONSTRUCTOR = new MethodDescription.ForLoadedMethod(Class.class.getMethod("getConstructor", new Class[]{Class[].class}));
                GET_DECLARED_CONSTRUCTOR = new MethodDescription.ForLoadedMethod(Class.class.getMethod(TypeProxy.SilentConstruction.Appender.GET_DECLARED_CONSTRUCTOR_METHOD_NAME, new Class[]{Class[].class}));
            } catch (NoSuchMethodException e10) {
                throw new IllegalStateException("Could not locate Class::getDeclaredConstructor", e10);
            }
        }

        protected ForConstructor(MethodDescription.InDefinedShape inDefinedShape) {
            super(inDefinedShape);
        }

        /* access modifiers changed from: protected */
        public MethodDescription.InDefinedShape accessorMethod() {
            return this.methodDescription.isPublic() ? GET_CONSTRUCTOR : GET_DECLARED_CONSTRUCTOR;
        }

        public StackManipulation cached() {
            return new CachedConstructor(this);
        }

        /* access modifiers changed from: protected */
        public StackManipulation methodName() {
            return StackManipulation.Trivial.INSTANCE;
        }
    }

    protected static class ForMethod extends MethodConstant implements CanCache {
        private static final MethodDescription.InDefinedShape GET_DECLARED_METHOD;
        private static final MethodDescription.InDefinedShape GET_METHOD;

        static {
            Class<String> cls = String.class;
            try {
                GET_METHOD = new MethodDescription.ForLoadedMethod(Class.class.getMethod("getMethod", new Class[]{cls, Class[].class}));
                GET_DECLARED_METHOD = new MethodDescription.ForLoadedMethod(Class.class.getMethod("getDeclaredMethod", new Class[]{cls, Class[].class}));
            } catch (NoSuchMethodException e10) {
                throw new IllegalStateException("Could not locate method lookup", e10);
            }
        }

        protected ForMethod(MethodDescription.InDefinedShape inDefinedShape) {
            super(inDefinedShape);
        }

        /* access modifiers changed from: protected */
        public MethodDescription.InDefinedShape accessorMethod() {
            return this.methodDescription.isPublic() ? GET_METHOD : GET_DECLARED_METHOD;
        }

        public StackManipulation cached() {
            return new CachedMethod(this);
        }

        /* access modifiers changed from: protected */
        public StackManipulation methodName() {
            return new TextConstant(this.methodDescription.getInternalName());
        }
    }

    protected static class PrivilegedLookup implements StackManipulation, CanCache {
        private final MethodDescription.InDefinedShape methodDescription;
        private final StackManipulation methodName;

        protected PrivilegedLookup(MethodDescription.InDefinedShape inDefinedShape, StackManipulation stackManipulation) {
            this.methodDescription = inDefinedShape;
            this.methodName = stackManipulation;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            Class cls;
            MethodDescription.InDefinedShape inDefinedShape = MethodConstant.DO_PRIVILEGED;
            if (inDefinedShape != null) {
                TypeDescription register = context.register(PrivilegedMemberLookupAction.of(this.methodDescription));
                StackManipulation[] stackManipulationArr = new StackManipulation[8];
                stackManipulationArr[0] = TypeCreation.of(register);
                stackManipulationArr[1] = Duplication.SINGLE;
                stackManipulationArr[2] = ClassConstant.of(this.methodDescription.getDeclaringType());
                stackManipulationArr[3] = this.methodName;
                stackManipulationArr[4] = ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Class.class)).withValues(MethodConstant.typeConstantsFor(this.methodDescription.getParameters().asTypeList().asErasures()));
                stackManipulationArr[5] = MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) register.getDeclaredMethods().filter(ElementMatchers.isConstructor())).getOnly());
                stackManipulationArr[6] = MethodInvocation.invoke(inDefinedShape);
                if (this.methodDescription.isConstructor()) {
                    cls = Constructor.class;
                } else {
                    cls = Method.class;
                }
                stackManipulationArr[7] = TypeCasting.to(TypeDescription.ForLoadedType.of(cls));
                return new StackManipulation.Compound(stackManipulationArr).apply(methodVisitor, context);
            }
            throw new IllegalStateException("Privileged method invocation is not supported on the current VM");
        }

        public StackManipulation cached() {
            return this.methodDescription.isConstructor() ? new CachedConstructor(this) : new CachedMethod(this);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.methodDescription.equals(((PrivilegedLookup) obj).methodDescription);
        }

        public int hashCode() {
            return this.methodDescription.hashCode();
        }

        public boolean isValid() {
            return this.methodName.isValid();
        }
    }

    protected MethodConstant(MethodDescription.InDefinedShape inDefinedShape) {
        this.methodDescription = inDefinedShape;
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
    @MaybeNull
    private static MethodDescription.InDefinedShape doPrivileged() {
        try {
            MethodDescription.ForLoadedMethod forLoadedMethod = new MethodDescription.ForLoadedMethod(Class.forName("java.security.AccessController").getMethod("doPrivileged", new Class[]{PrivilegedExceptionAction.class}));
            try {
                if (!Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE))) {
                    return null;
                }
            } catch (SecurityException unused) {
            }
            return forLoadedMethod;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static CanCache of(MethodDescription.InDefinedShape inDefinedShape) {
        if (inDefinedShape.isTypeInitializer()) {
            return CanCacheIllegal.INSTANCE;
        }
        if (inDefinedShape.isConstructor()) {
            return new ForConstructor(inDefinedShape);
        }
        return new ForMethod(inDefinedShape);
    }

    public static CanCache ofPrivileged(MethodDescription.InDefinedShape inDefinedShape) {
        if (DO_PRIVILEGED == null) {
            return of(inDefinedShape);
        }
        if (inDefinedShape.isTypeInitializer()) {
            return CanCacheIllegal.INSTANCE;
        }
        if (inDefinedShape.isConstructor()) {
            return new ForConstructor(inDefinedShape).withPrivilegedLookup();
        }
        return new ForMethod(inDefinedShape).withPrivilegedLookup();
    }

    protected static List<StackManipulation> typeConstantsFor(List<TypeDescription> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (TypeDescription of2 : list) {
            arrayList.add(ClassConstant.of(of2));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public abstract MethodDescription.InDefinedShape accessorMethod();

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        return new StackManipulation.Compound(ClassConstant.of(this.methodDescription.getDeclaringType()), methodName(), ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Class.class)).withValues(typeConstantsFor(this.methodDescription.getParameters().asTypeList().asErasures())), MethodInvocation.invoke(accessorMethod())).apply(methodVisitor, context);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.methodDescription.equals(((MethodConstant) obj).methodDescription);
    }

    public int hashCode() {
        return this.methodDescription.hashCode();
    }

    /* access modifiers changed from: protected */
    public abstract StackManipulation methodName();

    /* access modifiers changed from: protected */
    public CanCache withPrivilegedLookup() {
        return new PrivilegedLookup(this.methodDescription, methodName());
    }
}
