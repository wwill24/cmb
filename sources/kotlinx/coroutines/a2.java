package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import zk.a;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B6\u0012\u0006\u0010\n\u001a\u00020\t\u0012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0014R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/a2;", "T", "Lkotlinx/coroutines/q0;", "", "N0", "Lkotlin/coroutines/c;", "c", "Lkotlin/coroutines/c;", "continuation", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "", "block", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class a2<T> extends q0<T> {

    /* renamed from: c  reason: collision with root package name */
    private final c<Unit> f32274c;

    public a2(CoroutineContext coroutineContext, Function2<? super k0, ? super c<? super T>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.f32274c = IntrinsicsKt__IntrinsicsJvmKt.b(function2, this, this);
    }

    /* access modifiers changed from: protected */
    public void N0() {
        a.b(this.f32274c, this);
    }
}
