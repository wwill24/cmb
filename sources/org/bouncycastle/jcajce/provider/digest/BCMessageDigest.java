package org.bouncycastle.jcajce.provider.digest;

import java.security.DigestException;
import java.security.MessageDigest;
import org.bouncycastle.crypto.Digest;

public class BCMessageDigest extends MessageDigest {
    protected Digest digest;
    protected int digestSize;

    protected BCMessageDigest(Digest digest2) {
        super(digest2.getAlgorithmName());
        this.digest = digest2;
        this.digestSize = digest2.getDigestSize();
    }

    public int engineDigest(byte[] bArr, int i10, int i11) throws DigestException {
        int i12 = this.digestSize;
        if (i11 < i12) {
            throw new DigestException("partial digests not returned");
        } else if (bArr.length - i10 >= i12) {
            this.digest.doFinal(bArr, i10);
            return this.digestSize;
        } else {
            throw new DigestException("insufficient space in the output buffer to store the digest");
        }
    }

    public byte[] engineDigest() {
        byte[] bArr = new byte[this.digestSize];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    public int engineGetDigestLength() {
        return this.digestSize;
    }

    public void engineReset() {
        this.digest.reset();
    }

    public void engineUpdate(byte b10) {
        this.digest.update(b10);
    }

    public void engineUpdate(byte[] bArr, int i10, int i11) {
        this.digest.update(bArr, i10, i11);
    }
}
