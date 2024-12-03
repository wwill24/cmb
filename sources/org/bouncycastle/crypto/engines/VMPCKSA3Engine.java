package org.bouncycastle.crypto.engines;

public class VMPCKSA3Engine extends VMPCEngine {
    public String getAlgorithmName() {
        return "VMPC-KSA3";
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
        for (int i15 = 0; i15 < 768; i15++) {
            byte[] bArr5 = this.P;
            byte b16 = this.f41439s;
            int i16 = i15 & 255;
            byte b17 = bArr5[i16];
            byte b18 = bArr5[(b16 + b17 + bArr[i15 % bArr.length]) & 255];
            this.f41439s = b18;
            bArr5[i16] = bArr5[b18 & 255];
            bArr5[b18 & 255] = b17;
        }
        this.f41438n = 0;
    }
}
