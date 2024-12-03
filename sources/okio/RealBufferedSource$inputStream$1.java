package okio;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"okio/RealBufferedSource$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "data", "", "offset", "byteCount", "toString", "", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealBufferedSource$inputStream$1 extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RealBufferedSource f33406a;

    RealBufferedSource$inputStream$1(RealBufferedSource realBufferedSource) {
        this.f33406a = realBufferedSource;
    }

    public int available() {
        RealBufferedSource realBufferedSource = this.f33406a;
        if (!realBufferedSource.f33405c) {
            return (int) Math.min(realBufferedSource.f33404b.size(), (long) a.e.API_PRIORITY_OTHER);
        }
        throw new IOException("closed");
    }

    public void close() {
        this.f33406a.close();
    }

    public int read() {
        RealBufferedSource realBufferedSource = this.f33406a;
        if (!realBufferedSource.f33405c) {
            if (realBufferedSource.f33404b.size() == 0) {
                RealBufferedSource realBufferedSource2 = this.f33406a;
                if (realBufferedSource2.f33403a.N1(realBufferedSource2.f33404b, 8192) == -1) {
                    return -1;
                }
            }
            return this.f33406a.f33404b.readByte() & 255;
        }
        throw new IOException("closed");
    }

    public String toString() {
        return this.f33406a + ".inputStream()";
    }

    public int read(byte[] bArr, int i10, int i11) {
        j.g(bArr, "data");
        if (!this.f33406a.f33405c) {
            _UtilKt.b((long) bArr.length, (long) i10, (long) i11);
            if (this.f33406a.f33404b.size() == 0) {
                RealBufferedSource realBufferedSource = this.f33406a;
                if (realBufferedSource.f33403a.N1(realBufferedSource.f33404b, 8192) == -1) {
                    return -1;
                }
            }
            return this.f33406a.f33404b.read(bArr, i10, i11);
        }
        throw new IOException("closed");
    }
}
