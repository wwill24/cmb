package net.bytebuddy.dynamic;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.StreamDrainer;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface ClassFileLocator extends Closeable {
    public static final String CLASS_FILE_EXTENSION = ".class";

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements ClassFileLocator, Closeable {
        private final List<ClassFileLocator> classFileLocators;

        public Compound(ClassFileLocator... classFileLocatorArr) {
            this((List<? extends ClassFileLocator>) Arrays.asList(classFileLocatorArr));
        }

        public void close() throws IOException {
            for (ClassFileLocator close : this.classFileLocators) {
                close.close();
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileLocators.equals(((Compound) obj).classFileLocators);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classFileLocators.hashCode();
        }

        public Resolution locate(String str) throws IOException {
            for (ClassFileLocator locate : this.classFileLocators) {
                Resolution locate2 = locate.locate(str);
                if (locate2.isResolved()) {
                    return locate2;
                }
            }
            return new Resolution.Illegal(str);
        }

        public Compound(List<? extends ClassFileLocator> list) {
            this.classFileLocators = new ArrayList();
            for (ClassFileLocator classFileLocator : list) {
                if (classFileLocator instanceof Compound) {
                    this.classFileLocators.addAll(((Compound) classFileLocator).classFileLocators);
                } else if (!(classFileLocator instanceof NoOp)) {
                    this.classFileLocators.add(classFileLocator);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Filtering implements ClassFileLocator {
        private final ClassFileLocator delegate;
        private final ElementMatcher<? super String> matcher;

        public Filtering(ElementMatcher<? super String> elementMatcher, ClassFileLocator classFileLocator) {
            this.matcher = elementMatcher;
            this.delegate = classFileLocator;
        }

        public void close() throws IOException {
            this.delegate.close();
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

        public Resolution locate(String str) throws IOException {
            return this.matcher.matches(str) ? this.delegate.locate(str) : new Resolution.Illegal(str);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForClassLoader implements ClassFileLocator {
        private static final boolean ACCESS_CONTROLLER;
        private static final ClassLoader BOOT_LOADER_PROXY = ((ClassLoader) doPrivileged(BootLoaderProxyCreationAction.INSTANCE));
        private final ClassLoader classLoader;

        protected enum BootLoaderProxyCreationAction implements PrivilegedAction<ClassLoader> {
            INSTANCE;

            public ClassLoader run() {
                return new URLClassLoader(new URL[0], ClassLoadingStrategy.BOOTSTRAP_LOADER);
            }
        }

        public static class WeaklyReferenced extends WeakReference<ClassLoader> implements ClassFileLocator {
            private final int hashCode;

            protected WeaklyReferenced(ClassLoader classLoader) {
                super(classLoader);
                this.hashCode = System.identityHashCode(classLoader);
            }

            public static ClassFileLocator of(@MaybeNull ClassLoader classLoader) {
                if (classLoader == null || classLoader == ClassLoader.getSystemClassLoader() || classLoader == ClassLoader.getSystemClassLoader().getParent()) {
                    return ForClassLoader.of(classLoader);
                }
                return new WeaklyReferenced(classLoader);
            }

            public void close() {
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ClassLoader classLoader = (ClassLoader) ((WeaklyReferenced) obj).get();
                if (classLoader == null || get() != classLoader) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return this.hashCode;
            }

            public Resolution locate(String str) throws IOException {
                ClassLoader classLoader = (ClassLoader) get();
                if (classLoader == null) {
                    return new Resolution.Illegal(str);
                }
                return ForClassLoader.locate(classLoader, str);
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

        protected ForClassLoader(ClassLoader classLoader2) {
            this.classLoader = classLoader2;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static ClassFileLocator of(@MaybeNull ClassLoader classLoader2) {
            if (classLoader2 == null) {
                classLoader2 = BOOT_LOADER_PROXY;
            }
            return new ForClassLoader(classLoader2);
        }

        public static ClassFileLocator ofBootLoader() {
            return new ForClassLoader(BOOT_LOADER_PROXY);
        }

        public static ClassFileLocator ofPlatformLoader() {
            return of(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassFileLocator ofSystemLoader() {
            return new ForClassLoader(ClassLoader.getSystemClassLoader());
        }

        public static byte[] read(Class<?> cls) {
            try {
                ClassLoader classLoader2 = cls.getClassLoader();
                if (classLoader2 == null) {
                    classLoader2 = BOOT_LOADER_PROXY;
                }
                return locate(classLoader2, TypeDescription.ForLoadedType.getName(cls)).resolve();
            } catch (IOException e10) {
                throw new IllegalStateException("Cannot read class file for " + cls, e10);
            }
        }

        public static Map<String, byte[]> readToNames(Class<?>... clsArr) {
            return readToNames((Collection<? extends Class<?>>) Arrays.asList(clsArr));
        }

        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((ForClassLoader) obj).classLoader);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classLoader.hashCode();
        }

        public Resolution locate(String str) throws IOException {
            return locate(this.classLoader, str);
        }

        protected static Resolution locate(ClassLoader classLoader2, String str) throws IOException {
            InputStream resourceAsStream = classLoader2.getResourceAsStream(str.replace('.', '/') + ".class");
            if (resourceAsStream == null) {
                return new Resolution.Illegal(str);
            }
            try {
                return new Resolution.Explicit(StreamDrainer.DEFAULT.drain(resourceAsStream));
            } finally {
                resourceAsStream.close();
            }
        }

        public static Map<String, byte[]> readToNames(Collection<? extends Class<?>> collection) {
            HashMap hashMap = new HashMap();
            for (Class cls : collection) {
                hashMap.put(cls.getName(), read((Class<?>) cls));
            }
            return hashMap;
        }

        public static Map<Class<?>, byte[]> read(Class<?>... clsArr) {
            return read((Collection<? extends Class<?>>) Arrays.asList(clsArr));
        }

        public static Map<Class<?>, byte[]> read(Collection<? extends Class<?>> collection) {
            HashMap hashMap = new HashMap();
            for (Class cls : collection) {
                hashMap.put(cls, read((Class<?>) cls));
            }
            return hashMap;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForFolder implements ClassFileLocator {
        private final File folder;

        public ForFolder(File file) {
            this.folder = file;
        }

        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.folder.equals(((ForFolder) obj).folder);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.folder.hashCode();
        }

        public Resolution locate(String str) throws IOException {
            File file = this.folder;
            File file2 = new File(file, str.replace('.', File.separatorChar) + ".class");
            if (!file2.exists()) {
                return new Resolution.Illegal(str);
            }
            FileInputStream fileInputStream = new FileInputStream(file2);
            try {
                return new Resolution.Explicit(StreamDrainer.DEFAULT.drain(fileInputStream));
            } finally {
                fileInputStream.close();
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForInstrumentation implements ClassFileLocator {
        private static final boolean ACCESS_CONTROLLER;
        private static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        private final ClassLoadingDelegate classLoadingDelegate;
        private final Instrumentation instrumentation;

        public interface ClassLoadingDelegate {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Default implements ClassLoadingDelegate {
                private static final ClassLoader BOOT_LOADER_PROXY = ((ClassLoader) ForInstrumentation.doPrivileged(BootLoaderProxyCreationAction.INSTANCE));
                protected final ClassLoader classLoader;

                protected enum BootLoaderProxyCreationAction implements PrivilegedAction<ClassLoader> {
                    INSTANCE;

                    public ClassLoader run() {
                        return new URLClassLoader(new URL[0], ClassLoadingStrategy.BOOTSTRAP_LOADER);
                    }
                }

                protected Default(ClassLoader classLoader2) {
                    this.classLoader = classLoader2;
                }

                public static ClassLoadingDelegate of(@MaybeNull ClassLoader classLoader2) {
                    if (ForDelegatingClassLoader.isDelegating(classLoader2)) {
                        return new ForDelegatingClassLoader(classLoader2);
                    }
                    if (classLoader2 == null) {
                        classLoader2 = BOOT_LOADER_PROXY;
                    }
                    return new Default(classLoader2);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((Default) obj).classLoader);
                }

                @MaybeNull
                public ClassLoader getClassLoader() {
                    ClassLoader classLoader2 = this.classLoader;
                    return classLoader2 == BOOT_LOADER_PROXY ? ClassLoadingStrategy.BOOTSTRAP_LOADER : classLoader2;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.classLoader.hashCode();
                }

                public Class<?> locate(String str) throws ClassNotFoundException {
                    return this.classLoader.loadClass(str);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Explicit implements ClassLoadingDelegate {
                private final ClassLoadingDelegate fallbackDelegate;
                private final Map<String, Class<?>> types;

                public Explicit(@MaybeNull ClassLoader classLoader, Collection<? extends Class<?>> collection) {
                    this(Default.of(classLoader), collection);
                }

                public static ClassLoadingDelegate of(Class<?> cls) {
                    return new Explicit(cls.getClassLoader(), (Collection<? extends Class<?>>) Collections.singleton(cls));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Explicit explicit = (Explicit) obj;
                    return this.fallbackDelegate.equals(explicit.fallbackDelegate) && this.types.equals(explicit.types);
                }

                @MaybeNull
                public ClassLoader getClassLoader() {
                    return this.fallbackDelegate.getClassLoader();
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.fallbackDelegate.hashCode()) * 31) + this.types.hashCode();
                }

                public Class<?> locate(String str) throws ClassNotFoundException {
                    Class<?> cls = this.types.get(str);
                    if (cls == null) {
                        return this.fallbackDelegate.locate(str);
                    }
                    return cls;
                }

                public Explicit(ClassLoadingDelegate classLoadingDelegate, Collection<? extends Class<?>> collection) {
                    this.fallbackDelegate = classLoadingDelegate;
                    this.types = new HashMap();
                    for (Class cls : collection) {
                        this.types.put(TypeDescription.ForLoadedType.getName(cls), cls);
                    }
                }
            }

            public static class ForDelegatingClassLoader extends Default {
                private static final boolean ACCESS_CONTROLLER;
                private static final String DELEGATING_CLASS_LOADER_NAME = "sun.reflect.DelegatingClassLoader";
                private static final Dispatcher.Initializable DISPATCHER = ((Dispatcher.Initializable) doPrivileged(Dispatcher.CreationAction.INSTANCE));
                private static final int ONLY = 0;

                protected interface Dispatcher {

                    public enum CreationAction implements PrivilegedAction<Initializable> {
                        INSTANCE;

                        public Initializable run() {
                            try {
                                return new Resolved(ClassLoader.class.getDeclaredField("classes"));
                            } catch (Exception e10) {
                                return new Unresolved(e10.getMessage());
                            }
                        }
                    }

                    public interface Initializable {
                        Dispatcher initialize();
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Resolved implements Dispatcher, Initializable, PrivilegedAction<Dispatcher> {
                        private static final boolean ACCESS_CONTROLLER;
                        private final Field field;

                        static {
                            boolean z10 = false;
                            try {
                                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
                                return;
                            } catch (ClassNotFoundException unused) {
                            } catch (SecurityException unused2) {
                                z10 = true;
                            }
                            ACCESS_CONTROLLER = z10;
                        }

                        public Resolved(Field field2) {
                            this.field = field2;
                        }

                        @AccessControllerPlugin.Enhance
                        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.field.equals(((Resolved) obj).field);
                        }

                        public Vector<Class<?>> extract(ClassLoader classLoader) {
                            try {
                                return (Vector) this.field.get(classLoader);
                            } catch (IllegalAccessException e10) {
                                throw new IllegalStateException("Cannot access field", e10);
                            }
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.field.hashCode();
                        }

                        public Dispatcher initialize() {
                            return (Dispatcher) doPrivileged(this);
                        }

                        public Dispatcher run() {
                            this.field.setAccessible(true);
                            return this;
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Unresolved implements Initializable {
                        private final String message;

                        public Unresolved(String str) {
                            this.message = str;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.message.equals(((Unresolved) obj).message);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.message.hashCode();
                        }

                        public Dispatcher initialize() {
                            throw new UnsupportedOperationException("Could not locate classes vector: " + this.message);
                        }
                    }

                    Vector<Class<?>> extract(ClassLoader classLoader);
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

                protected ForDelegatingClassLoader(ClassLoader classLoader) {
                    super(classLoader);
                }

                @AccessControllerPlugin.Enhance
                private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                    return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
                }

                protected static boolean isDelegating(@MaybeNull ClassLoader classLoader) {
                    return classLoader != null && classLoader.getClass().getName().equals(DELEGATING_CLASS_LOADER_NAME);
                }

                public Class<?> locate(String str) throws ClassNotFoundException {
                    try {
                        Vector<Class<?>> extract = DISPATCHER.initialize().extract(this.classLoader);
                        if (extract.size() != 1) {
                            return super.locate(str);
                        }
                        Class<?> cls = extract.get(0);
                        if (TypeDescription.ForLoadedType.getName(cls).equals(str)) {
                            return cls;
                        }
                        return super.locate(str);
                    } catch (RuntimeException unused) {
                        return super.locate(str);
                    }
                }
            }

            @MaybeNull
            ClassLoader getClassLoader();

            Class<?> locate(String str) throws ClassNotFoundException;
        }

        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        protected interface Dispatcher {
            @JavaDispatcher.Proxied("addTransformer")
            void addTransformer(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, boolean z10);

            @JavaDispatcher.Proxied("isRetransformClassesSupported")
            boolean isRetransformClassesSupported(Instrumentation instrumentation);

            @JavaDispatcher.Proxied("retransformClasses")
            void retransformClasses(Instrumentation instrumentation, Class<?>[] clsArr) throws UnmodifiableClassException;
        }

        protected static class ExtractionClassFileTransformer implements ClassFileTransformer {
            @AlwaysNull
            private static final byte[] DO_NOT_TRANSFORM = null;
            @SuppressFBWarnings(justification = "The array is not to be modified by contract", value = {"VO_VOLATILE_REFERENCE_TO_ARRAY"})
            @MaybeNull
            private volatile byte[] binaryRepresentation;
            @MaybeNull
            private final ClassLoader classLoader;
            private final String typeName;

            protected ExtractionClassFileTransformer(@MaybeNull ClassLoader classLoader2, String str) {
                this.classLoader = classLoader2;
                this.typeName = str;
            }

            /* access modifiers changed from: protected */
            @SuppressFBWarnings(justification = "The array is not to be modified by contract", value = {"EI_EXPOSE_REP"})
            @MaybeNull
            public byte[] getBinaryRepresentation() {
                return this.binaryRepresentation;
            }

            @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP", "EI_EXPOSE_REP2"})
            @MaybeNull
            public byte[] transform(@MaybeNull ClassLoader classLoader2, @MaybeNull String str, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
                if (str != null && ElementMatchers.isChildOf(this.classLoader).matches(classLoader2) && this.typeName.equals(str.replace('/', '.'))) {
                    this.binaryRepresentation = (byte[]) bArr.clone();
                }
                return DO_NOT_TRANSFORM;
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

        public ForInstrumentation(Instrumentation instrumentation2, @MaybeNull ClassLoader classLoader) {
            this(instrumentation2, ClassLoadingDelegate.Default.of(classLoader));
        }

        /* access modifiers changed from: private */
        @AccessControllerPlugin.Enhance
        public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static ClassFileLocator fromInstalledAgent(@MaybeNull ClassLoader classLoader) {
            return new ForInstrumentation(resolveByteBuddyAgentInstrumentation(), classLoader);
        }

        public static ClassFileLocator of(Instrumentation instrumentation2, Class<?> cls) {
            return new ForInstrumentation(instrumentation2, ClassLoadingDelegate.Explicit.of(cls));
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

        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForInstrumentation forInstrumentation = (ForInstrumentation) obj;
            return this.instrumentation.equals(forInstrumentation.instrumentation) && this.classLoadingDelegate.equals(forInstrumentation.classLoadingDelegate);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + this.classLoadingDelegate.hashCode();
        }

        public Resolution locate(String str) {
            ExtractionClassFileTransformer extractionClassFileTransformer;
            Resolution resolution;
            try {
                extractionClassFileTransformer = new ExtractionClassFileTransformer(this.classLoadingDelegate.getClassLoader(), str);
                Dispatcher dispatcher = DISPATCHER;
                dispatcher.addTransformer(this.instrumentation, extractionClassFileTransformer, true);
                dispatcher.retransformClasses(this.instrumentation, new Class[]{this.classLoadingDelegate.locate(str)});
                byte[] binaryRepresentation = extractionClassFileTransformer.getBinaryRepresentation();
                if (binaryRepresentation == null) {
                    resolution = new Resolution.Illegal(str);
                } else {
                    resolution = new Resolution.Explicit(binaryRepresentation);
                }
                this.instrumentation.removeTransformer(extractionClassFileTransformer);
                return resolution;
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
                return new Resolution.Illegal(str);
            } catch (Throwable th2) {
                this.instrumentation.removeTransformer(extractionClassFileTransformer);
                throw th2;
            }
        }

        public ForInstrumentation(Instrumentation instrumentation2, ClassLoadingDelegate classLoadingDelegate2) {
            if (DISPATCHER.isRetransformClassesSupported(instrumentation2)) {
                this.instrumentation = instrumentation2;
                this.classLoadingDelegate = classLoadingDelegate2;
                return;
            }
            throw new IllegalArgumentException(instrumentation2 + " does not support retransformation");
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForJarFile implements ClassFileLocator {
        private static final List<String> RUNTIME_LOCATIONS = Arrays.asList(new String[]{"lib/rt.jar", "../lib/rt.jar", "../Classes/classes.jar"});
        private final JarFile jarFile;

        public ForJarFile(JarFile jarFile2) {
            this.jarFile = jarFile2;
        }

        public static ClassFileLocator of(File file) throws IOException {
            return new ForJarFile(new JarFile(file));
        }

        public static ClassFileLocator ofClassPath() throws IOException {
            return ofClassPath(System.getProperty("java.class.path"));
        }

        public static ClassFileLocator ofRuntimeJar() throws IOException {
            File file;
            String replace = System.getProperty("java.home").replace('\\', '/');
            Iterator<String> it = RUNTIME_LOCATIONS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    file = null;
                    break;
                }
                file = new File(replace, it.next());
                if (file.isFile()) {
                    break;
                }
            }
            if (file != null) {
                return of(file);
            }
            throw new IllegalStateException("Runtime jar does not exist in " + replace + " for any of " + RUNTIME_LOCATIONS);
        }

        public void close() throws IOException {
            this.jarFile.close();
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.jarFile.equals(((ForJarFile) obj).jarFile);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.jarFile.hashCode();
        }

        public Resolution locate(String str) throws IOException {
            JarFile jarFile2 = this.jarFile;
            ZipEntry entry = jarFile2.getEntry(str.replace('.', '/') + ".class");
            if (entry == null) {
                return new Resolution.Illegal(str);
            }
            InputStream inputStream = this.jarFile.getInputStream(entry);
            try {
                return new Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
            } finally {
                inputStream.close();
            }
        }

        public static ClassFileLocator ofClassPath(String str) throws IOException {
            ArrayList arrayList = new ArrayList();
            for (String file : Pattern.compile(System.getProperty("path.separator"), 16).split(str)) {
                File file2 = new File(file);
                if (file2.isDirectory()) {
                    arrayList.add(new ForFolder(file2));
                } else if (file2.isFile()) {
                    arrayList.add(of(file2));
                }
            }
            return new Compound((List<? extends ClassFileLocator>) arrayList);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForModule implements ClassFileLocator {
        private static final Object[] NO_ARGUMENT = new Object[0];
        private final JavaModule module;

        public static class WeaklyReferenced extends WeakReference<Object> implements ClassFileLocator {
            private final int hashCode;

            protected WeaklyReferenced(Object obj) {
                super(obj);
                this.hashCode = System.identityHashCode(obj);
            }

            public static ClassFileLocator of(JavaModule javaModule) {
                if (!javaModule.isNamed()) {
                    return ForClassLoader.WeaklyReferenced.of(javaModule.getClassLoader());
                }
                if (javaModule.getClassLoader() == null || javaModule.getClassLoader() == ClassLoader.getSystemClassLoader() || javaModule.getClassLoader() == ClassLoader.getSystemClassLoader().getParent()) {
                    return new ForModule(javaModule);
                }
                return new WeaklyReferenced(javaModule.unwrap());
            }

            public void close() {
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Object obj2 = ((WeaklyReferenced) obj).get();
                if (obj2 == null || get() != obj2) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return this.hashCode;
            }

            public Resolution locate(String str) throws IOException {
                Object obj = get();
                if (obj == null) {
                    return new Resolution.Illegal(str);
                }
                return ForModule.locate(JavaModule.of(obj), str);
            }
        }

        protected ForModule(JavaModule javaModule) {
            this.module = javaModule;
        }

        public static ClassFileLocator of(JavaModule javaModule) {
            if (javaModule.isNamed()) {
                return new ForModule(javaModule);
            }
            return ForClassLoader.of(javaModule.getClassLoader());
        }

        @SuppressFBWarnings(justification = "Exception should always be wrapped for clarity", value = {"REC_CATCH_EXCEPTION"})
        public static ClassFileLocator ofBootLayer() {
            try {
                HashMap hashMap = new HashMap();
                Class<?> cls = Class.forName("java.lang.ModuleLayer");
                Method method = JavaType.MODULE.load().getMethod("getPackages", new Class[0]);
                for (Object next : (Set) cls.getMethod("modules", new Class[0]).invoke(cls.getMethod("boot", new Class[0]).invoke((Object) null, new Object[0]), new Object[0])) {
                    ClassFileLocator of2 = of(JavaModule.of(next));
                    for (String put : (Set) method.invoke(next, NO_ARGUMENT)) {
                        hashMap.put(put, of2);
                    }
                }
                return new PackageDiscriminating(hashMap);
            } catch (Exception e10) {
                throw new IllegalStateException("Cannot process boot layer", e10);
            }
        }

        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.module.equals(((ForModule) obj).module);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.module.hashCode();
        }

        public Resolution locate(String str) throws IOException {
            return locate(this.module, str);
        }

        protected static Resolution locate(JavaModule javaModule, String str) throws IOException {
            InputStream resourceAsStream = javaModule.getResourceAsStream(str.replace('.', '/') + ".class");
            if (resourceAsStream == null) {
                return new Resolution.Illegal(str);
            }
            try {
                return new Resolution.Explicit(StreamDrainer.DEFAULT.drain(resourceAsStream));
            } finally {
                resourceAsStream.close();
            }
        }
    }

    public enum NoOp implements ClassFileLocator {
        INSTANCE;

        public void close() {
        }

        public Resolution locate(String str) {
            return new Resolution.Illegal(str);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class PackageDiscriminating implements ClassFileLocator {
        private final Map<String, ClassFileLocator> classFileLocators;

        public PackageDiscriminating(Map<String, ClassFileLocator> map) {
            this.classFileLocators = map;
        }

        public void close() throws IOException {
            for (ClassFileLocator close : this.classFileLocators.values()) {
                close.close();
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileLocators.equals(((PackageDiscriminating) obj).classFileLocators);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classFileLocators.hashCode();
        }

        public Resolution locate(String str) throws IOException {
            String str2;
            int lastIndexOf = str.lastIndexOf(46);
            Map<String, ClassFileLocator> map = this.classFileLocators;
            if (lastIndexOf == -1) {
                str2 = "";
            } else {
                str2 = str.substring(0, lastIndexOf);
            }
            ClassFileLocator classFileLocator = map.get(str2);
            if (classFileLocator == null) {
                return new Resolution.Illegal(str);
            }
            return classFileLocator.locate(str);
        }
    }

    public interface Resolution {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Explicit implements Resolution {
            private final byte[] binaryRepresentation;

            @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP2"})
            public Explicit(byte[] bArr) {
                this.binaryRepresentation = bArr;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && Arrays.equals(this.binaryRepresentation, ((Explicit) obj).binaryRepresentation);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + Arrays.hashCode(this.binaryRepresentation);
            }

            public boolean isResolved() {
                return true;
            }

            @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP"})
            public byte[] resolve() {
                return this.binaryRepresentation;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Illegal implements Resolution {
            private final String typeName;

            public Illegal(String str) {
                this.typeName = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeName.equals(((Illegal) obj).typeName);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.typeName.hashCode();
            }

            public boolean isResolved() {
                return false;
            }

            public byte[] resolve() {
                throw new IllegalStateException("Could not locate class file for " + this.typeName);
            }
        }

        boolean isResolved();

        byte[] resolve();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements ClassFileLocator {
        private final Map<String, byte[]> classFiles;

        public Simple(Map<String, byte[]> map) {
            this.classFiles = map;
        }

        public static ClassFileLocator of(String str, byte[] bArr) {
            return new Simple(Collections.singletonMap(str, bArr));
        }

        public static ClassFileLocator ofResources(Map<String, byte[]> map) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).endsWith(".class")) {
                    hashMap.put(((String) next.getKey()).substring(0, ((String) next.getKey()).length() - 6).replace('/', '.'), next.getValue());
                }
            }
            return new Simple(hashMap);
        }

        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFiles.equals(((Simple) obj).classFiles);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classFiles.hashCode();
        }

        public Resolution locate(String str) {
            byte[] bArr = this.classFiles.get(str);
            if (bArr == null) {
                return new Resolution.Illegal(str);
            }
            return new Resolution.Explicit(bArr);
        }

        public static ClassFileLocator of(DynamicType dynamicType) {
            return of(dynamicType.getAllTypes());
        }

        public static ClassFileLocator of(Map<TypeDescription, byte[]> map) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                hashMap.put(((TypeDescription) next.getKey()).getName(), next.getValue());
            }
            return new Simple(hashMap);
        }
    }

    Resolution locate(String str) throws IOException;

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForUrl implements ClassFileLocator {
        private static final boolean ACCESS_CONTROLLER;
        private final ClassLoader classLoader;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ClassLoaderCreationAction implements PrivilegedAction<ClassLoader> {
            private final URL[] url;

            protected ClassLoaderCreationAction(URL[] urlArr) {
                this.url = urlArr;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && Arrays.equals(this.url, ((ClassLoaderCreationAction) obj).url);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + Arrays.hashCode(this.url);
            }

            public ClassLoader run() {
                return new URLClassLoader(this.url, ClassLoadingStrategy.BOOTSTRAP_LOADER);
            }
        }

        static {
            boolean z10 = false;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
                return;
            } catch (ClassNotFoundException unused) {
            } catch (SecurityException unused2) {
                z10 = true;
            }
            ACCESS_CONTROLLER = z10;
        }

        public ForUrl(URL... urlArr) {
            this.classLoader = (ClassLoader) doPrivileged(new ClassLoaderCreationAction(urlArr));
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public void close() throws IOException {
            ClassLoader classLoader2 = this.classLoader;
            if (classLoader2 instanceof Closeable) {
                ((Closeable) classLoader2).close();
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((ForUrl) obj).classLoader);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classLoader.hashCode();
        }

        public Resolution locate(String str) throws IOException {
            return ForClassLoader.locate(this.classLoader, str);
        }

        public ForUrl(Collection<? extends URL> collection) {
            this((URL[]) collection.toArray(new URL[0]));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForModuleFile implements ClassFileLocator {
        private static final List<String> BOOT_LOCATIONS = Arrays.asList(new String[]{"jmods", "../jmods", "modules"});
        private static final String JMOD_FILE_EXTENSION = ".jmod";
        private final ZipFile zipFile;

        public ForModuleFile(ZipFile zipFile2) {
            this.zipFile = zipFile2;
        }

        public static ClassFileLocator of(File file) throws IOException {
            return new ForModuleFile(new ZipFile(file));
        }

        public static ClassFileLocator ofBootPath() throws IOException {
            File file;
            String replace = System.getProperty("java.home").replace('\\', '/');
            Iterator<String> it = BOOT_LOCATIONS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    file = null;
                    break;
                }
                file = new File(replace, it.next());
                if (file.isDirectory()) {
                    break;
                }
            }
            if (file != null) {
                return ofBootPath(file);
            }
            throw new IllegalStateException("Boot modules do not exist in " + replace + " for any of " + BOOT_LOCATIONS);
        }

        public static ClassFileLocator ofModulePath() throws IOException {
            String property = System.getProperty("jdk.module.path");
            if (property == null) {
                return NoOp.INSTANCE;
            }
            return ofModulePath(property);
        }

        public void close() throws IOException {
            this.zipFile.close();
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.zipFile.equals(((ForModuleFile) obj).zipFile);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.zipFile.hashCode();
        }

        public Resolution locate(String str) throws IOException {
            ZipFile zipFile2 = this.zipFile;
            ZipEntry entry = zipFile2.getEntry("classes/" + str.replace('.', '/') + ".class");
            if (entry == null) {
                return new Resolution.Illegal(str);
            }
            InputStream inputStream = this.zipFile.getInputStream(entry);
            try {
                return new Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
            } finally {
                inputStream.close();
            }
        }

        public static ClassFileLocator ofModulePath(String str) throws IOException {
            return ofModulePath(str, System.getProperty("user.dir"));
        }

        public static ClassFileLocator ofModulePath(String str, String str2) throws IOException {
            ClassFileLocator classFileLocator;
            ClassFileLocator classFileLocator2;
            ArrayList arrayList = new ArrayList();
            for (String file : Pattern.compile(System.getProperty("path.separator"), 16).split(str)) {
                File file2 = new File(str2, file);
                if (file2.isDirectory()) {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            if (file3.isDirectory()) {
                                arrayList.add(new ForFolder(file3));
                            } else if (file3.isFile()) {
                                if (file3.getName().endsWith(JMOD_FILE_EXTENSION)) {
                                    classFileLocator2 = of(file3);
                                } else {
                                    classFileLocator2 = ForJarFile.of(file3);
                                }
                                arrayList.add(classFileLocator2);
                            }
                        }
                    }
                } else if (file2.isFile()) {
                    if (file2.getName().endsWith(JMOD_FILE_EXTENSION)) {
                        classFileLocator = of(file2);
                    } else {
                        classFileLocator = ForJarFile.of(file2);
                    }
                    arrayList.add(classFileLocator);
                }
            }
            return new Compound((List<? extends ClassFileLocator>) arrayList);
        }

        public static ClassFileLocator ofBootPath(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return NoOp.INSTANCE;
            }
            ArrayList arrayList = new ArrayList(listFiles.length);
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(of(file2));
                } else if (file2.isDirectory()) {
                    arrayList.add(new ForFolder(file2));
                }
            }
            return new Compound((List<? extends ClassFileLocator>) arrayList);
        }
    }
}
