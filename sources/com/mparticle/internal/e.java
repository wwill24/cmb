package com.mparticle.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

@TargetApi(14)
class e implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private a f22461a;

    public e(a aVar) {
        this.f22461a = aVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f22461a.a(activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        this.f22461a.b(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.f22461a.c(activity);
    }

    public void onActivityResumed(Activity activity) {
        this.f22461a.d(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f22461a.b(activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        this.f22461a.e(activity);
    }

    public void onActivityStopped(Activity activity) {
        this.f22461a.f(activity);
    }
}
