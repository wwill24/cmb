package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/s;", "Lkotlinx/coroutines/t1;", "", "cause", "", "X", "Lkotlinx/coroutines/o;", "e", "Lkotlinx/coroutines/o;", "child", "<init>", "(Lkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class s extends t1 {

    /* renamed from: e  reason: collision with root package name */
    public final o<?> f32617e;

    public s(o<?> oVar) {
        this.f32617e = oVar;
    }

    public void X(Throwable th2) {
        o<?> oVar = this.f32617e;
        oVar.H(oVar.u(Y()));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        X((Throwable) obj);
        return Unit.f32013a;
    }
}
