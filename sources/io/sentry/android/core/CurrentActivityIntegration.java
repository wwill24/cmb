package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import io.sentry.Integration;
import io.sentry.SentryOptions;
import io.sentry.g0;
import io.sentry.util.l;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class CurrentActivityIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final Application f30857a;

    public CurrentActivityIntegration(Application application) {
        this.f30857a = (Application) l.c(application, "Application is required");
    }

    private void e(Activity activity) {
        if (k0.c().b() == activity) {
            k0.c().a();
        }
    }

    private void f(Activity activity) {
        k0.c().d(activity);
    }

    public void a(g0 g0Var, SentryOptions sentryOptions) {
        this.f30857a.registerActivityLifecycleCallbacks(this);
    }

    public void close() throws IOException {
        this.f30857a.unregisterActivityLifecycleCallbacks(this);
        k0.c().a();
    }

    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        f(activity);
    }

    public void onActivityDestroyed(@NonNull Activity activity) {
        e(activity);
    }

    public void onActivityPaused(@NonNull Activity activity) {
        e(activity);
    }

    public void onActivityResumed(@NonNull Activity activity) {
        f(activity);
    }

    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public void onActivityStarted(@NonNull Activity activity) {
        f(activity);
    }

    public void onActivityStopped(@NonNull Activity activity) {
        e(activity);
    }
}
