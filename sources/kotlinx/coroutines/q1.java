package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\b¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R&\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/q1;", "Lkotlinx/coroutines/t1;", "", "cause", "", "X", "(Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "e", "Lkotlin/jvm/functions/Function1;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class q1 extends t1 {

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f32596f = AtomicIntegerFieldUpdater.newUpdater(q1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: e  reason: collision with root package name */
    private final Function1<Throwable, Unit> f32597e;

    public q1(Function1<? super Throwable, Unit> function1) {
        this.f32597e = function1;
    }

    public void X(Throwable th2) {
        if (f32596f.compareAndSet(this, 0, 1)) {
            this.f32597e.invoke(th2);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        X((Throwable) obj);
        return Unit.f32013a;
    }
}
