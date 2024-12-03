package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import le.b;
import we.d;

public final class g8 extends w3 {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final f8 f39877c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d f39878d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Boolean f39879e;

    /* renamed from: f  reason: collision with root package name */
    private final n f39880f;

    /* renamed from: g  reason: collision with root package name */
    private final x8 f39881g;

    /* renamed from: h  reason: collision with root package name */
    private final List f39882h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final n f39883i;

    protected g8(u4 u4Var) {
        super(u4Var);
        this.f39881g = new x8(u4Var.a());
        this.f39877c = new f8(this);
        this.f39880f = new q7(this, u4Var);
        this.f39883i = new s7(this, u4Var);
    }

    private final zzq C(boolean z10) {
        Pair a10;
        this.f40059a.b();
        i3 B = this.f40059a.B();
        String str = null;
        if (z10) {
            q3 d10 = this.f40059a.d();
            if (!(d10.f40059a.F().f39739d == null || (a10 = d10.f40059a.F().f39739d.a()) == null || a10 == e4.f39737y)) {
                str = String.valueOf(a10.second) + CertificateUtil.DELIMITER + ((String) a10.first);
            }
        }
        return B.q(str);
    }

    /* access modifiers changed from: private */
    public final void D() {
        h();
        this.f40059a.d().v().b("Processing queued up service tasks", Integer.valueOf(this.f39882h.size()));
        for (Runnable run : this.f39882h) {
            try {
                run.run();
            } catch (RuntimeException e10) {
                this.f40059a.d().r().b("Task exception while flushing queue", e10);
            }
        }
        this.f39882h.clear();
        this.f39883i.b();
    }

    /* access modifiers changed from: private */
    public final void E() {
        h();
        this.f39881g.b();
        n nVar = this.f39880f;
        this.f40059a.z();
        nVar.d(((Long) g3.L.a((Object) null)).longValue());
    }

    private final void F(Runnable runnable) throws IllegalStateException {
        h();
        if (z()) {
            runnable.run();
            return;
        }
        this.f40059a.z();
        if (((long) this.f39882h.size()) >= 1000) {
            this.f40059a.d().r().a("Discarding data. Max runnable queue size reached");
            return;
        }
        this.f39882h.add(runnable);
        this.f39883i.d(DateUtils.MILLIS_IN_MINUTE);
        P();
    }

    private final boolean G() {
        this.f40059a.b();
        return true;
    }

