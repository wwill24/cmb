package net.bytebuddy.agent;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.security.Permission;
import net.bytebuddy.agent.utility.nullability.MaybeNull;

public class Installer {
    @MaybeNull
    private static volatile Instrumentation instrumentation;

    private Installer() {
        throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
    }

    public static void agentmain(String str, Instrumentation instrumentation2) {
        instrumentation = instrumentation2;
    }

    public static Instrumentation getInstrumentation() {
        try {
            Object invoke = System.class.getMethod("getSecurityManager", new Class[0]).invoke((Object) null, new Object[0]);
            if (invoke != null) {
                Class.forName("java.lang.SecurityManager").getMethod("checkPermission", new Class[]{Permission.class}).invoke(invoke, new Object[]{new RuntimePermission("net.bytebuddy.agent.getInstrumentation")});
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            throw new IllegalStateException("Failed to assert access rights using security manager", targetException);
        } catch (IllegalAccessException e11) {
            throw new IllegalStateException("Failed to access security manager", e11);
        }
        Instrumentation instrumentation2 = instrumentation;
        if (instrumentation2 != null) {
            return instrumentation2;
        }
        throw new IllegalStateException("The Byte Buddy agent is not loaded or this method is not called via the system class loader");
    }

    public static void premain(String str, Instrumentation instrumentation2) {
        instrumentation = instrumentation2;
    }
}
