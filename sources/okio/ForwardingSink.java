package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0010\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lokio/ForwardingSink;", "Lokio/Sink;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "flush", "Lokio/Timeout;", "p", "close", "", "toString", "a", "Lokio/Sink;", "delegate", "()Lokio/Sink;", "<init>", "(Lokio/Sink;)V", "okio"}, k = 1, mv = {1, 6, 0})
public abstract class ForwardingSink implements Sink {

    /* renamed from: a  reason: collision with root package name */
    private final Sink f33347a;

    public ForwardingSink(Sink sink) {
        j.g(sink, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f33347a = sink;
    }

    public void close() throws IOException {
        this.f33347a.close();
    }

    public void flush() throws IOException {
        this.f33347a.flush();
    }

    public void k0(Buffer buffer, long j10) throws IOException {
        j.g(buffer, "source");
        this.f33347a.k0(buffer, j10);
    }

    public Timeout p() {
        return this.f33347a.p();
    }

    public String toString() {
        return getClass().getSimpleName() + PropertyUtils.MAPPED_DELIM + this.f33347a + PropertyUtils.MAPPED_DELIM2;
    }
}
