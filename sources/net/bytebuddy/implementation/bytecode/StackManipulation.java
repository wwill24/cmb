package net.bytebuddy.implementation.bytecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface StackManipulation {

    public static abstract class AbstractBase implements StackManipulation {
        public boolean isValid() {
            return true;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements StackManipulation {
        private final List<StackManipulation> stackManipulations;

        public Compound(StackManipulation... stackManipulationArr) {
            this((List<? extends StackManipulation>) Arrays.asList(stackManipulationArr));
        }

        public Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            Size size = Size.ZERO;
            for (StackManipulation apply : this.stackManipulations) {
                size = size.aggregate(apply.apply(methodVisitor, context));
            }
            return size;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.stackManipulations.equals(((Compound) obj).stackManipulations);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.stackManipulations.hashCode();
        }

        public boolean isValid() {
            for (StackManipulation isValid : this.stackManipulations) {
                if (!isValid.isValid()) {
                    return false;
                }
            }
            return true;
        }

        public Compound(List<? extends StackManipulation> list) {
            this.stackManipulations = new ArrayList();
            for (StackManipulation stackManipulation : list) {
                if (stackManipulation instanceof Compound) {
                    this.stackManipulations.addAll(((Compound) stackManipulation).stackManipulations);
                } else if (!(stackManipulation instanceof Trivial)) {
                    this.stackManipulations.add(stackManipulation);
                }
            }
        }
    }

    public enum Illegal implements StackManipulation {
        INSTANCE;

        public Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            throw new IllegalStateException("An illegal stack manipulation must not be applied");
        }

        public boolean isValid() {
            return false;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple extends AbstractBase {
        private final Dispatcher dispatcher;

        public interface Dispatcher {
            Size apply(MethodVisitor methodVisitor, Implementation.Context context);
        }

        public Simple(Dispatcher dispatcher2) {
            this.dispatcher = dispatcher2;
        }

        public Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return this.dispatcher.apply(methodVisitor, context);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.dispatcher.equals(((Simple) obj).dispatcher);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.dispatcher.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Size {
        public static final Size ZERO = new Size(0, 0);
        private final int maximalSize;
        private final int sizeImpact;

        public Size(int i10, int i11) {
            this.sizeImpact = i10;
            this.maximalSize = i11;
        }

        public Size aggregate(Size size) {
            return aggregate(size.sizeImpact, size.maximalSize);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Size size = (Size) obj;
            return this.sizeImpact == size.sizeImpact && this.maximalSize == size.maximalSize;
        }

        public int getMaximalSize() {
            return this.maximalSize;
        }

        public int getSizeImpact() {
            return this.sizeImpact;
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.sizeImpact) * 31) + this.maximalSize;
        }

        private Size aggregate(int i10, int i11) {
            int i12 = this.sizeImpact;
            return new Size(i10 + i12, Math.max(this.maximalSize, i12 + i11));
        }
    }

    public enum Trivial implements StackManipulation {
        INSTANCE;

        public Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return StackSize.ZERO.toIncreasingSize();
        }

        public boolean isValid() {
            return true;
        }
    }

    Size apply(MethodVisitor methodVisitor, Implementation.Context context);

    boolean isValid();
}
