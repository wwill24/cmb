package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class VMPCEngine implements StreamCipher {
    protected byte[] P = null;

    /* renamed from: n  reason: collision with root package name */
    protected byte f41438n = 0;

    /* renamed from: s  reason: collision with root package name */
    protected byte f41439s = 0;
    protected byte[] workingIV;
    protected byte[] workingKey;

    public String getAlgorithmName() {
        return "VMPC";
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
                byte[] iv = parametersWithIV.getIV();
                this.workingIV = iv;
                if (iv == null || iv.length < 1 || iv.length > 768) {
                    throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
                }
                byte[] key = keyParameter.getKey();
                this.workingKey = key;
                initKey(key, this.workingIV);
                return;
            }
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC init parameters must include an IV");
    }

    /* access modifiers changed from: protected */
    public void initKey(byte[] bArr, byte[] bArr2) {
        this.f41439s = 0;
        this.P = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            this.P[i10] = (byte) i10;
        }
        for (int i11 = 0; i11 < 768; i11++) {
            byte[] bArr3 = this.P;
            byte b10 = this.f41439s;
            int i12 = i11 & 255;
            byte b11 = bArr3[i12];
            byte b12 = bArr3[(b10 + b11 + bArr[i11 % bArr.length]) & 255];
            this.f41439s = b12;
            bArr3[i12] = bArr3[b12 & 255];
            bArr3[b12 & 255] = b11;
        }
        for (int i13 = 0; i13 < 768; i13++) {
            byte[] bArr4 = this.P;
            byte b13 = this.f41439s;
            int i14 = i13 & 255;
            byte b14 = bArr4[i14];
            byte b15 = bArr4[(b13 + b14 + bArr2[i13 % bArr2.length]) & 255];
            this.f41439s = b15;
            bArr4[i14] = bArr4[b15 & 255];
            bArr4[b15 & 255] = b14;
        }
        this.f41438n = 0;
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i11 <= bArr2.length) {
            for (int i13 = 0; i13 < i11; i13++) {
                byte[] bArr3 = this.P;
                byte b10 = this.f41439s;
                byte b11 = this.f41438n;
                byte b12 = bArr3[(b10 + bArr3[b11 & 255]) & 255];
                this.f41439s = b12;
                byte b13 = bArr3[(bArr3[bArr3[b12 & 255] & 255] + 1) & 255];
                byte b14 = bArr3[b11 & 255];
                bArr3[b11 & 255] = bArr3[b12 & 255];
                bArr3[b12 & 255] = b14;
                this.f41438n = (byte) ((b11 + 1) & 255);
                bArr2[i13 + i12] = (byte) (bArr[i13 + i10] ^ b13);
            }
            return i11;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        initKey(this.workingKey, this.workingIV);
    }

    public byte returnByte(byte b10) {
        byte[] bArr = this.P;
        byte b11 = this.f41439s;
        byte b12 = this.f41438n;
        byte b13 = bArr[(b11 + bArr[b12 & 255]) & 255];
        this.f41439s = b13;
        byte b14 = bArr[(bArr[bArr[b13 & 255] & 255] + 1) & 255];
        byte b15 = bArr[b12 & 255];
        bArr[b12 & 255] = bArr[b13 & 255];
        bArr[b13 & 255] = b15;
        this.f41438n = (byte) ((b12 + 1) & 255);
        return (byte) (b10 ^ b14);
    }
}
