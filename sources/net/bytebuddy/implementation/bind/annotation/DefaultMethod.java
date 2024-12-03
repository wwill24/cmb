package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultMethod {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<DefaultMethod> {
        INSTANCE;
        
        private static final MethodDescription.InDefinedShape CACHED = null;
        private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE = null;
        private static final MethodDescription.InDefinedShape PRIVILEGED = null;
        private static final MethodDescription.InDefinedShape TARGET_TYPE = null;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class DelegationMethod implements StackManipulation {
            private final boolean cached;
            private final boolean privileged;
            private final Implementation.SpecialMethodInvocation specialMethodInvocation;

            protected DelegationMethod(Implementation.SpecialMethodInvocation specialMethodInvocation2, boolean z10, boolean z11) {
                this.specialMethodInvocation = specialMethodInvocation2;
                this.cached = z10;
                this.privileged = z11;
            }

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                StackManipulation stackManipulation;
                if (this.privileged) {
                    stackManipulation = MethodConstant.ofPrivileged(context.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.PUBLIC));
                } else {
                    stackManipulation = MethodConstant.of(context.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.PUBLIC));
                }
                if (this.cached) {
                    stackManipulation = FieldAccess.forField(context.cache(stackManipulation, TypeDescription.ForLoadedType.of(Method.class))).read();
                }
                return stackManipulation.apply(methodVisitor, context);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                DelegationMethod delegationMethod = (DelegationMethod) obj;
                return this.cached == delegationMethod.cached && this.privileged == delegationMethod.privileged && this.specialMethodInvocation.equals(delegationMethod.specialMethodInvocation);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.specialMethodInvocation.hashCode()) * 31) + (this.cached ? 1 : 0)) * 31) + (this.privileged ? 1 : 0);
            }

            public boolean isValid() {
                return this.specialMethodInvocation.isValid();
            }
        }

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
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(DefaultMethod.class).getDeclaredMethods();
            CACHED = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("cached"))).getOnly();
            PRIVILEGED = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("privileged"))).getOnly();
            TARGET_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("targetType"))).getOnly();
            NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("nullIfImpossible"))).getOnly();
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<DefaultMethod> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            MethodLocator methodLocator;
            Class<Boolean> cls = Boolean.class;
            if (!parameterDescription.getType().asErasure().isAssignableFrom((Class<?>) Method.class)) {
                throw new IllegalStateException("Cannot assign Method type to " + parameterDescription);
            } else if (methodDescription.isMethod()) {
                TypeDescription typeDescription = (TypeDescription) loadable.getValue(TARGET_TYPE).resolve(TypeDescription.class);
                if (typeDescription.represents(Void.TYPE)) {
                    methodLocator = MethodLocator.ForImplicitType.INSTANCE;
                } else {
                    methodLocator = new MethodLocator.ForExplicitType(typeDescription);
                }
                Implementation.SpecialMethodInvocation withCheckedCompatibilityTo = methodLocator.resolve(target, methodDescription).withCheckedCompatibilityTo(methodDescription.asTypeToken());
                if (withCheckedCompatibilityTo.isValid()) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(new DelegationMethod(withCheckedCompatibilityTo, ((Boolean) loadable.getValue(CACHED).resolve(cls)).booleanValue(), ((Boolean) loadable.getValue(PRIVILEGED).resolve(cls)).booleanValue()));
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

        public Class<DefaultMethod> getHandledType() {
            return DefaultMethod.class;
        }
    }

    boolean cached() default true;

    boolean nullIfImpossible() default false;

    boolean privileged() default false;

    Class<?> targetType() default void.class;
}
