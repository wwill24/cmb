package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/b1;", "Lkotlinx/coroutines/y1;", "", "cause", "", "X", "Lkotlinx/coroutines/z0;", "e", "Lkotlinx/coroutines/z0;", "handle", "<init>", "(Lkotlinx/coroutines/z0;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class b1 extends y1 {

    /* renamed from: e  reason: collision with root package name */
    private final z0 f32286e;

    public b1(z0 z0Var) {
        this.f32286e = z0Var;
    }

    public void X(Throwable th2) {
        this.f32286e.dispose();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        X((Throwable) obj);
        return Unit.f32013a;
    }
}
