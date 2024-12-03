package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SkippingCipher;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.util.Arrays;

public class CipherInputStream extends FilterInputStream {
    private static final int INPUT_BUF_SIZE = 2048;
    private AEADBlockCipher aeadBlockCipher;
    private byte[] buf;
    private int bufOff;
    private BufferedBlockCipher bufferedBlockCipher;
    private boolean finalized;
    private byte[] inBuf;
    private byte[] markBuf;
    private int markBufOff;
    private long markPosition;
    private int maxBuf;
    private SkippingCipher skippingCipher;
    private StreamCipher streamCipher;

    public CipherInputStream(InputStream inputStream, BufferedBlockCipher bufferedBlockCipher2) {
        this(inputStream, bufferedBlockCipher2, 2048);
    }

    public CipherInputStream(InputStream inputStream, BufferedBlockCipher bufferedBlockCipher2, int i10) {
        super(inputStream);
        this.bufferedBlockCipher = bufferedBlockCipher2;
        this.inBuf = new byte[i10];
        this.skippingCipher = bufferedBlockCipher2 instanceof SkippingCipher ? (SkippingCipher) bufferedBlockCipher2 : null;
    }

    public CipherInputStream(InputStream inputStream, StreamCipher streamCipher2) {
        this(inputStream, streamCipher2, 2048);
    }

    public CipherInputStream(InputStream inputStream, StreamCipher streamCipher2, int i10) {
        super(inputStream);
        this.streamCipher = streamCipher2;
        this.inBuf = new byte[i10];
        this.skippingCipher = streamCipher2 instanceof SkippingCipher ? (SkippingCipher) streamCipher2 : null;
    }

    public CipherInputStream(InputStream inputStream, AEADBlockCipher aEADBlockCipher) {
        this(inputStream, aEADBlockCipher, 2048);
    }

    public CipherInputStream(InputStream inputStream, AEADBlockCipher aEADBlockCipher, int i10) {
        super(inputStream);
        this.aeadBlockCipher = aEADBlockCipher;
        this.inBuf = new byte[i10];
        this.skippingCipher = aEADBlockCipher instanceof SkippingCipher ? (SkippingCipher) aEADBlockCipher : null;
    }

    private void ensureCapacity(int i10, boolean z10) {
        if (z10) {
            BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
            if (bufferedBlockCipher2 != null) {
                i10 = bufferedBlockCipher2.getOutputSize(i10);
            } else {
                AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                if (aEADBlockCipher != null) {
                    i10 = aEADBlockCipher.getOutputSize(i10);
                }
            }
        } else {
            BufferedBlockCipher bufferedBlockCipher3 = this.bufferedBlockCipher;
            if (bufferedBlockCipher3 != null) {
                i10 = bufferedBlockCipher3.getUpdateOutputSize(i10);
            } else {
                AEADBlockCipher aEADBlockCipher2 = this.aeadBlockCipher;
                if (aEADBlockCipher2 != null) {
                    i10 = aEADBlockCipher2.getUpdateOutputSize(i10);
                }
            }
        }
        byte[] bArr = this.buf;
        if (bArr == null || bArr.length < i10) {
            this.buf = new byte[i10];
        }
    }

    private void finaliseCipher() throws IOException {
        int doFinal;
        try {
            this.finalized = true;
            ensureCapacity(0, true);
            BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
            if (bufferedBlockCipher2 != null) {
                doFinal = bufferedBlockCipher2.doFinal(this.buf, 0);
            } else {
                AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                if (aEADBlockCipher != null) {
                    doFinal = aEADBlockCipher.doFinal(this.buf, 0);
                } else {
                    this.maxBuf = 0;
                    return;
                }
            }
            this.maxBuf = doFinal;
        } catch (InvalidCipherTextException e10) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e10);
        } catch (Exception e11) {
            throw new IOException("Error finalising cipher " + e11);
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
            int read = this.in.read(this.inBuf);
            if (read == -1) {
                finaliseCipher();
                int i11 = this.maxBuf;
                if (i11 == 0) {
                    return -1;
                }
                return i11;
            }
            try {
                ensureCapacity(read, false);
                BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
                if (bufferedBlockCipher2 != null) {
                    read = bufferedBlockCipher2.processBytes(this.inBuf, 0, read, this.buf, 0);
                } else {
                    AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                    if (aEADBlockCipher != null) {
                        read = aEADBlockCipher.processBytes(this.inBuf, 0, read, this.buf, 0);
                    } else {
                        this.streamCipher.processBytes(this.inBuf, 0, read, this.buf, 0);
                    }
                }
                this.maxBuf = read;
            } catch (Exception e10) {
                throw new CipherIOException("Error processing stream ", e10);
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
            this.markBufOff = 0;
            this.markPosition = 0;
            byte[] bArr = this.markBuf;
            if (bArr != null) {
                Arrays.fill(bArr, (byte) 0);
                this.markBuf = null;
            }
            byte[] bArr2 = this.buf;
            if (bArr2 != null) {
                Arrays.fill(bArr2, (byte) 0);
                this.buf = null;
            }
            Arrays.fill(this.inBuf, (byte) 0);
        } finally {
            if (!this.finalized) {
                finaliseCipher();
            }
        }
    }

    public void mark(int i10) {
        this.in.mark(i10);
        SkippingCipher skippingCipher2 = this.skippingCipher;
        if (skippingCipher2 != null) {
            this.markPosition = skippingCipher2.getPosition();
        }
        byte[] bArr = this.buf;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.markBuf = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        this.markBufOff = this.bufOff;
    }

    public boolean markSupported() {
        if (this.skippingCipher != null) {
            return this.in.markSupported();
        }
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

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
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
        if (this.skippingCipher != null) {
            this.in.reset();
            this.skippingCipher.seekTo(this.markPosition);
            byte[] bArr = this.markBuf;
            if (bArr != null) {
                this.buf = bArr;
            }
            this.bufOff = this.markBufOff;
            return;
        }
        throw new IOException("cipher must implement SkippingCipher to be used with reset()");
    }

    public long skip(long j10) throws IOException {
        if (j10 <= 0) {
            return 0;
        }
        if (this.skippingCipher != null) {
            long available = (long) available();
            if (j10 <= available) {
                this.bufOff = (int) (((long) this.bufOff) + j10);
                return j10;
            }
            this.bufOff = this.maxBuf;
            long skip = this.in.skip(j10 - available);
            if (skip == this.skippingCipher.skip(skip)) {
                return skip + available;
            }
            throw new IOException("Unable to skip cipher " + skip + " bytes.");
        }
        int min = (int) Math.min(j10, (long) available());
        this.bufOff += min;
        return (long) min;
    }
}
