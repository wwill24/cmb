package org.bouncycastle.crypto.engines;

import com.google.firebase.database.core.ValidationPath;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class HC128Engine implements StreamCipher {
    private byte[] buf = new byte[4];
    private int cnt = 0;
    private int idx = 0;
    private boolean initialised;
    private byte[] iv;
    private byte[] key;

    /* renamed from: p  reason: collision with root package name */
    private int[] f41424p = new int[512];

    /* renamed from: q  reason: collision with root package name */
    private int[] f41425q = new int[512];

    private static int dim(int i10, int i11) {
        return mod512(i10 - i11);
    }

    private static int f1(int i10) {
        return (i10 >>> 3) ^ (rotateRight(i10, 7) ^ rotateRight(i10, 18));
    }

    private static int f2(int i10) {
        return (i10 >>> 10) ^ (rotateRight(i10, 17) ^ rotateRight(i10, 19));
    }

    private int g1(int i10, int i11, int i12) {
        return (rotateRight(i10, 10) ^ rotateRight(i12, 23)) + rotateRight(i11, 8);
    }

    private int g2(int i10, int i11, int i12) {
        return (rotateLeft(i10, 10) ^ rotateLeft(i12, 23)) + rotateLeft(i11, 8);
    }

    private byte getByte() {
        if (this.idx == 0) {
            int step = step();
            byte[] bArr = this.buf;
            bArr[0] = (byte) (step & 255);
            int i10 = step >> 8;
            bArr[1] = (byte) (i10 & 255);
            int i11 = i10 >> 8;
            bArr[2] = (byte) (i11 & 255);
            bArr[3] = (byte) ((i11 >> 8) & 255);
        }
        byte[] bArr2 = this.buf;
        int i12 = this.idx;
        byte b10 = bArr2[i12];
        this.idx = 3 & (i12 + 1);
        return b10;
    }

    private int h1(int i10) {
        int[] iArr = this.f41425q;
        return iArr[i10 & 255] + iArr[((i10 >> 16) & 255) + 256];
    }

    private int h2(int i10) {
        int[] iArr = this.f41424p;
        return iArr[i10 & 255] + iArr[((i10 >> 16) & 255) + 256];
    }

    private void init() {
        if (this.key.length == 16) {
            this.idx = 0;
            this.cnt = 0;
            int[] iArr = new int[1280];
            for (int i10 = 0; i10 < 16; i10++) {
                int i11 = i10 >> 2;
                iArr[i11] = ((this.key[i10] & 255) << ((i10 & 3) * 8)) | iArr[i11];
            }
            System.arraycopy(iArr, 0, iArr, 4, 4);
            int i12 = 0;
            while (true) {
                byte[] bArr = this.iv;
                if (i12 >= bArr.length || i12 >= 16) {
                    System.arraycopy(iArr, 8, iArr, 12, 4);
                } else {
                    int i13 = (i12 >> 2) + 8;
                    iArr[i13] = ((bArr[i12] & 255) << ((i12 & 3) * 8)) | iArr[i13];
                    i12++;
                }
            }
            System.arraycopy(iArr, 8, iArr, 12, 4);
            for (int i14 = 16; i14 < 1280; i14++) {
                iArr[i14] = f2(iArr[i14 - 2]) + iArr[i14 - 7] + f1(iArr[i14 - 15]) + iArr[i14 - 16] + i14;
            }
            System.arraycopy(iArr, 256, this.f41424p, 0, 512);
            System.arraycopy(iArr, ValidationPath.MAX_PATH_LENGTH_BYTES, this.f41425q, 0, 512);
            for (int i15 = 0; i15 < 512; i15++) {
                this.f41424p[i15] = step();
            }
            for (int i16 = 0; i16 < 512; i16++) {
                this.f41425q[i16] = step();
            }
            this.cnt = 0;
            return;
        }
        throw new IllegalArgumentException("The key must be 128 bits long");
    }

    private static int mod1024(int i10) {
        return i10 & 1023;
    }

    private static int mod512(int i10) {
        return i10 & 511;
    }

    private static int rotateLeft(int i10, int i11) {
        return (i10 >>> (-i11)) | (i10 << i11);
    }

    private static int rotateRight(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    private int step() {
        int i10;
        int i11;
        int mod512 = mod512(this.cnt);
        if (this.cnt < 512) {
            int[] iArr = this.f41424p;
            iArr[mod512] = iArr[mod512] + g1(iArr[dim(mod512, 3)], this.f41424p[dim(mod512, 10)], this.f41424p[dim(mod512, 511)]);
            i10 = h1(this.f41424p[dim(mod512, 12)]);
            i11 = this.f41424p[mod512];
        } else {
            int[] iArr2 = this.f41425q;
            iArr2[mod512] = iArr2[mod512] + g2(iArr2[dim(mod512, 3)], this.f41425q[dim(mod512, 10)], this.f41425q[dim(mod512, 511)]);
            i10 = h2(this.f41425q[dim(mod512, 12)]);
            i11 = this.f41425q[mod512];
        }
        int i12 = i11 ^ i10;
        this.cnt = mod1024(this.cnt + 1);
        return i12;
    }

    public String getAlgorithmName() {
        return "HC-128";
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.iv = parametersWithIV.getIV();
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            this.iv = new byte[0];
            cipherParameters2 = cipherParameters;
        }
        if (cipherParameters2 instanceof KeyParameter) {
            this.key = ((KeyParameter) cipherParameters2).getKey();
            init();
            this.initialised = true;
            return;
        }
        throw new IllegalArgumentException("Invalid parameter passed to HC128 init - " + cipherParameters.getClass().getName());
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i11 <= bArr2.length) {
            for (int i13 = 0; i13 < i11; i13++) {
                bArr2[i12 + i13] = (byte) (bArr[i10 + i13] ^ getByte());
            }
            return i11;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        init();
    }

    public byte returnByte(byte b10) {
        return (byte) (b10 ^ getByte());
    }
}
