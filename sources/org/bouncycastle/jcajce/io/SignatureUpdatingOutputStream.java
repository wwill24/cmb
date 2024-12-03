package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

class SignatureUpdatingOutputStream extends OutputStream {
    private Signature sig;

    SignatureUpdatingOutputStream(Signature signature) {
        this.sig = signature;
    }

    public void write(int i10) throws IOException {
        try {
            this.sig.update((byte) i10);
        } catch (SignatureException e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.sig.update(bArr);
        } catch (SignatureException e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        try {
            this.sig.update(bArr, i10, i11);
        } catch (SignatureException e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
