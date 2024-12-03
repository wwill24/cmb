package org.bouncycastle.util;

public class Integers {
    public static final int BYTES = 4;
    public static final int SIZE = 32;

    public static int numberOfLeadingZeros(int i10) {
        return Integer.numberOfLeadingZeros(i10);
    }

    public static int numberOfTrailingZeros(int i10) {
        return Integer.numberOfTrailingZeros(i10);
    }

    public static int reverse(int i10) {
        return Integer.reverse(i10);
    }

    public static int reverseBytes(int i10) {
        return Integer.reverseBytes(i10);
    }

    public static int rotateLeft(int i10, int i11) {
        return Integer.rotateLeft(i10, i11);
    }

    public static int rotateRight(int i10, int i11) {
        return Integer.rotateRight(i10, i11);
    }

    public static Integer valueOf(int i10) {
        return Integer.valueOf(i10);
    }
}
