package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.android.gms.internal.measurement.zzph;

final class u8 {

    /* renamed from: a  reason: collision with root package name */
    protected long f40343a;

    /* renamed from: b  reason: collision with root package name */
    protected long f40344b;

    /* renamed from: c  reason: collision with root package name */
    private final n f40345c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ w8 f40346d;

    public u8(w8 w8Var) {
        this.f40346d = w8Var;
        this.f40345c = new t8(this, w8Var.f40059a);
        long b10 = w8Var.f40059a.a().b();
        this.f40343a = b10;
        this.f40344b = b10;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f40345c.b();
        this.f40343a = 0;
        this.f40344b = 0;
    }

    /* access modifiers changed from: package-private */
    public final void b(long j10) {
        this.f40345c.b();
    }

    /* access modifiers changed from: package-private */
    public final void c(long j10) {
        this.f40346d.h();
        this.f40345c.b();
        this.f40343a = j10;
        this.f40344b = j10;
    }

    public final boolean d(boolean z10, boolean z11, long j10) {
        this.f40346d.h();
        this.f40346d.i();
        zzph.zzc();
        if (!this.f40346d.f40059a.z().B((String) null, g3.f39820h0)) {
            this.f40346d.f40059a.F().f39750o.b(this.f40346d.f40059a.a().currentTimeMillis());
        } else if (this.f40346d.f40059a.o()) {
            this.f40346d.f40059a.F().f39750o.b(this.f40346d.f40059a.a().currentTimeMillis());
        }
        long j11 = j10 - this.f40343a;
        if (z10 || j11 >= 1000) {
            if (!z11) {
                j11 = j10 - this.f40344b;
                this.f40344b = j10;
            }
            this.f40346d.f40059a.d().v().b("Recording user engagement, ms", Long.valueOf(j11));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j11);
            t9.y(this.f40346d.f40059a.K().s(!this.f40346d.f40059a.z().D()), bundle, true);
            if (!z11) {
                this.f40346d.f40059a.I().u("auto", "_e", bundle);
            }
            this.f40343a = j10;
            this.f40345c.b();
            this.f40345c.d(DateUtils.MILLIS_IN_HOUR);
            return true;
        }
        this.f40346d.f40059a.d().v().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j11));
        return false;
    }
}
