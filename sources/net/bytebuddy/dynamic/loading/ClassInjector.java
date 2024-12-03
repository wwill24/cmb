package net.bytebuddy.dynamic.loading;

import com.facebook.internal.ServerProtocol;
import com.sun.jna.FunctionMapper;
import com.sun.jna.JNIEnv;
import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;
import java.net.URL;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.MemberRemoval;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.GraalImageCode;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.nullability.UnknownNull;
import net.bytebuddy.utility.privilege.GetMethodAction;

public interface ClassInjector {
    public static final boolean ALLOW_EXISTING_TYPES = false;
    public static final Permission SUPPRESS_ACCESS_CHECKS = new ReflectPermission("suppressAccessChecks");

    public static abstract class AbstractBase implements ClassInjector {
        public Map<TypeDescription, Class<?>> inject(Map<? extends TypeDescription, byte[]> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put(((TypeDescription) next.getKey()).getName(), next.getValue());
            }
            Map<String, Class<?>> injectRaw = injectRaw(linkedHashMap);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (TypeDescription typeDescription : map.keySet()) {
                linkedHashMap2.put(typeDescription, injectRaw.get(typeDescription.getName()));
            }
            return linkedHashMap2;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingInstrumentation extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final String CLASS_FILE_EXTENSION = ".class";
        /* access modifiers changed from: private */
        public static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        private static final String JAR = "jar";
        private final File folder;
        private final Instrumentation instrumentation;
        private final RandomString randomString;
        private final Target target;

        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        protected interface Dispatcher {
            @JavaDispatcher.Proxied("appendToBootstrapClassLoaderSearch")
            void appendToBootstrapClassLoaderSearch(Instrumentation instrumentation, JarFile jarFile);

            @JavaDispatcher.Proxied("appendToSystemClassLoaderSearch")
            void appendToSystemClassLoaderSearch(Instrumentation instrumentation, JarFile jarFile);

            @JavaDispatcher.Proxied("isModifiableModule")
            boolean isModifiableModule(Instrumentation instrumentation, @JavaDispatcher.Proxied("java.lang.Module") Object obj);

            @JavaDispatcher.Proxied("redefineModule")
            void redefineModule(Instrumentation instrumentation, @JavaDispatcher.Proxied("java.lang.Module") Object obj, Set<?> set, Map<String, Set<?>> map, Map<String, Set<?>> map2, Set<Class<?>> set2, Map<Class<?>, List<Class<?>>> map3);
        }

        public enum Target {
            BOOTSTRAP((String) null) {
                /* access modifiers changed from: protected */
                public void inject(Instrumentation instrumentation, JarFile jarFile) {
                    UsingInstrumentation.DISPATCHER.appendToBootstrapClassLoaderSearch(instrumentation, jarFile);
                }
            },
            SYSTEM(ClassLoader.getSystemClassLoader()) {
                /* access modifiers changed from: protected */
                public void inject(Instrumentation instrumentation, JarFile jarFile) {
                    UsingInstrumentation.DISPATCHER.appendToSystemClassLoaderSearch(instrumentation, jarFile);
                }
            };
            
            @MaybeNull
            private final ClassLoader classLoader;

            /* access modifiers changed from: protected */
            @MaybeNull
            public ClassLoader getClassLoader() {
                return this.classLoader;
            }

            /* access modifiers changed from: protected */
            public abstract void inject(Instrumentation instrumentation, JarFile jarFile);

