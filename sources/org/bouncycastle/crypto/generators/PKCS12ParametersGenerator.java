package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS12ParametersGenerator extends PBEParametersGenerator {
    public static final int IV_MATERIAL = 2;
    public static final int KEY_MATERIAL = 1;
    public static final int MAC_MATERIAL = 3;
    private Digest digest;

    /* renamed from: u  reason: collision with root package name */
    private int f41449u;

    /* renamed from: v  reason: collision with root package name */
    private int f41450v;

    public PKCS12ParametersGenerator(Digest digest2) {
        this.digest = digest2;
        if (digest2 instanceof ExtendedDigest) {
            this.f41449u = digest2.getDigestSize();
            this.f41450v = ((ExtendedDigest) digest2).getByteLength();
            return;
        }
        throw new IllegalArgumentException("Digest " + digest2.getAlgorithmName() + " unsupported");
    }

    private void adjust(byte[] bArr, int i10, byte[] bArr2) {
        int i11 = (bArr2[bArr2.length - 1] & 255) + (bArr[(bArr2.length + i10) - 1] & 255) + 1;
        bArr[(bArr2.length + i10) - 1] = (byte) i11;
        int i12 = i11 >>> 8;
        for (int length = bArr2.length - 2; length >= 0; length--) {
            int i13 = i10 + length;
            int i14 = i12 + (bArr2[length] & 255) + (bArr[i13] & 255);
            bArr[i13] = (byte) i14;
            i12 = i14 >>> 8;
        }
    }

    private byte[] generateDerivedKey(int i10, int i11) {
        byte[] bArr;
        byte[] bArr2;
        int i12;
        int i13 = i11;
        int i14 = this.f41450v;
        byte[] bArr3 = new byte[i14];
        byte[] bArr4 = new byte[i13];
        int i15 = 0;
        for (int i16 = 0; i16 != i14; i16++) {
            bArr3[i16] = (byte) i10;
        }
        byte[] bArr5 = this.salt;
        int i17 = 1;
        if (bArr5 == null || bArr5.length == 0) {
            bArr = new byte[0];
        } else {
            int i18 = this.f41450v;
            int length = i18 * (((bArr5.length + i18) - 1) / i18);
            bArr = new byte[length];
            for (int i19 = 0; i19 != length; i19++) {
                byte[] bArr6 = this.salt;
                bArr[i19] = bArr6[i19 % bArr6.length];
            }
        }
        byte[] bArr7 = this.password;
        if (bArr7 == null || bArr7.length == 0) {
            bArr2 = new byte[0];
        } else {
            int i20 = this.f41450v;
            int length2 = i20 * (((bArr7.length + i20) - 1) / i20);
            bArr2 = new byte[length2];
            for (int i21 = 0; i21 != length2; i21++) {
                byte[] bArr8 = this.password;
                bArr2[i21] = bArr8[i21 % bArr8.length];
            }
        }
        int length3 = bArr.length + bArr2.length;
        byte[] bArr9 = new byte[length3];
        System.arraycopy(bArr, 0, bArr9, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr9, bArr.length, bArr2.length);
        int i22 = this.f41450v;
        byte[] bArr10 = new byte[i22];
        int i23 = this.f41449u;
        int i24 = ((i13 + i23) - 1) / i23;
        byte[] bArr11 = new byte[i23];
        int i25 = 1;
        while (i25 <= i24) {
            this.digest.update(bArr3, i15, i14);
            this.digest.update(bArr9, i15, length3);
            this.digest.doFinal(bArr11, i15);
            for (int i26 = i17; i26 < this.iterationCount; i26++) {
                this.digest.update(bArr11, i15, i23);
                this.digest.doFinal(bArr11, i15);
            }
            for (int i27 = i15; i27 != i22; i27++) {
                bArr10[i27] = bArr11[i27 % i23];
            }
            int i28 = i15;
            while (true) {
                int i29 = this.f41450v;
                if (i28 == length3 / i29) {
                    break;
                }
                adjust(bArr9, i29 * i28, bArr10);
                i28++;
            }
            if (i25 == i24) {
                int i30 = i25 - 1;
                int i31 = this.f41449u;
                i12 = 0;
                System.arraycopy(bArr11, 0, bArr4, i30 * i31, i13 - (i30 * i31));
            } else {
                i12 = 0;
                System.arraycopy(bArr11, 0, bArr4, (i25 - 1) * this.f41449u, i23);
            }
            i25++;
            i15 = i12;
            i17 = 1;
        }
        return bArr4;
    }

    public CipherParameters generateDerivedMacParameters(int i10) {
        int i11 = i10 / 8;
        return new KeyParameter(generateDerivedKey(3, i11), 0, i11);
    }

    public CipherParameters generateDerivedParameters(int i10) {
        int i11 = i10 / 8;
        return new KeyParameter(generateDerivedKey(1, i11), 0, i11);
    }

    public CipherParameters generateDerivedParameters(int i10, int i11) {
        int i12 = i10 / 8;
        int i13 = i11 / 8;
        byte[] generateDerivedKey = generateDerivedKey(1, i12);
        return new ParametersWithIV(new KeyParameter(generateDerivedKey, 0, i12), generateDerivedKey(2, i13), 0, i13);
    }
}
