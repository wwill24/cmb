package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import we.w;

public final class g7 extends w3 {

    /* renamed from: c  reason: collision with root package name */
    private volatile z6 f39867c;

    /* renamed from: d  reason: collision with root package name */
    private volatile z6 f39868d;

    /* renamed from: e  reason: collision with root package name */
    protected z6 f39869e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f39870f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private Activity f39871g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f39872h;

    /* renamed from: i  reason: collision with root package name */
    private volatile z6 f39873i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public z6 f39874j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f39875k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f39876l = new Object();

    public g7(u4 u4Var) {
        super(u4Var);
    }

    private final z6 F(@NonNull Activity activity) {
        p.k(activity);
        z6 z6Var = (z6) this.f39870f.get(activity);
        if (z6Var == null) {
            z6 z6Var2 = new z6((String) null, t(activity.getClass(), "Activity"), this.f40059a.N().t0());
            this.f39870f.put(activity, z6Var2);
            z6Var = z6Var2;
        }
        if (this.f39873i != null) {
            return this.f39873i;
        }
        return z6Var;
    }

    private final void G(Activity activity, z6 z6Var, boolean z10) {
        z6 z6Var2;
        z6 z6Var3;
        String str;
        z6 z6Var4 = z6Var;
        if (this.f39867c == null) {
            z6Var2 = this.f39868d;
        } else {
            z6Var2 = this.f39867c;
        }
        z6 z6Var5 = z6Var2;
        if (z6Var4.f40464b == null) {
            if (activity != null) {
                str = t(activity.getClass(), "Activity");
            } else {
                str = null;
            }
            z6Var3 = new z6(z6Var4.f40463a, str, z6Var4.f40465c, z6Var4.f40467e, z6Var4.f40468f);
        } else {
            z6Var3 = z6Var4;
        }
        this.f39868d = this.f39867c;
        this.f39867c = z6Var3;
        this.f40059a.f().z(new b7(this, z6Var3, z6Var5, this.f40059a.a().b(), z10));
    }

    /* access modifiers changed from: private */
    public final void o(z6 z6Var, z6 z6Var2, long j10, boolean z10, Bundle bundle) {
        boolean z11;
        Bundle bundle2;
        String str;
        long j11;
        long j12;
        z6 z6Var3 = z6Var;
        z6 z6Var4 = z6Var2;
        long j13 = j10;
        Bundle bundle3 = bundle;
        h();
        boolean z12 = false;
        if (z6Var4 == null || z6Var4.f40465c != z6Var3.f40465c || !w.a(z6Var4.f40464b, z6Var3.f40464b) || !w.a(z6Var4.f40463a, z6Var3.f40463a)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && this.f39869e != null) {
            z12 = true;
        }
        if (z11) {
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle4 = bundle2;
            t9.y(z6Var3, bundle4, true);
            if (z6Var4 != null) {
                String str2 = z6Var4.f40463a;
                if (str2 != null) {
                    bundle4.putString("_pn", str2);
                }
                String str3 = z6Var4.f40464b;
                if (str3 != null) {
                    bundle4.putString("_pc", str3);
                }
                bundle4.putLong("_pi", z6Var4.f40465c);
            }
            if (z12) {
                u8 u8Var = this.f40059a.M().f40394f;
                long j14 = j13 - u8Var.f40344b;
                u8Var.f40344b = j13;
                if (j14 > 0) {
                    this.f40059a.N().w(bundle4, j14);
                }
            }
            if (!this.f40059a.z().D()) {
                bundle4.putLong("_mst", 1);
            }
            if (true != z6Var3.f40467e) {
                str = "auto";
            } else {
                str = "app";
            }
            String str4 = str;
            long currentTimeMillis = this.f40059a.a().currentTimeMillis();
            if (z6Var3.f40467e) {
                j12 = currentTimeMillis;
                long j15 = z6Var3.f40468f;
                if (j15 != 0) {
                    j11 = j15;
                    this.f40059a.I().v(str4, "_vs", j11, bundle4);
                }
            } else {
                j12 = currentTimeMillis;
            }
            j11 = j12;
            this.f40059a.I().v(str4, "_vs", j11, bundle4);
        }
        if (z12) {
            p(this.f39869e, true, j13);
        }
        this.f39869e = z6Var3;
        if (z6Var3.f40467e) {
            this.f39874j = z6Var3;
        }
        this.f40059a.L().u(z6Var3);
    }

