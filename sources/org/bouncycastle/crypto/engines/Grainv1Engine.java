package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class Grainv1Engine implements StreamCipher {
    private static final int STATE_SIZE = 5;
    private int index = 2;
    private boolean initialised = false;
    private int[] lfsr;
    private int[] nfsr;
    private byte[] out;
    private int output;
    private byte[] workingIV;
    private byte[] workingKey;

    private byte getKeyStream() {
        if (this.index > 1) {
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
        int i12 = (i10 >>> 1) | (i11 << 15);
        int i13 = (i10 >>> 2) | (i11 << 14);
        int i14 = (i10 >>> 4) | (i11 << 12);
        int i15 = (i10 >>> 10) | (i11 << 6);
        int i16 = iArr[2];
        int i17 = (i11 >>> 15) | (i16 << 1);
        int i18 = iArr[3];
        int i19 = (i16 >>> 11) | (i18 << 5);
        int i20 = iArr[4];
        int i21 = (i18 >>> 8) | (i20 << 8);
        int i22 = (i20 << 1) | (i18 >>> 15);
        int[] iArr2 = this.lfsr;
        int i23 = iArr2[1];
        int i24 = (iArr2[0] >>> 3) | (i23 << 13);
        int i25 = iArr2[2];
        int i26 = (i23 >>> 9) | (i25 << 7);
        int i27 = (iArr2[3] << 2) | (i25 >>> 14);
        int i28 = iArr2[4];
        int i29 = (i26 ^ i22) ^ (i24 & i28);
        int i30 = i27 & i28;
        int i31 = i24 & i27;
        int i32 = i28 & i31;
        int i33 = i31 & i22;
        return (((((((((i22 & i30) ^ ((i33 ^ (i32 ^ (((i29 ^ i30) ^ (i28 & i22)) ^ ((i24 & i26) & i27)))) ^ ((i26 & i27) & i22))) ^ i12) ^ i13) ^ i14) ^ i15) ^ i17) ^ i19) ^ i21) & 65535;
    }

    private int getOutputLFSR() {
        int[] iArr = this.lfsr;
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = (i11 >>> 7) | (i12 << 9);
        int i14 = iArr[3];
        int i15 = iArr[4];
        return (((i15 << 2) | (i14 >>> 14)) ^ ((((i10 ^ ((i10 >>> 13) | (i11 << 3))) ^ i13) ^ ((i12 >>> 6) | (i14 << 10))) ^ ((i14 >>> 3) | (i15 << 13)))) & 65535;
    }

    private int getOutputNFSR() {
        int[] iArr = this.nfsr;
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = (i10 >>> 9) | (i11 << 7);
        int i13 = (i10 >>> 14) | (i11 << 2);
        int i14 = (i10 >>> 15) | (i11 << 1);
        int i15 = iArr[2];
        int i16 = (i11 >>> 5) | (i15 << 11);
        int i17 = (i11 >>> 12) | (i15 << 4);
        int i18 = iArr[3];
        int i19 = (i15 >>> 1) | (i18 << 15);
        int i20 = (i15 >>> 5) | (i18 << 11);
        int i21 = (i15 >>> 13) | (i18 << 3);
        int i22 = iArr[4];
        int i23 = (i18 >>> 4) | (i22 << 12);
        int i24 = (i18 >>> 12) | (i22 << 4);
        int i25 = (i22 << 1) | (i18 >>> 15);
        int i26 = i25 & i24;
        int i27 = i24 & i23;
        int i28 = ((((i10 ^ (((((((((((i18 >>> 14) | (i22 << 2)) ^ i24) ^ i23) ^ i21) ^ i20) ^ i19) ^ i17) ^ i16) ^ i13) ^ i12)) ^ i26) ^ (i20 & i19)) ^ (i14 & i12)) ^ (i27 & i21);
        int i29 = i19 & i17 & i16;
        return (((((((((i25 & i21) & i17) & i12) ^ (i28 ^ i29)) ^ ((i27 & i20) & i19)) ^ ((i26 & i16) & i14)) ^ (((i26 & i23) & i21) & i20)) ^ ((i29 & i14) & i12)) ^ (((((i23 & i21) & i20) & i19) & i17) & i16)) & 65535;
    }

    private void initGrain() {
        for (int i10 = 0; i10 < 10; i10++) {
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
        this.nfsr = shift(this.nfsr, getOutputNFSR() ^ this.lfsr[0]);
        this.lfsr = shift(this.lfsr, getOutputLFSR());
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        bArr2[8] = -1;
        bArr2[9] = -1;
        this.workingKey = bArr;
        this.workingIV = bArr2;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.nfsr;
            if (i10 < iArr.length) {
                byte[] bArr3 = this.workingKey;
                int i12 = i11 + 1;
                iArr[i10] = ((bArr3[i11] & 255) | (bArr3[i12] << 8)) & 65535;
                int[] iArr2 = this.lfsr;
                byte[] bArr4 = this.workingIV;
                iArr2[i10] = ((bArr4[i11] & 255) | (bArr4[i12] << 8)) & 65535;
                i11 += 2;
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
        iArr[3] = iArr[4];
        iArr[4] = i10;
        return iArr;
    }

    public String getAlgorithmName() {
        return "Grain v1";
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv == null || iv.length != 8) {
                throw new IllegalArgumentException("Grain v1 requires exactly 8 bytes of IV");
            } else if (parametersWithIV.getParameters() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
                this.workingIV = new byte[keyParameter.getKey().length];
                this.workingKey = new byte[keyParameter.getKey().length];
                this.lfsr = new int[5];
                this.nfsr = new int[5];
                this.out = new byte[2];
                System.arraycopy(iv, 0, this.workingIV, 0, iv.length);
                System.arraycopy(keyParameter.getKey(), 0, this.workingKey, 0, keyParameter.getKey().length);
                reset();
            } else {
                throw new IllegalArgumentException("Grain v1 Init parameters must include a key");
            }
        } else {
            throw new IllegalArgumentException("Grain v1 Init parameters must include an IV");
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
        this.index = 2;
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
