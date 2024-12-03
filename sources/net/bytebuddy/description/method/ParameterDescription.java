package net.bytebuddy.description.method;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface ParameterDescription extends AnnotationSource, NamedElement.WithRuntimeName, NamedElement.WithOptionalName, ModifierReviewable.ForParameterDescription, ByteCodeElement.TypeDependant<InDefinedShape, Token> {
    public static final String NAME_PREFIX = "arg";

    public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements ParameterDescription {
        private transient /* synthetic */ int hashCode;
        private transient /* synthetic */ int offset;

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ParameterDescription)) {
                return false;
            }
            ParameterDescription parameterDescription = (ParameterDescription) obj;
            if (!getDeclaringMethod().equals(parameterDescription.getDeclaringMethod()) || getIndex() != parameterDescription.getIndex()) {
                return false;
            }
            return true;
        }

        public String getActualName() {
            if (isNamed()) {
                return getName();
            }
            return "";
        }

        public String getInternalName() {
            return getName();
        }

        public int getModifiers() {
            return 0;
        }

        public String getName() {
            return "arg".concat(String.valueOf(getIndex()));
        }

        @CachedReturnPlugin.Enhance("offset")
        public int getOffset() {
            int i10;
            int i11 = 0;
            if (this.offset == 0) {
                TypeList asErasures = getDeclaringMethod().getParameters().asTypeList().asErasures();
                if (getDeclaringMethod().isStatic()) {
                    i10 = StackSize.ZERO.getSize();
                } else {
                    i10 = StackSize.SINGLE.getSize();
                }
                while (i11 < getIndex()) {
                    i10 += ((TypeDescription) asErasures.get(i11)).getStackSize().getSize();
                    i11++;
                }
                i11 = i10;
            }
            if (i11 == 0) {
                return this.offset;
            }
            this.offset = i11;
            return i11;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode2 = this.hashCode != 0 ? 0 : getDeclaringMethod().hashCode() ^ getIndex();
            if (hashCode2 == 0) {
                return this.hashCode;
            }
            this.hashCode = hashCode2;
            return hashCode2;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder(Modifier.toString(getModifiers()));
            if (getModifiers() != 0) {
                sb2.append(' ');
            }
            if (isVarArgs()) {
                str = getType().asErasure().getName().replaceFirst("\\[]$", "...");
            } else {
                str = getType().asErasure().getName();
            }
            sb2.append(str);
            sb2.append(' ');
            sb2.append(getName());
            return sb2.toString();
        }

        public Token asToken(ElementMatcher<? super TypeDescription> elementMatcher) {
            return new Token((TypeDescription.Generic) getType().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher)), getDeclaredAnnotations(), isNamed() ? getName() : Token.NO_NAME, hasModifiers() ? Integer.valueOf(getModifiers()) : Token.NO_MODIFIERS);
        }
    }

    public static abstract class ForLoadedParameter<T extends AccessibleObject> extends InDefinedShape.AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final Parameter PARAMETER = ((Parameter) doPrivileged(JavaDispatcher.of(Parameter.class)));
        protected final T executable;
        protected final int index;
        protected final ParameterAnnotationSource parameterAnnotationSource;

        protected static class OfConstructor extends ForLoadedParameter<Constructor<?>> {
            protected OfConstructor(Constructor<?> constructor, int i10, ParameterAnnotationSource parameterAnnotationSource) {
                super(constructor, i10, parameterAnnotationSource);
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs", value = {"BC_UNCONFIRMED_CAST"})
            public AnnotationList getDeclaredAnnotations() {
                Annotation[][] parameterAnnotations = this.parameterAnnotationSource.getParameterAnnotations();
                MethodDescription.InDefinedShape declaringMethod = getDeclaringMethod();
                if (parameterAnnotations.length == declaringMethod.getParameters().size() || !declaringMethod.getDeclaringType().isInnerClass()) {
                    return new AnnotationList.ForLoadedAnnotations(parameterAnnotations[this.index]);
                }
                if (this.index == 0) {
                    return new AnnotationList.Empty();
                }
                return new AnnotationList.ForLoadedAnnotations(parameterAnnotations[this.index - 1]);
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs.", value = {"BC_UNCONFIRMED_CAST"})
            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(((Constructor) this.executable).getParameterTypes()[this.index]);
                }
                T t10 = this.executable;
                return new TypeDescription.Generic.LazyProjection.OfConstructorParameter((Constructor) t10, this.index, ((Constructor) t10).getParameterTypes());
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs.", value = {"BC_UNCONFIRMED_CAST"})
            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedConstructor((Constructor) this.executable);
            }
        }

        protected static class OfLegacyVmConstructor extends InDefinedShape.AbstractBase {
            private final Constructor<?> constructor;
            private final int index;
            private final ParameterAnnotationSource parameterAnnotationSource;
            private final Class<?>[] parameterType;

            protected OfLegacyVmConstructor(Constructor<?> constructor2, int i10, Class<?>[] clsArr, ParameterAnnotationSource parameterAnnotationSource2) {
                this.constructor = constructor2;
                this.index = i10;
                this.parameterType = clsArr;
                this.parameterAnnotationSource = parameterAnnotationSource2;
            }

            public AnnotationList getDeclaredAnnotations() {
                MethodDescription.InDefinedShape declaringMethod = getDeclaringMethod();
                Annotation[][] parameterAnnotations = this.parameterAnnotationSource.getParameterAnnotations();
                if (parameterAnnotations.length == declaringMethod.getParameters().size() || !declaringMethod.getDeclaringType().isInnerClass()) {
                    return new AnnotationList.ForLoadedAnnotations(parameterAnnotations[this.index]);
                }
                if (this.index == 0) {
                    return new AnnotationList.Empty();
                }
                return new AnnotationList.ForLoadedAnnotations(parameterAnnotations[this.index - 1]);
            }

            public int getIndex() {
                return this.index;
            }

            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.parameterType[this.index]);
                }
                return new TypeDescription.Generic.LazyProjection.OfConstructorParameter(this.constructor, this.index, this.parameterType);
            }

            public boolean hasModifiers() {
                return false;
            }

            public boolean isNamed() {
                return false;
            }

            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedConstructor(this.constructor);
            }
        }

        protected static class OfLegacyVmMethod extends InDefinedShape.AbstractBase {
            private final int index;
            private final Method method;
            private final ParameterAnnotationSource parameterAnnotationSource;
            private final Class<?>[] parameterType;

            protected OfLegacyVmMethod(Method method2, int i10, Class<?>[] clsArr, ParameterAnnotationSource parameterAnnotationSource2) {
                this.method = method2;
                this.index = i10;
                this.parameterType = clsArr;
                this.parameterAnnotationSource = parameterAnnotationSource2;
            }

            public AnnotationList getDeclaredAnnotations() {
                return new AnnotationList.ForLoadedAnnotations(this.parameterAnnotationSource.getParameterAnnotations()[this.index]);
            }

            public int getIndex() {
                return this.index;
            }

            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.parameterType[this.index]);
                }
                return new TypeDescription.Generic.LazyProjection.OfMethodParameter(this.method, this.index, this.parameterType);
            }

            public boolean hasModifiers() {
                return false;
            }

            public boolean isNamed() {
                return false;
            }

            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedMethod(this.method);
            }
        }

        protected static class OfMethod extends ForLoadedParameter<Method> {
            protected OfMethod(Method method, int i10, ParameterAnnotationSource parameterAnnotationSource) {
                super(method, i10, parameterAnnotationSource);
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs.", value = {"BC_UNCONFIRMED_CAST"})
            public AnnotationList getDeclaredAnnotations() {
                return new AnnotationList.ForLoadedAnnotations(this.parameterAnnotationSource.getParameterAnnotations()[this.index]);
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs.", value = {"BC_UNCONFIRMED_CAST"})
            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(((Method) this.executable).getParameterTypes()[this.index]);
                }
                T t10 = this.executable;
                return new TypeDescription.Generic.LazyProjection.OfMethodParameter((Method) t10, this.index, ((Method) t10).getParameterTypes());
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs.", value = {"BC_UNCONFIRMED_CAST"})
            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedMethod((Method) this.executable);
            }
        }

        @JavaDispatcher.Proxied("java.lang.reflect.Parameter")
        protected interface Parameter {
            @JavaDispatcher.Proxied("getModifiers")
            int getModifiers(Object obj);

            @JavaDispatcher.Proxied("getName")
            String getName(Object obj);

            @JavaDispatcher.Proxied("isNamePresent")
            boolean isNamePresent(Object obj);
        }

        public interface ParameterAnnotationSource {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForLoadedConstructor implements ParameterAnnotationSource {
                private final Constructor<?> constructor;

                public ForLoadedConstructor(Constructor<?> constructor2) {
                    this.constructor = constructor2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.constructor.equals(((ForLoadedConstructor) obj).constructor);
                }

                public Annotation[][] getParameterAnnotations() {
                    return this.constructor.getParameterAnnotations();
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.constructor.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForLoadedMethod implements ParameterAnnotationSource {
                private final Method method;

                public ForLoadedMethod(Method method2) {
                    this.method = method2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.method.equals(((ForLoadedMethod) obj).method);
                }

                public Annotation[][] getParameterAnnotations() {
                    return this.method.getParameterAnnotations();
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.method.hashCode();
                }
            }

            Annotation[][] getParameterAnnotations();
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

        protected ForLoadedParameter(T t10, int i10, ParameterAnnotationSource parameterAnnotationSource2) {
            this.executable = t10;
            this.index = i10;
            this.parameterAnnotationSource = parameterAnnotationSource2;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public int getIndex() {
            return this.index;
        }

        public int getModifiers() {
            return PARAMETER.getModifiers(ParameterList.ForLoadedExecutable.EXECUTABLE.getParameters(this.executable)[this.index]);
        }

        public String getName() {
            return PARAMETER.getName(ParameterList.ForLoadedExecutable.EXECUTABLE.getParameters(this.executable)[this.index]);
        }

        public boolean hasModifiers() {
            return isNamed() || getModifiers() != 0;
        }

        public boolean isNamed() {
            return PARAMETER.isNamePresent(ParameterList.ForLoadedExecutable.EXECUTABLE.getParameters(this.executable)[this.index]);
        }
    }

    public interface InDefinedShape extends ParameterDescription {

        public static abstract class AbstractBase extends AbstractBase implements InDefinedShape {
            public InDefinedShape asDefined() {
                return this;
            }
        }

        MethodDescription.InDefinedShape getDeclaringMethod();
    }

    public interface InGenericShape extends ParameterDescription {
        MethodDescription.InGenericShape getDeclaringMethod();
    }

    public static class Latent extends InDefinedShape.AbstractBase {
        private final List<? extends AnnotationDescription> declaredAnnotations;
        private final MethodDescription.InDefinedShape declaringMethod;
        private final int index;
        @MaybeNull
        private final Integer modifiers;
        @MaybeNull
        private final String name;
        private final int offset;
        private final TypeDescription.Generic parameterType;

        public Latent(MethodDescription.InDefinedShape inDefinedShape, Token token, int i10, int i11) {
            this(inDefinedShape, token.getType(), token.getAnnotations(), token.getName(), token.getModifiers(), i10, i11);
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.declaredAnnotations);
        }

        public int getIndex() {
            return this.index;
        }

        public int getModifiers() {
            Integer num = this.modifiers;
            if (num == null) {
                return super.getModifiers();
            }
            return num.intValue();
        }

        public String getName() {
            String str = this.name;
            if (str == null) {
                return super.getName();
            }
            return str;
        }

        public int getOffset() {
            return this.offset;
        }

        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.parameterType.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of((ParameterDescription) this));
        }

        public boolean hasModifiers() {
            return this.modifiers != null;
        }

        public boolean isNamed() {
            return this.name != null;
        }

        public MethodDescription.InDefinedShape getDeclaringMethod() {
            return this.declaringMethod;
        }

        public Latent(MethodDescription.InDefinedShape inDefinedShape, TypeDescription.Generic generic, int i10, int i11) {
            this(inDefinedShape, generic, Collections.emptyList(), Token.NO_NAME, Token.NO_MODIFIERS, i10, i11);
        }

        public Latent(MethodDescription.InDefinedShape inDefinedShape, TypeDescription.Generic generic, List<? extends AnnotationDescription> list, @MaybeNull String str, @MaybeNull Integer num, int i10, int i11) {
            this.declaringMethod = inDefinedShape;
            this.parameterType = generic;
            this.declaredAnnotations = list;
            this.name = str;
            this.modifiers = num;
            this.index = i10;
            this.offset = i11;
        }
    }

    public static class Token implements ByteCodeElement.Token<Token> {
        @AlwaysNull
        public static final Integer NO_MODIFIERS = null;
        @AlwaysNull
        public static final String NO_NAME = null;
        private final List<? extends AnnotationDescription> annotations;
        private transient /* synthetic */ int hashCode;
        @MaybeNull
        private final Integer modifiers;
        @MaybeNull
        private final String name;
        private final TypeDescription.Generic type;

        public static class TypeList extends AbstractList<Token> {
            private final List<? extends TypeDefinition> typeDescriptions;

            public TypeList(List<? extends TypeDefinition> list) {
                this.typeDescriptions = list;
            }

            public int size() {
                return this.typeDescriptions.size();
            }

            public Token get(int i10) {
                return new Token(((TypeDefinition) this.typeDescriptions.get(i10)).asGenericType());
            }
        }

        public Token(TypeDescription.Generic generic) {
            this(generic, Collections.emptyList());
        }

        public boolean equals(@MaybeNull Object obj) {
            String str;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.type.equals(token.type) && this.annotations.equals(token.annotations) && ((str = this.name) == null ? token.name == null : str.equals(token.name))) {
                Integer num = this.modifiers;
                if (num != null) {
                    if (num.equals(token.modifiers)) {
                        return true;
                    }
                } else if (token.modifiers == null) {
                    return true;
                }
            }
            return false;
        }

        public AnnotationList getAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        @MaybeNull
        public Integer getModifiers() {
            return this.modifiers;
        }

        @MaybeNull
        public String getName() {
            return this.name;
        }

        public TypeDescription.Generic getType() {
            return this.type;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i10;
            int i11 = 0;
            if (this.hashCode == 0) {
                int hashCode2 = ((this.type.hashCode() * 31) + this.annotations.hashCode()) * 31;
                String str = this.name;
                if (str != null) {
                    i10 = str.hashCode();
                } else {
                    i10 = 0;
                }
                int i12 = (hashCode2 + i10) * 31;
                Integer num = this.modifiers;
                if (num != null) {
                    i11 = num.hashCode();
                }
                i11 += i12;
            }
            if (i11 == 0) {
                return this.hashCode;
            }
            this.hashCode = i11;
            return i11;
        }

        public String toString() {
            return "ParameterDescription.Token{type=" + this.type + ", annotations=" + this.annotations + ", name='" + this.name + '\'' + ", modifiers=" + this.modifiers + '}';
        }

        public Token(TypeDescription.Generic generic, List<? extends AnnotationDescription> list) {
            this(generic, list, NO_NAME, NO_MODIFIERS);
        }

        public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            return new Token((TypeDescription.Generic) this.type.accept(visitor), this.annotations, this.name, this.modifiers);
        }

        public Token(TypeDescription.Generic generic, @MaybeNull String str, @MaybeNull Integer num) {
            this(generic, Collections.emptyList(), str, num);
        }

        public Token(TypeDescription.Generic generic, List<? extends AnnotationDescription> list, @MaybeNull String str, @MaybeNull Integer num) {
            this.type = generic;
            this.annotations = list;
            this.name = str;
            this.modifiers = num;
        }
    }

    public static class TypeSubstituting extends AbstractBase implements InGenericShape {
        private final MethodDescription.InGenericShape declaringMethod;
        private final ParameterDescription parameterDescription;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(MethodDescription.InGenericShape inGenericShape, ParameterDescription parameterDescription2, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
            this.declaringMethod = inGenericShape;
            this.parameterDescription = parameterDescription2;
            this.visitor = visitor2;
        }

        public AnnotationList getDeclaredAnnotations() {
            return this.parameterDescription.getDeclaredAnnotations();
        }

        public int getIndex() {
            return this.parameterDescription.getIndex();
        }

        public int getModifiers() {
            return this.parameterDescription.getModifiers();
        }

        public String getName() {
            return this.parameterDescription.getName();
        }

        public int getOffset() {
            return this.parameterDescription.getOffset();
        }

        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.parameterDescription.getType().accept(this.visitor);
        }

        public boolean hasModifiers() {
            return this.parameterDescription.hasModifiers();
        }

        public boolean isNamed() {
            return this.parameterDescription.isNamed();
        }

        public InDefinedShape asDefined() {
            return (InDefinedShape) this.parameterDescription.asDefined();
        }

        public MethodDescription.InGenericShape getDeclaringMethod() {
            return this.declaringMethod;
        }
    }

    MethodDescription getDeclaringMethod();

    int getIndex();

    int getOffset();

    TypeDescription.Generic getType();

    boolean hasModifiers();
}
