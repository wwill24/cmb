package net.bytebuddy.implementation.bytecode.assign.primitive;

import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;

public enum PrimitiveBoxingDelegate {
    BOOLEAN(Boolean.class, r15, "valueOf", "(Z)Ljava/lang/Boolean;"),
    BYTE(Byte.class, r12, "valueOf", "(B)Ljava/lang/Byte;"),
    SHORT(Short.class, r12, "valueOf", "(S)Ljava/lang/Short;"),
    CHARACTER(Character.class, r12, "valueOf", "(C)Ljava/lang/Character;"),
    INTEGER(Integer.class, r12, "valueOf", "(I)Ljava/lang/Integer;"),
    LONG(Long.class, r5, "valueOf", "(J)Ljava/lang/Long;"),
    FLOAT(Float.class, r12, "valueOf", "(F)Ljava/lang/Float;"),
    DOUBLE(Double.class, r5, "valueOf", "(D)Ljava/lang/Double;");
    
    /* access modifiers changed from: private */
    public final String boxingMethodDescriptor;
    /* access modifiers changed from: private */
    public final String boxingMethodName;
    /* access modifiers changed from: private */
    public final StackManipulation.Size size;
    /* access modifiers changed from: private */
    public final TypeDescription wrapperType;

    private class BoxingStackManipulation implements StackManipulation {
        private final StackManipulation stackManipulation;

        public BoxingStackManipulation(StackManipulation stackManipulation2) {
            this.stackManipulation = stackManipulation2;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, PrimitiveBoxingDelegate.this.wrapperType.getInternalName(), PrimitiveBoxingDelegate.this.boxingMethodName, PrimitiveBoxingDelegate.this.boxingMethodDescriptor, false);
            return PrimitiveBoxingDelegate.this.size.aggregate(this.stackManipulation.apply(methodVisitor, context));
        }

        public boolean isValid() {
            return this.stackManipulation.isValid();
        }
    }

    private PrimitiveBoxingDelegate(Class<?> cls, StackSize stackSize, String str, String str2) {
        this.wrapperType = TypeDescription.ForLoadedType.of(cls);
        this.size = stackSize.toDecreasingSize();
        this.boxingMethodName = str;
        this.boxingMethodDescriptor = str2;
    }

    public static PrimitiveBoxingDelegate forPrimitive(TypeDefinition typeDefinition) {
        if (typeDefinition.represents(Boolean.TYPE)) {
            return BOOLEAN;
        }
        if (typeDefinition.represents(Byte.TYPE)) {
            return BYTE;
        }
        if (typeDefinition.represents(Short.TYPE)) {
            return SHORT;
        }
        if (typeDefinition.represents(Character.TYPE)) {
            return CHARACTER;
        }
        if (typeDefinition.represents(Integer.TYPE)) {
            return INTEGER;
        }
        if (typeDefinition.represents(Long.TYPE)) {
            return LONG;
        }
        if (typeDefinition.represents(Float.TYPE)) {
            return FLOAT;
        }
        if (typeDefinition.represents(Double.TYPE)) {
            return DOUBLE;
        }
        throw new IllegalArgumentException("Not a non-void, primitive type: " + typeDefinition);
    }

    public StackManipulation assignBoxedTo(TypeDescription.Generic generic, Assigner assigner, Assigner.Typing typing) {
        return new BoxingStackManipulation(assigner.assign(this.wrapperType.asGenericType(), generic, typing));
    }
}
