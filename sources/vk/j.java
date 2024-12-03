package vk;

import java.util.NoSuchElementException;
import kotlin.random.Random;
import kotlin.random.c;
import kotlin.ranges.IntRange;
import kotlin.ranges.a;

class j extends i {
    public static float b(float f10, float f11) {
        return f10 < f11 ? f11 : f10;
    }

    public static int c(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static long d(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    public static double e(double d10, double d11) {
        return d10 > d11 ? d11 : d10;
    }

    public static float f(float f10, float f11) {
        return f10 > f11 ? f11 : f10;
    }

    public static int g(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static long h(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static double i(double d10, double d11, double d12) {
        if (d11 <= d12) {
            return d10 < d11 ? d11 : d10 > d12 ? d12 : d10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d12 + " is less than minimum " + d11 + '.');
    }

    public static int j(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    public static long k(long j10, long j11, long j12) {
        if (j11 <= j12) {
            return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j12 + " is less than minimum " + j11 + '.');
    }

    public static a l(int i10, int i11) {
        return a.f32148d.a(i10, i11, -1);
    }

    public static int m(IntRange intRange, Random random) {
        kotlin.jvm.internal.j.g(intRange, "<this>");
        kotlin.jvm.internal.j.g(random, "random");
        try {
            return c.d(random, intRange);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    public static a n(a aVar, int i10) {
        boolean z10;
        kotlin.jvm.internal.j.g(aVar, "<this>");
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        i.a(z10, Integer.valueOf(i10));
        a.C0370a aVar2 = a.f32148d;
        int b10 = aVar.b();
        int d10 = aVar.d();
        if (aVar.f() <= 0) {
            i10 = -i10;
        }
        return aVar2.a(b10, d10, i10);
    }

    public static IntRange o(int i10, int i11) {
        if (i11 <= Integer.MIN_VALUE) {
            return IntRange.f32146e.a();
        }
        return new IntRange(i10, i11 - 1);
    }
}
