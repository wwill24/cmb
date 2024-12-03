package net.bytebuddy.utility;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.AnnotatedElement;
import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public class JavaModule implements NamedElement.WithOptionalName, AnnotationSource {
    private static final boolean ACCESS_CONTROLLER;
    protected static final Module MODULE = ((Module) doPrivileged(JavaDispatcher.of(Module.class)));
    protected static final Resolver RESOLVER = ((Resolver) doPrivileged(JavaDispatcher.of(Resolver.class)));
    @AlwaysNull
    public static final JavaModule UNSUPPORTED = null;
    private final AnnotatedElement module;

    @JavaDispatcher.Proxied("java.lang.Module")
    protected interface Module {
        @JavaDispatcher.Proxied("canRead")
        boolean canRead(Object obj, @JavaDispatcher.Proxied("java.lang.Module") Object obj2);

        @JavaDispatcher.Proxied("getClassLoader")
        @MaybeNull
        ClassLoader getClassLoader(Object obj);

        @JavaDispatcher.Proxied("getName")
        String getName(Object obj);

        @JavaDispatcher.Proxied("getResourceAsStream")
        @MaybeNull
        InputStream getResourceAsStream(Object obj, String str) throws IOException;

        @JavaDispatcher.Proxied("isExported")
        boolean isExported(Object obj, String str, @JavaDispatcher.Proxied("java.lang.Module") Object obj2);

        @JavaDispatcher.Proxied("isInstance")
        @JavaDispatcher.Instance
        boolean isInstance(Object obj);

        @JavaDispatcher.Proxied("isNamed")
        boolean isNamed(Object obj);

        @JavaDispatcher.Proxied("isOpen")
        boolean isOpen(Object obj, String str, @JavaDispatcher.Proxied("java.lang.Module") Object obj2);
    }

    @JavaDispatcher.Proxied("java.lang.Class")
    protected interface Resolver {
        @JavaDispatcher.Defaults
        @MaybeNull
        @JavaDispatcher.Proxied("getModule")
        Object getModule(Class<?> cls);
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

    protected JavaModule(AnnotatedElement annotatedElement) {
        this.module = annotatedElement;
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static boolean isSupported() {
        return ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V9);
    }

    public static JavaModule of(Object obj) {
        if (MODULE.isInstance(obj)) {
            return new JavaModule((AnnotatedElement) obj);
        }
        throw new IllegalArgumentException("Not a Java module: " + obj);
    }

    @MaybeNull
    public static JavaModule ofType(Class<?> cls) {
        Object module2 = RESOLVER.getModule(cls);
        if (module2 == null) {
            return UNSUPPORTED;
        }
        return new JavaModule((AnnotatedElement) module2);
    }

    public boolean canRead(JavaModule javaModule) {
        return MODULE.canRead(this.module, javaModule.unwrap());
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaModule)) {
            return false;
        }
        return this.module.equals(((JavaModule) obj).module);
    }

    public String getActualName() {
        return MODULE.getName(this.module);
    }

    @MaybeNull
    public ClassLoader getClassLoader() {
        return MODULE.getClassLoader(this.module);
    }

    public AnnotationList getDeclaredAnnotations() {
        return new AnnotationList.ForLoadedAnnotations(this.module.getDeclaredAnnotations());
    }

    @MaybeNull
    public InputStream getResourceAsStream(String str) throws IOException {
        return MODULE.getResourceAsStream(this.module, str);
    }

    public int hashCode() {
        return this.module.hashCode();
    }

    public boolean isExported(@MaybeNull PackageDescription packageDescription, JavaModule javaModule) {
        if (packageDescription == null || packageDescription.isDefault() || MODULE.isExported(this.module, packageDescription.getName(), javaModule.unwrap())) {
            return true;
        }
        return false;
    }

    public boolean isNamed() {
        return MODULE.isNamed(this.module);
    }

    public boolean isOpened(@MaybeNull PackageDescription packageDescription, JavaModule javaModule) {
        if (packageDescription == null || packageDescription.isDefault() || MODULE.isOpen(this.module, packageDescription.getName(), javaModule.unwrap())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.module.toString();
    }

    public Object unwrap() {
        return this.module;
    }
}
