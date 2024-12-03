package net.bytebuddy.dynamic.loading;

import com.facebook.internal.ServerProtocol;
import java.io.File;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class ClassReloadingStrategy implements ClassLoadingStrategy<ClassLoader> {
    private static final boolean ACCESS_CONTROLLER;
    protected static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
    private final BootstrapInjection bootstrapInjection;
    private final Instrumentation instrumentation;
    private final Map<String, Class<?>> preregisteredTypes;
    private final Strategy strategy;

    protected interface BootstrapInjection {

        public enum Disabled implements BootstrapInjection {
            INSTANCE;

            public ClassInjector make(Instrumentation instrumentation) {
                throw new IllegalStateException("Bootstrap injection is not enabled");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Enabled implements BootstrapInjection {
            private final File folder;

            protected Enabled(File file) {
                this.folder = file;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.folder.equals(((Enabled) obj).folder);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.folder.hashCode();
            }

            public ClassInjector make(Instrumentation instrumentation) {
                return ClassInjector.UsingInstrumentation.of(this.folder, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, instrumentation);
            }
        }

        ClassInjector make(Instrumentation instrumentation);
    }

    @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
    protected interface Dispatcher {
        @JavaDispatcher.Proxied("addTransformer")
        void addTransformer(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, boolean z10);

        @JavaDispatcher.Proxied("isModifiableClass")
        boolean isModifiableClass(Instrumentation instrumentation, Class<?> cls);

        @JavaDispatcher.Proxied("isRetransformClassesSupported")
        boolean isRetransformClassesSupported(Instrumentation instrumentation);

        @JavaDispatcher.Proxied("retransformClasses")
        void retransformClasses(Instrumentation instrumentation, Class<?>[] clsArr) throws UnmodifiableClassException;
    }

    public enum Strategy {
        REDEFINITION(true) {
            /* access modifiers changed from: protected */
            public void apply(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> map) throws UnmodifiableClassException, ClassNotFoundException {
                instrumentation.redefineClasses((ClassDefinition[]) map.values().toArray(new ClassDefinition[0]));
            }

            public void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> list) throws IOException, UnmodifiableClassException, ClassNotFoundException {
                HashMap hashMap = new HashMap(list.size());
                for (Class next : list) {
                    hashMap.put(next, new ClassDefinition(next, classFileLocator.locate(TypeDescription.ForLoadedType.getName(next)).resolve()));
                }
                apply(instrumentation, hashMap);
            }

            /* access modifiers changed from: protected */
            public Strategy validate(Instrumentation instrumentation) {
                if (instrumentation.isRedefineClassesSupported()) {
                    return this;
                }
                throw new IllegalArgumentException("Does not support redefinition: " + instrumentation);
            }
        },
        RETRANSFORMATION(false) {
            /* access modifiers changed from: protected */
            public void apply(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> map) throws UnmodifiableClassException {
                ClassRedefinitionTransformer classRedefinitionTransformer = new ClassRedefinitionTransformer(map);
                synchronized (this) {
                    Dispatcher dispatcher = ClassReloadingStrategy.DISPATCHER;
                    dispatcher.addTransformer(instrumentation, classRedefinitionTransformer, true);
                    try {
                        dispatcher.retransformClasses(instrumentation, (Class[]) map.keySet().toArray(new Class[0]));
                    } finally {
                        instrumentation.removeTransformer(classRedefinitionTransformer);
                    }
                }
                classRedefinitionTransformer.assertTransformation();
            }

            public void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> list) throws UnmodifiableClassException, ClassNotFoundException {
                for (Class next : list) {
                    if (!ClassReloadingStrategy.DISPATCHER.isModifiableClass(instrumentation, next)) {
                        throw new IllegalArgumentException("Cannot modify type: " + next);
                    }
                }
                Dispatcher dispatcher = ClassReloadingStrategy.DISPATCHER;
                ClassResettingTransformer classResettingTransformer = ClassResettingTransformer.INSTANCE;
                dispatcher.addTransformer(instrumentation, classResettingTransformer, true);
                try {
                    dispatcher.retransformClasses(instrumentation, (Class[]) list.toArray(new Class[0]));
                    instrumentation.removeTransformer(classResettingTransformer);
                } catch (Throwable th2) {
                    instrumentation.removeTransformer(ClassResettingTransformer.INSTANCE);
                    throw th2;
                }
            }

            /* access modifiers changed from: protected */
            public Strategy validate(Instrumentation instrumentation) {
                if (ClassReloadingStrategy.DISPATCHER.isRetransformClassesSupported(instrumentation)) {
                    return this;
                }
                throw new IllegalArgumentException("Does not support retransformation: " + instrumentation);
            }
        };
        
        /* access modifiers changed from: private */
        @AlwaysNull
        public static final byte[] NO_REDEFINITION = null;
        private static final boolean REDEFINE_CLASSES = true;
        private final boolean redefinition;

        protected static class ClassRedefinitionTransformer implements ClassFileTransformer {
            private final Map<Class<?>, ClassDefinition> redefinedClasses;

            protected ClassRedefinitionTransformer(Map<Class<?>, ClassDefinition> map) {
                this.redefinedClasses = map;
            }

            public void assertTransformation() {
                if (!this.redefinedClasses.isEmpty()) {
                    throw new IllegalStateException("Could not transform: " + this.redefinedClasses.keySet());
                }
            }

            @MaybeNull
            public byte[] transform(@MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
                if (str == null) {
                    return Strategy.NO_REDEFINITION;
                }
                ClassDefinition remove = this.redefinedClasses.remove(cls);
                if (remove == null) {
                    return Strategy.NO_REDEFINITION;
                }
                return remove.getDefinitionClassFile();
            }
        }

        protected enum ClassResettingTransformer implements ClassFileTransformer {
            INSTANCE;

            @MaybeNull
            public byte[] transform(@MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
                return Strategy.NO_REDEFINITION;
            }
        }

        static {
            NO_REDEFINITION = null;
        }

        /* access modifiers changed from: protected */
        public abstract void apply(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> map) throws UnmodifiableClassException, ClassNotFoundException;

        public boolean isRedefinition() {
            return this.redefinition;
        }

        public abstract void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> list) throws IOException, UnmodifiableClassException, ClassNotFoundException;

        /* access modifiers changed from: protected */
        public abstract Strategy validate(Instrumentation instrumentation);

        private Strategy(boolean z10) {
            this.redefinition = z10;
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

    public ClassReloadingStrategy(Instrumentation instrumentation2, Strategy strategy2) {
        this(instrumentation2, strategy2, BootstrapInjection.Disabled.INSTANCE, Collections.emptyMap());
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static ClassReloadingStrategy fromInstalledAgent() {
        return of(resolveByteBuddyAgentInstrumentation());
    }

    public static ClassReloadingStrategy of(Instrumentation instrumentation2) {
        if (DISPATCHER.isRetransformClassesSupported(instrumentation2)) {
            return new ClassReloadingStrategy(instrumentation2, Strategy.RETRANSFORMATION);
        }
        if (instrumentation2.isRedefineClassesSupported()) {
            return new ClassReloadingStrategy(instrumentation2, Strategy.REDEFINITION);
        }
        throw new IllegalArgumentException("Instrumentation does not support reloading of classes: " + instrumentation2);
    }

    private static Instrumentation resolveByteBuddyAgentInstrumentation() {
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass("net.bytebuddy.agent.Installer");
            JavaModule ofType = JavaModule.ofType(AgentBuilder.class);
            JavaModule ofType2 = JavaModule.ofType(loadClass);
            if (ofType != null && !ofType.canRead(ofType2)) {
                Class<?> cls = Class.forName("java.lang.Module");
                cls.getMethod("addReads", new Class[]{cls}).invoke(ofType.unwrap(), new Object[]{ofType2.unwrap()});
            }
            return (Instrumentation) loadClass.getMethod("getInstrumentation", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", e11);
        }
    }

    public ClassReloadingStrategy enableBootstrapInjection(File file) {
        return new ClassReloadingStrategy(this.instrumentation, this.strategy, new BootstrapInjection.Enabled(file), this.preregisteredTypes);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassReloadingStrategy classReloadingStrategy = (ClassReloadingStrategy) obj;
        return this.strategy.equals(classReloadingStrategy.strategy) && this.instrumentation.equals(classReloadingStrategy.instrumentation) && this.bootstrapInjection.equals(classReloadingStrategy.bootstrapInjection) && this.preregisteredTypes.equals(classReloadingStrategy.preregisteredTypes);
    }

    public int hashCode() {
        return (((((((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + this.strategy.hashCode()) * 31) + this.bootstrapInjection.hashCode()) * 31) + this.preregisteredTypes.hashCode();
    }

    public Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map) {
        ClassInjector classInjector;
        HashMap hashMap = new HashMap(this.preregisteredTypes);
        for (Class cls : this.instrumentation.getInitiatedClasses(classLoader)) {
            hashMap.put(TypeDescription.ForLoadedType.getName(cls), cls);
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        HashMap hashMap2 = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            Class cls2 = (Class) hashMap.get(((TypeDescription) next.getKey()).getName());
            if (cls2 != null) {
                concurrentHashMap.put(cls2, new ClassDefinition(cls2, (byte[]) next.getValue()));
                hashMap2.put(next.getKey(), cls2);
            } else {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        try {
            this.strategy.apply(this.instrumentation, concurrentHashMap);
            if (!linkedHashMap.isEmpty()) {
                if (classLoader == null) {
                    classInjector = this.bootstrapInjection.make(this.instrumentation);
                } else {
                    classInjector = new ClassInjector.UsingReflection(classLoader);
                }
                hashMap2.putAll(classInjector.inject(linkedHashMap));
            }
            return hashMap2;
        } catch (ClassNotFoundException e10) {
            throw new IllegalArgumentException("Could not locate classes for redefinition", e10);
        } catch (UnmodifiableClassException e11) {
            throw new IllegalStateException("Cannot redefine specified class", e11);
        }
    }

    public ClassReloadingStrategy preregistered(Class<?>... clsArr) {
        HashMap hashMap = new HashMap(this.preregisteredTypes);
        for (Class<?> cls : clsArr) {
            hashMap.put(TypeDescription.ForLoadedType.getName(cls), cls);
        }
        return new ClassReloadingStrategy(this.instrumentation, this.strategy, this.bootstrapInjection, hashMap);
    }

    public ClassReloadingStrategy reset(Class<?>... clsArr) throws IOException {
        if (clsArr.length == 0) {
            return this;
        }
        return reset(ClassFileLocator.ForClassLoader.of(clsArr[0].getClassLoader()), clsArr);
    }

    public static ClassReloadingStrategy fromInstalledAgent(Strategy strategy2) {
        return new ClassReloadingStrategy(resolveByteBuddyAgentInstrumentation(), strategy2);
    }

    public ClassReloadingStrategy reset(ClassFileLocator classFileLocator, Class<?>... clsArr) throws IOException {
        if (clsArr.length > 0) {
            try {
                this.strategy.reset(this.instrumentation, classFileLocator, Arrays.asList(clsArr));
            } catch (ClassNotFoundException e10) {
                throw new IllegalArgumentException("Cannot locate types " + Arrays.toString(clsArr), e10);
            } catch (UnmodifiableClassException e11) {
                throw new IllegalStateException("Cannot reset types " + Arrays.toString(clsArr), e11);
            }
        }
        return this;
    }

    protected ClassReloadingStrategy(Instrumentation instrumentation2, Strategy strategy2, BootstrapInjection bootstrapInjection2, Map<String, Class<?>> map) {
        this.instrumentation = instrumentation2;
        this.strategy = strategy2.validate(instrumentation2);
        this.bootstrapInjection = bootstrapInjection2;
        this.preregisteredTypes = map;
    }
}
