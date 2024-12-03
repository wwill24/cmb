package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaType;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SuperMethodHandle {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<SuperMethodHandle> {
        INSTANCE;
        
        private static final MethodDescription.InDefinedShape FALLBACK_TO_DEFAULT = null;
        private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE = null;

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(SuperMethodHandle.class).getDeclaredMethods();
            FALLBACK_TO_DEFAULT = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("fallbackToDefault"))).getOnly();
            NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("nullIfImpossible"))).getOnly();
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<SuperMethodHandle> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            Implementation.SpecialMethodInvocation specialMethodInvocation;
            Class<Boolean> cls = Boolean.class;
            if (!parameterDescription.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                throw new IllegalStateException("Cannot assign MethodHandle type to " + parameterDescription);
            } else if (methodDescription.isMethod()) {
                if (((Boolean) loadable.getValue(FALLBACK_TO_DEFAULT).resolve(cls)).booleanValue()) {
                    specialMethodInvocation = target.invokeDominant(methodDescription.asSignatureToken());
                } else {
                    specialMethodInvocation = target.invokeSuper(methodDescription.asSignatureToken());
                }
                Implementation.SpecialMethodInvocation withCheckedCompatibilityTo = specialMethodInvocation.withCheckedCompatibilityTo(methodDescription.asTypeToken());
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

        public Class<SuperMethodHandle> getHandledType() {
            return SuperMethodHandle.class;
        }
    }

    boolean fallbackToDefault() default true;

    boolean nullIfImpossible() default false;
}
