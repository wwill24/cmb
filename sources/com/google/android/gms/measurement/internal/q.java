package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;

final class q {

    /* renamed from: a  reason: collision with root package name */
    final String f40145a;

    /* renamed from: b  reason: collision with root package name */
    final String f40146b;

    /* renamed from: c  reason: collision with root package name */
    final long f40147c;

    /* renamed from: d  reason: collision with root package name */
    final long f40148d;

    /* renamed from: e  reason: collision with root package name */
    final long f40149e;

    /* renamed from: f  reason: collision with root package name */
    final long f40150f;

    /* renamed from: g  reason: collision with root package name */
    final long f40151g;

    /* renamed from: h  reason: collision with root package name */
    final Long f40152h;

    /* renamed from: i  reason: collision with root package name */
    final Long f40153i;

    /* renamed from: j  reason: collision with root package name */
    final Long f40154j;

    /* renamed from: k  reason: collision with root package name */
    final Boolean f40155k;

    q(String str, String str2, long j10, long j11, long j12, long j13, long j14, Long l10, Long l11, Long l12, Boolean bool) {
        boolean z10;
        boolean z11;
        boolean z12;
        long j15 = j10;
        long j16 = j11;
        long j17 = j12;
        long j18 = j14;
        p.g(str);
        p.g(str2);
        boolean z13 = true;
        if (j15 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.a(z10);
        if (j16 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        p.a(z11);
        if (j17 >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        p.a(z12);
        p.a(j18 < 0 ? false : z13);
        this.f40145a = str;
        this.f40146b = str2;
        this.f40147c = j15;
        this.f40148d = j16;
        this.f40149e = j17;
        this.f40150f = j13;
        this.f40151g = j18;
        this.f40152h = l10;
        this.f40153i = l11;
        this.f40154j = l12;
        this.f40155k = bool;
    }

    /* access modifiers changed from: package-private */
    public final q a(Long l10, Long l11, Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
        }
        return new q(this.f40145a, this.f40146b, this.f40147c, this.f40148d, this.f40149e, this.f40150f, this.f40151g, this.f40152h, l10, l11, bool);
    }

    /* access modifiers changed from: package-private */
    public final q b(long j10, long j11) {
        return new q(this.f40145a, this.f40146b, this.f40147c, this.f40148d, this.f40149e, this.f40150f, j10, Long.valueOf(j11), this.f40153i, this.f40154j, this.f40155k);
    }

    /* access modifiers changed from: package-private */
    public final q c(long j10) {
        return new q(this.f40145a, this.f40146b, this.f40147c, this.f40148d, this.f40149e, j10, this.f40151g, this.f40152h, this.f40153i, this.f40154j, this.f40155k);
    }
}
