package net.bytebuddy.asm;

import com.facebook.internal.ServerProtocol;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public abstract class ClassVisitorFactory<T> {
    private static final boolean ACCESS_CONTROLLER;
    private static final String DELEGATE = "delegate";
    private static final String LABELS = "labels";
    private static final String WRAP = "wrap";
    private final Class<?> type;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class AttributeTranslator implements ByteCodeAppender {
        protected static final String NAME = "attribute";
        private final Class<?> sourceAttribute;
        private final TypeDescription sourceWrapper;
        private final Class<?> targetAttribute;
        private final TypeDescription targetWrapper;

        protected AttributeTranslator(Class<?> cls, Class<?> cls2, TypeDescription typeDescription, TypeDescription typeDescription2) {
            this.sourceAttribute = cls;
            this.targetAttribute = cls2;
            this.sourceWrapper = typeDescription;
            this.targetWrapper = typeDescription2;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Label label = new Label();
            Label label2 = new Label();
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(Opcodes.ARETURN);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, this.targetWrapper.getInternalName());
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitTypeInsn(192, this.targetWrapper.getInternalName());
            methodVisitor.visitFieldInsn(Opcodes.GETFIELD, this.targetWrapper.getInternalName(), "delegate", Type.getDescriptor(this.sourceAttribute));
            methodVisitor.visitInsn(Opcodes.ARETURN);
            methodVisitor.visitLabel(label2);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitTypeInsn(Opcodes.NEW, this.sourceWrapper.getInternalName());
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(25, 0);
            MethodVisitor methodVisitor2 = methodVisitor;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESPECIAL, this.sourceWrapper.getInternalName(), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(this.targetAttribute)), false);
            methodVisitor.visitInsn(Opcodes.ARETURN);
            return new ByteCodeAppender.Size(3, 1);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AttributeTranslator attributeTranslator = (AttributeTranslator) obj;
            return this.sourceAttribute.equals(attributeTranslator.sourceAttribute) && this.targetAttribute.equals(attributeTranslator.targetAttribute) && this.sourceWrapper.equals(attributeTranslator.sourceWrapper) && this.targetWrapper.equals(attributeTranslator.targetWrapper);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.sourceAttribute.hashCode()) * 31) + this.targetAttribute.hashCode()) * 31) + this.sourceWrapper.hashCode()) * 31) + this.targetWrapper.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ConstantArrayTranslator implements ByteCodeAppender {
        protected static final String NAME = "constants";

        protected ConstantArrayTranslator() {
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            MethodVisitor methodVisitor2 = methodVisitor;
            Class<Object[]> cls = Object[].class;
            Class<Object> cls2 = Object.class;
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label);
            methodVisitor2.visitInsn(1);
            methodVisitor2.visitInsn(Opcodes.ARETURN);
            methodVisitor2.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor2, methodDescription.getParameters().asTypeList());
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitInsn(190);
            methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, Type.getInternalName(cls2));
            methodVisitor2.visitVarInsn(58, 1);
            methodVisitor2.visitInsn(3);
            methodVisitor2.visitVarInsn(54, 2);
            methodVisitor2.visitLabel(label2);
            context.getFrameGeneration().append(methodVisitor2, Arrays.asList(new TypeDescription[]{TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Integer.TYPE)}), methodDescription.getParameters().asTypeList());
            methodVisitor2.visitVarInsn(21, 2);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitInsn(190);
            methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPGE, label3);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(21, 2);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(21, 2);
            methodVisitor2.visitInsn(50);
            String internalName = context.getInstrumentedType().getInternalName();
            Type type = Type.getType((Class<?>) cls2);
            Type[] typeArr = {Type.getType((Class<?>) cls2)};
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, internalName, "constant", Type.getMethodDescriptor(type, typeArr), false);
            methodVisitor2.visitInsn(83);
            methodVisitor2.visitIincInsn(2, 1);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
            methodVisitor2.visitLabel(label3);
            context.getFrameGeneration().chop(methodVisitor2, 1, CompoundList.of(methodDescription.getParameters().asTypeList(), TypeDescription.ForLoadedType.of(cls)));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitInsn(Opcodes.ARETURN);
            return new ByteCodeAppender.Size(4, 3);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ConstantDynamicTranslator implements ByteCodeAppender {
        protected static final String NAME = "constantDyanmic";
        private final Class<?> sourceConstantDynamic;
        private final Class<?> sourceHandle;
        private final Class<?> targetConstantDynamic;
        private final Class<?> targetHandle;

        protected ConstantDynamicTranslator(Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4) {
            this.sourceConstantDynamic = cls;
            this.targetConstantDynamic = cls2;
            this.sourceHandle = cls3;
            this.targetHandle = cls4;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            MethodVisitor methodVisitor2 = methodVisitor;
            Class<Object[]> cls = Object[].class;
            Class<String> cls2 = String.class;
            Class<Object> cls3 = Object.class;
            Label label = new Label();
            Label label2 = new Label();
            methodVisitor2.visitVarInsn(25, 0);
            String internalName = Type.getInternalName(this.sourceConstantDynamic);
            Type type = Type.INT_TYPE;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, internalName, "getBootstrapMethodArgumentCount", Type.getMethodDescriptor(type, new Type[0]), false);
            methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, Type.getInternalName(cls3));
            methodVisitor2.visitVarInsn(58, 1);
            methodVisitor2.visitInsn(3);
            methodVisitor2.visitVarInsn(54, 2);
            methodVisitor2.visitLabel(label);
            context.getFrameGeneration().append(methodVisitor2, Arrays.asList(new TypeDescription[]{TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Integer.TYPE)}), methodDescription.getParameters().asTypeList());
            methodVisitor2.visitVarInsn(21, 2);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitInsn(190);
            methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPGE, label2);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(21, 2);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(21, 2);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(this.sourceConstantDynamic), "getBootstrapMethodArgument", Type.getMethodDescriptor(Type.getType((Class<?>) cls3), type), false);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, context.getInstrumentedType().getInternalName(), "ldc", Type.getMethodDescriptor(Type.getType((Class<?>) cls3), Type.getType((Class<?>) cls3)), false);
            methodVisitor2.visitInsn(83);
            methodVisitor2.visitIincInsn(2, 1);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label);
            methodVisitor2.visitLabel(label2);
            context.getFrameGeneration().chop(methodVisitor2, 1, CompoundList.of(methodDescription.getParameters().asTypeList(), TypeDescription.ForLoadedType.of(cls)));
            methodVisitor2.visitTypeInsn(Opcodes.NEW, Type.getInternalName(this.targetConstantDynamic));
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(this.sourceConstantDynamic), "getName", Type.getMethodDescriptor(Type.getType((Class<?>) cls2), new Type[0]), false);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(this.sourceConstantDynamic), "getDescriptor", Type.getMethodDescriptor(Type.getType((Class<?>) cls2), new Type[0]), false);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(this.sourceConstantDynamic), "getBootstrapMethod", Type.getMethodDescriptor(Type.getType(this.sourceHandle), new Type[0]), false);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, context.getInstrumentedType().getInternalName(), "handle", Type.getMethodDescriptor(Type.getType(this.targetHandle), Type.getType(this.sourceHandle)), false);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(this.targetConstantDynamic), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType((Class<?>) cls2), Type.getType((Class<?>) cls2), Type.getType(this.targetHandle), Type.getType((Class<?>) cls)), false);
            methodVisitor2.visitInsn(Opcodes.ARETURN);
            methodVisitor2.visitMaxs(6, 3);
            return new ByteCodeAppender.Size(6, 3);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ConstantDynamicTranslator constantDynamicTranslator = (ConstantDynamicTranslator) obj;
            return this.sourceConstantDynamic.equals(constantDynamicTranslator.sourceConstantDynamic) && this.targetConstantDynamic.equals(constantDynamicTranslator.targetConstantDynamic) && this.sourceHandle.equals(constantDynamicTranslator.sourceHandle) && this.targetHandle.equals(constantDynamicTranslator.targetHandle);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.sourceConstantDynamic.hashCode()) * 31) + this.targetConstantDynamic.hashCode()) * 31) + this.sourceHandle.hashCode()) * 31) + this.targetHandle.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ConstantTranslator implements ByteCodeAppender {
        protected static final String NAME = "constant";
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final Class<?> sourceConstantDynamic;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final Class<?> sourceHandle;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final Class<?> sourceType;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final Class<?> targetConstantDynamic;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final Class<?> targetHandle;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final Class<?> targetType;

        protected ConstantTranslator(@MaybeNull Class<?> cls, @MaybeNull Class<?> cls2, @MaybeNull Class<?> cls3, @MaybeNull Class<?> cls4, @MaybeNull Class<?> cls5, @MaybeNull Class<?> cls6) {
            this.sourceHandle = cls;
            this.targetHandle = cls2;
            this.sourceType = cls3;
            this.targetType = cls4;
            this.sourceConstantDynamic = cls5;
            this.targetConstantDynamic = cls6;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            int i10;
            int i11;
            int i12;
            MethodVisitor methodVisitor2 = methodVisitor;
            Class<String> cls = String.class;
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            if (this.sourceType == null || this.targetType == null) {
                i12 = 0;
                i11 = 25;
                i10 = 1;
            } else {
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitTypeInsn(Opcodes.INSTANCEOF, Type.getInternalName(this.sourceType));
                methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label);
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitTypeInsn(192, Type.getInternalName(this.sourceType));
                i12 = 0;
                i11 = 25;
                i10 = 1;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(this.sourceType), "getDescriptor", Type.getMethodDescriptor(Type.getType((Class<?>) cls), new Type[0]), false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(this.targetType), "getType", Type.getMethodDescriptor(Type.getType(this.targetType), Type.getType((Class<?>) cls)), false);
                methodVisitor2.visitInsn(Opcodes.ARETURN);
                methodVisitor2.visitLabel(label);
                context.getFrameGeneration().same(methodVisitor2, methodDescription.getParameters().asTypeList());
            }
            if (!(this.sourceHandle == null || this.targetHandle == null)) {
                methodVisitor2.visitVarInsn(i11, i12);
                methodVisitor2.visitTypeInsn(Opcodes.INSTANCEOF, Type.getInternalName(this.sourceHandle));
                methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label2);
                methodVisitor2.visitVarInsn(i11, i12);
                methodVisitor2.visitTypeInsn(192, Type.getInternalName(this.sourceHandle));
                String internalName = context.getInstrumentedType().getInternalName();
                Type type = Type.getType(this.targetHandle);
                Type[] typeArr = new Type[i10];
                typeArr[i12] = Type.getType(this.sourceHandle);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, internalName, "handle", Type.getMethodDescriptor(type, typeArr), false);
                methodVisitor2.visitInsn(Opcodes.ARETURN);
                methodVisitor2.visitLabel(label2);
                context.getFrameGeneration().same(methodVisitor2, methodDescription.getParameters().asTypeList());
            }
            if (!(this.sourceConstantDynamic == null || this.targetConstantDynamic == null)) {
                methodVisitor2.visitVarInsn(i11, i12);
                methodVisitor2.visitTypeInsn(Opcodes.INSTANCEOF, Type.getInternalName(this.sourceConstantDynamic));
                methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label3);
                methodVisitor2.visitVarInsn(i11, i12);
                methodVisitor2.visitTypeInsn(192, Type.getInternalName(this.sourceConstantDynamic));
                String internalName2 = context.getInstrumentedType().getInternalName();
                Type type2 = Type.getType(this.targetConstantDynamic);
                Type[] typeArr2 = new Type[i10];
                typeArr2[i12] = Type.getType(this.sourceConstantDynamic);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, internalName2, "constantDyanmic", Type.getMethodDescriptor(type2, typeArr2), false);
                methodVisitor2.visitInsn(Opcodes.ARETURN);
                methodVisitor2.visitLabel(label3);
                context.getFrameGeneration().same(methodVisitor2, methodDescription.getParameters().asTypeList());
            }
            methodVisitor2.visitVarInsn(i11, i12);
            methodVisitor2.visitInsn(Opcodes.ARETURN);
            return new ByteCodeAppender.Size(i10, i10);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r2 != null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
            if (r2 != null) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
            if (r2 != null) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x005a, code lost:
            if (r2 != null) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006c, code lost:
            if (r2 != null) goto L_0x006e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0081 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L_0x0004
                return r0
            L_0x0004:
                r1 = 0
                if (r5 != 0) goto L_0x0008
                return r1
            L_0x0008:
                java.lang.Class r2 = r4.getClass()
                java.lang.Class r3 = r5.getClass()
                if (r2 == r3) goto L_0x0013
                return r1
            L_0x0013:
                java.lang.Class<?> r2 = r4.sourceHandle
                net.bytebuddy.asm.ClassVisitorFactory$ConstantTranslator r5 = (net.bytebuddy.asm.ClassVisitorFactory.ConstantTranslator) r5
                java.lang.Class<?> r3 = r5.sourceHandle
                if (r3 == 0) goto L_0x0024
                if (r2 == 0) goto L_0x0026
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0027
                return r1
            L_0x0024:
                if (r2 == 0) goto L_0x0027
            L_0x0026:
                return r1
            L_0x0027:
                java.lang.Class<?> r2 = r4.targetHandle
                java.lang.Class<?> r3 = r5.targetHandle
                if (r3 == 0) goto L_0x0036
                if (r2 == 0) goto L_0x0038
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0039
                return r1
            L_0x0036:
                if (r2 == 0) goto L_0x0039
            L_0x0038:
                return r1
            L_0x0039:
                java.lang.Class<?> r2 = r4.sourceType
                java.lang.Class<?> r3 = r5.sourceType
                if (r3 == 0) goto L_0x0048
                if (r2 == 0) goto L_0x004a
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x004b
                return r1
            L_0x0048:
                if (r2 == 0) goto L_0x004b
            L_0x004a:
                return r1
            L_0x004b:
                java.lang.Class<?> r2 = r4.targetType
                java.lang.Class<?> r3 = r5.targetType
                if (r3 == 0) goto L_0x005a
                if (r2 == 0) goto L_0x005c
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x005d
                return r1
            L_0x005a:
                if (r2 == 0) goto L_0x005d
            L_0x005c:
                return r1
            L_0x005d:
                java.lang.Class<?> r2 = r4.sourceConstantDynamic
                java.lang.Class<?> r3 = r5.sourceConstantDynamic
                if (r3 == 0) goto L_0x006c
                if (r2 == 0) goto L_0x006e
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x006f
                return r1
            L_0x006c:
                if (r2 == 0) goto L_0x006f
            L_0x006e:
                return r1
            L_0x006f:
                java.lang.Class<?> r2 = r4.targetConstantDynamic
                java.lang.Class<?> r5 = r5.targetConstantDynamic
                if (r5 == 0) goto L_0x007e
                if (r2 == 0) goto L_0x0080
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L_0x0081
                return r1
            L_0x007e:
                if (r2 == 0) goto L_0x0081
            L_0x0080:
                return r1
            L_0x0081:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.ClassVisitorFactory.ConstantTranslator.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = getClass().hashCode() * 31;
            Class<?> cls = this.sourceHandle;
            if (cls != null) {
                hashCode += cls.hashCode();
            }
            int i10 = hashCode * 31;
            Class<?> cls2 = this.targetHandle;
            if (cls2 != null) {
                i10 += cls2.hashCode();
            }
            int i11 = i10 * 31;
            Class<?> cls3 = this.sourceType;
            if (cls3 != null) {
                i11 += cls3.hashCode();
            }
            int i12 = i11 * 31;
            Class<?> cls4 = this.targetType;
            if (cls4 != null) {
                i12 += cls4.hashCode();
            }
            int i13 = i12 * 31;
            Class<?> cls5 = this.sourceConstantDynamic;
            if (cls5 != null) {
                i13 += cls5.hashCode();
            }
            int i14 = i13 * 31;
            Class<?> cls6 = this.targetConstantDynamic;
            return cls6 != null ? i14 + cls6.hashCode() : i14;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class CreateClassVisitorFactory<S> implements PrivilegedAction<ClassVisitorFactory<S>> {
        private final ByteBuddy byteBuddy;
        private final Class<S> classVisitor;

        protected CreateClassVisitorFactory(Class<S> cls, ByteBuddy byteBuddy2) {
            this.classVisitor = cls;
            this.byteBuddy = byteBuddy2;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CreateClassVisitorFactory createClassVisitorFactory = (CreateClassVisitorFactory) obj;
            return this.classVisitor.equals(createClassVisitorFactory.classVisitor) && this.byteBuddy.equals(createClassVisitorFactory.byteBuddy);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.classVisitor.hashCode()) * 31) + this.byteBuddy.hashCode();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Class[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.Class[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v39, resolved type: net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v43, resolved type: net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v43, resolved type: net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: java.lang.Class} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: java.lang.Class} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: java.lang.Class} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: java.lang.Class} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: java.lang.Class} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v89, resolved type: java.lang.Class<net.bytebuddy.jar.asm.MethodVisitor>} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x0538 A[Catch:{ Exception -> 0x0816 }] */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x0542 A[Catch:{ Exception -> 0x0816 }] */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x057b A[Catch:{ Exception -> 0x0816 }] */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x0597 A[Catch:{ Exception -> 0x0816 }] */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x05db A[SYNTHETIC, Splitter:B:131:0x05db] */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x0612 A[Catch:{ Exception -> 0x0816 }] */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x0595 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0473 A[Catch:{ Exception -> 0x0816 }] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x04ae A[Catch:{ Exception -> 0x0816 }] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x04b6 A[Catch:{ Exception -> 0x0816 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.bytebuddy.asm.ClassVisitorFactory<S> run() {
            /*
                r41 = this;
                r1 = r41
                java.lang.String r0 = "delegate"
                java.lang.Class<net.bytebuddy.jar.asm.Label[]> r2 = net.bytebuddy.jar.asm.Label[].class
                java.lang.Class<net.bytebuddy.jar.asm.ConstantDynamic> r3 = net.bytebuddy.jar.asm.ConstantDynamic.class
                java.lang.Class<net.bytebuddy.jar.asm.Type> r4 = net.bytebuddy.jar.asm.Type.class
                java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
                java.lang.Class<net.bytebuddy.jar.asm.Handle> r6 = net.bytebuddy.jar.asm.Handle.class
                java.lang.Class<java.lang.Object[]> r7 = java.lang.Object[].class
                java.lang.Class<net.bytebuddy.jar.asm.ClassVisitor> r8 = net.bytebuddy.jar.asm.ClassVisitor.class
                java.lang.Class<net.bytebuddy.jar.asm.MethodVisitor> r9 = net.bytebuddy.jar.asm.MethodVisitor.class
                java.lang.Class<net.bytebuddy.jar.asm.TypePath> r10 = net.bytebuddy.jar.asm.TypePath.class
                java.lang.Class<net.bytebuddy.jar.asm.Label> r11 = net.bytebuddy.jar.asm.Label.class
                java.lang.Class<net.bytebuddy.jar.asm.Attribute> r12 = net.bytebuddy.jar.asm.Attribute.class
                java.lang.String r13 = r8.getSimpleName()
                java.lang.Class<S> r14 = r1.classVisitor
                java.lang.String r14 = r14.getSimpleName()
                boolean r13 = r13.equals(r14)
                if (r13 == 0) goto L_0x0838
                java.lang.Class<S> r13 = r1.classVisitor     // Catch:{ Exception -> 0x081a }
                java.lang.Package r13 = r13.getPackage()     // Catch:{ Exception -> 0x081a }
                java.lang.String r13 = r13.getName()     // Catch:{ Exception -> 0x081a }
                java.util.HashMap r14 = new java.util.HashMap     // Catch:{ Exception -> 0x081a }
                r14.<init>()     // Catch:{ Exception -> 0x081a }
                r15 = 6
                r16 = r0
                java.lang.Class[] r0 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x081a }
                r15 = 0
                r0[r15] = r12     // Catch:{ Exception -> 0x081a }
                r15 = 1
                r0[r15] = r11     // Catch:{ Exception -> 0x081a }
                r15 = 2
                r0[r15] = r4     // Catch:{ Exception -> 0x081a }
                r20 = 3
                r0[r20] = r10     // Catch:{ Exception -> 0x081a }
                r21 = 4
                r0[r21] = r6     // Catch:{ Exception -> 0x081a }
                r22 = 5
                r0[r22] = r3     // Catch:{ Exception -> 0x081a }
                java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x081a }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x081a }
            L_0x005b:
                boolean r23 = r0.hasNext()     // Catch:{ Exception -> 0x081a }
                java.lang.String r15 = "."
                if (r23 == 0) goto L_0x00a0
                java.lang.Object r23 = r0.next()     // Catch:{ Exception -> 0x081a }
                r25 = r0
                r0 = r23
                java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ Exception -> 0x081a }
                r23 = r7
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0096 }
                r7.<init>()     // Catch:{ ClassNotFoundException -> 0x0096 }
                r7.append(r13)     // Catch:{ ClassNotFoundException -> 0x0096 }
                r7.append(r15)     // Catch:{ ClassNotFoundException -> 0x0096 }
                java.lang.String r15 = r0.getSimpleName()     // Catch:{ ClassNotFoundException -> 0x0096 }
                r7.append(r15)     // Catch:{ ClassNotFoundException -> 0x0096 }
                java.lang.String r7 = r7.toString()     // Catch:{ ClassNotFoundException -> 0x0096 }
                java.lang.Class<S> r15 = r1.classVisitor     // Catch:{ ClassNotFoundException -> 0x0096 }
                java.lang.ClassLoader r15 = r15.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0096 }
                r26 = r5
                r5 = 0
                java.lang.Class r7 = java.lang.Class.forName(r7, r5, r15)     // Catch:{ ClassNotFoundException -> 0x0098 }
                r14.put(r0, r7)     // Catch:{ Exception -> 0x081a }
                goto L_0x0098
            L_0x0096:
                r26 = r5
            L_0x0098:
                r7 = r23
                r0 = r25
                r5 = r26
                r15 = 2
                goto L_0x005b
            L_0x00a0:
                r26 = r5
                r23 = r7
                boolean r0 = r14.containsKey(r11)     // Catch:{ Exception -> 0x081a }
                if (r0 == 0) goto L_0x00d8
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x081a }
                r0.<init>()     // Catch:{ Exception -> 0x081a }
                java.lang.String r5 = "[L"
                r0.append(r5)     // Catch:{ Exception -> 0x081a }
                java.lang.Object r5 = r14.get(r11)     // Catch:{ Exception -> 0x081a }
                java.lang.Class r5 = (java.lang.Class) r5     // Catch:{ Exception -> 0x081a }
                java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x081a }
                r0.append(r5)     // Catch:{ Exception -> 0x081a }
                java.lang.String r5 = ";"
                r0.append(r5)     // Catch:{ Exception -> 0x081a }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x081a }
                java.lang.Class<S> r5 = r1.classVisitor     // Catch:{ Exception -> 0x081a }
                java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ Exception -> 0x081a }
                r7 = 0
                java.lang.Class r0 = java.lang.Class.forName(r0, r7, r5)     // Catch:{ Exception -> 0x081a }
                r14.put(r2, r0)     // Catch:{ Exception -> 0x081a }
            L_0x00d8:
                java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x081a }
                r0.<init>()     // Catch:{ Exception -> 0x081a }
                java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x081a }
                r5.<init>()     // Catch:{ Exception -> 0x081a }
                r7 = 6
                java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x081a }
                r17 = 0
                r7[r17] = r8     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.AnnotationVisitor> r17 = net.bytebuddy.jar.asm.AnnotationVisitor.class
                r19 = 1
                r7[r19] = r17     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.ModuleVisitor> r17 = net.bytebuddy.jar.asm.ModuleVisitor.class
                r24 = 2
                r7[r24] = r17     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.RecordComponentVisitor> r17 = net.bytebuddy.jar.asm.RecordComponentVisitor.class
                r7[r20] = r17     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.FieldVisitor> r17 = net.bytebuddy.jar.asm.FieldVisitor.class
                r7[r21] = r17     // Catch:{ Exception -> 0x081a }
                r7[r22] = r9     // Catch:{ Exception -> 0x081a }
                java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ Exception -> 0x081a }
                java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x081a }
            L_0x0107:
                boolean r17 = r7.hasNext()     // Catch:{ Exception -> 0x081a }
                if (r17 == 0) goto L_0x0248
                java.lang.Object r17 = r7.next()     // Catch:{ Exception -> 0x081a }
                r20 = r7
                r7 = r17
                java.lang.Class r7 = (java.lang.Class) r7     // Catch:{ Exception -> 0x081a }
                r17 = r8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x022e }
                r8.<init>()     // Catch:{ ClassNotFoundException -> 0x022e }
                r8.append(r13)     // Catch:{ ClassNotFoundException -> 0x022e }
                r8.append(r15)     // Catch:{ ClassNotFoundException -> 0x022e }
                r21 = r13
                java.lang.String r13 = r7.getSimpleName()     // Catch:{ ClassNotFoundException -> 0x0227 }
                r8.append(r13)     // Catch:{ ClassNotFoundException -> 0x0227 }
                java.lang.String r8 = r8.toString()     // Catch:{ ClassNotFoundException -> 0x0227 }
                java.lang.Class<S> r13 = r1.classVisitor     // Catch:{ ClassNotFoundException -> 0x0227 }
                java.lang.ClassLoader r13 = r13.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0227 }
                r22 = r15
                r15 = 0
                java.lang.Class r8 = java.lang.Class.forName(r8, r15, r13)     // Catch:{ ClassNotFoundException -> 0x0220 }
                if (r7 != r9) goto L_0x01c3
                net.bytebuddy.ByteBuddy r13 = r1.byteBuddy     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.TypePath> r30 = net.bytebuddy.jar.asm.TypePath.class
                java.lang.Object r15 = r14.get(r10)     // Catch:{ Exception -> 0x081a }
                r31 = r15
                java.lang.Class r31 = (java.lang.Class) r31     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.Label> r32 = net.bytebuddy.jar.asm.Label.class
                java.lang.Object r15 = r14.get(r11)     // Catch:{ Exception -> 0x081a }
                r33 = r15
                java.lang.Class r33 = (java.lang.Class) r33     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.Type> r34 = net.bytebuddy.jar.asm.Type.class
                java.lang.Object r15 = r14.get(r4)     // Catch:{ Exception -> 0x081a }
                r35 = r15
                java.lang.Class r35 = (java.lang.Class) r35     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.Handle> r36 = net.bytebuddy.jar.asm.Handle.class
                java.lang.Object r15 = r14.get(r6)     // Catch:{ Exception -> 0x081a }
                r37 = r15
                java.lang.Class r37 = (java.lang.Class) r37     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.ConstantDynamic> r38 = net.bytebuddy.jar.asm.ConstantDynamic.class
                java.lang.Object r15 = r14.get(r3)     // Catch:{ Exception -> 0x081a }
                r39 = r15
                java.lang.Class r39 = (java.lang.Class) r39     // Catch:{ Exception -> 0x081a }
                r27 = r13
                r28 = r7
                r29 = r8
                net.bytebuddy.dynamic.DynamicType$Builder r13 = net.bytebuddy.asm.ClassVisitorFactory.toMethodVisitorBuilder(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.ByteBuddy r15 = r1.byteBuddy     // Catch:{ Exception -> 0x081a }
                java.lang.Object r25 = r14.get(r10)     // Catch:{ Exception -> 0x081a }
                r30 = r25
                java.lang.Class r30 = (java.lang.Class) r30     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.TypePath> r31 = net.bytebuddy.jar.asm.TypePath.class
                java.lang.Object r25 = r14.get(r11)     // Catch:{ Exception -> 0x081a }
                r32 = r25
                java.lang.Class r32 = (java.lang.Class) r32     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.Label> r33 = net.bytebuddy.jar.asm.Label.class
                java.lang.Object r25 = r14.get(r4)     // Catch:{ Exception -> 0x081a }
                r34 = r25
                java.lang.Class r34 = (java.lang.Class) r34     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.Type> r35 = net.bytebuddy.jar.asm.Type.class
                java.lang.Object r25 = r14.get(r6)     // Catch:{ Exception -> 0x081a }
                r36 = r25
                java.lang.Class r36 = (java.lang.Class) r36     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.Handle> r37 = net.bytebuddy.jar.asm.Handle.class
                java.lang.Object r25 = r14.get(r3)     // Catch:{ Exception -> 0x081a }
                r38 = r25
                java.lang.Class r38 = (java.lang.Class) r38     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.ConstantDynamic> r39 = net.bytebuddy.jar.asm.ConstantDynamic.class
                r27 = r15
                r28 = r8
                r29 = r7
                net.bytebuddy.dynamic.DynamicType$Builder r15 = net.bytebuddy.asm.ClassVisitorFactory.toMethodVisitorBuilder(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)     // Catch:{ Exception -> 0x081a }
                r25 = r3
                r33 = r4
                r35 = r6
                goto L_0x0216
            L_0x01c3:
                net.bytebuddy.ByteBuddy r13 = r1.byteBuddy     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.TypePath> r30 = net.bytebuddy.jar.asm.TypePath.class
                java.lang.Object r15 = r14.get(r10)     // Catch:{ Exception -> 0x081a }
                r31 = r15
                java.lang.Class r31 = (java.lang.Class) r31     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.implementation.Implementation$Simple r15 = new net.bytebuddy.implementation.Implementation$Simple     // Catch:{ Exception -> 0x081a }
                r25 = r3
                r33 = r4
                r3 = 1
                net.bytebuddy.implementation.bytecode.StackManipulation[] r4 = new net.bytebuddy.implementation.bytecode.StackManipulation[r3]     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.implementation.bytecode.member.MethodReturn r3 = net.bytebuddy.implementation.bytecode.member.MethodReturn.VOID     // Catch:{ Exception -> 0x081a }
                r18 = 0
                r4[r18] = r3     // Catch:{ Exception -> 0x081a }
                r15.<init>((net.bytebuddy.implementation.bytecode.StackManipulation[]) r4)     // Catch:{ Exception -> 0x081a }
                r27 = r13
                r28 = r7
                r29 = r8
                r32 = r15
                net.bytebuddy.dynamic.DynamicType$Builder r13 = net.bytebuddy.asm.ClassVisitorFactory.toVisitorBuilder(r27, r28, r29, r30, r31, r32)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.ByteBuddy r4 = r1.byteBuddy     // Catch:{ Exception -> 0x081a }
                java.lang.Object r15 = r14.get(r10)     // Catch:{ Exception -> 0x081a }
                r30 = r15
                java.lang.Class r30 = (java.lang.Class) r30     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.jar.asm.TypePath> r31 = net.bytebuddy.jar.asm.TypePath.class
                net.bytebuddy.implementation.Implementation$Simple r15 = new net.bytebuddy.implementation.Implementation$Simple     // Catch:{ Exception -> 0x081a }
                r35 = r6
                r34 = r13
                r13 = 1
                net.bytebuddy.implementation.bytecode.StackManipulation[] r6 = new net.bytebuddy.implementation.bytecode.StackManipulation[r13]     // Catch:{ Exception -> 0x081a }
                r13 = 0
                r6[r13] = r3     // Catch:{ Exception -> 0x081a }
                r15.<init>((net.bytebuddy.implementation.bytecode.StackManipulation[]) r6)     // Catch:{ Exception -> 0x081a }
                r27 = r4
                r28 = r8
                r29 = r7
                r32 = r15
                net.bytebuddy.dynamic.DynamicType$Builder r15 = net.bytebuddy.asm.ClassVisitorFactory.toVisitorBuilder(r27, r28, r29, r30, r31, r32)     // Catch:{ Exception -> 0x081a }
                r13 = r34
            L_0x0216:
                r0.put(r7, r8)     // Catch:{ Exception -> 0x081a }
                r5.put(r7, r13)     // Catch:{ Exception -> 0x081a }
                r5.put(r8, r15)     // Catch:{ Exception -> 0x081a }
                goto L_0x0238
            L_0x0220:
                r25 = r3
                r33 = r4
                r35 = r6
                goto L_0x0238
            L_0x0227:
                r25 = r3
                r33 = r4
                r35 = r6
                goto L_0x0236
            L_0x022e:
                r25 = r3
                r33 = r4
                r35 = r6
                r21 = r13
            L_0x0236:
                r22 = r15
            L_0x0238:
                r8 = r17
                r7 = r20
                r13 = r21
                r15 = r22
                r3 = r25
                r4 = r33
                r6 = r35
                goto L_0x0107
            L_0x0248:
                r35 = r6
                r17 = r8
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x081a }
                r3.<init>()     // Catch:{ Exception -> 0x081a }
                java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x081a }
                r4.<init>()     // Catch:{ Exception -> 0x081a }
                boolean r6 = r14.containsKey(r12)     // Catch:{ Exception -> 0x081a }
                if (r6 == 0) goto L_0x029b
                net.bytebuddy.ByteBuddy r6 = r1.byteBuddy     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy$Default r8 = net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.NO_CONSTRUCTORS     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType$Builder r6 = r6.subclass(r12, (net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy) r8)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.ByteBuddy r13 = r1.byteBuddy     // Catch:{ Exception -> 0x081a }
                java.lang.Object r15 = r14.get(r12)     // Catch:{ Exception -> 0x081a }
                java.lang.Class r15 = (java.lang.Class) r15     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType$Builder r8 = r13.subclass(r15, (net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy) r8)     // Catch:{ Exception -> 0x081a }
                java.lang.Object r13 = r14.get(r12)     // Catch:{ Exception -> 0x081a }
                java.lang.Class r13 = (java.lang.Class) r13     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.type.TypeDescription r15 = r6.toTypeDescription()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.type.TypeDescription r7 = r8.toTypeDescription()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType r7 = net.bytebuddy.asm.ClassVisitorFactory.toAttributeWrapper(r6, r12, r13, r15, r7)     // Catch:{ Exception -> 0x081a }
                r3.add(r7)     // Catch:{ Exception -> 0x081a }
                java.lang.Object r13 = r14.get(r12)     // Catch:{ Exception -> 0x081a }
                java.lang.Class r13 = (java.lang.Class) r13     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.type.TypeDescription r15 = r8.toTypeDescription()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.type.TypeDescription r6 = r6.toTypeDescription()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType r6 = net.bytebuddy.asm.ClassVisitorFactory.toAttributeWrapper(r8, r13, r12, r15, r6)     // Catch:{ Exception -> 0x081a }
                r3.add(r6)     // Catch:{ Exception -> 0x081a }
                goto L_0x029d
            L_0x029b:
                r6 = 0
                r7 = 0
            L_0x029d:
                java.util.Set r8 = r0.entrySet()     // Catch:{ Exception -> 0x081a }
                java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x081a }
            L_0x02a5:
                boolean r13 = r8.hasNext()     // Catch:{ Exception -> 0x081a }
                java.lang.String r15 = "wrap"
                if (r13 == 0) goto L_0x071d
                java.lang.Object r13 = r8.next()     // Catch:{ Exception -> 0x0816 }
                java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ Exception -> 0x0816 }
                r21 = r8
                java.lang.Object r8 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r8 = r5.get(r8)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r8 = (net.bytebuddy.dynamic.DynamicType.Builder) r8     // Catch:{ Exception -> 0x0816 }
                r22 = r8
                java.lang.Object r8 = r13.getValue()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r8 = r5.get(r8)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r8 = (net.bytebuddy.dynamic.DynamicType.Builder) r8     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r25 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                java.lang.Class r25 = (java.lang.Class) r25     // Catch:{ Exception -> 0x0816 }
                r27 = r8
                java.lang.reflect.Method[] r8 = r25.getMethods()     // Catch:{ Exception -> 0x0816 }
                int r1 = r8.length     // Catch:{ Exception -> 0x0816 }
                r25 = r3
                r3 = r22
                r22 = r4
                r4 = r27
                r27 = r15
                r15 = 0
            L_0x02e3:
                if (r15 >= r1) goto L_0x06c4
                r28 = r8[r15]     // Catch:{ Exception -> 0x0816 }
                r29 = r1
                java.lang.Class r1 = r28.getDeclaringClass()     // Catch:{ Exception -> 0x0816 }
                r30 = r8
                r8 = r26
                if (r1 != r8) goto L_0x030b
                r36 = r6
                r37 = r7
                r40 = r8
                r39 = r9
                r38 = r11
                r7 = r12
                r26 = r15
                r8 = r16
                r11 = r23
                r23 = r35
                r9 = r0
                r35 = r2
                goto L_0x06a8
            L_0x030b:
                java.lang.Class[] r1 = r28.getParameterTypes()     // Catch:{ Exception -> 0x0816 }
                r26 = r15
                int r15 = r1.length     // Catch:{ Exception -> 0x0816 }
                r31 = r0
                java.lang.Class[] r0 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x0816 }
                r32 = r4
                java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0816 }
                r33 = r3
                int r3 = r1.length     // Catch:{ Exception -> 0x0816 }
                r4.<init>(r3)     // Catch:{ Exception -> 0x0816 }
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0816 }
                r3.<init>(r15)     // Catch:{ Exception -> 0x0816 }
                r36 = r6
                r37 = r7
                r6 = 1
                r15 = 0
                r34 = 0
            L_0x032d:
                int r7 = r1.length     // Catch:{ Exception -> 0x0816 }
                if (r15 >= r7) goto L_0x05b7
                java.lang.Object r7 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                if (r7 != r9) goto L_0x0388
                r7 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                if (r7 != r11) goto L_0x0388
                java.lang.Object r7 = r14.get(r11)     // Catch:{ Exception -> 0x0816 }
                java.lang.Class r7 = (java.lang.Class) r7     // Catch:{ Exception -> 0x0816 }
                r0[r15] = r7     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r5.get(r7)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r7 = (net.bytebuddy.dynamic.DynamicType.Builder) r7     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r7 = r7.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                r38 = r11
                r11 = r0[r15]     // Catch:{ Exception -> 0x0816 }
                r39 = r12
                java.lang.String r12 = "label"
                r40 = r8
                r8 = 1
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r7 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r7, r11, r12, r6, r8)     // Catch:{ Exception -> 0x0816 }
                r4.add(r7)     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r13.getValue()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r5.get(r7)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r7 = (net.bytebuddy.dynamic.DynamicType.Builder) r7     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r7 = r7.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                r8 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                java.lang.String r11 = "label"
                r12 = 1
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r7 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r7, r8, r11, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r3.add(r7)     // Catch:{ Exception -> 0x0816 }
            L_0x037c:
                r11 = r23
                r23 = r35
                r7 = r39
                r35 = r2
            L_0x0384:
                r39 = r9
                goto L_0x0591
            L_0x0388:
                r40 = r8
                r38 = r11
                r39 = r12
                java.lang.Object r7 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                if (r7 != r9) goto L_0x03d5
                r7 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                if (r7 != r2) goto L_0x03d5
                java.lang.Object r7 = r14.get(r2)     // Catch:{ Exception -> 0x0816 }
                java.lang.Class r7 = (java.lang.Class) r7     // Catch:{ Exception -> 0x0816 }
                r0[r15] = r7     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r5.get(r7)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r7 = (net.bytebuddy.dynamic.DynamicType.Builder) r7     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r7 = r7.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                r8 = r0[r15]     // Catch:{ Exception -> 0x0816 }
                java.lang.String r11 = "labels"
                r12 = 1
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r7 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r7, r8, r11, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r4.add(r7)     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r13.getValue()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r5.get(r7)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r7 = (net.bytebuddy.dynamic.DynamicType.Builder) r7     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r7 = r7.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                r8 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                java.lang.String r11 = "labels"
                r12 = 1
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r7 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r7, r8, r11, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r3.add(r7)     // Catch:{ Exception -> 0x0816 }
                goto L_0x037c
            L_0x03d5:
                r7 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                if (r7 != r10) goto L_0x0417
                java.lang.Object r7 = r14.get(r10)     // Catch:{ Exception -> 0x0816 }
                java.lang.Class r7 = (java.lang.Class) r7     // Catch:{ Exception -> 0x0816 }
                r0[r15] = r7     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r5.get(r7)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r7 = (net.bytebuddy.dynamic.DynamicType.Builder) r7     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r7 = r7.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                r8 = r0[r15]     // Catch:{ Exception -> 0x0816 }
                java.lang.String r11 = "typePath"
                r12 = 0
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r7 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r7, r8, r11, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r4.add(r7)     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r13.getValue()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r5.get(r7)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r7 = (net.bytebuddy.dynamic.DynamicType.Builder) r7     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r7 = r7.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                r8 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                java.lang.String r11 = "typePath"
                r12 = 0
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r7 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r7, r8, r11, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r3.add(r7)     // Catch:{ Exception -> 0x0816 }
                goto L_0x037c
            L_0x0417:
                java.lang.Object r7 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                if (r7 != r9) goto L_0x0469
                r7 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                r8 = r35
                if (r7 != r8) goto L_0x046b
                java.lang.Object r7 = r14.get(r8)     // Catch:{ Exception -> 0x0816 }
                java.lang.Class r7 = (java.lang.Class) r7     // Catch:{ Exception -> 0x0816 }
                r0[r15] = r7     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r7 = r5.get(r7)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r7 = (net.bytebuddy.dynamic.DynamicType.Builder) r7     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r7 = r7.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                r11 = r0[r15]     // Catch:{ Exception -> 0x0816 }
                java.lang.String r12 = "handle"
                r35 = r2
                r2 = 0
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r7 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r7, r11, r12, r6, r2)     // Catch:{ Exception -> 0x0816 }
                r4.add(r7)     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r13.getValue()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r2 = (net.bytebuddy.dynamic.DynamicType.Builder) r2     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r2 = r2.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                r7 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                java.lang.String r11 = "handle"
                r12 = 0
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r2 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r2, r7, r11, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r3.add(r2)     // Catch:{ Exception -> 0x0816 }
            L_0x0461:
                r11 = r23
                r7 = r39
                r23 = r8
                goto L_0x0384
            L_0x0469:
                r8 = r35
            L_0x046b:
                r35 = r2
                java.lang.Object r2 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                if (r2 != r9) goto L_0x04ae
                r2 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                r7 = r40
                if (r2 != r7) goto L_0x04b0
                r0[r15] = r7     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r2 = (net.bytebuddy.dynamic.DynamicType.Builder) r2     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r2 = r2.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                java.lang.String r11 = "constant"
                r12 = 0
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r2 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r2, r7, r11, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r4.add(r2)     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r13.getValue()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r2 = (net.bytebuddy.dynamic.DynamicType.Builder) r2     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r2 = r2.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                java.lang.String r11 = "constant"
                r12 = 0
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r2 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r2, r7, r11, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r3.add(r2)     // Catch:{ Exception -> 0x0816 }
                r40 = r7
                goto L_0x0461
            L_0x04ae:
                r7 = r40
            L_0x04b0:
                java.lang.Object r2 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                if (r2 != r9) goto L_0x0538
                r2 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                r11 = r23
                if (r2 != r11) goto L_0x0535
                r0[r15] = r11     // Catch:{ Exception -> 0x0816 }
                java.lang.String r2 = r28.getName()     // Catch:{ Exception -> 0x0816 }
                java.lang.String r12 = "visitFrame"
                boolean r2 = r2.equals(r12)     // Catch:{ Exception -> 0x0816 }
                if (r2 == 0) goto L_0x04fd
                java.lang.Object r2 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r2 = (net.bytebuddy.dynamic.DynamicType.Builder) r2     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r2 = r2.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                java.lang.String r12 = "frames"
                r40 = r7
                r7 = 1
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r2 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r2, r11, r12, r6, r7)     // Catch:{ Exception -> 0x0816 }
                r4.add(r2)     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r13.getValue()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r2 = (net.bytebuddy.dynamic.DynamicType.Builder) r2     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r2 = r2.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                java.lang.String r7 = "frames"
                r12 = 1
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r2 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r2, r11, r7, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r3.add(r2)     // Catch:{ Exception -> 0x0816 }
                goto L_0x052f
            L_0x04fd:
                r40 = r7
                java.lang.Object r2 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r2 = (net.bytebuddy.dynamic.DynamicType.Builder) r2     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r2 = r2.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                java.lang.String r7 = "constants"
                r12 = 0
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r2 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r2, r11, r7, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r4.add(r2)     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r13.getValue()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r2 = (net.bytebuddy.dynamic.DynamicType.Builder) r2     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r2 = r2.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                java.lang.String r7 = "constants"
                r12 = 0
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r2 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r2, r11, r7, r6, r12)     // Catch:{ Exception -> 0x0816 }
                r3.add(r2)     // Catch:{ Exception -> 0x0816 }
            L_0x052f:
                r23 = r8
                r7 = r39
                goto L_0x0384
            L_0x0535:
                r40 = r7
                goto L_0x053c
            L_0x0538:
                r40 = r7
                r11 = r23
            L_0x053c:
                r2 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                r7 = r39
                if (r2 != r7) goto L_0x057b
                java.lang.Object r2 = r14.get(r7)     // Catch:{ Exception -> 0x0816 }
                java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ Exception -> 0x0816 }
                r0[r15] = r2     // Catch:{ Exception -> 0x0816 }
                if (r37 == 0) goto L_0x0574
                if (r36 == 0) goto L_0x0574
                net.bytebuddy.description.type.TypeDescription r2 = r36.getTypeDescription()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r12 = r14.get(r7)     // Catch:{ Exception -> 0x0816 }
                java.lang.Class r12 = (java.lang.Class) r12     // Catch:{ Exception -> 0x0816 }
                r23 = r8
                java.lang.String r8 = "attribute"
                r39 = r9
                r9 = 0
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r2 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r2, r12, r8, r6, r9)     // Catch:{ Exception -> 0x0816 }
                r4.add(r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r2 = r37.getTypeDescription()     // Catch:{ Exception -> 0x0816 }
                java.lang.String r8 = "attribute"
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$Factory r2 = net.bytebuddy.asm.ClassVisitorFactory.toConvertedParameter(r2, r7, r8, r6, r9)     // Catch:{ Exception -> 0x0816 }
                r3.add(r2)     // Catch:{ Exception -> 0x0816 }
                goto L_0x0591
            L_0x0574:
                r23 = r8
                r39 = r9
                r34 = 1
                goto L_0x0591
            L_0x057b:
                r23 = r8
                r39 = r9
                r0[r15] = r2     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$ForMethodParameter$Factory r2 = new net.bytebuddy.implementation.MethodCall$ArgumentLoader$ForMethodParameter$Factory     // Catch:{ Exception -> 0x0816 }
                r2.<init>(r15)     // Catch:{ Exception -> 0x0816 }
                r4.add(r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.implementation.MethodCall$ArgumentLoader$ForMethodParameter$Factory r2 = new net.bytebuddy.implementation.MethodCall$ArgumentLoader$ForMethodParameter$Factory     // Catch:{ Exception -> 0x0816 }
                r2.<init>(r15)     // Catch:{ Exception -> 0x0816 }
                r3.add(r2)     // Catch:{ Exception -> 0x0816 }
            L_0x0591:
                r2 = r0[r15]     // Catch:{ Exception -> 0x0816 }
                if (r2 != 0) goto L_0x0597
                r1 = 1
                goto L_0x05c5
            L_0x0597:
                r2 = r1[r15]     // Catch:{ Exception -> 0x0816 }
                java.lang.Class r8 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x0816 }
                if (r2 == r8) goto L_0x05a4
                java.lang.Class r8 = java.lang.Double.TYPE     // Catch:{ Exception -> 0x0816 }
                if (r2 != r8) goto L_0x05a2
                goto L_0x05a4
            L_0x05a2:
                r2 = 1
                goto L_0x05a5
            L_0x05a4:
                r2 = 2
            L_0x05a5:
                int r6 = r6 + r2
                int r15 = r15 + 1
                r12 = r7
                r2 = r35
                r9 = r39
                r8 = r40
                r35 = r23
                r23 = r11
                r11 = r38
                goto L_0x032d
            L_0x05b7:
                r40 = r8
                r39 = r9
                r38 = r11
                r7 = r12
                r11 = r23
                r23 = r35
                r35 = r2
                r1 = 0
            L_0x05c5:
                if (r1 == 0) goto L_0x05cb
            L_0x05c7:
                r0 = 0
                r34 = 1
                goto L_0x05d9
            L_0x05cb:
                java.lang.Object r1 = r13.getValue()     // Catch:{ NoSuchMethodException -> 0x05c7 }
                java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ NoSuchMethodException -> 0x05c7 }
                java.lang.String r2 = r28.getName()     // Catch:{ NoSuchMethodException -> 0x05c7 }
                java.lang.reflect.Method r0 = r1.getMethod(r2, r0)     // Catch:{ NoSuchMethodException -> 0x05c7 }
            L_0x05d9:
                if (r34 == 0) goto L_0x0612
                net.bytebuddy.matcher.ElementMatcher$Junction r1 = net.bytebuddy.matcher.ElementMatchers.is((java.lang.reflect.Method) r28)     // Catch:{ Exception -> 0x0816 }
                r2 = r33
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r1 = r2.method(r1)     // Catch:{ Exception -> 0x0816 }
                java.lang.Class<java.lang.UnsupportedOperationException> r2 = java.lang.UnsupportedOperationException.class
                net.bytebuddy.implementation.Implementation r2 = net.bytebuddy.implementation.ExceptionMethod.throwing((java.lang.Class<? extends java.lang.Throwable>) r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r1 = r1.intercept(r2)     // Catch:{ Exception -> 0x0816 }
                if (r0 == 0) goto L_0x0608
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.is((java.lang.reflect.Method) r0)     // Catch:{ Exception -> 0x0816 }
                r6 = r32
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r0 = r6.method(r0)     // Catch:{ Exception -> 0x0816 }
                java.lang.Class<java.lang.UnsupportedOperationException> r2 = java.lang.UnsupportedOperationException.class
                net.bytebuddy.implementation.Implementation r2 = net.bytebuddy.implementation.ExceptionMethod.throwing((java.lang.Class<? extends java.lang.Throwable>) r2)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r0 = r0.intercept(r2)     // Catch:{ Exception -> 0x0816 }
                r4 = r0
                r3 = r1
                goto L_0x060c
            L_0x0608:
                r6 = r32
                r3 = r1
                r4 = r6
            L_0x060c:
                r8 = r16
                r9 = r31
                goto L_0x06a8
            L_0x0612:
                r6 = r32
                r2 = r33
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r1 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r0)     // Catch:{ Exception -> 0x0816 }
                r8 = r16
                net.bytebuddy.implementation.MethodCall r1 = r1.onField((java.lang.String) r8)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.implementation.MethodCall r1 = r1.with((java.util.List<? extends net.bytebuddy.implementation.MethodCall.ArgumentLoader.Factory>) r4)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r4 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r28)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.implementation.MethodCall r4 = r4.onField((java.lang.String) r8)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.implementation.MethodCall r3 = r4.with((java.util.List<? extends net.bytebuddy.implementation.MethodCall.ArgumentLoader.Factory>) r3)     // Catch:{ Exception -> 0x0816 }
                java.lang.Class r4 = r28.getReturnType()     // Catch:{ Exception -> 0x0816 }
                r9 = r31
                java.lang.Object r4 = r9.get(r4)     // Catch:{ Exception -> 0x0816 }
                java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ Exception -> 0x0816 }
                if (r4 == 0) goto L_0x068e
                java.lang.Class r12 = r28.getReturnType()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r12 = r5.get(r12)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r12 = (net.bytebuddy.dynamic.DynamicType.Builder) r12     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r12 = r12.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.method.MethodList r12 = r12.getDeclaredMethods()     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.matcher.ElementMatcher$Junction r15 = net.bytebuddy.matcher.ElementMatchers.named(r27)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.matcher.FilterableList r12 = r12.filter(r15)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.method.MethodList r12 = (net.bytebuddy.description.method.MethodList) r12     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r12 = r12.getOnly()     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.method.MethodDescription r12 = (net.bytebuddy.description.method.MethodDescription) r12     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r12 = net.bytebuddy.implementation.MethodCall.invoke((net.bytebuddy.description.method.MethodDescription) r12)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.implementation.MethodCall r1 = r12.withMethodCall(r1)     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r4 = r5.get(r4)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder r4 = (net.bytebuddy.dynamic.DynamicType.Builder) r4     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r4 = r4.toTypeDescription()     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.method.MethodList r4 = r4.getDeclaredMethods()     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.matcher.ElementMatcher$Junction r12 = net.bytebuddy.matcher.ElementMatchers.named(r27)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.matcher.FilterableList r4 = r4.filter(r12)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.method.MethodList r4 = (net.bytebuddy.description.method.MethodList) r4     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r4 = r4.getOnly()     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.method.MethodDescription r4 = (net.bytebuddy.description.method.MethodDescription) r4     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r4 = net.bytebuddy.implementation.MethodCall.invoke((net.bytebuddy.description.method.MethodDescription) r4)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.implementation.MethodCall r3 = r4.withMethodCall(r3)     // Catch:{ Exception -> 0x0816 }
            L_0x068e:
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.is((java.lang.reflect.Method) r28)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r2 = r2.method(r4)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r1 = r2.intercept(r1)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.is((java.lang.reflect.Method) r0)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r0 = r6.method(r0)     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r0 = r0.intercept(r3)     // Catch:{ Exception -> 0x0816 }
                r4 = r0
                r3 = r1
            L_0x06a8:
                int r15 = r26 + 1
                r12 = r7
                r16 = r8
                r0 = r9
                r1 = r29
                r8 = r30
                r2 = r35
                r6 = r36
                r7 = r37
                r9 = r39
                r26 = r40
                r35 = r23
                r23 = r11
                r11 = r38
                goto L_0x02e3
            L_0x06c4:
                r36 = r6
                r37 = r7
                r39 = r9
                r38 = r11
                r7 = r12
                r8 = r16
                r11 = r23
                r40 = r26
                r23 = r35
                r9 = r0
                r35 = r2
                r2 = r3
                r6 = r4
                net.bytebuddy.dynamic.DynamicType$Unloaded r0 = r2.make()     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.dynamic.DynamicType$Unloaded r1 = r6.make()     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r13.getKey()     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r3 = r0.getTypeDescription()     // Catch:{ Exception -> 0x0816 }
                r4 = r22
                r4.put(r2, r3)     // Catch:{ Exception -> 0x0816 }
                java.lang.Object r2 = r13.getValue()     // Catch:{ Exception -> 0x0816 }
                net.bytebuddy.description.type.TypeDescription r3 = r1.getTypeDescription()     // Catch:{ Exception -> 0x0816 }
                r4.put(r2, r3)     // Catch:{ Exception -> 0x0816 }
                r2 = r25
                r2.add(r0)     // Catch:{ Exception -> 0x0816 }
                r2.add(r1)     // Catch:{ Exception -> 0x0816 }
                r1 = r41
                r3 = r2
                r12 = r7
                r16 = r8
                r0 = r9
                r8 = r21
                r2 = r35
                r6 = r36
                r7 = r37
                r9 = r39
                r26 = r40
                r35 = r23
                r23 = r11
                r11 = r38
                goto L_0x02a5
            L_0x071d:
                r2 = r3
                r27 = r15
                net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder r0 = new net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder     // Catch:{ Exception -> 0x0816 }
                r1 = 0
                r0.<init>(r1)     // Catch:{ Exception -> 0x0816 }
                r3 = 2
                java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0816 }
                r3[r1] = r17     // Catch:{ Exception -> 0x0816 }
                r1 = r41
                java.lang.Class<S> r5 = r1.classVisitor     // Catch:{ Exception -> 0x081a }
                r6 = 1
                r3[r6] = r5     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder r0 = r0.appendMostSpecific((java.lang.Class<?>[]) r3)     // Catch:{ Exception -> 0x081a }
                java.lang.ClassLoader r0 = r0.build()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.ByteBuddy r3 = r1.byteBuddy     // Catch:{ Exception -> 0x081a }
                java.lang.Class<net.bytebuddy.asm.ClassVisitorFactory> r5 = net.bytebuddy.asm.ClassVisitorFactory.class
                net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy$Default r6 = net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType$Builder r3 = r3.subclass(r5, (net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy) r6)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.matcher.ElementMatcher$Junction r5 = net.bytebuddy.matcher.ElementMatchers.named(r27)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r3 = r3.method(r5)     // Catch:{ Exception -> 0x081a }
                java.lang.Class<S> r5 = r1.classVisitor     // Catch:{ Exception -> 0x081a }
                java.lang.Object r5 = r4.get(r5)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.method.MethodList r5 = r5.getDeclaredMethods()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.matcher.ElementMatcher$Junction r6 = net.bytebuddy.matcher.ElementMatchers.isConstructor()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.matcher.FilterableList r5 = r5.filter(r6)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.method.MethodList r5 = (net.bytebuddy.description.method.MethodList) r5     // Catch:{ Exception -> 0x081a }
                java.lang.Object r5 = r5.getOnly()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.method.MethodDescription r5 = (net.bytebuddy.description.method.MethodDescription) r5     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.implementation.MethodCall r5 = net.bytebuddy.implementation.MethodCall.construct((net.bytebuddy.description.method.MethodDescription) r5)     // Catch:{ Exception -> 0x081a }
                r6 = 1
                int[] r7 = new int[r6]     // Catch:{ Exception -> 0x081a }
                r6 = 0
                r7[r6] = r6     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.implementation.MethodCall r5 = r5.withArgument(r7)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r3 = r3.intercept(r5)     // Catch:{ Exception -> 0x081a }
                java.lang.String r5 = "unwrap"
                net.bytebuddy.matcher.ElementMatcher$Junction r5 = net.bytebuddy.matcher.ElementMatchers.named(r5)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r3 = r3.method(r5)     // Catch:{ Exception -> 0x081a }
                r5 = r17
                java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.method.MethodList r4 = r4.getDeclaredMethods()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.matcher.ElementMatcher$Junction r6 = net.bytebuddy.matcher.ElementMatchers.isConstructor()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.matcher.FilterableList r4 = r4.filter(r6)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.method.MethodList r4 = (net.bytebuddy.description.method.MethodList) r4     // Catch:{ Exception -> 0x081a }
                java.lang.Object r4 = r4.getOnly()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.description.method.MethodDescription r4 = (net.bytebuddy.description.method.MethodDescription) r4     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.implementation.MethodCall r4 = net.bytebuddy.implementation.MethodCall.construct((net.bytebuddy.description.method.MethodDescription) r4)     // Catch:{ Exception -> 0x081a }
                r6 = 1
                int[] r7 = new int[r6]     // Catch:{ Exception -> 0x081a }
                r6 = 0
                r7[r6] = r6     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.implementation.MethodCall r4 = r4.withArgument(r7)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.implementation.bytecode.assign.Assigner r6 = net.bytebuddy.implementation.bytecode.assign.Assigner.DEFAULT     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r7 = net.bytebuddy.implementation.bytecode.assign.Assigner.Typing.DYNAMIC     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.implementation.Implementation$Composable r4 = r4.withAssigner(r6, r7)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r3 = r3.intercept(r4)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType$Unloaded r3 = r3.make()     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType$Unloaded r2 = r3.include((java.util.List<? extends net.bytebuddy.dynamic.DynamicType>) r2)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.dynamic.DynamicType$Loaded r2 = r2.load(r0)     // Catch:{ Exception -> 0x081a }
                java.lang.Class r2 = r2.getLoaded()     // Catch:{ Exception -> 0x081a }
                r3 = 1
                java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x081a }
                java.lang.Class<java.lang.Class> r6 = java.lang.Class.class
                r7 = 0
                r4[r7] = r6     // Catch:{ Exception -> 0x081a }
                java.lang.reflect.Constructor r2 = r2.getConstructor(r4)     // Catch:{ Exception -> 0x081a }
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x081a }
                java.lang.Class<S> r4 = r1.classVisitor     // Catch:{ Exception -> 0x081a }
                r3[r7] = r4     // Catch:{ Exception -> 0x081a }
                java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ Exception -> 0x081a }
                net.bytebuddy.asm.ClassVisitorFactory r2 = (net.bytebuddy.asm.ClassVisitorFactory) r2     // Catch:{ Exception -> 0x081a }
                boolean r3 = r0 instanceof net.bytebuddy.dynamic.loading.MultipleParentClassLoader     // Catch:{ Exception -> 0x081a }
                if (r3 == 0) goto L_0x0815
                java.lang.ClassLoader r3 = r5.getClassLoader()     // Catch:{ Exception -> 0x081a }
                if (r0 == r3) goto L_0x0815
                java.lang.Class<S> r3 = r1.classVisitor     // Catch:{ Exception -> 0x081a }
                java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ Exception -> 0x081a }
                if (r0 == r3) goto L_0x0815
                r3 = r0
                net.bytebuddy.dynamic.loading.MultipleParentClassLoader r3 = (net.bytebuddy.dynamic.loading.MultipleParentClassLoader) r3     // Catch:{ Exception -> 0x081a }
                boolean r3 = r3.seal()     // Catch:{ Exception -> 0x081a }
                if (r3 == 0) goto L_0x07fe
                goto L_0x0815
            L_0x07fe:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x081a }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x081a }
                r3.<init>()     // Catch:{ Exception -> 0x081a }
                java.lang.String r4 = "Failed to seal multiple parent class loader: "
                r3.append(r4)     // Catch:{ Exception -> 0x081a }
                r3.append(r0)     // Catch:{ Exception -> 0x081a }
                java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x081a }
                r2.<init>(r0)     // Catch:{ Exception -> 0x081a }
                throw r2     // Catch:{ Exception -> 0x081a }
            L_0x0815:
                return r2
            L_0x0816:
                r0 = move-exception
                r1 = r41
                goto L_0x081b
            L_0x081a:
                r0 = move-exception
            L_0x081b:
                java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Failed to generate factory for "
                r3.append(r4)
                java.lang.Class<S> r4 = r1.classVisitor
                java.lang.String r4 = r4.getName()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r2.<init>(r3, r0)
                throw r2
            L_0x0838:
                r5 = r8
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Expected a class named "
                r2.append(r3)
                java.lang.String r3 = r5.getSimpleName()
                r2.append(r3)
                java.lang.String r3 = ": "
                r2.append(r3)
                java.lang.Class<S> r3 = r1.classVisitor
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.ClassVisitorFactory.CreateClassVisitorFactory.run():net.bytebuddy.asm.ClassVisitorFactory");
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class FrameTranslator implements ByteCodeAppender {
        protected static final String NAME = "frames";
        private final Class<?> sourceLabel;
        private final Class<?> targetLabel;

        protected FrameTranslator(Class<?> cls, Class<?> cls2) {
            this.sourceLabel = cls;
            this.targetLabel = cls2;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            MethodVisitor methodVisitor2 = methodVisitor;
            Class<Object> cls = Object.class;
            Class<Object[]> cls2 = Object[].class;
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            Label label4 = new Label();
            Label label5 = new Label();
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label);
            methodVisitor2.visitInsn(1);
            methodVisitor2.visitInsn(Opcodes.ARETURN);
            methodVisitor2.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor2, CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitInsn(190);
            methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, Type.getInternalName(cls));
            methodVisitor2.visitVarInsn(58, 2);
            methodVisitor2.visitInsn(3);
            methodVisitor2.visitVarInsn(54, 3);
            methodVisitor2.visitLabel(label2);
            Implementation.Context.FrameGeneration frameGeneration = context.getFrameGeneration();
            Class cls3 = Integer.TYPE;
            frameGeneration.append(methodVisitor2, Arrays.asList(new TypeDescription[]{TypeDescription.ForLoadedType.of(cls2), TypeDescription.ForLoadedType.of(cls3)}), CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor2.visitVarInsn(21, 3);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitInsn(190);
            methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPGE, label4);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(21, 3);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(21, 3);
            methodVisitor2.visitInsn(50);
            methodVisitor2.visitTypeInsn(Opcodes.INSTANCEOF, Type.getInternalName(this.sourceLabel));
            methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label5);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(21, 3);
            methodVisitor2.visitInsn(50);
            methodVisitor2.visitTypeInsn(192, Type.getInternalName(this.sourceLabel));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, context.getInstrumentedType().getInternalName(), "label", Type.getMethodDescriptor(Type.getType(this.targetLabel), Type.getType(this.sourceLabel)), false);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label3);
            methodVisitor2.visitLabel(label5);
            context.getFrameGeneration().full(methodVisitor2, Arrays.asList(new TypeDescription[]{TypeDescription.ForLoadedType.of(cls2), TypeDescription.ForLoadedType.of(cls3)}), CompoundList.of(Collections.singletonList(context.getInstrumentedType()), methodDescription.getParameters().asTypeList(), Arrays.asList(new TypeDescription[]{TypeDescription.ForLoadedType.of(cls2), TypeDescription.ForLoadedType.of(cls3)})));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(21, 3);
            methodVisitor2.visitInsn(50);
            methodVisitor2.visitLabel(label3);
            context.getFrameGeneration().full(methodVisitor2, Arrays.asList(new TypeDescription[]{TypeDescription.ForLoadedType.of(cls2), TypeDescription.ForLoadedType.of(cls3), TypeDescription.ForLoadedType.of(cls)}), CompoundList.of(Collections.singletonList(context.getInstrumentedType()), methodDescription.getParameters().asTypeList(), Arrays.asList(new TypeDescription[]{TypeDescription.ForLoadedType.of(cls2), TypeDescription.ForLoadedType.of(cls3)})));
            methodVisitor2.visitInsn(83);
            methodVisitor2.visitIincInsn(3, 1);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
            methodVisitor2.visitLabel(label4);
            context.getFrameGeneration().chop(methodVisitor2, 1, CompoundList.of(Collections.singletonList(context.getInstrumentedType()), methodDescription.getParameters().asTypeList(), Collections.singletonList(TypeDescription.ForLoadedType.of(cls2))));
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitInsn(Opcodes.ARETURN);
            return new ByteCodeAppender.Size(5, 4);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            FrameTranslator frameTranslator = (FrameTranslator) obj;
            return this.sourceLabel.equals(frameTranslator.sourceLabel) && this.targetLabel.equals(frameTranslator.targetLabel);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.sourceLabel.hashCode()) * 31) + this.targetLabel.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class HandleTranslator implements ByteCodeAppender {
        protected static final String NAME = "handle";
        private final Class<?> sourceHandle;
        private final Class<?> targetHandle;

        protected HandleTranslator(Class<?> cls, Class<?> cls2) {
            this.sourceHandle = cls;
            this.targetHandle = cls2;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Class<String> cls = String.class;
            Label label = new Label();
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(Opcodes.ARETURN);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitTypeInsn(Opcodes.NEW, Type.getInternalName(this.targetHandle));
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(25, 0);
            String internalName = Type.getInternalName(this.sourceHandle);
            Type type = Type.INT_TYPE;
            MethodVisitor methodVisitor2 = methodVisitor;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, internalName, "getTag", Type.getMethodDescriptor(type, new Type[0]), false);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(this.sourceHandle), "getOwner", Type.getMethodDescriptor(Type.getType((Class<?>) cls), new Type[0]), false);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(this.sourceHandle), "getName", Type.getMethodDescriptor(Type.getType((Class<?>) cls), new Type[0]), false);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(this.sourceHandle), "getDesc", Type.getMethodDescriptor(Type.getType((Class<?>) cls), new Type[0]), false);
            methodVisitor.visitVarInsn(25, 0);
            String internalName2 = Type.getInternalName(this.sourceHandle);
            Type type2 = Type.BOOLEAN_TYPE;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, internalName2, "isInterface", Type.getMethodDescriptor(type2, new Type[0]), false);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(this.targetHandle), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, type, Type.getType((Class<?>) cls), Type.getType((Class<?>) cls), Type.getType((Class<?>) cls), type2), false);
            methodVisitor.visitInsn(Opcodes.ARETURN);
            return new ByteCodeAppender.Size(7, 1);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            HandleTranslator handleTranslator = (HandleTranslator) obj;
            return this.sourceHandle.equals(handleTranslator.sourceHandle) && this.targetHandle.equals(handleTranslator.targetHandle);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.sourceHandle.hashCode()) * 31) + this.targetHandle.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class LabelArrayTranslator implements ByteCodeAppender {
        protected static final String NAME = "labels";
        private final Class<?> sourceLabel;
        private final Class<?> targetLabel;

        protected LabelArrayTranslator(Class<?> cls, Class<?> cls2) {
            this.sourceLabel = cls;
            this.targetLabel = cls2;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            MethodVisitor methodVisitor2 = methodVisitor;
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label);
            methodVisitor2.visitInsn(1);
            methodVisitor2.visitInsn(Opcodes.ARETURN);
            methodVisitor2.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor2, CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitInsn(190);
            methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, Type.getInternalName(this.targetLabel));
            methodVisitor2.visitVarInsn(58, 2);
            methodVisitor2.visitInsn(3);
            methodVisitor2.visitVarInsn(54, 3);
            methodVisitor2.visitLabel(label2);
            context.getFrameGeneration().append(methodVisitor2, Arrays.asList(new TypeDescription[]{TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(this.targetLabel)), TypeDescription.ForLoadedType.of(Integer.TYPE)}), CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor2.visitVarInsn(21, 3);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitInsn(190);
            methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPGE, label3);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(21, 3);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(21, 3);
            methodVisitor2.visitInsn(50);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, context.getInstrumentedType().getInternalName(), "label", Type.getMethodDescriptor(Type.getType(this.targetLabel), Type.getType(this.sourceLabel)), false);
            methodVisitor2.visitInsn(83);
            methodVisitor2.visitIincInsn(3, 1);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
            methodVisitor2.visitLabel(label3);
            context.getFrameGeneration().chop(methodVisitor2, 1, CompoundList.of(Collections.singletonList(context.getInstrumentedType()), methodDescription.getParameters().asTypeList(), Collections.singletonList(TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(this.targetLabel)))));
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitInsn(Opcodes.ARETURN);
            return new ByteCodeAppender.Size(5, 4);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LabelArrayTranslator labelArrayTranslator = (LabelArrayTranslator) obj;
            return this.sourceLabel.equals(labelArrayTranslator.sourceLabel) && this.targetLabel.equals(labelArrayTranslator.targetLabel);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.sourceLabel.hashCode()) * 31) + this.targetLabel.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class LabelTranslator implements ByteCodeAppender {
        protected static final String NAME = "label";
        private final Class<?> target;

        protected LabelTranslator(Class<?> cls) {
            this.target = cls;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            MethodVisitor methodVisitor2 = methodVisitor;
            Class<Object> cls = Object.class;
            Label label = new Label();
            Label label2 = new Label();
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label);
            methodVisitor2.visitInsn(1);
            methodVisitor2.visitInsn(Opcodes.ARETURN);
            methodVisitor2.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor2, CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitFieldInsn(Opcodes.GETFIELD, context.getInstrumentedType().getInternalName(), ClassVisitorFactory.LABELS, Type.getDescriptor(Map.class));
            methodVisitor2.visitVarInsn(25, 1);
            String internalName = Type.getInternalName(Map.class);
            String methodDescriptor = Type.getMethodDescriptor(Type.getType((Class<?>) cls), Type.getType((Class<?>) cls));
            String str = ClassVisitorFactory.LABELS;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, internalName, "get", methodDescriptor, true);
            methodVisitor2.visitTypeInsn(192, Type.getInternalName(this.target));
            methodVisitor2.visitVarInsn(58, 2);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label2);
            methodVisitor2.visitTypeInsn(Opcodes.NEW, Type.getInternalName(this.target));
            methodVisitor2.visitInsn(89);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(this.target), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", false);
            methodVisitor2.visitVarInsn(58, 2);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitFieldInsn(Opcodes.GETFIELD, context.getInstrumentedType().getInternalName(), str, Type.getDescriptor(Map.class));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            MethodVisitor methodVisitor3 = methodVisitor;
            methodVisitor3.visitMethodInsn(Opcodes.INVOKEINTERFACE, Type.getInternalName(Map.class), "put", Type.getMethodDescriptor(Type.getType((Class<?>) cls), Type.getType((Class<?>) cls), Type.getType((Class<?>) cls)), true);
            methodVisitor2.visitInsn(87);
            methodVisitor2.visitLabel(label2);
            context.getFrameGeneration().append(methodVisitor2, Collections.singletonList(TypeDescription.ForLoadedType.of(this.target)), CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitInsn(Opcodes.ARETURN);
            return new ByteCodeAppender.Size(3, 3);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.target.equals(((LabelTranslator) obj).target);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.target.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class NullCheckedConstruction implements ByteCodeAppender {
        private final Class<?> type;

        protected NullCheckedConstruction(Class<?> cls) {
            this.type = cls;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            methodVisitor.visitVarInsn(25, 0);
            Label label = new Label();
            methodVisitor.visitJumpInsn(Opcodes.IFNULL, label);
            methodVisitor.visitTypeInsn(Opcodes.NEW, context.getInstrumentedType().getInternalName());
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, context.getInstrumentedType().getInternalName(), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(this.type)), false);
            methodVisitor.visitInsn(Opcodes.ARETURN);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(Opcodes.ARETURN);
            return new ByteCodeAppender.Size(3, 1);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.type.equals(((NullCheckedConstruction) obj).type);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.type.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class TypePathTranslator implements ByteCodeAppender {
        protected static final String NAME = "typePath";
        private final Class<?> sourceTypePath;
        private final Class<?> targetTypePath;

        protected TypePathTranslator(Class<?> cls, Class<?> cls2) {
            this.sourceTypePath = cls;
            this.targetTypePath = cls2;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Class<String> cls = String.class;
            Label label = new Label();
            Label label2 = new Label();
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
            methodVisitor.visitInsn(1);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitLabel(label);
            methodVisitor.visitVarInsn(25, 0);
            MethodVisitor methodVisitor2 = methodVisitor;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(this.sourceTypePath), "toString", Type.getMethodDescriptor(Type.getType((Class<?>) cls), new Type[0]), false);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(this.targetTypePath), "fromString", Type.getMethodDescriptor(Type.getType(this.targetTypePath), Type.getType((Class<?>) cls)), false);
            methodVisitor.visitLabel(label2);
            context.getFrameGeneration().same1(methodVisitor, TypeDescription.ForLoadedType.of(this.targetTypePath), methodDescription.getParameters().asTypeList());
            methodVisitor.visitInsn(Opcodes.ARETURN);
            return new ByteCodeAppender.Size(1, 2);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TypePathTranslator typePathTranslator = (TypePathTranslator) obj;
            return this.sourceTypePath.equals(typePathTranslator.sourceTypePath) && this.targetTypePath.equals(typePathTranslator.targetTypePath);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.sourceTypePath.hashCode()) * 31) + this.targetTypePath.hashCode();
        }
    }

    static {
        boolean z10 = false;
        try {
            Class.forName("java.security.AccessController", false, (ClassLoader) null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            return;
        } catch (ClassNotFoundException unused) {
        } catch (SecurityException unused2) {
            z10 = true;
        }
        ACCESS_CONTROLLER = z10;
    }

    protected ClassVisitorFactory(Class<?> cls) {
        this.type = cls;
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static <S> ClassVisitorFactory<S> of(Class<S> cls) {
        return of(cls, new ByteBuddy().with(TypeValidation.DISABLED));
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [java.lang.reflect.Type, java.lang.Class<?>, java.lang.Class] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.bytebuddy.dynamic.DynamicType toAttributeWrapper(net.bytebuddy.dynamic.DynamicType.Builder<?> r11, java.lang.Class<?> r12, java.lang.Class<?> r13, net.bytebuddy.description.type.TypeDescription r14, net.bytebuddy.description.type.TypeDescription r15) throws java.lang.Exception {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = 2
            net.bytebuddy.description.modifier.ModifierContributor$ForField[] r2 = new net.bytebuddy.description.modifier.ModifierContributor.ForField[r1]
            net.bytebuddy.description.modifier.Visibility r3 = net.bytebuddy.description.modifier.Visibility.PUBLIC
            r4 = 0
            r2[r4] = r3
            net.bytebuddy.description.modifier.FieldManifestation r5 = net.bytebuddy.description.modifier.FieldManifestation.FINAL
            r6 = 1
            r2[r6] = r5
            java.lang.String r5 = "delegate"
            net.bytebuddy.dynamic.DynamicType$Builder$FieldDefinition$Optional$Valuable r11 = r11.defineField((java.lang.String) r5, (java.lang.reflect.Type) r13, (net.bytebuddy.description.modifier.ModifierContributor.ForField[]) r2)
            net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r2 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r6]
            r2[r4] = r3
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r11 = r11.defineConstructor((net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r2)
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r6]
            r2[r4] = r13
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r11 = r11.withParameters((java.lang.reflect.Type[]) r2)
            java.lang.Class[] r2 = new java.lang.Class[r6]
            r2[r4] = r0
            java.lang.reflect.Constructor r2 = r12.getDeclaredConstructor(r2)
            net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r2 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Constructor<?>) r2)
            net.bytebuddy.implementation.MethodCall r2 = r2.onSuper()
            net.bytebuddy.implementation.bytecode.StackManipulation$Compound r7 = new net.bytebuddy.implementation.bytecode.StackManipulation$Compound
            net.bytebuddy.implementation.bytecode.StackManipulation[] r8 = new net.bytebuddy.implementation.bytecode.StackManipulation[r1]
            net.bytebuddy.implementation.bytecode.member.MethodVariableAccess r9 = net.bytebuddy.implementation.bytecode.member.MethodVariableAccess.REFERENCE
            net.bytebuddy.implementation.bytecode.StackManipulation r9 = r9.loadFrom(r6)
            r8[r4] = r9
            net.bytebuddy.description.field.FieldDescription$ForLoadedField r9 = new net.bytebuddy.description.field.FieldDescription$ForLoadedField
            java.lang.String r10 = "type"
            java.lang.reflect.Field r10 = r13.getField(r10)
            r9.<init>(r10)
            net.bytebuddy.implementation.bytecode.member.FieldAccess$Defined r9 = net.bytebuddy.implementation.bytecode.member.FieldAccess.forField((net.bytebuddy.description.field.FieldDescription.InDefinedShape) r9)
            net.bytebuddy.implementation.bytecode.StackManipulation r9 = r9.read()
            r8[r6] = r9
            r7.<init>((net.bytebuddy.implementation.bytecode.StackManipulation[]) r8)
            net.bytebuddy.implementation.MethodCall r0 = r2.with((net.bytebuddy.implementation.bytecode.StackManipulation) r7, (java.lang.reflect.Type) r0)
            net.bytebuddy.implementation.FieldAccessor$OwnerTypeLocatable r2 = net.bytebuddy.implementation.FieldAccessor.ofField(r5)
            net.bytebuddy.implementation.Implementation$Composable r2 = r2.setsArgumentAt(r4)
            net.bytebuddy.implementation.Implementation$Composable r0 = r0.andThen((net.bytebuddy.implementation.Implementation.Composable) r2)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r11 = r11.intercept(r0)
            net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r0 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r1]
            r0[r4] = r3
            net.bytebuddy.description.modifier.Ownership r1 = net.bytebuddy.description.modifier.Ownership.STATIC
            r0[r6] = r1
            java.lang.String r1 = "attribute"
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r11 = r11.defineMethod((java.lang.String) r1, (java.lang.reflect.Type) r12, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r0)
            java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r6]
            r0[r4] = r13
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r11 = r11.withParameters((java.lang.reflect.Type[]) r0)
            net.bytebuddy.implementation.Implementation$Simple r0 = new net.bytebuddy.implementation.Implementation$Simple
            net.bytebuddy.implementation.bytecode.ByteCodeAppender[] r1 = new net.bytebuddy.implementation.bytecode.ByteCodeAppender[r6]
            net.bytebuddy.asm.ClassVisitorFactory$AttributeTranslator r2 = new net.bytebuddy.asm.ClassVisitorFactory$AttributeTranslator
            r2.<init>(r12, r13, r14, r15)
            r1[r4] = r2
            r0.<init>((net.bytebuddy.implementation.bytecode.ByteCodeAppender[]) r1)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r11 = r11.intercept(r0)
            net.bytebuddy.matcher.ElementMatcher$Junction r12 = net.bytebuddy.matcher.ElementMatchers.isProtected()
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r11 = r11.method(r12)
            java.lang.Class<java.lang.UnsupportedOperationException> r12 = java.lang.UnsupportedOperationException.class
            net.bytebuddy.implementation.Implementation r12 = net.bytebuddy.implementation.ExceptionMethod.throwing((java.lang.Class<? extends java.lang.Throwable>) r12)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r11 = r11.intercept(r12)
            java.lang.String r12 = "isUnknown"
            net.bytebuddy.matcher.ElementMatcher$Junction r14 = net.bytebuddy.matcher.ElementMatchers.named(r12)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r11 = r11.method(r14)
            java.lang.Class[] r14 = new java.lang.Class[r4]
            java.lang.reflect.Method r12 = r13.getMethod(r12, r14)
            net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r12 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r12)
            net.bytebuddy.implementation.MethodCall r12 = r12.onField((java.lang.String) r5)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r11 = r11.intercept(r12)
            java.lang.String r12 = "isCodeAttribute"
            net.bytebuddy.matcher.ElementMatcher$Junction r14 = net.bytebuddy.matcher.ElementMatchers.named(r12)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r11 = r11.method(r14)
            java.lang.Class[] r14 = new java.lang.Class[r4]
            java.lang.reflect.Method r12 = r13.getMethod(r12, r14)
            net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r12 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r12)
            net.bytebuddy.implementation.MethodCall r12 = r12.onField((java.lang.String) r5)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r11 = r11.intercept(r12)
            net.bytebuddy.dynamic.DynamicType$Unloaded r11 = r11.make()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.ClassVisitorFactory.toAttributeWrapper(net.bytebuddy.dynamic.DynamicType$Builder, java.lang.Class, java.lang.Class, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDescription):net.bytebuddy.dynamic.DynamicType");
    }

    /* access modifiers changed from: private */
    public static MethodCall.ArgumentLoader.Factory toConvertedParameter(TypeDescription typeDescription, Class<?> cls, String str, int i10, boolean z10) {
        StackManipulation stackManipulation;
        StackManipulation[] stackManipulationArr = new StackManipulation[3];
        if (z10) {
            stackManipulation = MethodVariableAccess.loadThis();
        } else {
            stackManipulation = StackManipulation.Trivial.INSTANCE;
        }
        stackManipulationArr[0] = stackManipulation;
        stackManipulationArr[1] = MethodVariableAccess.REFERENCE.loadFrom(i10);
        stackManipulationArr[2] = MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) typeDescription.getDeclaredMethods().filter(ElementMatchers.named(str))).getOnly());
        return new MethodCall.ArgumentLoader.ForStackManipulation((StackManipulation) new StackManipulation.Compound(stackManipulationArr), (java.lang.reflect.Type) cls);
    }

    /* access modifiers changed from: private */
    public static DynamicType.Builder<?> toMethodVisitorBuilder(ByteBuddy byteBuddy, Class<?> cls, Class<?> cls2, @MaybeNull Class<?> cls3, @MaybeNull Class<?> cls4, @MaybeNull Class<?> cls5, @MaybeNull Class<?> cls6, @MaybeNull Class<?> cls7, @MaybeNull Class<?> cls8, @MaybeNull Class<?> cls9, @MaybeNull Class<?> cls10, @MaybeNull Class<?> cls11, @MaybeNull Class<?> cls12) throws Exception {
        Class<?> cls13 = cls5;
        Class<?> cls14 = cls6;
        Class<?> cls15 = cls9;
        Class<?> cls16 = cls10;
        Class<?> cls17 = cls11;
        Class<?> cls18 = cls12;
        java.lang.reflect.Type type2 = Object.class;
        java.lang.reflect.Type type3 = Object[].class;
        ByteBuddy byteBuddy2 = byteBuddy;
        Class<?> cls19 = cls;
        Class<?> cls20 = cls2;
        Class<?> cls21 = cls3;
        Class<?> cls22 = cls4;
        DynamicType.Builder visitorBuilder = toVisitorBuilder(byteBuddy2, cls19, cls20, cls21, cls22, FieldAccessor.ofField(LABELS).setsValue((StackManipulation) new StackManipulation.Compound(TypeCreation.of(TypeDescription.ForLoadedType.of(HashMap.class)), Duplication.SINGLE, MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(HashMap.class).getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments(0)))).getOnly())), (java.lang.reflect.Type) Map.class));
        if (!(cls13 == null || cls14 == null)) {
            Visibility visibility = Visibility.PRIVATE;
            visitorBuilder = visitorBuilder.defineField(LABELS, (java.lang.reflect.Type) Map.class, visibility, FieldManifestation.FINAL).defineMethod("label", (java.lang.reflect.Type) cls14, visibility).withParameters(cls13).intercept(new Implementation.Simple(new LabelTranslator(cls14))).defineMethod(LABELS, (TypeDefinition) TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(cls6)), visibility).withParameters(TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(cls5))).intercept(new Implementation.Simple(new LabelArrayTranslator(cls13, cls14))).defineMethod("frames", type3, visibility).withParameters(type3).intercept(new Implementation.Simple(new FrameTranslator(cls13, cls14)));
        }
        if (!(cls15 == null || cls16 == null)) {
            visitorBuilder = visitorBuilder.defineMethod("handle", (java.lang.reflect.Type) cls16, Visibility.PRIVATE, Ownership.STATIC).withParameters(cls15).intercept(new Implementation.Simple(new HandleTranslator(cls15, cls16)));
        }
        if (!(cls17 == null || cls18 == null || cls15 == null || cls16 == null)) {
            visitorBuilder = visitorBuilder.defineMethod("constantDyanmic", (java.lang.reflect.Type) cls18, Visibility.PRIVATE, Ownership.STATIC).withParameters(cls17).intercept(new Implementation.Simple(new ConstantDynamicTranslator(cls17, cls18, cls15, cls16)));
        }
        Visibility visibility2 = Visibility.PRIVATE;
        Ownership ownership = Ownership.STATIC;
        return visitorBuilder.defineMethod("constant", type2, visibility2, ownership).withParameters(type2).intercept(new Implementation.Simple(new ConstantTranslator(cls9, cls10, cls7, cls8, cls11, cls12))).defineMethod("constants", type3, visibility2, ownership).withParameters(type3).intercept(new Implementation.Simple(new ConstantArrayTranslator()));
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [java.lang.reflect.Type, java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r13v0, types: [java.lang.reflect.Type, java.lang.Class<?>, java.lang.Class] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.bytebuddy.dynamic.DynamicType.Builder<?> toVisitorBuilder(net.bytebuddy.ByteBuddy r9, java.lang.Class<?> r10, java.lang.Class<?> r11, @net.bytebuddy.utility.nullability.MaybeNull java.lang.Class<?> r12, @net.bytebuddy.utility.nullability.MaybeNull java.lang.Class<?> r13, net.bytebuddy.implementation.Implementation r14) throws java.lang.Exception {
        /*
            net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy$Default r0 = net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.NO_CONSTRUCTORS
            net.bytebuddy.dynamic.DynamicType$Builder r9 = r9.subclass(r10, (net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy) r0)
            r0 = 2
            net.bytebuddy.description.modifier.ModifierContributor$ForField[] r1 = new net.bytebuddy.description.modifier.ModifierContributor.ForField[r0]
            net.bytebuddy.description.modifier.Visibility r2 = net.bytebuddy.description.modifier.Visibility.PRIVATE
            r3 = 0
            r1[r3] = r2
            net.bytebuddy.description.modifier.FieldManifestation r4 = net.bytebuddy.description.modifier.FieldManifestation.FINAL
            r5 = 1
            r1[r5] = r4
            java.lang.String r4 = "delegate"
            net.bytebuddy.dynamic.DynamicType$Builder$FieldDefinition$Optional$Valuable r9 = r9.defineField((java.lang.String) r4, (java.lang.reflect.Type) r11, (net.bytebuddy.description.modifier.ModifierContributor.ForField[]) r1)
            net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r1 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r5]
            net.bytebuddy.description.modifier.Visibility r6 = net.bytebuddy.description.modifier.Visibility.PUBLIC
            r1[r3] = r6
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r9 = r9.defineConstructor((net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r1)
            java.lang.reflect.Type[] r1 = new java.lang.reflect.Type[r5]
            r1[r3] = r11
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r9 = r9.withParameters((java.lang.reflect.Type[]) r1)
            java.lang.Class[] r1 = new java.lang.Class[r5]
            java.lang.Class r7 = java.lang.Integer.TYPE
            r1[r3] = r7
            java.lang.reflect.Constructor r1 = r10.getDeclaredConstructor(r1)
            net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r1 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Constructor<?>) r1)
            java.lang.Object[] r7 = new java.lang.Object[r5]
            int r8 = net.bytebuddy.utility.OpenedClassReader.ASM_API
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7[r3] = r8
            net.bytebuddy.implementation.MethodCall r1 = r1.with((java.lang.Object[]) r7)
            net.bytebuddy.implementation.FieldAccessor$OwnerTypeLocatable r4 = net.bytebuddy.implementation.FieldAccessor.ofField(r4)
            net.bytebuddy.implementation.Implementation$Composable r4 = r4.setsArgumentAt(r3)
            net.bytebuddy.implementation.Implementation$Composable r1 = r1.andThen((net.bytebuddy.implementation.Implementation.Composable) r4)
            net.bytebuddy.implementation.Implementation r14 = r1.andThen((net.bytebuddy.implementation.Implementation) r14)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r9 = r9.intercept(r14)
            net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r14 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r0]
            r14[r3] = r6
            net.bytebuddy.description.modifier.Ownership r1 = net.bytebuddy.description.modifier.Ownership.STATIC
            r14[r5] = r1
            java.lang.String r4 = "wrap"
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r9 = r9.defineMethod((java.lang.String) r4, (java.lang.reflect.Type) r10, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r14)
            java.lang.reflect.Type[] r10 = new java.lang.reflect.Type[r5]
            r10[r3] = r11
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r9 = r9.withParameters((java.lang.reflect.Type[]) r10)
            net.bytebuddy.implementation.Implementation$Simple r10 = new net.bytebuddy.implementation.Implementation$Simple
            net.bytebuddy.implementation.bytecode.ByteCodeAppender[] r14 = new net.bytebuddy.implementation.bytecode.ByteCodeAppender[r5]
            net.bytebuddy.asm.ClassVisitorFactory$NullCheckedConstruction r4 = new net.bytebuddy.asm.ClassVisitorFactory$NullCheckedConstruction
            r4.<init>(r11)
            r14[r3] = r4
            r10.<init>((net.bytebuddy.implementation.bytecode.ByteCodeAppender[]) r14)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r9 = r9.intercept(r10)
            if (r12 == 0) goto L_0x00ae
            if (r13 != 0) goto L_0x0088
            goto L_0x00ae
        L_0x0088:
            net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r10 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r0]
            r10[r3] = r2
            r10[r5] = r1
            java.lang.String r11 = "typePath"
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r9 = r9.defineMethod((java.lang.String) r11, (java.lang.reflect.Type) r13, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r10)
            java.lang.reflect.Type[] r10 = new java.lang.reflect.Type[r5]
            r10[r3] = r12
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r9 = r9.withParameters((java.lang.reflect.Type[]) r10)
            net.bytebuddy.implementation.Implementation$Simple r10 = new net.bytebuddy.implementation.Implementation$Simple
            net.bytebuddy.implementation.bytecode.ByteCodeAppender[] r11 = new net.bytebuddy.implementation.bytecode.ByteCodeAppender[r5]
            net.bytebuddy.asm.ClassVisitorFactory$TypePathTranslator r14 = new net.bytebuddy.asm.ClassVisitorFactory$TypePathTranslator
            r14.<init>(r12, r13)
            r11[r3] = r14
            r10.<init>((net.bytebuddy.implementation.bytecode.ByteCodeAppender[]) r11)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r9 = r9.intercept(r10)
        L_0x00ae:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.ClassVisitorFactory.toVisitorBuilder(net.bytebuddy.ByteBuddy, java.lang.Class, java.lang.Class, java.lang.Class, java.lang.Class, net.bytebuddy.implementation.Implementation):net.bytebuddy.dynamic.DynamicType$Builder");
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.type.equals(((ClassVisitorFactory) obj).type);
    }

    public Class<?> getType() {
        return this.type;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.type.hashCode();
    }

    public abstract ClassVisitor unwrap(T t10);

    public abstract T wrap(ClassVisitor classVisitor);

    public static <S> ClassVisitorFactory<S> of(Class<S> cls, ByteBuddy byteBuddy) {
        return (ClassVisitorFactory) doPrivileged(new CreateClassVisitorFactory(cls, byteBuddy));
    }
}
