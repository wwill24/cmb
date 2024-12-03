package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Strings;

class SSHBuilder {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    SSHBuilder() {
    }

    public byte[] getBytes() {
        return this.bos.toByteArray();
    }

    public byte[] getPaddedBytes() {
        return getPaddedBytes(8);
    }

    public byte[] getPaddedBytes(int i10) {
        int size = this.bos.size() % i10;
        if (size != 0) {
            int i11 = i10 - size;
            for (int i12 = 1; i12 <= i11; i12++) {
                this.bos.write(i12);
            }
        }
        return this.bos.toByteArray();
    }

    public void u32(int i10) {
        this.bos.write((i10 >>> 24) & 255);
        this.bos.write((i10 >>> 16) & 255);
        this.bos.write((i10 >>> 8) & 255);
        this.bos.write(i10 & 255);
    }

    public void writeBigNum(BigInteger bigInteger) {
        writeBlock(bigInteger.toByteArray());
    }

    public void writeBlock(byte[] bArr) {
        u32(bArr.length);
        try {
            this.bos.write(bArr);
        } catch (IOException e10) {
            throw new IllegalStateException(e10.getMessage(), e10);
        }
    }

    public void writeBytes(byte[] bArr) {
        try {
            this.bos.write(bArr);
        } catch (IOException e10) {
            throw new IllegalStateException(e10.getMessage(), e10);
        }
    }

    public void writeString(String str) {
        writeBlock(Strings.toByteArray(str));
    }
}
