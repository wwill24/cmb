package androidx.camera.core.impl.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

class b extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    final OutputStream f2617a;

    /* renamed from: b  reason: collision with root package name */
    private ByteOrder f2618b;

    b(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.f2617a = outputStream;
        this.f2618b = byteOrder;
    }

    public void a(ByteOrder byteOrder) {
        this.f2618b = byteOrder;
    }

    public void b(int i10) throws IOException {
        this.f2617a.write(i10);
    }

    public void c(int i10) throws IOException {
        ByteOrder byteOrder = this.f2618b;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.f2617a.write((i10 >>> 0) & 255);
            this.f2617a.write((i10 >>> 8) & 255);
            this.f2617a.write((i10 >>> 16) & 255);
            this.f2617a.write((i10 >>> 24) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.f2617a.write((i10 >>> 24) & 255);
            this.f2617a.write((i10 >>> 16) & 255);
            this.f2617a.write((i10 >>> 8) & 255);
            this.f2617a.write((i10 >>> 0) & 255);
        }
    }

    public void e(short s10) throws IOException {
        ByteOrder byteOrder = this.f2618b;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.f2617a.write((s10 >>> 0) & 255);
            this.f2617a.write((s10 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.f2617a.write((s10 >>> 8) & 255);
            this.f2617a.write((s10 >>> 0) & 255);
        }
    }

    public void f(long j10) throws IOException {
        c((int) j10);
    }

    public void g(int i10) throws IOException {
        e((short) i10);
    }

    public void write(byte[] bArr) throws IOException {
        this.f2617a.write(bArr);
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f2617a.write(bArr, i10, i11);
    }
}
