package io.sentry.android.core;

import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.util.l;
import io.sentry.w1;
import java.io.Closeable;

public abstract class EnvelopeFileObserverIntegration implements Integration, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private p0 f30858a;

    /* renamed from: b  reason: collision with root package name */
    private h0 f30859b;

    private static final class OutboxEnvelopeFileObserverIntegration extends EnvelopeFileObserverIntegration {
        private OutboxEnvelopeFileObserverIntegration() {
        }

        /* access modifiers changed from: protected */
        public String f(SentryOptions sentryOptions) {
            return sentryOptions.getOutboxPath();
        }
    }

    public static EnvelopeFileObserverIntegration e() {
        return new OutboxEnvelopeFileObserverIntegration();
    }

    public final void a(g0 g0Var, SentryOptions sentryOptions) {
        l.c(g0Var, "Hub is required");
        l.c(sentryOptions, "SentryOptions is required");
        this.f30859b = sentryOptions.getLogger();
        String f10 = f(sentryOptions);
        if (f10 == null) {
            this.f30859b.c(SentryLevel.WARNING, "Null given as a path to EnvelopeFileObserverIntegration. Nothing will be registered.", new Object[0]);
            return;
        }
        h0 h0Var = this.f30859b;
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        h0Var.c(sentryLevel, "Registering EnvelopeFileObserverIntegration for path: %s", f10);
        w1 w1Var = new w1(g0Var, sentryOptions.getEnvelopeReader(), sentryOptions.getSerializer(), this.f30859b, sentryOptions.getFlushTimeoutMillis());
        p0 p0Var = new p0(f10, w1Var, this.f30859b, sentryOptions.getFlushTimeoutMillis());
        this.f30858a = p0Var;
        try {
            p0Var.startWatching();
            this.f30859b.c(sentryLevel, "EnvelopeFileObserverIntegration installed.", new Object[0]);
        } catch (Throwable th2) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to initialize EnvelopeFileObserverIntegration.", th2);
        }
    }

    public void close() {
        p0 p0Var = this.f30858a;
        if (p0Var != null) {
            p0Var.stopWatching();
            h0 h0Var = this.f30859b;
            if (h0Var != null) {
                h0Var.c(SentryLevel.DEBUG, "EnvelopeFileObserverIntegration removed.", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract String f(SentryOptions sentryOptions);
}
