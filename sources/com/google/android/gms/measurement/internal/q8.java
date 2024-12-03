package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzqo;

public final /* synthetic */ class q8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r8 f40207a;

    public /* synthetic */ q8(r8 r8Var) {
        this.f40207a = r8Var;
    }

    public final void run() {
        r8 r8Var = this.f40207a;
        s8 s8Var = r8Var.f40230c;
        long j10 = r8Var.f40228a;
        long j11 = r8Var.f40229b;
        s8Var.f40266b.h();
        s8Var.f40266b.f40059a.d().q().a("Application going to the background");
        s8Var.f40266b.f40059a.F().f39753r.a(true);
        s8Var.f40266b.s(true);
        if (!s8Var.f40266b.f40059a.z().D()) {
            s8Var.f40266b.f40394f.b(j11);
            s8Var.f40266b.f40394f.d(false, false, j11);
        }
        zzqo.zzc();
        if (s8Var.f40266b.f40059a.z().B((String) null, g3.D0)) {
            s8Var.f40266b.f40059a.d().u().b("Application backgrounded at: timestamp_millis", Long.valueOf(j10));
        } else {
            s8Var.f40266b.f40059a.I().v("auto", "_ab", j10, new Bundle());
        }
    }
}
