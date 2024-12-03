package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"okio/Throttler$sink$1", "Lokio/ForwardingSink;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "okio"}, k = 1, mv = {1, 6, 0})
public final class Throttler$sink$1 extends ForwardingSink {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Throttler f33427b;

    public void k0(Buffer buffer, long j10) throws IOException {
        j.g(buffer, "source");
        while (j10 > 0) {
            try {
                long d10 = this.f33427b.d(j10);
                super.k0(buffer, d10);
                j10 -= d10;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("interrupted");
            }
        }
    }
}
