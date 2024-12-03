package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class Grain128Engine implements StreamCipher {
    private static final int STATE_SIZE = 4;
    private int index = 4;
    private boolean initialised = false;
    private int[] lfsr;
    private int[] nfsr;
    private byte[] out;
    private int output;
    private byte[] workingIV;
    private byte[] workingKey;

    private byte getKeyStream() {
        if (this.index > 3) {
            oneRound();
            this.index = 0;
        }
        byte[] bArr = this.out;
        int i10 = this.index;
        this.index = i10 + 1;
        return bArr[i10];
    }

    private int getOutput() {
        int[] iArr = this.nfsr;
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = (i10 >>> 2) | (i11 << 30);
        int i13 = (i10 >>> 12) | (i11 << 20);
        int i14 = (i10 >>> 15) | (i11 << 17);
        int i15 = iArr[2];
        int i16 = (i11 >>> 4) | (i15 << 28);
        int i17 = (i11 >>> 13) | (i15 << 19);
        int i18 = iArr[3];
        int i19 = (i15 >>> 9) | (i18 << 23);
        int i20 = (i15 >>> 25) | (i18 << 7);
        int i21 = (i18 << 1) | (i15 >>> 31);
        int[] iArr2 = this.lfsr;
        int i22 = iArr2[0];
        int i23 = iArr2[1];
        int i24 = (i22 >>> 8) | (i23 << 24);
        int i25 = (i22 >>> 13) | (i23 << 19);
        int i26 = (i22 >>> 20) | (i23 << 12);
        int i27 = iArr2[2];
        int i28 = iArr2[3];
        int i29 = i25 & i26;
        int i30 = i21 & i13 & ((i28 << 1) | (i27 >>> 31));
        return ((((((((i30 ^ (((i29 ^ (i13 & i24)) ^ (i21 & ((i23 >>> 10) | (i27 << 22)))) ^ (((i23 >>> 28) | (i27 << 4)) & ((i27 >>> 15) | (i28 << 17))))) ^ ((i27 >>> 29) | (i28 << 3))) ^ i12) ^ i14) ^ i16) ^ i17) ^ i15) ^ i19) ^ i20;
    }

    private int getOutputLFSR() {
        int[] iArr = this.lfsr;
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = (i10 >>> 7) | (i11 << 25);
        int i13 = iArr[2];
        int i14 = iArr[3];
        int i15 = (i13 >>> 6) | (i14 << 26);
        return i14 ^ ((((i10 ^ i12) ^ ((i11 >>> 6) | (i13 << 26))) ^ i15) ^ ((i13 >>> 17) | (i14 << 15)));
    }

    private int getOutputNFSR() {
        int[] iArr = this.nfsr;
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = (i10 >>> 3) | (i11 << 29);
        int i13 = (i10 >>> 11) | (i11 << 21);
        int i14 = (i10 >>> 13) | (i11 << 19);
        int i15 = (i10 >>> 17) | (i11 << 15);
        int i16 = (i10 >>> 18) | (i11 << 14);
        int i17 = (i10 >>> 26) | (i11 << 6);
        int i18 = (i10 >>> 27) | (i11 << 5);
        int i19 = iArr[2];
        int i20 = (i11 >>> 8) | (i19 << 24);
        int i21 = (i11 >>> 16) | (i19 << 16);
        int i22 = (i11 >>> 24) | (i19 << 8);
        int i23 = (i11 >>> 27) | (i19 << 5);
        int i24 = (i11 >>> 29) | (i19 << 3);
        int i25 = iArr[3];
        return (((((((i25 ^ (((i10 ^ i17) ^ i22) ^ ((i19 >>> 27) | (i25 << 5)))) ^ (i12 & ((i19 >>> 3) | (i25 << 29)))) ^ (i13 & i14)) ^ (i15 & i16)) ^ (i18 & i23)) ^ (i20 & i21)) ^ (i24 & ((i19 >>> 1) | (i25 << 31)))) ^ (((i19 >>> 4) | (i25 << 28)) & ((i19 >>> 20) | (i25 << 12)));
    }

    private void initGrain() {
        for (int i10 = 0; i10 < 8; i10++) {
            this.output = getOutput();
            this.nfsr = shift(this.nfsr, (getOutputNFSR() ^ this.lfsr[0]) ^ this.output);
            this.lfsr = shift(this.lfsr, getOutputLFSR() ^ this.output);
        }
        this.initialised = true;
    }

    private void oneRound() {
        int output2 = getOutput();
        this.output = output2;
        byte[] bArr = this.out;
        bArr[0] = (byte) output2;
        bArr[1] = (byte) (output2 >> 8);
        bArr[2] = (byte) (output2 >> 16);
        bArr[3] = (byte) (output2 >> 24);
        this.nfsr = shift(this.nfsr, getOutputNFSR() ^ this.lfsr[0]);
        this.lfsr = shift(this.lfsr, getOutputLFSR());
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        bArr2[12] = -1;
        bArr2[13] = -1;
        bArr2[14] = -1;
        bArr2[15] = -1;
        this.workingKey = bArr;
        this.workingIV = bArr2;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.nfsr;
            if (i10 < iArr.length) {
                byte[] bArr3 = this.workingKey;
                int i12 = i11 + 3;
                int i13 = i11 + 2;
                int i14 = i11 + 1;
                iArr[i10] = (bArr3[i11] & 255) | (bArr3[i12] << 24) | ((bArr3[i13] << Tnaf.POW_2_WIDTH) & 16711680) | ((bArr3[i14] << 8) & 65280);
                int[] iArr2 = this.lfsr;
                byte[] bArr4 = this.workingIV;
                iArr2[i10] = (bArr4[i11] & 255) | (bArr4[i12] << 24) | ((bArr4[i13] << Tnaf.POW_2_WIDTH) & 16711680) | ((bArr4[i14] << 8) & 65280);
                i11 += 4;
                i10++;
            } else {
                return;
            }
        }
    }

    private int[] shift(int[] iArr, int i10) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = i10;
        return iArr;
    }

    public String getAlgorithmName() {
        return "Grain-128";
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv == null || iv.length != 12) {
                throw new IllegalArgumentException("Grain-128  requires exactly 12 bytes of IV");
            } else if (parametersWithIV.getParameters() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
                this.workingIV = new byte[keyParameter.getKey().length];
                this.workingKey = new byte[keyParameter.getKey().length];
                this.lfsr = new int[4];
                this.nfsr = new int[4];
                this.out = new byte[4];
                System.arraycopy(iv, 0, this.workingIV, 0, iv.length);
                System.arraycopy(keyParameter.getKey(), 0, this.workingKey, 0, keyParameter.getKey().length);
                reset();
            } else {
                throw new IllegalArgumentException("Grain-128 Init parameters must include a key");
            }
        } else {
            throw new IllegalArgumentException("Grain-128 Init parameters must include an IV");
        }
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i11 <= bArr2.length) {
            for (int i13 = 0; i13 < i11; i13++) {
                bArr2[i12 + i13] = (byte) (bArr[i10 + i13] ^ getKeyStream());
            }
            return i11;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        this.index = 4;
        setKey(this.workingKey, this.workingIV);
        initGrain();
    }

    public byte returnByte(byte b10) {
        if (this.initialised) {
            return (byte) (b10 ^ getKeyStream());
        }
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }
}
