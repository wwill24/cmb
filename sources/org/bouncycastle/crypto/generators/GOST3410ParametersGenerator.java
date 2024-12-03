package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410ValidationParameters;
import org.bouncycastle.util.BigIntegers;

public class GOST3410ParametersGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private SecureRandom init_random;
    private int size;
    private int typeproc;

    private int procedure_A(int i10, int i11, BigInteger[] bigIntegerArr, int i12) {
        BigInteger bigInteger;
        BigInteger[] bigIntegerArr2;
        BigInteger bigInteger2;
        int i13;
        BigInteger bigInteger3;
        int i14;
        int i15 = i10;
        while (true) {
            if (i15 >= 0 && i15 <= 65536) {
                break;
            }
            i15 = this.init_random.nextInt() / 32768;
        }
        int i16 = i11;
        while (true) {
            if (i16 >= 0 && i16 <= 65536 && i16 / 2 != 0) {
                break;
            }
            i16 = (this.init_random.nextInt() / 32768) + 1;
        }
        BigInteger bigInteger4 = new BigInteger(Integer.toString(i16));
        BigInteger bigInteger5 = new BigInteger("19381");
        BigInteger bigInteger6 = new BigInteger(Integer.toString(i15));
        int i17 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger6};
        int[] iArr = {i12};
        int i18 = 0;
        int i19 = 0;
        while (iArr[i18] >= 17) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            i19 = i18 + 1;
            iArr[i19] = iArr[i18] / 2;
            i18 = i19;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[(i19 + 1)];
        int i20 = 16;
        bigIntegerArr4[i19] = new BigInteger("8003", 16);
        int i21 = i19 - 1;
        int i22 = 0;
        while (true) {
            if (i22 >= i19) {
                bigInteger = bigIntegerArr3[i17];
                break;
            }
            int i23 = iArr[i21] / i20;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i17, bigIntegerArr5, i17, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[(i23 + 1)];
                System.arraycopy(bigIntegerArr5, i17, bigIntegerArr2, i17, length2);
                int i24 = i17;
                while (i24 < i23) {
                    int i25 = i24 + 1;
                    bigIntegerArr2[i25] = bigIntegerArr2[i24].multiply(bigInteger5).add(bigInteger4).mod(TWO.pow(i20));
                    i24 = i25;
                }
                BigInteger bigInteger7 = new BigInteger("0");
                for (int i26 = i17; i26 < i23; i26++) {
                    bigInteger7 = bigInteger7.add(bigIntegerArr2[i26].multiply(TWO.pow(i26 * 16)));
                }
                bigIntegerArr2[i17] = bigIntegerArr2[i23];
                BigInteger bigInteger8 = TWO;
                int i27 = i21 + 1;
                BigInteger add = bigInteger8.pow(iArr[i21] - 1).divide(bigIntegerArr4[i27]).add(bigInteger8.pow(iArr[i21] - 1).multiply(bigInteger7).divide(bigIntegerArr4[i27].multiply(bigInteger8.pow(i23 * 16))));
                BigInteger mod = add.mod(bigInteger8);
                BigInteger bigInteger9 = ONE;
                if (mod.compareTo(bigInteger9) == 0) {
                    add = add.add(bigInteger9);
                }
                int i28 = 0;
                while (true) {
                    BigInteger bigInteger10 = bigInteger4;
                    bigInteger2 = bigInteger5;
                    long j10 = (long) i28;
                    i13 = i19;
                    BigInteger multiply = bigIntegerArr4[i27].multiply(add.add(BigInteger.valueOf(j10)));
                    BigInteger bigInteger11 = ONE;
                    BigInteger add2 = multiply.add(bigInteger11);
                    bigIntegerArr4[i21] = add2;
                    bigInteger3 = bigInteger10;
                    BigInteger bigInteger12 = TWO;
                    i14 = i23;
                    if (add2.compareTo(bigInteger12.pow(iArr[i21])) != 1) {
                        if (bigInteger12.modPow(bigIntegerArr4[i27].multiply(add.add(BigInteger.valueOf(j10))), bigIntegerArr4[i21]).compareTo(bigInteger11) == 0 && bigInteger12.modPow(add.add(BigInteger.valueOf(j10)), bigIntegerArr4[i21]).compareTo(bigInteger11) != 0) {
                            break;
                        }
                        i28 += 2;
                        i19 = i13;
                        bigInteger5 = bigInteger2;
                        bigInteger4 = bigInteger3;
                        i23 = i14;
                    } else {
                        break;
                    }
                }
                i19 = i13;
                bigInteger5 = bigInteger2;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger4 = bigInteger3;
                i23 = i14;
                i17 = 0;
                i20 = 16;
            }
            i21--;
            if (i21 < 0) {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                bigInteger = bigIntegerArr2[0];
                break;
            }
            i22++;
            i19 = i13;
            bigInteger5 = bigInteger2;
            bigIntegerArr3 = bigIntegerArr2;
            bigInteger4 = bigInteger3;
            i17 = 0;
            i20 = 16;
        }
        return bigInteger.intValue();
    }

    private long procedure_Aa(long j10, long j11, BigInteger[] bigIntegerArr, int i10) {
        BigInteger bigInteger;
        BigInteger[] bigIntegerArr2;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        int i11;
        long j12 = j10;
        while (true) {
            if (j12 >= 0 && j12 <= 4294967296L) {
                break;
            }
            j12 = (long) (this.init_random.nextInt() * 2);
        }
        long j13 = j11;
        while (true) {
            if (j13 >= 0 && j13 <= 4294967296L && j13 / 2 != 0) {
                break;
            }
            j13 = (long) ((this.init_random.nextInt() * 2) + 1);
        }
        BigInteger bigInteger4 = new BigInteger(Long.toString(j13));
        BigInteger bigInteger5 = new BigInteger("97781173");
        BigInteger bigInteger6 = new BigInteger(Long.toString(j12));
        int i12 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger6};
        int[] iArr = {i10};
        int i13 = 0;
        int i14 = 0;
        while (iArr[i13] >= 33) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            i14 = i13 + 1;
            iArr[i14] = iArr[i13] / 2;
            i13 = i14;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[(i14 + 1)];
        bigIntegerArr4[i14] = new BigInteger("8000000B", 16);
        int i15 = i14 - 1;
        int i16 = 0;
        while (true) {
            if (i16 >= i14) {
                bigInteger = bigIntegerArr3[i12];
                break;
            }
            int i17 = 32;
            int i18 = iArr[i15] / 32;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i12, bigIntegerArr5, i12, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[(i18 + 1)];
                System.arraycopy(bigIntegerArr5, i12, bigIntegerArr2, i12, length2);
                int i19 = i12;
                while (i19 < i18) {
                    int i20 = i19 + 1;
                    bigIntegerArr2[i20] = bigIntegerArr2[i19].multiply(bigInteger5).add(bigInteger4).mod(TWO.pow(i17));
                    i19 = i20;
                }
                BigInteger bigInteger7 = new BigInteger("0");
                for (int i21 = i12; i21 < i18; i21++) {
                    bigInteger7 = bigInteger7.add(bigIntegerArr2[i21].multiply(TWO.pow(i21 * 32)));
                }
                bigIntegerArr2[i12] = bigIntegerArr2[i18];
                BigInteger bigInteger8 = TWO;
                int i22 = i15 + 1;
                BigInteger add = bigInteger8.pow(iArr[i15] - 1).divide(bigIntegerArr4[i22]).add(bigInteger8.pow(iArr[i15] - 1).multiply(bigInteger7).divide(bigIntegerArr4[i22].multiply(bigInteger8.pow(i18 * 32))));
                BigInteger mod = add.mod(bigInteger8);
                BigInteger bigInteger9 = ONE;
                if (mod.compareTo(bigInteger9) == 0) {
                    add = add.add(bigInteger9);
                }
                int i23 = 0;
                while (true) {
                    long j14 = (long) i23;
                    bigInteger2 = bigInteger4;
                    BigInteger multiply = bigIntegerArr4[i22].multiply(add.add(BigInteger.valueOf(j14)));
                    BigInteger bigInteger10 = ONE;
                    BigInteger add2 = multiply.add(bigInteger10);
                    bigIntegerArr4[i15] = add2;
                    bigInteger3 = bigInteger5;
                    BigInteger bigInteger11 = TWO;
                    i11 = i14;
                    if (add2.compareTo(bigInteger11.pow(iArr[i15])) != 1) {
                        if (bigInteger11.modPow(bigIntegerArr4[i22].multiply(add.add(BigInteger.valueOf(j14))), bigIntegerArr4[i15]).compareTo(bigInteger10) == 0 && bigInteger11.modPow(add.add(BigInteger.valueOf(j14)), bigIntegerArr4[i15]).compareTo(bigInteger10) != 0) {
                            break;
                        }
                        i23 += 2;
                        bigInteger4 = bigInteger2;
                        i14 = i11;
                        bigInteger5 = bigInteger3;
                    } else {
                        break;
                    }
                }
                bigInteger4 = bigInteger2;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger5 = bigInteger3;
                i12 = 0;
                i17 = 32;
                i14 = i11;
            }
            i15--;
            if (i15 < 0) {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                bigInteger = bigIntegerArr2[0];
                break;
            }
            i16++;
            bigInteger4 = bigInteger2;
            i14 = i11;
            bigIntegerArr3 = bigIntegerArr2;
            bigInteger5 = bigInteger3;
            i12 = 0;
        }
        return bigInteger.longValue();
    }

    private void procedure_B(int i10, int i11, BigInteger[] bigIntegerArr) {
        int i12 = i10;
        while (true) {
            if (i12 >= 0 && i12 <= 65536) {
                break;
            }
            i12 = this.init_random.nextInt() / 32768;
        }
        int i13 = i11;
        while (true) {
            if (i13 >= 0 && i13 <= 65536 && i13 / 2 != 0) {
                break;
            }
            i13 = (this.init_random.nextInt() / 32768) + 1;
        }
        BigInteger[] bigIntegerArr2 = new BigInteger[2];
        BigInteger bigInteger = new BigInteger(Integer.toString(i13));
        BigInteger bigInteger2 = new BigInteger("19381");
        int procedure_A = procedure_A(i12, i13, bigIntegerArr2, 256);
        int i14 = 0;
        BigInteger bigInteger3 = bigIntegerArr2[0];
        int procedure_A2 = procedure_A(procedure_A, i13, bigIntegerArr2, 512);
        BigInteger bigInteger4 = bigIntegerArr2[0];
        BigInteger[] bigIntegerArr3 = new BigInteger[65];
        bigIntegerArr3[0] = new BigInteger(Integer.toString(procedure_A2));
        while (true) {
            int i15 = i14;
            while (i15 < 64) {
                int i16 = i15 + 1;
                bigIntegerArr3[i16] = bigIntegerArr3[i15].multiply(bigInteger2).add(bigInteger).mod(TWO.pow(16));
                i15 = i16;
            }
            BigInteger bigInteger5 = new BigInteger("0");
            for (int i17 = i14; i17 < 64; i17++) {
                bigInteger5 = bigInteger5.add(bigIntegerArr3[i17].multiply(TWO.pow(i17 * 16)));
            }
            bigIntegerArr3[i14] = bigIntegerArr3[64];
            BigInteger bigInteger6 = TWO;
            int i18 = 1024;
            BigInteger add = bigInteger6.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(bigInteger6.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.pow(1024))));
            BigInteger mod = add.mod(bigInteger6);
            BigInteger bigInteger7 = ONE;
            if (mod.compareTo(bigInteger7) == 0) {
                add = add.add(bigInteger7);
            }
            BigInteger bigInteger8 = add;
            int i19 = i14;
            while (true) {
                long j10 = (long) i19;
                BigInteger multiply = bigInteger3.multiply(bigInteger4).multiply(bigInteger8.add(BigInteger.valueOf(j10)));
                BigInteger bigInteger9 = ONE;
                BigInteger add2 = multiply.add(bigInteger9);
                BigInteger bigInteger10 = TWO;
                if (add2.compareTo(bigInteger10.pow(i18)) == 1) {
                    break;
                } else if (bigInteger10.modPow(bigInteger3.multiply(bigInteger4).multiply(bigInteger8.add(BigInteger.valueOf(j10))), add2).compareTo(bigInteger9) != 0 || bigInteger10.modPow(bigInteger3.multiply(bigInteger8.add(BigInteger.valueOf(j10))), add2).compareTo(bigInteger9) == 0) {
                    i19 += 2;
                    i18 = 1024;
                } else {
                    bigIntegerArr[0] = add2;
                    bigIntegerArr[1] = bigInteger3;
                    return;
                }
            }
            i14 = 0;
        }
    }

    private void procedure_Bb(long j10, long j11, BigInteger[] bigIntegerArr) {
        long j12 = j10;
        while (true) {
            if (j12 >= 0 && j12 <= 4294967296L) {
                break;
            }
            j12 = (long) (this.init_random.nextInt() * 2);
        }
        long j13 = j11;
        while (true) {
            if (j13 >= 0 && j13 <= 4294967296L && j13 / 2 != 0) {
                break;
            }
            j13 = (long) ((this.init_random.nextInt() * 2) + 1);
        }
        BigInteger[] bigIntegerArr2 = new BigInteger[2];
        BigInteger bigInteger = new BigInteger(Long.toString(j13));
        BigInteger bigInteger2 = new BigInteger("97781173");
        long j14 = j13;
        BigInteger[] bigIntegerArr3 = bigIntegerArr2;
        long procedure_Aa = procedure_Aa(j12, j14, bigIntegerArr3, 256);
        int i10 = 0;
        BigInteger bigInteger3 = bigIntegerArr2[0];
        long procedure_Aa2 = procedure_Aa(procedure_Aa, j14, bigIntegerArr3, 512);
        BigInteger bigInteger4 = bigIntegerArr2[0];
        BigInteger[] bigIntegerArr4 = new BigInteger[33];
        bigIntegerArr4[0] = new BigInteger(Long.toString(procedure_Aa2));
        while (true) {
            int i11 = i10;
            while (i11 < 32) {
                int i12 = i11 + 1;
                bigIntegerArr4[i12] = bigIntegerArr4[i11].multiply(bigInteger2).add(bigInteger).mod(TWO.pow(32));
                i11 = i12;
            }
            BigInteger bigInteger5 = new BigInteger("0");
            for (int i13 = i10; i13 < 32; i13++) {
                bigInteger5 = bigInteger5.add(bigIntegerArr4[i13].multiply(TWO.pow(i13 * 32)));
            }
            bigIntegerArr4[i10] = bigIntegerArr4[32];
            BigInteger bigInteger6 = TWO;
            int i14 = 1024;
            BigInteger add = bigInteger6.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(bigInteger6.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.pow(1024))));
            BigInteger mod = add.mod(bigInteger6);
            BigInteger bigInteger7 = ONE;
            if (mod.compareTo(bigInteger7) == 0) {
                add = add.add(bigInteger7);
            }
            int i15 = i10;
            while (true) {
                long j15 = (long) i15;
                BigInteger multiply = bigInteger3.multiply(bigInteger4).multiply(add.add(BigInteger.valueOf(j15)));
                BigInteger bigInteger8 = ONE;
                BigInteger add2 = multiply.add(bigInteger8);
                BigInteger bigInteger9 = TWO;
                if (add2.compareTo(bigInteger9.pow(i14)) == 1) {
                    break;
                } else if (bigInteger9.modPow(bigInteger3.multiply(bigInteger4).multiply(add.add(BigInteger.valueOf(j15))), add2).compareTo(bigInteger8) != 0 || bigInteger9.modPow(bigInteger3.multiply(add.add(BigInteger.valueOf(j15))), add2).compareTo(bigInteger8) == 0) {
                    i15 += 2;
                    i14 = 1024;
                } else {
                    bigIntegerArr[0] = add2;
                    bigIntegerArr[1] = bigInteger3;
                    return;
                }
            }
            i10 = 0;
        }
    }

    private BigInteger procedure_C(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger subtract = bigInteger.subtract(ONE);
        BigInteger divide = subtract.divide(bigInteger2);
        int bitLength = bigInteger.bitLength();
        while (true) {
            BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(bitLength, this.init_random);
            BigInteger bigInteger3 = ONE;
            if (createRandomBigInteger.compareTo(bigInteger3) > 0 && createRandomBigInteger.compareTo(subtract) < 0) {
                BigInteger modPow = createRandomBigInteger.modPow(divide, bigInteger);
                if (modPow.compareTo(bigInteger3) != 0) {
                    return modPow;
                }
            }
        }
    }

    public GOST3410Parameters generateParameters() {
        BigInteger[] bigIntegerArr = new BigInteger[2];
        if (this.typeproc == 1) {
            int nextInt = this.init_random.nextInt();
            int nextInt2 = this.init_random.nextInt();
            int i10 = this.size;
            if (i10 == 512) {
                procedure_A(nextInt, nextInt2, bigIntegerArr, 512);
            } else if (i10 == 1024) {
                procedure_B(nextInt, nextInt2, bigIntegerArr);
            } else {
                throw new IllegalArgumentException("Ooops! key size 512 or 1024 bit.");
            }
            BigInteger bigInteger = bigIntegerArr[0];
            BigInteger bigInteger2 = bigIntegerArr[1];
            return new GOST3410Parameters(bigInteger, bigInteger2, procedure_C(bigInteger, bigInteger2), new GOST3410ValidationParameters(nextInt, nextInt2));
        }
        long nextLong = this.init_random.nextLong();
        long nextLong2 = this.init_random.nextLong();
        int i11 = this.size;
        if (i11 == 512) {
            procedure_Aa(nextLong, nextLong2, bigIntegerArr, 512);
        } else if (i11 == 1024) {
            procedure_Bb(nextLong, nextLong2, bigIntegerArr);
        } else {
            throw new IllegalStateException("Ooops! key size 512 or 1024 bit.");
        }
        BigInteger bigInteger3 = bigIntegerArr[0];
        BigInteger bigInteger4 = bigIntegerArr[1];
        return new GOST3410Parameters(bigInteger3, bigInteger4, procedure_C(bigInteger3, bigInteger4), new GOST3410ValidationParameters(nextLong, nextLong2));
    }

    public void init(int i10, int i11, SecureRandom secureRandom) {
        this.size = i10;
        this.typeproc = i11;
        this.init_random = secureRandom;
    }
}
