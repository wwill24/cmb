package net.bytebuddy.implementation.bind.annotation;

import java.io.Serializable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pipe {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Pipe> {
        private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Pipe.class).getDeclaredMethods().filter(ElementMatchers.named("serializableProxy"))).getOnly());
        private final MethodDescription forwardingMethod;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class RedirectionProxy extends StackManipulation.AbstractBase implements AuxiliaryType {
            private static final String FIELD_NAME_PREFIX = "argument";
            private final Assigner assigner;
            private final TypeDescription forwardingType;
            private final boolean serializableProxy;
            private final MethodDescription sourceMethod;

            protected enum ConstructorCall implements Implementation {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public final transient MethodDescription.InDefinedShape objectTypeDefaultConstructor;

                @HashCodeAndEqualsPlugin.Enhance
                private static class Appender implements ByteCodeAppender {
                    private final TypeDescription instrumentedType;

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        FieldList<FieldDescription.InDefinedShape> declaredFields = this.instrumentedType.getDeclaredFields();
                        StackManipulation[] stackManipulationArr = new StackManipulation[declaredFields.size()];
                        int i10 = 0;
                        for (FieldDescription forField : declaredFields) {
                            stackManipulationArr[i10] = new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodVariableAccess.load((ParameterDescription) methodDescription.getParameters().get(i10)), FieldAccess.forField(forField).write());
                            i10++;
                        }
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodInvocation.invoke(ConstructorCall.INSTANCE.objectTypeDefaultConstructor), new StackManipulation.Compound(stackManipulationArr), MethodReturn.VOID).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Appender) obj).instrumentedType);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
                    }

                    private Appender(TypeDescription typeDescription) {
                        this.instrumentedType = typeDescription;
                    }
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender(target.getInstrumentedType());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class MethodCall implements Implementation {
                /* access modifiers changed from: private */
                public final Assigner assigner;
                /* access modifiers changed from: private */
                public final MethodDescription redirectedMethod;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                private class Appender implements ByteCodeAppender {
                    private final TypeDescription instrumentedType;

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        FieldList<FieldDescription.InDefinedShape> declaredFields = this.instrumentedType.getDeclaredFields();
                        StackManipulation[] stackManipulationArr = new StackManipulation[declaredFields.size()];
                        int i10 = 0;
                        for (FieldDescription forField : declaredFields) {
                            stackManipulationArr[i10] = new StackManipulation.Compound(MethodVariableAccess.loadThis(), FieldAccess.forField(forField).read());
                            i10++;
                        }
                        Assigner access$500 = MethodCall.this.assigner;
                        TypeDescription.Generic of2 = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
                        TypeDescription.Generic asGenericType = MethodCall.this.redirectedMethod.getDeclaringType().asGenericType();
                        Assigner.Typing typing = Assigner.Typing.DYNAMIC;
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.REFERENCE.loadFrom(1), access$500.assign(of2, asGenericType, typing), new StackManipulation.Compound(stackManipulationArr), MethodInvocation.invoke(MethodCall.this.redirectedMethod), MethodCall.this.assigner.assign(MethodCall.this.redirectedMethod.getReturnType(), methodDescription.getReturnType(), typing), MethodReturn.REFERENCE).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Appender appender = (Appender) obj;
                        return this.instrumentedType.equals(appender.instrumentedType) && MethodCall.this.equals(MethodCall.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + MethodCall.this.hashCode();
                    }

                    private Appender(TypeDescription typeDescription) {
                        this.instrumentedType = typeDescription;
                    }
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    if (this.redirectedMethod.isAccessibleTo(target.getInstrumentedType())) {
                        return new Appender(target.getInstrumentedType());
                    }
                    throw new IllegalStateException("Cannot invoke " + this.redirectedMethod + " from outside of class via @Pipe proxy");
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    MethodCall methodCall = (MethodCall) obj;
                    return this.redirectedMethod.equals(methodCall.redirectedMethod) && this.assigner.equals(methodCall.assigner);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.redirectedMethod.hashCode()) * 31) + this.assigner.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                private MethodCall(MethodDescription methodDescription, Assigner assigner2) {
                    this.redirectedMethod = methodDescription;
                    this.assigner = assigner2;
                }
            }

            protected RedirectionProxy(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner2, boolean z10) {
                this.forwardingType = typeDescription;
                this.sourceMethod = methodDescription;
                this.assigner = assigner2;
                this.serializableProxy = z10;
            }

            private static LinkedHashMap<String, TypeDescription> extractFields(MethodDescription methodDescription) {
                TypeList<TypeDescription> asErasures = methodDescription.getParameters().asTypeList().asErasures();
                LinkedHashMap<String, TypeDescription> linkedHashMap = new LinkedHashMap<>();
                int i10 = 0;
                for (TypeDescription put : asErasures) {
                    int i11 = i10 + 1;
                    linkedHashMap.put(fieldName(i10), put);
                    i10 = i11;
                }
                return linkedHashMap;
            }

            private static String fieldName(int i10) {
                return FIELD_NAME_PREFIX + i10;
            }

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                TypeDescription register = context.register(this);
                return new StackManipulation.Compound(TypeCreation.of(register), Duplication.SINGLE, MethodVariableAccess.allArgumentsOf(this.sourceMethod), MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) register.getDeclaredMethods().filter(ElementMatchers.isConstructor())).getOnly())).apply(methodVisitor, context);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                RedirectionProxy redirectionProxy = (RedirectionProxy) obj;
                return this.serializableProxy == redirectionProxy.serializableProxy && this.forwardingType.equals(redirectionProxy.forwardingType) && this.sourceMethod.equals(redirectionProxy.sourceMethod) && this.assigner.equals(redirectionProxy.assigner);
            }

            public String getSuffix() {
                String str;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(RandomString.hashOf(this.forwardingType.hashCode()));
                sb2.append(RandomString.hashOf(this.sourceMethod.hashCode()));
                if (this.serializableProxy) {
                    str = "S";
                } else {
                    str = "0";
                }
                sb2.append(str);
                return sb2.toString();
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.forwardingType.hashCode()) * 31) + this.sourceMethod.hashCode()) * 31) + this.assigner.hashCode()) * 31) + (this.serializableProxy ? 1 : 0);
            }

            public DynamicType make(String str, ClassFileVersion classFileVersion, MethodAccessorFactory methodAccessorFactory) {
                LinkedHashMap extractFields = extractFields(this.sourceMethod);
                DynamicType.Builder intercept = new ByteBuddy(classFileVersion).with(TypeValidation.DISABLED).subclass((TypeDefinition) this.forwardingType, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).name(str).modifiers(AuxiliaryType.DEFAULT_TYPE_MODIFIER).implement((Type[]) this.serializableProxy ? new Class[]{Serializable.class} : new Class[0]).method(ElementMatchers.isAbstract().and(ElementMatchers.isDeclaredBy(this.forwardingType))).intercept(new MethodCall(this.sourceMethod, this.assigner)).defineConstructor(new ModifierContributor.ForMethod[0]).withParameters((Collection<? extends TypeDefinition>) extractFields.values()).intercept(ConstructorCall.INSTANCE);
                for (Map.Entry entry : extractFields.entrySet()) {
                    intercept = intercept.defineField((String) entry.getKey(), (TypeDefinition) entry.getValue(), Visibility.PRIVATE);
                }
                return intercept.make();
            }
        }

        protected Binder(MethodDescription methodDescription) {
            this.forwardingMethod = methodDescription;
        }

        public static TargetMethodAnnotationDrivenBinder.ParameterBinder<Pipe> install(Class<?> cls) {
            return install(TypeDescription.ForLoadedType.of(cls));
        }

        private static MethodDescription onlyMethod(TypeDescription typeDescription) {
            Class<Object> cls = Object.class;
            if (!typeDescription.isInterface()) {
                throw new IllegalArgumentException(typeDescription + " is not an interface");
            } else if (!typeDescription.getInterfaces().isEmpty()) {
                throw new IllegalArgumentException(typeDescription + " must not extend other interfaces");
            } else if (typeDescription.isPublic()) {
                MethodList methodList = (MethodList) typeDescription.getDeclaredMethods().filter(ElementMatchers.isAbstract());
                if (methodList.size() == 1) {
                    MethodDescription methodDescription = (MethodDescription) methodList.getOnly();
                    if (!methodDescription.getReturnType().asErasure().represents(cls)) {
                        throw new IllegalArgumentException(methodDescription + " does not return an Object-type");
                    } else if (methodDescription.getParameters().size() == 1 && ((ParameterDescription) methodDescription.getParameters().getOnly()).getType().asErasure().represents(cls)) {
                        return methodDescription;
                    } else {
                        throw new IllegalArgumentException(methodDescription + " does not take a single Object-typed argument");
                    }
                } else {
                    throw new IllegalArgumentException(typeDescription + " must declare exactly one abstract method");
                }
            } else {
                throw new IllegalArgumentException(typeDescription + " is mot public");
            }
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Pipe> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            if (!parameterDescription.getType().asErasure().equals(this.forwardingMethod.getDeclaringType())) {
                throw new IllegalStateException("Illegal use of @Pipe for " + parameterDescription + " which was installed for " + this.forwardingMethod.getDeclaringType());
            } else if (methodDescription.isStatic()) {
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            } else {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(new RedirectionProxy(this.forwardingMethod.getDeclaringType().asErasure(), methodDescription, assigner, ((Boolean) loadable.getValue(SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue()));
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.forwardingMethod.equals(((Binder) obj).forwardingMethod);
        }

        public Class<Pipe> getHandledType() {
            return Pipe.class;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.forwardingMethod.hashCode();
        }

        public static TargetMethodAnnotationDrivenBinder.ParameterBinder<Pipe> install(TypeDescription typeDescription) {
            return new Binder(onlyMethod(typeDescription));
        }
    }

    boolean serializableProxy() default false;
}