    /* access modifiers changed from: private */
    public final void p(z6 z6Var, boolean z10, long j10) {
        boolean z11;
        this.f40059a.y().n(this.f40059a.a().b());
        if (z6Var == null || !z6Var.f40466d) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (this.f40059a.M().f40394f.d(z11, z10, j10) && z6Var != null) {
            z6Var.f40466d = false;
        }
    }

    static /* bridge */ /* synthetic */ void w(g7 g7Var, Bundle bundle, z6 z6Var, z6 z6Var2, long j10) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        g7Var.o(z6Var, z6Var2, j10, true, g7Var.f40059a.N().x0((String) null, "screen_view", bundle, (List) null, false));
    }

    public final void A(Activity activity) {
        synchronized (this.f39876l) {
            this.f39875k = false;
            this.f39872h = true;
        }
        long b10 = this.f40059a.a().b();
        if (!this.f40059a.z().D()) {
            this.f39867c = null;
            this.f40059a.f().z(new d7(this, b10));
            return;
        }
        z6 F = F(activity);
        this.f39868d = this.f39867c;
        this.f39867c = null;
        this.f40059a.f().z(new e7(this, F, b10));
    }

    public final void B(Activity activity) {
        synchronized (this.f39876l) {
            this.f39875k = true;
            if (activity != this.f39871g) {
                synchronized (this.f39876l) {
                    this.f39871g = activity;
                    this.f39872h = false;
                }
                if (this.f40059a.z().D()) {
                    this.f39873i = null;
                    this.f40059a.f().z(new f7(this));
                }
            }
        }
        if (!this.f40059a.z().D()) {
            this.f39867c = this.f39873i;
            this.f40059a.f().z(new c7(this));
            return;
        }
        G(activity, F(activity), false);
        z1 y10 = this.f40059a.y();
        y10.f40059a.f().z(new y0(y10, y10.f40059a.a().b()));
    }

    public final void C(Activity activity, Bundle bundle) {
        z6 z6Var;
        if (this.f40059a.z().D() && bundle != null && (z6Var = (z6) this.f39870f.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", z6Var.f40465c);
            bundle2.putString("name", z6Var.f40463a);
            bundle2.putString("referrer_name", z6Var.f40464b);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r1 <= 100) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        if (r1 <= 100) goto L_0x00cf;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(@androidx.annotation.NonNull android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.u4 r0 = r3.f40059a
            com.google.android.gms.measurement.internal.g r0 = r0.z()
            boolean r0 = r0.D()
            if (r0 != 0) goto L_0x001c
            com.google.android.gms.measurement.internal.u4 r4 = r3.f40059a
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()
            com.google.android.gms.measurement.internal.o3 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.a(r5)
            return
        L_0x001c:
            com.google.android.gms.measurement.internal.z6 r0 = r3.f39867c
            if (r0 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.u4 r4 = r3.f40059a
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()
            com.google.android.gms.measurement.internal.o3 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.a(r5)
            return
        L_0x0030:
            java.util.Map r1 = r3.f39870f
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.measurement.internal.u4 r4 = r3.f40059a
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()
            com.google.android.gms.measurement.internal.o3 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.a(r5)
            return
        L_0x0048:
            if (r6 != 0) goto L_0x0054
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.t(r6, r1)
        L_0x0054:
            java.lang.String r1 = r0.f40464b
            boolean r1 = we.w.a(r1, r6)
            java.lang.String r0 = r0.f40463a
            boolean r0 = we.w.a(r0, r5)
            if (r1 == 0) goto L_0x0075
            if (r0 != 0) goto L_0x0065
            goto L_0x0075
        L_0x0065:
            com.google.android.gms.measurement.internal.u4 r4 = r3.f40059a
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()
            com.google.android.gms.measurement.internal.o3 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.a(r5)
            return
        L_0x0075:
            r0 = 100
            if (r5 == 0) goto L_0x00a3
            int r1 = r5.length()
            if (r1 <= 0) goto L_0x008b
            int r1 = r5.length()
            com.google.android.gms.measurement.internal.u4 r2 = r3.f40059a
            r2.z()
            if (r1 > r0) goto L_0x008b
            goto L_0x00a3
        L_0x008b:
            com.google.android.gms.measurement.internal.u4 r4 = r3.f40059a
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()
            com.google.android.gms.measurement.internal.o3 r4 = r4.x()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.b(r6, r5)
            return
        L_0x00a3:
            if (r6 == 0) goto L_0x00cf
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x00b7
            int r1 = r6.length()
            com.google.android.gms.measurement.internal.u4 r2 = r3.f40059a
            r2.z()
            if (r1 > r0) goto L_0x00b7
            goto L_0x00cf
        L_0x00b7:
            com.google.android.gms.measurement.internal.u4 r4 = r3.f40059a
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()
            com.google.android.gms.measurement.internal.o3 r4 = r4.x()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.b(r6, r5)
            return
        L_0x00cf:
            com.google.android.gms.measurement.internal.u4 r0 = r3.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.v()
            if (r5 != 0) goto L_0x00de
            java.lang.String r1 = "null"
            goto L_0x00df
        L_0x00de:
            r1 = r5
        L_0x00df:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.c(r2, r1, r6)
            com.google.android.gms.measurement.internal.z6 r0 = new com.google.android.gms.measurement.internal.z6
            com.google.android.gms.measurement.internal.u4 r1 = r3.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            long r1 = r1.t0()
            r0.<init>(r5, r6, r1)
            java.util.Map r5 = r3.f39870f
            r5.put(r4, r0)
            r5 = 1
            r3.G(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.g7.D(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r2 > 100) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r4 > 100) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c1, code lost:
        r0 = r12.f40059a.d().v();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cb, code lost:
        if (r3 != null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cd, code lost:
        r1 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d0, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d1, code lost:
        if (r4 != null) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        r0.c("Logging screen view with name, class", r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00de, code lost:
        if (r12.f39867c != null) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        r0 = r12.f39868d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e3, code lost:
        r0 = r12.f39867c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e5, code lost:
        r2 = new com.google.android.gms.measurement.internal.z6(r3, r4, r12.f40059a.N().t0(), true, r14);
        r12.f39867c = r2;
        r12.f39868d = r0;
        r12.f39873i = r2;
        r12.f40059a.f().z(new com.google.android.gms.measurement.internal.a7(r12, r13, r2, r0, r12.f40059a.a().b()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(android.os.Bundle r13, long r14) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.f39876l
            monitor-enter(r0)
            boolean r1 = r12.f39875k     // Catch:{ all -> 0x011b }
            if (r1 != 0) goto L_0x0018
            com.google.android.gms.measurement.internal.u4 r13 = r12.f40059a     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.q3 r13 = r13.d()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.o3 r13 = r13.x()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Cannot log screen view event when the app is in the background."
            r13.a(r14)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x0018:
            java.lang.String r1 = "screen_name"
            java.lang.String r3 = r13.getString(r1)     // Catch:{ all -> 0x011b }
            r1 = 100
            if (r3 == 0) goto L_0x004c
            int r2 = r3.length()     // Catch:{ all -> 0x011b }
            if (r2 <= 0) goto L_0x0033
            int r2 = r3.length()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.u4 r4 = r12.f40059a     // Catch:{ all -> 0x011b }
            r4.z()     // Catch:{ all -> 0x011b }
            if (r2 <= r1) goto L_0x004c
        L_0x0033:
            com.google.android.gms.measurement.internal.u4 r13 = r12.f40059a     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.q3 r13 = r13.d()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.o3 r13 = r13.x()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Invalid screen name length for screen view. Length"
            int r15 = r3.length()     // Catch:{ all -> 0x011b }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x011b }
            r13.b(r14, r15)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x004c:
            java.lang.String r2 = "screen_class"
            java.lang.String r2 = r13.getString(r2)     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x007e
            int r4 = r2.length()     // Catch:{ all -> 0x011b }
            if (r4 <= 0) goto L_0x0065
            int r4 = r2.length()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.u4 r5 = r12.f40059a     // Catch:{ all -> 0x011b }
            r5.z()     // Catch:{ all -> 0x011b }
            if (r4 <= r1) goto L_0x007e
        L_0x0065:
            com.google.android.gms.measurement.internal.u4 r13 = r12.f40059a     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.q3 r13 = r13.d()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.o3 r13 = r13.x()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Invalid screen class length for screen view. Length"
            int r15 = r2.length()     // Catch:{ all -> 0x011b }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x011b }
            r13.b(r14, r15)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x007e:
            if (r2 != 0) goto L_0x0093
            android.app.Activity r1 = r12.f39871g     // Catch:{ all -> 0x011b }
            if (r1 == 0) goto L_0x008f
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x011b }
            java.lang.String r2 = "Activity"
            java.lang.String r1 = r12.t(r1, r2)     // Catch:{ all -> 0x011b }
            goto L_0x0091
        L_0x008f:
            java.lang.String r1 = "Activity"
        L_0x0091:
            r4 = r1
            goto L_0x0094
        L_0x0093:
            r4 = r2
        L_0x0094:
            com.google.android.gms.measurement.internal.z6 r1 = r12.f39867c     // Catch:{ all -> 0x011b }
            boolean r2 = r12.f39872h     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x00c0
            if (r1 == 0) goto L_0x00c0
            r2 = 0
            r12.f39872h = r2     // Catch:{ all -> 0x011b }
            java.lang.String r2 = r1.f40464b     // Catch:{ all -> 0x011b }
            boolean r2 = we.w.a(r2, r4)     // Catch:{ all -> 0x011b }
            java.lang.String r1 = r1.f40463a     // Catch:{ all -> 0x011b }
            boolean r1 = we.w.a(r1, r3)     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x00c0
            if (r1 == 0) goto L_0x00c0
            com.google.android.gms.measurement.internal.u4 r13 = r12.f40059a     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.q3 r13 = r13.d()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.o3 r13 = r13.x()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Ignoring call to log screen view event with duplicate parameters."
            r13.a(r14)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x00c0:
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.u4 r0 = r12.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.v()
            if (r3 != 0) goto L_0x00d0
            java.lang.String r1 = "null"
            goto L_0x00d1
        L_0x00d0:
            r1 = r3
        L_0x00d1:
            if (r4 != 0) goto L_0x00d6
            java.lang.String r2 = "null"
            goto L_0x00d7
        L_0x00d6:
            r2 = r4
        L_0x00d7:
            java.lang.String r5 = "Logging screen view with name, class"
            r0.c(r5, r1, r2)
            com.google.android.gms.measurement.internal.z6 r0 = r12.f39867c
            if (r0 != 0) goto L_0x00e3
            com.google.android.gms.measurement.internal.z6 r0 = r12.f39868d
            goto L_0x00e5
        L_0x00e3:
            com.google.android.gms.measurement.internal.z6 r0 = r12.f39867c
        L_0x00e5:
            com.google.android.gms.measurement.internal.z6 r1 = new com.google.android.gms.measurement.internal.z6
            com.google.android.gms.measurement.internal.u4 r2 = r12.f40059a
            com.google.android.gms.measurement.internal.t9 r2 = r2.N()
            long r5 = r2.t0()
            r7 = 1
            r2 = r1
            r8 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r12.f39867c = r1
            r12.f39868d = r0
            r12.f39873i = r1
            com.google.android.gms.measurement.internal.u4 r14 = r12.f40059a
            me.f r14 = r14.a()
            long r10 = r14.b()
            com.google.android.gms.measurement.internal.u4 r14 = r12.f40059a
            com.google.android.gms.measurement.internal.s4 r14 = r14.f()
            com.google.android.gms.measurement.internal.a7 r15 = new com.google.android.gms.measurement.internal.a7
            r5 = r15
            r6 = r12
            r7 = r13
            r8 = r1
            r9 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r14.z(r15)
            return
        L_0x011b:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.g7.E(android.os.Bundle, long):void");
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        return false;
    }

    public final z6 r() {
        return this.f39867c;
    }

    public final z6 s(boolean z10) {
        i();
        h();
        if (!z10) {
            return this.f39869e;
        }
        z6 z6Var = this.f39869e;
        if (z6Var != null) {
            return z6Var;
        }
        return this.f39874j;
    }

    /* access modifiers changed from: package-private */
    public final String t(Class cls, String str) {
        String str2;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        if (length > 0) {
            str2 = split[length - 1];
        } else {
            str2 = "";
        }
        int length2 = str2.length();
        this.f40059a.z();
        if (length2 <= 100) {
            return str2;
        }
        this.f40059a.z();
        return str2.substring(0, 100);
    }

    public final void y(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (this.f40059a.z().D() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.f39870f.put(activity, new z6(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void z(Activity activity) {
        synchronized (this.f39876l) {
            if (activity == this.f39871g) {
                this.f39871g = null;
            }
        }
        if (this.f40059a.z().D()) {
            this.f39870f.remove(activity);
        }
    }
}
