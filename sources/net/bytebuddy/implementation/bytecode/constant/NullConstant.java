package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum NullConstant implements StackManipulation {
    INSTANCE;

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(1);
        return new StackManipulation.Size(1, 1);
    }

    public boolean isValid() {
        return true;
    }
}
