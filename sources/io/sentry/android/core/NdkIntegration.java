package io.sentry.android.core;

import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.util.l;
import java.io.Closeable;
import java.io.IOException;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

public final class NdkIntegration implements Integration, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f30870a;

    /* renamed from: b  reason: collision with root package name */
    private SentryAndroidOptions f30871b;

    public NdkIntegration(Class<?> cls) {
        this.f30870a = cls;
    }

    private void e(SentryOptions sentryOptions) {
        sentryOptions.setEnableNdk(false);
        sentryOptions.setEnableScopeSync(false);
    }

    public final void a(g0 g0Var, SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions;
        l.c(g0Var, "Hub is required");
        if (sentryOptions instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        } else {
            sentryAndroidOptions = null;
        }
        SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f30871b = sentryAndroidOptions2;
        boolean isEnableNdk = sentryAndroidOptions2.isEnableNdk();
        h0 logger = this.f30871b.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "NdkIntegration enabled: %s", Boolean.valueOf(isEnableNdk));
        if (!isEnableNdk || this.f30870a == null) {
            e(this.f30871b);
        } else if (this.f30871b.getCacheDirPath() == null) {
            this.f30871b.getLogger().c(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
            e(this.f30871b);
        } else {
            try {
                this.f30870a.getMethod("init", new Class[]{SentryAndroidOptions.class}).invoke((Object) null, new Object[]{this.f30871b});
                this.f30871b.getLogger().c(sentryLevel, "NdkIntegration installed.", new Object[0]);
                c();
            } catch (NoSuchMethodException e10) {
                e(this.f30871b);
                this.f30871b.getLogger().b(SentryLevel.ERROR, "Failed to invoke the SentryNdk.init method.", e10);
            } catch (Throwable th2) {
                e(this.f30871b);
                this.f30871b.getLogger().b(SentryLevel.ERROR, "Failed to initialize SentryNdk.", th2);
            }
        }
    }

    public void close() throws IOException {
        Class<?> cls;
        SentryAndroidOptions sentryAndroidOptions = this.f30871b;
        if (sentryAndroidOptions != null && sentryAndroidOptions.isEnableNdk() && (cls = this.f30870a) != null) {
            try {
                cls.getMethod(Close.ELEMENT, new Class[0]).invoke((Object) null, new Object[0]);
                this.f30871b.getLogger().c(SentryLevel.DEBUG, "NdkIntegration removed.", new Object[0]);
            } catch (NoSuchMethodException e10) {
                this.f30871b.getLogger().b(SentryLevel.ERROR, "Failed to invoke the SentryNdk.close method.", e10);
            } catch (Throwable th2) {
                e(this.f30871b);
                throw th2;
            }
            e(this.f30871b);
        }
    }
}
