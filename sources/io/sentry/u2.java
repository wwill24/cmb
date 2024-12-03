package io.sentry;

public abstract class u2 implements Comparable<u2> {
    /* renamed from: a */
    public int compareTo(u2 u2Var) {
        return Long.valueOf(h()).compareTo(Long.valueOf(u2Var.h()));
    }

    public long b(u2 u2Var) {
        return h() - u2Var.h();
    }

    public final boolean c(u2 u2Var) {
        return b(u2Var) > 0;
    }

    public final boolean d(u2 u2Var) {
        return b(u2Var) < 0;
    }

    public long e(u2 u2Var) {
        if (u2Var == null || compareTo(u2Var) >= 0) {
            return h();
        }
        return u2Var.h();
    }

    public abstract long h();
}
