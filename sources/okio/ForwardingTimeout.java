package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0017J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0001H\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "k", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "g", "h", "", "e", "c", "deadlineNanoTime", "d", "b", "a", "", "f", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "setDelegate", "(Lokio/Timeout;)V", "<init>", "okio"}, k = 1, mv = {1, 6, 0})
public class ForwardingTimeout extends Timeout {

    /* renamed from: f  reason: collision with root package name */
    private Timeout f33349f;

    public ForwardingTimeout(Timeout timeout) {
        j.g(timeout, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f33349f = timeout;
    }

    public Timeout a() {
        return this.f33349f.a();
    }

    public Timeout b() {
        return this.f33349f.b();
    }

    public long c() {
        return this.f33349f.c();
    }

    public Timeout d(long j10) {
        return this.f33349f.d(j10);
    }

    public boolean e() {
        return this.f33349f.e();
    }

    public void f() throws IOException {
        this.f33349f.f();
    }

    public Timeout g(long j10, TimeUnit timeUnit) {
        j.g(timeUnit, "unit");
        return this.f33349f.g(j10, timeUnit);
    }

    public long h() {
        return this.f33349f.h();
    }

    public final Timeout j() {
        return this.f33349f;
    }

    public final ForwardingTimeout k(Timeout timeout) {
        j.g(timeout, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f33349f = timeout;
        return this;
    }
}
