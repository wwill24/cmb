package okhttp3;

import el.e;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import net.bytebuddy.implementation.MethodDelegation;
import okhttp3.internal.connection.f;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u000fB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0011"}, d2 = {"Lokhttp3/j;", "", "Lokhttp3/internal/connection/f;", "a", "Lokhttp3/internal/connection/f;", "()Lokhttp3/internal/connection/f;", "delegate", "<init>", "(Lokhttp3/internal/connection/f;)V", "", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "(IJLjava/util/concurrent/TimeUnit;)V", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final f f33113a;

    public j(f fVar) {
        kotlin.jvm.internal.j.g(fVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f33113a = fVar;
    }

    public final f a() {
        return this.f33113a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public j(int i10, long j10, TimeUnit timeUnit) {
        this(new f(e.f29630i, i10, j10, timeUnit));
        kotlin.jvm.internal.j.g(timeUnit, "timeUnit");
    }

    public j() {
        this(5, 5, TimeUnit.MINUTES);
    }
}
