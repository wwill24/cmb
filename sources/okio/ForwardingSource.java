package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0010\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0013"}, d2 = {"Lokio/ForwardingSource;", "Lokio/Source;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "Lokio/Timeout;", "p", "", "close", "", "toString", "a", "Lokio/Source;", "()Lokio/Source;", "delegate", "<init>", "(Lokio/Source;)V", "okio"}, k = 1, mv = {1, 6, 0})
public abstract class ForwardingSource implements Source {

    /* renamed from: a  reason: collision with root package name */
    private final Source f33348a;

    public ForwardingSource(Source source) {
        j.g(source, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f33348a = source;
    }

    public long N1(Buffer buffer, long j10) throws IOException {
        j.g(buffer, "sink");
        return this.f33348a.N1(buffer, j10);
    }

    public final Source a() {
        return this.f33348a;
    }

    public void close() throws IOException {
        this.f33348a.close();
    }

    public Timeout p() {
        return this.f33348a.p();
    }

    public String toString() {
        return getClass().getSimpleName() + PropertyUtils.MAPPED_DELIM + this.f33348a + PropertyUtils.MAPPED_DELIM2;
    }
}
