package net.bytebuddy.implementation.bytecode.collection;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum ArrayLength implements StackManipulation {
    INSTANCE;

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(190);
        return StackManipulation.Size.ZERO;
    }

    public boolean isValid() {
        return true;
    }
}
