package net.bytebuddy.implementation.bytecode.member;

import java.util.Collection;
import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.beanutils.PropertyUtils;

public enum MethodInvocation {
    VIRTUAL(Opcodes.INVOKEVIRTUAL, 5, Opcodes.INVOKEVIRTUAL, 5),
    INTERFACE(Opcodes.INVOKEINTERFACE, 9, Opcodes.INVOKEINTERFACE, 9),
    STATIC(Opcodes.INVOKESTATIC, 6, Opcodes.INVOKESTATIC, 6),
    SPECIAL(Opcodes.INVOKESPECIAL, 7, Opcodes.INVOKESPECIAL, 7),
    SPECIAL_CONSTRUCTOR(Opcodes.INVOKESPECIAL, 8, Opcodes.INVOKESPECIAL, 8),
    VIRTUAL_PRIVATE(Opcodes.INVOKEVIRTUAL, 5, Opcodes.INVOKESPECIAL, 7),
    INTERFACE_PRIVATE(Opcodes.INVOKEINTERFACE, 9, Opcodes.INVOKESPECIAL, 7);
    
    /* access modifiers changed from: private */
    public final int handle;
    /* access modifiers changed from: private */
    public final int legacyHandle;
    /* access modifiers changed from: private */
    public final int legacyOpcode;
    /* access modifiers changed from: private */
    public final int opcode;

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    protected class DynamicInvocation extends StackManipulation.AbstractBase {
        private final List<? extends JavaConstant> arguments;
        private final MethodDescription.InDefinedShape bootstrapMethod;
        private final String methodName;
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        public DynamicInvocation(String str, TypeDescription typeDescription, List<? extends TypeDescription> list, MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list2) {
            this.methodName = str;
            this.returnType = typeDescription;
            this.parameterTypes = list;
            this.bootstrapMethod = inDefinedShape;
            this.arguments = list2;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            int i10;
            StringBuilder sb2 = new StringBuilder("(");
            for (TypeDescription descriptor : this.parameterTypes) {
                sb2.append(descriptor.getDescriptor());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(this.returnType.getDescriptor());
            String sb3 = sb2.toString();
            Object[] objArr = new Object[this.arguments.size()];
            int i11 = 0;
            for (JavaConstant accept : this.arguments) {
                objArr[i11] = accept.accept(JavaConstantValue.Visitor.INSTANCE);
                i11++;
            }
            String str = this.methodName;
            if (MethodInvocation.this.handle == MethodInvocation.this.legacyHandle || context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V11)) {
                i10 = MethodInvocation.this.handle;
            } else {
                i10 = MethodInvocation.this.legacyHandle;
            }
            methodVisitor.visitInvokeDynamicInsn(str, sb3, new Handle(i10, this.bootstrapMethod.getDeclaringType().getInternalName(), this.bootstrapMethod.getInternalName(), this.bootstrapMethod.getDescriptor(), this.bootstrapMethod.getDeclaringType().isInterface()), objArr);
            int size = this.returnType.getStackSize().getSize() - StackSize.of((Collection<? extends TypeDefinition>) this.parameterTypes);
            return new StackManipulation.Size(size, Math.max(size, 0));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DynamicInvocation dynamicInvocation = (DynamicInvocation) obj;
            return MethodInvocation.this.equals(MethodInvocation.this) && this.methodName.equals(dynamicInvocation.methodName) && this.returnType.equals(dynamicInvocation.returnType) && this.parameterTypes.equals(dynamicInvocation.parameterTypes) && this.bootstrapMethod.equals(dynamicInvocation.bootstrapMethod) && this.arguments.equals(dynamicInvocation.arguments);
        }

        public int hashCode() {
            return (((((((((((getClass().hashCode() * 31) + this.methodName.hashCode()) * 31) + this.returnType.hashCode()) * 31) + this.parameterTypes.hashCode()) * 31) + this.bootstrapMethod.hashCode()) * 31) + this.arguments.hashCode()) * 31) + MethodInvocation.this.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class HandleInvocation extends StackManipulation.AbstractBase {
        private static final String METHOD_HANDLE = "java/lang/invoke/MethodHandle";
        private final MethodDescription.InDefinedShape methodDescription;
        private final HandleType type;

        protected HandleInvocation(MethodDescription.InDefinedShape inDefinedShape, HandleType handleType) {
            this.methodDescription = inDefinedShape;
            this.type = handleType;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            String str;
            String methodName = this.type.getMethodName();
            if (this.methodDescription.isStatic() || this.methodDescription.isConstructor()) {
                str = this.methodDescription.getDescriptor();
            } else {
                str = "(" + this.methodDescription.getDeclaringType().getDescriptor() + this.methodDescription.getDescriptor().substring(1);
            }
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, METHOD_HANDLE, methodName, str, false);
            int size = this.methodDescription.getReturnType().getStackSize().getSize() - (this.methodDescription.getStackSize() + 1);
            return new StackManipulation.Size(size, Math.max(0, size));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            HandleInvocation handleInvocation = (HandleInvocation) obj;
            return this.type.equals(handleInvocation.type) && this.methodDescription.equals(handleInvocation.methodDescription);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.type.hashCode();
        }
    }

    public enum HandleType {
        EXACT("invokeExact"),
        REGULAR("invoke");
        
        private final String methodName;

        private HandleType(String str) {
            this.methodName = str;
        }

        /* access modifiers changed from: protected */
        public String getMethodName() {
            return this.methodName;
        }
    }

    protected enum IllegalInvocation implements WithImplicitInvocationTargetType {
        INSTANCE;

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return StackManipulation.Illegal.INSTANCE.apply(methodVisitor, context);
        }

        public StackManipulation dynamic(String str, TypeDescription typeDescription, List<? extends TypeDescription> list, List<? extends JavaConstant> list2) {
            return StackManipulation.Illegal.INSTANCE;
        }

        public boolean isValid() {
            return false;
        }

        public StackManipulation onHandle(HandleType handleType) {
            return StackManipulation.Illegal.INSTANCE;
        }

        public StackManipulation special(TypeDescription typeDescription) {
            return StackManipulation.Illegal.INSTANCE;
        }

        public StackManipulation virtual(TypeDescription typeDescription) {
            return StackManipulation.Illegal.INSTANCE;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    protected class Invocation extends StackManipulation.AbstractBase implements WithImplicitInvocationTargetType {
        private final MethodDescription.InDefinedShape methodDescription;
        private final TypeDescription typeDescription;

        protected Invocation(MethodInvocation methodInvocation, MethodDescription.InDefinedShape inDefinedShape) {
            this(inDefinedShape, inDefinedShape.getDeclaringType());
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            int i10;
            if (MethodInvocation.this.opcode == MethodInvocation.this.legacyOpcode || context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V11)) {
                i10 = MethodInvocation.this.opcode;
            } else {
                i10 = MethodInvocation.this.legacyOpcode;
            }
            methodVisitor.visitMethodInsn(i10, this.typeDescription.getInternalName(), this.methodDescription.getInternalName(), this.methodDescription.getDescriptor(), this.typeDescription.isInterface());
            int size = this.methodDescription.getReturnType().getStackSize().getSize() - this.methodDescription.getStackSize();
            return new StackManipulation.Size(size, Math.max(0, size));
        }

        public StackManipulation dynamic(String str, TypeDescription typeDescription2, List<? extends TypeDescription> list, List<? extends JavaConstant> list2) {
            if (!this.methodDescription.isInvokeBootstrap(TypeList.Explicit.of(list2))) {
                return StackManipulation.Illegal.INSTANCE;
            }
            return new DynamicInvocation(str, typeDescription2, new TypeList.Explicit(list), (MethodDescription.InDefinedShape) this.methodDescription.asDefined(), list2);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Invocation invocation = (Invocation) obj;
            return MethodInvocation.this.equals(MethodInvocation.this) && this.typeDescription.equals(invocation.typeDescription) && this.methodDescription.equals(invocation.methodDescription);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + this.methodDescription.hashCode()) * 31) + MethodInvocation.this.hashCode();
        }

