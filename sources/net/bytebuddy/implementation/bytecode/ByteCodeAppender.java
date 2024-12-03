package net.bytebuddy.implementation.bytecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface ByteCodeAppender {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements ByteCodeAppender {
        private final List<ByteCodeAppender> byteCodeAppenders;

        public Compound(ByteCodeAppender... byteCodeAppenderArr) {
            this((List<? extends ByteCodeAppender>) Arrays.asList(byteCodeAppenderArr));
        }

        public Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Size size = new Size(0, methodDescription.getStackSize());
            for (ByteCodeAppender apply : this.byteCodeAppenders) {
                size = size.merge(apply.apply(methodVisitor, context, methodDescription));
            }
            return size;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.byteCodeAppenders.equals(((Compound) obj).byteCodeAppenders);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.byteCodeAppenders.hashCode();
        }

        public Compound(List<? extends ByteCodeAppender> list) {
            this.byteCodeAppenders = new ArrayList();
            for (ByteCodeAppender byteCodeAppender : list) {
                if (byteCodeAppender instanceof Compound) {
                    this.byteCodeAppenders.addAll(((Compound) byteCodeAppender).byteCodeAppenders);
                } else {
                    this.byteCodeAppenders.add(byteCodeAppender);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements ByteCodeAppender {
        private final StackManipulation stackManipulation;

        public Simple(StackManipulation... stackManipulationArr) {
            this((List<? extends StackManipulation>) Arrays.asList(stackManipulationArr));
        }

        public Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            return new Size(this.stackManipulation.apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.stackManipulation.equals(((Simple) obj).stackManipulation);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.stackManipulation.hashCode();
        }

        public Simple(List<? extends StackManipulation> list) {
            this.stackManipulation = new StackManipulation.Compound(list);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Size {
        public static final Size ZERO = new Size(0, 0);
        private final int localVariableSize;
        private final int operandStackSize;

        public Size(int i10, int i11) {
            this.operandStackSize = i10;
            this.localVariableSize = i11;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Size size = (Size) obj;
            return this.operandStackSize == size.operandStackSize && this.localVariableSize == size.localVariableSize;
        }

        public int getLocalVariableSize() {
            return this.localVariableSize;
        }

        public int getOperandStackSize() {
            return this.operandStackSize;
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.operandStackSize) * 31) + this.localVariableSize;
        }

        public Size merge(Size size) {
            return new Size(Math.max(this.operandStackSize, size.operandStackSize), Math.max(this.localVariableSize, size.localVariableSize));
        }
    }

    Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription);
}
