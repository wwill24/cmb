package net.bytebuddy.description.type;

import com.facebook.internal.ServerProtocol;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.DeclaredByType;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.jar.asm.signature.SignatureWriter;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface RecordComponentDescription extends DeclaredByType.WithMandatoryDeclaration, NamedElement.WithDescriptor, AnnotationSource, ByteCodeElement.TypeDependant<InDefinedShape, Token> {

    public static abstract class AbstractBase implements RecordComponentDescription {
        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RecordComponentDescription)) {
                return false;
            }
            return getActualName().equals(((RecordComponentDescription) obj).getActualName());
        }

        public String getDescriptor() {
            return getType().asErasure().getDescriptor();
        }

        @MaybeNull
        public String getGenericSignature() {
            TypeDescription.Generic type = getType();
            try {
                if (type.getSort().isNonGeneric()) {
                    return NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE;
                }
                return ((SignatureVisitor) type.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(new SignatureWriter()))).toString();
            } catch (GenericSignatureFormatError unused) {
                return NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE;
            }
        }

        public int hashCode() {
            return getActualName().hashCode();
        }

        public String toString() {
            return getType().getTypeName() + " " + getActualName();
        }

        public Token asToken(ElementMatcher<? super TypeDescription> elementMatcher) {
            return new Token(getActualName(), (TypeDescription.Generic) getType().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher)), getDeclaredAnnotations());
        }
    }

    public static class ForLoadedRecordComponent extends InDefinedShape.AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        protected static final RecordComponent RECORD_COMPONENT = ((RecordComponent) doPrivileged(JavaDispatcher.of(RecordComponent.class)));
        private final AnnotatedElement recordComponent;

        @JavaDispatcher.Proxied("java.lang.reflect.RecordComponent")
        protected interface RecordComponent {
            @JavaDispatcher.Proxied("getAccessor")
            Method getAccessor(Object obj);

            @JavaDispatcher.Proxied("getAnnotatedType")
            AnnotatedElement getAnnotatedType(Object obj);

            @JavaDispatcher.Proxied("getDeclaringRecord")
            Class<?> getDeclaringRecord(Object obj);

            @JavaDispatcher.Proxied("getGenericSignature")
            @MaybeNull
            String getGenericSignature(Object obj);

            @JavaDispatcher.Proxied("getGenericType")
            Type getGenericType(Object obj);

            @JavaDispatcher.Proxied("getName")
            String getName(Object obj);

            @JavaDispatcher.Proxied("getType")
            Class<?> getType(Object obj);

            @JavaDispatcher.Proxied("isInstance")
            @JavaDispatcher.Instance
            boolean isInstance(Object obj);
        }

        static {
            boolean z10 = false;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            } catch (ClassNotFoundException unused) {
            } catch (SecurityException unused2) {
                z10 = true;
            }
            ACCESS_CONTROLLER = z10;
        }

        protected ForLoadedRecordComponent(AnnotatedElement annotatedElement) {
            this.recordComponent = annotatedElement;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static RecordComponentDescription of(Object obj) {
            if (RECORD_COMPONENT.isInstance(obj)) {
                return new ForLoadedRecordComponent((AnnotatedElement) obj);
            }
            throw new IllegalArgumentException("Not a record component: " + obj);
        }

        public String getActualName() {
            return RECORD_COMPONENT.getName(this.recordComponent);
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.ForLoadedAnnotations(this.recordComponent.getDeclaredAnnotations());
        }

        @MaybeNull
        public String getGenericSignature() {
            return RECORD_COMPONENT.getGenericSignature(this.recordComponent);
        }

        public TypeDescription.Generic getType() {
            return new TypeDescription.Generic.LazyProjection.OfRecordComponent(this.recordComponent);
        }

        public MethodDescription.InDefinedShape getAccessor() {
            return new MethodDescription.ForLoadedMethod(RECORD_COMPONENT.getAccessor(this.recordComponent));
        }

        public TypeDescription getDeclaringType() {
            return TypeDescription.ForLoadedType.of(RECORD_COMPONENT.getDeclaringRecord(this.recordComponent));
        }
    }

    public interface InDefinedShape extends RecordComponentDescription {

        public static abstract class AbstractBase extends AbstractBase implements InDefinedShape {
            public InDefinedShape asDefined() {
                return this;
            }

            public MethodDescription.InDefinedShape getAccessor() {
                return (MethodDescription.InDefinedShape) ((MethodList) getDeclaringType().getDeclaredMethods().filter(ElementMatchers.named(getActualName()))).getOnly();
            }
        }

        MethodDescription.InDefinedShape getAccessor();

        TypeDescription getDeclaringType();
    }

    public interface InGenericShape extends RecordComponentDescription {
        MethodDescription.InGenericShape getAccessor();
    }

    public static class Latent extends InDefinedShape.AbstractBase {
        private final List<? extends AnnotationDescription> annotations;
        private final TypeDescription declaringType;
        private final String name;
        private final TypeDescription.Generic type;

        public Latent(TypeDescription typeDescription, Token token) {
            this(typeDescription, token.getName(), token.getType(), token.getAnnotations());
        }

        public String getActualName() {
            return this.name;
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.type.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of((RecordComponentDescription) this));
        }

        public TypeDescription getDeclaringType() {
            return this.declaringType;
        }

        public Latent(TypeDescription typeDescription, String str, TypeDescription.Generic generic, List<? extends AnnotationDescription> list) {
            this.declaringType = typeDescription;
            this.name = str;
            this.type = generic;
            this.annotations = list;
        }
    }

    public static class Token implements ByteCodeElement.Token<Token> {
        private final List<? extends AnnotationDescription> annotations;
        private transient /* synthetic */ int hashCode;
        private final String name;
        private final TypeDescription.Generic type;

        public Token(String str, TypeDescription.Generic generic) {
            this(str, generic, Collections.emptyList());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Token token = (Token) obj;
            if (!this.name.equals(token.name) || !this.type.equals(token.type) || !this.annotations.equals(token.annotations)) {
                return false;
            }
            return true;
        }

        public AnnotationList getAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription.Generic getType() {
            return this.type;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i10;
            if (this.hashCode != 0) {
                i10 = 0;
            } else {
                i10 = (((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + this.annotations.hashCode();
            }
            if (i10 == 0) {
                return this.hashCode;
            }
            this.hashCode = i10;
            return i10;
        }

        public Token(String str, TypeDescription.Generic generic, List<? extends AnnotationDescription> list) {
            this.name = str;
            this.type = generic;
            this.annotations = list;
        }

        public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            return new Token(this.name, (TypeDescription.Generic) this.type.accept(visitor), this.annotations);
        }
    }

    public static class TypeSubstituting extends AbstractBase implements InGenericShape {
        private final TypeDescription.Generic declaringType;
        private final RecordComponentDescription recordComponentDescription;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic generic, RecordComponentDescription recordComponentDescription2, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
            this.declaringType = generic;
            this.recordComponentDescription = recordComponentDescription2;
            this.visitor = visitor2;
        }

        public String getActualName() {
            return this.recordComponentDescription.getActualName();
        }

        public AnnotationList getDeclaredAnnotations() {
            return this.recordComponentDescription.getDeclaredAnnotations();
        }

        public TypeDefinition getDeclaringType() {
            return this.declaringType;
        }

        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.recordComponentDescription.getType().accept(this.visitor);
        }

        public InDefinedShape asDefined() {
            return (InDefinedShape) this.recordComponentDescription.asDefined();
        }

        public MethodDescription.InGenericShape getAccessor() {
            return (MethodDescription.InGenericShape) ((MethodList) this.declaringType.getDeclaredMethods().filter(ElementMatchers.named(getActualName()))).getOnly();
        }
    }

    Token asToken(ElementMatcher<? super TypeDescription> elementMatcher);

    MethodDescription getAccessor();

    TypeDescription.Generic getType();
}
