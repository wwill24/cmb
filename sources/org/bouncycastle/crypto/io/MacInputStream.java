package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.Mac;

public class MacInputStream extends FilterInputStream {
    protected Mac mac;

    public MacInputStream(InputStream inputStream, Mac mac2) {
        super(inputStream);
        this.mac = mac2;
    }

    public Mac getMac() {
        return this.mac;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            this.mac.update((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = this.in.read(bArr, i10, i11);
        if (read >= 0) {
            this.mac.update(bArr, i10, read);
        }
        return read;
    }
}
