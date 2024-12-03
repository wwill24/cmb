package net.bytebuddy.dynamic.loading;

import com.facebook.internal.ServerProtocol;
import com.google.firebase.sessions.settings.RemoteSettings;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URLStreamHandler;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.loading.ClassFilePostProcessor;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import net.bytebuddy.utility.GraalImageCode;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public class ByteArrayClassLoader extends InjectionClassLoader {
    private static final boolean ACCESS_CONTROLLER;
    private static final int FROM_BEGINNING = 0;
    /* access modifiers changed from: private */
    @AlwaysNull
    public static final URL NO_URL = null;
    /* access modifiers changed from: private */
    public static final PackageLookupStrategy PACKAGE_LOOKUP_STRATEGY = ((PackageLookupStrategy) doPrivileged(PackageLookupStrategy.CreationAction.INSTANCE));
    protected static final SynchronizationStrategy.Initializable SYNCHRONIZATION_STRATEGY = ((SynchronizationStrategy.Initializable) doPrivileged(SynchronizationStrategy.CreationAction.INSTANCE));
    public static final String URL_SCHEMA = "bytebuddy";
    @MaybeNull
    protected final Object accessControlContext;
    protected final ClassFilePostProcessor classFilePostProcessor;
    protected final PackageDefinitionStrategy packageDefinitionStrategy;
    protected final PersistenceHandler persistenceHandler;
    @MaybeNull
    protected final ProtectionDomain protectionDomain;
    protected final ConcurrentMap<String, byte[]> typeDefinitions;

    public static class ChildFirst extends ByteArrayClassLoader {
        private static final String CLASS_FILE_SUFFIX = ".class";

        protected static class PrependingEnumeration implements Enumeration<URL> {
            private final Enumeration<URL> enumeration;
            @MaybeNull
            private URL nextElement;

            protected PrependingEnumeration(URL url, Enumeration<URL> enumeration2) {
                this.nextElement = url;
                this.enumeration = enumeration2;
            }

            public boolean hasMoreElements() {
                return this.nextElement != null && this.enumeration.hasMoreElements();
            }

            public URL nextElement() {
                if (this.nextElement == null || !this.enumeration.hasMoreElements()) {
                    throw new NoSuchElementException();
                }
                try {
                    return this.nextElement;
                } finally {
                    this.nextElement = this.enumeration.nextElement();
                }
            }
        }

        static {
            doRegisterAsParallelCapable();
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map) {
            super(classLoader, map);
        }

        @SuppressFBWarnings(justification = "Must be invoked from targeting class loader type.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
        private static void doRegisterAsParallelCapable() {
            try {
                Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke((Object) null, new Object[0]);
            } catch (Throwable unused) {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean isShadowed(java.lang.String r4) {
            /*
                r3 = this;
                net.bytebuddy.dynamic.loading.ByteArrayClassLoader$PersistenceHandler r0 = r3.persistenceHandler
                boolean r0 = r0.isManifest()
                r1 = 0
                if (r0 != 0) goto L_0x0042
                java.lang.String r0 = ".class"
                boolean r0 = r4.endsWith(r0)
                if (r0 != 0) goto L_0x0012
                goto L_0x0042
            L_0x0012:
                monitor-enter(r3)
                r0 = 47
                r2 = 46
                java.lang.String r0 = r4.replace(r0, r2)     // Catch:{ all -> 0x003f }
                int r4 = r4.length()     // Catch:{ all -> 0x003f }
                int r4 = r4 + -6
                java.lang.String r4 = r0.substring(r1, r4)     // Catch:{ all -> 0x003f }
                java.util.concurrent.ConcurrentMap<java.lang.String, byte[]> r0 = r3.typeDefinitions     // Catch:{ all -> 0x003f }
                boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x003f }
                r2 = 1
                if (r0 == 0) goto L_0x0030
                monitor-exit(r3)     // Catch:{ all -> 0x003f }
                return r2
            L_0x0030:
                java.lang.Class r4 = r3.findLoadedClass(r4)     // Catch:{ all -> 0x003f }
                if (r4 == 0) goto L_0x003d
                java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ all -> 0x003f }
                if (r4 != r3) goto L_0x003d
                r1 = r2
            L_0x003d:
                monitor-exit(r3)     // Catch:{ all -> 0x003f }
                return r1
            L_0x003f:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x003f }
                throw r4
            L_0x0042:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ByteArrayClassLoader.ChildFirst.isShadowed(java.lang.String):boolean");
        }

        public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map) {
            return load(classLoader, map, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, PersistenceHandler.LATENT, PackageDefinitionStrategy.Trivial.INSTANCE, false, true);
        }

        public URL getResource(String str) {
            URL url = this.persistenceHandler.url(str, this.typeDefinitions);
            if (url != null || isShadowed(str)) {
                return url;
            }
            return super.getResource(str);
        }

        public Enumeration<URL> getResources(String str) throws IOException {
            URL url = this.persistenceHandler.url(str, this.typeDefinitions);
            if (url == null) {
                return super.getResources(str);
            }
            return new PrependingEnumeration(url, super.getResources(str));
        }

        /* access modifiers changed from: protected */
        public Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
            synchronized (ByteArrayClassLoader.SYNCHRONIZATION_STRATEGY.initialize().getClassLoadingLock(this, str)) {
                Class<?> findLoadedClass = findLoadedClass(str);
                if (findLoadedClass != null) {
                    return findLoadedClass;
                }
                try {
                    Class<?> findClass = findClass(str);
                    if (z10) {
                        resolveClass(findClass);
                    }
                    return findClass;
                } catch (ClassNotFoundException unused) {
                    return super.loadClass(str, z10);
                }
            }
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, boolean z10, Map<String, byte[]> map) {
            super(classLoader, z10, map);
        }

        @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
        public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, boolean z10, boolean z11) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                hashMap.put(((TypeDescription) next.getKey()).getName(), next.getValue());
            }
            ChildFirst childFirst = new ChildFirst(classLoader, z11, hashMap, protectionDomain, persistenceHandler, packageDefinitionStrategy, ClassFilePostProcessor.NoOp.INSTANCE);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (TypeDescription next2 : map.keySet()) {
                try {
                    Class<?> cls = Class.forName(next2.getName(), false, childFirst);
                    if (!GraalImageCode.getCurrent().isNativeImageExecution() && z10) {
                        if (cls.getClassLoader() != childFirst) {
                            throw new IllegalStateException("Class already loaded: " + cls);
                        }
                    }
                    linkedHashMap.put(next2, cls);
                } catch (ClassNotFoundException e10) {
                    throw new IllegalStateException("Cannot load class " + next2, e10);
                }
            }
            return linkedHashMap;
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, PersistenceHandler persistenceHandler) {
            super(classLoader, map, persistenceHandler);
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, boolean z10, Map<String, byte[]> map, PersistenceHandler persistenceHandler) {
            super(classLoader, z10, map, persistenceHandler);
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy) {
            super(classLoader, map, protectionDomain, persistenceHandler, packageDefinitionStrategy);
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, boolean z10, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy) {
            super(classLoader, z10, map, protectionDomain, persistenceHandler, packageDefinitionStrategy);
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassFilePostProcessor classFilePostProcessor) {
            super(classLoader, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, classFilePostProcessor);
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, boolean z10, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassFilePostProcessor classFilePostProcessor) {
            super(classLoader, z10, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, classFilePostProcessor);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    protected class ClassDefinitionAction implements PrivilegedAction<Class<?>> {
        private final byte[] binaryRepresentation;
        private final String name;

        protected ClassDefinitionAction(String str, byte[] bArr) {
            this.name = str;
            this.binaryRepresentation = bArr;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassDefinitionAction classDefinitionAction = (ClassDefinitionAction) obj;
            return this.name.equals(classDefinitionAction.name) && Arrays.equals(this.binaryRepresentation, classDefinitionAction.binaryRepresentation) && ByteArrayClassLoader.this.equals(ByteArrayClassLoader.this);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + Arrays.hashCode(this.binaryRepresentation)) * 31) + ByteArrayClassLoader.this.hashCode();
        }

        public Class<?> run() {
            int lastIndexOf = this.name.lastIndexOf(46);
            if (lastIndexOf != -1) {
                String substring = this.name.substring(0, lastIndexOf);
                ByteArrayClassLoader byteArrayClassLoader = ByteArrayClassLoader.this;
                PackageDefinitionStrategy.Definition define = byteArrayClassLoader.packageDefinitionStrategy.define(byteArrayClassLoader, substring, this.name);
                if (define.isDefined()) {
                    Package apply = ByteArrayClassLoader.PACKAGE_LOOKUP_STRATEGY.apply(ByteArrayClassLoader.this, substring);
                    if (apply == null) {
                        Package unused = ByteArrayClassLoader.this.definePackage(substring, define.getSpecificationTitle(), define.getSpecificationVersion(), define.getSpecificationVendor(), define.getImplementationTitle(), define.getImplementationVersion(), define.getImplementationVendor(), define.getSealBase());
                    } else if (!define.isCompatibleTo(apply)) {
                        throw new SecurityException("Sealing violation for package " + substring);
                    }
                }
            }
            ByteArrayClassLoader byteArrayClassLoader2 = ByteArrayClassLoader.this;
            String str = this.name;
            byte[] bArr = this.binaryRepresentation;
            return byteArrayClassLoader2.defineClass(str, bArr, 0, bArr.length, byteArrayClassLoader2.protectionDomain);
        }
    }

    protected enum EmptyEnumeration implements Enumeration<URL> {
        INSTANCE;

        public boolean hasMoreElements() {
            return false;
        }

        public URL nextElement() {
            throw new NoSuchElementException();
        }
    }

    protected interface PackageLookupStrategy {

        public enum CreationAction implements PrivilegedAction<PackageLookupStrategy> {
            INSTANCE;

            @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
            public PackageLookupStrategy run() {
                if (!JavaModule.isSupported()) {
                    return ForLegacyVm.INSTANCE;
                }
                try {
                    return new ForJava9CapableVm(ClassLoader.class.getMethod("getDefinedPackage", new Class[]{String.class}));
                } catch (Exception unused) {
                    return ForLegacyVm.INSTANCE;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForJava9CapableVm implements PackageLookupStrategy {
            private final Method getDefinedPackage;

            protected ForJava9CapableVm(Method method) {
                this.getDefinedPackage = method;
            }

            @MaybeNull
            public Package apply(ByteArrayClassLoader byteArrayClassLoader, String str) {
                try {
                    return (Package) this.getDefinedPackage.invoke(byteArrayClassLoader, new Object[]{str});
                } catch (IllegalAccessException e10) {
                    throw new IllegalStateException(e10);
                } catch (InvocationTargetException e11) {
                    throw new IllegalStateException(e11.getTargetException());
                }
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.getDefinedPackage.equals(((ForJava9CapableVm) obj).getDefinedPackage);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.getDefinedPackage.hashCode();
            }
        }

        public enum ForLegacyVm implements PackageLookupStrategy {
            INSTANCE;

            @MaybeNull
            public Package apply(ByteArrayClassLoader byteArrayClassLoader, String str) {
                return byteArrayClassLoader.doGetPackage(str);
            }
        }

        @MaybeNull
        Package apply(ByteArrayClassLoader byteArrayClassLoader, String str);
    }

    public enum PersistenceHandler {
        MANIFEST(true) {
            /* access modifiers changed from: protected */
            public byte[] lookup(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                return concurrentMap.get(str);
            }

            /* access modifiers changed from: protected */
            public void release(String str, ConcurrentMap<String, byte[]> concurrentMap) {
            }

            /* access modifiers changed from: protected */
            public URL url(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                if (!str.endsWith(".class")) {
                    return ByteArrayClassLoader.NO_URL;
                }
                if (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    str = str.substring(1);
                }
                byte[] bArr = concurrentMap.get(str.replace('/', '.').substring(0, str.length() - 6));
                if (bArr == null) {
                    return ByteArrayClassLoader.NO_URL;
                }
                return (URL) ByteArrayClassLoader.doPrivileged(new UrlDefinitionAction(str, bArr));
            }
        },
        LATENT(false) {
            /* access modifiers changed from: protected */
            public byte[] lookup(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                return concurrentMap.remove(str);
            }

            /* access modifiers changed from: protected */
            public void release(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                concurrentMap.remove(str);
            }

            /* access modifiers changed from: protected */
            public URL url(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                return ByteArrayClassLoader.NO_URL;
            }
        };
        
        private static final String CLASS_FILE_SUFFIX = ".class";
        private final boolean manifest;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class UrlDefinitionAction implements PrivilegedAction<URL> {
            private static final boolean ACCESS_CONTROLLER = false;
            private static final Dispatcher DISPATCHER = null;
            private static final String ENCODING = "UTF-8";
            private static final String NO_FILE = "";
            private static final int NO_PORT = -1;
            private final byte[] binaryRepresentation;
            private final String typeName;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class ByteArrayUrlStreamHandler extends URLStreamHandler {
                private final byte[] binaryRepresentation;

                protected static class ByteArrayUrlConnection extends URLConnection {
                    private final InputStream inputStream;

                    protected ByteArrayUrlConnection(URL url, InputStream inputStream2) {
                        super(url);
                        this.inputStream = inputStream2;
                    }

                    public void connect() {
                        this.connected = true;
                    }

                    public InputStream getInputStream() {
                        connect();
                        return this.inputStream;
                    }
                }

                protected ByteArrayUrlStreamHandler(byte[] bArr) {
                    this.binaryRepresentation = bArr;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && Arrays.equals(this.binaryRepresentation, ((ByteArrayUrlStreamHandler) obj).binaryRepresentation);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + Arrays.hashCode(this.binaryRepresentation);
                }

                /* access modifiers changed from: protected */
                public URLConnection openConnection(URL url) {
                    return new ByteArrayUrlConnection(url, new ByteArrayInputStream(this.binaryRepresentation));
                }
            }

            @JavaDispatcher.Proxied("java.net.URL")
            protected interface Dispatcher {
                @JavaDispatcher.Proxied("make")
                @JavaDispatcher.IsConstructor
                URL make(String str, String str2, int i10, String str3, URLStreamHandler uRLStreamHandler) throws MalformedURLException;

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Defaults
                @MaybeNull
                @JavaDispatcher.Proxied("of")
                URL of(URI uri, URLStreamHandler uRLStreamHandler) throws MalformedURLException;
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
                DISPATCHER = (Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class));
                ACCESS_CONTROLLER = z10;
                DISPATCHER = (Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class));
            }

            protected UrlDefinitionAction(String str, byte[] bArr) {
                this.typeName = str;
                this.binaryRepresentation = bArr;
            }

            @AccessControllerPlugin.Enhance
            private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UrlDefinitionAction urlDefinitionAction = (UrlDefinitionAction) obj;
                return this.typeName.equals(urlDefinitionAction.typeName) && Arrays.equals(this.binaryRepresentation, urlDefinitionAction.binaryRepresentation);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.typeName.hashCode()) * 31) + Arrays.hashCode(this.binaryRepresentation);
            }

            public URL run() {
                try {
                    String encode = URLEncoder.encode(this.typeName.replace('.', '/'), "UTF-8");
                    ByteArrayUrlStreamHandler byteArrayUrlStreamHandler = new ByteArrayUrlStreamHandler(this.binaryRepresentation);
                    Dispatcher dispatcher = DISPATCHER;
                    URL of2 = dispatcher.of(URI.create("bytebuddy://" + encode), byteArrayUrlStreamHandler);
                    return of2 == null ? dispatcher.make(ByteArrayClassLoader.URL_SCHEMA, encode, -1, "", byteArrayUrlStreamHandler) : of2;
                } catch (MalformedURLException e10) {
                    throw new IllegalStateException("Cannot create URL for " + this.typeName, e10);
                } catch (UnsupportedEncodingException e11) {
                    throw new IllegalStateException("Could not find encoding: UTF-8", e11);
                }
            }
        }

        public boolean isManifest() {
            return this.manifest;
        }

        /* access modifiers changed from: protected */
        @MaybeNull
        public abstract byte[] lookup(String str, ConcurrentMap<String, byte[]> concurrentMap);

        /* access modifiers changed from: protected */
        public abstract void release(String str, ConcurrentMap<String, byte[]> concurrentMap);

        /* access modifiers changed from: protected */
        @MaybeNull
        public abstract URL url(String str, ConcurrentMap<String, byte[]> concurrentMap);

        private PersistenceHandler(boolean z10) {
            this.manifest = z10;
        }
    }

    protected static class SingletonEnumeration implements Enumeration<URL> {
        @MaybeNull
        private URL element;

        protected SingletonEnumeration(URL url) {
            this.element = url;
        }

        public boolean hasMoreElements() {
            return this.element != null;
        }

        public URL nextElement() {
            URL url = this.element;
            if (url != null) {
                this.element = null;
                return url;
            }
            throw new NoSuchElementException();
        }
    }

    protected interface SynchronizationStrategy {

        public enum CreationAction implements PrivilegedAction<Initializable> {
            INSTANCE;

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.lang.Object[]} */
            /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|(2:10|14)(2:9|15)) */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a4, code lost:
                return net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
                return new net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForJava7CapableVm(java.lang.ClassLoader.class.getDeclaredMethod("getClassLoadingLock", new java.lang.Class[]{r2}));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                return net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0085, code lost:
                if (net.bytebuddy.ClassFileVersion.ofThisVm(net.bytebuddy.ClassFileVersion.JAVA_V5).isAtLeast(net.bytebuddy.ClassFileVersion.JAVA_V9) == false) goto L_0x0092;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0079 */
            /* JADX WARNING: Multi-variable type inference failed */
            @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.Initializable run() {
                /*
                    r15 = this;
                    java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                    java.lang.String r1 = "getClassLoadingLock"
                    java.lang.Class<java.lang.String> r2 = java.lang.String.class
                    r3 = 1
                    r4 = 0
                    java.lang.String r5 = "java.lang.invoke.MethodType"
                    java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r6 = "java.lang.invoke.MethodHandle"
                    java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x0079 }
                    net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForJava8CapableVm r7 = new net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForJava8CapableVm     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r8 = "java.lang.invoke.MethodHandles$Lookup"
                    java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r9 = "findVirtual"
                    r10 = 3
                    java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x0079 }
                    java.lang.Class<java.lang.Class> r12 = java.lang.Class.class
                    r11[r4] = r12     // Catch:{ Exception -> 0x0079 }
                    r11[r3] = r2     // Catch:{ Exception -> 0x0079 }
                    r12 = 2
                    r11[r12] = r5     // Catch:{ Exception -> 0x0079 }
                    java.lang.reflect.Method r8 = r8.getMethod(r9, r11)     // Catch:{ Exception -> 0x0079 }
                    java.lang.Object r9 = net.bytebuddy.dynamic.loading.ByteArrayClassLoader.methodHandle()     // Catch:{ Exception -> 0x0079 }
                    java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0079 }
                    java.lang.Class<java.lang.ClassLoader> r11 = java.lang.ClassLoader.class
                    r10[r4] = r11     // Catch:{ Exception -> 0x0079 }
                    r10[r3] = r1     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r11 = "methodType"
                    java.lang.Class[] r13 = new java.lang.Class[r12]     // Catch:{ Exception -> 0x0079 }
                    java.lang.Class<java.lang.Class> r14 = java.lang.Class.class
                    r13[r4] = r14     // Catch:{ Exception -> 0x0079 }
                    java.lang.Class<java.lang.Class[]> r14 = java.lang.Class[].class
                    r13[r3] = r14     // Catch:{ Exception -> 0x0079 }
                    java.lang.reflect.Method r5 = r5.getMethod(r11, r13)     // Catch:{ Exception -> 0x0079 }
                    r11 = 0
                    java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x0079 }
                    r13[r4] = r0     // Catch:{ Exception -> 0x0079 }
                    java.lang.Class[] r14 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0079 }
                    r14[r4] = r2     // Catch:{ Exception -> 0x0079 }
                    r13[r3] = r14     // Catch:{ Exception -> 0x0079 }
                    java.lang.Object r5 = r5.invoke(r11, r13)     // Catch:{ Exception -> 0x0079 }
                    r10[r12] = r5     // Catch:{ Exception -> 0x0079 }
                    java.lang.Object r5 = r8.invoke(r9, r10)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r8 = "bindTo"
                    java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0079 }
                    r9[r4] = r0     // Catch:{ Exception -> 0x0079 }
                    java.lang.reflect.Method r0 = r6.getMethod(r8, r9)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r8 = "invokeWithArguments"
                    java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0079 }
                    java.lang.Class<java.lang.Object[]> r10 = java.lang.Object[].class
                    r9[r4] = r10     // Catch:{ Exception -> 0x0079 }
                    java.lang.reflect.Method r6 = r6.getMethod(r8, r9)     // Catch:{ Exception -> 0x0079 }
                    r7.<init>(r5, r0, r6)     // Catch:{ Exception -> 0x0079 }
                    return r7
                L_0x0079:
                    net.bytebuddy.ClassFileVersion r0 = net.bytebuddy.ClassFileVersion.JAVA_V5     // Catch:{ Exception -> 0x00a2 }
                    net.bytebuddy.ClassFileVersion r0 = net.bytebuddy.ClassFileVersion.ofThisVm(r0)     // Catch:{ Exception -> 0x00a2 }
                    net.bytebuddy.ClassFileVersion r5 = net.bytebuddy.ClassFileVersion.JAVA_V9     // Catch:{ Exception -> 0x00a2 }
                    boolean r0 = r0.isAtLeast(r5)     // Catch:{ Exception -> 0x00a2 }
                    if (r0 == 0) goto L_0x0092
                    java.lang.Class<net.bytebuddy.dynamic.loading.ByteArrayClassLoader> r0 = net.bytebuddy.dynamic.loading.ByteArrayClassLoader.class
                    java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ Exception -> 0x00a2 }
                    if (r0 != 0) goto L_0x0092
                    net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForLegacyVm r0 = net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE     // Catch:{ Exception -> 0x00a2 }
                    goto L_0x00a1
                L_0x0092:
                    net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForJava7CapableVm r0 = new net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForJava7CapableVm     // Catch:{ Exception -> 0x00a2 }
                    java.lang.Class<java.lang.ClassLoader> r5 = java.lang.ClassLoader.class
                    java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00a2 }
                    r3[r4] = r2     // Catch:{ Exception -> 0x00a2 }
                    java.lang.reflect.Method r1 = r5.getDeclaredMethod(r1, r3)     // Catch:{ Exception -> 0x00a2 }
                    r0.<init>(r1)     // Catch:{ Exception -> 0x00a2 }
                L_0x00a1:
                    return r0
                L_0x00a2:
                    net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForLegacyVm r0 = net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.CreationAction.run():net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$Initializable");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForJava7CapableVm implements SynchronizationStrategy, Initializable {
            private final Method method;

            protected ForJava7CapableVm(Method method2) {
                this.method = method2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForJava7CapableVm) obj).method);
            }

            public Object getClassLoadingLock(ByteArrayClassLoader byteArrayClassLoader, String str) {
                try {
                    return this.method.invoke(byteArrayClassLoader, new Object[]{str});
                } catch (IllegalAccessException e10) {
                    throw new IllegalStateException(e10);
                } catch (InvocationTargetException e11) {
                    throw new IllegalStateException(e11.getTargetException());
                }
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.method.hashCode();
            }

            @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
            public SynchronizationStrategy initialize() {
                try {
                    this.method.setAccessible(true);
                    return this;
                } catch (Exception unused) {
                    return ForLegacyVm.INSTANCE;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForJava8CapableVm implements SynchronizationStrategy, Initializable {
            private final Method bindTo;
            private final Method invokeWithArguments;
            private final Object methodHandle;

            protected ForJava8CapableVm(Object obj, Method method, Method method2) {
                this.methodHandle = obj;
                this.bindTo = method;
                this.invokeWithArguments = method2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForJava8CapableVm forJava8CapableVm = (ForJava8CapableVm) obj;
                return this.methodHandle.equals(forJava8CapableVm.methodHandle) && this.bindTo.equals(forJava8CapableVm.bindTo) && this.invokeWithArguments.equals(forJava8CapableVm.invokeWithArguments);
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object[]} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object getClassLoadingLock(net.bytebuddy.dynamic.loading.ByteArrayClassLoader r7, java.lang.String r8) {
                /*
                    r6 = this;
                    java.lang.reflect.Method r0 = r6.invokeWithArguments     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.reflect.Method r1 = r6.bindTo     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.Object r2 = r6.methodHandle     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    r3 = 1
                    java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    r5 = 0
                    r4[r5] = r7     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.Object r7 = r1.invoke(r2, r4)     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    r2[r5] = r8     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    r1[r5] = r2     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.Object r7 = r0.invoke(r7, r1)     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    return r7
                L_0x001d:
                    r7 = move-exception
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.Throwable r7 = r7.getTargetException()
                    r8.<init>(r7)
                    throw r8
                L_0x0028:
                    r7 = move-exception
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    r8.<init>(r7)
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForJava8CapableVm.getClassLoadingLock(net.bytebuddy.dynamic.loading.ByteArrayClassLoader, java.lang.String):java.lang.Object");
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.methodHandle.hashCode()) * 31) + this.bindTo.hashCode()) * 31) + this.invokeWithArguments.hashCode();
            }

            public SynchronizationStrategy initialize() {
                return this;
            }
        }

        public enum ForLegacyVm implements SynchronizationStrategy, Initializable {
            INSTANCE;

            public Object getClassLoadingLock(ByteArrayClassLoader byteArrayClassLoader, String str) {
                return byteArrayClassLoader;
            }

            public SynchronizationStrategy initialize() {
                return this;
            }
        }

        public interface Initializable {
            SynchronizationStrategy initialize();
        }

        Object getClassLoadingLock(ByteArrayClassLoader byteArrayClassLoader, String str);
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
        doRegisterAsParallelCapable();
        ACCESS_CONTROLLER = z10;
        doRegisterAsParallelCapable();
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map) {
        this(classLoader, true, map);
    }

    /* access modifiers changed from: private */
    @MaybeNull
    public Package doGetPackage(String str) {
        return getPackage(str);
    }

    /* access modifiers changed from: private */
    @AccessControllerPlugin.Enhance
    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    @SuppressFBWarnings(justification = "Must be invoked from targeting class loader type.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
    private static void doRegisterAsParallelCapable() {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke((Object) null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    @AccessControllerPlugin.Enhance
    @MaybeNull
    private static Object getContext() {
        if (ACCESS_CONTROLLER) {
            return AccessController.getContext();
        }
        return null;
    }

    public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map) {
        return load(classLoader, map, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, PersistenceHandler.LATENT, PackageDefinitionStrategy.Trivial.INSTANCE, false, true);
    }

    /* access modifiers changed from: private */
    public static Object methodHandle() throws Exception {
        return Class.forName("java.lang.invoke.MethodHandles").getMethod("lookup", new Class[0]).invoke((Object) null, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public Map<String, Class<?>> doDefineClasses(Map<String, byte[]> map) throws ClassNotFoundException {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(next.getKey(), this.typeDefinitions.putIfAbsent(next.getKey(), next.getValue()));
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String next2 : map.keySet()) {
                synchronized (SYNCHRONIZATION_STRATEGY.initialize().getClassLoadingLock(this, next2)) {
                    linkedHashMap.put(next2, loadClass(next2));
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getValue() == null) {
                    this.persistenceHandler.release((String) entry.getKey(), this.typeDefinitions);
                } else {
                    this.typeDefinitions.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        } catch (Throwable th2) {
            for (Map.Entry entry2 : hashMap.entrySet()) {
                if (entry2.getValue() == null) {
                    this.persistenceHandler.release((String) entry2.getKey(), this.typeDefinitions);
                } else {
                    this.typeDefinitions.put(entry2.getKey(), entry2.getValue());
                }
            }
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public Class<?> findClass(String str) throws ClassNotFoundException {
        byte[] lookup = this.persistenceHandler.lookup(str, this.typeDefinitions);
        if (lookup != null) {
            return (Class) doPrivileged(new ClassDefinitionAction(str, this.classFilePostProcessor.transform(this, str, this.protectionDomain, lookup)), this.accessControlContext);
        }
        throw new ClassNotFoundException(str);
    }

    /* access modifiers changed from: protected */
    @MaybeNull
    public URL findResource(String str) {
        return this.persistenceHandler.url(str, this.typeDefinitions);
    }

    /* access modifiers changed from: protected */
    public Enumeration<URL> findResources(String str) {
        URL url = this.persistenceHandler.url(str, this.typeDefinitions);
        if (url == null) {
            return EmptyEnumeration.INSTANCE;
        }
        return new SingletonEnumeration(url);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, boolean z10, Map<String, byte[]> map) {
        this(classLoader, z10, map, PersistenceHandler.LATENT);
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction, @MaybeNull Object obj) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction, (AccessControlContext) obj) : privilegedAction.run();
    }

    @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
    public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map, @MaybeNull ProtectionDomain protectionDomain2, PersistenceHandler persistenceHandler2, PackageDefinitionStrategy packageDefinitionStrategy2, boolean z10, boolean z11) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(((TypeDescription) next.getKey()).getName(), next.getValue());
        }
        ByteArrayClassLoader byteArrayClassLoader = new ByteArrayClassLoader(classLoader, z11, hashMap, protectionDomain2, persistenceHandler2, packageDefinitionStrategy2, ClassFilePostProcessor.NoOp.INSTANCE);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (TypeDescription next2 : map.keySet()) {
            try {
                Class<?> cls = Class.forName(next2.getName(), false, byteArrayClassLoader);
                if (!GraalImageCode.getCurrent().isNativeImageExecution() && z10) {
                    if (cls.getClassLoader() != byteArrayClassLoader) {
                        throw new IllegalStateException("Class already loaded: " + cls);
                    }
                }
                linkedHashMap.put(next2, cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Cannot load class " + next2, e10);
            }
        }
        return linkedHashMap;
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, PersistenceHandler persistenceHandler2) {
        this(classLoader, true, map, persistenceHandler2);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, boolean z10, Map<String, byte[]> map, PersistenceHandler persistenceHandler2) {
        this(classLoader, z10, map, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, persistenceHandler2, (PackageDefinitionStrategy) PackageDefinitionStrategy.Trivial.INSTANCE);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain2, PersistenceHandler persistenceHandler2, PackageDefinitionStrategy packageDefinitionStrategy2) {
        this(classLoader, true, map, protectionDomain2, persistenceHandler2, packageDefinitionStrategy2);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, boolean z10, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain2, PersistenceHandler persistenceHandler2, PackageDefinitionStrategy packageDefinitionStrategy2) {
        this(classLoader, z10, map, protectionDomain2, persistenceHandler2, packageDefinitionStrategy2, ClassFilePostProcessor.NoOp.INSTANCE);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain2, PersistenceHandler persistenceHandler2, PackageDefinitionStrategy packageDefinitionStrategy2, ClassFilePostProcessor classFilePostProcessor2) {
        this(classLoader, true, map, protectionDomain2, persistenceHandler2, packageDefinitionStrategy2, classFilePostProcessor2);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, boolean z10, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain2, PersistenceHandler persistenceHandler2, PackageDefinitionStrategy packageDefinitionStrategy2, ClassFilePostProcessor classFilePostProcessor2) {
        super(classLoader, z10);
        this.typeDefinitions = new ConcurrentHashMap(map);
        this.protectionDomain = protectionDomain2;
        this.persistenceHandler = persistenceHandler2;
        this.packageDefinitionStrategy = packageDefinitionStrategy2;
        this.classFilePostProcessor = classFilePostProcessor2;
        this.accessControlContext = getContext();
    }
}
