package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/j2;", "Lkotlinx/coroutines/y1;", "", "cause", "", "X", "Lkotlin/coroutines/c;", "e", "Lkotlin/coroutines/c;", "continuation", "<init>", "(Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class j2 extends y1 {

    /* renamed from: e  reason: collision with root package name */
    private final c<Unit> f32576e;

    public j2(c<? super Unit> cVar) {
        this.f32576e = cVar;
    }

    public void X(Throwable th2) {
        c<Unit> cVar = this.f32576e;
        Result.a aVar = Result.f32010a;
        cVar.resumeWith(Result.b(Unit.f32013a));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        X((Throwable) obj);
        return Unit.f32013a;
    }
}
