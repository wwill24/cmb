package org.bouncycastle.math.raw;

public abstract class Bits {
    public static int bitPermuteStep(int i10, int i11, int i12) {
        int i13 = i11 & ((i10 >>> i12) ^ i10);
        return i10 ^ (i13 ^ (i13 << i12));
    }

    public static long bitPermuteStep(long j10, long j11, int i10) {
        long j12 = j11 & ((j10 >>> i10) ^ j10);
        return j10 ^ (j12 ^ (j12 << i10));
    }

    public static int bitPermuteStepSimple(int i10, int i11, int i12) {
        return ((i10 >>> i12) & i11) | ((i10 & i11) << i12);
    }

    public static long bitPermuteStepSimple(long j10, long j11, int i10) {
        return ((j10 >>> i10) & j11) | ((j10 & j11) << i10);
    }
}
