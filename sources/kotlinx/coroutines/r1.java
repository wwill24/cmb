package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R&\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/r1;", "Lkotlinx/coroutines/y1;", "", "cause", "", "X", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "e", "Lkotlin/jvm/functions/Function1;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class r1 extends y1 {

    /* renamed from: e  reason: collision with root package name */
    private final Function1<Throwable, Unit> f32601e;

    public r1(Function1<? super Throwable, Unit> function1) {
        this.f32601e = function1;
    }

    public void X(Throwable th2) {
        this.f32601e.invoke(th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        X((Throwable) obj);
        return Unit.f32013a;
    }
}
