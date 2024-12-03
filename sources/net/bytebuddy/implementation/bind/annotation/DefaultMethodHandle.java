package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.nullability.MaybeNull;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultMethodHandle {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<DefaultMethodHandle> {
        INSTANCE;
        
        private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE = null;
        private static final MethodDescription.InDefinedShape TARGET_TYPE = null;

        protected interface MethodLocator {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForExplicitType implements MethodLocator {
                private final TypeDescription typeDescription;

                protected ForExplicitType(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForExplicitType) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }

                public Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription) {
                    if (this.typeDescription.isInterface()) {
                        return target.invokeDefault(methodDescription.asSignatureToken(), TargetType.resolve(this.typeDescription, target.getInstrumentedType()));
                    }
                    throw new IllegalStateException(methodDescription + " method carries default method call parameter on non-interface type");
                }
            }

            public enum ForImplicitType implements MethodLocator {
                INSTANCE;

                public Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription) {
                    return target.invokeDefault(methodDescription.asSignatureToken());
                }
            }

            Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription);
        }

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(DefaultMethodHandle.class).getDeclaredMethods();
            TARGET_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("targetType"))).getOnly();
            NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("nullIfImpossible"))).getOnly();
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<DefaultMethodHandle> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            MethodLocator methodLocator;
            Class<Boolean> cls = Boolean.class;
            if (!parameterDescription.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                throw new IllegalStateException("Cannot assign MethodHandle type to " + parameterDescription);
            } else if (methodDescription.isMethod()) {
                TypeDescription typeDescription = (TypeDescription) loadable.getValue(TARGET_TYPE).resolve(TypeDescription.class);
                if (typeDescription.represents(Void.TYPE)) {
                    methodLocator = MethodLocator.ForImplicitType.INSTANCE;
                } else {
                    methodLocator = new MethodLocator.ForExplicitType(typeDescription);
                }
                Implementation.SpecialMethodInvocation withCheckedCompatibilityTo = methodLocator.resolve(target, methodDescription).withCheckedCompatibilityTo(methodDescription.asTypeToken());
                if (withCheckedCompatibilityTo.isValid()) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(withCheckedCompatibilityTo.toMethodHandle().toStackManipulation());
                }
                if (((Boolean) loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(cls)).booleanValue()) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE);
                }
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            } else if (((Boolean) loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(cls)).booleanValue()) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE);
            } else {
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            }
        }

        public Class<DefaultMethodHandle> getHandledType() {
            return DefaultMethodHandle.class;
        }
    }

    boolean nullIfImpossible() default false;

    Class<?> targetType() default void.class;
}
