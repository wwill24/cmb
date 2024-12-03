package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

public enum FloatConstant implements StackManipulation {
    ZERO(11),
    ONE(12),
    TWO(13);
    
    /* access modifiers changed from: private */
    public static final StackManipulation.Size SIZE = null;
    private final int opcode;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ConstantPool extends StackManipulation.AbstractBase {
        private final float value;

        protected ConstantPool(float f10) {
            this.value = f10;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitLdcInsn(Float.valueOf(this.value));
            return FloatConstant.SIZE;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.compare(this.value, ((ConstantPool) obj).value) == 0;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + Float.floatToIntBits(this.value);
        }
    }

    static {
        SIZE = StackSize.SINGLE.toIncreasingSize();
    }

    private FloatConstant(int i10) {
        this.opcode = i10;
    }

    public static StackManipulation forValue(float f10) {
        if (f10 == 0.0f) {
            return ZERO;
        }
        if (f10 == 1.0f) {
            return ONE;
        }
        if (f10 == 2.0f) {
            return TWO;
        }
        return new ConstantPool(f10);
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return SIZE;
    }

    public boolean isValid() {
        return true;
    }
}