        public StackManipulation onHandle(HandleType handleType) {
            return new HandleInvocation(this.methodDescription, handleType);
        }

        public StackManipulation special(TypeDescription typeDescription2) {
            if (!this.methodDescription.isSpecializableFor(typeDescription2)) {
                return StackManipulation.Illegal.INSTANCE;
            }
            MethodInvocation methodInvocation = MethodInvocation.SPECIAL;
            methodInvocation.getClass();
            return new Invocation(this.methodDescription, typeDescription2);
        }

        public StackManipulation virtual(TypeDescription typeDescription2) {
            if (this.methodDescription.isConstructor() || this.methodDescription.isStatic()) {
                return StackManipulation.Illegal.INSTANCE;
            }
            if (this.methodDescription.isPrivate()) {
                if (this.methodDescription.getDeclaringType().equals(typeDescription2)) {
                    return this;
                }
                return StackManipulation.Illegal.INSTANCE;
            } else if (!typeDescription2.isInterface()) {
                MethodInvocation methodInvocation = MethodInvocation.VIRTUAL;
                methodInvocation.getClass();
                return new Invocation(this.methodDescription, typeDescription2);
            } else if (this.methodDescription.getDeclaringType().represents(Object.class)) {
                return this;
            } else {
                MethodInvocation methodInvocation2 = MethodInvocation.INTERFACE;
                methodInvocation2.getClass();
                return new Invocation(this.methodDescription, typeDescription2);
            }
        }

