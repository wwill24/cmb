package net.bytebuddy.dynamic.scaffold.inline;

import com.coffeemeetsbagel.models.Height;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.auxiliary.TrivialType;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface MethodRebaseResolver {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements MethodRebaseResolver {
        private final List<DynamicType> dynamicTypes;
        private final Map<MethodDescription.InDefinedShape, Resolution> resolutions;

        protected Default(Map<MethodDescription.InDefinedShape, Resolution> map, List<DynamicType> list) {
            this.resolutions = map;
            this.dynamicTypes = list;
        }

        public static MethodRebaseResolver make(TypeDescription typeDescription, Set<? extends MethodDescription.SignatureToken> set, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, MethodNameTransformer methodNameTransformer) {
            Resolution resolution;
            HashMap hashMap = new HashMap();
            DynamicType dynamicType = null;
            for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods()) {
                if (set.contains(inDefinedShape.asSignatureToken())) {
                    if (inDefinedShape.isConstructor()) {
                        if (dynamicType == null) {
                            TrivialType trivialType = TrivialType.SIGNATURE_RELEVANT;
                            dynamicType = trivialType.make(namingStrategy.name(typeDescription, trivialType), classFileVersion, MethodAccessorFactory.Illegal.INSTANCE);
                        }
                        resolution = Resolution.ForRebasedConstructor.of(inDefinedShape, dynamicType.getTypeDescription());
                    } else {
                        resolution = Resolution.ForRebasedMethod.of(typeDescription, inDefinedShape, methodNameTransformer);
                    }
                    hashMap.put(inDefinedShape, resolution);
                }
            }
            if (dynamicType == null) {
                return new Default(hashMap, Collections.emptyList());
            }
            return new Default(hashMap, Collections.singletonList(dynamicType));
        }

        public Map<MethodDescription.SignatureToken, Resolution> asTokenMap() {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : this.resolutions.entrySet()) {
                hashMap.put(((MethodDescription.InDefinedShape) next.getKey()).asSignatureToken(), next.getValue());
            }
            return hashMap;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default defaultR = (Default) obj;
            return this.resolutions.equals(defaultR.resolutions) && this.dynamicTypes.equals(defaultR.dynamicTypes);
        }

        public List<DynamicType> getAuxiliaryTypes() {
            return this.dynamicTypes;
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.resolutions.hashCode()) * 31) + this.dynamicTypes.hashCode();
        }

        public Resolution resolve(MethodDescription.InDefinedShape inDefinedShape) {
            Resolution resolution = this.resolutions.get(inDefinedShape);
            if (resolution == null) {
                return new Resolution.Preserved(inDefinedShape);
            }
            return resolution;
        }
    }

    public enum Disabled implements MethodRebaseResolver {
        INSTANCE;

        public Map<MethodDescription.SignatureToken, Resolution> asTokenMap() {
            return Collections.emptyMap();
        }

        public List<DynamicType> getAuxiliaryTypes() {
            return Collections.emptyList();
        }

        public Resolution resolve(MethodDescription.InDefinedShape inDefinedShape) {
            return new Resolution.Preserved(inDefinedShape);
        }
    }

    public interface Resolution {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForRebasedConstructor implements Resolution {
            private final MethodDescription.InDefinedShape methodDescription;
            private final TypeDescription placeholderType;

            protected static class RebasedConstructor extends MethodDescription.InDefinedShape.AbstractBase {
                private final MethodDescription.InDefinedShape methodDescription;
                private final TypeDescription placeholderType;

                protected RebasedConstructor(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
                    this.methodDescription = inDefinedShape;
                    this.placeholderType = typeDescription;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                @AlwaysNull
                public AnnotationValue<?, ?> getDefaultValue() {
                    return AnnotationValue.UNDEFINED;
                }

                public TypeList.Generic getExceptionTypes() {
                    return this.methodDescription.getExceptionTypes().asRawTypes();
                }

                public String getInternalName() {
                    return MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                }

                public int getModifiers() {
                    return 4098;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) CompoundList.of(this.methodDescription.getParameters().asTypeList().asErasures(), this.placeholderType));
                }

                public TypeDescription.Generic getReturnType() {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE);
                }

                public TypeList.Generic getTypeVariables() {
                    return new TypeList.Generic.Empty();
                }

                public TypeDescription getDeclaringType() {
                    return this.methodDescription.getDeclaringType();
                }
            }

            protected ForRebasedConstructor(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
                this.methodDescription = inDefinedShape;
                this.placeholderType = typeDescription;
            }

            public static Resolution of(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
                return new ForRebasedConstructor(new RebasedConstructor(inDefinedShape, typeDescription), typeDescription);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForRebasedConstructor forRebasedConstructor = (ForRebasedConstructor) obj;
                return this.methodDescription.equals(forRebasedConstructor.methodDescription) && this.placeholderType.equals(forRebasedConstructor.placeholderType);
            }

            public TypeList getAppendedParameters() {
                return new TypeList.Explicit(this.placeholderType);
            }

            public MethodDescription.InDefinedShape getResolvedMethod() {
                return this.methodDescription;
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.placeholderType.hashCode();
            }

            public boolean isRebased() {
                return true;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForRebasedMethod implements Resolution {
            private final MethodDescription.InDefinedShape methodDescription;

            protected static class RebasedMethod extends MethodDescription.InDefinedShape.AbstractBase {
                private final TypeDescription instrumentedType;
                private final MethodDescription.InDefinedShape methodDescription;
                private final MethodNameTransformer methodNameTransformer;

                protected RebasedMethod(TypeDescription typeDescription, MethodDescription.InDefinedShape inDefinedShape, MethodNameTransformer methodNameTransformer2) {
                    this.instrumentedType = typeDescription;
                    this.methodDescription = inDefinedShape;
                    this.methodNameTransformer = methodNameTransformer2;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                @AlwaysNull
                public AnnotationValue<?, ?> getDefaultValue() {
                    return AnnotationValue.UNDEFINED;
                }

                public TypeList.Generic getExceptionTypes() {
                    return this.methodDescription.getExceptionTypes().asRawTypes();
                }

                public String getInternalName() {
                    return this.methodNameTransformer.transform(this.methodDescription);
                }

                public int getModifiers() {
                    int i10;
                    int i11;
                    int i12 = 0;
                    if (this.methodDescription.isStatic()) {
                        i10 = 8;
                    } else {
                        i10 = 0;
                    }
                    int i13 = i10 | Opcodes.ACC_SYNTHETIC;
                    if (this.methodDescription.isNative()) {
                        i12 = Height.CENTIMETRES_MAX;
                    }
                    int i14 = i13 | i12;
                    if (!this.instrumentedType.isInterface() || this.methodDescription.isNative()) {
                        i11 = 2;
                    } else {
                        i11 = 1;
                    }
                    return i14 | i11;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) this.methodDescription.getParameters().asTypeList().asRawTypes());
                }

                public TypeDescription.Generic getReturnType() {
                    return this.methodDescription.getReturnType().asRawType();
                }

                public TypeList.Generic getTypeVariables() {
                    return new TypeList.Generic.Empty();
                }

                public TypeDescription getDeclaringType() {
                    return this.methodDescription.getDeclaringType();
                }
            }

            protected ForRebasedMethod(MethodDescription.InDefinedShape inDefinedShape) {
                this.methodDescription = inDefinedShape;
            }

            public static Resolution of(TypeDescription typeDescription, MethodDescription.InDefinedShape inDefinedShape, MethodNameTransformer methodNameTransformer) {
                return new ForRebasedMethod(new RebasedMethod(typeDescription, inDefinedShape, methodNameTransformer));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((ForRebasedMethod) obj).methodDescription);
            }

            public TypeList getAppendedParameters() {
                return new TypeList.Empty();
            }

            public MethodDescription.InDefinedShape getResolvedMethod() {
                return this.methodDescription;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
            }

            public boolean isRebased() {
                return true;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Preserved implements Resolution {
            private final MethodDescription.InDefinedShape methodDescription;

            public Preserved(MethodDescription.InDefinedShape inDefinedShape) {
                this.methodDescription = inDefinedShape;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((Preserved) obj).methodDescription);
            }

            public TypeList getAppendedParameters() {
                throw new IllegalStateException("Cannot process additional parameters for non-rebased method: " + this.methodDescription);
            }

            public MethodDescription.InDefinedShape getResolvedMethod() {
                return this.methodDescription;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
            }

            public boolean isRebased() {
                return false;
            }
        }

        TypeList getAppendedParameters();

        MethodDescription.InDefinedShape getResolvedMethod();

        boolean isRebased();
    }

    Map<MethodDescription.SignatureToken, Resolution> asTokenMap();

    List<DynamicType> getAuxiliaryTypes();

    Resolution resolve(MethodDescription.InDefinedShape inDefinedShape);
}
