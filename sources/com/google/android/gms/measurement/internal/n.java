package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzby;

abstract class n {

    /* renamed from: d  reason: collision with root package name */
    private static volatile Handler f40044d;

    /* renamed from: a  reason: collision with root package name */
    private final p5 f40045a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f40046b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile long f40047c;

    n(p5 p5Var) {
        p.k(p5Var);
        this.f40045a = p5Var;
        this.f40046b = new m(this, p5Var);
    }

    private final Handler f() {
        Handler handler;
        if (f40044d != null) {
            return f40044d;
        }
        synchronized (n.class) {
            if (f40044d == null) {
                f40044d = new zzby(this.f40045a.c().getMainLooper());
            }
            handler = f40044d;
        }
        return handler;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f40047c = 0;
        f().removeCallbacks(this.f40046b);
    }

    public abstract void c();

    public final void d(long j10) {
        b();
        if (j10 >= 0) {
            this.f40047c = this.f40045a.a().currentTimeMillis();
            if (!f().postDelayed(this.f40046b, j10)) {
                this.f40045a.d().r().b("Failed to schedule delayed post. time", Long.valueOf(j10));
            }
        }
    }

    public final boolean e() {
        return this.f40047c != 0;
    }
}
