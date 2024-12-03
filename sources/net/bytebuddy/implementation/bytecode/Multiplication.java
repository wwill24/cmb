package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum Multiplication implements StackManipulation {
    INTEGER(104, r1),
    LONG(105, r4),
    FLOAT(106, r1),
    DOUBLE(107, r4);
    
    private final int opcode;
    private final StackSize stackSize;

    private Multiplication(int i10, StackSize stackSize2) {
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
