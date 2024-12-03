package io.sentry.android.core.internal.util;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.lang.Thread;

public final /* synthetic */ class m implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SentryOptions f31038a;

    public /* synthetic */ m(SentryOptions sentryOptions) {
        this.f31038a = sentryOptions;
    }

    public final void uncaughtException(Thread thread, Throwable th2) {
        this.f31038a.getLogger().b(SentryLevel.ERROR, "Error during frames measurements.", th2);
    }
}
