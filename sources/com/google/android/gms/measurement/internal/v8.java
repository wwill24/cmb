package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzos;
import com.google.android.gms.internal.measurement.zzqu;

final class v8 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w8 f40370a;

    v8(w8 w8Var) {
        this.f40370a = w8Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f40370a.h();
        if (this.f40370a.f40059a.F().v(this.f40370a.f40059a.a().currentTimeMillis())) {
            this.f40370a.f40059a.F().f39747l.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f40370a.f40059a.d().v().a("Detected application was in foreground");
                c(this.f40370a.f40059a.a().currentTimeMillis(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(long j10, boolean z10) {
        this.f40370a.h();
        this.f40370a.u();
        if (this.f40370a.f40059a.F().v(j10)) {
            this.f40370a.f40059a.F().f39747l.a(true);
            zzqu.zzc();
            if (this.f40370a.f40059a.z().B((String) null, g3.f39836p0)) {
                this.f40370a.f40059a.B().v();
            }
        }
        this.f40370a.f40059a.F().f39750o.b(j10);
        if (this.f40370a.f40059a.F().f39747l.b()) {
            c(j10, z10);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(long j10, boolean z10) {
        this.f40370a.h();
        if (this.f40370a.f40059a.o()) {
            this.f40370a.f40059a.F().f39750o.b(j10);
            this.f40370a.f40059a.d().v().b("Session started, time", Long.valueOf(this.f40370a.f40059a.a().b()));
            Long valueOf = Long.valueOf(j10 / 1000);
            this.f40370a.f40059a.I().M("auto", "_sid", valueOf, j10);
            this.f40370a.f40059a.F().f39751p.b(valueOf.longValue());
            this.f40370a.f40059a.F().f39747l.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.f40370a.f40059a.z().B((String) null, g3.f39812d0) && z10) {
                bundle.putLong("_aib", 1);
            }
            this.f40370a.f40059a.I().v("auto", "_s", j10, bundle);
            zzos.zzc();
            if (this.f40370a.f40059a.z().B((String) null, g3.f39818g0)) {
                String a10 = this.f40370a.f40059a.F().f39756u.a();
                if (!TextUtils.isEmpty(a10)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", a10);
                    this.f40370a.f40059a.I().v("auto", "_ssr", j10, bundle2);
                }
            }
        }
    }
}
