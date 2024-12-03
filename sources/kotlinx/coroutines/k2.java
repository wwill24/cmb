package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/k2;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "run", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/n;", "b", "Lkotlinx/coroutines/n;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class k2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineDispatcher f32578a;

    /* renamed from: b  reason: collision with root package name */
    private final n<Unit> f32579b;

    public k2(CoroutineDispatcher coroutineDispatcher, n<? super Unit> nVar) {
        this.f32578a = coroutineDispatcher;
        this.f32579b = nVar;
    }

    public void run() {
        this.f32579b.D(this.f32578a, Unit.f32013a);
    }
}
