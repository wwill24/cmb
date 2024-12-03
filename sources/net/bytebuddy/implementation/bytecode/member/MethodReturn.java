package net.bytebuddy.implementation.bytecode.member;

import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;

public enum MethodReturn implements StackManipulation {
    INTEGER(Opcodes.IRETURN, r1),
    DOUBLE(Opcodes.DRETURN, r4),
    FLOAT(Opcodes.FRETURN, r1),
    LONG(Opcodes.LRETURN, r4),
    VOID(Opcodes.RETURN, StackSize.ZERO),
    REFERENCE(Opcodes.ARETURN, r1);
    
    private final int returnOpcode;
    private final StackManipulation.Size size;

    private MethodReturn(int i10, StackSize stackSize) {
        this.returnOpcode = i10;
        this.size = stackSize.toDecreasingSize();
    }

    public static StackManipulation of(TypeDefinition typeDefinition) {
        if (!typeDefinition.isPrimitive()) {
            return REFERENCE;
        }
        if (typeDefinition.represents(Long.TYPE)) {
            return LONG;
        }
        if (typeDefinition.represents(Double.TYPE)) {
            return DOUBLE;
        }
        if (typeDefinition.represents(Float.TYPE)) {
            return FLOAT;
        }
        if (typeDefinition.represents(Void.TYPE)) {
            return VOID;
        }
        return INTEGER;
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.returnOpcode);
        return this.size;
    }

    public boolean isValid() {
        return true;
    }
}
