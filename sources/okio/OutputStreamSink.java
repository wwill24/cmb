package okio;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lokio/OutputStreamSink;", "Lokio/Sink;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "flush", "close", "Lokio/Timeout;", "p", "", "toString", "Ljava/io/OutputStream;", "a", "Ljava/io/OutputStream;", "out", "b", "Lokio/Timeout;", "timeout", "<init>", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "okio"}, k = 1, mv = {1, 6, 0})
final class OutputStreamSink implements Sink {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f33377a;

    /* renamed from: b  reason: collision with root package name */
    private final Timeout f33378b;

    public OutputStreamSink(OutputStream outputStream, Timeout timeout) {
        j.g(outputStream, "out");
        j.g(timeout, "timeout");
        this.f33377a = outputStream;
        this.f33378b = timeout;
    }

    public void close() {
        this.f33377a.close();
    }

    public void flush() {
        this.f33377a.flush();
    }

    public void k0(Buffer buffer, long j10) {
        j.g(buffer, "source");
        _UtilKt.b(buffer.size(), 0, j10);
        while (j10 > 0) {
            this.f33378b.f();
            Segment segment = buffer.f33298a;
            j.d(segment);
            int min = (int) Math.min(j10, (long) (segment.f33410c - segment.f33409b));
            this.f33377a.write(segment.f33408a, segment.f33409b, min);
            segment.f33409b += min;
            long j11 = (long) min;
            j10 -= j11;
            buffer.I(buffer.size() - j11);
            if (segment.f33409b == segment.f33410c) {
                buffer.f33298a = segment.b();
                SegmentPool.b(segment);
            }
        }
    }

    public Timeout p() {
        return this.f33378b;
    }

    public String toString() {
        return "sink(" + this.f33377a + PropertyUtils.MAPPED_DELIM2;
    }
}
