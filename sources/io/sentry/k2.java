package io.sentry;

import io.sentry.util.l;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class k2 implements j2 {

    /* renamed from: a  reason: collision with root package name */
    private final h2 f31316a;

    public k2(h2 h2Var) {
        this.f31316a = (h2) l.c(h2Var, "SendFireAndForgetDirPath is required");
    }

    public g2 d(g0 g0Var, SentryOptions sentryOptions) {
        l.c(g0Var, "Hub is required");
        l.c(sentryOptions, "SentryOptions is required");
        String a10 = this.f31316a.a();
        if (a10 == null || !e(a10, sentryOptions.getLogger())) {
            sentryOptions.getLogger().c(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
            return null;
        }
        return a(new s(g0Var, sentryOptions.getSerializer(), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis()), a10, sentryOptions.getLogger());
    }
}
