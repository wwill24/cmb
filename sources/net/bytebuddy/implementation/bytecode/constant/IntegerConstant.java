package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

public enum IntegerConstant implements StackManipulation {
    MINUS_ONE(2),
    ZERO(3),
    ONE(4),
    TWO(5),
    THREE(6),
    FOUR(7),
    FIVE(8);
    
    /* access modifiers changed from: private */
    public static final StackManipulation.Size SIZE = null;
    private final int opcode;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ConstantPool extends StackManipulation.AbstractBase {
        private final int value;

        protected ConstantPool(int i10) {
            this.value = i10;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitLdcInsn(Integer.valueOf(this.value));
            return IntegerConstant.SIZE;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((ConstantPool) obj).value;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.value;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class SingleBytePush extends StackManipulation.AbstractBase {
        private final byte value;

        protected SingleBytePush(byte b10) {
            this.value = b10;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitIntInsn(16, this.value);
            return IntegerConstant.SIZE;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((SingleBytePush) obj).value;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.value;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class TwoBytePush extends StackManipulation.AbstractBase {
        private final short value;

        protected TwoBytePush(short s10) {
            this.value = s10;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitIntInsn(17, this.value);
            return IntegerConstant.SIZE;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((TwoBytePush) obj).value;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.value;
        }
    }

    static {
        SIZE = StackSize.SINGLE.toIncreasingSize();
    }

    private IntegerConstant(int i10) {
        this.opcode = i10;
    }

    public static StackManipulation forValue(boolean z10) {
        return z10 ? ONE : ZERO;
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return SIZE;
    }

    public boolean isValid() {
        return true;
    }

    public static StackManipulation forValue(int i10) {
        switch (i10) {
            case -1:
                return MINUS_ONE;
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            default:
                if (i10 >= -128 && i10 <= 127) {
                    return new SingleBytePush((byte) i10);
                }
                if (i10 < -32768 || i10 > 32767) {
                    return new ConstantPool(i10);
                }
                return new TwoBytePush((short) i10);
        }
    }
}
