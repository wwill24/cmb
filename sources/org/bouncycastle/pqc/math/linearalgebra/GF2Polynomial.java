package org.bouncycastle.pqc.math.linearalgebra;

import com.google.android.gms.common.api.a;
import java.math.BigInteger;
import java.util.Random;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.util.Arrays;
import org.jivesoftware.smack.datatypes.UInt32;

public class GF2Polynomial {
    private static final int[] bitMask = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, Opcodes.ACC_SYNTHETIC, 8192, Opcodes.ACC_ENUM, 32768, 65536, Opcodes.ACC_DEPRECATED, Opcodes.ASM4, Opcodes.ASM8, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, 0};
    private static final boolean[] parity = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    private static Random rand = new Random();
    private static final int[] reverseRightMask = {0, 1, 3, 7, 15, 31, 63, Opcodes.LAND, 255, 511, 1023, 2047, 4095, 8191, 16383, Advice.MethodSizeHandler.UNDEFINED_SIZE, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, a.e.API_PRIORITY_OTHER, -1};
    private static final short[] squaringTable = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
    private int blocks;
    private int len;
    private int[] value;

    public GF2Polynomial(int i10) {
        i10 = i10 < 1 ? 1 : i10;
        int i11 = ((i10 - 1) >> 5) + 1;
        this.blocks = i11;
        this.value = new int[i11];
        this.len = i10;
    }

    public GF2Polynomial(int i10, String str) {
        i10 = i10 < 1 ? 1 : i10;
        int i11 = ((i10 - 1) >> 5) + 1;
        this.blocks = i11;
        this.value = new int[i11];
        this.len = i10;
        if (str.equalsIgnoreCase("ZERO")) {
            assignZero();
        } else if (str.equalsIgnoreCase("ONE")) {
            assignOne();
        } else if (str.equalsIgnoreCase("RANDOM")) {
            randomize();
        } else if (str.equalsIgnoreCase("X")) {
            assignX();
        } else if (str.equalsIgnoreCase("ALL")) {
            assignAll();
        } else {
            throw new IllegalArgumentException("Error: GF2Polynomial was called using " + str + " as value!");
        }
    }

    public GF2Polynomial(int i10, BigInteger bigInteger) {
        i10 = i10 < 1 ? 1 : i10;
        int i11 = ((i10 - 1) >> 5) + 1;
        this.blocks = i11;
        this.value = new int[i11];
        this.len = i10;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] == 0) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            byteArray = bArr;
        }
        int length2 = byteArray.length & 3;
        int length3 = ((byteArray.length - 1) >> 2) + 1;
        for (int i12 = 0; i12 < length2; i12++) {
            int[] iArr = this.value;
            int i13 = length3 - 1;
            iArr[i13] = iArr[i13] | ((byteArray[i12] & 255) << (((length2 - 1) - i12) << 3));
        }
        for (int i14 = 0; i14 <= ((byteArray.length - 4) >> 2); i14++) {
            int length4 = (byteArray.length - 1) - (i14 << 2);
            int[] iArr2 = this.value;
            int i15 = byteArray[length4] & 255;
            iArr2[i14] = i15;
            int i16 = i15 | ((byteArray[length4 - 1] << 8) & 65280);
            iArr2[i14] = i16;
            int i17 = i16 | ((byteArray[length4 - 2] << Tnaf.POW_2_WIDTH) & 16711680);
            iArr2[i14] = i17;
            iArr2[i14] = ((byteArray[length4 - 3] << 24) & -16777216) | i17;
        }
        int i18 = this.len;
        if ((i18 & 31) != 0) {
            int[] iArr3 = this.value;
            int i19 = this.blocks - 1;
            iArr3[i19] = reverseRightMask[i18 & 31] & iArr3[i19];
        }
        reduceN();
    }

    public GF2Polynomial(int i10, Random random) {
        i10 = i10 < 1 ? 1 : i10;
        int i11 = ((i10 - 1) >> 5) + 1;
        this.blocks = i11;
        this.value = new int[i11];
        this.len = i10;
        randomize(random);
    }

    public GF2Polynomial(int i10, byte[] bArr) {
        int i11;
        i10 = i10 < 1 ? 1 : i10;
        int i12 = ((i10 - 1) >> 5) + 1;
        this.blocks = i12;
        this.value = new int[i12];
        this.len = i10;
        int min = Math.min(((bArr.length - 1) >> 2) + 1, i12);
        int i13 = 0;
        while (true) {
            i11 = min - 1;
            if (i13 >= i11) {
                break;
            }
            int length = (bArr.length - (i13 << 2)) - 1;
            int[] iArr = this.value;
            int i14 = bArr[length] & 255;
            iArr[i13] = i14;
            int i15 = (65280 & (bArr[length - 1] << 8)) | i14;
            iArr[i13] = i15;
            int i16 = (16711680 & (bArr[length - 2] << Tnaf.POW_2_WIDTH)) | i15;
            iArr[i13] = i16;
            iArr[i13] = ((bArr[length - 3] << 24) & -16777216) | i16;
            i13++;
        }
        int length2 = (bArr.length - (i11 << 2)) - 1;
        int[] iArr2 = this.value;
        int i17 = bArr[length2] & 255;
        iArr2[i11] = i17;
        if (length2 > 0) {
            iArr2[i11] = (65280 & (bArr[length2 - 1] << 8)) | i17;
        }
        if (length2 > 1) {
            iArr2[i11] = iArr2[i11] | (16711680 & (bArr[length2 - 2] << Tnaf.POW_2_WIDTH));
        }
        if (length2 > 2) {
            iArr2[i11] = ((bArr[length2 - 3] << 24) & -16777216) | iArr2[i11];
        }
        zeroUnusedBits();
        reduceN();
    }

    public GF2Polynomial(int i10, int[] iArr) {
        i10 = i10 < 1 ? 1 : i10;
        int i11 = ((i10 - 1) >> 5) + 1;
        this.blocks = i11;
        this.value = new int[i11];
        this.len = i10;
        System.arraycopy(iArr, 0, this.value, 0, Math.min(i11, iArr.length));
        zeroUnusedBits();
    }

    public GF2Polynomial(GF2Polynomial gF2Polynomial) {
        this.len = gF2Polynomial.len;
        this.blocks = gF2Polynomial.blocks;
        this.value = IntUtils.clone(gF2Polynomial.value);
    }

    private void doShiftBlocksLeft(int i10) {
        int i11 = this.blocks;
        int[] iArr = this.value;
        if (i11 <= iArr.length) {
            for (int i12 = i11 - 1; i12 >= i10; i12--) {
                int[] iArr2 = this.value;
                iArr2[i12] = iArr2[i12 - i10];
            }
            for (int i13 = 0; i13 < i10; i13++) {
                this.value[i13] = 0;
            }
            return;
        }
        int[] iArr3 = new int[i11];
        System.arraycopy(iArr, 0, iArr3, i10, i11 - i10);
        this.value = iArr3;
    }

    private GF2Polynomial karaMult(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.len << 1);
        int i10 = this.len;
        if (i10 <= 32) {
            gF2Polynomial2.value = mult32(this.value[0], gF2Polynomial.value[0]);
            return gF2Polynomial2;
        } else if (i10 <= 64) {
            gF2Polynomial2.value = mult64(this.value, gF2Polynomial.value);
            return gF2Polynomial2;
        } else if (i10 <= 128) {
            gF2Polynomial2.value = mult128(this.value, gF2Polynomial.value);
            return gF2Polynomial2;
        } else if (i10 <= 256) {
            gF2Polynomial2.value = mult256(this.value, gF2Polynomial.value);
            return gF2Polynomial2;
        } else if (i10 <= 512) {
            gF2Polynomial2.value = mult512(this.value, gF2Polynomial.value);
            return gF2Polynomial2;
        } else {
            int i11 = bitMask[IntegerFunctions.floorLog(i10 - 1)];
            int i12 = ((i11 - 1) >> 5) + 1;
            GF2Polynomial lower = lower(i12);
            GF2Polynomial upper = upper(i12);
            GF2Polynomial lower2 = gF2Polynomial.lower(i12);
            GF2Polynomial upper2 = gF2Polynomial.upper(i12);
            GF2Polynomial karaMult = upper.karaMult(upper2);
            GF2Polynomial karaMult2 = lower.karaMult(lower2);
            lower.addToThis(upper);
            lower2.addToThis(upper2);
            GF2Polynomial karaMult3 = lower.karaMult(lower2);
            gF2Polynomial2.shiftLeftAddThis(karaMult, i11 << 1);
            gF2Polynomial2.shiftLeftAddThis(karaMult, i11);
            gF2Polynomial2.shiftLeftAddThis(karaMult3, i11);
            gF2Polynomial2.shiftLeftAddThis(karaMult2, i11);
            gF2Polynomial2.addToThis(karaMult2);
            return gF2Polynomial2;
        }
    }

    private GF2Polynomial lower(int i10) {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(i10 << 5);
        System.arraycopy(this.value, 0, gF2Polynomial.value, 0, Math.min(i10, this.blocks));
        return gF2Polynomial;
    }

    private static int[] mult128(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[8];
        int[] iArr4 = new int[2];
        System.arraycopy(iArr, 0, iArr4, 0, Math.min(2, iArr.length));
        int[] iArr5 = new int[2];
        if (iArr.length > 2) {
            System.arraycopy(iArr, 2, iArr5, 0, Math.min(2, iArr.length - 2));
        }
        int[] iArr6 = new int[2];
        System.arraycopy(iArr2, 0, iArr6, 0, Math.min(2, iArr2.length));
        int[] iArr7 = new int[2];
        if (iArr2.length > 2) {
            System.arraycopy(iArr2, 2, iArr7, 0, Math.min(2, iArr2.length - 2));
        }
        if (iArr5[1] == 0 && iArr7[1] == 0) {
            int i10 = iArr5[0];
            if (!(i10 == 0 && iArr7[0] == 0)) {
                int[] mult32 = mult32(i10, iArr7[0]);
                int i11 = iArr3[5];
                int i12 = mult32[1];
                iArr3[5] = i11 ^ i12;
                int i13 = iArr3[4];
                int i14 = mult32[0];
                iArr3[4] = i13 ^ i14;
                iArr3[3] = iArr3[3] ^ i12;
                iArr3[2] = i14 ^ iArr3[2];
            }
        } else {
            int[] mult64 = mult64(iArr5, iArr7);
            int i15 = iArr3[7];
            int i16 = mult64[3];
            iArr3[7] = i15 ^ i16;
            int i17 = iArr3[6];
            int i18 = mult64[2];
            iArr3[6] = i17 ^ i18;
            int i19 = iArr3[5];
            int i20 = mult64[1];
            iArr3[5] = i19 ^ (i16 ^ i20);
            int i21 = iArr3[4];
            int i22 = mult64[0];
            iArr3[4] = i21 ^ (i22 ^ i18);
            iArr3[3] = iArr3[3] ^ i20;
            iArr3[2] = i22 ^ iArr3[2];
        }
        iArr5[0] = iArr5[0] ^ iArr4[0];
        iArr5[1] = iArr5[1] ^ iArr4[1];
        int i23 = iArr7[0] ^ iArr6[0];
        iArr7[0] = i23;
        int i24 = iArr7[1] ^ iArr6[1];
        iArr7[1] = i24;
        if (iArr5[1] == 0 && i24 == 0) {
            int[] mult322 = mult32(iArr5[0], i23);
            iArr3[3] = iArr3[3] ^ mult322[1];
            iArr3[2] = mult322[0] ^ iArr3[2];
        } else {
            int[] mult642 = mult64(iArr5, iArr7);
            iArr3[5] = iArr3[5] ^ mult642[3];
            iArr3[4] = iArr3[4] ^ mult642[2];
            iArr3[3] = iArr3[3] ^ mult642[1];
            iArr3[2] = mult642[0] ^ iArr3[2];
        }
        if (iArr4[1] == 0 && iArr6[1] == 0) {
            int[] mult323 = mult32(iArr4[0], iArr6[0]);
            int i25 = iArr3[3];
            int i26 = mult323[1];
            iArr3[3] = i25 ^ i26;
            int i27 = iArr3[2];
            int i28 = mult323[0];
            iArr3[2] = i27 ^ i28;
            iArr3[1] = iArr3[1] ^ i26;
            iArr3[0] = i28 ^ iArr3[0];
        } else {
            int[] mult643 = mult64(iArr4, iArr6);
            int i29 = iArr3[5];
            int i30 = mult643[3];
            iArr3[5] = i29 ^ i30;
            int i31 = iArr3[4];
            int i32 = mult643[2];
            iArr3[4] = i31 ^ i32;
            int i33 = iArr3[3];
            int i34 = mult643[1];
            iArr3[3] = i33 ^ (i30 ^ i34);
            int i35 = iArr3[2];
            int i36 = mult643[0];
            iArr3[2] = i35 ^ (i36 ^ i32);
            iArr3[1] = iArr3[1] ^ i34;
            iArr3[0] = i36 ^ iArr3[0];
        }
        return iArr3;
    }

    private static int[] mult256(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int[] iArr5 = new int[16];
        int[] iArr6 = new int[4];
        System.arraycopy(iArr3, 0, iArr6, 0, Math.min(4, iArr3.length));
        int[] iArr7 = new int[4];
        if (iArr3.length > 4) {
            System.arraycopy(iArr3, 4, iArr7, 0, Math.min(4, iArr3.length - 4));
        }
        int[] iArr8 = new int[4];
        System.arraycopy(iArr4, 0, iArr8, 0, Math.min(4, iArr4.length));
        int[] iArr9 = new int[4];
        if (iArr4.length > 4) {
            System.arraycopy(iArr4, 4, iArr9, 0, Math.min(4, iArr4.length - 4));
        }
        if (iArr7[3] != 0 || iArr7[2] != 0 || iArr9[3] != 0 || iArr9[2] != 0) {
            int[] mult128 = mult128(iArr7, iArr9);
            int i10 = iArr5[15];
            int i11 = mult128[7];
            iArr5[15] = i10 ^ i11;
            int i12 = iArr5[14];
            int i13 = mult128[6];
            iArr5[14] = i12 ^ i13;
            int i14 = iArr5[13];
            int i15 = mult128[5];
            iArr5[13] = i14 ^ i15;
            int i16 = iArr5[12];
            int i17 = mult128[4];
            iArr5[12] = i16 ^ i17;
            int i18 = iArr5[11];
            int i19 = mult128[3];
            iArr5[11] = i18 ^ (i19 ^ i11);
            int i20 = iArr5[10];
            int i21 = mult128[2];
            iArr5[10] = i20 ^ (i21 ^ i13);
            int i22 = iArr5[9];
            int i23 = mult128[1];
            iArr5[9] = i22 ^ (i23 ^ i15);
            int i24 = iArr5[8];
            int i25 = mult128[0];
            iArr5[8] = i24 ^ (i25 ^ i17);
            iArr5[7] = iArr5[7] ^ i19;
            iArr5[6] = iArr5[6] ^ i21;
            iArr5[5] = iArr5[5] ^ i23;
            iArr5[4] = i25 ^ iArr5[4];
        } else if (iArr7[1] == 0 && iArr9[1] == 0) {
            int i26 = iArr7[0];
            if (!(i26 == 0 && iArr9[0] == 0)) {
                int[] mult32 = mult32(i26, iArr9[0]);
                int i27 = iArr5[9];
                int i28 = mult32[1];
                iArr5[9] = i27 ^ i28;
                int i29 = iArr5[8];
                int i30 = mult32[0];
                iArr5[8] = i29 ^ i30;
                iArr5[5] = iArr5[5] ^ i28;
                iArr5[4] = i30 ^ iArr5[4];
            }
        } else {
            int[] mult64 = mult64(iArr7, iArr9);
            int i31 = iArr5[11];
            int i32 = mult64[3];
            iArr5[11] = i31 ^ i32;
            int i33 = iArr5[10];
            int i34 = mult64[2];
            iArr5[10] = i33 ^ i34;
            int i35 = iArr5[9];
            int i36 = mult64[1];
            iArr5[9] = i35 ^ i36;
            int i37 = iArr5[8];
            int i38 = mult64[0];
            iArr5[8] = i37 ^ i38;
            iArr5[7] = iArr5[7] ^ i32;
            iArr5[6] = iArr5[6] ^ i34;
            iArr5[5] = iArr5[5] ^ i36;
            iArr5[4] = i38 ^ iArr5[4];
        }
        iArr7[0] = iArr7[0] ^ iArr6[0];
        iArr7[1] = iArr7[1] ^ iArr6[1];
        iArr7[2] = iArr7[2] ^ iArr6[2];
        iArr7[3] = iArr7[3] ^ iArr6[3];
        iArr9[0] = iArr9[0] ^ iArr8[0];
        iArr9[1] = iArr9[1] ^ iArr8[1];
        iArr9[2] = iArr9[2] ^ iArr8[2];
        iArr9[3] = iArr9[3] ^ iArr8[3];
        int[] mult1282 = mult128(iArr7, iArr9);
        iArr5[11] = iArr5[11] ^ mult1282[7];
        iArr5[10] = iArr5[10] ^ mult1282[6];
        iArr5[9] = iArr5[9] ^ mult1282[5];
        iArr5[8] = iArr5[8] ^ mult1282[4];
        iArr5[7] = iArr5[7] ^ mult1282[3];
        iArr5[6] = iArr5[6] ^ mult1282[2];
        iArr5[5] = iArr5[5] ^ mult1282[1];
        iArr5[4] = mult1282[0] ^ iArr5[4];
        int[] mult1283 = mult128(iArr6, iArr8);
        int i39 = iArr5[11];
        int i40 = mult1283[7];
        iArr5[11] = i39 ^ i40;
        int i41 = iArr5[10];
        int i42 = mult1283[6];
        iArr5[10] = i41 ^ i42;
        int i43 = iArr5[9];
        int i44 = mult1283[5];
        iArr5[9] = i43 ^ i44;
        int i45 = iArr5[8];
        int i46 = mult1283[4];
        iArr5[8] = i45 ^ i46;
        int i47 = iArr5[7];
        int i48 = mult1283[3];
        iArr5[7] = i47 ^ (i40 ^ i48);
        int i49 = iArr5[6];
        int i50 = mult1283[2];
        iArr5[6] = i49 ^ (i42 ^ i50);
        int i51 = iArr5[5];
        int i52 = mult1283[1];
        iArr5[5] = i51 ^ (i44 ^ i52);
        int i53 = iArr5[4];
        int i54 = mult1283[0];
        iArr5[4] = i53 ^ (i54 ^ i46);
        iArr5[3] = iArr5[3] ^ i48;
        iArr5[2] = iArr5[2] ^ i50;
        iArr5[1] = iArr5[1] ^ i52;
        iArr5[0] = i54 ^ iArr5[0];
        return iArr5;
    }

    private static int[] mult32(int i10, int i11) {
        int[] iArr = new int[2];
        if (!(i10 == 0 || i11 == 0)) {
            long j10 = ((long) i11) & UInt32.MAX_VALUE_LONG;
            long j11 = 0;
            for (int i12 = 1; i12 <= 32; i12++) {
                if ((bitMask[i12 - 1] & i10) != 0) {
                    j11 ^= j10;
                }
                j10 <<= 1;
            }
            iArr[1] = (int) (j11 >>> 32);
            iArr[0] = (int) (j11 & UInt32.MAX_VALUE_LONG);
        }
        return iArr;
    }

    private static int[] mult512(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int[] iArr5 = new int[32];
        int[] iArr6 = new int[8];
        System.arraycopy(iArr3, 0, iArr6, 0, Math.min(8, iArr3.length));
        int[] iArr7 = new int[8];
        if (iArr3.length > 8) {
            System.arraycopy(iArr3, 8, iArr7, 0, Math.min(8, iArr3.length - 8));
        }
        int[] iArr8 = new int[8];
        System.arraycopy(iArr4, 0, iArr8, 0, Math.min(8, iArr4.length));
        int[] iArr9 = new int[8];
        if (iArr4.length > 8) {
            System.arraycopy(iArr4, 8, iArr9, 0, Math.min(8, iArr4.length - 8));
        }
        int[] mult256 = mult256(iArr7, iArr9);
        int i10 = iArr5[31];
        int i11 = mult256[15];
        iArr5[31] = i10 ^ i11;
        int i12 = iArr5[30];
        int i13 = mult256[14];
        iArr5[30] = i12 ^ i13;
        int i14 = iArr5[29];
        int i15 = mult256[13];
        iArr5[29] = i14 ^ i15;
        int i16 = iArr5[28];
        int i17 = mult256[12];
        iArr5[28] = i16 ^ i17;
        int i18 = iArr5[27];
        int i19 = mult256[11];
        iArr5[27] = i18 ^ i19;
        int i20 = iArr5[26];
        int i21 = mult256[10];
        iArr5[26] = i20 ^ i21;
        int i22 = iArr5[25];
        int i23 = mult256[9];
        iArr5[25] = i22 ^ i23;
        int i24 = iArr5[24];
        int i25 = mult256[8];
        iArr5[24] = i24 ^ i25;
        int i26 = iArr5[23];
        int i27 = mult256[7];
        iArr5[23] = i26 ^ (i27 ^ i11);
        int i28 = iArr5[22];
        int i29 = mult256[6];
        iArr5[22] = i28 ^ (i29 ^ i13);
        int i30 = iArr5[21];
        int i31 = mult256[5];
        iArr5[21] = i30 ^ (i31 ^ i15);
        int i32 = iArr5[20];
        int i33 = mult256[4];
        iArr5[20] = i32 ^ (i33 ^ i17);
        int i34 = iArr5[19];
        int i35 = mult256[3];
        iArr5[19] = i34 ^ (i35 ^ i19);
        int i36 = iArr5[18];
        int i37 = mult256[2];
        iArr5[18] = i36 ^ (i37 ^ i21);
        int i38 = iArr5[17];
        int i39 = mult256[1];
        iArr5[17] = i38 ^ (i39 ^ i23);
        int i40 = iArr5[16];
        int i41 = mult256[0];
        iArr5[16] = i40 ^ (i41 ^ i25);
        iArr5[15] = iArr5[15] ^ i27;
        iArr5[14] = iArr5[14] ^ i29;
        iArr5[13] = iArr5[13] ^ i31;
        iArr5[12] = iArr5[12] ^ i33;
        iArr5[11] = iArr5[11] ^ i35;
        iArr5[10] = iArr5[10] ^ i37;
        iArr5[9] = iArr5[9] ^ i39;
        iArr5[8] = iArr5[8] ^ i41;
        iArr7[0] = iArr7[0] ^ iArr6[0];
        iArr7[1] = iArr7[1] ^ iArr6[1];
        iArr7[2] = iArr7[2] ^ iArr6[2];
        iArr7[3] = iArr7[3] ^ iArr6[3];
        iArr7[4] = iArr7[4] ^ iArr6[4];
        iArr7[5] = iArr7[5] ^ iArr6[5];
        iArr7[6] = iArr7[6] ^ iArr6[6];
        iArr7[7] = iArr7[7] ^ iArr6[7];
        iArr9[0] = iArr9[0] ^ iArr8[0];
        iArr9[1] = iArr9[1] ^ iArr8[1];
        iArr9[2] = iArr9[2] ^ iArr8[2];
        iArr9[3] = iArr9[3] ^ iArr8[3];
        iArr9[4] = iArr9[4] ^ iArr8[4];
        iArr9[5] = iArr9[5] ^ iArr8[5];
        iArr9[6] = iArr9[6] ^ iArr8[6];
        iArr9[7] = iArr9[7] ^ iArr8[7];
        int[] mult2562 = mult256(iArr7, iArr9);
        iArr5[23] = iArr5[23] ^ mult2562[15];
        iArr5[22] = iArr5[22] ^ mult2562[14];
        iArr5[21] = iArr5[21] ^ mult2562[13];
        iArr5[20] = iArr5[20] ^ mult2562[12];
        iArr5[19] = iArr5[19] ^ mult2562[11];
        iArr5[18] = iArr5[18] ^ mult2562[10];
        iArr5[17] = iArr5[17] ^ mult2562[9];
        iArr5[16] = iArr5[16] ^ mult2562[8];
        iArr5[15] = iArr5[15] ^ mult2562[7];
        iArr5[14] = iArr5[14] ^ mult2562[6];
        iArr5[13] = iArr5[13] ^ mult2562[5];
        iArr5[12] = iArr5[12] ^ mult2562[4];
        iArr5[11] = iArr5[11] ^ mult2562[3];
        iArr5[10] = iArr5[10] ^ mult2562[2];
        iArr5[9] = iArr5[9] ^ mult2562[1];
        iArr5[8] = mult2562[0] ^ iArr5[8];
        int[] mult2563 = mult256(iArr6, iArr8);
        int i42 = iArr5[23];
        int i43 = mult2563[15];
        iArr5[23] = i42 ^ i43;
        int i44 = iArr5[22];
        int i45 = mult2563[14];
        iArr5[22] = i44 ^ i45;
        int i46 = iArr5[21];
        int i47 = mult2563[13];
        iArr5[21] = i46 ^ i47;
        int i48 = iArr5[20];
        int i49 = mult2563[12];
        iArr5[20] = i48 ^ i49;
        int i50 = iArr5[19];
        int i51 = mult2563[11];
        iArr5[19] = i50 ^ i51;
        int i52 = iArr5[18];
        int i53 = mult2563[10];
        iArr5[18] = i52 ^ i53;
        int i54 = iArr5[17];
        int i55 = mult2563[9];
        iArr5[17] = i54 ^ i55;
        int i56 = iArr5[16];
        int i57 = mult2563[8];
        iArr5[16] = i56 ^ i57;
        int i58 = iArr5[15];
        int i59 = mult2563[7];
        iArr5[15] = i58 ^ (i43 ^ i59);
        int i60 = iArr5[14];
        int i61 = mult2563[6];
        iArr5[14] = i60 ^ (i45 ^ i61);
        int i62 = iArr5[13];
        int i63 = mult2563[5];
        iArr5[13] = i62 ^ (i47 ^ i63);
        int i64 = iArr5[12];
        int i65 = mult2563[4];
        iArr5[12] = i64 ^ (i49 ^ i65);
        int i66 = iArr5[11];
        int i67 = mult2563[3];
        iArr5[11] = i66 ^ (i51 ^ i67);
        int i68 = iArr5[10];
        int i69 = mult2563[2];
        iArr5[10] = i68 ^ (i69 ^ i53);
        int i70 = iArr5[9];
        int i71 = mult2563[1];
        iArr5[9] = i70 ^ (i71 ^ i55);
        int i72 = iArr5[8];
        int i73 = mult2563[0];
        iArr5[8] = i72 ^ (i73 ^ i57);
        iArr5[7] = iArr5[7] ^ i59;
        iArr5[6] = iArr5[6] ^ i61;
        iArr5[5] = iArr5[5] ^ i63;
        iArr5[4] = iArr5[4] ^ i65;
        iArr5[3] = iArr5[3] ^ i67;
        iArr5[2] = iArr5[2] ^ i69;
        iArr5[1] = iArr5[1] ^ i71;
        iArr5[0] = i73 ^ iArr5[0];
        return iArr5;
    }

    private static int[] mult64(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[4];
        int i10 = iArr[0];
        int i11 = iArr.length > 1 ? iArr[1] : 0;
        int i12 = iArr2[0];
        int i13 = iArr2.length > 1 ? iArr2[1] : 0;
        if (!(i11 == 0 && i13 == 0)) {
            int[] mult32 = mult32(i11, i13);
            int i14 = iArr3[3];
            int i15 = mult32[1];
            iArr3[3] = i14 ^ i15;
            int i16 = iArr3[2];
            int i17 = mult32[0];
            iArr3[2] = i16 ^ (i17 ^ i15);
            iArr3[1] = i17 ^ iArr3[1];
        }
        int[] mult322 = mult32(i11 ^ i10, i13 ^ i12);
        iArr3[2] = iArr3[2] ^ mult322[1];
        iArr3[1] = mult322[0] ^ iArr3[1];
        int[] mult323 = mult32(i10, i12);
        int i18 = iArr3[2];
        int i19 = mult323[1];
        iArr3[2] = i18 ^ i19;
        int i20 = iArr3[1];
        int i21 = mult323[0];
        iArr3[1] = i20 ^ (i19 ^ i21);
        iArr3[0] = i21 ^ iArr3[0];
        return iArr3;
    }

    private GF2Polynomial upper(int i10) {
        int min = Math.min(i10, this.blocks - i10);
        GF2Polynomial gF2Polynomial = new GF2Polynomial(min << 5);
        if (this.blocks >= i10) {
            System.arraycopy(this.value, i10, gF2Polynomial.value, 0, min);
        }
        return gF2Polynomial;
    }

    private void zeroUnusedBits() {
        int i10 = this.len;
        if ((i10 & 31) != 0) {
            int[] iArr = this.value;
            int i11 = this.blocks - 1;
            iArr[i11] = reverseRightMask[i10 & 31] & iArr[i11];
        }
    }

    public GF2Polynomial add(GF2Polynomial gF2Polynomial) {
        return xor(gF2Polynomial);
    }

    public void addToThis(GF2Polynomial gF2Polynomial) {
        expandN(gF2Polynomial.len);
        xorThisBy(gF2Polynomial);
    }

    public void assignAll() {
        for (int i10 = 0; i10 < this.blocks; i10++) {
            this.value[i10] = -1;
        }
        zeroUnusedBits();
    }

    public void assignOne() {
        for (int i10 = 1; i10 < this.blocks; i10++) {
            this.value[i10] = 0;
        }
        this.value[0] = 1;
    }

    public void assignX() {
        for (int i10 = 1; i10 < this.blocks; i10++) {
            this.value[i10] = 0;
        }
        this.value[0] = 2;
    }

    public void assignZero() {
        for (int i10 = 0; i10 < this.blocks; i10++) {
            this.value[i10] = 0;
        }
    }

    public Object clone() {
        return new GF2Polynomial(this);
    }

    public GF2Polynomial[] divide(GF2Polynomial gF2Polynomial) throws RuntimeException {
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[2];
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.len);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial4 = new GF2Polynomial(gF2Polynomial);
        if (!gF2Polynomial4.isZero()) {
            gF2Polynomial3.reduceN();
            gF2Polynomial4.reduceN();
            int i10 = gF2Polynomial3.len;
            int i11 = gF2Polynomial4.len;
            if (i10 < i11) {
                gF2PolynomialArr[0] = new GF2Polynomial(0);
                gF2PolynomialArr[1] = gF2Polynomial3;
                return gF2PolynomialArr;
            }
            int i12 = i10 - i11;
            gF2Polynomial2.expandN(i12 + 1);
            while (i12 >= 0) {
                gF2Polynomial3.subtractFromThis(gF2Polynomial4.shiftLeft(i12));
                gF2Polynomial3.reduceN();
                gF2Polynomial2.xorBit(i12);
                i12 = gF2Polynomial3.len - gF2Polynomial4.len;
            }
            gF2PolynomialArr[0] = gF2Polynomial2;
            gF2PolynomialArr[1] = gF2Polynomial3;
            return gF2PolynomialArr;
        }
        throw new RuntimeException();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2Polynomial)) {
            return false;
        }
        GF2Polynomial gF2Polynomial = (GF2Polynomial) obj;
        if (this.len != gF2Polynomial.len) {
            return false;
        }
        for (int i10 = 0; i10 < this.blocks; i10++) {
            if (this.value[i10] != gF2Polynomial.value[i10]) {
                return false;
            }
        }
        return true;
    }

    public void expandN(int i10) {
        if (this.len < i10) {
            this.len = i10;
            int i11 = ((i10 - 1) >>> 5) + 1;
            int i12 = this.blocks;
            if (i12 < i11) {
                int[] iArr = this.value;
                if (iArr.length >= i11) {
                    while (i12 < i11) {
                        this.value[i12] = 0;
                        i12++;
                    }
                    this.blocks = i11;
                    return;
                }
                int[] iArr2 = new int[i11];
                System.arraycopy(iArr, 0, iArr2, 0, i12);
                this.blocks = i11;
                this.value = iArr2;
            }
        }
    }

    public GF2Polynomial gcd(GF2Polynomial gF2Polynomial) throws RuntimeException {
        if (isZero() && gF2Polynomial.isZero()) {
            throw new ArithmeticException("Both operands of gcd equal zero.");
        } else if (isZero()) {
            return new GF2Polynomial(gF2Polynomial);
        } else {
            if (gF2Polynomial.isZero()) {
                return new GF2Polynomial(this);
            }
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this);
            GF2Polynomial gF2Polynomial3 = new GF2Polynomial(gF2Polynomial);
            GF2Polynomial gF2Polynomial4 = gF2Polynomial2;
            GF2Polynomial gF2Polynomial5 = gF2Polynomial3;
            while (!gF2Polynomial5.isZero()) {
                GF2Polynomial gF2Polynomial6 = gF2Polynomial5;
                gF2Polynomial5 = gF2Polynomial4.remainder(gF2Polynomial5);
                gF2Polynomial4 = gF2Polynomial6;
            }
            return gF2Polynomial4;
        }
    }

    public int getBit(int i10) {
        if (i10 < 0) {
            throw new RuntimeException();
        } else if (i10 > this.len - 1) {
            return 0;
        } else {
            return (bitMask[i10 & 31] & this.value[i10 >>> 5]) != 0 ? 1 : 0;
        }
    }

    public int getLength() {
        return this.len;
    }

    public int hashCode() {
        return this.len + Arrays.hashCode(this.value);
    }

    public GF2Polynomial increase() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this);
        gF2Polynomial.increaseThis();
        return gF2Polynomial;
    }

    public void increaseThis() {
        xorBit(0);
    }

    public boolean isIrreducible() {
        if (isZero()) {
            return false;
        }
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this);
        gF2Polynomial.reduceN();
        int i10 = gF2Polynomial.len;
        int i11 = i10 - 1;
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(i10, "X");
        for (int i12 = 1; i12 <= (i11 >> 1); i12++) {
            gF2Polynomial2.squareThisPreCalc();
            gF2Polynomial2 = gF2Polynomial2.remainder(gF2Polynomial);
            GF2Polynomial add = gF2Polynomial2.add(new GF2Polynomial(32, "X"));
            if (add.isZero() || !gF2Polynomial.gcd(add).isOne()) {
                return false;
            }
        }
        return true;
    }

    public boolean isOne() {
        for (int i10 = 1; i10 < this.blocks; i10++) {
            if (this.value[i10] != 0) {
                return false;
            }
        }
        return this.value[0] == 1;
    }

    public boolean isZero() {
        if (this.len == 0) {
            return true;
        }
        for (int i10 = 0; i10 < this.blocks; i10++) {
            if (this.value[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public GF2Polynomial multiply(GF2Polynomial gF2Polynomial) {
        int max = Math.max(this.len, gF2Polynomial.len);
        expandN(max);
        gF2Polynomial.expandN(max);
        return karaMult(gF2Polynomial);
    }

    public GF2Polynomial multiplyClassic(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(Math.max(this.len, gF2Polynomial.len) << 1);
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[32];
        gF2PolynomialArr[0] = new GF2Polynomial(this);
        for (int i10 = 1; i10 <= 31; i10++) {
            gF2PolynomialArr[i10] = gF2PolynomialArr[i10 - 1].shiftLeft();
        }
        for (int i11 = 0; i11 < gF2Polynomial.blocks; i11++) {
            for (int i12 = 0; i12 <= 31; i12++) {
                if ((gF2Polynomial.value[i11] & bitMask[i12]) != 0) {
                    gF2Polynomial2.xorThisBy(gF2PolynomialArr[i12]);
                }
            }
            for (int i13 = 0; i13 <= 31; i13++) {
                gF2PolynomialArr[i13].shiftBlocksLeft();
            }
        }
        return gF2Polynomial2;
    }

    public GF2Polynomial quotient(GF2Polynomial gF2Polynomial) throws RuntimeException {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.len);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial4 = new GF2Polynomial(gF2Polynomial);
        if (!gF2Polynomial4.isZero()) {
            gF2Polynomial3.reduceN();
            gF2Polynomial4.reduceN();
            int i10 = gF2Polynomial3.len;
            int i11 = gF2Polynomial4.len;
            if (i10 < i11) {
                return new GF2Polynomial(0);
            }
            int i12 = i10 - i11;
            gF2Polynomial2.expandN(i12 + 1);
            while (i12 >= 0) {
                gF2Polynomial3.subtractFromThis(gF2Polynomial4.shiftLeft(i12));
                gF2Polynomial3.reduceN();
                gF2Polynomial2.xorBit(i12);
                i12 = gF2Polynomial3.len - gF2Polynomial4.len;
            }
            return gF2Polynomial2;
        }
        throw new RuntimeException();
    }

    public void randomize() {
        for (int i10 = 0; i10 < this.blocks; i10++) {
            this.value[i10] = rand.nextInt();
        }
        zeroUnusedBits();
    }

    public void randomize(Random random) {
        for (int i10 = 0; i10 < this.blocks; i10++) {
            this.value[i10] = random.nextInt();
        }
        zeroUnusedBits();
    }

    public void reduceN() {
        int i10;
        int i11 = this.blocks;
        while (true) {
            i11--;
            i10 = this.value[i11];
            if (i10 != 0 || i11 <= 0) {
                int i12 = 0;
            }
        }
        int i122 = 0;
        while (i10 != 0) {
            i10 >>>= 1;
            i122++;
        }
        this.len = (i11 << 5) + i122;
        this.blocks = i11 + 1;
    }

    /* access modifiers changed from: package-private */
    public void reducePentanomial(int i10, int[] iArr) {
        GF2Polynomial gF2Polynomial = this;
        int i11 = i10;
        int i12 = i11 >>> 5;
        int i13 = i11 & 31;
        int i14 = 32 - i13;
        boolean z10 = false;
        int i15 = iArr[0];
        int i16 = (i11 - i15) >>> 5;
        int i17 = 32 - ((i11 - i15) & 31);
        int i18 = iArr[1];
        int i19 = (i11 - i18) >>> 5;
        int i20 = 32 - ((i11 - i18) & 31);
        int i21 = iArr[2];
        int i22 = (i11 - i21) >>> 5;
        int i23 = 32 - ((i11 - i21) & 31);
        int i24 = ((i11 << 1) - 2) >>> 5;
        while (i24 > i12) {
            int[] iArr2 = gF2Polynomial.value;
            long j10 = ((long) iArr2[i24]) & UInt32.MAX_VALUE_LONG;
            int i25 = i24 - i12;
            int i26 = i25 - 1;
            int i27 = i12;
            int i28 = i13;
            iArr2[i26] = ((int) (j10 << i14)) ^ iArr2[i26];
            iArr2[i25] = (int) (((long) iArr2[i25]) ^ (j10 >>> (32 - i14)));
            int i29 = i24 - i16;
            int i30 = i29 - 1;
            iArr2[i30] = iArr2[i30] ^ ((int) (j10 << i17));
            iArr2[i29] = (int) (((long) iArr2[i29]) ^ (j10 >>> (32 - i17)));
            int i31 = i24 - i19;
            int i32 = i31 - 1;
            iArr2[i32] = iArr2[i32] ^ ((int) (j10 << i20));
            iArr2[i31] = (int) (((long) iArr2[i31]) ^ (j10 >>> (32 - i20)));
            int i33 = i24 - i22;
            int i34 = i33 - 1;
            iArr2[i34] = iArr2[i34] ^ ((int) (j10 << i23));
            iArr2[i33] = (int) ((j10 >>> (32 - i23)) ^ ((long) iArr2[i33]));
            iArr2[i24] = 0;
            i24--;
            int i35 = i10;
            z10 = false;
            i12 = i27;
            i13 = i28;
            gF2Polynomial = this;
        }
        GF2Polynomial gF2Polynomial2 = gF2Polynomial;
        int i36 = i12;
        int i37 = i13;
        boolean z11 = z10;
        int[] iArr3 = gF2Polynomial2.value;
        long j11 = ((long) iArr3[i36]) & UInt32.MAX_VALUE_LONG & (UInt32.MAX_VALUE_LONG << i37);
        iArr3[0] = (int) ((j11 >>> (32 - i14)) ^ ((long) iArr3[0]));
        int i38 = i36 - i16;
        int i39 = i38 - 1;
        if (i39 >= 0) {
            iArr3[i39] = iArr3[i39] ^ ((int) (j11 << i17));
        }
        iArr3[i38] = (int) (((long) iArr3[i38]) ^ (j11 >>> (32 - i17)));
        int i40 = i36 - i19;
        int i41 = i40 - 1;
        if (i41 >= 0) {
            iArr3[i41] = iArr3[i41] ^ ((int) (j11 << i20));
        }
        iArr3[i40] = (int) (((long) iArr3[i40]) ^ (j11 >>> (32 - i20)));
        int i42 = i36 - i22;
        int i43 = i42 - 1;
        if (i43 >= 0) {
            iArr3[i43] = iArr3[i43] ^ ((int) (j11 << i23));
        }
        iArr3[i42] = (int) ((j11 >>> (32 - i23)) ^ ((long) iArr3[i42]));
        iArr3[i36] = iArr3[i36] & reverseRightMask[i37];
        int i44 = i10;
        this.blocks = ((i44 - 1) >>> 5) + 1;
        this.len = i44;
    }

    /* access modifiers changed from: package-private */
    public void reduceTrinomial(int i10, int i11) {
        int i12 = i10;
        int i13 = i12 >>> 5;
        int i14 = i12 & 31;
        int i15 = 32 - i14;
        int i16 = i12 - i11;
        int i17 = i16 >>> 5;
        int i18 = 32 - (i16 & 31);
        int i19 = ((i12 << 1) - 2) >>> 5;
        while (i19 > i13) {
            int[] iArr = this.value;
            long j10 = UInt32.MAX_VALUE_LONG & ((long) iArr[i19]);
            int i20 = i19 - i13;
            int i21 = i20 - 1;
            int i22 = i13;
            iArr[i21] = ((int) (j10 << i15)) ^ iArr[i21];
            iArr[i20] = (int) (((long) iArr[i20]) ^ (j10 >>> (32 - i15)));
            int i23 = i19 - i17;
            int i24 = i23 - 1;
            iArr[i24] = iArr[i24] ^ ((int) (j10 << i18));
            iArr[i23] = (int) ((j10 >>> (32 - i18)) ^ ((long) iArr[i23]));
            iArr[i19] = 0;
            i19--;
            int i25 = i10;
            i13 = i22;
        }
        int i26 = i13;
        int[] iArr2 = this.value;
        long j11 = (UInt32.MAX_VALUE_LONG << i14) & ((long) iArr2[i26]) & UInt32.MAX_VALUE_LONG;
        iArr2[0] = (int) (((long) iArr2[0]) ^ (j11 >>> (32 - i15)));
        int i27 = i26 - i17;
        int i28 = i27 - 1;
        if (i28 >= 0) {
            iArr2[i28] = iArr2[i28] ^ ((int) (j11 << i18));
        }
        iArr2[i27] = (int) ((j11 >>> (32 - i18)) ^ ((long) iArr2[i27]));
        iArr2[i26] = iArr2[i26] & reverseRightMask[i14];
        int i29 = i10;
        this.blocks = ((i29 - 1) >>> 5) + 1;
        this.len = i29;
    }

    public GF2Polynomial remainder(GF2Polynomial gF2Polynomial) throws RuntimeException {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(gF2Polynomial);
        if (!gF2Polynomial3.isZero()) {
            gF2Polynomial2.reduceN();
            gF2Polynomial3.reduceN();
            int i10 = gF2Polynomial2.len;
            int i11 = gF2Polynomial3.len;
            if (i10 < i11) {
                return gF2Polynomial2;
            }
            while (true) {
                int i12 = i10 - i11;
                if (i12 < 0) {
                    return gF2Polynomial2;
                }
                gF2Polynomial2.subtractFromThis(gF2Polynomial3.shiftLeft(i12));
                gF2Polynomial2.reduceN();
                i10 = gF2Polynomial2.len;
                i11 = gF2Polynomial3.len;
            }
        } else {
            throw new RuntimeException();
        }
    }

    public void resetBit(int i10) throws RuntimeException {
        if (i10 < 0) {
            throw new RuntimeException();
        } else if (i10 <= this.len - 1) {
            int[] iArr = this.value;
            int i11 = i10 >>> 5;
            iArr[i11] = (~bitMask[i10 & 31]) & iArr[i11];
        }
    }

    public void setBit(int i10) throws RuntimeException {
        if (i10 < 0 || i10 > this.len - 1) {
            throw new RuntimeException();
        }
        int[] iArr = this.value;
        int i11 = i10 >>> 5;
        iArr[i11] = bitMask[i10 & 31] | iArr[i11];
    }

    /* access modifiers changed from: package-private */
    public void shiftBlocksLeft() {
        int i10 = this.blocks + 1;
        this.blocks = i10;
        this.len += 32;
        int[] iArr = this.value;
        if (i10 <= iArr.length) {
            for (int i11 = i10 - 1; i11 >= 1; i11--) {
                int[] iArr2 = this.value;
                iArr2[i11] = iArr2[i11 - 1];
            }
            this.value[0] = 0;
            return;
        }
        int[] iArr3 = new int[i10];
        System.arraycopy(iArr, 0, iArr3, 1, i10 - 1);
        this.value = iArr3;
    }

    public GF2Polynomial shiftLeft() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.len + 1, this.value);
        for (int i10 = gF2Polynomial.blocks - 1; i10 >= 1; i10--) {
            int[] iArr = gF2Polynomial.value;
            int i11 = iArr[i10] << 1;
            iArr[i10] = i11;
            iArr[i10] = i11 | (iArr[i10 - 1] >>> 31);
        }
        int[] iArr2 = gF2Polynomial.value;
        iArr2[0] = iArr2[0] << 1;
        return gF2Polynomial;
    }

    public GF2Polynomial shiftLeft(int i10) {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.len + i10, this.value);
        if (i10 >= 32) {
            gF2Polynomial.doShiftBlocksLeft(i10 >>> 5);
        }
        int i11 = i10 & 31;
        if (i11 != 0) {
            for (int i12 = gF2Polynomial.blocks - 1; i12 >= 1; i12--) {
                int[] iArr = gF2Polynomial.value;
                int i13 = iArr[i12] << i11;
                iArr[i12] = i13;
                iArr[i12] = i13 | (iArr[i12 - 1] >>> (32 - i11));
            }
            int[] iArr2 = gF2Polynomial.value;
            iArr2[0] = iArr2[0] << i11;
        }
        return gF2Polynomial;
    }

    public void shiftLeftAddThis(GF2Polynomial gF2Polynomial, int i10) {
        int i11;
        if (i10 == 0) {
            addToThis(gF2Polynomial);
            return;
        }
        expandN(gF2Polynomial.len + i10);
        int i12 = i10 >>> 5;
        for (int i13 = gF2Polynomial.blocks - 1; i13 >= 0; i13--) {
            int i14 = i13 + i12;
            int i15 = i14 + 1;
            if (i15 < this.blocks && (i11 = i10 & 31) != 0) {
                int[] iArr = this.value;
                iArr[i15] = (gF2Polynomial.value[i13] >>> (32 - i11)) ^ iArr[i15];
            }
            int[] iArr2 = this.value;
            iArr2[i14] = iArr2[i14] ^ (gF2Polynomial.value[i13] << (i10 & 31));
        }
    }

    public void shiftLeftThis() {
        int i10 = this.len;
        int i11 = i10 & 31;
        this.len = i10 + 1;
        int i12 = this.blocks;
        if (i11 == 0) {
            int i13 = i12 + 1;
            this.blocks = i13;
            int[] iArr = this.value;
            if (i13 > iArr.length) {
                int[] iArr2 = new int[i13];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                this.value = iArr2;
            }
            for (int i14 = this.blocks - 1; i14 >= 1; i14--) {
                int[] iArr3 = this.value;
                int i15 = i14 - 1;
                iArr3[i14] = iArr3[i14] | (iArr3[i15] >>> 31);
                iArr3[i15] = iArr3[i15] << 1;
            }
            return;
        }
        for (int i16 = i12 - 1; i16 >= 1; i16--) {
            int[] iArr4 = this.value;
            int i17 = iArr4[i16] << 1;
            iArr4[i16] = i17;
            iArr4[i16] = i17 | (iArr4[i16 - 1] >>> 31);
        }
        int[] iArr5 = this.value;
        iArr5[0] = iArr5[0] << 1;
    }

    public GF2Polynomial shiftRight() {
        int i10;
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.len - 1);
        int i11 = 0;
        System.arraycopy(this.value, 0, gF2Polynomial.value, 0, gF2Polynomial.blocks);
        while (true) {
            i10 = gF2Polynomial.blocks;
            if (i11 > i10 - 2) {
                break;
            }
            int[] iArr = gF2Polynomial.value;
            int i12 = iArr[i11] >>> 1;
            iArr[i11] = i12;
            int i13 = i11 + 1;
            iArr[i11] = i12 | (iArr[i13] << 31);
            i11 = i13;
        }
        int[] iArr2 = gF2Polynomial.value;
        int i14 = i10 - 1;
        iArr2[i14] = iArr2[i14] >>> 1;
        if (i10 < this.blocks) {
            int i15 = i10 - 1;
            iArr2[i15] = (this.value[i10] << 31) | iArr2[i15];
        }
        return gF2Polynomial;
    }

    public void shiftRightThis() {
        int i10;
        int i11 = this.len - 1;
        this.len = i11;
        this.blocks = ((i11 - 1) >>> 5) + 1;
        int i12 = 0;
        while (true) {
            i10 = this.blocks;
            if (i12 > i10 - 2) {
                break;
            }
            int[] iArr = this.value;
            int i13 = iArr[i12] >>> 1;
            iArr[i12] = i13;
            int i14 = i12 + 1;
            iArr[i12] = i13 | (iArr[i14] << 31);
            i12 = i14;
        }
        int[] iArr2 = this.value;
        int i15 = i10 - 1;
        iArr2[i15] = iArr2[i15] >>> 1;
        if ((this.len & 31) == 0) {
            int i16 = i10 - 1;
            iArr2[i16] = (iArr2[i10] << 31) | iArr2[i16];
        }
    }

    public void squareThisBitwise() {
        if (!isZero()) {
            int i10 = this.blocks;
            int i11 = i10 << 1;
            int[] iArr = new int[i11];
            for (int i12 = i10 - 1; i12 >= 0; i12--) {
                int i13 = this.value[i12];
                int i14 = 1;
                for (int i15 = 0; i15 < 16; i15++) {
                    if ((i13 & 1) != 0) {
                        int i16 = i12 << 1;
                        iArr[i16] = iArr[i16] | i14;
                    }
                    if ((65536 & i13) != 0) {
                        int i17 = (i12 << 1) + 1;
                        iArr[i17] = iArr[i17] | i14;
                    }
                    i14 <<= 2;
                    i13 >>>= 1;
                }
            }
            this.value = iArr;
            this.blocks = i11;
            this.len = (this.len << 1) - 1;
        }
    }

    public void squareThisPreCalc() {
        int i10;
        int i11;
        if (!isZero()) {
            int length = this.value.length;
            int i12 = this.blocks;
            if (length >= (i12 << 1)) {
                for (int i13 = i12 - 1; i13 >= 0; i13--) {
                    int[] iArr = this.value;
                    int i14 = i13 << 1;
                    short[] sArr = squaringTable;
                    int i15 = iArr[i13];
                    iArr[i14 + 1] = (sArr[(i15 & -16777216) >>> 24] << 16) | sArr[(i15 & 16711680) >>> 16];
                    int i16 = iArr[i13];
                    iArr[i14] = (sArr[(i16 & 65280) >>> 8] << 16) | sArr[i16 & 255];
                }
                i10 = this.blocks << 1;
            } else {
                int[] iArr2 = new int[(i12 << 1)];
                int i17 = 0;
                while (true) {
                    i11 = this.blocks;
                    if (i17 >= i11) {
                        break;
                    }
                    int i18 = i17 << 1;
                    short[] sArr2 = squaringTable;
                    int[] iArr3 = this.value;
                    int i19 = iArr3[i17];
                    iArr2[i18] = (sArr2[(i19 & 65280) >>> 8] << 16) | sArr2[i19 & 255];
                    int i20 = iArr3[i17];
                    iArr2[i18 + 1] = (sArr2[(i20 & -16777216) >>> 24] << 16) | sArr2[(i20 & 16711680) >>> 16];
                    i17++;
                }
                this.value = iArr2;
                i10 = i11 << 1;
            }
            this.blocks = i10;
            this.len = (this.len << 1) - 1;
        }
    }

    public GF2Polynomial subtract(GF2Polynomial gF2Polynomial) {
        return xor(gF2Polynomial);
    }

    public void subtractFromThis(GF2Polynomial gF2Polynomial) {
        expandN(gF2Polynomial.len);
        xorThisBy(gF2Polynomial);
    }

    public boolean testBit(int i10) {
        if (i10 < 0) {
            throw new RuntimeException();
        } else if (i10 > this.len - 1) {
            return false;
        } else {
            return (bitMask[i10 & 31] & this.value[i10 >>> 5]) != 0;
        }
    }

    public byte[] toByteArray() {
        int i10 = ((this.len - 1) >> 3) + 1;
        int i11 = i10 & 3;
        byte[] bArr = new byte[i10];
        for (int i12 = 0; i12 < (i10 >> 2); i12++) {
            int i13 = (i10 - (i12 << 2)) - 1;
            int i14 = this.value[i12];
            bArr[i13] = (byte) (i14 & 255);
            bArr[i13 - 1] = (byte) ((65280 & i14) >>> 8);
            bArr[i13 - 2] = (byte) ((16711680 & i14) >>> 16);
            bArr[i13 - 3] = (byte) ((i14 & -16777216) >>> 24);
        }
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = ((i11 - i15) - 1) << 3;
            bArr[i15] = (byte) ((this.value[this.blocks - 1] & (255 << i16)) >>> i16);
        }
        return bArr;
    }

    public BigInteger toFlexiBigInt() {
        return (this.len == 0 || isZero()) ? new BigInteger(0, new byte[0]) : new BigInteger(1, toByteArray());
    }

    public int[] toIntegerArray() {
        int i10 = this.blocks;
        int[] iArr = new int[i10];
        System.arraycopy(this.value, 0, iArr, 0, i10);
        return iArr;
    }

    public String toString(int i10) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};
        String[] strArr = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        String str = new String();
        if (i10 == 16) {
            for (int i11 = this.blocks - 1; i11 >= 0; i11--) {
                str = ((((((((str + cArr[(this.value[i11] >>> 28) & 15]) + cArr[(this.value[i11] >>> 24) & 15]) + cArr[(this.value[i11] >>> 20) & 15]) + cArr[(this.value[i11] >>> 16) & 15]) + cArr[(this.value[i11] >>> 12) & 15]) + cArr[(this.value[i11] >>> 8) & 15]) + cArr[(this.value[i11] >>> 4) & 15]) + cArr[this.value[i11] & 15]) + " ";
            }
        } else {
            for (int i12 = this.blocks - 1; i12 >= 0; i12--) {
                str = ((((((((str + strArr[(this.value[i12] >>> 28) & 15]) + strArr[(this.value[i12] >>> 24) & 15]) + strArr[(this.value[i12] >>> 20) & 15]) + strArr[(this.value[i12] >>> 16) & 15]) + strArr[(this.value[i12] >>> 12) & 15]) + strArr[(this.value[i12] >>> 8) & 15]) + strArr[(this.value[i12] >>> 4) & 15]) + strArr[this.value[i12] & 15]) + " ";
            }
        }
        return str;
    }

    public boolean vectorMult(GF2Polynomial gF2Polynomial) throws RuntimeException {
        if (this.len == gF2Polynomial.len) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.blocks; i10++) {
                int i11 = this.value[i10] & gF2Polynomial.value[i10];
                boolean[] zArr = parity;
                z10 = (((z10 ^ zArr[i11 & 255]) ^ zArr[(i11 >>> 8) & 255]) ^ zArr[(i11 >>> 16) & 255]) ^ zArr[(i11 >>> 24) & 255];
            }
            return z10;
        }
        throw new RuntimeException();
    }

    public GF2Polynomial xor(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2;
        int min = Math.min(this.blocks, gF2Polynomial.blocks);
        int i10 = 0;
        if (this.len >= gF2Polynomial.len) {
            gF2Polynomial2 = new GF2Polynomial(this);
            while (i10 < min) {
                int[] iArr = gF2Polynomial2.value;
                iArr[i10] = iArr[i10] ^ gF2Polynomial.value[i10];
                i10++;
            }
        } else {
            gF2Polynomial2 = new GF2Polynomial(gF2Polynomial);
            while (i10 < min) {
                int[] iArr2 = gF2Polynomial2.value;
                iArr2[i10] = iArr2[i10] ^ this.value[i10];
                i10++;
            }
        }
        gF2Polynomial2.zeroUnusedBits();
        return gF2Polynomial2;
    }

    public void xorBit(int i10) throws RuntimeException {
        if (i10 < 0 || i10 > this.len - 1) {
            throw new RuntimeException();
        }
        int[] iArr = this.value;
        int i11 = i10 >>> 5;
        iArr[i11] = bitMask[i10 & 31] ^ iArr[i11];
    }

    public void xorThisBy(GF2Polynomial gF2Polynomial) {
        for (int i10 = 0; i10 < Math.min(this.blocks, gF2Polynomial.blocks); i10++) {
            int[] iArr = this.value;
            iArr[i10] = iArr[i10] ^ gF2Polynomial.value[i10];
        }
        zeroUnusedBits();
    }
}
