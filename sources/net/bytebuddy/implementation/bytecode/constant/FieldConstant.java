package net.bytebuddy.implementation.bytecode.constant;

import java.lang.reflect.Field;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

public class FieldConstant extends StackManipulation.AbstractBase {
    private final FieldDescription.InDefinedShape fieldDescription;

    protected static class Cached implements StackManipulation {
        private final StackManipulation fieldConstant;

        public Cached(StackManipulation stackManipulation) {
            this.fieldConstant = stackManipulation;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return FieldAccess.forField(context.cache(this.fieldConstant, TypeDescription.ForLoadedType.of(Field.class))).read().apply(methodVisitor, context);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.fieldConstant.equals(((Cached) obj).fieldConstant);
        }

        public int hashCode() {
            return this.fieldConstant.hashCode();
        }

        public boolean isValid() {
            return this.fieldConstant.isValid();
        }
    }

    public FieldConstant(FieldDescription.InDefinedShape inDefinedShape) {
        this.fieldDescription = inDefinedShape;
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        try {
            return new StackManipulation.Compound(ClassConstant.of(this.fieldDescription.getDeclaringType()), new TextConstant(this.fieldDescription.getInternalName()), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(Class.class.getMethod("getDeclaredField", new Class[]{String.class})))).apply(methodVisitor, context);
        } catch (NoSuchMethodException e10) {
            throw new IllegalStateException("Cannot locate Class::getDeclaredField", e10);
        }
    }

    public StackManipulation cached() {
        return new Cached(this);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.fieldDescription.equals(((FieldConstant) obj).fieldDescription);
    }

    public int hashCode() {
        return this.fieldDescription.hashCode();
    }
}
