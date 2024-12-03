package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum Subtraction implements StackManipulation {
    INTEGER(100, r1),
    LONG(101, r4),
    FLOAT(102, r1),
    DOUBLE(103, r4);
    
    private final int opcode;
    private final StackSize stackSize;

    private Subtraction(int i10, StackSize stackSize2) {
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
