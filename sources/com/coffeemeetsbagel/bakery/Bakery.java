package com.coffeemeetsbagel.bakery;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.StrictMode;
import android.text.TextUtils;
import androidx.appcompat.app.f;
import androidx.core.app.p;
import c9.d;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityLogin;
import com.coffeemeetsbagel.bakery.SiftHandler;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.external_links.LeanPlumCmbLinks;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.feature.sync.r;
import com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions;
import com.coffeemeetsbagel.likes_you.u0;
import com.coffeemeetsbagel.match.c0;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.interfaces.UpgradeContract;
import com.coffeemeetsbagel.store.s0;
import com.facebook.FacebookSdk;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.LeanplumPushNotificationCustomizer;
import com.leanplum.LeanplumPushService;
import com.leanplum.annotations.Parser;
import f6.b2;
import f6.f2;
import h5.d0;
import h5.e;
import hb.c;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.d1;
import java.lang.Thread;
import java.util.concurrent.TimeoutException;
import k7.s;
import l8.h;
import lc.g;
import t8.l;

public class Bakery extends Application {

    /* renamed from: a  reason: collision with root package name */
    private static Bakery f11052a;

    /* renamed from: b  reason: collision with root package name */
    private static b f11053b;

    public enum CmbEndpointsPointToType {
        STAGING,
        PRODUCTION,
        CUSTOM;
        
        private String customUrl;

        /* access modifiers changed from: private */
        public CmbEndpointsPointToType c(String str) {
            this.customUrl = str;
            return this;
        }

        public String b() {
            if (TextUtils.isEmpty(x4.a.f18540d)) {
                i1.g();
            }
            return x4.a.f18540d;
        }
    }

    class a implements LeanplumPushNotificationCustomizer {
        a() {
        }

        public void customize(Notification.Builder builder, Bundle bundle, Notification.Style style) {
        }

        public void customize(p.e eVar, Bundle bundle) {
            eVar.x(R.drawable.icon_notification_k_statusbar);
        }
    }

    private static final class b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private final SiftHandler f11059a;

        public b() {
            HandlerThread handlerThread = new HandlerThread("SiftHandler");
            handlerThread.start();
            this.f11059a = new SiftHandler(handlerThread.getLooper());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.f11059a.a(SiftHandler.SiftEvent.CREATE);
        }

        public void onActivityDestroyed(Activity activity) {
            this.f11059a.a(SiftHandler.SiftEvent.DESTROYED);
        }

        public void onActivityPaused(Activity activity) {
            this.f11059a.a(SiftHandler.SiftEvent.PAUSE);
        }

