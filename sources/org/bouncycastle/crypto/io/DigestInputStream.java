package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.Digest;

public class DigestInputStream extends FilterInputStream {
    protected Digest digest;

    public DigestInputStream(InputStream inputStream, Digest digest2) {
        super(inputStream);
        this.digest = digest2;
    }

    public Digest getDigest() {
        return this.digest;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            this.digest.update((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = this.in.read(bArr, i10, i11);
        if (read > 0) {
            this.digest.update(bArr, i10, read);
        }
        return read;
    }
}
