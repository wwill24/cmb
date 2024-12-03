package io.sentry;

import io.sentry.util.l;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class j implements h0 {

    /* renamed from: a  reason: collision with root package name */
    private final SentryOptions f31302a;

    /* renamed from: b  reason: collision with root package name */
    private final h0 f31303b;

    public j(SentryOptions sentryOptions, h0 h0Var) {
        this.f31302a = (SentryOptions) l.c(sentryOptions, "SentryOptions is required.");
        this.f31303b = h0Var;
    }

    public void a(SentryLevel sentryLevel, Throwable th2, String str, Object... objArr) {
        if (this.f31303b != null && d(sentryLevel)) {
            this.f31303b.a(sentryLevel, th2, str, objArr);
        }
    }

    public void b(SentryLevel sentryLevel, String str, Throwable th2) {
        if (this.f31303b != null && d(sentryLevel)) {
            this.f31303b.b(sentryLevel, str, th2);
        }
    }

    public void c(SentryLevel sentryLevel, String str, Object... objArr) {
        if (this.f31303b != null && d(sentryLevel)) {
            this.f31303b.c(sentryLevel, str, objArr);
        }
    }

    public boolean d(SentryLevel sentryLevel) {
        SentryLevel diagnosticLevel = this.f31302a.getDiagnosticLevel();
        if (sentryLevel != null && this.f31302a.isDebug() && sentryLevel.ordinal() >= diagnosticLevel.ordinal()) {
            return true;
        }
        return false;
    }
}
