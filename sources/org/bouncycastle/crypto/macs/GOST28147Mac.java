package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithSBox;

public class GOST28147Mac implements Mac {
    private byte[] S = {9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, 13, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, 13, 1, 14, 4, 6, 2, 11, 3, 13, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, 13, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, 13, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, 13, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, 13, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, 13, 4};
    private int blockSize = 8;
    private byte[] buf = new byte[8];
    private int bufOff = 0;
    private boolean firstStep = true;
    private byte[] mac = new byte[8];
    private byte[] macIV = null;
    private int macSize = 4;
    private int[] workingKey = null;

    private byte[] CM5func(byte[] bArr, int i10, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length - i10)];
        System.arraycopy(bArr, i10, bArr3, 0, bArr2.length);
        for (int i11 = 0; i11 != bArr2.length; i11++) {
            bArr3[i11] = (byte) (bArr3[i11] ^ bArr2[i11]);
        }
        return bArr3;
    }

    private int bytesToint(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] << 24) & -16777216) + ((bArr[i10 + 2] << Tnaf.POW_2_WIDTH) & 16711680) + ((bArr[i10 + 1] << 8) & 65280) + (bArr[i10] & 255);
    }

    private int[] generateWorkingKey(byte[] bArr) {
        if (bArr.length == 32) {
            int[] iArr = new int[8];
            for (int i10 = 0; i10 != 8; i10++) {
                iArr[i10] = bytesToint(bArr, i10 * 4);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    private void gost28147MacFunc(int[] iArr, byte[] bArr, int i10, byte[] bArr2, int i11) {
        int bytesToint = bytesToint(bArr, i10);
        int bytesToint2 = bytesToint(bArr, i10 + 4);
        for (int i12 = 0; i12 < 2; i12++) {
            int i13 = 0;
            while (i13 < 8) {
                i13++;
                int i14 = bytesToint;
                bytesToint = bytesToint2 ^ gost28147_mainStep(bytesToint, iArr[i13]);
                bytesToint2 = i14;
            }
        }
        intTobytes(bytesToint, bArr2, i11);
        intTobytes(bytesToint2, bArr2, i11 + 4);
    }

    private int gost28147_mainStep(int i10, int i11) {
        int i12 = i11 + i10;
        byte[] bArr = this.S;
        int i13 = (bArr[((i12 >> 0) & 15) + 0] << 0) + (bArr[((i12 >> 4) & 15) + 16] << 4) + (bArr[((i12 >> 8) & 15) + 32] << 8) + (bArr[((i12 >> 12) & 15) + 48] << 12) + (bArr[((i12 >> 16) & 15) + 64] << Tnaf.POW_2_WIDTH) + (bArr[((i12 >> 20) & 15) + 80] << 20) + (bArr[((i12 >> 24) & 15) + 96] << 24) + (bArr[((i12 >> 28) & 15) + 112] << 28);
        return (i13 << 11) | (i13 >>> 21);
    }

    private void intTobytes(int i10, byte[] bArr, int i11) {
        bArr[i11 + 3] = (byte) (i10 >>> 24);
        bArr[i11 + 2] = (byte) (i10 >>> 16);
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11] = (byte) i10;
    }

    private void recursiveInit(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters != null) {
            CipherParameters cipherParameters2 = null;
            if (cipherParameters instanceof ParametersWithSBox) {
                ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
                System.arraycopy(parametersWithSBox.getSBox(), 0, this.S, 0, parametersWithSBox.getSBox().length);
                cipherParameters2 = parametersWithSBox.getParameters();
            } else if (cipherParameters instanceof KeyParameter) {
                this.workingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey());
            } else if (cipherParameters instanceof ParametersWithIV) {
                ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
                byte[] iv = parametersWithIV.getIV();
                byte[] bArr = this.mac;
                System.arraycopy(iv, 0, bArr, 0, bArr.length);
                this.macIV = parametersWithIV.getIV();
                cipherParameters2 = parametersWithIV.getParameters();
            } else {
                throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - " + cipherParameters.getClass().getName());
            }
            recursiveInit(cipherParameters2);
        }
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        while (true) {
            int i11 = this.bufOff;
            if (i11 >= this.blockSize) {
                break;
            }
            this.buf[i11] = 0;
            this.bufOff = i11 + 1;
        }
        byte[] bArr2 = this.buf;
        byte[] bArr3 = new byte[bArr2.length];
        System.arraycopy(bArr2, 0, bArr3, 0, this.mac.length);
        if (this.firstStep) {
            this.firstStep = false;
        } else {
            bArr3 = CM5func(this.buf, 0, this.mac);
        }
        gost28147MacFunc(this.workingKey, bArr3, 0, this.mac, 0);
        byte[] bArr4 = this.mac;
        int i12 = this.macSize;
        System.arraycopy(bArr4, (bArr4.length / 2) - i12, bArr, i10, i12);
        reset();
        return this.macSize;
    }

    public String getAlgorithmName() {
        return "GOST28147Mac";
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        reset();
        this.buf = new byte[this.blockSize];
        this.macIV = null;
        recursiveInit(cipherParameters);
    }

    public void reset() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i10 < bArr.length) {
                bArr[i10] = 0;
                i10++;
            } else {
                this.bufOff = 0;
                this.firstStep = true;
                return;
            }
        }
    }

    public void update(byte b10) throws IllegalStateException {
        int i10 = this.bufOff;
        byte[] bArr = this.buf;
        if (i10 == bArr.length) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, this.mac.length);
            if (this.firstStep) {
                this.firstStep = false;
                byte[] bArr3 = this.macIV;
                if (bArr3 != null) {
                    bArr2 = CM5func(this.buf, 0, bArr3);
                }
            } else {
                bArr2 = CM5func(this.buf, 0, this.mac);
            }
            gost28147MacFunc(this.workingKey, bArr2, 0, this.mac, 0);
            this.bufOff = 0;
        }
        byte[] bArr4 = this.buf;
        int i11 = this.bufOff;
        this.bufOff = i11 + 1;
        bArr4[i11] = b10;
    }

    public void update(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalStateException {
        if (i11 >= 0) {
            int i12 = this.blockSize;
            int i13 = this.bufOff;
            int i14 = i12 - i13;
            if (i11 > i14) {
                System.arraycopy(bArr, i10, this.buf, i13, i14);
                byte[] bArr2 = this.buf;
                byte[] bArr3 = new byte[bArr2.length];
                System.arraycopy(bArr2, 0, bArr3, 0, this.mac.length);
                if (this.firstStep) {
                    this.firstStep = false;
                    byte[] bArr4 = this.macIV;
                    if (bArr4 != null) {
                        bArr3 = CM5func(this.buf, 0, bArr4);
                    }
                } else {
                    bArr3 = CM5func(this.buf, 0, this.mac);
                }
                gost28147MacFunc(this.workingKey, bArr3, 0, this.mac, 0);
                this.bufOff = 0;
                while (true) {
                    i11 -= i14;
                    i10 += i14;
                    if (i11 <= this.blockSize) {
                        break;
                    }
                    gost28147MacFunc(this.workingKey, CM5func(bArr, i10, this.mac), 0, this.mac, 0);
                    i14 = this.blockSize;
                }
            }
            System.arraycopy(bArr, i10, this.buf, this.bufOff, i11);
            this.bufOff += i11;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
