package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import zk.a;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B6\u0012\u0006\u0010\t\u001a\u00020\b\u0012\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/b2;", "Lkotlinx/coroutines/m2;", "", "N0", "Lkotlin/coroutines/c;", "c", "Lkotlin/coroutines/c;", "continuation", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "", "block", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class b2 extends m2 {

    /* renamed from: c  reason: collision with root package name */
    private final c<Unit> f32287c;

    public b2(CoroutineContext coroutineContext, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.f32287c = IntrinsicsKt__IntrinsicsJvmKt.b(function2, this, this);
    }

    /* access modifiers changed from: protected */
    public void N0() {
        a.b(this.f32287c, this);
    }
}