        protected Invocation(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription2) {
            this.typeDescription = typeDescription2;
            this.methodDescription = inDefinedShape;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class OfGenericMethod implements WithImplicitInvocationTargetType {
        private final WithImplicitInvocationTargetType invocation;
        private final TypeDescription targetType;

        protected OfGenericMethod(TypeDescription typeDescription, WithImplicitInvocationTargetType withImplicitInvocationTargetType) {
            this.targetType = typeDescription;
            this.invocation = withImplicitInvocationTargetType;
        }

        protected static WithImplicitInvocationTargetType of(MethodDescription methodDescription, WithImplicitInvocationTargetType withImplicitInvocationTargetType) {
            return new OfGenericMethod(methodDescription.getReturnType().asErasure(), withImplicitInvocationTargetType);
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return new StackManipulation.Compound(this.invocation, TypeCasting.to(this.targetType)).apply(methodVisitor, context);
        }

        public StackManipulation dynamic(String str, TypeDescription typeDescription, List<? extends TypeDescription> list, List<? extends JavaConstant> list2) {
            return this.invocation.dynamic(str, typeDescription, list, list2);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OfGenericMethod ofGenericMethod = (OfGenericMethod) obj;
            return this.targetType.equals(ofGenericMethod.targetType) && this.invocation.equals(ofGenericMethod.invocation);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31) + this.invocation.hashCode();
        }

        public boolean isValid() {
            return this.invocation.isValid();
        }

        public StackManipulation onHandle(HandleType handleType) {
            return new StackManipulation.Compound(this.invocation.onHandle(handleType), TypeCasting.to(this.targetType));
        }

        public StackManipulation special(TypeDescription typeDescription) {
            return new StackManipulation.Compound(this.invocation.special(typeDescription), TypeCasting.to(this.targetType));
        }

        public StackManipulation virtual(TypeDescription typeDescription) {
            return new StackManipulation.Compound(this.invocation.virtual(typeDescription), TypeCasting.to(this.targetType));
        }
    }

    public interface WithImplicitInvocationTargetType extends StackManipulation {
        StackManipulation dynamic(String str, TypeDescription typeDescription, List<? extends TypeDescription> list, List<? extends JavaConstant> list2);

        StackManipulation onHandle(HandleType handleType);

        StackManipulation special(TypeDescription typeDescription);

        StackManipulation virtual(TypeDescription typeDescription);
    }

    private MethodInvocation(int i10, int i11, int i12, int i13) {
        this.opcode = i10;
        this.handle = i11;
        this.legacyOpcode = i12;
        this.legacyHandle = i13;
    }

    public static WithImplicitInvocationTargetType invoke(MethodDescription.InDefinedShape inDefinedShape) {
        if (inDefinedShape.isTypeInitializer()) {
            return IllegalInvocation.INSTANCE;
        }
        if (inDefinedShape.isStatic()) {
            MethodInvocation methodInvocation = STATIC;
            methodInvocation.getClass();
            return new Invocation(methodInvocation, inDefinedShape);
        } else if (inDefinedShape.isConstructor()) {
            MethodInvocation methodInvocation2 = SPECIAL_CONSTRUCTOR;
            methodInvocation2.getClass();
            return new Invocation(methodInvocation2, inDefinedShape);
        } else if (inDefinedShape.isPrivate()) {
            MethodInvocation methodInvocation3 = inDefinedShape.getDeclaringType().isInterface() ? INTERFACE_PRIVATE : VIRTUAL_PRIVATE;
            methodInvocation3.getClass();
            return new Invocation(methodInvocation3, inDefinedShape);
        } else if (inDefinedShape.getDeclaringType().isInterface()) {
            MethodInvocation methodInvocation4 = INTERFACE;
            methodInvocation4.getClass();
            return new Invocation(methodInvocation4, inDefinedShape);
        } else {
            MethodInvocation methodInvocation5 = VIRTUAL;
            methodInvocation5.getClass();
            return new Invocation(methodInvocation5, inDefinedShape);
        }
    }

    public static StackManipulation lookup() {
        return invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(JavaType.METHOD_HANDLES.getTypeStub(), new MethodDescription.Token("lookup", 9, JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType())));
    }

    public static WithImplicitInvocationTargetType invoke(MethodDescription methodDescription) {
        MethodDescription.InDefinedShape inDefinedShape = (MethodDescription.InDefinedShape) methodDescription.asDefined();
        if (inDefinedShape.getReturnType().asErasure().equals(methodDescription.getReturnType().asErasure())) {
            return invoke(inDefinedShape);
        }
        return OfGenericMethod.of(methodDescription, invoke(inDefinedShape));
    }
}
