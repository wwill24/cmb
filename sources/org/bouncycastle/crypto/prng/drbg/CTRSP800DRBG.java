package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public class CTRSP800DRBG implements SP80090DRBG {
    private static final int AES_MAX_BITS_REQUEST = 262144;
    private static final long AES_RESEED_MAX = 140737488355328L;
    private static final byte[] K_BITS = Hex.decodeStrict("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");
    private static final int TDEA_MAX_BITS_REQUEST = 4096;
    private static final long TDEA_RESEED_MAX = 2147483648L;
    private byte[] _Key;
    private byte[] _V;
    private BlockCipher _engine;
    private EntropySource _entropySource;
    private boolean _isTDEA = false;
    private int _keySizeInBits;
    private long _reseedCounter = 0;
    private int _securityStrength;
    private int _seedLength;

    public CTRSP800DRBG(BlockCipher blockCipher, int i10, int i11, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this._entropySource = entropySource;
        this._engine = blockCipher;
        this._keySizeInBits = i10;
        this._securityStrength = i11;
        this._seedLength = (blockCipher.getBlockSize() * 8) + i10;
        this._isTDEA = isTDEA(blockCipher);
        if (i11 > 256) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        } else if (getMaxSecurityStrength(blockCipher, i10) < i11) {
            throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
        } else if (entropySource.entropySize() >= i11) {
            CTR_DRBG_Instantiate_algorithm(getEntropy(), bArr2, bArr);
        } else {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
    }

    private void BCC(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int blockSize = this._engine.getBlockSize();
        byte[] bArr5 = new byte[blockSize];
        int length = bArr4.length / blockSize;
        byte[] bArr6 = new byte[blockSize];
        this._engine.init(true, new KeyParameter(expandKey(bArr2)));
        this._engine.processBlock(bArr3, 0, bArr5, 0);
        for (int i10 = 0; i10 < length; i10++) {
            XOR(bArr6, bArr5, bArr4, i10 * blockSize);
            this._engine.processBlock(bArr6, 0, bArr5, 0);
        }
        System.arraycopy(bArr5, 0, bArr, 0, bArr.length);
    }

    private byte[] Block_Cipher_df(byte[] bArr, int i10) {
        byte[] bArr2 = bArr;
        int blockSize = this._engine.getBlockSize();
        int length = bArr2.length;
        int i11 = i10 / 8;
        int i12 = length + 8;
        byte[] bArr3 = new byte[(((((i12 + 1) + blockSize) - 1) / blockSize) * blockSize)];
        copyIntToByteArray(bArr3, length, 0);
        copyIntToByteArray(bArr3, i11, 4);
        System.arraycopy(bArr2, 0, bArr3, 8, length);
        bArr3[i12] = Byte.MIN_VALUE;
        int i13 = this._keySizeInBits;
        int i14 = (i13 / 8) + blockSize;
        byte[] bArr4 = new byte[i14];
        byte[] bArr5 = new byte[blockSize];
        byte[] bArr6 = new byte[blockSize];
        int i15 = i13 / 8;
        byte[] bArr7 = new byte[i15];
        System.arraycopy(K_BITS, 0, bArr7, 0, i15);
        int i16 = 0;
        while (true) {
            int i17 = i16 * blockSize;
            if (i17 * 8 >= this._keySizeInBits + (blockSize * 8)) {
                break;
            }
            copyIntToByteArray(bArr6, i16, 0);
            BCC(bArr5, bArr7, bArr6, bArr3);
            int i18 = i14 - i17;
            if (i18 > blockSize) {
                i18 = blockSize;
            }
            System.arraycopy(bArr5, 0, bArr4, i17, i18);
            i16++;
        }
        byte[] bArr8 = new byte[blockSize];
        System.arraycopy(bArr4, 0, bArr7, 0, i15);
        System.arraycopy(bArr4, i15, bArr8, 0, blockSize);
        byte[] bArr9 = new byte[i11];
        this._engine.init(true, new KeyParameter(expandKey(bArr7)));
        int i19 = 0;
        while (true) {
            int i20 = i19 * blockSize;
            if (i20 >= i11) {
                return bArr9;
            }
            this._engine.processBlock(bArr8, 0, bArr8, 0);
            int i21 = i11 - i20;
            if (i21 > blockSize) {
                i21 = blockSize;
            }
            System.arraycopy(bArr8, 0, bArr9, i20, i21);
            i19++;
        }
    }

    private void CTR_DRBG_Instantiate_algorithm(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] Block_Cipher_df = Block_Cipher_df(Arrays.concatenate(bArr, bArr2, bArr3), this._seedLength);
        int blockSize = this._engine.getBlockSize();
        byte[] bArr4 = new byte[((this._keySizeInBits + 7) / 8)];
        this._Key = bArr4;
        byte[] bArr5 = new byte[blockSize];
        this._V = bArr5;
        CTR_DRBG_Update(Block_Cipher_df, bArr4, bArr5);
        this._reseedCounter = 1;
    }

    private void CTR_DRBG_Reseed_algorithm(byte[] bArr) {
        CTR_DRBG_Update(Block_Cipher_df(Arrays.concatenate(getEntropy(), bArr), this._seedLength), this._Key, this._V);
        this._reseedCounter = 1;
    }

    private void CTR_DRBG_Update(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int length = bArr.length;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[this._engine.getBlockSize()];
        int blockSize = this._engine.getBlockSize();
        this._engine.init(true, new KeyParameter(expandKey(bArr2)));
        int i10 = 0;
        while (true) {
            int i11 = i10 * blockSize;
            if (i11 < bArr.length) {
                addOneTo(bArr3);
                this._engine.processBlock(bArr3, 0, bArr5, 0);
                int i12 = length - i11;
                if (i12 > blockSize) {
                    i12 = blockSize;
                }
                System.arraycopy(bArr5, 0, bArr4, i11, i12);
                i10++;
            } else {
                XOR(bArr4, bArr, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr2, 0, bArr2.length);
                System.arraycopy(bArr4, bArr2.length, bArr3, 0, bArr3.length);
                return;
            }
        }
    }

    private void XOR(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = (byte) (bArr2[i11] ^ bArr3[i11 + i10]);
        }
    }

    private void addOneTo(byte[] bArr) {
        byte b10 = 1;
        for (int i10 = 1; i10 <= bArr.length; i10++) {
            int i11 = (bArr[bArr.length - i10] & 255) + b10;
            b10 = i11 > 255 ? (byte) 1 : 0;
            bArr[bArr.length - i10] = (byte) i11;
        }
    }

    private void copyIntToByteArray(byte[] bArr, int i10, int i11) {
        bArr[i11 + 0] = (byte) (i10 >> 24);
        bArr[i11 + 1] = (byte) (i10 >> 16);
        bArr[i11 + 2] = (byte) (i10 >> 8);
        bArr[i11 + 3] = (byte) i10;
    }

    private byte[] getEntropy() {
        byte[] entropy = this._entropySource.getEntropy();
        if (entropy.length >= (this._securityStrength + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private int getMaxSecurityStrength(BlockCipher blockCipher, int i10) {
        if (isTDEA(blockCipher) && i10 == 168) {
            return 112;
        }
        if (blockCipher.getAlgorithmName().equals("AES")) {
            return i10;
        }
        return -1;
    }

    private boolean isTDEA(BlockCipher blockCipher) {
        return blockCipher.getAlgorithmName().equals("DESede") || blockCipher.getAlgorithmName().equals("TDEA");
    }

    private void padKey(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int i12 = i10 + 0;
        bArr2[i11 + 0] = (byte) (bArr[i12] & 254);
        int i13 = i10 + 1;
        bArr2[i11 + 1] = (byte) ((bArr[i12] << 7) | ((bArr[i13] & 252) >>> 1));
        int i14 = i10 + 2;
        bArr2[i11 + 2] = (byte) ((bArr[i13] << 6) | ((bArr[i14] & 248) >>> 2));
        int i15 = i10 + 3;
        bArr2[i11 + 3] = (byte) ((bArr[i14] << 5) | ((bArr[i15] & 240) >>> 3));
        int i16 = i10 + 4;
        bArr2[i11 + 4] = (byte) ((bArr[i15] << 4) | ((bArr[i16] & 224) >>> 4));
        int i17 = i10 + 5;
        bArr2[i11 + 5] = (byte) ((bArr[i16] << 3) | ((bArr[i17] & 192) >>> 5));
        int i18 = i10 + 6;
        bArr2[i11 + 6] = (byte) ((bArr[i17] << 2) | ((bArr[i18] & 128) >>> 6));
        int i19 = i11 + 7;
        bArr2[i19] = (byte) (bArr[i18] << 1);
        while (i11 <= i19) {
            byte b10 = bArr2[i11];
            bArr2[i11] = (byte) (((((b10 >> 7) ^ ((((((b10 >> 1) ^ (b10 >> 2)) ^ (b10 >> 3)) ^ (b10 >> 4)) ^ (b10 >> 5)) ^ (b10 >> 6))) ^ 1) & 1) | (b10 & 254));
            i11++;
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] expandKey(byte[] bArr) {
        if (!this._isTDEA) {
            return bArr;
        }
        byte[] bArr2 = new byte[24];
        padKey(bArr, 0, bArr2, 0);
        padKey(bArr, 7, bArr2, 8);
        padKey(bArr, 14, bArr2, 16);
        return bArr2;
    }

    public int generate(byte[] bArr, byte[] bArr2, boolean z10) {
        byte[] bArr3;
        boolean z11 = this._isTDEA;
        long j10 = this._reseedCounter;
        if (z11) {
            if (j10 > TDEA_RESEED_MAX) {
                return -1;
            }
            if (Utils.isTooLarge(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else if (j10 > AES_RESEED_MAX) {
            return -1;
        } else {
            if (Utils.isTooLarge(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z10) {
            CTR_DRBG_Reseed_algorithm(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            bArr3 = Block_Cipher_df(bArr2, this._seedLength);
            CTR_DRBG_Update(bArr3, this._Key, this._V);
        } else {
            bArr3 = new byte[(this._seedLength / 8)];
        }
        int length = this._V.length;
        byte[] bArr4 = new byte[length];
        this._engine.init(true, new KeyParameter(expandKey(this._Key)));
        for (int i10 = 0; i10 <= bArr.length / length; i10++) {
            int i11 = i10 * length;
            int length2 = bArr.length - i11 > length ? length : bArr.length - (this._V.length * i10);
            if (length2 != 0) {
                addOneTo(this._V);
                this._engine.processBlock(this._V, 0, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr, i11, length2);
            }
        }
        CTR_DRBG_Update(bArr3, this._Key, this._V);
        this._reseedCounter++;
        return bArr.length * 8;
    }

    public int getBlockSize() {
        return this._V.length * 8;
    }

    public void reseed(byte[] bArr) {
        CTR_DRBG_Reseed_algorithm(bArr);
    }
}
