package org.bouncycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Mac;

public class MacOutputStream extends OutputStream {
    protected Mac mac;

    public MacOutputStream(Mac mac2) {
        this.mac = mac2;
    }

    public byte[] getMac() {
        byte[] bArr = new byte[this.mac.getMacSize()];
        this.mac.doFinal(bArr, 0);
        return bArr;
    }

    public void write(int i10) throws IOException {
        this.mac.update((byte) i10);
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.mac.update(bArr, i10, i11);
    }
}
