package net.bytebuddy.implementation.bytecode.assign.primitive;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.nullability.MaybeNull;

public enum PrimitiveWideningDelegate {
    BOOLEAN(r12, r13, r13, r13, r13, r13, r13, r13),
    BYTE(r3, r12, r5, r13, r12, r8, new WideningStackManipulation(134, r16.toIncreasingSize()), new WideningStackManipulation(Opcodes.I2L, r15.toIncreasingSize())),
    SHORT(r3, r4, r5, r13, r12, new WideningStackManipulation(Opcodes.I2L, r15.toIncreasingSize()), new WideningStackManipulation(134, r16.toIncreasingSize()), new WideningStackManipulation(135, r15.toIncreasingSize())),
    CHARACTER(r3, r4, r5, r12, r7, new WideningStackManipulation(Opcodes.I2L, r15.toIncreasingSize()), new WideningStackManipulation(134, r16.toIncreasingSize()), new WideningStackManipulation(135, r15.toIncreasingSize())),
    INTEGER(r3, r4, r5, r6, r7, new WideningStackManipulation(Opcodes.I2L, r15.toIncreasingSize()), new WideningStackManipulation(134, r16.toIncreasingSize()), new WideningStackManipulation(135, r15.toIncreasingSize())),
    LONG(r3, r4, r5, r6, r7, r12, new WideningStackManipulation(Opcodes.L2F, r15.toDecreasingSize()), new WideningStackManipulation(Opcodes.L2D, r16.toIncreasingSize())),
    FLOAT(r3, r4, r5, r6, r7, r8, r12, new WideningStackManipulation(Opcodes.F2D, r15.toIncreasingSize())),
    DOUBLE(r3, r4, r5, r6, r7, r8, r13, r12);
    
    private final StackManipulation toBooleanStackManipulation;
    private final StackManipulation toByteStackManipulation;
    private final StackManipulation toCharacterStackManipulation;
    private final StackManipulation toDoubleStackManipulation;
    private final StackManipulation toFloatStackManipulation;
    private final StackManipulation toIntegerStackManipulation;
    private final StackManipulation toLongStackManipulation;
    private final StackManipulation toShortStackManipulation;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class WideningStackManipulation extends StackManipulation.AbstractBase {
        private final int conversionOpcode;
        private final StackManipulation.Size size;

        protected WideningStackManipulation(int i10, StackManipulation.Size size2) {
            this.conversionOpcode = i10;
            this.size = size2;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitInsn(this.conversionOpcode);
            return this.size;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WideningStackManipulation wideningStackManipulation = (WideningStackManipulation) obj;
            return this.conversionOpcode == wideningStackManipulation.conversionOpcode && this.size.equals(wideningStackManipulation.size);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.conversionOpcode) * 31) + this.size.hashCode();
        }
    }

    private PrimitiveWideningDelegate(StackManipulation stackManipulation, StackManipulation stackManipulation2, StackManipulation stackManipulation3, StackManipulation stackManipulation4, StackManipulation stackManipulation5, StackManipulation stackManipulation6, StackManipulation stackManipulation7, StackManipulation stackManipulation8) {
        this.toBooleanStackManipulation = stackManipulation;
        this.toByteStackManipulation = stackManipulation2;
        this.toShortStackManipulation = stackManipulation3;
        this.toCharacterStackManipulation = stackManipulation4;
        this.toIntegerStackManipulation = stackManipulation5;
        this.toLongStackManipulation = stackManipulation6;
        this.toFloatStackManipulation = stackManipulation7;
        this.toDoubleStackManipulation = stackManipulation8;
    }

    public static PrimitiveWideningDelegate forPrimitive(TypeDefinition typeDefinition) {
        if (typeDefinition.represents(Boolean.TYPE)) {
            return BOOLEAN;
        }
        if (typeDefinition.represents(Byte.TYPE)) {
            return BYTE;
        }
        if (typeDefinition.represents(Short.TYPE)) {
            return SHORT;
        }
        if (typeDefinition.represents(Character.TYPE)) {
            return CHARACTER;
        }
        if (typeDefinition.represents(Integer.TYPE)) {
            return INTEGER;
        }
        if (typeDefinition.represents(Long.TYPE)) {
            return LONG;
        }
        if (typeDefinition.represents(Float.TYPE)) {
            return FLOAT;
        }
        if (typeDefinition.represents(Double.TYPE)) {
            return DOUBLE;
        }
        throw new IllegalArgumentException("Not a primitive, non-void type: " + typeDefinition);
    }

    public StackManipulation widenTo(TypeDefinition typeDefinition) {
        if (typeDefinition.represents(Boolean.TYPE)) {
            return this.toBooleanStackManipulation;
        }
        if (typeDefinition.represents(Byte.TYPE)) {
            return this.toByteStackManipulation;
        }
        if (typeDefinition.represents(Short.TYPE)) {
            return this.toShortStackManipulation;
        }
        if (typeDefinition.represents(Character.TYPE)) {
            return this.toCharacterStackManipulation;
        }
        if (typeDefinition.represents(Integer.TYPE)) {
            return this.toIntegerStackManipulation;
        }
        if (typeDefinition.represents(Long.TYPE)) {
            return this.toLongStackManipulation;
        }
        if (typeDefinition.represents(Float.TYPE)) {
            return this.toFloatStackManipulation;
        }
        if (typeDefinition.represents(Double.TYPE)) {
            return this.toDoubleStackManipulation;
        }
        throw new IllegalArgumentException("Not a primitive non-void type: " + typeDefinition);
    }
}
