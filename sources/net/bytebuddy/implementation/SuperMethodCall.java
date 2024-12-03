package net.bytebuddy.implementation;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

public enum SuperMethodCall implements Implementation.Composable {
    INSTANCE;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class Appender implements ByteCodeAppender {
        private final Implementation.Target implementationTarget;
        private final TerminationHandler terminationHandler;

        protected enum TerminationHandler {
            RETURNING {
                /* access modifiers changed from: protected */
                public StackManipulation of(MethodDescription methodDescription) {
                    return MethodReturn.of(methodDescription.getReturnType());
                }
            },
            DROPPING {
                /* access modifiers changed from: protected */
                public StackManipulation of(MethodDescription methodDescription) {
                    return Removal.of(methodDescription.getReturnType());
                }
            };

            /* access modifiers changed from: protected */
            public abstract StackManipulation of(MethodDescription methodDescription);
        }

        protected Appender(Implementation.Target target, TerminationHandler terminationHandler2) {
            this.implementationTarget = target;
            this.terminationHandler = terminationHandler2;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Implementation.SpecialMethodInvocation withCheckedCompatibilityTo = this.implementationTarget.invokeDominant(methodDescription.asSignatureToken()).withCheckedCompatibilityTo(methodDescription.asTypeToken());
            if (withCheckedCompatibilityTo.isValid()) {
                return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), withCheckedCompatibilityTo, this.terminationHandler.of(methodDescription)).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            }
            throw new IllegalStateException("Cannot call super (or default) method for " + methodDescription);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.terminationHandler.equals(appender.terminationHandler) && this.implementationTarget.equals(appender.implementationTarget);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.implementationTarget.hashCode()) * 31) + this.terminationHandler.hashCode();
        }
    }

    protected enum WithoutReturn implements Implementation {
        INSTANCE;

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target, Appender.TerminationHandler.DROPPING);
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }
    }

    public Implementation andThen(Implementation implementation) {
        return new Implementation.Compound(WithoutReturn.INSTANCE, implementation);
    }

    public ByteCodeAppender appender(Implementation.Target target) {
        return new Appender(target, Appender.TerminationHandler.RETURNING);
    }

    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    public Implementation.Composable andThen(Implementation.Composable composable) {
        return new Implementation.Compound.Composable((Implementation) WithoutReturn.INSTANCE, composable);
    }
}
