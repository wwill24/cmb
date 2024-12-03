package com.mparticle.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.identity.IdentityApi;
import com.mparticle.identity.IdentityApiRequest;
import com.mparticle.identity.MParticleUser;
import com.mparticle.internal.listeners.InternalListenerManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class a {

    /* renamed from: o  reason: collision with root package name */
    public static boolean f22381o;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f22382a;

    /* renamed from: b  reason: collision with root package name */
    Context f22383b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f22384c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public InternalSession f22385d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<Activity> f22386e;

    /* renamed from: f  reason: collision with root package name */
    private String f22387f;

    /* renamed from: g  reason: collision with root package name */
    AtomicLong f22388g;

    /* renamed from: h  reason: collision with root package name */
    Handler f22389h;

    /* renamed from: i  reason: collision with root package name */
    AtomicInteger f22390i;

    /* renamed from: j  reason: collision with root package name */
    private long f22391j;

    /* renamed from: k  reason: collision with root package name */
    boolean f22392k;

    /* renamed from: l  reason: collision with root package name */
    private j f22393l;

    /* renamed from: m  reason: collision with root package name */
    private Uri f22394m;

    /* renamed from: n  reason: collision with root package name */
    private String f22395n;

    /* renamed from: com.mparticle.internal.a$a  reason: collision with other inner class name */
    class C0257a implements IdentityApi.j {
        C0257a() {
        }

        public void a(long j10, long j11) {
            if (a.this.f22385d != null) {
                a.this.f22385d.addMpid(j10);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            try {
                if (a.this.l()) {
                    a.this.a();
                    a.this.m();
                    a.this.f22382a.c0();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            if (a.this.p()) {
                Logger.debug("Session timed out");
                a.this.d();
            }
        }
    }

    static class d extends IdentityApiRequest.Builder {
        d(MParticleUser mParticleUser) {
            super(mParticleUser);
        }

        /* access modifiers changed from: protected */
        public IdentityApiRequest.Builder googleAdId(String str, String str2) {
            return super.googleAdId(str, str2);
        }
    }

    static class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f22399a;

        /* renamed from: b  reason: collision with root package name */
        String f22400b;

        /* renamed from: com.mparticle.internal.a$e$a  reason: collision with other inner class name */
        class C0258a extends IdentityApi.k {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MParticle f22401a;

            C0258a(MParticle mParticle) {
                this.f22401a = mParticle;
            }

            public void a(MParticleUser mParticleUser) {
                IdentityApi Identity = this.f22401a.Identity();
                d dVar = new d(mParticleUser);
                e eVar = e.this;
                Identity.modify(dVar.googleAdId(eVar.f22399a, eVar.f22400b).build());
            }
        }

        e(String str, String str2) {
            this.f22399a = str;
            this.f22400b = str2;
        }

        public void run() {
            MParticle instance;
            String str = this.f22399a;
            if (str != null && !str.equals(this.f22400b) && (instance = MParticle.getInstance()) != null) {
                MParticleUser currentUser = instance.Identity().getCurrentUser();
                if (currentUser != null) {
                    instance.Identity().modify(new d(currentUser).googleAdId(this.f22399a, this.f22400b).build());
                } else {
                    instance.Identity().addIdentityStateListener(new C0258a(instance));
                }
            }
        }
    }

    public a(Context context, boolean z10) {
        this.f22385d = new InternalSession();
        this.f22386e = null;
        this.f22389h = new Handler();
        this.f22390i = new AtomicInteger(0);
        this.f22392k = z10;
        this.f22383b = context.getApplicationContext();
        this.f22388g = new AtomicLong(k());
        this.f22384c = context.getSharedPreferences("mParticlePrefs", 0);
        b.a((IdentityApi.j) new C0257a());
    }

    private long k() {
        if (this.f22392k) {
            return System.currentTimeMillis();
        }
        return SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: private */
    public void m() {
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            a("app_back", this.f22387f);
            instance.Internal().c().onApplicationBackground();
            this.f22387f = null;
            Logger.debug("App backgrounded.");
            this.f22390i.incrementAndGet();
        }
    }

    private void n() {
        q();
        this.f22393l.b(this.f22385d);
        Logger.debug("Started new session");
        this.f22393l.A();
        c();
        a();
    }

    @TargetApi(14)
    private void o() {
        ((Application) this.f22383b).registerActivityLifecycleCallbacks(new e(this));
    }

    public void e() {
        if (!f22381o) {
            a((String) null, (String) null, (String) null, (String) null);
        }
        InternalSession j10 = j();
        j10.mLastEventTime = System.currentTimeMillis();
        if (!j10.isActive()) {
            n();
        } else {
            this.f22393l.c(j());
        }
    }

    public void f(Activity activity) {
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.Internal().c().onActivityStopped(activity);
        }
    }

    public String g() {
        return this.f22387f;
    }

    public String h() {
        return this.f22395n;
    }

    public Uri i() {
        return this.f22394m;
    }

    public InternalSession j() {
        return this.f22385d;
    }

    public boolean l() {
        return !f22381o || (this.f22386e == null && k() - this.f22388g.get() >= 1000);
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        InternalSession j10 = j();
        MParticle instance = MParticle.getInstance();
        if (0 == j10.mSessionStartTime || !l() || !j10.isTimedOut(this.f22382a.O()) || (instance != null && instance.Media().getAudioPlaying())) {
            return false;
        }
        return true;
    }

    public void q() {
        this.f22385d = new InternalSession().start(this.f22383b);
        this.f22388g = new AtomicLong(k());
        c();
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.Internal().c().onSessionStart();
        }
    }

    private void b() {
        this.f22384c.edit().remove("mp::location:provider").remove("mp::location:mintime").remove("mp::location:mindistance").apply();
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.disableLocationTracking();
        }
    }

    public void a(int i10) {
        if (i10 >= 14) {
            o();
        }
    }

    public void c(Activity activity) {
        try {
            this.f22384c.edit().putBoolean("mp::crashed_in_foreground", false).apply();
            this.f22388g = new AtomicLong(k());
            WeakReference<Activity> weakReference = this.f22386e;
            if (weakReference != null && activity == weakReference.get()) {
                this.f22386e.clear();
                this.f22386e = null;
            }
            this.f22389h.postDelayed(new b(), 1000);
            MParticle instance = MParticle.getInstance();
            if (instance != null) {
                if (instance.isAutoTrackingEnabled().booleanValue()) {
                    instance.logScreen(new MPEvent.Builder(a(activity)).internalNavigationDirection(false).build());
                }
                instance.Internal().c().onActivityPaused(activity);
            }
        } catch (Exception e10) {
            Logger.verbose("Failed while trying to track activity pause: " + e10.getMessage());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:25|26|27|28|29) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0092 */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0118 A[Catch:{ Exception -> 0x015b }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012a A[Catch:{ Exception -> 0x015b }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(android.app.Activity r19) {
        /*
            r18 = this;
            r12 = r18
            r0 = r19
            java.lang.String r1 = "al_applink_data"
            r13 = 1
            r14 = 0
            java.lang.String r2 = a((android.app.Activity) r19)     // Catch:{ Exception -> 0x015b }
            r12.f22387f = r2     // Catch:{ Exception -> 0x015b }
            java.util.concurrent.atomic.AtomicInteger r2 = r12.f22390i     // Catch:{ Exception -> 0x015b }
            int r11 = r2.get()     // Catch:{ Exception -> 0x015b }
            boolean r2 = f22381o     // Catch:{ Exception -> 0x015b }
            if (r2 == 0) goto L_0x0022
            com.mparticle.internal.InternalSession r2 = r18.j()     // Catch:{ Exception -> 0x015b }
            boolean r2 = r2.isActive()     // Catch:{ Exception -> 0x015b }
            if (r2 != 0) goto L_0x0029
        L_0x0022:
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger     // Catch:{ Exception -> 0x015b }
            r2.<init>(r14)     // Catch:{ Exception -> 0x015b }
            r12.f22390i = r2     // Catch:{ Exception -> 0x015b }
        L_0x0029:
            r15 = 0
            if (r0 == 0) goto L_0x00a2
            android.content.ComponentName r2 = r19.getCallingActivity()     // Catch:{ Exception -> 0x015b }
            if (r2 == 0) goto L_0x0037
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x015b }
            goto L_0x0038
        L_0x0037:
            r2 = r15
        L_0x0038:
            android.content.Intent r3 = r19.getIntent()     // Catch:{ Exception -> 0x015b }
            if (r3 == 0) goto L_0x009e
            android.content.Intent r3 = r19.getIntent()     // Catch:{ Exception -> 0x015b }
            java.lang.String r3 = r3.getDataString()     // Catch:{ Exception -> 0x015b }
            android.net.Uri r4 = r12.f22394m     // Catch:{ Exception -> 0x015b }
            if (r4 != 0) goto L_0x0054
            android.content.Intent r4 = r19.getIntent()     // Catch:{ Exception -> 0x015b }
            android.net.Uri r4 = r4.getData()     // Catch:{ Exception -> 0x015b }
            r12.f22394m = r4     // Catch:{ Exception -> 0x015b }
        L_0x0054:
            java.lang.String r4 = r12.f22395n     // Catch:{ Exception -> 0x015b }
            if (r4 != 0) goto L_0x0062
            android.content.Intent r4 = r19.getIntent()     // Catch:{ Exception -> 0x015b }
            java.lang.String r4 = r4.getAction()     // Catch:{ Exception -> 0x015b }
            r12.f22395n = r4     // Catch:{ Exception -> 0x015b }
        L_0x0062:
            android.content.Intent r4 = r19.getIntent()     // Catch:{ Exception -> 0x015b }
            android.os.Bundle r4 = r4.getExtras()     // Catch:{ Exception -> 0x015b }
            if (r4 == 0) goto L_0x009a
            android.content.Intent r4 = r19.getIntent()     // Catch:{ Exception -> 0x015b }
            android.os.Bundle r4 = r4.getExtras()     // Catch:{ Exception -> 0x015b }
            android.os.Bundle r4 = r4.getBundle(r1)     // Catch:{ Exception -> 0x015b }
            if (r4 == 0) goto L_0x009a
            org.json.b r4 = new org.json.b     // Catch:{ Exception -> 0x015b }
            r4.<init>()     // Catch:{ Exception -> 0x015b }
            android.content.Intent r5 = r19.getIntent()     // Catch:{ Exception -> 0x0092 }
            android.os.Bundle r5 = r5.getExtras()     // Catch:{ Exception -> 0x0092 }
            android.os.Bundle r5 = r5.getBundle(r1)     // Catch:{ Exception -> 0x0092 }
            org.json.b r5 = com.mparticle.internal.MPUtility.wrapExtras(r5)     // Catch:{ Exception -> 0x0092 }
            r4.put((java.lang.String) r1, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0092 }
        L_0x0092:
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x015b }
            r9 = r1
            r10 = r2
            r8 = r3
            goto L_0x00a5
        L_0x009a:
            r10 = r2
            r8 = r3
            r9 = r15
            goto L_0x00a5
        L_0x009e:
            r10 = r2
            r8 = r15
            r9 = r8
            goto L_0x00a5
        L_0x00a2:
            r8 = r15
            r9 = r8
            r10 = r9
        L_0x00a5:
            com.mparticle.internal.InternalSession r1 = r12.f22385d     // Catch:{ Exception -> 0x015b }
            java.util.concurrent.atomic.AtomicLong r2 = r12.f22388g     // Catch:{ Exception -> 0x015b }
            long r3 = r18.k()     // Catch:{ Exception -> 0x015b }
            r1.updateBackgroundTime(r2, r3)     // Catch:{ Exception -> 0x015b }
            boolean r1 = f22381o     // Catch:{ Exception -> 0x015b }
            if (r1 != 0) goto L_0x00ba
            java.lang.String r1 = r12.f22387f     // Catch:{ Exception -> 0x015b }
            r12.a(r1, r8, r9, r10)     // Catch:{ Exception -> 0x015b }
            goto L_0x010d
        L_0x00ba:
            boolean r1 = r18.l()     // Catch:{ Exception -> 0x015b }
            if (r1 == 0) goto L_0x010d
            java.util.concurrent.atomic.AtomicLong r1 = r12.f22388g     // Catch:{ Exception -> 0x015b }
            long r1 = r1.get()     // Catch:{ Exception -> 0x015b }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x010d
            android.content.Context r1 = r12.f22383b     // Catch:{ Exception -> 0x015b }
            com.mparticle.internal.MPUtility$AdIdInfo r1 = com.mparticle.internal.MPUtility.getAdIdInfo(r1)     // Catch:{ Exception -> 0x015b }
            if (r1 != 0) goto L_0x00d5
            goto L_0x00d9
        L_0x00d5:
            boolean r2 = r1.isLimitAdTrackingEnabled     // Catch:{ Exception -> 0x015b }
            if (r2 == 0) goto L_0x00db
        L_0x00d9:
            r1 = r15
            goto L_0x00dd
        L_0x00db:
            java.lang.String r1 = r1.f22362id     // Catch:{ Exception -> 0x015b }
        L_0x00dd:
            com.mparticle.internal.j r2 = r12.f22393l     // Catch:{ Exception -> 0x015b }
            com.mparticle.internal.a$e r3 = new com.mparticle.internal.a$e     // Catch:{ Exception -> 0x015b }
            com.mparticle.internal.b r4 = r12.f22382a     // Catch:{ Exception -> 0x015b }
            java.lang.String r4 = r4.I()     // Catch:{ Exception -> 0x015b }
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x015b }
            r2.a((java.lang.Runnable) r3)     // Catch:{ Exception -> 0x015b }
            java.lang.String r2 = "app_fore"
            java.lang.String r3 = r12.f22387f     // Catch:{ Exception -> 0x015b }
            java.util.concurrent.atomic.AtomicLong r1 = r12.f22388g     // Catch:{ Exception -> 0x015b }
            long r4 = r1.get()     // Catch:{ Exception -> 0x015b }
            long r6 = r12.f22391j     // Catch:{ Exception -> 0x015b }
            long r4 = r4 - r6
            long r6 = r18.k()     // Catch:{ Exception -> 0x015b }
            java.util.concurrent.atomic.AtomicLong r1 = r12.f22388g     // Catch:{ Exception -> 0x015b }
            long r16 = r1.get()     // Catch:{ Exception -> 0x015b }
            long r6 = r6 - r16
            r1 = r18
            r1.a(r2, r3, r4, r6, r8, r9, r10, r11)     // Catch:{ Exception -> 0x015b }
            r1 = r13
            goto L_0x010e
        L_0x010d:
            r1 = r14
        L_0x010e:
            long r2 = r18.k()     // Catch:{ Exception -> 0x015b }
            r12.f22391j = r2     // Catch:{ Exception -> 0x015b }
            java.lang.ref.WeakReference<android.app.Activity> r2 = r12.f22386e     // Catch:{ Exception -> 0x015b }
            if (r2 == 0) goto L_0x011d
            r2.clear()     // Catch:{ Exception -> 0x015b }
            r12.f22386e = r15     // Catch:{ Exception -> 0x015b }
        L_0x011d:
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x015b }
            r2.<init>(r0)     // Catch:{ Exception -> 0x015b }
            r12.f22386e = r2     // Catch:{ Exception -> 0x015b }
            com.mparticle.MParticle r2 = com.mparticle.MParticle.getInstance()     // Catch:{ Exception -> 0x015b }
            if (r2 == 0) goto L_0x0178
            java.lang.Boolean r3 = r2.isAutoTrackingEnabled()     // Catch:{ Exception -> 0x015b }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x015b }
            if (r3 == 0) goto L_0x0139
            java.lang.String r3 = r12.f22387f     // Catch:{ Exception -> 0x015b }
            r2.logScreen((java.lang.String) r3)     // Catch:{ Exception -> 0x015b }
        L_0x0139:
            if (r1 == 0) goto L_0x014f
            com.mparticle.MParticle$e r1 = r2.Internal()     // Catch:{ Exception -> 0x015b }
            com.mparticle.internal.d r1 = r1.c()     // Catch:{ Exception -> 0x015b }
            r1.onApplicationForeground()     // Catch:{ Exception -> 0x015b }
            java.lang.String r1 = "App foregrounded."
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x015b }
            com.mparticle.internal.Logger.debug(r1)     // Catch:{ Exception -> 0x015b }
        L_0x014f:
            com.mparticle.MParticle$e r1 = r2.Internal()     // Catch:{ Exception -> 0x015b }
            com.mparticle.internal.d r1 = r1.c()     // Catch:{ Exception -> 0x015b }
            r1.onActivityResumed(r0)     // Catch:{ Exception -> 0x015b }
            goto L_0x0178
        L_0x015b:
            r0 = move-exception
            java.lang.String[] r1 = new java.lang.String[r13]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed while trying to track activity resume: "
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1[r14] = r0
            com.mparticle.internal.Logger.verbose(r1)
        L_0x0178:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.a.d(android.app.Activity):void");
    }

    public void a(b bVar) {
        this.f22382a = bVar;
    }

    public WeakReference<Activity> f() {
        return this.f22386e;
    }

    public void a(j jVar) {
        this.f22393l = jVar;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, long j10, long j11, String str3, String str4, String str5, int i10) {
        if (this.f22382a.V()) {
            e();
            this.f22393l.a(str, str2, str3, str4, str5, j10, j11, i10);
        }
    }

    public void a(String str, String str2) {
        a(str, str2, 0, 0, (String) null, (String) null, (String) null, 0);
    }

    public void e(Activity activity) {
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.Internal().c().onActivityStarted(activity);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f22389h.postDelayed(new c(), (long) this.f22382a.O());
    }

    public void b(Activity activity, Bundle bundle) {
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.Internal().c().onActivitySaveInstanceState(activity, bundle);
        }
    }

    public a(Context context) {
        this(context, false);
    }

    public void b(Activity activity) {
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.Internal().c().onActivityDestroyed(activity);
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        f22381o = true;
        a("app_init", str, 0, 0, str2, str3, str4, 0);
    }

    public void a(Activity activity, Bundle bundle) {
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.Internal().c().onActivityCreated(activity, bundle);
        }
    }

    private static String a(Activity activity) {
        return activity.getClass().getCanonicalName();
    }

    private void c() {
        MParticle instance;
        if (this.f22384c.contains("mp::location:provider")) {
            String string = this.f22384c.getString("mp::location:provider", (String) null);
            long j10 = this.f22384c.getLong("mp::location:mintime", 0);
            long j11 = this.f22384c.getLong("mp::location:mindistance", 0);
            if (string != null && j10 > 0 && j11 > 0 && (instance = MParticle.getInstance()) != null) {
                instance.enableLocationTracking(string, j10, j11);
            }
        }
    }

    public void d() {
        Logger.debug("Ended session");
        this.f22393l.a(this.f22385d);
        b();
        this.f22385d = new InternalSession();
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.Internal().c().onSessionEnd();
        }
        InternalListenerManager.getListener().onSessionUpdated(this.f22385d);
    }
}
