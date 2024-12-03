package io.sentry;

import io.sentry.util.l;
import java.io.Closeable;
import java.io.IOException;

public final class ShutdownHookIntegration implements Integration, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Runtime f30805a;

    /* renamed from: b  reason: collision with root package name */
    private Thread f30806b;

    public ShutdownHookIntegration(Runtime runtime) {
        this.f30805a = (Runtime) l.c(runtime, "Runtime is required");
    }

    public void a(g0 g0Var, SentryOptions sentryOptions) {
        l.c(g0Var, "Hub is required");
        l.c(sentryOptions, "SentryOptions is required");
        if (sentryOptions.isEnableShutdownHook()) {
            Thread thread = new Thread(new h4(g0Var, sentryOptions));
            this.f30806b = thread;
            this.f30805a.addShutdownHook(thread);
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "ShutdownHookIntegration installed.", new Object[0]);
            c();
            return;
        }
        sentryOptions.getLogger().c(SentryLevel.INFO, "enableShutdownHook is disabled.", new Object[0]);
    }

    public void close() throws IOException {
        Thread thread = this.f30806b;
        if (thread != null) {
            try {
                this.f30805a.removeShutdownHook(thread);
            } catch (IllegalStateException e10) {
                String message = e10.getMessage();
                if (message == null || !message.equals("Shutdown in progress")) {
                    throw e10;
                }
            }
        }
    }

    public ShutdownHookIntegration() {
        this(Runtime.getRuntime());
    }
}
