package net.bytebuddy;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.EnumerationState;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.TypeManifestation;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.inline.DecoratingDynamicTypeBuilder;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import net.bytebuddy.dynamic.scaffold.inline.RebaseDynamicTypeBuilder;
import net.bytebuddy.dynamic.scaffold.inline.RedefinitionDynamicTypeBuilder;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.dynamic.scaffold.subclass.SubclassDynamicTypeBuilder;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class ByteBuddy {
    private static final boolean ACCESS_CONTROLLER;
    private static final String BYTE_BUDDY_DEFAULT_CONTEXT_NAME = "synthetic";
    private static final String BYTE_BUDDY_DEFAULT_PREFIX = "ByteBuddy";
    private static final String BYTE_BUDDY_DEFAULT_SUFFIX = "auxiliary";
    @MaybeNull
    private static final AuxiliaryType.NamingStrategy DEFAULT_AUXILIARY_NAMING_STRATEGY;
    @MaybeNull
    private static final Implementation.Context.Factory DEFAULT_IMPLEMENTATION_CONTEXT_FACTORY;
    public static final String DEFAULT_NAMING_PROPERTY = "net.bytebuddy.naming";
    @MaybeNull
    private static final NamingStrategy DEFAULT_NAMING_STRATEGY;
    protected final AnnotationRetention annotationRetention;
    protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
    protected final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
    protected final ClassFileVersion classFileVersion;
    protected final ClassWriterStrategy classWriterStrategy;
    protected final LatentMatcher<? super MethodDescription> ignoredMethods;
    protected final Implementation.Context.Factory implementationContextFactory;
    protected final InstrumentedType.Factory instrumentedTypeFactory;
    protected final MethodGraph.Compiler methodGraphCompiler;
    protected final NamingStrategy namingStrategy;
    protected final TypeValidation typeValidation;
    protected final VisibilityBridgeStrategy visibilityBridgeStrategy;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class EnumerationImplementation implements Implementation {
        protected static final String CLONE_METHOD_NAME = "clone";
        private static final int ENUM_FIELD_MODIFIERS = 25;
        private static final String ENUM_VALUES = "$VALUES";
        protected static final String ENUM_VALUES_METHOD_NAME = "values";
        protected static final String ENUM_VALUE_OF_METHOD_NAME = "valueOf";
        private final List<String> values;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class InitializationAppender implements ByteCodeAppender {
            private final List<String> values;

            protected InitializationAppender(List<String> list) {
                this.values = list;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                TypeDescription asErasure = methodDescription.getDeclaringType().asErasure();
                MethodDescription methodDescription2 = (MethodDescription) ((MethodList) asErasure.getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{String.class, Integer.TYPE})))).getOnly();
                StackManipulation stackManipulation = StackManipulation.Trivial.INSTANCE;
                ArrayList<FieldDescription> arrayList = new ArrayList<>(this.values.size());
                int i10 = 0;
                for (String next : this.values) {
                    FieldDescription fieldDescription = (FieldDescription) ((FieldList) asErasure.getDeclaredFields().filter(ElementMatchers.named(next))).getOnly();
                    StackManipulation compound = new StackManipulation.Compound(stackManipulation, TypeCreation.of(asErasure), Duplication.SINGLE, new TextConstant(next), IntegerConstant.forValue(i10), MethodInvocation.invoke(methodDescription2), FieldAccess.forField(fieldDescription).write());
                    arrayList.add(fieldDescription);
                    i10++;
                    stackManipulation = compound;
                }
                ArrayList arrayList2 = new ArrayList(this.values.size());
                for (FieldDescription forField : arrayList) {
                    arrayList2.add(FieldAccess.forField(forField).read());
                }
                return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulation, ArrayFactory.forType(asErasure.asGenericType()).withValues(arrayList2), FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) asErasure.getDeclaredFields().filter(ElementMatchers.named(EnumerationImplementation.ENUM_VALUES))).getOnly()).write()).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.values.equals(((InitializationAppender) obj).values);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.values.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ValuesMethodAppender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            protected ValuesMethodAppender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                FieldDescription fieldDescription = (FieldDescription) ((FieldList) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(EnumerationImplementation.ENUM_VALUES))).getOnly();
                return new ByteCodeAppender.Size(new StackManipulation.Compound(FieldAccess.forField(fieldDescription).read(), MethodInvocation.invoke((MethodDescription) ((MethodList) TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class).getDeclaredMethods().filter(ElementMatchers.named(EnumerationImplementation.CLONE_METHOD_NAME))).getOnly()).virtual(fieldDescription.getType().asErasure()), TypeCasting.to(fieldDescription.getType().asErasure()), MethodReturn.REFERENCE).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((ValuesMethodAppender) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }
        }

        protected EnumerationImplementation(List<String> list) {
            this.values = list;
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new ValuesMethodAppender(target.getInstrumentedType());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.values.equals(((EnumerationImplementation) obj).values);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.values.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            for (String token : this.values) {
                instrumentedType = instrumentedType.withField(new FieldDescription.Token(token, 16409, TargetType.DESCRIPTION.asGenericType()));
            }
            return instrumentedType.withField(new FieldDescription.Token(ENUM_VALUES, 4121, TypeDescription.ArrayProjection.of(TargetType.DESCRIPTION).asGenericType())).withInitializer((ByteCodeAppender) new InitializationAppender(this.values));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected enum RecordConstructorStrategy implements ConstructorStrategy, Implementation {
        INSTANCE;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            protected Appender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                int i10 = 1;
                if (methodDescription.isMethod()) {
                    return new ByteCodeAppender.Simple(MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(methodDescription.getName()))).getOnly()).read(), MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context, methodDescription);
                }
                ArrayList arrayList = new ArrayList((this.instrumentedType.getRecordComponents().size() * 3) + 2);
                arrayList.add(MethodVariableAccess.loadThis());
                arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(JavaType.RECORD.getTypeStub(), new MethodDescription.Token(1))));
                for (RecordComponentDescription.InDefinedShape inDefinedShape : this.instrumentedType.getRecordComponents()) {
                    arrayList.add(MethodVariableAccess.loadThis());
                    arrayList.add(MethodVariableAccess.of(inDefinedShape.getType()).loadFrom(i10));
                    arrayList.add(FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(inDefinedShape.getActualName()))).getOnly()).write());
                    i10 += inDefinedShape.getType().getStackSize().getSize();
                }
                arrayList.add(MethodReturn.VOID);
                return new ByteCodeAppender.Simple((List<? extends StackManipulation>) arrayList).apply(methodVisitor, context, methodDescription);
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
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType());
        }

        public List<MethodDescription.Token> extractConstructors(TypeDescription typeDescription) {
            ArrayList arrayList = new ArrayList(typeDescription.getRecordComponents().size());
            for (RecordComponentDescription.InDefinedShape inDefinedShape : typeDescription.getRecordComponents()) {
                arrayList.add(new ParameterDescription.Token(inDefinedShape.getType(), inDefinedShape.getDeclaredAnnotations().filter(ElementMatchers.targetsElement(ElementType.CONSTRUCTOR)), inDefinedShape.getActualName(), 0));
            }
            return Collections.singletonList(new MethodDescription.Token(MethodDescription.CONSTRUCTOR_INTERNAL_NAME, 1, Collections.emptyList(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE), arrayList, Collections.emptyList(), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED));
        }

        public MethodRegistry inject(TypeDescription typeDescription, MethodRegistry methodRegistry) {
            return methodRegistry.prepend(new LatentMatcher.Resolved(ElementMatchers.isConstructor().and(ElementMatchers.takesGenericArguments((List<? extends TypeDefinition>) typeDescription.getRecordComponents().asTypeList()))), new MethodRegistry.Handler.ForImplementation(this), MethodAttributeAppender.ForInstrumentedMethod.EXCLUDING_RECEIVER, Transformer.NoOp.make());
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            for (RecordComponentDescription.InDefinedShape inDefinedShape : instrumentedType.getRecordComponents()) {
                instrumentedType = instrumentedType.withField(new FieldDescription.Token(inDefinedShape.getActualName(), 18, inDefinedShape.getType(), inDefinedShape.getDeclaredAnnotations().filter(ElementMatchers.targetsElement(ElementType.FIELD)))).withMethod(new MethodDescription.Token(inDefinedShape.getActualName(), 1, Collections.emptyList(), inDefinedShape.getType(), Collections.emptyList(), Collections.emptyList(), inDefinedShape.getDeclaredAnnotations().filter(ElementMatchers.targetsElement(ElementType.METHOD)), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED));
            }
            return instrumentedType;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected enum RecordObjectMethod implements Implementation {
        HASH_CODE("hashCode", r12, Integer.TYPE, new Class[0]),
        EQUALS("equals", MethodVariableAccess.REFERENCE.loadFrom(1), Boolean.TYPE, Object.class),
        TO_STRING("toString", r12, String.class, new Class[0]);
        
        private final List<? extends TypeDescription> arguments;
        private final String name;
        private final TypeDescription returnType;
        private final StackManipulation stackManipulation;

        private RecordObjectMethod(String str, StackManipulation stackManipulation2, Class<?> cls, Class<?>... clsArr) {
            this.name = str;
            this.stackManipulation = stackManipulation2;
            this.returnType = TypeDescription.ForLoadedType.of(cls);
            this.arguments = new TypeList.ForLoadedTypes(clsArr);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            Class<String> cls = String.class;
            StringBuilder sb2 = new StringBuilder();
            ArrayList arrayList = new ArrayList(target.getInstrumentedType().getRecordComponents().size());
            for (RecordComponentDescription.InDefinedShape inDefinedShape : target.getInstrumentedType().getRecordComponents()) {
                if (sb2.length() > 0) {
                    sb2.append(";");
                }
                sb2.append(inDefinedShape.getActualName());
                arrayList.add(JavaConstant.MethodHandle.ofGetter((FieldDescription.InDefinedShape) ((FieldList) target.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.named(inDefinedShape.getActualName()))).getOnly()));
            }
            return new ByteCodeAppender.Simple(MethodVariableAccess.loadThis(), this.stackManipulation, MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(JavaType.OBJECT_METHODS.getTypeStub(), new MethodDescription.Token("bootstrap", 9, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Arrays.asList(new TypeDescription.Generic[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType(), TypeDescription.ForLoadedType.of(cls).asGenericType(), JavaType.TYPE_DESCRIPTOR.getTypeStub().asGenericType(), TypeDescription.ForLoadedType.of(Class.class).asGenericType(), TypeDescription.ForLoadedType.of(cls).asGenericType(), TypeDescription.ArrayProjection.of(JavaType.METHOD_HANDLE.getTypeStub()).asGenericType()})))).dynamic(this.name, this.returnType, CompoundList.of(target.getInstrumentedType(), this.arguments), CompoundList.of(Arrays.asList(new JavaConstant[]{JavaConstant.Simple.of(target.getInstrumentedType()), JavaConstant.Simple.ofLoaded(sb2.toString())}), (List) arrayList)), MethodReturn.of(this.returnType));
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0030  */
    static {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = "java.security.AccessController"
            java.lang.Class.forName(r2, r0, r1)     // Catch:{ ClassNotFoundException -> 0x0017, SecurityException -> 0x0016 }
            java.lang.String r2 = "net.bytebuddy.securitymanager"
            java.lang.String r3 = "true"
            java.lang.String r2 = java.lang.System.getProperty(r2, r3)     // Catch:{ ClassNotFoundException -> 0x0017, SecurityException -> 0x0016 }
            boolean r2 = java.lang.Boolean.parseBoolean(r2)     // Catch:{ ClassNotFoundException -> 0x0017, SecurityException -> 0x0016 }
            ACCESS_CONTROLLER = r2     // Catch:{ ClassNotFoundException -> 0x0017, SecurityException -> 0x0016 }
            goto L_0x0019
        L_0x0016:
            r0 = 1
        L_0x0017:
            ACCESS_CONTROLLER = r0
        L_0x0019:
            net.bytebuddy.utility.privilege.GetSystemPropertyAction r0 = new net.bytebuddy.utility.privilege.GetSystemPropertyAction
            java.lang.String r2 = "net.bytebuddy.naming"
            r0.<init>(r2)
            java.lang.Object r0 = doPrivileged(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "synthetic"
            java.lang.String r3 = "auxiliary"
            java.lang.String r4 = "net.bytebuddy.renamed"
            java.lang.String r5 = "ByteBuddy"
            if (r0 != 0) goto L_0x0054
            net.bytebuddy.utility.GraalImageCode r0 = net.bytebuddy.utility.GraalImageCode.getCurrent()
            boolean r0 = r0.isDefined()
            if (r0 == 0) goto L_0x0051
            net.bytebuddy.NamingStrategy$Suffixing r1 = new net.bytebuddy.NamingStrategy$Suffixing
            net.bytebuddy.NamingStrategy$Suffixing$BaseNameResolver$WithCallerSuffix r0 = new net.bytebuddy.NamingStrategy$Suffixing$BaseNameResolver$WithCallerSuffix
            net.bytebuddy.NamingStrategy$Suffixing$BaseNameResolver$ForUnnamedType r6 = net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE
            r0.<init>(r6)
            r1.<init>(r5, r0, r4)
            net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy$Suffixing r0 = new net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy$Suffixing
            r0.<init>(r3)
            net.bytebuddy.implementation.Implementation$Context$Default$Factory$WithFixedSuffix r3 = new net.bytebuddy.implementation.Implementation$Context$Default$Factory$WithFixedSuffix
            r3.<init>(r2)
            goto L_0x00b1
        L_0x0051:
            r0 = r1
            r3 = r0
            goto L_0x00b1
        L_0x0054:
            java.lang.String r1 = "fixed"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x006e
            net.bytebuddy.NamingStrategy$Suffixing r1 = new net.bytebuddy.NamingStrategy$Suffixing
            net.bytebuddy.NamingStrategy$Suffixing$BaseNameResolver$ForUnnamedType r0 = net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE
            r1.<init>(r5, r0, r4)
            net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy$Suffixing r0 = new net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy$Suffixing
            r0.<init>(r3)
            net.bytebuddy.implementation.Implementation$Context$Default$Factory$WithFixedSuffix r3 = new net.bytebuddy.implementation.Implementation$Context$Default$Factory$WithFixedSuffix
            r3.<init>(r2)
            goto L_0x00b1
        L_0x006e:
            java.lang.String r1 = "caller"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x008d
            net.bytebuddy.NamingStrategy$Suffixing r1 = new net.bytebuddy.NamingStrategy$Suffixing
            net.bytebuddy.NamingStrategy$Suffixing$BaseNameResolver$WithCallerSuffix r0 = new net.bytebuddy.NamingStrategy$Suffixing$BaseNameResolver$WithCallerSuffix
            net.bytebuddy.NamingStrategy$Suffixing$BaseNameResolver$ForUnnamedType r6 = net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE
            r0.<init>(r6)
            r1.<init>(r5, r0, r4)
            net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy$Suffixing r0 = new net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy$Suffixing
            r0.<init>(r3)
            net.bytebuddy.implementation.Implementation$Context$Default$Factory$WithFixedSuffix r3 = new net.bytebuddy.implementation.Implementation$Context$Default$Factory$WithFixedSuffix
            r3.<init>(r2)
            goto L_0x00b1
        L_0x008d:
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00b8 }
            net.bytebuddy.NamingStrategy$SuffixingRandom r6 = new net.bytebuddy.NamingStrategy$SuffixingRandom
            net.bytebuddy.NamingStrategy$Suffixing$BaseNameResolver$ForUnnamedType r7 = net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE
            net.bytebuddy.utility.RandomString r8 = new net.bytebuddy.utility.RandomString
            r9 = 8
            java.util.Random r10 = new java.util.Random
            r10.<init>(r0)
            r8.<init>(r9, r10)
            r6.<init>((java.lang.String) r5, (net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver) r7, (java.lang.String) r4, (net.bytebuddy.utility.RandomString) r8)
            net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy$Suffixing r1 = new net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy$Suffixing
            r1.<init>(r3)
            net.bytebuddy.implementation.Implementation$Context$Default$Factory$WithFixedSuffix r0 = new net.bytebuddy.implementation.Implementation$Context$Default$Factory$WithFixedSuffix
            r0.<init>(r2)
            r3 = r0
            r0 = r1
            r1 = r6
        L_0x00b1:
            DEFAULT_NAMING_STRATEGY = r1
            DEFAULT_AUXILIARY_NAMING_STRATEGY = r0
            DEFAULT_IMPLEMENTATION_CONTEXT_FACTORY = r3
            return
        L_0x00b8:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "'net.bytebuddy.naming' is set to an unknown, non-numeric value: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.ByteBuddy.<clinit>():void");
    }

    public ByteBuddy() {
        this(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5));
    }

    @AccessControllerPlugin.Enhance
    @MaybeNull
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public <T> DynamicType.Builder<T> decorate(Class<T> cls) {
        return decorate(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ByteBuddy byteBuddy = (ByteBuddy) obj;
        return this.annotationRetention.equals(byteBuddy.annotationRetention) && this.typeValidation.equals(byteBuddy.typeValidation) && this.classFileVersion.equals(byteBuddy.classFileVersion) && this.namingStrategy.equals(byteBuddy.namingStrategy) && this.auxiliaryTypeNamingStrategy.equals(byteBuddy.auxiliaryTypeNamingStrategy) && this.annotationValueFilterFactory.equals(byteBuddy.annotationValueFilterFactory) && this.implementationContextFactory.equals(byteBuddy.implementationContextFactory) && this.methodGraphCompiler.equals(byteBuddy.methodGraphCompiler) && this.instrumentedTypeFactory.equals(byteBuddy.instrumentedTypeFactory) && this.ignoredMethods.equals(byteBuddy.ignoredMethods) && this.visibilityBridgeStrategy.equals(byteBuddy.visibilityBridgeStrategy) && this.classWriterStrategy.equals(byteBuddy.classWriterStrategy);
    }

    public int hashCode() {
        return (((((((((((((((((((((((getClass().hashCode() * 31) + this.classFileVersion.hashCode()) * 31) + this.namingStrategy.hashCode()) * 31) + this.auxiliaryTypeNamingStrategy.hashCode()) * 31) + this.annotationValueFilterFactory.hashCode()) * 31) + this.annotationRetention.hashCode()) * 31) + this.implementationContextFactory.hashCode()) * 31) + this.methodGraphCompiler.hashCode()) * 31) + this.instrumentedTypeFactory.hashCode()) * 31) + this.ignoredMethods.hashCode()) * 31) + this.typeValidation.hashCode()) * 31) + this.visibilityBridgeStrategy.hashCode()) * 31) + this.classWriterStrategy.hashCode();
    }

    public ByteBuddy ignore(ElementMatcher<? super MethodDescription> elementMatcher) {
        return ignore((LatentMatcher<? super MethodDescription>) new LatentMatcher.Resolved(elementMatcher));
    }

    public DynamicType.Builder<? extends Annotation> makeAnnotation() {
        return new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(this.namingStrategy.subclass(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Annotation.class)), ModifierContributor.Resolver.of(Visibility.PUBLIC, TypeManifestation.ANNOTATION).resolve(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)).withInterfaces(new TypeList.Generic.Explicit(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Annotation.class))), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, ConstructorStrategy.Default.NO_CONSTRUCTORS);
    }

    public DynamicType.Builder<? extends Enum<?>> makeEnumeration(String... strArr) {
        return makeEnumeration((Collection<? extends String>) Arrays.asList(strArr));
    }

    public DynamicType.Builder<?> makeInterface() {
        return makeInterface((Collection<? extends TypeDefinition>) Collections.emptyList());
    }

    public DynamicType.Builder<?> makePackage(String str) {
        InstrumentedType.Factory factory = this.instrumentedTypeFactory;
        return new SubclassDynamicTypeBuilder(factory.subclass(str + "." + PackageDescription.PACKAGE_CLASS_NAME, PackageDescription.PACKAGE_MODIFIERS, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, ConstructorStrategy.Default.NO_CONSTRUCTORS);
    }

    public DynamicType.Builder<?> makeRecord() {
        Class<Object> cls = Object.class;
        TypeDescription.Generic asGenericType = InstrumentedType.Default.of(JavaType.RECORD.getTypeStub().getName(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(cls), Visibility.PUBLIC).withMethod(new MethodDescription.Token(4)).withMethod(new MethodDescription.Token("hashCode", 1025, TypeDescription.ForLoadedType.of(Integer.TYPE).asGenericType())).withMethod(new MethodDescription.Token("equals", 1025, TypeDescription.ForLoadedType.of(Boolean.TYPE).asGenericType(), Collections.singletonList(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(cls)))).withMethod(new MethodDescription.Token("toString", 1025, TypeDescription.ForLoadedType.of(String.class).asGenericType())).asGenericType();
        return new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(this.namingStrategy.subclass(asGenericType), 17, asGenericType).withRecord(true), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, RecordConstructorStrategy.INSTANCE).method(ElementMatchers.isHashCode()).intercept(RecordObjectMethod.HASH_CODE).method(ElementMatchers.isEquals()).intercept(RecordObjectMethod.EQUALS).method(ElementMatchers.isToString()).intercept(RecordObjectMethod.TO_STRING);
    }

    public <T> DynamicType.Builder<T> rebase(Class<T> cls) {
        return rebase(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public <T> DynamicType.Builder<T> redefine(Class<T> cls) {
        return redefine(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public <T> DynamicType.Builder<T> subclass(Class<T> cls) {
        return subclass((TypeDefinition) TypeDescription.ForLoadedType.of(cls));
    }

    public ByteBuddy with(ClassFileVersion classFileVersion2) {
        return new ByteBuddy(classFileVersion2, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ByteBuddy(net.bytebuddy.ClassFileVersion r16) {
        /*
            r15 = this;
            net.bytebuddy.NamingStrategy r0 = DEFAULT_NAMING_STRATEGY
            if (r0 != 0) goto L_0x000b
            net.bytebuddy.NamingStrategy$SuffixingRandom r0 = new net.bytebuddy.NamingStrategy$SuffixingRandom
            java.lang.String r1 = "ByteBuddy"
            r0.<init>(r1)
        L_0x000b:
            r4 = r0
            net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy r0 = DEFAULT_AUXILIARY_NAMING_STRATEGY
            if (r0 != 0) goto L_0x0017
            net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy$SuffixingRandom r0 = new net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy$SuffixingRandom
            java.lang.String r1 = "auxiliary"
            r0.<init>(r1)
        L_0x0017:
            r5 = r0
            net.bytebuddy.implementation.attribute.AnnotationValueFilter$Default r6 = net.bytebuddy.implementation.attribute.AnnotationValueFilter.Default.APPEND_DEFAULTS
            net.bytebuddy.implementation.attribute.AnnotationRetention r7 = net.bytebuddy.implementation.attribute.AnnotationRetention.ENABLED
            net.bytebuddy.implementation.Implementation$Context$Factory r0 = DEFAULT_IMPLEMENTATION_CONTEXT_FACTORY
            if (r0 != 0) goto L_0x0022
            net.bytebuddy.implementation.Implementation$Context$Default$Factory r0 = net.bytebuddy.implementation.Implementation.Context.Default.Factory.INSTANCE
        L_0x0022:
            r8 = r0
            net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler r9 = net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.DEFAULT
            net.bytebuddy.dynamic.scaffold.InstrumentedType$Factory$Default r10 = net.bytebuddy.dynamic.scaffold.InstrumentedType.Factory.Default.MODIFIABLE
            net.bytebuddy.dynamic.scaffold.TypeValidation r11 = net.bytebuddy.dynamic.scaffold.TypeValidation.ENABLED
            net.bytebuddy.dynamic.VisibilityBridgeStrategy$Default r12 = net.bytebuddy.dynamic.VisibilityBridgeStrategy.Default.ALWAYS
            net.bytebuddy.dynamic.scaffold.ClassWriterStrategy$Default r13 = net.bytebuddy.dynamic.scaffold.ClassWriterStrategy.Default.CONSTANT_POOL_RETAINING
            net.bytebuddy.matcher.LatentMatcher$Resolved r14 = new net.bytebuddy.matcher.LatentMatcher$Resolved
            net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.isSynthetic()
            net.bytebuddy.matcher.ElementMatcher$Junction r1 = net.bytebuddy.matcher.ElementMatchers.isDefaultFinalizer()
            net.bytebuddy.matcher.ElementMatcher$Junction r0 = r0.or(r1)
            r14.<init>(r0)
            r2 = r15
            r3 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.ByteBuddy.<init>(net.bytebuddy.ClassFileVersion):void");
    }

    public <T> DynamicType.Builder<T> decorate(Class<T> cls, ClassFileLocator classFileLocator) {
        return decorate(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public ByteBuddy ignore(LatentMatcher<? super MethodDescription> latentMatcher) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, latentMatcher);
    }

    public DynamicType.Builder<? extends Enum<?>> makeEnumeration(Collection<? extends String> collection) {
        Class<TargetType> cls = TargetType.class;
        Class<String> cls2 = String.class;
        if (!collection.isEmpty()) {
            TypeDescription.Generic build = TypeDescription.Generic.Builder.parameterizedType((Class<?>) Enum.class, cls).build();
            InstrumentedType.Factory factory = this.instrumentedTypeFactory;
            String subclass = this.namingStrategy.subclass(build);
            Visibility visibility = Visibility.PUBLIC;
            InstrumentedType.WithFlexibleName subclass2 = factory.subclass(subclass, ModifierContributor.Resolver.of(visibility, TypeManifestation.FINAL, EnumerationState.ENUMERATION).resolve(), build);
            ClassFileVersion classFileVersion2 = this.classFileVersion;
            AuxiliaryType.NamingStrategy namingStrategy2 = this.auxiliaryTypeNamingStrategy;
            AnnotationValueFilter.Factory factory2 = this.annotationValueFilterFactory;
            AnnotationRetention annotationRetention2 = this.annotationRetention;
            Implementation.Context.Factory factory3 = this.implementationContextFactory;
            MethodGraph.Compiler compiler = this.methodGraphCompiler;
            TypeValidation typeValidation2 = this.typeValidation;
            VisibilityBridgeStrategy visibilityBridgeStrategy2 = this.visibilityBridgeStrategy;
            ClassWriterStrategy classWriterStrategy2 = this.classWriterStrategy;
            TypeDescription.Generic generic = build;
            DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition intercept = new SubclassDynamicTypeBuilder(subclass2, classFileVersion2, namingStrategy2, factory2, annotationRetention2, factory3, compiler, typeValidation2, visibilityBridgeStrategy2, classWriterStrategy2, this.ignoredMethods, ConstructorStrategy.Default.NO_CONSTRUCTORS).defineConstructor(Visibility.PRIVATE).withParameters(cls2, Integer.TYPE).intercept(SuperMethodCall.INSTANCE);
            Ownership ownership = Ownership.STATIC;
            return intercept.defineMethod("valueOf", (Type) cls, visibility, ownership).withParameters(cls2).intercept(MethodCall.invoke((MethodDescription) ((MethodList) generic.getDeclaredMethods().filter(ElementMatchers.named("valueOf").and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{Class.class, cls2})))).getOnly()).withOwnType().withArgument(0).withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC)).defineMethod("values", (Type) TargetType[].class, visibility, ownership).intercept(new EnumerationImplementation(new ArrayList(collection)));
        }
        throw new IllegalArgumentException("Require at least one enumeration constant");
    }

    public <T> DynamicType.Builder<T> makeInterface(Class<T> cls) {
        return makeInterface((List<? extends Type>) Collections.singletonList(cls));
    }

    public <T> DynamicType.Builder<T> rebase(Class<T> cls, ClassFileLocator classFileLocator) {
        return rebase(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public <T> DynamicType.Builder<T> redefine(Class<T> cls, ClassFileLocator classFileLocator) {
        return redefine(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public <T> DynamicType.Builder<T> subclass(Class<T> cls, ConstructorStrategy constructorStrategy) {
        return subclass((TypeDefinition) TypeDescription.ForLoadedType.of(cls), constructorStrategy);
    }

    public ByteBuddy with(NamingStrategy namingStrategy2) {
        return new ByteBuddy(this.classFileVersion, namingStrategy2, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public <T> DynamicType.Builder<T> decorate(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        if (typeDescription.isArray() || typeDescription.isPrimitive()) {
            throw new IllegalArgumentException("Cannot decorate array or primitive type: " + typeDescription);
        }
        return new DecoratingDynamicTypeBuilder(typeDescription, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, this.ignoredMethods, classFileLocator);
    }

    public DynamicType.Builder<?> makeInterface(Type... typeArr) {
        return makeInterface((List<? extends Type>) Arrays.asList(typeArr));
    }

    public <T> DynamicType.Builder<T> rebase(Class<T> cls, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
        return rebase(TypeDescription.ForLoadedType.of(cls), classFileLocator, methodNameTransformer);
    }

    public <T> DynamicType.Builder<T> redefine(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        TypeDescription typeDescription2 = typeDescription;
        if (!typeDescription.isArray() && !typeDescription.isPrimitive()) {
            return new RedefinitionDynamicTypeBuilder(this.instrumentedTypeFactory.represent(typeDescription2), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, typeDescription, classFileLocator);
        }
        throw new IllegalArgumentException("Cannot redefine array or primitive type: " + typeDescription2);
    }

    public DynamicType.Builder<?> subclass(Type type) {
        return subclass((TypeDefinition) TypeDefinition.Sort.describe(type));
    }

    public ByteBuddy with(AuxiliaryType.NamingStrategy namingStrategy2) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, namingStrategy2, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public DynamicType.Builder<?> makeInterface(List<? extends Type> list) {
        return makeInterface((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
    }

    public <T> DynamicType.Builder<T> rebase(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return rebase(typeDescription, classFileLocator, MethodNameTransformer.Suffixing.withRandomSuffix());
    }

    public DynamicType.Builder<?> subclass(Type type, ConstructorStrategy constructorStrategy) {
        return subclass((TypeDefinition) TypeDefinition.Sort.describe(type), constructorStrategy);
    }

    public ByteBuddy with(AnnotationValueFilter.Factory factory) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, factory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    protected ByteBuddy(ClassFileVersion classFileVersion2, NamingStrategy namingStrategy2, AuxiliaryType.NamingStrategy namingStrategy3, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention2, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, InstrumentedType.Factory factory3, TypeValidation typeValidation2, VisibilityBridgeStrategy visibilityBridgeStrategy2, ClassWriterStrategy classWriterStrategy2, LatentMatcher<? super MethodDescription> latentMatcher) {
        this.classFileVersion = classFileVersion2;
        this.namingStrategy = namingStrategy2;
        this.auxiliaryTypeNamingStrategy = namingStrategy3;
        this.annotationValueFilterFactory = factory;
        this.annotationRetention = annotationRetention2;
        this.implementationContextFactory = factory2;
        this.methodGraphCompiler = compiler;
        this.instrumentedTypeFactory = factory3;
        this.typeValidation = typeValidation2;
        this.visibilityBridgeStrategy = visibilityBridgeStrategy2;
        this.classWriterStrategy = classWriterStrategy2;
        this.ignoredMethods = latentMatcher;
    }

    public DynamicType.Builder<?> makeInterface(TypeDefinition... typeDefinitionArr) {
        return makeInterface((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
    }

    public <T> DynamicType.Builder<T> rebase(TypeDescription typeDescription, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
        TypeDescription typeDescription2 = typeDescription;
        if (!typeDescription.isArray() && !typeDescription.isPrimitive()) {
            return new RebaseDynamicTypeBuilder(this.instrumentedTypeFactory.represent(typeDescription2), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, typeDescription, classFileLocator, methodNameTransformer);
        }
        throw new IllegalArgumentException("Cannot rebase array or primitive type: " + typeDescription2);
    }

    public DynamicType.Builder<?> subclass(TypeDefinition typeDefinition) {
        return subclass(typeDefinition, (ConstructorStrategy) ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING);
    }

    public ByteBuddy with(AnnotationRetention annotationRetention2) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, annotationRetention2, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public DynamicType.Builder<?> makeInterface(Collection<? extends TypeDefinition> collection) {
        return subclass(Object.class, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).implement(collection).modifiers(TypeManifestation.INTERFACE, Visibility.PUBLIC);
    }

    public DynamicType.Builder<?> subclass(TypeDefinition typeDefinition, ConstructorStrategy constructorStrategy) {
        TypeList.Generic generic;
        TypeDescription.Generic generic2;
        TypeDefinition typeDefinition2 = typeDefinition;
        if (typeDefinition.isPrimitive() || typeDefinition.isArray() || typeDefinition.isFinal()) {
            throw new IllegalArgumentException("Cannot subclass primitive, array or final types: " + typeDefinition2);
        }
        if (typeDefinition.isInterface()) {
            generic2 = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
            generic = new TypeList.Generic.Explicit(typeDefinition2);
        } else {
            generic2 = typeDefinition.asGenericType();
            generic = new TypeList.Generic.Empty();
        }
        return new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(this.namingStrategy.subclass(typeDefinition.asGenericType()), ModifierContributor.Resolver.of(Visibility.PUBLIC, TypeManifestation.PLAIN).resolve(typeDefinition.getModifiers()), generic2).withInterfaces(generic), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, constructorStrategy);
    }

    public ByteBuddy with(Implementation.Context.Factory factory) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, factory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public ByteBuddy with(MethodGraph.Compiler compiler) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, compiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public DynamicType.Builder<?> rebase(Package packageR, ClassFileLocator classFileLocator) {
        return rebase((PackageDescription) new PackageDescription.ForLoadedPackage(packageR), classFileLocator);
    }

    public ByteBuddy with(InstrumentedType.Factory factory) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, factory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public DynamicType.Builder<?> rebase(PackageDescription packageDescription, ClassFileLocator classFileLocator) {
        return rebase((TypeDescription) new TypeDescription.ForPackageDescription(packageDescription), classFileLocator);
    }

    public ByteBuddy with(TypeValidation typeValidation2) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, typeValidation2, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public ByteBuddy with(VisibilityBridgeStrategy visibilityBridgeStrategy2) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, visibilityBridgeStrategy2, this.classWriterStrategy, this.ignoredMethods);
    }

    public ByteBuddy with(ClassWriterStrategy classWriterStrategy2) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, classWriterStrategy2, this.ignoredMethods);
    }
}
