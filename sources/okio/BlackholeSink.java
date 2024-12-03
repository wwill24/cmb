package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lokio/BlackholeSink;", "Lokio/Sink;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "flush", "Lokio/Timeout;", "p", "close", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
final class BlackholeSink implements Sink {
    public void close() {
    }

    public void flush() {
    }

    public void k0(Buffer buffer, long j10) {
        j.g(buffer, "source");
        buffer.skip(j10);
    }

    public Timeout p() {
        return Timeout.f33430e;
    }
}
