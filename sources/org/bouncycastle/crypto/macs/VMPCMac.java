package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class VMPCMac implements Mac {
    private byte[] P = null;
    private byte[] T;

    /* renamed from: g  reason: collision with root package name */
    private byte f41479g;

    /* renamed from: n  reason: collision with root package name */
    private byte f41480n = 0;

    /* renamed from: s  reason: collision with root package name */
    private byte f41481s = 0;
    private byte[] workingIV;
    private byte[] workingKey;

    /* renamed from: x1  reason: collision with root package name */
    private byte f41482x1;

    /* renamed from: x2  reason: collision with root package name */
    private byte f41483x2;

    /* renamed from: x3  reason: collision with root package name */
    private byte f41484x3;

    /* renamed from: x4  reason: collision with root package name */
    private byte f41485x4;

    private void initKey(byte[] bArr, byte[] bArr2) {
        this.f41481s = 0;
        this.P = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            this.P[i10] = (byte) i10;
        }
        for (int i11 = 0; i11 < 768; i11++) {
            byte[] bArr3 = this.P;
            byte b10 = this.f41481s;
            int i12 = i11 & 255;
            byte b11 = bArr3[i12];
            byte b12 = bArr3[(b10 + b11 + bArr[i11 % bArr.length]) & 255];
            this.f41481s = b12;
            bArr3[i12] = bArr3[b12 & 255];
            bArr3[b12 & 255] = b11;
        }
        for (int i13 = 0; i13 < 768; i13++) {
            byte[] bArr4 = this.P;
            byte b13 = this.f41481s;
            int i14 = i13 & 255;
            byte b14 = bArr4[i14];
            byte b15 = bArr4[(b13 + b14 + bArr2[i13 % bArr2.length]) & 255];
            this.f41481s = b15;
            bArr4[i14] = bArr4[b15 & 255];
            bArr4[b15 & 255] = b14;
        }
        this.f41480n = 0;
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        for (int i11 = 1; i11 < 25; i11++) {
            byte[] bArr2 = this.P;
            byte b10 = this.f41481s;
            byte b11 = this.f41480n;
            byte b12 = bArr2[(b10 + bArr2[b11 & 255]) & 255];
            this.f41481s = b12;
            byte b13 = this.f41485x4;
            byte b14 = this.f41484x3;
            byte b15 = bArr2[(b13 + b14 + i11) & 255];
            this.f41485x4 = b15;
            byte b16 = this.f41483x2;
            byte b17 = bArr2[(b14 + b16 + i11) & 255];
            this.f41484x3 = b17;
            byte b18 = this.f41482x1;
            byte b19 = bArr2[(b16 + b18 + i11) & 255];
            this.f41483x2 = b19;
            byte b20 = bArr2[(b18 + b12 + i11) & 255];
            this.f41482x1 = b20;
            byte[] bArr3 = this.T;
            byte b21 = this.f41479g;
            bArr3[b21 & 31] = (byte) (b20 ^ bArr3[b21 & 31]);
            bArr3[(b21 + 1) & 31] = (byte) (b19 ^ bArr3[(b21 + 1) & 31]);
            bArr3[(b21 + 2) & 31] = (byte) (b17 ^ bArr3[(b21 + 2) & 31]);
            bArr3[(b21 + 3) & 31] = (byte) (b15 ^ bArr3[(b21 + 3) & 31]);
            this.f41479g = (byte) ((b21 + 4) & 31);
            byte b22 = bArr2[b11 & 255];
            bArr2[b11 & 255] = bArr2[b12 & 255];
            bArr2[b12 & 255] = b22;
            this.f41480n = (byte) ((b11 + 1) & 255);
        }
        for (int i12 = 0; i12 < 768; i12++) {
            byte[] bArr4 = this.P;
            byte b23 = this.f41481s;
            int i13 = i12 & 255;
            byte b24 = bArr4[i13];
            byte b25 = bArr4[(b23 + b24 + this.T[i12 & 31]) & 255];
            this.f41481s = b25;
            bArr4[i13] = bArr4[b25 & 255];
            bArr4[b25 & 255] = b24;
        }
        byte[] bArr5 = new byte[20];
        for (int i14 = 0; i14 < 20; i14++) {
            byte[] bArr6 = this.P;
            int i15 = i14 & 255;
            byte b26 = bArr6[(this.f41481s + bArr6[i15]) & 255];
            this.f41481s = b26;
            bArr5[i14] = bArr6[(bArr6[bArr6[b26 & 255] & 255] + 1) & 255];
            byte b27 = bArr6[i15];
            bArr6[i15] = bArr6[b26 & 255];
            bArr6[b26 & 255] = b27;
        }
        System.arraycopy(bArr5, 0, bArr, i10, 20);
        reset();
        return 20;
    }

    public String getAlgorithmName() {
        return "VMPC-MAC";
    }

    public int getMacSize() {
        return 20;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                byte[] iv = parametersWithIV.getIV();
                this.workingIV = iv;
                if (iv == null || iv.length < 1 || iv.length > 768) {
                    throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
                }
                this.workingKey = keyParameter.getKey();
                reset();
                return;
            }
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
    }

    public void reset() {
        initKey(this.workingKey, this.workingIV);
        this.f41480n = 0;
        this.f41485x4 = 0;
        this.f41484x3 = 0;
        this.f41483x2 = 0;
        this.f41482x1 = 0;
        this.f41479g = 0;
        this.T = new byte[32];
        for (int i10 = 0; i10 < 32; i10++) {
            this.T[i10] = 0;
        }
    }

    public void update(byte b10) throws IllegalStateException {
        byte[] bArr = this.P;
        byte b11 = this.f41481s;
        byte b12 = this.f41480n;
        byte b13 = bArr[(b11 + bArr[b12 & 255]) & 255];
        this.f41481s = b13;
        byte b14 = this.f41485x4;
        byte b15 = this.f41484x3;
        byte b16 = bArr[(b14 + b15) & 255];
        this.f41485x4 = b16;
        byte b17 = this.f41483x2;
        byte b18 = bArr[(b15 + b17) & 255];
        this.f41484x3 = b18;
        byte b19 = this.f41482x1;
        byte b20 = bArr[(b17 + b19) & 255];
        this.f41483x2 = b20;
        byte b21 = bArr[(b19 + b13 + ((byte) (b10 ^ bArr[(bArr[bArr[b13 & 255] & 255] + 1) & 255]))) & 255];
        this.f41482x1 = b21;
        byte[] bArr2 = this.T;
        byte b22 = this.f41479g;
        bArr2[b22 & 31] = (byte) (b21 ^ bArr2[b22 & 31]);
        bArr2[(b22 + 1) & 31] = (byte) (b20 ^ bArr2[(b22 + 1) & 31]);
        bArr2[(b22 + 2) & 31] = (byte) (b18 ^ bArr2[(b22 + 2) & 31]);
        bArr2[(b22 + 3) & 31] = (byte) (b16 ^ bArr2[(b22 + 3) & 31]);
        this.f41479g = (byte) ((b22 + 4) & 31);
        byte b23 = bArr[b12 & 255];
        bArr[b12 & 255] = bArr[b13 & 255];
        bArr[b13 & 255] = b23;
        this.f41480n = (byte) ((b12 + 1) & 255);
    }

    public void update(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalStateException {
        if (i10 + i11 <= bArr.length) {
            for (int i12 = 0; i12 < i11; i12++) {
                update(bArr[i10 + i12]);
            }
            return;
        }
        throw new DataLengthException("input buffer too short");
    }
}
