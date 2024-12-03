package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.e;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import me.s;
import we.c;

public final class m5 extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final n9 f40032a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f40033b;

    /* renamed from: c  reason: collision with root package name */
    private String f40034c = null;

    public m5(n9 n9Var, String str) {
        p.k(n9Var);
        this.f40032a = n9Var;
    }

    private final void c(zzau zzau, zzq zzq) {
        this.f40032a.e();
        this.f40032a.j(zzau, zzq);
    }

    private final void x0(zzq zzq, boolean z10) {
        p.k(zzq);
        p.g(zzq.f40506a);
        y0(zzq.f40506a, false);
        this.f40032a.h0().M(zzq.f40507b, zzq.f40522w);
    }

    private final void y0(String str, boolean z10) {
        boolean z11;
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                try {
                    if (this.f40033b == null) {
                        if (!"com.google.android.gms".equals(this.f40034c) && !s.a(this.f40032a.c(), Binder.getCallingUid())) {
                            if (!f.a(this.f40032a.c()).c(Binder.getCallingUid())) {
                                z11 = false;
                                this.f40033b = Boolean.valueOf(z11);
                            }
                        }
                        z11 = true;
                        this.f40033b = Boolean.valueOf(z11);
                    }
                    if (this.f40033b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e10) {
                    this.f40032a.d().r().b("Measurement Service called with invalid calling package. appId", q3.z(str));
                    throw e10;
                }
            }
            if (this.f40034c == null && e.uidHasPackageName(this.f40032a.c(), Binder.getCallingUid(), str)) {
                this.f40034c = str;
            }
            if (!str.equals(this.f40034c)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.f40032a.d().r().a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    public final void B(zzq zzq) {
        p.g(zzq.f40506a);
        y0(zzq.f40506a, false);
        w0(new c5(this, zzq));
    }

    public final void H(zzq zzq) {
        x0(zzq, false);
        w0(new d5(this, zzq));
    }

    public final void I(zzau zzau, String str, String str2) {
        p.k(zzau);
        p.g(str);
        y0(str, true);
        w0(new g5(this, zzau, str));
    }

    public final void J(Bundle bundle, zzq zzq) {
        x0(zzq, false);
        String str = zzq.f40506a;
        p.k(str);
        w0(new v4(this, str, bundle));
    }

    public final List K(String str, String str2, String str3, boolean z10) {
        y0(str, true);
        try {
            List<r9> list = (List) this.f40032a.f().s(new z4(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (r9 r9Var : list) {
                if (z10 || !t9.Y(r9Var.f40233c)) {
                    arrayList.add(new zzlk(r9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f40032a.d().r().c("Failed to get user properties as. appId", q3.z(str), e10);
            return Collections.emptyList();
        }
    }

    public final String M(zzq zzq) {
        x0(zzq, false);
        return this.f40032a.j0(zzq);
    }

    public final void O(zzau zzau, zzq zzq) {
        p.k(zzau);
        x0(zzq, false);
        w0(new f5(this, zzau, zzq));
    }

    public final List P(String str, String str2, String str3) {
        y0(str, true);
        try {
            return (List) this.f40032a.f().s(new b5(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f40032a.d().r().b("Failed to get conditional user properties as", e10);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    public final void W(zzau zzau, zzq zzq) {
        zzc zzc;
        if (!this.f40032a.Z().C(zzq.f40506a)) {
            c(zzau, zzq);
            return;
        }
        this.f40032a.d().v().b("EES config found for", zzq.f40506a);
        o4 Z = this.f40032a.Z();
        String str = zzq.f40506a;
        if (TextUtils.isEmpty(str)) {
            zzc = null;
        } else {
            zzc = (zzc) Z.f40109j.get(str);
        }
        if (zzc != null) {
            try {
                Map K = this.f40032a.g0().K(zzau.f40492b.Y(), true);
                String a10 = we.p.a(zzau.f40491a);
                if (a10 == null) {
                    a10 = zzau.f40491a;
                }
                if (zzc.zze(new zzaa(a10, zzau.f40494d, K))) {
                    if (zzc.zzg()) {
                        this.f40032a.d().v().b("EES edited event", zzau.f40491a);
                        c(this.f40032a.g0().C(zzc.zza().zzb()), zzq);
                    } else {
                        c(zzau, zzq);
                    }
                    if (zzc.zzf()) {
                        for (zzaa zzaa : zzc.zza().zzc()) {
                            this.f40032a.d().v().b("EES logging created event", zzaa.zzd());
                            c(this.f40032a.g0().C(zzaa), zzq);
                        }
                        return;
                    }
                    return;
                }
            } catch (zzd unused) {
                this.f40032a.d().r().c("EES error. appId, eventName", zzq.f40507b, zzau.f40491a);
            }
            this.f40032a.d().v().b("EES was not applied to event", zzau.f40491a);
            c(zzau, zzq);
            return;
        }
        this.f40032a.d().v().b("EES not loaded for", zzq.f40506a);
        c(zzau, zzq);
    }

    public final List Z(String str, String str2, zzq zzq) {
        x0(zzq, false);
        String str3 = zzq.f40506a;
        p.k(str3);
        try {
            return (List) this.f40032a.f().s(new a5(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f40032a.d().r().b("Failed to get conditional user properties", e10);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    public final zzau f(zzau zzau, zzq zzq) {
        zzas zzas;
        if (!(!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzau.f40491a) || (zzas = zzau.f40492b) == null || zzas.zza() == 0)) {
            String m02 = zzau.f40492b.m0("_cis");
            if ("referrer broadcast".equals(m02) || "referrer API".equals(m02)) {
                this.f40032a.d().u().b("Event has been filtered ", zzau.toString());
                return new zzau("_cmpx", zzau.f40492b, zzau.f40493c, zzau.f40494d);
            }
        }
        return zzau;
    }

    public final void i(zzac zzac) {
        p.k(zzac);
        p.k(zzac.f40481c);
        p.g(zzac.f40479a);
        y0(zzac.f40479a, true);
        w0(new x4(this, new zzac(zzac)));
    }

    public final List j(zzq zzq, boolean z10) {
        x0(zzq, false);
        String str = zzq.f40506a;
        p.k(str);
        try {
            List<r9> list = (List) this.f40032a.f().s(new j5(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (r9 r9Var : list) {
                if (z10 || !t9.Y(r9Var.f40233c)) {
                    arrayList.add(new zzlk(r9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f40032a.d().r().c("Failed to get user properties. appId", q3.z(zzq.f40506a), e10);
            return null;
        }
    }

    public final void j0(zzac zzac, zzq zzq) {
        p.k(zzac);
        p.k(zzac.f40481c);
        x0(zzq, false);
        zzac zzac2 = new zzac(zzac);
        zzac2.f40479a = zzq.f40506a;
        w0(new w4(this, zzac2, zzq));
    }

    public final byte[] r0(zzau zzau, String str) {
        p.g(str);
        p.k(zzau);
        y0(str, true);
        this.f40032a.d().q().b("Log and bundle. event", this.f40032a.W().d(zzau.f40491a));
        long a10 = this.f40032a.a().a() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f40032a.f().t(new h5(this, zzau, str)).get();
            if (bArr == null) {
                this.f40032a.d().r().b("Log and bundle returned null. appId", q3.z(str));
                bArr = new byte[0];
            }
            this.f40032a.d().q().d("Log and bundle processed. event, size, time_ms", this.f40032a.W().d(zzau.f40491a), Integer.valueOf(bArr.length), Long.valueOf((this.f40032a.a().a() / 1000000) - a10));
            return bArr;
        } catch (InterruptedException | ExecutionException e10) {
            this.f40032a.d().r().d("Failed to log and bundle. appId, event, error", q3.z(str), this.f40032a.W().d(zzau.f40491a), e10);
            return null;
        }
    }

    public final void s(zzq zzq) {
        x0(zzq, false);
        w0(new k5(this, zzq));
    }

    public final void t0(zzlk zzlk, zzq zzq) {
        p.k(zzlk);
        x0(zzq, false);
        w0(new i5(this, zzlk, zzq));
    }

    public final void v(long j10, String str, String str2, String str3) {
        w0(new l5(this, str2, str3, str, j10));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void v0(String str, Bundle bundle) {
        k V = this.f40032a.V();
        V.h();
        V.i();
        byte[] zzbx = V.f39651b.g0().D(new p(V.f40059a, "", str, "dep", 0, 0, bundle)).zzbx();
        V.f40059a.d().v().c("Saving default event parameters, appId, data size", V.f40059a.D().d(str), Integer.valueOf(zzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbx);
        try {
            if (V.P().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                V.f40059a.d().r().b("Failed to insert default event parameters (got -1). appId", q3.z(str));
            }
        } catch (SQLiteException e10) {
            V.f40059a.d().r().c("Error storing default event parameters. appId", q3.z(str), e10);
        }
    }

    /* access modifiers changed from: package-private */
    public final void w0(Runnable runnable) {
        p.k(runnable);
        if (this.f40032a.f().C()) {
            runnable.run();
        } else {
            this.f40032a.f().z(runnable);
        }
    }

    public final void y(zzq zzq) {
        p.g(zzq.f40506a);
        p.k(zzq.C);
        e5 e5Var = new e5(this, zzq);
        p.k(e5Var);
        if (this.f40032a.f().C()) {
            e5Var.run();
        } else {
            this.f40032a.f().A(e5Var);
        }
    }

    public final List z(String str, String str2, boolean z10, zzq zzq) {
        x0(zzq, false);
        String str3 = zzq.f40506a;
        p.k(str3);
        try {
            List<r9> list = (List) this.f40032a.f().s(new y4(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (r9 r9Var : list) {
                if (z10 || !t9.Y(r9Var.f40233c)) {
                    arrayList.add(new zzlk(r9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f40032a.d().r().c("Failed to query user properties. appId", q3.z(zzq.f40506a), e10);
            return Collections.emptyList();
        }
    }
}
