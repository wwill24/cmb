package net.bytebuddy.description;

import net.bytebuddy.description.modifier.EnumerationState;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.FieldPersistence;
import net.bytebuddy.description.modifier.MethodManifestation;
import net.bytebuddy.description.modifier.MethodStrictness;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.ParameterManifestation;
import net.bytebuddy.description.modifier.ProvisioningState;
import net.bytebuddy.description.modifier.SynchronizationState;
import net.bytebuddy.description.modifier.SyntheticState;
import net.bytebuddy.description.modifier.TypeManifestation;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.jar.asm.Opcodes;

public interface ModifierReviewable {
    public static final int EMPTY_MASK = 0;

    public static abstract class AbstractBase implements ForTypeDefinition, ForFieldDescription, ForMethodDescription, ForParameterDescription {
        private boolean matchesMask(int i10) {
            return (getModifiers() & i10) == i10;
        }

        public EnumerationState getEnumerationState() {
            return isEnum() ? EnumerationState.ENUMERATION : EnumerationState.PLAIN;
        }

        public FieldManifestation getFieldManifestation() {
            int modifiers = getModifiers();
            int i10 = modifiers & 80;
            if (i10 == 0) {
                return FieldManifestation.PLAIN;
            }
            if (i10 == 16) {
                return FieldManifestation.FINAL;
            }
            if (i10 == 64) {
                return FieldManifestation.VOLATILE;
            }
            throw new IllegalStateException("Unexpected modifiers: " + modifiers);
        }

        public FieldPersistence getFieldPersistence() {
            int modifiers = getModifiers();
            int i10 = modifiers & 128;
            if (i10 == 0) {
                return FieldPersistence.PLAIN;
            }
            if (i10 == 128) {
                return FieldPersistence.TRANSIENT;
            }
            throw new IllegalStateException("Unexpected modifiers: " + modifiers);
        }

        public MethodManifestation getMethodManifestation() {
            int modifiers = getModifiers();
            int i10 = modifiers & 1360;
            if (i10 == 0) {
                return MethodManifestation.PLAIN;
            }
            if (i10 == 16) {
                return MethodManifestation.FINAL;
            }
            if (i10 == 64) {
                return MethodManifestation.BRIDGE;
            }
            if (i10 == 80) {
                return MethodManifestation.FINAL_BRIDGE;
            }
            if (i10 == 256) {
                return MethodManifestation.NATIVE;
            }
            if (i10 == 272) {
                return MethodManifestation.FINAL_NATIVE;
            }
            if (i10 == 1024) {
                return MethodManifestation.ABSTRACT;
            }
            throw new IllegalStateException("Unexpected modifiers: " + modifiers);
        }

        public MethodStrictness getMethodStrictness() {
            return isStrict() ? MethodStrictness.STRICT : MethodStrictness.PLAIN;
        }

        public Ownership getOwnership() {
            return isStatic() ? Ownership.STATIC : Ownership.MEMBER;
        }

        public ParameterManifestation getParameterManifestation() {
            return isFinal() ? ParameterManifestation.FINAL : ParameterManifestation.PLAIN;
        }

        public ProvisioningState getProvisioningState() {
            return isMandated() ? ProvisioningState.MANDATED : ProvisioningState.PLAIN;
        }

        public SynchronizationState getSynchronizationState() {
            return isSynchronized() ? SynchronizationState.SYNCHRONIZED : SynchronizationState.PLAIN;
        }

        public SyntheticState getSyntheticState() {
            return isSynthetic() ? SyntheticState.SYNTHETIC : SyntheticState.PLAIN;
        }

        public TypeManifestation getTypeManifestation() {
            int modifiers = getModifiers();
            int i10 = modifiers & 9744;
            if (i10 == 0) {
                return TypeManifestation.PLAIN;
            }
            if (i10 == 16) {
                return TypeManifestation.FINAL;
            }
            if (i10 == 1024) {
                return TypeManifestation.ABSTRACT;
            }
            if (i10 == 1536) {
                return TypeManifestation.INTERFACE;
            }
            if (i10 == 9728) {
                return TypeManifestation.ANNOTATION;
            }
            throw new IllegalStateException("Unexpected modifiers: " + modifiers);
        }

