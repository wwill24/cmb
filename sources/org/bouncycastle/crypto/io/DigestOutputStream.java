package org.bouncycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Digest;

public class DigestOutputStream extends OutputStream {
    protected Digest digest;

    public DigestOutputStream(Digest digest2) {
        this.digest = digest2;
    }

    public byte[] getDigest() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    public void write(int i10) throws IOException {
        this.digest.update((byte) i10);
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.digest.update(bArr, i10, i11);
    }
}