            private Target(@MaybeNull ClassLoader classLoader2) {
                this.classLoader = classLoader2;
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

        protected UsingInstrumentation(File file, Target target2, Instrumentation instrumentation2, RandomString randomString2) {
            this.folder = file;
            this.target = target2;
            this.instrumentation = instrumentation2;
            this.randomString = randomString2;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static boolean isAvailable() {
            return ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V6);
        }

        public static ClassInjector of(File file, Target target2, Instrumentation instrumentation2) {
            return new UsingInstrumentation(file, target2, instrumentation2, new RandomString());
        }

        public static void redefineModule(Instrumentation instrumentation2, JavaModule javaModule, Set<JavaModule> set, Map<String, Set<JavaModule>> map, Map<String, Set<JavaModule>> map2, Set<Class<?>> set2, Map<Class<?>, List<Class<?>>> map3) {
            if (DISPATCHER.isModifiableModule(instrumentation2, javaModule.unwrap())) {
                HashSet hashSet = new HashSet();
                for (JavaModule unwrap : set) {
                    hashSet.add(unwrap.unwrap());
                }
                HashMap hashMap = new HashMap();
                for (Map.Entry next : map.entrySet()) {
                    HashSet hashSet2 = new HashSet();
                    for (JavaModule unwrap2 : (Set) next.getValue()) {
                        hashSet2.add(unwrap2.unwrap());
                    }
                    hashMap.put(next.getKey(), hashSet2);
                }
                HashMap hashMap2 = new HashMap();
                for (Map.Entry next2 : map2.entrySet()) {
                    HashSet hashSet3 = new HashSet();
                    for (JavaModule unwrap3 : (Set) next2.getValue()) {
                        hashSet3.add(unwrap3.unwrap());
                    }
                    hashMap2.put(next2.getKey(), hashSet3);
                }
                DISPATCHER.redefineModule(instrumentation2, javaModule.unwrap(), hashSet, hashMap, hashMap2, set2, map3);
                return;
            }
            throw new IllegalArgumentException("Cannot modify module: " + javaModule);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UsingInstrumentation usingInstrumentation = (UsingInstrumentation) obj;
            return this.target.equals(usingInstrumentation.target) && this.instrumentation.equals(usingInstrumentation.instrumentation) && this.folder.equals(usingInstrumentation.folder) && this.randomString.equals(usingInstrumentation.randomString);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + this.target.hashCode()) * 31) + this.folder.hashCode()) * 31) + this.randomString.hashCode();
        }

        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map) {
            JarOutputStream jarOutputStream;
            JarFile jarFile;
            File file = this.folder;
            File file2 = new File(file, JAR + this.randomString.nextString() + "." + JAR);
            try {
                if (file2.createNewFile()) {
                    try {
                        jarOutputStream = new JarOutputStream(new FileOutputStream(file2));
                        for (Map.Entry next : map.entrySet()) {
                            jarOutputStream.putNextEntry(new JarEntry(((String) next.getKey()).replace('.', '/') + ".class"));
                            jarOutputStream.write((byte[]) next.getValue());
                        }
                        jarOutputStream.close();
                        jarFile = new JarFile(file2, false);
                        this.target.inject(this.instrumentation, jarFile);
                        jarFile.close();
                        HashMap hashMap = new HashMap();
                        for (String str : map.keySet()) {
                            hashMap.put(str, Class.forName(str, false, this.target.getClassLoader()));
                        }
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        return hashMap;
                    } catch (Throwable th2) {
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("Cannot create file " + file2);
                }
            } catch (IOException e10) {
                throw new IllegalStateException("Cannot write jar file to disk", e10);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Cannot load injected class", e11);
            }
        }

        public boolean isAlive() {
            return isAvailable();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingJna extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final Object BOOTSTRAP_LOADER_LOCK = new Object();
        private static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(Dispatcher.CreationAction.INSTANCE));
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final ClassLoader classLoader;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final ProtectionDomain protectionDomain;

        protected interface Dispatcher {

            public enum CreationAction implements PrivilegedAction<Dispatcher> {
                INSTANCE;

                public Dispatcher run() {
                    if (System.getProperty("java.vm.name", "").toUpperCase(Locale.US).contains("J9")) {
                        return new Unavailable("J9 does not support JNA-based class definition");
                    }
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("allow-objects", Boolean.TRUE);
                        if (Platform.isWindows() && !Platform.is64Bit()) {
                            hashMap.put("function-mapper", Windows32BitFunctionMapper.INSTANCE);
                        }
                        return new Enabled((Jvm) Native.loadLibrary("jvm", Jvm.class, hashMap));
                    } catch (Throwable th2) {
                        return new Unavailable(th2.getMessage());
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements Dispatcher {
                private final Jvm jvm;

                protected Enabled(Jvm jvm2) {
                    this.jvm = jvm2;
                }

                public Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    return this.jvm.JVM_DefineClass(JNIEnv.CURRENT, str.replace('.', '/'), classLoader, bArr, bArr.length, protectionDomain);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.jvm.equals(((Enabled) obj).jvm);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.jvm.hashCode();
                }

                public boolean isAvailable() {
                    return true;
                }
            }

            public interface Jvm extends Library {
                Class<?> JVM_DefineClass(JNIEnv jNIEnv, String str, @MaybeNull ClassLoader classLoader, byte[] bArr, int i10, @MaybeNull ProtectionDomain protectionDomain) throws LastErrorException;
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unavailable implements Dispatcher {
                private final String error;

                protected Unavailable(String str) {
                    this.error = str;
                }

                public Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("JNA is not available and JNA-based injection cannot be used: " + this.error);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.error.equals(((Unavailable) obj).error);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.error.hashCode();
                }

                public boolean isAvailable() {
                    return false;
                }
            }

            public enum Windows32BitFunctionMapper implements FunctionMapper {
                INSTANCE;

                public String getFunctionName(NativeLibrary nativeLibrary, Method method) {
                    if (method.getName().equals("JVM_DefineClass")) {
                        return "_JVM_DefineClass@24";
                    }
                    return method.getName();
                }
            }

            Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain);

            boolean isAvailable();
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

        public UsingJna(@MaybeNull ClassLoader classLoader2) {
            this(classLoader2, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofBootLoader() {
            return new UsingJna(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        public static ClassInjector ofPlatformLoader() {
            return new UsingJna(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassInjector ofSystemLoader() {
            return new UsingJna(ClassLoader.getSystemClassLoader());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r2 != null) goto L_0x0026;
         */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0039 A[RETURN] */
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
                java.lang.ClassLoader r2 = r4.classLoader
                net.bytebuddy.dynamic.loading.ClassInjector$UsingJna r5 = (net.bytebuddy.dynamic.loading.ClassInjector.UsingJna) r5
                java.lang.ClassLoader r3 = r5.classLoader
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
                java.security.ProtectionDomain r2 = r4.protectionDomain
                java.security.ProtectionDomain r5 = r5.protectionDomain
                if (r5 == 0) goto L_0x0036
                if (r2 == 0) goto L_0x0038
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L_0x0039
                return r1
            L_0x0036:
                if (r2 == 0) goto L_0x0039
            L_0x0038:
                return r1
            L_0x0039:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = getClass().hashCode() * 31;
            ClassLoader classLoader2 = this.classLoader;
            if (classLoader2 != null) {
                hashCode += classLoader2.hashCode();
            }
            int i10 = hashCode * 31;
            ProtectionDomain protectionDomain2 = this.protectionDomain;
            return protectionDomain2 != null ? i10 + protectionDomain2.hashCode() : i10;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|10|11|12|21|18|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0035 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Map<java.lang.String, java.lang.Class<?>> injectRaw(java.util.Map<? extends java.lang.String, byte[]> r9) {
            /*
                r8 = this;
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                java.lang.ClassLoader r1 = r8.classLoader
                if (r1 != 0) goto L_0x000b
                java.lang.Object r1 = BOOTSTRAP_LOADER_LOCK
            L_0x000b:
                monitor-enter(r1)
                java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0055 }
                java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0055 }
            L_0x0014:
                boolean r2 = r9.hasNext()     // Catch:{ all -> 0x0055 }
                if (r2 == 0) goto L_0x0053
                java.lang.Object r2 = r9.next()     // Catch:{ all -> 0x0055 }
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0055 }
                java.lang.Object r3 = r2.getKey()     // Catch:{ ClassNotFoundException -> 0x0035 }
                java.lang.Object r4 = r2.getKey()     // Catch:{ ClassNotFoundException -> 0x0035 }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ ClassNotFoundException -> 0x0035 }
                r5 = 0
                java.lang.ClassLoader r6 = r8.classLoader     // Catch:{ ClassNotFoundException -> 0x0035 }
                java.lang.Class r4 = java.lang.Class.forName(r4, r5, r6)     // Catch:{ ClassNotFoundException -> 0x0035 }
                r0.put(r3, r4)     // Catch:{ ClassNotFoundException -> 0x0035 }
                goto L_0x0014
            L_0x0035:
                java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x0055 }
                net.bytebuddy.dynamic.loading.ClassInjector$UsingJna$Dispatcher r4 = DISPATCHER     // Catch:{ all -> 0x0055 }
                java.lang.ClassLoader r5 = r8.classLoader     // Catch:{ all -> 0x0055 }
                java.lang.Object r6 = r2.getKey()     // Catch:{ all -> 0x0055 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0055 }
                java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0055 }
                byte[] r2 = (byte[]) r2     // Catch:{ all -> 0x0055 }
                java.security.ProtectionDomain r7 = r8.protectionDomain     // Catch:{ all -> 0x0055 }
                java.lang.Class r2 = r4.defineClass(r5, r6, r2, r7)     // Catch:{ all -> 0x0055 }
                r0.put(r3, r2)     // Catch:{ all -> 0x0055 }
                goto L_0x0014
            L_0x0053:
                monitor-exit(r1)     // Catch:{ all -> 0x0055 }
                return r0
            L_0x0055:
                r9 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0055 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.injectRaw(java.util.Map):java.util.Map");
        }

        public boolean isAlive() {
            return DISPATCHER.isAvailable();
        }

        public UsingJna(@MaybeNull ClassLoader classLoader2, @MaybeNull ProtectionDomain protectionDomain2) {
            this.classLoader = classLoader2;
            this.protectionDomain = protectionDomain2;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingLookup extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final MethodHandles METHOD_HANDLES = ((MethodHandles) doPrivileged(JavaDispatcher.of(MethodHandles.class)));
        private static final MethodHandles.Lookup METHOD_HANDLES_LOOKUP = ((MethodHandles.Lookup) doPrivileged(JavaDispatcher.of(MethodHandles.Lookup.class)));
        private static final int PACKAGE_LOOKUP = 8;
        private final Object lookup;

        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles")
        protected interface MethodHandles {

            @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup")
            public interface Lookup {
                @JavaDispatcher.Proxied("defineClass")
                Class<?> defineClass(Object obj, byte[] bArr) throws IllegalAccessException;

                @JavaDispatcher.Proxied("lookupClass")
                Class<?> lookupClass(Object obj);

                @JavaDispatcher.Proxied("lookupModes")
                int lookupModes(Object obj);
            }

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("privateLookupIn")
            Object privateLookupIn(Class<?> cls, @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup") Object obj) throws IllegalAccessException;
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

        protected UsingLookup(Object obj) {
            this.lookup = obj;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static boolean isAvailable() {
            return JavaType.MODULE.isAvailable();
        }

        public static UsingLookup of(Object obj) {
            if (!isAvailable()) {
                throw new IllegalStateException("The current VM does not support class definition via method handle lookups");
            } else if (!JavaType.METHOD_HANDLES_LOOKUP.isInstance(obj)) {
                throw new IllegalArgumentException("Not a method handle lookup: " + obj);
            } else if ((METHOD_HANDLES_LOOKUP.lookupModes(obj) & 8) != 0) {
                return new UsingLookup(obj);
            } else {
                throw new IllegalArgumentException("Lookup does not imply package-access: " + obj);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.lookup.equals(((UsingLookup) obj).lookup);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.lookup.hashCode();
        }

        public UsingLookup in(Class<?> cls) {
            try {
                return new UsingLookup(METHOD_HANDLES.privateLookupIn(cls, this.lookup));
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException("Cannot access " + cls.getName() + " from " + this.lookup, e10);
            }
        }

        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map) {
            String str;
            PackageDescription packageDescription = TypeDescription.ForLoadedType.of(lookupType()).getPackage();
            if (packageDescription != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry next : map.entrySet()) {
                    int lastIndexOf = ((String) next.getKey()).lastIndexOf(46);
                    String name = packageDescription.getName();
                    if (lastIndexOf == -1) {
                        str = "";
                    } else {
                        str = ((String) next.getKey()).substring(0, lastIndexOf);
                    }
                    if (name.equals(str)) {
                        try {
                            hashMap.put(next.getKey(), METHOD_HANDLES_LOOKUP.defineClass(this.lookup, (byte[]) next.getValue()));
                        } catch (Exception e10) {
                            throw new IllegalStateException(e10);
                        }
                    } else {
                        throw new IllegalArgumentException(((String) next.getKey()) + " must be defined in the same package as " + this.lookup);
                    }
                }
                return hashMap;
            }
            throw new IllegalArgumentException("Cannot inject array or primitive type");
        }

        public boolean isAlive() {
            return isAvailable();
        }

        public Class<?> lookupType() {
            return METHOD_HANDLES_LOOKUP.lookupClass(this.lookup);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingReflection extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        /* access modifiers changed from: private */
        public static final Method CHECK_PERMISSION = ((Method) doPrivileged(new GetMethodAction("java.lang.SecurityManager", "checkPermission", Permission.class)));
        private static final Dispatcher.Initializable DISPATCHER = ((Dispatcher.Initializable) doPrivileged(Dispatcher.CreationAction.INSTANCE));
        /* access modifiers changed from: private */
        public static final System SYSTEM = ((System) doPrivileged(JavaDispatcher.of(System.class)));
        private final ClassLoader classLoader;
        private final boolean forbidExisting;
        private final PackageDefinitionStrategy packageDefinitionStrategy;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final ProtectionDomain protectionDomain;

        protected interface Dispatcher {
            @AlwaysNull
            public static final Class<?> UNDEFINED = null;

            public enum CreationAction implements PrivilegedAction<Initializable> {
                INSTANCE;

                @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
                public Initializable run() {
                    try {
                        if (!JavaModule.isSupported()) {
                            return Direct.make();
                        }
                        if (UsingUnsafe.isAvailable()) {
                            return UsingUnsafeInjection.make();
                        }
                        return UsingUnsafeOverride.make();
                    } catch (InvocationTargetException e10) {
                        return new Initializable.Unavailable(e10.getTargetException().getMessage());
                    } catch (Exception e11) {
                        return new Initializable.Unavailable(e11.getMessage());
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Direct implements Dispatcher, Initializable {
                protected final Method defineClass;
                protected final Method definePackage;
                protected final Method findLoadedClass;
                @UnknownNull
                protected final Method getDefinedPackage;
                protected final Method getPackage;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class ForJava7CapableVm extends Direct {
                    private final Method getClassLoadingLock;

                    protected ForJava7CapableVm(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5, Method method6) {
                        super(method, method2, method3, method4, method5);
                        this.getClassLoadingLock = method6;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.getClassLoadingLock.equals(((ForJava7CapableVm) obj).getClassLoadingLock);
                    }

                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        try {
                            return this.getClassLoadingLock.invoke(classLoader, new Object[]{str});
                        } catch (IllegalAccessException e10) {
                            throw new IllegalStateException(e10);
                        } catch (InvocationTargetException e11) {
                            throw new IllegalStateException(e11.getTargetException());
                        }
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.getClassLoadingLock.hashCode();
                    }
                }

                protected static class ForLegacyVm extends Direct {
                    protected ForLegacyVm(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5) {
                        super(method, method2, method3, method4, method5);
                    }

                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        return classLoader;
                    }
                }

                protected Direct(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5) {
                    this.findLoadedClass = method;
                    this.defineClass = method2;
                    this.getDefinedPackage = method3;
                    this.getPackage = method4;
                    this.definePackage = method5;
                }

                @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
                protected static Initializable make() throws Exception {
                    Class<String> cls = String.class;
                    Method method = null;
                    if (JavaModule.isSupported()) {
                        try {
                            method = ClassLoader.class.getMethod("getDefinedPackage", new Class[]{cls});
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                    Method declaredMethod = ClassLoader.class.getDeclaredMethod("getPackage", new Class[]{cls});
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = ClassLoader.class.getDeclaredMethod("findLoadedClass", new Class[]{cls});
                    declaredMethod2.setAccessible(true);
                    Class cls2 = Integer.TYPE;
                    Method declaredMethod3 = ClassLoader.class.getDeclaredMethod("defineClass", new Class[]{cls, byte[].class, cls2, cls2, ProtectionDomain.class});
                    declaredMethod3.setAccessible(true);
                    Method declaredMethod4 = ClassLoader.class.getDeclaredMethod("definePackage", new Class[]{cls, cls, cls, cls, cls, cls, cls, URL.class});
                    declaredMethod4.setAccessible(true);
                    try {
                        Method declaredMethod5 = ClassLoader.class.getDeclaredMethod("getClassLoadingLock", new Class[]{cls});
                        declaredMethod5.setAccessible(true);
                        return new ForJava7CapableVm(declaredMethod2, declaredMethod3, method, declaredMethod, declaredMethod4, declaredMethod5);
                    } catch (NoSuchMethodException unused2) {
                        return new ForLegacyVm(declaredMethod2, declaredMethod3, method, declaredMethod, declaredMethod4);
                    }
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(classLoader, new Object[]{str, bArr, 0, Integer.valueOf(bArr.length), protectionDomain});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url) {
                    try {
                        return (Package) this.definePackage.invoke(classLoader, new Object[]{str, str2, str3, str4, str5, str6, str7, url});
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
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Direct direct = (Direct) obj;
                    return this.findLoadedClass.equals(direct.findLoadedClass) && this.defineClass.equals(direct.defineClass) && this.getDefinedPackage.equals(direct.getDefinedPackage) && this.getPackage.equals(direct.getPackage) && this.definePackage.equals(direct.definePackage);
                }

                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return (Class) this.findLoadedClass.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                @MaybeNull
                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    Method method = this.getDefinedPackage;
                    if (method == null) {
                        return getPackage(classLoader, str);
                    }
                    try {
                        return (Package) method.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public Package getPackage(ClassLoader classLoader, String str) {
                    try {
                        return (Package) this.getPackage.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public int hashCode() {
                    return (((((((((getClass().hashCode() * 31) + this.findLoadedClass.hashCode()) * 31) + this.defineClass.hashCode()) * 31) + this.getDefinedPackage.hashCode()) * 31) + this.getPackage.hashCode()) * 31) + this.definePackage.hashCode();
                }

                public Dispatcher initialize() {
                    Object securityManager = UsingReflection.SYSTEM.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            UsingReflection.CHECK_PERMISSION.invoke(securityManager, new Object[]{ClassInjector.SUPPRESS_ACCESS_CHECKS});
                        } catch (InvocationTargetException e10) {
                            return new Unavailable(e10.getTargetException().getMessage());
                        } catch (Exception e11) {
                            return new Unavailable(e11.getMessage());
                        }
                    }
                    return this;
                }

                public boolean isAvailable() {
                    return true;
                }
            }

            public interface Initializable {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Unavailable implements Dispatcher, Initializable {
                    private final String message;

                    protected Unavailable(String str) {
                        this.message = str;
                    }

                    public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                        throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message);
                    }

                    public Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url) {
                        throw new UnsupportedOperationException("Cannot define package using injection: " + this.message);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                    }

                    public Class<?> findClass(ClassLoader classLoader, String str) {
                        try {
                            return classLoader.loadClass(str);
                        } catch (ClassNotFoundException unused) {
                            return Dispatcher.UNDEFINED;
                        }
                    }

                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        return classLoader;
                    }

                    public Package getDefinedPackage(ClassLoader classLoader, String str) {
                        throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message);
                    }

                    public Package getPackage(ClassLoader classLoader, String str) {
                        throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.message.hashCode();
                    }

                    public Dispatcher initialize() {
                        return this;
                    }

                    public boolean isAvailable() {
                        return false;
                    }
                }

                Dispatcher initialize();

                boolean isAvailable();
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unavailable implements Dispatcher {
                private final String message;

                protected Unavailable(String str) {
                    this.message = str;
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message);
                }

                public Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url) {
                    throw new UnsupportedOperationException("Cannot define package using injection: " + this.message);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                }

                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return classLoader.loadClass(str);
                    } catch (ClassNotFoundException unused) {
                        return Dispatcher.UNDEFINED;
                    }
                }

                public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                    return classLoader;
                }

                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message);
                }

                public Package getPackage(ClassLoader classLoader, String str) {
                    throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.message.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class UsingUnsafeInjection implements Dispatcher, Initializable {
                private final Object accessor;
                private final Method defineClass;
                private final Method definePackage;
                private final Method findLoadedClass;
                private final Method getClassLoadingLock;
                @UnknownNull
                private final Method getDefinedPackage;
                private final Method getPackage;

                protected UsingUnsafeInjection(Object obj, Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5, Method method6) {
                    this.accessor = obj;
                    this.findLoadedClass = method;
                    this.defineClass = method2;
                    this.getDefinedPackage = method3;
                    this.getPackage = method4;
                    this.definePackage = method5;
                    this.getClassLoadingLock = method6;
                }

                /* JADX WARNING: Removed duplicated region for block: B:13:0x01c1  */
                /* JADX WARNING: Removed duplicated region for block: B:14:0x01ee  */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x029b  */
                /* JADX WARNING: Removed duplicated region for block: B:32:0x02ab  */
                @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
                /* Code decompiled incorrectly, please refer to instructions dump. */
                protected static net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable make() throws java.lang.Exception {
                    /*
                        java.lang.Class<byte[]> r0 = byte[].class
                        java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
                        java.lang.String r2 = "getClassLoadingLock"
                        java.lang.Class<java.lang.String> r3 = java.lang.String.class
                        net.bytebuddy.utility.GraalImageCode r4 = net.bytebuddy.utility.GraalImageCode.getCurrent()
                        boolean r4 = r4.isDefined()
                        java.lang.String r4 = java.lang.Boolean.toString(r4)
                        java.lang.String r5 = "net.bytebuddy.safe"
                        java.lang.String r4 = java.lang.System.getProperty(r5, r4)
                        boolean r4 = java.lang.Boolean.parseBoolean(r4)
                        if (r4 == 0) goto L_0x0028
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Initializable$Unavailable r0 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Initializable$Unavailable
                        java.lang.String r1 = "Use of Unsafe was disabled by system property"
                        r0.<init>(r1)
                        return r0
                    L_0x0028:
                        java.lang.String r4 = "sun.misc.Unsafe"
                        java.lang.Class r4 = java.lang.Class.forName(r4)
                        java.lang.String r5 = "theUnsafe"
                        java.lang.reflect.Field r5 = r4.getDeclaredField(r5)
                        r6 = 1
                        r5.setAccessible(r6)
                        r7 = 0
                        java.lang.Object r5 = r5.get(r7)
                        boolean r8 = net.bytebuddy.utility.JavaModule.isSupported()
                        java.lang.String r9 = "getDefinedPackage"
                        r10 = 0
                        if (r8 == 0) goto L_0x0051
                        java.lang.Class<java.lang.ClassLoader> r8 = java.lang.ClassLoader.class
                        java.lang.Class[] r11 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x0051 }
                        r11[r10] = r3     // Catch:{ NoSuchMethodException -> 0x0051 }
                        java.lang.reflect.Method r8 = r8.getDeclaredMethod(r9, r11)     // Catch:{ NoSuchMethodException -> 0x0051 }
                        goto L_0x0052
                    L_0x0051:
                        r8 = r7
                    L_0x0052:
                        net.bytebuddy.ByteBuddy r11 = new net.bytebuddy.ByteBuddy
                        r11.<init>()
                        net.bytebuddy.dynamic.scaffold.TypeValidation r12 = net.bytebuddy.dynamic.scaffold.TypeValidation.DISABLED
                        net.bytebuddy.ByteBuddy r11 = r11.with((net.bytebuddy.dynamic.scaffold.TypeValidation) r12)
                        net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy$Default r12 = net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.NO_CONSTRUCTORS
                        net.bytebuddy.dynamic.DynamicType$Builder r11 = r11.subclass(r1, (net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy) r12)
                        java.lang.StringBuilder r12 = new java.lang.StringBuilder
                        r12.<init>()
                        java.lang.Class<java.lang.ClassLoader> r13 = java.lang.ClassLoader.class
                        java.lang.String r13 = r13.getName()
                        r12.append(r13)
                        java.lang.String r13 = "$ByteBuddyAccessor$V1"
                        r12.append(r13)
                        java.lang.String r12 = r12.toString()
                        net.bytebuddy.dynamic.DynamicType$Builder r11 = r11.name(r12)
                        java.lang.Class<java.lang.Class> r12 = java.lang.Class.class
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r13 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r6]
                        net.bytebuddy.description.modifier.Visibility r14 = net.bytebuddy.description.modifier.Visibility.PUBLIC
                        r13[r10] = r14
                        java.lang.String r15 = "findLoadedClass"
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r11 = r11.defineMethod((java.lang.String) r15, (java.lang.reflect.Type) r12, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r13)
                        r12 = 2
                        java.lang.reflect.Type[] r13 = new java.lang.reflect.Type[r12]
                        java.lang.Class<java.lang.ClassLoader> r16 = java.lang.ClassLoader.class
                        r13[r10] = r16
                        r13[r6] = r3
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r11 = r11.withParameters((java.lang.reflect.Type[]) r13)
                        java.lang.Class<java.lang.ClassLoader> r13 = java.lang.ClassLoader.class
                        java.lang.String r7 = "findLoadedClass"
                        java.lang.Class[] r12 = new java.lang.Class[r6]
                        r12[r10] = r3
                        java.lang.reflect.Method r7 = r13.getDeclaredMethod(r7, r12)
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r7 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r7)
                        net.bytebuddy.implementation.MethodCall r7 = r7.onArgument(r10)
                        int[] r12 = new int[r6]
                        r12[r10] = r6
                        net.bytebuddy.implementation.MethodCall r7 = r7.withArgument(r12)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r7 = r11.intercept(r7)
                        java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r12 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r6]
                        r12[r10] = r14
                        java.lang.String r13 = "defineClass"
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r7 = r7.defineMethod((java.lang.String) r13, (java.lang.reflect.Type) r11, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r12)
                        r11 = 6
                        java.lang.reflect.Type[] r12 = new java.lang.reflect.Type[r11]
                        java.lang.Class<java.lang.ClassLoader> r18 = java.lang.ClassLoader.class
                        r12[r10] = r18
                        r12[r6] = r3
                        r17 = 2
                        r12[r17] = r0
                        java.lang.Class r18 = java.lang.Integer.TYPE
                        r19 = 3
                        r12[r19] = r18
                        r20 = 4
                        r12[r20] = r18
                        java.lang.Class<java.security.ProtectionDomain> r21 = java.security.ProtectionDomain.class
                        r11 = 5
                        r12[r11] = r21
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r7 = r7.withParameters((java.lang.reflect.Type[]) r12)
                        java.lang.Class<java.lang.ClassLoader> r12 = java.lang.ClassLoader.class
                        java.lang.String r6 = "defineClass"
                        r23 = r13
                        java.lang.Class[] r13 = new java.lang.Class[r11]
                        r13[r10] = r3
                        r21 = 1
                        r13[r21] = r0
                        r17 = 2
                        r13[r17] = r18
                        r13[r19] = r18
                        java.lang.Class<java.security.ProtectionDomain> r18 = java.security.ProtectionDomain.class
                        r13[r20] = r18
                        java.lang.reflect.Method r6 = r12.getDeclaredMethod(r6, r13)
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r6 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r6)
                        net.bytebuddy.implementation.MethodCall r6 = r6.onArgument(r10)
                        int[] r12 = new int[r11]
                        r12 = {1, 2, 3, 4, 5} // fill-array
                        net.bytebuddy.implementation.MethodCall r6 = r6.withArgument(r12)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r6 = r7.intercept(r6)
                        java.lang.Class<java.lang.Package> r7 = java.lang.Package.class
                        r12 = 1
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r13 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r12]
                        r13[r10] = r14
                        java.lang.String r11 = "getPackage"
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r6 = r6.defineMethod((java.lang.String) r11, (java.lang.reflect.Type) r7, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r13)
                        r7 = 2
                        java.lang.reflect.Type[] r13 = new java.lang.reflect.Type[r7]
                        java.lang.Class<java.lang.ClassLoader> r7 = java.lang.ClassLoader.class
                        r13[r10] = r7
                        r13[r12] = r3
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r6 = r6.withParameters((java.lang.reflect.Type[]) r13)
                        java.lang.Class<java.lang.ClassLoader> r7 = java.lang.ClassLoader.class
                        java.lang.String r13 = "getPackage"
                        r24 = r11
                        java.lang.Class[] r11 = new java.lang.Class[r12]
                        r11[r10] = r3
                        java.lang.reflect.Method r7 = r7.getDeclaredMethod(r13, r11)
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r7 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r7)
                        net.bytebuddy.implementation.MethodCall r7 = r7.onArgument(r10)
                        int[] r11 = new int[r12]
                        r11[r10] = r12
                        net.bytebuddy.implementation.MethodCall r7 = r7.withArgument(r11)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r6 = r6.intercept(r7)
                        java.lang.Class<java.lang.Package> r7 = java.lang.Package.class
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r11 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r12]
                        r11[r10] = r14
                        java.lang.String r13 = "definePackage"
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r6 = r6.defineMethod((java.lang.String) r13, (java.lang.reflect.Type) r7, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r11)
                        r7 = 9
                        java.lang.reflect.Type[] r11 = new java.lang.reflect.Type[r7]
                        java.lang.Class<java.lang.ClassLoader> r21 = java.lang.ClassLoader.class
                        r11[r10] = r21
                        r11[r12] = r3
                        r12 = 2
                        r11[r12] = r3
                        r11[r19] = r3
                        r11[r20] = r3
                        r12 = 5
                        r11[r12] = r3
                        r12 = 6
                        r11[r12] = r3
                        r12 = 7
                        r11[r12] = r3
                        java.lang.Class<java.net.URL> r25 = java.net.URL.class
                        r7 = 8
                        r11[r7] = r25
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r6 = r6.withParameters((java.lang.reflect.Type[]) r11)
                        java.lang.Class<java.lang.ClassLoader> r11 = java.lang.ClassLoader.class
                        java.lang.String r12 = "definePackage"
                        r26 = r13
                        java.lang.Class[] r13 = new java.lang.Class[r7]
                        r13[r10] = r3
                        r21 = 1
                        r13[r21] = r3
                        r17 = 2
                        r13[r17] = r3
                        r13[r19] = r3
                        r13[r20] = r3
                        r18 = 5
                        r13[r18] = r3
                        r22 = 6
                        r13[r22] = r3
                        java.lang.Class<java.net.URL> r27 = java.net.URL.class
                        r25 = 7
                        r13[r25] = r27
                        java.lang.reflect.Method r11 = r11.getDeclaredMethod(r12, r13)
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r11 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r11)
                        net.bytebuddy.implementation.MethodCall r11 = r11.onArgument(r10)
                        int[] r12 = new int[r7]
                        r12 = {1, 2, 3, 4, 5, 6, 7, 8} // fill-array
                        net.bytebuddy.implementation.MethodCall r11 = r11.withArgument(r12)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r6 = r6.intercept(r11)
                        if (r8 == 0) goto L_0x01ee
                        java.lang.Class<java.lang.Package> r11 = java.lang.Package.class
                        r12 = 1
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r13 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r12]
                        r13[r10] = r14
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r6 = r6.defineMethod((java.lang.String) r9, (java.lang.reflect.Type) r11, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r13)
                        r11 = 2
                        java.lang.reflect.Type[] r13 = new java.lang.reflect.Type[r11]
                        java.lang.Class<java.lang.ClassLoader> r11 = java.lang.ClassLoader.class
                        r13[r10] = r11
                        r13[r12] = r3
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r6 = r6.withParameters((java.lang.reflect.Type[]) r13)
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r11 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r8)
                        net.bytebuddy.implementation.MethodCall r11 = r11.onArgument(r10)
                        int[] r13 = new int[r12]
                        r13[r10] = r12
                        net.bytebuddy.implementation.MethodCall r11 = r11.withArgument(r13)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r6 = r6.intercept(r11)
                        goto L_0x01ef
                    L_0x01ee:
                        r12 = 1
                    L_0x01ef:
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r11 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r12]     // Catch:{ NoSuchMethodException -> 0x0226 }
                        r11[r10] = r14     // Catch:{ NoSuchMethodException -> 0x0224 }
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r11 = r6.defineMethod((java.lang.String) r2, (java.lang.reflect.Type) r1, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r11)     // Catch:{ NoSuchMethodException -> 0x0224 }
                        r12 = 2
                        java.lang.reflect.Type[] r13 = new java.lang.reflect.Type[r12]     // Catch:{ NoSuchMethodException -> 0x0224 }
                        java.lang.Class<java.lang.ClassLoader> r12 = java.lang.ClassLoader.class
                        r13[r10] = r12     // Catch:{ NoSuchMethodException -> 0x0224 }
                        r12 = 1
                        r13[r12] = r3     // Catch:{ NoSuchMethodException -> 0x0226 }
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r11 = r11.withParameters((java.lang.reflect.Type[]) r13)     // Catch:{ NoSuchMethodException -> 0x0226 }
                        java.lang.Class<java.lang.ClassLoader> r13 = java.lang.ClassLoader.class
                        java.lang.Class[] r14 = new java.lang.Class[r12]     // Catch:{ NoSuchMethodException -> 0x0226 }
                        r14[r10] = r3     // Catch:{ NoSuchMethodException -> 0x0226 }
                        java.lang.reflect.Method r13 = r13.getDeclaredMethod(r2, r14)     // Catch:{ NoSuchMethodException -> 0x0226 }
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r13 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r13)     // Catch:{ NoSuchMethodException -> 0x0226 }
                        net.bytebuddy.implementation.MethodCall r13 = r13.onArgument(r10)     // Catch:{ NoSuchMethodException -> 0x0226 }
                        int[] r14 = new int[r12]     // Catch:{ NoSuchMethodException -> 0x0226 }
                        r14[r10] = r12     // Catch:{ NoSuchMethodException -> 0x0226 }
                        net.bytebuddy.implementation.MethodCall r12 = r13.withArgument(r14)     // Catch:{ NoSuchMethodException -> 0x0224 }
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r1 = r11.intercept(r12)     // Catch:{ NoSuchMethodException -> 0x0224 }
                        goto L_0x0246
                    L_0x0224:
                        r11 = 1
                        goto L_0x0227
                    L_0x0226:
                        r11 = r12
                    L_0x0227:
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r12 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r11]
                        net.bytebuddy.description.modifier.Visibility r13 = net.bytebuddy.description.modifier.Visibility.PUBLIC
                        r12[r10] = r13
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r1 = r6.defineMethod((java.lang.String) r2, (java.lang.reflect.Type) r1, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r12)
                        r6 = 2
                        java.lang.reflect.Type[] r12 = new java.lang.reflect.Type[r6]
                        java.lang.Class<java.lang.ClassLoader> r6 = java.lang.ClassLoader.class
                        r12[r10] = r6
                        r12[r11] = r3
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r1 = r1.withParameters((java.lang.reflect.Type[]) r12)
                        net.bytebuddy.implementation.FixedValue$AssignerConfigurable r6 = net.bytebuddy.implementation.FixedValue.argument(r10)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r1 = r1.intercept(r6)
                    L_0x0246:
                        net.bytebuddy.dynamic.DynamicType$Unloaded r1 = r1.make()
                        java.lang.ClassLoader r6 = net.bytebuddy.dynamic.loading.ClassLoadingStrategy.BOOTSTRAP_LOADER
                        net.bytebuddy.dynamic.loading.ClassLoadingStrategy$ForUnsafeInjection r11 = new net.bytebuddy.dynamic.loading.ClassLoadingStrategy$ForUnsafeInjection
                        r11.<init>()
                        net.bytebuddy.dynamic.DynamicType$Loaded r1 = r1.load(r6, r11)
                        java.lang.Class r1 = r1.getLoaded()
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$UsingUnsafeInjection r6 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$UsingUnsafeInjection
                        r11 = 1
                        java.lang.Class[] r12 = new java.lang.Class[r11]
                        java.lang.Class<java.lang.Class> r13 = java.lang.Class.class
                        r12[r10] = r13
                        java.lang.String r13 = "allocateInstance"
                        java.lang.reflect.Method r4 = r4.getMethod(r13, r12)
                        java.lang.Object[] r12 = new java.lang.Object[r11]
                        r12[r10] = r1
                        java.lang.Object r28 = r4.invoke(r5, r12)
                        r4 = 2
                        java.lang.Class[] r5 = new java.lang.Class[r4]
                        java.lang.Class<java.lang.ClassLoader> r12 = java.lang.ClassLoader.class
                        r5[r10] = r12
                        r5[r11] = r3
                        java.lang.reflect.Method r29 = r1.getMethod(r15, r5)
                        r5 = 6
                        java.lang.Class[] r12 = new java.lang.Class[r5]
                        java.lang.Class<java.lang.ClassLoader> r5 = java.lang.ClassLoader.class
                        r12[r10] = r5
                        r12[r11] = r3
                        r12[r4] = r0
                        java.lang.Class r0 = java.lang.Integer.TYPE
                        r12[r19] = r0
                        r12[r20] = r0
                        java.lang.Class<java.security.ProtectionDomain> r0 = java.security.ProtectionDomain.class
                        r5 = 5
                        r12[r5] = r0
                        r0 = r23
                        java.lang.reflect.Method r30 = r1.getMethod(r0, r12)
                        if (r8 == 0) goto L_0x02ab
                        java.lang.Class[] r0 = new java.lang.Class[r4]
                        java.lang.Class<java.lang.ClassLoader> r5 = java.lang.ClassLoader.class
                        r0[r10] = r5
                        r5 = 1
                        r0[r5] = r3
                        java.lang.reflect.Method r0 = r1.getMethod(r9, r0)
                        r31 = r0
                        goto L_0x02ae
                    L_0x02ab:
                        r5 = 1
                        r31 = 0
                    L_0x02ae:
                        java.lang.Class[] r0 = new java.lang.Class[r4]
                        java.lang.Class<java.lang.ClassLoader> r8 = java.lang.ClassLoader.class
                        r0[r10] = r8
                        r0[r5] = r3
                        r8 = r24
                        java.lang.reflect.Method r32 = r1.getMethod(r8, r0)
                        r0 = 9
                        java.lang.Class[] r0 = new java.lang.Class[r0]
                        java.lang.Class<java.lang.ClassLoader> r8 = java.lang.ClassLoader.class
                        r0[r10] = r8
                        r0[r5] = r3
                        r0[r4] = r3
                        r0[r19] = r3
                        r0[r20] = r3
                        r5 = 5
                        r0[r5] = r3
                        r5 = 6
                        r0[r5] = r3
                        r5 = 7
                        r0[r5] = r3
                        java.lang.Class<java.net.URL> r5 = java.net.URL.class
                        r0[r7] = r5
                        r5 = r26
                        java.lang.reflect.Method r33 = r1.getMethod(r5, r0)
                        java.lang.Class[] r0 = new java.lang.Class[r4]
                        java.lang.Class<java.lang.ClassLoader> r4 = java.lang.ClassLoader.class
                        r0[r10] = r4
                        r4 = 1
                        r0[r4] = r3
                        java.lang.reflect.Method r34 = r1.getMethod(r2, r0)
                        r27 = r6
                        r27.<init>(r28, r29, r30, r31, r32, r33, r34)
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.UsingUnsafeInjection.make():net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Initializable");
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(this.accessor, new Object[]{classLoader, str, bArr, 0, Integer.valueOf(bArr.length), protectionDomain});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url) {
                    try {
                        return (Package) this.definePackage.invoke(this.accessor, new Object[]{classLoader, str, str2, str3, str4, str5, str6, str7, url});
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
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    UsingUnsafeInjection usingUnsafeInjection = (UsingUnsafeInjection) obj;
                    return this.accessor.equals(usingUnsafeInjection.accessor) && this.findLoadedClass.equals(usingUnsafeInjection.findLoadedClass) && this.defineClass.equals(usingUnsafeInjection.defineClass) && this.getDefinedPackage.equals(usingUnsafeInjection.getDefinedPackage) && this.getPackage.equals(usingUnsafeInjection.getPackage) && this.definePackage.equals(usingUnsafeInjection.definePackage) && this.getClassLoadingLock.equals(usingUnsafeInjection.getClassLoadingLock);
                }

                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return (Class) this.findLoadedClass.invoke(this.accessor, new Object[]{classLoader, str});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                    try {
                        return this.getClassLoadingLock.invoke(this.accessor, new Object[]{classLoader, str});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                @MaybeNull
                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    Method method = this.getDefinedPackage;
                    if (method == null) {
                        return getPackage(classLoader, str);
                    }
                    try {
                        return (Package) method.invoke(this.accessor, new Object[]{classLoader, str});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public Package getPackage(ClassLoader classLoader, String str) {
                    try {
                        return (Package) this.getPackage.invoke(this.accessor, new Object[]{classLoader, str});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public int hashCode() {
                    return (((((((((((((getClass().hashCode() * 31) + this.accessor.hashCode()) * 31) + this.findLoadedClass.hashCode()) * 31) + this.defineClass.hashCode()) * 31) + this.getDefinedPackage.hashCode()) * 31) + this.getPackage.hashCode()) * 31) + this.definePackage.hashCode()) * 31) + this.getClassLoadingLock.hashCode();
                }

                public Dispatcher initialize() {
                    Object securityManager = UsingReflection.SYSTEM.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            UsingReflection.CHECK_PERMISSION.invoke(securityManager, new Object[]{ClassInjector.SUPPRESS_ACCESS_CHECKS});
                        } catch (InvocationTargetException e10) {
                            return new Unavailable(e10.getTargetException().getMessage());
                        } catch (Exception e11) {
                            return new Unavailable(e11.getMessage());
                        }
                    }
                    return this;
                }

                public boolean isAvailable() {
                    return true;
                }
            }

            public static abstract class UsingUnsafeOverride implements Dispatcher, Initializable {
                protected final Method defineClass;
                protected final Method definePackage;
                protected final Method findLoadedClass;
                @MaybeNull
                protected final Method getDefinedPackage;
                protected final Method getPackage;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class ForJava7CapableVm extends UsingUnsafeOverride {
                    private final Method getClassLoadingLock;

                    protected ForJava7CapableVm(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5, Method method6) {
                        super(method, method2, method3, method4, method5);
                        this.getClassLoadingLock = method6;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.getClassLoadingLock.equals(((ForJava7CapableVm) obj).getClassLoadingLock);
                    }

                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        try {
                            return this.getClassLoadingLock.invoke(classLoader, new Object[]{str});
                        } catch (IllegalAccessException e10) {
                            throw new IllegalStateException(e10);
                        } catch (InvocationTargetException e11) {
                            throw new IllegalStateException(e11.getTargetException());
                        }
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.getClassLoadingLock.hashCode();
                    }
                }

                protected static class ForLegacyVm extends UsingUnsafeOverride {
                    protected ForLegacyVm(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5) {
                        super(method, method2, method3, method4, method5);
                    }

                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        return classLoader;
                    }
                }

                protected UsingUnsafeOverride(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5) {
                    this.findLoadedClass = method;
                    this.defineClass = method2;
                    this.getDefinedPackage = method3;
                    this.getPackage = method4;
                    this.definePackage = method5;
                }

                @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
                protected static Initializable make() throws Exception {
                    Field field;
                    Class<String> cls = String.class;
                    if (Boolean.parseBoolean(System.getProperty(UsingUnsafe.SAFE_PROPERTY, Boolean.toString(GraalImageCode.getCurrent().isDefined())))) {
                        return new Initializable.Unavailable("Use of Unsafe was disabled by system property");
                    }
                    Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls2.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    Method method = null;
                    Object obj = declaredField.get((Object) null);
                    try {
                        field = AccessibleObject.class.getDeclaredField("override");
                    } catch (NoSuchFieldException unused) {
                        DynamicType.Builder<AccessibleObject> redefine = new ByteBuddy().redefine(AccessibleObject.class);
                        field = redefine.name("net.bytebuddy.mirror." + AccessibleObject.class.getSimpleName()).noNestMate().visit(new MemberRemoval().stripInvokables(ElementMatchers.any())).make().load(AccessibleObject.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER.with(AccessibleObject.class.getProtectionDomain())).getLoaded().getDeclaredField("override");
                    }
                    long longValue = ((Long) cls2.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(obj, new Object[]{field})).longValue();
                    Method method2 = cls2.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
                    if (JavaModule.isSupported()) {
                        try {
                            method = ClassLoader.class.getMethod("getDefinedPackage", new Class[]{cls});
                        } catch (NoSuchMethodException unused2) {
                        }
                    }
                    Method declaredMethod = ClassLoader.class.getDeclaredMethod("getPackage", new Class[]{cls});
                    Boolean bool = Boolean.TRUE;
                    method2.invoke(obj, new Object[]{declaredMethod, Long.valueOf(longValue), bool});
                    Method declaredMethod2 = ClassLoader.class.getDeclaredMethod("findLoadedClass", new Class[]{cls});
                    Class cls3 = Integer.TYPE;
                    Method declaredMethod3 = ClassLoader.class.getDeclaredMethod("defineClass", new Class[]{cls, byte[].class, cls3, cls3, ProtectionDomain.class});
                    Method declaredMethod4 = ClassLoader.class.getDeclaredMethod("definePackage", new Class[]{cls, cls, cls, cls, cls, cls, cls, URL.class});
                    method2.invoke(obj, new Object[]{declaredMethod3, Long.valueOf(longValue), bool});
                    method2.invoke(obj, new Object[]{declaredMethod2, Long.valueOf(longValue), bool});
                    method2.invoke(obj, new Object[]{declaredMethod4, Long.valueOf(longValue), bool});
                    try {
                        Method declaredMethod5 = ClassLoader.class.getDeclaredMethod("getClassLoadingLock", new Class[]{cls});
                        method2.invoke(obj, new Object[]{declaredMethod5, Long.valueOf(longValue), bool});
                        return new ForJava7CapableVm(declaredMethod2, declaredMethod3, method, declaredMethod, declaredMethod4, declaredMethod5);
                    } catch (NoSuchMethodException unused3) {
                        return new ForLegacyVm(declaredMethod2, declaredMethod3, method, declaredMethod, declaredMethod4);
                    }
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(classLoader, new Object[]{str, bArr, 0, Integer.valueOf(bArr.length), protectionDomain});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url) {
                    try {
                        return (Package) this.definePackage.invoke(classLoader, new Object[]{str, str2, str3, str4, str5, str6, str7, url});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return (Class) this.findLoadedClass.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                @MaybeNull
                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    Method method = this.getDefinedPackage;
                    if (method == null) {
                        return getPackage(classLoader, str);
                    }
                    try {
                        return (Package) method.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public Package getPackage(ClassLoader classLoader, String str) {
                    try {
                        return (Package) this.getPackage.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e10) {
                        throw new IllegalStateException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new IllegalStateException(e11.getTargetException());
                    }
                }

                public Dispatcher initialize() {
                    Object securityManager = UsingReflection.SYSTEM.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            UsingReflection.CHECK_PERMISSION.invoke(securityManager, new Object[]{ClassInjector.SUPPRESS_ACCESS_CHECKS});
                        } catch (InvocationTargetException e10) {
                            return new Unavailable(e10.getTargetException().getMessage());
                        } catch (Exception e11) {
                            return new Unavailable(e11.getMessage());
                        }
                    }
                    return this;
                }

                public boolean isAvailable() {
                    return true;
                }
            }

            Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain);

            Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url);

            @MaybeNull
            Class<?> findClass(ClassLoader classLoader, String str);

            Object getClassLoadingLock(ClassLoader classLoader, String str);

            @MaybeNull
            Package getDefinedPackage(ClassLoader classLoader, String str);

            @MaybeNull
            Package getPackage(ClassLoader classLoader, String str);
        }

        @JavaDispatcher.Proxied("java.lang.System")
        protected interface System {
            @JavaDispatcher.IsStatic
            @JavaDispatcher.Defaults
            @MaybeNull
            @JavaDispatcher.Proxied("getSecurityManager")
            Object getSecurityManager();
        }

        static {
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = false;
            } catch (SecurityException unused2) {
                ACCESS_CONTROLLER = true;
            }
        }

        public UsingReflection(ClassLoader classLoader2) {
            this(classLoader2, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofSystemClassLoader() {
            return new UsingReflection(ClassLoader.getSystemClassLoader());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
            if (r2 != null) goto L_0x0038;
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
                boolean r2 = r4.forbidExisting
                net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection r5 = (net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection) r5
                boolean r3 = r5.forbidExisting
                if (r2 == r3) goto L_0x001c
                return r1
            L_0x001c:
                java.lang.ClassLoader r2 = r4.classLoader
                java.lang.ClassLoader r3 = r5.classLoader
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0027
                return r1
            L_0x0027:
                java.security.ProtectionDomain r2 = r4.protectionDomain
                java.security.ProtectionDomain r3 = r5.protectionDomain
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
                net.bytebuddy.dynamic.loading.PackageDefinitionStrategy r2 = r4.packageDefinitionStrategy
                net.bytebuddy.dynamic.loading.PackageDefinitionStrategy r5 = r5.packageDefinitionStrategy
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L_0x0044
                return r1
            L_0x0044:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = ((getClass().hashCode() * 31) + this.classLoader.hashCode()) * 31;
            ProtectionDomain protectionDomain2 = this.protectionDomain;
            if (protectionDomain2 != null) {
                hashCode += protectionDomain2.hashCode();
            }
            return (((hashCode * 31) + this.packageDefinitionStrategy.hashCode()) * 31) + (this.forbidExisting ? 1 : 0);
        }

        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map) {
            Iterator<Map.Entry<? extends String, byte[]>> it;
            HashMap hashMap;
            PackageDefinitionStrategy.Definition definition;
            String str;
            Dispatcher initialize = DISPATCHER.initialize();
            HashMap hashMap2 = new HashMap();
            Iterator<Map.Entry<? extends String, byte[]>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                synchronized (initialize.getClassLoadingLock(this.classLoader, (String) next.getKey())) {
                    Class<?> findClass = initialize.findClass(this.classLoader, (String) next.getKey());
                    if (findClass == null) {
                        int lastIndexOf = ((String) next.getKey()).lastIndexOf(46);
                        if (lastIndexOf != -1) {
                            String substring = ((String) next.getKey()).substring(0, lastIndexOf);
                            PackageDefinitionStrategy.Definition define = this.packageDefinitionStrategy.define(this.classLoader, substring, (String) next.getKey());
                            if (define.isDefined()) {
                                Package definedPackage = initialize.getDefinedPackage(this.classLoader, substring);
                                if (definedPackage == null) {
                                    try {
                                        it = it2;
                                        definition = define;
                                        hashMap = hashMap2;
                                        str = substring;
                                        try {
                                            initialize.definePackage(this.classLoader, substring, define.getSpecificationTitle(), define.getSpecificationVersion(), define.getSpecificationVendor(), define.getImplementationTitle(), define.getImplementationVersion(), define.getImplementationVendor(), define.getSealBase());
                                        } catch (IllegalStateException e10) {
                                            e = e10;
                                        }
                                    } catch (IllegalStateException e11) {
                                        e = e11;
                                        hashMap = hashMap2;
                                        it = it2;
                                        definition = define;
                                        str = substring;
                                        Package packageR = initialize.getPackage(this.classLoader, str);
                                        if (packageR == null) {
                                            throw e;
                                        } else if (definition.isCompatibleTo(packageR)) {
                                            findClass = initialize.defineClass(this.classLoader, (String) next.getKey(), (byte[]) next.getValue(), this.protectionDomain);
                                            HashMap hashMap3 = hashMap;
                                            hashMap3.put(next.getKey(), findClass);
                                            it2 = it;
                                            hashMap2 = hashMap3;
                                        } else {
                                            throw new SecurityException("Sealing violation for package " + str + " (getPackage fallback)");
                                        }
                                    }
                                } else {
                                    hashMap = hashMap2;
                                    it = it2;
                                    String str2 = substring;
                                    if (!define.isCompatibleTo(definedPackage)) {
                                        throw new SecurityException("Sealing violation for package " + str2);
                                    }
                                }
                                findClass = initialize.defineClass(this.classLoader, (String) next.getKey(), (byte[]) next.getValue(), this.protectionDomain);
                            }
                        }
                        hashMap = hashMap2;
                        it = it2;
                        findClass = initialize.defineClass(this.classLoader, (String) next.getKey(), (byte[]) next.getValue(), this.protectionDomain);
                    } else {
                        hashMap = hashMap2;
                        it = it2;
                        if (this.forbidExisting) {
                            throw new IllegalStateException("Cannot inject already loaded type: " + findClass);
                        }
                    }
                    HashMap hashMap32 = hashMap;
                    hashMap32.put(next.getKey(), findClass);
                }
                it2 = it;
                hashMap2 = hashMap32;
            }
            return hashMap2;
        }

        public boolean isAlive() {
            return isAvailable();
        }

        public UsingReflection(ClassLoader classLoader2, @MaybeNull ProtectionDomain protectionDomain2) {
            this(classLoader2, protectionDomain2, PackageDefinitionStrategy.Trivial.INSTANCE, false);
        }

        public UsingReflection(ClassLoader classLoader2, @MaybeNull ProtectionDomain protectionDomain2, PackageDefinitionStrategy packageDefinitionStrategy2, boolean z10) {
            if (classLoader2 != null) {
                this.classLoader = classLoader2;
                this.protectionDomain = protectionDomain2;
                this.packageDefinitionStrategy = packageDefinitionStrategy2;
                this.forbidExisting = z10;
                return;
            }
            throw new IllegalArgumentException("Cannot inject classes into the bootstrap class loader");
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingUnsafe extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final Object BOOTSTRAP_LOADER_LOCK = new Object();
        /* access modifiers changed from: private */
        public static final Method CHECK_PERMISSION = ((Method) doPrivileged(new GetMethodAction("java.lang.SecurityManager", "checkPermission", Permission.class)));
        /* access modifiers changed from: private */
        public static final Dispatcher.Initializable DISPATCHER = ((Dispatcher.Initializable) doPrivileged(Dispatcher.CreationAction.INSTANCE));
        public static final String SAFE_PROPERTY = "net.bytebuddy.safe";
        /* access modifiers changed from: private */
        public static final System SYSTEM = ((System) doPrivileged(JavaDispatcher.of(System.class)));
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final ClassLoader classLoader;
        private final Dispatcher.Initializable dispatcher;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final ProtectionDomain protectionDomain;

        protected interface Dispatcher {

            public enum CreationAction implements PrivilegedAction<Initializable> {
                INSTANCE;

                /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
                /* JADX WARNING: Can't wrap try/catch for region: R(2:19|20) */
                /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
                    r8 = new net.bytebuddy.ByteBuddy().redefine(java.lang.reflect.AccessibleObject.class);
                    r2 = r8.name("net.bytebuddy.mirror." + java.lang.reflect.AccessibleObject.class.getSimpleName()).noNestMate().visit(new net.bytebuddy.asm.MemberRemoval().stripInvokables(net.bytebuddy.matcher.ElementMatchers.any())).make().load(java.lang.reflect.AccessibleObject.class.getClassLoader(), net.bytebuddy.dynamic.loading.ClassLoadingStrategy.Default.WRAPPER.with(java.lang.reflect.AccessibleObject.class.getProtectionDomain())).getLoaded().getDeclaredField("override");
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
                    throw r0;
                 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x006c */
                /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0147 */
                @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable run() {
                    /*
                        r18 = this;
                        java.lang.Class<byte[]> r1 = byte[].class
                        java.lang.String r2 = "override"
                        java.lang.Class<java.lang.String> r3 = java.lang.String.class
                        java.lang.String r4 = "defineClass"
                        java.lang.String r5 = "theUnsafe"
                        net.bytebuddy.utility.GraalImageCode r0 = net.bytebuddy.utility.GraalImageCode.getCurrent()
                        boolean r0 = r0.isDefined()
                        java.lang.String r0 = java.lang.Boolean.toString(r0)
                        java.lang.String r6 = "net.bytebuddy.safe"
                        java.lang.String r0 = java.lang.System.getProperty(r6, r0)
                        boolean r0 = java.lang.Boolean.parseBoolean(r0)
                        if (r0 == 0) goto L_0x002a
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Unavailable r0 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Unavailable
                        java.lang.String r1 = "Use of Unsafe was disabled by system property"
                        r0.<init>(r1)
                        return r0
                    L_0x002a:
                        java.lang.String r0 = "sun.misc.Unsafe"
                        java.lang.Class r6 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0148 }
                        java.lang.reflect.Field r0 = r6.getDeclaredField(r5)     // Catch:{ Exception -> 0x0148 }
                        r7 = 1
                        r0.setAccessible(r7)     // Catch:{ Exception -> 0x0148 }
                        r8 = 0
                        java.lang.Object r9 = r0.get(r8)     // Catch:{ Exception -> 0x0148 }
                        r10 = 5
                        r11 = 4
                        r12 = 6
                        r13 = 3
                        r14 = 2
                        r15 = 0
                        java.lang.Class[] r0 = new java.lang.Class[r12]     // Catch:{ Exception -> 0x0064 }
                        r0[r15] = r3     // Catch:{ Exception -> 0x0064 }
                        r0[r7] = r1     // Catch:{ Exception -> 0x0064 }
                        java.lang.Class r16 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0064 }
                        r0[r14] = r16     // Catch:{ Exception -> 0x0064 }
                        r0[r13] = r16     // Catch:{ Exception -> 0x0064 }
                        java.lang.Class<java.lang.ClassLoader> r16 = java.lang.ClassLoader.class
                        r0[r11] = r16     // Catch:{ Exception -> 0x0064 }
                        java.lang.Class<java.security.ProtectionDomain> r16 = java.security.ProtectionDomain.class
                        r0[r10] = r16     // Catch:{ Exception -> 0x0064 }
                        java.lang.reflect.Method r0 = r6.getMethod(r4, r0)     // Catch:{ Exception -> 0x0064 }
                        r0.setAccessible(r7)     // Catch:{ Exception -> 0x0064 }
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Enabled r8 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Enabled     // Catch:{ Exception -> 0x0064 }
                        r8.<init>(r9, r0)     // Catch:{ Exception -> 0x0064 }
                        return r8
                    L_0x0064:
                        r0 = move-exception
                        java.lang.Class<java.lang.reflect.AccessibleObject> r8 = java.lang.reflect.AccessibleObject.class
                        java.lang.reflect.Field r2 = r8.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x006c }
                        goto L_0x00c9
                    L_0x006c:
                        net.bytebuddy.ByteBuddy r8 = new net.bytebuddy.ByteBuddy     // Catch:{ Exception -> 0x0147 }
                        r8.<init>()     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class<java.lang.reflect.AccessibleObject> r10 = java.lang.reflect.AccessibleObject.class
                        net.bytebuddy.dynamic.DynamicType$Builder r8 = r8.redefine(r10)     // Catch:{ Exception -> 0x0147 }
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0147 }
                        r10.<init>()     // Catch:{ Exception -> 0x0147 }
                        java.lang.String r11 = "net.bytebuddy.mirror."
                        r10.append(r11)     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class<java.lang.reflect.AccessibleObject> r11 = java.lang.reflect.AccessibleObject.class
                        java.lang.String r11 = r11.getSimpleName()     // Catch:{ Exception -> 0x0147 }
                        r10.append(r11)     // Catch:{ Exception -> 0x0147 }
                        java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.dynamic.DynamicType$Builder r8 = r8.name(r10)     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.dynamic.DynamicType$Builder r8 = r8.noNestMate()     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.asm.MemberRemoval r10 = new net.bytebuddy.asm.MemberRemoval     // Catch:{ Exception -> 0x0147 }
                        r10.<init>()     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.matcher.ElementMatcher$Junction r11 = net.bytebuddy.matcher.ElementMatchers.any()     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.asm.MemberRemoval r10 = r10.stripInvokables(r11)     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.dynamic.DynamicType$Builder r8 = r8.visit(r10)     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.dynamic.DynamicType$Unloaded r8 = r8.make()     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class<java.lang.reflect.AccessibleObject> r10 = java.lang.reflect.AccessibleObject.class
                        java.lang.ClassLoader r10 = r10.getClassLoader()     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Default r11 = net.bytebuddy.dynamic.loading.ClassLoadingStrategy.Default.WRAPPER     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class<java.lang.reflect.AccessibleObject> r17 = java.lang.reflect.AccessibleObject.class
                        java.security.ProtectionDomain r12 = r17.getProtectionDomain()     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Configurable r11 = r11.with((java.security.ProtectionDomain) r12)     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.dynamic.DynamicType$Loaded r8 = r8.load(r10, r11)     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class r8 = r8.getLoaded()     // Catch:{ Exception -> 0x0147 }
                        java.lang.reflect.Field r2 = r8.getDeclaredField(r2)     // Catch:{ Exception -> 0x0147 }
                    L_0x00c9:
                        java.lang.String r8 = "objectFieldOffset"
                        java.lang.Class[] r10 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class<java.lang.reflect.Field> r11 = java.lang.reflect.Field.class
                        r10[r15] = r11     // Catch:{ Exception -> 0x0147 }
                        java.lang.reflect.Method r8 = r6.getMethod(r8, r10)     // Catch:{ Exception -> 0x0147 }
                        java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0147 }
                        r10[r15] = r2     // Catch:{ Exception -> 0x0147 }
                        java.lang.Object r2 = r8.invoke(r9, r10)     // Catch:{ Exception -> 0x0147 }
                        java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ Exception -> 0x0147 }
                        long r10 = r2.longValue()     // Catch:{ Exception -> 0x0147 }
                        java.lang.String r2 = "putBoolean"
                        java.lang.Class[] r8 = new java.lang.Class[r13]     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
                        r8[r15] = r12     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x0147 }
                        r8[r7] = r12     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class r12 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x0147 }
                        r8[r14] = r12     // Catch:{ Exception -> 0x0147 }
                        java.lang.reflect.Method r2 = r6.getMethod(r2, r8)     // Catch:{ Exception -> 0x0147 }
                        java.lang.String r6 = "jdk.internal.misc.Unsafe"
                        java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x0147 }
                        java.lang.reflect.Field r5 = r6.getDeclaredField(r5)     // Catch:{ Exception -> 0x0147 }
                        java.lang.Object[] r8 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0147 }
                        r8[r15] = r5     // Catch:{ Exception -> 0x0147 }
                        java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x0147 }
                        r8[r7] = r12     // Catch:{ Exception -> 0x0147 }
                        java.lang.Boolean r12 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0147 }
                        r8[r14] = r12     // Catch:{ Exception -> 0x0147 }
                        r2.invoke(r9, r8)     // Catch:{ Exception -> 0x0147 }
                        r8 = 6
                        java.lang.Class[] r8 = new java.lang.Class[r8]     // Catch:{ Exception -> 0x0147 }
                        r8[r15] = r3     // Catch:{ Exception -> 0x0147 }
                        r8[r7] = r1     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0147 }
                        r8[r14] = r1     // Catch:{ Exception -> 0x0147 }
                        r8[r13] = r1     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class<java.lang.ClassLoader> r1 = java.lang.ClassLoader.class
                        r3 = 4
                        r8[r3] = r1     // Catch:{ Exception -> 0x0147 }
                        java.lang.Class<java.security.ProtectionDomain> r1 = java.security.ProtectionDomain.class
                        r3 = 5
                        r8[r3] = r1     // Catch:{ Exception -> 0x0147 }
                        java.lang.reflect.Method r1 = r6.getMethod(r4, r8)     // Catch:{ Exception -> 0x0147 }
                        java.lang.Object[] r3 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0147 }
                        r3[r15] = r1     // Catch:{ Exception -> 0x0147 }
                        java.lang.Long r4 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x0147 }
                        r3[r7] = r4     // Catch:{ Exception -> 0x0147 }
                        r3[r14] = r12     // Catch:{ Exception -> 0x0147 }
                        r2.invoke(r9, r3)     // Catch:{ Exception -> 0x0147 }
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Enabled r2 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Enabled     // Catch:{ Exception -> 0x0147 }
                        r3 = 0
                        java.lang.Object r3 = r5.get(r3)     // Catch:{ Exception -> 0x0147 }
                        r2.<init>(r3, r1)     // Catch:{ Exception -> 0x0147 }
                        return r2
                    L_0x0147:
                        throw r0     // Catch:{ Exception -> 0x0148 }
                    L_0x0148:
                        r0 = move-exception
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Unavailable r1 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Unavailable
                        java.lang.String r0 = r0.getMessage()
                        r1.<init>(r0)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.CreationAction.run():net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable");
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements Dispatcher, Initializable {
                private final Method defineClass;
                private final Object unsafe;

                protected Enabled(Object obj, Method method) {
                    this.unsafe = obj;
                    this.defineClass = method;
                }

                public Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(this.unsafe, new Object[]{str, bArr, 0, Integer.valueOf(bArr.length), classLoader, protectionDomain});
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
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Enabled enabled = (Enabled) obj;
                    return this.unsafe.equals(enabled.unsafe) && this.defineClass.equals(enabled.defineClass);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.unsafe.hashCode()) * 31) + this.defineClass.hashCode();
                }

                public Dispatcher initialize() {
                    Object securityManager = UsingUnsafe.SYSTEM.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            UsingUnsafe.CHECK_PERMISSION.invoke(securityManager, new Object[]{ClassInjector.SUPPRESS_ACCESS_CHECKS});
                        } catch (InvocationTargetException e10) {
                            return new Unavailable(e10.getTargetException().getMessage());
                        } catch (Exception e11) {
                            return new Unavailable(e11.getMessage());
                        }
                    }
                    return this;
                }

                public boolean isAvailable() {
                    return true;
                }
            }

            public interface Initializable {
                Dispatcher initialize();

                boolean isAvailable();
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unavailable implements Dispatcher, Initializable {
                private final String message;

                protected Unavailable(String str) {
                    this.message = str;
                }

                public Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("Could not access Unsafe class: " + this.message);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.message.hashCode();
                }

                public Dispatcher initialize() {
                    throw new UnsupportedOperationException("Could not access Unsafe class: " + this.message);
                }

                public boolean isAvailable() {
                    return false;
                }
            }

            Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Factory {
            private final Dispatcher.Initializable dispatcher;

            public interface AccessResolver {

                public enum Default implements AccessResolver {
                    INSTANCE;

                    public void apply(AccessibleObject accessibleObject) {
                        accessibleObject.setAccessible(true);
                    }
                }

                void apply(AccessibleObject accessibleObject);
            }

            public Factory() {
                this((AccessResolver) AccessResolver.Default.INSTANCE);
            }

            public static Factory resolve(Instrumentation instrumentation) {
                return resolve(instrumentation, false);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.dispatcher.equals(((Factory) obj).dispatcher);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.dispatcher.hashCode();
            }

            public boolean isAvailable() {
                return this.dispatcher.isAvailable();
            }

            public ClassInjector make(@MaybeNull ClassLoader classLoader) {
                return make(classLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
            }

            @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
            public Factory(AccessResolver accessResolver) {
                Dispatcher.Initializable initializable;
                if (UsingUnsafe.DISPATCHER.isAvailable()) {
                    initializable = UsingUnsafe.DISPATCHER;
                } else {
                    try {
                        Class<?> cls = Class.forName("jdk.internal.misc.Unsafe");
                        Field declaredField = cls.getDeclaredField("theUnsafe");
                        accessResolver.apply(declaredField);
                        Object obj = declaredField.get((Object) null);
                        Class cls2 = Integer.TYPE;
                        Method method = cls.getMethod("defineClass", new Class[]{String.class, byte[].class, cls2, cls2, ClassLoader.class, ProtectionDomain.class});
                        accessResolver.apply(method);
                        initializable = new Dispatcher.Enabled(obj, method);
                    } catch (Exception e10) {
                        initializable = new Dispatcher.Unavailable(e10.getMessage());
                    }
                }
                this.dispatcher = initializable;
            }

            @SuppressFBWarnings(justification = "Exception intends to trigger disabled injection strategy. Modules are assumed if module system is supported.", value = {"REC_CATCH_EXCEPTION", "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public static Factory resolve(Instrumentation instrumentation, boolean z10) {
                Class<AccessResolver> cls = AccessResolver.class;
                if (UsingUnsafe.isAvailable() || !JavaModule.isSupported()) {
                    return new Factory();
                }
                try {
                    Class<?> cls2 = Class.forName("jdk.internal.misc.Unsafe");
                    PackageDescription.ForLoadedPackage forLoadedPackage = new PackageDescription.ForLoadedPackage(cls2.getPackage());
                    JavaModule ofType = JavaModule.ofType(cls2);
                    if (ofType.isOpened(forLoadedPackage, JavaModule.ofType(UsingUnsafe.class))) {
                        return new Factory();
                    }
                    if (z10) {
                        JavaModule ofType2 = JavaModule.ofType(AccessResolver.Default.class);
                        UsingInstrumentation.redefineModule(instrumentation, ofType, Collections.singleton(ofType2), Collections.emptyMap(), Collections.singletonMap(forLoadedPackage.getName(), Collections.singleton(ofType2)), Collections.emptySet(), Collections.emptyMap());
                        return new Factory();
                    }
                    Class<? extends T> loaded = new ByteBuddy().subclass(cls).method(ElementMatchers.named("apply")).intercept(MethodCall.invoke(AccessibleObject.class.getMethod("setAccessible", new Class[]{Boolean.TYPE})).onArgument(0).with(Boolean.TRUE)).make().load(cls.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER.with(cls.getProtectionDomain())).getLoaded();
                    JavaModule ofType3 = JavaModule.ofType(loaded);
                    UsingInstrumentation.redefineModule(instrumentation, ofType, Collections.singleton(ofType3), Collections.emptyMap(), Collections.singletonMap(forLoadedPackage.getName(), Collections.singleton(ofType3)), Collections.emptySet(), Collections.emptyMap());
                    return new Factory((AccessResolver) loaded.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception e10) {
                    return new Factory((Dispatcher.Initializable) new Dispatcher.Unavailable(e10.getMessage()));
                }
            }

            public ClassInjector make(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
                return new UsingUnsafe(classLoader, protectionDomain, this.dispatcher);
            }

            protected Factory(Dispatcher.Initializable initializable) {
                this.dispatcher = initializable;
            }
        }

        @JavaDispatcher.Proxied("java.lang.System")
        protected interface System {
            @JavaDispatcher.IsStatic
            @JavaDispatcher.Defaults
            @MaybeNull
            @JavaDispatcher.Proxied("getSecurityManager")
            Object getSecurityManager();
        }

        static {
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = false;
            } catch (SecurityException unused2) {
                ACCESS_CONTROLLER = true;
            }
        }

        public UsingUnsafe(@MaybeNull ClassLoader classLoader2) {
            this(classLoader2, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofBootLoader() {
            return new UsingUnsafe(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        public static ClassInjector ofPlatformLoader() {
            return new UsingUnsafe(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassInjector ofSystemLoader() {
            return new UsingUnsafe(ClassLoader.getSystemClassLoader());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r2 != null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
            if (r2 != null) goto L_0x0038;
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
                java.lang.ClassLoader r2 = r4.classLoader
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe r5 = (net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe) r5
                java.lang.ClassLoader r3 = r5.classLoader
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
                java.security.ProtectionDomain r2 = r4.protectionDomain
                java.security.ProtectionDomain r3 = r5.protectionDomain
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
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable r2 = r4.dispatcher
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable r5 = r5.dispatcher
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L_0x0044
                return r1
            L_0x0044:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = getClass().hashCode() * 31;
            ClassLoader classLoader2 = this.classLoader;
            if (classLoader2 != null) {
                hashCode += classLoader2.hashCode();
            }
            int i10 = hashCode * 31;
            ProtectionDomain protectionDomain2 = this.protectionDomain;
            if (protectionDomain2 != null) {
                i10 += protectionDomain2.hashCode();
            }
            return (i10 * 31) + this.dispatcher.hashCode();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|10|11|12|21|18|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x001a, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Map<java.lang.String, java.lang.Class<?>> injectRaw(java.util.Map<? extends java.lang.String, byte[]> r9) {
            /*
                r8 = this;
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable r0 = r8.dispatcher
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher r0 = r0.initialize()
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
                java.lang.ClassLoader r2 = r8.classLoader
                if (r2 != 0) goto L_0x0011
                java.lang.Object r2 = BOOTSTRAP_LOADER_LOCK
            L_0x0011:
                monitor-enter(r2)
                java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0059 }
                java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0059 }
            L_0x001a:
                boolean r3 = r9.hasNext()     // Catch:{ all -> 0x0059 }
                if (r3 == 0) goto L_0x0057
                java.lang.Object r3 = r9.next()     // Catch:{ all -> 0x0059 }
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0059 }
                java.lang.Object r4 = r3.getKey()     // Catch:{ ClassNotFoundException -> 0x003b }
                java.lang.Object r5 = r3.getKey()     // Catch:{ ClassNotFoundException -> 0x003b }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ ClassNotFoundException -> 0x003b }
                r6 = 0
                java.lang.ClassLoader r7 = r8.classLoader     // Catch:{ ClassNotFoundException -> 0x003b }
                java.lang.Class r5 = java.lang.Class.forName(r5, r6, r7)     // Catch:{ ClassNotFoundException -> 0x003b }
                r1.put(r4, r5)     // Catch:{ ClassNotFoundException -> 0x003b }
                goto L_0x001a
            L_0x003b:
                java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x0059 }
                java.lang.ClassLoader r5 = r8.classLoader     // Catch:{ all -> 0x0059 }
                java.lang.Object r6 = r3.getKey()     // Catch:{ all -> 0x0059 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0059 }
                java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0059 }
                byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0059 }
                java.security.ProtectionDomain r7 = r8.protectionDomain     // Catch:{ all -> 0x0059 }
                java.lang.Class r3 = r0.defineClass(r5, r6, r3, r7)     // Catch:{ all -> 0x0059 }
                r1.put(r4, r3)     // Catch:{ all -> 0x0059 }
                goto L_0x001a
            L_0x0057:
                monitor-exit(r2)     // Catch:{ all -> 0x0059 }
                return r1
            L_0x0059:
                r9 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0059 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.injectRaw(java.util.Map):java.util.Map");
        }

        public boolean isAlive() {
            return this.dispatcher.isAvailable();
        }

        public UsingUnsafe(@MaybeNull ClassLoader classLoader2, @MaybeNull ProtectionDomain protectionDomain2) {
            this(classLoader2, protectionDomain2, DISPATCHER);
        }

        protected UsingUnsafe(@MaybeNull ClassLoader classLoader2, @MaybeNull ProtectionDomain protectionDomain2, Dispatcher.Initializable initializable) {
            this.classLoader = classLoader2;
            this.protectionDomain = protectionDomain2;
            this.dispatcher = initializable;
        }
    }

    Map<TypeDescription, Class<?>> inject(Map<? extends TypeDescription, byte[]> map);

    Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map);

    boolean isAlive();
}
