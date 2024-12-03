package org.bouncycastle.math.raw;

public class Interleave {
    private static final long M32 = 1431655765;
    private static final long M64 = 6148914691236517205L;
    private static final long M64R = -6148914691236517206L;

    public static int expand16to32(int i10) {
        int i11 = i10 & 65535;
        int i12 = (i11 | (i11 << 8)) & 16711935;
        int i13 = (i12 | (i12 << 4)) & 252645135;
        int i14 = (i13 | (i13 << 2)) & 858993459;
        return (i14 | (i14 << 1)) & 1431655765;
    }

    public static long expand32to64(int i10) {
        int bitPermuteStep = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(i10, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
        return ((((long) (bitPermuteStep >>> 1)) & M32) << 32) | (M32 & ((long) bitPermuteStep));
    }

    public static void expand64To128(long j10, long[] jArr, int i10) {
        long bitPermuteStep = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j10, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        jArr[i10] = bitPermuteStep & M64;
        jArr[i10 + 1] = (bitPermuteStep >>> 1) & M64;
    }

    public static void expand64To128(long[] jArr, int i10, int i11, long[] jArr2, int i12) {
        for (int i13 = 0; i13 < i11; i13++) {
            expand64To128(jArr[i10 + i13], jArr2, i12);
            i12 += 2;
        }
    }

    public static void expand64To128Rev(long j10, long[] jArr, int i10) {
        long bitPermuteStep = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j10, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        jArr[i10] = bitPermuteStep & M64R;
        jArr[i10 + 1] = (bitPermuteStep << 1) & M64R;
    }

    public static int expand8to16(int i10) {
        int i11 = i10 & 255;
        int i12 = (i11 | (i11 << 4)) & 3855;
        int i13 = (i12 | (i12 << 2)) & 13107;
        return (i13 | (i13 << 1)) & 21845;
    }

    public static int shuffle(int i10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(i10, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
    }

    public static long shuffle(long j10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j10, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
    }

    public static int shuffle2(int i10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(i10, 11141290, 7), 52428, 14), 15728880, 4), 65280, 8);
    }

    public static long shuffle2(long j10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j10, 4278255360L, 24), 57421771435671756L, 6), 264913582878960L, 12), 723401728380766730L, 3);
    }

    public static long shuffle3(long j10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j10, 47851476196393130L, 7), 225176545447116L, 14), 4042322160L, 28);
    }

    public static int unshuffle(int i10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(i10, 572662306, 1), 202116108, 2), 15728880, 4), 65280, 8);
    }

    public static long unshuffle(long j10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j10, 2459565876494606882L, 1), 868082074056920076L, 2), 67555025218437360L, 4), 280375465148160L, 8), 4294901760L, 16);
    }

    public static int unshuffle2(int i10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(i10, 65280, 8), 15728880, 4), 52428, 14), 11141290, 7);
    }

    public static long unshuffle2(long j10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j10, 723401728380766730L, 3), 264913582878960L, 12), 57421771435671756L, 6), 4278255360L, 24);
    }

    public static long unshuffle3(long j10) {
        return shuffle3(j10);
    }
}
