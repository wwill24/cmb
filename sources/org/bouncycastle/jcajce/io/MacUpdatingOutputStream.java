package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;

class MacUpdatingOutputStream extends OutputStream {
    private Mac mac;

    MacUpdatingOutputStream(Mac mac2) {
        this.mac = mac2;
    }

    public void write(int i10) throws IOException {
        this.mac.update((byte) i10);
    }

    public void write(byte[] bArr) throws IOException {
        this.mac.update(bArr);
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.mac.update(bArr, i10, i11);
    }
}
