package io.sentry;

import java.io.IOException;
import java.util.Locale;

public enum SentryLevel implements c1 {
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL;

    static final class a implements s0<SentryLevel> {
        a() {
        }

        /* renamed from: b */
        public SentryLevel a(y0 y0Var, h0 h0Var) throws Exception {
            return SentryLevel.valueOf(y0Var.G().toUpperCase(Locale.ROOT));
        }
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.I(name().toLowerCase(Locale.ROOT));
    }
}
