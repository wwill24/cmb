package net.bytebuddy.implementation.bytecode.assign.primitive;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class VoidAwareAssigner implements Assigner {
    private final Assigner chained;

    public VoidAwareAssigner(Assigner assigner) {
        this.chained = assigner;
    }

    public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing) {
        if (generic.represents(Void.TYPE) && generic2.represents(Void.TYPE)) {
            return StackManipulation.Trivial.INSTANCE;
        }
        if (generic.represents(Void.TYPE)) {
            if (typing.isDynamic()) {
                return DefaultValue.of(generic2);
            }
            return StackManipulation.Illegal.INSTANCE;
        } else if (generic2.represents(Void.TYPE)) {
            return Removal.of(generic);
        } else {
            return this.chained.assign(generic, generic2, typing);
        }
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.chained.equals(((VoidAwareAssigner) obj).chained);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.chained.hashCode();
    }
}
