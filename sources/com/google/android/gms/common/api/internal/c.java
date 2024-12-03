package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import me.p;

public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e  reason: collision with root package name */
    private static final c f38555e = new c();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f38556a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f38557b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f38558c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f38559d = false;

    public interface a {
        void onBackgroundStateChanged(boolean z10);
    }

    private c() {
    }

    @NonNull
    public static c b() {
        return f38555e;
    }

    public static void c(@NonNull Application application) {
        c cVar = f38555e;
        synchronized (cVar) {
            if (!cVar.f38559d) {
                application.registerActivityLifecycleCallbacks(cVar);
                application.registerComponentCallbacks(cVar);
                cVar.f38559d = true;
            }
        }
    }

    private final void f(boolean z10) {
        synchronized (f38555e) {
            Iterator it = this.f38558c.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onBackgroundStateChanged(z10);
            }
        }
    }

    public void a(@NonNull a aVar) {
        synchronized (f38555e) {
            this.f38558c.add(aVar);
        }
    }

    public boolean d() {
        return this.f38556a.get();
    }

    @TargetApi(16)
    public boolean e(boolean z10) {
        if (!this.f38557b.get()) {
            if (!p.b()) {
                return z10;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f38557b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f38556a.set(true);
            }
        }
        return d();
    }

    public final void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f38556a.compareAndSet(true, false);
        this.f38557b.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivityDestroyed(@NonNull Activity activity) {
    }

    public final void onActivityPaused(@NonNull Activity activity) {
    }

    public final void onActivityResumed(@NonNull Activity activity) {
        boolean compareAndSet = this.f38556a.compareAndSet(true, false);
        this.f38557b.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public final void onActivityStarted(@NonNull Activity activity) {
    }

    public final void onActivityStopped(@NonNull Activity activity) {
    }

    public final void onConfigurationChanged(@NonNull Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i10) {
        if (i10 == 20 && this.f38556a.compareAndSet(false, true)) {
            this.f38557b.set(true);
            f(true);
        }
    }
}
