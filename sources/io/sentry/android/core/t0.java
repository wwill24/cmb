package io.sentry.android.core;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.h0;

public final class t0 {
    public boolean a(String str, h0 h0Var) {
        return c(str, h0Var) != null;
    }

    public boolean b(String str, SentryOptions sentryOptions) {
        return a(str, sentryOptions != null ? sentryOptions.getLogger() : null);
    }

    public Class<?> c(String str, h0 h0Var) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            if (h0Var == null) {
                return null;
            }
            SentryLevel sentryLevel = SentryLevel.DEBUG;
            h0Var.b(sentryLevel, "Class not available:" + str, e10);
            return null;
        } catch (UnsatisfiedLinkError e11) {
            if (h0Var == null) {
                return null;
            }
            SentryLevel sentryLevel2 = SentryLevel.ERROR;
            h0Var.b(sentryLevel2, "Failed to load (UnsatisfiedLinkError) " + str, e11);
            return null;
        } catch (Throwable th2) {
            if (h0Var == null) {
                return null;
            }
            SentryLevel sentryLevel3 = SentryLevel.ERROR;
            h0Var.b(sentryLevel3, "Failed to initialize " + str, th2);
            return null;
        }
    }
}
