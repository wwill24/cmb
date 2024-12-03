package net.bytebuddy.implementation.auxiliary;

import java.io.Serializable;
import java.util.List;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class TypeProxy implements AuxiliaryType {
    public static final String INSTANCE_FIELD = "target";
    public static final String REFLECTION_METHOD = "make";
    private final boolean ignoreFinalizer;
    /* access modifiers changed from: private */
    public final Implementation.Target implementationTarget;
    /* access modifiers changed from: private */
    public final InvocationFactory invocationFactory;
    /* access modifiers changed from: private */
    public final TypeDescription proxiedType;
    private final boolean serializableProxy;

    protected enum AbstractMethodErrorThrow implements StackManipulation {
        INSTANCE;
        
        private final transient StackManipulation implementation;

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return this.implementation.apply(methodVisitor, context);
        }

        public boolean isValid() {
            return this.implementation.isValid();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForDefaultMethod extends StackManipulation.AbstractBase {
        private final Implementation.Target implementationTarget;
        private final TypeDescription proxiedType;
        private final boolean serializableProxy;

        public ForDefaultMethod(TypeDescription typeDescription, Implementation.Target target, boolean z10) {
            this.proxiedType = typeDescription;
            this.implementationTarget = target;
            this.serializableProxy = z10;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            TypeDescription register = context.register(new TypeProxy(this.proxiedType, this.implementationTarget, InvocationFactory.Default.DEFAULT_METHOD, true, this.serializableProxy));
            Duplication duplication = Duplication.SINGLE;
            return new StackManipulation.Compound(TypeCreation.of(register), duplication, MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) register.getDeclaredMethods().filter(ElementMatchers.isConstructor())).getOnly()), duplication, MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) register.getDeclaredFields().filter(ElementMatchers.named(TypeProxy.INSTANCE_FIELD))).getOnly()).write()).apply(methodVisitor, context);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForDefaultMethod forDefaultMethod = (ForDefaultMethod) obj;
            return this.serializableProxy == forDefaultMethod.serializableProxy && this.proxiedType.equals(forDefaultMethod.proxiedType) && this.implementationTarget.equals(forDefaultMethod.implementationTarget);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.proxiedType.hashCode()) * 31) + this.implementationTarget.hashCode()) * 31) + (this.serializableProxy ? 1 : 0);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForSuperMethodByConstructor extends StackManipulation.AbstractBase {
        private final List<TypeDescription> constructorParameters;
        private final boolean ignoreFinalizer;
        private final Implementation.Target implementationTarget;
        private final TypeDescription proxiedType;
        private final boolean serializableProxy;

        public ForSuperMethodByConstructor(TypeDescription typeDescription, Implementation.Target target, List<TypeDescription> list, boolean z10, boolean z11) {
            this.proxiedType = typeDescription;
            this.implementationTarget = target;
            this.constructorParameters = list;
            this.ignoreFinalizer = z10;
            this.serializableProxy = z11;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            TypeDescription register = context.register(new TypeProxy(this.proxiedType, this.implementationTarget, InvocationFactory.Default.SUPER_METHOD, this.ignoreFinalizer, this.serializableProxy));
            StackManipulation[] stackManipulationArr = new StackManipulation[this.constructorParameters.size()];
            int i10 = 0;
            for (TypeDescription of2 : this.constructorParameters) {
                stackManipulationArr[i10] = DefaultValue.of(of2);
                i10++;
            }
            Duplication duplication = Duplication.SINGLE;
            return new StackManipulation.Compound(TypeCreation.of(register), duplication, new StackManipulation.Compound(stackManipulationArr), MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) register.getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments((Iterable<? extends TypeDescription>) this.constructorParameters)))).getOnly()), duplication, MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) register.getDeclaredFields().filter(ElementMatchers.named(TypeProxy.INSTANCE_FIELD))).getOnly()).write()).apply(methodVisitor, context);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForSuperMethodByConstructor forSuperMethodByConstructor = (ForSuperMethodByConstructor) obj;
            return this.ignoreFinalizer == forSuperMethodByConstructor.ignoreFinalizer && this.serializableProxy == forSuperMethodByConstructor.serializableProxy && this.proxiedType.equals(forSuperMethodByConstructor.proxiedType) && this.implementationTarget.equals(forSuperMethodByConstructor.implementationTarget) && this.constructorParameters.equals(forSuperMethodByConstructor.constructorParameters);
        }

        public int hashCode() {
            return (((((((((getClass().hashCode() * 31) + this.proxiedType.hashCode()) * 31) + this.implementationTarget.hashCode()) * 31) + this.constructorParameters.hashCode()) * 31) + (this.ignoreFinalizer ? 1 : 0)) * 31) + (this.serializableProxy ? 1 : 0);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForSuperMethodByReflectionFactory extends StackManipulation.AbstractBase {
        private final boolean ignoreFinalizer;
        private final Implementation.Target implementationTarget;
        private final TypeDescription proxiedType;
        private final boolean serializableProxy;

        public ForSuperMethodByReflectionFactory(TypeDescription typeDescription, Implementation.Target target, boolean z10, boolean z11) {
            this.proxiedType = typeDescription;
            this.implementationTarget = target;
            this.ignoreFinalizer = z10;
            this.serializableProxy = z11;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            TypeDescription register = context.register(new TypeProxy(this.proxiedType, this.implementationTarget, InvocationFactory.Default.SUPER_METHOD, this.ignoreFinalizer, this.serializableProxy));
            return new StackManipulation.Compound(MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) register.getDeclaredMethods().filter(ElementMatchers.named(TypeProxy.REFLECTION_METHOD).and(ElementMatchers.takesArguments(0)))).getOnly()), Duplication.SINGLE, MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) register.getDeclaredFields().filter(ElementMatchers.named(TypeProxy.INSTANCE_FIELD))).getOnly()).write()).apply(methodVisitor, context);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForSuperMethodByReflectionFactory forSuperMethodByReflectionFactory = (ForSuperMethodByReflectionFactory) obj;
            return this.ignoreFinalizer == forSuperMethodByReflectionFactory.ignoreFinalizer && this.serializableProxy == forSuperMethodByReflectionFactory.serializableProxy && this.proxiedType.equals(forSuperMethodByReflectionFactory.proxiedType) && this.implementationTarget.equals(forSuperMethodByReflectionFactory.implementationTarget);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.proxiedType.hashCode()) * 31) + this.implementationTarget.hashCode()) * 31) + (this.ignoreFinalizer ? 1 : 0)) * 31) + (this.serializableProxy ? 1 : 0);
        }
    }

    public interface InvocationFactory {

        public enum Default implements InvocationFactory {
            SUPER_METHOD {
                public Implementation.SpecialMethodInvocation invoke(Implementation.Target target, TypeDescription typeDescription, MethodDescription methodDescription) {
                    return target.invokeDominant(methodDescription.asSignatureToken());
                }
            },
            DEFAULT_METHOD {
                public Implementation.SpecialMethodInvocation invoke(Implementation.Target target, TypeDescription typeDescription, MethodDescription methodDescription) {
                    return target.invokeDefault(methodDescription.asSignatureToken(), typeDescription);
                }
            }
        }

        Implementation.SpecialMethodInvocation invoke(Implementation.Target target, TypeDescription typeDescription, MethodDescription methodDescription);
    }

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    protected class MethodCall implements Implementation {
        /* access modifiers changed from: private */
        public final MethodAccessorFactory methodAccessorFactory;

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        protected class Appender implements ByteCodeAppender {
            /* access modifiers changed from: private */
            public final StackManipulation fieldLoadingInstruction;

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            protected class AccessorMethodInvocation implements StackManipulation {
                private final MethodDescription instrumentedMethod;
                private final Implementation.SpecialMethodInvocation specialMethodInvocation;

                protected AccessorMethodInvocation(MethodDescription methodDescription, Implementation.SpecialMethodInvocation specialMethodInvocation2) {
                    this.instrumentedMethod = methodDescription;
                    this.specialMethodInvocation = specialMethodInvocation2;
                }

                public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                    MethodDescription.InDefinedShape registerAccessorFor = MethodCall.this.methodAccessorFactory.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.DEFAULT);
                    return new StackManipulation.Compound(MethodVariableAccess.loadThis(), Appender.this.fieldLoadingInstruction, MethodVariableAccess.allArgumentsOf(this.instrumentedMethod).asBridgeOf(registerAccessorFor), MethodInvocation.invoke(registerAccessorFor), MethodReturn.of(this.instrumentedMethod.getReturnType())).apply(methodVisitor, context);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AccessorMethodInvocation accessorMethodInvocation = (AccessorMethodInvocation) obj;
                    return this.instrumentedMethod.equals(accessorMethodInvocation.instrumentedMethod) && this.specialMethodInvocation.equals(accessorMethodInvocation.specialMethodInvocation) && Appender.this.equals(Appender.this);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.instrumentedMethod.hashCode()) * 31) + this.specialMethodInvocation.hashCode()) * 31) + Appender.this.hashCode();
                }

                public boolean isValid() {
                    return this.specialMethodInvocation.isValid();
                }
            }

            protected Appender(TypeDescription typeDescription) {
                this.fieldLoadingInstruction = FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(TypeProxy.INSTANCE_FIELD))).getOnly()).read();
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                StackManipulation stackManipulation;
                Implementation.SpecialMethodInvocation invoke = TypeProxy.this.invocationFactory.invoke(TypeProxy.this.implementationTarget, TypeProxy.this.proxiedType, methodDescription);
                if (invoke.isValid()) {
                    stackManipulation = new AccessorMethodInvocation(methodDescription, invoke);
                } else {
                    stackManipulation = AbstractMethodErrorThrow.INSTANCE;
                }
                return new ByteCodeAppender.Size(stackManipulation.apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.fieldLoadingInstruction.equals(appender.fieldLoadingInstruction) && MethodCall.this.equals(MethodCall.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.fieldLoadingInstruction.hashCode()) * 31) + MethodCall.this.hashCode();
            }
        }

        protected MethodCall(MethodAccessorFactory methodAccessorFactory2) {
            this.methodAccessorFactory = methodAccessorFactory2;
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MethodCall methodCall = (MethodCall) obj;
            return this.methodAccessorFactory.equals(methodCall.methodAccessorFactory) && TypeProxy.this.equals(TypeProxy.this);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.methodAccessorFactory.hashCode()) * 31) + TypeProxy.this.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType.withField(new FieldDescription.Token(TypeProxy.INSTANCE_FIELD, 65, TypeProxy.this.implementationTarget.getInstrumentedType().asGenericType()));
        }
    }

    protected enum SilentConstruction implements Implementation {
        INSTANCE;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Appender implements ByteCodeAppender {
            public static final String GET_DECLARED_CONSTRUCTOR_METHOD_DESCRIPTOR = "([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;";
            public static final String GET_DECLARED_CONSTRUCTOR_METHOD_NAME = "getDeclaredConstructor";
            public static final String GET_REFLECTION_FACTORY_METHOD_DESCRIPTOR = "()Lsun/reflect/ReflectionFactory;";
            public static final String GET_REFLECTION_FACTORY_METHOD_NAME = "getReflectionFactory";
            public static final String JAVA_LANG_CLASS_INTERNAL_NAME = "java/lang/Class";
            public static final String JAVA_LANG_CONSTRUCTOR_INTERNAL_NAME = "java/lang/reflect/Constructor";
            public static final String JAVA_LANG_OBJECT_DESCRIPTOR = "Ljava/lang/Object;";
            public static final String JAVA_LANG_OBJECT_INTERNAL_NAME = "java/lang/Object";
            public static final String NEW_CONSTRUCTOR_FOR_SERIALIZATION_METHOD_DESCRIPTOR = "(Ljava/lang/Class;Ljava/lang/reflect/Constructor;)Ljava/lang/reflect/Constructor;";
            public static final String NEW_CONSTRUCTOR_FOR_SERIALIZATION_METHOD_NAME = "newConstructorForSerialization";
            public static final String NEW_INSTANCE_METHOD_DESCRIPTOR = "([Ljava/lang/Object;)Ljava/lang/Object;";
            public static final String NEW_INSTANCE_METHOD_NAME = "newInstance";
            public static final String REFLECTION_FACTORY_INTERNAL_NAME = "sun/reflect/ReflectionFactory";
            private final TypeDescription instrumentedType;

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, REFLECTION_FACTORY_INTERNAL_NAME, GET_REFLECTION_FACTORY_METHOD_NAME, GET_REFLECTION_FACTORY_METHOD_DESCRIPTOR, false);
                methodVisitor.visitLdcInsn(Type.getType(this.instrumentedType.getDescriptor()));
                methodVisitor.visitLdcInsn(Type.getType(JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor.visitInsn(3);
                methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, JAVA_LANG_CLASS_INTERNAL_NAME);
                MethodVisitor methodVisitor2 = methodVisitor;
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JAVA_LANG_CLASS_INTERNAL_NAME, GET_DECLARED_CONSTRUCTOR_METHOD_NAME, GET_DECLARED_CONSTRUCTOR_METHOD_DESCRIPTOR, false);
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, REFLECTION_FACTORY_INTERNAL_NAME, NEW_CONSTRUCTOR_FOR_SERIALIZATION_METHOD_NAME, NEW_CONSTRUCTOR_FOR_SERIALIZATION_METHOD_DESCRIPTOR, false);
                methodVisitor.visitInsn(3);
                methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, JAVA_LANG_OBJECT_INTERNAL_NAME);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JAVA_LANG_CONSTRUCTOR_INTERNAL_NAME, NEW_INSTANCE_METHOD_NAME, NEW_INSTANCE_METHOD_DESCRIPTOR, false);
                methodVisitor.visitTypeInsn(192, this.instrumentedType.getInternalName());
                methodVisitor.visitInsn(Opcodes.ARETURN);
                return new ByteCodeAppender.Size(4, 0);
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

    public TypeProxy(TypeDescription typeDescription, Implementation.Target target, InvocationFactory invocationFactory2, boolean z10, boolean z11) {
        this.proxiedType = typeDescription;
        this.implementationTarget = target;
        this.invocationFactory = invocationFactory2;
        this.ignoreFinalizer = z10;
        this.serializableProxy = z11;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TypeProxy typeProxy = (TypeProxy) obj;
        return this.ignoreFinalizer == typeProxy.ignoreFinalizer && this.serializableProxy == typeProxy.serializableProxy && this.proxiedType.equals(typeProxy.proxiedType) && this.implementationTarget.equals(typeProxy.implementationTarget) && this.invocationFactory.equals(typeProxy.invocationFactory);
    }

    public String getSuffix() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(RandomString.hashOf(this.proxiedType.hashCode()));
        String str = "0";
        sb2.append(this.ignoreFinalizer ? "I" : str);
        if (this.serializableProxy) {
            str = "S";
        }
        sb2.append(str);
        return sb2.toString();
    }

    public int hashCode() {
        return (((((((((getClass().hashCode() * 31) + this.proxiedType.hashCode()) * 31) + this.implementationTarget.hashCode()) * 31) + this.invocationFactory.hashCode()) * 31) + (this.ignoreFinalizer ? 1 : 0)) * 31) + (this.serializableProxy ? 1 : 0);
    }

    public DynamicType make(String str, ClassFileVersion classFileVersion, MethodAccessorFactory methodAccessorFactory) {
        ElementMatcher.Junction junction;
        ByteBuddy with = new ByteBuddy(classFileVersion).with(TypeValidation.DISABLED);
        if (this.ignoreFinalizer) {
            junction = ElementMatchers.isFinalizer();
        } else {
            junction = ElementMatchers.none();
        }
        return with.ignore((ElementMatcher<? super MethodDescription>) junction).subclass((TypeDefinition) this.proxiedType).name(str).modifiers(AuxiliaryType.DEFAULT_TYPE_MODIFIER).implement((java.lang.reflect.Type[]) this.serializableProxy ? new Class[]{Serializable.class} : new Class[0]).method(ElementMatchers.any()).intercept(new MethodCall(methodAccessorFactory)).defineMethod(REFLECTION_METHOD, (java.lang.reflect.Type) TargetType.class, Ownership.STATIC).intercept(SilentConstruction.INSTANCE).make();
    }
}
