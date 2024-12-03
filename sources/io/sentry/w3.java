package io.sentry;

import java.util.Date;

public final class w3 extends u2 {

    /* renamed from: a  reason: collision with root package name */
    private final Date f31784a;

    /* renamed from: b  reason: collision with root package name */
    private final long f31785b;

    public w3() {
        this(g.c(), System.nanoTime());
    }

    private long i(w3 w3Var, w3 w3Var2) {
        return w3Var.h() + (w3Var2.f31785b - w3Var.f31785b);
    }

    /* renamed from: a */
    public int compareTo(u2 u2Var) {
        if (!(u2Var instanceof w3)) {
            return super.compareTo(u2Var);
        }
        w3 w3Var = (w3) u2Var;
        long time = this.f31784a.getTime();
        long time2 = w3Var.f31784a.getTime();
        if (time == time2) {
            return Long.valueOf(this.f31785b).compareTo(Long.valueOf(w3Var.f31785b));
        }
        return Long.valueOf(time).compareTo(Long.valueOf(time2));
    }

    public long b(u2 u2Var) {
        if (u2Var instanceof w3) {
            return this.f31785b - ((w3) u2Var).f31785b;
        }
        return super.b(u2Var);
    }

    public long e(u2 u2Var) {
        if (u2Var == null || !(u2Var instanceof w3)) {
            return super.e(u2Var);
        }
        w3 w3Var = (w3) u2Var;
        if (compareTo(u2Var) < 0) {
            return i(this, w3Var);
        }
        return i(w3Var, this);
    }

    public long h() {
        return g.a(this.f31784a);
    }

    public w3(Date date, long j10) {
        this.f31784a = date;
        this.f31785b = j10;
    }
}
