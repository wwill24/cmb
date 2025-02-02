package org.bouncycastle.util.test;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UncloseableOutputStream extends FilterOutputStream {
    public UncloseableOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void close() {
        throw new RuntimeException("close() called on UncloseableOutputStream");
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.out.write(bArr, i10, i11);
    }
}
