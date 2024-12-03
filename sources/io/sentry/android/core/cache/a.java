package io.sentry.android.core.cache;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.g0;
import io.sentry.cache.d;
import io.sentry.transport.o;
import io.sentry.util.i;
import io.sentry.util.l;
import io.sentry.w;
import io.sentry.w2;
import java.io.File;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class a extends d {

    /* renamed from: g  reason: collision with root package name */
    private final o f30955g;

    public a(SentryAndroidOptions sentryAndroidOptions) {
        this(sentryAndroidOptions, io.sentry.android.core.internal.util.a.a());
    }

    public static boolean H(SentryOptions sentryOptions) {
        if (sentryOptions.getOutboxPath() == null) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Outbox path is null, the startup crash marker file does not exist", new Object[0]);
            return false;
        }
        File file = new File(sentryOptions.getOutboxPath(), "startup_crash");
        try {
            boolean exists = file.exists();
            if (exists && !file.delete()) {
                sentryOptions.getLogger().c(SentryLevel.ERROR, "Failed to delete the startup crash marker file. %s.", file.getAbsolutePath());
            }
            return exists;
        } catch (Throwable th2) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error reading/deleting the startup crash marker file on the disk", th2);
            return false;
        }
    }

    private void J() {
        if (this.f31161a.getOutboxPath() == null) {
            this.f31161a.getLogger().c(SentryLevel.DEBUG, "Outbox path is null, the startup crash marker file will not be written", new Object[0]);
            return;
        }
        try {
            new File(this.f31161a.getOutboxPath(), "startup_crash").createNewFile();
        } catch (Throwable th2) {
            this.f31161a.getLogger().b(SentryLevel.ERROR, "Error writing the startup crash marker file to the disk", th2);
        }
    }

    public void a1(w2 w2Var, w wVar) {
        super.a1(w2Var, wVar);
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.f31161a;
        Long c10 = g0.e().c();
        if (i.g(wVar, io.sentry.hints.d.class) && c10 != null) {
            long currentTimeMillis = this.f30955g.getCurrentTimeMillis() - c10.longValue();
            if (currentTimeMillis <= sentryAndroidOptions.getStartupCrashDurationThresholdMillis()) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Startup Crash detected %d milliseconds after SDK init. Writing a startup crash marker file to disk.", Long.valueOf(currentTimeMillis));
                J();
            }
        }
    }

    a(SentryAndroidOptions sentryAndroidOptions, o oVar) {
        super(sentryAndroidOptions, (String) l.c(sentryAndroidOptions.getCacheDirPath(), "cacheDirPath must not be null"), sentryAndroidOptions.getMaxCacheItems());
        this.f30955g = oVar;
    }
}
