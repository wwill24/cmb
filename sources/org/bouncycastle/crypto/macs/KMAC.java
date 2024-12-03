package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.CSHAKEDigest;
import org.bouncycastle.crypto.digests.XofUtils;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class KMAC implements Mac, Xof {
    private static final byte[] padding = new byte[100];
    private final int bitLength;
    private final CSHAKEDigest cshake;
    private boolean firstOutput;
    private boolean initialised;
    private byte[] key;
    private final int outputLength;

    public KMAC(int i10, byte[] bArr) {
        this.cshake = new CSHAKEDigest(i10, Strings.toByteArray("KMAC"), bArr);
        this.bitLength = i10;
        this.outputLength = (i10 * 2) / 8;
    }

    private void bytePad(byte[] bArr, int i10) {
        byte[] leftEncode = XofUtils.leftEncode((long) i10);
        update(leftEncode, 0, leftEncode.length);
        byte[] encode = encode(bArr);
        update(encode, 0, encode.length);
        int length = i10 - ((leftEncode.length + encode.length) % i10);
        if (length > 0 && length != i10) {
            while (true) {
                byte[] bArr2 = padding;
                if (length > bArr2.length) {
                    update(bArr2, 0, bArr2.length);
                    length -= bArr2.length;
                } else {
                    update(bArr2, 0, length);
                    return;
                }
            }
        }
    }

    private static byte[] encode(byte[] bArr) {
        return Arrays.concatenate(XofUtils.leftEncode((long) (bArr.length * 8)), bArr);
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        if (this.firstOutput) {
            if (this.initialised) {
                byte[] rightEncode = XofUtils.rightEncode((long) (getMacSize() * 8));
                this.cshake.update(rightEncode, 0, rightEncode.length);
            } else {
                throw new IllegalStateException("KMAC not initialized");
            }
        }
        int doFinal = this.cshake.doFinal(bArr, i10, getMacSize());
        reset();
        return doFinal;
    }

    public int doFinal(byte[] bArr, int i10, int i11) {
        if (this.firstOutput) {
            if (this.initialised) {
                byte[] rightEncode = XofUtils.rightEncode((long) (i11 * 8));
                this.cshake.update(rightEncode, 0, rightEncode.length);
            } else {
                throw new IllegalStateException("KMAC not initialized");
            }
        }
        int doFinal = this.cshake.doFinal(bArr, i10, i11);
        reset();
        return doFinal;
    }

    public int doOutput(byte[] bArr, int i10, int i11) {
        if (this.firstOutput) {
            if (this.initialised) {
                byte[] rightEncode = XofUtils.rightEncode(0);
                this.cshake.update(rightEncode, 0, rightEncode.length);
                this.firstOutput = false;
            } else {
                throw new IllegalStateException("KMAC not initialized");
            }
        }
        return this.cshake.doOutput(bArr, i10, i11);
    }

    public String getAlgorithmName() {
        return "KMAC" + this.cshake.getAlgorithmName().substring(6);
    }

    public int getByteLength() {
        return this.cshake.getByteLength();
    }

    public int getDigestSize() {
        return this.outputLength;
    }

    public int getMacSize() {
        return this.outputLength;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        this.key = Arrays.clone(((KeyParameter) cipherParameters).getKey());
        this.initialised = true;
        reset();
    }

    public void reset() {
        this.cshake.reset();
        byte[] bArr = this.key;
        if (bArr != null) {
            bytePad(bArr, this.bitLength == 128 ? 168 : 136);
        }
        this.firstOutput = true;
    }

    public void update(byte b10) throws IllegalStateException {
        if (this.initialised) {
            this.cshake.update(b10);
            return;
        }
        throw new IllegalStateException("KMAC not initialized");
    }

    public void update(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalStateException {
        if (this.initialised) {
            this.cshake.update(bArr, i10, i11);
            return;
        }
        throw new IllegalStateException("KMAC not initialized");
    }
}