        public void onActivityResumed(Activity activity) {
            this.f11059a.b(SiftHandler.SiftEvent.RESUME, activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            boolean z10;
            if ((activity instanceof ActivityLogin) || (activity instanceof ChatActivity)) {
                z10 = true;
            } else {
                z10 = false;
            }
            aa.a.f219a.a(z10);
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    private void P() {
        rd.b j10 = rd.b.j(this);
        j10.m(e.f15349a);
        j10.h(this);
        j10.l("UA-25237143-4").b(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R() {
        FacebookSdk.sdkInitialize(this);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void S(double d10, SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.setEnvironment(p().toString().toLowerCase());
        sentryAndroidOptions.setSampleRate(Double.valueOf(d10));
        sentryAndroidOptions.setDebug(false);
    }

    private void Z() {
        if (!g.b()) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyDeathOnNetwork().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().build());
        }
    }

    private void a0() {
        Thread.setDefaultUncaughtExceptionHandler(new h5.b(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    public static b j() {
        return f11053b;
    }

    public static CmbEndpointsPointToType p() {
        hb.b bVar = new hb.b(w());
        if (e.f15349a) {
            return CmbEndpointsPointToType.STAGING;
        }
        if (g.b()) {
            return CmbEndpointsPointToType.PRODUCTION;
        }
        String r10 = bVar.r("custom_ip");
        if (!TextUtils.isEmpty(r10)) {
            return CmbEndpointsPointToType.CUSTOM.c(r10);
        }
        if (bVar.p("is_set_to_baking")) {
            return CmbEndpointsPointToType.STAGING;
        }
        return CmbEndpointsPointToType.PRODUCTION;
    }

    public static Bakery w() {
        return f11052a;
    }

    public s A() {
        return f11053b.a1();
    }

    public f2 B() {
        return f11053b.Q0();
    }

    public PurchaseManager C() {
        return f11053b.j();
    }

    public r D() {
        return f11053b.i0();
    }

    public h E() {
        return f11053b.t();
    }

    public l F() {
        return f11053b.p1();
    }

    public ProfileContract$Manager G() {
        return f11053b.d();
    }

    public t H() {
        return f11053b.B();
    }

    public b9.a I() {
        return f11053b.U1();
    }

    public d J() {
        return f11053b.p();
    }

    public c7.d K() {
        return f11053b.i1();
    }

    public ga.e L() {
        return f11053b.x1();
    }

    public c M() {
        return f11053b.H();
    }

    public UpgradeContract.Manager N() {
        return f11053b.V1();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O */
    public void T(Thread thread, Throwable th2, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if ((!(th2 instanceof TimeoutException) || !thread.getName().equals("FinalizerWatchdogDaemon")) && uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }

    public u0 U() {
        return f11053b.m1();
    }

    /* access modifiers changed from: protected */
    public void V() {
        f11053b = f1.a().d(this).b(c0.f34498a).e(b2.f14780a).f(d0.f15347a).g(x4.b.f18542a).c(s0.f36931a).a(db.a.f40587a).build();
        fa.a.h(g.a(), f11053b.x1(), FirebaseCrashlytics.getInstance());
        fa.a.l(M().r("SELF_USER_PROFILE_ID"));
        AsyncTask.execute(new h5.c(this));
        c7.d i12 = f11053b.i1();
        i12.d(new e9.b());
        i12.b(new com.coffeemeetsbagel.feature.authentication.api.c(f11053b.E()));
        i12.a(new com.coffeemeetsbagel.feature.authentication.api.d(f11053b.E(), f11053b.d()));
        i12.d(new e9.c(this, f11053b.E(), f11053b.T0(), f11053b.H(), f11053b.b()));
        f11053b.Z1();
        h1.g().f(f11053b.p());
        f.H(true);
        Parser.parseVariables(this);
        LeanplumActivityHelper.enableLifecycleCallbacks(this);
        w().G().start();
    }

    /* access modifiers changed from: protected */
    public void W() {
    }

    /* access modifiers changed from: protected */
    public void X() {
        Parser.parseVariablesForClasses(t9.a.class, LeanPlumPaintedDoorDefinitions.class, com.coffeemeetsbagel.whatsnew.e.class, LeanPlumCmbLinks.class);
        LeanplumPushService.setCustomizer(new a());
    }

    /* access modifiers changed from: protected */
    public void Y() {
        double p10 = (double) H().p();
        if (p10 > 0.0d) {
            d1.f(this, new h5.d(p10));
        }
    }

    public b7.c e() {
        return f11053b.K();
    }

    public i5.a f() {
        return f11053b.r1();
    }

    public d7.c g() {
        return f11053b.E();
    }

    public e7.c h() {
        return f11053b.H1();
    }

    public j i() {
        return f11053b.l();
    }

    public CmbDatabase k() {
        return f11053b.C1();
    }

    public a6.a l() {
        return f11053b.x();
    }

    public ConnectivityManager m() {
        return f11053b.t1();
    }

    public t7.a n() {
        return f11053b.Q();
    }

    public v7.d o() {
        return f11053b.G();
    }

    @SuppressLint({"MParticleInitialization"})
    public void onCreate() {
        super.onCreate();
        f11052a = this;
        W();
        g1.c("user_landed");
        P();
        V();
        com.coffeemeetsbagel.image_loader.b bVar = com.coffeemeetsbagel.image_loader.b.f13967a;
        bVar.e(w().s());
        bVar.d(w().z());
        H().e(new a(this));
        X();
        registerActivityLifecycleCallbacks(new b());
        bk.a.B(new h5.a());
        Z();
        a0();
    }

    public y7.a q() {
        return f11053b.T0();
    }

    public h8.a r() {
        return f11053b.F1();
    }

    public s9.a s() {
        return f11053b.b();
    }

    public FirebaseContract.Analytics t() {
        return f11053b.a0();
    }

    public b u() {
        return f11053b;
    }

    public InstagramContract$Manager v() {
        return f11053b.U();
    }

    public d7.l x() {
        return f11053b.X1();
    }

    public q8.a y() {
        return f11053b.b1();
    }

    public a7.a z() {
        return f11053b.R();
    }
}
