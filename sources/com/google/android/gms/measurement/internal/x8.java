package com.google.android.gms.measurement.internal;

import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.android.gms.common.internal.p;
import me.f;

final class x8 {

    /* renamed from: a  reason: collision with root package name */
    private final f f40414a;

    /* renamed from: b  reason: collision with root package name */
    private long f40415b;

    public x8(f fVar) {
        p.k(fVar);
        this.f40414a = fVar;
    }

    public final void a() {
        this.f40415b = 0;
    }

    public final void b() {
        this.f40415b = this.f40414a.b();
    }

    public final boolean c(long j10) {
        return this.f40415b == 0 || this.f40414a.b() - this.f40415b >= DateUtils.MILLIS_IN_HOUR;
    }
}