        public Visibility getVisibility() {
            int modifiers = getModifiers();
            int i10 = modifiers & 7;
            if (i10 == 0) {
                return Visibility.PACKAGE_PRIVATE;
            }
            if (i10 == 1) {
                return Visibility.PUBLIC;
            }
            if (i10 == 2) {
                return Visibility.PRIVATE;
            }
            if (i10 == 4) {
                return Visibility.PROTECTED;
            }
            throw new IllegalStateException("Unexpected modifiers: " + modifiers);
        }

        public boolean isAbstract() {
            return matchesMask(1024);
        }

        public boolean isAnnotation() {
            return matchesMask(8192);
        }

        public boolean isBridge() {
            return matchesMask(64);
        }

        public boolean isDeprecated() {
            return matchesMask(Opcodes.ACC_DEPRECATED);
        }

        public boolean isEnum() {
            return matchesMask(Opcodes.ACC_ENUM);
        }

        public boolean isFinal() {
            return matchesMask(16);
        }

        public boolean isInterface() {
            return matchesMask(512);
        }

        public boolean isMandated() {
            return matchesMask(32768);
        }

        public boolean isNative() {
            return matchesMask(256);
        }

        public boolean isPackagePrivate() {
            return !isPublic() && !isProtected() && !isPrivate();
        }

        public boolean isPrivate() {
            return matchesMask(2);
        }

        public boolean isProtected() {
            return matchesMask(4);
        }

        public boolean isPublic() {
            return matchesMask(1);
        }

        public boolean isStatic() {
            return matchesMask(8);
        }

        public boolean isStrict() {
            return matchesMask(2048);
        }

        public boolean isSynchronized() {
            return matchesMask(32);
        }

        public boolean isSynthetic() {
            return matchesMask(Opcodes.ACC_SYNTHETIC);
        }

        public boolean isTransient() {
            return matchesMask(128);
        }

        public boolean isVarArgs() {
            return matchesMask(128);
        }

        public boolean isVolatile() {
            return matchesMask(64);
        }
    }

    public interface ForFieldDescription extends OfEnumeration {
        FieldManifestation getFieldManifestation();

        FieldPersistence getFieldPersistence();

        boolean isTransient();

        boolean isVolatile();
    }

    public interface ForMethodDescription extends OfAbstraction {
        MethodManifestation getMethodManifestation();

        MethodStrictness getMethodStrictness();

        SynchronizationState getSynchronizationState();

        boolean isBridge();

        boolean isNative();

        boolean isStrict();

        boolean isSynchronized();

        boolean isVarArgs();
    }

    public interface ForParameterDescription extends ModifierReviewable {
        ParameterManifestation getParameterManifestation();

        ProvisioningState getProvisioningState();

        boolean isMandated();
    }

    public interface ForTypeDefinition extends OfAbstraction, OfEnumeration {
        TypeManifestation getTypeManifestation();

        boolean isAnnotation();

        boolean isInterface();
    }

    public interface OfAbstraction extends OfByteCodeElement {
        boolean isAbstract();
    }

    public interface OfByteCodeElement extends ModifierReviewable {
        Ownership getOwnership();

        Visibility getVisibility();

        boolean isDeprecated();

        boolean isPackagePrivate();

        boolean isPrivate();

        boolean isProtected();

        boolean isPublic();

        boolean isStatic();
    }

    public interface OfEnumeration extends OfByteCodeElement {
        EnumerationState getEnumerationState();

        boolean isEnum();
    }

    int getModifiers();

    SyntheticState getSyntheticState();

    boolean isFinal();

    boolean isSynthetic();
}
