package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum ShiftLeft implements StackManipulation {
    INTEGER(120, StackSize.SINGLE),
    LONG(121, StackSize.DOUBLE);
    
    private final int opcode;
    private final StackSize stackSize;

    private ShiftLeft(int i10, StackSize stackSize2) {
        this.opcode = i10;
        this.stackSize = stackSize2;
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return this.stackSize.toDecreasingSize();
    }

    public boolean isValid() {
        return true;
    }
}
