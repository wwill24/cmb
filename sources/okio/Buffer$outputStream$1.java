package okio;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"okio/Buffer$outputStream$1", "Ljava/io/OutputStream;", "close", "", "flush", "toString", "", "write", "data", "", "offset", "", "byteCount", "b", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Buffer$outputStream$1 extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Buffer f33307a;

    Buffer$outputStream$1(Buffer buffer) {
        this.f33307a = buffer;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return this.f33307a + ".outputStream()";
    }

    public void write(int i10) {
        this.f33307a.writeByte(i10);
    }

    public void write(byte[] bArr, int i10, int i11) {
        j.g(bArr, "data");
        this.f33307a.write(bArr, i10, i11);
    }
}
