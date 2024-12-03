package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"okio/AsyncTimeout$source$1", "Lokio/Source;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "", "close", "Lokio/AsyncTimeout;", "a", "", "toString", "okio"}, k = 1, mv = {1, 6, 0})
public final class AsyncTimeout$source$1 implements Source {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AsyncTimeout f33296a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Source f33297b;

    AsyncTimeout$source$1(AsyncTimeout asyncTimeout, Source source) {
        this.f33296a = asyncTimeout;
        this.f33297b = source;
    }

    public long N1(Buffer buffer, long j10) {
        j.g(buffer, "sink");
        AsyncTimeout asyncTimeout = this.f33296a;
        Source source = this.f33297b;
        asyncTimeout.u();
        try {
            long N1 = source.N1(buffer, j10);
            if (!asyncTimeout.v()) {
                return N1;
            }
            throw asyncTimeout.o((IOException) null);
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

    /* renamed from: a */
    public AsyncTimeout p() {
        return this.f33296a;
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.f33296a;
        Source source = this.f33297b;
        asyncTimeout.u();
        try {
            source.close();
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

    public String toString() {
        return "AsyncTimeout.source(" + this.f33297b + PropertyUtils.MAPPED_DELIM2;
    }
}
