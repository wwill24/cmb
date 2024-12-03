package io.sentry;

import io.sentry.transport.d;
import io.sentry.transport.p;
import io.sentry.transport.y;
import io.sentry.util.l;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class a implements p0 {
    public p a(SentryOptions sentryOptions, b2 b2Var) {
        l.c(sentryOptions, "options is required");
        l.c(b2Var, "requestDetails is required");
        return new d(sentryOptions, new y(sentryOptions), sentryOptions.getTransportGate(), b2Var);
    }
}
