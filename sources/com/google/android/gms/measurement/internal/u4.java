package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzib;
import com.google.firebase.messaging.Constants;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import me.f;
import me.i;
import oe.d;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.b;
import we.m;

public final class u4 implements p5 {
    private static volatile u4 H;
    private volatile Boolean A;
    protected Boolean B;
    protected Boolean C;
    private volatile boolean D;
    private int E;
    private final AtomicInteger F = new AtomicInteger(0);
    final long G;

    /* renamed from: a  reason: collision with root package name */
    private final Context f40301a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40302b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40303c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40304d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f40305e;

    /* renamed from: f  reason: collision with root package name */
    private final c f40306f;

    /* renamed from: g  reason: collision with root package name */
    private final g f40307g;

    /* renamed from: h  reason: collision with root package name */
    private final e4 f40308h;

    /* renamed from: i  reason: collision with root package name */
    private final q3 f40309i;

    /* renamed from: j  reason: collision with root package name */
    private final s4 f40310j;

    /* renamed from: k  reason: collision with root package name */
    private final w8 f40311k;

    /* renamed from: l  reason: collision with root package name */
    private final t9 f40312l;

    /* renamed from: m  reason: collision with root package name */
    private final l3 f40313m;

    /* renamed from: n  reason: collision with root package name */
    private final f f40314n;

    /* renamed from: o  reason: collision with root package name */
    private final g7 f40315o;

    /* renamed from: p  reason: collision with root package name */
    private final u6 f40316p;

    /* renamed from: q  reason: collision with root package name */
    private final z1 f40317q;

    /* renamed from: r  reason: collision with root package name */
    private final x6 f40318r;

    /* renamed from: s  reason: collision with root package name */
    private final String f40319s;

    /* renamed from: t  reason: collision with root package name */
    private k3 f40320t;

    /* renamed from: u  reason: collision with root package name */
    private g8 f40321u;

    /* renamed from: v  reason: collision with root package name */
    private o f40322v;

    /* renamed from: w  reason: collision with root package name */
    private i3 f40323w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f40324x = false;

    /* renamed from: y  reason: collision with root package name */
    private Boolean f40325y;

    /* renamed from: z  reason: collision with root package name */
    private long f40326z;

