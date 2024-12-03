package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016J+\u0010\u000f\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lkotlinx/coroutines/scheduling/e;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "c0", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "E", "F", "Lkotlinx/coroutines/scheduling/h;", "", "tailDispatch", "f0", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/h;Z)V", "", "d", "I", "corePoolSize", "e", "maxPoolSize", "", "f", "J", "idleWorkerKeepAliveNs", "", "g", "Ljava/lang/String;", "schedulerName", "h", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "coroutineScheduler", "Ljava/util/concurrent/Executor;", "Y", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(IIJLjava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class e extends ExecutorCoroutineDispatcher {

    /* renamed from: d  reason: collision with root package name */
    private final int f32651d;

    /* renamed from: e  reason: collision with root package name */
    private final int f32652e;

    /* renamed from: f  reason: collision with root package name */
    private final long f32653f;

    /* renamed from: g  reason: collision with root package name */
    private final String f32654g;

    /* renamed from: h  reason: collision with root package name */
    private CoroutineScheduler f32655h = c0();

    public e(int i10, int i11, long j10, String str) {
        this.f32651d = i10;
        this.f32652e = i11;
        this.f32653f = j10;
        this.f32654g = str;
    }

    private final CoroutineScheduler c0() {
        return new CoroutineScheduler(this.f32651d, this.f32652e, this.f32653f, this.f32654g);
    }

    public void E(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.g(this.f32655h, runnable, (h) null, false, 6, (Object) null);
    }

    public void F(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.g(this.f32655h, runnable, (h) null, true, 2, (Object) null);
    }

    public Executor Y() {
        return this.f32655h;
    }

    public final void f0(Runnable runnable, h hVar, boolean z10) {
        this.f32655h.f(runnable, hVar, z10);
    }
}
