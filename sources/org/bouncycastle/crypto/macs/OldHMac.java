package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;

public class OldHMac implements Mac {
    private static final int BLOCK_LENGTH = 64;
    private static final byte IPAD = 54;
    private static final byte OPAD = 92;
    private Digest digest;
    private int digestSize;
    private byte[] inputPad = new byte[64];
    private byte[] outputPad = new byte[64];

    public OldHMac(Digest digest2) {
        this.digest = digest2;
        this.digestSize = digest2.getDigestSize();
    }

    public int doFinal(byte[] bArr, int i10) {
        int i11 = this.digestSize;
        byte[] bArr2 = new byte[i11];
        this.digest.doFinal(bArr2, 0);
        Digest digest2 = this.digest;
        byte[] bArr3 = this.outputPad;
        digest2.update(bArr3, 0, bArr3.length);
        this.digest.update(bArr2, 0, i11);
        int doFinal = this.digest.doFinal(bArr, i10);
        reset();
        return doFinal;
    }

    public String getAlgorithmName() {
        return this.digest.getAlgorithmName() + "/HMAC";
    }

    public int getMacSize() {
        return this.digestSize;
    }

    public Digest getUnderlyingDigest() {
        return this.digest;
    }

    public void init(CipherParameters cipherParameters) {
        this.digest.reset();
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        if (key.length <= 64) {
            System.arraycopy(key, 0, this.inputPad, 0, key.length);
            int length = key.length;
            while (true) {
                byte[] bArr = this.inputPad;
                if (length >= bArr.length) {
                    break;
                }
                bArr[length] = 0;
                length++;
            }
        } else {
            this.digest.update(key, 0, key.length);
            this.digest.doFinal(this.inputPad, 0);
            int i10 = this.digestSize;
            while (true) {
                byte[] bArr2 = this.inputPad;
                if (i10 >= bArr2.length) {
                    break;
                }
                bArr2[i10] = 0;
                i10++;
            }
        }
        byte[] bArr3 = this.inputPad;
        byte[] bArr4 = new byte[bArr3.length];
        this.outputPad = bArr4;
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        int i11 = 0;
        while (true) {
            byte[] bArr5 = this.inputPad;
            if (i11 >= bArr5.length) {
                break;
            }
            bArr5[i11] = (byte) (bArr5[i11] ^ IPAD);
            i11++;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr6 = this.outputPad;
            if (i12 < bArr6.length) {
                bArr6[i12] = (byte) (bArr6[i12] ^ OPAD);
                i12++;
            } else {
                Digest digest2 = this.digest;
                byte[] bArr7 = this.inputPad;
                digest2.update(bArr7, 0, bArr7.length);
                return;
            }
        }
    }

    public void reset() {
        this.digest.reset();
        Digest digest2 = this.digest;
        byte[] bArr = this.inputPad;
        digest2.update(bArr, 0, bArr.length);
    }

    public void update(byte b10) {
        this.digest.update(b10);
    }

    public void update(byte[] bArr, int i10, int i11) {
        this.digest.update(bArr, i10, i11);
    }
}
