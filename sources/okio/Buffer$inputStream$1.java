package okio;

import com.google.android.gms.common.api.a;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"okio/Buffer$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "sink", "", "offset", "byteCount", "toString", "", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Buffer$inputStream$1 extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Buffer f33306a;

    Buffer$inputStream$1(Buffer buffer) {
        this.f33306a = buffer;
    }

    public int available() {
        return (int) Math.min(this.f33306a.size(), (long) a.e.API_PRIORITY_OTHER);
    }

    public void close() {
    }

    public int read() {
        if (this.f33306a.size() > 0) {
            return this.f33306a.readByte() & 255;
        }
        return -1;
    }

    public String toString() {
        return this.f33306a + ".inputStream()";
    }

    public int read(byte[] bArr, int i10, int i11) {
        j.g(bArr, "sink");
        return this.f33306a.read(bArr, i10, i11);
    }
}
