package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.p;

public final class z3 {

    /* renamed from: a  reason: collision with root package name */
    private final String f40445a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f40446b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40447c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40448d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ e4 f40449e;

    public z3(e4 e4Var, String str, boolean z10) {
        this.f40449e = e4Var;
        p.g(str);
        this.f40445a = str;
        this.f40446b = z10;
    }

    public final void a(boolean z10) {
        SharedPreferences.Editor edit = this.f40449e.o().edit();
        edit.putBoolean(this.f40445a, z10);
        edit.apply();
        this.f40448d = z10;
    }

    public final boolean b() {
        if (!this.f40447c) {
            this.f40447c = true;
            this.f40448d = this.f40449e.o().getBoolean(this.f40445a, this.f40446b);
        }
        return this.f40448d;
    }
}
