package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import io.sentry.u2;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class SentryPerformanceProvider extends o0 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    private static u2 f30892e = r.a();

    /* renamed from: f  reason: collision with root package name */
    private static long f30893f = SystemClock.uptimeMillis();

    /* renamed from: b  reason: collision with root package name */
    private boolean f30894b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30895c = false;

    /* renamed from: d  reason: collision with root package name */
    private Application f30896d;

    public SentryPerformanceProvider() {
        g0.e().i(f30893f, f30892e);
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (!SentryPerformanceProvider.class.getName().equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            return;
        }
        throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
    }

    public String getType(Uri uri) {
        return null;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        boolean z10;
        if (!this.f30894b) {
            if (bundle == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            g0.e().j(z10);
            this.f30894b = true;
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (!this.f30895c) {
            this.f30895c = true;
            g0.e().g();
        }
        Application application = this.f30896d;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        if (!(context instanceof Application)) {
            return true;
        }
        Application application = (Application) context;
        this.f30896d = application;
        application.registerActivityLifecycleCallbacks(this);
        return true;
    }
}
