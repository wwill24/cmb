package io.sentry.util;

import io.sentry.SentryLevel;
import io.sentry.h0;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class k {
    public static void a(Class<?> cls, Object obj, h0 h0Var) {
        String str;
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        Object[] objArr = new Object[2];
        if (obj != null) {
            str = obj.getClass().getCanonicalName();
        } else {
            str = "Hint";
        }
        objArr[0] = str;
        objArr[1] = cls.getCanonicalName();
        h0Var.c(sentryLevel, "%s is not %s", objArr);
    }
}
