package net.bytebuddy.description.type;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.TypeVariableSource;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.FilterableList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface TypeList extends FilterableList<TypeDescription, TypeList> {
    @SuppressFBWarnings(justification = "Null reference cannot be mutated.", value = {"MS_MUTABLE_ARRAY", "MS_OOI_PKGPROTECT"})
    @AlwaysNull
    public static final String[] NO_INTERFACES = null;
    @AlwaysNull
    public static final TypeList UNDEFINED = null;

    public static abstract class AbstractBase extends FilterableList.AbstractBase<TypeDescription, TypeList> implements TypeList {
        public int getStackSize() {
            return StackSize.of((Collection<? extends TypeDefinition>) this);
        }

        @MaybeNull
        public String[] toInternalNames() {
            int size = size();
            String[] strArr = new String[size];
            Iterator it = iterator();
            int i10 = 0;
            while (it.hasNext()) {
                strArr[i10] = ((TypeDescription) it.next()).getInternalName();
                i10++;
            }
            if (size == 0) {
                return TypeList.NO_INTERFACES;
            }
            return strArr;
        }

        /* access modifiers changed from: protected */
        public TypeList wrap(List<TypeDescription> list) {
            return new Explicit((List<? extends TypeDescription>) list);
        }
    }

    public static class Empty extends FilterableList.Empty<TypeDescription, TypeList> implements TypeList {
        public int getStackSize() {
            return 0;
        }

        @SuppressFBWarnings(justification = "Value is null", value = {"EI_EXPOSE_REP"})
        public String[] toInternalNames() {
            return TypeList.NO_INTERFACES;
        }
    }

    public static class Explicit extends AbstractBase {
        private final List<? extends TypeDescription> typeDescriptions;

        public Explicit(TypeDescription... typeDescriptionArr) {
            this((List<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
        }

        public static TypeList of(List<? extends JavaConstant> list) {
            ArrayList arrayList = new ArrayList(list.size());
            for (JavaConstant typeDescription : list) {
                arrayList.add(typeDescription.getTypeDescription());
            }
            return new Explicit((List<? extends TypeDescription>) arrayList);
        }

        public int size() {
            return this.typeDescriptions.size();
        }

        public Explicit(List<? extends TypeDescription> list) {
            this.typeDescriptions = list;
        }

        public TypeDescription get(int i10) {
            return (TypeDescription) this.typeDescriptions.get(i10);
        }
    }

    public static class ForLoadedTypes extends AbstractBase {
        private final List<? extends Class<?>> types;

        public ForLoadedTypes(Class<?>... clsArr) {
            this((List<? extends Class<?>>) Arrays.asList(clsArr));
        }

        public int size() {
            return this.types.size();
        }

        @MaybeNull
        public String[] toInternalNames() {
            int size = this.types.size();
            String[] strArr = new String[size];
            int i10 = 0;
            for (Class internalName : this.types) {
                strArr[i10] = Type.getInternalName(internalName);
                i10++;
            }
            if (size == 0) {
                return TypeList.NO_INTERFACES;
            }
            return strArr;
        }

        public ForLoadedTypes(List<? extends Class<?>> list) {
            this.types = list;
        }

        public TypeDescription get(int i10) {
            return TypeDescription.ForLoadedType.of((Class) this.types.get(i10));
        }
    }

    public interface Generic extends FilterableList<TypeDescription.Generic, Generic> {

        public static abstract class AbstractBase extends FilterableList.AbstractBase<TypeDescription.Generic, Generic> implements Generic {
            public Generic accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
                ArrayList arrayList = new ArrayList(size());
                Iterator it = iterator();
                while (it.hasNext()) {
                    arrayList.add(((TypeDescription.Generic) it.next()).accept(visitor));
                }
                return new Explicit((List<? extends TypeDefinition>) arrayList);
            }

            public TypeList asErasures() {
                ArrayList arrayList = new ArrayList(size());
                Iterator it = iterator();
                while (it.hasNext()) {
                    arrayList.add(((TypeDescription.Generic) it.next()).asErasure());
                }
                return new Explicit((List<? extends TypeDescription>) arrayList);
            }

            public Generic asRawTypes() {
                ArrayList arrayList = new ArrayList(size());
                Iterator it = iterator();
                while (it.hasNext()) {
                    arrayList.add(((TypeDescription.Generic) it.next()).asRawType());
                }
                return new Explicit((List<? extends TypeDefinition>) arrayList);
            }

            public ByteCodeElement.Token.TokenList<TypeVariableToken> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher) {
                ArrayList arrayList = new ArrayList(size());
                Iterator it = iterator();
                while (it.hasNext()) {
                    arrayList.add(TypeVariableToken.of((TypeDescription.Generic) it.next(), elementMatcher));
                }
                return new ByteCodeElement.Token.TokenList<>(arrayList);
            }

            public int getStackSize() {
                Iterator it = iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    i10 += ((TypeDescription.Generic) it.next()).getStackSize().getSize();
                }
                return i10;
            }

            /* access modifiers changed from: protected */
            public Generic wrap(List<TypeDescription.Generic> list) {
                return new Explicit((List<? extends TypeDefinition>) list);
            }
        }

        public static class Empty extends FilterableList.Empty<TypeDescription.Generic, Generic> implements Generic {
            public Generic accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
                return new Empty();
            }

            public TypeList asErasures() {
                return new Empty();
            }

            public Generic asRawTypes() {
                return this;
            }

            public ByteCodeElement.Token.TokenList<TypeVariableToken> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher) {
                return new ByteCodeElement.Token.TokenList<>((S[]) new TypeVariableToken[0]);
            }

            public int getStackSize() {
                return 0;
            }
        }

        public static class Explicit extends AbstractBase {
            private final List<? extends TypeDefinition> typeDefinitions;

            public Explicit(TypeDefinition... typeDefinitionArr) {
                this((List<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
            }

            public int size() {
                return this.typeDefinitions.size();
            }

            public Explicit(List<? extends TypeDefinition> list) {
                this.typeDefinitions = list;
            }

            public TypeDescription.Generic get(int i10) {
                return ((TypeDefinition) this.typeDefinitions.get(i10)).asGenericType();
            }
        }

        public static class ForDetachedTypes extends AbstractBase {
            private final List<? extends TypeDescription.Generic> detachedTypes;
            private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

            public static class OfTypeVariables extends AbstractBase {
                private final List<? extends TypeVariableToken> detachedTypeVariables;
                private final TypeVariableSource typeVariableSource;
                private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

                protected static class AttachedTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                    private final TypeVariableSource typeVariableSource;
                    private final TypeVariableToken typeVariableToken;
                    private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

                    protected AttachedTypeVariable(TypeVariableSource typeVariableSource2, TypeVariableToken typeVariableToken2, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
                        this.typeVariableSource = typeVariableSource2;
                        this.typeVariableToken = typeVariableToken2;
                        this.visitor = visitor2;
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return this.typeVariableToken.getAnnotations();
                    }

                    public String getSymbol() {
                        return this.typeVariableToken.getSymbol();
                    }

                    public TypeVariableSource getTypeVariableSource() {
                        return this.typeVariableSource;
                    }

                    public Generic getUpperBounds() {
                        return this.typeVariableToken.getBounds().accept(this.visitor);
                    }
                }

                public OfTypeVariables(TypeVariableSource typeVariableSource2, List<? extends TypeVariableToken> list, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
                    this.typeVariableSource = typeVariableSource2;
                    this.detachedTypeVariables = list;
                    this.visitor = visitor2;
                }

                public int size() {
                    return this.detachedTypeVariables.size();
                }

                public TypeDescription.Generic get(int i10) {
                    return new AttachedTypeVariable(this.typeVariableSource, (TypeVariableToken) this.detachedTypeVariables.get(i10), this.visitor);
                }
            }

            public static class WithResolvedErasure extends AbstractBase {
                private final List<? extends TypeDescription.Generic> detachedTypes;
                private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

                public WithResolvedErasure(List<? extends TypeDescription.Generic> list, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
                    this.detachedTypes = list;
                    this.visitor = visitor2;
                }

                public int size() {
                    return this.detachedTypes.size();
                }

                public TypeDescription.Generic get(int i10) {
                    return new TypeDescription.Generic.LazyProjection.WithResolvedErasure((TypeDescription.Generic) this.detachedTypes.get(i10), this.visitor);
                }
            }

            public ForDetachedTypes(List<? extends TypeDescription.Generic> list, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
                this.detachedTypes = list;
                this.visitor = visitor2;
            }

            public static Generic attach(FieldDescription fieldDescription, List<? extends TypeDescription.Generic> list) {
                return new ForDetachedTypes(list, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(fieldDescription));
            }

            public static Generic attachVariables(TypeDescription typeDescription, List<? extends TypeVariableToken> list) {
                return new OfTypeVariables(typeDescription, list, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(typeDescription));
            }

            public int size() {
                return this.detachedTypes.size();
            }

            public static Generic attach(MethodDescription methodDescription, List<? extends TypeDescription.Generic> list) {
                return new ForDetachedTypes(list, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(methodDescription));
            }

            public static Generic attachVariables(MethodDescription methodDescription, List<? extends TypeVariableToken> list) {
                return new OfTypeVariables(methodDescription, list, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(methodDescription));
            }

            public TypeDescription.Generic get(int i10) {
                return (TypeDescription.Generic) ((TypeDescription.Generic) this.detachedTypes.get(i10)).accept(this.visitor);
            }

            public static Generic attach(ParameterDescription parameterDescription, List<? extends TypeDescription.Generic> list) {
                return new ForDetachedTypes(list, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(parameterDescription));
            }
        }

        public static class ForLoadedTypes extends AbstractBase {
            private final List<? extends java.lang.reflect.Type> types;

            public static class OfTypeVariables extends AbstractBase {
                private final List<TypeVariable<?>> typeVariables;

                protected OfTypeVariables(TypeVariable<?>... typeVariableArr) {
                    this((List<TypeVariable<?>>) Arrays.asList(typeVariableArr));
                }

                public static Generic of(GenericDeclaration genericDeclaration) {
                    return new OfTypeVariables((TypeVariable<?>[]) genericDeclaration.getTypeParameters());
                }

                public int size() {
                    return this.typeVariables.size();
                }

                protected OfTypeVariables(List<TypeVariable<?>> list) {
                    this.typeVariables = list;
                }

                public TypeDescription.Generic get(int i10) {
                    TypeVariable typeVariable = this.typeVariables.get(i10);
                    return TypeDefinition.Sort.describe(typeVariable, new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedTypeVariable(typeVariable));
                }
            }

            public ForLoadedTypes(java.lang.reflect.Type... typeArr) {
                this((List<? extends java.lang.reflect.Type>) Arrays.asList(typeArr));
            }

            public int size() {
                return this.types.size();
            }

            public ForLoadedTypes(List<? extends java.lang.reflect.Type> list) {
                this.types = list;
            }

            public TypeDescription.Generic get(int i10) {
                return TypeDefinition.Sort.describe((java.lang.reflect.Type) this.types.get(i10));
            }
        }

        public static class OfConstructorExceptionTypes extends AbstractBase {
            private final Constructor<?> constructor;

            private static class TypeProjection extends TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement {
                private final Constructor<?> constructor;
                private final Class<?>[] erasure;
                private final int index;
                private transient /* synthetic */ TypeDescription.Generic resolved;

                public TypeDescription asErasure() {
                    return TypeDescription.ForLoadedType.of(this.erasure[this.index]);
                }

                /* access modifiers changed from: protected */
                public TypeDescription.Generic.AnnotationReader getAnnotationReader() {
                    return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedExecutableExceptionType(this.constructor, this.index);
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("resolved")
                public TypeDescription.Generic resolve() {
                    TypeDescription.Generic generic;
                    if (this.resolved != null) {
                        generic = null;
                    } else {
                        java.lang.reflect.Type[] genericExceptionTypes = this.constructor.getGenericExceptionTypes();
                        if (this.erasure.length == genericExceptionTypes.length) {
                            generic = TypeDefinition.Sort.describe(genericExceptionTypes[this.index], getAnnotationReader());
                        } else {
                            generic = asRawType();
                        }
                    }
                    if (generic == null) {
                        return this.resolved;
                    }
                    this.resolved = generic;
                    return generic;
                }

                private TypeProjection(Constructor<?> constructor2, int i10, Class<?>[] clsArr) {
                    this.constructor = constructor2;
                    this.index = i10;
                    this.erasure = clsArr;
                }
            }

            public OfConstructorExceptionTypes(Constructor<?> constructor2) {
                this.constructor = constructor2;
            }

            public TypeList asErasures() {
                return new ForLoadedTypes((Class<?>[]) this.constructor.getExceptionTypes());
            }

            public int size() {
                return this.constructor.getExceptionTypes().length;
            }

            public TypeDescription.Generic get(int i10) {
                Constructor<?> constructor2 = this.constructor;
                return new TypeProjection(constructor2, i10, constructor2.getExceptionTypes());
            }
        }

        public static class OfLoadedInterfaceTypes extends AbstractBase {
            private final Class<?> type;

            private static class TypeProjection extends TypeDescription.Generic.LazyProjection.WithLazyNavigation.OfAnnotatedElement {
                private final Class<?>[] erasure;
                private final int index;
                private transient /* synthetic */ TypeDescription.Generic resolved;
                private final Class<?> type;

                public TypeDescription asErasure() {
                    return TypeDescription.ForLoadedType.of(this.erasure[this.index]);
                }

                /* access modifiers changed from: protected */
                public TypeDescription.Generic.AnnotationReader getAnnotationReader() {
                    return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedInterface(this.type, this.index);
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("resolved")
                public TypeDescription.Generic resolve() {
                    TypeDescription.Generic generic;
                    if (this.resolved != null) {
                        generic = null;
                    } else {
                        java.lang.reflect.Type[] genericInterfaces = this.type.getGenericInterfaces();
                        if (this.erasure.length == genericInterfaces.length) {
                            generic = TypeDefinition.Sort.describe(genericInterfaces[this.index], getAnnotationReader());
                        } else {
                            generic = asRawType();
                        }
                    }
                    if (generic == null) {
                        return this.resolved;
                    }
                    this.resolved = generic;
                    return generic;
                }

                private TypeProjection(Class<?> cls, int i10, Class<?>[] clsArr) {
                    this.type = cls;
                    this.index = i10;
                    this.erasure = clsArr;
                }
            }

            public OfLoadedInterfaceTypes(Class<?> cls) {
                this.type = cls;
            }

            public TypeList asErasures() {
                return new ForLoadedTypes((Class<?>[]) this.type.getInterfaces());
            }

            public int size() {
                return this.type.getInterfaces().length;
            }

            public TypeDescription.Generic get(int i10) {
                Class<?> cls = this.type;
                return new TypeProjection(cls, i10, cls.getInterfaces());
            }
        }

        public static class OfMethodExceptionTypes extends AbstractBase {
            private final Method method;

            private static class TypeProjection extends TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement {
                private final Class<?>[] erasure;
                private final int index;
                private final Method method;
                private transient /* synthetic */ TypeDescription.Generic resolved;

                public TypeProjection(Method method2, int i10, Class<?>[] clsArr) {
                    this.method = method2;
                    this.index = i10;
                    this.erasure = clsArr;
                }

                public TypeDescription asErasure() {
                    return TypeDescription.ForLoadedType.of(this.erasure[this.index]);
                }

                /* access modifiers changed from: protected */
                public TypeDescription.Generic.AnnotationReader getAnnotationReader() {
                    return new TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedExecutableExceptionType(this.method, this.index);
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("resolved")
                public TypeDescription.Generic resolve() {
                    TypeDescription.Generic generic;
                    if (this.resolved != null) {
                        generic = null;
                    } else {
                        java.lang.reflect.Type[] genericExceptionTypes = this.method.getGenericExceptionTypes();
                        if (this.erasure.length == genericExceptionTypes.length) {
                            generic = TypeDefinition.Sort.describe(genericExceptionTypes[this.index], getAnnotationReader());
                        } else {
                            generic = asRawType();
                        }
                    }
                    if (generic == null) {
                        return this.resolved;
                    }
                    this.resolved = generic;
                    return generic;
                }
            }

            public OfMethodExceptionTypes(Method method2) {
                this.method = method2;
            }

            public TypeList asErasures() {
                return new ForLoadedTypes((Class<?>[]) this.method.getExceptionTypes());
            }

            public int size() {
                return this.method.getExceptionTypes().length;
            }

            public TypeDescription.Generic get(int i10) {
                Method method2 = this.method;
                return new TypeProjection(method2, i10, method2.getExceptionTypes());
            }
        }

        Generic accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor);

        TypeList asErasures();

        Generic asRawTypes();

        ByteCodeElement.Token.TokenList<TypeVariableToken> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher);

        int getStackSize();
    }

    int getStackSize();

    @MaybeNull
    String[] toInternalNames();
}
