package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.a;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzph;
import com.google.android.gms.internal.measurement.zzqu;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import we.n;
import we.o;
import we.s;
import we.t;

public final class u6 extends w3 {

    /* renamed from: c  reason: collision with root package name */
    protected t6 f40329c;

    /* renamed from: d  reason: collision with root package name */
    private s f40330d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f40331e = new CopyOnWriteArraySet();

    /* renamed from: f  reason: collision with root package name */
    private boolean f40332f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference f40333g = new AtomicReference();

    /* renamed from: h  reason: collision with root package name */
    private final Object f40334h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private o f40335i = o.f42122c;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicLong f40336j = new AtomicLong(0);

    /* renamed from: k  reason: collision with root package name */
    private long f40337k = -1;

    /* renamed from: l  reason: collision with root package name */
    final z9 f40338l;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f40339m = true;

    /* renamed from: n  reason: collision with root package name */
    private final s9 f40340n = new i6(this);

    protected u6(u4 u4Var) {
        super(u4Var);
        this.f40338l = new z9(u4Var);
    }

    /* access modifiers changed from: private */
    public final void O(Boolean bool, boolean z10) {
        h();
        i();
        this.f40059a.d().q().b("Setting app measurement enabled (FE)", bool);
        this.f40059a.F().s(bool);
        if (z10) {
            e4 F = this.f40059a.F();
            u4 u4Var = F.f40059a;
            F.h();
            SharedPreferences.Editor edit = F.o().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.f40059a.p() || (bool != null && !bool.booleanValue())) {
            P();
        }
    }

    /* access modifiers changed from: private */
    public final void P() {
        long j10;
        h();
        String a10 = this.f40059a.F().f39748m.a();
        if (a10 != null) {
            if ("unset".equals(a10)) {
                M("app", "_npa", (Object) null, this.f40059a.a().currentTimeMillis());
            } else {
                if (true != ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(a10)) {
                    j10 = 0;
                } else {
                    j10 = 1;
                }
                M("app", "_npa", Long.valueOf(j10), this.f40059a.a().currentTimeMillis());
            }
        }
        if (!this.f40059a.o() || !this.f40339m) {
            this.f40059a.d().q().a("Updating Scion state (FE)");
            this.f40059a.L().w();
            return;
        }
        this.f40059a.d().q().a("Recording app launch after enabling measurement for the first time (FE)");
        f0();
        zzph.zzc();
        if (this.f40059a.z().B((String) null, g3.f39820h0)) {
            this.f40059a.M().f40393e.a();
        }
        this.f40059a.f().z(new x5(this));
    }

    static /* bridge */ /* synthetic */ void b0(u6 u6Var, o oVar, o oVar2) {
        boolean z10;
        zzha[] zzhaArr = {zzha.ANALYTICS_STORAGE, zzha.AD_STORAGE};
        int i10 = 0;
        while (true) {
            if (i10 >= 2) {
                z10 = false;
                break;
            }
            zzha zzha = zzhaArr[i10];
            if (!oVar2.j(zzha) && oVar.j(zzha)) {
                z10 = true;
                break;
            }
            i10++;
        }
        boolean n10 = oVar.n(oVar2, zzha.ANALYTICS_STORAGE, zzha.AD_STORAGE);
        if (z10 || n10) {
            u6Var.f40059a.B().v();
        }
    }

