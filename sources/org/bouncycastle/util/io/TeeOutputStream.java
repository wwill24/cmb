package org.bouncycastle.util.io;

import java.io.IOException;
import java.io.OutputStream;

public class TeeOutputStream extends OutputStream {
    private OutputStream output1;
    private OutputStream output2;

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        this.output1 = outputStream;
        this.output2 = outputStream2;
    }

    public void close() throws IOException {
        this.output1.close();
        this.output2.close();
    }

    public void flush() throws IOException {
        this.output1.flush();
        this.output2.flush();
    }

    public void write(int i10) throws IOException {
        this.output1.write(i10);
        this.output2.write(i10);
    }

    public void write(byte[] bArr) throws IOException {
        this.output1.write(bArr);
        this.output2.write(bArr);
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.output1.write(bArr, i10, i11);
        this.output2.write(bArr, i10, i11);
    }
}
