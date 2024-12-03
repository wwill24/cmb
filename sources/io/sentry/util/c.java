package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class c {
    public static Throwable a(Throwable th2) {
        l.c(th2, "throwable cannot be null");
        while (th2.getCause() != null && th2.getCause() != th2) {
            th2 = th2.getCause();
        }
        return th2;
    }
}
