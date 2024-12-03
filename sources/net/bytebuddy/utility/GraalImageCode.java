package net.bytebuddy.utility;

import com.facebook.internal.ServerProtocol;
import com.mparticle.identity.IdentityHttpResponse;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public enum GraalImageCode {
    ;
    
    private static final boolean ACCESS_CONTROLLER = false;
    @MaybeNull
    private static GraalImageCode current;
    private final boolean defined;
    private final boolean nativeImageExecution;

    protected enum ImageCodeContextAction implements PrivilegedAction<GraalImageCode> {
        INSTANCE;

        public GraalImageCode run() {
            try {
                Method method = Class.forName("java.lang.management.ManagementFactory").getMethod("getRuntimeMXBean", new Class[0]);
                for (String startsWith : (List) method.getReturnType().getMethod("getInputArguments", new Class[0]).invoke(method.invoke((Object) null, new Object[0]), new Object[0])) {
                    if (startsWith.startsWith("-agentlib:native-image-agent")) {
                        return GraalImageCode.AGENT;
                    }
                }
            } catch (Throwable unused) {
            }
            return GraalImageCode.NONE;
        }
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
        GraalImageCode graalImageCode = new GraalImageCode("AGENT", 0, true, false);
        AGENT = graalImageCode;
        GraalImageCode graalImageCode2 = new GraalImageCode("BUILD", 1, true, false);
        BUILD = graalImageCode2;
        GraalImageCode graalImageCode3 = new GraalImageCode("RUNTIME", 2, true, true);
        RUNTIME = graalImageCode3;
        GraalImageCode graalImageCode4 = new GraalImageCode(IdentityHttpResponse.UNKNOWN, 3, false, false);
        UNKNOWN = graalImageCode4;
        GraalImageCode graalImageCode5 = new GraalImageCode("NONE", 4, false, false);
        NONE = graalImageCode5;
        $VALUES = new GraalImageCode[]{graalImageCode, graalImageCode2, graalImageCode3, graalImageCode4, graalImageCode5};
    }

    private GraalImageCode(boolean z10, boolean z11) {
        this.defined = z10;
        this.nativeImageExecution = z11;
    }

    @AccessControllerPlugin.Enhance
    @MaybeNull
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    @SuppressFBWarnings(justification = "This behaviour is intended to avoid early binding in native images.", value = {"LI_LAZY_INIT_STATIC", "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
    public static GraalImageCode getCurrent() {
        GraalImageCode graalImageCode = current;
        if (graalImageCode == null) {
            String str = (String) doPrivileged(new GetSystemPropertyAction("org.graalvm.nativeimage.imagecode"));
            if (str == null) {
                String str2 = (String) doPrivileged(new GetSystemPropertyAction("java.vm.vendor"));
                if (str2 == null || !str2.toLowerCase(Locale.US).contains("graalvm")) {
                    graalImageCode = NONE;
                } else {
                    graalImageCode = (GraalImageCode) doPrivileged(ImageCodeContextAction.INSTANCE);
                }
            } else if (str.equalsIgnoreCase("agent")) {
                graalImageCode = AGENT;
            } else if (str.equalsIgnoreCase("runtime")) {
                graalImageCode = RUNTIME;
            } else if (str.equalsIgnoreCase("buildtime")) {
                graalImageCode = BUILD;
            } else {
                graalImageCode = UNKNOWN;
            }
            current = graalImageCode;
        }
        return graalImageCode;
    }

    public boolean isDefined() {
        return this.defined;
    }

    public boolean isNativeImageExecution() {
        return this.nativeImageExecution;
    }

    public <T> T[] sorted(T[] tArr, Comparator<? super T> comparator) {
        if (this.defined) {
            Arrays.sort(tArr, comparator);
        }
        return tArr;
    }
}
