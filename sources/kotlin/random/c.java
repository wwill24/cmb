package kotlin.random;

import kotlin.jvm.internal.j;
import kotlin.ranges.IntRange;

public final class c {
    public static final String a(Object obj, Object obj2) {
        j.g(obj, "from");
        j.g(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void b(int i10, int i11) {
        if (!(i11 > i10)) {
            throw new IllegalArgumentException(a(Integer.valueOf(i10), Integer.valueOf(i11)).toString());
        }
    }

    public static final int c(int i10) {
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public static final int d(Random random, IntRange intRange) {
        j.g(random, "<this>");
        j.g(intRange, "range");
        if (intRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + intRange);
        } else if (intRange.d() < Integer.MAX_VALUE) {
            return random.e(intRange.b(), intRange.d() + 1);
        } else {
            if (intRange.b() > Integer.MIN_VALUE) {
                return random.e(intRange.b() - 1, intRange.d()) + 1;
            }
            return random.c();
        }
    }

    public static final int e(int i10, int i11) {
        return (i10 >>> (32 - i11)) & ((-i11) >> 31);
    }
}
