package net.bytebuddy.implementation.bytecode.member;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

public enum FieldAccess {
    STATIC(Opcodes.PUTSTATIC, Opcodes.GETSTATIC, StackSize.ZERO),
    INSTANCE(Opcodes.PUTFIELD, Opcodes.GETFIELD, StackSize.SINGLE);
    
    /* access modifiers changed from: private */
    public final int getterOpcode;
    /* access modifiers changed from: private */
    public final int putterOpcode;
    /* access modifiers changed from: private */
    public final int targetSizeChange;

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    protected class AccessDispatcher implements Defined {
        /* access modifiers changed from: private */
        public final FieldDescription.InDefinedShape fieldDescription;

        private abstract class AbstractFieldInstruction extends StackManipulation.AbstractBase {
            private AbstractFieldInstruction() {
            }

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitFieldInsn(getOpcode(), AccessDispatcher.this.fieldDescription.getDeclaringType().getInternalName(), AccessDispatcher.this.fieldDescription.getInternalName(), AccessDispatcher.this.fieldDescription.getDescriptor());
                return resolveSize(AccessDispatcher.this.fieldDescription.getType().getStackSize());
            }

            /* access modifiers changed from: protected */
            public abstract int getOpcode();

            /* access modifiers changed from: protected */
            public abstract StackManipulation.Size resolveSize(StackSize stackSize);
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        protected class FieldGetInstruction extends AbstractFieldInstruction {
            protected FieldGetInstruction() {
                super();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && AccessDispatcher.this.equals(AccessDispatcher.this);
            }

            /* access modifiers changed from: protected */
            public int getOpcode() {
                return FieldAccess.this.getterOpcode;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + AccessDispatcher.this.hashCode();
            }

            /* access modifiers changed from: protected */
            public StackManipulation.Size resolveSize(StackSize stackSize) {
                int size = stackSize.getSize() - FieldAccess.this.targetSizeChange;
                return new StackManipulation.Size(size, size);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        protected class FieldPutInstruction extends AbstractFieldInstruction {
            protected FieldPutInstruction() {
                super();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && AccessDispatcher.this.equals(AccessDispatcher.this);
            }

            /* access modifiers changed from: protected */
            public int getOpcode() {
                return FieldAccess.this.putterOpcode;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + AccessDispatcher.this.hashCode();
            }

            /* access modifiers changed from: protected */
            public StackManipulation.Size resolveSize(StackSize stackSize) {
                return new StackManipulation.Size((stackSize.getSize() + FieldAccess.this.targetSizeChange) * -1, 0);
            }
        }

        protected AccessDispatcher(FieldDescription.InDefinedShape inDefinedShape) {
            this.fieldDescription = inDefinedShape;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AccessDispatcher accessDispatcher = (AccessDispatcher) obj;
            return FieldAccess.this.equals(FieldAccess.this) && this.fieldDescription.equals(accessDispatcher.fieldDescription);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.fieldDescription.hashCode()) * 31) + FieldAccess.this.hashCode();
        }

        public StackManipulation read() {
            return new FieldGetInstruction();
        }

        public StackManipulation write() {
            return new FieldPutInstruction();
        }
    }

    public interface Defined {
        StackManipulation read();

        StackManipulation write();
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class OfGenericField implements Defined {
        private final Defined defined;
        private final TypeDefinition targetType;

        protected OfGenericField(TypeDefinition typeDefinition, Defined defined2) {
            this.targetType = typeDefinition;
            this.defined = defined2;
        }

        protected static Defined of(FieldDescription fieldDescription, Defined defined2) {
            return new OfGenericField(fieldDescription.getType(), defined2);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OfGenericField ofGenericField = (OfGenericField) obj;
            return this.targetType.equals(ofGenericField.targetType) && this.defined.equals(ofGenericField.defined);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31) + this.defined.hashCode();
        }

        public StackManipulation read() {
            return new StackManipulation.Compound(this.defined.read(), TypeCasting.to(this.targetType));
        }

        public StackManipulation write() {
            return this.defined.write();
        }
    }

    private FieldAccess(int i10, int i11, StackSize stackSize) {
        this.putterOpcode = i10;
        this.getterOpcode = i11;
        this.targetSizeChange = stackSize.getSize();
    }

    public static StackManipulation forEnumeration(EnumerationDescription enumerationDescription) {
        FieldList fieldList = (FieldList) enumerationDescription.getEnumerationType().getDeclaredFields().filter(ElementMatchers.named(enumerationDescription.getValue()));
        if (fieldList.size() != 1 || !((FieldDescription.InDefinedShape) fieldList.getOnly()).isStatic() || !((FieldDescription.InDefinedShape) fieldList.getOnly()).isPublic() || !((FieldDescription.InDefinedShape) fieldList.getOnly()).isEnum()) {
            return StackManipulation.Illegal.INSTANCE;
        }
        FieldAccess fieldAccess = STATIC;
        fieldAccess.getClass();
        return new AccessDispatcher((FieldDescription.InDefinedShape) fieldList.getOnly()).read();
    }

    public static Defined forField(FieldDescription.InDefinedShape inDefinedShape) {
        if (inDefinedShape.isStatic()) {
            FieldAccess fieldAccess = STATIC;
            fieldAccess.getClass();
            return new AccessDispatcher(inDefinedShape);
        }
        FieldAccess fieldAccess2 = INSTANCE;
        fieldAccess2.getClass();
        return new AccessDispatcher(inDefinedShape);
    }

    public static Defined forField(FieldDescription fieldDescription) {
        FieldDescription.InDefinedShape inDefinedShape = (FieldDescription.InDefinedShape) fieldDescription.asDefined();
        if (fieldDescription.getType().asErasure().equals(inDefinedShape.getType().asErasure())) {
            return forField(inDefinedShape);
        }
        return OfGenericField.of(fieldDescription, forField(inDefinedShape));
    }
}
