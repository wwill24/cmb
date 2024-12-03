package net.bytebuddy.implementation.bind;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface MethodDelegationBinder {

    /* renamed from: net.bytebuddy.implementation.bind.MethodDelegationBinder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$bytebuddy$implementation$bind$MethodDelegationBinder$AmbiguityResolver$Resolution;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.bytebuddy.implementation.bind.MethodDelegationBinder$AmbiguityResolver$Resolution[] r0 = net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver.Resolution.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$bytebuddy$implementation$bind$MethodDelegationBinder$AmbiguityResolver$Resolution = r0
                net.bytebuddy.implementation.bind.MethodDelegationBinder$AmbiguityResolver$Resolution r1 = net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$bytebuddy$implementation$bind$MethodDelegationBinder$AmbiguityResolver$Resolution     // Catch:{ NoSuchFieldError -> 0x001d }
                net.bytebuddy.implementation.bind.MethodDelegationBinder$AmbiguityResolver$Resolution r1 = net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$bytebuddy$implementation$bind$MethodDelegationBinder$AmbiguityResolver$Resolution     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.bytebuddy.implementation.bind.MethodDelegationBinder$AmbiguityResolver$Resolution r1 = net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$bytebuddy$implementation$bind$MethodDelegationBinder$AmbiguityResolver$Resolution     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.bytebuddy.implementation.bind.MethodDelegationBinder$AmbiguityResolver$Resolution r1 = net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.implementation.bind.MethodDelegationBinder.AnonymousClass1.<clinit>():void");
        }
    }

    @SuppressFBWarnings(justification = "Safe initialization is implied.", value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"})
    public interface AmbiguityResolver {
        public static final AmbiguityResolver DEFAULT = new Compound(BindingPriority.Resolver.INSTANCE, DeclaringTypeResolver.INSTANCE, ArgumentTypeResolver.INSTANCE, MethodNameEqualityResolver.INSTANCE, ParameterLengthResolver.INSTANCE);

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements AmbiguityResolver {
            private final List<AmbiguityResolver> ambiguityResolvers;

            public Compound(AmbiguityResolver... ambiguityResolverArr) {
                this((List<? extends AmbiguityResolver>) Arrays.asList(ambiguityResolverArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.ambiguityResolvers.equals(((Compound) obj).ambiguityResolvers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.ambiguityResolvers.hashCode();
            }

            public Resolution resolve(MethodDescription methodDescription, MethodBinding methodBinding, MethodBinding methodBinding2) {
                Resolution resolution = Resolution.UNKNOWN;
                Iterator<AmbiguityResolver> it = this.ambiguityResolvers.iterator();
                while (resolution.isUnresolved() && it.hasNext()) {
                    resolution = it.next().resolve(methodDescription, methodBinding, methodBinding2);
                }
                return resolution;
            }

            public Compound(List<? extends AmbiguityResolver> list) {
                this.ambiguityResolvers = new ArrayList();
                for (AmbiguityResolver ambiguityResolver : list) {
                    if (ambiguityResolver instanceof Compound) {
                        this.ambiguityResolvers.addAll(((Compound) ambiguityResolver).ambiguityResolvers);
                    } else if (!(ambiguityResolver instanceof NoOp)) {
                        this.ambiguityResolvers.add(ambiguityResolver);
                    }
                }
            }
        }

        public enum Directional implements AmbiguityResolver {
            LEFT(true),
            RIGHT(false);
            
            private final boolean left;

            private Directional(boolean z10) {
                this.left = z10;
            }

            public Resolution resolve(MethodDescription methodDescription, MethodBinding methodBinding, MethodBinding methodBinding2) {
                return this.left ? Resolution.LEFT : Resolution.RIGHT;
            }
        }

        public enum NoOp implements AmbiguityResolver {
            INSTANCE;

            public Resolution resolve(MethodDescription methodDescription, MethodBinding methodBinding, MethodBinding methodBinding2) {
                return Resolution.UNKNOWN;
            }
        }

        public enum Resolution {
            UNKNOWN(true),
            LEFT(false),
            RIGHT(false),
            AMBIGUOUS(true);
            
            private final boolean unresolved;

            private Resolution(boolean z10) {
                this.unresolved = z10;
            }

            public boolean isUnresolved() {
                return this.unresolved;
            }

            public Resolution merge(Resolution resolution) {
                int i10 = AnonymousClass1.$SwitchMap$net$bytebuddy$implementation$bind$MethodDelegationBinder$AmbiguityResolver$Resolution[ordinal()];
                if (i10 == 1 || i10 == 2) {
                    if (resolution == UNKNOWN || resolution == this) {
                        return this;
                    }
                    return AMBIGUOUS;
                } else if (i10 == 3) {
                    return AMBIGUOUS;
                } else {
                    if (i10 == 4) {
                        return resolution;
                    }
                    throw new AssertionError();
                }
            }
        }

        Resolution resolve(MethodDescription methodDescription, MethodBinding methodBinding, MethodBinding methodBinding2);
    }

    public interface BindingResolver {

        public enum Default implements BindingResolver {
            INSTANCE;
            
            private static final int LEFT = 0;
            private static final int ONLY = 0;
            private static final int RIGHT = 1;

            private MethodBinding doResolve(AmbiguityResolver ambiguityResolver, MethodDescription methodDescription, List<MethodBinding> list) {
                int size = list.size();
                if (size == 1) {
                    return list.get(0);
                }
                if (size != 2) {
                    MethodBinding methodBinding = list.get(0);
                    MethodBinding methodBinding2 = list.get(1);
                    int[] iArr = AnonymousClass1.$SwitchMap$net$bytebuddy$implementation$bind$MethodDelegationBinder$AmbiguityResolver$Resolution;
                    int i10 = iArr[ambiguityResolver.resolve(methodDescription, methodBinding, methodBinding2).ordinal()];
                    if (i10 == 1) {
                        list.remove(1);
                        return doResolve(ambiguityResolver, methodDescription, list);
                    } else if (i10 == 2) {
                        list.remove(0);
                        return doResolve(ambiguityResolver, methodDescription, list);
                    } else if (i10 == 3 || i10 == 4) {
                        list.remove(1);
                        list.remove(0);
                        MethodBinding doResolve = doResolve(ambiguityResolver, methodDescription, list);
                        int i11 = iArr[ambiguityResolver.resolve(methodDescription, methodBinding, doResolve).merge(ambiguityResolver.resolve(methodDescription, methodBinding2, doResolve)).ordinal()];
                        if (i11 != 1) {
                            if (i11 == 2) {
                                return doResolve;
                            }
                            if (!(i11 == 3 || i11 == 4)) {
                                throw new AssertionError();
                            }
                        }
                        throw new IllegalArgumentException("Cannot resolve ambiguous delegation of " + methodDescription + " to " + methodBinding.getTarget() + " or " + methodBinding2.getTarget());
                    } else {
                        throw new IllegalStateException("Unexpected amount of targets: " + list.size());
                    }
                } else {
                    MethodBinding methodBinding3 = list.get(0);
                    MethodBinding methodBinding4 = list.get(1);
                    int i12 = AnonymousClass1.$SwitchMap$net$bytebuddy$implementation$bind$MethodDelegationBinder$AmbiguityResolver$Resolution[ambiguityResolver.resolve(methodDescription, methodBinding3, methodBinding4).ordinal()];
                    if (i12 == 1) {
                        return methodBinding3;
                    }
                    if (i12 == 2) {
                        return methodBinding4;
                    }
                    if (i12 == 3 || i12 == 4) {
                        throw new IllegalArgumentException("Cannot resolve ambiguous delegation of " + methodDescription + " to " + methodBinding3.getTarget() + " or " + methodBinding4.getTarget());
                    }
                    throw new AssertionError();
                }
            }

            public MethodBinding resolve(AmbiguityResolver ambiguityResolver, MethodDescription methodDescription, List<MethodBinding> list) {
                return doResolve(ambiguityResolver, methodDescription, new ArrayList(list));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class StreamWriting implements BindingResolver {
            private final BindingResolver delegate;
            private final PrintStream printStream;

            public StreamWriting(BindingResolver bindingResolver, PrintStream printStream2) {
                this.delegate = bindingResolver;
                this.printStream = printStream2;
            }

            public static BindingResolver toSystemError() {
                return toSystemError(Default.INSTANCE);
            }

            public static BindingResolver toSystemOut() {
                return toSystemOut(Default.INSTANCE);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                StreamWriting streamWriting = (StreamWriting) obj;
                return this.delegate.equals(streamWriting.delegate) && this.printStream.equals(streamWriting.printStream);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.delegate.hashCode()) * 31) + this.printStream.hashCode();
            }

            public MethodBinding resolve(AmbiguityResolver ambiguityResolver, MethodDescription methodDescription, List<MethodBinding> list) {
                MethodBinding resolve = this.delegate.resolve(ambiguityResolver, methodDescription, list);
                PrintStream printStream2 = this.printStream;
                printStream2.println("Binding " + methodDescription + " as delegation to " + resolve.getTarget());
                return resolve;
            }

            public static BindingResolver toSystemError(BindingResolver bindingResolver) {
                return new StreamWriting(bindingResolver, System.err);
            }

            public static BindingResolver toSystemOut(BindingResolver bindingResolver) {
                return new StreamWriting(bindingResolver, System.out);
            }
        }

        public enum Unique implements BindingResolver {
            INSTANCE;
            
            private static final int ONLY = 0;

            public MethodBinding resolve(AmbiguityResolver ambiguityResolver, MethodDescription methodDescription, List<MethodBinding> list) {
                if (list.size() == 1) {
                    return list.get(0);
                }
                throw new IllegalStateException(methodDescription + " allowed for more than one binding: " + list);
            }
        }

        MethodBinding resolve(AmbiguityResolver ambiguityResolver, MethodDescription methodDescription, List<MethodBinding> list);
    }

    public interface MethodBinding extends StackManipulation {

        public static class Builder {
            private final MethodDescription candidate;
            private final MethodInvoker methodInvoker;
            private int nextParameterIndex = 0;
            private final List<StackManipulation> parameterStackManipulations;
            private final LinkedHashMap<Object, Integer> registeredTargetIndices = new LinkedHashMap<>();

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Build implements MethodBinding {
                private final StackManipulation methodInvocation;
                private final List<StackManipulation> parameterStackManipulations;
                private final Map<?, Integer> registeredTargetIndices;
                private final MethodDescription target;
                private final StackManipulation terminatingStackManipulation;

                protected Build(MethodDescription methodDescription, Map<?, Integer> map, StackManipulation stackManipulation, List<StackManipulation> list, StackManipulation stackManipulation2) {
                    this.target = methodDescription;
                    this.registeredTargetIndices = new HashMap(map);
                    this.methodInvocation = stackManipulation;
                    this.parameterStackManipulations = new ArrayList(list);
                    this.terminatingStackManipulation = stackManipulation2;
                }

                public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                    return new StackManipulation.Compound((List<? extends StackManipulation>) CompoundList.of(this.parameterStackManipulations, (List<StackManipulation>) Arrays.asList(new StackManipulation[]{this.methodInvocation, this.terminatingStackManipulation}))).apply(methodVisitor, context);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Build build = (Build) obj;
                    return this.target.equals(build.target) && this.registeredTargetIndices.equals(build.registeredTargetIndices) && this.methodInvocation.equals(build.methodInvocation) && this.parameterStackManipulations.equals(build.parameterStackManipulations) && this.terminatingStackManipulation.equals(build.terminatingStackManipulation);
                }

                public MethodDescription getTarget() {
                    return this.target;
                }

                @MaybeNull
                public Integer getTargetParameterIndex(Object obj) {
                    return this.registeredTargetIndices.get(obj);
                }

                public int hashCode() {
                    return (((((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.registeredTargetIndices.hashCode()) * 31) + this.methodInvocation.hashCode()) * 31) + this.parameterStackManipulations.hashCode()) * 31) + this.terminatingStackManipulation.hashCode();
                }

                public boolean isValid() {
                    boolean z10;
                    if (!this.methodInvocation.isValid() || !this.terminatingStackManipulation.isValid()) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    Iterator<StackManipulation> it = this.parameterStackManipulations.iterator();
                    while (z10 && it.hasNext()) {
                        z10 = it.next().isValid();
                    }
                    return z10;
                }
            }

            public Builder(MethodInvoker methodInvoker2, MethodDescription methodDescription) {
                this.methodInvoker = methodInvoker2;
                this.candidate = methodDescription;
                this.parameterStackManipulations = new ArrayList(methodDescription.getParameters().size());
            }

            public boolean append(ParameterBinding<?> parameterBinding) {
                this.parameterStackManipulations.add(parameterBinding);
                LinkedHashMap<Object, Integer> linkedHashMap = this.registeredTargetIndices;
                Object identificationToken = parameterBinding.getIdentificationToken();
                int i10 = this.nextParameterIndex;
                this.nextParameterIndex = i10 + 1;
                if (linkedHashMap.put(identificationToken, Integer.valueOf(i10)) == null) {
                    return true;
                }
                return false;
            }

            public MethodBinding build(StackManipulation stackManipulation) {
                if (this.candidate.getParameters().size() == this.nextParameterIndex) {
                    MethodDescription methodDescription = this.candidate;
                    return new Build(methodDescription, this.registeredTargetIndices, this.methodInvoker.invoke(methodDescription), this.parameterStackManipulations, stackManipulation);
                }
                throw new IllegalStateException("The number of parameters bound does not equal the target's number of parameters");
            }
        }

        public enum Illegal implements MethodBinding {
            INSTANCE;

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                throw new IllegalStateException("Cannot delegate to an unbound method");
            }

            public MethodDescription getTarget() {
                throw new IllegalStateException("Method is not bound");
            }

            public Integer getTargetParameterIndex(Object obj) {
                throw new IllegalStateException("Method is not bound");
            }

            public boolean isValid() {
                return false;
            }
        }

        MethodDescription getTarget();

        @MaybeNull
        Integer getTargetParameterIndex(Object obj);
    }

    public interface MethodInvoker {

        public enum Simple implements MethodInvoker {
            INSTANCE;

            public StackManipulation invoke(MethodDescription methodDescription) {
                return MethodInvocation.invoke(methodDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Virtual implements MethodInvoker {
            private final TypeDescription typeDescription;

            public Virtual(TypeDescription typeDescription2) {
                this.typeDescription = typeDescription2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((Virtual) obj).typeDescription);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
            }

            public StackManipulation invoke(MethodDescription methodDescription) {
                return MethodInvocation.invoke(methodDescription).virtual(this.typeDescription);
            }
        }

        StackManipulation invoke(MethodDescription methodDescription);
    }

    public interface ParameterBinding<T> extends StackManipulation {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Anonymous implements ParameterBinding<Object> {
            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
            private final Object anonymousToken = new Object();
            private final StackManipulation delegate;

            public Anonymous(StackManipulation stackManipulation) {
                this.delegate = stackManipulation;
            }

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                return this.delegate.apply(methodVisitor, context);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((Anonymous) obj).delegate);
            }

            public Object getIdentificationToken() {
                return this.anonymousToken;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.delegate.hashCode();
            }

            public boolean isValid() {
                return this.delegate.isValid();
            }
        }

        public enum Illegal implements ParameterBinding<Void> {
            INSTANCE;

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                throw new IllegalStateException("An illegal parameter binding must not be applied");
            }

            public boolean isValid() {
                return false;
            }

            public Void getIdentificationToken() {
                throw new IllegalStateException("An illegal binding does not define an identification token");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Unique<T> implements ParameterBinding<T> {
            private final StackManipulation delegate;
            private final T identificationToken;

            public Unique(StackManipulation stackManipulation, T t10) {
                this.delegate = stackManipulation;
                this.identificationToken = t10;
            }

            public static <S> Unique<S> of(StackManipulation stackManipulation, S s10) {
                return new Unique<>(stackManipulation, s10);
            }

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                return this.delegate.apply(methodVisitor, context);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Unique unique = (Unique) obj;
                return this.identificationToken.equals(unique.identificationToken) && this.delegate.equals(unique.delegate);
            }

            public T getIdentificationToken() {
                return this.identificationToken;
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.identificationToken.hashCode()) * 31) + this.delegate.hashCode();
            }

            public boolean isValid() {
                return this.delegate.isValid();
            }
        }

        T getIdentificationToken();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Processor implements Record {
        private final AmbiguityResolver ambiguityResolver;
        private final BindingResolver bindingResolver;
        private final List<? extends Record> records;

        public Processor(List<? extends Record> list, AmbiguityResolver ambiguityResolver2, BindingResolver bindingResolver2) {
            this.records = list;
            this.ambiguityResolver = ambiguityResolver2;
            this.bindingResolver = bindingResolver2;
        }

        public MethodBinding bind(Implementation.Target target, MethodDescription methodDescription, TerminationHandler terminationHandler, MethodInvoker methodInvoker, Assigner assigner) {
            ArrayList arrayList = new ArrayList();
            for (Record bind : this.records) {
                MethodBinding bind2 = bind.bind(target, methodDescription, terminationHandler, methodInvoker, assigner);
                if (bind2.isValid()) {
                    arrayList.add(bind2);
                }
            }
            if (!arrayList.isEmpty()) {
                return this.bindingResolver.resolve(this.ambiguityResolver, methodDescription, arrayList);
            }
            throw new IllegalArgumentException("None of " + this.records + " allows for delegation from " + methodDescription);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Processor processor = (Processor) obj;
            return this.records.equals(processor.records) && this.ambiguityResolver.equals(processor.ambiguityResolver) && this.bindingResolver.equals(processor.bindingResolver);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.records.hashCode()) * 31) + this.ambiguityResolver.hashCode()) * 31) + this.bindingResolver.hashCode();
        }
    }

    public interface Record {

        public enum Illegal implements Record {
            INSTANCE;

            public MethodBinding bind(Implementation.Target target, MethodDescription methodDescription, TerminationHandler terminationHandler, MethodInvoker methodInvoker, Assigner assigner) {
                return MethodBinding.Illegal.INSTANCE;
            }
        }

        MethodBinding bind(Implementation.Target target, MethodDescription methodDescription, TerminationHandler terminationHandler, MethodInvoker methodInvoker, Assigner assigner);
    }

    public interface TerminationHandler {

        public enum Default implements TerminationHandler {
            RETURNING {
                public StackManipulation resolve(Assigner assigner, Assigner.Typing typing, MethodDescription methodDescription, MethodDescription methodDescription2) {
                    TypeDescription.Generic generic;
                    StackManipulation[] stackManipulationArr = new StackManipulation[2];
                    if (methodDescription2.isConstructor()) {
                        generic = methodDescription2.getDeclaringType().asGenericType();
                    } else {
                        generic = methodDescription2.getReturnType();
                    }
                    stackManipulationArr[0] = assigner.assign(generic, methodDescription.getReturnType(), typing);
                    stackManipulationArr[1] = MethodReturn.of(methodDescription.getReturnType());
                    return new StackManipulation.Compound(stackManipulationArr);
                }
            },
            DROPPING {
                public StackManipulation resolve(Assigner assigner, Assigner.Typing typing, MethodDescription methodDescription, MethodDescription methodDescription2) {
                    TypeDefinition typeDefinition;
                    if (methodDescription2.isConstructor()) {
                        typeDefinition = methodDescription2.getDeclaringType();
                    } else {
                        typeDefinition = methodDescription2.getReturnType();
                    }
                    return Removal.of(typeDefinition);
                }
            }
        }

        StackManipulation resolve(Assigner assigner, Assigner.Typing typing, MethodDescription methodDescription, MethodDescription methodDescription2);
    }

    Record compile(MethodDescription methodDescription);
}
