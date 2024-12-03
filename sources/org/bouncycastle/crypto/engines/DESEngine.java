package org.bouncycastle.crypto.engines;

import com.facebook.internal.NativeProtocol;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class DESEngine implements BlockCipher {
    protected static final int BLOCK_SIZE = 8;
    private static final int[] SP1 = {16843776, 0, 65536, 16843780, 16842756, 66564, 4, 65536, 1024, 16843776, 16843780, 1024, 16778244, 16842756, 16777216, 4, 1028, 16778240, 16778240, 66560, 66560, 16842752, 16842752, 16778244, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 16777220, 16777220, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 0, 1028, 66564, 16777216, 65536, 16843780, 4, 16842752, 16843776, 16777216, 16777216, 1024, 16842756, 65536, 66560, 16777220, 1024, 4, 16778244, 66564, 16843780, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 16842752, 16778244, 16777220, 1028, 66564, 16843776, 1028, 16778240, 16778240, 0, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 66560, 0, 16842756};
    private static final int[] SP2 = {-2146402272, -2147450880, 32768, 1081376, 1048576, 32, -2146435040, -2147450848, -2147483616, -2146402272, -2146402304, Integer.MIN_VALUE, -2147450880, 1048576, 32, -2146435040, 1081344, 1048608, -2147450848, 0, Integer.MIN_VALUE, 32768, 1081376, -2146435072, 1048608, -2147483616, 0, 1081344, 32800, -2146402304, -2146435072, 32800, 0, 1081376, -2146435040, 1048576, -2147450848, -2146435072, -2146402304, 32768, -2146435072, -2147450880, 32, -2146402272, 1081376, 32, 32768, Integer.MIN_VALUE, 32800, -2146402304, 1048576, -2147483616, 1048608, -2147450848, -2147483616, 1048608, 1081344, 0, -2147450880, 32800, Integer.MIN_VALUE, -2146435040, -2146402272, 1081344};
    private static final int[] SP3 = {520, 134349312, 0, 134348808, 134218240, 0, 131592, 134218240, 131080, 134217736, 134217736, Opcodes.ACC_DEPRECATED, 134349320, 131080, 134348800, 520, 134217728, 8, 134349312, 512, 131584, 134348800, 134348808, 131592, 134218248, 131584, Opcodes.ACC_DEPRECATED, 134218248, 8, 134349320, 512, 134217728, 134349312, 134217728, 131080, 520, Opcodes.ACC_DEPRECATED, 134349312, 134218240, 0, 512, 131080, 134349320, 134218240, 134217736, 512, 0, 134348808, 134218248, Opcodes.ACC_DEPRECATED, 134217728, 134349320, 8, 131592, 131584, 134217736, 134348800, 134218248, 520, 134348800, 131592, 8, 134348808, 131584};
    private static final int[] SP4 = {8396801, 8321, 8321, 128, 8396928, 8388737, 8388609, 8193, 0, 8396800, 8396800, 8396929, 129, 0, 8388736, 8388609, 1, 8192, 8388608, 8396801, 128, 8388608, 8193, 8320, 8388737, 1, 8320, 8388736, 8192, 8396928, 8396929, 129, 8388736, 8388609, 8396800, 8396929, 129, 0, 0, 8396800, 8320, 8388736, 8388737, 1, 8396801, 8321, 8321, 128, 8396929, 129, 1, 8192, 8388609, 8193, 8396928, 8388737, 8193, 8320, 8388608, 8396801, 128, 8388608, 8192, 8396928};
    private static final int[] SP5 = {256, 34078976, 34078720, 1107296512, Opcodes.ASM8, 256, 1073741824, 34078720, 1074266368, Opcodes.ASM8, 33554688, 1074266368, 1107296512, 1107820544, 524544, 1073741824, 33554432, 1074266112, 1074266112, 0, 1073742080, 1107820800, 1107820800, 33554688, 1107820544, 1073742080, 0, 1107296256, 34078976, 33554432, 1107296256, 524544, Opcodes.ASM8, 1107296512, 256, 33554432, 1073741824, 34078720, 1107296512, 1074266368, 33554688, 1073741824, 1107820544, 34078976, 1074266368, 256, 33554432, 1107820544, 1107820800, 524544, 1107296256, 1107820800, 34078720, 0, 1074266112, 1107296256, 524544, 33554688, 1073742080, Opcodes.ASM8, 0, 1074266112, 34078976, 1073742080};
    private static final int[] SP6 = {536870928, 541065216, Opcodes.ACC_ENUM, 541081616, 541065216, 16, 541081616, 4194304, 536887296, 4210704, 4194304, 536870928, 4194320, 536887296, 536870912, 16400, 0, 4194320, 536887312, Opcodes.ACC_ENUM, 4210688, 536887312, 16, 541065232, 541065232, 0, 4210704, 541081600, 16400, 4210688, 541081600, 536870912, 536887296, 16, 541065232, 4210688, 541081616, 4194304, 16400, 536870928, 4194304, 536887296, 536870912, 16400, 536870928, 541081616, 4210688, 541065216, 4210704, 541081600, 0, 541065232, 16, Opcodes.ACC_ENUM, 541065216, 4210704, Opcodes.ACC_ENUM, 4194320, 536887312, 0, 541081600, 536870912, 4194320, 536887312};
    private static final int[] SP7 = {2097152, 69206018, 67110914, 0, 2048, 67110914, 2099202, 69208064, 69208066, 2097152, 0, 67108866, 2, 67108864, 69206018, 2050, 67110912, 2099202, 2097154, 67110912, 67108866, 69206016, 69208064, 2097154, 69206016, 2048, 2050, 69208066, 2099200, 2, 67108864, 2099200, 67108864, 2099200, 2097152, 67110914, 67110914, 69206018, 69206018, 2, 2097154, 67108864, 67110912, 2097152, 69208064, 2050, 2099202, 69208064, 2050, 67108866, 69208066, 69206016, 2099200, 0, 2, 69208066, 0, 2099202, 69206016, 2048, 67108866, 67110912, 2048, 2097154};
    private static final int[] SP8 = {268439616, Opcodes.ACC_SYNTHETIC, Opcodes.ASM4, 268701760, 268435456, 268439616, 64, 268435456, 262208, 268697600, 268701760, 266240, 268701696, 266304, Opcodes.ACC_SYNTHETIC, 64, 268697600, 268435520, 268439552, 4160, 266240, 262208, 268697664, 268701696, 4160, 0, 0, 268697664, 268435520, 268439552, 266304, Opcodes.ASM4, 266304, Opcodes.ASM4, 268701696, Opcodes.ACC_SYNTHETIC, 64, 268697664, Opcodes.ACC_SYNTHETIC, 266304, 268439552, 64, 268435520, 268697600, 268697664, 268435456, Opcodes.ASM4, 268439616, 0, 268701760, 262208, 268435520, 268697600, 268439552, 268439616, 0, 268701760, 266240, 266240, 4160, 4160, 262208, 268435456, 268701696};
    private static final int[] bigbyte = {8388608, 4194304, 2097152, 1048576, Opcodes.ASM8, Opcodes.ASM4, Opcodes.ACC_DEPRECATED, 65536, 32768, Opcodes.ACC_ENUM, 8192, Opcodes.ACC_SYNTHETIC, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
    private static final short[] bytebit = {128, 64, 32, 16, 8, 4, 2, 1};
    private static final byte[] pc1 = {56, 48, 40, 32, 24, Tnaf.POW_2_WIDTH, 8, 0, 57, Framer.STDOUT_FRAME_PREFIX, 41, Framer.ENTER_FRAME_PREFIX, 25, 17, 9, 1, 58, Framer.STDERR_FRAME_PREFIX, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, Framer.STDIN_FRAME_PREFIX, 37, 29, 21, 13, 5, 60, 52, 44, 36, 28, 20, 12, 4, 27, 19, 11, 3};
    private static final byte[] pc2 = {13, Tnaf.POW_2_WIDTH, 10, 23, 0, 4, 2, 27, 14, 5, 20, 9, 22, 18, 11, 3, 25, 7, 15, 6, 26, 19, 12, 1, 40, 51, 30, 36, 46, 54, 29, 39, Framer.STDERR_FRAME_PREFIX, 44, 32, 47, 43, 48, 38, 55, Framer.ENTER_FRAME_PREFIX, 52, Framer.STDIN_FRAME_PREFIX, 41, Framer.STDOUT_FRAME_PREFIX, 35, 28, 31};
    private static final byte[] totrot = {1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, 25, 27, 28};
    private int[] workingKey = null;

    /* access modifiers changed from: protected */
    public void desFunc(int[] iArr, byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = bArr2;
        int i12 = i11;
        int bigEndianToInt = Pack.bigEndianToInt(bArr, i10);
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr, i10 + 4);
        int i13 = ((bigEndianToInt >>> 4) ^ bigEndianToInt2) & 252645135;
        int i14 = bigEndianToInt2 ^ i13;
        int i15 = bigEndianToInt ^ (i13 << 4);
        int i16 = ((i15 >>> 16) ^ i14) & 65535;
        int i17 = i14 ^ i16;
        int i18 = i15 ^ (i16 << 16);
        int i19 = ((i17 >>> 2) ^ i18) & 858993459;
        int i20 = i18 ^ i19;
        int i21 = i17 ^ (i19 << 2);
        int i22 = ((i21 >>> 8) ^ i20) & 16711935;
        int i23 = i20 ^ i22;
        int i24 = i21 ^ (i22 << 8);
        int i25 = (i24 >>> 31) | (i24 << 1);
        int i26 = (i23 ^ i25) & -1431655766;
        int i27 = i23 ^ i26;
        int i28 = i25 ^ i26;
        int i29 = (i27 >>> 31) | (i27 << 1);
        for (int i30 = 0; i30 < 8; i30++) {
            int i31 = i30 * 4;
            int i32 = ((i28 << 28) | (i28 >>> 4)) ^ iArr[i31 + 0];
            int[] iArr2 = SP7;
            int i33 = iArr2[i32 & 63];
            int[] iArr3 = SP5;
            int i34 = i33 | iArr3[(i32 >>> 8) & 63];
            int[] iArr4 = SP3;
            int i35 = i34 | iArr4[(i32 >>> 16) & 63];
            int[] iArr5 = SP1;
            int i36 = iArr5[(i32 >>> 24) & 63] | i35;
            int i37 = iArr[i31 + 1] ^ i28;
            int[] iArr6 = SP8;
            int i38 = i36 | iArr6[i37 & 63];
            int[] iArr7 = SP6;
            int i39 = i38 | iArr7[(i37 >>> 8) & 63];
            int[] iArr8 = SP4;
            int i40 = i39 | iArr8[(i37 >>> 16) & 63];
            int[] iArr9 = SP2;
            i29 ^= i40 | iArr9[(i37 >>> 24) & 63];
            int i41 = ((i29 << 28) | (i29 >>> 4)) ^ iArr[i31 + 2];
            int i42 = iArr5[(i41 >>> 24) & 63];
            int i43 = iArr[i31 + 3] ^ i29;
            i28 ^= ((((i42 | ((iArr2[i41 & 63] | iArr3[(i41 >>> 8) & 63]) | iArr4[(i41 >>> 16) & 63])) | iArr6[i43 & 63]) | iArr7[(i43 >>> 8) & 63]) | iArr8[(i43 >>> 16) & 63]) | iArr9[(i43 >>> 24) & 63];
        }
        int i44 = (i28 >>> 1) | (i28 << 31);
        int i45 = (i29 ^ i44) & -1431655766;
        int i46 = i29 ^ i45;
        int i47 = i44 ^ i45;
        int i48 = (i46 >>> 1) | (i46 << 31);
        int i49 = ((i48 >>> 8) ^ i47) & 16711935;
        int i50 = i47 ^ i49;
        int i51 = i48 ^ (i49 << 8);
        int i52 = ((i51 >>> 2) ^ i50) & 858993459;
        int i53 = i50 ^ i52;
        int i54 = i51 ^ (i52 << 2);
        int i55 = ((i53 >>> 16) ^ i54) & 65535;
        int i56 = i54 ^ i55;
        int i57 = i53 ^ (i55 << 16);
        int i58 = ((i57 >>> 4) ^ i56) & 252645135;
        Pack.intToBigEndian(i57 ^ (i58 << 4), bArr3, i12);
        Pack.intToBigEndian(i56 ^ i58, bArr3, i12 + 4);
    }

    /* access modifiers changed from: protected */
    public int[] generateWorkingKey(boolean z10, byte[] bArr) {
        int i10;
        int[] iArr = new int[32];
        boolean[] zArr = new boolean[56];
        boolean[] zArr2 = new boolean[56];
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= 56) {
                break;
            }
            byte b10 = pc1[i11];
            if ((bytebit[b10 & 7] & bArr[b10 >>> 3]) == 0) {
                z11 = false;
            }
            zArr[i11] = z11;
            i11++;
        }
        for (int i12 = 0; i12 < 16; i12++) {
            int i13 = z10 ? i12 << 1 : (15 - i12) << 1;
            int i14 = i13 + 1;
            iArr[i14] = 0;
            iArr[i13] = 0;
            int i15 = 0;
            while (true) {
                if (i15 >= 28) {
                    break;
                }
                int i16 = totrot[i12] + i15;
                if (i16 < 28) {
                    zArr2[i15] = zArr[i16];
                } else {
                    zArr2[i15] = zArr[i16 - 28];
                }
                i15++;
            }
            for (i10 = 28; i10 < 56; i10++) {
                int i17 = totrot[i12] + i10;
                if (i17 < 56) {
                    zArr2[i10] = zArr[i17];
                } else {
                    zArr2[i10] = zArr[i17 - 28];
                }
            }
            for (int i18 = 0; i18 < 24; i18++) {
                byte[] bArr2 = pc2;
                if (zArr2[bArr2[i18]]) {
                    iArr[i13] = iArr[i13] | bigbyte[i18];
                }
                if (zArr2[bArr2[i18 + 24]]) {
                    iArr[i14] = iArr[i14] | bigbyte[i18];
                }
            }
        }
        for (int i19 = 0; i19 != 32; i19 += 2) {
            int i20 = iArr[i19];
            int i21 = i19 + 1;
            int i22 = iArr[i21];
            iArr[i19] = ((16515072 & i22) >>> 10) | ((i20 & 16515072) << 6) | ((i20 & 4032) << 10) | ((i22 & 4032) >>> 6);
            iArr[i21] = ((i20 & 63) << 16) | ((i20 & 258048) << 12) | ((258048 & i22) >>> 4) | (i22 & 63);
        }
        return iArr;
    }

    public String getAlgorithmName() {
        return "DES";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            KeyParameter keyParameter = (KeyParameter) cipherParameters;
            if (keyParameter.getKey().length <= 8) {
                this.workingKey = generateWorkingKey(z10, keyParameter.getKey());
                return;
            }
            throw new IllegalArgumentException("DES key too long - should be 8 bytes");
        }
        throw new IllegalArgumentException("invalid parameter passed to DES init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = this.workingKey;
        if (iArr == null) {
            throw new IllegalStateException("DES engine not initialised");
        } else if (i10 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 + 8 <= bArr2.length) {
            desFunc(iArr, bArr, i10, bArr2, i11);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
