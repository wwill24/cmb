package gk;

import kotlin.jvm.internal.j;

public final class r {
    public static final int a(int i10, int i11) {
        return j.i(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j10, long j11) {
        return j.j(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
    }

    public static final String c(long j10) {
        return d(j10, 10);
    }

    public static final String d(long j10, int i10) {
        if (j10 >= 0) {
            String l10 = Long.toString(j10, b.a(i10));
            j.f(l10, "toString(this, checkRadix(radix))");
            return l10;
        }
        long j11 = (long) i10;
        long j12 = ((j10 >>> 1) / j11) << 1;
        long j13 = j10 - (j12 * j11);
        if (j13 >= j11) {
            j13 -= j11;
            j12++;
        }
        StringBuilder sb2 = new StringBuilder();
        String l11 = Long.toString(j12, b.a(i10));
        j.f(l11, "toString(this, checkRadix(radix))");
        sb2.append(l11);
        String l12 = Long.toString(j13, b.a(i10));
        j.f(l12, "toString(this, checkRadix(radix))");
        sb2.append(l12);
        return sb2.toString();
    }
}
