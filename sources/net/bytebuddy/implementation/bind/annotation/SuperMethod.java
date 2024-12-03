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
public @interface SuperMethod {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<SuperMethod> {
        INSTANCE;
        
        private static final MethodDescription.InDefinedShape CACHED = null;
        private static final MethodDescription.InDefinedShape FALLBACK_TO_DEFAULT = null;
        private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE = null;
        private static final MethodDescription.InDefinedShape PRIVILEGED = null;

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

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(SuperMethod.class).getDeclaredMethods();
            CACHED = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("cached"))).getOnly();
            PRIVILEGED = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("privileged"))).getOnly();
            FALLBACK_TO_DEFAULT = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("fallbackToDefault"))).getOnly();
            NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("nullIfImpossible"))).getOnly();
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<SuperMethod> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            Implementation.SpecialMethodInvocation specialMethodInvocation;
            Class<Boolean> cls = Boolean.class;
            if (!parameterDescription.getType().asErasure().isAssignableFrom((Class<?>) Method.class)) {
                throw new IllegalStateException("Cannot assign Method type to " + parameterDescription);
            } else if (methodDescription.isMethod()) {
                if (((Boolean) loadable.getValue(FALLBACK_TO_DEFAULT).resolve(cls)).booleanValue()) {
                    specialMethodInvocation = target.invokeDominant(methodDescription.asSignatureToken());
                } else {
                    specialMethodInvocation = target.invokeSuper(methodDescription.asSignatureToken());
                }
                Implementation.SpecialMethodInvocation withCheckedCompatibilityTo = specialMethodInvocation.withCheckedCompatibilityTo(methodDescription.asTypeToken());
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

        public Class<SuperMethod> getHandledType() {
            return SuperMethod.class;
        }
    }

    boolean cached() default true;

    boolean fallbackToDefault() default true;

    boolean nullIfImpossible() default false;

    boolean privileged() default false;
}
