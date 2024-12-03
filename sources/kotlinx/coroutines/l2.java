package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.d;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B<\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR3\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/l2;", "T", "R", "Lkotlinx/coroutines/y1;", "", "cause", "", "X", "Lkotlinx/coroutines/selects/d;", "e", "Lkotlinx/coroutines/selects/d;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "f", "Lkotlin/jvm/functions/Function2;", "block", "<init>", "(Lkotlinx/coroutines/selects/d;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class l2<T, R> extends y1 {

    /* renamed from: e  reason: collision with root package name */
    private final d<R> f32581e;

    /* renamed from: f  reason: collision with root package name */
    private final Function2<T, c<? super R>, Object> f32582f;

    public l2(d<? super R> dVar, Function2<? super T, ? super c<? super R>, ? extends Object> function2) {
        this.f32581e = dVar;
        this.f32582f = function2;
    }

    public void X(Throwable th2) {
        if (this.f32581e.n()) {
            Y().S0(this.f32581e, this.f32582f);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        X((Throwable) obj);
        return Unit.f32013a;
    }
}
