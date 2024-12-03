package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzby;

public final class w8 extends w3 {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Handler f40391c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40392d = true;

    /* renamed from: e  reason: collision with root package name */
    protected final v8 f40393e = new v8(this);

    /* renamed from: f  reason: collision with root package name */
    protected final u8 f40394f = new u8(this);

    /* renamed from: g  reason: collision with root package name */
    protected final s8 f40395g = new s8(this);

    w8(u4 u4Var) {
        super(u4Var);
    }

    static /* bridge */ /* synthetic */ void q(w8 w8Var, long j10) {
        w8Var.h();
        w8Var.u();
        w8Var.f40059a.d().v().b("Activity paused, time", Long.valueOf(j10));
        w8Var.f40395g.a(j10);
        if (w8Var.f40059a.z().D()) {
            w8Var.f40394f.b(j10);
        }
    }

    static /* bridge */ /* synthetic */ void r(w8 w8Var, long j10) {
        w8Var.h();
        w8Var.u();
        w8Var.f40059a.d().v().b("Activity resumed, time", Long.valueOf(j10));
        if (w8Var.f40059a.z().B((String) null, g3.I0)) {
            if (w8Var.f40059a.z().D() || w8Var.f40392d) {
                w8Var.f40394f.c(j10);
            }
        } else if (w8Var.f40059a.z().D() || w8Var.f40059a.F().f39753r.b()) {
            w8Var.f40394f.c(j10);
        }
        w8Var.f40395g.b();
        v8 v8Var = w8Var.f40393e;
        v8Var.f40370a.h();
        if (v8Var.f40370a.f40059a.o()) {
            v8Var.b(v8Var.f40370a.f40059a.a().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    public final void u() {
        h();
        if (this.f40391c == null) {
            this.f40391c = new zzby(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void s(boolean z10) {
        h();
        this.f40392d = z10;
    }

    /* access modifiers changed from: package-private */
    public final boolean t() {
        h();
        return this.f40392d;
    }
}
