package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/y0;", "Lkotlinx/coroutines/z0;", "", "dispose", "", "toString", "Ljava/util/concurrent/Future;", "a", "Ljava/util/concurrent/Future;", "future", "<init>", "(Ljava/util/concurrent/Future;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class y0 implements z0 {

    /* renamed from: a  reason: collision with root package name */
    private final Future<?> f32738a;

    public y0(Future<?> future) {
        this.f32738a = future;
    }

    public void dispose() {
        this.f32738a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f32738a + PropertyUtils.INDEXED_DELIM2;
    }
}