    static /* bridge */ /* synthetic */ void M(g8 g8Var, ComponentName componentName) {
        g8Var.h();
        if (g8Var.f39878d != null) {
            g8Var.f39878d = null;
            g8Var.f40059a.d().v().b("Disconnected from device MeasurementService", componentName);
            g8Var.h();
            g8Var.P();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean A() {
        h();
        i();
        if (!B() || this.f40059a.N().q0() >= ((Integer) g3.f39824j0.a((Object) null)).intValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean B() {
        /*
            r7 = this;
            r7.h()
            r7.i()
            java.lang.Boolean r0 = r7.f39879e
            if (r0 != 0) goto L_0x014b
            r7.h()
            r7.i()
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.e4 r0 = r0.F()
            r0.h()
            android.content.SharedPreferences r1 = r0.o()
            java.lang.String r2 = "use_service"
            boolean r1 = r1.contains(r2)
            r3 = 0
            if (r1 != 0) goto L_0x0028
            r0 = 0
            goto L_0x0034
        L_0x0028:
            android.content.SharedPreferences r0 = r0.o()
            boolean r0 = r0.getBoolean(r2, r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0034:
            r1 = 1
            if (r0 == 0) goto L_0x003f
            boolean r4 = r0.booleanValue()
            if (r4 == 0) goto L_0x003f
            goto L_0x0145
        L_0x003f:
            com.google.android.gms.measurement.internal.u4 r4 = r7.f40059a
            r4.b()
            com.google.android.gms.measurement.internal.u4 r4 = r7.f40059a
            com.google.android.gms.measurement.internal.i3 r4 = r4.B()
            int r4 = r4.o()
            if (r4 != r1) goto L_0x0053
        L_0x0050:
            r3 = r1
            goto L_0x010d
        L_0x0053:
            com.google.android.gms.measurement.internal.u4 r4 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()
            com.google.android.gms.measurement.internal.o3 r4 = r4.v()
            java.lang.String r5 = "Checking service availability"
            r4.a(r5)
            com.google.android.gms.measurement.internal.u4 r4 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r4 = r4.N()
            r5 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r4 = r4.r0(r5)
            if (r4 == 0) goto L_0x00fc
            if (r4 == r1) goto L_0x00ec
            r5 = 2
            if (r4 == r5) goto L_0x00c6
            r0 = 3
            if (r4 == r0) goto L_0x00b5
            r0 = 9
            if (r4 == r0) goto L_0x00a5
            r0 = 18
            if (r4 == r0) goto L_0x0095
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.String r4 = "Unexpected service status"
            r0.b(r4, r1)
            goto L_0x00c4
        L_0x0095:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()
            java.lang.String r3 = "Service updating"
            r0.a(r3)
            goto L_0x0050
        L_0x00a5:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()
            java.lang.String r1 = "Service invalid"
            r0.a(r1)
            goto L_0x00c4
        L_0x00b5:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()
            java.lang.String r1 = "Service disabled"
            r0.a(r1)
        L_0x00c4:
            r1 = r3
            goto L_0x010d
        L_0x00c6:
            com.google.android.gms.measurement.internal.u4 r4 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()
            com.google.android.gms.measurement.internal.o3 r4 = r4.q()
            java.lang.String r5 = "Service container out of date"
            r4.a(r5)
            com.google.android.gms.measurement.internal.u4 r4 = r7.f40059a
            com.google.android.gms.measurement.internal.t9 r4 = r4.N()
            int r4 = r4.q0()
            r5 = 17443(0x4423, float:2.4443E-41)
            if (r4 >= r5) goto L_0x00e4
            goto L_0x010d
        L_0x00e4:
            if (r0 != 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r1 = r3
        L_0x00e8:
            r6 = r3
            r3 = r1
            r1 = r6
            goto L_0x010d
        L_0x00ec:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.v()
            java.lang.String r4 = "Service missing"
            r0.a(r4)
            goto L_0x010d
        L_0x00fc:
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.v()
            java.lang.String r3 = "Service available"
            r0.a(r3)
            goto L_0x0050
        L_0x010d:
            if (r3 != 0) goto L_0x012b
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.g r0 = r0.z()
            boolean r0 = r0.G()
            if (r0 == 0) goto L_0x012b
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()
            java.lang.String r1 = "No way to upload. Consider using the full version of Analytics"
            r0.a(r1)
            goto L_0x0144
        L_0x012b:
            if (r1 == 0) goto L_0x0144
            com.google.android.gms.measurement.internal.u4 r0 = r7.f40059a
            com.google.android.gms.measurement.internal.e4 r0 = r0.F()
            r0.h()
            android.content.SharedPreferences r0 = r0.o()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r2, r3)
            r0.apply()
        L_0x0144:
            r1 = r3
        L_0x0145:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r7.f39879e = r0
        L_0x014b:
            java.lang.Boolean r0 = r7.f39879e
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.g8.B():boolean");
    }

    /* access modifiers changed from: package-private */
    public final Boolean J() {
        return this.f39879e;
    }

    /* access modifiers changed from: protected */
    public final void O() {
        h();
        i();
        zzq C = C(true);
        this.f40059a.C().r();
        F(new n7(this, C));
    }

    /* access modifiers changed from: package-private */
    public final void P() {
        h();
        i();
        if (!z()) {
            if (B()) {
                this.f39877c.d();
            } else if (!this.f40059a.z().G()) {
                this.f40059a.b();
                List<ResolveInfo> queryIntentServices = this.f40059a.c().getPackageManager().queryIntentServices(new Intent().setClassName(this.f40059a.c(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                    this.f40059a.d().r().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    return;
                }
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context c10 = this.f40059a.c();
                this.f40059a.b();
                intent.setComponent(new ComponentName(c10, "com.google.android.gms.measurement.AppMeasurementService"));
                this.f39877c.b(intent);
            }
        }
    }

    public final void Q() {
        h();
        i();
        this.f39877c.e();
        try {
            b.b().c(this.f40059a.c(), this.f39877c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f39878d = null;
    }

    public final void R(zzcf zzcf) {
        h();
        i();
        F(new m7(this, C(false), zzcf));
    }

    public final void S(AtomicReference atomicReference) {
        h();
        i();
        F(new l7(this, atomicReference, C(false)));
    }

    /* access modifiers changed from: protected */
    public final void T(zzcf zzcf, String str, String str2) {
        h();
        i();
        F(new y7(this, str, str2, C(false), zzcf));
    }

    /* access modifiers changed from: protected */
    public final void U(AtomicReference atomicReference, String str, String str2, String str3) {
        h();
        i();
        F(new x7(this, atomicReference, (String) null, str2, str3, C(false)));
    }

    /* access modifiers changed from: protected */
    public final void V(zzcf zzcf, String str, String str2, boolean z10) {
        h();
        i();
        F(new i7(this, str, str2, C(false), z10, zzcf));
    }

    /* access modifiers changed from: protected */
    public final void W(AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        h();
        i();
        F(new z7(this, atomicReference, (String) null, str2, str3, C(false), z10));
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void o(zzau zzau, String str) {
        p.k(zzau);
        h();
        i();
        G();
        F(new v7(this, true, C(true), this.f40059a.C().v(zzau), zzau, str));
    }

    public final void p(zzcf zzcf, zzau zzau, String str) {
        h();
        i();
        if (this.f40059a.N().r0(e.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            this.f40059a.d().w().a("Not bundling data. Service unavailable or out of date");
            this.f40059a.N().H(zzcf, new byte[0]);
            return;
        }
        F(new r7(this, zzau, str, zzcf));
    }

    /* access modifiers changed from: protected */
    public final void q() {
        h();
        i();
        zzq C = C(false);
        G();
        this.f40059a.C().q();
        F(new k7(this, C));
    }

    /* access modifiers changed from: package-private */
    public final void r(d dVar, AbstractSafeParcelable abstractSafeParcelable, zzq zzq) {
        int i10;
        h();
        i();
        G();
        this.f40059a.z();
        int i11 = 0;
        int i12 = 100;
        while (i11 < 1001 && i12 == 100) {
            ArrayList arrayList = new ArrayList();
            List p10 = this.f40059a.C().p(100);
            if (p10 != null) {
                arrayList.addAll(p10);
                i10 = p10.size();
            } else {
                i10 = 0;
            }
            if (abstractSafeParcelable != null && i10 < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            for (int i13 = 0; i13 < size; i13++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i13);
                if (abstractSafeParcelable2 instanceof zzau) {
                    try {
                        dVar.O((zzau) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e10) {
                        this.f40059a.d().r().b("Failed to send event to the service", e10);
                    }
                } else if (abstractSafeParcelable2 instanceof zzlk) {
                    try {
                        dVar.t0((zzlk) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e11) {
                        this.f40059a.d().r().b("Failed to send user property to the service", e11);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        dVar.j0((zzac) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e12) {
                        this.f40059a.d().r().b("Failed to send conditional user property to the service", e12);
                    }
                } else {
                    this.f40059a.d().r().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i11++;
            i12 = i10;
        }
    }

    /* access modifiers changed from: protected */
    public final void s(zzac zzac) {
        p.k(zzac);
        h();
        i();
        this.f40059a.b();
        F(new w7(this, true, C(true), this.f40059a.C().u(zzac), new zzac(zzac), zzac));
    }

    /* access modifiers changed from: protected */
    public final void t(boolean z10) {
        h();
        i();
        if (z10) {
            G();
            this.f40059a.C().q();
        }
        if (A()) {
            F(new u7(this, C(false)));
        }
    }

    /* access modifiers changed from: protected */
    public final void u(z6 z6Var) {
        h();
        i();
        F(new o7(this, z6Var));
    }

    public final void v(Bundle bundle) {
        h();
        i();
        F(new p7(this, C(false), bundle));
    }

    /* access modifiers changed from: protected */
    public final void w() {
        h();
        i();
        F(new t7(this, C(true)));
    }

    /* access modifiers changed from: protected */
    public final void x(d dVar) {
        h();
        p.k(dVar);
        this.f39878d = dVar;
        E();
        D();
    }

    /* access modifiers changed from: protected */
    public final void y(zzlk zzlk) {
        h();
        i();
        G();
        F(new j7(this, C(true), this.f40059a.C().w(zzlk), zzlk));
    }

    public final boolean z() {
        h();
        i();
        if (this.f39878d != null) {
            return true;
        }
        return false;
    }
}
