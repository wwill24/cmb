package org.bouncycastle.pqc.math.linearalgebra;

import java.io.PrintStream;
import org.jivesoftware.smack.datatypes.UInt32;

public final class PolynomialRingGF2 {
    private PolynomialRingGF2() {
    }

    public static int add(int i10, int i11) {
        return i10 ^ i11;
    }

    public static int degree(int i10) {
        int i11 = -1;
        while (i10 != 0) {
            i11++;
            i10 >>>= 1;
        }
        return i11;
    }

    public static int degree(long j10) {
        int i10 = 0;
        while (j10 != 0) {
            i10++;
            j10 >>>= 1;
        }
        return i10 - 1;
    }

    public static int gcd(int i10, int i11) {
        while (true) {
            int i12 = i11;
            int i13 = i10;
            i10 = i12;
            if (i10 == 0) {
                return i13;
            }
            i11 = remainder(i13, i10);
        }
    }

    public static int getIrreduciblePolynomial(int i10) {
        PrintStream printStream;
        String str;
        if (i10 < 0) {
            printStream = System.err;
            str = "The Degree is negative";
        } else if (i10 > 31) {
            printStream = System.err;
            str = "The Degree is more then 31";
        } else if (i10 == 0) {
            return 1;
        } else {
            int i11 = 1 << (i10 + 1);
            for (int i12 = (1 << i10) + 1; i12 < i11; i12 += 2) {
                if (isIrreducible(i12)) {
                    return i12;
                }
            }
            return 0;
        }
        printStream.println(str);
        return 0;
    }

    public static boolean isIrreducible(int i10) {
        if (i10 == 0) {
            return false;
        }
        int degree = degree(i10) >>> 1;
        int i11 = 2;
        for (int i12 = 0; i12 < degree; i12++) {
            i11 = modMultiply(i11, i11, i10);
            if (gcd(i11 ^ 2, i10) != 1) {
                return false;
            }
        }
        return true;
    }

    public static int modMultiply(int i10, int i11, int i12) {
        int remainder = remainder(i10, i12);
        int remainder2 = remainder(i11, i12);
        int i13 = 0;
        if (remainder2 != 0) {
            int degree = 1 << degree(i12);
            while (remainder != 0) {
                if (((byte) (remainder & 1)) == 1) {
                    i13 ^= remainder2;
                }
                remainder >>>= 1;
                remainder2 <<= 1;
                if (remainder2 >= degree) {
                    remainder2 ^= i12;
                }
            }
        }
        return i13;
    }

    public static long multiply(int i10, int i11) {
        long j10 = 0;
        if (i11 != 0) {
            long j11 = ((long) i11) & UInt32.MAX_VALUE_LONG;
            while (i10 != 0) {
                if (((byte) (i10 & 1)) == 1) {
                    j10 ^= j11;
                }
                i10 >>>= 1;
                j11 <<= 1;
            }
        }
        return j10;
    }

    public static int remainder(int i10, int i11) {
        if (i11 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (degree(i10) >= degree(i11)) {
            i10 ^= i11 << (degree(i10) - degree(i11));
        }
        return i10;
    }

    public static int rest(long j10, int i10) {
        if (i10 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        long j11 = ((long) i10) & UInt32.MAX_VALUE_LONG;
        while ((j10 >>> 32) != 0) {
            j10 ^= j11 << (degree(j10) - degree(j11));
        }
        int i11 = (int) (j10 & -1);
        while (degree(i11) >= degree(i10)) {
            i11 ^= i10 << (degree(i11) - degree(i10));
        }
        return i11;
    }
}
