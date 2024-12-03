package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.p;
import we.g;

public final class c4 {

    /* renamed from: a  reason: collision with root package name */
    final String f39696a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39697b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39698c;

    /* renamed from: d  reason: collision with root package name */
    private final long f39699d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ e4 f39700e;

    /* synthetic */ c4(e4 e4Var, String str, long j10, g gVar) {
        boolean z10;
        this.f39700e = e4Var;
        p.g("health_monitor");
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.a(z10);
        this.f39696a = "health_monitor:start";
        this.f39697b = "health_monitor:count";
        this.f39698c = "health_monitor:value";
        this.f39699d = j10;
    }

    private final long c() {
        return this.f39700e.o().getLong(this.f39696a, 0);
    }

    private final void d() {
        this.f39700e.h();
        long currentTimeMillis = this.f39700e.f40059a.a().currentTimeMillis();
        SharedPreferences.Editor edit = this.f39700e.o().edit();
        edit.remove(this.f39697b);
        edit.remove(this.f39698c);
        edit.putLong(this.f39696a, currentTimeMillis);
        edit.apply();
    }

    public final Pair a() {
        long j10;
        this.f39700e.h();
        this.f39700e.h();
        long c10 = c();
        if (c10 == 0) {
            d();
            j10 = 0;
        } else {
            j10 = Math.abs(c10 - this.f39700e.f40059a.a().currentTimeMillis());
        }
        long j11 = this.f39699d;
        if (j10 < j11) {
            return null;
        }
        if (j10 > j11 + j11) {
            d();
            return null;
        }
        String string = this.f39700e.o().getString(this.f39698c, (String) null);
        long j12 = this.f39700e.o().getLong(this.f39697b, 0);
        d();
        if (string == null || j12 <= 0) {
            return e4.f39737y;
        }
        return new Pair(string, Long.valueOf(j12));
    }

    public final void b(String str, long j10) {
        this.f39700e.h();
        if (c() == 0) {
            d();
        }
        if (str == null) {
            str = "";
        }
        long j11 = this.f39700e.o().getLong(this.f39697b, 0);
        if (j11 <= 0) {
            SharedPreferences.Editor edit = this.f39700e.o().edit();
            edit.putString(this.f39698c, str);
            edit.putLong(this.f39697b, 1);
            edit.apply();
            return;
        }
        long j12 = j11 + 1;
        SharedPreferences.Editor edit2 = this.f39700e.o().edit();
        if ((this.f39700e.f40059a.N().u().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j12) {
            edit2.putString(this.f39698c, str);
        }
        edit2.putLong(this.f39697b, j12);
        edit2.apply();
    }
}
