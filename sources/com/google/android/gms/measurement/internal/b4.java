package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.p;

public final class b4 {

    /* renamed from: a  reason: collision with root package name */
    private final String f39669a;

    /* renamed from: b  reason: collision with root package name */
    private final long f39670b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f39671c;

    /* renamed from: d  reason: collision with root package name */
    private long f39672d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ e4 f39673e;

    public b4(e4 e4Var, String str, long j10) {
        this.f39673e = e4Var;
        p.g(str);
        this.f39669a = str;
        this.f39670b = j10;
    }

    public final long a() {
        if (!this.f39671c) {
            this.f39671c = true;
            this.f39672d = this.f39673e.o().getLong(this.f39669a, this.f39670b);
        }
        return this.f39672d;
    }

    public final void b(long j10) {
        SharedPreferences.Editor edit = this.f39673e.o().edit();
        edit.putLong(this.f39669a, j10);
        edit.apply();
        this.f39672d = j10;
    }
}
