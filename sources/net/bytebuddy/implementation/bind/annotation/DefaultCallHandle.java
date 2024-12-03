package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
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
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.nullability.MaybeNull;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultCallHandle {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<DefaultCallHandle> {
        INSTANCE;
        
        private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE = null;
        private static final MethodDescription.InDefinedShape TARGET_TYPE = null;

        protected interface DefaultMethodLocator {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Explicit implements DefaultMethodLocator {
                private final TypeDescription typeDescription;

                public Explicit(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((Explicit) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }

                public Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription) {
                    if (this.typeDescription.isInterface()) {
                        return target.invokeDefault(methodDescription.asSignatureToken(), this.typeDescription);
                    }
                    throw new IllegalStateException(methodDescription + " method carries default method call parameter on non-interface type");
                }
            }

            public enum Implicit implements DefaultMethodLocator {
                INSTANCE;

                public Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription) {
                    return target.invokeDefault(methodDescription.asSignatureToken());
                }
            }

            Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription);
        }

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(DefaultCallHandle.class).getDeclaredMethods();
            TARGET_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("targetType"))).getOnly();
            NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("nullIfImpossible"))).getOnly();
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<DefaultCallHandle> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            DefaultMethodLocator defaultMethodLocator;
            StackManipulation stackManipulation;
            Object obj;
            Class<Object> cls = Object.class;
            Class<Boolean> cls2 = Boolean.class;
            TypeDescription asErasure = parameterDescription.getType().asErasure();
            JavaType javaType = JavaType.METHOD_HANDLE;
            if (!asErasure.isAssignableFrom(javaType.getTypeStub())) {
                throw new IllegalStateException("Cannot assign MethodHandle type to " + parameterDescription);
            } else if (!methodDescription.isConstructor()) {
                TypeDescription typeDescription = (TypeDescription) loadable.getValue(TARGET_TYPE).resolve(TypeDescription.class);
                if (typeDescription.represents(Void.TYPE)) {
                    defaultMethodLocator = DefaultMethodLocator.Implicit.INSTANCE;
                } else {
                    defaultMethodLocator = new DefaultMethodLocator.Explicit(typeDescription);
                }
                Implementation.SpecialMethodInvocation withCheckedCompatibilityTo = defaultMethodLocator.resolve(target, methodDescription).withCheckedCompatibilityTo(methodDescription.asTypeToken());
                if (withCheckedCompatibilityTo.isValid()) {
                    ArrayList arrayList = new ArrayList((methodDescription.getParameters().size() * 3) + 3);
                    arrayList.add(withCheckedCompatibilityTo.toMethodHandle().toStackManipulation());
                    arrayList.add(MethodVariableAccess.loadThis());
                    arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(cls))))));
                    if (!methodDescription.getParameters().isEmpty()) {
                        ArrayList arrayList2 = new ArrayList(methodDescription.getParameters().size());
                        Iterator<E> it = methodDescription.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription2 = (ParameterDescription) it.next();
                            if (parameterDescription2.getType().isPrimitive()) {
                                obj = new StackManipulation.Compound(MethodVariableAccess.load(parameterDescription2), assigner.assign(parameterDescription2.getType(), parameterDescription2.getType().asErasure().asBoxed().asGenericType(), typing));
                            } else {
                                obj = MethodVariableAccess.load(parameterDescription2);
                            }
                            arrayList2.add(obj);
                        }
                        arrayList.add(IntegerConstant.forValue(0));
                        arrayList.add(ArrayFactory.forType(TypeDescription.ForLoadedType.of(cls).asGenericType()).withValues(arrayList2));
                        TypeDescription typeStub = JavaType.METHOD_HANDLES.getTypeStub();
                        JavaType javaType2 = JavaType.METHOD_HANDLE;
                        arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(typeStub, new MethodDescription.Token("insertArguments", 9, javaType2.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(javaType2.getTypeStub(), TypeDefinition.Sort.describe(Integer.TYPE), TypeDefinition.Sort.describe(Object[].class))))));
                    }
                    stackManipulation = new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
                } else if (!((Boolean) loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(cls2)).booleanValue()) {
                    return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
                } else {
                    stackManipulation = NullConstant.INSTANCE;
                }
                return new MethodDelegationBinder.ParameterBinding.Anonymous(stackManipulation);
            } else if (((Boolean) loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(cls2)).booleanValue()) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE);
            } else {
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            }
        }

        public Class<DefaultCallHandle> getHandledType() {
            return DefaultCallHandle.class;
        }
    }

    boolean nullIfImpossible() default false;

    Class<?> targetType() default void.class;
}
