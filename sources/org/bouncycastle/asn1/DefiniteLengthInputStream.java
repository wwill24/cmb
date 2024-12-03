package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

class DefiniteLengthInputStream extends LimitedInputStream {
    private static final byte[] EMPTY_BYTES = new byte[0];
    private final int _originalLength;
    private int _remaining;

    DefiniteLengthInputStream(InputStream inputStream, int i10, int i11) {
        super(inputStream, i11);
        if (i10 >= 0) {
            this._originalLength = i10;
            this._remaining = i10;
            if (i10 == 0) {
                setParentEofDetect(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    /* access modifiers changed from: package-private */
    public int getRemaining() {
        return this._remaining;
    }

    public int read() throws IOException {
        if (this._remaining == 0) {
            return -1;
        }
        int read = this._in.read();
        if (read >= 0) {
            int i10 = this._remaining - 1;
            this._remaining = i10;
            if (i10 == 0) {
                setParentEofDetect(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this._remaining;
        if (i12 == 0) {
            return -1;
        }
        int read = this._in.read(bArr, i10, Math.min(i11, i12));
        if (read >= 0) {
            int i13 = this._remaining - read;
            this._remaining = i13;
            if (i13 == 0) {
                setParentEofDetect(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    /* access modifiers changed from: package-private */
    public void readAllIntoByteArray(byte[] bArr) throws IOException {
        int i10 = this._remaining;
        if (i10 != bArr.length) {
            throw new IllegalArgumentException("buffer length not right for data");
        } else if (i10 != 0) {
            int limit = getLimit();
            int i11 = this._remaining;
            if (i11 < limit) {
                int readFully = i11 - Streams.readFully(this._in, bArr);
                this._remaining = readFully;
                if (readFully == 0) {
                    setParentEofDetect(true);
                    return;
                }
                throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
            }
            throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + limit);
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] toByteArray() throws IOException {
        if (this._remaining == 0) {
            return EMPTY_BYTES;
        }
        int limit = getLimit();
        int i10 = this._remaining;
        if (i10 < limit) {
            byte[] bArr = new byte[i10];
            int readFully = i10 - Streams.readFully(this._in, bArr);
            this._remaining = readFully;
            if (readFully == 0) {
                setParentEofDetect(true);
                return bArr;
            }
            throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
        }
        throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + limit);
    }
}
