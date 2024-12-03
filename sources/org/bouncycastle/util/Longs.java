package org.bouncycastle.util;

public class Longs {
    public static final int BYTES = 8;
    public static final int SIZE = 64;

    public static int numberOfLeadingZeros(long j10) {
        return Long.numberOfLeadingZeros(j10);
    }

    public static int numberOfTrailingZeros(long j10) {
        return Long.numberOfTrailingZeros(j10);
    }

    public static long reverse(long j10) {
        return Long.reverse(j10);
    }

    public static long reverseBytes(long j10) {
        return Long.reverseBytes(j10);
    }

    public static long rotateLeft(long j10, int i10) {
        return Long.rotateLeft(j10, i10);
    }

    public static long rotateRight(long j10, int i10) {
        return Long.rotateRight(j10, i10);
    }

    public static Long valueOf(long j10) {
        return Long.valueOf(j10);
    }
}
