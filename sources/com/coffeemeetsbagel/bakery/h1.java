package com.coffeemeetsbagel.bakery;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.coffeemeetsbagel.token.g;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Deprecated
public class h1 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: j  reason: collision with root package name */
    private static h1 f11201j;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f11202a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f11203b = true;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f11204c = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f11205d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    private Runnable f11206e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f11207f;

    /* renamed from: g  reason: collision with root package name */
    private int f11208g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11209h = false;

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (h1.this.f11202a && h1.this.f11203b) {
                h1.this.k();
                h1.this.f11202a = false;
                for (b P : h1.this.f11205d) {
                    try {
                        P.P();
                    } catch (Exception e10) {
                        fa.a.g("ManagerActivityLifecycle", "Listener threw exception!", e10);
                    }
                }
            }
        }
    }

    public interface b {
        void P();

        void S();
    }

    public static h1 g() {
        h1 h1Var = f11201j;
        if (h1Var != null) {
            return h1Var;
        }
        throw new IllegalStateException("ManagerActivityLifecycle is not initialised - invoke at least once with parameterised create/get");
    }

    public static h1 h(Application application) {
        if (f11201j == null) {
            h1 h1Var = new h1();
            f11201j = h1Var;
            application.registerActivityLifecycleCallbacks(h1Var);
        }
        return f11201j;
    }

    /* access modifiers changed from: private */
    public void k() {
        new g(new com.coffeemeetsbagel.token.a(Bakery.w().K()), Bakery.w().M().a(), FirebaseMessaging.getInstance(), Bakery.w().g()).start();
    }

    public void f(b bVar) {
        this.f11205d.add(bVar);
    }

    public boolean i() {
        return this.f11202a;
    }

    public void j(b bVar) {
        this.f11205d.remove(bVar);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.f11203b = true;
        Runnable runnable = this.f11206e;
        if (runnable != null) {
            this.f11204c.removeCallbacks(runnable);
        }
        Handler handler = this.f11204c;
        a aVar = new a();
        this.f11206e = aVar;
        handler.postDelayed(aVar, 500);
    }

    public void onActivityResumed(Activity activity) {
        this.f11203b = false;
        boolean z10 = !this.f11202a;
        this.f11202a = true;
        if (z10) {
            k();
            if (this.f11207f == null) {
                HashMap hashMap = new HashMap();
                this.f11207f = hashMap;
                hashMap.put(FirebaseAnalytics.Param.METHOD, "direct");
            }
            this.f11207f.put("is badged", String.valueOf(Bakery.w().M().p("APP_BADGE_SHOWN")));
            Bakery.w().z().trackEvent("App Launch", this.f11207f);
        }
        Runnable runnable = this.f11206e;
        if (runnable != null) {
            this.f11204c.removeCallbacks(runnable);
        }
        if (z10) {
            ManagerNotifications.d();
            for (b S : this.f11205d) {
                try {
                    S.S();
                } catch (Exception e10) {
                    fa.a.g("ManagerActivityLifecycle", "Listener threw exception!", e10);
                }
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        int i10 = this.f11208g + 1;
        this.f11208g = i10;
        if (i10 == 1 && !this.f11209h) {
            Bakery.w().f().b(false);
        }
    }

    @SuppressLint({"VisibleForTests"})
    public void onActivityStopped(Activity activity) {
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        this.f11209h = isChangingConfigurations;
        int i10 = this.f11208g - 1;
        this.f11208g = i10;
        if (i10 == 0 && !isChangingConfigurations) {
            g1.f11198a.clear();
            Bakery.w().f().b(true);
        }
    }
}
