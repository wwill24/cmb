package org.bouncycastle.jcajce.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

public class CipherInputStream extends FilterInputStream {
    private byte[] buf;
    private int bufOff;
    private final Cipher cipher;
    private boolean finalized = false;
    private final byte[] inputBuffer = new byte[512];
    private int maxBuf;

    public CipherInputStream(InputStream inputStream, Cipher cipher2) {
        super(inputStream);
        this.cipher = cipher2;
    }

    private byte[] finaliseCipher() throws InvalidCipherTextIOException {
        try {
            if (this.finalized) {
                return null;
            }
            this.finalized = true;
            return this.cipher.doFinal();
        } catch (GeneralSecurityException e10) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e10);
        }
    }

    private int nextChunk() throws IOException {
        if (this.finalized) {
            return -1;
        }
        this.bufOff = 0;
        this.maxBuf = 0;
        while (true) {
            int i10 = this.maxBuf;
            if (i10 != 0) {
                return i10;
            }
            int read = this.in.read(this.inputBuffer);
            if (read == -1) {
                byte[] finaliseCipher = finaliseCipher();
                this.buf = finaliseCipher;
                if (finaliseCipher == null || finaliseCipher.length == 0) {
                    return -1;
                }
                int length = finaliseCipher.length;
                this.maxBuf = length;
                return length;
            }
            byte[] update = this.cipher.update(this.inputBuffer, 0, read);
            this.buf = update;
            if (update != null) {
                this.maxBuf = update.length;
            }
        }
    }

    public int available() throws IOException {
        return this.maxBuf - this.bufOff;
    }

    public void close() throws IOException {
        try {
            this.in.close();
            this.bufOff = 0;
            this.maxBuf = 0;
        } finally {
            if (!this.finalized) {
                finaliseCipher();
            }
        }
    }

    public void mark(int i10) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        if (this.bufOff >= this.maxBuf && nextChunk() < 0) {
            return -1;
        }
        byte[] bArr = this.buf;
        int i10 = this.bufOff;
        this.bufOff = i10 + 1;
        return bArr[i10] & 255;
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.bufOff >= this.maxBuf && nextChunk() < 0) {
            return -1;
        }
        int min = Math.min(i11, available());
        System.arraycopy(this.buf, this.bufOff, bArr, i10, min);
        this.bufOff += min;
        return min;
    }

    public void reset() throws IOException {
    }

    public long skip(long j10) throws IOException {
        if (j10 <= 0) {
            return 0;
        }
        int min = (int) Math.min(j10, (long) available());
        this.bufOff += min;
        return (long) min;
    }
}
