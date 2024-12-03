package kotlin.text;

import kotlin.jvm.internal.j;

class q extends p {
    public static Integer j(String str) {
        j.g(str, "<this>");
        return k(str, 10);
    }

    public static final Integer k(String str, int i10) {
        boolean z10;
        int i11;
        j.g(str, "<this>");
        int unused = b.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char charAt = str.charAt(0);
        int i13 = -2147483647;
        int i14 = 1;
        if (j.i(charAt, 48) >= 0) {
            z10 = false;
            i14 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i13 = Integer.MIN_VALUE;
                z10 = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z10 = false;
            }
        }
        int i15 = -59652323;
        while (i14 < length) {
            int b10 = b.b(str.charAt(i14), i10);
            if (b10 < 0) {
                return null;
            }
            if ((i12 < i15 && (i15 != -59652323 || i12 < (i15 = i13 / i10))) || (i11 = i12 * i10) < i13 + b10) {
                return null;
            }
            i12 = i11 - b10;
            i14++;
        }
        if (z10) {
            return Integer.valueOf(i12);
        }
        return Integer.valueOf(-i12);
    }

    public static Long l(String str) {
        j.g(str, "<this>");
        return m(str, 10);
    }

    public static final Long m(String str, int i10) {
        String str2 = str;
        int i11 = i10;
        j.g(str2, "<this>");
        int unused = b.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char charAt = str2.charAt(0);
        long j10 = -9223372036854775807L;
        boolean z10 = true;
        if (j.i(charAt, 48) >= 0) {
            z10 = false;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                j10 = Long.MIN_VALUE;
                i12 = 1;
            } else if (charAt != '+') {
                return null;
            } else {
                z10 = false;
                i12 = 1;
            }
        }
        long j11 = -256204778801521550L;
        long j12 = 0;
        long j13 = -256204778801521550L;
        while (i12 < length) {
            int b10 = b.b(str2.charAt(i12), i11);
            if (b10 < 0) {
                return null;
            }
            if (j12 < j13) {
                if (j13 == j11) {
                    j13 = j10 / ((long) i11);
                    if (j12 < j13) {
                    }
                }
                return null;
            }
            long j14 = j12 * ((long) i11);
            long j15 = (long) b10;
            if (j14 < j10 + j15) {
                return null;
            }
            j12 = j14 - j15;
            i12++;
            j11 = -256204778801521550L;
        }
        if (z10) {
            return Long.valueOf(j12);
        }
        return Long.valueOf(-j12);
    }
}
