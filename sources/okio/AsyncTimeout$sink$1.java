package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"okio/AsyncTimeout$sink$1", "Lokio/Sink;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "flush", "close", "Lokio/AsyncTimeout;", "a", "", "toString", "okio"}, k = 1, mv = {1, 6, 0})
public final class AsyncTimeout$sink$1 implements Sink {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AsyncTimeout f33294a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Sink f33295b;

    AsyncTimeout$sink$1(AsyncTimeout asyncTimeout, Sink sink) {
        this.f33294a = asyncTimeout;
        this.f33295b = sink;
    }

    /* renamed from: a */
    public AsyncTimeout p() {
        return this.f33294a;
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.f33294a;
        Sink sink = this.f33295b;
        asyncTimeout.u();
        try {
            sink.close();
            Unit unit = Unit.f32013a;
            if (asyncTimeout.v()) {
                throw asyncTimeout.o((IOException) null);
            }
        } catch (IOException e10) {
            e = e10;
            if (asyncTimeout.v()) {
                e = asyncTimeout.o(e);
            }
            throw e;
        } finally {
            boolean v10 = asyncTimeout.v();
        }
    }

    public void flush() {
        AsyncTimeout asyncTimeout = this.f33294a;
        Sink sink = this.f33295b;
        asyncTimeout.u();
        try {
            sink.flush();
            Unit unit = Unit.f32013a;
            if (asyncTimeout.v()) {
                throw asyncTimeout.o((IOException) null);
            }
        } catch (IOException e10) {
            e = e10;
            if (asyncTimeout.v()) {
                e = asyncTimeout.o(e);
            }
            throw e;
        } finally {
            boolean v10 = asyncTimeout.v();
        }
    }

    public void k0(Buffer buffer, long j10) {
        j.g(buffer, "source");
        _UtilKt.b(buffer.size(), 0, j10);
        while (true) {
            long j11 = 0;
            if (j10 > 0) {
                Segment segment = buffer.f33298a;
                j.d(segment);
                while (true) {
                    if (j11 >= 65536) {
                        break;
                    }
                    j11 += (long) (segment.f33410c - segment.f33409b);
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    } else {
                        segment = segment.f33413f;
                        j.d(segment);
                    }
                }
                AsyncTimeout asyncTimeout = this.f33294a;
                Sink sink = this.f33295b;
                asyncTimeout.u();
                try {
                    sink.k0(buffer, j11);
                    Unit unit = Unit.f32013a;
                    if (!asyncTimeout.v()) {
                        j10 -= j11;
                    } else {
                        throw asyncTimeout.o((IOException) null);
                    }
                } catch (IOException e10) {
                    e = e10;
                    if (asyncTimeout.v()) {
                        e = asyncTimeout.o(e);
                    }
                    throw e;
                } finally {
                    boolean v10 = asyncTimeout.v();
                }
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "AsyncTimeout.sink(" + this.f33295b + PropertyUtils.MAPPED_DELIM2;
    }
}
