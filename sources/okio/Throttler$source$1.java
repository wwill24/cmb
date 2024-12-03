package okio;

import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"okio/Throttler$source$1", "Lokio/ForwardingSource;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "okio"}, k = 1, mv = {1, 6, 0})
public final class Throttler$source$1 extends ForwardingSource {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Throttler f33428b;

    public long N1(Buffer buffer, long j10) {
        j.g(buffer, "sink");
        try {
            return super.N1(buffer, this.f33428b.d(j10));
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
