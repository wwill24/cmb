package net.bytebuddy.agent.builder;

import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.api.a;
import com.google.firebase.sessions.settings.RemoteSettings;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.agent.builder.ResettableClassFileTransformer;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.EntryPoint;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.MethodManifestation;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.TypeManifestation;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.NexusAccessor;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.ExceptionMethod;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface AgentBuilder {

    public interface CircularityLock {

        public static class Default implements CircularityLock {
            private final ConcurrentMap<Thread, Boolean> threads = new ConcurrentHashMap();

            public boolean acquire() {
                return this.threads.putIfAbsent(Thread.currentThread(), Boolean.TRUE) == null;
            }

            /* access modifiers changed from: protected */
            public boolean isLocked() {
                return this.threads.containsKey(Thread.currentThread());
            }

            public void release() {
                this.threads.remove(Thread.currentThread());
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Global implements CircularityLock {
            private final Lock lock;
            private final long time;
            private final TimeUnit timeUnit;

            public Global() {
                this(0, TimeUnit.MILLISECONDS);
            }

            public boolean acquire() {
                try {
                    long j10 = this.time;
                    if (j10 == 0) {
                        return this.lock.tryLock();
                    }
                    return this.lock.tryLock(j10, this.timeUnit);
                } catch (InterruptedException unused) {
                    return false;
                }
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Global global = (Global) obj;
                return this.time == global.time && this.timeUnit.equals(global.timeUnit) && this.lock.equals(global.lock);
            }

            public int hashCode() {
                long j10 = this.time;
                return (((((getClass().hashCode() * 31) + this.lock.hashCode()) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.timeUnit.hashCode();
            }

            public void release() {
                this.lock.unlock();
            }

            public Global(long j10, TimeUnit timeUnit2) {
                this.lock = new ReentrantLock();
                this.time = j10;
                this.timeUnit = timeUnit2;
            }
        }

        public enum Inactive implements CircularityLock {
            INSTANCE;

            public boolean acquire() {
                return true;
            }

            public void release() {
            }
        }

        boolean acquire();

        void release();
    }

    public interface ClassFileBufferStrategy {

        public enum Default implements ClassFileBufferStrategy {
            RETAINING {
                public ClassFileLocator resolve(String str, byte[] bArr, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, ProtectionDomain protectionDomain) {
                    return ClassFileLocator.Simple.of(str, bArr);
                }

                public TypePool typePool(PoolStrategy poolStrategy, ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader, String str) {
                    return poolStrategy.typePool(classFileLocator, classLoader, str);
                }
            },
            DISCARDING {
                public ClassFileLocator resolve(String str, byte[] bArr, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, ProtectionDomain protectionDomain) {
                    return ClassFileLocator.NoOp.INSTANCE;
                }

                public TypePool typePool(PoolStrategy poolStrategy, ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader, String str) {
                    return poolStrategy.typePool(classFileLocator, classLoader);
                }
            }
        }

        ClassFileLocator resolve(String str, byte[] bArr, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, ProtectionDomain protectionDomain);

        TypePool typePool(PoolStrategy poolStrategy, ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader, String str);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements AgentBuilder {
        private static final boolean ACCESS_CONTROLLER;
        private static final CircularityLock DEFAULT_LOCK = new CircularityLock.Default();
        /* access modifiers changed from: private */
        public static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        private static final String INSTALLER_GETTER = "getInstrumentation";
        private static final String INSTALLER_TYPE = "net.bytebuddy.agent.Installer";
        /* access modifiers changed from: private */
        @AlwaysNull
        public static final Class<?> NOT_PREVIOUSLY_DEFINED = null;
        /* access modifiers changed from: private */
        @AlwaysNull
        public static final byte[] NO_TRANSFORMATION = null;
        protected final ByteBuddy byteBuddy;
        protected final CircularityLock circularityLock;
        protected final ClassFileBufferStrategy classFileBufferStrategy;
        protected final ClassFileLocator classFileLocator;
        protected final DescriptionStrategy descriptionStrategy;
        protected final FallbackStrategy fallbackStrategy;
        protected final RawMatcher ignoreMatcher;
        protected final InitializationStrategy initializationStrategy;
        protected final InjectionStrategy injectionStrategy;
        protected final InstallationListener installationListener;
        protected final LambdaInstrumentationStrategy lambdaInstrumentationStrategy;
        protected final Listener listener;
        protected final LocationStrategy locationStrategy;
        protected final NativeMethodStrategy nativeMethodStrategy;
        protected final PoolStrategy poolStrategy;
        protected final RedefinitionStrategy.BatchAllocator redefinitionBatchAllocator;
        protected final RedefinitionStrategy.DiscoveryStrategy redefinitionDiscoveryStrategy;
        protected final RedefinitionStrategy.Listener redefinitionListener;
        protected final RedefinitionStrategy.ResubmissionStrategy redefinitionResubmissionStrategy;
        protected final RedefinitionStrategy redefinitionStrategy;
        protected final List<Transformation> transformations;
        protected final TransformerDecorator transformerDecorator;
        protected final TypeStrategy typeStrategy;
        protected final WarmupStrategy warmupStrategy;

        protected static abstract class Delegator implements AgentBuilder {

            protected static abstract class Matchable<S extends Matchable<S>> extends Delegator implements Matchable<S> {
                protected Matchable() {
                }

                public S and(ElementMatcher<? super TypeDescription> elementMatcher) {
                    return and(elementMatcher, ElementMatchers.any());
                }

                public S or(ElementMatcher<? super TypeDescription> elementMatcher) {
                    return or(elementMatcher, ElementMatchers.any());
                }

                public S and(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                    return and(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                public S or(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                    return or(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                public S and(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                    return and((RawMatcher) new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2, elementMatcher3));
                }

                public S or(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                    return or((RawMatcher) new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2, elementMatcher3));
                }
            }

            protected Delegator() {
            }

            public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Class<?>... clsArr) {
                return materialize().assureReadEdgeFromAndTo(instrumentation, clsArr);
            }

            public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Class<?>... clsArr) {
                return materialize().assureReadEdgeTo(instrumentation, clsArr);
            }

            public AgentBuilder disableClassFormatChanges() {
                return materialize().disableClassFormatChanges();
            }

            public AgentBuilder disableNativeMethodPrefix() {
                return materialize().disableNativeMethodPrefix();
            }

            public AgentBuilder enableNativeMethodPrefix(String str) {
                return materialize().enableNativeMethodPrefix(str);
            }

            public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher) {
                return materialize().ignore(elementMatcher);
            }

            public ResettableClassFileTransformer installOn(Instrumentation instrumentation) {
                return materialize().installOn(instrumentation);
            }

            public ResettableClassFileTransformer installOnByteBuddyAgent() {
                return materialize().installOnByteBuddyAgent();
            }

            public ClassFileTransformer makeRaw() {
                return materialize().makeRaw();
            }

            /* access modifiers changed from: protected */
            public abstract AgentBuilder materialize();

            public ResettableClassFileTransformer patchOn(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                return materialize().patchOn(instrumentation, resettableClassFileTransformer);
            }

            public ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer) {
                return materialize().patchOnByteBuddyAgent(resettableClassFileTransformer);
            }

            public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher) {
                return materialize().type(elementMatcher);
            }

            public AgentBuilder warmUp(Class<?>... clsArr) {
                return materialize().warmUp(clsArr);
            }

            public AgentBuilder with(ByteBuddy byteBuddy) {
                return materialize().with(byteBuddy);
            }

            public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
                return materialize().assureReadEdgeFromAndTo(instrumentation, javaModuleArr);
            }

            public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
                return materialize().assureReadEdgeTo(instrumentation, javaModuleArr);
            }

            public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                return materialize().ignore(elementMatcher, elementMatcher2);
            }

            public ResettableClassFileTransformer patchOn(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode) {
                return materialize().patchOn(instrumentation, resettableClassFileTransformer, patchMode);
            }

            public ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode) {
                return materialize().patchOnByteBuddyAgent(resettableClassFileTransformer, patchMode);
            }

            public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                return materialize().type(elementMatcher, elementMatcher2);
            }

            public AgentBuilder warmUp(Collection<Class<?>> collection) {
                return materialize().warmUp(collection);
            }

            public AgentBuilder with(Listener listener) {
                return materialize().with(listener);
            }

            public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection) {
                return materialize().assureReadEdgeFromAndTo(instrumentation, collection);
            }

            public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection) {
                return materialize().assureReadEdgeTo(instrumentation, collection);
            }

            public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                return materialize().ignore(elementMatcher, elementMatcher2, elementMatcher3);
            }

            public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                return materialize().type(elementMatcher, elementMatcher2, elementMatcher3);
            }

            public AgentBuilder with(CircularityLock circularityLock) {
                return materialize().with(circularityLock);
            }

            public Ignored ignore(RawMatcher rawMatcher) {
                return materialize().ignore(rawMatcher);
            }

            public Identified.Narrowable type(RawMatcher rawMatcher) {
                return materialize().type(rawMatcher);
            }

            public AgentBuilder with(TypeStrategy typeStrategy) {
                return materialize().with(typeStrategy);
            }

            public AgentBuilder with(PoolStrategy poolStrategy) {
                return materialize().with(poolStrategy);
            }

            public AgentBuilder with(LocationStrategy locationStrategy) {
                return materialize().with(locationStrategy);
            }

            public AgentBuilder with(ClassFileLocator classFileLocator) {
                return materialize().with(classFileLocator);
            }

            public AgentBuilder with(InitializationStrategy initializationStrategy) {
                return materialize().with(initializationStrategy);
            }

            public RedefinitionListenable.WithoutBatchStrategy with(RedefinitionStrategy redefinitionStrategy) {
                return materialize().with(redefinitionStrategy);
            }

            public AgentBuilder with(LambdaInstrumentationStrategy lambdaInstrumentationStrategy) {
                return materialize().with(lambdaInstrumentationStrategy);
            }

            public AgentBuilder with(DescriptionStrategy descriptionStrategy) {
                return materialize().with(descriptionStrategy);
            }

            public AgentBuilder with(FallbackStrategy fallbackStrategy) {
                return materialize().with(fallbackStrategy);
            }

            public AgentBuilder with(ClassFileBufferStrategy classFileBufferStrategy) {
                return materialize().with(classFileBufferStrategy);
            }

            public AgentBuilder with(InstallationListener installationListener) {
                return materialize().with(installationListener);
            }

            public AgentBuilder with(InjectionStrategy injectionStrategy) {
                return materialize().with(injectionStrategy);
            }

            public AgentBuilder with(TransformerDecorator transformerDecorator) {
                return materialize().with(transformerDecorator);
            }
        }

        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        protected interface Dispatcher {
            @JavaDispatcher.Proxied("addTransformer")
            void addTransformer(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, boolean z10);

            @JavaDispatcher.Proxied("isNativeMethodPrefixSupported")
            @JavaDispatcher.Defaults
            boolean isNativeMethodPrefixSupported(Instrumentation instrumentation);

            @JavaDispatcher.Proxied("setNativeMethodPrefix")
            void setNativeMethodPrefix(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, String str);
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        protected class Ignoring extends Delegator.Matchable<Ignored> implements Ignored {
            private final RawMatcher rawMatcher;

            protected Ignoring(RawMatcher rawMatcher2) {
                this.rawMatcher = rawMatcher2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Ignoring ignoring = (Ignoring) obj;
                return this.rawMatcher.equals(ignoring.rawMatcher) && Default.this.equals(Default.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.rawMatcher.hashCode()) * 31) + Default.this.hashCode();
            }

            /* access modifiers changed from: protected */
            public AgentBuilder materialize() {
                Default defaultR = Default.this;
                ByteBuddy byteBuddy = defaultR.byteBuddy;
                Default defaultR2 = defaultR;
                return new Default(byteBuddy, defaultR.listener, defaultR.circularityLock, defaultR.poolStrategy, defaultR.typeStrategy, defaultR.locationStrategy, defaultR.classFileLocator, defaultR.nativeMethodStrategy, defaultR.warmupStrategy, defaultR.transformerDecorator, defaultR.initializationStrategy, defaultR.redefinitionStrategy, defaultR.redefinitionDiscoveryStrategy, defaultR.redefinitionBatchAllocator, defaultR2.redefinitionListener, defaultR2.redefinitionResubmissionStrategy, defaultR2.injectionStrategy, defaultR2.lambdaInstrumentationStrategy, defaultR2.descriptionStrategy, defaultR2.fallbackStrategy, defaultR2.classFileBufferStrategy, defaultR2.installationListener, this.rawMatcher, defaultR2.transformations);
            }

            public Ignored and(RawMatcher rawMatcher2) {
                return new Ignoring(new RawMatcher.Conjunction(this.rawMatcher, rawMatcher2));
            }

            public Ignored or(RawMatcher rawMatcher2) {
                return new Ignoring(new RawMatcher.Disjunction(this.rawMatcher, rawMatcher2));
            }
        }

        protected interface NativeMethodStrategy {

            public enum Disabled implements NativeMethodStrategy {
                INSTANCE;

                public void apply(Instrumentation instrumentation, ClassFileTransformer classFileTransformer) {
                }

                public MethodNameTransformer resolve() {
                    return MethodNameTransformer.Suffixing.withRandomSuffix();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForPrefix implements NativeMethodStrategy {
                private final String prefix;

                protected ForPrefix(String str) {
                    this.prefix = str;
                }

                protected static NativeMethodStrategy of(String str) {
                    if (str.length() != 0) {
                        return new ForPrefix(str);
                    }
                    throw new IllegalArgumentException("A method name prefix must not be the empty string");
                }

                public void apply(Instrumentation instrumentation, ClassFileTransformer classFileTransformer) {
                    if (Default.DISPATCHER.isNativeMethodPrefixSupported(instrumentation)) {
                        Default.DISPATCHER.setNativeMethodPrefix(instrumentation, classFileTransformer, this.prefix);
                        return;
                    }
                    throw new IllegalArgumentException("A prefix for native methods is not supported: " + instrumentation);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.prefix.equals(((ForPrefix) obj).prefix);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.prefix.hashCode();
                }

                public MethodNameTransformer resolve() {
                    return new MethodNameTransformer.Prefixing(this.prefix);
                }
            }

            void apply(Instrumentation instrumentation, ClassFileTransformer classFileTransformer);

            MethodNameTransformer resolve();
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Transformation {
            /* access modifiers changed from: private */
            @AlwaysNull
            public static final byte[] NONE = null;
            private final RawMatcher matcher;
            private final boolean terminal;
            private final List<Transformer> transformers;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class DifferentialMatcher implements RawMatcher {
                private final ResettableClassFileTransformer classFileTransformer;
                private final RawMatcher ignoreMatcher;
                private final List<Transformation> transformations;

                protected DifferentialMatcher(RawMatcher rawMatcher, List<Transformation> list, ResettableClassFileTransformer resettableClassFileTransformer) {
                    this.ignoreMatcher = rawMatcher;
                    this.transformations = list;
                    this.classFileTransformer = resettableClassFileTransformer;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    DifferentialMatcher differentialMatcher = (DifferentialMatcher) obj;
                    return this.ignoreMatcher.equals(differentialMatcher.ignoreMatcher) && this.transformations.equals(differentialMatcher.transformations) && this.classFileTransformer.equals(differentialMatcher.classFileTransformer);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.ignoreMatcher.hashCode()) * 31) + this.transformations.hashCode()) * 31) + this.classFileTransformer.hashCode();
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean matches(net.bytebuddy.description.type.TypeDescription r10, @net.bytebuddy.utility.nullability.MaybeNull java.lang.ClassLoader r11, @net.bytebuddy.utility.nullability.MaybeNull net.bytebuddy.utility.JavaModule r12, @net.bytebuddy.utility.nullability.MaybeNull java.lang.Class<?> r13, java.security.ProtectionDomain r14) {
                    /*
                        r9 = this;
                        net.bytebuddy.agent.builder.ResettableClassFileTransformer r0 = r9.classFileTransformer
                        r1 = r10
                        r2 = r11
                        r3 = r12
                        r4 = r13
                        r5 = r14
                        java.util.Iterator r0 = r0.iterator(r1, r2, r3, r4, r5)
                        net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r1 = r9.ignoreMatcher
                        r2 = r10
                        r3 = r11
                        r4 = r12
                        r5 = r13
                        r6 = r14
                        boolean r1 = r1.matches(r2, r3, r4, r5, r6)
                        if (r1 == 0) goto L_0x001d
                        boolean r10 = r0.hasNext()
                        return r10
                    L_0x001d:
                        java.util.List<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r1 = r9.transformations
                        java.util.Iterator r1 = r1.iterator()
                    L_0x0023:
                        boolean r2 = r1.hasNext()
                        if (r2 == 0) goto L_0x0066
                        java.lang.Object r2 = r1.next()
                        net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation r2 = (net.bytebuddy.agent.builder.AgentBuilder.Default.Transformation) r2
                        net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r3 = r2.getMatcher()
                        r4 = r10
                        r5 = r11
                        r6 = r12
                        r7 = r13
                        r8 = r14
                        boolean r3 = r3.matches(r4, r5, r6, r7, r8)
                        if (r3 == 0) goto L_0x0023
                        java.util.List r2 = r2.getTransformers()
                        java.util.Iterator r2 = r2.iterator()
                    L_0x0046:
                        boolean r3 = r2.hasNext()
                        if (r3 == 0) goto L_0x0023
                        java.lang.Object r3 = r2.next()
                        net.bytebuddy.agent.builder.AgentBuilder$Transformer r3 = (net.bytebuddy.agent.builder.AgentBuilder.Transformer) r3
                        boolean r4 = r0.hasNext()
                        if (r4 == 0) goto L_0x0064
                        java.lang.Object r4 = r0.next()
                        net.bytebuddy.agent.builder.AgentBuilder$Transformer r4 = (net.bytebuddy.agent.builder.AgentBuilder.Transformer) r4
                        boolean r3 = r4.equals(r3)
                        if (r3 != 0) goto L_0x0046
                    L_0x0064:
                        r10 = 1
                        return r10
                    L_0x0066:
                        boolean r10 = r0.hasNext()
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.Transformation.DifferentialMatcher.matches(net.bytebuddy.description.type.TypeDescription, java.lang.ClassLoader, net.bytebuddy.utility.JavaModule, java.lang.Class, java.security.ProtectionDomain):boolean");
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class SimpleMatcher implements RawMatcher {
                private final RawMatcher ignoreMatcher;
                private final List<Transformation> transformations;

                protected SimpleMatcher(RawMatcher rawMatcher, List<Transformation> list) {
                    this.ignoreMatcher = rawMatcher;
                    this.transformations = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    SimpleMatcher simpleMatcher = (SimpleMatcher) obj;
                    return this.ignoreMatcher.equals(simpleMatcher.ignoreMatcher) && this.transformations.equals(simpleMatcher.transformations);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.ignoreMatcher.hashCode()) * 31) + this.transformations.hashCode();
                }

                public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain) {
                    if (this.ignoreMatcher.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                        return false;
                    }
                    for (Transformation matcher : this.transformations) {
                        if (matcher.getMatcher().matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                            return true;
                        }
                    }
                    return false;
                }
            }

            protected static class TransformerIterator implements Iterator<Transformer> {
                @MaybeNull
                private final Class<?> classBeingRedefined;
                @MaybeNull
                private final ClassLoader classLoader;
                @MaybeNull
                private final JavaModule module;
                private final ProtectionDomain protectionDomain;
                private final Iterator<Transformation> transformations;
                private Iterator<Transformer> transformers = Collections.emptySet().iterator();
                private final TypeDescription typeDescription;

                protected TransformerIterator(TypeDescription typeDescription2, @MaybeNull ClassLoader classLoader2, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain2, List<Transformation> list) {
                    this.typeDescription = typeDescription2;
                    this.classLoader = classLoader2;
                    this.module = javaModule;
                    this.classBeingRedefined = cls;
                    this.protectionDomain = protectionDomain2;
                    this.transformations = list.iterator();
                    while (!this.transformers.hasNext() && this.transformations.hasNext()) {
                        Transformation next = this.transformations.next();
                        if (next.getMatcher().matches(typeDescription2, classLoader2, javaModule, cls, protectionDomain2)) {
                            this.transformers = next.getTransformers().iterator();
                        }
                    }
                }

                public boolean hasNext() {
                    return this.transformers.hasNext();
                }

                public void remove() {
                    throw new UnsupportedOperationException("remove");
                }

                /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: 
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                    	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                    */
                public net.bytebuddy.agent.builder.AgentBuilder.Transformer next() {
                    /*
                        r8 = this;
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Transformer> r0 = r8.transformers     // Catch:{ all -> 0x0040 }
                        java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0040 }
                        net.bytebuddy.agent.builder.AgentBuilder$Transformer r0 = (net.bytebuddy.agent.builder.AgentBuilder.Transformer) r0     // Catch:{ all -> 0x0040 }
                    L_0x0008:
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Transformer> r1 = r8.transformers
                        boolean r1 = r1.hasNext()
                        if (r1 != 0) goto L_0x003f
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r1 = r8.transformations
                        boolean r1 = r1.hasNext()
                        if (r1 == 0) goto L_0x003f
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r1 = r8.transformations
                        java.lang.Object r1 = r1.next()
                        net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation r1 = (net.bytebuddy.agent.builder.AgentBuilder.Default.Transformation) r1
                        net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r2 = r1.getMatcher()
                        net.bytebuddy.description.type.TypeDescription r3 = r8.typeDescription
                        java.lang.ClassLoader r4 = r8.classLoader
                        net.bytebuddy.utility.JavaModule r5 = r8.module
                        java.lang.Class<?> r6 = r8.classBeingRedefined
                        java.security.ProtectionDomain r7 = r8.protectionDomain
                        boolean r2 = r2.matches(r3, r4, r5, r6, r7)
                        if (r2 == 0) goto L_0x0008
                        java.util.List r1 = r1.getTransformers()
                        java.util.Iterator r1 = r1.iterator()
                        r8.transformers = r1
                        goto L_0x0008
                    L_0x003f:
                        return r0
                    L_0x0040:
                        r0 = move-exception
                    L_0x0041:
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Transformer> r1 = r8.transformers
                        boolean r1 = r1.hasNext()
                        if (r1 != 0) goto L_0x0078
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r1 = r8.transformations
                        boolean r1 = r1.hasNext()
                        if (r1 == 0) goto L_0x0078
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r1 = r8.transformations
                        java.lang.Object r1 = r1.next()
                        net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation r1 = (net.bytebuddy.agent.builder.AgentBuilder.Default.Transformation) r1
                        net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r2 = r1.getMatcher()
                        net.bytebuddy.description.type.TypeDescription r3 = r8.typeDescription
                        java.lang.ClassLoader r4 = r8.classLoader
                        net.bytebuddy.utility.JavaModule r5 = r8.module
                        java.lang.Class<?> r6 = r8.classBeingRedefined
                        java.security.ProtectionDomain r7 = r8.protectionDomain
                        boolean r2 = r2.matches(r3, r4, r5, r6, r7)
                        if (r2 == 0) goto L_0x0041
                        java.util.List r1 = r1.getTransformers()
                        java.util.Iterator r1 = r1.iterator()
                        r8.transformers = r1
                        goto L_0x0041
                    L_0x0078:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.Transformation.TransformerIterator.next():net.bytebuddy.agent.builder.AgentBuilder$Transformer");
                }
            }

            protected Transformation(RawMatcher rawMatcher, List<Transformer> list, boolean z10) {
                this.matcher = rawMatcher;
                this.transformers = list;
                this.terminal = z10;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Transformation transformation = (Transformation) obj;
                return this.terminal == transformation.terminal && this.matcher.equals(transformation.matcher) && this.transformers.equals(transformation.transformers);
            }

            /* access modifiers changed from: protected */
            public RawMatcher getMatcher() {
                return this.matcher;
            }

            /* access modifiers changed from: protected */
            public List<Transformer> getTransformers() {
                return this.transformers;
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.transformers.hashCode()) * 31) + (this.terminal ? 1 : 0);
            }

            /* access modifiers changed from: protected */
            public boolean isTerminal() {
                return this.terminal;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        protected class Transforming extends Delegator.Matchable<Identified.Narrowable> implements Identified.Extendable, Identified.Narrowable {
            private final RawMatcher rawMatcher;
            private final boolean terminal;
            private final List<Transformer> transformers;

            protected Transforming(RawMatcher rawMatcher2, List<Transformer> list, boolean z10) {
                this.rawMatcher = rawMatcher2;
                this.transformers = list;
                this.terminal = z10;
            }

            public AgentBuilder asTerminalTransformation() {
                return new Transforming(this.rawMatcher, this.transformers, true);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Transforming transforming = (Transforming) obj;
                return this.terminal == transforming.terminal && this.rawMatcher.equals(transforming.rawMatcher) && this.transformers.equals(transforming.transformers) && Default.this.equals(Default.this);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.rawMatcher.hashCode()) * 31) + this.transformers.hashCode()) * 31) + (this.terminal ? 1 : 0)) * 31) + Default.this.hashCode();
            }

            /* access modifiers changed from: protected */
            public AgentBuilder materialize() {
                Default defaultR = Default.this;
                ByteBuddy byteBuddy = defaultR.byteBuddy;
                Listener listener = defaultR.listener;
                CircularityLock circularityLock = defaultR.circularityLock;
                PoolStrategy poolStrategy = defaultR.poolStrategy;
                ByteBuddy byteBuddy2 = byteBuddy;
                Default defaultR2 = defaultR;
                return new Default(byteBuddy2, listener, circularityLock, poolStrategy, defaultR.typeStrategy, defaultR.locationStrategy, defaultR.classFileLocator, defaultR.nativeMethodStrategy, defaultR.warmupStrategy, defaultR.transformerDecorator, defaultR.initializationStrategy, defaultR.redefinitionStrategy, defaultR.redefinitionDiscoveryStrategy, defaultR.redefinitionBatchAllocator, defaultR2.redefinitionListener, defaultR2.redefinitionResubmissionStrategy, defaultR2.injectionStrategy, defaultR2.lambdaInstrumentationStrategy, defaultR2.descriptionStrategy, defaultR2.fallbackStrategy, defaultR2.classFileBufferStrategy, defaultR2.installationListener, defaultR2.ignoreMatcher, CompoundList.of(defaultR2.transformations, new Transformation(this.rawMatcher, this.transformers, this.terminal)));
            }

            public Identified.Extendable transform(Transformer transformer) {
                return new Transforming(this.rawMatcher, CompoundList.of(this.transformers, transformer), this.terminal);
            }

            public Identified.Narrowable and(RawMatcher rawMatcher2) {
                return new Transforming(new RawMatcher.Conjunction(this.rawMatcher, rawMatcher2), this.transformers, this.terminal);
            }

            public Identified.Narrowable or(RawMatcher rawMatcher2) {
                return new Transforming(new RawMatcher.Disjunction(this.rawMatcher, rawMatcher2), this.transformers, this.terminal);
            }
        }

        protected interface WarmupStrategy {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements WarmupStrategy {
                private static final Dispatcher DISPATCHER = ((Dispatcher) Default.doPrivileged(JavaDispatcher.of(Dispatcher.class)));
                private final Set<Class<?>> types;

                @JavaDispatcher.Proxied("java.lang.instrument.ClassFileTransformer")
                protected interface Dispatcher {
                    @MaybeNull
                    @JavaDispatcher.Proxied("transform")
                    byte[] transform(ClassFileTransformer classFileTransformer, @JavaDispatcher.Proxied("java.lang.Module") @MaybeNull Object obj, @MaybeNull ClassLoader classLoader, String str, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) throws IllegalClassFormatException;
                }

                protected Enabled(Set<Class<?>> set) {
                    this.types = set;
                }

                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: net.bytebuddy.dynamic.ClassFileLocator$Resolution} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Class} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: net.bytebuddy.agent.builder.AgentBuilder$Default$WarmupStrategy$Enabled$Dispatcher} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: java.lang.Class} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: java.lang.Class} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: net.bytebuddy.agent.builder.AgentBuilder$Default$WarmupStrategy$Enabled$Dispatcher} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void apply(net.bytebuddy.agent.builder.ResettableClassFileTransformer r21, net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy r22, net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy r23, net.bytebuddy.agent.builder.AgentBuilder.CircularityLock r24, net.bytebuddy.agent.builder.AgentBuilder.InstallationListener r25) {
                    /*
                        r20 = this;
                        r1 = r20
                        r10 = r21
                        r11 = r25
                        java.util.Set<java.lang.Class<?>> r0 = r1.types
                        r11.onBeforeWarmUp(r0, r10)
                        java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
                        r12.<init>()
                        java.util.Set<java.lang.Class<?>> r0 = r1.types
                        java.util.Iterator r13 = r0.iterator()
                        r14 = 0
                        r15 = r14
                    L_0x0018:
                        boolean r0 = r13.hasNext()
                        if (r0 == 0) goto L_0x0107
                        java.lang.Object r0 = r13.next()
                        r9 = r0
                        java.lang.Class r9 = (java.lang.Class) r9
                        net.bytebuddy.utility.JavaModule r0 = net.bytebuddy.utility.JavaModule.ofType(r9)     // Catch:{ all -> 0x00f9 }
                        java.lang.ClassLoader r2 = r9.getClassLoader()     // Catch:{ all -> 0x00f9 }
                        r8 = r22
                        net.bytebuddy.dynamic.ClassFileLocator r2 = r8.classFileLocator(r2, r0)     // Catch:{ all -> 0x00f9 }
                        java.lang.String r3 = r9.getName()     // Catch:{ all -> 0x00f9 }
                        net.bytebuddy.dynamic.ClassFileLocator$Resolution r2 = r2.locate(r3)     // Catch:{ all -> 0x00f9 }
                        byte[] r16 = r2.resolve()     // Catch:{ all -> 0x00f9 }
                        r24.release()     // Catch:{ all -> 0x00f9 }
                        r17 = 1
                        if (r0 != 0) goto L_0x008a
                        java.lang.ClassLoader r3 = r9.getClassLoader()     // Catch:{ all -> 0x00f1 }
                        java.lang.String r4 = net.bytebuddy.jar.asm.Type.getInternalName(r9)     // Catch:{ all -> 0x00f1 }
                        java.lang.Class r5 = net.bytebuddy.agent.builder.AgentBuilder.Default.NOT_PREVIOUSLY_DEFINED     // Catch:{ all -> 0x00f1 }
                        java.security.ProtectionDomain r6 = r9.getProtectionDomain()     // Catch:{ all -> 0x00f1 }
                        r2 = r21
                        r7 = r16
                        byte[] r0 = r2.transform(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00f1 }
                        if (r0 == 0) goto L_0x0063
                        r2 = r17
                        goto L_0x0064
                    L_0x0063:
                        r2 = r14
                    L_0x0064:
                        r15 = r15 | r2
                        boolean r2 = r23.isEnabled()     // Catch:{ all -> 0x00f1 }
                        if (r2 == 0) goto L_0x0088
                        java.lang.ClassLoader r3 = r9.getClassLoader()     // Catch:{ all -> 0x00f1 }
                        java.lang.String r4 = net.bytebuddy.jar.asm.Type.getInternalName(r9)     // Catch:{ all -> 0x00f1 }
                        java.security.ProtectionDomain r6 = r9.getProtectionDomain()     // Catch:{ all -> 0x00f1 }
                        r2 = r21
                        r5 = r9
                        r7 = r16
                        byte[] r0 = r2.transform(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00f1 }
                        if (r0 == 0) goto L_0x0083
                        goto L_0x0085
                    L_0x0083:
                        r17 = r14
                    L_0x0085:
                        r2 = r15 | r17
                        r15 = r2
                    L_0x0088:
                        r2 = r9
                        goto L_0x00e3
                    L_0x008a:
                        net.bytebuddy.agent.builder.AgentBuilder$Default$WarmupStrategy$Enabled$Dispatcher r18 = DISPATCHER     // Catch:{ all -> 0x00f1 }
                        java.lang.Object r4 = r0.unwrap()     // Catch:{ all -> 0x00f1 }
                        java.lang.ClassLoader r5 = r9.getClassLoader()     // Catch:{ all -> 0x00f1 }
                        java.lang.String r6 = net.bytebuddy.jar.asm.Type.getInternalName(r9)     // Catch:{ all -> 0x00f1 }
                        java.lang.Class r7 = net.bytebuddy.agent.builder.AgentBuilder.Default.NOT_PREVIOUSLY_DEFINED     // Catch:{ all -> 0x00f1 }
                        java.security.ProtectionDomain r19 = r9.getProtectionDomain()     // Catch:{ all -> 0x00f1 }
                        r2 = r18
                        r3 = r21
                        r8 = r19
                        r19 = r9
                        r9 = r16
                        byte[] r2 = r2.transform(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00ed }
                        if (r2 == 0) goto L_0x00b3
                        r3 = r17
                        goto L_0x00b4
                    L_0x00b3:
                        r3 = r14
                    L_0x00b4:
                        r15 = r15 | r3
                        boolean r3 = r23.isEnabled()     // Catch:{ all -> 0x00ed }
                        if (r3 == 0) goto L_0x00e0
                        java.lang.Object r4 = r0.unwrap()     // Catch:{ all -> 0x00ed }
                        java.lang.ClassLoader r5 = r19.getClassLoader()     // Catch:{ all -> 0x00ed }
                        java.lang.String r6 = net.bytebuddy.jar.asm.Type.getInternalName(r19)     // Catch:{ all -> 0x00ed }
                        java.security.ProtectionDomain r8 = r19.getProtectionDomain()     // Catch:{ all -> 0x00ed }
                        r2 = r18
                        r3 = r21
                        r7 = r19
                        r9 = r16
                        byte[] r0 = r2.transform(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00ed }
                        if (r0 == 0) goto L_0x00da
                        goto L_0x00dc
                    L_0x00da:
                        r17 = r14
                    L_0x00dc:
                        r2 = r15 | r17
                        r15 = r2
                        goto L_0x00e1
                    L_0x00e0:
                        r0 = r2
                    L_0x00e1:
                        r2 = r19
                    L_0x00e3:
                        r12.put(r2, r0)     // Catch:{ all -> 0x00eb }
                        r24.acquire()     // Catch:{ all -> 0x00f7 }
                        goto L_0x0018
                    L_0x00eb:
                        r0 = move-exception
                        goto L_0x00f3
                    L_0x00ed:
                        r0 = move-exception
                        r2 = r19
                        goto L_0x00f3
                    L_0x00f1:
                        r0 = move-exception
                        r2 = r9
                    L_0x00f3:
                        r24.acquire()     // Catch:{ all -> 0x00f7 }
                        throw r0     // Catch:{ all -> 0x00f7 }
                    L_0x00f7:
                        r0 = move-exception
                        goto L_0x00fb
                    L_0x00f9:
                        r0 = move-exception
                        r2 = r9
                    L_0x00fb:
                        r11.onWarmUpError(r2, r10, r0)
                        byte[] r0 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION
                        r12.put(r2, r0)
                        goto L_0x0018
                    L_0x0107:
                        r11.onAfterWarmUp(r12, r10, r15)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.WarmupStrategy.Enabled.apply(net.bytebuddy.agent.builder.ResettableClassFileTransformer, net.bytebuddy.agent.builder.AgentBuilder$LocationStrategy, net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy, net.bytebuddy.agent.builder.AgentBuilder$CircularityLock, net.bytebuddy.agent.builder.AgentBuilder$InstallationListener):void");
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.types.equals(((Enabled) obj).types);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.types.hashCode();
                }

                public WarmupStrategy with(Collection<Class<?>> collection) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(this.types);
                    linkedHashSet.addAll(collection);
                    return new Enabled(linkedHashSet);
                }
            }

            public enum NoOp implements WarmupStrategy {
                INSTANCE;

                public void apply(ResettableClassFileTransformer resettableClassFileTransformer, LocationStrategy locationStrategy, RedefinitionStrategy redefinitionStrategy, CircularityLock circularityLock, InstallationListener installationListener) {
                }

                public WarmupStrategy with(Collection<Class<?>> collection) {
                    return new Enabled(new LinkedHashSet(collection));
                }
            }

            void apply(ResettableClassFileTransformer resettableClassFileTransformer, LocationStrategy locationStrategy, RedefinitionStrategy redefinitionStrategy, CircularityLock circularityLock, InstallationListener installationListener);

            WarmupStrategy with(Collection<Class<?>> collection);
        }

        static {
            boolean z10 = false;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            } catch (ClassNotFoundException unused) {
            } catch (SecurityException unused2) {
                z10 = true;
            }
            ACCESS_CONTROLLER = z10;
        }

        public Default() {
            this(new ByteBuddy());
        }

        private ResettableClassFileTransformer doInstall(Instrumentation instrumentation, RawMatcher rawMatcher, PatchMode.Handler handler) {
            ResettableClassFileTransformer resettableClassFileTransformer;
            Default defaultR = this;
            Instrumentation instrumentation2 = instrumentation;
            PatchMode.Handler handler2 = handler;
            if (defaultR.circularityLock.acquire()) {
                try {
                    RedefinitionStrategy.ResubmissionStrategy.Installation apply = defaultR.redefinitionResubmissionStrategy.apply(instrumentation, defaultR.poolStrategy, defaultR.locationStrategy, defaultR.descriptionStrategy, defaultR.fallbackStrategy, defaultR.listener, defaultR.installationListener, defaultR.circularityLock, new Transformation.SimpleMatcher(defaultR.ignoreMatcher, defaultR.transformations), defaultR.redefinitionStrategy, defaultR.redefinitionBatchAllocator, defaultR.redefinitionListener);
                    ResettableClassFileTransformer decorate = defaultR.transformerDecorator.decorate(defaultR.makeRaw(apply.getListener(), apply.getInstallationListener(), apply.getResubmissionEnforcer()));
                    apply.getInstallationListener().onBeforeInstall(instrumentation2, decorate);
                    try {
                        defaultR.warmupStrategy.apply(decorate, defaultR.locationStrategy, defaultR.redefinitionStrategy, defaultR.circularityLock, apply.getInstallationListener());
                        handler2.onBeforeRegistration(instrumentation2);
                        if (defaultR.redefinitionStrategy.isRetransforming()) {
                            DISPATCHER.addTransformer(instrumentation2, decorate, true);
                        } else {
                            instrumentation2.addTransformer(decorate);
                        }
                        handler2.onAfterRegistration(instrumentation2);
                        defaultR.nativeMethodStrategy.apply(instrumentation2, decorate);
                        defaultR.lambdaInstrumentationStrategy.apply(defaultR.byteBuddy, instrumentation2, decorate);
                        RedefinitionStrategy redefinitionStrategy2 = defaultR.redefinitionStrategy;
                        PoolStrategy poolStrategy2 = defaultR.poolStrategy;
                        LocationStrategy locationStrategy2 = defaultR.locationStrategy;
                        DescriptionStrategy descriptionStrategy2 = defaultR.descriptionStrategy;
                        FallbackStrategy fallbackStrategy2 = defaultR.fallbackStrategy;
                        RedefinitionStrategy.DiscoveryStrategy discoveryStrategy = defaultR.redefinitionDiscoveryStrategy;
                        LambdaInstrumentationStrategy lambdaInstrumentationStrategy2 = defaultR.lambdaInstrumentationStrategy;
                        Listener listener2 = apply.getListener();
                        RedefinitionStrategy.Listener listener3 = defaultR.redefinitionListener;
                        RedefinitionStrategy.BatchAllocator batchAllocator = defaultR.redefinitionBatchAllocator;
                        CircularityLock circularityLock2 = defaultR.circularityLock;
                        resettableClassFileTransformer = decorate;
                        try {
                            redefinitionStrategy2.apply(instrumentation, poolStrategy2, locationStrategy2, descriptionStrategy2, fallbackStrategy2, discoveryStrategy, lambdaInstrumentationStrategy2, listener2, listener3, rawMatcher, batchAllocator, circularityLock2);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        resettableClassFileTransformer = decorate;
                        try {
                            Throwable onError = apply.getInstallationListener().onError(instrumentation2, resettableClassFileTransformer, th);
                            if (onError != null) {
                                ResettableClassFileTransformer resettableClassFileTransformer2 = resettableClassFileTransformer;
                                defaultR = this;
                                instrumentation2.removeTransformer(resettableClassFileTransformer2);
                                throw new IllegalStateException("Could not install class file transformer", onError);
                            }
                            apply.getInstallationListener().onInstall(instrumentation2, resettableClassFileTransformer);
                            ResettableClassFileTransformer resettableClassFileTransformer3 = resettableClassFileTransformer;
                            this.circularityLock.release();
                            return resettableClassFileTransformer3;
                        } catch (Throwable th4) {
                            th = th4;
                            defaultR = this;
                            defaultR.circularityLock.release();
                            throw th;
                        }
                    }
                    apply.getInstallationListener().onInstall(instrumentation2, resettableClassFileTransformer);
                    ResettableClassFileTransformer resettableClassFileTransformer32 = resettableClassFileTransformer;
                    this.circularityLock.release();
                    return resettableClassFileTransformer32;
                } catch (Throwable th5) {
                    th = th5;
                    defaultR.circularityLock.release();
                    throw th;
                }
            } else {
                throw new IllegalStateException("Could not acquire the circularity lock upon installation.");
            }
        }

        /* access modifiers changed from: private */
        @AccessControllerPlugin.Enhance
        public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static AgentBuilder of(Plugin... pluginArr) {
            return of((List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        private static Instrumentation resolveByteBuddyAgentInstrumentation() {
            try {
                Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(INSTALLER_TYPE);
                JavaModule ofType = JavaModule.ofType(AgentBuilder.class);
                JavaModule ofType2 = JavaModule.ofType(loadClass);
                if (ofType != null && !ofType.canRead(ofType2)) {
                    Class<?> cls = Class.forName("java.lang.Module");
                    cls.getMethod("addReads", new Class[]{cls}).invoke(ofType.unwrap(), new Object[]{ofType2.unwrap()});
                }
                return (Instrumentation) loadClass.getMethod(INSTALLER_GETTER, new Class[0]).invoke((Object) null, new Object[0]);
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", e11);
            }
        }

        public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Class<?>... clsArr) {
            return JavaModule.isSupported() ? with(Listener.ModuleReadEdgeCompleting.of(instrumentation, true, clsArr)) : this;
        }

        public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Class<?>... clsArr) {
            return JavaModule.isSupported() ? with(Listener.ModuleReadEdgeCompleting.of(instrumentation, false, clsArr)) : this;
        }

        public AgentBuilder disableClassFormatChanges() {
            ByteBuddy with = this.byteBuddy.with((Implementation.Context.Factory) Implementation.Context.Disabled.Factory.INSTANCE);
            Listener listener2 = this.listener;
            CircularityLock circularityLock2 = this.circularityLock;
            PoolStrategy poolStrategy2 = this.poolStrategy;
            TypeStrategy typeStrategy2 = this.typeStrategy;
            TypeStrategy.Default defaultR = TypeStrategy.Default.DECORATE;
            if (typeStrategy2 != defaultR) {
                defaultR = TypeStrategy.Default.REDEFINE_FROZEN;
            }
            return new Default(with, listener2, circularityLock2, poolStrategy2, defaultR, this.locationStrategy, this.classFileLocator, NativeMethodStrategy.Disabled.INSTANCE, this.warmupStrategy, this.transformerDecorator, InitializationStrategy.NoOp.INSTANCE, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public AgentBuilder disableNativeMethodPrefix() {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, NativeMethodStrategy.Disabled.INSTANCE, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public AgentBuilder enableNativeMethodPrefix(String str) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, NativeMethodStrategy.ForPrefix.of(str), this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default defaultR = (Default) obj;
            return this.redefinitionStrategy.equals(defaultR.redefinitionStrategy) && this.lambdaInstrumentationStrategy.equals(defaultR.lambdaInstrumentationStrategy) && this.byteBuddy.equals(defaultR.byteBuddy) && this.listener.equals(defaultR.listener) && this.circularityLock.equals(defaultR.circularityLock) && this.poolStrategy.equals(defaultR.poolStrategy) && this.typeStrategy.equals(defaultR.typeStrategy) && this.locationStrategy.equals(defaultR.locationStrategy) && this.classFileLocator.equals(defaultR.classFileLocator) && this.nativeMethodStrategy.equals(defaultR.nativeMethodStrategy) && this.warmupStrategy.equals(defaultR.warmupStrategy) && this.transformerDecorator.equals(defaultR.transformerDecorator) && this.initializationStrategy.equals(defaultR.initializationStrategy) && this.redefinitionDiscoveryStrategy.equals(defaultR.redefinitionDiscoveryStrategy) && this.redefinitionBatchAllocator.equals(defaultR.redefinitionBatchAllocator) && this.redefinitionListener.equals(defaultR.redefinitionListener) && this.redefinitionResubmissionStrategy.equals(defaultR.redefinitionResubmissionStrategy) && this.injectionStrategy.equals(defaultR.injectionStrategy) && this.descriptionStrategy.equals(defaultR.descriptionStrategy) && this.fallbackStrategy.equals(defaultR.fallbackStrategy) && this.classFileBufferStrategy.equals(defaultR.classFileBufferStrategy) && this.installationListener.equals(defaultR.installationListener) && this.ignoreMatcher.equals(defaultR.ignoreMatcher) && this.transformations.equals(defaultR.transformations);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((getClass().hashCode() * 31) + this.byteBuddy.hashCode()) * 31) + this.listener.hashCode()) * 31) + this.circularityLock.hashCode()) * 31) + this.poolStrategy.hashCode()) * 31) + this.typeStrategy.hashCode()) * 31) + this.locationStrategy.hashCode()) * 31) + this.classFileLocator.hashCode()) * 31) + this.nativeMethodStrategy.hashCode()) * 31) + this.warmupStrategy.hashCode()) * 31) + this.transformerDecorator.hashCode()) * 31) + this.initializationStrategy.hashCode()) * 31) + this.redefinitionStrategy.hashCode()) * 31) + this.redefinitionDiscoveryStrategy.hashCode()) * 31) + this.redefinitionBatchAllocator.hashCode()) * 31) + this.redefinitionListener.hashCode()) * 31) + this.redefinitionResubmissionStrategy.hashCode()) * 31) + this.injectionStrategy.hashCode()) * 31) + this.lambdaInstrumentationStrategy.hashCode()) * 31) + this.descriptionStrategy.hashCode()) * 31) + this.fallbackStrategy.hashCode()) * 31) + this.classFileBufferStrategy.hashCode()) * 31) + this.installationListener.hashCode()) * 31) + this.ignoreMatcher.hashCode()) * 31) + this.transformations.hashCode();
        }

        public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher) {
            return ignore(elementMatcher, ElementMatchers.any());
        }

        public ResettableClassFileTransformer installOn(Instrumentation instrumentation) {
            return doInstall(instrumentation, new Transformation.SimpleMatcher(this.ignoreMatcher, this.transformations), PatchMode.Handler.NoOp.INSTANCE);
        }

        public ResettableClassFileTransformer installOnByteBuddyAgent() {
            return installOn(resolveByteBuddyAgentInstrumentation());
        }

        public ResettableClassFileTransformer patchOn(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            return patchOn(instrumentation, resettableClassFileTransformer, PatchMode.OVERLAP);
        }

        public ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer) {
            return patchOnByteBuddyAgent(resettableClassFileTransformer, PatchMode.OVERLAP);
        }

        public Identified.Narrowable type(RawMatcher rawMatcher) {
            return new Transforming(rawMatcher, Collections.emptyList(), false);
        }

        public AgentBuilder warmUp(Class<?>... clsArr) {
            return warmUp((Collection<Class<?>>) Arrays.asList(clsArr));
        }

        public AgentBuilder with(ByteBuddy byteBuddy2) {
            return new Default(byteBuddy2, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Default(net.bytebuddy.ByteBuddy r31) {
            /*
                r30 = this;
                r0 = r30
                r1 = r31
                net.bytebuddy.agent.builder.AgentBuilder$Listener$NoOp r2 = net.bytebuddy.agent.builder.AgentBuilder.Listener.NoOp.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r3 = DEFAULT_LOCK
                net.bytebuddy.agent.builder.AgentBuilder$PoolStrategy$Default r4 = net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy.Default.FAST
                net.bytebuddy.agent.builder.AgentBuilder$TypeStrategy$Default r5 = net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy.Default.REBASE
                net.bytebuddy.agent.builder.AgentBuilder$LocationStrategy$ForClassLoader r6 = net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy.ForClassLoader.STRONG
                net.bytebuddy.dynamic.ClassFileLocator$NoOp r7 = net.bytebuddy.dynamic.ClassFileLocator.NoOp.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$Default$NativeMethodStrategy$Disabled r8 = net.bytebuddy.agent.builder.AgentBuilder.Default.NativeMethodStrategy.Disabled.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$Default$WarmupStrategy$NoOp r9 = net.bytebuddy.agent.builder.AgentBuilder.Default.WarmupStrategy.NoOp.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$TransformerDecorator$NoOp r10 = net.bytebuddy.agent.builder.AgentBuilder.TransformerDecorator.NoOp.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$InitializationStrategy$SelfInjection$Split r12 = new net.bytebuddy.agent.builder.AgentBuilder$InitializationStrategy$SelfInjection$Split
                r11 = r12
                r12.<init>()
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy r12 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DISABLED
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$DiscoveryStrategy$SinglePass r13 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$BatchAllocator$ForTotal r14 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$Listener$NoOp r15 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Disabled r16 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Disabled.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$InjectionStrategy$UsingReflection r17 = net.bytebuddy.agent.builder.AgentBuilder.InjectionStrategy.UsingReflection.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$LambdaInstrumentationStrategy r18 = net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.DISABLED
                net.bytebuddy.agent.builder.AgentBuilder$DescriptionStrategy$Default r19 = net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy.Default.HYBRID
                net.bytebuddy.agent.builder.AgentBuilder$FallbackStrategy r20 = net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy.ByThrowableType.ofOptionalTypes()
                net.bytebuddy.agent.builder.AgentBuilder$ClassFileBufferStrategy$Default r21 = net.bytebuddy.agent.builder.AgentBuilder.ClassFileBufferStrategy.Default.RETAINING
                net.bytebuddy.agent.builder.AgentBuilder$InstallationListener$NoOp r22 = net.bytebuddy.agent.builder.AgentBuilder.InstallationListener.NoOp.INSTANCE
                r25 = r0
                net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$Disjunction r0 = new net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$Disjunction
                r23 = r0
                r1 = 2
                net.bytebuddy.agent.builder.AgentBuilder$RawMatcher[] r1 = new net.bytebuddy.agent.builder.AgentBuilder.RawMatcher[r1]
                r26 = r2
                net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$ForElementMatchers r2 = new net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$ForElementMatchers
                r27 = r3
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = net.bytebuddy.matcher.ElementMatchers.any()
                r28 = r4
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.isBootstrapClassLoader()
                r29 = r5
                net.bytebuddy.matcher.ElementMatcher$Junction r5 = net.bytebuddy.matcher.ElementMatchers.isExtensionClassLoader()
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = r4.or(r5)
                r2.<init>(r3, r4)
                r3 = 0
                r1[r3] = r2
                net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$ForElementMatchers r2 = new net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$ForElementMatchers
                java.lang.String r3 = "net.bytebuddy."
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = net.bytebuddy.matcher.ElementMatchers.nameStartsWith(r3)
                java.lang.String r4 = "net.bytebuddy.renamed."
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.nameStartsWith(r4)
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.not(r4)
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = r3.and(r4)
                java.lang.String r4 = "sun.reflect."
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.nameStartsWith(r4)
                java.lang.String r5 = "jdk.internal.reflect."
                net.bytebuddy.matcher.ElementMatcher$Junction r5 = net.bytebuddy.matcher.ElementMatchers.nameStartsWith(r5)
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = r4.or(r5)
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = r3.or(r4)
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.isSynthetic()
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = r3.or(r4)
                r2.<init>(r3)
                r3 = 1
                r1[r3] = r2
                r0.<init>((net.bytebuddy.agent.builder.AgentBuilder.RawMatcher[]) r1)
                java.util.List r24 = java.util.Collections.emptyList()
                r1 = r31
                r0 = r25
                r2 = r26
                r3 = r27
                r4 = r28
                r5 = r29
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.<init>(net.bytebuddy.ByteBuddy):void");
        }

        public static AgentBuilder of(List<? extends Plugin> list) {
            return of((EntryPoint) EntryPoint.Default.REBASE, list);
        }

        public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
            return ignore(elementMatcher, elementMatcher2, ElementMatchers.any());
        }

        public ResettableClassFileTransformer makeRaw() {
            return makeRaw(this.listener, InstallationListener.NoOp.INSTANCE, RedefinitionStrategy.ResubmissionEnforcer.Disabled.INSTANCE);
        }

        public ResettableClassFileTransformer patchOn(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode) {
            return doInstall(instrumentation, new Transformation.DifferentialMatcher(this.ignoreMatcher, this.transformations, resettableClassFileTransformer), patchMode.toHandler(resettableClassFileTransformer));
        }

        public ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode) {
            return patchOn(resolveByteBuddyAgentInstrumentation(), resettableClassFileTransformer, patchMode);
        }

        public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher) {
            return type(elementMatcher, ElementMatchers.any());
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0013  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.bytebuddy.agent.builder.AgentBuilder warmUp(java.util.Collection<java.lang.Class<?>> r29) {
            /*
                r28 = this;
                r0 = r28
                boolean r1 = r29.isEmpty()
                if (r1 == 0) goto L_0x0009
                return r0
            L_0x0009:
                java.util.Iterator r1 = r29.iterator()
            L_0x000d:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x003d
                java.lang.Object r2 = r1.next()
                java.lang.Class r2 = (java.lang.Class) r2
                boolean r3 = r2.isPrimitive()
                if (r3 != 0) goto L_0x0026
                boolean r3 = r2.isArray()
                if (r3 != 0) goto L_0x0026
                goto L_0x000d
            L_0x0026:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Cannot warm up primitive or array type: "
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x003d:
                net.bytebuddy.agent.builder.AgentBuilder$Default r1 = new net.bytebuddy.agent.builder.AgentBuilder$Default
                r3 = r1
                net.bytebuddy.ByteBuddy r4 = r0.byteBuddy
                net.bytebuddy.agent.builder.AgentBuilder$Listener r5 = r0.listener
                net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r6 = r0.circularityLock
                net.bytebuddy.agent.builder.AgentBuilder$PoolStrategy r7 = r0.poolStrategy
                net.bytebuddy.agent.builder.AgentBuilder$TypeStrategy r8 = r0.typeStrategy
                net.bytebuddy.agent.builder.AgentBuilder$LocationStrategy r9 = r0.locationStrategy
                net.bytebuddy.dynamic.ClassFileLocator r10 = r0.classFileLocator
                net.bytebuddy.agent.builder.AgentBuilder$Default$NativeMethodStrategy r11 = r0.nativeMethodStrategy
                net.bytebuddy.agent.builder.AgentBuilder$Default$WarmupStrategy r2 = r0.warmupStrategy
                r12 = r29
                net.bytebuddy.agent.builder.AgentBuilder$Default$WarmupStrategy r12 = r2.with(r12)
                net.bytebuddy.agent.builder.AgentBuilder$TransformerDecorator r13 = r0.transformerDecorator
                net.bytebuddy.agent.builder.AgentBuilder$InitializationStrategy r14 = r0.initializationStrategy
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy r15 = r0.redefinitionStrategy
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$DiscoveryStrategy r2 = r0.redefinitionDiscoveryStrategy
                r16 = r2
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$BatchAllocator r2 = r0.redefinitionBatchAllocator
                r17 = r2
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$Listener r2 = r0.redefinitionListener
                r18 = r2
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy r2 = r0.redefinitionResubmissionStrategy
                r19 = r2
                net.bytebuddy.agent.builder.AgentBuilder$InjectionStrategy r2 = r0.injectionStrategy
                r20 = r2
                net.bytebuddy.agent.builder.AgentBuilder$LambdaInstrumentationStrategy r2 = r0.lambdaInstrumentationStrategy
                r21 = r2
                net.bytebuddy.agent.builder.AgentBuilder$DescriptionStrategy r2 = r0.descriptionStrategy
                r22 = r2
                net.bytebuddy.agent.builder.AgentBuilder$FallbackStrategy r2 = r0.fallbackStrategy
                r23 = r2
                net.bytebuddy.agent.builder.AgentBuilder$ClassFileBufferStrategy r2 = r0.classFileBufferStrategy
                r24 = r2
                net.bytebuddy.agent.builder.AgentBuilder$InstallationListener r2 = r0.installationListener
                r25 = r2
                net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r2 = r0.ignoreMatcher
                r26 = r2
                java.util.List<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r2 = r0.transformations
                r27 = r2
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.warmUp(java.util.Collection):net.bytebuddy.agent.builder.AgentBuilder");
        }

        public AgentBuilder with(Listener listener2) {
            ByteBuddy byteBuddy2 = this.byteBuddy;
            Listener.Compound compound = r4;
            Listener.Compound compound2 = new Listener.Compound(this.listener, listener2);
            return new Default(byteBuddy2, compound, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        protected static class Redefining extends Default implements RedefinitionListenable.WithoutBatchStrategy {

            protected class WithResubmission extends Delegator implements RedefinitionListenable.WithResubmissionSpecification {
                private final RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
                private final RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
                private final RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler;

                protected WithResubmission(RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler2, RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher2, RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher2) {
                    this.resubmissionScheduler = resubmissionScheduler2;
                    this.resubmissionOnErrorMatcher = resubmissionOnErrorMatcher2;
                    this.resubmissionImmediateMatcher = resubmissionImmediateMatcher2;
                }

                /* access modifiers changed from: protected */
                public AgentBuilder materialize() {
                    Redefining redefining = Redefining.this;
                    ByteBuddy byteBuddy = redefining.byteBuddy;
                    Listener listener = redefining.listener;
                    CircularityLock circularityLock = redefining.circularityLock;
                    PoolStrategy poolStrategy = redefining.poolStrategy;
                    TypeStrategy typeStrategy = redefining.typeStrategy;
                    LocationStrategy locationStrategy = redefining.locationStrategy;
                    ClassFileLocator classFileLocator = redefining.classFileLocator;
                    NativeMethodStrategy nativeMethodStrategy = redefining.nativeMethodStrategy;
                    WarmupStrategy warmupStrategy = redefining.warmupStrategy;
                    TransformerDecorator transformerDecorator = redefining.transformerDecorator;
                    InitializationStrategy initializationStrategy = redefining.initializationStrategy;
                    RedefinitionStrategy redefinitionStrategy = redefining.redefinitionStrategy;
                    RedefinitionStrategy.DiscoveryStrategy discoveryStrategy = redefining.redefinitionDiscoveryStrategy;
                    ByteBuddy byteBuddy2 = byteBuddy;
                    Redefining redefining2 = redefining;
                    RedefinitionStrategy.BatchAllocator batchAllocator = redefining.redefinitionBatchAllocator;
                    RedefinitionStrategy.Listener listener2 = redefining2.redefinitionListener;
                    RedefinitionStrategy.ResubmissionStrategy.Enabled enabled = r1;
                    RedefinitionStrategy.ResubmissionStrategy.Enabled enabled2 = new RedefinitionStrategy.ResubmissionStrategy.Enabled(this.resubmissionScheduler, this.resubmissionOnErrorMatcher, this.resubmissionImmediateMatcher);
                    Redefining redefining3 = Redefining.this;
                    return new Default(byteBuddy2, listener, circularityLock, poolStrategy, typeStrategy, locationStrategy, classFileLocator, nativeMethodStrategy, warmupStrategy, transformerDecorator, initializationStrategy, redefinitionStrategy, discoveryStrategy, batchAllocator, listener2, enabled, redefining3.injectionStrategy, redefining3.lambdaInstrumentationStrategy, redefining3.descriptionStrategy, redefining3.fallbackStrategy, redefining3.classFileBufferStrategy, redefining3.installationListener, redefining3.ignoreMatcher, redefining3.transformations);
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate() {
                    return resubmitImmediate((ElementMatcher<String>) ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError() {
                    return resubmitOnError((ElementMatcher<? super Throwable>) ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher) {
                    return resubmitImmediate(elementMatcher, ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher) {
                    return resubmitOnError(elementMatcher, ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                    return resubmitImmediate(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2) {
                    return resubmitOnError(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                    return resubmitImmediate((RedefinitionListenable.ResubmissionImmediateMatcher) new RedefinitionListenable.ResubmissionImmediateMatcher.ForElementMatchers(elementMatcher, elementMatcher2, elementMatcher3));
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3) {
                    return resubmitOnError(elementMatcher, elementMatcher2, elementMatcher3, ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher2) {
                    return new WithResubmission(this.resubmissionScheduler, this.resubmissionOnErrorMatcher, new RedefinitionListenable.ResubmissionImmediateMatcher.Disjunction(this.resubmissionImmediateMatcher, resubmissionImmediateMatcher2));
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3, ElementMatcher<? super JavaModule> elementMatcher4) {
                    return resubmitOnError((RedefinitionListenable.ResubmissionOnErrorMatcher) new RedefinitionListenable.ResubmissionOnErrorMatcher.ForElementMatchers(elementMatcher, elementMatcher2, elementMatcher3, elementMatcher4));
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher2) {
                    return new WithResubmission(this.resubmissionScheduler, new RedefinitionListenable.ResubmissionOnErrorMatcher.Disjunction(this.resubmissionOnErrorMatcher, resubmissionOnErrorMatcher2), this.resubmissionImmediateMatcher);
                }
            }

            protected Redefining(ByteBuddy byteBuddy, Listener listener, CircularityLock circularityLock, PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy, ClassFileLocator classFileLocator, NativeMethodStrategy nativeMethodStrategy, WarmupStrategy warmupStrategy, TransformerDecorator transformerDecorator, InitializationStrategy initializationStrategy, RedefinitionStrategy redefinitionStrategy, RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, RedefinitionStrategy.BatchAllocator batchAllocator, RedefinitionStrategy.Listener listener2, RedefinitionStrategy.ResubmissionStrategy resubmissionStrategy, InjectionStrategy injectionStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener, RawMatcher rawMatcher, List<Transformation> list) {
                super(byteBuddy, listener, circularityLock, poolStrategy, typeStrategy, locationStrategy, classFileLocator, nativeMethodStrategy, warmupStrategy, transformerDecorator, initializationStrategy, redefinitionStrategy, discoveryStrategy, batchAllocator, listener2, resubmissionStrategy, injectionStrategy, lambdaInstrumentationStrategy, descriptionStrategy, fallbackStrategy, classFileBufferStrategy, installationListener, rawMatcher, list);
            }

            public /* bridge */ /* synthetic */ ClassFileTransformer makeRaw() {
                return super.makeRaw();
            }

            public RedefinitionListenable redefineOnly(Class<?>... clsArr) {
                return with((RedefinitionStrategy.DiscoveryStrategy) new RedefinitionStrategy.DiscoveryStrategy.Explicit(clsArr));
            }

            public RedefinitionListenable.WithImplicitDiscoveryStrategy with(RedefinitionStrategy.BatchAllocator batchAllocator) {
                if (this.redefinitionStrategy.isEnabled()) {
                    Redefining redefining = r2;
                    Redefining redefining2 = new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, batchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
                    return redefining;
                }
                throw new IllegalStateException("Cannot set redefinition batch allocator when redefinition is disabled");
            }

            public RedefinitionListenable.WithoutResubmissionSpecification withResubmission(RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler) {
                if (this.redefinitionStrategy.isEnabled()) {
                    return new WithResubmission(resubmissionScheduler, RedefinitionListenable.ResubmissionOnErrorMatcher.Trivial.NON_MATCHING, RedefinitionListenable.ResubmissionImmediateMatcher.Trivial.NON_MATCHING);
                }
                throw new IllegalStateException("Cannot enable resubmission when redefinition is disabled");
            }

            public RedefinitionListenable with(RedefinitionStrategy.DiscoveryStrategy discoveryStrategy) {
                if (this.redefinitionStrategy.isEnabled()) {
                    return new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, discoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
                }
                throw new IllegalStateException("Cannot set redefinition discovery strategy when redefinition is disabled");
            }

            public RedefinitionListenable with(RedefinitionStrategy.Listener listener) {
                if (this.redefinitionStrategy.isEnabled()) {
                    ByteBuddy byteBuddy = this.byteBuddy;
                    Listener listener2 = this.listener;
                    CircularityLock circularityLock = this.circularityLock;
                    PoolStrategy poolStrategy = this.poolStrategy;
                    TypeStrategy typeStrategy = this.typeStrategy;
                    LocationStrategy locationStrategy = this.locationStrategy;
                    ClassFileLocator classFileLocator = this.classFileLocator;
                    NativeMethodStrategy nativeMethodStrategy = this.nativeMethodStrategy;
                    WarmupStrategy warmupStrategy = this.warmupStrategy;
                    TransformerDecorator transformerDecorator = this.transformerDecorator;
                    InitializationStrategy initializationStrategy = this.initializationStrategy;
                    RedefinitionStrategy redefinitionStrategy = this.redefinitionStrategy;
                    RedefinitionStrategy.DiscoveryStrategy discoveryStrategy = this.redefinitionDiscoveryStrategy;
                    Redefining redefining = r2;
                    RedefinitionStrategy.BatchAllocator batchAllocator = this.redefinitionBatchAllocator;
                    RedefinitionStrategy.Listener.Compound compound = r1;
                    RedefinitionStrategy.Listener.Compound compound2 = new RedefinitionStrategy.Listener.Compound(this.redefinitionListener, listener);
                    Redefining redefining2 = new Redefining(byteBuddy, listener2, circularityLock, poolStrategy, typeStrategy, locationStrategy, classFileLocator, nativeMethodStrategy, warmupStrategy, transformerDecorator, initializationStrategy, redefinitionStrategy, discoveryStrategy, batchAllocator, compound, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
                    return redefining;
                }
                throw new IllegalStateException("Cannot set redefinition listener when redefinition is disabled");
            }
        }

        private ResettableClassFileTransformer makeRaw(Listener listener2, InstallationListener installationListener2, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer) {
            ExecutingTransformer.Factory factory = ExecutingTransformer.FACTORY;
            return factory.make(this.byteBuddy, listener2, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.initializationStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, installationListener2, this.ignoreMatcher, resubmissionEnforcer, this.transformations, this.circularityLock);
        }

        public static AgentBuilder of(EntryPoint entryPoint, Plugin... pluginArr) {
            return of(entryPoint, (List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
            return assureReadEdgeFromAndTo(instrumentation, (Collection<? extends JavaModule>) Arrays.asList(javaModuleArr));
        }

        public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
            return assureReadEdgeTo(instrumentation, (Collection<? extends JavaModule>) Arrays.asList(javaModuleArr));
        }

        public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
            return ignore((RawMatcher) new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2, ElementMatchers.not(ElementMatchers.supportsModules()).or(elementMatcher3)));
        }

        public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
            return type(elementMatcher, elementMatcher2, ElementMatchers.any());
        }

        public AgentBuilder with(CircularityLock circularityLock2) {
            return new Default(this.byteBuddy, this.listener, circularityLock2, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public static AgentBuilder of(EntryPoint entryPoint, List<? extends Plugin> list) {
            return of(entryPoint, ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5), list);
        }

        public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection) {
            return with((Listener) new Listener.ModuleReadEdgeCompleting(instrumentation, true, new HashSet(collection)));
        }

        public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection) {
            return with((Listener) new Listener.ModuleReadEdgeCompleting(instrumentation, false, new HashSet(collection)));
        }

        public Ignored ignore(RawMatcher rawMatcher) {
            return new Ignoring(rawMatcher);
        }

        public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
            return type((RawMatcher) new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2, ElementMatchers.not(ElementMatchers.supportsModules()).or(elementMatcher3)));
        }

        public AgentBuilder with(TypeStrategy typeStrategy2) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, typeStrategy2, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        protected static class ExecutingTransformer extends ResettableClassFileTransformer.AbstractBase {
            private static final boolean ACCESS_CONTROLLER;
            protected static final Factory FACTORY = ((Factory) Default.doPrivileged(Factory.CreationAction.INSTANCE));
            @MaybeNull
            private final Object accessControlContext = getContext();
            private final ByteBuddy byteBuddy;
            private final CircularityLock circularityLock;
            private final ClassFileBufferStrategy classFileBufferStrategy;
            private final ClassFileLocator classFileLocator;
            private final DescriptionStrategy descriptionStrategy;
            private final FallbackStrategy fallbackStrategy;
            private final RawMatcher ignoreMatcher;
            private final InitializationStrategy initializationStrategy;
            private final InjectionStrategy injectionStrategy;
            private final InstallationListener installationListener;
            private final LambdaInstrumentationStrategy lambdaInstrumentationStrategy;
            private final Listener listener;
            private final LocationStrategy locationStrategy;
            private final NativeMethodStrategy nativeMethodStrategy;
            private final PoolStrategy poolStrategy;
            private final RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer;
            private final List<Transformation> transformations;
            private final TypeStrategy typeStrategy;

            protected interface Factory {

                public enum CreationAction implements PrivilegedAction<Factory> {
                    INSTANCE;

                    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
                    public Factory run() {
                        try {
                            DynamicType.Builder<ExecutingTransformer> subclass = new ByteBuddy().with(TypeValidation.DISABLED).subclass(ExecutingTransformer.class);
                            return new ForJava9CapableVm(subclass.name(ExecutingTransformer.class.getName() + "$ByteBuddy$ModuleSupport").method(ElementMatchers.named("transform").and(ElementMatchers.takesArgument(0, (Class<?>) JavaType.MODULE.load()))).intercept(MethodCall.invoke(ExecutingTransformer.class.getDeclaredMethod("transform", new Class[]{Object.class, ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class})).onSuper().withAllArguments()).make().load(ExecutingTransformer.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER_PERSISTENT.with(ExecutingTransformer.class.getProtectionDomain())).getLoaded().getDeclaredConstructor(new Class[]{ByteBuddy.class, Listener.class, PoolStrategy.class, TypeStrategy.class, LocationStrategy.class, ClassFileLocator.class, NativeMethodStrategy.class, InitializationStrategy.class, InjectionStrategy.class, LambdaInstrumentationStrategy.class, DescriptionStrategy.class, FallbackStrategy.class, ClassFileBufferStrategy.class, InstallationListener.class, RawMatcher.class, RedefinitionStrategy.ResubmissionEnforcer.class, List.class, CircularityLock.class}));
                        } catch (Exception unused) {
                            return ForLegacyVm.INSTANCE;
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJava9CapableVm implements Factory {
                    private final Constructor<? extends ResettableClassFileTransformer> executingTransformer;

                    protected ForJava9CapableVm(Constructor<? extends ResettableClassFileTransformer> constructor) {
                        this.executingTransformer = constructor;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.executingTransformer.equals(((ForJava9CapableVm) obj).executingTransformer);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.executingTransformer.hashCode();
                    }

                    public ResettableClassFileTransformer make(ByteBuddy byteBuddy, Listener listener, PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy, ClassFileLocator classFileLocator, NativeMethodStrategy nativeMethodStrategy, InitializationStrategy initializationStrategy, InjectionStrategy injectionStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener, RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer, List<Transformation> list, CircularityLock circularityLock) {
                        try {
                            return (ResettableClassFileTransformer) this.executingTransformer.newInstance(new Object[]{byteBuddy, listener, poolStrategy, typeStrategy, locationStrategy, classFileLocator, nativeMethodStrategy, initializationStrategy, injectionStrategy, lambdaInstrumentationStrategy, descriptionStrategy, fallbackStrategy, classFileBufferStrategy, installationListener, rawMatcher, resubmissionEnforcer, list, circularityLock});
                        } catch (IllegalAccessException e10) {
                            throw new IllegalStateException("Cannot access " + this.executingTransformer, e10);
                        } catch (InstantiationException e11) {
                            throw new IllegalStateException("Cannot instantiate " + this.executingTransformer.getDeclaringClass(), e11);
                        } catch (InvocationTargetException e12) {
                            throw new IllegalStateException("Cannot invoke " + this.executingTransformer, e12.getTargetException());
                        }
                    }
                }

                public enum ForLegacyVm implements Factory {
                    INSTANCE;

                    public ResettableClassFileTransformer make(ByteBuddy byteBuddy, Listener listener, PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy, ClassFileLocator classFileLocator, NativeMethodStrategy nativeMethodStrategy, InitializationStrategy initializationStrategy, InjectionStrategy injectionStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener, RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer, List<Transformation> list, CircularityLock circularityLock) {
                        return new ExecutingTransformer(byteBuddy, listener, poolStrategy, typeStrategy, locationStrategy, classFileLocator, nativeMethodStrategy, initializationStrategy, injectionStrategy, lambdaInstrumentationStrategy, descriptionStrategy, fallbackStrategy, classFileBufferStrategy, installationListener, rawMatcher, resubmissionEnforcer, list, circularityLock);
                    }
                }

                ResettableClassFileTransformer make(ByteBuddy byteBuddy, Listener listener, PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy, ClassFileLocator classFileLocator, NativeMethodStrategy nativeMethodStrategy, InitializationStrategy initializationStrategy, InjectionStrategy injectionStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener, RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer, List<Transformation> list, CircularityLock circularityLock);
            }

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            protected class Java9CapableVmDispatcher implements PrivilegedAction<byte[]> {
                private final byte[] binaryRepresentation;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final Class<?> classBeingRedefined;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final ClassLoader classLoader;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final String internalTypeName;
                private final ProtectionDomain protectionDomain;
                private final Object rawModule;

                protected Java9CapableVmDispatcher(Object obj, @MaybeNull ClassLoader classLoader2, @MaybeNull String str, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain2, byte[] bArr) {
                    this.rawModule = obj;
                    this.classLoader = classLoader2;
                    this.internalTypeName = str;
                    this.classBeingRedefined = cls;
                    this.protectionDomain = protectionDomain2;
                    this.binaryRepresentation = bArr;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
                    if (r2 != null) goto L_0x0026;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
                    if (r2 != null) goto L_0x0043;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x0053, code lost:
                    if (r2 != null) goto L_0x0055;
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
                        java.lang.String r2 = r4.internalTypeName
                        net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer$Java9CapableVmDispatcher r5 = (net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.Java9CapableVmDispatcher) r5
                        java.lang.String r3 = r5.internalTypeName
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
                        java.lang.Object r2 = r4.rawModule
                        java.lang.Object r3 = r5.rawModule
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0032
                        return r1
                    L_0x0032:
                        java.lang.ClassLoader r2 = r4.classLoader
                        java.lang.ClassLoader r3 = r5.classLoader
                        if (r3 == 0) goto L_0x0041
                        if (r2 == 0) goto L_0x0043
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0044
                        return r1
                    L_0x0041:
                        if (r2 == 0) goto L_0x0044
                    L_0x0043:
                        return r1
                    L_0x0044:
                        java.lang.Class<?> r2 = r4.classBeingRedefined
                        java.lang.Class<?> r3 = r5.classBeingRedefined
                        if (r3 == 0) goto L_0x0053
                        if (r2 == 0) goto L_0x0055
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0056
                        return r1
                    L_0x0053:
                        if (r2 == 0) goto L_0x0056
                    L_0x0055:
                        return r1
                    L_0x0056:
                        java.security.ProtectionDomain r2 = r4.protectionDomain
                        java.security.ProtectionDomain r3 = r5.protectionDomain
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0061
                        return r1
                    L_0x0061:
                        byte[] r2 = r4.binaryRepresentation
                        byte[] r3 = r5.binaryRepresentation
                        boolean r2 = java.util.Arrays.equals(r2, r3)
                        if (r2 != 0) goto L_0x006c
                        return r1
                    L_0x006c:
                        net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer r2 = net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.this
                        net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer r5 = net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.this
                        boolean r5 = r2.equals(r5)
                        if (r5 != 0) goto L_0x0077
                        return r1
                    L_0x0077:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.Java9CapableVmDispatcher.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    int hashCode = ((getClass().hashCode() * 31) + this.rawModule.hashCode()) * 31;
                    ClassLoader classLoader2 = this.classLoader;
                    if (classLoader2 != null) {
                        hashCode += classLoader2.hashCode();
                    }
                    int i10 = hashCode * 31;
                    String str = this.internalTypeName;
                    if (str != null) {
                        i10 += str.hashCode();
                    }
                    int i11 = i10 * 31;
                    Class<?> cls = this.classBeingRedefined;
                    if (cls != null) {
                        i11 += cls.hashCode();
                    }
                    return (((((i11 * 31) + this.protectionDomain.hashCode()) * 31) + Arrays.hashCode(this.binaryRepresentation)) * 31) + ExecutingTransformer.this.hashCode();
                }

                @MaybeNull
                public byte[] run() {
                    return ExecutingTransformer.this.transform(JavaModule.of(this.rawModule), this.classLoader, this.internalTypeName, this.classBeingRedefined, this.protectionDomain, this.binaryRepresentation);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            protected class LegacyVmDispatcher implements PrivilegedAction<byte[]> {
                private final byte[] binaryRepresentation;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final Class<?> classBeingRedefined;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final ClassLoader classLoader;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final String internalTypeName;
                private final ProtectionDomain protectionDomain;

                protected LegacyVmDispatcher(@MaybeNull ClassLoader classLoader2, @MaybeNull String str, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain2, byte[] bArr) {
                    this.classLoader = classLoader2;
                    this.internalTypeName = str;
                    this.classBeingRedefined = cls;
                    this.protectionDomain = protectionDomain2;
                    this.binaryRepresentation = bArr;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
                    if (r2 != null) goto L_0x0026;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
                    if (r2 != null) goto L_0x0038;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
                    if (r2 != null) goto L_0x004a;
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
                        java.lang.String r2 = r4.internalTypeName
                        net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer$LegacyVmDispatcher r5 = (net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.LegacyVmDispatcher) r5
                        java.lang.String r3 = r5.internalTypeName
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
                        java.lang.ClassLoader r2 = r4.classLoader
                        java.lang.ClassLoader r3 = r5.classLoader
                        if (r3 == 0) goto L_0x0036
                        if (r2 == 0) goto L_0x0038
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0039
                        return r1
                    L_0x0036:
                        if (r2 == 0) goto L_0x0039
                    L_0x0038:
                        return r1
                    L_0x0039:
                        java.lang.Class<?> r2 = r4.classBeingRedefined
                        java.lang.Class<?> r3 = r5.classBeingRedefined
                        if (r3 == 0) goto L_0x0048
                        if (r2 == 0) goto L_0x004a
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x004b
                        return r1
                    L_0x0048:
                        if (r2 == 0) goto L_0x004b
                    L_0x004a:
                        return r1
                    L_0x004b:
                        java.security.ProtectionDomain r2 = r4.protectionDomain
                        java.security.ProtectionDomain r3 = r5.protectionDomain
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0056
                        return r1
                    L_0x0056:
                        byte[] r2 = r4.binaryRepresentation
                        byte[] r3 = r5.binaryRepresentation
                        boolean r2 = java.util.Arrays.equals(r2, r3)
                        if (r2 != 0) goto L_0x0061
                        return r1
                    L_0x0061:
                        net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer r2 = net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.this
                        net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer r5 = net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.this
                        boolean r5 = r2.equals(r5)
                        if (r5 != 0) goto L_0x006c
                        return r1
                    L_0x006c:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.LegacyVmDispatcher.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    int hashCode = getClass().hashCode() * 31;
                    ClassLoader classLoader2 = this.classLoader;
                    if (classLoader2 != null) {
                        hashCode += classLoader2.hashCode();
                    }
                    int i10 = hashCode * 31;
                    String str = this.internalTypeName;
                    if (str != null) {
                        i10 += str.hashCode();
                    }
                    int i11 = i10 * 31;
                    Class<?> cls = this.classBeingRedefined;
                    if (cls != null) {
                        i11 += cls.hashCode();
                    }
                    return (((((i11 * 31) + this.protectionDomain.hashCode()) * 31) + Arrays.hashCode(this.binaryRepresentation)) * 31) + ExecutingTransformer.this.hashCode();
                }

                @MaybeNull
                public byte[] run() {
                    return ExecutingTransformer.this.transform(JavaModule.UNSUPPORTED, this.classLoader, this.internalTypeName, this.classBeingRedefined, this.protectionDomain, this.binaryRepresentation);
                }
            }

            static {
                boolean z10 = false;
                try {
                    Class.forName("java.security.AccessController", false, (ClassLoader) null);
                    ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
                } catch (ClassNotFoundException unused) {
                } catch (SecurityException unused2) {
                    z10 = true;
                }
                ACCESS_CONTROLLER = z10;
            }

            public ExecutingTransformer(ByteBuddy byteBuddy2, Listener listener2, PoolStrategy poolStrategy2, TypeStrategy typeStrategy2, LocationStrategy locationStrategy2, ClassFileLocator classFileLocator2, NativeMethodStrategy nativeMethodStrategy2, InitializationStrategy initializationStrategy2, InjectionStrategy injectionStrategy2, LambdaInstrumentationStrategy lambdaInstrumentationStrategy2, DescriptionStrategy descriptionStrategy2, FallbackStrategy fallbackStrategy2, ClassFileBufferStrategy classFileBufferStrategy2, InstallationListener installationListener2, RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer2, List<Transformation> list, CircularityLock circularityLock2) {
                this.byteBuddy = byteBuddy2;
                this.typeStrategy = typeStrategy2;
                this.poolStrategy = poolStrategy2;
                this.locationStrategy = locationStrategy2;
                this.classFileLocator = classFileLocator2;
                this.listener = listener2;
                this.nativeMethodStrategy = nativeMethodStrategy2;
                this.initializationStrategy = initializationStrategy2;
                this.injectionStrategy = injectionStrategy2;
                this.lambdaInstrumentationStrategy = lambdaInstrumentationStrategy2;
                this.descriptionStrategy = descriptionStrategy2;
                this.fallbackStrategy = fallbackStrategy2;
                this.classFileBufferStrategy = classFileBufferStrategy2;
                this.installationListener = installationListener2;
                this.ignoreMatcher = rawMatcher;
                this.resubmissionEnforcer = resubmissionEnforcer2;
                this.transformations = list;
                this.circularityLock = circularityLock2;
            }

            @AccessControllerPlugin.Enhance
            private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction, @MaybeNull Object obj) {
                return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction, (AccessControlContext) obj) : privilegedAction.run();
            }

            @MaybeNull
            private byte[] doTransform(@MaybeNull JavaModule javaModule, @MaybeNull ClassLoader classLoader, String str, @MaybeNull Class<?> cls, boolean z10, ProtectionDomain protectionDomain, TypePool typePool, ClassFileLocator classFileLocator2) {
                ClassLoader classLoader2 = classLoader;
                TypeDescription apply = this.descriptionStrategy.apply(str, cls, typePool, this.circularityLock, classLoader, javaModule);
                ArrayList<Transformer> arrayList = new ArrayList<>();
                if (!this.ignoreMatcher.matches(apply, classLoader, javaModule, cls, protectionDomain)) {
                    for (Transformation next : this.transformations) {
                        if (next.getMatcher().matches(apply, classLoader, javaModule, cls, protectionDomain)) {
                            arrayList.addAll(next.getTransformers());
                            if (next.isTerminal()) {
                                break;
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    JavaModule javaModule2 = javaModule;
                    this.listener.onIgnored(apply, classLoader2, javaModule, z10);
                    return Transformation.NONE;
                }
                JavaModule javaModule3 = javaModule;
                boolean z11 = z10;
                DynamicType.Builder<?> builder = this.typeStrategy.builder(apply, this.byteBuddy, classFileLocator2, this.nativeMethodStrategy.resolve(), classLoader, javaModule, protectionDomain);
                InitializationStrategy.Dispatcher dispatcher = this.initializationStrategy.dispatcher();
                DynamicType.Builder<?> builder2 = builder;
                for (Transformer transform : arrayList) {
                    builder2 = transform.transform(builder2, apply, classLoader, javaModule, protectionDomain);
                }
                DynamicType.Unloaded<?> make = dispatcher.apply(builder2).make(TypeResolutionStrategy.Disabled.INSTANCE, typePool);
                dispatcher.register(make, classLoader2, protectionDomain, this.injectionStrategy);
                this.listener.onTransformation(apply, classLoader, javaModule, z10, make);
                return make.getBytes();
            }

            @AccessControllerPlugin.Enhance
            @MaybeNull
            private static Object getContext() {
                if (ACCESS_CONTROLLER) {
                    return AccessController.getContext();
                }
                return null;
            }

            public Iterator<Transformer> iterator(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain) {
                if (this.ignoreMatcher.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                    return Collections.emptySet().iterator();
                }
                return new Transformation.TransformerIterator(typeDescription, classLoader, javaModule, cls, protectionDomain, this.transformations);
            }

            public synchronized boolean reset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, RedefinitionStrategy redefinitionStrategy, RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, RedefinitionStrategy.BatchAllocator batchAllocator, RedefinitionStrategy.Listener listener2) {
                synchronized (this) {
                    if (!instrumentation.removeTransformer(resettableClassFileTransformer)) {
                        return false;
                    }
                    redefinitionStrategy.apply(instrumentation, this.poolStrategy, this.locationStrategy, this.descriptionStrategy, this.fallbackStrategy, discoveryStrategy, this.lambdaInstrumentationStrategy, Listener.NoOp.INSTANCE, listener2, new Transformation.SimpleMatcher(this.ignoreMatcher, this.transformations), batchAllocator, CircularityLock.Inactive.INSTANCE);
                    this.installationListener.onReset(instrumentation, resettableClassFileTransformer);
                    return true;
                }
            }

            @MaybeNull
            public byte[] transform(@MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
                if (!this.circularityLock.acquire()) {
                    return Default.NO_TRANSFORMATION;
                }
                try {
                    return (byte[]) doPrivileged(new LegacyVmDispatcher(classLoader, str, cls, protectionDomain, bArr), this.accessControlContext);
                } finally {
                    this.circularityLock.release();
                }
            }

            /* access modifiers changed from: protected */
            @MaybeNull
            public byte[] transform(Object obj, @MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
                if (!this.circularityLock.acquire()) {
                    return Default.NO_TRANSFORMATION;
                }
                try {
                    return (byte[]) doPrivileged(new Java9CapableVmDispatcher(obj, classLoader, str, cls, protectionDomain, bArr), this.accessControlContext);
                } finally {
                    this.circularityLock.release();
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x010b A[Catch:{ all -> 0x0138 }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x010d A[Catch:{ all -> 0x0138 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x0116  */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x0118  */
            @net.bytebuddy.utility.nullability.MaybeNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public byte[] transform(@net.bytebuddy.utility.nullability.MaybeNull net.bytebuddy.utility.JavaModule r21, @net.bytebuddy.utility.nullability.MaybeNull java.lang.ClassLoader r22, @net.bytebuddy.utility.nullability.MaybeNull java.lang.String r23, @net.bytebuddy.utility.nullability.MaybeNull java.lang.Class<?> r24, java.security.ProtectionDomain r25, byte[] r26) {
                /*
                    r20 = this;
                    r10 = r20
                    r11 = r21
                    r12 = r22
                    r0 = r23
                    r13 = r24
                    java.lang.String r14 = "Failed transformation of "
                    if (r0 == 0) goto L_0x014b
                    net.bytebuddy.agent.builder.AgentBuilder$LambdaInstrumentationStrategy r1 = r10.lambdaInstrumentationStrategy
                    boolean r1 = r1.isInstrumented(r13)
                    if (r1 != 0) goto L_0x0018
                    goto L_0x014b
                L_0x0018:
                    r1 = 47
                    r2 = 46
                    java.lang.String r15 = r0.replace(r1, r2)
                    r16 = 0
                    r9 = 1
                    net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionEnforcer r0 = r10.resubmissionEnforcer     // Catch:{ all -> 0x0103 }
                    boolean r0 = r0.isEnforced(r15, r12, r11, r13)     // Catch:{ all -> 0x0103 }
                    if (r0 == 0) goto L_0x0036
                    byte[] r0 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION     // Catch:{ all -> 0x0030 }
                    return r0
                L_0x0030:
                    r0 = move-exception
                    r8 = r0
                    r7 = r14
                    r14 = r9
                    goto L_0x0107
                L_0x0036:
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r0 = r10.listener     // Catch:{ all -> 0x00cb }
                    if (r13 == 0) goto L_0x003c
                    r1 = r9
                    goto L_0x003e
                L_0x003c:
                    r1 = r16
                L_0x003e:
                    r0.onDiscovery(r15, r12, r11, r1)     // Catch:{ all -> 0x00cb }
                    net.bytebuddy.dynamic.ClassFileLocator$Compound r8 = new net.bytebuddy.dynamic.ClassFileLocator$Compound     // Catch:{ all -> 0x00cb }
                    r0 = 3
                    net.bytebuddy.dynamic.ClassFileLocator[] r0 = new net.bytebuddy.dynamic.ClassFileLocator[r0]     // Catch:{ all -> 0x00cb }
                    net.bytebuddy.agent.builder.AgentBuilder$ClassFileBufferStrategy r1 = r10.classFileBufferStrategy     // Catch:{ all -> 0x00cb }
                    r2 = r15
                    r3 = r26
                    r4 = r22
                    r5 = r21
                    r6 = r25
                    net.bytebuddy.dynamic.ClassFileLocator r1 = r1.resolve(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00cb }
                    r0[r16] = r1     // Catch:{ all -> 0x00cb }
                    net.bytebuddy.dynamic.ClassFileLocator r1 = r10.classFileLocator     // Catch:{ all -> 0x00cb }
                    r0[r9] = r1     // Catch:{ all -> 0x00cb }
                    r1 = 2
                    net.bytebuddy.agent.builder.AgentBuilder$LocationStrategy r2 = r10.locationStrategy     // Catch:{ all -> 0x00cb }
                    net.bytebuddy.dynamic.ClassFileLocator r2 = r2.classFileLocator(r12, r11)     // Catch:{ all -> 0x00cb }
                    r0[r1] = r2     // Catch:{ all -> 0x00cb }
                    r8.<init>((net.bytebuddy.dynamic.ClassFileLocator[]) r0)     // Catch:{ all -> 0x00cb }
                    net.bytebuddy.agent.builder.AgentBuilder$ClassFileBufferStrategy r0 = r10.classFileBufferStrategy     // Catch:{ all -> 0x00cb }
                    net.bytebuddy.agent.builder.AgentBuilder$PoolStrategy r1 = r10.poolStrategy     // Catch:{ all -> 0x00cb }
                    net.bytebuddy.pool.TypePool r17 = r0.typePool(r1, r8, r12, r15)     // Catch:{ all -> 0x00cb }
                    if (r13 == 0) goto L_0x0073
                    r6 = r9
                    goto L_0x0075
                L_0x0073:
                    r6 = r16
                L_0x0075:
                    r1 = r20
                    r2 = r21
                    r3 = r22
                    r4 = r15
                    r5 = r24
                    r7 = r25
                    r18 = r8
                    r8 = r17
                    r19 = r14
                    r14 = r9
                    r9 = r18
                    byte[] r0 = r1.doTransform(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0098 }
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    if (r13 == 0) goto L_0x0092
                    goto L_0x0094
                L_0x0092:
                    r14 = r16
                L_0x0094:
                    r1.onComplete(r15, r12, r11, r14)
                    return r0
                L_0x0098:
                    r0 = move-exception
                    r1 = r0
                    if (r13 == 0) goto L_0x00c8
                    net.bytebuddy.agent.builder.AgentBuilder$DescriptionStrategy r0 = r10.descriptionStrategy     // Catch:{ all -> 0x00c9 }
                    boolean r0 = r0.isLoadedFirst()     // Catch:{ all -> 0x00c9 }
                    if (r0 == 0) goto L_0x00c8
                    net.bytebuddy.agent.builder.AgentBuilder$FallbackStrategy r0 = r10.fallbackStrategy     // Catch:{ all -> 0x00c9 }
                    boolean r0 = r0.isFallback(r13, r1)     // Catch:{ all -> 0x00c9 }
                    if (r0 == 0) goto L_0x00c8
                    java.lang.Class r5 = net.bytebuddy.agent.builder.AgentBuilder.Default.NOT_PREVIOUSLY_DEFINED     // Catch:{ all -> 0x00c9 }
                    r6 = 1
                    r1 = r20
                    r2 = r21
                    r3 = r22
                    r4 = r15
                    r7 = r25
                    r8 = r17
                    r9 = r18
                    byte[] r0 = r1.doTransform(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00c9 }
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    r1.onComplete(r15, r12, r11, r14)
                    return r0
                L_0x00c8:
                    throw r1     // Catch:{ all -> 0x00c9 }
                L_0x00c9:
                    r0 = move-exception
                    goto L_0x00cf
                L_0x00cb:
                    r0 = move-exception
                    r19 = r14
                    r14 = r9
                L_0x00cf:
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener     // Catch:{ all -> 0x00f7 }
                    if (r13 == 0) goto L_0x00d5
                    r5 = r14
                    goto L_0x00d7
                L_0x00d5:
                    r5 = r16
                L_0x00d7:
                    r2 = r15
                    r3 = r22
                    r4 = r21
                    r6 = r0
                    r1.onError(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00f7 }
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f7 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
                    r2.<init>()     // Catch:{ all -> 0x00f7 }
                    r7 = r19
                    r2.append(r7)     // Catch:{ all -> 0x00f7 }
                    r2.append(r15)     // Catch:{ all -> 0x00f7 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00f7 }
                    r1.<init>(r2, r0)     // Catch:{ all -> 0x00f7 }
                    throw r1     // Catch:{ all -> 0x00f7 }
                L_0x00f7:
                    r0 = move-exception
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    if (r13 == 0) goto L_0x00fd
                    goto L_0x00ff
                L_0x00fd:
                    r14 = r16
                L_0x00ff:
                    r1.onComplete(r15, r12, r11, r14)
                    throw r0
                L_0x0103:
                    r0 = move-exception
                    r7 = r14
                    r14 = r9
                    r8 = r0
                L_0x0107:
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r0 = r10.listener     // Catch:{ all -> 0x0138 }
                    if (r13 == 0) goto L_0x010d
                    r9 = r14
                    goto L_0x010f
                L_0x010d:
                    r9 = r16
                L_0x010f:
                    r0.onDiscovery(r15, r12, r11, r9)     // Catch:{ all -> 0x0138 }
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    if (r13 == 0) goto L_0x0118
                    r5 = r14
                    goto L_0x011a
                L_0x0118:
                    r5 = r16
                L_0x011a:
                    r2 = r15
                    r3 = r22
                    r4 = r21
                    r6 = r8
                    r1.onError(r2, r3, r4, r5, r6)
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r7)
                    r1.append(r15)
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1, r8)
                    throw r0
                L_0x0138:
                    r0 = move-exception
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    if (r13 == 0) goto L_0x013f
                    r5 = r14
                    goto L_0x0141
                L_0x013f:
                    r5 = r16
                L_0x0141:
                    r2 = r15
                    r3 = r22
                    r4 = r21
                    r6 = r8
                    r1.onError(r2, r3, r4, r5, r6)
                    throw r0
                L_0x014b:
                    byte[] r0 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.transform(net.bytebuddy.utility.JavaModule, java.lang.ClassLoader, java.lang.String, java.lang.Class, java.security.ProtectionDomain, byte[]):byte[]");
            }
        }

        public static AgentBuilder of(ClassFileVersion classFileVersion, Plugin... pluginArr) {
            return of(classFileVersion, (List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        public AgentBuilder with(PoolStrategy poolStrategy2) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, poolStrategy2, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public static AgentBuilder of(ClassFileVersion classFileVersion, List<? extends Plugin> list) {
            return of((EntryPoint) EntryPoint.Default.REBASE, classFileVersion, list);
        }

        public AgentBuilder with(LocationStrategy locationStrategy2) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, locationStrategy2, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public static AgentBuilder of(EntryPoint entryPoint, ClassFileVersion classFileVersion, Plugin... pluginArr) {
            return of(entryPoint, classFileVersion, (List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        public AgentBuilder with(ClassFileLocator classFileLocator2) {
            ByteBuddy byteBuddy2 = this.byteBuddy;
            Listener listener2 = this.listener;
            CircularityLock circularityLock2 = this.circularityLock;
            PoolStrategy poolStrategy2 = this.poolStrategy;
            TypeStrategy typeStrategy2 = this.typeStrategy;
            LocationStrategy locationStrategy2 = this.locationStrategy;
            ClassFileLocator.Compound compound = r9;
            ClassFileLocator.Compound compound2 = new ClassFileLocator.Compound(this.classFileLocator, classFileLocator2);
            return new Default(byteBuddy2, listener2, circularityLock2, poolStrategy2, typeStrategy2, locationStrategy2, compound, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public static AgentBuilder of(EntryPoint entryPoint, ClassFileVersion classFileVersion, List<? extends Plugin> list) {
            AgentBuilder with = new Default(entryPoint.byteBuddy(classFileVersion)).with((TypeStrategy) new TypeStrategy.ForBuildEntryPoint(entryPoint));
            for (Plugin plugin : list) {
                with = with.type((ElementMatcher<? super TypeDescription>) plugin).transform(new Transformer.ForBuildPlugin(plugin));
            }
            return with;
        }

        public AgentBuilder with(TransformerDecorator transformerDecorator2) {
            ByteBuddy byteBuddy2 = this.byteBuddy;
            Listener listener2 = this.listener;
            CircularityLock circularityLock2 = this.circularityLock;
            PoolStrategy poolStrategy2 = this.poolStrategy;
            TypeStrategy typeStrategy2 = this.typeStrategy;
            LocationStrategy locationStrategy2 = this.locationStrategy;
            ClassFileLocator classFileLocator2 = this.classFileLocator;
            NativeMethodStrategy nativeMethodStrategy2 = this.nativeMethodStrategy;
            WarmupStrategy warmupStrategy2 = this.warmupStrategy;
            TransformerDecorator.Compound compound = r12;
            TransformerDecorator.Compound compound2 = new TransformerDecorator.Compound(this.transformerDecorator, transformerDecorator2);
            return new Default(byteBuddy2, listener2, circularityLock2, poolStrategy2, typeStrategy2, locationStrategy2, classFileLocator2, nativeMethodStrategy2, warmupStrategy2, compound, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public RedefinitionListenable.WithoutBatchStrategy with(RedefinitionStrategy redefinitionStrategy2) {
            return new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, redefinitionStrategy2, RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE, RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE, RedefinitionStrategy.Listener.NoOp.INSTANCE, RedefinitionStrategy.ResubmissionStrategy.Disabled.INSTANCE, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public AgentBuilder with(InitializationStrategy initializationStrategy2) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, initializationStrategy2, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        protected Default(ByteBuddy byteBuddy2, Listener listener2, CircularityLock circularityLock2, PoolStrategy poolStrategy2, TypeStrategy typeStrategy2, LocationStrategy locationStrategy2, ClassFileLocator classFileLocator2, NativeMethodStrategy nativeMethodStrategy2, WarmupStrategy warmupStrategy2, TransformerDecorator transformerDecorator2, InitializationStrategy initializationStrategy2, RedefinitionStrategy redefinitionStrategy2, RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, RedefinitionStrategy.BatchAllocator batchAllocator, RedefinitionStrategy.Listener listener3, RedefinitionStrategy.ResubmissionStrategy resubmissionStrategy, InjectionStrategy injectionStrategy2, LambdaInstrumentationStrategy lambdaInstrumentationStrategy2, DescriptionStrategy descriptionStrategy2, FallbackStrategy fallbackStrategy2, ClassFileBufferStrategy classFileBufferStrategy2, InstallationListener installationListener2, RawMatcher rawMatcher, List<Transformation> list) {
            this.byteBuddy = byteBuddy2;
            this.listener = listener2;
            this.circularityLock = circularityLock2;
            this.poolStrategy = poolStrategy2;
            this.typeStrategy = typeStrategy2;
            this.locationStrategy = locationStrategy2;
            this.classFileLocator = classFileLocator2;
            this.nativeMethodStrategy = nativeMethodStrategy2;
            this.warmupStrategy = warmupStrategy2;
            this.transformerDecorator = transformerDecorator2;
            this.initializationStrategy = initializationStrategy2;
            this.redefinitionStrategy = redefinitionStrategy2;
            this.redefinitionDiscoveryStrategy = discoveryStrategy;
            this.redefinitionBatchAllocator = batchAllocator;
            this.redefinitionListener = listener3;
            this.redefinitionResubmissionStrategy = resubmissionStrategy;
            this.injectionStrategy = injectionStrategy2;
            this.lambdaInstrumentationStrategy = lambdaInstrumentationStrategy2;
            this.descriptionStrategy = descriptionStrategy2;
            this.fallbackStrategy = fallbackStrategy2;
            this.classFileBufferStrategy = classFileBufferStrategy2;
            this.installationListener = installationListener2;
            this.ignoreMatcher = rawMatcher;
            this.transformations = list;
        }

        public AgentBuilder with(LambdaInstrumentationStrategy lambdaInstrumentationStrategy2) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, lambdaInstrumentationStrategy2, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public AgentBuilder with(DescriptionStrategy descriptionStrategy2) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, descriptionStrategy2, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public AgentBuilder with(FallbackStrategy fallbackStrategy2) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, fallbackStrategy2, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public AgentBuilder with(ClassFileBufferStrategy classFileBufferStrategy2) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, classFileBufferStrategy2, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public AgentBuilder with(InstallationListener installationListener2) {
            ByteBuddy byteBuddy2 = this.byteBuddy;
            Listener listener2 = this.listener;
            CircularityLock circularityLock2 = this.circularityLock;
            PoolStrategy poolStrategy2 = this.poolStrategy;
            TypeStrategy typeStrategy2 = this.typeStrategy;
            LocationStrategy locationStrategy2 = this.locationStrategy;
            ClassFileLocator classFileLocator2 = this.classFileLocator;
            NativeMethodStrategy nativeMethodStrategy2 = this.nativeMethodStrategy;
            WarmupStrategy warmupStrategy2 = this.warmupStrategy;
            TransformerDecorator transformerDecorator2 = this.transformerDecorator;
            InitializationStrategy initializationStrategy2 = this.initializationStrategy;
            RedefinitionStrategy redefinitionStrategy2 = this.redefinitionStrategy;
            RedefinitionStrategy.DiscoveryStrategy discoveryStrategy = this.redefinitionDiscoveryStrategy;
            RedefinitionStrategy.BatchAllocator batchAllocator = this.redefinitionBatchAllocator;
            RedefinitionStrategy.Listener listener3 = this.redefinitionListener;
            RedefinitionStrategy.ResubmissionStrategy resubmissionStrategy = this.redefinitionResubmissionStrategy;
            InjectionStrategy injectionStrategy2 = this.injectionStrategy;
            LambdaInstrumentationStrategy lambdaInstrumentationStrategy2 = this.lambdaInstrumentationStrategy;
            DescriptionStrategy descriptionStrategy2 = this.descriptionStrategy;
            FallbackStrategy fallbackStrategy2 = this.fallbackStrategy;
            ClassFileBufferStrategy classFileBufferStrategy2 = this.classFileBufferStrategy;
            InstallationListener.Compound compound = r1;
            ByteBuddy byteBuddy3 = byteBuddy2;
            InstallationListener.Compound compound2 = new InstallationListener.Compound(this.installationListener, installationListener2);
            return new Default(byteBuddy3, listener2, circularityLock2, poolStrategy2, typeStrategy2, locationStrategy2, classFileLocator2, nativeMethodStrategy2, warmupStrategy2, transformerDecorator2, initializationStrategy2, redefinitionStrategy2, discoveryStrategy, batchAllocator, listener3, resubmissionStrategy, injectionStrategy2, lambdaInstrumentationStrategy2, descriptionStrategy2, fallbackStrategy2, classFileBufferStrategy2, compound, this.ignoreMatcher, this.transformations);
        }

        public AgentBuilder with(InjectionStrategy injectionStrategy2) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy, injectionStrategy2, this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }
    }

    public interface DescriptionStrategy {

        public enum Default implements DescriptionStrategy {
            HYBRID(true) {
                public TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool, CircularityLock circularityLock, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    if (cls == null) {
                        return typePool.describe(str).resolve();
                    }
                    return TypeDescription.ForLoadedType.of(cls);
                }
            },
            POOL_ONLY(false) {
                public TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool, CircularityLock circularityLock, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    return typePool.describe(str).resolve();
                }
            },
            POOL_FIRST(false) {
                public TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool, CircularityLock circularityLock, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    TypePool.Resolution describe = typePool.describe(str);
                    if (describe.isResolved() || cls == null) {
                        return describe.resolve();
                    }
                    return TypeDescription.ForLoadedType.of(cls);
                }
            };
            
            private final boolean loadedFirst;

            public boolean isLoadedFirst() {
                return this.loadedFirst;
            }

            public DescriptionStrategy withSuperTypeLoading() {
                return new SuperTypeLoading(this);
            }

            private Default(boolean z10) {
                this.loadedFirst = z10;
            }

            public DescriptionStrategy withSuperTypeLoading(ExecutorService executorService) {
                return new SuperTypeLoading.Asynchronous(this, executorService);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class SuperTypeLoading implements DescriptionStrategy {
            private final DescriptionStrategy delegate;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Asynchronous implements DescriptionStrategy {
                private final DescriptionStrategy delegate;
                private final ExecutorService executorService;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class ThreadSwitchingClassLoadingDelegate implements TypeDescription.SuperTypeLoading.ClassLoadingDelegate {
                    private final ExecutorService executorService;

                    @HashCodeAndEqualsPlugin.Enhance
                    protected static class NotifyingClassLoadingAction implements Callable<Class<?>> {
                        private final ClassLoader classLoader;
                        private final String name;
                        private final AtomicBoolean signal;

                        protected NotifyingClassLoadingAction(String str, ClassLoader classLoader2, AtomicBoolean atomicBoolean) {
                            this.name = str;
                            this.classLoader = classLoader2;
                            this.signal = atomicBoolean;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            NotifyingClassLoadingAction notifyingClassLoadingAction = (NotifyingClassLoadingAction) obj;
                            return this.name.equals(notifyingClassLoadingAction.name) && this.classLoader.equals(notifyingClassLoadingAction.classLoader) && this.signal.equals(notifyingClassLoadingAction.signal);
                        }

                        public int hashCode() {
                            return (((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.classLoader.hashCode()) * 31) + this.signal.hashCode();
                        }

                        public Class<?> call() throws ClassNotFoundException {
                            Class<?> cls;
                            synchronized (this.classLoader) {
                                try {
                                    cls = Class.forName(this.name, false, this.classLoader);
                                    this.signal.set(false);
                                    this.classLoader.notifyAll();
                                } catch (Throwable th2) {
                                    this.signal.set(false);
                                    this.classLoader.notifyAll();
                                    throw th2;
                                }
                            }
                            return cls;
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    protected static class SimpleClassLoadingAction implements Callable<Class<?>> {
                        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                        @MaybeNull
                        private final ClassLoader classLoader;
                        private final String name;

                        protected SimpleClassLoadingAction(String str, @MaybeNull ClassLoader classLoader2) {
                            this.name = str;
                            this.classLoader = classLoader2;
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:20:0x0032 A[RETURN] */
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
                                java.lang.String r2 = r4.name
                                net.bytebuddy.agent.builder.AgentBuilder$DescriptionStrategy$SuperTypeLoading$Asynchronous$ThreadSwitchingClassLoadingDelegate$SimpleClassLoadingAction r5 = (net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy.SuperTypeLoading.Asynchronous.ThreadSwitchingClassLoadingDelegate.SimpleClassLoadingAction) r5
                                java.lang.String r3 = r5.name
                                boolean r2 = r2.equals(r3)
                                if (r2 != 0) goto L_0x0020
                                return r1
                            L_0x0020:
                                java.lang.ClassLoader r2 = r4.classLoader
                                java.lang.ClassLoader r5 = r5.classLoader
                                if (r5 == 0) goto L_0x002f
                                if (r2 == 0) goto L_0x0031
                                boolean r5 = r2.equals(r5)
                                if (r5 != 0) goto L_0x0032
                                return r1
                            L_0x002f:
                                if (r2 == 0) goto L_0x0032
                            L_0x0031:
                                return r1
                            L_0x0032:
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy.SuperTypeLoading.Asynchronous.ThreadSwitchingClassLoadingDelegate.SimpleClassLoadingAction.equals(java.lang.Object):boolean");
                        }

                        public int hashCode() {
                            int hashCode = ((getClass().hashCode() * 31) + this.name.hashCode()) * 31;
                            ClassLoader classLoader2 = this.classLoader;
                            return classLoader2 != null ? hashCode + classLoader2.hashCode() : hashCode;
                        }

                        public Class<?> call() throws ClassNotFoundException {
                            return Class.forName(this.name, false, this.classLoader);
                        }
                    }

                    protected ThreadSwitchingClassLoadingDelegate(ExecutorService executorService2) {
                        this.executorService = executorService2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.executorService.equals(((ThreadSwitchingClassLoadingDelegate) obj).executorService);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.executorService.hashCode();
                    }

                    public Class<?> load(String str, @MaybeNull ClassLoader classLoader) {
                        boolean z10;
                        Callable callable;
                        if (classLoader == null || !Thread.holdsLock(classLoader)) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        AtomicBoolean atomicBoolean = new AtomicBoolean(z10);
                        ExecutorService executorService2 = this.executorService;
                        if (z10) {
                            callable = new NotifyingClassLoadingAction(str, classLoader, atomicBoolean);
                        } else {
                            callable = new SimpleClassLoadingAction(str, classLoader);
                        }
                        Future submit = executorService2.submit(callable);
                        while (z10) {
                            try {
                                if (!atomicBoolean.get()) {
                                    break;
                                }
                                classLoader.wait();
                            } catch (ExecutionException e10) {
                                throw new IllegalStateException("Could not load " + str + " asynchronously", e10.getCause());
                            } catch (Exception e11) {
                                throw new IllegalStateException("Could not load " + str + " asynchronously", e11);
                            }
                        }
                        return (Class) submit.get();
                    }
                }

                public Asynchronous(DescriptionStrategy descriptionStrategy, ExecutorService executorService2) {
                    this.delegate = descriptionStrategy;
                    this.executorService = executorService2;
                }

                public TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool, CircularityLock circularityLock, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    TypeDescription apply = this.delegate.apply(str, cls, typePool, circularityLock, classLoader, javaModule);
                    if (apply instanceof TypeDescription.ForLoadedType) {
                        return apply;
                    }
                    return new TypeDescription.SuperTypeLoading(apply, classLoader, new ThreadSwitchingClassLoadingDelegate(this.executorService));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Asynchronous asynchronous = (Asynchronous) obj;
                    return this.delegate.equals(asynchronous.delegate) && this.executorService.equals(asynchronous.executorService);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.delegate.hashCode()) * 31) + this.executorService.hashCode();
                }

                public boolean isLoadedFirst() {
                    return this.delegate.isLoadedFirst();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class UnlockingClassLoadingDelegate implements TypeDescription.SuperTypeLoading.ClassLoadingDelegate {
                private final CircularityLock circularityLock;

                protected UnlockingClassLoadingDelegate(CircularityLock circularityLock2) {
                    this.circularityLock = circularityLock2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.circularityLock.equals(((UnlockingClassLoadingDelegate) obj).circularityLock);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.circularityLock.hashCode();
                }

                public Class<?> load(String str, @MaybeNull ClassLoader classLoader) throws ClassNotFoundException {
                    this.circularityLock.release();
                    try {
                        return Class.forName(str, false, classLoader);
                    } finally {
                        this.circularityLock.acquire();
                    }
                }
            }

            public SuperTypeLoading(DescriptionStrategy descriptionStrategy) {
                this.delegate = descriptionStrategy;
            }

            public TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool, CircularityLock circularityLock, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                TypeDescription apply = this.delegate.apply(str, cls, typePool, circularityLock, classLoader, javaModule);
                if (apply instanceof TypeDescription.ForLoadedType) {
                    return apply;
                }
                return new TypeDescription.SuperTypeLoading(apply, classLoader, new UnlockingClassLoadingDelegate(circularityLock));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((SuperTypeLoading) obj).delegate);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.delegate.hashCode();
            }

            public boolean isLoadedFirst() {
                return this.delegate.isLoadedFirst();
            }
        }

        TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool, CircularityLock circularityLock, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule);

        boolean isLoadedFirst();
    }

    public interface FallbackStrategy {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ByThrowableType implements FallbackStrategy {
            private final Set<? extends Class<? extends Throwable>> types;

            public ByThrowableType(Class<? extends Throwable>... clsArr) {
                this((Set<? extends Class<? extends Throwable>>) new HashSet(Arrays.asList(clsArr)));
            }

            public static FallbackStrategy ofOptionalTypes() {
                return new ByThrowableType((Class<? extends Throwable>[]) new Class[]{LinkageError.class, TypeNotPresentException.class});
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.types.equals(((ByThrowableType) obj).types);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.types.hashCode();
            }

            public boolean isFallback(Class<?> cls, Throwable th2) {
                for (Class isInstance : this.types) {
                    if (isInstance.isInstance(th2)) {
                        return true;
                    }
                }
                return false;
            }

            public ByThrowableType(Set<? extends Class<? extends Throwable>> set) {
                this.types = set;
            }
        }

        public enum Simple implements FallbackStrategy {
            ENABLED(true),
            DISABLED(false);
            
            private final boolean enabled;

            private Simple(boolean z10) {
                this.enabled = z10;
            }

            public boolean isFallback(Class<?> cls, Throwable th2) {
                return this.enabled;
            }
        }

        boolean isFallback(Class<?> cls, Throwable th2);
    }

    public interface Identified {

        public interface Extendable extends AgentBuilder, Identified {
            AgentBuilder asTerminalTransformation();
        }

        public interface Narrowable extends Matchable<Narrowable>, Identified {
        }

        Extendable transform(Transformer transformer);
    }

    public interface Ignored extends Matchable<Ignored>, AgentBuilder {
    }

    public interface InitializationStrategy {

        public interface Dispatcher {
            DynamicType.Builder<?> apply(DynamicType.Builder<?> builder);

            void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy);
        }

        public enum Minimal implements InitializationStrategy, Dispatcher {
            INSTANCE;

            public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder) {
                return builder;
            }

            public Dispatcher dispatcher() {
                return this;
            }

            public void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
                Map<TypeDescription, byte[]> auxiliaryTypes = dynamicType.getAuxiliaryTypes();
                LinkedHashMap linkedHashMap = new LinkedHashMap(auxiliaryTypes);
                for (TypeDescription next : auxiliaryTypes.keySet()) {
                    if (!next.getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) AuxiliaryType.SignatureRelevant.class)) {
                        linkedHashMap.remove(next);
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    ClassInjector resolve = injectionStrategy.resolve(classLoader, protectionDomain);
                    Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers = dynamicType.getLoadedTypeInitializers();
                    for (Map.Entry next2 : resolve.inject(linkedHashMap).entrySet()) {
                        loadedTypeInitializers.get(next2.getKey()).onLoad((Class) next2.getValue());
                    }
                }
            }
        }

        public enum NoOp implements InitializationStrategy, Dispatcher {
            INSTANCE;

            public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder) {
                return builder;
            }

            public Dispatcher dispatcher() {
                return this;
            }

            public void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class SelfInjection implements InitializationStrategy {
            protected final NexusAccessor nexusAccessor;

            @HashCodeAndEqualsPlugin.Enhance
            protected static abstract class Dispatcher implements Dispatcher {
                protected final int identification;
                protected final NexusAccessor nexusAccessor;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class InjectingInitializer implements LoadedTypeInitializer {
                    private final ClassInjector classInjector;
                    private final TypeDescription instrumentedType;
                    private final Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers;
                    private final Map<TypeDescription, byte[]> rawAuxiliaryTypes;

                    protected InjectingInitializer(TypeDescription typeDescription, Map<TypeDescription, byte[]> map, Map<TypeDescription, LoadedTypeInitializer> map2, ClassInjector classInjector2) {
                        this.instrumentedType = typeDescription;
                        this.rawAuxiliaryTypes = map;
                        this.loadedTypeInitializers = map2;
                        this.classInjector = classInjector2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        InjectingInitializer injectingInitializer = (InjectingInitializer) obj;
                        return this.instrumentedType.equals(injectingInitializer.instrumentedType) && this.rawAuxiliaryTypes.equals(injectingInitializer.rawAuxiliaryTypes) && this.loadedTypeInitializers.equals(injectingInitializer.loadedTypeInitializers) && this.classInjector.equals(injectingInitializer.classInjector);
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.rawAuxiliaryTypes.hashCode()) * 31) + this.loadedTypeInitializers.hashCode()) * 31) + this.classInjector.hashCode();
                    }

                    public boolean isAlive() {
                        return true;
                    }

                    public void onLoad(Class<?> cls) {
                        for (Map.Entry next : this.classInjector.inject(this.rawAuxiliaryTypes).entrySet()) {
                            this.loadedTypeInitializers.get(next.getKey()).onLoad((Class) next.getValue());
                        }
                        this.loadedTypeInitializers.get(this.instrumentedType).onLoad(cls);
                    }
                }

                protected Dispatcher(NexusAccessor nexusAccessor2, int i10) {
                    this.nexusAccessor = nexusAccessor2;
                    this.identification = i10;
                }

                public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder) {
                    return builder.initializer((ByteCodeAppender) new NexusAccessor.InitializationAppender(this.identification));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Dispatcher dispatcher = (Dispatcher) obj;
                    return this.identification == dispatcher.identification && this.nexusAccessor.equals(dispatcher.nexusAccessor);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.nexusAccessor.hashCode()) * 31) + this.identification;
                }
            }

            public static class Eager extends SelfInjection {

                protected static class Dispatcher extends Dispatcher {
                    protected Dispatcher(NexusAccessor nexusAccessor, int i10) {
                        super(nexusAccessor, i10);
                    }

                    public void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
                        Map<TypeDescription, byte[]> auxiliaryTypes = dynamicType.getAuxiliaryTypes();
                        Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers = dynamicType.getLoadedTypeInitializers();
                        if (!auxiliaryTypes.isEmpty()) {
                            for (Map.Entry next : injectionStrategy.resolve(classLoader, protectionDomain).inject(auxiliaryTypes).entrySet()) {
                                loadedTypeInitializers.get(next.getKey()).onLoad((Class) next.getValue());
                            }
                        }
                        this.nexusAccessor.register(dynamicType.getTypeDescription().getName(), classLoader, this.identification, loadedTypeInitializers.get(dynamicType.getTypeDescription()));
                    }
                }

                public Eager() {
                    this(new NexusAccessor());
                }

                /* access modifiers changed from: protected */
                public Dispatcher dispatcher(int i10) {
                    return new Dispatcher(this.nexusAccessor, i10);
                }

                public Eager(NexusAccessor nexusAccessor) {
                    super(nexusAccessor);
                }
            }

            public static class Lazy extends SelfInjection {

                protected static class Dispatcher extends Dispatcher {
                    protected Dispatcher(NexusAccessor nexusAccessor, int i10) {
                        super(nexusAccessor, i10);
                    }

                    public void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
                        LoadedTypeInitializer loadedTypeInitializer;
                        Map<TypeDescription, byte[]> auxiliaryTypes = dynamicType.getAuxiliaryTypes();
                        if (auxiliaryTypes.isEmpty()) {
                            loadedTypeInitializer = dynamicType.getLoadedTypeInitializers().get(dynamicType.getTypeDescription());
                        } else {
                            loadedTypeInitializer = new Dispatcher.InjectingInitializer(dynamicType.getTypeDescription(), auxiliaryTypes, dynamicType.getLoadedTypeInitializers(), injectionStrategy.resolve(classLoader, protectionDomain));
                        }
                        this.nexusAccessor.register(dynamicType.getTypeDescription().getName(), classLoader, this.identification, loadedTypeInitializer);
                    }
                }

                public Lazy() {
                    this(new NexusAccessor());
                }

                /* access modifiers changed from: protected */
                public Dispatcher dispatcher(int i10) {
                    return new Dispatcher(this.nexusAccessor, i10);
                }

                public Lazy(NexusAccessor nexusAccessor) {
                    super(nexusAccessor);
                }
            }

            public static class Split extends SelfInjection {

                protected static class Dispatcher extends Dispatcher {
                    protected Dispatcher(NexusAccessor nexusAccessor, int i10) {
                        super(nexusAccessor, i10);
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: net.bytebuddy.implementation.LoadedTypeInitializer} */
                    /* JADX WARNING: Multi-variable type inference failed */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void register(net.bytebuddy.dynamic.DynamicType r7, @net.bytebuddy.utility.nullability.MaybeNull java.lang.ClassLoader r8, @net.bytebuddy.utility.nullability.MaybeNull java.security.ProtectionDomain r9, net.bytebuddy.agent.builder.AgentBuilder.InjectionStrategy r10) {
                        /*
                            r6 = this;
                            java.util.Map r0 = r7.getAuxiliaryTypes()
                            boolean r1 = r0.isEmpty()
                            if (r1 != 0) goto L_0x009e
                            net.bytebuddy.description.type.TypeDescription r1 = r7.getTypeDescription()
                            net.bytebuddy.dynamic.loading.ClassInjector r9 = r10.resolve(r8, r9)
                            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
                            r10.<init>(r0)
                            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
                            r2.<init>(r0)
                            java.util.Set r0 = r0.keySet()
                            java.util.Iterator r0 = r0.iterator()
                        L_0x0024:
                            boolean r3 = r0.hasNext()
                            if (r3 == 0) goto L_0x0043
                            java.lang.Object r3 = r0.next()
                            net.bytebuddy.description.type.TypeDescription r3 = (net.bytebuddy.description.type.TypeDescription) r3
                            net.bytebuddy.description.annotation.AnnotationList r4 = r3.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.implementation.auxiliary.AuxiliaryType$SignatureRelevant> r5 = net.bytebuddy.implementation.auxiliary.AuxiliaryType.SignatureRelevant.class
                            boolean r4 = r4.isAnnotationPresent((java.lang.Class<? extends java.lang.annotation.Annotation>) r5)
                            if (r4 == 0) goto L_0x003e
                            r4 = r2
                            goto L_0x003f
                        L_0x003e:
                            r4 = r10
                        L_0x003f:
                            r4.remove(r3)
                            goto L_0x0024
                        L_0x0043:
                            java.util.Map r0 = r7.getLoadedTypeInitializers()
                            boolean r3 = r10.isEmpty()
                            if (r3 != 0) goto L_0x0079
                            java.util.Map r3 = r9.inject(r10)
                            java.util.Set r3 = r3.entrySet()
                            java.util.Iterator r3 = r3.iterator()
                        L_0x0059:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x0079
                            java.lang.Object r4 = r3.next()
                            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                            java.lang.Object r5 = r4.getKey()
                            java.lang.Object r5 = r0.get(r5)
                            net.bytebuddy.implementation.LoadedTypeInitializer r5 = (net.bytebuddy.implementation.LoadedTypeInitializer) r5
                            java.lang.Object r4 = r4.getValue()
                            java.lang.Class r4 = (java.lang.Class) r4
                            r5.onLoad(r4)
                            goto L_0x0059
                        L_0x0079:
                            java.util.HashMap r3 = new java.util.HashMap
                            r3.<init>(r0)
                            java.util.Set r0 = r0.keySet()
                            java.util.Set r10 = r10.keySet()
                            r0.removeAll(r10)
                            int r10 = r3.size()
                            r0 = 1
                            if (r10 <= r0) goto L_0x0096
                            net.bytebuddy.agent.builder.AgentBuilder$InitializationStrategy$SelfInjection$Dispatcher$InjectingInitializer r10 = new net.bytebuddy.agent.builder.AgentBuilder$InitializationStrategy$SelfInjection$Dispatcher$InjectingInitializer
                            r10.<init>(r1, r2, r3, r9)
                            goto L_0x00ad
                        L_0x0096:
                            java.lang.Object r9 = r3.get(r1)
                            r10 = r9
                            net.bytebuddy.implementation.LoadedTypeInitializer r10 = (net.bytebuddy.implementation.LoadedTypeInitializer) r10
                            goto L_0x00ad
                        L_0x009e:
                            java.util.Map r9 = r7.getLoadedTypeInitializers()
                            net.bytebuddy.description.type.TypeDescription r10 = r7.getTypeDescription()
                            java.lang.Object r9 = r9.get(r10)
                            r10 = r9
                            net.bytebuddy.implementation.LoadedTypeInitializer r10 = (net.bytebuddy.implementation.LoadedTypeInitializer) r10
                        L_0x00ad:
                            net.bytebuddy.dynamic.NexusAccessor r9 = r6.nexusAccessor
                            net.bytebuddy.description.type.TypeDescription r7 = r7.getTypeDescription()
                            java.lang.String r7 = r7.getName()
                            int r0 = r6.identification
                            r9.register(r7, r8, r0, r10)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split.Dispatcher.register(net.bytebuddy.dynamic.DynamicType, java.lang.ClassLoader, java.security.ProtectionDomain, net.bytebuddy.agent.builder.AgentBuilder$InjectionStrategy):void");
                    }
                }

                public Split() {
                    this(new NexusAccessor());
                }

                /* access modifiers changed from: protected */
                public Dispatcher dispatcher(int i10) {
                    return new Dispatcher(this.nexusAccessor, i10);
                }

                public Split(NexusAccessor nexusAccessor) {
                    super(nexusAccessor);
                }
            }

            protected SelfInjection(NexusAccessor nexusAccessor2) {
                this.nexusAccessor = nexusAccessor2;
            }

            @SuppressFBWarnings(justification = "Avoids thread-contention.", value = {"DMI_RANDOM_USED_ONLY_ONCE"})
            public Dispatcher dispatcher() {
                return dispatcher(new Random().nextInt());
            }

            /* access modifiers changed from: protected */
            public abstract Dispatcher dispatcher(int i10);

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.nexusAccessor.equals(((SelfInjection) obj).nexusAccessor);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.nexusAccessor.hashCode();
            }
        }

        Dispatcher dispatcher();
    }

    public interface InjectionStrategy {

        public enum Disabled implements InjectionStrategy {
            INSTANCE;

            public ClassInjector resolve(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
                throw new IllegalStateException("Class injection is disabled");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class UsingInstrumentation implements InjectionStrategy {
            private final File folder;
            private final Instrumentation instrumentation;

            public UsingInstrumentation(Instrumentation instrumentation2, File file) {
                this.instrumentation = instrumentation2;
                this.folder = file;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UsingInstrumentation usingInstrumentation = (UsingInstrumentation) obj;
                return this.instrumentation.equals(usingInstrumentation.instrumentation) && this.folder.equals(usingInstrumentation.folder);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + this.folder.hashCode();
            }

            public ClassInjector resolve(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
                if (classLoader == null) {
                    return ClassInjector.UsingInstrumentation.of(this.folder, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, this.instrumentation);
                }
                return UsingReflection.INSTANCE.resolve(classLoader, protectionDomain);
            }
        }

        public enum UsingJna implements InjectionStrategy {
            INSTANCE;

            public ClassInjector resolve(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
                if (ClassInjector.UsingJna.isAvailable()) {
                    return new ClassInjector.UsingJna(classLoader, protectionDomain);
                }
                throw new IllegalStateException("JNA-based injection is not available on the current VM");
            }
        }

        public enum UsingReflection implements InjectionStrategy {
            INSTANCE;

            public ClassInjector resolve(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
                if (classLoader == null) {
                    throw new IllegalStateException("Cannot inject auxiliary class into bootstrap loader using reflection");
                } else if (ClassInjector.UsingReflection.isAvailable()) {
                    return new ClassInjector.UsingReflection(classLoader, protectionDomain);
                } else {
                    throw new IllegalStateException("Reflection-based injection is not available on the current VM");
                }
            }
        }

        public enum UsingUnsafe implements InjectionStrategy {
            INSTANCE;

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfFactory implements InjectionStrategy {
                private final ClassInjector.UsingUnsafe.Factory factory;

                public OfFactory(ClassInjector.UsingUnsafe.Factory factory2) {
                    this.factory = factory2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.factory.equals(((OfFactory) obj).factory);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.factory.hashCode();
                }

                public ClassInjector resolve(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
                    return this.factory.make(classLoader, protectionDomain);
                }
            }

            public ClassInjector resolve(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
                if (ClassInjector.UsingUnsafe.isAvailable()) {
                    return new ClassInjector.UsingUnsafe(classLoader, protectionDomain);
                }
                throw new IllegalStateException("Unsafe-based injection is not available on the current VM");
            }
        }

        ClassInjector resolve(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain);
    }

    public interface InstallationListener {
        @AlwaysNull
        public static final Throwable SUPPRESS_ERROR = null;

        public static abstract class Adapter implements InstallationListener {
            public void onAfterWarmUp(Map<Class<?>, byte[]> map, ResettableClassFileTransformer resettableClassFileTransformer, boolean z10) {
            }

            public void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                return th2;
            }

            public void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements InstallationListener {
            private final List<InstallationListener> installationListeners;

            public Compound(InstallationListener... installationListenerArr) {
                this((List<? extends InstallationListener>) Arrays.asList(installationListenerArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.installationListeners.equals(((Compound) obj).installationListeners);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.installationListeners.hashCode();
            }

            public void onAfterWarmUp(Map<Class<?>, byte[]> map, ResettableClassFileTransformer resettableClassFileTransformer, boolean z10) {
                for (InstallationListener onAfterWarmUp : this.installationListeners) {
                    onAfterWarmUp.onAfterWarmUp(map, resettableClassFileTransformer, z10);
                }
            }

            public void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                for (InstallationListener onBeforeInstall : this.installationListeners) {
                    onBeforeInstall.onBeforeInstall(instrumentation, resettableClassFileTransformer);
                }
            }

            public void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer) {
                for (InstallationListener onBeforeWarmUp : this.installationListeners) {
                    onBeforeWarmUp.onBeforeWarmUp(set, resettableClassFileTransformer);
                }
            }

            @MaybeNull
            public Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                for (InstallationListener next : this.installationListeners) {
                    Throwable th3 = InstallationListener.SUPPRESS_ERROR;
                    if (th2 == th3) {
                        return th3;
                    }
                    th2 = next.onError(instrumentation, resettableClassFileTransformer, th2);
                }
                return th2;
            }

            public void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                for (InstallationListener onInstall : this.installationListeners) {
                    onInstall.onInstall(instrumentation, resettableClassFileTransformer);
                }
            }

            public void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                for (InstallationListener onReset : this.installationListeners) {
                    onReset.onReset(instrumentation, resettableClassFileTransformer);
                }
            }

            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                for (InstallationListener onWarmUpError : this.installationListeners) {
                    onWarmUpError.onWarmUpError(cls, resettableClassFileTransformer, th2);
                }
            }

            public Compound(List<? extends InstallationListener> list) {
                this.installationListeners = new ArrayList();
                for (InstallationListener installationListener : list) {
                    if (installationListener instanceof Compound) {
                        this.installationListeners.addAll(((Compound) installationListener).installationListeners);
                    } else if (!(installationListener instanceof NoOp)) {
                        this.installationListeners.add(installationListener);
                    }
                }
            }
        }

        public enum ErrorSuppressing implements InstallationListener {
            INSTANCE;

            public void onAfterWarmUp(Map<Class<?>, byte[]> map, ResettableClassFileTransformer resettableClassFileTransformer, boolean z10) {
            }

            public void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @MaybeNull
            public Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                return InstallationListener.SUPPRESS_ERROR;
            }

            public void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
            }
        }

        public enum NoOp implements InstallationListener {
            INSTANCE;

            public void onAfterWarmUp(Map<Class<?>, byte[]> map, ResettableClassFileTransformer resettableClassFileTransformer, boolean z10) {
            }

            public void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                return th2;
            }

            public void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class StreamWriting implements InstallationListener {
            protected static final String PREFIX = "[Byte Buddy]";
            private final PrintStream printStream;

            public StreamWriting(PrintStream printStream2) {
                this.printStream = printStream2;
            }

            public static InstallationListener toSystemError() {
                return new StreamWriting(System.err);
            }

            public static InstallationListener toSystemOut() {
                return new StreamWriting(System.out);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.printStream.equals(((StreamWriting) obj).printStream);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.printStream.hashCode();
            }

            public void onAfterWarmUp(Map<Class<?>, byte[]> map, ResettableClassFileTransformer resettableClassFileTransformer, boolean z10) {
                PrintStream printStream2 = this.printStream;
                Object[] objArr = new Object[3];
                objArr[0] = z10 ? "transformed" : "not transformed";
                objArr[1] = resettableClassFileTransformer;
                objArr[2] = map.keySet();
                printStream2.printf("[Byte Buddy] AFTER_WARMUP %s %s on %s%n", objArr);
            }

            public void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] BEFORE_INSTALL %s on %s%n", new Object[]{resettableClassFileTransformer, instrumentation});
            }

            public void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] BEFORE_WARMUP %s on %s%n", new Object[]{resettableClassFileTransformer, set});
            }

            public Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                synchronized (this.printStream) {
                    this.printStream.printf("[Byte Buddy] ERROR %s on %s%n", new Object[]{resettableClassFileTransformer, instrumentation});
                    th2.printStackTrace(this.printStream);
                }
                return th2;
            }

            public void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] INSTALL %s on %s%n", new Object[]{resettableClassFileTransformer, instrumentation});
            }

            public void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] RESET %s on %s%n", new Object[]{resettableClassFileTransformer, instrumentation});
            }

            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                synchronized (this.printStream) {
                    this.printStream.printf("[Byte Buddy] ERROR_WARMUP %s on %s%n", new Object[]{resettableClassFileTransformer, cls});
                    th2.printStackTrace(this.printStream);
                }
            }
        }

        void onAfterWarmUp(Map<Class<?>, byte[]> map, ResettableClassFileTransformer resettableClassFileTransformer, boolean z10);

        void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer);

        void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer);

        @MaybeNull
        Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2);

        void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer);

        void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer);

        void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2);
    }

    public enum LambdaInstrumentationStrategy {
        ENABLED {
            /* access modifiers changed from: protected */
            public void apply(ByteBuddy byteBuddy, Instrumentation instrumentation, ClassFileTransformer classFileTransformer) {
                if (LambdaFactory.register(classFileTransformer, new LambdaInstanceFactory(byteBuddy))) {
                    try {
                        Class<?> cls = Class.forName("java.lang.invoke.LambdaMetafactory");
                        byteBuddy.with((Implementation.Context.Factory) Implementation.Context.Disabled.Factory.INSTANCE).redefine(cls).method(ElementMatchers.isPublic().and(ElementMatchers.named("metafactory"))).intercept(new Implementation.Simple(LambdaMetafactoryFactory.REGULAR)).method(ElementMatchers.isPublic().and(ElementMatchers.named("altMetafactory"))).intercept(new Implementation.Simple(LambdaMetafactoryFactory.ALTERNATIVE)).make().load(cls.getClassLoader(), ClassReloadingStrategy.of(instrumentation));
                    } catch (ClassNotFoundException unused) {
                    }
                }
            }

            /* access modifiers changed from: protected */
            public boolean isInstrumented(@MaybeNull Class<?> cls) {
                return true;
            }
        },
        DISABLED {
            /* access modifiers changed from: protected */
            public void apply(ByteBuddy byteBuddy, Instrumentation instrumentation, ClassFileTransformer classFileTransformer) {
            }

            /* access modifiers changed from: protected */
            public boolean isInstrumented(@MaybeNull Class<?> cls) {
                return cls == null || !cls.getName().contains(RemoteSettings.FORWARD_SLASH_STRING);
            }
        };

        @HashCodeAndEqualsPlugin.Enhance
        protected static class LambdaInstanceFactory {
            private static final String FIELD_PREFIX = "arg$";
            private static final String LAMBDA_FACTORY = "get$Lambda";
            private static final AtomicInteger LAMBDA_NAME_COUNTER = null;
            private static final String LAMBDA_TYPE_INFIX = "$$Lambda$ByteBuddy$";
            @AlwaysNull
            private static final Class<?> NOT_PREVIOUSLY_DEFINED = null;
            private final ByteBuddy byteBuddy;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class BridgeMethodImplementation implements Implementation {
                private final JavaConstant.MethodType lambdaMethod;
                private final String lambdaMethodName;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class Appender implements ByteCodeAppender {
                    private final Implementation.SpecialMethodInvocation bridgeTargetInvocation;

                    protected Appender(Implementation.SpecialMethodInvocation specialMethodInvocation) {
                        this.bridgeTargetInvocation = specialMethodInvocation;
                    }

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        StackManipulation stackManipulation;
                        ByteCodeAppender[] byteCodeAppenderArr = new ByteCodeAppender[1];
                        StackManipulation[] stackManipulationArr = new StackManipulation[4];
                        stackManipulationArr[0] = MethodVariableAccess.allArgumentsOf(methodDescription).asBridgeOf(this.bridgeTargetInvocation.getMethodDescription()).prependThisReference();
                        Implementation.SpecialMethodInvocation specialMethodInvocation = this.bridgeTargetInvocation;
                        stackManipulationArr[1] = specialMethodInvocation;
                        if (specialMethodInvocation.getMethodDescription().getReturnType().asErasure().isAssignableTo(methodDescription.getReturnType().asErasure())) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = TypeCasting.to(methodDescription.getReturnType());
                        }
                        stackManipulationArr[2] = stackManipulation;
                        stackManipulationArr[3] = MethodReturn.of(methodDescription.getReturnType());
                        byteCodeAppenderArr[0] = new ByteCodeAppender.Simple(stackManipulationArr);
                        return new ByteCodeAppender.Compound(byteCodeAppenderArr).apply(methodVisitor, context, methodDescription);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.bridgeTargetInvocation.equals(((Appender) obj).bridgeTargetInvocation);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.bridgeTargetInvocation.hashCode();
                    }
                }

                protected BridgeMethodImplementation(String str, JavaConstant.MethodType methodType) {
                    this.lambdaMethodName = str;
                    this.lambdaMethod = methodType;
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender(target.invokeSuper(new MethodDescription.SignatureToken(this.lambdaMethodName, this.lambdaMethod.getReturnType(), (List<? extends TypeDescription>) this.lambdaMethod.getParameterTypes())));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    BridgeMethodImplementation bridgeMethodImplementation = (BridgeMethodImplementation) obj;
                    return this.lambdaMethodName.equals(bridgeMethodImplementation.lambdaMethodName) && this.lambdaMethod.equals(bridgeMethodImplementation.lambdaMethod);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.lambdaMethodName.hashCode()) * 31) + this.lambdaMethod.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            protected enum ConstructorImplementation implements Implementation {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public final transient MethodDescription.InDefinedShape objectConstructor;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class Appender implements ByteCodeAppender {
                    private final List<FieldDescription.InDefinedShape> declaredFields;

                    protected Appender(List<FieldDescription.InDefinedShape> list) {
                        this.declaredFields = list;
                    }

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        ArrayList arrayList = new ArrayList(this.declaredFields.size() * 3);
                        Iterator<E> it = methodDescription.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            arrayList.add(MethodVariableAccess.loadThis());
                            arrayList.add(MethodVariableAccess.load(parameterDescription));
                            arrayList.add(FieldAccess.forField(this.declaredFields.get(parameterDescription.getIndex())).write());
                        }
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodInvocation.invoke(ConstructorImplementation.INSTANCE.objectConstructor), new StackManipulation.Compound((List<? extends StackManipulation>) arrayList), MethodReturn.VOID).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.declaredFields.equals(((Appender) obj).declaredFields);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.declaredFields.hashCode();
                    }
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender(target.getInstrumentedType().getDeclaredFields());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            protected enum FactoryImplementation implements Implementation {
                INSTANCE;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class Appender implements ByteCodeAppender {
                    private final TypeDescription instrumentedType;

                    protected Appender(TypeDescription typeDescription) {
                        this.instrumentedType = typeDescription;
                    }

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(TypeCreation.of(this.instrumentedType), Duplication.SINGLE, MethodVariableAccess.allArgumentsOf(methodDescription), MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) this.instrumentedType.getDeclaredMethods().filter(ElementMatchers.isConstructor())).getOnly()), MethodReturn.REFERENCE).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
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

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class LambdaMethodImplementation implements Implementation {
                private final JavaConstant.MethodType specializedLambdaMethod;
                private final JavaConstant.MethodHandle targetMethod;
                private final TypeDescription targetType;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class Appender implements ByteCodeAppender {
                    private static final Dispatcher LOOKUP_DATA_DISPATCHER = null;
                    private final List<FieldDescription.InDefinedShape> declaredFields;
                    private final Dispatcher dispatcher;
                    private final JavaConstant.MethodType specializedLambdaMethod;
                    private final MethodDescription targetMethod;

                    protected interface Dispatcher {

                        public enum UsingDirectInvocation implements Dispatcher {
                            INSTANCE;

                            public StackManipulation initialize() {
                                return StackManipulation.Trivial.INSTANCE;
                            }

                            public StackManipulation invoke(MethodDescription methodDescription) {
                                return MethodInvocation.invoke(methodDescription);
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class UsingMethodHandle extends StackManipulation.AbstractBase implements Dispatcher {
                            private final MethodDescription.InDefinedShape invokeExact;

                            protected UsingMethodHandle(MethodDescription.InDefinedShape inDefinedShape) {
                                this.invokeExact = inDefinedShape;
                            }

                            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                                methodVisitor.visitLdcInsn(new ConstantDynamic(JavaConstant.Dynamic.DEFAULT_NAME, "Ljava/lang/invoke/MethodHandle;", new Handle(6, "java/lang/invoke/MethodHandles", "classData", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", false), new Object[0]));
                                return new StackManipulation.Size(1, 1);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.invokeExact.equals(((UsingMethodHandle) obj).invokeExact);
                            }

                            public int hashCode() {
                                return (getClass().hashCode() * 31) + this.invokeExact.hashCode();
                            }

                            public StackManipulation initialize() {
                                return this;
                            }

                            public StackManipulation invoke(MethodDescription methodDescription) {
                                return MethodInvocation.invoke(this.invokeExact);
                            }
                        }

                        StackManipulation initialize();

                        StackManipulation invoke(MethodDescription methodDescription);
                    }

                    static {
                        LOOKUP_DATA_DISPATCHER = dispatcher();
                    }

                    protected Appender(MethodDescription methodDescription, JavaConstant.MethodType methodType, List<FieldDescription.InDefinedShape> list, Dispatcher dispatcher2) {
                        this.targetMethod = methodDescription;
                        this.specializedLambdaMethod = methodType;
                        this.declaredFields = list;
                        this.dispatcher = dispatcher2;
                    }

                    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
                    private static Dispatcher dispatcher() {
                        try {
                            Class<?> cls = Class.forName("java.lang.invoke.MethodHandles$Lookup", false, (ClassLoader) null);
                            cls.getMethod("classData", new Class[]{cls, String.class, Class.class});
                            return new Dispatcher.UsingMethodHandle(new MethodDescription.ForLoadedMethod(Class.forName("java.lang.invoke.MethodHandle", false, (ClassLoader) null).getMethod("invokeExact", new Class[]{Object[].class})));
                        } catch (Exception unused) {
                            return Dispatcher.UsingDirectInvocation.INSTANCE;
                        }
                    }

                    protected static ByteCodeAppender of(MethodDescription methodDescription, JavaConstant.MethodType methodType, List<FieldDescription.InDefinedShape> list, JavaConstant.MethodHandle.HandleType handleType, TypeDescription typeDescription) {
                        Dispatcher dispatcher2;
                        if (handleType == JavaConstant.MethodHandle.HandleType.INVOKE_SPECIAL || !methodDescription.getDeclaringType().asErasure().isVisibleTo(typeDescription)) {
                            dispatcher2 = LOOKUP_DATA_DISPATCHER;
                        } else {
                            dispatcher2 = Dispatcher.UsingDirectInvocation.INSTANCE;
                        }
                        return new Appender(methodDescription, methodType, list, dispatcher2);
                    }

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        StackManipulation stackManipulation;
                        TypeDescription.Generic generic;
                        ArrayList arrayList = new ArrayList((this.declaredFields.size() * 2) + 1);
                        for (FieldDescription.InDefinedShape forField : this.declaredFields) {
                            arrayList.add(MethodVariableAccess.loadThis());
                            arrayList.add(FieldAccess.forField(forField).read());
                        }
                        ArrayList arrayList2 = new ArrayList(methodDescription.getParameters().size() * 2);
                        Iterator<E> it = methodDescription.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            arrayList2.add(MethodVariableAccess.load(parameterDescription));
                            arrayList2.add(Assigner.DEFAULT.assign(parameterDescription.getType(), ((TypeDescription) this.specializedLambdaMethod.getParameterTypes().get(parameterDescription.getIndex())).asGenericType(), Assigner.Typing.DYNAMIC));
                        }
                        StackManipulation[] stackManipulationArr = new StackManipulation[7];
                        if (this.targetMethod.isConstructor()) {
                            stackManipulation = new StackManipulation.Compound(TypeCreation.of(this.targetMethod.getDeclaringType().asErasure()), Duplication.SINGLE);
                        } else {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        }
                        stackManipulationArr[0] = stackManipulation;
                        stackManipulationArr[1] = this.dispatcher.initialize();
                        stackManipulationArr[2] = new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
                        stackManipulationArr[3] = new StackManipulation.Compound((List<? extends StackManipulation>) arrayList2);
                        stackManipulationArr[4] = this.dispatcher.invoke(this.targetMethod);
                        Assigner assigner = Assigner.DEFAULT;
                        if (this.targetMethod.isConstructor()) {
                            generic = this.targetMethod.getDeclaringType().asGenericType();
                        } else {
                            generic = this.targetMethod.getReturnType();
                        }
                        stackManipulationArr[5] = assigner.assign(generic, this.specializedLambdaMethod.getReturnType().asGenericType(), Assigner.Typing.DYNAMIC);
                        stackManipulationArr[6] = MethodReturn.of(this.specializedLambdaMethod.getReturnType());
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulationArr).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Appender appender = (Appender) obj;
                        return this.targetMethod.equals(appender.targetMethod) && this.specializedLambdaMethod.equals(appender.specializedLambdaMethod) && this.declaredFields.equals(appender.declaredFields) && this.dispatcher.equals(appender.dispatcher);
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.targetMethod.hashCode()) * 31) + this.specializedLambdaMethod.hashCode()) * 31) + this.declaredFields.hashCode()) * 31) + this.dispatcher.hashCode();
                    }
                }

                protected LambdaMethodImplementation(TypeDescription typeDescription, JavaConstant.MethodHandle methodHandle, JavaConstant.MethodType methodType) {
                    this.targetType = typeDescription;
                    this.targetMethod = methodHandle;
                    this.specializedLambdaMethod = methodType;
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    return Appender.of((MethodDescription) ((MethodList) this.targetMethod.getOwnerType().getDeclaredMethods().filter(ElementMatchers.hasMethodName(this.targetMethod.getName()).and(ElementMatchers.returns(this.targetMethod.getReturnType())).and(ElementMatchers.takesArguments((Iterable<? extends TypeDescription>) this.targetMethod.getParameterTypes())))).getOnly(), this.specializedLambdaMethod, target.getInstrumentedType().getDeclaredFields(), this.targetMethod.getHandleType(), this.targetType);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    LambdaMethodImplementation lambdaMethodImplementation = (LambdaMethodImplementation) obj;
                    return this.targetType.equals(lambdaMethodImplementation.targetType) && this.targetMethod.equals(lambdaMethodImplementation.targetMethod) && this.specializedLambdaMethod.equals(lambdaMethodImplementation.specializedLambdaMethod);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31) + this.targetMethod.hashCode()) * 31) + this.specializedLambdaMethod.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class SerializationImplementation implements Implementation {
                private final JavaConstant.MethodType lambdaMethod;
                private final String lambdaMethodName;
                private final TypeDescription lambdaType;
                private final JavaConstant.MethodType specializedMethod;
                private final JavaConstant.MethodHandle targetMethod;
                private final TypeDescription targetType;

                protected SerializationImplementation(TypeDescription typeDescription, TypeDescription typeDescription2, String str, JavaConstant.MethodType methodType, JavaConstant.MethodHandle methodHandle, JavaConstant.MethodType methodType2) {
                    this.targetType = typeDescription;
                    this.lambdaType = typeDescription2;
                    this.lambdaMethodName = str;
                    this.lambdaMethod = methodType;
                    this.targetMethod = methodHandle;
                    this.specializedMethod = methodType2;
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    Class<Object> cls = Object.class;
                    try {
                        TypeDescription of2 = TypeDescription.ForLoadedType.of(Class.forName("java.lang.invoke.SerializedLambda"));
                        ArrayList arrayList = new ArrayList(target.getInstrumentedType().getDeclaredFields().size());
                        for (FieldDescription.InDefinedShape inDefinedShape : target.getInstrumentedType().getDeclaredFields()) {
                            arrayList.add(new StackManipulation.Compound(MethodVariableAccess.loadThis(), FieldAccess.forField(inDefinedShape).read(), Assigner.DEFAULT.assign(inDefinedShape.getType(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(cls), Assigner.Typing.STATIC)));
                        }
                        return new ByteCodeAppender.Simple(new StackManipulation.Compound(TypeCreation.of(of2), Duplication.SINGLE, ClassConstant.of(this.targetType), new TextConstant(this.lambdaType.getInternalName()), new TextConstant(this.lambdaMethodName), new TextConstant(this.lambdaMethod.getDescriptor()), IntegerConstant.forValue(this.targetMethod.getHandleType().getIdentifier()), new TextConstant(this.targetMethod.getOwnerType().getInternalName()), new TextConstant(this.targetMethod.getName()), new TextConstant(this.targetMethod.getDescriptor()), new TextConstant(this.specializedMethod.getDescriptor()), ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(cls)).withValues(arrayList), MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) of2.getDeclaredMethods().filter(ElementMatchers.isConstructor())).getOnly()), MethodReturn.REFERENCE));
                    } catch (ClassNotFoundException e10) {
                        throw new IllegalStateException("Cannot find class for lambda serialization", e10);
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    SerializationImplementation serializationImplementation = (SerializationImplementation) obj;
                    return this.lambdaMethodName.equals(serializationImplementation.lambdaMethodName) && this.targetType.equals(serializationImplementation.targetType) && this.lambdaType.equals(serializationImplementation.lambdaType) && this.lambdaMethod.equals(serializationImplementation.lambdaMethod) && this.targetMethod.equals(serializationImplementation.targetMethod) && this.specializedMethod.equals(serializationImplementation.specializedMethod);
                }

                public int hashCode() {
                    return (((((((((((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31) + this.lambdaType.hashCode()) * 31) + this.lambdaMethodName.hashCode()) * 31) + this.lambdaMethod.hashCode()) * 31) + this.targetMethod.hashCode()) * 31) + this.specializedMethod.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            static {
                LAMBDA_NAME_COUNTER = new AtomicInteger();
            }

            protected LambdaInstanceFactory(ByteBuddy byteBuddy2) {
                this.byteBuddy = byteBuddy2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.byteBuddy.equals(((LambdaInstanceFactory) obj).byteBuddy);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.byteBuddy.hashCode();
            }

            public byte[] make(Object obj, String str, Object obj2, Object obj3, Object obj4, Object obj5, boolean z10, List<Class<?>> list, List<?> list2, Collection<? extends ClassFileTransformer> collection) {
                char c10;
                String str2 = str;
                List<Class<?>> list3 = list;
                JavaConstant.MethodType ofLoaded = JavaConstant.MethodType.ofLoaded(obj2);
                JavaConstant.MethodType ofLoaded2 = JavaConstant.MethodType.ofLoaded(obj3);
                JavaConstant.MethodHandle ofLoaded3 = JavaConstant.MethodHandle.ofLoaded(obj4, obj);
                JavaConstant.MethodType ofLoaded4 = JavaConstant.MethodType.ofLoaded(obj5);
                Class<?> lookupType = JavaConstant.MethodHandle.lookupType(obj);
                String str3 = lookupType.getName() + LAMBDA_TYPE_INFIX + LAMBDA_NAME_COUNTER.incrementAndGet();
                DynamicType.Builder<?> subclass = this.byteBuddy.subclass((TypeDefinition) ofLoaded.getReturnType(), (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS);
                boolean z11 = false;
                Visibility visibility = Visibility.PUBLIC;
                DynamicType.Builder intercept = subclass.modifiers(TypeManifestation.FINAL, visibility).implement((List<? extends Type>) list3).name(str3).defineConstructor(visibility).withParameters((Collection<? extends TypeDefinition>) ofLoaded.getParameterTypes()).intercept(ConstructorImplementation.INSTANCE).method(ElementMatchers.named(str).and(ElementMatchers.takesArguments((Iterable<? extends TypeDescription>) ofLoaded2.getParameterTypes())).and(ElementMatchers.returns(ofLoaded2.getReturnType()))).intercept(new LambdaMethodImplementation(TypeDescription.ForLoadedType.of(lookupType), ofLoaded3, ofLoaded4));
                int i10 = 0;
                for (TypeDescription defineField : ofLoaded.getParameterTypes()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(FIELD_PREFIX);
                    i10++;
                    sb2.append(i10);
                    intercept = intercept.defineField(sb2.toString(), (TypeDefinition) defineField, Visibility.PRIVATE, FieldManifestation.FINAL);
                    z11 = false;
                }
                char c11 = z11;
                if (!ofLoaded.getParameterTypes().isEmpty()) {
                    TypeDescription returnType = ofLoaded.getReturnType();
                    ModifierContributor.ForMethod[] forMethodArr = new ModifierContributor.ForMethod[2];
                    forMethodArr[c11] = Visibility.PRIVATE;
                    forMethodArr[1] = Ownership.STATIC;
                    intercept = intercept.defineMethod(LAMBDA_FACTORY, (TypeDefinition) returnType, forMethodArr).withParameters((Collection<? extends TypeDefinition>) ofLoaded.getParameterTypes()).intercept(FactoryImplementation.INSTANCE);
                }
                if (z10) {
                    if (!list3.contains(Serializable.class)) {
                        c10 = 0;
                        intercept = intercept.implement(Serializable.class);
                    } else {
                        c10 = 0;
                    }
                    ModifierContributor.ForMethod[] forMethodArr2 = new ModifierContributor.ForMethod[1];
                    forMethodArr2[c10] = Visibility.PRIVATE;
                    intercept = intercept.defineMethod("writeReplace", (Type) Object.class, forMethodArr2).intercept(new SerializationImplementation(TypeDescription.ForLoadedType.of(lookupType), ofLoaded.getReturnType(), str, ofLoaded2, ofLoaded3, JavaConstant.MethodType.ofLoaded(obj5)));
                } else if (ofLoaded.getReturnType().isAssignableTo((Class<?>) Serializable.class)) {
                    Class cls = Void.TYPE;
                    Visibility visibility2 = Visibility.PRIVATE;
                    intercept = intercept.defineMethod("readObject", (Type) cls, visibility2).withParameters(ObjectInputStream.class).throwing(NotSerializableException.class).intercept(ExceptionMethod.throwing((Class<? extends Throwable>) NotSerializableException.class, "Non-serializable lambda")).defineMethod("writeObject", (Type) Void.TYPE, visibility2).withParameters(ObjectOutputStream.class).throwing(NotSerializableException.class).intercept(ExceptionMethod.throwing((Class<? extends Throwable>) NotSerializableException.class, "Non-serializable lambda"));
                }
                for (Object ofLoaded5 : list2) {
                    JavaConstant.MethodType ofLoaded6 = JavaConstant.MethodType.ofLoaded(ofLoaded5);
                    intercept = intercept.defineMethod(str2, (TypeDefinition) ofLoaded6.getReturnType(), MethodManifestation.BRIDGE, Visibility.PUBLIC).withParameters((Collection<? extends TypeDefinition>) ofLoaded6.getParameterTypes()).intercept(new BridgeMethodImplementation(str2, ofLoaded2));
                }
                byte[] bytes = intercept.make().getBytes();
                for (ClassFileTransformer transform : collection) {
                    try {
                        byte[] transform2 = transform.transform(lookupType.getClassLoader(), str3.replace('.', '/'), NOT_PREVIOUSLY_DEFINED, lookupType.getProtectionDomain(), bytes);
                        if (transform2 != null) {
                            bytes = transform2;
                        }
                    } catch (Throwable unused) {
                    }
                }
                return bytes;
            }
        }

        protected enum LambdaMetafactoryFactory implements ByteCodeAppender {
            REGULAR(6, 11) {
                /* access modifiers changed from: protected */
                public void onDispatch(MethodVisitor methodVisitor) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitVarInsn(54, 6);
                    MethodVisitor methodVisitor2 = methodVisitor;
                    methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Collections", "emptyList", "()Ljava/util/List;", false);
                    methodVisitor.visitVarInsn(58, 7);
                    methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Collections", "emptyList", "()Ljava/util/List;", false);
                    methodVisitor.visitVarInsn(58, 8);
                    methodVisitor2.visitFrame(1, 3, new Object[]{Opcodes.INTEGER, "java/util/List", "java/util/List"}, 0, (Object[]) null);
                }
            },
            ALTERNATIVE(6, 16) {
                /* access modifiers changed from: protected */
                public void onDispatch(MethodVisitor methodVisitor) {
                    MethodVisitor methodVisitor2 = methodVisitor;
                    methodVisitor2.visitVarInsn(25, 3);
                    methodVisitor2.visitInsn(6);
                    methodVisitor2.visitInsn(50);
                    methodVisitor2.visitTypeInsn(192, "java/lang/Integer");
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
                    methodVisitor2.visitVarInsn(54, 4);
                    methodVisitor2.visitInsn(7);
                    methodVisitor2.visitVarInsn(54, 5);
                    methodVisitor2.visitVarInsn(21, 4);
                    methodVisitor2.visitInsn(5);
                    methodVisitor2.visitInsn(126);
                    Label label = new Label();
                    methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label);
                    methodVisitor2.visitVarInsn(25, 3);
                    methodVisitor2.visitVarInsn(21, 5);
                    methodVisitor2.visitIincInsn(5, 1);
                    methodVisitor2.visitInsn(50);
                    methodVisitor2.visitTypeInsn(192, "java/lang/Integer");
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
                    methodVisitor2.visitVarInsn(54, 7);
                    methodVisitor2.visitVarInsn(21, 7);
                    methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
                    methodVisitor2.visitVarInsn(58, 6);
                    methodVisitor2.visitVarInsn(25, 3);
                    methodVisitor2.visitVarInsn(21, 5);
                    methodVisitor2.visitVarInsn(25, 6);
                    methodVisitor2.visitInsn(3);
                    methodVisitor2.visitVarInsn(21, 7);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
                    methodVisitor2.visitVarInsn(21, 5);
                    methodVisitor2.visitVarInsn(21, 7);
                    methodVisitor2.visitInsn(96);
                    methodVisitor2.visitVarInsn(54, 5);
                    Label label2 = new Label();
                    methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
                    methodVisitor2.visitLabel(label);
                    Integer num = Opcodes.INTEGER;
                    methodVisitor.visitFrame(1, 2, new Object[]{num, num}, 0, (Object[]) null);
                    methodVisitor2.visitInsn(3);
                    methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
                    methodVisitor2.visitVarInsn(58, 6);
                    methodVisitor2.visitLabel(label2);
                    methodVisitor.visitFrame(1, 1, new Object[]{"[Ljava/lang/Class;"}, 0, (Object[]) null);
                    methodVisitor2.visitVarInsn(21, 4);
                    methodVisitor2.visitInsn(5);
                    methodVisitor2.visitInsn(126);
                    Label label3 = new Label();
                    methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label3);
                    methodVisitor2.visitVarInsn(25, 3);
                    methodVisitor2.visitVarInsn(21, 5);
                    methodVisitor2.visitIincInsn(5, 1);
                    methodVisitor2.visitInsn(50);
                    methodVisitor2.visitTypeInsn(192, "java/lang/Integer");
                    Label label4 = label3;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
                    methodVisitor2.visitVarInsn(54, 8);
                    methodVisitor2.visitVarInsn(21, 8);
                    methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/invoke/MethodType");
                    methodVisitor2.visitVarInsn(58, 7);
                    methodVisitor2.visitVarInsn(25, 3);
                    methodVisitor2.visitVarInsn(21, 5);
                    methodVisitor2.visitVarInsn(25, 7);
                    methodVisitor2.visitInsn(3);
                    methodVisitor2.visitVarInsn(21, 8);
                    String str = "java/lang/invoke/MethodType";
                    methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
                    Label label5 = new Label();
                    methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
                    methodVisitor2.visitLabel(label4);
                    methodVisitor.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
                    methodVisitor2.visitInsn(3);
                    methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, str);
                    methodVisitor2.visitVarInsn(58, 7);
                    methodVisitor2.visitLabel(label5);
                    methodVisitor.visitFrame(1, 1, new Object[]{"[Ljava/lang/invoke/MethodType;"}, 0, (Object[]) null);
                    methodVisitor2.visitVarInsn(25, 3);
                    methodVisitor2.visitInsn(3);
                    methodVisitor2.visitInsn(50);
                    methodVisitor2.visitTypeInsn(192, str);
                    methodVisitor2.visitVarInsn(58, 8);
                    methodVisitor2.visitVarInsn(25, 3);
                    methodVisitor2.visitInsn(4);
                    methodVisitor2.visitInsn(50);
                    methodVisitor2.visitTypeInsn(192, "java/lang/invoke/MethodHandle");
                    methodVisitor2.visitVarInsn(58, 9);
                    methodVisitor2.visitVarInsn(25, 3);
                    methodVisitor2.visitInsn(5);
                    methodVisitor2.visitInsn(50);
                    methodVisitor2.visitTypeInsn(192, str);
                    methodVisitor2.visitVarInsn(58, 10);
                    methodVisitor2.visitVarInsn(21, 4);
                    methodVisitor2.visitInsn(4);
                    methodVisitor2.visitInsn(126);
                    Label label6 = new Label();
                    methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label6);
                    methodVisitor2.visitInsn(4);
                    Label label7 = new Label();
                    methodVisitor2.visitJumpInsn(Opcodes.GOTO, label7);
                    methodVisitor2.visitLabel(label6);
                    methodVisitor.visitFrame(1, 3, new Object[]{str, "java/lang/invoke/MethodHandle", str}, 0, (Object[]) null);
                    methodVisitor2.visitInsn(3);
                    methodVisitor2.visitLabel(label7);
                    methodVisitor.visitFrame(4, 0, (Object[]) null, 1, new Object[]{num});
                    methodVisitor2.visitVarInsn(54, 11);
                    methodVisitor2.visitVarInsn(25, 6);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "asList", "([Ljava/lang/Object;)Ljava/util/List;", false);
                    methodVisitor2.visitVarInsn(58, 12);
                    methodVisitor2.visitVarInsn(25, 7);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "asList", "([Ljava/lang/Object;)Ljava/util/List;", false);
                    methodVisitor2.visitVarInsn(58, 13);
                    methodVisitor2.visitVarInsn(25, 8);
                    methodVisitor2.visitVarInsn(58, 3);
                    methodVisitor2.visitVarInsn(25, 9);
                    methodVisitor2.visitVarInsn(58, 4);
                    methodVisitor2.visitVarInsn(25, 10);
                    methodVisitor2.visitVarInsn(58, 5);
                    methodVisitor2.visitVarInsn(21, 11);
                    methodVisitor2.visitVarInsn(54, 6);
                    methodVisitor2.visitVarInsn(25, 12);
                    methodVisitor2.visitVarInsn(58, 7);
                    methodVisitor2.visitVarInsn(25, 13);
                    methodVisitor2.visitVarInsn(58, 8);
                    methodVisitor.visitFrame(0, 9, new Object[]{"java/lang/invoke/MethodHandles$Lookup", "java/lang/String", str, str, "java/lang/invoke/MethodHandle", str, num, "java/util/List", "java/util/List"}, 0, (Object[]) null);
                }
            };
            
            private static final Loader LOADER = null;
            private final int localVariableLength;
            private final int stackSize;

            protected interface Loader {

                public enum Unavailable implements Loader {
                    INSTANCE;

                    public void apply(MethodVisitor methodVisitor) {
                        throw new IllegalStateException("No lambda expression loading strategy available on current VM");
                    }

                    public int getLocalVariableLength() {
                        throw new IllegalStateException("No lambda expression loading strategy available on current VM");
                    }

                    public int getStackSize() {
                        throw new IllegalStateException("No lambda expression loading strategy available on current VM");
                    }
                }

                public enum UsingMethodHandleLookup implements Loader {
                    INSTANCE;

                    public void apply(MethodVisitor methodVisitor) {
                        MethodVisitor methodVisitor2 = methodVisitor;
                        methodVisitor2.visitVarInsn(25, 0);
                        methodVisitor2.visitVarInsn(25, 4);
                        MethodVisitor methodVisitor3 = methodVisitor;
                        methodVisitor3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "revealDirect", "(Ljava/lang/invoke/MethodHandle;)Ljava/lang/invoke/MethodHandleInfo;", false);
                        methodVisitor2.visitVarInsn(58, 10);
                        methodVisitor2.visitVarInsn(25, 10);
                        methodVisitor3.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/lang/invoke/MethodHandleInfo", "getModifiers", "()I", true);
                        methodVisitor3.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/reflect/Modifier", "isProtected", "(I)Z", false);
                        Label label = new Label();
                        methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label);
                        methodVisitor2.visitVarInsn(25, 0);
                        methodVisitor3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false);
                        methodVisitor2.visitVarInsn(25, 10);
                        methodVisitor3.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/lang/invoke/MethodHandleInfo", "getDeclaringClass", "()Ljava/lang/Class;", true);
                        methodVisitor3.visitMethodInsn(Opcodes.INVOKESTATIC, "sun/invoke/util/VerifyAccess", "isSamePackage", "(Ljava/lang/Class;Ljava/lang/Class;)Z", false);
                        Label label2 = new Label();
                        methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label2);
                        methodVisitor2.visitLabel(label);
                        Integer num = Opcodes.INTEGER;
                        MethodVisitor methodVisitor4 = methodVisitor;
                        methodVisitor4.visitFrame(0, 11, new Object[]{"java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "java/lang/invoke/MethodType", "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", num, "java/util/List", "java/util/List", "[B", "java/lang/invoke/MethodHandleInfo"}, 0, new Object[0]);
                        methodVisitor2.visitVarInsn(25, 10);
                        methodVisitor4.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/lang/invoke/MethodHandleInfo", "getReferenceKind", "()I", true);
                        methodVisitor2.visitIntInsn(16, 7);
                        Label label3 = new Label();
                        methodVisitor2.visitJumpInsn(160, label3);
                        methodVisitor2.visitLabel(label2);
                        methodVisitor.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
                        methodVisitor2.visitInsn(4);
                        Label label4 = new Label();
                        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label4);
                        methodVisitor2.visitLabel(label3);
                        MethodVisitor methodVisitor5 = methodVisitor;
                        methodVisitor5.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
                        methodVisitor2.visitInsn(3);
                        methodVisitor2.visitLabel(label4);
                        methodVisitor5.visitFrame(4, 0, (Object[]) null, 1, new Object[]{num});
                        methodVisitor2.visitVarInsn(54, 11);
                        methodVisitor2.visitVarInsn(21, 11);
                        Label label5 = new Label();
                        methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label5);
                        methodVisitor2.visitVarInsn(25, 0);
                        methodVisitor2.visitVarInsn(25, 9);
                        methodVisitor2.visitVarInsn(25, 10);
                        methodVisitor2.visitInsn(4);
                        methodVisitor2.visitInsn(5);
                        methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/invoke/MethodHandles$Lookup$ClassOption");
                        methodVisitor2.visitInsn(89);
                        methodVisitor2.visitInsn(3);
                        methodVisitor2.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "NESTMATE", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;");
                        methodVisitor2.visitInsn(83);
                        methodVisitor2.visitInsn(89);
                        methodVisitor2.visitInsn(4);
                        methodVisitor2.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "STRONG", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;");
                        methodVisitor2.visitInsn(83);
                        String str = "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;";
                        String str2 = "java/lang/invoke/MethodHandles$Lookup$ClassOption";
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "defineHiddenClassWithClassData", "([BLjava/lang/Object;Z[Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;)Ljava/lang/invoke/MethodHandles$Lookup;", false);
                        methodVisitor2.visitVarInsn(58, 12);
                        methodVisitor2.visitLabel(new Label());
                        Label label6 = new Label();
                        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label6);
                        methodVisitor2.visitLabel(label5);
                        methodVisitor.visitFrame(1, 1, new Object[]{num}, 0, (Object[]) null);
                        methodVisitor2.visitVarInsn(25, 0);
                        methodVisitor2.visitVarInsn(25, 9);
                        methodVisitor2.visitInsn(4);
                        methodVisitor2.visitInsn(5);
                        methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, str2);
                        methodVisitor2.visitInsn(89);
                        methodVisitor2.visitInsn(3);
                        methodVisitor2.visitFieldInsn(Opcodes.GETSTATIC, str2, "NESTMATE", str);
                        methodVisitor2.visitInsn(83);
                        methodVisitor2.visitInsn(89);
                        methodVisitor2.visitInsn(4);
                        methodVisitor2.visitFieldInsn(Opcodes.GETSTATIC, str2, "STRONG", str);
                        methodVisitor2.visitInsn(83);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "defineHiddenClass", "([BZ[Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;)Ljava/lang/invoke/MethodHandles$Lookup;", false);
                        methodVisitor2.visitVarInsn(58, 12);
                        methodVisitor2.visitLabel(label6);
                        MethodVisitor methodVisitor6 = methodVisitor;
                        methodVisitor6.visitFrame(1, 1, new Object[]{"java/lang/invoke/MethodHandles$Lookup"}, 0, (Object[]) null);
                        methodVisitor2.visitVarInsn(25, 12);
                        methodVisitor6.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false);
                        methodVisitor2.visitVarInsn(58, 10);
                        methodVisitor.visitFrame(0, 10, new Object[]{"java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "java/lang/invoke/MethodType", "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", num, "java/util/List", "java/util/List", TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME}, 0, (Object[]) null);
                    }

                    public int getLocalVariableLength() {
                        return 15;
                    }

                    public int getStackSize() {
                        return 8;
                    }
                }

                public enum UsingUnsafe implements Loader {
                    JDK_INTERNAL_MISC_UNSAFE("jdk/internal/misc/Unsafe"),
                    SUN_MISC_UNSAFE("sun/misc/Unsafe");
                    
                    private final String type;

                    private UsingUnsafe(String str) {
                        this.type = str;
                    }

                    public void apply(MethodVisitor methodVisitor) {
                        String str = this.type;
                        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, str, "getUnsafe", "()L" + this.type + ";", false);
                        methodVisitor.visitVarInsn(58, 11);
                        methodVisitor.visitVarInsn(25, 11);
                        methodVisitor.visitVarInsn(25, 0);
                        MethodVisitor methodVisitor2 = methodVisitor;
                        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false);
                        methodVisitor.visitVarInsn(25, 9);
                        methodVisitor.visitInsn(1);
                        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, this.type, "defineAnonymousClass", "(Ljava/lang/Class;[B[Ljava/lang/Object;)Ljava/lang/Class;", false);
                        methodVisitor.visitVarInsn(58, 10);
                        methodVisitor.visitVarInsn(25, 11);
                        methodVisitor.visitVarInsn(25, 10);
                        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, this.type, "ensureClassInitialized", "(Ljava/lang/Class;)V", false);
                    }

                    public int getLocalVariableLength() {
                        return 13;
                    }

                    public int getStackSize() {
                        return 4;
                    }

                    /* access modifiers changed from: protected */
                    public String getType() {
                        return this.type;
                    }
                }

                void apply(MethodVisitor methodVisitor);

                int getLocalVariableLength();

                int getStackSize();
            }

            static {
                LOADER = resolve();
            }

            @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"DE_MIGHT_IGNORE", "REC_CATCH_EXCEPTION"})
            private static Loader resolve() {
                Class<byte[]> cls = byte[].class;
                try {
                    Class<?> cls2 = Class.forName("java.lang.invoke.MethodHandles$Lookup", false, (ClassLoader) null);
                    Class cls3 = Boolean.TYPE;
                    cls2.getMethod("defineHiddenClass", new Class[]{cls, cls3, Class.forName("[Ljava.lang.invoke.MethodHandles$Lookup$ClassOption;", false, (ClassLoader) null)});
                    cls2.getMethod("defineHiddenClassWithClassData", new Class[]{cls, Object.class, cls3, Class.forName("[Ljava.lang.invoke.MethodHandles$Lookup$ClassOption;", false, (ClassLoader) null)});
                    return Loader.UsingMethodHandleLookup.INSTANCE;
                } catch (Exception unused) {
                    Loader.UsingUnsafe[] values = Loader.UsingUnsafe.values();
                    int length = values.length;
                    int i10 = 0;
                    while (i10 < length) {
                        Loader.UsingUnsafe usingUnsafe = values[i10];
                        try {
                            Class.forName(usingUnsafe.getType().replace('/', '.'), false, (ClassLoader) null).getMethod("defineAnonymousClass", new Class[]{Class.class, cls, Object[].class});
                            return usingUnsafe;
                        } catch (Exception unused2) {
                            i10++;
                        }
                    }
                    return Loader.Unavailable.INSTANCE;
                }
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                MethodVisitor methodVisitor2 = methodVisitor;
                onDispatch(methodVisitor);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/ClassLoader", "getSystemClassLoader", "()Ljava/lang/ClassLoader;", false);
                methodVisitor2.visitLdcInsn("net.bytebuddy.agent.builder.LambdaFactory");
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/ClassLoader", "loadClass", "(Ljava/lang/String;)Ljava/lang/Class;", false);
                methodVisitor2.visitLdcInsn(TypeProxy.REFLECTION_METHOD);
                methodVisitor2.visitIntInsn(16, 9);
                methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitLdcInsn(net.bytebuddy.jar.asm.Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(4);
                methodVisitor2.visitLdcInsn(net.bytebuddy.jar.asm.Type.getType("Ljava/lang/String;"));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(5);
                methodVisitor2.visitLdcInsn(net.bytebuddy.jar.asm.Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(6);
                methodVisitor2.visitLdcInsn(net.bytebuddy.jar.asm.Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(7);
                methodVisitor2.visitLdcInsn(net.bytebuddy.jar.asm.Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(8);
                methodVisitor2.visitLdcInsn(net.bytebuddy.jar.asm.Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 6);
                methodVisitor2.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Boolean", "TYPE", "Ljava/lang/Class;");
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 7);
                methodVisitor2.visitLdcInsn(net.bytebuddy.jar.asm.Type.getType("Ljava/util/List;"));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 8);
                methodVisitor2.visitLdcInsn(net.bytebuddy.jar.asm.Type.getType("Ljava/util/List;"));
                methodVisitor2.visitInsn(83);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME, "getDeclaredMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
                methodVisitor2.visitInsn(1);
                methodVisitor2.visitIntInsn(16, 9);
                methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(4);
                methodVisitor2.visitVarInsn(25, 1);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(5);
                methodVisitor2.visitVarInsn(25, 2);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(6);
                methodVisitor2.visitVarInsn(25, 3);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(7);
                methodVisitor2.visitVarInsn(25, 4);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(8);
                methodVisitor2.visitVarInsn(25, 5);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 6);
                methodVisitor2.visitVarInsn(21, 6);
                MethodVisitor methodVisitor3 = methodVisitor;
                String str = TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME;
                methodVisitor3.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 7);
                methodVisitor2.visitVarInsn(25, 7);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 8);
                methodVisitor2.visitVarInsn(25, 8);
                methodVisitor2.visitInsn(83);
                methodVisitor3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/reflect/Method", "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", false);
                methodVisitor2.visitTypeInsn(192, "[B");
                methodVisitor2.visitVarInsn(58, 9);
                Loader loader = LOADER;
                loader.apply(methodVisitor2);
                methodVisitor2.visitVarInsn(25, 2);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodType", "parameterCount", "()I", false);
                Label label = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.IFNE, label);
                methodVisitor2.visitTypeInsn(Opcodes.NEW, "java/lang/invoke/ConstantCallSite");
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitVarInsn(25, 2);
                MethodVisitor methodVisitor4 = methodVisitor;
                methodVisitor4.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodType", "returnType", "()Ljava/lang/Class;", false);
                methodVisitor2.visitVarInsn(25, 10);
                methodVisitor4.visitMethodInsn(Opcodes.INVOKEVIRTUAL, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME, "getDeclaredConstructors", "()[Ljava/lang/reflect/Constructor;", false);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitInsn(50);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitTypeInsn(Opcodes.ANEWARRAY, str);
                MethodVisitor methodVisitor5 = methodVisitor;
                methodVisitor5.visitMethodInsn(Opcodes.INVOKEVIRTUAL, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CONSTRUCTOR_INTERNAL_NAME, TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_DESCRIPTOR, false);
                methodVisitor5.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/invoke/MethodHandles", "constant", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/invoke/MethodHandle;", false);
                methodVisitor5.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/invoke/ConstantCallSite", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/invoke/MethodHandle;)V", false);
                Label label2 = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
                methodVisitor2.visitLabel(label);
                methodVisitor.visitFrame(0, 11, new Object[]{"java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "java/lang/invoke/MethodType", "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", Opcodes.INTEGER, "java/util/List", "java/util/List", "[B", TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME}, 0, new Object[0]);
                methodVisitor2.visitTypeInsn(Opcodes.NEW, "java/lang/invoke/ConstantCallSite");
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/invoke/MethodHandles$Lookup", "IMPL_LOOKUP", "Ljava/lang/invoke/MethodHandles$Lookup;");
                methodVisitor2.visitVarInsn(25, 10);
                methodVisitor2.visitLdcInsn("get$Lambda");
                methodVisitor2.visitVarInsn(25, 2);
                MethodVisitor methodVisitor6 = methodVisitor;
                methodVisitor6.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false);
                methodVisitor6.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/invoke/ConstantCallSite", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/invoke/MethodHandle;)V", false);
                methodVisitor2.visitLabel(label2);
                methodVisitor.visitFrame(4, 0, (Object[]) null, 1, new Object[]{"java/lang/invoke/CallSite"});
                methodVisitor2.visitInsn(Opcodes.ARETURN);
                return new ByteCodeAppender.Size(Math.max(this.stackSize, loader.getStackSize()), Math.max(this.localVariableLength, loader.getLocalVariableLength()));
            }

            /* access modifiers changed from: protected */
            public abstract void onDispatch(MethodVisitor methodVisitor);

            private LambdaMetafactoryFactory(int i10, int i11) {
                this.stackSize = i10;
                this.localVariableLength = i11;
            }
        }

        public static LambdaInstrumentationStrategy of(boolean z10) {
            return z10 ? ENABLED : DISABLED;
        }

        public static void release(ClassFileTransformer classFileTransformer, Instrumentation instrumentation) {
            if (LambdaFactory.release(classFileTransformer)) {
                try {
                    ClassReloadingStrategy.of(instrumentation).reset(Class.forName("java.lang.invoke.LambdaMetafactory"));
                } catch (Exception e10) {
                    throw new IllegalStateException("Could not release lambda transformer", e10);
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract void apply(ByteBuddy byteBuddy, Instrumentation instrumentation, ClassFileTransformer classFileTransformer);

        public boolean isEnabled() {
            return this == ENABLED;
        }

        /* access modifiers changed from: protected */
        public abstract boolean isInstrumented(@MaybeNull Class<?> cls);
    }

    public interface Listener {
        public static final boolean LOADED = true;

        public static abstract class Adapter implements Listener {
            public void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
            }

            public void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
            }

            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, Throwable th2) {
            }

            public void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
            }

            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, DynamicType dynamicType) {
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements Listener {
            private final List<Listener> listeners;

            public Compound(Listener... listenerArr) {
                this((List<? extends Listener>) Arrays.asList(listenerArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.listeners.equals(((Compound) obj).listeners);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.listeners.hashCode();
            }

            public void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
                for (Listener onComplete : this.listeners) {
                    onComplete.onComplete(str, classLoader, javaModule, z10);
                }
            }

            public void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
                for (Listener onDiscovery : this.listeners) {
                    onDiscovery.onDiscovery(str, classLoader, javaModule, z10);
                }
            }

            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, Throwable th2) {
                for (Listener onError : this.listeners) {
                    onError.onError(str, classLoader, javaModule, z10, th2);
                }
            }

            public void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
                for (Listener onIgnored : this.listeners) {
                    onIgnored.onIgnored(typeDescription, classLoader, javaModule, z10);
                }
            }

            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, DynamicType dynamicType) {
                for (Listener onTransformation : this.listeners) {
                    onTransformation.onTransformation(typeDescription, classLoader, javaModule, z10, dynamicType);
                }
            }

            public Compound(List<? extends Listener> list) {
                this.listeners = new ArrayList();
                for (Listener listener : list) {
                    if (listener instanceof Compound) {
                        this.listeners.addAll(((Compound) listener).listeners);
                    } else if (!(listener instanceof NoOp)) {
                        this.listeners.add(listener);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Filtering implements Listener {
            private final Listener delegate;
            private final ElementMatcher<? super String> matcher;

            public Filtering(ElementMatcher<? super String> elementMatcher, Listener listener) {
                this.matcher = elementMatcher;
                this.delegate = listener;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Filtering filtering = (Filtering) obj;
                return this.matcher.equals(filtering.matcher) && this.delegate.equals(filtering.delegate);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.delegate.hashCode();
            }

            public void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
                if (this.matcher.matches(str)) {
                    this.delegate.onComplete(str, classLoader, javaModule, z10);
                }
            }

            public void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
                if (this.matcher.matches(str)) {
                    this.delegate.onDiscovery(str, classLoader, javaModule, z10);
                }
            }

            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, Throwable th2) {
                if (this.matcher.matches(str)) {
                    this.delegate.onError(str, classLoader, javaModule, z10, th2);
                }
            }

            public void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
                if (this.matcher.matches(typeDescription.getName())) {
                    this.delegate.onIgnored(typeDescription, classLoader, javaModule, z10);
                }
            }

            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, DynamicType dynamicType) {
                if (this.matcher.matches(typeDescription.getName())) {
                    this.delegate.onTransformation(typeDescription, classLoader, javaModule, z10, dynamicType);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ModuleReadEdgeCompleting extends Adapter {
            private final boolean addTargetEdge;
            private final Instrumentation instrumentation;
            private final Set<? extends JavaModule> modules;

            public ModuleReadEdgeCompleting(Instrumentation instrumentation2, boolean z10, Set<? extends JavaModule> set) {
                this.instrumentation = instrumentation2;
                this.addTargetEdge = z10;
                this.modules = set;
            }

            public static Listener of(Instrumentation instrumentation2, boolean z10, Class<?>... clsArr) {
                HashSet hashSet = new HashSet();
                for (Class<?> ofType : clsArr) {
                    hashSet.add(JavaModule.ofType(ofType));
                }
                if (hashSet.isEmpty()) {
                    return NoOp.INSTANCE;
                }
                return new ModuleReadEdgeCompleting(instrumentation2, z10, hashSet);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ModuleReadEdgeCompleting moduleReadEdgeCompleting = (ModuleReadEdgeCompleting) obj;
                return this.addTargetEdge == moduleReadEdgeCompleting.addTargetEdge && this.instrumentation.equals(moduleReadEdgeCompleting.instrumentation) && this.modules.equals(moduleReadEdgeCompleting.modules);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + (this.addTargetEdge ? 1 : 0)) * 31) + this.modules.hashCode();
            }

            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, DynamicType dynamicType) {
                Map map;
                if (javaModule != JavaModule.UNSUPPORTED && javaModule.isNamed()) {
                    for (JavaModule javaModule2 : this.modules) {
                        if (!javaModule.canRead(javaModule2) || (this.addTargetEdge && !javaModule.isOpened(typeDescription.getPackage(), javaModule2))) {
                            PackageDescription packageDescription = typeDescription.getPackage();
                            Instrumentation instrumentation2 = this.instrumentation;
                            Set singleton = Collections.singleton(javaModule2);
                            Map emptyMap = Collections.emptyMap();
                            if (!this.addTargetEdge || packageDescription == null || packageDescription.isDefault()) {
                                map = Collections.emptyMap();
                            } else {
                                map = Collections.singletonMap(packageDescription.getName(), Collections.singleton(javaModule2));
                            }
                            ClassInjector.UsingInstrumentation.redefineModule(instrumentation2, javaModule, singleton, emptyMap, map, Collections.emptySet(), Collections.emptyMap());
                        }
                        if (this.addTargetEdge && !javaModule2.canRead(javaModule)) {
                            ClassInjector.UsingInstrumentation.redefineModule(this.instrumentation, javaModule2, Collections.singleton(javaModule), Collections.emptyMap(), Collections.emptyMap(), Collections.emptySet(), Collections.emptyMap());
                        }
                    }
                }
            }
        }

        public enum NoOp implements Listener {
            INSTANCE;

            public void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
            }

            public void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
            }

            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, Throwable th2) {
            }

            public void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
            }

            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, DynamicType dynamicType) {
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class StreamWriting implements Listener {
            protected static final String PREFIX = "[Byte Buddy]";
            private final PrintStream printStream;

            public StreamWriting(PrintStream printStream2) {
                this.printStream = printStream2;
            }

            public static StreamWriting toSystemError() {
                return new StreamWriting(System.err);
            }

            public static StreamWriting toSystemOut() {
                return new StreamWriting(System.out);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.printStream.equals(((StreamWriting) obj).printStream);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.printStream.hashCode();
            }

            public void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
                this.printStream.printf("[Byte Buddy] COMPLETE %s [%s, %s, %s, loaded=%b]%n", new Object[]{str, classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z10)});
            }

            public void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
                this.printStream.printf("[Byte Buddy] DISCOVERY %s [%s, %s, %s, loaded=%b]%n", new Object[]{str, classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z10)});
            }

            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, Throwable th2) {
                synchronized (this.printStream) {
                    this.printStream.printf("[Byte Buddy] ERROR %s [%s, %s, %s, loaded=%b]%n", new Object[]{str, classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z10)});
                    th2.printStackTrace(this.printStream);
                }
            }

            public void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10) {
                this.printStream.printf("[Byte Buddy] IGNORE %s [%s, %s, %s, loaded=%b]%n", new Object[]{typeDescription.getName(), classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z10)});
            }

            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, DynamicType dynamicType) {
                this.printStream.printf("[Byte Buddy] TRANSFORM %s [%s, %s, %s, loaded=%b]%n", new Object[]{typeDescription.getName(), classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z10)});
            }

            public Listener withErrorsOnly() {
                return new WithErrorsOnly(this);
            }

            public Listener withTransformationsOnly() {
                return new WithTransformationsOnly(this);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class WithErrorsOnly extends Adapter {
            private final Listener delegate;

            public WithErrorsOnly(Listener listener) {
                this.delegate = listener;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((WithErrorsOnly) obj).delegate);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.delegate.hashCode();
            }

            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, Throwable th2) {
                this.delegate.onError(str, classLoader, javaModule, z10, th2);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class WithTransformationsOnly extends Adapter {
            private final Listener delegate;

            public WithTransformationsOnly(Listener listener) {
                this.delegate = listener;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((WithTransformationsOnly) obj).delegate);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.delegate.hashCode();
            }

            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, Throwable th2) {
                this.delegate.onError(str, classLoader, javaModule, z10, th2);
            }

            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, DynamicType dynamicType) {
                this.delegate.onTransformation(typeDescription, classLoader, javaModule, z10, dynamicType);
            }
        }

        void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10);

        void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10);

        void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, Throwable th2);

        void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10);

        void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z10, DynamicType dynamicType);
    }

    public interface LocationStrategy {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements LocationStrategy {
            private final List<LocationStrategy> locationStrategies;

            public Compound(LocationStrategy... locationStrategyArr) {
                this((List<? extends LocationStrategy>) Arrays.asList(locationStrategyArr));
            }

            public ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                ArrayList arrayList = new ArrayList(this.locationStrategies.size());
                for (LocationStrategy classFileLocator : this.locationStrategies) {
                    arrayList.add(classFileLocator.classFileLocator(classLoader, javaModule));
                }
                return new ClassFileLocator.Compound((List<? extends ClassFileLocator>) arrayList);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.locationStrategies.equals(((Compound) obj).locationStrategies);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.locationStrategies.hashCode();
            }

            public Compound(List<? extends LocationStrategy> list) {
                this.locationStrategies = new ArrayList();
                for (LocationStrategy locationStrategy : list) {
                    if (locationStrategy instanceof Compound) {
                        this.locationStrategies.addAll(((Compound) locationStrategy).locationStrategies);
                    } else if (!(locationStrategy instanceof NoOp)) {
                        this.locationStrategies.add(locationStrategy);
                    }
                }
            }
        }

        public enum ForClassLoader implements LocationStrategy {
            STRONG {
                public ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    return ClassFileLocator.ForClassLoader.of(classLoader);
                }
            },
            WEAK {
                public ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    return ClassFileLocator.ForClassLoader.WeaklyReferenced.of(classLoader);
                }
            };

            public LocationStrategy withFallbackTo(ClassFileLocator... classFileLocatorArr) {
                return withFallbackTo((Collection<? extends ClassFileLocator>) Arrays.asList(classFileLocatorArr));
            }

            public LocationStrategy withFallbackTo(Collection<? extends ClassFileLocator> collection) {
                ArrayList arrayList = new ArrayList(collection.size());
                for (ClassFileLocator simple : collection) {
                    arrayList.add(new Simple(simple));
                }
                return withFallbackTo((List<? extends LocationStrategy>) arrayList);
            }

            public LocationStrategy withFallbackTo(LocationStrategy... locationStrategyArr) {
                return withFallbackTo((List<? extends LocationStrategy>) Arrays.asList(locationStrategyArr));
            }

            public LocationStrategy withFallbackTo(List<? extends LocationStrategy> list) {
                ArrayList arrayList = new ArrayList(list.size() + 1);
                arrayList.add(this);
                arrayList.addAll(list);
                return new Compound((List<? extends LocationStrategy>) arrayList);
            }
        }

        public enum NoOp implements LocationStrategy {
            INSTANCE;

            public ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                return ClassFileLocator.NoOp.INSTANCE;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements LocationStrategy {
            private final ClassFileLocator classFileLocator;

            public Simple(ClassFileLocator classFileLocator2) {
                this.classFileLocator = classFileLocator2;
            }

            public ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                return this.classFileLocator;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.classFileLocator.equals(((Simple) obj).classFileLocator);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.classFileLocator.hashCode();
            }
        }

        ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule);
    }

    public interface Matchable<T extends Matchable<T>> {
        T and(RawMatcher rawMatcher);

        T and(ElementMatcher<? super TypeDescription> elementMatcher);

        T and(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2);

        T and(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);

        T or(RawMatcher rawMatcher);

        T or(ElementMatcher<? super TypeDescription> elementMatcher);

        T or(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2);

        T or(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);
    }

    public enum PatchMode {
        GAP {
            /* access modifiers changed from: protected */
            public Handler toHandler(ResettableClassFileTransformer resettableClassFileTransformer) {
                return new Handler.ForPatchWithGap(resettableClassFileTransformer);
            }
        },
        OVERLAP {
            /* access modifiers changed from: protected */
            public Handler toHandler(ResettableClassFileTransformer resettableClassFileTransformer) {
                return new Handler.ForPatchWithOverlap(resettableClassFileTransformer);
            }
        };

        protected interface Handler {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForPatchWithGap implements Handler {
                private final ResettableClassFileTransformer classFileTransformer;

                protected ForPatchWithGap(ResettableClassFileTransformer resettableClassFileTransformer) {
                    this.classFileTransformer = resettableClassFileTransformer;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.classFileTransformer.equals(((ForPatchWithGap) obj).classFileTransformer);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.classFileTransformer.hashCode();
                }

                public void onAfterRegistration(Instrumentation instrumentation) {
                }

                public void onBeforeRegistration(Instrumentation instrumentation) {
                    if (!this.classFileTransformer.reset(instrumentation, RedefinitionStrategy.DISABLED)) {
                        throw new IllegalArgumentException("Failed to deregister patched class file transformer: " + this.classFileTransformer);
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForPatchWithOverlap implements Handler {
                private final ResettableClassFileTransformer classFileTransformer;

                protected ForPatchWithOverlap(ResettableClassFileTransformer resettableClassFileTransformer) {
                    this.classFileTransformer = resettableClassFileTransformer;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.classFileTransformer.equals(((ForPatchWithOverlap) obj).classFileTransformer);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.classFileTransformer.hashCode();
                }

                public void onAfterRegistration(Instrumentation instrumentation) {
                    if (!this.classFileTransformer.reset(instrumentation, RedefinitionStrategy.DISABLED)) {
                        throw new IllegalArgumentException("Failed to deregister patched class file transformer: " + this.classFileTransformer);
                    }
                }

                public void onBeforeRegistration(Instrumentation instrumentation) {
                }
            }

            public enum NoOp implements Handler {
                INSTANCE;

                public void onAfterRegistration(Instrumentation instrumentation) {
                }

                public void onBeforeRegistration(Instrumentation instrumentation) {
                }
            }

            void onAfterRegistration(Instrumentation instrumentation);

            void onBeforeRegistration(Instrumentation instrumentation);
        }

        /* access modifiers changed from: protected */
        public abstract Handler toHandler(ResettableClassFileTransformer resettableClassFileTransformer);
    }

    public interface PoolStrategy {

        public enum ClassLoading implements PoolStrategy {
            EXTENDED(TypePool.Default.ReaderMode.EXTENDED),
            FAST(TypePool.Default.ReaderMode.FAST);
            
            private final TypePool.Default.ReaderMode readerMode;

            private ClassLoading(TypePool.Default.ReaderMode readerMode2) {
                this.readerMode = readerMode2;
            }

            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader) {
                return TypePool.ClassLoading.of(classLoader, new TypePool.Default.WithLazyResolution(TypePool.CacheProvider.Simple.withObjectType(), classFileLocator, this.readerMode));
            }

            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader, String str) {
                return typePool(classFileLocator, classLoader);
            }
        }

        public enum Default implements PoolStrategy {
            EXTENDED(TypePool.Default.ReaderMode.EXTENDED),
            FAST(TypePool.Default.ReaderMode.FAST);
            
            private final TypePool.Default.ReaderMode readerMode;

            private Default(TypePool.Default.ReaderMode readerMode2) {
                this.readerMode = readerMode2;
            }

            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader) {
                return new TypePool.Default.WithLazyResolution(TypePool.CacheProvider.Simple.withObjectType(), classFileLocator, this.readerMode);
            }

            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader, String str) {
                return typePool(classFileLocator, classLoader);
            }
        }

        public enum Eager implements PoolStrategy {
            EXTENDED(TypePool.Default.ReaderMode.EXTENDED),
            FAST(TypePool.Default.ReaderMode.FAST);
            
            private final TypePool.Default.ReaderMode readerMode;

            private Eager(TypePool.Default.ReaderMode readerMode2) {
                this.readerMode = readerMode2;
            }

            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader) {
                return new TypePool.Default(TypePool.CacheProvider.Simple.withObjectType(), classFileLocator, this.readerMode);
            }

            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader, String str) {
                return typePool(classFileLocator, classLoader);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class WithTypePoolCache implements PoolStrategy {
            protected final TypePool.Default.ReaderMode readerMode;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Simple extends WithTypePoolCache {
                private final ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> cacheProviders;

                public Simple(ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> concurrentMap) {
                    this(TypePool.Default.ReaderMode.FAST, concurrentMap);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.cacheProviders.equals(((Simple) obj).cacheProviders);
                }

                /* access modifiers changed from: protected */
                public ClassLoader getBootstrapMarkerLoader() {
                    return ClassLoader.getSystemClassLoader();
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.cacheProviders.hashCode();
                }

                /* access modifiers changed from: protected */
                public TypePool.CacheProvider locate(@MaybeNull ClassLoader classLoader) {
                    if (classLoader == null) {
                        classLoader = getBootstrapMarkerLoader();
                    }
                    TypePool.CacheProvider cacheProvider = this.cacheProviders.get(classLoader);
                    while (cacheProvider == null) {
                        cacheProvider = TypePool.CacheProvider.Simple.withObjectType();
                        TypePool.CacheProvider putIfAbsent = this.cacheProviders.putIfAbsent(classLoader, cacheProvider);
                        if (putIfAbsent != null) {
                            cacheProvider = putIfAbsent;
                        }
                    }
                    return cacheProvider;
                }

                public Simple(TypePool.Default.ReaderMode readerMode, ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> concurrentMap) {
                    super(readerMode);
                    this.cacheProviders = concurrentMap;
                }
            }

            protected WithTypePoolCache(TypePool.Default.ReaderMode readerMode2) {
                this.readerMode = readerMode2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.readerMode.equals(((WithTypePoolCache) obj).readerMode);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.readerMode.hashCode();
            }

            /* access modifiers changed from: protected */
            public abstract TypePool.CacheProvider locate(@MaybeNull ClassLoader classLoader);

            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader) {
                return new TypePool.Default.WithLazyResolution(locate(classLoader), classFileLocator, this.readerMode);
            }

            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader, String str) {
                return new TypePool.Default.WithLazyResolution(new TypePool.CacheProvider.Discriminating(ElementMatchers.is((Object) str), new TypePool.CacheProvider.Simple(), locate(classLoader)), classFileLocator, this.readerMode);
            }
        }

        TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader);

        TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader, String str);
    }

    public interface RawMatcher {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Conjunction implements RawMatcher {
            private final List<RawMatcher> matchers;

            protected Conjunction(RawMatcher... rawMatcherArr) {
                this((List<? extends RawMatcher>) Arrays.asList(rawMatcherArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.matchers.hashCode();
            }

            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain) {
                for (RawMatcher matches : this.matchers) {
                    if (!matches.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                        return false;
                    }
                }
                return true;
            }

            protected Conjunction(List<? extends RawMatcher> list) {
                this.matchers = new ArrayList(list.size());
                for (RawMatcher rawMatcher : list) {
                    if (rawMatcher instanceof Conjunction) {
                        this.matchers.addAll(((Conjunction) rawMatcher).matchers);
                    } else if (rawMatcher != Trivial.MATCHING) {
                        this.matchers.add(rawMatcher);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Disjunction implements RawMatcher {
            private final List<RawMatcher> matchers;

            protected Disjunction(RawMatcher... rawMatcherArr) {
                this((List<? extends RawMatcher>) Arrays.asList(rawMatcherArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.matchers.hashCode();
            }

            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain) {
                for (RawMatcher matches : this.matchers) {
                    if (matches.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                        return true;
                    }
                }
                return false;
            }

            protected Disjunction(List<? extends RawMatcher> list) {
                this.matchers = new ArrayList(list.size());
                for (RawMatcher rawMatcher : list) {
                    if (rawMatcher instanceof Disjunction) {
                        this.matchers.addAll(((Disjunction) rawMatcher).matchers);
                    } else if (rawMatcher != Trivial.NON_MATCHING) {
                        this.matchers.add(rawMatcher);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForElementMatchers implements RawMatcher {
            private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
            private final ElementMatcher<? super JavaModule> moduleMatcher;
            private final ElementMatcher<? super TypeDescription> typeMatcher;

            public ForElementMatchers(ElementMatcher<? super TypeDescription> elementMatcher) {
                this(elementMatcher, ElementMatchers.any());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                return this.typeMatcher.equals(forElementMatchers.typeMatcher) && this.classLoaderMatcher.equals(forElementMatchers.classLoaderMatcher) && this.moduleMatcher.equals(forElementMatchers.moduleMatcher);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.typeMatcher.hashCode()) * 31) + this.classLoaderMatcher.hashCode()) * 31) + this.moduleMatcher.hashCode();
            }

            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain) {
                return this.moduleMatcher.matches(javaModule) && this.classLoaderMatcher.matches(classLoader) && this.typeMatcher.matches(typeDescription);
            }

            public ForElementMatchers(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                this(elementMatcher, elementMatcher2, ElementMatchers.any());
            }

            public ForElementMatchers(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                this.typeMatcher = elementMatcher;
                this.classLoaderMatcher = elementMatcher2;
                this.moduleMatcher = elementMatcher3;
            }
        }

        public enum ForLoadState implements RawMatcher {
            LOADED(false),
            UNLOADED(true);
            
            private final boolean unloaded;

            private ForLoadState(boolean z10) {
                this.unloaded = z10;
            }

            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain) {
                return (cls == null) == this.unloaded;
            }
        }

        public enum ForResolvableTypes implements RawMatcher {
            INSTANCE;

            public RawMatcher inverted() {
                return new Inversion(this);
            }

            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain) {
                if (cls == null) {
                    return true;
                }
                try {
                    return Class.forName(cls.getName(), true, classLoader) == cls;
                } catch (Throwable unused) {
                    return false;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Inversion implements RawMatcher {
            private final RawMatcher matcher;

            public Inversion(RawMatcher rawMatcher) {
                this.matcher = rawMatcher;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matcher.equals(((Inversion) obj).matcher);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.matcher.hashCode();
            }

            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain) {
                return !this.matcher.matches(typeDescription, classLoader, javaModule, cls, protectionDomain);
            }
        }

        public enum Trivial implements RawMatcher {
            MATCHING(true),
            NON_MATCHING(false);
            
            private final boolean matches;

            private Trivial(boolean z10) {
                this.matches = z10;
            }

            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain) {
                return this.matches;
            }
        }

        boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain);
    }

    public interface RedefinitionListenable extends AgentBuilder {

        public interface ResubmissionImmediateMatcher {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Conjunction implements ResubmissionImmediateMatcher {
                private final List<ResubmissionImmediateMatcher> matchers;

                public Conjunction(ResubmissionImmediateMatcher... resubmissionImmediateMatcherArr) {
                    this((List<? extends ResubmissionImmediateMatcher>) Arrays.asList(resubmissionImmediateMatcherArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matchers.hashCode();
                }

                public boolean matches(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    for (ResubmissionImmediateMatcher matches : this.matchers) {
                        if (!matches.matches(str, classLoader, javaModule)) {
                            return false;
                        }
                    }
                    return true;
                }

                public Conjunction(List<? extends ResubmissionImmediateMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionImmediateMatcher resubmissionImmediateMatcher : list) {
                        if (resubmissionImmediateMatcher instanceof Conjunction) {
                            this.matchers.addAll(((Conjunction) resubmissionImmediateMatcher).matchers);
                        } else if (resubmissionImmediateMatcher != Trivial.NON_MATCHING) {
                            this.matchers.add(resubmissionImmediateMatcher);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Disjunction implements ResubmissionImmediateMatcher {
                private final List<ResubmissionImmediateMatcher> matchers;

                public Disjunction(ResubmissionImmediateMatcher... resubmissionImmediateMatcherArr) {
                    this((List<? extends ResubmissionImmediateMatcher>) Arrays.asList(resubmissionImmediateMatcherArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matchers.hashCode();
                }

                public boolean matches(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    for (ResubmissionImmediateMatcher matches : this.matchers) {
                        if (matches.matches(str, classLoader, javaModule)) {
                            return true;
                        }
                    }
                    return false;
                }

                public Disjunction(List<? extends ResubmissionImmediateMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionImmediateMatcher resubmissionImmediateMatcher : list) {
                        if (resubmissionImmediateMatcher instanceof Disjunction) {
                            this.matchers.addAll(((Disjunction) resubmissionImmediateMatcher).matchers);
                        } else if (resubmissionImmediateMatcher != Trivial.NON_MATCHING) {
                            this.matchers.add(resubmissionImmediateMatcher);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForElementMatchers implements ResubmissionImmediateMatcher {
                private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
                private final ElementMatcher<? super JavaModule> moduleMatcher;
                private final ElementMatcher<String> typeNameMatcher;

                public ForElementMatchers(ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                    this.typeNameMatcher = elementMatcher;
                    this.classLoaderMatcher = elementMatcher2;
                    this.moduleMatcher = elementMatcher3;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                    return this.typeNameMatcher.equals(forElementMatchers.typeNameMatcher) && this.classLoaderMatcher.equals(forElementMatchers.classLoaderMatcher) && this.moduleMatcher.equals(forElementMatchers.moduleMatcher);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.typeNameMatcher.hashCode()) * 31) + this.classLoaderMatcher.hashCode()) * 31) + this.moduleMatcher.hashCode();
                }

                public boolean matches(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    if (!this.typeNameMatcher.matches(str) || !this.classLoaderMatcher.matches(classLoader) || !this.moduleMatcher.matches(javaModule)) {
                        return false;
                    }
                    return true;
                }
            }

            public enum Trivial implements ResubmissionImmediateMatcher {
                MATCHING(true),
                NON_MATCHING(false);
                
                private final boolean matching;

                private Trivial(boolean z10) {
                    this.matching = z10;
                }

                public boolean matches(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    return this.matching;
                }
            }

            boolean matches(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule);
        }

        public interface ResubmissionOnErrorMatcher {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Conjunction implements ResubmissionOnErrorMatcher {
                private final List<ResubmissionOnErrorMatcher> matchers;

                public Conjunction(ResubmissionOnErrorMatcher... resubmissionOnErrorMatcherArr) {
                    this((List<? extends ResubmissionOnErrorMatcher>) Arrays.asList(resubmissionOnErrorMatcherArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matchers.hashCode();
                }

                public boolean matches(Throwable th2, String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    for (ResubmissionOnErrorMatcher matches : this.matchers) {
                        if (!matches.matches(th2, str, classLoader, javaModule)) {
                            return false;
                        }
                    }
                    return true;
                }

                public Conjunction(List<? extends ResubmissionOnErrorMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionOnErrorMatcher resubmissionOnErrorMatcher : list) {
                        if (resubmissionOnErrorMatcher instanceof Conjunction) {
                            this.matchers.addAll(((Conjunction) resubmissionOnErrorMatcher).matchers);
                        } else if (resubmissionOnErrorMatcher != Trivial.MATCHING) {
                            this.matchers.add(resubmissionOnErrorMatcher);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Disjunction implements ResubmissionOnErrorMatcher {
                private final List<ResubmissionOnErrorMatcher> matchers;

                public Disjunction(ResubmissionOnErrorMatcher... resubmissionOnErrorMatcherArr) {
                    this((List<? extends ResubmissionOnErrorMatcher>) Arrays.asList(resubmissionOnErrorMatcherArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matchers.hashCode();
                }

                public boolean matches(Throwable th2, String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    for (ResubmissionOnErrorMatcher matches : this.matchers) {
                        if (matches.matches(th2, str, classLoader, javaModule)) {
                            return true;
                        }
                    }
                    return false;
                }

                public Disjunction(List<? extends ResubmissionOnErrorMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionOnErrorMatcher resubmissionOnErrorMatcher : list) {
                        if (resubmissionOnErrorMatcher instanceof Disjunction) {
                            this.matchers.addAll(((Disjunction) resubmissionOnErrorMatcher).matchers);
                        } else if (resubmissionOnErrorMatcher != Trivial.NON_MATCHING) {
                            this.matchers.add(resubmissionOnErrorMatcher);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForElementMatchers implements ResubmissionOnErrorMatcher {
                private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
                private final ElementMatcher<? super Throwable> exceptionMatcher;
                private final ElementMatcher<? super JavaModule> moduleMatcher;
                private final ElementMatcher<String> typeNameMatcher;

                public ForElementMatchers(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3, ElementMatcher<? super JavaModule> elementMatcher4) {
                    this.exceptionMatcher = elementMatcher;
                    this.typeNameMatcher = elementMatcher2;
                    this.classLoaderMatcher = elementMatcher3;
                    this.moduleMatcher = elementMatcher4;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                    return this.exceptionMatcher.equals(forElementMatchers.exceptionMatcher) && this.typeNameMatcher.equals(forElementMatchers.typeNameMatcher) && this.classLoaderMatcher.equals(forElementMatchers.classLoaderMatcher) && this.moduleMatcher.equals(forElementMatchers.moduleMatcher);
                }

                public int hashCode() {
                    return (((((((getClass().hashCode() * 31) + this.exceptionMatcher.hashCode()) * 31) + this.typeNameMatcher.hashCode()) * 31) + this.classLoaderMatcher.hashCode()) * 31) + this.moduleMatcher.hashCode();
                }

                public boolean matches(Throwable th2, String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    if (!this.exceptionMatcher.matches(th2) || !this.typeNameMatcher.matches(str) || !this.classLoaderMatcher.matches(classLoader) || !this.moduleMatcher.matches(javaModule)) {
                        return false;
                    }
                    return true;
                }
            }

            public enum Trivial implements ResubmissionOnErrorMatcher {
                MATCHING(true),
                NON_MATCHING(false);
                
                private final boolean matching;

                private Trivial(boolean z10) {
                    this.matching = z10;
                }

                public boolean matches(Throwable th2, String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule) {
                    return this.matching;
                }
            }

            boolean matches(Throwable th2, String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule);
        }

        public interface WithImplicitDiscoveryStrategy extends RedefinitionListenable {
            RedefinitionListenable redefineOnly(Class<?>... clsArr);

            RedefinitionListenable with(RedefinitionStrategy.DiscoveryStrategy discoveryStrategy);
        }

        public interface WithResubmissionSpecification extends WithoutResubmissionSpecification, AgentBuilder {
        }

        public interface WithoutBatchStrategy extends WithImplicitDiscoveryStrategy {
            WithImplicitDiscoveryStrategy with(RedefinitionStrategy.BatchAllocator batchAllocator);
        }

        public interface WithoutResubmissionSpecification {
            WithResubmissionSpecification resubmitImmediate();

            WithResubmissionSpecification resubmitImmediate(ResubmissionImmediateMatcher resubmissionImmediateMatcher);

            WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher);

            WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2);

            WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);

            WithResubmissionSpecification resubmitOnError();

            WithResubmissionSpecification resubmitOnError(ResubmissionOnErrorMatcher resubmissionOnErrorMatcher);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3, ElementMatcher<? super JavaModule> elementMatcher4);
        }

        RedefinitionListenable with(RedefinitionStrategy.Listener listener);

        WithoutResubmissionSpecification withResubmission(RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler);
    }

    public enum RedefinitionStrategy {
        DISABLED(false, false) {
            public void apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, DiscoveryStrategy discoveryStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, Listener listener, Listener listener2, RawMatcher rawMatcher, BatchAllocator batchAllocator, CircularityLock circularityLock) {
            }

            /* access modifiers changed from: protected */
            public void check(Instrumentation instrumentation) {
                throw new IllegalStateException("Cannot apply redefinition on disabled strategy");
            }

            /* access modifiers changed from: protected */
            public Collector make(PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, RawMatcher rawMatcher, CircularityLock circularityLock) {
                throw new IllegalStateException("A disabled redefinition strategy cannot create a collector");
            }
        },
        REDEFINITION(true, false) {
            /* access modifiers changed from: protected */
            public void check(Instrumentation instrumentation) {
                if (!instrumentation.isRedefineClassesSupported()) {
                    throw new IllegalStateException("Cannot apply redefinition on " + instrumentation);
                }
            }

            /* access modifiers changed from: protected */
            public Collector make(PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, RawMatcher rawMatcher, CircularityLock circularityLock) {
                return new Collector.ForRedefinition(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy, listener, fallbackStrategy, circularityLock);
            }
        },
        RETRANSFORMATION(true, true) {
            /* access modifiers changed from: protected */
            public void check(Instrumentation instrumentation) {
                if (!RedefinitionStrategy.DISPATCHER.isRetransformClassesSupported(instrumentation)) {
                    throw new IllegalStateException("Cannot apply retransformation on " + instrumentation);
                }
            }

            /* access modifiers changed from: protected */
            public Collector make(PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, RawMatcher rawMatcher, CircularityLock circularityLock) {
                return new Collector.ForRetransformation(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy, listener, fallbackStrategy, circularityLock);
            }
        };
        
        protected static final Dispatcher DISPATCHER = null;
        private final boolean enabled;
        private final boolean retransforming;

        public interface BatchAllocator {
            public static final int FIRST_BATCH = 0;

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFixedSize implements BatchAllocator {
                private final int size;

                protected ForFixedSize(int i10) {
                    this.size = i10;
                }

                public static BatchAllocator ofSize(int i10) {
                    if (i10 > 0) {
                        return new ForFixedSize(i10);
                    }
                    if (i10 == 0) {
                        return ForTotal.INSTANCE;
                    }
                    throw new IllegalArgumentException("Cannot define a batch with a negative size: " + i10);
                }

                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    ArrayList arrayList = new ArrayList();
                    int i10 = 0;
                    while (i10 < list.size()) {
                        arrayList.add(new ArrayList(list.subList(i10, Math.min(list.size(), this.size + i10))));
                        i10 += this.size;
                    }
                    return arrayList;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.size == ((ForFixedSize) obj).size;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.size;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForMatchedGrouping implements BatchAllocator {
                private final Collection<? extends ElementMatcher<? super TypeDescription>> matchers;

                public ForMatchedGrouping(ElementMatcher<? super TypeDescription>... elementMatcherArr) {
                    this((Collection<? extends ElementMatcher<? super TypeDescription>>) new LinkedHashSet(Arrays.asList(elementMatcherArr)));
                }

                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ArrayList arrayList = new ArrayList();
                    for (ElementMatcher put : this.matchers) {
                        linkedHashMap.put(put, new ArrayList());
                    }
                    for (Class next : list) {
                        Iterator<? extends ElementMatcher<? super TypeDescription>> it = this.matchers.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                arrayList.add(next);
                                break;
                            }
                            ElementMatcher elementMatcher = (ElementMatcher) it.next();
                            if (elementMatcher.matches(TypeDescription.ForLoadedType.of(next))) {
                                ((List) linkedHashMap.get(elementMatcher)).add(next);
                                break;
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(this.matchers.size() + 1);
                    for (List list2 : linkedHashMap.values()) {
                        if (!list2.isEmpty()) {
                            arrayList2.add(list2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        arrayList2.add(arrayList);
                    }
                    return arrayList2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matchers.equals(((ForMatchedGrouping) obj).matchers);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matchers.hashCode();
                }

                public BatchAllocator withMaximum(int i10) {
                    return Slicing.withMaximum(i10, this);
                }

                public BatchAllocator withMinimum(int i10) {
                    return Slicing.withMinimum(i10, this);
                }

                public BatchAllocator withinRange(int i10, int i11) {
                    return Slicing.withinRange(i10, i11, this);
                }

                public ForMatchedGrouping(Collection<? extends ElementMatcher<? super TypeDescription>> collection) {
                    this.matchers = collection;
                }
            }

            public enum ForTotal implements BatchAllocator {
                INSTANCE;

                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    if (list.isEmpty()) {
                        return Collections.emptySet();
                    }
                    return Collections.singleton(list);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Partitioning implements BatchAllocator {
                private final int parts;

                protected Partitioning(int i10) {
                    this.parts = i10;
                }

                public static BatchAllocator of(int i10) {
                    if (i10 >= 1) {
                        return new Partitioning(i10);
                    }
                    throw new IllegalArgumentException("A batch size must be positive: " + i10);
                }

                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    if (list.isEmpty()) {
                        return Collections.emptyList();
                    }
                    ArrayList arrayList = new ArrayList();
                    int size = list.size() / this.parts;
                    int size2 = list.size() % this.parts;
                    int i10 = size2;
                    while (i10 < list.size()) {
                        int i11 = i10 + size;
                        arrayList.add(new ArrayList(list.subList(i10, i11)));
                        i10 = i11;
                    }
                    if (arrayList.isEmpty()) {
                        return Collections.singletonList(list);
                    }
                    ((List) arrayList.get(0)).addAll(0, list.subList(0, size2));
                    return arrayList;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.parts == ((Partitioning) obj).parts;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.parts;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Slicing implements BatchAllocator {
                private final BatchAllocator batchAllocator;
                private final int maximum;
                private final int minimum;

                protected static class SlicingIterable implements Iterable<List<Class<?>>> {
                    private final Iterable<? extends List<Class<?>>> iterable;
                    private final int maximum;
                    private final int minimum;

                    protected static class SlicingIterator implements Iterator<List<Class<?>>> {
                        private List<Class<?>> buffer;
                        private final Iterator<? extends List<Class<?>>> iterator;
                        private final int maximum;
                        private final int minimum;

                        protected SlicingIterator(int i10, int i11, Iterator<? extends List<Class<?>>> it) {
                            this.minimum = i10;
                            this.maximum = i11;
                            this.iterator = it;
                            this.buffer = new ArrayList();
                        }

                        public boolean hasNext() {
                            return !this.buffer.isEmpty() || this.iterator.hasNext();
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("remove");
                        }

                        public List<Class<?>> next() {
                            if (this.buffer.isEmpty()) {
                                this.buffer = (List) this.iterator.next();
                            }
                            while (this.buffer.size() < this.minimum && this.iterator.hasNext()) {
                                this.buffer.addAll((Collection) this.iterator.next());
                            }
                            int size = this.buffer.size();
                            int i10 = this.maximum;
                            if (size > i10) {
                                try {
                                    return this.buffer.subList(0, i10);
                                } finally {
                                    List<Class<?>> list = this.buffer;
                                    this.buffer = new ArrayList(list.subList(this.maximum, list.size()));
                                }
                            } else {
                                try {
                                    return this.buffer;
                                } finally {
                                    this.buffer = new ArrayList();
                                }
                            }
                        }
                    }

                    protected SlicingIterable(int i10, int i11, Iterable<? extends List<Class<?>>> iterable2) {
                        this.minimum = i10;
                        this.maximum = i11;
                        this.iterable = iterable2;
                    }

                    public Iterator<List<Class<?>>> iterator() {
                        return new SlicingIterator(this.minimum, this.maximum, this.iterable.iterator());
                    }
                }

                protected Slicing(int i10, int i11, BatchAllocator batchAllocator2) {
                    this.minimum = i10;
                    this.maximum = i11;
                    this.batchAllocator = batchAllocator2;
                }

                public static BatchAllocator withMaximum(int i10, BatchAllocator batchAllocator2) {
                    return withinRange(1, i10, batchAllocator2);
                }

                public static BatchAllocator withMinimum(int i10, BatchAllocator batchAllocator2) {
                    return withinRange(i10, a.e.API_PRIORITY_OTHER, batchAllocator2);
                }

                public static BatchAllocator withinRange(int i10, int i11, BatchAllocator batchAllocator2) {
                    if (i10 <= 0) {
                        throw new IllegalArgumentException("Minimum must be a positive number: " + i10);
                    } else if (i10 <= i11) {
                        return new Slicing(i10, i11, batchAllocator2);
                    } else {
                        throw new IllegalArgumentException("Minimum must not be bigger than maximum: " + i10 + " >" + i11);
                    }
                }

                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    return new SlicingIterable(this.minimum, this.maximum, this.batchAllocator.batch(list));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Slicing slicing = (Slicing) obj;
                    return this.minimum == slicing.minimum && this.maximum == slicing.maximum && this.batchAllocator.equals(slicing.batchAllocator);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.minimum) * 31) + this.maximum) * 31) + this.batchAllocator.hashCode();
                }
            }

            Iterable<? extends List<Class<?>>> batch(List<Class<?>> list);
        }

        protected static abstract class Collector {
            protected final CircularityLock circularityLock;
            private final DescriptionStrategy descriptionStrategy;
            private final FallbackStrategy fallbackStrategy;
            protected final Listener listener;
            protected final LocationStrategy locationStrategy;
            private final RawMatcher matcher;
            private final PoolStrategy poolStrategy;
            protected final List<Class<?>> types;

            protected static class ForRedefinition extends Collector {
                protected ForRedefinition(RawMatcher rawMatcher, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, Listener listener, FallbackStrategy fallbackStrategy, CircularityLock circularityLock) {
                    super(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy, listener, fallbackStrategy, circularityLock);
                }

                /* access modifiers changed from: protected */
                public void doApply(Instrumentation instrumentation, List<Class<?>> list) throws UnmodifiableClassException, ClassNotFoundException {
                    Throwable th2;
                    JavaModule ofType;
                    ArrayList arrayList = new ArrayList(list.size());
                    for (Class next : list) {
                        try {
                            arrayList.add(new ClassDefinition(next, this.locationStrategy.classFileLocator(next.getClassLoader(), JavaModule.ofType(next)).locate(TypeDescription.ForLoadedType.getName(next)).resolve()));
                        } catch (Throwable th3) {
                            this.listener.onComplete(TypeDescription.ForLoadedType.getName(next), next.getClassLoader(), ofType, true);
                            throw th3;
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        this.circularityLock.release();
                        try {
                            instrumentation.redefineClasses((ClassDefinition[]) arrayList.toArray(new ClassDefinition[0]));
                        } finally {
                            this.circularityLock.acquire();
                        }
                    }
                }
            }

            protected static class ForRetransformation extends Collector {
                protected ForRetransformation(RawMatcher rawMatcher, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, Listener listener, FallbackStrategy fallbackStrategy, CircularityLock circularityLock) {
                    super(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy, listener, fallbackStrategy, circularityLock);
                }

                /* access modifiers changed from: protected */
                public void doApply(Instrumentation instrumentation, List<Class<?>> list) throws UnmodifiableClassException {
                    if (!list.isEmpty()) {
                        this.circularityLock.release();
                        try {
                            RedefinitionStrategy.DISPATCHER.retransformClasses(instrumentation, (Class[]) list.toArray(new Class[0]));
                        } finally {
                            this.circularityLock.acquire();
                        }
                    }
                }
            }

            protected static class PrependableIterator implements Iterator<List<Class<?>>> {
                private final List<Iterator<? extends List<Class<?>>>> backlog;
                private Iterator<? extends List<Class<?>>> current;

                protected PrependableIterator(Iterable<? extends List<Class<?>>> iterable) {
                    this.current = iterable.iterator();
                    this.backlog = new ArrayList();
                }

                public boolean hasNext() {
                    return this.current.hasNext();
                }

                public void prepend(Iterable<? extends List<Class<?>>> iterable) {
                    Iterator<? extends List<Class<?>>> it = iterable.iterator();
                    if (it.hasNext()) {
                        if (this.current.hasNext()) {
                            this.backlog.add(this.current);
                        }
                        this.current = it;
                    }
                }

                public void remove() {
                    throw new UnsupportedOperationException("remove");
                }

                /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: 
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                    	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                    */
                public java.util.List<java.lang.Class<?>> next() {
                    /*
                        r3 = this;
                        java.util.Iterator<? extends java.util.List<java.lang.Class<?>>> r0 = r3.current     // Catch:{ all -> 0x002a }
                        java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x002a }
                        java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x002a }
                    L_0x0008:
                        java.util.Iterator<? extends java.util.List<java.lang.Class<?>>> r1 = r3.current
                        boolean r1 = r1.hasNext()
                        if (r1 != 0) goto L_0x0029
                        java.util.List<java.util.Iterator<? extends java.util.List<java.lang.Class<?>>>> r1 = r3.backlog
                        boolean r1 = r1.isEmpty()
                        if (r1 != 0) goto L_0x0029
                        java.util.List<java.util.Iterator<? extends java.util.List<java.lang.Class<?>>>> r1 = r3.backlog
                        int r2 = r1.size()
                        int r2 = r2 + -1
                        java.lang.Object r1 = r1.remove(r2)
                        java.util.Iterator r1 = (java.util.Iterator) r1
                        r3.current = r1
                        goto L_0x0008
                    L_0x0029:
                        return r0
                    L_0x002a:
                        r0 = move-exception
                    L_0x002b:
                        java.util.Iterator<? extends java.util.List<java.lang.Class<?>>> r1 = r3.current
                        boolean r1 = r1.hasNext()
                        if (r1 != 0) goto L_0x004c
                        java.util.List<java.util.Iterator<? extends java.util.List<java.lang.Class<?>>>> r1 = r3.backlog
                        boolean r1 = r1.isEmpty()
                        if (r1 != 0) goto L_0x004c
                        java.util.List<java.util.Iterator<? extends java.util.List<java.lang.Class<?>>>> r1 = r3.backlog
                        int r2 = r1.size()
                        int r2 = r2 + -1
                        java.lang.Object r1 = r1.remove(r2)
                        java.util.Iterator r1 = (java.util.Iterator) r1
                        r3.current = r1
                        goto L_0x002b
                    L_0x004c:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Collector.PrependableIterator.next():java.util.List");
                }
            }

            protected Collector(RawMatcher rawMatcher, PoolStrategy poolStrategy2, LocationStrategy locationStrategy2, DescriptionStrategy descriptionStrategy2, Listener listener2, FallbackStrategy fallbackStrategy2, CircularityLock circularityLock2) {
                this.matcher = rawMatcher;
                this.poolStrategy = poolStrategy2;
                this.locationStrategy = locationStrategy2;
                this.descriptionStrategy = descriptionStrategy2;
                this.listener = listener2;
                this.fallbackStrategy = fallbackStrategy2;
                this.circularityLock = circularityLock2;
                this.types = new ArrayList();
            }

            private void doConsider(RawMatcher rawMatcher, Listener listener2, TypeDescription typeDescription, Class<?> cls, @MaybeNull Class<?> cls2, @MaybeNull JavaModule javaModule, boolean z10) {
                boolean z11;
                String name;
                ClassLoader classLoader;
                boolean z12;
                boolean z13;
                if (z10) {
                    if (rawMatcher.matches(typeDescription, cls.getClassLoader(), javaModule, cls2, cls.getProtectionDomain())) {
                        this.types.add(cls);
                        return;
                    }
                }
                boolean z14 = true;
                try {
                    String name2 = TypeDescription.ForLoadedType.getName(cls);
                    ClassLoader classLoader2 = cls.getClassLoader();
                    if (cls2 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    listener2.onDiscovery(name2, classLoader2, javaModule, z12);
                    ClassLoader classLoader3 = cls.getClassLoader();
                    if (cls2 != null) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    listener2.onIgnored(typeDescription, classLoader3, javaModule, z13);
                    name = TypeDescription.ForLoadedType.getName(cls);
                    classLoader = cls.getClassLoader();
                    if (cls2 != null) {
                        listener2.onComplete(name, classLoader, javaModule, z14);
                    }
                } catch (Throwable unused) {
                    return;
                }
                z14 = false;
                listener2.onComplete(name, classLoader, javaModule, z14);
            }

            /* access modifiers changed from: protected */
            public int apply(Instrumentation instrumentation, BatchAllocator batchAllocator, Listener listener2, int i10) {
                HashMap hashMap = new HashMap();
                PrependableIterator prependableIterator = new PrependableIterator(batchAllocator.batch(this.types));
                while (prependableIterator.hasNext()) {
                    List next = prependableIterator.next();
                    listener2.onBatch(i10, next, this.types);
                    try {
                        doApply(instrumentation, next);
                    } catch (Throwable th2) {
                        prependableIterator.prepend(listener2.onError(i10, next, th2, this.types));
                        hashMap.put(next, th2);
                    }
                    i10++;
                }
                listener2.onComplete(i10, this.types, hashMap);
                return i10;
            }

            /* access modifiers changed from: protected */
            public void consider(Class<?> cls, boolean z10) {
                TypePool typePool;
                JavaModule ofType = JavaModule.ofType(cls);
                try {
                    typePool = this.poolStrategy.typePool(this.locationStrategy.classFileLocator(cls.getClassLoader(), ofType), cls.getClassLoader());
                    doConsider(this.matcher, this.listener, this.descriptionStrategy.apply(TypeDescription.ForLoadedType.getName(cls), cls, typePool, this.circularityLock, cls.getClassLoader(), ofType), cls, cls, ofType, z10);
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    try {
                        this.listener.onDiscovery(TypeDescription.ForLoadedType.getName(cls), cls.getClassLoader(), ofType, true);
                        this.listener.onError(TypeDescription.ForLoadedType.getName(cls), cls.getClassLoader(), ofType, true, th3);
                        this.listener.onComplete(TypeDescription.ForLoadedType.getName(cls), cls.getClassLoader(), ofType, true);
                    } catch (Throwable unused) {
                    }
                }
            }

            /* access modifiers changed from: protected */
            public abstract void doApply(Instrumentation instrumentation, List<Class<?>> list) throws UnmodifiableClassException, ClassNotFoundException;
        }

        public interface DiscoveryStrategy {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Explicit implements DiscoveryStrategy {
                private final Set<Class<?>> types;

                public Explicit(Class<?>... clsArr) {
                    this((Set<Class<?>>) new LinkedHashSet(Arrays.asList(clsArr)));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.types.equals(((Explicit) obj).types);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.types.hashCode();
                }

                public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                    return Collections.singleton(this.types);
                }

                public Explicit(Set<Class<?>> set) {
                    this.types = set;
                }
            }

            public enum Reiterating implements DiscoveryStrategy {
                INSTANCE;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class ReiteratingIterable implements Iterable<Iterable<Class<?>>> {
                    private final Instrumentation instrumentation;

                    protected ReiteratingIterable(Instrumentation instrumentation2) {
                        this.instrumentation = instrumentation2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.instrumentation.equals(((ReiteratingIterable) obj).instrumentation);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.instrumentation.hashCode();
                    }

                    public Iterator<Iterable<Class<?>>> iterator() {
                        return new ReiteratingIterator(this.instrumentation);
                    }
                }

                protected static class ReiteratingIterator implements Iterator<Iterable<Class<?>>> {
                    private final Instrumentation instrumentation;
                    private final Set<Class<?>> processed;
                    @MaybeNull
                    private List<Class<?>> types;

                    protected ReiteratingIterator(Instrumentation instrumentation2) {
                        this.instrumentation = instrumentation2;
                        this.processed = new HashSet();
                    }

                    public boolean hasNext() {
                        if (this.types == null) {
                            this.types = new ArrayList();
                            for (Class cls : this.instrumentation.getAllLoadedClasses()) {
                                if (cls != null && this.processed.add(cls)) {
                                    this.types.add(cls);
                                }
                            }
                        }
                        return !this.types.isEmpty();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("remove");
                    }

                    public Iterable<Class<?>> next() {
                        if (hasNext()) {
                            try {
                                return this.types;
                            } finally {
                                this.types = null;
                            }
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                }

                enum WithSortOrderAssumption implements DiscoveryStrategy {
                    INSTANCE;

                    @HashCodeAndEqualsPlugin.Enhance
                    protected static class OrderedReiteratingIterable implements Iterable<Iterable<Class<?>>> {
                        private final Instrumentation instrumentation;

                        protected OrderedReiteratingIterable(Instrumentation instrumentation2) {
                            this.instrumentation = instrumentation2;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.instrumentation.equals(((OrderedReiteratingIterable) obj).instrumentation);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.instrumentation.hashCode();
                        }

                        public Iterator<Iterable<Class<?>>> iterator() {
                            return new OrderedReiteratingIterator(this.instrumentation);
                        }
                    }

                    protected static class OrderedReiteratingIterator implements Iterator<Iterable<Class<?>>> {
                        private int index;
                        private final Instrumentation instrumentation;
                        @MaybeNull
                        private List<Class<?>> types;

                        protected OrderedReiteratingIterator(Instrumentation instrumentation2) {
                            this.instrumentation = instrumentation2;
                            this.index = 0;
                        }

                        public boolean hasNext() {
                            if (this.types == null) {
                                Class[] allLoadedClasses = this.instrumentation.getAllLoadedClasses();
                                this.types = new ArrayList(Arrays.asList(allLoadedClasses).subList(this.index, allLoadedClasses.length));
                                this.index = allLoadedClasses.length;
                            }
                            return !this.types.isEmpty();
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("remove");
                        }

                        public Iterable<Class<?>> next() {
                            if (hasNext()) {
                                try {
                                    return this.types;
                                } finally {
                                    this.types = null;
                                }
                            } else {
                                throw new NoSuchElementException();
                            }
                        }
                    }

                    public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                        return new OrderedReiteratingIterable(instrumentation);
                    }
                }

                public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                    return new ReiteratingIterable(instrumentation);
                }
            }

            public enum SinglePass implements DiscoveryStrategy {
                INSTANCE;

                public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                    return Collections.singleton(Arrays.asList(instrumentation.getAllLoadedClasses()));
                }
            }

            Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation);
        }

        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        protected interface Dispatcher {
            @JavaDispatcher.Proxied("isModifiableClass")
            boolean isModifiableClass(Instrumentation instrumentation, Class<?> cls);

            @JavaDispatcher.Proxied("isRetransformClassesSupported")
            @JavaDispatcher.Defaults
            boolean isRetransformClassesSupported(Instrumentation instrumentation);

            @JavaDispatcher.Proxied("retransformClasses")
            void retransformClasses(Instrumentation instrumentation, Class<?>[] clsArr) throws UnmodifiableClassException;
        }

        public interface Listener {

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Adapter implements Listener {
                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass();
                }

                public int hashCode() {
                    return getClass().hashCode();
                }

                public void onBatch(int i10, List<Class<?>> list, List<Class<?>> list2) {
                }

                public void onComplete(int i10, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                }

                public Iterable<? extends List<Class<?>>> onError(int i10, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    return Collections.emptyList();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class BatchReallocator extends Adapter {
                private final BatchAllocator batchAllocator;

                public BatchReallocator(BatchAllocator batchAllocator2) {
                    this.batchAllocator = batchAllocator2;
                }

                public static Listener splitting() {
                    return new BatchReallocator(new BatchAllocator.Partitioning(2));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.batchAllocator.equals(((BatchReallocator) obj).batchAllocator);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.batchAllocator.hashCode();
                }

                public Iterable<? extends List<Class<?>>> onError(int i10, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    if (list.size() < 2) {
                        return Collections.emptyList();
                    }
                    return this.batchAllocator.batch(list);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Listener {
                private final List<Listener> listeners;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class CompoundIterable implements Iterable<List<Class<?>>> {
                    private final List<Iterable<? extends List<Class<?>>>> iterables;

                    protected static class CompoundIterator implements Iterator<List<Class<?>>> {
                        private final List<Iterable<? extends List<Class<?>>>> backlog;
                        @MaybeNull
                        private Iterator<? extends List<Class<?>>> current;

                        protected CompoundIterator(List<Iterable<? extends List<Class<?>>>> list) {
                            this.backlog = list;
                            forward();
                        }

                        private void forward() {
                            while (true) {
                                Iterator<? extends List<Class<?>>> it = this.current;
                                if ((it == null || !it.hasNext()) && !this.backlog.isEmpty()) {
                                    this.current = this.backlog.remove(0).iterator();
                                } else {
                                    return;
                                }
                            }
                        }

                        public boolean hasNext() {
                            Iterator<? extends List<Class<?>>> it = this.current;
                            return it != null && it.hasNext();
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("remove");
                        }

                        public List<Class<?>> next() {
                            try {
                                Iterator<? extends List<Class<?>>> it = this.current;
                                if (it != null) {
                                    return (List) it.next();
                                }
                                throw new NoSuchElementException();
                            } finally {
                                forward();
                            }
                        }
                    }

                    protected CompoundIterable(List<Iterable<? extends List<Class<?>>>> list) {
                        this.iterables = list;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.iterables.equals(((CompoundIterable) obj).iterables);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.iterables.hashCode();
                    }

                    public Iterator<List<Class<?>>> iterator() {
                        return new CompoundIterator(new ArrayList(this.iterables));
                    }
                }

                public Compound(Listener... listenerArr) {
                    this((List<? extends Listener>) Arrays.asList(listenerArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.listeners.equals(((Compound) obj).listeners);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.listeners.hashCode();
                }

                public void onBatch(int i10, List<Class<?>> list, List<Class<?>> list2) {
                    for (Listener onBatch : this.listeners) {
                        onBatch.onBatch(i10, list, list2);
                    }
                }

                public void onComplete(int i10, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                    for (Listener onComplete : this.listeners) {
                        onComplete.onComplete(i10, list, map);
                    }
                }

                public Iterable<? extends List<Class<?>>> onError(int i10, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    ArrayList arrayList = new ArrayList();
                    for (Listener onError : this.listeners) {
                        arrayList.add(onError.onError(i10, list, th2, list2));
                    }
                    return new CompoundIterable(arrayList);
                }

                public Compound(List<? extends Listener> list) {
                    this.listeners = new ArrayList();
                    for (Listener listener : list) {
                        if (listener instanceof Compound) {
                            this.listeners.addAll(((Compound) listener).listeners);
                        } else if (!(listener instanceof NoOp)) {
                            this.listeners.add(listener);
                        }
                    }
                }
            }

            public enum ErrorEscalating implements Listener {
                FAIL_FAST {
                    public void onComplete(int i10, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                    }

                    public Iterable<? extends List<Class<?>>> onError(int i10, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                        throw new IllegalStateException("Could not transform any of " + list, th2);
                    }
                },
                FAIL_LAST {
                    public void onComplete(int i10, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                        if (!map.isEmpty()) {
                            throw new IllegalStateException("Could not transform any of " + map);
                        }
                    }

                    public Iterable<? extends List<Class<?>>> onError(int i10, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                        return Collections.emptyList();
                    }
                };

                public void onBatch(int i10, List<Class<?>> list, List<Class<?>> list2) {
                }
            }

            public enum NoOp implements Listener {
                INSTANCE;

                public void onBatch(int i10, List<Class<?>> list, List<Class<?>> list2) {
                }

                public void onComplete(int i10, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                }

                public Iterable<? extends List<Class<?>>> onError(int i10, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    return Collections.emptyList();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Pausing extends Adapter {
                private final long value;

                protected Pausing(long j10) {
                    this.value = j10;
                }

                public static Listener of(long j10, TimeUnit timeUnit) {
                    int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
                    if (i10 > 0) {
                        return new Pausing(timeUnit.toMillis(j10));
                    }
                    if (i10 == 0) {
                        return NoOp.INSTANCE;
                    }
                    throw new IllegalArgumentException("Cannot sleep for a non-positive amount of time: " + j10);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value == ((Pausing) obj).value;
                }

                public int hashCode() {
                    long j10 = this.value;
                    return (super.hashCode() * 31) + ((int) (j10 ^ (j10 >>> 32)));
                }

                public void onBatch(int i10, List<Class<?>> list, List<Class<?>> list2) {
                    if (i10 > 0) {
                        try {
                            Thread.sleep(this.value);
                        } catch (InterruptedException e10) {
                            Thread.currentThread().interrupt();
                            throw new IllegalStateException(e10);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class StreamWriting implements Listener {
                private final PrintStream printStream;

                public StreamWriting(PrintStream printStream2) {
                    this.printStream = printStream2;
                }

                public static Listener toSystemError() {
                    return new StreamWriting(System.err);
                }

                public static Listener toSystemOut() {
                    return new StreamWriting(System.out);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.printStream.equals(((StreamWriting) obj).printStream);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.printStream.hashCode();
                }

                public void onBatch(int i10, List<Class<?>> list, List<Class<?>> list2) {
                    this.printStream.printf("[Byte Buddy] REDEFINE BATCH #%d [%d of %d type(s)]%n", new Object[]{Integer.valueOf(i10), Integer.valueOf(list.size()), Integer.valueOf(list2.size())});
                }

                public void onComplete(int i10, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                    this.printStream.printf("[Byte Buddy] REDEFINE COMPLETE %d batch(es) containing %d types [%d failed batch(es)]%n", new Object[]{Integer.valueOf(i10), Integer.valueOf(list.size()), Integer.valueOf(map.size())});
                }

                public Iterable<? extends List<Class<?>>> onError(int i10, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    synchronized (this.printStream) {
                        this.printStream.printf("[Byte Buddy] REDEFINE ERROR #%d [%d of %d type(s)]%n", new Object[]{Integer.valueOf(i10), Integer.valueOf(list.size()), Integer.valueOf(list2.size())});
                        th2.printStackTrace(this.printStream);
                    }
                    return Collections.emptyList();
                }
            }

            public enum Yielding implements Listener {
                INSTANCE;

                public void onBatch(int i10, List<Class<?>> list, List<Class<?>> list2) {
                    if (i10 > 0) {
                        Thread.yield();
                    }
                }

                public void onComplete(int i10, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                }

                public Iterable<? extends List<Class<?>>> onError(int i10, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    return Collections.emptyList();
                }
            }

            void onBatch(int i10, List<Class<?>> list, List<Class<?>> list2);

            void onComplete(int i10, List<Class<?>> list, Map<List<Class<?>>, Throwable> map);

            Iterable<? extends List<Class<?>>> onError(int i10, List<Class<?>> list, Throwable th2, List<Class<?>> list2);
        }

        protected interface ResubmissionEnforcer {

            public enum Disabled implements ResubmissionEnforcer {
                INSTANCE;

                public boolean isEnforced(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls) {
                    return false;
                }
            }

            boolean isEnforced(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls);
        }

        public interface ResubmissionScheduler {

            @HashCodeAndEqualsPlugin.Enhance
            public static class AtFixedRate implements ResubmissionScheduler {
                private final ScheduledExecutorService scheduledExecutorService;
                private final long time;
                private final TimeUnit timeUnit;

                public AtFixedRate(ScheduledExecutorService scheduledExecutorService2, long j10, TimeUnit timeUnit2) {
                    this.scheduledExecutorService = scheduledExecutorService2;
                    this.time = j10;
                    this.timeUnit = timeUnit2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AtFixedRate atFixedRate = (AtFixedRate) obj;
                    return this.time == atFixedRate.time && this.timeUnit.equals(atFixedRate.timeUnit) && this.scheduledExecutorService.equals(atFixedRate.scheduledExecutorService);
                }

                public int hashCode() {
                    long j10 = this.time;
                    return (((((getClass().hashCode() * 31) + this.scheduledExecutorService.hashCode()) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.timeUnit.hashCode();
                }

                public boolean isAlive() {
                    return !this.scheduledExecutorService.isShutdown();
                }

                public Cancelable schedule(Runnable runnable) {
                    ScheduledExecutorService scheduledExecutorService2 = this.scheduledExecutorService;
                    long j10 = this.time;
                    return new Cancelable.ForFuture(scheduledExecutorService2.scheduleAtFixedRate(runnable, j10, j10, this.timeUnit));
                }
            }

            public interface Cancelable {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForFuture implements Cancelable {
                    private final Future<?> future;

                    public ForFuture(Future<?> future2) {
                        this.future = future2;
                    }

                    public void cancel() {
                        this.future.cancel(true);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.future.equals(((ForFuture) obj).future);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.future.hashCode();
                    }
                }

                public enum NoOp implements Cancelable {
                    INSTANCE;

                    public void cancel() {
                    }
                }

                void cancel();
            }

            public enum NoOp implements ResubmissionScheduler {
                INSTANCE;

                public boolean isAlive() {
                    return false;
                }

                public Cancelable schedule(Runnable runnable) {
                    return Cancelable.NoOp.INSTANCE;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class WithFixedDelay implements ResubmissionScheduler {
                private final ScheduledExecutorService scheduledExecutorService;
                private final long time;
                private final TimeUnit timeUnit;

                public WithFixedDelay(ScheduledExecutorService scheduledExecutorService2, long j10, TimeUnit timeUnit2) {
                    this.scheduledExecutorService = scheduledExecutorService2;
                    this.time = j10;
                    this.timeUnit = timeUnit2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    WithFixedDelay withFixedDelay = (WithFixedDelay) obj;
                    return this.time == withFixedDelay.time && this.timeUnit.equals(withFixedDelay.timeUnit) && this.scheduledExecutorService.equals(withFixedDelay.scheduledExecutorService);
                }

                public int hashCode() {
                    long j10 = this.time;
                    return (((((getClass().hashCode() * 31) + this.scheduledExecutorService.hashCode()) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.timeUnit.hashCode();
                }

                public boolean isAlive() {
                    return !this.scheduledExecutorService.isShutdown();
                }

                public Cancelable schedule(Runnable runnable) {
                    ScheduledExecutorService scheduledExecutorService2 = this.scheduledExecutorService;
                    long j10 = this.time;
                    return new Cancelable.ForFuture(scheduledExecutorService2.scheduleWithFixedDelay(runnable, j10, j10, this.timeUnit));
                }
            }

            boolean isAlive();

            Cancelable schedule(Runnable runnable);
        }

        protected interface ResubmissionStrategy {

            public enum Disabled implements ResubmissionStrategy {
                INSTANCE;

                public Installation apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, InstallationListener installationListener, CircularityLock circularityLock, RawMatcher rawMatcher, RedefinitionStrategy redefinitionStrategy, BatchAllocator batchAllocator, Listener listener2) {
                    return new Installation(listener, installationListener, ResubmissionEnforcer.Disabled.INSTANCE);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements ResubmissionStrategy {
                private final RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
                private final RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
                private final ResubmissionScheduler resubmissionScheduler;

                protected static class LookupKey {
                    /* access modifiers changed from: private */
                    @MaybeNull
                    public final ClassLoader classLoader;
                    /* access modifiers changed from: private */
                    public final int hashCode;

                    protected LookupKey(@MaybeNull ClassLoader classLoader2) {
                        this.classLoader = classLoader2;
                        this.hashCode = System.identityHashCode(classLoader2);
                    }

                    @SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof LookupKey) {
                            if (this.classLoader == ((LookupKey) obj).classLoader) {
                                return true;
                            }
                            return false;
                        } else if (!(obj instanceof StorageKey)) {
                            return false;
                        } else {
                            StorageKey storageKey = (StorageKey) obj;
                            if (this.hashCode == storageKey.hashCode && this.classLoader == storageKey.get()) {
                                return true;
                            }
                            return false;
                        }
                    }

                    public int hashCode() {
                        return this.hashCode;
                    }
                }

                protected static class ResubmissionInstallationListener extends InstallationListener.Adapter implements Runnable {
                    @MaybeNull
                    private volatile ResubmissionScheduler.Cancelable cancelable;
                    private final CircularityLock circularityLock;
                    private final DescriptionStrategy descriptionStrategy;
                    private final FallbackStrategy fallbackStrategy;
                    private final Instrumentation instrumentation;
                    private final Listener listener;
                    private final LocationStrategy locationStrategy;
                    private final RawMatcher matcher;
                    private final PoolStrategy poolStrategy;
                    private final BatchAllocator redefinitionBatchAllocator;
                    private final Listener redefinitionBatchListener;
                    private final RedefinitionStrategy redefinitionStrategy;
                    private final ResubmissionScheduler resubmissionScheduler;
                    private final ConcurrentMap<StorageKey, Set<String>> types;

                    protected ResubmissionInstallationListener(Instrumentation instrumentation2, ResubmissionScheduler resubmissionScheduler2, PoolStrategy poolStrategy2, LocationStrategy locationStrategy2, DescriptionStrategy descriptionStrategy2, FallbackStrategy fallbackStrategy2, Listener listener2, CircularityLock circularityLock2, RawMatcher rawMatcher, RedefinitionStrategy redefinitionStrategy2, BatchAllocator batchAllocator, Listener listener3, ConcurrentMap<StorageKey, Set<String>> concurrentMap) {
                        this.instrumentation = instrumentation2;
                        this.resubmissionScheduler = resubmissionScheduler2;
                        this.poolStrategy = poolStrategy2;
                        this.locationStrategy = locationStrategy2;
                        this.descriptionStrategy = descriptionStrategy2;
                        this.fallbackStrategy = fallbackStrategy2;
                        this.listener = listener2;
                        this.circularityLock = circularityLock2;
                        this.matcher = rawMatcher;
                        this.redefinitionStrategy = redefinitionStrategy2;
                        this.redefinitionBatchAllocator = batchAllocator;
                        this.redefinitionBatchListener = listener3;
                        this.types = concurrentMap;
                    }

                    public void onInstall(Instrumentation instrumentation2, ResettableClassFileTransformer resettableClassFileTransformer) {
                        this.cancelable = this.resubmissionScheduler.schedule(this);
                    }

                    public void onReset(Instrumentation instrumentation2, ResettableClassFileTransformer resettableClassFileTransformer) {
                        ResubmissionScheduler.Cancelable cancelable2 = this.cancelable;
                        if (cancelable2 != null) {
                            cancelable2.cancel();
                        }
                    }

                    /* JADX WARNING: Can't wrap try/catch for region: R(7:23|24|(6:28|(1:30)|32|34|35|36)|33|34|35|36) */
                    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a6, code lost:
                        if (net.bytebuddy.ClassFileVersion.ofThisVm(r7).isAtMost(r7) != false) goto L_0x00a8;
                     */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ae */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r9 = this;
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                            boolean r0 = r0.acquire()
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy r1 = r9.redefinitionStrategy     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$PoolStrategy r2 = r9.poolStrategy     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$LocationStrategy r3 = r9.locationStrategy     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$DescriptionStrategy r4 = r9.descriptionStrategy     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$FallbackStrategy r5 = r9.fallbackStrategy     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$Listener r6 = r9.listener     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r7 = r9.matcher     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r8 = r9.circularityLock     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$Collector r1 = r1.make(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00c3 }
                            java.util.concurrent.ConcurrentMap<net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey, java.util.Set<java.lang.String>> r2 = r9.types     // Catch:{ all -> 0x00c3 }
                            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x00c3 }
                            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00c3 }
                        L_0x0024:
                            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00c3 }
                            r4 = 0
                            if (r3 == 0) goto L_0x00b2
                            boolean r3 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x00c3 }
                            if (r3 == 0) goto L_0x0039
                            if (r0 == 0) goto L_0x0038
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                            r0.release()
                        L_0x0038:
                            return
                        L_0x0039:
                            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00c3 }
                            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x00c3 }
                            java.lang.Object r5 = r3.getKey()     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey r5 = (net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey) r5     // Catch:{ all -> 0x00c3 }
                            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x00c3 }
                            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00c3 }
                            if (r5 != 0) goto L_0x005e
                            java.lang.Object r6 = r3.getKey()     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey r6 = (net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey) r6     // Catch:{ all -> 0x00c3 }
                            boolean r6 = r6.isBootstrapLoader()     // Catch:{ all -> 0x00c3 }
                            if (r6 == 0) goto L_0x005a
                            goto L_0x005e
                        L_0x005a:
                            r2.remove()     // Catch:{ all -> 0x00c3 }
                            goto L_0x0024
                        L_0x005e:
                            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00c3 }
                            java.util.Set r3 = (java.util.Set) r3     // Catch:{ all -> 0x00c3 }
                            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00c3 }
                        L_0x0068:
                            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x00c3 }
                            if (r6 == 0) goto L_0x0024
                            boolean r6 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x00c3 }
                            if (r6 == 0) goto L_0x007c
                            if (r0 == 0) goto L_0x007b
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                            r0.release()
                        L_0x007b:
                            return
                        L_0x007c:
                            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x00ae }
                            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00ae }
                            java.lang.Class r6 = java.lang.Class.forName(r6, r4, r5)     // Catch:{ all -> 0x00ae }
                            boolean r7 = r6.isArray()     // Catch:{ all -> 0x00ae }
                            if (r7 != 0) goto L_0x00aa
                            boolean r7 = r6.isPrimitive()     // Catch:{ all -> 0x00ae }
                            if (r7 != 0) goto L_0x00aa
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$Dispatcher r7 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DISPATCHER     // Catch:{ all -> 0x00ae }
                            java.lang.instrument.Instrumentation r8 = r9.instrumentation     // Catch:{ all -> 0x00ae }
                            boolean r7 = r7.isModifiableClass(r8, r6)     // Catch:{ all -> 0x00ae }
                            if (r7 != 0) goto L_0x00a8
                            net.bytebuddy.ClassFileVersion r7 = net.bytebuddy.ClassFileVersion.JAVA_V5     // Catch:{ all -> 0x00ae }
                            net.bytebuddy.ClassFileVersion r8 = net.bytebuddy.ClassFileVersion.ofThisVm(r7)     // Catch:{ all -> 0x00ae }
                            boolean r7 = r8.isAtMost(r7)     // Catch:{ all -> 0x00ae }
                            if (r7 == 0) goto L_0x00aa
                        L_0x00a8:
                            r7 = 1
                            goto L_0x00ab
                        L_0x00aa:
                            r7 = r4
                        L_0x00ab:
                            r1.consider(r6, r7)     // Catch:{ all -> 0x00ae }
                        L_0x00ae:
                            r3.remove()     // Catch:{ all -> 0x00c3 }
                            goto L_0x0068
                        L_0x00b2:
                            java.lang.instrument.Instrumentation r2 = r9.instrumentation     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$BatchAllocator r3 = r9.redefinitionBatchAllocator     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$Listener r5 = r9.redefinitionBatchListener     // Catch:{ all -> 0x00c3 }
                            r1.apply(r2, r3, r5, r4)     // Catch:{ all -> 0x00c3 }
                            if (r0 == 0) goto L_0x00c2
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                            r0.release()
                        L_0x00c2:
                            return
                        L_0x00c3:
                            r1 = move-exception
                            if (r0 == 0) goto L_0x00cb
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                            r0.release()
                        L_0x00cb:
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.ResubmissionInstallationListener.run():void");
                    }
                }

                protected static class Resubmitter extends Listener.Adapter implements ResubmissionEnforcer {
                    private final RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
                    private final RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
                    private final ConcurrentMap<StorageKey, Set<String>> types;

                    protected static class ConcurrentHashSet<T> extends AbstractSet<T> {
                        private final ConcurrentMap<T, Boolean> delegate;

                        protected ConcurrentHashSet() {
                            this.delegate = new ConcurrentHashMap();
                        }

                        public boolean add(T t10) {
                            return this.delegate.put(t10, Boolean.TRUE) == null;
                        }

                        public Iterator<T> iterator() {
                            return this.delegate.keySet().iterator();
                        }

                        public boolean remove(Object obj) {
                            return this.delegate.remove(obj) != null;
                        }

                        public int size() {
                            return this.delegate.size();
                        }
                    }

                    protected Resubmitter(RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher2, RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher2, ConcurrentMap<StorageKey, Set<String>> concurrentMap) {
                        this.resubmissionOnErrorMatcher = resubmissionOnErrorMatcher2;
                        this.resubmissionImmediateMatcher = resubmissionImmediateMatcher2;
                        this.types = concurrentMap;
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
                        r4 = new net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.Resubmitter.ConcurrentHashSet();
                     */
                    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"GC_UNRELATED_TYPES"})
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean isEnforced(java.lang.String r2, @net.bytebuddy.utility.nullability.MaybeNull java.lang.ClassLoader r3, @net.bytebuddy.utility.nullability.MaybeNull net.bytebuddy.utility.JavaModule r4, @net.bytebuddy.utility.nullability.MaybeNull java.lang.Class<?> r5) {
                        /*
                            r1 = this;
                            if (r5 != 0) goto L_0x0033
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionListenable$ResubmissionImmediateMatcher r5 = r1.resubmissionImmediateMatcher
                            boolean r4 = r5.matches(r2, r3, r4)
                            if (r4 == 0) goto L_0x0033
                            java.util.concurrent.ConcurrentMap<net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey, java.util.Set<java.lang.String>> r4 = r1.types
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$LookupKey r5 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$LookupKey
                            r5.<init>(r3)
                            java.lang.Object r4 = r4.get(r5)
                            java.util.Set r4 = (java.util.Set) r4
                            if (r4 != 0) goto L_0x002e
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$Resubmitter$ConcurrentHashSet r4 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$Resubmitter$ConcurrentHashSet
                            r4.<init>()
                            java.util.concurrent.ConcurrentMap<net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey, java.util.Set<java.lang.String>> r5 = r1.types
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey r0 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey
                            r0.<init>(r3)
                            java.lang.Object r3 = r5.putIfAbsent(r0, r4)
                            java.util.Set r3 = (java.util.Set) r3
                            if (r3 == 0) goto L_0x002e
                            r4 = r3
                        L_0x002e:
                            r4.add(r2)
                            r2 = 1
                            return r2
                        L_0x0033:
                            r2 = 0
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.Resubmitter.isEnforced(java.lang.String, java.lang.ClassLoader, net.bytebuddy.utility.JavaModule, java.lang.Class):boolean");
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
                        r3 = new net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.Resubmitter.ConcurrentHashSet();
                     */
                    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"GC_UNRELATED_TYPES"})
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onError(java.lang.String r1, @net.bytebuddy.utility.nullability.MaybeNull java.lang.ClassLoader r2, @net.bytebuddy.utility.nullability.MaybeNull net.bytebuddy.utility.JavaModule r3, boolean r4, java.lang.Throwable r5) {
                        /*
                            r0 = this;
                            if (r4 != 0) goto L_0x0031
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionListenable$ResubmissionOnErrorMatcher r4 = r0.resubmissionOnErrorMatcher
                            boolean r3 = r4.matches(r5, r1, r2, r3)
                            if (r3 == 0) goto L_0x0031
                            java.util.concurrent.ConcurrentMap<net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey, java.util.Set<java.lang.String>> r3 = r0.types
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$LookupKey r4 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$LookupKey
                            r4.<init>(r2)
                            java.lang.Object r3 = r3.get(r4)
                            java.util.Set r3 = (java.util.Set) r3
                            if (r3 != 0) goto L_0x002e
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$Resubmitter$ConcurrentHashSet r3 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$Resubmitter$ConcurrentHashSet
                            r3.<init>()
                            java.util.concurrent.ConcurrentMap<net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey, java.util.Set<java.lang.String>> r4 = r0.types
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey r5 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey
                            r5.<init>(r2)
                            java.lang.Object r2 = r4.putIfAbsent(r5, r3)
                            java.util.Set r2 = (java.util.Set) r2
                            if (r2 == 0) goto L_0x002e
                            r3 = r2
                        L_0x002e:
                            r3.add(r1)
                        L_0x0031:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.Resubmitter.onError(java.lang.String, java.lang.ClassLoader, net.bytebuddy.utility.JavaModule, boolean, java.lang.Throwable):void");
                    }
                }

                protected static class StorageKey extends WeakReference<ClassLoader> {
                    /* access modifiers changed from: private */
                    public final int hashCode;

                    protected StorageKey(@MaybeNull ClassLoader classLoader) {
                        super(classLoader);
                        this.hashCode = System.identityHashCode(classLoader);
                    }

                    @SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof LookupKey) {
                            LookupKey lookupKey = (LookupKey) obj;
                            if (this.hashCode == lookupKey.hashCode && get() == lookupKey.classLoader) {
                                return true;
                            }
                            return false;
                        } else if (!(obj instanceof StorageKey)) {
                            return false;
                        } else {
                            StorageKey storageKey = (StorageKey) obj;
                            if (this.hashCode == storageKey.hashCode && get() == storageKey.get()) {
                                return true;
                            }
                            return false;
                        }
                    }

                    public int hashCode() {
                        return this.hashCode;
                    }

                    /* access modifiers changed from: protected */
                    public boolean isBootstrapLoader() {
                        return this.hashCode == 0;
                    }
                }

                protected Enabled(ResubmissionScheduler resubmissionScheduler2, RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher2, RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher2) {
                    this.resubmissionScheduler = resubmissionScheduler2;
                    this.resubmissionOnErrorMatcher = resubmissionOnErrorMatcher2;
                    this.resubmissionImmediateMatcher = resubmissionImmediateMatcher2;
                }

                public Installation apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, InstallationListener installationListener, CircularityLock circularityLock, RawMatcher rawMatcher, RedefinitionStrategy redefinitionStrategy, BatchAllocator batchAllocator, Listener listener2) {
                    if (this.resubmissionScheduler.isAlive()) {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        Resubmitter resubmitter = new Resubmitter(this.resubmissionOnErrorMatcher, this.resubmissionImmediateMatcher, concurrentHashMap);
                        Listener.Compound compound = new Listener.Compound(resubmitter, listener);
                        return new Installation(compound, new InstallationListener.Compound(new ResubmissionInstallationListener(instrumentation, this.resubmissionScheduler, poolStrategy, locationStrategy, descriptionStrategy, fallbackStrategy, listener, circularityLock, rawMatcher, redefinitionStrategy, batchAllocator, listener2, concurrentHashMap), installationListener), resubmitter);
                    }
                    throw new IllegalStateException("Resubmission scheduler " + this.resubmissionScheduler + " is not alive");
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Enabled enabled = (Enabled) obj;
                    return this.resubmissionScheduler.equals(enabled.resubmissionScheduler) && this.resubmissionOnErrorMatcher.equals(enabled.resubmissionOnErrorMatcher) && this.resubmissionImmediateMatcher.equals(enabled.resubmissionImmediateMatcher);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.resubmissionScheduler.hashCode()) * 31) + this.resubmissionOnErrorMatcher.hashCode()) * 31) + this.resubmissionImmediateMatcher.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Installation {
                private final InstallationListener installationListener;
                private final Listener listener;
                private final ResubmissionEnforcer resubmissionEnforcer;

                protected Installation(Listener listener2, InstallationListener installationListener2, ResubmissionEnforcer resubmissionEnforcer2) {
                    this.listener = listener2;
                    this.installationListener = installationListener2;
                    this.resubmissionEnforcer = resubmissionEnforcer2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Installation installation = (Installation) obj;
                    return this.listener.equals(installation.listener) && this.installationListener.equals(installation.installationListener) && this.resubmissionEnforcer.equals(installation.resubmissionEnforcer);
                }

                /* access modifiers changed from: protected */
                public InstallationListener getInstallationListener() {
                    return this.installationListener;
                }

                /* access modifiers changed from: protected */
                public Listener getListener() {
                    return this.listener;
                }

                /* access modifiers changed from: protected */
                public ResubmissionEnforcer getResubmissionEnforcer() {
                    return this.resubmissionEnforcer;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.listener.hashCode()) * 31) + this.installationListener.hashCode()) * 31) + this.resubmissionEnforcer.hashCode();
                }
            }

            Installation apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, InstallationListener installationListener, CircularityLock circularityLock, RawMatcher rawMatcher, RedefinitionStrategy redefinitionStrategy, BatchAllocator batchAllocator, Listener listener2);
        }

        static {
            DISPATCHER = (Dispatcher) Default.doPrivileged(JavaDispatcher.of(Dispatcher.class));
        }

        /* access modifiers changed from: protected */
        public void apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, DiscoveryStrategy discoveryStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, Listener listener, Listener listener2, RawMatcher rawMatcher, BatchAllocator batchAllocator, CircularityLock circularityLock) {
            boolean z10;
            Instrumentation instrumentation2 = instrumentation;
            check(instrumentation);
            int i10 = 0;
            for (Iterable<Class<?>> it : discoveryStrategy.resolve(instrumentation)) {
                Collector make = make(poolStrategy, locationStrategy, descriptionStrategy, fallbackStrategy, listener, rawMatcher, circularityLock);
                for (Class cls : it) {
                    if (cls == null || cls.isArray() || cls.isPrimitive()) {
                        LambdaInstrumentationStrategy lambdaInstrumentationStrategy2 = lambdaInstrumentationStrategy;
                    } else if (lambdaInstrumentationStrategy.isInstrumented(cls)) {
                        if (!DISPATCHER.isModifiableClass(instrumentation, cls)) {
                            ClassFileVersion classFileVersion = ClassFileVersion.JAVA_V5;
                            if (!ClassFileVersion.ofThisVm(classFileVersion).isAtMost(classFileVersion)) {
                                z10 = false;
                                make.consider(cls, z10);
                            }
                        }
                        z10 = true;
                        make.consider(cls, z10);
                    }
                }
                LambdaInstrumentationStrategy lambdaInstrumentationStrategy3 = lambdaInstrumentationStrategy;
                i10 = make.apply(instrumentation, batchAllocator, listener2, i10);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void check(Instrumentation instrumentation);

        /* access modifiers changed from: protected */
        public boolean isEnabled() {
            return this.enabled;
        }

        /* access modifiers changed from: protected */
        public boolean isRetransforming() {
            return this.retransforming;
        }

        /* access modifiers changed from: protected */
        public abstract Collector make(PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, RawMatcher rawMatcher, CircularityLock circularityLock);

        private RedefinitionStrategy(boolean z10, boolean z11) {
            this.enabled = z10;
            this.retransforming = z11;
        }
    }

    public interface Transformer {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForAdvice implements Transformer {
            private final Advice.WithCustomMapping advice;
            private final Assigner assigner;
            private final ClassFileLocator classFileLocator;
            private final List<Entry> entries;
            private final Advice.ExceptionHandler exceptionHandler;
            private final LocationStrategy locationStrategy;
            private final PoolStrategy poolStrategy;

            @HashCodeAndEqualsPlugin.Enhance
            protected static abstract class Entry {
                private final LatentMatcher<? super MethodDescription> matcher;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class ForSplitAdvice extends Entry {
                    private final String enter;
                    private final String exit;

                    protected ForSplitAdvice(LatentMatcher<? super MethodDescription> latentMatcher, String str, String str2) {
                        super(latentMatcher);
                        this.enter = str;
                        this.exit = str2;
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
                        ForSplitAdvice forSplitAdvice = (ForSplitAdvice) obj;
                        return this.enter.equals(forSplitAdvice.enter) && this.exit.equals(forSplitAdvice.exit);
                    }

                    public int hashCode() {
                        return (((super.hashCode() * 31) + this.enter.hashCode()) * 31) + this.exit.hashCode();
                    }

                    /* access modifiers changed from: protected */
                    public Advice resolve(Advice.WithCustomMapping withCustomMapping, TypePool typePool, ClassFileLocator classFileLocator) {
                        return withCustomMapping.to(typePool.describe(this.enter).resolve(), typePool.describe(this.exit).resolve(), classFileLocator);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                protected static class ForUnifiedAdvice extends Entry {
                    protected final String name;

                    protected ForUnifiedAdvice(LatentMatcher<? super MethodDescription> latentMatcher, String str) {
                        super(latentMatcher);
                        this.name = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.name.equals(((ForUnifiedAdvice) obj).name);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.name.hashCode();
                    }

                    /* access modifiers changed from: protected */
                    public Advice resolve(Advice.WithCustomMapping withCustomMapping, TypePool typePool, ClassFileLocator classFileLocator) {
                        return withCustomMapping.to(typePool.describe(this.name).resolve(), classFileLocator);
                    }
                }

                protected Entry(LatentMatcher<? super MethodDescription> latentMatcher) {
                    this.matcher = latentMatcher;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matcher.equals(((Entry) obj).matcher);
                }

                /* access modifiers changed from: protected */
                public LatentMatcher<? super MethodDescription> getMatcher() {
                    return this.matcher;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matcher.hashCode();
                }

                /* access modifiers changed from: protected */
                public abstract Advice resolve(Advice.WithCustomMapping withCustomMapping, TypePool typePool, ClassFileLocator classFileLocator);
            }

            public ForAdvice() {
                this(Advice.withCustomMapping());
            }

            public ForAdvice advice(ElementMatcher<? super MethodDescription> elementMatcher, String str) {
                return advice((LatentMatcher<? super MethodDescription>) new LatentMatcher.Resolved(elementMatcher), str);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForAdvice forAdvice = (ForAdvice) obj;
                return this.advice.equals(forAdvice.advice) && this.exceptionHandler.equals(forAdvice.exceptionHandler) && this.assigner.equals(forAdvice.assigner) && this.classFileLocator.equals(forAdvice.classFileLocator) && this.poolStrategy.equals(forAdvice.poolStrategy) && this.locationStrategy.equals(forAdvice.locationStrategy) && this.entries.equals(forAdvice.entries);
            }

            public int hashCode() {
                return (((((((((((((getClass().hashCode() * 31) + this.advice.hashCode()) * 31) + this.exceptionHandler.hashCode()) * 31) + this.assigner.hashCode()) * 31) + this.classFileLocator.hashCode()) * 31) + this.poolStrategy.hashCode()) * 31) + this.locationStrategy.hashCode()) * 31) + this.entries.hashCode();
            }

            public ForAdvice include(ClassLoader... classLoaderArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (ClassLoader of2 : classLoaderArr) {
                    linkedHashSet.add(ClassFileLocator.ForClassLoader.of(of2));
                }
                return include((List<? extends ClassFileLocator>) new ArrayList(linkedHashSet));
            }

            /* access modifiers changed from: protected */
            public ForAdvice make(Advice.WithCustomMapping withCustomMapping, Advice.ExceptionHandler exceptionHandler2, Assigner assigner2, ClassFileLocator classFileLocator2, PoolStrategy poolStrategy2, LocationStrategy locationStrategy2, List<Entry> list) {
                return new ForAdvice(withCustomMapping, exceptionHandler2, assigner2, classFileLocator2, poolStrategy2, locationStrategy2, list);
            }

            public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, ProtectionDomain protectionDomain) {
                ClassLoader classLoader2 = classLoader;
                int i10 = 1;
                ClassFileLocator.Compound compound = new ClassFileLocator.Compound(this.classFileLocator, this.locationStrategy.classFileLocator(classLoader2, javaModule));
                TypePool typePool = this.poolStrategy.typePool(compound, classLoader2);
                AsmVisitorWrapper.ForDeclaredMethods forDeclaredMethods = new AsmVisitorWrapper.ForDeclaredMethods();
                AsmVisitorWrapper.ForDeclaredMethods forDeclaredMethods2 = forDeclaredMethods;
                for (Entry next : this.entries) {
                    ElementMatcher<? super Object> resolve = next.getMatcher().resolve(typeDescription);
                    AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper[] methodVisitorWrapperArr = new AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper[i10];
                    methodVisitorWrapperArr[0] = wrap(typeDescription, classLoader, javaModule, protectionDomain, next.resolve(this.advice, typePool, compound).withAssigner(this.assigner).withExceptionHandler(this.exceptionHandler));
                    forDeclaredMethods2 = forDeclaredMethods2.invokable((ElementMatcher<? super MethodDescription>) resolve, methodVisitorWrapperArr);
                    i10 = 1;
                }
                return builder.visit(forDeclaredMethods2);
            }

            public ForAdvice with(PoolStrategy poolStrategy2) {
                return make(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, poolStrategy2, this.locationStrategy, this.entries);
            }

            public ForAdvice withExceptionHandler(Advice.ExceptionHandler exceptionHandler2) {
                return make(this.advice, exceptionHandler2, this.assigner, this.classFileLocator, this.poolStrategy, this.locationStrategy, this.entries);
            }

            /* access modifiers changed from: protected */
            public AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper wrap(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, ProtectionDomain protectionDomain, Advice advice2) {
                return advice2;
            }

            public ForAdvice(Advice.WithCustomMapping withCustomMapping) {
                this(withCustomMapping, Advice.ExceptionHandler.Default.SUPPRESSING, Assigner.DEFAULT, ClassFileLocator.NoOp.INSTANCE, PoolStrategy.Default.FAST, LocationStrategy.ForClassLoader.STRONG, Collections.emptyList());
            }

            public ForAdvice advice(LatentMatcher<? super MethodDescription> latentMatcher, String str) {
                return make(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy, this.locationStrategy, CompoundList.of(this.entries, new Entry.ForUnifiedAdvice(latentMatcher, str)));
            }

            public ForAdvice with(LocationStrategy locationStrategy2) {
                return make(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy, locationStrategy2, this.entries);
            }

            public ForAdvice with(Assigner assigner2) {
                return make(this.advice, this.exceptionHandler, assigner2, this.classFileLocator, this.poolStrategy, this.locationStrategy, this.entries);
            }

            protected ForAdvice(Advice.WithCustomMapping withCustomMapping, Advice.ExceptionHandler exceptionHandler2, Assigner assigner2, ClassFileLocator classFileLocator2, PoolStrategy poolStrategy2, LocationStrategy locationStrategy2, List<Entry> list) {
                this.advice = withCustomMapping;
                this.exceptionHandler = exceptionHandler2;
                this.assigner = assigner2;
                this.classFileLocator = classFileLocator2;
                this.poolStrategy = poolStrategy2;
                this.locationStrategy = locationStrategy2;
                this.entries = list;
            }

            public ForAdvice advice(ElementMatcher<? super MethodDescription> elementMatcher, String str, String str2) {
                return advice((LatentMatcher<? super MethodDescription>) new LatentMatcher.Resolved(elementMatcher), str, str2);
            }

            public ForAdvice include(ClassFileLocator... classFileLocatorArr) {
                return include((List<? extends ClassFileLocator>) Arrays.asList(classFileLocatorArr));
            }

            public ForAdvice advice(LatentMatcher<? super MethodDescription> latentMatcher, String str, String str2) {
                return make(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy, this.locationStrategy, CompoundList.of(this.entries, new Entry.ForSplitAdvice(latentMatcher, str, str2)));
            }

            public ForAdvice include(List<? extends ClassFileLocator> list) {
                return make(this.advice, this.exceptionHandler, this.assigner, new ClassFileLocator.Compound((List<? extends ClassFileLocator>) CompoundList.of(this.classFileLocator, list)), this.poolStrategy, this.locationStrategy, this.entries);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForBuildPlugin implements Transformer {
            private final Plugin plugin;

            public ForBuildPlugin(Plugin plugin2) {
                this.plugin = plugin2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.plugin.equals(((ForBuildPlugin) obj).plugin);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.plugin.hashCode();
            }

            public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, ProtectionDomain protectionDomain) {
                return this.plugin.apply(builder, typeDescription, ClassFileLocator.ForClassLoader.of(classLoader));
            }
        }

        DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, ProtectionDomain protectionDomain);
    }

    public interface TransformerDecorator {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements TransformerDecorator {
            private final List<TransformerDecorator> transformerDecorators;

            public Compound(TransformerDecorator... transformerDecoratorArr) {
                this((List<? extends TransformerDecorator>) Arrays.asList(transformerDecoratorArr));
            }

            public ResettableClassFileTransformer decorate(ResettableClassFileTransformer resettableClassFileTransformer) {
                for (TransformerDecorator decorate : this.transformerDecorators) {
                    resettableClassFileTransformer = decorate.decorate(resettableClassFileTransformer);
                }
                return resettableClassFileTransformer;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.transformerDecorators.equals(((Compound) obj).transformerDecorators);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.transformerDecorators.hashCode();
            }

            public Compound(List<? extends TransformerDecorator> list) {
                this.transformerDecorators = new ArrayList();
                for (TransformerDecorator transformerDecorator : list) {
                    if (transformerDecorator instanceof Compound) {
                        this.transformerDecorators.addAll(((Compound) transformerDecorator).transformerDecorators);
                    } else if (!(transformerDecorator instanceof NoOp)) {
                        this.transformerDecorators.add(transformerDecorator);
                    }
                }
            }
        }

        public enum NoOp implements TransformerDecorator {
            INSTANCE;

            public ResettableClassFileTransformer decorate(ResettableClassFileTransformer resettableClassFileTransformer) {
                return resettableClassFileTransformer;
            }
        }

        ResettableClassFileTransformer decorate(ResettableClassFileTransformer resettableClassFileTransformer);
    }

    public interface TypeStrategy {

        public enum Default implements TypeStrategy {
            REBASE {
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull ProtectionDomain protectionDomain) {
                    return byteBuddy.rebase(typeDescription, classFileLocator, methodNameTransformer);
                }
            },
            REDEFINE {
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull ProtectionDomain protectionDomain) {
                    return byteBuddy.redefine(typeDescription, classFileLocator);
                }
            },
            REDEFINE_FROZEN {
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull ProtectionDomain protectionDomain) {
                    return byteBuddy.with((InstrumentedType.Factory) InstrumentedType.Factory.Default.FROZEN).with((VisibilityBridgeStrategy) VisibilityBridgeStrategy.Default.NEVER).redefine(typeDescription, classFileLocator).ignoreAlso((LatentMatcher<? super MethodDescription>) LatentMatcher.ForSelfDeclaredMethod.NOT_DECLARED);
                }
            },
            DECORATE {
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull ProtectionDomain protectionDomain) {
                    return byteBuddy.decorate(typeDescription, classFileLocator);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForBuildEntryPoint implements TypeStrategy {
            private final EntryPoint entryPoint;

            public ForBuildEntryPoint(EntryPoint entryPoint2) {
                this.entryPoint = entryPoint2;
            }

            public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull ProtectionDomain protectionDomain) {
                return this.entryPoint.transform(typeDescription, byteBuddy, classFileLocator, methodNameTransformer);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.entryPoint.equals(((ForBuildEntryPoint) obj).entryPoint);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.entryPoint.hashCode();
            }
        }

        DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull ProtectionDomain protectionDomain);
    }

    AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection);

    AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Class<?>... clsArr);

    AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, JavaModule... javaModuleArr);

    AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection);

    AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Class<?>... clsArr);

    AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, JavaModule... javaModuleArr);

    AgentBuilder disableClassFormatChanges();

    AgentBuilder disableNativeMethodPrefix();

    AgentBuilder enableNativeMethodPrefix(String str);

    Ignored ignore(RawMatcher rawMatcher);

    Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher);

    Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2);

    Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);

    ResettableClassFileTransformer installOn(Instrumentation instrumentation);

    ResettableClassFileTransformer installOnByteBuddyAgent();

    ClassFileTransformer makeRaw();

    ResettableClassFileTransformer patchOn(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer);

    ResettableClassFileTransformer patchOn(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode);

    ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer);

    ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode);

    Identified.Narrowable type(RawMatcher rawMatcher);

    Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher);

    Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2);

    Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);

    AgentBuilder warmUp(Collection<Class<?>> collection);

    AgentBuilder warmUp(Class<?>... clsArr);

    RedefinitionListenable.WithoutBatchStrategy with(RedefinitionStrategy redefinitionStrategy);

    AgentBuilder with(ByteBuddy byteBuddy);

    AgentBuilder with(CircularityLock circularityLock);

    AgentBuilder with(ClassFileBufferStrategy classFileBufferStrategy);

    AgentBuilder with(DescriptionStrategy descriptionStrategy);

    AgentBuilder with(FallbackStrategy fallbackStrategy);

    AgentBuilder with(InitializationStrategy initializationStrategy);

    AgentBuilder with(InjectionStrategy injectionStrategy);

    AgentBuilder with(InstallationListener installationListener);

    AgentBuilder with(LambdaInstrumentationStrategy lambdaInstrumentationStrategy);

    AgentBuilder with(Listener listener);

    AgentBuilder with(LocationStrategy locationStrategy);

    AgentBuilder with(PoolStrategy poolStrategy);

    AgentBuilder with(TransformerDecorator transformerDecorator);

    AgentBuilder with(TypeStrategy typeStrategy);

    AgentBuilder with(ClassFileLocator classFileLocator);
}
