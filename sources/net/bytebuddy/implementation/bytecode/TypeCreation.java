package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class TypeCreation extends StackManipulation.AbstractBase {
    private final TypeDescription typeDescription;

    protected TypeCreation(TypeDescription typeDescription2) {
        this.typeDescription = typeDescription2;
    }

    public static StackManipulation of(TypeDescription typeDescription2) {
        if (!typeDescription2.isArray() && !typeDescription2.isPrimitive() && !typeDescription2.isAbstract()) {
            return new TypeCreation(typeDescription2);
        }
        throw new IllegalArgumentException(typeDescription2 + " is not instantiable");
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitTypeInsn(Opcodes.NEW, this.typeDescription.getInternalName());
        return new StackManipulation.Size(1, 1);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((TypeCreation) obj).typeDescription);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
    }
}
