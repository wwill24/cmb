package v;

import androidx.annotation.NonNull;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class b extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f18033a;

    public b(@NonNull ByteBuffer byteBuffer) {
        this.f18033a = byteBuffer;
    }

    public void write(int i10) throws IOException {
        if (this.f18033a.hasRemaining()) {
            this.f18033a.put((byte) i10);
            return;
        }
        throw new EOFException("Output ByteBuffer has no bytes remaining.");
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        bArr.getClass();
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i11 != 0) {
            if (this.f18033a.remaining() >= i11) {
                this.f18033a.put(bArr, i10, i11);
                return;
            }
            throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
        }
    }
}
