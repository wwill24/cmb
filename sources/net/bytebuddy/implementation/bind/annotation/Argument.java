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
import net.bytebuddy.implementation.bind.ArgumentTypeResolver;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.matcher.ElementMatchers;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Argument {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Argument> {
        INSTANCE;
        
        private static final MethodDescription.InDefinedShape BINDING_MECHANIC = null;
        private static final MethodDescription.InDefinedShape VALUE = null;

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Argument.class).getDeclaredMethods();
            VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
            BINDING_MECHANIC = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("bindingMechanic"))).getOnly();
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Argument> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            Class<Integer> cls = Integer.class;
            MethodDescription.InDefinedShape inDefinedShape = VALUE;
            if (((Integer) loadable.getValue(inDefinedShape).resolve(cls)).intValue() < 0) {
                throw new IllegalArgumentException("@Argument annotation on " + parameterDescription + " specifies negative index");
            } else if (methodDescription.getParameters().size() <= ((Integer) loadable.getValue(inDefinedShape).resolve(cls)).intValue()) {
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            } else {
                return ((BindingMechanic) loadable.getValue(BINDING_MECHANIC).load(Argument.class.getClassLoader()).resolve(BindingMechanic.class)).makeBinding(((ParameterDescription) methodDescription.getParameters().get(((Integer) loadable.getValue(inDefinedShape).resolve(cls)).intValue())).getType(), parameterDescription.getType(), ((Integer) loadable.getValue(inDefinedShape).resolve(cls)).intValue(), assigner, typing, ((ParameterDescription) methodDescription.getParameters().get(((Integer) loadable.getValue(inDefinedShape).resolve(cls)).intValue())).getOffset());
            }
        }

        public Class<Argument> getHandledType() {
            return Argument.class;
        }
    }

    public enum BindingMechanic {
        UNIQUE {
            /* access modifiers changed from: protected */
            public MethodDelegationBinder.ParameterBinding<?> makeBinding(TypeDescription.Generic generic, TypeDescription.Generic generic2, int i10, Assigner assigner, Assigner.Typing typing, int i11) {
                return MethodDelegationBinder.ParameterBinding.Unique.of(new StackManipulation.Compound(MethodVariableAccess.of(generic).loadFrom(i11), assigner.assign(generic, generic2, typing)), new ArgumentTypeResolver.ParameterIndexToken(i10));
            }
        },
        ANONYMOUS {
            /* access modifiers changed from: protected */
            public MethodDelegationBinder.ParameterBinding<?> makeBinding(TypeDescription.Generic generic, TypeDescription.Generic generic2, int i10, Assigner assigner, Assigner.Typing typing, int i11) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(new StackManipulation.Compound(MethodVariableAccess.of(generic).loadFrom(i11), assigner.assign(generic, generic2, typing)));
            }
        };

        /* access modifiers changed from: protected */
        public abstract MethodDelegationBinder.ParameterBinding<?> makeBinding(TypeDescription.Generic generic, TypeDescription.Generic generic2, int i10, Assigner assigner, Assigner.Typing typing, int i11);
    }

    BindingMechanic bindingMechanic() default BindingMechanic.UNIQUE;

    int value();
}
