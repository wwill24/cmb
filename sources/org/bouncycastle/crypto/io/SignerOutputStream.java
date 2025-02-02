package org.bouncycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Signer;

public class SignerOutputStream extends OutputStream {
    protected Signer signer;

    public SignerOutputStream(Signer signer2) {
        this.signer = signer2;
    }

    public Signer getSigner() {
        return this.signer;
    }

    public void write(int i10) throws IOException {
        this.signer.update((byte) i10);
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.signer.update(bArr, i10, i11);
    }
}
