package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

class DigestUpdatingOutputStream extends OutputStream {
    private MessageDigest digest;

    DigestUpdatingOutputStream(MessageDigest messageDigest) {
        this.digest = messageDigest;
    }

    public void write(int i10) throws IOException {
        this.digest.update((byte) i10);
    }

    public void write(byte[] bArr) throws IOException {
        this.digest.update(bArr);
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.digest.update(bArr, i10, i11);
    }
}
