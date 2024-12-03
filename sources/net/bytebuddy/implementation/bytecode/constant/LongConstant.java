package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

public enum LongConstant implements StackManipulation {
    ZERO(9),
    ONE(10);
    
    /* access modifiers changed from: private */
    public static final StackManipulation.Size SIZE = null;
    private final int opcode;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ConstantPool extends StackManipulation.AbstractBase {
        private final long value;

        protected ConstantPool(long j10) {
            this.value = j10;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitLdcInsn(Long.valueOf(this.value));
            return LongConstant.SIZE;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((ConstantPool) obj).value;
        }

        public int hashCode() {
            long j10 = this.value;
            return (getClass().hashCode() * 31) + ((int) (j10 ^ (j10 >>> 32)));
        }
    }

    static {
        SIZE = StackSize.DOUBLE.toIncreasingSize();
    }

    private LongConstant(int i10) {
        this.opcode = i10;
    }

    public static StackManipulation forValue(long j10) {
        if (j10 == 0) {
            return ZERO;
        }
        if (j10 == 1) {
            return ONE;
        }
        return new ConstantPool(j10);
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return SIZE;
    }

    public boolean isValid() {
        return true;
    }
}
