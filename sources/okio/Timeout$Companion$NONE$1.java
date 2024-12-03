package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"okio/Timeout$Companion$NONE$1", "Lokio/Timeout;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "g", "deadlineNanoTime", "d", "", "f", "okio"}, k = 1, mv = {1, 6, 0})
public final class Timeout$Companion$NONE$1 extends Timeout {
    Timeout$Companion$NONE$1() {
    }

    public Timeout d(long j10) {
        return this;
    }

    public void f() {
    }

    public Timeout g(long j10, TimeUnit timeUnit) {
        j.g(timeUnit, "unit");
        return this;
    }
}
