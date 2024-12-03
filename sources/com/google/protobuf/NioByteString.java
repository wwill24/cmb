package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    NioByteString(ByteBuffer byteBuffer) {
        w.b(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer b0(int i10, int i11) {
        if (i10 < this.buffer.position() || i11 > this.buffer.limit() || i10 > i11) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}));
        }
        ByteBuffer slice = this.buffer.slice();
        slice.position(i10 - this.buffer.position());
        slice.limit(i11 - this.buffer.position());
        return slice;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private Object writeReplace() {
        return ByteString.o(this.buffer.slice());
    }

    public boolean A() {
        return Utf8.r(this.buffer);
    }

    public h D() {
        return h.j(this.buffer, true);
    }

    /* access modifiers changed from: protected */
    public int H(int i10, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + this.buffer.get(i13);
        }
        return i10;
    }

    /* access modifiers changed from: protected */
    public int J(int i10, int i11, int i12) {
        return Utf8.u(i10, this.buffer, i11, i12 + i11);
    }

    public ByteString M(int i10, int i11) {
        try {
            return new NioByteString(b0(i10, i11));
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new ArrayIndexOutOfBoundsException(e11.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public String R(Charset charset) {
        int i10;
        int i11;
        byte[] bArr;
        if (this.buffer.hasArray()) {
            bArr = this.buffer.array();
            i11 = this.buffer.arrayOffset() + this.buffer.position();
            i10 = this.buffer.remaining();
        } else {
            bArr = N();
            i11 = 0;
            i10 = bArr.length;
        }
        return new String(bArr, i11, i10, charset);
    }

    /* access modifiers changed from: package-private */
    public void Z(g gVar) throws IOException {
        gVar.a(this.buffer.slice());
    }

    /* access modifiers changed from: package-private */
    public boolean a0(ByteString byteString, int i10, int i11) {
        return M(0, i11).equals(byteString.M(i10, i11 + i10));
    }

    public ByteBuffer d() {
        return this.buffer.asReadOnlyBuffer();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.d());
    }

    public byte g(int i10) {
        try {
            return this.buffer.get(i10);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new ArrayIndexOutOfBoundsException(e11.getMessage());
        }
    }

    public int size() {
        return this.buffer.remaining();
    }

    /* access modifiers changed from: protected */
    public void v(byte[] bArr, int i10, int i11, int i12) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i10);
        slice.get(bArr, i11, i12);
    }

    public byte y(int i10) {
        return g(i10);
    }
}
