package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\r\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"okio/Pipe$source$1", "Lokio/Source;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "", "close", "Lokio/Timeout;", "p", "a", "Lokio/Timeout;", "timeout", "okio"}, k = 1, mv = {1, 6, 0})
public final class Pipe$source$1 implements Source {

    /* renamed from: a  reason: collision with root package name */
    private final Timeout f33397a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Pipe f33398b;

    public long N1(Buffer buffer, long j10) {
        j.g(buffer, "sink");
        Buffer a10 = this.f33398b.a();
        Pipe pipe = this.f33398b;
        synchronized (a10) {
            if (!(!pipe.f())) {
                throw new IllegalStateException("closed".toString());
            } else if (!pipe.b()) {
                while (pipe.a().size() == 0) {
                    if (pipe.e()) {
                        return -1;
                    }
                    this.f33397a.i(pipe.a());
                    if (pipe.b()) {
                        throw new IOException("canceled");
                    }
                }
                long N1 = pipe.a().N1(buffer, j10);
                pipe.a().notifyAll();
                return N1;
            } else {
                throw new IOException("canceled");
            }
        }
    }

    public void close() {
        Buffer a10 = this.f33398b.a();
        Pipe pipe = this.f33398b;
        synchronized (a10) {
            pipe.h(true);
            pipe.a().notifyAll();
            Unit unit = Unit.f32013a;
        }
    }

    public Timeout p() {
        return this.f33397a;
    }
}
