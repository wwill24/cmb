package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;
import org.jivesoftware.smack.util.SystemUtil;

@ApiStatus.Internal
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f31724a;

    /* renamed from: b  reason: collision with root package name */
    static boolean f31725b;

    static {
        boolean z10;
        try {
            f31724a = "The Android Project".equals(System.getProperty(SystemUtil.PROPERTY_JAVA_VENDOR));
        } catch (Throwable unused) {
            f31724a = false;
        }
        try {
            String property = System.getProperty("java.specification.version");
            if (property != null) {
                if (Double.valueOf(property).doubleValue() >= 9.0d) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                f31725b = z10;
                return;
            }
            f31725b = false;
        } catch (Throwable unused2) {
            f31725b = false;
        }
    }

    public static boolean a() {
        return f31725b;
    }

    public static boolean b() {
        return !f31724a;
    }
}
