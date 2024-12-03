package io.sentry;

import java.io.File;

public interface j2 {
    /* access modifiers changed from: private */
    static /* synthetic */ void c(h0 h0Var, String str, l lVar, File file) {
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        h0Var.c(sentryLevel, "Started processing cached files from %s", str);
        lVar.e(file);
        h0Var.c(sentryLevel, "Finished processing cached files from %s", str);
    }

    g2 a(l lVar, String str, h0 h0Var) {
        return new i2(h0Var, str, lVar, new File(str));
    }

    g2 d(g0 g0Var, SentryOptions sentryOptions);

    boolean e(String str, h0 h0Var) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        h0Var.c(SentryLevel.INFO, "No cached dir path is defined in options.", new Object[0]);
        return false;
    }
}
