package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAValidationParameters;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.encoders.Hex;

public class DSAParametersGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private int L;
    private int N;
    private int certainty;
    private Digest digest;
    private int iterations;
    private SecureRandom random;
    private int usageIndex;
    private boolean use186_3;

    public DSAParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    public DSAParametersGenerator(Digest digest2) {
        this.digest = digest2;
    }

    private static BigInteger calculateGenerator_FIPS186_2(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        BigInteger divide = bigInteger.subtract(ONE).divide(bigInteger2);
        BigInteger subtract = bigInteger.subtract(TWO);
        do {
            modPow = BigIntegers.createRandomInRange(TWO, subtract, secureRandom).modPow(divide, bigInteger);
        } while (modPow.bitLength() <= 1);
        return modPow;
    }

    private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return calculateGenerator_FIPS186_2(bigInteger, bigInteger2, secureRandom);
    }

    private static BigInteger calculateGenerator_FIPS186_3_Verifiable(Digest digest2, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, int i10) {
        BigInteger divide = bigInteger.subtract(ONE).divide(bigInteger2);
        byte[] decodeStrict = Hex.decodeStrict("6767656E");
        int length = bArr.length + decodeStrict.length + 1 + 2;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(decodeStrict, 0, bArr2, bArr.length, decodeStrict.length);
        bArr2[length - 3] = (byte) i10;
        byte[] bArr3 = new byte[digest2.getDigestSize()];
        for (int i11 = 1; i11 < 65536; i11++) {
            inc(bArr2);
            hash(digest2, bArr2, bArr3, 0);
            BigInteger modPow = new BigInteger(1, bArr3).modPow(divide, bigInteger);
            if (modPow.compareTo(TWO) >= 0) {
                return modPow;
            }
        }
        return null;
    }

    private DSAParameters generateParameters_FIPS186_2() {
        int i10 = 20;
        byte[] bArr = new byte[20];
        byte[] bArr2 = new byte[20];
        byte[] bArr3 = new byte[20];
        byte[] bArr4 = new byte[20];
        int i11 = this.L;
        int i12 = (i11 - 1) / 160;
        int i13 = i11 / 8;
        byte[] bArr5 = new byte[i13];
        if (this.digest instanceof SHA1Digest) {
            while (true) {
                this.random.nextBytes(bArr);
                hash(this.digest, bArr, bArr2, 0);
                System.arraycopy(bArr, 0, bArr3, 0, i10);
                inc(bArr3);
                hash(this.digest, bArr3, bArr3, 0);
                for (int i14 = 0; i14 != i10; i14++) {
                    bArr4[i14] = (byte) (bArr2[i14] ^ bArr3[i14]);
                }
                bArr4[0] = (byte) (bArr4[0] | Byte.MIN_VALUE);
                bArr4[19] = (byte) (bArr4[19] | 1);
                BigInteger bigInteger = new BigInteger(1, bArr4);
                if (isProbablePrime(bigInteger)) {
                    byte[] clone = Arrays.clone(bArr);
                    inc(clone);
                    int i15 = 0;
                    while (i15 < 4096) {
                        for (int i16 = 1; i16 <= i12; i16++) {
                            inc(clone);
                            hash(this.digest, clone, bArr5, i13 - (i16 * 20));
                        }
                        int i17 = i13 - (i12 * 20);
                        inc(clone);
                        hash(this.digest, clone, bArr2, 0);
                        System.arraycopy(bArr2, 20 - i17, bArr5, 0, i17);
                        bArr5[0] = (byte) (bArr5[0] | Byte.MIN_VALUE);
                        BigInteger bigInteger2 = new BigInteger(1, bArr5);
                        BigInteger subtract = bigInteger2.subtract(bigInteger2.mod(bigInteger.shiftLeft(1)).subtract(ONE));
                        if (subtract.bitLength() == this.L && isProbablePrime(subtract)) {
                            return new DSAParameters(subtract, bigInteger, calculateGenerator_FIPS186_2(subtract, bigInteger, this.random), new DSAValidationParameters(bArr, i15));
                        }
                        i15++;
                        i10 = 20;
                    }
                    continue;
                }
            }
        } else {
            throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ab, code lost:
        r1 = calculateGenerator_FIPS186_3_Verifiable(r1, r8, r9, r3, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.bouncycastle.crypto.params.DSAParameters generateParameters_FIPS186_3() {
        /*
            r16 = this;
            r0 = r16
            org.bouncycastle.crypto.Digest r1 = r0.digest
            int r2 = r1.getDigestSize()
            int r2 = r2 * 8
            int r3 = r0.N
            int r3 = r3 / 8
            byte[] r3 = new byte[r3]
            int r4 = r0.L
            int r5 = r4 + -1
            int r5 = r5 / r2
            int r6 = r4 + -1
            int r6 = r6 % r2
            int r4 = r4 / 8
            byte[] r2 = new byte[r4]
            int r6 = r1.getDigestSize()
            byte[] r7 = new byte[r6]
        L_0x0022:
            java.security.SecureRandom r8 = r0.random
            r8.nextBytes(r3)
            r8 = 0
            hash(r1, r3, r7, r8)
            java.math.BigInteger r9 = new java.math.BigInteger
            r10 = 1
            r9.<init>(r10, r7)
            java.math.BigInteger r11 = ONE
            int r12 = r0.N
            int r12 = r12 - r10
            java.math.BigInteger r11 = r11.shiftLeft(r12)
            java.math.BigInteger r9 = r9.mod(r11)
            java.math.BigInteger r9 = r9.setBit(r8)
            int r11 = r0.N
            int r11 = r11 - r10
            java.math.BigInteger r9 = r9.setBit(r11)
            boolean r11 = r0.isProbablePrime(r9)
            if (r11 != 0) goto L_0x0050
            goto L_0x0022
        L_0x0050:
            byte[] r11 = org.bouncycastle.util.Arrays.clone((byte[]) r3)
            int r12 = r0.L
            int r12 = r12 * 4
            r13 = r8
        L_0x0059:
            if (r13 >= r12) goto L_0x0022
            r14 = r10
        L_0x005c:
            if (r14 > r5) goto L_0x006b
            inc(r11)
            int r15 = r14 * r6
            int r15 = r4 - r15
            hash(r1, r11, r2, r15)
            int r14 = r14 + 1
            goto L_0x005c
        L_0x006b:
            int r14 = r5 * r6
            int r14 = r4 - r14
            inc(r11)
            hash(r1, r11, r7, r8)
            int r15 = r6 - r14
            java.lang.System.arraycopy(r7, r15, r2, r8, r14)
            byte r14 = r2[r8]
            r14 = r14 | -128(0xffffffffffffff80, float:NaN)
            byte r14 = (byte) r14
            r2[r8] = r14
            java.math.BigInteger r14 = new java.math.BigInteger
            r14.<init>(r10, r2)
            java.math.BigInteger r15 = r9.shiftLeft(r10)
            java.math.BigInteger r15 = r14.mod(r15)
            java.math.BigInteger r8 = ONE
            java.math.BigInteger r8 = r15.subtract(r8)
            java.math.BigInteger r8 = r14.subtract(r8)
            int r14 = r8.bitLength()
            int r15 = r0.L
            if (r14 == r15) goto L_0x00a1
            goto L_0x00cf
        L_0x00a1:
            boolean r14 = r0.isProbablePrime(r8)
            if (r14 == 0) goto L_0x00cf
            int r2 = r0.usageIndex
            if (r2 < 0) goto L_0x00be
            java.math.BigInteger r1 = calculateGenerator_FIPS186_3_Verifiable(r1, r8, r9, r3, r2)
            if (r1 == 0) goto L_0x00be
            org.bouncycastle.crypto.params.DSAParameters r2 = new org.bouncycastle.crypto.params.DSAParameters
            org.bouncycastle.crypto.params.DSAValidationParameters r4 = new org.bouncycastle.crypto.params.DSAValidationParameters
            int r5 = r0.usageIndex
            r4.<init>(r3, r13, r5)
            r2.<init>(r8, r9, r1, r4)
            return r2
        L_0x00be:
            java.security.SecureRandom r1 = r0.random
            java.math.BigInteger r1 = calculateGenerator_FIPS186_3_Unverifiable(r8, r9, r1)
            org.bouncycastle.crypto.params.DSAParameters r2 = new org.bouncycastle.crypto.params.DSAParameters
            org.bouncycastle.crypto.params.DSAValidationParameters r4 = new org.bouncycastle.crypto.params.DSAValidationParameters
            r4.<init>(r3, r13)
            r2.<init>(r8, r9, r1, r4)
            return r2
        L_0x00cf:
            int r13 = r13 + 1
            r8 = 0
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.generators.DSAParametersGenerator.generateParameters_FIPS186_3():org.bouncycastle.crypto.params.DSAParameters");
    }

    private static int getDefaultN(int i10) {
        return i10 > 1024 ? 256 : 160;
    }

    private static int getMinimumIterations(int i10) {
        if (i10 <= 1024) {
            return 40;
        }
        return (((i10 - 1) / 1024) * 8) + 48;
    }

    private static void hash(Digest digest2, byte[] bArr, byte[] bArr2, int i10) {
        digest2.update(bArr, 0, bArr.length);
        digest2.doFinal(bArr2, i10);
    }

    private static void inc(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0) {
            byte b10 = (byte) ((bArr[length] + 1) & 255);
            bArr[length] = b10;
            if (b10 == 0) {
                length--;
            } else {
                return;
            }
        }
    }

    private boolean isProbablePrime(BigInteger bigInteger) {
        return bigInteger.isProbablePrime(this.certainty);
    }

    public DSAParameters generateParameters() {
        return this.use186_3 ? generateParameters_FIPS186_3() : generateParameters_FIPS186_2();
    }

    public void init(int i10, int i11, SecureRandom secureRandom) {
        this.L = i10;
        this.N = getDefaultN(i10);
        this.certainty = i11;
        this.iterations = Math.max(getMinimumIterations(this.L), (i11 + 1) / 2);
        this.random = secureRandom;
        this.use186_3 = false;
        this.usageIndex = -1;
    }

    public void init(DSAParameterGenerationParameters dSAParameterGenerationParameters) {
        int l10 = dSAParameterGenerationParameters.getL();
        int n10 = dSAParameterGenerationParameters.getN();
        if (l10 < 1024 || l10 > 3072 || l10 % 1024 != 0) {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        } else if (l10 == 1024 && n10 != 160) {
            throw new IllegalArgumentException("N must be 160 for L = 1024");
        } else if (l10 == 2048 && n10 != 224 && n10 != 256) {
            throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
        } else if (l10 == 3072 && n10 != 256) {
            throw new IllegalArgumentException("N must be 256 for L = 3072");
        } else if (this.digest.getDigestSize() * 8 >= n10) {
            this.L = l10;
            this.N = n10;
            this.certainty = dSAParameterGenerationParameters.getCertainty();
            this.iterations = Math.max(getMinimumIterations(l10), (this.certainty + 1) / 2);
            this.random = dSAParameterGenerationParameters.getRandom();
            this.use186_3 = true;
            this.usageIndex = dSAParameterGenerationParameters.getUsageIndex();
        } else {
            throw new IllegalStateException("Digest output size too small for value of N");
        }
    }
}
