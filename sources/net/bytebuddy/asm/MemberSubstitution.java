package net.bytebuddy.asm;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.constant.FieldConstant;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.constant.SerializedConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.FilterableList;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.ConstantValue;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.visitor.LocalVariableAwareMethodVisitor;
import org.jivesoftware.smack.packet.Session;

@HashCodeAndEqualsPlugin.Enhance
public class MemberSubstitution implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
    protected static final int THIS_REFERENCE = 0;
    private final MethodGraph.Compiler methodGraphCompiler;
    private final Replacement.Factory replacementFactory;
    private final boolean strict;
    private final TypePoolResolver typePoolResolver;

    /* renamed from: net.bytebuddy.asm.MemberSubstitution$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$bytebuddy$asm$MemberSubstitution$Replacement$InvocationType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                net.bytebuddy.asm.MemberSubstitution$Replacement$InvocationType[] r0 = net.bytebuddy.asm.MemberSubstitution.Replacement.InvocationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$bytebuddy$asm$MemberSubstitution$Replacement$InvocationType = r0
                net.bytebuddy.asm.MemberSubstitution$Replacement$InvocationType r1 = net.bytebuddy.asm.MemberSubstitution.Replacement.InvocationType.VIRTUAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$bytebuddy$asm$MemberSubstitution$Replacement$InvocationType     // Catch:{ NoSuchFieldError -> 0x001d }
                net.bytebuddy.asm.MemberSubstitution$Replacement$InvocationType r1 = net.bytebuddy.asm.MemberSubstitution.Replacement.InvocationType.SUPER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.AnonymousClass1.<clinit>():void");
        }
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AllArguments {
        boolean includeSelf() default false;

        boolean nullIfEmpty() default false;

        Source source() default Source.SUBSTITUTED_ELEMENT;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @Documented
    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Argument {
        boolean optional() default false;

        Source source() default Source.SUBSTITUTED_ELEMENT;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        int value();
    }

    @Documented
    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Current {
        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldGetterHandle {
        Class<?> declaringType() default void.class;

        String value() default "";
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldSetterHandle {
        Class<?> declaringType() default void.class;

        String value() default "";
    }

    @Documented
    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldValue {
        Class<?> declaringType() default void.class;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        String value() default "";
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Origin {
        Source source() default Source.SUBSTITUTED_ELEMENT;
    }

    protected interface Replacement {

        public interface Binding {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved implements Binding {
                private final ByteCodeElement.Member original;
                private final TypeDescription receiver;
                private final Substitution substitution;

                protected Resolved(TypeDescription typeDescription, ByteCodeElement.Member member, Substitution substitution2) {
                    this.receiver = typeDescription;
                    this.original = member;
                    this.substitution = substitution2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Resolved resolved = (Resolved) obj;
                    return this.receiver.equals(resolved.receiver) && this.original.equals(resolved.original) && this.substitution.equals(resolved.substitution);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.receiver.hashCode()) * 31) + this.original.hashCode()) * 31) + this.substitution.hashCode();
                }

                public boolean isBound() {
                    return true;
                }

                public StackManipulation make(TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i10) {
                    return this.substitution.resolve(this.receiver, this.original, generic, generic2, methodHandle, stackManipulation, i10);
                }
            }

            public enum Unresolved implements Binding {
                INSTANCE;

                public boolean isBound() {
                    return false;
                }

                public StackManipulation make(TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i10) {
                    throw new IllegalStateException("Cannot resolve unresolved binding");
                }
            }

            boolean isBound();

            StackManipulation make(TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i10);
        }

        public interface Factory {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Factory {
                private final List<Factory> factories;

                protected Compound(Factory... factoryArr) {
                    this((List<? extends Factory>) Arrays.asList(factoryArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.factories.equals(((Compound) obj).factories);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.factories.hashCode();
                }

                public Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    ArrayList arrayList = new ArrayList();
                    for (Factory make : this.factories) {
                        arrayList.add(make.make(typeDescription, methodDescription, typePool));
                    }
                    return new ForFirstBinding(arrayList);
                }

                protected Compound(List<? extends Factory> list) {
                    this.factories = new ArrayList();
                    for (Factory factory : list) {
                        if (factory instanceof Compound) {
                            this.factories.addAll(((Compound) factory).factories);
                        } else if (!(factory instanceof NoOp)) {
                            this.factories.add(factory);
                        }
                    }
                }
            }

            Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool);
        }

        public enum InvocationType {
            VIRTUAL,
            SUPER,
            OTHER;

            protected static InvocationType of(int i10, MethodDescription methodDescription) {
                if (i10 != 182) {
                    if (i10 != 183) {
                        if (i10 != 185) {
                            return OTHER;
                        }
                    } else if (methodDescription.isVirtual()) {
                        return SUPER;
                    } else {
                        return OTHER;
                    }
                }
                return VIRTUAL;
            }

            /* access modifiers changed from: protected */
            public boolean matches(boolean z10, boolean z11) {
                int i10 = AnonymousClass1.$SwitchMap$net$bytebuddy$asm$MemberSubstitution$Replacement$InvocationType[ordinal()];
                if (i10 == 1) {
                    return z10;
                }
                if (i10 != 2) {
                    return true;
                }
                return z11;
            }
        }

        public enum NoOp implements Replacement, Factory {
            INSTANCE;

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, FieldDescription.InDefinedShape inDefinedShape, boolean z10) {
                return Binding.Unresolved.INSTANCE;
            }

            public Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return this;
            }

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType) {
                return Binding.Unresolved.INSTANCE;
            }
        }

        Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, FieldDescription.InDefinedShape inDefinedShape, boolean z10);

        Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType);

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForElementMatchers implements Replacement {
            private final ElementMatcher<? super FieldDescription.InDefinedShape> fieldMatcher;
            private final boolean includeSuperCalls;
            private final boolean includeVirtualCalls;
            private final boolean matchFieldRead;
            private final boolean matchFieldWrite;
            private final ElementMatcher<? super MethodDescription> methodMatcher;
            private final Substitution substitution;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Factory implements Factory {
                private final ElementMatcher<? super FieldDescription.InDefinedShape> fieldMatcher;
                private final boolean includeSuperCalls;
                private final boolean includeVirtualCalls;
                private final boolean matchFieldRead;
                private final boolean matchFieldWrite;
                private final ElementMatcher<? super MethodDescription> methodMatcher;
                private final Substitution.Factory substitutionFactory;

                protected Factory(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, ElementMatcher<? super MethodDescription> elementMatcher2, boolean z10, boolean z11, boolean z12, boolean z13, Substitution.Factory factory) {
                    this.fieldMatcher = elementMatcher;
                    this.methodMatcher = elementMatcher2;
                    this.matchFieldRead = z10;
                    this.matchFieldWrite = z11;
                    this.includeVirtualCalls = z12;
                    this.includeSuperCalls = z13;
                    this.substitutionFactory = factory;
                }

                protected static Factory of(ElementMatcher<? super ByteCodeElement.Member> elementMatcher, Substitution.Factory factory) {
                    return new Factory(elementMatcher, elementMatcher, true, true, true, true, factory);
                }

                protected static Factory ofField(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, boolean z10, boolean z11, Substitution.Factory factory) {
                    return new Factory(elementMatcher, ElementMatchers.none(), z10, z11, false, false, factory);
                }

                protected static Factory ofMethod(ElementMatcher<? super MethodDescription> elementMatcher, boolean z10, boolean z11, Substitution.Factory factory) {
                    return new Factory(ElementMatchers.none(), elementMatcher, false, false, z10, z11, factory);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.matchFieldRead == factory.matchFieldRead && this.matchFieldWrite == factory.matchFieldWrite && this.includeVirtualCalls == factory.includeVirtualCalls && this.includeSuperCalls == factory.includeSuperCalls && this.fieldMatcher.equals(factory.fieldMatcher) && this.methodMatcher.equals(factory.methodMatcher) && this.substitutionFactory.equals(factory.substitutionFactory);
                }

                public int hashCode() {
                    return (((((((((((((getClass().hashCode() * 31) + this.fieldMatcher.hashCode()) * 31) + this.methodMatcher.hashCode()) * 31) + (this.matchFieldRead ? 1 : 0)) * 31) + (this.matchFieldWrite ? 1 : 0)) * 31) + (this.includeVirtualCalls ? 1 : 0)) * 31) + (this.includeSuperCalls ? 1 : 0)) * 31) + this.substitutionFactory.hashCode();
                }

                public Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForElementMatchers(this.fieldMatcher, this.methodMatcher, this.matchFieldRead, this.matchFieldWrite, this.includeVirtualCalls, this.includeSuperCalls, this.substitutionFactory.make(typeDescription, methodDescription, typePool));
                }
            }

            protected ForElementMatchers(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, ElementMatcher<? super MethodDescription> elementMatcher2, boolean z10, boolean z11, boolean z12, boolean z13, Substitution substitution2) {
                this.fieldMatcher = elementMatcher;
                this.methodMatcher = elementMatcher2;
                this.matchFieldRead = z10;
                this.matchFieldWrite = z11;
                this.includeVirtualCalls = z12;
                this.includeSuperCalls = z13;
                this.substitution = substitution2;
            }

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, FieldDescription.InDefinedShape inDefinedShape, boolean z10) {
                if (!z10 ? this.matchFieldRead : this.matchFieldWrite) {
                    if (this.fieldMatcher.matches(inDefinedShape)) {
                        return new Binding.Resolved(inDefinedShape.getDeclaringType(), inDefinedShape, this.substitution);
                    }
                }
                return Binding.Unresolved.INSTANCE;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                return this.matchFieldRead == forElementMatchers.matchFieldRead && this.matchFieldWrite == forElementMatchers.matchFieldWrite && this.includeVirtualCalls == forElementMatchers.includeVirtualCalls && this.includeSuperCalls == forElementMatchers.includeSuperCalls && this.fieldMatcher.equals(forElementMatchers.fieldMatcher) && this.methodMatcher.equals(forElementMatchers.methodMatcher) && this.substitution.equals(forElementMatchers.substitution);
            }

            public int hashCode() {
                return (((((((((((((getClass().hashCode() * 31) + this.fieldMatcher.hashCode()) * 31) + this.methodMatcher.hashCode()) * 31) + (this.matchFieldRead ? 1 : 0)) * 31) + (this.matchFieldWrite ? 1 : 0)) * 31) + (this.includeVirtualCalls ? 1 : 0)) * 31) + (this.includeSuperCalls ? 1 : 0)) * 31) + this.substitution.hashCode();
            }

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType) {
                return (!invocationType.matches(this.includeVirtualCalls, this.includeSuperCalls) || !this.methodMatcher.matches(methodDescription2)) ? Binding.Unresolved.INSTANCE : new Binding.Resolved(typeDescription2, methodDescription2, this.substitution);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFirstBinding implements Replacement {
            private final List<? extends Replacement> replacements;

            protected ForFirstBinding(List<? extends Replacement> list) {
                this.replacements = list;
            }

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, FieldDescription.InDefinedShape inDefinedShape, boolean z10) {
                for (Replacement bind : this.replacements) {
                    Binding bind2 = bind.bind(typeDescription, methodDescription, inDefinedShape, z10);
                    if (bind2.isBound()) {
                        return bind2;
                    }
                }
                return Binding.Unresolved.INSTANCE;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.replacements.equals(((ForFirstBinding) obj).replacements);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.replacements.hashCode();
            }

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType) {
                for (Replacement bind : this.replacements) {
                    Binding bind2 = bind.bind(typeDescription, methodDescription, typeDescription2, methodDescription2, invocationType);
                    if (bind2.isBound()) {
                        return bind2;
                    }
                }
                return Binding.Unresolved.INSTANCE;
            }
        }
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SelfCallHandle {
        boolean bound() default true;

        Source source() default Source.SUBSTITUTED_ELEMENT;
    }

    public enum Source {
        SUBSTITUTED_ELEMENT {
            /* access modifiers changed from: protected */
            @MaybeNull
            public Value argument(int i10, TypeList.Generic generic, Map<Integer, Integer> map, ByteCodeElement.Member member, MethodDescription methodDescription) {
                if (i10 < generic.size() - (member.isStatic() ^ true ? 1 : 0)) {
                    return new Value((TypeDescription.Generic) generic.get((member.isStatic() ^ true ? 1 : 0) + i10), map.get(Integer.valueOf(i10 + (member.isStatic() ^ true ? 1 : 0))).intValue());
                }
                return null;
            }

            /* access modifiers changed from: protected */
            public List<Value> arguments(boolean z10, TypeList.Generic generic, Map<Integer, Integer> map, ByteCodeElement.Member member, MethodDescription methodDescription) {
                int i10;
                int size = generic.size();
                int i11 = 0;
                if (z10 || member.isStatic()) {
                    i10 = 0;
                } else {
                    i10 = 1;
                }
                ArrayList arrayList = new ArrayList(size - i10);
                if (!member.isStatic() && !z10) {
                    i11 = 1;
                }
                while (i11 < generic.size()) {
                    arrayList.add(new Value((TypeDescription.Generic) generic.get(i11), map.get(Integer.valueOf(i11)).intValue()));
                    i11++;
                }
                return arrayList;
            }

            /* access modifiers changed from: protected */
            public ByteCodeElement.Member element(ByteCodeElement.Member member, MethodDescription methodDescription) {
                return member;
            }

            /* access modifiers changed from: protected */
            public JavaConstant.MethodHandle handle(JavaConstant.MethodHandle methodHandle, MethodDescription methodDescription) {
                return methodHandle;
            }

            /* access modifiers changed from: protected */
            public boolean isRepresentable(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, ByteCodeElement.Member member, MethodDescription methodDescription) {
                return sort.isRepresentable(member);
            }

            /* access modifiers changed from: protected */
            public StackManipulation resolve(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, MethodDescription methodDescription) {
                return sort.resolve(member, generic.asErasures(), generic2.asErasure());
            }

            /* access modifiers changed from: protected */
            @MaybeNull
            public Value self(TypeList.Generic generic, Map<Integer, Integer> map, ByteCodeElement.Member member, MethodDescription methodDescription) {
                if (member.isStatic()) {
                    return null;
                }
                return new Value((TypeDescription.Generic) generic.get(0), map.get(0).intValue());
            }
        },
        ENCLOSING_METHOD {
            /* access modifiers changed from: protected */
            @MaybeNull
            public Value argument(int i10, TypeList.Generic generic, Map<Integer, Integer> map, ByteCodeElement.Member member, MethodDescription methodDescription) {
                if (i10 >= methodDescription.getParameters().size()) {
                    return null;
                }
                ParameterDescription parameterDescription = (ParameterDescription) methodDescription.getParameters().get(i10);
                return new Value(parameterDescription.getType(), parameterDescription.getOffset());
            }

            /* access modifiers changed from: protected */
            public List<Value> arguments(boolean z10, TypeList.Generic generic, Map<Integer, Integer> map, ByteCodeElement.Member member, MethodDescription methodDescription) {
                ArrayList arrayList;
                if (!z10 || methodDescription.isStatic()) {
                    arrayList = new ArrayList(methodDescription.getParameters().size());
                } else {
                    arrayList = new ArrayList(methodDescription.getParameters().size() + 1);
                    arrayList.add(new Value(methodDescription.getDeclaringType().asGenericType(), 0));
                }
                Iterator<E> it = methodDescription.getParameters().iterator();
                while (it.hasNext()) {
                    ParameterDescription parameterDescription = (ParameterDescription) it.next();
                    arrayList.add(new Value(parameterDescription.getType(), parameterDescription.getOffset()));
                }
                return arrayList;
            }

            /* access modifiers changed from: protected */
            public ByteCodeElement.Member element(ByteCodeElement.Member member, MethodDescription methodDescription) {
                return methodDescription;
            }

            /* access modifiers changed from: protected */
            public JavaConstant.MethodHandle handle(JavaConstant.MethodHandle methodHandle, MethodDescription methodDescription) {
                return JavaConstant.MethodHandle.of((MethodDescription.InDefinedShape) methodDescription.asDefined());
            }

            /* access modifiers changed from: protected */
            public boolean isRepresentable(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, ByteCodeElement.Member member, MethodDescription methodDescription) {
                return sort.isRepresentable(methodDescription);
            }

            /* access modifiers changed from: protected */
            public StackManipulation resolve(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, MethodDescription methodDescription) {
                List list;
                TypeDescription typeDescription;
                if (methodDescription.isStatic() || methodDescription.isConstructor()) {
                    list = methodDescription.getParameters().asTypeList().asErasures();
                } else {
                    list = CompoundList.of(methodDescription.getDeclaringType().asErasure(), methodDescription.getParameters().asTypeList().asErasures());
                }
                if (methodDescription.isConstructor()) {
                    typeDescription = methodDescription.getDeclaringType().asErasure();
                } else {
                    typeDescription = methodDescription.getReturnType().asErasure();
                }
                return sort.resolve(methodDescription, list, typeDescription);
            }

            /* access modifiers changed from: protected */
            @MaybeNull
            public Value self(TypeList.Generic generic, Map<Integer, Integer> map, ByteCodeElement.Member member, MethodDescription methodDescription) {
                if (methodDescription.isStatic()) {
                    return null;
                }
                return new Value(methodDescription.getDeclaringType().asGenericType(), 0);
            }
        };

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Value {
            private final int offset;
            private final TypeDescription.Generic typeDescription;

            protected Value(TypeDescription.Generic generic, int i10) {
                this.typeDescription = generic;
                this.offset = i10;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Value value = (Value) obj;
                return this.offset == value.offset && this.typeDescription.equals(value.typeDescription);
            }

            /* access modifiers changed from: protected */
            public int getOffset() {
                return this.offset;
            }

            /* access modifiers changed from: protected */
            public TypeDescription.Generic getTypeDescription() {
                return this.typeDescription;
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + this.offset;
            }
        }

        /* access modifiers changed from: protected */
        @MaybeNull
        public abstract Value argument(int i10, TypeList.Generic generic, Map<Integer, Integer> map, ByteCodeElement.Member member, MethodDescription methodDescription);

        /* access modifiers changed from: protected */
        public abstract List<Value> arguments(boolean z10, TypeList.Generic generic, Map<Integer, Integer> map, ByteCodeElement.Member member, MethodDescription methodDescription);

        /* access modifiers changed from: protected */
        public abstract ByteCodeElement.Member element(ByteCodeElement.Member member, MethodDescription methodDescription);

        /* access modifiers changed from: protected */
        public abstract JavaConstant.MethodHandle handle(JavaConstant.MethodHandle methodHandle, MethodDescription methodDescription);

        /* access modifiers changed from: protected */
        public abstract boolean isRepresentable(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, ByteCodeElement.Member member, MethodDescription methodDescription);

        /* access modifiers changed from: protected */
        public abstract StackManipulation resolve(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, MethodDescription methodDescription);

        /* access modifiers changed from: protected */
        @MaybeNull
        public abstract Value self(TypeList.Generic generic, Map<Integer, Integer> map, ByteCodeElement.Member member, MethodDescription methodDescription);
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface StubValue {
        Source source() default Source.SUBSTITUTED_ELEMENT;
    }

    protected static class SubstitutingMethodVisitor extends LocalVariableAwareMethodVisitor {
        private final Implementation.Context implementationContext;
        private final MethodDescription instrumentedMethod;
        private final TypeDescription instrumentedType;
        /* access modifiers changed from: private */
        public int localVariableExtension = 0;
        private final MethodGraph.Compiler methodGraphCompiler;
        private final Replacement replacement;
        private int stackSizeBuffer = 0;
        private final boolean strict;
        private final TypePool typePool;
        private final boolean virtualPrivateCalls;

        private class LocalVariableTracingMethodVisitor extends MethodVisitor {
            /* synthetic */ LocalVariableTracingMethodVisitor(SubstitutingMethodVisitor substitutingMethodVisitor, MethodVisitor methodVisitor, AnonymousClass1 r32) {
                this(methodVisitor);
            }

            @SuppressFBWarnings(justification = "No action required on default option.", value = {"SF_SWITCH_NO_DEFAULT"})
            public void visitVarInsn(int i10, int i11) {
                switch (i10) {
                    case 54:
                    case 56:
                    case 58:
                        SubstitutingMethodVisitor substitutingMethodVisitor = SubstitutingMethodVisitor.this;
                        int unused = substitutingMethodVisitor.localVariableExtension = Math.max(substitutingMethodVisitor.localVariableExtension, i11 + 1);
                        break;
                    case 55:
                    case 57:
                        SubstitutingMethodVisitor substitutingMethodVisitor2 = SubstitutingMethodVisitor.this;
                        int unused2 = substitutingMethodVisitor2.localVariableExtension = Math.max(substitutingMethodVisitor2.localVariableExtension, i11 + 2);
                        break;
                }
                super.visitVarInsn(i10, i11);
            }

            private LocalVariableTracingMethodVisitor(MethodVisitor methodVisitor) {
                super(OpenedClassReader.ASM_API, methodVisitor);
            }
        }

        protected SubstitutingMethodVisitor(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodDescription methodDescription, MethodGraph.Compiler compiler, boolean z10, Replacement replacement2, Implementation.Context context, TypePool typePool2, boolean z11) {
            super(methodVisitor, methodDescription);
            this.instrumentedType = typeDescription;
            this.instrumentedMethod = methodDescription;
            this.methodGraphCompiler = compiler;
            this.strict = z10;
            this.replacement = replacement2;
            this.implementationContext = context;
            this.typePool = typePool2;
            this.virtualPrivateCalls = z11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ef, code lost:
            r12 = r1;
            r13 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0101, code lost:
            r12 = r1;
            r13 = r2;
            r9 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0104, code lost:
            r1 = r0.stackSizeBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0106, code lost:
            if (r9 == false) goto L_0x0113;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0108, code lost:
            r2 = net.bytebuddy.utility.JavaConstant.MethodHandle.ofGetter((net.bytebuddy.description.field.FieldDescription.InDefinedShape) r3.getOnly());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0113, code lost:
            r2 = net.bytebuddy.utility.JavaConstant.MethodHandle.ofSetter((net.bytebuddy.description.field.FieldDescription.InDefinedShape) r3.getOnly());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x011d, code lost:
            r14 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x011e, code lost:
            if (r9 == false) goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0120, code lost:
            r2 = net.bytebuddy.implementation.bytecode.member.FieldAccess.forField((net.bytebuddy.description.field.FieldDescription.InDefinedShape) r3.getOnly()).read();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x012f, code lost:
            r2 = net.bytebuddy.implementation.bytecode.member.FieldAccess.forField((net.bytebuddy.description.field.FieldDescription.InDefinedShape) r3.getOnly()).write();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x013d, code lost:
            r0.stackSizeBuffer = java.lang.Math.max(r1, r11.make(r12, r13, r14, r2, getFreeOffset()).apply(new net.bytebuddy.asm.MemberSubstitution.SubstitutingMethodVisitor.LocalVariableTracingMethodVisitor(r0, r0.mv, (net.bytebuddy.asm.MemberSubstitution.AnonymousClass1) null), r0.implementationContext).getMaximalSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x015e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void visitFieldInsn(int r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                r2 = r19
                net.bytebuddy.pool.TypePool r3 = r0.typePool
                r4 = 47
                r5 = 46
                java.lang.String r6 = r2.replace(r4, r5)
                net.bytebuddy.pool.TypePool$Resolution r3 = r3.describe(r6)
                boolean r6 = r3.isResolved()
                java.lang.String r7 = " using "
                java.lang.String r8 = "Could not resolve "
                if (r6 == 0) goto L_0x0198
                net.bytebuddy.description.type.TypeDescription r3 = r3.resolve()
                net.bytebuddy.description.field.FieldList r3 = r3.getDeclaredFields()
                boolean r6 = r0.strict
                if (r6 == 0) goto L_0x0037
                net.bytebuddy.matcher.ElementMatcher$Junction r6 = net.bytebuddy.matcher.ElementMatchers.named(r20)
                net.bytebuddy.matcher.ElementMatcher$Junction r9 = net.bytebuddy.matcher.ElementMatchers.hasDescriptor(r21)
                net.bytebuddy.matcher.ElementMatcher$Junction r6 = r6.and(r9)
                goto L_0x0047
            L_0x0037:
                net.bytebuddy.matcher.ElementMatcher$Junction r6 = net.bytebuddy.matcher.ElementMatchers.named(r20)
                net.bytebuddy.matcher.ElementMatcher$Junction r9 = net.bytebuddy.matcher.ElementMatchers.hasDescriptor(r21)
                net.bytebuddy.matcher.ElementMatcher$Junction r6 = r6.and(r9)
                net.bytebuddy.matcher.ElementMatcher$Junction r6 = net.bytebuddy.matcher.ElementMatchers.failSafe(r6)
            L_0x0047:
                net.bytebuddy.matcher.FilterableList r3 = r3.filter(r6)
                net.bytebuddy.description.field.FieldList r3 = (net.bytebuddy.description.field.FieldList) r3
                boolean r6 = r3.isEmpty()
                if (r6 != 0) goto L_0x015f
                net.bytebuddy.asm.MemberSubstitution$Replacement r4 = r0.replacement
                net.bytebuddy.description.type.TypeDescription r5 = r0.instrumentedType
                net.bytebuddy.description.method.MethodDescription r6 = r0.instrumentedMethod
                java.lang.Object r7 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r7 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r7
                r8 = 181(0xb5, float:2.54E-43)
                r9 = 0
                r10 = 1
                if (r1 == r8) goto L_0x006c
                r8 = 179(0xb3, float:2.51E-43)
                if (r1 != r8) goto L_0x006a
                goto L_0x006c
            L_0x006a:
                r8 = r9
                goto L_0x006d
            L_0x006c:
                r8 = r10
            L_0x006d:
                net.bytebuddy.asm.MemberSubstitution$Replacement$Binding r11 = r4.bind(r5, r6, r7, r8)
                boolean r4 = r11.isBound()
                if (r4 == 0) goto L_0x0163
                switch(r1) {
                    case 178: goto L_0x00f2;
                    case 179: goto L_0x00d6;
                    case 180: goto L_0x00b8;
                    case 181: goto L_0x0091;
                    default: goto L_0x007a;
                }
            L_0x007a:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Unexpected opcode: "
                r3.append(r4)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                r2.<init>(r1)
                throw r2
            L_0x0091:
                net.bytebuddy.description.type.TypeList$Generic$Explicit r1 = new net.bytebuddy.description.type.TypeList$Generic$Explicit
                r2 = 2
                net.bytebuddy.description.type.TypeDefinition[] r2 = new net.bytebuddy.description.type.TypeDefinition[r2]
                java.lang.Object r4 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r4 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r4
                net.bytebuddy.description.type.TypeDescription r4 = r4.getDeclaringType()
                r2[r9] = r4
                java.lang.Object r4 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r4 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r4
                net.bytebuddy.description.type.TypeDescription$Generic r4 = r4.getType()
                r2[r10] = r4
                r1.<init>((net.bytebuddy.description.type.TypeDefinition[]) r2)
                java.lang.Class r2 = java.lang.Void.TYPE
                net.bytebuddy.description.type.TypeDescription$Generic r2 = net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(r2)
                goto L_0x00ef
            L_0x00b8:
                net.bytebuddy.description.type.TypeList$Generic$Explicit r1 = new net.bytebuddy.description.type.TypeList$Generic$Explicit
                net.bytebuddy.description.type.TypeDefinition[] r2 = new net.bytebuddy.description.type.TypeDefinition[r10]
                java.lang.Object r4 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r4 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r4
                net.bytebuddy.description.type.TypeDescription r4 = r4.getDeclaringType()
                r2[r9] = r4
                r1.<init>((net.bytebuddy.description.type.TypeDefinition[]) r2)
                java.lang.Object r2 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r2 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r2
                net.bytebuddy.description.type.TypeDescription$Generic r2 = r2.getType()
                goto L_0x0101
            L_0x00d6:
                net.bytebuddy.description.type.TypeList$Generic$Explicit r1 = new net.bytebuddy.description.type.TypeList$Generic$Explicit
                net.bytebuddy.description.type.TypeDefinition[] r2 = new net.bytebuddy.description.type.TypeDefinition[r10]
                java.lang.Object r4 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r4 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r4
                net.bytebuddy.description.type.TypeDescription$Generic r4 = r4.getType()
                r2[r9] = r4
                r1.<init>((net.bytebuddy.description.type.TypeDefinition[]) r2)
                java.lang.Class r2 = java.lang.Void.TYPE
                net.bytebuddy.description.type.TypeDescription$Generic r2 = net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(r2)
            L_0x00ef:
                r12 = r1
                r13 = r2
                goto L_0x0104
            L_0x00f2:
                net.bytebuddy.description.type.TypeList$Generic$Empty r1 = new net.bytebuddy.description.type.TypeList$Generic$Empty
                r1.<init>()
                java.lang.Object r2 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r2 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r2
                net.bytebuddy.description.type.TypeDescription$Generic r2 = r2.getType()
            L_0x0101:
                r12 = r1
                r13 = r2
                r9 = r10
            L_0x0104:
                int r1 = r0.stackSizeBuffer
                if (r9 == 0) goto L_0x0113
                java.lang.Object r2 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r2 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r2
                net.bytebuddy.utility.JavaConstant$MethodHandle r2 = net.bytebuddy.utility.JavaConstant.MethodHandle.ofGetter((net.bytebuddy.description.field.FieldDescription.InDefinedShape) r2)
                goto L_0x011d
            L_0x0113:
                java.lang.Object r2 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r2 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r2
                net.bytebuddy.utility.JavaConstant$MethodHandle r2 = net.bytebuddy.utility.JavaConstant.MethodHandle.ofSetter((net.bytebuddy.description.field.FieldDescription.InDefinedShape) r2)
            L_0x011d:
                r14 = r2
                if (r9 == 0) goto L_0x012f
                java.lang.Object r2 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r2 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r2
                net.bytebuddy.implementation.bytecode.member.FieldAccess$Defined r2 = net.bytebuddy.implementation.bytecode.member.FieldAccess.forField((net.bytebuddy.description.field.FieldDescription.InDefinedShape) r2)
                net.bytebuddy.implementation.bytecode.StackManipulation r2 = r2.read()
                goto L_0x013d
            L_0x012f:
                java.lang.Object r2 = r3.getOnly()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r2 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r2
                net.bytebuddy.implementation.bytecode.member.FieldAccess$Defined r2 = net.bytebuddy.implementation.bytecode.member.FieldAccess.forField((net.bytebuddy.description.field.FieldDescription.InDefinedShape) r2)
                net.bytebuddy.implementation.bytecode.StackManipulation r2 = r2.write()
            L_0x013d:
                r15 = r2
                int r16 = r17.getFreeOffset()
                net.bytebuddy.implementation.bytecode.StackManipulation r2 = r11.make(r12, r13, r14, r15, r16)
                net.bytebuddy.asm.MemberSubstitution$SubstitutingMethodVisitor$LocalVariableTracingMethodVisitor r3 = new net.bytebuddy.asm.MemberSubstitution$SubstitutingMethodVisitor$LocalVariableTracingMethodVisitor
                net.bytebuddy.jar.asm.MethodVisitor r4 = r0.mv
                r5 = 0
                r3.<init>(r0, r4, r5)
                net.bytebuddy.implementation.Implementation$Context r4 = r0.implementationContext
                net.bytebuddy.implementation.bytecode.StackManipulation$Size r2 = r2.apply(r3, r4)
                int r2 = r2.getMaximalSize()
                int r1 = java.lang.Math.max(r1, r2)
                r0.stackSizeBuffer = r1
                return
            L_0x015f:
                boolean r3 = r0.strict
                if (r3 != 0) goto L_0x0168
            L_0x0163:
                r6 = r20
                r9 = r21
                goto L_0x01a0
            L_0x0168:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r8)
                java.lang.String r2 = r2.replace(r4, r5)
                r3.append(r2)
                java.lang.String r2 = "."
                r3.append(r2)
                r6 = r20
                r3.append(r6)
                r9 = r21
                r3.append(r9)
                r3.append(r7)
                net.bytebuddy.pool.TypePool r2 = r0.typePool
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0198:
                r6 = r20
                r9 = r21
                boolean r3 = r0.strict
                if (r3 != 0) goto L_0x01a4
            L_0x01a0:
                super.visitFieldInsn(r18, r19, r20, r21)
                return
            L_0x01a4:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r8)
                java.lang.String r2 = r2.replace(r4, r5)
                r3.append(r2)
                r3.append(r7)
                net.bytebuddy.pool.TypePool r2 = r0.typePool
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.SubstitutingMethodVisitor.visitFieldInsn(int, java.lang.String, java.lang.String, java.lang.String):void");
        }

        public void visitMaxs(int i10, int i11) {
            super.visitMaxs(i10 + this.stackSizeBuffer, Math.max(this.localVariableExtension, i11));
        }

        public void visitMethodInsn(int i10, String str, String str2, String str3, boolean z10) {
            MethodList methodList;
            TypeList.Generic generic;
            TypeDescription.Generic generic2;
            JavaConstant.MethodHandle methodHandle;
            StackManipulation stackManipulation;
            ElementMatcher.Junction junction;
            ElementMatcher.Junction junction2;
            ElementMatcher.Junction junction3;
            ElementMatcher.Junction junction4;
            ElementMatcher.Junction junction5;
            int i11 = i10;
            String str4 = str;
            String str5 = str2;
            Class<Object> cls = Object.class;
            TypePool.Resolution describe = this.typePool.describe(str4.replace('/', '.'));
            if (describe.isResolved()) {
                if (i11 == 183 && str5.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = describe.resolve().getDeclaredMethods();
                    if (this.strict) {
                        junction5 = ElementMatchers.isConstructor().and(ElementMatchers.hasDescriptor(str3));
                    } else {
                        junction5 = ElementMatchers.failSafe(ElementMatchers.isConstructor().and(ElementMatchers.hasDescriptor(str3)));
                    }
                    methodList = (MethodList) declaredMethods.filter(junction5);
                } else if (i11 == 184 || i11 == 183) {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods2 = describe.resolve().getDeclaredMethods();
                    if (this.strict) {
                        junction = ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3));
                    } else {
                        junction = ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)));
                    }
                    methodList = (MethodList) declaredMethods2.filter(junction);
                } else if (this.virtualPrivateCalls) {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods3 = describe.resolve().getDeclaredMethods();
                    if (this.strict) {
                        junction3 = ElementMatchers.isPrivate().and(ElementMatchers.not(ElementMatchers.isStatic())).and(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)));
                    } else {
                        junction3 = ElementMatchers.failSafe(ElementMatchers.isPrivate().and(ElementMatchers.not(ElementMatchers.isStatic())).and(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3))));
                    }
                    methodList = (MethodList) declaredMethods3.filter(junction3);
                    if (methodList.isEmpty()) {
                        MethodList<?> asMethodList = this.methodGraphCompiler.compile((TypeDefinition) describe.resolve(), this.instrumentedType).listNodes().asMethodList();
                        if (this.strict) {
                            junction4 = ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3));
                        } else {
                            junction4 = ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)));
                        }
                        methodList = (MethodList) asMethodList.filter(junction4);
                    }
                } else {
                    MethodList<?> asMethodList2 = this.methodGraphCompiler.compile((TypeDefinition) describe.resolve(), this.instrumentedType).listNodes().asMethodList();
                    if (this.strict) {
                        junction2 = ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3));
                    } else {
                        junction2 = ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)));
                    }
                    methodList = (MethodList) asMethodList2.filter(junction2);
                }
                if (!methodList.isEmpty()) {
                    Replacement.Binding bind = this.replacement.bind(this.instrumentedType, this.instrumentedMethod, describe.resolve(), (MethodDescription) methodList.getOnly(), Replacement.InvocationType.of(i11, (MethodDescription) methodList.getOnly()));
                    if (bind.isBound()) {
                        if (((MethodDescription) methodList.getOnly()).isStatic() || ((MethodDescription) methodList.getOnly()).isConstructor()) {
                            generic = ((MethodDescription) methodList.getOnly()).getParameters().asTypeList();
                        } else {
                            generic = new TypeList.Generic.Explicit((List<? extends TypeDefinition>) CompoundList.of(describe.resolve(), ((MethodDescription) methodList.getOnly()).getParameters().asTypeList()));
                        }
                        TypeList.Generic generic3 = generic;
                        if (((MethodDescription) methodList.getOnly()).isConstructor()) {
                            generic2 = ((MethodDescription) methodList.getOnly()).getDeclaringType().asGenericType();
                        } else {
                            generic2 = ((MethodDescription) methodList.getOnly()).getReturnType();
                        }
                        TypeDescription.Generic generic4 = generic2;
                        if (i11 != 183 || !((MethodDescription) methodList.getOnly()).isMethod() || ((MethodDescription) methodList.getOnly()).isPrivate()) {
                            methodHandle = JavaConstant.MethodHandle.of((MethodDescription.InDefinedShape) ((MethodDescription) methodList.getOnly()).asDefined());
                        } else {
                            methodHandle = JavaConstant.MethodHandle.ofSpecial((MethodDescription.InDefinedShape) ((MethodDescription) methodList.getOnly()).asDefined(), describe.resolve());
                        }
                        JavaConstant.MethodHandle methodHandle2 = methodHandle;
                        if (i11 != 183 || !((MethodDescription) methodList.getOnly()).isMethod() || ((MethodDescription) methodList.getOnly()).isPrivate()) {
                            stackManipulation = MethodInvocation.invoke((MethodDescription) methodList.getOnly());
                        } else {
                            stackManipulation = MethodInvocation.invoke((MethodDescription) methodList.getOnly()).special(describe.resolve());
                        }
                        StackManipulation.Size apply = bind.make(generic3, generic4, methodHandle2, stackManipulation, getFreeOffset()).apply(new LocalVariableTracingMethodVisitor(this, this.mv, (AnonymousClass1) null), this.implementationContext);
                        if (((MethodDescription) methodList.getOnly()).isConstructor()) {
                            int max = Math.max(this.stackSizeBuffer, apply.getMaximalSize() + 2);
                            this.stackSizeBuffer = max;
                            Duplication duplication = Duplication.SINGLE;
                            Removal removal = Removal.SINGLE;
                            this.stackSizeBuffer = Math.max(max, new StackManipulation.Compound(duplication.flipOver(TypeDescription.ForLoadedType.of(cls)), removal, removal, duplication.flipOver(TypeDescription.ForLoadedType.of(cls)), removal, removal).apply(this.mv, this.implementationContext).getMaximalSize() + StackSize.SINGLE.getSize());
                            return;
                        }
                        this.stackSizeBuffer = Math.max(this.stackSizeBuffer, apply.getMaximalSize());
                        return;
                    }
                } else if (this.strict) {
                    throw new IllegalStateException("Could not resolve " + str4.replace('/', '.') + "." + str5 + str3 + " using " + this.typePool);
                }
                String str6 = str3;
            } else {
                String str7 = str3;
                if (this.strict) {
                    throw new IllegalStateException("Could not resolve " + str4.replace('/', '.') + " using " + this.typePool);
                }
            }
            super.visitMethodInsn(i10, str, str2, str3, z10);
        }
    }

    public interface Substitution {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Chain implements Substitution {
            private final Assigner assigner;
            private final List<Step> steps;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final Assigner assigner;
                private final List<Step.Factory> steps;
                private final Assigner.Typing typing;

                protected Factory(Assigner assigner2, Assigner.Typing typing2, List<Step.Factory> list) {
                    this.assigner = assigner2;
                    this.typing = typing2;
                    this.steps = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.typing.equals(factory.typing) && this.assigner.equals(factory.assigner) && this.steps.equals(factory.steps);
                }

                public Factory executing(Step.Factory... factoryArr) {
                    return executing((List<? extends Step.Factory>) Arrays.asList(factoryArr));
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.assigner.hashCode()) * 31) + this.typing.hashCode()) * 31) + this.steps.hashCode();
                }

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    if (this.steps.isEmpty()) {
                        return Stubbing.INSTANCE;
                    }
                    ArrayList arrayList = new ArrayList(this.steps.size());
                    for (Step.Factory make : this.steps) {
                        arrayList.add(make.make(this.assigner, this.typing, typeDescription, methodDescription));
                    }
                    return new Chain(this.assigner, this.typing, arrayList);
                }

                public Factory executing(List<? extends Step.Factory> list) {
                    return new Factory(this.assigner, this.typing, CompoundList.of(this.steps, (List<Step.Factory>) list));
                }
            }

            public interface Step {

                public interface Factory {
                    Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription);
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForArgumentLoading implements Step, Factory {
                    private final int index;

                    protected ForArgumentLoading(int i10) {
                        this.index = i10;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.index == ((ForArgumentLoading) obj).index;
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.index;
                    }

                    public Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this;
                    }

                    public Resolution resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i10) {
                        if (this.index < generic.size()) {
                            return new Simple((StackManipulation) new StackManipulation.Compound(Removal.of(generic3), MethodVariableAccess.of((TypeDefinition) generic.get(this.index)).loadFrom(map.get(Integer.valueOf(this.index)).intValue())), (TypeDescription.Generic) generic.get(this.index));
                        }
                        throw new IllegalStateException(member + " has not " + this.index + " arguments");
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForArgumentSubstitution implements Step {
                    private final Assigner assigner;
                    private final int index;
                    private final StackManipulation substitution;
                    private final TypeDescription.Generic typeDescription;
                    private final Assigner.Typing typing;

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Factory implements Factory {
                        private final int index;
                        private final StackManipulation stackManipulation;
                        private final TypeDescription.Generic typeDescription;

                        public Factory(StackManipulation stackManipulation2, Type type, int i10) {
                            this(stackManipulation2, TypeDefinition.Sort.describe(type), i10);
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Factory factory = (Factory) obj;
                            return this.index == factory.index && this.stackManipulation.equals(factory.stackManipulation) && this.typeDescription.equals(factory.typeDescription);
                        }

                        public int hashCode() {
                            return (((((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDescription.hashCode()) * 31) + this.index;
                        }

                        public Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription2, MethodDescription methodDescription) {
                            return new ForArgumentSubstitution(this.stackManipulation, this.typeDescription, this.index, assigner, typing);
                        }

                        public Factory(StackManipulation stackManipulation2, TypeDescription.Generic generic, int i10) {
                            this.stackManipulation = stackManipulation2;
                            this.typeDescription = generic;
                            this.index = i10;
                        }
                    }

                    protected ForArgumentSubstitution(StackManipulation stackManipulation, TypeDescription.Generic generic, int i10, Assigner assigner2, Assigner.Typing typing2) {
                        this.substitution = stackManipulation;
                        this.typeDescription = generic;
                        this.index = i10;
                        this.assigner = assigner2;
                        this.typing = typing2;
                    }

                    public static Factory of(Object obj, int i10) {
                        if (i10 >= 0) {
                            ConstantValue wrap = ConstantValue.Simple.wrap(obj);
                            return new Factory(wrap.toStackManipulation(), wrap.getTypeDescription().asGenericType(), i10);
                        }
                        throw new IllegalArgumentException("Index cannot be negative: " + i10);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForArgumentSubstitution forArgumentSubstitution = (ForArgumentSubstitution) obj;
                        return this.index == forArgumentSubstitution.index && this.typing.equals(forArgumentSubstitution.typing) && this.substitution.equals(forArgumentSubstitution.substitution) && this.typeDescription.equals(forArgumentSubstitution.typeDescription) && this.assigner.equals(forArgumentSubstitution.assigner);
                    }

                    public int hashCode() {
                        return (((((((((getClass().hashCode() * 31) + this.substitution.hashCode()) * 31) + this.typeDescription.hashCode()) * 31) + this.index) * 31) + this.assigner.hashCode()) * 31) + this.typing.hashCode();
                    }

                    public Resolution resolve(TypeDescription typeDescription2, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i10) {
                        if (this.index < generic.size()) {
                            StackManipulation assign = this.assigner.assign(this.typeDescription, (TypeDescription.Generic) generic.get(this.index), this.typing);
                            if (assign.isValid()) {
                                return new Simple((StackManipulation) new StackManipulation.Compound(this.substitution, assign, MethodVariableAccess.of((TypeDefinition) generic.get(this.index)).storeAt(map.get(Integer.valueOf(this.index)).intValue())), generic3);
                            }
                            throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + generic.get(this.index));
                        }
                        throw new IllegalStateException(member + " has not " + this.index + " arguments");
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForAssignment implements Step {
                    private final Assigner assigner;
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    @MaybeNull
                    private final TypeDescription.Generic result;

                    @HashCodeAndEqualsPlugin.Enhance
                    protected static class Factory implements Factory {
                        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                        @MaybeNull
                        private final TypeDescription.Generic result;

                        protected Factory(@MaybeNull TypeDescription.Generic generic) {
                            this.result = generic;
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:17:0x0027 A[RETURN] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                            /*
                                r4 = this;
                                r0 = 1
                                if (r4 != r5) goto L_0x0004
                                return r0
                            L_0x0004:
                                r1 = 0
                                if (r5 != 0) goto L_0x0008
                                return r1
                            L_0x0008:
                                java.lang.Class r2 = r4.getClass()
                                java.lang.Class r3 = r5.getClass()
                                if (r2 == r3) goto L_0x0013
                                return r1
                            L_0x0013:
                                net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.result
                                net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForAssignment$Factory r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForAssignment.Factory) r5
                                net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.result
                                if (r5 == 0) goto L_0x0024
                                if (r2 == 0) goto L_0x0026
                                boolean r5 = r2.equals(r5)
                                if (r5 != 0) goto L_0x0027
                                return r1
                            L_0x0024:
                                if (r2 == 0) goto L_0x0027
                            L_0x0026:
                                return r1
                            L_0x0027:
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForAssignment.Factory.equals(java.lang.Object):boolean");
                        }

                        public int hashCode() {
                            int hashCode = getClass().hashCode() * 31;
                            TypeDescription.Generic generic = this.result;
                            return generic != null ? hashCode + generic.hashCode() : hashCode;
                        }

                        public Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                            return new ForAssignment(this.result, assigner);
                        }
                    }

                    protected ForAssignment(@MaybeNull TypeDescription.Generic generic, Assigner assigner2) {
                        this.result = generic;
                        this.assigner = assigner2;
                    }

                    public static Factory castTo(Type type) {
                        return new Factory(TypeDefinition.Sort.describe(type));
                    }

                    public static Factory castToSubstitutionResult() {
                        return new Factory((TypeDescription.Generic) null);
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
                        if (r2 != null) goto L_0x0026;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                        /*
                            r4 = this;
                            r0 = 1
                            if (r4 != r5) goto L_0x0004
                            return r0
                        L_0x0004:
                            r1 = 0
                            if (r5 != 0) goto L_0x0008
                            return r1
                        L_0x0008:
                            java.lang.Class r2 = r4.getClass()
                            java.lang.Class r3 = r5.getClass()
                            if (r2 == r3) goto L_0x0013
                            return r1
                        L_0x0013:
                            net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.result
                            net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForAssignment r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForAssignment) r5
                            net.bytebuddy.description.type.TypeDescription$Generic r3 = r5.result
                            if (r3 == 0) goto L_0x0024
                            if (r2 == 0) goto L_0x0026
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L_0x0027
                            return r1
                        L_0x0024:
                            if (r2 == 0) goto L_0x0027
                        L_0x0026:
                            return r1
                        L_0x0027:
                            net.bytebuddy.implementation.bytecode.assign.Assigner r2 = r4.assigner
                            net.bytebuddy.implementation.bytecode.assign.Assigner r5 = r5.assigner
                            boolean r5 = r2.equals(r5)
                            if (r5 != 0) goto L_0x0032
                            return r1
                        L_0x0032:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForAssignment.equals(java.lang.Object):boolean");
                    }

                    public int hashCode() {
                        int hashCode = getClass().hashCode() * 31;
                        TypeDescription.Generic generic = this.result;
                        if (generic != null) {
                            hashCode += generic.hashCode();
                        }
                        return (hashCode * 31) + this.assigner.hashCode();
                    }

                    public Resolution resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i10) {
                        Assigner assigner2 = this.assigner;
                        TypeDescription.Generic generic4 = this.result;
                        if (generic4 == null) {
                            generic4 = generic2;
                        }
                        StackManipulation assign = assigner2.assign(generic3, generic4, Assigner.Typing.DYNAMIC);
                        if (!assign.isValid()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to assign ");
                            sb2.append(generic3);
                            sb2.append(" to ");
                            TypeDescription.Generic generic5 = this.result;
                            if (generic5 != null) {
                                generic2 = generic5;
                            }
                            sb2.append(generic2);
                            throw new IllegalStateException(sb2.toString());
                        }
                        TypeDescription.Generic generic6 = this.result;
                        if (generic6 != null) {
                            generic2 = generic6;
                        }
                        return new Simple(assign, generic2);
                    }

                    public static Factory castTo(TypeDescription.Generic generic) {
                        return new Factory(generic);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForDelegation implements Step {
                    private final Dispatcher.Resolved dispatcher;
                    private final List<OffsetMapping.Resolved> offsetMappings;
                    private final TypeDescription.Generic returned;

                    public interface BootstrapArgumentResolver {

                        public interface Factory {
                            BootstrapArgumentResolver make(MethodDescription.InDefinedShape inDefinedShape);
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForDefaultValues implements BootstrapArgumentResolver {
                            private final MethodDescription.InDefinedShape delegate;

                            public enum Factory implements Factory {
                                INSTANCE;

                                public BootstrapArgumentResolver make(MethodDescription.InDefinedShape inDefinedShape) {
                                    return new ForDefaultValues(inDefinedShape);
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Resolved implements Resolved {
                                private final MethodDescription.InDefinedShape delegate;
                                private final MethodDescription instrumentedMethod;
                                private final TypeDescription instrumentedType;

                                protected Resolved(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription) {
                                    this.delegate = inDefinedShape;
                                    this.instrumentedType = typeDescription;
                                    this.instrumentedMethod = methodDescription;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.delegate.equals(resolved.delegate) && this.instrumentedType.equals(resolved.instrumentedType) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return (((((getClass().hashCode() * 31) + this.delegate.hashCode()) * 31) + this.instrumentedType.hashCode()) * 31) + this.instrumentedMethod.hashCode();
                                }

                                public List<JavaConstant> make(TypeDescription typeDescription, ByteCodeElement.Member member, JavaConstant.MethodHandle methodHandle) {
                                    if (this.instrumentedMethod.isTypeInitializer()) {
                                        return Arrays.asList(new JavaConstant[]{JavaConstant.Simple.ofLoaded(this.delegate.getDeclaringType().getName()), JavaConstant.Simple.of(typeDescription), JavaConstant.Simple.ofLoaded(member.getInternalName()), methodHandle, JavaConstant.Simple.of(this.instrumentedType), JavaConstant.Simple.ofLoaded(this.instrumentedMethod.getInternalName())});
                                    }
                                    return Arrays.asList(new JavaConstant[]{JavaConstant.Simple.ofLoaded(this.delegate.getDeclaringType().getName()), JavaConstant.Simple.of(typeDescription), JavaConstant.Simple.ofLoaded(member.getInternalName()), methodHandle, JavaConstant.Simple.of(this.instrumentedType), JavaConstant.Simple.ofLoaded(this.instrumentedMethod.getInternalName()), JavaConstant.MethodHandle.of((MethodDescription.InDefinedShape) this.instrumentedMethod.asDefined())});
                                }
                            }

                            protected ForDefaultValues(MethodDescription.InDefinedShape inDefinedShape) {
                                this.delegate = inDefinedShape;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((ForDefaultValues) obj).delegate);
                            }

                            public int hashCode() {
                                return (getClass().hashCode() * 31) + this.delegate.hashCode();
                            }

                            public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Resolved(this.delegate, typeDescription, methodDescription);
                            }
                        }

                        public interface Resolved {
                            List<JavaConstant> make(TypeDescription typeDescription, ByteCodeElement.Member member, JavaConstant.MethodHandle methodHandle);
                        }

                        Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription);
                    }

                    protected interface Dispatcher {

                        public interface Factory {
                            Dispatcher make(MethodDescription.InDefinedShape inDefinedShape);
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForDynamicInvocation implements Dispatcher {
                            private final MethodDescription.InDefinedShape bootstrapMethod;
                            private final MethodDescription.InDefinedShape delegate;
                            private final BootstrapArgumentResolver resolver;

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Factory implements Factory {
                                private final MethodDescription.InDefinedShape bootstrapMethod;
                                private final BootstrapArgumentResolver.Factory resolverFactory;

                                protected Factory(MethodDescription.InDefinedShape inDefinedShape, BootstrapArgumentResolver.Factory factory) {
                                    this.bootstrapMethod = inDefinedShape;
                                    this.resolverFactory = factory;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Factory factory = (Factory) obj;
                                    return this.bootstrapMethod.equals(factory.bootstrapMethod) && this.resolverFactory.equals(factory.resolverFactory);
                                }

                                public int hashCode() {
                                    return (((getClass().hashCode() * 31) + this.bootstrapMethod.hashCode()) * 31) + this.resolverFactory.hashCode();
                                }

                                public Dispatcher make(MethodDescription.InDefinedShape inDefinedShape) {
                                    return new ForDynamicInvocation(this.bootstrapMethod, inDefinedShape, this.resolverFactory.make(inDefinedShape));
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Resolved implements Resolved {
                                private final MethodDescription.InDefinedShape bootstrapMethod;
                                private final MethodDescription.InDefinedShape delegate;
                                private final BootstrapArgumentResolver.Resolved resolver;

                                protected Resolved(MethodDescription.InDefinedShape inDefinedShape, MethodDescription.InDefinedShape inDefinedShape2, BootstrapArgumentResolver.Resolved resolved) {
                                    this.bootstrapMethod = inDefinedShape;
                                    this.delegate = inDefinedShape2;
                                    this.resolver = resolved;
                                }

                                public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, JavaConstant.MethodHandle methodHandle) {
                                    List<JavaConstant> make = this.resolver.make(typeDescription, member, methodHandle);
                                    if (this.bootstrapMethod.isInvokeBootstrap(TypeList.Explicit.of(make))) {
                                        return MethodInvocation.invoke(this.bootstrapMethod).dynamic(this.delegate.getInternalName(), this.delegate.getReturnType().asErasure(), this.delegate.getParameters().asTypeList().asErasures(), make);
                                    }
                                    throw new IllegalArgumentException(this.bootstrapMethod + " is not accepting advice bootstrap arguments: " + make);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.bootstrapMethod.equals(resolved.bootstrapMethod) && this.delegate.equals(resolved.delegate) && this.resolver.equals(resolved.resolver);
                                }

                                public int hashCode() {
                                    return (((((getClass().hashCode() * 31) + this.bootstrapMethod.hashCode()) * 31) + this.delegate.hashCode()) * 31) + this.resolver.hashCode();
                                }

                                public StackManipulation initialize() {
                                    return StackManipulation.Trivial.INSTANCE;
                                }
                            }

                            protected ForDynamicInvocation(MethodDescription.InDefinedShape inDefinedShape, MethodDescription.InDefinedShape inDefinedShape2, BootstrapArgumentResolver bootstrapArgumentResolver) {
                                this.bootstrapMethod = inDefinedShape;
                                this.delegate = inDefinedShape2;
                                this.resolver = bootstrapArgumentResolver;
                            }

                            protected static Factory of(MethodDescription.InDefinedShape inDefinedShape, BootstrapArgumentResolver.Factory factory) {
                                if (inDefinedShape.isInvokeBootstrap()) {
                                    return new Factory(inDefinedShape, factory);
                                }
                                throw new IllegalStateException("Not a bootstrap method: " + inDefinedShape);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                ForDynamicInvocation forDynamicInvocation = (ForDynamicInvocation) obj;
                                return this.bootstrapMethod.equals(forDynamicInvocation.bootstrapMethod) && this.delegate.equals(forDynamicInvocation.delegate) && this.resolver.equals(forDynamicInvocation.resolver);
                            }

                            public int hashCode() {
                                return (((((getClass().hashCode() * 31) + this.bootstrapMethod.hashCode()) * 31) + this.delegate.hashCode()) * 31) + this.resolver.hashCode();
                            }

                            public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Resolved(this.bootstrapMethod, this.delegate, this.resolver.resolve(typeDescription, methodDescription));
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForRegularInvocation implements Dispatcher, Resolved {
                            private final MethodDescription delegate;

                            protected enum Factory implements Factory {
                                INSTANCE;

                                public Dispatcher make(MethodDescription.InDefinedShape inDefinedShape) {
                                    return new ForRegularInvocation(inDefinedShape);
                                }
                            }

                            protected ForRegularInvocation(MethodDescription methodDescription) {
                                this.delegate = methodDescription;
                            }

                            public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, JavaConstant.MethodHandle methodHandle) {
                                return MethodInvocation.invoke(this.delegate);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((ForRegularInvocation) obj).delegate);
                            }

                            public int hashCode() {
                                return (getClass().hashCode() * 31) + this.delegate.hashCode();
                            }

                            public StackManipulation initialize() {
                                if (!this.delegate.isConstructor()) {
                                    return StackManipulation.Trivial.INSTANCE;
                                }
                                return new StackManipulation.Compound(TypeCreation.of(this.delegate.getDeclaringType().asErasure()), Duplication.SINGLE);
                            }

                            public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                return this;
                            }
                        }

                        public interface Resolved {
                            StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, JavaConstant.MethodHandle methodHandle);

                            StackManipulation initialize();
                        }

                        Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription);
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    protected static class Factory implements Factory {
                        private final MethodDescription.InDefinedShape delegate;
                        private final Dispatcher dispatcher;
                        private final List<OffsetMapping> offsetMappings;

                        protected Factory(MethodDescription.InDefinedShape inDefinedShape, Dispatcher dispatcher2, List<? extends OffsetMapping.Factory<?>> list) {
                            MethodDescription.InDefinedShape inDefinedShape2 = inDefinedShape;
                            HashMap hashMap = new HashMap();
                            for (OffsetMapping.Factory factory : list) {
                                hashMap.put(TypeDescription.ForLoadedType.of(factory.getAnnotationType()), factory);
                            }
                            this.offsetMappings = new ArrayList(list.size());
                            if (inDefinedShape.isMethod() && !inDefinedShape.isStatic()) {
                                OffsetMapping offsetMapping = null;
                                for (AnnotationDescription annotationDescription : inDefinedShape.getDeclaredAnnotations()) {
                                    OffsetMapping.Factory factory2 = (OffsetMapping.Factory) hashMap.get(annotationDescription.getAnnotationType());
                                    if (factory2 != null) {
                                        OffsetMapping make = factory2.make(inDefinedShape2, annotationDescription.prepare(factory2.getAnnotationType()));
                                        if (offsetMapping == null) {
                                            offsetMapping = make;
                                        } else {
                                            throw new IllegalStateException(inDefinedShape2 + " is bound to both " + make + " and " + offsetMapping);
                                        }
                                    }
                                }
                                this.offsetMappings.add(offsetMapping == null ? new OffsetMapping.ForThisReference(inDefinedShape.getDeclaringType().asGenericType(), (Assigner.Typing) null, Source.SUBSTITUTED_ELEMENT, false) : offsetMapping);
                            }
                            for (int i10 = 0; i10 < inDefinedShape.getParameters().size(); i10++) {
                                ParameterDescription.InDefinedShape inDefinedShape3 = (ParameterDescription.InDefinedShape) inDefinedShape.getParameters().get(i10);
                                OffsetMapping offsetMapping2 = null;
                                for (AnnotationDescription annotationDescription2 : inDefinedShape3.getDeclaredAnnotations()) {
                                    OffsetMapping.Factory factory3 = (OffsetMapping.Factory) hashMap.get(annotationDescription2.getAnnotationType());
                                    if (factory3 != null) {
                                        OffsetMapping make2 = factory3.make(inDefinedShape3, annotationDescription2.prepare(factory3.getAnnotationType()));
                                        if (offsetMapping2 == null) {
                                            offsetMapping2 = make2;
                                        } else {
                                            throw new IllegalStateException(inDefinedShape3 + " is bound to both " + make2 + " and " + offsetMapping2);
                                        }
                                    }
                                }
                                List<OffsetMapping> list2 = this.offsetMappings;
                                if (offsetMapping2 == null) {
                                    offsetMapping2 = new OffsetMapping.ForArgument(inDefinedShape3.getType(), i10, (Assigner.Typing) null, Source.SUBSTITUTED_ELEMENT, false);
                                }
                                list2.add(offsetMapping2);
                            }
                            this.delegate = inDefinedShape2;
                            this.dispatcher = dispatcher2;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Factory factory = (Factory) obj;
                            return this.delegate.equals(factory.delegate) && this.dispatcher.equals(factory.dispatcher) && this.offsetMappings.equals(factory.offsetMappings);
                        }

                        public int hashCode() {
                            return (((((getClass().hashCode() * 31) + this.delegate.hashCode()) * 31) + this.dispatcher.hashCode()) * 31) + this.offsetMappings.hashCode();
                        }

                        public Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                            ArrayList arrayList = new ArrayList(this.offsetMappings.size());
                            for (OffsetMapping resolve : this.offsetMappings) {
                                arrayList.add(resolve.resolve(assigner, typing, typeDescription, methodDescription));
                            }
                            return new ForDelegation(this.delegate.getReturnType(), this.dispatcher.resolve(typeDescription, methodDescription), arrayList);
                        }
                    }

                    public static class WithCustomMapping {
                        private final Dispatcher.Factory dispatcherFactory;
                        private final Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> offsetMappings;

                        protected WithCustomMapping(Dispatcher.Factory factory, Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> map) {
                            this.dispatcherFactory = factory;
                            this.offsetMappings = map;
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, @MaybeNull Object obj) {
                            return bind(OffsetMapping.ForStackManipulation.of(cls, obj));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, Object... objArr) {
                            return bindDynamic(cls, method, (List<?>) Arrays.asList(objArr));
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor, Class<?> cls2) {
                            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), TypeDescription.ForLoadedType.of(cls2));
                        }

                        public <T extends Annotation> WithCustomMapping bindProperty(Class<T> cls, String str) {
                            return bind(OffsetMapping.ForStackManipulation.OfAnnotationProperty.of(cls, str));
                        }

                        public <T extends Annotation> WithCustomMapping bindSerialized(Class<T> cls, Serializable serializable) {
                            return bindSerialized(cls, serializable, serializable.getClass());
                        }

                        public WithCustomMapping bootstrap(Constructor<?> constructor) {
                            return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor));
                        }

                        public Factory to(Method method) {
                            return to((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Field field) {
                            return bind(cls, (FieldDescription) new FieldDescription.ForLoadedField(field));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, List<?> list) {
                            return bindDynamic(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), list);
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor, Class<?> cls2, MethodGraph.Compiler compiler) {
                            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), TypeDescription.ForLoadedType.of(cls2), compiler);
                        }

                        public <T extends Annotation, S extends Serializable> WithCustomMapping bindSerialized(Class<T> cls, S s10, Class<? super S> cls2) {
                            return bind(OffsetMapping.ForStackManipulation.OfSerializedConstant.of(cls, s10, cls2));
                        }

                        public WithCustomMapping bootstrap(Constructor<?> constructor, BootstrapArgumentResolver.Factory factory) {
                            return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), factory);
                        }

                        public Factory to(Constructor<?> constructor) {
                            return to((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, FieldDescription fieldDescription) {
                            return bind(new OffsetMapping.ForField.Resolved.Factory(cls, fieldDescription));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor, Object... objArr) {
                            return bindDynamic(cls, constructor, (List<?>) Arrays.asList(objArr));
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2) {
                            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls2));
                        }

                        public WithCustomMapping bootstrap(Method method) {
                            return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method));
                        }

                        public Factory to(MethodDescription.InDefinedShape inDefinedShape) {
                            return ForDelegation.to(inDefinedShape, this.dispatcherFactory, new ArrayList(this.offsetMappings.values()));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Class<?> cls2) {
                            return bind(cls, TypeDescription.ForLoadedType.of(cls2));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor, List<?> list) {
                            return bindDynamic(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), list);
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2, MethodGraph.Compiler compiler) {
                            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls2), compiler);
                        }

                        public WithCustomMapping bootstrap(Method method, BootstrapArgumentResolver.Factory factory) {
                            return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), factory);
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, TypeDescription typeDescription) {
                            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, ConstantValue.Simple.wrap(typeDescription)));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
                            return bindDynamic(cls, inDefinedShape, (List<?>) Arrays.asList(objArr));
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
                            return bindLambda(cls, inDefinedShape, typeDescription, MethodGraph.Compiler.DEFAULT);
                        }

                        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape) {
                            return bootstrap(inDefinedShape, (BootstrapArgumentResolver.Factory) BootstrapArgumentResolver.ForDefaultValues.Factory.INSTANCE);
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Enum<?> enumR) {
                            return bind(cls, (EnumerationDescription) new EnumerationDescription.ForLoadedEnumeration(enumR));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, List<?> list) {
                            List<JavaConstant> wrap = JavaConstant.Simple.wrap(list);
                            if (inDefinedShape.isInvokeBootstrap(TypeList.Explicit.of(wrap))) {
                                return bind(new OffsetMapping.ForStackManipulation.OfDynamicInvocation(cls, inDefinedShape, wrap));
                            }
                            throw new IllegalArgumentException("Not a valid bootstrap method " + inDefinedShape + " for " + wrap);
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodGraph.Compiler compiler) {
                            TypeDescription typeDescription2 = typeDescription;
                            if (typeDescription.isInterface()) {
                                MethodList methodList = (MethodList) compiler.compile((TypeDefinition) typeDescription2).listNodes().asMethodList().filter(ElementMatchers.isAbstract());
                                if (methodList.size() == 1) {
                                    TypeDescription.Latent latent = new TypeDescription.Latent("java.lang.invoke.LambdaMetafactory", 1, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), new TypeDescription.Generic[0]);
                                    List emptyList = Collections.emptyList();
                                    TypeDescription.Generic asGenericType = JavaType.CALL_SITE.getTypeStub().asGenericType();
                                    JavaType javaType = JavaType.METHOD_TYPE;
                                    return bindDynamic(cls, (MethodDescription.InDefinedShape) new MethodDescription.Latent(latent, "metafactory", 9, emptyList, asGenericType, Arrays.asList(new ParameterDescription.Token[]{new ParameterDescription.Token(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType()), new ParameterDescription.Token(TypeDescription.ForLoadedType.of(String.class).asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_HANDLE.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType())}), Collections.emptyList(), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED), JavaConstant.MethodType.ofSignature((MethodDescription) methodList.asDefined().getOnly()), JavaConstant.MethodHandle.of(inDefinedShape), JavaConstant.MethodType.ofSignature((MethodDescription) methodList.asDefined().getOnly()));
                                }
                                throw new IllegalArgumentException(typeDescription2 + " does not define exactly one abstract method: " + methodList);
                            }
                            throw new IllegalArgumentException(typeDescription2 + " is not an interface type");
                        }

                        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape, BootstrapArgumentResolver.Factory factory) {
                            return new WithCustomMapping(Dispatcher.ForDynamicInvocation.of(inDefinedShape, factory), this.offsetMappings);
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, EnumerationDescription enumerationDescription) {
                            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, ConstantValue.Simple.wrap(enumerationDescription)));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, ConstantValue constantValue) {
                            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, constantValue.toStackManipulation(), constantValue.getTypeDescription().asGenericType()));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation, Type type) {
                            return bind(cls, stackManipulation, TypeDefinition.Sort.describe(type));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation, TypeDescription.Generic generic) {
                            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, stackManipulation, generic));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, OffsetMapping offsetMapping) {
                            return bind(new OffsetMapping.Factory.Simple(cls, offsetMapping));
                        }

                        public WithCustomMapping bind(OffsetMapping.Factory<?> factory) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap(this.offsetMappings);
                            if (!factory.getAnnotationType().isAnnotation()) {
                                throw new IllegalArgumentException("Not an annotation type: " + factory.getAnnotationType());
                            } else if (linkedHashMap.put(factory.getAnnotationType(), factory) == null) {
                                return new WithCustomMapping(this.dispatcherFactory, linkedHashMap);
                            } else {
                                throw new IllegalArgumentException("Annotation type already mapped: " + factory.getAnnotationType());
                            }
                        }
                    }

                    protected ForDelegation(TypeDescription.Generic generic, Dispatcher.Resolved resolved, List<OffsetMapping.Resolved> list) {
                        this.returned = generic;
                        this.dispatcher = resolved;
                        this.offsetMappings = list;
                    }

                    public static Factory to(Method method) {
                        return to((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method));
                    }

                    public static WithCustomMapping withCustomMapping() {
                        return new WithCustomMapping(Dispatcher.ForRegularInvocation.Factory.INSTANCE, Collections.emptyMap());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForDelegation forDelegation = (ForDelegation) obj;
                        return this.returned.equals(forDelegation.returned) && this.dispatcher.equals(forDelegation.dispatcher) && this.offsetMappings.equals(forDelegation.offsetMappings);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.returned.hashCode()) * 31) + this.dispatcher.hashCode()) * 31) + this.offsetMappings.hashCode();
                    }

                    public Resolution resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i10) {
                        Object obj;
                        ArrayList arrayList = new ArrayList(this.offsetMappings.size() + 3);
                        if (generic3.represents(Void.TYPE)) {
                            obj = StackManipulation.Trivial.INSTANCE;
                            int i11 = i10;
                        } else {
                            obj = MethodVariableAccess.of(generic3).storeAt(i10);
                        }
                        arrayList.add(obj);
                        arrayList.add(this.dispatcher.initialize());
                        for (OffsetMapping.Resolved apply : this.offsetMappings) {
                            arrayList.add(apply.apply(typeDescription, member, generic, generic2, generic3, methodHandle, map, i10));
                        }
                        TypeDescription typeDescription2 = typeDescription;
                        arrayList.add(this.dispatcher.apply(typeDescription, member, methodHandle));
                        return new Simple((StackManipulation) new StackManipulation.Compound((List<? extends StackManipulation>) arrayList), this.returned);
                    }

                    public static Factory to(Constructor<?> constructor) {
                        return to((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor));
                    }

                    public interface OffsetMapping {

                        public interface Factory<T extends Annotation> {

                            public static abstract class AbstractBase<S extends Annotation> implements Factory<S> {
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<S> loadable) {
                                    return make(inDefinedShape.getDeclaringType().asGenericType(), loadable);
                                }

                                /* access modifiers changed from: protected */
                                public abstract OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<S> loadable);

                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<S> loadable) {
                                    return make(inDefinedShape.getType(), loadable);
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Simple<S extends Annotation> extends AbstractBase<S> {
                                private final Class<S> annotationType;
                                private final OffsetMapping offsetMapping;

                                public Simple(Class<S> cls, OffsetMapping offsetMapping2) {
                                    this.annotationType = cls;
                                    this.offsetMapping = offsetMapping2;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Simple simple = (Simple) obj;
                                    return this.annotationType.equals(simple.annotationType) && this.offsetMapping.equals(simple.offsetMapping);
                                }

                                public Class<S> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return (((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.offsetMapping.hashCode();
                                }

                                /* access modifiers changed from: protected */
                                public OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<S> loadable) {
                                    return this.offsetMapping;
                                }
                            }

                            public static abstract class WithParameterSupportOnly<S extends Annotation> implements Factory<S> {
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<S> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }
                            }

                            Class<T> getAnnotationType();

                            OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable);

                            OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable);
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForAllArguments implements OffsetMapping {
                            private final boolean includeSelf;
                            private final boolean nullIfEmpty;
                            private final Source source;
                            private final TypeDescription.Generic targetComponentType;
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            @MaybeNull
                            private final Assigner.Typing typing;

                            protected enum Factory implements Factory<AllArguments> {
                                INSTANCE;
                                
                                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_INCLUDE_SELF = null;
                                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_NULL_IF_EMPTY = null;
                                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_SOURCE = null;
                                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_TYPING = null;

                                static {
                                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(AllArguments.class).getDeclaredMethods();
                                    ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                                    ALL_ARGUMENTS_SOURCE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("source"))).getOnly();
                                    ALL_ARGUMENTS_INCLUDE_SELF = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("includeSelf"))).getOnly();
                                    ALL_ARGUMENTS_NULL_IF_EMPTY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("nullIfEmpty"))).getOnly();
                                }

                                public Class<AllArguments> getAnnotationType() {
                                    return AllArguments.class;
                                }

                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<AllArguments> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<AllArguments> loadable) {
                                    Class<Boolean> cls = Boolean.class;
                                    Class<EnumerationDescription> cls2 = EnumerationDescription.class;
                                    if (inDefinedShape.getType().isArray()) {
                                        return new ForAllArguments(inDefinedShape.getType().getComponentType(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ALL_ARGUMENTS_TYPING).resolve(cls2)).load(Assigner.Typing.class), (Source) ((EnumerationDescription) loadable.getValue(ALL_ARGUMENTS_SOURCE).resolve(cls2)).load(Source.class), ((Boolean) loadable.getValue(ALL_ARGUMENTS_INCLUDE_SELF).resolve(cls)).booleanValue(), ((Boolean) loadable.getValue(ALL_ARGUMENTS_NULL_IF_EMPTY).resolve(cls)).booleanValue());
                                    }
                                    throw new IllegalStateException("Expected array as parameter type for " + inDefinedShape);
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Resolved implements Resolved {
                                private final Assigner assigner;
                                private final boolean includeSelf;
                                private final MethodDescription instrumentedMethod;
                                private final boolean nullIfEmpty;
                                private final Source source;
                                private final TypeDescription.Generic targetComponentType;
                                private final Assigner.Typing typing;

                                protected Resolved(TypeDescription.Generic generic, Assigner.Typing typing2, Source source2, boolean z10, boolean z11, Assigner assigner2, MethodDescription methodDescription) {
                                    this.targetComponentType = generic;
                                    this.typing = typing2;
                                    this.source = source2;
                                    this.includeSelf = z10;
                                    this.nullIfEmpty = z11;
                                    this.assigner = assigner2;
                                    this.instrumentedMethod = methodDescription;
                                }

                                public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10) {
                                    List<Source.Value> arguments = this.source.arguments(this.includeSelf, generic, map, member, this.instrumentedMethod);
                                    if (this.nullIfEmpty && arguments.isEmpty()) {
                                        return NullConstant.INSTANCE;
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    for (Source.Value next : arguments) {
                                        StackManipulation assign = this.assigner.assign(next.getTypeDescription(), this.targetComponentType, this.typing);
                                        if (assign.isValid()) {
                                            arrayList.add(new StackManipulation.Compound(MethodVariableAccess.of(next.getTypeDescription()).loadFrom(next.getOffset()), assign));
                                        } else {
                                            throw new IllegalStateException("Cannot assign " + next.getTypeDescription() + " to " + this.targetComponentType);
                                        }
                                    }
                                    return ArrayFactory.forType(this.targetComponentType).withValues(arrayList);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.includeSelf == resolved.includeSelf && this.nullIfEmpty == resolved.nullIfEmpty && this.typing.equals(resolved.typing) && this.source.equals(resolved.source) && this.targetComponentType.equals(resolved.targetComponentType) && this.assigner.equals(resolved.assigner) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return (((((((((((((getClass().hashCode() * 31) + this.targetComponentType.hashCode()) * 31) + this.typing.hashCode()) * 31) + this.source.hashCode()) * 31) + (this.includeSelf ? 1 : 0)) * 31) + (this.nullIfEmpty ? 1 : 0)) * 31) + this.assigner.hashCode()) * 31) + this.instrumentedMethod.hashCode();
                                }
                            }

                            public ForAllArguments(TypeDescription.Generic generic, @MaybeNull Assigner.Typing typing2, Source source2, boolean z10, boolean z11) {
                                this.targetComponentType = generic;
                                this.typing = typing2;
                                this.source = source2;
                                this.includeSelf = z10;
                                this.nullIfEmpty = z11;
                            }

                            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
                                if (r2 != null) goto L_0x0034;
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L_0x0004
                                    return r0
                                L_0x0004:
                                    r1 = 0
                                    if (r5 != 0) goto L_0x0008
                                    return r1
                                L_0x0008:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L_0x0013
                                    return r1
                                L_0x0013:
                                    boolean r2 = r4.includeSelf
                                    net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$ForAllArguments r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForAllArguments) r5
                                    boolean r3 = r5.includeSelf
                                    if (r2 == r3) goto L_0x001c
                                    return r1
                                L_0x001c:
                                    boolean r2 = r4.nullIfEmpty
                                    boolean r3 = r5.nullIfEmpty
                                    if (r2 == r3) goto L_0x0023
                                    return r1
                                L_0x0023:
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = r4.typing
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r3 = r5.typing
                                    if (r3 == 0) goto L_0x0032
                                    if (r2 == 0) goto L_0x0034
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x0035
                                    return r1
                                L_0x0032:
                                    if (r2 == 0) goto L_0x0035
                                L_0x0034:
                                    return r1
                                L_0x0035:
                                    net.bytebuddy.asm.MemberSubstitution$Source r2 = r4.source
                                    net.bytebuddy.asm.MemberSubstitution$Source r3 = r5.source
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x0040
                                    return r1
                                L_0x0040:
                                    net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.targetComponentType
                                    net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.targetComponentType
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L_0x004b
                                    return r1
                                L_0x004b:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForAllArguments.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int hashCode = ((getClass().hashCode() * 31) + this.targetComponentType.hashCode()) * 31;
                                Assigner.Typing typing2 = this.typing;
                                if (typing2 != null) {
                                    hashCode += typing2.hashCode();
                                }
                                return (((((hashCode * 31) + this.source.hashCode()) * 31) + (this.includeSelf ? 1 : 0)) * 31) + (this.nullIfEmpty ? 1 : 0);
                            }

                            public Resolved resolve(Assigner assigner, Assigner.Typing typing2, TypeDescription typeDescription, MethodDescription methodDescription) {
                                TypeDescription.Generic generic = this.targetComponentType;
                                Assigner.Typing typing3 = this.typing;
                                return new Resolved(generic, typing3 == null ? typing2 : typing3, this.source, this.includeSelf, this.nullIfEmpty, assigner, methodDescription);
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForCurrent implements OffsetMapping {
                            private final TypeDescription.Generic targetType;
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            @MaybeNull
                            private final Assigner.Typing typing;

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Resolved implements Resolved {
                                private final Assigner assigner;
                                private final TypeDescription.Generic targetType;
                                private final Assigner.Typing typing;

                                public Resolved(TypeDescription.Generic generic, Assigner assigner2, Assigner.Typing typing2) {
                                    this.targetType = generic;
                                    this.assigner = assigner2;
                                    this.typing = typing2;
                                }

                                public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10) {
                                    StackManipulation assign = this.assigner.assign(generic3, this.targetType, this.typing);
                                    if (assign.isValid()) {
                                        return new StackManipulation.Compound(MethodVariableAccess.of(generic3).loadFrom(i10), assign);
                                    }
                                    throw new IllegalStateException("Cannot assign " + generic3 + " to " + this.targetType);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.typing.equals(resolved.typing) && this.targetType.equals(resolved.targetType) && this.assigner.equals(resolved.assigner);
                                }

                                public int hashCode() {
                                    return (((((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31) + this.assigner.hashCode()) * 31) + this.typing.hashCode();
                                }
                            }

                            public ForCurrent(TypeDescription.Generic generic, @MaybeNull Assigner.Typing typing2) {
                                this.targetType = generic;
                                this.typing = typing2;
                            }

                            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
                                if (r2 != null) goto L_0x0026;
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L_0x0004
                                    return r0
                                L_0x0004:
                                    r1 = 0
                                    if (r5 != 0) goto L_0x0008
                                    return r1
                                L_0x0008:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L_0x0013
                                    return r1
                                L_0x0013:
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = r4.typing
                                    net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$ForCurrent r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForCurrent) r5
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r3 = r5.typing
                                    if (r3 == 0) goto L_0x0024
                                    if (r2 == 0) goto L_0x0026
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x0027
                                    return r1
                                L_0x0024:
                                    if (r2 == 0) goto L_0x0027
                                L_0x0026:
                                    return r1
                                L_0x0027:
                                    net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.targetType
                                    net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.targetType
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L_0x0032
                                    return r1
                                L_0x0032:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForCurrent.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int hashCode = ((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31;
                                Assigner.Typing typing2 = this.typing;
                                return typing2 != null ? hashCode + typing2.hashCode() : hashCode;
                            }

                            public Resolved resolve(Assigner assigner, Assigner.Typing typing2, TypeDescription typeDescription, MethodDescription methodDescription) {
                                TypeDescription.Generic generic = this.targetType;
                                Assigner.Typing typing3 = this.typing;
                                if (typing3 != null) {
                                    typing2 = typing3;
                                }
                                return new Resolved(generic, assigner, typing2);
                            }

                            protected enum Factory implements Factory<Current> {
                                INSTANCE;
                                
                                private static final MethodDescription.InDefinedShape CURRENT_TYPING = null;

                                static {
                                    CURRENT_TYPING = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Current.class).getDeclaredMethods().filter(ElementMatchers.named("typing"))).getOnly();
                                }

                                public Class<Current> getAnnotationType() {
                                    return Current.class;
                                }

                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Current> loadable) {
                                    return new ForCurrent(inDefinedShape.getDeclaringType().asGenericType(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(CURRENT_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
                                }

                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Current> loadable) {
                                    return new ForCurrent(inDefinedShape.getType(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(CURRENT_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
                                }
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static abstract class ForField implements OffsetMapping {
                            /* access modifiers changed from: private */
                            public static final MethodDescription.InDefinedShape FIELD_VALUE_DECLARING_TYPE;
                            /* access modifiers changed from: private */
                            public static final MethodDescription.InDefinedShape FIELD_VALUE_TYPING;
                            /* access modifiers changed from: private */
                            public static final MethodDescription.InDefinedShape FIELD_VALUE_VALUE;
                            private final TypeDescription.Generic target;
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            @MaybeNull
                            private final Assigner.Typing typing;

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved extends ForField {
                                private final FieldDescription fieldDescription;

                                @HashCodeAndEqualsPlugin.Enhance
                                public static class Factory<T extends Annotation> extends Factory.AbstractBase<T> {
                                    private final Class<T> annotationType;
                                    private final FieldDescription fieldDescription;
                                    private final Assigner.Typing typing;

                                    public Factory(Class<T> cls, FieldDescription fieldDescription2) {
                                        this(cls, fieldDescription2, Assigner.Typing.STATIC);
                                    }

                                    public boolean equals(@MaybeNull Object obj) {
                                        if (this == obj) {
                                            return true;
                                        }
                                        if (obj == null || getClass() != obj.getClass()) {
                                            return false;
                                        }
                                        Factory factory = (Factory) obj;
                                        return this.typing.equals(factory.typing) && this.annotationType.equals(factory.annotationType) && this.fieldDescription.equals(factory.fieldDescription);
                                    }

                                    public Class<T> getAnnotationType() {
                                        return this.annotationType;
                                    }

                                    public int hashCode() {
                                        return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.fieldDescription.hashCode()) * 31) + this.typing.hashCode();
                                    }

                                    /* access modifiers changed from: protected */
                                    public OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<T> loadable) {
                                        return new Resolved(generic, this.typing, this.fieldDescription);
                                    }

                                    public Factory(Class<T> cls, FieldDescription fieldDescription2, Assigner.Typing typing2) {
                                        this.annotationType = cls;
                                        this.fieldDescription = fieldDescription2;
                                        this.typing = typing2;
                                    }
                                }

                                public Resolved(TypeDescription.Generic generic, Assigner.Typing typing, FieldDescription fieldDescription2) {
                                    super(generic, typing);
                                    this.fieldDescription = fieldDescription2;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (!super.equals(obj)) {
                                        return false;
                                    }
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Resolved) obj).fieldDescription);
                                }

                                public int hashCode() {
                                    return (super.hashCode() * 31) + this.fieldDescription.hashCode();
                                }

                                /* access modifiers changed from: protected */
                                @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                    if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
                                        throw new IllegalStateException(this.fieldDescription + " is no member of " + typeDescription);
                                    } else if (this.fieldDescription.isVisibleTo(typeDescription)) {
                                        return this.fieldDescription;
                                    } else {
                                        throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                                    }
                                }
                            }

                            static {
                                MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldValue.class).getDeclaredMethods();
                                FIELD_VALUE_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                                FIELD_VALUE_DECLARING_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("declaringType"))).getOnly();
                                FIELD_VALUE_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                            }

                            protected ForField(TypeDescription.Generic generic, @MaybeNull Assigner.Typing typing2) {
                                this.target = generic;
                                this.typing = typing2;
                            }

                            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
                                if (r2 != null) goto L_0x0026;
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L_0x0004
                                    return r0
                                L_0x0004:
                                    r1 = 0
                                    if (r5 != 0) goto L_0x0008
                                    return r1
                                L_0x0008:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L_0x0013
                                    return r1
                                L_0x0013:
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = r4.typing
                                    net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$ForField r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField) r5
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r3 = r5.typing
                                    if (r3 == 0) goto L_0x0024
                                    if (r2 == 0) goto L_0x0026
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x0027
                                    return r1
                                L_0x0024:
                                    if (r2 == 0) goto L_0x0027
                                L_0x0026:
                                    return r1
                                L_0x0027:
                                    net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.target
                                    net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.target
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L_0x0032
                                    return r1
                                L_0x0032:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int hashCode = ((getClass().hashCode() * 31) + this.target.hashCode()) * 31;
                                Assigner.Typing typing2 = this.typing;
                                return typing2 != null ? hashCode + typing2.hashCode() : hashCode;
                            }

                            public Resolved resolve(Assigner assigner, Assigner.Typing typing2, TypeDescription typeDescription, MethodDescription methodDescription) {
                                StackManipulation stackManipulation;
                                FieldDescription resolve = resolve(typeDescription, methodDescription);
                                if (resolve.isStatic() || !methodDescription.isStatic()) {
                                    TypeDescription.Generic type = resolve.getType();
                                    TypeDescription.Generic generic = this.target;
                                    Assigner.Typing typing3 = this.typing;
                                    if (typing3 != null) {
                                        typing2 = typing3;
                                    }
                                    StackManipulation assign = assigner.assign(type, generic, typing2);
                                    if (assign.isValid()) {
                                        StackManipulation[] stackManipulationArr = new StackManipulation[3];
                                        if (resolve.isStatic()) {
                                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                                        } else {
                                            stackManipulation = MethodVariableAccess.loadThis();
                                        }
                                        stackManipulationArr[0] = stackManipulation;
                                        stackManipulationArr[1] = FieldAccess.forField(resolve).read();
                                        stackManipulationArr[2] = assign;
                                        return new Resolved.ForStackManipulation(new StackManipulation.Compound(stackManipulationArr));
                                    }
                                    throw new IllegalStateException("Cannot assign " + resolve + " to " + this.target);
                                }
                                throw new IllegalStateException("Cannot access non-static field " + resolve + " from static method " + methodDescription);
                            }

                            /* access modifiers changed from: protected */
                            public abstract FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription);

                            @HashCodeAndEqualsPlugin.Enhance
                            public static abstract class Unresolved extends ForField {
                                protected static final String BEAN_PROPERTY = "";
                                private final String name;

                                protected Unresolved(TypeDescription.Generic generic, Assigner.Typing typing, String str) {
                                    super(generic, typing);
                                    this.name = str;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (!super.equals(obj)) {
                                        return false;
                                    }
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.name.equals(((Unresolved) obj).name);
                                }

                                /* access modifiers changed from: protected */
                                public abstract FieldLocator fieldLocator(TypeDescription typeDescription);

                                public int hashCode() {
                                    return (super.hashCode() * 31) + this.name.hashCode();
                                }

                                /* access modifiers changed from: protected */
                                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                    FieldLocator.Resolution resolution;
                                    FieldLocator fieldLocator = fieldLocator(typeDescription);
                                    if (this.name.equals("")) {
                                        resolution = FieldLocator.Resolution.Simple.ofBeanAccessor(fieldLocator, methodDescription);
                                    } else {
                                        resolution = fieldLocator.locate(this.name);
                                    }
                                    if (resolution.isResolved()) {
                                        return resolution.getField();
                                    }
                                    throw new IllegalStateException("Cannot locate field named " + this.name + " for " + typeDescription);
                                }

                                @HashCodeAndEqualsPlugin.Enhance
                                public static class WithExplicitType extends Unresolved {
                                    private final TypeDescription declaringType;

                                    protected WithExplicitType(TypeDescription.Generic generic, AnnotationDescription.Loadable<FieldValue> loadable, TypeDescription typeDescription) {
                                        this(generic, (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ForField.FIELD_VALUE_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (String) loadable.getValue(ForField.FIELD_VALUE_VALUE).resolve(String.class), typeDescription);
                                    }

                                    public boolean equals(@MaybeNull Object obj) {
                                        if (!super.equals(obj)) {
                                            return false;
                                        }
                                        if (this == obj) {
                                            return true;
                                        }
                                        return obj != null && getClass() == obj.getClass() && this.declaringType.equals(((WithExplicitType) obj).declaringType);
                                    }

                                    /* access modifiers changed from: protected */
                                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                                        if (this.declaringType.represents(TargetType.class) || typeDescription.isAssignableTo(this.declaringType)) {
                                            return new FieldLocator.ForExactType(TargetType.resolve(this.declaringType, typeDescription));
                                        }
                                        throw new IllegalStateException(this.declaringType + " is no super type of " + typeDescription);
                                    }

                                    public int hashCode() {
                                        return (super.hashCode() * 31) + this.declaringType.hashCode();
                                    }

                                    public WithExplicitType(TypeDescription.Generic generic, Assigner.Typing typing, String str, TypeDescription typeDescription) {
                                        super(generic, typing, str);
                                        this.declaringType = typeDescription;
                                    }
                                }

                                public static class WithImplicitType extends Unresolved {
                                    protected WithImplicitType(TypeDescription.Generic generic, AnnotationDescription.Loadable<FieldValue> loadable) {
                                        this(generic, (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ForField.FIELD_VALUE_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (String) loadable.getValue(ForField.FIELD_VALUE_VALUE).resolve(String.class));
                                    }

                                    /* access modifiers changed from: protected */
                                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                                        return new FieldLocator.ForClassHierarchy(typeDescription);
                                    }

                                    public WithImplicitType(TypeDescription.Generic generic, Assigner.Typing typing, String str) {
                                        super(generic, typing, str);
                                    }
                                }

                                protected enum Factory implements Factory<FieldValue> {
                                    INSTANCE;

                                    public Class<FieldValue> getAnnotationType() {
                                        return FieldValue.class;
                                    }

                                    public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldValue> loadable) {
                                        TypeDescription typeDescription = (TypeDescription) loadable.getValue(ForField.FIELD_VALUE_DECLARING_TYPE).resolve(TypeDescription.class);
                                        if (typeDescription.represents(Void.TYPE)) {
                                            return new WithImplicitType(inDefinedShape.getDeclaringType().asGenericType(), loadable);
                                        }
                                        return new WithExplicitType(inDefinedShape.getDeclaringType().asGenericType(), loadable, typeDescription);
                                    }

                                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldValue> loadable) {
                                        TypeDescription typeDescription = (TypeDescription) loadable.getValue(ForField.FIELD_VALUE_DECLARING_TYPE).resolve(TypeDescription.class);
                                        if (typeDescription.represents(Void.TYPE)) {
                                            return new WithImplicitType(inDefinedShape.getType(), loadable);
                                        }
                                        return new WithExplicitType(inDefinedShape.getType(), loadable, typeDescription);
                                    }
                                }
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static abstract class ForFieldHandle implements OffsetMapping {
                            private final Access access;

                            public enum Access {
                                GETTER {
                                    /* access modifiers changed from: protected */
                                    public JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape) {
                                        return JavaConstant.MethodHandle.ofGetter(inDefinedShape);
                                    }
                                },
                                SETTER {
                                    /* access modifiers changed from: protected */
                                    public JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape) {
                                        return JavaConstant.MethodHandle.ofSetter(inDefinedShape);
                                    }
                                };

                                /* access modifiers changed from: protected */
                                public abstract JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape);
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved extends ForFieldHandle {
                                private final FieldDescription fieldDescription;

                                @HashCodeAndEqualsPlugin.Enhance
                                public static class Factory<T extends Annotation> implements Factory<T> {
                                    private final Access access;
                                    private final Class<T> annotationType;
                                    private final FieldDescription fieldDescription;

                                    public Factory(Class<T> cls, FieldDescription fieldDescription2, Access access2) {
                                        this.annotationType = cls;
                                        this.fieldDescription = fieldDescription2;
                                        this.access = access2;
                                    }

                                    public boolean equals(@MaybeNull Object obj) {
                                        if (this == obj) {
                                            return true;
                                        }
                                        if (obj == null || getClass() != obj.getClass()) {
                                            return false;
                                        }
                                        Factory factory = (Factory) obj;
                                        return this.access.equals(factory.access) && this.annotationType.equals(factory.annotationType) && this.fieldDescription.equals(factory.fieldDescription);
                                    }

                                    public Class<T> getAnnotationType() {
                                        return this.annotationType;
                                    }

                                    public int hashCode() {
                                        return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.fieldDescription.hashCode()) * 31) + this.access.hashCode();
                                    }

                                    public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable) {
                                        throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                    }

                                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable) {
                                        if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                                            return new Resolved(this.access, this.fieldDescription);
                                        }
                                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                                    }
                                }

                                public Resolved(Access access, FieldDescription fieldDescription2) {
                                    super(access);
                                    this.fieldDescription = fieldDescription2;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (!super.equals(obj)) {
                                        return false;
                                    }
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Resolved) obj).fieldDescription);
                                }

                                public int hashCode() {
                                    return (super.hashCode() * 31) + this.fieldDescription.hashCode();
                                }

                                /* access modifiers changed from: protected */
                                @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                    if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
                                        throw new IllegalStateException(this.fieldDescription + " is no member of " + typeDescription);
                                    } else if (this.fieldDescription.isVisibleTo(typeDescription)) {
                                        return this.fieldDescription;
                                    } else {
                                        throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                                    }
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            public static abstract class Unresolved extends ForFieldHandle {
                                protected static final String BEAN_PROPERTY = "";
                                private final String name;

                                protected enum GetterFactory implements Factory<FieldGetterHandle> {
                                    INSTANCE;
                                    
                                    private static final MethodDescription.InDefinedShape FIELD_GETTER_HANDLE_DECLARING_TYPE = null;
                                    private static final MethodDescription.InDefinedShape FIELD_GETTER_HANDLE_VALUE = null;

                                    static {
                                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldGetterHandle.class).getDeclaredMethods();
                                        FIELD_GETTER_HANDLE_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                                        FIELD_GETTER_HANDLE_DECLARING_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("declaringType"))).getOnly();
                                    }

                                    public Class<FieldGetterHandle> getAnnotationType() {
                                        return FieldGetterHandle.class;
                                    }

                                    public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldGetterHandle> loadable) {
                                        throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                    }

                                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldGetterHandle> loadable) {
                                        Class<String> cls = String.class;
                                        if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                                            TypeDescription typeDescription = (TypeDescription) loadable.getValue(FIELD_GETTER_HANDLE_DECLARING_TYPE).resolve(TypeDescription.class);
                                            if (typeDescription.represents(Void.TYPE)) {
                                                return new WithImplicitType(Access.GETTER, (String) loadable.getValue(FIELD_GETTER_HANDLE_VALUE).resolve(cls));
                                            }
                                            return new WithExplicitType(Access.GETTER, (String) loadable.getValue(FIELD_GETTER_HANDLE_VALUE).resolve(cls), typeDescription);
                                        }
                                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                                    }
                                }

                                protected enum SetterFactory implements Factory<FieldSetterHandle> {
                                    INSTANCE;
                                    
                                    private static final MethodDescription.InDefinedShape FIELD_SETTER_HANDLE_DECLARING_TYPE = null;
                                    private static final MethodDescription.InDefinedShape FIELD_SETTER_HANDLE_VALUE = null;

                                    static {
                                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldSetterHandle.class).getDeclaredMethods();
                                        FIELD_SETTER_HANDLE_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                                        FIELD_SETTER_HANDLE_DECLARING_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("declaringType"))).getOnly();
                                    }

                                    public Class<FieldSetterHandle> getAnnotationType() {
                                        return FieldSetterHandle.class;
                                    }

                                    public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldSetterHandle> loadable) {
                                        throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                    }

                                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldSetterHandle> loadable) {
                                        Class<String> cls = String.class;
                                        if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                                            TypeDescription typeDescription = (TypeDescription) loadable.getValue(FIELD_SETTER_HANDLE_DECLARING_TYPE).resolve(TypeDescription.class);
                                            if (typeDescription.represents(Void.TYPE)) {
                                                return new WithImplicitType(Access.SETTER, (String) loadable.getValue(FIELD_SETTER_HANDLE_VALUE).resolve(cls));
                                            }
                                            return new WithExplicitType(Access.SETTER, (String) loadable.getValue(FIELD_SETTER_HANDLE_VALUE).resolve(cls), typeDescription);
                                        }
                                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                                    }
                                }

                                @HashCodeAndEqualsPlugin.Enhance
                                public static class WithExplicitType extends Unresolved {
                                    private final TypeDescription declaringType;

                                    public WithExplicitType(Access access, String str, TypeDescription typeDescription) {
                                        super(access, str);
                                        this.declaringType = typeDescription;
                                    }

                                    public boolean equals(@MaybeNull Object obj) {
                                        if (!super.equals(obj)) {
                                            return false;
                                        }
                                        if (this == obj) {
                                            return true;
                                        }
                                        return obj != null && getClass() == obj.getClass() && this.declaringType.equals(((WithExplicitType) obj).declaringType);
                                    }

                                    /* access modifiers changed from: protected */
                                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                                        if (this.declaringType.represents(TargetType.class) || typeDescription.isAssignableTo(this.declaringType)) {
                                            return new FieldLocator.ForExactType(TargetType.resolve(this.declaringType, typeDescription));
                                        }
                                        throw new IllegalStateException(this.declaringType + " is no super type of " + typeDescription);
                                    }

                                    public int hashCode() {
                                        return (super.hashCode() * 31) + this.declaringType.hashCode();
                                    }
                                }

                                public static class WithImplicitType extends Unresolved {
                                    public WithImplicitType(Access access, String str) {
                                        super(access, str);
                                    }

                                    /* access modifiers changed from: protected */
                                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                                        return new FieldLocator.ForClassHierarchy(typeDescription);
                                    }
                                }

                                public Unresolved(Access access, String str) {
                                    super(access);
                                    this.name = str;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (!super.equals(obj)) {
                                        return false;
                                    }
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.name.equals(((Unresolved) obj).name);
                                }

                                /* access modifiers changed from: protected */
                                public abstract FieldLocator fieldLocator(TypeDescription typeDescription);

                                public int hashCode() {
                                    return (super.hashCode() * 31) + this.name.hashCode();
                                }

                                /* access modifiers changed from: protected */
                                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                    FieldLocator.Resolution resolution;
                                    FieldLocator fieldLocator = fieldLocator(typeDescription);
                                    if (this.name.equals("")) {
                                        resolution = FieldLocator.Resolution.Simple.ofBeanAccessor(fieldLocator, methodDescription);
                                    } else {
                                        resolution = fieldLocator.locate(this.name);
                                    }
                                    if (resolution.isResolved()) {
                                        return resolution.getField();
                                    }
                                    throw new IllegalStateException("Cannot locate field named " + this.name + " for " + typeDescription);
                                }
                            }

                            protected ForFieldHandle(Access access2) {
                                this.access = access2;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.access.equals(((ForFieldHandle) obj).access);
                            }

                            public int hashCode() {
                                return (getClass().hashCode() * 31) + this.access.hashCode();
                            }

                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                FieldDescription resolve = resolve(typeDescription, methodDescription);
                                if (!resolve.isStatic() && methodDescription.isStatic()) {
                                    throw new IllegalStateException("Cannot access non-static field " + resolve + " from static method " + methodDescription);
                                } else if (resolve.isStatic()) {
                                    return new Resolved.ForStackManipulation(this.access.resolve((FieldDescription.InDefinedShape) resolve.asDefined()).toStackManipulation());
                                } else {
                                    JavaType javaType = JavaType.METHOD_HANDLE;
                                    return new Resolved.ForStackManipulation(new StackManipulation.Compound(this.access.resolve((FieldDescription.InDefinedShape) resolve.asDefined()).toStackManipulation(), MethodVariableAccess.REFERENCE.loadFrom(0), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(Object.class)))))));
                                }
                            }

                            /* access modifiers changed from: protected */
                            public abstract FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription);
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForOrigin implements OffsetMapping {
                            private final Sort sort;
                            private final Source source;

                            protected enum Factory implements Factory<Origin> {
                                INSTANCE;
                                
                                private static final MethodDescription.InDefinedShape ORIGIN_TYPE = null;

                                static {
                                    ORIGIN_TYPE = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Origin.class).getDeclaredMethods().filter(ElementMatchers.named("source"))).getOnly();
                                }

                                public Class<Origin> getAnnotationType() {
                                    return Origin.class;
                                }

                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Origin> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Origin> loadable) {
                                    Sort sort;
                                    if (inDefinedShape.getType().asErasure().represents(Class.class)) {
                                        sort = Sort.TYPE;
                                    } else if (inDefinedShape.getType().asErasure().represents(Method.class)) {
                                        sort = Sort.METHOD;
                                    } else if (inDefinedShape.getType().asErasure().represents(Constructor.class)) {
                                        sort = Sort.CONSTRUCTOR;
                                    } else if (inDefinedShape.getType().asErasure().represents(Field.class)) {
                                        sort = Sort.FIELD;
                                    } else if (JavaType.EXECUTABLE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                                        sort = Sort.EXECUTABLE;
                                    } else if (JavaType.METHOD_HANDLE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                                        sort = Sort.METHOD_HANDLE;
                                    } else if (JavaType.METHOD_TYPE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                                        sort = Sort.METHOD_TYPE;
                                    } else if (JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                                        sort = Sort.LOOKUP;
                                    } else if (inDefinedShape.getType().asErasure().isAssignableFrom((Class<?>) String.class)) {
                                        sort = Sort.STRING;
                                    } else {
                                        throw new IllegalStateException("Non-supported type " + inDefinedShape.getType() + " for @Origin annotation");
                                    }
                                    return new ForOrigin(sort, (Source) ((EnumerationDescription) loadable.getValue(ORIGIN_TYPE).resolve(EnumerationDescription.class)).load(Source.class));
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Resolved implements Resolved {
                                private final MethodDescription instrumentedMethod;
                                private final Sort sort;
                                private final Source source;

                                protected Resolved(Sort sort2, Source source2, MethodDescription methodDescription) {
                                    this.sort = sort2;
                                    this.source = source2;
                                    this.instrumentedMethod = methodDescription;
                                }

                                public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10) {
                                    if (this.source.isRepresentable(this.sort, member, this.instrumentedMethod)) {
                                        return this.source.resolve(this.sort, member, generic, generic2, this.instrumentedMethod);
                                    }
                                    throw new IllegalStateException("Cannot represent " + this.sort + " for " + this.source + " in " + this.instrumentedMethod);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.sort.equals(resolved.sort) && this.source.equals(resolved.source) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return (((((getClass().hashCode() * 31) + this.sort.hashCode()) * 31) + this.source.hashCode()) * 31) + this.instrumentedMethod.hashCode();
                                }
                            }

                            protected enum Sort {
                                METHOD {
                                    /* access modifiers changed from: protected */
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return (member instanceof MethodDescription) && ((MethodDescription) member).isMethod();
                                    }

                                    /* access modifiers changed from: protected */
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return MethodConstant.of((MethodDescription.InDefinedShape) ((MethodDescription) member).asDefined());
                                    }
                                },
                                CONSTRUCTOR {
                                    /* access modifiers changed from: protected */
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return (member instanceof MethodDescription) && ((MethodDescription) member).isConstructor();
                                    }

                                    /* access modifiers changed from: protected */
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return MethodConstant.of((MethodDescription.InDefinedShape) ((MethodDescription) member).asDefined());
                                    }
                                },
                                FIELD {
                                    /* access modifiers changed from: protected */
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return member instanceof FieldDescription;
                                    }

                                    /* access modifiers changed from: protected */
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return new FieldConstant((FieldDescription.InDefinedShape) ((FieldDescription) member).asDefined());
                                    }
                                },
                                EXECUTABLE {
                                    /* access modifiers changed from: protected */
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return member instanceof MethodDescription;
                                    }

                                    /* access modifiers changed from: protected */
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return MethodConstant.of((MethodDescription.InDefinedShape) ((MethodDescription) member).asDefined());
                                    }
                                },
                                TYPE {
                                    /* access modifiers changed from: protected */
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    /* access modifiers changed from: protected */
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return ClassConstant.of(member.getDeclaringType().asErasure());
                                    }
                                },
                                LOOKUP {
                                    /* access modifiers changed from: protected */
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    /* access modifiers changed from: protected */
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return MethodInvocation.lookup();
                                    }
                                },
                                METHOD_HANDLE {
                                    /* access modifiers changed from: protected */
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    /* access modifiers changed from: protected */
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        JavaConstant.MethodHandle methodHandle;
                                        if (member instanceof MethodDescription) {
                                            methodHandle = JavaConstant.MethodHandle.of((MethodDescription.InDefinedShape) ((MethodDescription) member).asDefined());
                                        } else if (!(member instanceof FieldDescription)) {
                                            throw new IllegalStateException("Unexpected byte code element: " + member);
                                        } else if (typeDescription.represents(Void.TYPE)) {
                                            methodHandle = JavaConstant.MethodHandle.ofSetter((FieldDescription.InDefinedShape) ((FieldDescription) member).asDefined());
                                        } else {
                                            methodHandle = JavaConstant.MethodHandle.ofGetter((FieldDescription.InDefinedShape) ((FieldDescription) member).asDefined());
                                        }
                                        return methodHandle.toStackManipulation();
                                    }
                                },
                                METHOD_TYPE {
                                    /* access modifiers changed from: protected */
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    /* access modifiers changed from: protected */
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return JavaConstant.MethodType.of(typeDescription, (List<? extends TypeDescription>) list).toStackManipulation();
                                    }
                                },
                                STRING {
                                    /* access modifiers changed from: protected */
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    /* access modifiers changed from: protected */
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return new TextConstant(member.toString());
                                    }
                                };

                                /* access modifiers changed from: protected */
                                public abstract boolean isRepresentable(ByteCodeElement.Member member);

                                /* access modifiers changed from: protected */
                                public abstract StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription);
                            }

                            protected ForOrigin(Sort sort2, Source source2) {
                                this.sort = sort2;
                                this.source = source2;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                ForOrigin forOrigin = (ForOrigin) obj;
                                return this.sort.equals(forOrigin.sort) && this.source.equals(forOrigin.source);
                            }

                            public int hashCode() {
                                return (((getClass().hashCode() * 31) + this.sort.hashCode()) * 31) + this.source.hashCode();
                            }

                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Resolved(this.sort, this.source, methodDescription);
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForSelfCallHandle implements OffsetMapping {
                            private final boolean bound;
                            private final Source source;

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Bound implements Resolved {
                                private final MethodDescription instrumentedMethod;
                                private final Source source;

                                protected Bound(Source source2, MethodDescription methodDescription) {
                                    this.source = source2;
                                    this.instrumentedMethod = methodDescription;
                                }

                                public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10) {
                                    int i11;
                                    Source.Value self = this.source.self(generic, map, member, this.instrumentedMethod);
                                    List<Source.Value> arguments = this.source.arguments(false, generic, map, member, this.instrumentedMethod);
                                    int size = arguments.size();
                                    if (self == null) {
                                        i11 = 0;
                                    } else {
                                        i11 = 2;
                                    }
                                    ArrayList arrayList = new ArrayList(size + i11 + 1 + (arguments.isEmpty() ^ true ? 1 : 0));
                                    arrayList.add(this.source.handle(methodHandle, this.instrumentedMethod).toStackManipulation());
                                    if (self != null) {
                                        arrayList.add(MethodVariableAccess.of(self.getTypeDescription()).loadFrom(self.getOffset()));
                                        JavaType javaType = JavaType.METHOD_HANDLE;
                                        arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(Object.class))))));
                                    }
                                    if (!arguments.isEmpty()) {
                                        for (Source.Value next : arguments) {
                                            arrayList.add(MethodVariableAccess.of(next.getTypeDescription()).loadFrom(next.getOffset()));
                                        }
                                        TypeDescription typeStub = JavaType.METHOD_HANDLES.getTypeStub();
                                        JavaType javaType2 = JavaType.METHOD_HANDLE;
                                        arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(typeStub, new MethodDescription.Token("insertArguments", 9, javaType2.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(javaType2.getTypeStub(), TypeDefinition.Sort.describe(Integer.TYPE), TypeDefinition.Sort.describe(Object[].class))))));
                                    }
                                    return new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Bound bound = (Bound) obj;
                                    return this.source.equals(bound.source) && this.instrumentedMethod.equals(bound.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return (((getClass().hashCode() * 31) + this.source.hashCode()) * 31) + this.instrumentedMethod.hashCode();
                                }
                            }

                            protected enum Factory implements Factory<SelfCallHandle> {
                                INSTANCE;
                                
                                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_BOUND = null;
                                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_SOURCE = null;

                                static {
                                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(SelfCallHandle.class).getDeclaredMethods();
                                    ALL_ARGUMENTS_SOURCE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("source"))).getOnly();
                                    ALL_ARGUMENTS_BOUND = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("bound"))).getOnly();
                                }

                                public Class<SelfCallHandle> getAnnotationType() {
                                    return SelfCallHandle.class;
                                }

                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<SelfCallHandle> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<SelfCallHandle> loadable) {
                                    if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                                        return new ForSelfCallHandle((Source) ((EnumerationDescription) loadable.getValue(ALL_ARGUMENTS_SOURCE).resolve(EnumerationDescription.class)).load(Source.class), ((Boolean) loadable.getValue(ALL_ARGUMENTS_BOUND).resolve(Boolean.class)).booleanValue());
                                    }
                                    throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Unbound implements Resolved {
                                private final MethodDescription instrumentedMethod;
                                private final Source source;

                                protected Unbound(Source source2, MethodDescription methodDescription) {
                                    this.source = source2;
                                    this.instrumentedMethod = methodDescription;
                                }

                                public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10) {
                                    return this.source.handle(methodHandle, this.instrumentedMethod).toStackManipulation();
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Unbound unbound = (Unbound) obj;
                                    return this.source.equals(unbound.source) && this.instrumentedMethod.equals(unbound.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return (((getClass().hashCode() * 31) + this.source.hashCode()) * 31) + this.instrumentedMethod.hashCode();
                                }
                            }

                            public ForSelfCallHandle(Source source2, boolean z10) {
                                this.source = source2;
                                this.bound = z10;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                ForSelfCallHandle forSelfCallHandle = (ForSelfCallHandle) obj;
                                return this.bound == forSelfCallHandle.bound && this.source.equals(forSelfCallHandle.source);
                            }

                            public int hashCode() {
                                return (((getClass().hashCode() * 31) + this.source.hashCode()) * 31) + (this.bound ? 1 : 0);
                            }

                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return this.bound ? new Bound(this.source, methodDescription) : new Unbound(this.source, methodDescription);
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForStackManipulation implements OffsetMapping {
                            private final StackManipulation stackManipulation;
                            private final TypeDescription.Generic targetType;
                            private final TypeDescription.Generic typeDescription;

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Factory<T extends Annotation> extends Factory.AbstractBase<T> {
                                private final Class<T> annotationType;
                                private final StackManipulation stackManipulation;
                                private final TypeDescription.Generic typeDescription;

                                public Factory(Class<T> cls, ConstantValue constantValue) {
                                    this(cls, constantValue.toStackManipulation(), constantValue.getTypeDescription().asGenericType());
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Factory factory = (Factory) obj;
                                    return this.annotationType.equals(factory.annotationType) && this.stackManipulation.equals(factory.stackManipulation) && this.typeDescription.equals(factory.typeDescription);
                                }

                                public Class<T> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDescription.hashCode();
                                }

                                /* access modifiers changed from: protected */
                                public OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<T> loadable) {
                                    return new ForStackManipulation(this.stackManipulation, this.typeDescription, generic);
                                }

                                public Factory(Class<T> cls, StackManipulation stackManipulation2, TypeDescription.Generic generic) {
                                    this.annotationType = cls;
                                    this.stackManipulation = stackManipulation2;
                                    this.typeDescription = generic;
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class OfAnnotationProperty<T extends Annotation> extends Factory.WithParameterSupportOnly<T> {
                                private final Class<T> annotationType;
                                private final MethodDescription.InDefinedShape property;

                                protected OfAnnotationProperty(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape) {
                                    this.annotationType = cls;
                                    this.property = inDefinedShape;
                                }

                                public static <S extends Annotation> Factory<S> of(Class<S> cls, String str) {
                                    if (cls.isAnnotation()) {
                                        try {
                                            return new OfAnnotationProperty(cls, new MethodDescription.ForLoadedMethod(cls.getMethod(str, new Class[0])));
                                        } catch (NoSuchMethodException e10) {
                                            throw new IllegalArgumentException("Cannot find a property " + str + " on " + cls, e10);
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Not an annotation type: " + cls);
                                    }
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    OfAnnotationProperty ofAnnotationProperty = (OfAnnotationProperty) obj;
                                    return this.annotationType.equals(ofAnnotationProperty.annotationType) && this.property.equals(ofAnnotationProperty.property);
                                }

                                public Class<T> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return (((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.property.hashCode();
                                }

                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable) {
                                    ConstantValue wrapOrNull = ConstantValue.Simple.wrapOrNull(loadable.getValue(this.property).resolve());
                                    if (wrapOrNull != null) {
                                        return new ForStackManipulation(wrapOrNull.toStackManipulation(), wrapOrNull.getTypeDescription().asGenericType(), inDefinedShape.getType());
                                    }
                                    throw new IllegalStateException("Not a constant value property: " + this.property);
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class OfDefaultValue<T extends Annotation> implements Factory<T> {
                                private final Class<T> annotationType;

                                public OfDefaultValue(Class<T> cls) {
                                    this.annotationType = cls;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((OfDefaultValue) obj).annotationType);
                                }

                                public Class<T> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.annotationType.hashCode();
                                }

                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable) {
                                    return new ForStackManipulation(DefaultValue.of(inDefinedShape.getType()), inDefinedShape.getType(), inDefinedShape.getType());
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class OfDynamicInvocation<T extends Annotation> extends Factory.AbstractBase<T> {
                                private final Class<T> annotationType;
                                private final List<? extends JavaConstant> arguments;
                                private final MethodDescription.InDefinedShape bootstrapMethod;

                                public OfDynamicInvocation(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list) {
                                    this.annotationType = cls;
                                    this.bootstrapMethod = inDefinedShape;
                                    this.arguments = list;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    OfDynamicInvocation ofDynamicInvocation = (OfDynamicInvocation) obj;
                                    return this.annotationType.equals(ofDynamicInvocation.annotationType) && this.bootstrapMethod.equals(ofDynamicInvocation.bootstrapMethod) && this.arguments.equals(ofDynamicInvocation.arguments);
                                }

                                public Class<T> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.bootstrapMethod.hashCode()) * 31) + this.arguments.hashCode();
                                }

                                /* access modifiers changed from: protected */
                                public OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<T> loadable) {
                                    if (!generic.isInterface()) {
                                        throw new IllegalArgumentException(generic + " is not an interface");
                                    } else if (!generic.getInterfaces().isEmpty()) {
                                        throw new IllegalArgumentException(generic + " must not extend other interfaces");
                                    } else if (generic.isPublic()) {
                                        MethodList methodList = (MethodList) generic.getDeclaredMethods().filter(ElementMatchers.isAbstract());
                                        if (methodList.size() == 1) {
                                            return new ForStackManipulation(MethodInvocation.invoke(this.bootstrapMethod).dynamic(((MethodDescription) methodList.getOnly()).getInternalName(), generic.asErasure(), Collections.emptyList(), this.arguments), generic, generic);
                                        }
                                        throw new IllegalArgumentException(generic + " must declare exactly one abstract method");
                                    } else {
                                        throw new IllegalArgumentException(generic + " is mot public");
                                    }
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class OfSerializedConstant<T extends Annotation> extends Factory.AbstractBase<T> {
                                private final Class<T> annotationType;
                                private final StackManipulation deserialization;
                                private final TypeDescription.Generic typeDescription;

                                protected OfSerializedConstant(Class<T> cls, StackManipulation stackManipulation, TypeDescription.Generic generic) {
                                    this.annotationType = cls;
                                    this.deserialization = stackManipulation;
                                    this.typeDescription = generic;
                                }

                                public static <S extends Annotation, U extends Serializable> Factory<S> of(Class<S> cls, U u10, Class<? super U> cls2) {
                                    if (cls2.isInstance(u10)) {
                                        return new OfSerializedConstant(cls, SerializedConstant.of(u10), TypeDescription.ForLoadedType.of(cls2).asGenericType());
                                    }
                                    throw new IllegalArgumentException(u10 + " is no instance of " + cls2);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    OfSerializedConstant ofSerializedConstant = (OfSerializedConstant) obj;
                                    return this.annotationType.equals(ofSerializedConstant.annotationType) && this.deserialization.equals(ofSerializedConstant.deserialization) && this.typeDescription.equals(ofSerializedConstant.typeDescription);
                                }

                                public Class<T> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.deserialization.hashCode()) * 31) + this.typeDescription.hashCode();
                                }

                                /* access modifiers changed from: protected */
                                public OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<T> loadable) {
                                    return new ForStackManipulation(this.deserialization, this.typeDescription, generic);
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Resolved implements Resolved {
                                private final Assigner assigner;
                                private final StackManipulation stackManipulation;
                                private final TypeDescription.Generic targetType;
                                private final TypeDescription.Generic typeDescription;
                                private final Assigner.Typing typing;

                                protected Resolved(Assigner assigner2, Assigner.Typing typing2, StackManipulation stackManipulation2, TypeDescription.Generic generic, TypeDescription.Generic generic2) {
                                    this.assigner = assigner2;
                                    this.typing = typing2;
                                    this.stackManipulation = stackManipulation2;
                                    this.typeDescription = generic;
                                    this.targetType = generic2;
                                }

                                public StackManipulation apply(TypeDescription typeDescription2, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10) {
                                    StackManipulation assign = this.assigner.assign(this.typeDescription, this.targetType, this.typing);
                                    if (assign.isValid()) {
                                        return new StackManipulation.Compound(this.stackManipulation, assign);
                                    }
                                    throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.targetType);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.typing.equals(resolved.typing) && this.assigner.equals(resolved.assigner) && this.stackManipulation.equals(resolved.stackManipulation) && this.typeDescription.equals(resolved.typeDescription) && this.targetType.equals(resolved.targetType);
                                }

                                public int hashCode() {
                                    return (((((((((getClass().hashCode() * 31) + this.assigner.hashCode()) * 31) + this.typing.hashCode()) * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDescription.hashCode()) * 31) + this.targetType.hashCode();
                                }
                            }

                            public ForStackManipulation(StackManipulation stackManipulation2, TypeDescription.Generic generic, TypeDescription.Generic generic2) {
                                this.targetType = generic2;
                                this.stackManipulation = stackManipulation2;
                                this.typeDescription = generic;
                            }

                            public static <S extends Annotation> Factory<S> of(Class<S> cls, @MaybeNull Object obj) {
                                if (obj == null) {
                                    return new OfDefaultValue(cls);
                                }
                                return new Factory(cls, ConstantValue.Simple.wrap(obj));
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                ForStackManipulation forStackManipulation = (ForStackManipulation) obj;
                                return this.stackManipulation.equals(forStackManipulation.stackManipulation) && this.typeDescription.equals(forStackManipulation.typeDescription) && this.targetType.equals(forStackManipulation.targetType);
                            }

                            public int hashCode() {
                                return (((((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDescription.hashCode()) * 31) + this.targetType.hashCode();
                            }

                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription2, MethodDescription methodDescription) {
                                return new Resolved(assigner, typing, this.stackManipulation, this.typeDescription, this.targetType);
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForStubValue implements OffsetMapping {
                            private final Source source;

                            @HashCodeAndEqualsPlugin.Enhance
                            protected enum Factory implements Factory<StubValue> {
                                INSTANCE;
                                
                                private static final MethodDescription.InDefinedShape STUB_VALUE_SOURCE = null;

                                static {
                                    STUB_VALUE_SOURCE = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(StubValue.class).getDeclaredMethods().filter(ElementMatchers.named("source"))).getOnly();
                                }

                                public Class<StubValue> getAnnotationType() {
                                    return StubValue.class;
                                }

                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<StubValue> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<StubValue> loadable) {
                                    if (inDefinedShape.getType().represents(Object.class)) {
                                        return new ForStubValue((Source) ((EnumerationDescription) loadable.getValue(STUB_VALUE_SOURCE).resolve(EnumerationDescription.class)).load(Source.class));
                                    }
                                    throw new IllegalStateException("Expected " + inDefinedShape + " to declare an Object type");
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Resolved implements Resolved {
                                private final MethodDescription instrumentedMethod;
                                private final Source source;

                                protected Resolved(Source source2, MethodDescription methodDescription) {
                                    this.source = source2;
                                    this.instrumentedMethod = methodDescription;
                                }

                                public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10) {
                                    return DefaultValue.of(this.source.handle(methodHandle, this.instrumentedMethod).getReturnType());
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.source.equals(resolved.source) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return (((getClass().hashCode() * 31) + this.source.hashCode()) * 31) + this.instrumentedMethod.hashCode();
                                }
                            }

                            protected ForStubValue(Source source2) {
                                this.source = source2;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.source.equals(((ForStubValue) obj).source);
                            }

                            public int hashCode() {
                                return (getClass().hashCode() * 31) + this.source.hashCode();
                            }

                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Resolved(this.source, methodDescription);
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForThisReference implements OffsetMapping {
                            private final boolean optional;
                            private final Source source;
                            private final TypeDescription.Generic targetType;
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            @MaybeNull
                            private final Assigner.Typing typing;

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Resolved implements Resolved {
                                private final Assigner assigner;
                                private final MethodDescription instrumentedMethod;
                                private final boolean optional;
                                private final Source source;
                                private final TypeDescription.Generic targetType;
                                private final Assigner.Typing typing;

                                protected Resolved(TypeDescription.Generic generic, Assigner.Typing typing2, Source source2, boolean z10, Assigner assigner2, MethodDescription methodDescription) {
                                    this.targetType = generic;
                                    this.typing = typing2;
                                    this.source = source2;
                                    this.optional = z10;
                                    this.assigner = assigner2;
                                    this.instrumentedMethod = methodDescription;
                                }

                                public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10) {
                                    Source.Value self = this.source.self(generic, map, member, this.instrumentedMethod);
                                    if (self != null) {
                                        StackManipulation assign = this.assigner.assign(self.getTypeDescription(), this.targetType, this.typing);
                                        if (assign.isValid()) {
                                            return new StackManipulation.Compound(MethodVariableAccess.of(self.getTypeDescription()).loadFrom(self.getOffset()), assign);
                                        }
                                        throw new IllegalStateException("Cannot assign " + self.getTypeDescription() + " to " + this.targetType);
                                    } else if (this.optional) {
                                        return DefaultValue.of(this.targetType);
                                    } else {
                                        throw new IllegalStateException("No this reference available for " + member);
                                    }
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.optional == resolved.optional && this.typing.equals(resolved.typing) && this.source.equals(resolved.source) && this.targetType.equals(resolved.targetType) && this.assigner.equals(resolved.assigner) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return (((((((((((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31) + this.typing.hashCode()) * 31) + this.source.hashCode()) * 31) + (this.optional ? 1 : 0)) * 31) + this.assigner.hashCode()) * 31) + this.instrumentedMethod.hashCode();
                                }
                            }

                            public ForThisReference(TypeDescription.Generic generic, @MaybeNull Assigner.Typing typing2, Source source2, boolean z10) {
                                this.targetType = generic;
                                this.typing = typing2;
                                this.source = source2;
                                this.optional = z10;
                            }

                            /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
                                if (r2 != null) goto L_0x002d;
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L_0x0004
                                    return r0
                                L_0x0004:
                                    r1 = 0
                                    if (r5 != 0) goto L_0x0008
                                    return r1
                                L_0x0008:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L_0x0013
                                    return r1
                                L_0x0013:
                                    boolean r2 = r4.optional
                                    net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$ForThisReference r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForThisReference) r5
                                    boolean r3 = r5.optional
                                    if (r2 == r3) goto L_0x001c
                                    return r1
                                L_0x001c:
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = r4.typing
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r3 = r5.typing
                                    if (r3 == 0) goto L_0x002b
                                    if (r2 == 0) goto L_0x002d
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x002e
                                    return r1
                                L_0x002b:
                                    if (r2 == 0) goto L_0x002e
                                L_0x002d:
                                    return r1
                                L_0x002e:
                                    net.bytebuddy.asm.MemberSubstitution$Source r2 = r4.source
                                    net.bytebuddy.asm.MemberSubstitution$Source r3 = r5.source
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x0039
                                    return r1
                                L_0x0039:
                                    net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.targetType
                                    net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.targetType
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L_0x0044
                                    return r1
                                L_0x0044:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForThisReference.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int hashCode = ((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31;
                                Assigner.Typing typing2 = this.typing;
                                if (typing2 != null) {
                                    hashCode += typing2.hashCode();
                                }
                                return (((hashCode * 31) + this.source.hashCode()) * 31) + (this.optional ? 1 : 0);
                            }

                            public Resolved resolve(Assigner assigner, Assigner.Typing typing2, TypeDescription typeDescription, MethodDescription methodDescription) {
                                TypeDescription.Generic generic = this.targetType;
                                Assigner.Typing typing3 = this.typing;
                                return new Resolved(generic, typing3 == null ? typing2 : typing3, this.source, this.optional, assigner, methodDescription);
                            }

                            protected enum Factory implements Factory<This> {
                                INSTANCE;
                                
                                private static final MethodDescription.InDefinedShape THIS_OPTIONAL = null;
                                private static final MethodDescription.InDefinedShape THIS_SOURCE = null;
                                private static final MethodDescription.InDefinedShape THIS_TYPING = null;

                                static {
                                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(This.class).getDeclaredMethods();
                                    THIS_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                                    THIS_SOURCE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("source"))).getOnly();
                                    THIS_OPTIONAL = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(Session.Feature.OPTIONAL_ELEMENT))).getOnly();
                                }

                                public Class<This> getAnnotationType() {
                                    return This.class;
                                }

                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<This> loadable) {
                                    Class<EnumerationDescription> cls = EnumerationDescription.class;
                                    return new ForThisReference(inDefinedShape.getDeclaringType().asGenericType(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(THIS_TYPING).resolve(cls)).load(Assigner.Typing.class), (Source) ((EnumerationDescription) loadable.getValue(THIS_SOURCE).resolve(cls)).load(Source.class), ((Boolean) loadable.getValue(THIS_OPTIONAL).resolve(Boolean.class)).booleanValue());
                                }

                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<This> loadable) {
                                    Class<EnumerationDescription> cls = EnumerationDescription.class;
                                    return new ForThisReference(inDefinedShape.getType(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(THIS_TYPING).resolve(cls)).load(Assigner.Typing.class), (Source) ((EnumerationDescription) loadable.getValue(THIS_SOURCE).resolve(cls)).load(Source.class), ((Boolean) loadable.getValue(THIS_OPTIONAL).resolve(Boolean.class)).booleanValue());
                                }
                            }
                        }

                        public interface Resolved {

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class ForStackManipulation implements Resolved {
                                private final StackManipulation stackManipulation;

                                public ForStackManipulation(StackManipulation stackManipulation2) {
                                    this.stackManipulation = stackManipulation2;
                                }

                                public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10) {
                                    return this.stackManipulation;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.stackManipulation.equals(((ForStackManipulation) obj).stackManipulation);
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.stackManipulation.hashCode();
                                }
                            }

                            StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10);
                        }

                        Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription);

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForArgument implements OffsetMapping {
                            private final int index;
                            private final boolean optional;
                            private final Source source;
                            private final TypeDescription.Generic targetType;
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            @MaybeNull
                            private final Assigner.Typing typing;

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class Resolved implements Resolved {
                                private final Assigner assigner;
                                private final int index;
                                private final MethodDescription instrumentedMethod;
                                private final boolean optional;
                                private final Source source;
                                private final TypeDescription.Generic targetType;
                                private final Assigner.Typing typing;

                                protected Resolved(TypeDescription.Generic generic, int i10, Assigner.Typing typing2, Source source2, boolean z10, Assigner assigner2, MethodDescription methodDescription) {
                                    this.targetType = generic;
                                    this.index = i10;
                                    this.typing = typing2;
                                    this.source = source2;
                                    this.optional = z10;
                                    this.assigner = assigner2;
                                    this.instrumentedMethod = methodDescription;
                                }

                                public StackManipulation apply(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i10) {
                                    Source.Value argument = this.source.argument(this.index, generic, map, member, this.instrumentedMethod);
                                    if (argument != null) {
                                        StackManipulation assign = this.assigner.assign(argument.getTypeDescription(), this.targetType, this.typing);
                                        if (assign.isValid()) {
                                            return new StackManipulation.Compound(MethodVariableAccess.of(argument.getTypeDescription()).loadFrom(argument.getOffset()), assign);
                                        }
                                        throw new IllegalStateException("Cannot assign " + argument.getTypeDescription() + " to " + this.targetType);
                                    } else if (this.optional) {
                                        return DefaultValue.of(this.targetType);
                                    } else {
                                        throw new IllegalStateException("No argument with index " + this.index + " available for " + member);
                                    }
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.index == resolved.index && this.optional == resolved.optional && this.typing.equals(resolved.typing) && this.source.equals(resolved.source) && this.targetType.equals(resolved.targetType) && this.assigner.equals(resolved.assigner) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return (((((((((((((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31) + this.index) * 31) + this.typing.hashCode()) * 31) + this.source.hashCode()) * 31) + (this.optional ? 1 : 0)) * 31) + this.assigner.hashCode()) * 31) + this.instrumentedMethod.hashCode();
                                }
                            }

                            public ForArgument(TypeDescription.Generic generic, int i10, @MaybeNull Assigner.Typing typing2, Source source2, boolean z10) {
                                this.targetType = generic;
                                this.index = i10;
                                this.typing = typing2;
                                this.source = source2;
                                this.optional = z10;
                            }

                            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
                                if (r2 != null) goto L_0x0034;
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L_0x0004
                                    return r0
                                L_0x0004:
                                    r1 = 0
                                    if (r5 != 0) goto L_0x0008
                                    return r1
                                L_0x0008:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L_0x0013
                                    return r1
                                L_0x0013:
                                    int r2 = r4.index
                                    net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$ForArgument r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForArgument) r5
                                    int r3 = r5.index
                                    if (r2 == r3) goto L_0x001c
                                    return r1
                                L_0x001c:
                                    boolean r2 = r4.optional
                                    boolean r3 = r5.optional
                                    if (r2 == r3) goto L_0x0023
                                    return r1
                                L_0x0023:
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = r4.typing
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r3 = r5.typing
                                    if (r3 == 0) goto L_0x0032
                                    if (r2 == 0) goto L_0x0034
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x0035
                                    return r1
                                L_0x0032:
                                    if (r2 == 0) goto L_0x0035
                                L_0x0034:
                                    return r1
                                L_0x0035:
                                    net.bytebuddy.asm.MemberSubstitution$Source r2 = r4.source
                                    net.bytebuddy.asm.MemberSubstitution$Source r3 = r5.source
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L_0x0040
                                    return r1
                                L_0x0040:
                                    net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.targetType
                                    net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.targetType
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L_0x004b
                                    return r1
                                L_0x004b:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForArgument.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int hashCode = ((((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31) + this.index) * 31;
                                Assigner.Typing typing2 = this.typing;
                                if (typing2 != null) {
                                    hashCode += typing2.hashCode();
                                }
                                return (((hashCode * 31) + this.source.hashCode()) * 31) + (this.optional ? 1 : 0);
                            }

                            public Resolved resolve(Assigner assigner, Assigner.Typing typing2, TypeDescription typeDescription, MethodDescription methodDescription) {
                                TypeDescription.Generic generic = this.targetType;
                                int i10 = this.index;
                                Assigner.Typing typing3 = this.typing;
                                return new Resolved(generic, i10, typing3 == null ? typing2 : typing3, this.source, this.optional, assigner, methodDescription);
                            }

                            protected enum Factory implements Factory<Argument> {
                                INSTANCE;
                                
                                private static final MethodDescription.InDefinedShape ARGUMENT_OPTIONAL = null;
                                private static final MethodDescription.InDefinedShape ARGUMENT_SOURCE = null;
                                private static final MethodDescription.InDefinedShape ARGUMENT_TYPING = null;
                                private static final MethodDescription.InDefinedShape ARGUMENT_VALUE = null;

                                static {
                                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Argument.class).getDeclaredMethods();
                                    ARGUMENT_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                                    ARGUMENT_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                                    ARGUMENT_SOURCE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("source"))).getOnly();
                                    ARGUMENT_OPTIONAL = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(Session.Feature.OPTIONAL_ELEMENT))).getOnly();
                                }

                                public Class<Argument> getAnnotationType() {
                                    return Argument.class;
                                }

                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Argument> loadable) {
                                    Class<EnumerationDescription> cls = EnumerationDescription.class;
                                    return new ForArgument(inDefinedShape.getDeclaringType().asGenericType(), ((Integer) loadable.getValue(ARGUMENT_VALUE).resolve(Integer.class)).intValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ARGUMENT_TYPING).resolve(cls)).load(Assigner.Typing.class), (Source) ((EnumerationDescription) loadable.getValue(ARGUMENT_SOURCE).resolve(cls)).load(Source.class), ((Boolean) loadable.getValue(ARGUMENT_OPTIONAL).resolve(Boolean.class)).booleanValue());
                                }

                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Argument> loadable) {
                                    Class<EnumerationDescription> cls = EnumerationDescription.class;
                                    int intValue = ((Integer) loadable.getValue(ARGUMENT_VALUE).resolve(Integer.class)).intValue();
                                    if (intValue >= 0) {
                                        return new ForArgument(inDefinedShape.getType(), intValue, (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ARGUMENT_TYPING).resolve(cls)).load(Assigner.Typing.class), (Source) ((EnumerationDescription) loadable.getValue(ARGUMENT_SOURCE).resolve(cls)).load(Source.class), ((Boolean) loadable.getValue(ARGUMENT_OPTIONAL).resolve(Boolean.class)).booleanValue());
                                    }
                                    throw new IllegalStateException("Cannot assign negative parameter index " + intValue + " for " + inDefinedShape);
                                }
                            }
                        }
                    }

                    public static Factory to(MethodDescription.InDefinedShape inDefinedShape) {
                        if (!inDefinedShape.isTypeInitializer()) {
                            return to(inDefinedShape, Dispatcher.ForRegularInvocation.Factory.INSTANCE, Collections.emptyList());
                        }
                        throw new IllegalArgumentException("Cannot delegate to a type initializer: " + inDefinedShape);
                    }

                    /* access modifiers changed from: private */
                    public static Factory to(MethodDescription.InDefinedShape inDefinedShape, Dispatcher.Factory factory, List<? extends OffsetMapping.Factory<?>> list) {
                        if (!inDefinedShape.isTypeInitializer()) {
                            return new Factory(inDefinedShape, factory.make(inDefinedShape), CompoundList.of(Arrays.asList(new OffsetMapping.Factory[]{OffsetMapping.ForArgument.Factory.INSTANCE, OffsetMapping.ForThisReference.Factory.INSTANCE, OffsetMapping.ForAllArguments.Factory.INSTANCE, OffsetMapping.ForSelfCallHandle.Factory.INSTANCE, OffsetMapping.ForField.Unresolved.Factory.INSTANCE, OffsetMapping.ForFieldHandle.Unresolved.GetterFactory.INSTANCE, OffsetMapping.ForFieldHandle.Unresolved.SetterFactory.INSTANCE, OffsetMapping.ForOrigin.Factory.INSTANCE, OffsetMapping.ForStubValue.Factory.INSTANCE, new OffsetMapping.ForStackManipulation.OfDefaultValue(Unused.class), OffsetMapping.ForCurrent.Factory.INSTANCE}), (List) list));
                        }
                        throw new IllegalArgumentException("Cannot delegate to type initializer: " + inDefinedShape);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForField implements Step {
                    protected final Assigner assigner;
                    protected final FieldDescription fieldDescription;
                    protected final Assigner.Typing typing;

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Read extends ForField {

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Factory implements Factory {
                            private final FieldDescription fieldDescription;

                            public Factory(Field field) {
                                this((FieldDescription) new FieldDescription.ForLoadedField(field));
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Factory) obj).fieldDescription);
                            }

                            public int hashCode() {
                                return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                            }

                            public Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Read(this.fieldDescription, assigner, typing);
                            }

                            public Factory(FieldDescription fieldDescription2) {
                                this.fieldDescription = fieldDescription2;
                            }
                        }

                        protected Read(FieldDescription fieldDescription, Assigner assigner, Assigner.Typing typing) {
                            super(fieldDescription, assigner, typing);
                        }

                        /* access modifiers changed from: protected */
                        public Resolution doResolve(ByteCodeElement.Member member, TypeList.Generic generic, Map<Integer, Integer> map, StackManipulation stackManipulation) {
                            return new Simple((StackManipulation) new StackManipulation.Compound(stackManipulation, FieldAccess.forField(this.fieldDescription).read()), this.fieldDescription.getType());
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass();
                        }

                        public int hashCode() {
                            return super.hashCode();
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Write extends ForField {
                        private final int index;

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Factory implements Factory {
                            private final FieldDescription fieldDescription;
                            private final int index;

                            public Factory(Field field, int i10) {
                                this((FieldDescription) new FieldDescription.ForLoadedField(field), i10);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Factory factory = (Factory) obj;
                                return this.index == factory.index && this.fieldDescription.equals(factory.fieldDescription);
                            }

                            public int hashCode() {
                                return (((getClass().hashCode() * 31) + this.fieldDescription.hashCode()) * 31) + this.index;
                            }

                            public Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Write(this.fieldDescription, assigner, typing, this.index);
                            }

                            public Factory(FieldDescription fieldDescription2, int i10) {
                                this.fieldDescription = fieldDescription2;
                                this.index = i10;
                            }
                        }

                        protected Write(FieldDescription fieldDescription, Assigner assigner, Assigner.Typing typing, int i10) {
                            super(fieldDescription, assigner, typing);
                            this.index = i10;
                        }

                        /* access modifiers changed from: protected */
                        public Resolution doResolve(ByteCodeElement.Member member, TypeList.Generic generic, Map<Integer, Integer> map, StackManipulation stackManipulation) {
                            int i10;
                            if ((member.getModifiers() & 8) != 0 || ((member instanceof MethodDescription) && ((MethodDescription) member).isConstructor())) {
                                i10 = this.index;
                            } else {
                                i10 = this.index + 1;
                            }
                            if (i10 < generic.size()) {
                                StackManipulation assign = this.assigner.assign((TypeDescription.Generic) generic.get(i10), this.fieldDescription.getType(), this.typing);
                                if (assign.isValid()) {
                                    return new Simple((StackManipulation) new StackManipulation.Compound(stackManipulation, MethodVariableAccess.of((TypeDefinition) generic.get(i10)).loadFrom(map.get(Integer.valueOf(i10)).intValue()), assign, FieldAccess.forField(this.fieldDescription).write()), TypeDefinition.Sort.describe(Void.TYPE));
                                }
                                throw new IllegalStateException("Cannot write " + generic.get(i10) + " to " + this.fieldDescription);
                            }
                            throw new IllegalStateException(member + " does not define an argument with index " + i10);
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.index == ((Write) obj).index;
                        }

                        public int hashCode() {
                            return (super.hashCode() * 31) + this.index;
                        }
                    }

                    protected ForField(FieldDescription fieldDescription2, Assigner assigner2, Assigner.Typing typing2) {
                        this.fieldDescription = fieldDescription2;
                        this.assigner = assigner2;
                        this.typing = typing2;
                    }

                    /* access modifiers changed from: protected */
                    public abstract Resolution doResolve(ByteCodeElement.Member member, TypeList.Generic generic, Map<Integer, Integer> map, StackManipulation stackManipulation);

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForField forField = (ForField) obj;
                        return this.typing.equals(forField.typing) && this.fieldDescription.equals(forField.fieldDescription) && this.assigner.equals(forField.assigner);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.fieldDescription.hashCode()) * 31) + this.assigner.hashCode()) * 31) + this.typing.hashCode();
                    }

                    @SuppressFBWarnings(justification = "Field description always has declaring type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public Resolution resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i10) {
                        ArrayList arrayList = new ArrayList(2);
                        if (this.fieldDescription.isStatic()) {
                            arrayList.add(Removal.of(generic3));
                        } else {
                            StackManipulation assign = this.assigner.assign(generic3, this.fieldDescription.getDeclaringType().asGenericType(), this.typing);
                            if (assign.isValid()) {
                                arrayList.add(assign);
                            } else {
                                throw new IllegalStateException("Cannot assign " + generic3 + " to " + this.fieldDescription.getDeclaringType());
                            }
                        }
                        return doResolve(member, generic, map, new StackManipulation.Compound((List<? extends StackManipulation>) arrayList));
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForInvocation implements Step {
                    private final Assigner assigner;
                    private final MethodDescription methodDescription;
                    private final Map<Integer, Integer> substitutions;
                    private final Assigner.Typing typing;

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Factory implements Factory {
                        private final MethodDescription methodDescription;
                        private final Map<Integer, Integer> substitutions;

                        public Factory(Method method) {
                            this((MethodDescription) new MethodDescription.ForLoadedMethod(method));
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Factory factory = (Factory) obj;
                            return this.methodDescription.equals(factory.methodDescription) && this.substitutions.equals(factory.substitutions);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.substitutions.hashCode();
                        }

                        public Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription2) {
                            return new ForInvocation(this.methodDescription, this.substitutions, assigner, typing);
                        }

                        public Factory(Constructor<?> constructor) {
                            this((MethodDescription) new MethodDescription.ForLoadedConstructor(constructor));
                        }

                        public Factory(MethodDescription methodDescription2) {
                            this(methodDescription2, Collections.emptyMap());
                        }

                        public Factory(MethodDescription methodDescription2, Map<Integer, Integer> map) {
                            this.methodDescription = methodDescription2;
                            this.substitutions = map;
                        }
                    }

                    protected ForInvocation(MethodDescription methodDescription2, Map<Integer, Integer> map, Assigner assigner2, Assigner.Typing typing2) {
                        this.methodDescription = methodDescription2;
                        this.substitutions = map;
                        this.assigner = assigner2;
                        this.typing = typing2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForInvocation forInvocation = (ForInvocation) obj;
                        return this.typing.equals(forInvocation.typing) && this.methodDescription.equals(forInvocation.methodDescription) && this.substitutions.equals(forInvocation.substitutions) && this.assigner.equals(forInvocation.assigner);
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.substitutions.hashCode()) * 31) + this.assigner.hashCode()) * 31) + this.typing.hashCode();
                    }

                    public Resolution resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i10) {
                        int i11;
                        int i12;
                        ArrayList arrayList = new ArrayList((generic.size() * 2) + 3);
                        if (this.methodDescription.isStatic()) {
                            arrayList.add(Removal.of(generic3));
                        } else if (this.methodDescription.isConstructor()) {
                            arrayList.add(Removal.of(generic3));
                            arrayList.add(TypeCreation.of(this.methodDescription.getDeclaringType().asErasure()));
                        } else {
                            StackManipulation assign = this.assigner.assign(generic3, this.methodDescription.getDeclaringType().asGenericType(), this.typing);
                            if (assign.isValid()) {
                                arrayList.add(assign);
                            } else {
                                throw new IllegalStateException("Cannot assign " + generic3 + " to " + this.methodDescription.getDeclaringType());
                            }
                        }
                        int i13 = 0;
                        if ((member.getModifiers() & 8) != 0 || ((member instanceof MethodDescription) && ((MethodDescription) member).isConstructor())) {
                            i11 = 0;
                        } else {
                            i11 = 1;
                        }
                        while (i13 < this.methodDescription.getParameters().size()) {
                            if (this.substitutions.containsKey(Integer.valueOf(i13 + i11))) {
                                i12 = this.substitutions.get(Integer.valueOf(i13 + i11)).intValue();
                            } else {
                                i12 = i13 + i11;
                            }
                            if (i12 < generic.size()) {
                                arrayList.add(MethodVariableAccess.of((TypeDefinition) generic.get(i12)).loadFrom(map.get(Integer.valueOf(i12)).intValue()));
                                StackManipulation assign2 = this.assigner.assign((TypeDescription.Generic) generic.get(i12), ((ParameterDescription) this.methodDescription.getParameters().get(i13)).getType(), this.typing);
                                if (assign2.isValid()) {
                                    arrayList.add(assign2);
                                    i13++;
                                } else {
                                    throw new IllegalStateException("Cannot assign parameter with " + i13 + " of type " + generic.get(i12) + " to " + this.methodDescription);
                                }
                            } else {
                                throw new IllegalStateException(member + " does not support an index " + i12);
                            }
                        }
                        arrayList.add(MethodInvocation.invoke(this.methodDescription));
                        return new Simple((StackManipulation) new StackManipulation.Compound((List<? extends StackManipulation>) arrayList), this.methodDescription.getReturnType());
                    }
                }

                public enum OfOriginalExpression implements Step, Factory {
                    INSTANCE;

                    public Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this;
                    }

                    public Resolution resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i10) {
                        ArrayList arrayList;
                        TypeDescription.Generic generic4;
                        boolean z10 = member instanceof MethodDescription;
                        if (!z10 || !((MethodDescription) member).isConstructor()) {
                            arrayList = new ArrayList(generic.size() + 4);
                            arrayList.add(Removal.of(generic3));
                        } else {
                            arrayList = new ArrayList(generic.size() + 4);
                            arrayList.add(Removal.of(generic3));
                            arrayList.add(TypeCreation.of(member.getDeclaringType().asErasure()));
                            arrayList.add(Duplication.SINGLE);
                        }
                        for (int i11 = 0; i11 < generic.size(); i11++) {
                            arrayList.add(MethodVariableAccess.of((TypeDefinition) generic.get(i11)).loadFrom(map.get(Integer.valueOf(i11)).intValue()));
                        }
                        if (z10) {
                            arrayList.add(stackManipulation);
                            StackManipulation.Compound compound = new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
                            MethodDescription methodDescription = (MethodDescription) member;
                            if (methodDescription.isConstructor()) {
                                generic4 = member.getDeclaringType().asGenericType();
                            } else {
                                generic4 = methodDescription.getReturnType();
                            }
                            return new Simple((StackManipulation) compound, generic4);
                        } else if (!(member instanceof FieldDescription)) {
                            throw new IllegalArgumentException("Unexpected target type: " + member);
                        } else if (member.isStatic()) {
                            if (generic.isEmpty()) {
                                arrayList.add(stackManipulation);
                                return new Simple((StackManipulation) new StackManipulation.Compound((List<? extends StackManipulation>) arrayList), ((FieldDescription) member).getType());
                            }
                            arrayList.add(stackManipulation);
                            return new Simple((StackManipulation) new StackManipulation.Compound((List<? extends StackManipulation>) arrayList), TypeDefinition.Sort.describe(Void.TYPE));
                        } else if (generic.size() == 1) {
                            FieldDescription fieldDescription = (FieldDescription) member;
                            arrayList.add(FieldAccess.forField(fieldDescription).read());
                            return new Simple((StackManipulation) new StackManipulation.Compound((List<? extends StackManipulation>) arrayList), fieldDescription.getType());
                        } else {
                            arrayList.add(FieldAccess.forField((FieldDescription) member).write());
                            return new Simple((StackManipulation) new StackManipulation.Compound((List<? extends StackManipulation>) arrayList), TypeDefinition.Sort.describe(Void.TYPE));
                        }
                    }
                }

                public interface Resolution {
                    TypeDescription.Generic getResultType();

                    StackManipulation getStackManipulation();
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements Step, Resolution, Factory {
                    private final TypeDescription.Generic resultType;
                    private final StackManipulation stackManipulation;

                    public Simple(StackManipulation stackManipulation2, Type type) {
                        this(stackManipulation2, TypeDefinition.Sort.describe(type));
                    }

                    public static Factory of(Object obj) {
                        ConstantValue wrap = ConstantValue.Simple.wrap(obj);
                        return new Simple(wrap.toStackManipulation(), wrap.getTypeDescription().asGenericType());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Simple simple = (Simple) obj;
                        return this.stackManipulation.equals(simple.stackManipulation) && this.resultType.equals(simple.resultType);
                    }

                    public TypeDescription.Generic getResultType() {
                        return this.resultType;
                    }

                    public StackManipulation getStackManipulation() {
                        return this.stackManipulation;
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.resultType.hashCode();
                    }

                    public Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this;
                    }

                    public Resolution resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation2, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i10) {
                        if (typeDescription.represents(Void.TYPE)) {
                            return this;
                        }
                        return new Simple((StackManipulation) new StackManipulation.Compound(Removal.of(generic3), this.stackManipulation), this.resultType);
                    }

                    public Simple(StackManipulation stackManipulation2, TypeDescription.Generic generic) {
                        this.stackManipulation = stackManipulation2;
                        this.resultType = generic;
                    }
                }

                Resolution resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i10);
            }

            protected Chain(Assigner assigner2, Assigner.Typing typing2, List<Step> list) {
                this.assigner = assigner2;
                this.typing = typing2;
                this.steps = list;
            }

            public static Factory with(Assigner assigner2, Assigner.Typing typing2) {
                return new Factory(assigner2, typing2, Collections.emptyList());
            }

            public static Factory withDefaultAssigner() {
                return with(Assigner.DEFAULT, Assigner.Typing.STATIC);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Chain chain = (Chain) obj;
                return this.typing.equals(chain.typing) && this.assigner.equals(chain.assigner) && this.steps.equals(chain.steps);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.assigner.hashCode()) * 31) + this.typing.hashCode()) * 31) + this.steps.hashCode();
            }

            public StackManipulation resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i10) {
                TypeList.Generic generic3 = generic;
                TypeDescription.Generic generic4 = generic2;
                int i11 = 2;
                int size = generic.size() + 1 + (this.steps.size() * 2);
                if (generic4.represents(Void.TYPE)) {
                    i11 = 0;
                }
                ArrayList arrayList = new ArrayList(size + i11);
                HashMap hashMap = new HashMap();
                int i12 = i10;
                for (int size2 = generic.size() - 1; size2 >= 0; size2--) {
                    arrayList.add(MethodVariableAccess.of((TypeDefinition) generic3.get(size2)).storeAt(i12));
                    hashMap.put(Integer.valueOf(size2), Integer.valueOf(i12));
                    i12 += ((TypeDescription.Generic) generic3.get(size2)).getStackSize().getSize();
                }
                arrayList.add(DefaultValue.of(generic2));
                TypeDescription.Generic generic5 = generic4;
                for (Step resolve : this.steps) {
                    Step.Resolution resolve2 = resolve.resolve(typeDescription, member, generic, generic2, methodHandle, stackManipulation, generic5, hashMap, i12);
                    arrayList.add(resolve2.getStackManipulation());
                    generic5 = resolve2.getResultType();
                }
                StackManipulation assign = this.assigner.assign(generic5, generic4, this.typing);
                if (assign.isValid()) {
                    arrayList.add(assign);
                    return new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
                }
                throw new IllegalStateException("Failed to assign " + generic5 + " to " + generic4);
            }
        }

        public interface Factory {
            Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFieldAccess implements Substitution {
            private final FieldResolver fieldResolver;
            private final TypeDescription instrumentedType;

            public interface FieldResolver {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForElementMatcher implements FieldResolver {
                    private final TypeDescription instrumentedType;
                    private final ElementMatcher<? super FieldDescription> matcher;

                    protected ForElementMatcher(TypeDescription typeDescription, ElementMatcher<? super FieldDescription> elementMatcher) {
                        this.instrumentedType = typeDescription;
                        this.matcher = elementMatcher;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForElementMatcher forElementMatcher = (ForElementMatcher) obj;
                        return this.instrumentedType.equals(forElementMatcher.instrumentedType) && this.matcher.equals(forElementMatcher.matcher);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.matcher.hashCode();
                    }

                    public FieldDescription resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        if (generic.isEmpty()) {
                            throw new IllegalStateException("Cannot substitute parameterless instruction with " + member);
                        } else if (((TypeDescription.Generic) generic.get(0)).isPrimitive() || ((TypeDescription.Generic) generic.get(0)).isArray()) {
                            throw new IllegalStateException("Cannot access field on primitive or array type for " + member);
                        } else {
                            TypeDefinition typeDefinition = (TypeDefinition) ((TypeDescription.Generic) generic.get(0)).accept(new TypeDescription.Generic.Visitor.Substitutor.ForReplacement(this.instrumentedType));
                            do {
                                FieldList fieldList = (FieldList) typeDefinition.getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic()).and(ElementMatchers.isVisibleTo(this.instrumentedType)).and(this.matcher));
                                if (fieldList.size() == 1) {
                                    return (FieldDescription) fieldList.getOnly();
                                }
                                if (fieldList.size() <= 1) {
                                    typeDefinition = typeDefinition.getSuperClass();
                                } else {
                                    throw new IllegalStateException("Ambiguous field location of " + fieldList);
                                }
                            } while (typeDefinition != null);
                            throw new IllegalStateException("Cannot locate field matching " + this.matcher + " on " + typeDescription);
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements FieldResolver {
                    private final FieldDescription fieldDescription;

                    public Simple(FieldDescription fieldDescription2) {
                        this.fieldDescription = fieldDescription2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Simple) obj).fieldDescription);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                    }

                    public FieldDescription resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        return this.fieldDescription;
                    }
                }

                FieldDescription resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2);
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfGivenField implements Factory {
                private final FieldDescription fieldDescription;

                public OfGivenField(FieldDescription fieldDescription2) {
                    this.fieldDescription = fieldDescription2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((OfGivenField) obj).fieldDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                }

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForFieldAccess(typeDescription, new FieldResolver.Simple(this.fieldDescription));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfMatchedField implements Factory {
                private final ElementMatcher<? super FieldDescription> matcher;

                public OfMatchedField(ElementMatcher<? super FieldDescription> elementMatcher) {
                    this.matcher = elementMatcher;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matcher.equals(((OfMatchedField) obj).matcher);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matcher.hashCode();
                }

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForFieldAccess(typeDescription, new FieldResolver.ForElementMatcher(typeDescription, this.matcher));
                }
            }

            public ForFieldAccess(TypeDescription typeDescription, FieldResolver fieldResolver2) {
                this.instrumentedType = typeDescription;
                this.fieldResolver = fieldResolver2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForFieldAccess forFieldAccess = (ForFieldAccess) obj;
                return this.instrumentedType.equals(forFieldAccess.instrumentedType) && this.fieldResolver.equals(forFieldAccess.fieldResolver);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.fieldResolver.hashCode();
            }

            @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public StackManipulation resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i10) {
                int i11;
                FieldDescription resolve = this.fieldResolver.resolve(typeDescription, member, generic, generic2);
                if (!resolve.isAccessibleTo(this.instrumentedType)) {
                    throw new IllegalStateException(this.instrumentedType + " cannot access " + resolve);
                } else if (generic2.represents(Void.TYPE)) {
                    int size = generic.size();
                    if (resolve.isStatic()) {
                        i11 = 1;
                    } else {
                        i11 = 2;
                    }
                    if (size != i11) {
                        throw new IllegalStateException("Cannot set " + resolve + " with " + generic);
                    } else if (!resolve.isStatic() && !((TypeDescription.Generic) generic.get(0)).asErasure().isAssignableTo(resolve.getDeclaringType().asErasure())) {
                        throw new IllegalStateException("Cannot set " + resolve + " on " + generic.get(0));
                    } else if (((TypeDescription.Generic) generic.get(resolve.isStatic() ^ true ? 1 : 0)).asErasure().isAssignableTo(resolve.getType().asErasure())) {
                        return FieldAccess.forField(resolve).write();
                    } else {
                        throw new IllegalStateException("Cannot set " + resolve + " to " + generic.get(resolve.isStatic() ^ true ? 1 : 0));
                    }
                } else if (generic.size() != (true ^ resolve.isStatic())) {
                    throw new IllegalStateException("Cannot set " + resolve + " with " + generic);
                } else if (!resolve.isStatic() && !((TypeDescription.Generic) generic.get(0)).asErasure().isAssignableTo(resolve.getDeclaringType().asErasure())) {
                    throw new IllegalStateException("Cannot get " + resolve + " on " + generic.get(0));
                } else if (resolve.getType().asErasure().isAssignableTo(generic2.asErasure())) {
                    return FieldAccess.forField(resolve).read();
                } else {
                    throw new IllegalStateException("Cannot get " + resolve + " as " + generic2);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMethodInvocation implements Substitution {
            private final TypeDescription instrumentedType;
            private final MethodResolver methodResolver;

            public interface MethodResolver {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Matching implements MethodResolver {
                    private final TypeDescription instrumentedType;
                    private final ElementMatcher<? super MethodDescription> matcher;
                    private final MethodGraph.Compiler methodGraphCompiler;

                    public Matching(TypeDescription typeDescription, MethodGraph.Compiler compiler, ElementMatcher<? super MethodDescription> elementMatcher) {
                        this.instrumentedType = typeDescription;
                        this.methodGraphCompiler = compiler;
                        this.matcher = elementMatcher;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Matching matching = (Matching) obj;
                        return this.instrumentedType.equals(matching.instrumentedType) && this.methodGraphCompiler.equals(matching.methodGraphCompiler) && this.matcher.equals(matching.matcher);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.methodGraphCompiler.hashCode()) * 31) + this.matcher.hashCode();
                    }

                    public MethodDescription resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        if (generic.isEmpty()) {
                            throw new IllegalStateException("Cannot substitute parameterless instruction with " + member);
                        } else if (((TypeDescription.Generic) generic.get(0)).isPrimitive() || ((TypeDescription.Generic) generic.get(0)).isArray()) {
                            throw new IllegalStateException("Cannot invoke method on primitive or array type for " + member);
                        } else {
                            TypeDefinition typeDefinition = (TypeDefinition) ((TypeDescription.Generic) generic.get(0)).accept(new TypeDescription.Generic.Visitor.Substitutor.ForReplacement(this.instrumentedType));
                            List of2 = CompoundList.of(this.methodGraphCompiler.compile(typeDefinition, this.instrumentedType).listNodes().asMethodList().filter(this.matcher), (FilterableList) typeDefinition.getDeclaredMethods().filter(ElementMatchers.isPrivate().and(ElementMatchers.isVisibleTo(this.instrumentedType)).and(this.matcher)));
                            if (of2.size() == 1) {
                                return (MethodDescription) of2.get(0);
                            }
                            throw new IllegalStateException("Not exactly one method that matches " + this.matcher + ": " + of2);
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements MethodResolver {
                    private final MethodDescription methodDescription;

                    public Simple(MethodDescription methodDescription2) {
                        this.methodDescription = methodDescription2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((Simple) obj).methodDescription);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
                    }

                    public MethodDescription resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        return this.methodDescription;
                    }
                }

                MethodDescription resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2);
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfGivenMethod implements Factory {
                private final MethodDescription methodDescription;

                public OfGivenMethod(MethodDescription methodDescription2) {
                    this.methodDescription = methodDescription2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((OfGivenMethod) obj).methodDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
                }

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription2, TypePool typePool) {
                    return new ForMethodInvocation(typeDescription, new MethodResolver.Simple(this.methodDescription));
                }
            }

            enum OfInstrumentedMethod implements Factory {
                INSTANCE;

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForMethodInvocation(typeDescription, new MethodResolver.Simple(methodDescription));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfMatchedMethod implements Factory {
                private final ElementMatcher<? super MethodDescription> matcher;
                private final MethodGraph.Compiler methodGraphCompiler;

                public OfMatchedMethod(ElementMatcher<? super MethodDescription> elementMatcher, MethodGraph.Compiler compiler) {
                    this.matcher = elementMatcher;
                    this.methodGraphCompiler = compiler;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfMatchedMethod ofMatchedMethod = (OfMatchedMethod) obj;
                    return this.matcher.equals(ofMatchedMethod.matcher) && this.methodGraphCompiler.equals(ofMatchedMethod.methodGraphCompiler);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.methodGraphCompiler.hashCode();
                }

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForMethodInvocation(typeDescription, new MethodResolver.Matching(typeDescription, this.methodGraphCompiler, this.matcher));
                }
            }

            public ForMethodInvocation(TypeDescription typeDescription, MethodResolver methodResolver2) {
                this.instrumentedType = typeDescription;
                this.methodResolver = methodResolver2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMethodInvocation forMethodInvocation = (ForMethodInvocation) obj;
                return this.instrumentedType.equals(forMethodInvocation.instrumentedType) && this.methodResolver.equals(forMethodInvocation.methodResolver);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.methodResolver.hashCode();
            }

            public StackManipulation resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i10) {
                List list;
                MethodDescription resolve = this.methodResolver.resolve(typeDescription, member, generic, generic2);
                if (resolve.isAccessibleTo(this.instrumentedType)) {
                    if (resolve.isStatic()) {
                        list = resolve.getParameters().asTypeList();
                    } else {
                        list = new TypeList.Generic.Explicit((List<? extends TypeDefinition>) CompoundList.of(resolve.getDeclaringType(), resolve.getParameters().asTypeList()));
                    }
                    if (!resolve.getReturnType().asErasure().isAssignableTo(generic2.asErasure())) {
                        throw new IllegalStateException("Cannot assign return value of " + resolve + " to " + generic2);
                    } else if (list.size() == generic.size()) {
                        int i11 = 0;
                        while (i11 < list.size()) {
                            if (((TypeDescription.Generic) generic.get(i11)).asErasure().isAssignableTo(((TypeDescription.Generic) list.get(i11)).asErasure())) {
                                i11++;
                            } else {
                                throw new IllegalStateException("Cannot invoke " + resolve + " on parameter " + i11 + " of type " + generic.get(i11));
                            }
                        }
                        boolean isVirtual = resolve.isVirtual();
                        MethodInvocation.WithImplicitInvocationTargetType invoke = MethodInvocation.invoke(resolve);
                        if (isVirtual) {
                            return invoke.virtual(((TypeDescription.Generic) list.get(0)).asErasure());
                        }
                        return invoke;
                    } else {
                        throw new IllegalStateException("Cannot invoke " + resolve + " on " + generic.size() + " parameters");
                    }
                } else {
                    throw new IllegalStateException(this.instrumentedType + " cannot access " + resolve);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForValue implements Substitution, Factory {
            private final StackManipulation stackManipulation;
            private final TypeDescription.Generic typeDescription;

            public ForValue(StackManipulation stackManipulation2, TypeDescription.Generic generic) {
                this.stackManipulation = stackManipulation2;
                this.typeDescription = generic;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForValue forValue = (ForValue) obj;
                return this.stackManipulation.equals(forValue.stackManipulation) && this.typeDescription.equals(forValue.typeDescription);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDescription.hashCode();
            }

            public Substitution make(TypeDescription typeDescription2, MethodDescription methodDescription, TypePool typePool) {
                return this;
            }

            public StackManipulation resolve(TypeDescription typeDescription2, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation2, int i10) {
                ArrayList arrayList = new ArrayList(generic.size());
                for (int size = generic.size() - 1; size >= 0; size--) {
                    arrayList.add(Removal.of((TypeDefinition) generic.get(size)));
                }
                if (this.typeDescription.asErasure().isAssignableTo(generic2.asErasure())) {
                    return new StackManipulation.Compound((List<? extends StackManipulation>) CompoundList.of(arrayList, this.stackManipulation));
                }
                throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + generic2);
            }
        }

        public enum Stubbing implements Substitution, Factory {
            INSTANCE;

            public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return this;
            }

            public StackManipulation resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i10) {
                ArrayList arrayList = new ArrayList(generic.size());
                for (int size = generic.size() - 1; size >= 0; size--) {
                    arrayList.add(Removal.of((TypeDefinition) generic.get(size)));
                }
                return new StackManipulation.Compound((List<? extends StackManipulation>) CompoundList.of(arrayList, DefaultValue.of(generic2.asErasure())));
            }
        }

        StackManipulation resolve(TypeDescription typeDescription, ByteCodeElement.Member member, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i10);
    }

    @Documented
    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface This {
        boolean optional() default false;

        Source source() default Source.SUBSTITUTED_ELEMENT;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    public interface TypePoolResolver {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForClassFileLocator implements TypePoolResolver {
            private final ClassFileLocator classFileLocator;
            private final TypePool.Default.ReaderMode readerMode;

            public ForClassFileLocator(ClassFileLocator classFileLocator2) {
                this(classFileLocator2, TypePool.Default.ReaderMode.FAST);
            }

            public static TypePoolResolver of(@MaybeNull ClassLoader classLoader) {
                return new ForClassFileLocator(ClassFileLocator.ForClassLoader.of(classLoader));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForClassFileLocator forClassFileLocator = (ForClassFileLocator) obj;
                return this.readerMode.equals(forClassFileLocator.readerMode) && this.classFileLocator.equals(forClassFileLocator.classFileLocator);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.classFileLocator.hashCode()) * 31) + this.readerMode.hashCode();
            }

            public TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return new TypePool.Default(new TypePool.CacheProvider.Simple(), this.classFileLocator, this.readerMode, typePool);
            }

            public ForClassFileLocator(ClassFileLocator classFileLocator2, TypePool.Default.ReaderMode readerMode2) {
                this.classFileLocator = classFileLocator2;
                this.readerMode = readerMode2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForExplicitPool implements TypePoolResolver {
            private final TypePool typePool;

            public ForExplicitPool(TypePool typePool2) {
                this.typePool = typePool2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typePool.equals(((ForExplicitPool) obj).typePool);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.typePool.hashCode();
            }

            public TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool2) {
                return this.typePool;
            }
        }

        public enum OfImplicitPool implements TypePoolResolver {
            INSTANCE;

            public TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return typePool;
            }
        }

        TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool);
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Unused {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class WithoutSpecification {
        protected final MethodGraph.Compiler methodGraphCompiler;
        protected final Replacement.Factory replacementFactory;
        protected final boolean strict;
        protected final TypePoolResolver typePoolResolver;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ForMatchedByteCodeElement extends WithoutSpecification {
            private final ElementMatcher<? super ByteCodeElement.Member> matcher;

            protected ForMatchedByteCodeElement(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z10, Replacement.Factory factory, ElementMatcher<? super ByteCodeElement.Member> elementMatcher) {
                super(compiler, typePoolResolver, z10, factory);
                this.matcher = elementMatcher;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matcher.equals(((ForMatchedByteCodeElement) obj).matcher);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.matcher.hashCode();
            }

            public MemberSubstitution replaceWith(Substitution.Factory factory) {
                return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, new Replacement.Factory.Compound(this.replacementFactory, Replacement.ForElementMatchers.Factory.of(this.matcher, factory)));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMatchedField extends WithoutSpecification {
            private final boolean matchRead;
            private final boolean matchWrite;
            private final ElementMatcher<? super FieldDescription.InDefinedShape> matcher;

            protected ForMatchedField(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z10, Replacement.Factory factory, ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
                this(compiler, typePoolResolver, z10, factory, elementMatcher, true, true);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMatchedField forMatchedField = (ForMatchedField) obj;
                return this.matchRead == forMatchedField.matchRead && this.matchWrite == forMatchedField.matchWrite && this.matcher.equals(forMatchedField.matcher);
            }

            public int hashCode() {
                return (((((super.hashCode() * 31) + this.matcher.hashCode()) * 31) + (this.matchRead ? 1 : 0)) * 31) + (this.matchWrite ? 1 : 0);
            }

            public WithoutSpecification onRead() {
                return new ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, this.matcher, true, false);
            }

            public WithoutSpecification onWrite() {
                return new ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, this.matcher, false, true);
            }

            public MemberSubstitution replaceWith(Substitution.Factory factory) {
                return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, new Replacement.Factory.Compound(this.replacementFactory, Replacement.ForElementMatchers.Factory.ofField(this.matcher, this.matchRead, this.matchWrite, factory)));
            }

            protected ForMatchedField(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z10, Replacement.Factory factory, ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, boolean z11, boolean z12) {
                super(compiler, typePoolResolver, z10, factory);
                this.matcher = elementMatcher;
                this.matchRead = z11;
                this.matchWrite = z12;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMatchedMethod extends WithoutSpecification {
            private final boolean includeSuperCalls;
            private final boolean includeVirtualCalls;
            private final ElementMatcher<? super MethodDescription> matcher;

            protected ForMatchedMethod(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z10, Replacement.Factory factory, ElementMatcher<? super MethodDescription> elementMatcher) {
                this(compiler, typePoolResolver, z10, factory, elementMatcher, true, true);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMatchedMethod forMatchedMethod = (ForMatchedMethod) obj;
                return this.includeVirtualCalls == forMatchedMethod.includeVirtualCalls && this.includeSuperCalls == forMatchedMethod.includeSuperCalls && this.matcher.equals(forMatchedMethod.matcher);
            }

            public int hashCode() {
                return (((((super.hashCode() * 31) + this.matcher.hashCode()) * 31) + (this.includeVirtualCalls ? 1 : 0)) * 31) + (this.includeSuperCalls ? 1 : 0);
            }

            public WithoutSpecification onSuperCall() {
                return new ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, ElementMatchers.isVirtual().and(this.matcher), false, true);
            }

            public WithoutSpecification onVirtualCall() {
                return new ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, ElementMatchers.isVirtual().and(this.matcher), true, false);
            }

            public MemberSubstitution replaceWith(Substitution.Factory factory) {
                return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, new Replacement.Factory.Compound(this.replacementFactory, Replacement.ForElementMatchers.Factory.ofMethod(this.matcher, this.includeVirtualCalls, this.includeSuperCalls, factory)));
            }

            protected ForMatchedMethod(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z10, Replacement.Factory factory, ElementMatcher<? super MethodDescription> elementMatcher, boolean z11, boolean z12) {
                super(compiler, typePoolResolver, z10, factory);
                this.matcher = elementMatcher;
                this.includeVirtualCalls = z11;
                this.includeSuperCalls = z12;
            }
        }

        protected WithoutSpecification(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver2, boolean z10, Replacement.Factory factory) {
            this.methodGraphCompiler = compiler;
            this.typePoolResolver = typePoolResolver2;
            this.strict = z10;
            this.replacementFactory = factory;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WithoutSpecification withoutSpecification = (WithoutSpecification) obj;
            return this.strict == withoutSpecification.strict && this.methodGraphCompiler.equals(withoutSpecification.methodGraphCompiler) && this.typePoolResolver.equals(withoutSpecification.typePoolResolver) && this.replacementFactory.equals(withoutSpecification.replacementFactory);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.methodGraphCompiler.hashCode()) * 31) + this.typePoolResolver.hashCode()) * 31) + (this.strict ? 1 : 0)) * 31) + this.replacementFactory.hashCode();
        }

        public MemberSubstitution replaceWith(Field field) {
            return replaceWith((FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public abstract MemberSubstitution replaceWith(Substitution.Factory factory);

        public MemberSubstitution replaceWithChain(Substitution.Chain.Step.Factory... factoryArr) {
            return replaceWithChain((List<? extends Substitution.Chain.Step.Factory>) Arrays.asList(factoryArr));
        }

        public MemberSubstitution replaceWithConstant(Object obj) {
            ConstantValue wrap = ConstantValue.Simple.wrap(obj);
            return replaceWith((Substitution.Factory) new Substitution.ForValue(wrap.toStackManipulation(), wrap.getTypeDescription().asGenericType()));
        }

        public MemberSubstitution replaceWithField(ElementMatcher<? super FieldDescription> elementMatcher) {
            return replaceWith((Substitution.Factory) new Substitution.ForFieldAccess.OfMatchedField(elementMatcher));
        }

        public MemberSubstitution replaceWithInstrumentedMethod() {
            return replaceWith((Substitution.Factory) Substitution.ForMethodInvocation.OfInstrumentedMethod.INSTANCE);
        }

        public MemberSubstitution replaceWithMethod(ElementMatcher<? super MethodDescription> elementMatcher) {
            return replaceWithMethod(elementMatcher, this.methodGraphCompiler);
        }

        public MemberSubstitution stub() {
            return replaceWith((Substitution.Factory) Substitution.Stubbing.INSTANCE);
        }

        public MemberSubstitution replaceWith(FieldDescription fieldDescription) {
            return replaceWith((Substitution.Factory) new Substitution.ForFieldAccess.OfGivenField(fieldDescription));
        }

        public MemberSubstitution replaceWithChain(List<? extends Substitution.Chain.Step.Factory> list) {
            return replaceWith((Substitution.Factory) Substitution.Chain.withDefaultAssigner().executing(list));
        }

        public MemberSubstitution replaceWithMethod(ElementMatcher<? super MethodDescription> elementMatcher, MethodGraph.Compiler compiler) {
            return replaceWith((Substitution.Factory) new Substitution.ForMethodInvocation.OfMatchedMethod(elementMatcher, compiler));
        }

        public MemberSubstitution replaceWith(Method method) {
            return replaceWith((MethodDescription) new MethodDescription.ForLoadedMethod(method));
        }

        public MemberSubstitution replaceWith(MethodDescription methodDescription) {
            if (methodDescription.isMethod()) {
                return replaceWith((Substitution.Factory) new Substitution.ForMethodInvocation.OfGivenMethod(methodDescription));
            }
            throw new IllegalArgumentException("Cannot use " + methodDescription + " as a replacement");
        }
    }

    protected MemberSubstitution(boolean z10) {
        this(MethodGraph.Compiler.DEFAULT, TypePoolResolver.OfImplicitPool.INSTANCE, z10, Replacement.NoOp.INSTANCE);
    }

    public static MemberSubstitution relaxed() {
        return new MemberSubstitution(false);
    }

    public static MemberSubstitution strict() {
        return new MemberSubstitution(true);
    }

    public WithoutSpecification constructor(ElementMatcher<? super MethodDescription> elementMatcher) {
        return invokable(ElementMatchers.isConstructor().and(elementMatcher));
    }

    public WithoutSpecification element(ElementMatcher<? super ByteCodeElement.Member> elementMatcher) {
        return new WithoutSpecification.ForMatchedByteCodeElement(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, elementMatcher);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MemberSubstitution memberSubstitution = (MemberSubstitution) obj;
        return this.strict == memberSubstitution.strict && this.methodGraphCompiler.equals(memberSubstitution.methodGraphCompiler) && this.typePoolResolver.equals(memberSubstitution.typePoolResolver) && this.replacementFactory.equals(memberSubstitution.replacementFactory);
    }

    public WithoutSpecification.ForMatchedField field(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new WithoutSpecification.ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, elementMatcher);
    }

    public int hashCode() {
        return (((((((getClass().hashCode() * 31) + this.methodGraphCompiler.hashCode()) * 31) + (this.strict ? 1 : 0)) * 31) + this.typePoolResolver.hashCode()) * 31) + this.replacementFactory.hashCode();
    }

    public WithoutSpecification invokable(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new WithoutSpecification.ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, elementMatcher);
    }

    public WithoutSpecification.ForMatchedMethod method(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new WithoutSpecification.ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, elementMatcher);
    }

    public AsmVisitorWrapper.ForDeclaredMethods on(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new AsmVisitorWrapper.ForDeclaredMethods().invokable(elementMatcher, this);
    }

    public MemberSubstitution with(MethodGraph.Compiler compiler) {
        return new MemberSubstitution(compiler, this.typePoolResolver, this.strict, this.replacementFactory);
    }

    public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i10, int i11) {
        TypePool resolve = this.typePoolResolver.resolve(typeDescription, methodDescription, typePool);
        return new SubstitutingMethodVisitor(methodVisitor, typeDescription, methodDescription, this.methodGraphCompiler, this.strict, this.replacementFactory.make(typeDescription, methodDescription, resolve), context, resolve, context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V11));
    }

    protected MemberSubstitution(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver2, boolean z10, Replacement.Factory factory) {
        this.methodGraphCompiler = compiler;
        this.typePoolResolver = typePoolResolver2;
        this.strict = z10;
        this.replacementFactory = factory;
    }

    public MemberSubstitution with(TypePoolResolver typePoolResolver2) {
        return new MemberSubstitution(this.methodGraphCompiler, typePoolResolver2, this.strict, this.replacementFactory);
    }
}
