package net.bytebuddy.utility;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface ConstantValue {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements ConstantValue {
        private final StackManipulation stackManipulation;
        private final TypeDescription typeDescription;

        protected Simple(StackManipulation stackManipulation2, TypeDescription typeDescription2) {
            this.stackManipulation = stackManipulation2;
            this.typeDescription = typeDescription2;
        }

        public static ConstantValue wrap(Object obj) {
            ConstantValue wrapOrNull = wrapOrNull(obj);
            if (wrapOrNull != null) {
                return wrapOrNull;
            }
            throw new IllegalArgumentException("Not a constant value: " + obj);
        }

        @MaybeNull
        public static ConstantValue wrapOrNull(Object obj) {
            if (obj instanceof ConstantValue) {
                return (ConstantValue) obj;
            }
            if (obj instanceof TypeDescription) {
                TypeDescription typeDescription2 = (TypeDescription) obj;
                if (typeDescription2.isPrimitive()) {
                    return new Simple(ClassConstant.of(typeDescription2), TypeDescription.ForLoadedType.of(Class.class));
                }
                return JavaConstant.Simple.of(typeDescription2);
            } else if (obj instanceof EnumerationDescription) {
                EnumerationDescription enumerationDescription = (EnumerationDescription) obj;
                return new Simple(FieldAccess.forEnumeration(enumerationDescription), enumerationDescription.getEnumerationType());
            } else if (obj instanceof Boolean) {
                return new Simple(IntegerConstant.forValue(((Boolean) obj).booleanValue()), TypeDescription.ForLoadedType.of(Boolean.TYPE));
            } else {
                if (obj instanceof Byte) {
                    return new Simple(IntegerConstant.forValue((int) ((Byte) obj).byteValue()), TypeDescription.ForLoadedType.of(Byte.TYPE));
                }
                if (obj instanceof Short) {
                    return new Simple(IntegerConstant.forValue((int) ((Short) obj).shortValue()), TypeDescription.ForLoadedType.of(Short.TYPE));
                }
                if (obj instanceof Character) {
                    return new Simple(IntegerConstant.forValue((int) ((Character) obj).charValue()), TypeDescription.ForLoadedType.of(Character.TYPE));
                }
                if (obj instanceof Class) {
                    Class cls = (Class) obj;
                    if (cls.isPrimitive()) {
                        return new Simple(ClassConstant.of(TypeDescription.ForLoadedType.of(cls)), TypeDescription.ForLoadedType.of(Class.class));
                    }
                    return JavaConstant.Simple.of(TypeDescription.ForLoadedType.of(cls));
                } else if (!(obj instanceof Enum)) {
                    return JavaConstant.Simple.ofLoadedOrNull(obj);
                } else {
                    Enum enumR = (Enum) obj;
                    return new Simple(FieldAccess.forEnumeration(new EnumerationDescription.ForLoadedEnumeration(enumR)), TypeDescription.ForLoadedType.of(enumR.getDeclaringClass()));
                }
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Simple simple = (Simple) obj;
            return this.stackManipulation.equals(simple.stackManipulation) && this.typeDescription.equals(simple.typeDescription);
        }

        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDescription.hashCode();
        }

        public StackManipulation toStackManipulation() {
            return this.stackManipulation;
        }
    }

    TypeDescription getTypeDescription();

    StackManipulation toStackManipulation();
}
