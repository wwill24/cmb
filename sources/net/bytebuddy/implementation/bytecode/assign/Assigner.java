package net.bytebuddy.implementation.bytecode.assign;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveTypeAwareAssigner;
import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;
import net.bytebuddy.implementation.bytecode.assign.reference.GenericTypeAwareAssigner;
import net.bytebuddy.implementation.bytecode.assign.reference.ReferenceTypeAwareAssigner;

@SuppressFBWarnings(justification = "Safe initialization is implied.", value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"})
public interface Assigner {
    public static final Assigner DEFAULT = new VoidAwareAssigner(new PrimitiveTypeAwareAssigner(ReferenceTypeAwareAssigner.INSTANCE));
    public static final Assigner GENERICS_AWARE = new VoidAwareAssigner(new PrimitiveTypeAwareAssigner(GenericTypeAwareAssigner.INSTANCE));

    public enum EqualTypesOnly implements Assigner {
        GENERIC {
            public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Typing typing) {
                return generic.equals(generic2) ? StackManipulation.Trivial.INSTANCE : StackManipulation.Illegal.INSTANCE;
            }
        },
        ERASURE {
            public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Typing typing) {
                return generic.asErasure().equals(generic2.asErasure()) ? StackManipulation.Trivial.INSTANCE : StackManipulation.Illegal.INSTANCE;
            }
        }
    }

    public enum Refusing implements Assigner {
        INSTANCE;

        public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Typing typing) {
            return StackManipulation.Illegal.INSTANCE;
        }
    }

    public enum Typing {
        STATIC(false),
        DYNAMIC(true);
        
        private final boolean dynamic;

        private Typing(boolean z10) {
            this.dynamic = z10;
        }

        public static Typing of(boolean z10) {
            return z10 ? DYNAMIC : STATIC;
        }

        public boolean isDynamic() {
            return this.dynamic;
        }
    }

    StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Typing typing);
}
