package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/u;", "Lkotlinx/coroutines/t1;", "Lkotlinx/coroutines/t;", "", "cause", "", "X", "", "e", "Lkotlinx/coroutines/v;", "Lkotlinx/coroutines/v;", "childJob", "Lkotlinx/coroutines/s1;", "getParent", "()Lkotlinx/coroutines/s1;", "parent", "<init>", "(Lkotlinx/coroutines/v;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class u extends t1 implements t {

    /* renamed from: e  reason: collision with root package name */
    public final v f32727e;

    public u(v vVar) {
        this.f32727e = vVar;
    }

    public void X(Throwable th2) {
        this.f32727e.x(Y());
    }

    public boolean e(Throwable th2) {
        return Y().c0(th2);
    }

    public s1 getParent() {
        return Y();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        X((Throwable) obj);
        return Unit.f32013a;
    }
}
