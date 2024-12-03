package org.bouncycastle.crypto.engines;

import com.google.firebase.database.core.ValidationPath;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class HC256Engine implements StreamCipher {
    private byte[] buf = new byte[4];
    private int cnt = 0;
    private int idx = 0;
    private boolean initialised;
    private byte[] iv;
    private byte[] key;

    /* renamed from: p  reason: collision with root package name */
    private int[] f41426p = new int[1024];

    /* renamed from: q  reason: collision with root package name */
    private int[] f41427q = new int[1024];

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

    private void init() {
        byte[] bArr = this.key;
        if (bArr.length != 32 && bArr.length != 16) {
            throw new IllegalArgumentException("The key must be 128/256 bits long");
        } else if (this.iv.length >= 16) {
            if (bArr.length != 32) {
                byte[] bArr2 = new byte[32];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                byte[] bArr3 = this.key;
                System.arraycopy(bArr3, 0, bArr2, 16, bArr3.length);
                this.key = bArr2;
            }
            byte[] bArr4 = this.iv;
            if (bArr4.length < 32) {
                byte[] bArr5 = new byte[32];
                System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
                byte[] bArr6 = this.iv;
                System.arraycopy(bArr6, 0, bArr5, bArr6.length, 32 - bArr6.length);
                this.iv = bArr5;
            }
            this.idx = 0;
            this.cnt = 0;
            int[] iArr = new int[2560];
            for (int i10 = 0; i10 < 32; i10++) {
                int i11 = i10 >> 2;
                iArr[i11] = iArr[i11] | ((this.key[i10] & 255) << ((i10 & 3) * 8));
            }
            for (int i12 = 0; i12 < 32; i12++) {
                int i13 = (i12 >> 2) + 8;
                iArr[i13] = iArr[i13] | ((this.iv[i12] & 255) << ((i12 & 3) * 8));
            }
            for (int i14 = 16; i14 < 2560; i14++) {
                int i15 = iArr[i14 - 2];
                int i16 = iArr[i14 - 15];
                iArr[i14] = ((i15 >>> 10) ^ (rotateRight(i15, 17) ^ rotateRight(i15, 19))) + iArr[i14 - 7] + ((i16 >>> 3) ^ (rotateRight(i16, 7) ^ rotateRight(i16, 18))) + iArr[i14 - 16] + i14;
            }
            System.arraycopy(iArr, 512, this.f41426p, 0, 1024);
            System.arraycopy(iArr, 1536, this.f41427q, 0, 1024);
            for (int i17 = 0; i17 < 4096; i17++) {
                step();
            }
            this.cnt = 0;
        } else {
            throw new IllegalArgumentException("The IV must be at least 128 bits long");
        }
    }

    private static int rotateRight(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    private int step() {
        int i10;
        int i11;
        int i12 = this.cnt;
        int i13 = i12 & 1023;
        if (i12 < 1024) {
            int[] iArr = this.f41426p;
            int i14 = iArr[(i13 - 3) & 1023];
            int i15 = iArr[(i13 - 1023) & 1023];
            int i16 = iArr[i13];
            int rotateRight = iArr[(i13 - 10) & 1023] + (rotateRight(i15, 23) ^ rotateRight(i14, 10));
            int[] iArr2 = this.f41427q;
            iArr[i13] = i16 + rotateRight + iArr2[(i14 ^ i15) & 1023];
            int[] iArr3 = this.f41426p;
            int i17 = iArr3[(i13 - 12) & 1023];
            i10 = iArr2[i17 & 255] + iArr2[((i17 >> 8) & 255) + 256] + iArr2[((i17 >> 16) & 255) + 512] + iArr2[((i17 >> 24) & 255) + ValidationPath.MAX_PATH_LENGTH_BYTES];
            i11 = iArr3[i13];
        } else {
            int[] iArr4 = this.f41427q;
            int i18 = iArr4[(i13 - 3) & 1023];
            int i19 = iArr4[(i13 - 1023) & 1023];
            int i20 = iArr4[i13];
            int rotateRight2 = iArr4[(i13 - 10) & 1023] + (rotateRight(i19, 23) ^ rotateRight(i18, 10));
            int[] iArr5 = this.f41426p;
            iArr4[i13] = i20 + rotateRight2 + iArr5[(i18 ^ i19) & 1023];
            int[] iArr6 = this.f41427q;
            int i21 = iArr6[(i13 - 12) & 1023];
            i10 = iArr5[i21 & 255] + iArr5[((i21 >> 8) & 255) + 256] + iArr5[((i21 >> 16) & 255) + 512] + iArr5[((i21 >> 24) & 255) + ValidationPath.MAX_PATH_LENGTH_BYTES];
            i11 = iArr6[i13];
        }
        int i22 = i11 ^ i10;
        this.cnt = (this.cnt + 1) & 2047;
        return i22;
    }

    public String getAlgorithmName() {
        return "HC-256";
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
        throw new IllegalArgumentException("Invalid parameter passed to HC256 init - " + cipherParameters.getClass().getName());
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
