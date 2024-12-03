package kotlinx.coroutines;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/i2;", "T", "Lkotlinx/coroutines/y1;", "", "cause", "", "X", "Lkotlinx/coroutines/o;", "e", "Lkotlinx/coroutines/o;", "continuation", "<init>", "(Lkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class i2<T> extends y1 {

    /* renamed from: e  reason: collision with root package name */
    private final o<T> f32495e;

    public i2(o<? super T> oVar) {
        this.f32495e = oVar;
    }

    public void X(Throwable th2) {
        Object q02 = Y().q0();
        if (q02 instanceof b0) {
            o<T> oVar = this.f32495e;
            Result.a aVar = Result.f32010a;
            oVar.resumeWith(Result.b(g.a(((b0) q02).f32285a)));
            return;
        }
        o<T> oVar2 = this.f32495e;
        Result.a aVar2 = Result.f32010a;
        oVar2.resumeWith(Result.b(z1.h(q02)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        X((Throwable) obj);
        return Unit.f32013a;
    }
}
