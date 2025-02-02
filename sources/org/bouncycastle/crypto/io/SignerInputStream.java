package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.Signer;

public class SignerInputStream extends FilterInputStream {
    protected Signer signer;

    public SignerInputStream(InputStream inputStream, Signer signer2) {
        super(inputStream);
        this.signer = signer2;
    }

    public Signer getSigner() {
        return this.signer;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            this.signer.update((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = this.in.read(bArr, i10, i11);
        if (read > 0) {
            this.signer.update(bArr, i10, read);
        }
        return read;
    }
}