    u4(s5 s5Var) {
        long j10;
        Bundle bundle;
        boolean z10 = false;
        p.k(s5Var);
        Context context = s5Var.f40249a;
        c cVar = new c(context);
        this.f40306f = cVar;
        e3.f39736a = cVar;
        this.f40301a = context;
        this.f40302b = s5Var.f40250b;
        this.f40303c = s5Var.f40251c;
        this.f40304d = s5Var.f40252d;
        this.f40305e = s5Var.f40256h;
        this.A = s5Var.f40253e;
        this.f40319s = s5Var.f40258j;
        this.D = true;
        zzcl zzcl = s5Var.f40255g;
        if (!(zzcl == null || (bundle = zzcl.zzg) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.B = (Boolean) obj;
            }
            Object obj2 = zzcl.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.C = (Boolean) obj2;
            }
        }
        zzib.zzd(context);
        f c10 = i.c();
        this.f40314n = c10;
        Long l10 = s5Var.f40257i;
        if (l10 != null) {
            j10 = l10.longValue();
        } else {
            j10 = c10.currentTimeMillis();
        }
        this.G = j10;
        this.f40307g = new g(this);
        e4 e4Var = new e4(this);
        e4Var.l();
        this.f40308h = e4Var;
        q3 q3Var = new q3(this);
        q3Var.l();
        this.f40309i = q3Var;
        t9 t9Var = new t9(this);
        t9Var.l();
        this.f40312l = t9Var;
        this.f40313m = new l3(new r5(s5Var, this));
        this.f40317q = new z1(this);
        g7 g7Var = new g7(this);
        g7Var.j();
        this.f40315o = g7Var;
        u6 u6Var = new u6(this);
        u6Var.j();
        this.f40316p = u6Var;
        w8 w8Var = new w8(this);
        w8Var.j();
        this.f40311k = w8Var;
        x6 x6Var = new x6(this);
        x6Var.l();
        this.f40318r = x6Var;
        s4 s4Var = new s4(this);
        s4Var.l();
        this.f40310j = s4Var;
        zzcl zzcl2 = s5Var.f40255g;
        z10 = (zzcl2 == null || zzcl2.zzb == 0) ? true : z10;
        if (context.getApplicationContext() instanceof Application) {
            u6 I = I();
            if (I.f40059a.f40301a.getApplicationContext() instanceof Application) {
                Application application = (Application) I.f40059a.f40301a.getApplicationContext();
                if (I.f40329c == null) {
                    I.f40329c = new t6(I);
                }
                if (z10) {
                    application.unregisterActivityLifecycleCallbacks(I.f40329c);
                    application.registerActivityLifecycleCallbacks(I.f40329c);
                    I.f40059a.d().v().a("Registered activity lifecycle callback");
                }
            }
        } else {
            d().w().a("Application context is not an Application");
        }
        s4Var.z(new t4(this, s5Var));
    }

    public static u4 H(Context context, zzcl zzcl, Long l10) {
        Bundle bundle;
        if (zzcl != null && (zzcl.zze == null || zzcl.zzf == null)) {
            zzcl = new zzcl(zzcl.zza, zzcl.zzb, zzcl.zzc, zzcl.zzd, (String) null, (String) null, zzcl.zzg, (String) null);
        }
        p.k(context);
        p.k(context.getApplicationContext());
        if (H == null) {
            synchronized (u4.class) {
                if (H == null) {
                    H = new u4(new s5(context, zzcl, l10));
                }
            }
        } else if (!(zzcl == null || (bundle = zzcl.zzg) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            p.k(H);
            H.A = Boolean.valueOf(zzcl.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        p.k(H);
        return H;
    }

    static /* bridge */ /* synthetic */ void e(u4 u4Var, s5 s5Var) {
        u4Var.f().h();
        u4Var.f40307g.w();
        o oVar = new o(u4Var);
        oVar.l();
        u4Var.f40322v = oVar;
        i3 i3Var = new i3(u4Var, s5Var.f40254f);
        i3Var.j();
        u4Var.f40323w = i3Var;
        k3 k3Var = new k3(u4Var);
        k3Var.j();
        u4Var.f40320t = k3Var;
        g8 g8Var = new g8(u4Var);
        g8Var.j();
        u4Var.f40321u = g8Var;
        u4Var.f40312l.m();
        u4Var.f40308h.m();
        u4Var.f40323w.k();
        o3 u10 = u4Var.d().u();
        u4Var.f40307g.q();
        u10.b("App measurement initialized, version", 79000L);
        u4Var.d().u().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String s10 = i3Var.s();
        if (TextUtils.isEmpty(u4Var.f40302b)) {
            if (u4Var.N().U(s10)) {
                u4Var.d().u().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                u4Var.d().u().a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(s10)));
            }
        }
        u4Var.d().q().a("Debug-level message logging enabled");
        if (u4Var.E != u4Var.F.get()) {
            u4Var.d().r().c("Not all components initialized", Integer.valueOf(u4Var.E), Integer.valueOf(u4Var.F.get()));
        }
        u4Var.f40324x = true;
    }

    static final void t() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void u(n5 n5Var) {
        if (n5Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void v(w3 w3Var) {
        if (w3Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!w3Var.m()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(w3Var.getClass())));
        }
    }

    private static final void w(o5 o5Var) {
        if (o5Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!o5Var.n()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(o5Var.getClass())));
        }
    }

    @Pure
    public final o A() {
        w(this.f40322v);
        return this.f40322v;
    }

    @Pure
    public final i3 B() {
        v(this.f40323w);
        return this.f40323w;
    }

    @Pure
    public final k3 C() {
        v(this.f40320t);
        return this.f40320t;
    }

    @Pure
    public final l3 D() {
        return this.f40313m;
    }

    public final q3 E() {
        q3 q3Var = this.f40309i;
        if (q3Var == null || !q3Var.n()) {
            return null;
        }
        return q3Var;
    }

    @Pure
    public final e4 F() {
        u(this.f40308h);
        return this.f40308h;
    }

    /* access modifiers changed from: package-private */
    @SideEffectFree
    public final s4 G() {
        return this.f40310j;
    }

    @Pure
    public final u6 I() {
        v(this.f40316p);
        return this.f40316p;
    }

    @Pure
    public final x6 J() {
        w(this.f40318r);
        return this.f40318r;
    }

    @Pure
    public final g7 K() {
        v(this.f40315o);
        return this.f40315o;
    }

    @Pure
    public final g8 L() {
        v(this.f40321u);
        return this.f40321u;
    }

    @Pure
    public final w8 M() {
        v(this.f40311k);
        return this.f40311k;
    }

    @Pure
    public final t9 N() {
        u(this.f40312l);
        return this.f40312l;
    }

    @Pure
    public final String O() {
        return this.f40302b;
    }

    @Pure
    public final String P() {
        return this.f40303c;
    }

    @Pure
    public final String Q() {
        return this.f40304d;
    }

    @Pure
    public final String R() {
        return this.f40319s;
    }

    @Pure
    public final f a() {
        return this.f40314n;
    }

    @Pure
    public final c b() {
        return this.f40306f;
    }

    @Pure
    public final Context c() {
        return this.f40301a;
    }

    @Pure
    public final q3 d() {
        w(this.f40309i);
        return this.f40309i;
    }

    @Pure
    public final s4 f() {
        w(this.f40310j);
        return this.f40310j;
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        this.F.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h(String str, int i10, Throwable th2, byte[] bArr, Map map) {
        if (!(i10 == 200 || i10 == 204)) {
            if (i10 == 304) {
                i10 = 304;
            }
            d().w().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i10), th2);
        }
        if (th2 == null) {
            F().f39754s.a(true);
            if (bArr == null || bArr.length == 0) {
                d().q().a("Deferred Deep Link response empty.");
                return;
            }
            try {
                b bVar = new b(new String(bArr));
                String optString = bVar.optString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "");
                String optString2 = bVar.optString("gclid", "");
                double optDouble = bVar.optDouble("timestamp", 0.0d);
                if (TextUtils.isEmpty(optString)) {
                    d().q().a("Deferred Deep Link is empty.");
                    return;
                }
                t9 N = N();
                u4 u4Var = N.f40059a;
                if (!TextUtils.isEmpty(optString)) {
                    List<ResolveInfo> queryIntentActivities = N.f40059a.f40301a.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.f40316p.u("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                        t9 N2 = N();
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = N2.f40059a.f40301a.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, optString);
                                edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                                if (edit.commit()) {
                                    N2.f40059a.f40301a.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    return;
                                }
                                return;
                            } catch (RuntimeException e10) {
                                N2.f40059a.d().r().b("Failed to persist Deferred Deep Link. exception", e10);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                d().w().c("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e11) {
                d().r().b("Failed to parse the Deferred Deep Link response. exception", e11);
                return;
            }
        }
        d().w().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i10), th2);
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        this.E++;
    }

    public final void j() {
        f().h();
        w(J());
        String s10 = B().s();
        Pair p10 = F().p(s10);
        if (!this.f40307g.A() || ((Boolean) p10.second).booleanValue() || TextUtils.isEmpty((CharSequence) p10.first)) {
            d().q().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        x6 J = J();
        J.k();
        ConnectivityManager connectivityManager = (ConnectivityManager) J.f40059a.f40301a.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            d().w().a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        t9 N = N();
        B().f40059a.f40307g.q();
        URL s11 = N.s(79000, s10, (String) p10.first, F().f39755t.a() - 1);
        if (s11 != null) {
            x6 J2 = J();
            m mVar = new m(this);
            J2.h();
            J2.k();
            p.k(s11);
            p.k(mVar);
            J2.f40059a.f().y(new w6(J2, s10, s11, (byte[]) null, (Map) null, mVar));
        }
    }

    /* access modifiers changed from: package-private */
    public final void k(boolean z10) {
        this.A = Boolean.valueOf(z10);
    }

    public final void l(boolean z10) {
        f().h();
        this.D = z10;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
        if (r8.l() == false) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(com.google.android.gms.internal.measurement.zzcl r8) {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.s4 r0 = r7.f()
            r0.h()
            com.google.android.gms.measurement.internal.e4 r0 = r7.F()
            we.o r0 = r0.q()
            int r1 = r0.a()
            com.google.android.gms.measurement.internal.g r2 = r7.f40307g
            com.google.android.gms.measurement.internal.u4 r3 = r2.f40059a
            java.lang.String r3 = "google_analytics_default_allow_ad_storage"
            java.lang.Boolean r2 = r2.t(r3)
            com.google.android.gms.measurement.internal.g r3 = r7.f40307g
            com.google.android.gms.measurement.internal.u4 r4 = r3.f40059a
            java.lang.String r4 = "google_analytics_default_allow_analytics_storage"
            java.lang.Boolean r3 = r3.t(r4)
            r4 = -10
            r5 = 0
            if (r2 != 0) goto L_0x002e
            if (r3 == 0) goto L_0x003e
        L_0x002e:
            com.google.android.gms.measurement.internal.e4 r6 = r7.F()
            boolean r6 = r6.w(r4)
            if (r6 == 0) goto L_0x003e
            we.o r8 = new we.o
            r8.<init>(r2, r3, r4)
            goto L_0x0098
        L_0x003e:
            com.google.android.gms.measurement.internal.i3 r2 = r7.B()
            java.lang.String r2 = r2.t()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 30
            if (r2 != 0) goto L_0x006d
            if (r1 == 0) goto L_0x005e
            if (r1 == r3) goto L_0x005e
            r2 = 10
            if (r1 == r2) goto L_0x005e
            if (r1 == r3) goto L_0x005e
            if (r1 == r3) goto L_0x005e
            r2 = 40
            if (r1 != r2) goto L_0x006d
        L_0x005e:
            com.google.android.gms.measurement.internal.u6 r8 = r7.I()
            we.o r1 = new we.o
            r1.<init>(r5, r5, r4)
            long r2 = r7.G
            r8.F(r1, r2)
            goto L_0x0097
        L_0x006d:
            com.google.android.gms.measurement.internal.i3 r1 = r7.B()
            java.lang.String r1 = r1.t()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0097
            if (r8 == 0) goto L_0x0097
            android.os.Bundle r1 = r8.zzg
            if (r1 == 0) goto L_0x0097
            com.google.android.gms.measurement.internal.e4 r1 = r7.F()
            boolean r1 = r1.w(r3)
            if (r1 == 0) goto L_0x0097
            android.os.Bundle r8 = r8.zzg
            we.o r8 = we.o.b(r8, r3)
            boolean r1 = r8.l()
            if (r1 != 0) goto L_0x0098
        L_0x0097:
            r8 = r5
        L_0x0098:
            if (r8 == 0) goto L_0x00a4
            com.google.android.gms.measurement.internal.u6 r0 = r7.I()
            long r1 = r7.G
            r0.F(r8, r1)
            r0 = r8
        L_0x00a4:
            com.google.android.gms.measurement.internal.u6 r8 = r7.I()
            r8.J(r0)
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            com.google.android.gms.measurement.internal.b4 r8 = r8.f39740e
            long r0 = r8.a()
            r2 = 0
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.q3 r8 = r7.d()
            com.google.android.gms.measurement.internal.o3 r8 = r8.v()
            long r0 = r7.G
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "Persisting first open"
            r8.b(r1, r0)
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            com.google.android.gms.measurement.internal.b4 r8 = r8.f39740e
            long r0 = r7.G
            r8.b(r0)
        L_0x00d9:
            com.google.android.gms.measurement.internal.u6 r8 = r7.I()
            com.google.android.gms.measurement.internal.z9 r8 = r8.f40338l
            r8.c()
            boolean r8 = r7.r()
            if (r8 != 0) goto L_0x016e
            boolean r8 = r7.o()
            if (r8 == 0) goto L_0x0329
            com.google.android.gms.measurement.internal.t9 r8 = r7.N()
            java.lang.String r0 = "android.permission.INTERNET"
            boolean r8 = r8.T(r0)
            if (r8 != 0) goto L_0x0107
            com.google.android.gms.measurement.internal.q3 r8 = r7.d()
            com.google.android.gms.measurement.internal.o3 r8 = r8.r()
            java.lang.String r0 = "App is missing INTERNET permission"
            r8.a(r0)
        L_0x0107:
            com.google.android.gms.measurement.internal.t9 r8 = r7.N()
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r8 = r8.T(r0)
            if (r8 != 0) goto L_0x0120
            com.google.android.gms.measurement.internal.q3 r8 = r7.d()
            com.google.android.gms.measurement.internal.o3 r8 = r8.r()
            java.lang.String r0 = "App is missing ACCESS_NETWORK_STATE permission"
            r8.a(r0)
        L_0x0120:
            android.content.Context r8 = r7.f40301a
            oe.c r8 = oe.d.a(r8)
            boolean r8 = r8.f()
            if (r8 != 0) goto L_0x015f
            com.google.android.gms.measurement.internal.g r8 = r7.f40307g
            boolean r8 = r8.G()
            if (r8 != 0) goto L_0x015f
            android.content.Context r8 = r7.f40301a
            boolean r8 = com.google.android.gms.measurement.internal.t9.a0(r8)
            if (r8 != 0) goto L_0x0149
            com.google.android.gms.measurement.internal.q3 r8 = r7.d()
            com.google.android.gms.measurement.internal.o3 r8 = r8.r()
            java.lang.String r0 = "AppMeasurementReceiver not registered/enabled"
            r8.a(r0)
        L_0x0149:
            android.content.Context r8 = r7.f40301a
            r0 = 0
            boolean r8 = com.google.android.gms.measurement.internal.t9.b0(r8, r0)
            if (r8 != 0) goto L_0x015f
            com.google.android.gms.measurement.internal.q3 r8 = r7.d()
            com.google.android.gms.measurement.internal.o3 r8 = r8.r()
            java.lang.String r0 = "AppMeasurementService not registered/enabled"
            r8.a(r0)
        L_0x015f:
            com.google.android.gms.measurement.internal.q3 r8 = r7.d()
            com.google.android.gms.measurement.internal.o3 r8 = r8.r()
            java.lang.String r0 = "Uploading is not possible. App measurement disabled"
            r8.a(r0)
            goto L_0x0329
        L_0x016e:
            com.google.android.gms.measurement.internal.i3 r8 = r7.B()
            java.lang.String r8 = r8.t()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x018a
            com.google.android.gms.measurement.internal.i3 r8 = r7.B()
            java.lang.String r8 = r8.r()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0250
        L_0x018a:
            com.google.android.gms.measurement.internal.t9 r8 = r7.N()
            com.google.android.gms.measurement.internal.i3 r0 = r7.B()
            java.lang.String r0 = r0.t()
            com.google.android.gms.measurement.internal.e4 r1 = r7.F()
            r1.h()
            android.content.SharedPreferences r1 = r1.o()
            java.lang.String r2 = "gmp_app_id"
            java.lang.String r1 = r1.getString(r2, r5)
            com.google.android.gms.measurement.internal.i3 r3 = r7.B()
            java.lang.String r3 = r3.r()
            com.google.android.gms.measurement.internal.e4 r4 = r7.F()
            r4.h()
            android.content.SharedPreferences r4 = r4.o()
            java.lang.String r6 = "admob_app_id"
            java.lang.String r4 = r4.getString(r6, r5)
            boolean r8 = r8.d0(r0, r1, r3, r4)
            if (r8 == 0) goto L_0x0216
            com.google.android.gms.measurement.internal.q3 r8 = r7.d()
            com.google.android.gms.measurement.internal.o3 r8 = r8.u()
            java.lang.String r0 = "Rechecking which service to use due to a GMP App Id change"
            r8.a(r0)
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            r8.h()
            java.lang.Boolean r0 = r8.r()
            android.content.SharedPreferences r1 = r8.o()
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.clear()
            r1.apply()
            if (r0 == 0) goto L_0x01f1
            r8.s(r0)
        L_0x01f1:
            com.google.android.gms.measurement.internal.k3 r8 = r7.C()
            r8.q()
            com.google.android.gms.measurement.internal.g8 r8 = r7.f40321u
            r8.Q()
            com.google.android.gms.measurement.internal.g8 r8 = r7.f40321u
            r8.P()
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            com.google.android.gms.measurement.internal.b4 r8 = r8.f39740e
            long r0 = r7.G
            r8.b(r0)
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            com.google.android.gms.measurement.internal.d4 r8 = r8.f39742g
            r8.b(r5)
        L_0x0216:
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            com.google.android.gms.measurement.internal.i3 r0 = r7.B()
            java.lang.String r0 = r0.t()
            r8.h()
            android.content.SharedPreferences r8 = r8.o()
            android.content.SharedPreferences$Editor r8 = r8.edit()
            r8.putString(r2, r0)
            r8.apply()
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            com.google.android.gms.measurement.internal.i3 r0 = r7.B()
            java.lang.String r0 = r0.r()
            r8.h()
            android.content.SharedPreferences r8 = r8.o()
            android.content.SharedPreferences$Editor r8 = r8.edit()
            r8.putString(r6, r0)
            r8.apply()
        L_0x0250:
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            we.o r8 = r8.q()
            com.google.android.gms.measurement.internal.zzha r0 = com.google.android.gms.measurement.internal.zzha.ANALYTICS_STORAGE
            boolean r8 = r8.j(r0)
            if (r8 != 0) goto L_0x0269
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            com.google.android.gms.measurement.internal.d4 r8 = r8.f39742g
            r8.b(r5)
        L_0x0269:
            com.google.android.gms.measurement.internal.u6 r8 = r7.I()
            com.google.android.gms.measurement.internal.e4 r0 = r7.F()
            com.google.android.gms.measurement.internal.d4 r0 = r0.f39742g
            java.lang.String r0 = r0.a()
            r8.C(r0)
            com.google.android.gms.internal.measurement.zzos.zzc()
            com.google.android.gms.measurement.internal.g r8 = r7.f40307g
            com.google.android.gms.measurement.internal.f3 r0 = com.google.android.gms.measurement.internal.g3.f39818g0
            boolean r8 = r8.B(r5, r0)
            if (r8 == 0) goto L_0x02bf
            com.google.android.gms.measurement.internal.t9 r8 = r7.N()
            com.google.android.gms.measurement.internal.u4 r8 = r8.f40059a     // Catch:{ ClassNotFoundException -> 0x0299 }
            android.content.Context r8 = r8.f40301a     // Catch:{ ClassNotFoundException -> 0x0299 }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0299 }
            java.lang.String r0 = "com.google.firebase.remoteconfig.FirebaseRemoteConfig"
            r8.loadClass(r0)     // Catch:{ ClassNotFoundException -> 0x0299 }
            goto L_0x02bf
        L_0x0299:
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            com.google.android.gms.measurement.internal.d4 r8 = r8.f39756u
            java.lang.String r8 = r8.a()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x02bf
            com.google.android.gms.measurement.internal.q3 r8 = r7.d()
            com.google.android.gms.measurement.internal.o3 r8 = r8.w()
            java.lang.String r0 = "Remote config removed with active feature rollouts"
            r8.a(r0)
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            com.google.android.gms.measurement.internal.d4 r8 = r8.f39756u
            r8.b(r5)
        L_0x02bf:
            com.google.android.gms.measurement.internal.i3 r8 = r7.B()
            java.lang.String r8 = r8.t()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x02db
            com.google.android.gms.measurement.internal.i3 r8 = r7.B()
            java.lang.String r8 = r8.r()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0329
        L_0x02db:
            boolean r8 = r7.o()
            com.google.android.gms.measurement.internal.e4 r0 = r7.F()
            boolean r0 = r0.u()
            if (r0 != 0) goto L_0x02fa
            com.google.android.gms.measurement.internal.g r0 = r7.f40307g
            boolean r0 = r0.E()
            if (r0 != 0) goto L_0x02fa
            com.google.android.gms.measurement.internal.e4 r0 = r7.F()
            r1 = r8 ^ 1
            r0.t(r1)
        L_0x02fa:
            if (r8 == 0) goto L_0x0303
            com.google.android.gms.measurement.internal.u6 r8 = r7.I()
            r8.f0()
        L_0x0303:
            com.google.android.gms.measurement.internal.w8 r8 = r7.M()
            com.google.android.gms.measurement.internal.v8 r8 = r8.f40393e
            r8.a()
            com.google.android.gms.measurement.internal.g8 r8 = r7.L()
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            r8.S(r0)
            com.google.android.gms.measurement.internal.g8 r8 = r7.L()
            com.google.android.gms.measurement.internal.e4 r0 = r7.F()
            com.google.android.gms.measurement.internal.a4 r0 = r0.f39759x
            android.os.Bundle r0 = r0.a()
            r8.v(r0)
        L_0x0329:
            com.google.android.gms.measurement.internal.e4 r8 = r7.F()
            com.google.android.gms.measurement.internal.z3 r8 = r8.f39749n
            r0 = 1
            r8.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.u4.m(com.google.android.gms.internal.measurement.zzcl):void");
    }

    public final boolean n() {
        return this.A != null && this.A.booleanValue();
    }

    public final boolean o() {
        return x() == 0;
    }

    public final boolean p() {
        f().h();
        return this.D;
    }

    @Pure
    public final boolean q() {
        return TextUtils.isEmpty(this.f40302b);
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        boolean z10;
        if (this.f40324x) {
            f().h();
            Boolean bool = this.f40325y;
            if (bool == null || this.f40326z == 0 || (!bool.booleanValue() && Math.abs(this.f40314n.b() - this.f40326z) > 1000)) {
                this.f40326z = this.f40314n.b();
                boolean z11 = true;
                if (!N().T("android.permission.INTERNET") || !N().T("android.permission.ACCESS_NETWORK_STATE") || (!d.a(this.f40301a).f() && !this.f40307g.G() && (!t9.a0(this.f40301a) || !t9.b0(this.f40301a, false)))) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                Boolean valueOf = Boolean.valueOf(z10);
                this.f40325y = valueOf;
                if (valueOf.booleanValue()) {
                    if (!N().M(B().t(), B().r()) && TextUtils.isEmpty(B().r())) {
                        z11 = false;
                    }
                    this.f40325y = Boolean.valueOf(z11);
                }
            }
            return this.f40325y.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @Pure
    public final boolean s() {
        return this.f40305e;
    }

    public final int x() {
        f().h();
        if (this.f40307g.E()) {
            return 1;
        }
        Boolean bool = this.C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        f().h();
        if (!this.D) {
            return 8;
        }
        Boolean r10 = F().r();
        if (r10 == null) {
            g gVar = this.f40307g;
            c cVar = gVar.f40059a.f40306f;
            Boolean t10 = gVar.t("firebase_analytics_collection_enabled");
            if (t10 == null) {
                Boolean bool2 = this.B;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (this.A == null || this.A.booleanValue()) {
                    return 0;
                } else {
                    return 7;
                }
            } else if (t10.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (r10.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    @Pure
    public final z1 y() {
        z1 z1Var = this.f40317q;
        if (z1Var != null) {
            return z1Var;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final g z() {
        return this.f40307g;
    }
}
