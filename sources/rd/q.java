package rd;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class q extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f41873a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(u uVar) {
        super(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
        this.f41873a = uVar;
        setThreadFactory(new s((r) null));
        allowCoreThreadTimeOut(true);
    }

    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t10) {
        return new p(this, runnable, t10);
    }
}
