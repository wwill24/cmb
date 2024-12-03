package com.mparticle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.mparticle.internal.Logger;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class a extends Application {

    /* renamed from: a  reason: collision with root package name */
    private Application f22239a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f22240b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22241c = true;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public b f22242d;

    /* renamed from: com.mparticle.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0253a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22243a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mparticle.a$d[] r0 = com.mparticle.a.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22243a = r0
                com.mparticle.a$d r1 = com.mparticle.a.d.ON_CREATED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22243a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mparticle.a$d r1 = com.mparticle.a.d.ON_STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22243a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mparticle.a$d r1 = com.mparticle.a.d.ON_RESUMED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22243a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mparticle.a$d r1 = com.mparticle.a.d.ON_PAUSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22243a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mparticle.a$d r1 = com.mparticle.a.d.ON_SAVE_INSTANCE_STATE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f22243a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mparticle.a$d r1 = com.mparticle.a.d.ON_STOPPED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f22243a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mparticle.a$d r1 = com.mparticle.a.d.ON_DESTROYED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.a.C0253a.<clinit>():void");
        }
    }

    @TargetApi(14)
    class b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        List<c> f22244a = Collections.synchronizedList(new LinkedList());

        /* renamed from: b  reason: collision with root package name */
        int f22245b = 10;

        b() {
        }

        /* access modifiers changed from: private */
        public LinkedList<c> b() {
            LinkedList<c> linkedList;
            synchronized (this.f22244a) {
                linkedList = new LinkedList<>(this.f22244a);
            }
            return linkedList;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            a().add(new c(d.ON_CREATED, new WeakReference(activity), bundle));
        }

        public void onActivityDestroyed(Activity activity) {
            a().add(new c(a.this, d.ON_DESTROYED, new WeakReference(activity)));
        }

        public void onActivityPaused(Activity activity) {
            a().add(new c(a.this, d.ON_PAUSED, new WeakReference(activity)));
        }

        public void onActivityResumed(Activity activity) {
            a().add(new c(a.this, d.ON_RESUMED, new WeakReference(activity)));
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            a().add(new c(d.ON_SAVE_INSTANCE_STATE, new WeakReference(activity), bundle));
        }

        public void onActivityStarted(Activity activity) {
            a().add(new c(a.this, d.ON_STARTED, new WeakReference(activity)));
        }

        public void onActivityStopped(Activity activity) {
            a().add(new c(a.this, d.ON_STOPPED, new WeakReference(activity)));
        }

        private List<c> a() {
            if (this.f22244a.size() <= this.f22245b) {
                return this.f22244a;
            }
            this.f22244a.remove(0);
            return a();
        }
    }

    class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public d f22247a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<Activity> f22248b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Bundle f22249c;

        public c(a aVar, d dVar, WeakReference<Activity> weakReference) {
            this(dVar, weakReference, (Bundle) null);
        }

        public boolean equals(Object obj) {
            boolean z10;
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            WeakReference<Activity> weakReference = cVar.f22248b;
            if (!(weakReference == null && this.f22248b == null) && (weakReference == null || this.f22248b == null || weakReference.get() != this.f22248b.get())) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && cVar.f22247a == this.f22247a && cVar.f22249c == this.f22249c) {
                return true;
            }
            return false;
        }

        c(d dVar, WeakReference<Activity> weakReference, Bundle bundle) {
            this.f22247a = dVar;
            this.f22248b = weakReference;
            this.f22249c = bundle;
        }
    }

    enum d {
        ON_CREATED,
        ON_STARTED,
        ON_RESUMED,
        ON_PAUSED,
        ON_STOPPED,
        ON_SAVE_INSTANCE_STATE,
        ON_DESTROYED
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        Application.ActivityLifecycleCallbacks f22259a;

        e(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            this.f22259a = activityLifecycleCallbacks;
        }

        @TargetApi(14)
        public void run() {
            WeakReference<Activity> weakReference;
            Activity activity;
            Activity activity2;
            if (this.f22259a != null && a.this.f22242d != null && a.this.f22240b) {
                if (MParticle.getInstance().Internal().c() == null) {
                    weakReference = null;
                } else {
                    weakReference = MParticle.getInstance().Internal().c().getCurrentActivity();
                }
                if (weakReference != null && (activity = weakReference.get()) != null) {
                    LinkedList a10 = a.this.f22242d.b();
                    while (a10.size() > 0) {
                        c cVar = (c) a10.removeFirst();
                        if (!(cVar.f22248b == null || (activity2 = (Activity) cVar.f22248b.get()) == null || activity2 != activity)) {
                            switch (C0253a.f22243a[cVar.f22247a.ordinal()]) {
                                case 1:
                                    Logger.debug("Forwarding OnCreate");
                                    this.f22259a.onActivityCreated(activity2, cVar.f22249c);
                                    break;
                                case 2:
                                    Logger.debug("Forwarding OnStart");
                                    this.f22259a.onActivityStarted(activity2);
                                    break;
                                case 3:
                                    Logger.debug("Forwarding OnResume");
                                    this.f22259a.onActivityResumed(activity2);
                                    break;
                                case 4:
                                    Logger.debug("Forwarding OnPause");
                                    this.f22259a.onActivityPaused(activity2);
                                    break;
                                case 5:
                                    Logger.debug("Forwarding OnSaveInstance");
                                    this.f22259a.onActivitySaveInstanceState(activity2, cVar.f22249c);
                                    break;
                                case 6:
                                    Logger.debug("Forwarding OnStop");
                                    this.f22259a.onActivityStopped(activity2);
                                    break;
                                case 7:
                                    Logger.debug("Forwarding OnDestroy");
                                    this.f22259a.onActivityDestroyed(activity2);
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    public a(Application application) {
        this.f22239a = application;
        attachBaseContext(application);
        this.f22242d = new b();
        a();
    }

    public boolean equals(Object obj) {
        return this.f22239a.equals(obj);
    }

    public Context getApplicationContext() {
        return this;
    }

    public int hashCode() {
        return this.f22239a.hashCode();
    }

    @SuppressLint({"MissingSuperCall"})
    public void onConfigurationChanged(Configuration configuration) {
        this.f22239a.onConfigurationChanged(configuration);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate() {
        this.f22239a.onCreate();
    }

    @SuppressLint({"MissingSuperCall"})
    public void onLowMemory() {
        this.f22239a.onLowMemory();
    }

    @SuppressLint({"MissingSuperCall"})
    public void onTerminate() {
        this.f22239a.onTerminate();
    }

    @SuppressLint({"MissingSuperCall"})
    @TargetApi(14)
    public void onTrimMemory(int i10) {
        this.f22239a.onTrimMemory(i10);
    }

    @TargetApi(14)
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        a(activityLifecycleCallbacks, false);
    }

    @TargetApi(14)
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f22239a.registerComponentCallbacks(componentCallbacks);
    }

    @TargetApi(18)
    public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.f22239a.registerOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    public String toString() {
        return this.f22239a.toString();
    }

    @TargetApi(14)
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f22239a.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @TargetApi(14)
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f22239a.unregisterComponentCallbacks(componentCallbacks);
    }

    @TargetApi(18)
    public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.f22239a.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks, boolean z10) {
        this.f22239a.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        e eVar = new e(activityLifecycleCallbacks);
        if (z10) {
            eVar.run();
            return;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        new Handler().post(eVar);
    }

    @TargetApi(14)
    public void b() {
        this.f22239a.unregisterActivityLifecycleCallbacks(this.f22242d);
    }

    @TargetApi(14)
    private void a() {
        b();
        this.f22239a.registerActivityLifecycleCallbacks(this.f22242d);
    }
}
