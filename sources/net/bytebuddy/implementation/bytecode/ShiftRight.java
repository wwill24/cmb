package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum ShiftRight implements StackManipulation {
    INTEGER(122, StackSize.SINGLE, Unsigned.INTEGER),
    LONG(123, StackSize.DOUBLE, Unsigned.LONG);
    
    private final int opcode;
    private final StackSize stackSize;
    private final StackManipulation unsigned;

    protected enum Unsigned implements StackManipulation {
        INTEGER(124, StackSize.SINGLE),
        LONG(125, StackSize.DOUBLE);
        
        private final int opcode;
        private final StackSize stackSize;

        private Unsigned(int i10, StackSize stackSize2) {
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

    private ShiftRight(int i10, StackSize stackSize2, StackManipulation stackManipulation) {
        this.opcode = i10;
        this.stackSize = stackSize2;
        this.unsigned = stackManipulation;
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return this.stackSize.toDecreasingSize();
    }

    public boolean isValid() {
        return true;
    }

    public StackManipulation toUnsigned() {
        return this.unsigned;
    }
}
