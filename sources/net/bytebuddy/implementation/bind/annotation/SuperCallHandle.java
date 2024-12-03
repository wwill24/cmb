package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SuperCallHandle {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<SuperCallHandle> {
        INSTANCE;
        
        private static final MethodDescription.InDefinedShape FALLBACK_TO_DEFAULT = null;
        private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE = null;

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(SuperCallHandle.class).getDeclaredMethods();
            FALLBACK_TO_DEFAULT = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("fallbackToDefault"))).getOnly();
            NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("nullIfImpossible"))).getOnly();
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<SuperCallHandle> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            Implementation.SpecialMethodInvocation specialMethodInvocation;
            StackManipulation stackManipulation;
            int i10;
            Object obj;
            AnnotationDescription.Loadable<SuperCallHandle> loadable2 = loadable;
            Implementation.Target target2 = target;
            Class<Object> cls = Object.class;
            Class<Boolean> cls2 = Boolean.class;
            TypeDescription asErasure = parameterDescription.getType().asErasure();
            JavaType javaType = JavaType.METHOD_HANDLE;
            if (!asErasure.isAssignableFrom(javaType.getTypeStub())) {
                throw new IllegalStateException("A method handle for a super method invocation cannot be assigned to " + parameterDescription);
            } else if (!methodDescription.isConstructor()) {
                if (((Boolean) loadable.getValue(FALLBACK_TO_DEFAULT).resolve(cls2)).booleanValue()) {
                    specialMethodInvocation = target2.invokeDominant(methodDescription.asSignatureToken());
                } else {
                    specialMethodInvocation = target2.invokeSuper(methodDescription.asSignatureToken());
                }
                Implementation.SpecialMethodInvocation withCheckedCompatibilityTo = specialMethodInvocation.withCheckedCompatibilityTo(methodDescription.asTypeToken());
                if (withCheckedCompatibilityTo.isValid()) {
                    if (methodDescription.isStatic()) {
                        i10 = 0;
                    } else {
                        i10 = 2;
                    }
                    ArrayList arrayList = new ArrayList(i10 + 1 + (methodDescription.getParameters().size() * 3));
                    arrayList.add(withCheckedCompatibilityTo.toMethodHandle().toStackManipulation());
                    if (!methodDescription.isStatic()) {
                        arrayList.add(MethodVariableAccess.loadThis());
                        arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(cls))))));
                    }
                    if (!methodDescription.getParameters().isEmpty()) {
                        ArrayList arrayList2 = new ArrayList(methodDescription.getParameters().size());
                        Iterator<E> it = methodDescription.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription2 = (ParameterDescription) it.next();
                            if (parameterDescription2.getType().isPrimitive()) {
                                obj = new StackManipulation.Compound(MethodVariableAccess.load(parameterDescription2), assigner.assign(parameterDescription2.getType(), parameterDescription2.getType().asErasure().asBoxed().asGenericType(), typing));
                            } else {
                                Assigner assigner2 = assigner;
                                Assigner.Typing typing2 = typing;
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

        public Class<SuperCallHandle> getHandledType() {
            return SuperCallHandle.class;
        }
    }

    boolean fallbackToDefault() default true;

    boolean nullIfImpossible() default false;
}
