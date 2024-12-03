package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzgd;
import java.util.ArrayList;
import java.util.List;
import we.y;

final class l9 {

    /* renamed from: a  reason: collision with root package name */
    zzgd f40021a;

    /* renamed from: b  reason: collision with root package name */
    List f40022b;

    /* renamed from: c  reason: collision with root package name */
    List f40023c;

    /* renamed from: d  reason: collision with root package name */
    long f40024d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ n9 f40025e;

    /* synthetic */ l9(n9 n9Var, y yVar) {
        this.f40025e = n9Var;
    }

    private static final long b(zzft zzft) {
        return ((zzft.zzd() / 1000) / 60) / 60;
    }

    public final boolean a(long j10, zzft zzft) {
        p.k(zzft);
        if (this.f40023c == null) {
            this.f40023c = new ArrayList();
        }
        if (this.f40022b == null) {
            this.f40022b = new ArrayList();
        }
        if (!this.f40023c.isEmpty() && b((zzft) this.f40023c.get(0)) != b(zzft)) {
            return false;
        }
        long zzbz = this.f40024d + ((long) zzft.zzbz());
        this.f40025e.U();
        if (zzbz >= ((long) Math.max(0, ((Integer) g3.f39825k.a((Object) null)).intValue()))) {
            return false;
        }
        this.f40024d = zzbz;
        this.f40023c.add(zzft);
        this.f40022b.add(Long.valueOf(j10));
        int size = this.f40023c.size();
        this.f40025e.U();
        if (size >= Math.max(1, ((Integer) g3.f39827l.a((Object) null)).intValue())) {
            return false;
        }
        return true;
    }
}
