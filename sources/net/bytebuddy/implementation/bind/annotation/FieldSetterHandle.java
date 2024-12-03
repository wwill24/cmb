package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldSetterHandle {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldSetterHandle> {
        INSTANCE(new Delegate());
        
        /* access modifiers changed from: private */
        public static final MethodDescription.InDefinedShape DECLARING_TYPE = null;
        /* access modifiers changed from: private */
        public static final MethodDescription.InDefinedShape FIELD_NAME = null;
        private final TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldSetterHandle> delegate;

        protected static class Delegate extends TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFieldBinding<FieldSetterHandle> {
            protected Delegate() {
            }

            /* access modifiers changed from: protected */
            public MethodDelegationBinder.ParameterBinding<?> bind(FieldDescription fieldDescription, AnnotationDescription.Loadable<FieldSetterHandle> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner) {
                TypeDescription asErasure = parameterDescription.getType().asErasure();
                JavaType javaType = JavaType.METHOD_HANDLE;
                if (!asErasure.isAssignableFrom(javaType.getTypeStub())) {
                    throw new IllegalStateException("Cannot assign method handle to " + parameterDescription);
                } else if (fieldDescription.isStatic()) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(JavaConstant.MethodHandle.ofSetter((FieldDescription.InDefinedShape) fieldDescription.asDefined()).toStackManipulation());
                } else {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(new StackManipulation.Compound(JavaConstant.MethodHandle.ofSetter((FieldDescription.InDefinedShape) fieldDescription.asDefined()).toStackManipulation(), MethodVariableAccess.loadThis(), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(Object.class)))))));
                }
            }

            /* access modifiers changed from: protected */
            public TypeDescription declaringType(AnnotationDescription.Loadable<FieldSetterHandle> loadable) {
                return (TypeDescription) loadable.getValue(Binder.DECLARING_TYPE).resolve(TypeDescription.class);
            }

            /* access modifiers changed from: protected */
            public String fieldName(AnnotationDescription.Loadable<FieldSetterHandle> loadable) {
                return (String) loadable.getValue(Binder.FIELD_NAME).resolve(String.class);
            }

            public Class<FieldSetterHandle> getHandledType() {
                return FieldSetterHandle.class;
            }
        }

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldSetterHandle.class).getDeclaredMethods();
            DECLARING_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("declaringType"))).getOnly();
            FIELD_NAME = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
        }

        private Binder(TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldSetterHandle> parameterBinder) {
            this.delegate = parameterBinder;
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<FieldSetterHandle> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            return this.delegate.bind(loadable, methodDescription, parameterDescription, target, assigner, typing);
        }

        public Class<FieldSetterHandle> getHandledType() {
            return this.delegate.getHandledType();
        }
    }

    Class<?> declaringType() default void.class;

    String value() default "";
}
