package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Origin {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Origin> {
        INSTANCE;
        
        private static final MethodDescription.InDefinedShape CACHE = null;
        private static final MethodDescription.InDefinedShape PRIVILEGED = null;

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Origin.class).getDeclaredMethods();
            CACHE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("cache"))).getOnly();
            PRIVILEGED = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("privileged"))).getOnly();
        }

        private static StackManipulation methodConstant(AnnotationDescription.Loadable<Origin> loadable, MethodDescription.InDefinedShape inDefinedShape) {
            MethodConstant.CanCache canCache;
            Class<Boolean> cls = Boolean.class;
            if (((Boolean) loadable.getValue(PRIVILEGED).resolve(cls)).booleanValue()) {
                canCache = MethodConstant.ofPrivileged(inDefinedShape);
            } else {
                canCache = MethodConstant.of(inDefinedShape);
            }
            if (((Boolean) loadable.getValue(CACHE).resolve(cls)).booleanValue()) {
                return canCache.cached();
            }
            return canCache;
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Origin> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            TypeDescription asErasure = parameterDescription.getType().asErasure();
            if (asErasure.represents(Class.class)) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(ClassConstant.of(target.getOriginType().asErasure()));
            }
            if (asErasure.represents(Method.class)) {
                if (methodDescription.isMethod()) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(methodConstant(loadable, (MethodDescription.InDefinedShape) methodDescription.asDefined()));
                }
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            } else if (asErasure.represents(Constructor.class)) {
                if (methodDescription.isConstructor()) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(methodConstant(loadable, (MethodDescription.InDefinedShape) methodDescription.asDefined()));
                }
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            } else if (JavaType.EXECUTABLE.getTypeStub().equals(asErasure)) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(methodConstant(loadable, (MethodDescription.InDefinedShape) methodDescription.asDefined()));
            } else {
                if (asErasure.represents(String.class)) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(new TextConstant(methodDescription.toString()));
                }
                if (asErasure.represents(Integer.TYPE)) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(IntegerConstant.forValue(methodDescription.getModifiers()));
                }
                if (asErasure.equals(JavaType.METHOD_HANDLE.getTypeStub())) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(JavaConstant.MethodHandle.of((MethodDescription.InDefinedShape) methodDescription.asDefined()).toStackManipulation());
                }
                if (asErasure.equals(JavaType.METHOD_TYPE.getTypeStub())) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(JavaConstant.MethodType.of((MethodDescription) methodDescription.asDefined()).toStackManipulation());
                }
                if (asErasure.equals(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub())) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(MethodInvocation.lookup());
                }
                throw new IllegalStateException("The " + parameterDescription + " method's " + parameterDescription.getIndex() + " parameter is annotated with a Origin annotation with an argument not representing a Class, Method, Constructor, String, int, MethodType or MethodHandle type");
            }
        }

        public Class<Origin> getHandledType() {
            return Origin.class;
        }
    }

    boolean cache() default true;

    boolean privileged() default false;
}
