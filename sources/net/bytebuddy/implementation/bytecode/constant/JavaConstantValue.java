package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.beanutils.PropertyUtils;

@HashCodeAndEqualsPlugin.Enhance
public class JavaConstantValue extends StackManipulation.AbstractBase {
    private final JavaConstant constant;

    public enum Visitor implements JavaConstant.Visitor<Object> {
        INSTANCE;

        public Object onValue(JavaConstant.Simple<?> simple) {
            return simple.getValue();
        }

        public ConstantDynamic onDynamic(JavaConstant.Dynamic dynamic) {
            int size = dynamic.getArguments().size();
            Object[] objArr = new Object[size];
            for (int i10 = 0; i10 < size; i10++) {
                objArr[i10] = dynamic.getArguments().get(i10).accept(this);
            }
            return new ConstantDynamic(dynamic.getName(), dynamic.getTypeDescription().getDescriptor(), onMethodHandle(dynamic.getBootstrap()), objArr);
        }

        public Handle onMethodHandle(JavaConstant.MethodHandle methodHandle) {
            return new Handle(methodHandle.getHandleType().getIdentifier(), methodHandle.getOwnerType().getInternalName(), methodHandle.getName(), methodHandle.getDescriptor(), methodHandle.getOwnerType().isInterface());
        }

        public Type onMethodType(JavaConstant.MethodType methodType) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PropertyUtils.MAPPED_DELIM);
            for (TypeDescription descriptor : methodType.getParameterTypes()) {
                sb2.append(descriptor.getDescriptor());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(methodType.getReturnType().getDescriptor());
            return Type.getMethodType(sb2.toString());
        }

        public Type onType(JavaConstant.Simple<TypeDescription> simple) {
            return Type.getType(simple.getValue().getDescriptor());
        }
    }

    public JavaConstantValue(JavaConstant javaConstant) {
        this.constant = javaConstant;
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitLdcInsn(this.constant.accept(Visitor.INSTANCE));
        return this.constant.getTypeDescription().getStackSize().toIncreasingSize();
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.constant.equals(((JavaConstantValue) obj).constant);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.constant.hashCode();
    }
}
