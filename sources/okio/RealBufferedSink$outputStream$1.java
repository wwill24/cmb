package okio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"okio/RealBufferedSink$outputStream$1", "Ljava/io/OutputStream;", "", "b", "", "write", "", "data", "offset", "byteCount", "flush", "close", "", "toString", "okio"}, k = 1, mv = {1, 6, 0})
public final class RealBufferedSink$outputStream$1 extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RealBufferedSink f33402a;

    public void close() {
        this.f33402a.close();
    }

    public void flush() {
        RealBufferedSink realBufferedSink = this.f33402a;
        if (!realBufferedSink.f33401c) {
            realBufferedSink.flush();
        }
    }

    public String toString() {
        return this.f33402a + ".outputStream()";
    }

    public void write(int i10) {
        RealBufferedSink realBufferedSink = this.f33402a;
        if (!realBufferedSink.f33401c) {
            realBufferedSink.f33400b.writeByte((byte) i10);
            this.f33402a.V();
            return;
        }
        throw new IOException("closed");
    }

    public void write(byte[] bArr, int i10, int i11) {
        j.g(bArr, "data");
        RealBufferedSink realBufferedSink = this.f33402a;
        if (!realBufferedSink.f33401c) {
            realBufferedSink.f33400b.write(bArr, i10, i11);
            this.f33402a.V();
            return;
        }
        throw new IOException("closed");
    }
}