    static /* synthetic */ void c0(u6 u6Var, o oVar, long j10, boolean z10, boolean z11) {
        u6Var.h();
        u6Var.i();
        o q10 = u6Var.f40059a.F().q();
        if (j10 > u6Var.f40337k || !o.k(q10.a(), oVar.a())) {
            e4 F = u6Var.f40059a.F();
            u4 u4Var = F.f40059a;
            F.h();
            int a10 = oVar.a();
            if (F.w(a10)) {
                SharedPreferences.Editor edit = F.o().edit();
                edit.putString("consent_settings", oVar.i());
                edit.putInt("consent_source", a10);
                edit.apply();
                u6Var.f40337k = j10;
                u6Var.f40059a.L().t(z10);
                if (z11) {
                    u6Var.f40059a.L().S(new AtomicReference());
                    return;
                }
                return;
            }
            u6Var.f40059a.d().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(oVar.a()));
            return;
        }
        u6Var.f40059a.d().u().b("Dropped out-of-date consent setting, proposed settings", oVar);
    }

    /* access modifiers changed from: protected */
    public final void A(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String next : bundle2.keySet()) {
            Object obj = bundle2.get(next);
            if (obj instanceof Bundle) {
                bundle2.putBundle(next, new Bundle((Bundle) obj));
            } else {
                int i10 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i10 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i10];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i10] = new Bundle((Bundle) parcelable);
                        }
                        i10++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i10 < list.size()) {
                        Object obj2 = list.get(i10);
                        if (obj2 instanceof Bundle) {
                            list.set(i10, new Bundle((Bundle) obj2));
                        }
                        i10++;
                    }
                }
            }
        }
        this.f40059a.f().z(new z5(this, str, str2, j10, bundle2, z10, z11, z12, str3));
    }

    /* access modifiers changed from: package-private */
    public final void B(String str, String str2, long j10, Object obj) {
        this.f40059a.f().z(new a6(this, str, str2, obj, j10));
    }

    /* access modifiers changed from: package-private */
    public final void C(String str) {
        this.f40333g.set(str);
    }

    public final void D(Bundle bundle) {
        E(bundle, this.f40059a.a().currentTimeMillis());
    }

    public final void E(Bundle bundle, long j10) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        p.k(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.f40059a.d().w().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        p.k(bundle2);
        n.a(bundle2, "app_id", cls2, (Object) null);
        n.a(bundle2, FirebaseAnalytics.Param.ORIGIN, cls2, (Object) null);
        n.a(bundle2, "name", cls2, (Object) null);
        n.a(bundle2, "value", Object.class, (Object) null);
        n.a(bundle2, "trigger_event_name", cls2, (Object) null);
        n.a(bundle2, "trigger_timeout", cls, 0L);
        n.a(bundle2, "timed_out_event_name", cls2, (Object) null);
        n.a(bundle2, "timed_out_event_params", Bundle.class, (Object) null);
        n.a(bundle2, "triggered_event_name", cls2, (Object) null);
        n.a(bundle2, "triggered_event_params", Bundle.class, (Object) null);
        n.a(bundle2, "time_to_live", cls, 0L);
        n.a(bundle2, "expired_event_name", cls2, (Object) null);
        n.a(bundle2, "expired_event_params", Bundle.class, (Object) null);
        p.g(bundle2.getString("name"));
        p.g(bundle2.getString(FirebaseAnalytics.Param.ORIGIN));
        p.k(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j10);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.f40059a.N().p0(string) != 0) {
            this.f40059a.d().r().b("Invalid conditional user property name", this.f40059a.D().f(string));
        } else if (this.f40059a.N().l0(string, obj) == 0) {
            Object p10 = this.f40059a.N().p(string, obj);
            if (p10 == null) {
                this.f40059a.d().r().c("Unable to normalize conditional user property value", this.f40059a.D().f(string), obj);
                return;
            }
            n.b(bundle2, p10);
            long j11 = bundle2.getLong("trigger_timeout");
            if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
                this.f40059a.z();
                if (j11 > 15552000000L || j11 < 1) {
                    this.f40059a.d().r().c("Invalid conditional user property timeout", this.f40059a.D().f(string), Long.valueOf(j11));
                    return;
                }
            }
            long j12 = bundle2.getLong("time_to_live");
            this.f40059a.z();
            if (j12 > 15552000000L || j12 < 1) {
                this.f40059a.d().r().c("Invalid conditional user property time to live", this.f40059a.D().f(string), Long.valueOf(j12));
            } else {
                this.f40059a.f().z(new c6(this, bundle2));
            }
        } else {
            this.f40059a.d().r().c("Invalid conditional user property value", this.f40059a.D().f(string), obj);
        }
    }

    public final void F(o oVar, long j10) {
        o oVar2;
        boolean z10;
        boolean z11;
        boolean z12;
        i();
        int a10 = oVar.a();
        if (a10 != -10 && oVar.f() == null && oVar.g() == null) {
            this.f40059a.d().x().a("Discarding empty consent settings");
            return;
        }
        synchronized (this.f40334h) {
            oVar2 = this.f40335i;
            z10 = true;
            z11 = false;
            if (o.k(a10, oVar2.a())) {
                boolean m10 = oVar.m(this.f40335i);
                zzha zzha = zzha.ANALYTICS_STORAGE;
                if (oVar.j(zzha) && !this.f40335i.j(zzha)) {
                    z11 = true;
                }
                oVar = oVar.e(this.f40335i);
                this.f40335i = oVar;
                z12 = z11;
                z11 = m10;
            } else {
                z10 = false;
                z12 = false;
            }
        }
        if (!z10) {
            this.f40059a.d().u().b("Ignoring lower-priority consent settings, proposed settings", oVar);
            return;
        }
        long andIncrement = this.f40336j.getAndIncrement();
        if (z11) {
            this.f40333g.set((Object) null);
            this.f40059a.f().A(new p6(this, oVar, j10, andIncrement, z12, oVar2));
            return;
        }
        q6 q6Var = new q6(this, oVar, andIncrement, z12, oVar2);
        if (a10 == 30 || a10 == -10) {
            this.f40059a.f().A(q6Var);
        } else {
            this.f40059a.f().z(q6Var);
        }
    }

    public final void G(Bundle bundle, int i10, long j10) {
        i();
        String h10 = o.h(bundle);
        if (h10 != null) {
            this.f40059a.d().x().b("Ignoring invalid consent setting", h10);
            this.f40059a.d().x().a("Valid consent values are 'granted', 'denied'");
        }
        F(o.b(bundle, i10), j10);
    }

    public final void H(s sVar) {
        s sVar2;
        boolean z10;
        h();
        i();
        if (!(sVar == null || sVar == (sVar2 = this.f40330d))) {
            if (sVar2 == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            p.p(z10, "EventInterceptor already set.");
        }
        this.f40330d = sVar;
    }

    public final void I(Boolean bool) {
        i();
        this.f40059a.f().z(new o6(this, bool));
    }

    /* access modifiers changed from: package-private */
    public final void J(o oVar) {
        boolean z10;
        Boolean bool;
        h();
        if ((!oVar.j(zzha.ANALYTICS_STORAGE) || !oVar.j(zzha.AD_STORAGE)) && !this.f40059a.L().A()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 != this.f40059a.p()) {
            this.f40059a.l(z10);
            e4 F = this.f40059a.F();
            u4 u4Var = F.f40059a;
            F.h();
            if (F.o().contains("measurement_enabled_from_api")) {
                bool = Boolean.valueOf(F.o().getBoolean("measurement_enabled_from_api", true));
            } else {
                bool = null;
            }
            if (!z10 || bool == null || bool.booleanValue()) {
                O(Boolean.valueOf(z10), false);
            }
        }
    }

    public final void K(String str, String str2, Object obj, boolean z10) {
        L("auto", "_ldl", obj, true, this.f40059a.a().currentTimeMillis());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void L(java.lang.String r16, java.lang.String r17, java.lang.Object r18, boolean r19, long r20) {
        /*
            r15 = this;
            r6 = r15
            r2 = r17
            r0 = r18
            r1 = 6
            r3 = 0
            r4 = 24
            if (r19 == 0) goto L_0x0017
            com.google.android.gms.measurement.internal.u4 r1 = r6.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            int r1 = r1.p0(r2)
        L_0x0015:
            r10 = r1
            goto L_0x003f
        L_0x0017:
            com.google.android.gms.measurement.internal.u4 r5 = r6.f40059a
            com.google.android.gms.measurement.internal.t9 r5 = r5.N()
            java.lang.String r7 = "user property"
            boolean r8 = r5.S(r7, r2)
            if (r8 != 0) goto L_0x0026
        L_0x0025:
            goto L_0x0015
        L_0x0026:
            java.lang.String[] r8 = we.r.f42133a
            r9 = 0
            boolean r8 = r5.P(r7, r8, r9, r2)
            if (r8 != 0) goto L_0x0032
            r1 = 15
            goto L_0x0015
        L_0x0032:
            com.google.android.gms.measurement.internal.u4 r8 = r5.f40059a
            r8.z()
            boolean r5 = r5.N(r7, r4, r2)
            if (r5 != 0) goto L_0x003e
            goto L_0x0025
        L_0x003e:
            r10 = r3
        L_0x003f:
            r1 = 1
            if (r10 == 0) goto L_0x0067
            com.google.android.gms.measurement.internal.u4 r0 = r6.f40059a
            com.google.android.gms.measurement.internal.t9 r0 = r0.N()
            com.google.android.gms.measurement.internal.u4 r5 = r6.f40059a
            r5.z()
            java.lang.String r12 = r0.r(r2, r4, r1)
            if (r2 == 0) goto L_0x0057
            int r3 = r17.length()
        L_0x0057:
            r13 = r3
            com.google.android.gms.measurement.internal.u4 r0 = r6.f40059a
            com.google.android.gms.measurement.internal.t9 r7 = r0.N()
            com.google.android.gms.measurement.internal.s9 r8 = r6.f40340n
            r9 = 0
            java.lang.String r11 = "_ev"
            r7.C(r8, r9, r10, r11, r12, r13)
            return
        L_0x0067:
            if (r16 != 0) goto L_0x006c
            java.lang.String r5 = "app"
            goto L_0x006e
        L_0x006c:
            r5 = r16
        L_0x006e:
            if (r0 == 0) goto L_0x00c2
            com.google.android.gms.measurement.internal.u4 r7 = r6.f40059a
            com.google.android.gms.measurement.internal.t9 r7 = r7.N()
            int r11 = r7.l0(r2, r0)
            if (r11 == 0) goto L_0x00ab
            com.google.android.gms.measurement.internal.u4 r5 = r6.f40059a
            com.google.android.gms.measurement.internal.t9 r5 = r5.N()
            com.google.android.gms.measurement.internal.u4 r7 = r6.f40059a
            r7.z()
            java.lang.String r13 = r5.r(r2, r4, r1)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x0093
            boolean r1 = r0 instanceof java.lang.CharSequence
            if (r1 == 0) goto L_0x009b
        L_0x0093:
            java.lang.String r0 = r18.toString()
            int r3 = r0.length()
        L_0x009b:
            r14 = r3
            com.google.android.gms.measurement.internal.u4 r0 = r6.f40059a
            com.google.android.gms.measurement.internal.t9 r8 = r0.N()
            com.google.android.gms.measurement.internal.s9 r9 = r6.f40340n
            r10 = 0
            java.lang.String r12 = "_ev"
            r8.C(r9, r10, r11, r12, r13, r14)
            return
        L_0x00ab:
            com.google.android.gms.measurement.internal.u4 r1 = r6.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            java.lang.Object r7 = r1.p(r2, r0)
            if (r7 == 0) goto L_0x00c1
            r0 = r15
            r1 = r5
            r2 = r17
            r3 = r20
            r5 = r7
            r0.B(r1, r2, r3, r5)
        L_0x00c1:
            return
        L_0x00c2:
            r7 = 0
            r0 = r15
            r1 = r5
            r2 = r17
            r3 = r20
            r5 = r7
            r0.B(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.u6.L(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.p.g(r9)
            com.google.android.gms.common.internal.p.g(r10)
            r8.h()
            r8.i()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0064
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0052
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0052
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            r11 = 1
            java.lang.String r0 = "false"
            boolean r10 = r0.equals(r10)
            r2 = 1
            if (r11 == r10) goto L_0x0037
            r10 = 0
            goto L_0x0038
        L_0x0037:
            r10 = r2
        L_0x0038:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.u4 r10 = r8.f40059a
            com.google.android.gms.measurement.internal.e4 r10 = r10.F()
            com.google.android.gms.measurement.internal.d4 r10 = r10.f39748m
            long r4 = r11.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x004e
            java.lang.String r0 = "true"
        L_0x004e:
            r10.b(r0)
            goto L_0x0061
        L_0x0052:
            if (r11 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.u4 r10 = r8.f40059a
            com.google.android.gms.measurement.internal.e4 r10 = r10.F()
            com.google.android.gms.measurement.internal.d4 r10 = r10.f39748m
            java.lang.String r0 = "unset"
            r10.b(r0)
        L_0x0061:
            r6 = r11
            r3 = r1
            goto L_0x0066
        L_0x0064:
            r3 = r10
            r6 = r11
        L_0x0066:
            com.google.android.gms.measurement.internal.u4 r10 = r8.f40059a
            boolean r10 = r10.o()
            if (r10 != 0) goto L_0x007e
            com.google.android.gms.measurement.internal.u4 r9 = r8.f40059a
            com.google.android.gms.measurement.internal.q3 r9 = r9.d()
            com.google.android.gms.measurement.internal.o3 r9 = r9.v()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L_0x007e:
            com.google.android.gms.measurement.internal.u4 r10 = r8.f40059a
            boolean r10 = r10.r()
            if (r10 != 0) goto L_0x0087
            return
        L_0x0087:
            com.google.android.gms.measurement.internal.zzlk r10 = new com.google.android.gms.measurement.internal.zzlk
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.u4 r9 = r8.f40059a
            com.google.android.gms.measurement.internal.g8 r9 = r9.L()
            r9.y(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.u6.M(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void N(t tVar) {
        i();
        p.k(tVar);
        if (!this.f40331e.remove(tVar)) {
            this.f40059a.d().w().a("OnEventListener had not been registered");
        }
    }

    public final int Q(String str) {
        p.g(str);
        this.f40059a.z();
        return 25;
    }

    public final Boolean R() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.f40059a.f().r(atomicReference, 15000, "boolean test flag value", new f6(this, atomicReference));
    }

    public final Double S() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.f40059a.f().r(atomicReference, 15000, "double test flag value", new n6(this, atomicReference));
    }

    public final Integer T() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.f40059a.f().r(atomicReference, 15000, "int test flag value", new m6(this, atomicReference));
    }

    public final Long U() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.f40059a.f().r(atomicReference, 15000, "long test flag value", new l6(this, atomicReference));
    }

    public final String V() {
        return (String) this.f40333g.get();
    }

    public final String W() {
        z6 r10 = this.f40059a.K().r();
        if (r10 != null) {
            return r10.f40464b;
        }
        return null;
    }

    public final String X() {
        z6 r10 = this.f40059a.K().r();
        if (r10 != null) {
            return r10.f40463a;
        }
        return null;
    }

    public final String Y() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.f40059a.f().r(atomicReference, 15000, "String test flag value", new k6(this, atomicReference));
    }

    public final ArrayList Z(String str, String str2) {
        if (this.f40059a.f().C()) {
            this.f40059a.d().r().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.f40059a.b();
        if (c.a()) {
            this.f40059a.d().r().a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f40059a.f().r(atomicReference, 5000, "get conditional user properties", new e6(this, atomicReference, (String) null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return t9.v(list);
        }
        this.f40059a.d().r().b("Timed out waiting for get conditional user properties", (Object) null);
        return new ArrayList();
    }

    public final Map a0(String str, String str2, boolean z10) {
        if (this.f40059a.f().C()) {
            this.f40059a.d().r().a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.f40059a.b();
        if (c.a()) {
            this.f40059a.d().r().a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f40059a.f().r(atomicReference, 5000, "get user properties", new g6(this, atomicReference, (String) null, str, str2, z10));
        List<zzlk> list = (List) atomicReference.get();
        if (list == null) {
            this.f40059a.d().r().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z10));
            return Collections.emptyMap();
        }
        a aVar = new a(list.size());
        for (zzlk zzlk : list) {
            Object S = zzlk.S();
            if (S != null) {
                aVar.put(zzlk.f40500b, S);
            }
        }
        return aVar;
    }

    public final void f0() {
        h();
        i();
        if (this.f40059a.r()) {
            if (this.f40059a.z().B((String) null, g3.f39808b0)) {
                g z10 = this.f40059a.z();
                z10.f40059a.b();
                Boolean t10 = z10.t("google_analytics_deferred_deep_link_enabled");
                if (t10 != null && t10.booleanValue()) {
                    this.f40059a.d().q().a("Deferred Deep Link feature enabled.");
                    this.f40059a.f().z(new w5(this));
                }
            }
            this.f40059a.L().O();
            this.f40339m = false;
            e4 F = this.f40059a.F();
            F.h();
            String string = F.o().getString("previous_os_version", (String) null);
            F.f40059a.A().k();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = F.o().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                this.f40059a.A().k();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    u("auto", "_ou", bundle);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        return false;
    }

    public final void o(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.f40059a.a().currentTimeMillis();
        p.g(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        this.f40059a.f().z(new d6(this, bundle2));
    }

    public final void p() {
        if ((this.f40059a.c().getApplicationContext() instanceof Application) && this.f40329c != null) {
            ((Application) this.f40059a.c().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f40329c);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void q(Bundle bundle) {
        if (bundle == null) {
            this.f40059a.F().f39759x.b(new Bundle());
            return;
        }
        Bundle a10 = this.f40059a.F().f39759x.a();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.f40059a.N().V(obj)) {
                    this.f40059a.N().C(this.f40340n, (String) null, 27, (String) null, (String) null, 0);
                }
                this.f40059a.d().x().c("Invalid default event parameter type. Name, value", next, obj);
            } else if (t9.Y(next)) {
                this.f40059a.d().x().b("Invalid default event parameter name. Name", next);
            } else if (obj == null) {
                a10.remove(next);
            } else {
                t9 N = this.f40059a.N();
                this.f40059a.z();
                if (N.Q("param", next, 100, obj)) {
                    this.f40059a.N().D(a10, next, obj);
                }
            }
        }
        this.f40059a.N();
        int m10 = this.f40059a.z().m();
        if (a10.size() > m10) {
            int i10 = 0;
            for (String str : new TreeSet(a10.keySet())) {
                i10++;
                if (i10 > m10) {
                    a10.remove(str);
                }
            }
            this.f40059a.N().C(this.f40340n, (String) null, 26, (String) null, (String) null, 0);
            this.f40059a.d().x().a("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.f40059a.F().f39759x.b(a10);
        this.f40059a.L().v(a10);
    }

    public final void r(String str, String str2, Bundle bundle) {
        s(str, str2, bundle, true, true, this.f40059a.a().currentTimeMillis());
    }

    public final void s(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        Bundle bundle2;
        String str3;
        String str4 = str2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (str4 == "screen_view" || (str4 != null && str2.equals("screen_view"))) {
            this.f40059a.K().E(bundle2, j10);
            return;
        }
        boolean z12 = true;
        if (z11 && this.f40330d != null && !t9.Y(str2)) {
            z12 = false;
        }
        boolean z13 = z12;
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        A(str3, str2, j10, bundle2, z11, z13, z10, (String) null);
    }

    public final void t(String str, String str2, Bundle bundle, String str3) {
        u4.t();
        A("auto", str2, this.f40059a.a().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* access modifiers changed from: package-private */
    public final void u(String str, String str2, Bundle bundle) {
        h();
        v(str, str2, this.f40059a.a().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void v(String str, String str2, long j10, Bundle bundle) {
        boolean z10;
        h();
        if (this.f40330d == null || t9.Y(str2)) {
            z10 = true;
        } else {
            z10 = false;
        }
        w(str, str2, j10, bundle, true, z10, true, (String) null);
    }

    /* JADX WARNING: type inference failed for: r5v10, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r5v12, types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(java.lang.String r22, java.lang.String r23, long r24, android.os.Bundle r26, boolean r27, boolean r28, boolean r29, java.lang.String r30) {
        /*
            r21 = this;
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r12 = r26
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            com.google.android.gms.common.internal.p.g(r22)
            com.google.android.gms.common.internal.p.k(r26)
            r21.h()
            r21.i()
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            boolean r1 = r1.o()
            if (r1 == 0) goto L_0x0509
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.i3 r1 = r1.B()
            java.util.List r1 = r1.u()
            if (r1 == 0) goto L_0x0043
            boolean r1 = r1.contains(r9)
            if (r1 == 0) goto L_0x0033
            goto L_0x0043
        L_0x0033:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.q()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.c(r1, r9, r8)
            return
        L_0x0043:
            boolean r1 = r7.f40332f
            r13 = 0
            r14 = 0
            r15 = 1
            if (r1 != 0) goto L_0x00a1
            r7.f40332f = r15
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a     // Catch:{ ClassNotFoundException -> 0x0092 }
            boolean r1 = r1.s()     // Catch:{ ClassNotFoundException -> 0x0092 }
            if (r1 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a     // Catch:{ ClassNotFoundException -> 0x0092 }
            android.content.Context r1 = r1.c()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.Class r0 = java.lang.Class.forName(r0, r15, r1)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x0067
        L_0x0063:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
        L_0x0067:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x0081 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r14] = r3     // Catch:{ Exception -> 0x0081 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0081 }
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0081 }
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a     // Catch:{ Exception -> 0x0081 }
            android.content.Context r2 = r2.c()     // Catch:{ Exception -> 0x0081 }
            r1[r14] = r2     // Catch:{ Exception -> 0x0081 }
            r0.invoke(r13, r1)     // Catch:{ Exception -> 0x0081 }
            goto L_0x00a1
        L_0x0081:
            r0 = move-exception
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.q3 r1 = r1.d()     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.o3 r1 = r1.w()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.b(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x00a1
        L_0x0092:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.u()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.a(r1)
        L_0x00a1:
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00cd
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            r1.b()
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            me.f r0 = r0.a()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r21
            r1.M(r2, r3, r4, r5)
        L_0x00cd:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            r0.b()
            if (r27 == 0) goto L_0x00ef
            boolean r0 = com.google.android.gms.measurement.internal.t9.c0(r23)
            if (r0 == 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r0 = r0.N()
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.e4 r1 = r1.F()
            com.google.android.gms.measurement.internal.a4 r1 = r1.f39759x
            android.os.Bundle r1 = r1.a()
            r0.z(r12, r1)
        L_0x00ef:
            r0 = 40
            if (r29 != 0) goto L_0x0177
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            r1.b()
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0177
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            java.lang.String r2 = "event"
            boolean r3 = r1.S(r2, r9)
            r4 = 2
            if (r3 != 0) goto L_0x0110
            goto L_0x012a
        L_0x0110:
            java.lang.String[] r3 = we.p.f42125a
            java.lang.String[] r5 = we.p.f42126b
            boolean r3 = r1.P(r2, r3, r5, r9)
            if (r3 != 0) goto L_0x011d
            r4 = 13
            goto L_0x012a
        L_0x011d:
            com.google.android.gms.measurement.internal.u4 r3 = r1.f40059a
            r3.z()
            boolean r1 = r1.N(r2, r0, r9)
            if (r1 != 0) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r4 = r14
        L_0x012a:
            if (r4 == 0) goto L_0x0177
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r1 = r1.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.s()
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a
            com.google.android.gms.measurement.internal.l3 r2 = r2.D()
            java.lang.String r2 = r2.d(r9)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.b(r3, r2)
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a
            r2.z()
            java.lang.String r0 = r1.r(r9, r0, r15)
            if (r9 == 0) goto L_0x015a
            int r14 = r23.length()
        L_0x015a:
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            com.google.android.gms.measurement.internal.s9 r2 = r7.f40340n
            r3 = 0
            java.lang.String r5 = "_ev"
            r22 = r1
            r23 = r2
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r0
            r28 = r14
            r22.C(r23, r24, r25, r26, r27, r28)
            return
        L_0x0177:
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            r1.b()
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.g7 r1 = r1.K()
            com.google.android.gms.measurement.internal.z6 r1 = r1.s(r14)
            java.lang.String r2 = "_sc"
            if (r1 == 0) goto L_0x0192
            boolean r3 = r12.containsKey(r2)
            if (r3 != 0) goto L_0x0192
            r1.f40466d = r15
        L_0x0192:
            if (r27 == 0) goto L_0x0198
            if (r29 != 0) goto L_0x0198
            r3 = r15
            goto L_0x0199
        L_0x0198:
            r3 = r14
        L_0x0199:
            com.google.android.gms.measurement.internal.t9.y(r1, r12, r3)
            java.lang.String r1 = "am"
            boolean r1 = r1.equals(r8)
            boolean r3 = com.google.android.gms.measurement.internal.t9.Y(r23)
            if (r27 == 0) goto L_0x01e9
            we.s r4 = r7.f40330d
            if (r4 == 0) goto L_0x01e9
            if (r3 != 0) goto L_0x01e9
            if (r1 == 0) goto L_0x01b3
            r16 = r15
            goto L_0x01eb
        L_0x01b3:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.q()
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.l3 r1 = r1.D()
            java.lang.String r1 = r1.d(r9)
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a
            com.google.android.gms.measurement.internal.l3 r2 = r2.D()
            java.lang.String r2 = r2.b(r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.c(r3, r1, r2)
            we.s r0 = r7.f40330d
            com.google.android.gms.common.internal.p.k(r0)
            we.s r1 = r7.f40330d
            r2 = r22
            r3 = r23
            r4 = r26
            r5 = r24
            r1.a(r2, r3, r4, r5)
            return
        L_0x01e9:
            r16 = r1
        L_0x01eb:
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            boolean r1 = r1.r()
            if (r1 == 0) goto L_0x0508
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            int r1 = r1.m0(r9)
            if (r1 == 0) goto L_0x0249
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()
            com.google.android.gms.measurement.internal.o3 r2 = r2.s()
            com.google.android.gms.measurement.internal.u4 r3 = r7.f40059a
            com.google.android.gms.measurement.internal.l3 r3 = r3.D()
            java.lang.String r3 = r3.d(r9)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r2.b(r4, r3)
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r2 = r2.N()
            com.google.android.gms.measurement.internal.u4 r3 = r7.f40059a
            r3.z()
            java.lang.String r0 = r2.r(r9, r0, r15)
            if (r9 == 0) goto L_0x022d
            int r14 = r23.length()
        L_0x022d:
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r2 = r2.N()
            com.google.android.gms.measurement.internal.s9 r3 = r7.f40340n
            java.lang.String r4 = "_ev"
            r22 = r2
            r23 = r3
            r24 = r30
            r25 = r1
            r26 = r4
            r27 = r0
            r28 = r14
            r22.C(r23, r24, r25, r26, r27, r28)
            return
        L_0x0249:
            java.lang.String r0 = "_o"
            java.lang.String r1 = "_sn"
            java.lang.String r3 = "_si"
            java.lang.String[] r1 = new java.lang.String[]{r0, r1, r2, r3}
            java.util.List r5 = me.g.c(r1)
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            r2 = r30
            r3 = r23
            r4 = r26
            r6 = r29
            android.os.Bundle r12 = r1.x0(r2, r3, r4, r5, r6)
            com.google.android.gms.common.internal.p.k(r12)
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            r1.b()
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.g7 r1 = r1.K()
            com.google.android.gms.measurement.internal.z6 r1 = r1.s(r14)
            java.lang.String r5 = "_ae"
            if (r1 == 0) goto L_0x02ae
            boolean r1 = r5.equals(r9)
            if (r1 == 0) goto L_0x02ae
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.w8 r1 = r1.M()
            com.google.android.gms.measurement.internal.u8 r1 = r1.f40394f
            com.google.android.gms.measurement.internal.w8 r2 = r1.f40346d
            com.google.android.gms.measurement.internal.u4 r2 = r2.f40059a
            me.f r2 = r2.a()
            long r14 = r2.b()
            long r3 = r1.f40344b
            long r2 = r14 - r3
            r1.f40344b = r14
            r14 = 0
            int r1 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x02ae
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            r1.w(r12, r2)
        L_0x02ae:
            com.google.android.gms.internal.measurement.zzos.zzc()
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.g r1 = r1.z()
            com.google.android.gms.measurement.internal.f3 r2 = com.google.android.gms.measurement.internal.g3.f39818g0
            boolean r1 = r1.B(r13, r2)
            if (r1 == 0) goto L_0x0338
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            java.lang.String r2 = "_ffr"
            if (r1 != 0) goto L_0x0317
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0317
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            java.lang.String r2 = r12.getString(r2)
            boolean r3 = me.r.b(r2)
            if (r3 == 0) goto L_0x02e3
            r2 = r13
            goto L_0x02e9
        L_0x02e3:
            if (r2 == 0) goto L_0x02e9
            java.lang.String r2 = r2.trim()
        L_0x02e9:
            com.google.android.gms.measurement.internal.u4 r3 = r1.f40059a
            com.google.android.gms.measurement.internal.e4 r3 = r3.F()
            com.google.android.gms.measurement.internal.d4 r3 = r3.f39756u
            java.lang.String r3 = r3.a()
            boolean r3 = we.a0.a(r2, r3)
            if (r3 != 0) goto L_0x0307
            com.google.android.gms.measurement.internal.u4 r1 = r1.f40059a
            com.google.android.gms.measurement.internal.e4 r1 = r1.F()
            com.google.android.gms.measurement.internal.d4 r1 = r1.f39756u
            r1.b(r2)
            goto L_0x0338
        L_0x0307:
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.q()
            java.lang.String r1 = "Not logging duplicate session_start_with_rollout event"
            r0.a(r1)
            return
        L_0x0317:
            boolean r1 = r5.equals(r9)
            if (r1 == 0) goto L_0x0338
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            com.google.android.gms.measurement.internal.u4 r1 = r1.f40059a
            com.google.android.gms.measurement.internal.e4 r1 = r1.F()
            com.google.android.gms.measurement.internal.d4 r1 = r1.f39756u
            java.lang.String r1 = r1.a()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0338
            r12.putString(r2, r1)
        L_0x0338:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r14.add(r12)
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.g r1 = r1.z()
            com.google.android.gms.measurement.internal.f3 r2 = com.google.android.gms.measurement.internal.g3.I0
            boolean r1 = r1.B(r13, r2)
            if (r1 == 0) goto L_0x0359
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.w8 r1 = r1.M()
            boolean r1 = r1.t()
            goto L_0x0365
        L_0x0359:
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.e4 r1 = r1.F()
            com.google.android.gms.measurement.internal.z3 r1 = r1.f39753r
            boolean r1 = r1.b()
        L_0x0365:
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a
            com.google.android.gms.measurement.internal.e4 r2 = r2.F()
            com.google.android.gms.measurement.internal.b4 r2 = r2.f39750o
            long r2 = r2.a()
            r17 = 0
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r2 <= 0) goto L_0x03e1
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a
            com.google.android.gms.measurement.internal.e4 r2 = r2.F()
            boolean r2 = r2.v(r10)
            if (r2 == 0) goto L_0x03e1
            if (r1 == 0) goto L_0x03e1
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r1 = r1.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.v()
            java.lang.String r2 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.a(r2)
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            me.f r1 = r1.a()
            long r19 = r1.currentTimeMillis()
            r4 = 0
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sid"
            r1 = r21
            r26 = r14
            r13 = r17
            r15 = r5
            r5 = r19
            r1.M(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            me.f r1 = r1.a()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r21
            r1.M(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            me.f r1 = r1.a()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r21
            r1.M(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.e4 r1 = r1.F()
            com.google.android.gms.measurement.internal.b4 r1 = r1.f39751p
            r1.b(r13)
            goto L_0x03e6
        L_0x03e1:
            r15 = r5
            r26 = r14
            r13 = r17
        L_0x03e6:
            java.lang.String r1 = "extend_session"
            long r1 = r12.getLong(r1, r13)
            r3 = 1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x040d
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r1 = r1.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.v()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.a(r2)
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.w8 r1 = r1.M()
            com.google.android.gms.measurement.internal.v8 r1 = r1.f40393e
            r2 = 1
            r1.b(r10, r2)
        L_0x040d:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r2 = r12.keySet()
            r1.<init>(r2)
            java.util.Collections.sort(r1)
            int r2 = r1.size()
            r3 = 0
        L_0x041e:
            if (r3 >= r2) goto L_0x046c
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0469
            com.google.android.gms.measurement.internal.u4 r5 = r7.f40059a
            r5.N()
            java.lang.Object r5 = r12.get(r4)
            boolean r6 = r5 instanceof android.os.Bundle
            if (r6 == 0) goto L_0x043e
            r6 = 1
            android.os.Bundle[] r13 = new android.os.Bundle[r6]
            android.os.Bundle r5 = (android.os.Bundle) r5
            r6 = 0
            r13[r6] = r5
            goto L_0x0464
        L_0x043e:
            boolean r6 = r5 instanceof android.os.Parcelable[]
            if (r6 == 0) goto L_0x044f
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r6 = r5.length
            java.lang.Class<android.os.Bundle[]> r13 = android.os.Bundle[].class
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6, r13)
            r13 = r5
            android.os.Bundle[] r13 = (android.os.Bundle[]) r13
            goto L_0x0464
        L_0x044f:
            boolean r6 = r5 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x0463
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()
            android.os.Bundle[] r6 = new android.os.Bundle[r6]
            java.lang.Object[] r5 = r5.toArray(r6)
            r13 = r5
            android.os.Bundle[] r13 = (android.os.Bundle[]) r13
            goto L_0x0464
        L_0x0463:
            r13 = 0
        L_0x0464:
            if (r13 == 0) goto L_0x0469
            r12.putParcelableArray(r4, r13)
        L_0x0469:
            int r3 = r3 + 1
            goto L_0x041e
        L_0x046c:
            r12 = 0
        L_0x046d:
            int r1 = r26.size()
            if (r12 >= r1) goto L_0x04da
            r13 = r26
            java.lang.Object r1 = r13.get(r12)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r12 == 0) goto L_0x0480
            java.lang.String r2 = "_ep"
            goto L_0x0481
        L_0x0480:
            r2 = r9
        L_0x0481:
            r1.putString(r0, r8)
            if (r28 == 0) goto L_0x0490
            com.google.android.gms.measurement.internal.u4 r3 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r3 = r3.N()
            android.os.Bundle r1 = r3.w0(r1)
        L_0x0490:
            r14 = r1
            com.google.android.gms.measurement.internal.zzau r5 = new com.google.android.gms.measurement.internal.zzau
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas
            r3.<init>(r14)
            r1 = r5
            r4 = r22
            r27 = r0
            r0 = r5
            r5 = r24
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.g8 r1 = r1.L()
            r5 = r30
            r1.o(r0, r5)
            if (r16 != 0) goto L_0x04d3
            java.util.Set r0 = r7.f40331e
            java.util.Iterator r0 = r0.iterator()
        L_0x04b6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x04d3
            java.lang.Object r1 = r0.next()
            we.t r1 = (we.t) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r14)
            r2 = r22
            r3 = r23
            r5 = r24
            r1.onEvent(r2, r3, r4, r5)
            r5 = r30
            goto L_0x04b6
        L_0x04d3:
            int r12 = r12 + 1
            r0 = r27
            r26 = r13
            goto L_0x046d
        L_0x04da:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            r0.b()
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.g7 r0 = r0.K()
            r1 = 0
            com.google.android.gms.measurement.internal.z6 r0 = r0.s(r1)
            if (r0 == 0) goto L_0x0508
            boolean r0 = r15.equals(r9)
            if (r0 == 0) goto L_0x0508
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.w8 r0 = r0.M()
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            me.f r1 = r1.a()
            long r1 = r1.b()
            com.google.android.gms.measurement.internal.u8 r0 = r0.f40394f
            r3 = 1
            r0.d(r3, r3, r1)
        L_0x0508:
            return
        L_0x0509:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.q()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.u6.w(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void x(t tVar) {
        i();
        p.k(tVar);
        if (!this.f40331e.add(tVar)) {
            this.f40059a.d().w().a("OnEventListener already registered");
        }
    }

    public final void y(long j10) {
        this.f40333g.set((Object) null);
        this.f40059a.f().z(new b6(this, j10));
    }

    /* access modifiers changed from: package-private */
    public final void z(long j10, boolean z10) {
        h();
        i();
        this.f40059a.d().q().a("Resetting analytics data (FE)");
        w8 M = this.f40059a.M();
        M.h();
        M.f40394f.a();
        zzqu.zzc();
        if (this.f40059a.z().B((String) null, g3.f39836p0)) {
            this.f40059a.B().v();
        }
        boolean o10 = this.f40059a.o();
        e4 F = this.f40059a.F();
        F.f39740e.b(j10);
        if (!TextUtils.isEmpty(F.f40059a.F().f39756u.a())) {
            F.f39756u.b((String) null);
        }
        zzph.zzc();
        g z11 = F.f40059a.z();
        f3 f3Var = g3.f39820h0;
        if (z11.B((String) null, f3Var)) {
            F.f39750o.b(0);
        }
        F.f39751p.b(0);
        if (!F.f40059a.z().E()) {
            F.t(!o10);
        }
        F.f39757v.b((String) null);
        F.f39758w.b(0);
        F.f39759x.b((Bundle) null);
        if (z10) {
            this.f40059a.L().q();
        }
        zzph.zzc();
        if (this.f40059a.z().B((String) null, f3Var)) {
            this.f40059a.M().f40393e.a();
        }
        this.f40339m = !o10;
    }
}
