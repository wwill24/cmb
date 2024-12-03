package org.bouncycastle.math;

import java.math.BigInteger;
import java.security.SecureRandom;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.jivesoftware.smack.datatypes.UInt32;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportCandidate;

public abstract class Primes {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    public static final int SMALL_FACTOR_LIMIT = 211;
    private static final BigInteger THREE = BigInteger.valueOf(3);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static class MROutput {
        private BigInteger factor;
        private boolean provablyComposite;

        private MROutput(boolean z10, BigInteger bigInteger) {
            this.provablyComposite = z10;
            this.factor = bigInteger;
        }

        /* access modifiers changed from: private */
        public static MROutput probablyPrime() {
            return new MROutput(false, (BigInteger) null);
        }

        /* access modifiers changed from: private */
        public static MROutput provablyCompositeNotPrimePower() {
            return new MROutput(true, (BigInteger) null);
        }

        /* access modifiers changed from: private */
        public static MROutput provablyCompositeWithFactor(BigInteger bigInteger) {
            return new MROutput(true, bigInteger);
        }

        public BigInteger getFactor() {
            return this.factor;
        }

        public boolean isNotPrimePower() {
            return this.provablyComposite && this.factor == null;
        }

        public boolean isProvablyComposite() {
            return this.provablyComposite;
        }
    }

    public static class STOutput {
        private BigInteger prime;
        private int primeGenCounter;
        private byte[] primeSeed;

        private STOutput(BigInteger bigInteger, byte[] bArr, int i10) {
            this.prime = bigInteger;
            this.primeSeed = bArr;
            this.primeGenCounter = i10;
        }

        public BigInteger getPrime() {
            return this.prime;
        }

        public int getPrimeGenCounter() {
            return this.primeGenCounter;
        }

        public byte[] getPrimeSeed() {
            return this.primeSeed;
        }
    }

    private static void checkCandidate(BigInteger bigInteger, String str) {
        if (bigInteger == null || bigInteger.signum() < 1 || bigInteger.bitLength() < 2) {
            throw new IllegalArgumentException("'" + str + "' must be non-null and >= 2");
        }
    }

    public static MROutput enhancedMRProbablePrimeTest(BigInteger bigInteger, SecureRandom secureRandom, int i10) {
        boolean z10;
        BigInteger bigInteger2;
        checkCandidate(bigInteger, JingleContentTransportCandidate.ELEMENT);
        if (secureRandom == null) {
            throw new IllegalArgumentException("'random' cannot be null");
        } else if (i10 < 1) {
            throw new IllegalArgumentException("'iterations' must be > 0");
        } else if (bigInteger.bitLength() == 2) {
            return MROutput.probablyPrime();
        } else {
            if (!bigInteger.testBit(0)) {
                return MROutput.provablyCompositeWithFactor(TWO);
            }
            BigInteger subtract = bigInteger.subtract(ONE);
            BigInteger subtract2 = bigInteger.subtract(TWO);
            int lowestSetBit = subtract.getLowestSetBit();
            BigInteger shiftRight = subtract.shiftRight(lowestSetBit);
            for (int i11 = 0; i11 < i10; i11++) {
                BigInteger createRandomInRange = BigIntegers.createRandomInRange(TWO, subtract2, secureRandom);
                BigInteger gcd = createRandomInRange.gcd(bigInteger);
                BigInteger bigInteger3 = ONE;
                if (gcd.compareTo(bigInteger3) > 0) {
                    return MROutput.provablyCompositeWithFactor(gcd);
                }
                BigInteger modPow = createRandomInRange.modPow(shiftRight, bigInteger);
                if (!modPow.equals(bigInteger3) && !modPow.equals(subtract)) {
                    int i12 = 1;
                    while (true) {
                        if (i12 >= lowestSetBit) {
                            z10 = false;
                            bigInteger2 = modPow;
                            break;
                        }
                        bigInteger2 = modPow.modPow(TWO, bigInteger);
                        if (bigInteger2.equals(subtract)) {
                            z10 = true;
                            break;
                        } else if (bigInteger2.equals(ONE)) {
                            z10 = false;
                            break;
                        } else {
                            i12++;
                            modPow = bigInteger2;
                        }
                    }
                    if (!z10) {
                        BigInteger bigInteger4 = ONE;
                        if (!bigInteger2.equals(bigInteger4)) {
                            modPow = bigInteger2.modPow(TWO, bigInteger);
                            if (modPow.equals(bigInteger4)) {
                                modPow = bigInteger2;
                            }
                        }
                        BigInteger gcd2 = modPow.subtract(bigInteger4).gcd(bigInteger);
                        return gcd2.compareTo(bigInteger4) > 0 ? MROutput.provablyCompositeWithFactor(gcd2) : MROutput.provablyCompositeNotPrimePower();
                    }
                }
            }
            return MROutput.probablyPrime();
        }
    }

