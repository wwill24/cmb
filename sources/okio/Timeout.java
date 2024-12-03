package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0000H\u0016J\b\u0010\u000e\u001a\u00020\u0000H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0001R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0015¨\u0006\u001a"}, d2 = {"Lokio/Timeout;", "", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "g", "h", "", "e", "c", "deadlineNanoTime", "d", "b", "a", "", "f", "monitor", "i", "Z", "hasDeadline", "J", "timeoutNanos", "<init>", "()V", "Companion", "okio"}, k = 1, mv = {1, 6, 0})
public class Timeout {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f33429d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: e  reason: collision with root package name */
    public static final Timeout f33430e = new Timeout$Companion$NONE$1();

    /* renamed from: a  reason: collision with root package name */
    private boolean f33431a;

    /* renamed from: b  reason: collision with root package name */
    private long f33432b;

    /* renamed from: c  reason: collision with root package name */
    private long f33433c;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lokio/Timeout$Companion;", "", "", "aNanos", "bNanos", "a", "Lokio/Timeout;", "NONE", "Lokio/Timeout;", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a(long j10, long j11) {
            return (j10 != 0 && (j11 == 0 || j10 < j11)) ? j10 : j11;
        }
    }

    public Timeout a() {
        this.f33431a = false;
        return this;
    }

    public Timeout b() {
        this.f33433c = 0;
        return this;
    }

    public long c() {
        if (this.f33431a) {
            return this.f33432b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public Timeout d(long j10) {
        this.f33431a = true;
        this.f33432b = j10;
        return this;
    }

    public boolean e() {
        return this.f33431a;
    }

    public void f() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        } else if (this.f33431a && this.f33432b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout g(long j10, TimeUnit timeUnit) {
        boolean z10;
        j.g(timeUnit, "unit");
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f33433c = timeUnit.toNanos(j10);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j10).toString());
    }

    public long h() {
        return this.f33433c;
    }

    public final void i(Object obj) throws InterruptedIOException {
        j.g(obj, "monitor");
        try {
            boolean e10 = e();
            long h10 = h();
            long j10 = 0;
            if (e10 || h10 != 0) {
                long nanoTime = System.nanoTime();
                if (e10 && h10 != 0) {
                    h10 = Math.min(h10, c() - nanoTime);
                } else if (e10) {
                    h10 = c() - nanoTime;
                }
                if (h10 > 0) {
                    long j11 = h10 / 1000000;
                    obj.wait(j11, (int) (h10 - (1000000 * j11)));
                    j10 = System.nanoTime() - nanoTime;
                }
                if (j10 >= h10) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            obj.wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
