package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class o {
    public static boolean a(Double d10) {
        return b(d10, true);
    }

    private static boolean b(Double d10, boolean z10) {
        return d10 == null ? z10 : !d10.isNaN() && d10.doubleValue() >= 0.0d && d10.doubleValue() <= 1.0d;
    }

    public static boolean c(Double d10) {
        return b(d10, true);
    }

    public static boolean d(Double d10) {
        return e(d10, true);
    }

    public static boolean e(Double d10, boolean z10) {
        return b(d10, z10);
    }
}