    private static int extract32(byte[] bArr) {
        int min = Math.min(4, bArr.length);
        int i10 = 0;
        int i11 = 0;
        while (i10 < min) {
            int i12 = i10 + 1;
            i11 |= (bArr[bArr.length - i12] & 255) << (i10 * 8);
            i10 = i12;
        }
        return i11;
    }

    public static STOutput generateSTRandomPrime(Digest digest, int i10, byte[] bArr) {
        if (digest == null) {
            throw new IllegalArgumentException("'hash' cannot be null");
        } else if (i10 < 2) {
            throw new IllegalArgumentException("'length' must be >= 2");
        } else if (bArr != null && bArr.length != 0) {
            return implSTRandomPrime(digest, i10, Arrays.clone(bArr));
        } else {
            throw new IllegalArgumentException("'inputSeed' cannot be null or empty");
        }
    }

    public static boolean hasAnySmallFactors(BigInteger bigInteger) {
        checkCandidate(bigInteger, JingleContentTransportCandidate.ELEMENT);
        return implHasAnySmallFactors(bigInteger);
    }

    private static void hash(Digest digest, byte[] bArr, byte[] bArr2, int i10) {
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr2, i10);
    }

    private static BigInteger hashGen(Digest digest, byte[] bArr, int i10) {
        int digestSize = digest.getDigestSize();
        int i11 = i10 * digestSize;
        byte[] bArr2 = new byte[i11];
        for (int i12 = 0; i12 < i10; i12++) {
            i11 -= digestSize;
            hash(digest, bArr, bArr2, i11);
            inc(bArr, 1);
        }
        return new BigInteger(1, bArr2);
    }

    private static boolean implHasAnySmallFactors(BigInteger bigInteger) {
        int intValue = bigInteger.mod(BigInteger.valueOf((long) 223092870)).intValue();
        if (!(intValue % 2 == 0 || intValue % 3 == 0 || intValue % 5 == 0 || intValue % 7 == 0 || intValue % 11 == 0 || intValue % 13 == 0 || intValue % 17 == 0 || intValue % 19 == 0 || intValue % 23 == 0)) {
            int intValue2 = bigInteger.mod(BigInteger.valueOf((long) 58642669)).intValue();
            if (!(intValue2 % 29 == 0 || intValue2 % 31 == 0 || intValue2 % 37 == 0 || intValue2 % 41 == 0 || intValue2 % 43 == 0)) {
                int intValue3 = bigInteger.mod(BigInteger.valueOf((long) 600662303)).intValue();
                if (!(intValue3 % 47 == 0 || intValue3 % 53 == 0 || intValue3 % 59 == 0 || intValue3 % 61 == 0 || intValue3 % 67 == 0)) {
                    int intValue4 = bigInteger.mod(BigInteger.valueOf((long) 33984931)).intValue();
                    if (!(intValue4 % 71 == 0 || intValue4 % 73 == 0 || intValue4 % 79 == 0 || intValue4 % 83 == 0)) {
                        int intValue5 = bigInteger.mod(BigInteger.valueOf((long) 89809099)).intValue();
                        if (!(intValue5 % 89 == 0 || intValue5 % 97 == 0 || intValue5 % 101 == 0 || intValue5 % 103 == 0)) {
                            int intValue6 = bigInteger.mod(BigInteger.valueOf((long) 167375713)).intValue();
                            if (!(intValue6 % 107 == 0 || intValue6 % 109 == 0 || intValue6 % 113 == 0 || intValue6 % Opcodes.LAND == 0)) {
                                int intValue7 = bigInteger.mod(BigInteger.valueOf((long) 371700317)).intValue();
                                if (!(intValue7 % Opcodes.LXOR == 0 || intValue7 % Opcodes.L2F == 0 || intValue7 % Opcodes.F2I == 0 || intValue7 % Opcodes.FCMPL == 0)) {
                                    int intValue8 = bigInteger.mod(BigInteger.valueOf((long) 645328247)).intValue();
                                    if (!(intValue8 % Opcodes.DCMPL == 0 || intValue8 % Opcodes.IFGT == 0 || intValue8 % Opcodes.IF_ICMPGT == 0 || intValue8 % Opcodes.GOTO == 0)) {
                                        int intValue9 = bigInteger.mod(BigInteger.valueOf((long) 1070560157)).intValue();
                                        if (!(intValue9 % Opcodes.LRETURN == 0 || intValue9 % Opcodes.PUTSTATIC == 0 || intValue9 % Opcodes.PUTFIELD == 0 || intValue9 % Opcodes.ATHROW == 0)) {
                                            int intValue10 = bigInteger.mod(BigInteger.valueOf((long) 1596463769)).intValue();
                                            return intValue10 % Opcodes.INSTANCEOF == 0 || intValue10 % Opcodes.MULTIANEWARRAY == 0 || intValue10 % Opcodes.IFNONNULL == 0 || intValue10 % 211 == 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean implMRProbablePrimeToBase(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10, BigInteger bigInteger4) {
        BigInteger modPow = bigInteger4.modPow(bigInteger3, bigInteger);
        if (modPow.equals(ONE) || modPow.equals(bigInteger2)) {
            return true;
        }
        for (int i11 = 1; i11 < i10; i11++) {
            modPow = modPow.modPow(TWO, bigInteger);
            if (modPow.equals(bigInteger2)) {
                return true;
            }
            if (modPow.equals(ONE)) {
                return false;
            }
        }
        return false;
    }

    private static STOutput implSTRandomPrime(Digest digest, int i10, byte[] bArr) {
        Object obj;
        Digest digest2 = digest;
        int i11 = i10;
        byte[] bArr2 = bArr;
        int digestSize = digest.getDigestSize();
        Object obj2 = null;
        int i12 = 1;
        if (i11 < 33) {
            byte[] bArr3 = new byte[digestSize];
            byte[] bArr4 = new byte[digestSize];
            int i13 = 0;
            do {
                hash(digest2, bArr2, bArr3, 0);
                inc(bArr2, 1);
                hash(digest2, bArr2, bArr4, 0);
                inc(bArr2, 1);
                i13++;
                long extract32 = ((long) (((extract32(bArr3) ^ extract32(bArr4)) & (-1 >>> (32 - i11))) | (1 << (i11 - 1)) | 1)) & UInt32.MAX_VALUE_LONG;
                if (isPrime32(extract32)) {
                    return new STOutput(BigInteger.valueOf(extract32), bArr2, i13);
                }
            } while (i13 <= i11 * 4);
            throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
        }
        STOutput implSTRandomPrime = implSTRandomPrime(digest2, (i11 + 3) / 2, bArr2);
        BigInteger prime = implSTRandomPrime.getPrime();
        byte[] primeSeed = implSTRandomPrime.getPrimeSeed();
        int primeGenCounter = implSTRandomPrime.getPrimeGenCounter();
        int i14 = i11 - 1;
        int i15 = (i14 / (digestSize * 8)) + 1;
        BigInteger hashGen = hashGen(digest2, primeSeed, i15);
        BigInteger bigInteger = ONE;
        BigInteger bit = hashGen.mod(bigInteger.shiftLeft(i14)).setBit(i14);
        BigInteger shiftLeft = prime.shiftLeft(1);
        BigInteger shiftLeft2 = bit.subtract(bigInteger).divide(shiftLeft).add(bigInteger).shiftLeft(1);
        BigInteger add = shiftLeft2.multiply(prime).add(bigInteger);
        int i16 = primeGenCounter;
        int i17 = 0;
        while (true) {
            if (add.bitLength() > i11) {
                BigInteger bigInteger2 = ONE;
                shiftLeft2 = bigInteger2.shiftLeft(i14).subtract(bigInteger2).divide(shiftLeft).add(bigInteger2).shiftLeft(i12);
                add = shiftLeft2.multiply(prime).add(bigInteger2);
            }
            i16 += i12;
            if (!implHasAnySmallFactors(add)) {
                BigInteger add2 = shiftLeft2.add(BigInteger.valueOf((long) i17));
                BigInteger modPow = hashGen(digest2, primeSeed, i15).mod(add.subtract(THREE)).add(TWO).modPow(add2, add);
                BigInteger bigInteger3 = ONE;
                if (add.gcd(modPow.subtract(bigInteger3)).equals(bigInteger3) && modPow.modPow(prime, add).equals(bigInteger3)) {
                    return new STOutput(add, primeSeed, i16);
                }
                obj = null;
                shiftLeft2 = add2;
                i17 = 0;
            } else {
                obj = obj2;
                inc(primeSeed, i15);
            }
            if (i16 < (i11 * 4) + primeGenCounter) {
                i17 += 2;
                add = add.add(shiftLeft);
                obj2 = obj;
                i12 = 1;
            } else {
                throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
            }
        }
    }

    private static void inc(byte[] bArr, int i10) {
        int length = bArr.length;
        while (i10 > 0) {
            length--;
            if (length >= 0) {
                int i11 = i10 + (bArr[length] & 255);
                bArr[length] = (byte) i11;
                i10 = i11 >>> 8;
            } else {
                return;
            }
        }
    }

    public static boolean isMRProbablePrime(BigInteger bigInteger, SecureRandom secureRandom, int i10) {
        checkCandidate(bigInteger, JingleContentTransportCandidate.ELEMENT);
        if (secureRandom == null) {
            throw new IllegalArgumentException("'random' cannot be null");
        } else if (i10 < 1) {
            throw new IllegalArgumentException("'iterations' must be > 0");
        } else if (bigInteger.bitLength() == 2) {
            return true;
        } else {
            if (!bigInteger.testBit(0)) {
                return false;
            }
            BigInteger subtract = bigInteger.subtract(ONE);
            BigInteger subtract2 = bigInteger.subtract(TWO);
            int lowestSetBit = subtract.getLowestSetBit();
            BigInteger shiftRight = subtract.shiftRight(lowestSetBit);
            for (int i11 = 0; i11 < i10; i11++) {
                if (!implMRProbablePrimeToBase(bigInteger, subtract, shiftRight, lowestSetBit, BigIntegers.createRandomInRange(TWO, subtract2, secureRandom))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isMRProbablePrimeToBase(BigInteger bigInteger, BigInteger bigInteger2) {
        checkCandidate(bigInteger, JingleContentTransportCandidate.ELEMENT);
        checkCandidate(bigInteger2, "base");
        BigInteger bigInteger3 = ONE;
        if (bigInteger2.compareTo(bigInteger.subtract(bigInteger3)) >= 0) {
            throw new IllegalArgumentException("'base' must be < ('candidate' - 1)");
        } else if (bigInteger.bitLength() == 2) {
            return true;
        } else {
            BigInteger subtract = bigInteger.subtract(bigInteger3);
            int lowestSetBit = subtract.getLowestSetBit();
            return implMRProbablePrimeToBase(bigInteger, subtract, subtract.shiftRight(lowestSetBit), lowestSetBit, bigInteger2);
        }
    }

    private static boolean isPrime32(long j10) {
        if ((j10 >>> 32) == 0) {
            int i10 = (j10 > 5 ? 1 : (j10 == 5 ? 0 : -1));
            if (i10 <= 0) {
                return j10 == 2 || j10 == 3 || i10 == 0;
            }
            if ((1 & j10) == 0 || j10 % 3 == 0 || j10 % 5 == 0) {
                return false;
            }
            long[] jArr = {1, 7, 11, 13, 17, 19, 23, 29};
            long j11 = 0;
            int i11 = 1;
            while (true) {
                if (i11 >= 8) {
                    j11 += 30;
                    if (j11 * j11 >= j10) {
                        return true;
                    }
                    i11 = 0;
                } else if (j10 % (jArr[i11] + j11) == 0) {
                    return j10 < 30;
                } else {
                    i11++;
                }
            }
        } else {
            throw new IllegalArgumentException("Size limit exceeded");
        }
    }
}
