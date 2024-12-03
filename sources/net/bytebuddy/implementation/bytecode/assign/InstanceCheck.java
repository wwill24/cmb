package net.bytebuddy.implementation.bytecode.assign;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class InstanceCheck extends StackManipulation.AbstractBase {
    private final TypeDescription typeDescription;

    protected InstanceCheck(TypeDescription typeDescription2) {
        this.typeDescription = typeDescription2;
    }

    public static StackManipulation of(TypeDescription typeDescription2) {
        if (!typeDescription2.isPrimitive()) {
            return new InstanceCheck(typeDescription2);
        }
        throw new IllegalArgumentException("Cannot check an instance against a primitive type: " + typeDescription2);
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, this.typeDescription.getInternalName());
        return StackManipulation.Size.ZERO;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((InstanceCheck) obj).typeDescription);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
    }
}
