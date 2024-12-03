package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/InputStreamSource;", "Lokio/Source;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "", "close", "Lokio/Timeout;", "p", "", "toString", "Ljava/io/InputStream;", "a", "Ljava/io/InputStream;", "input", "b", "Lokio/Timeout;", "timeout", "<init>", "(Ljava/io/InputStream;Lokio/Timeout;)V", "okio"}, k = 1, mv = {1, 6, 0})
class InputStreamSource implements Source {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f33370a;

    /* renamed from: b  reason: collision with root package name */
    private final Timeout f33371b;

    public InputStreamSource(InputStream inputStream, Timeout timeout) {
        j.g(inputStream, "input");
        j.g(timeout, "timeout");
        this.f33370a = inputStream;
        this.f33371b = timeout;
    }

    public long N1(Buffer buffer, long j10) {
        boolean z10;
        j.g(buffer, "sink");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 == 0) {
            return 0;
        }
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            try {
                this.f33371b.f();
                Segment O = buffer.O(1);
                int read = this.f33370a.read(O.f33408a, O.f33410c, (int) Math.min(j10, (long) (8192 - O.f33410c)));
                if (read != -1) {
                    O.f33410c += read;
                    long j11 = (long) read;
                    buffer.I(buffer.size() + j11);
                    return j11;
                } else if (O.f33409b != O.f33410c) {
                    return -1;
                } else {
                    buffer.f33298a = O.b();
                    SegmentPool.b(O);
                    return -1;
                }
            } catch (AssertionError e10) {
                if (Okio.d(e10)) {
                    throw new IOException(e10);
                }
                throw e10;
            }
        } else {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
    }

    public void close() {
        this.f33370a.close();
    }

    public Timeout p() {
        return this.f33371b;
    }

    public String toString() {
        return "source(" + this.f33370a + PropertyUtils.MAPPED_DELIM2;
    }
}
