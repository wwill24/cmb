package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/y2;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext$a;", "getKey", "()Lkotlin/coroutines/CoroutineContext$a;", "key", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class y2 implements CoroutineContext.Element, CoroutineContext.a<y2> {

    /* renamed from: a  reason: collision with root package name */
    public static final y2 f32740a = new y2();

    private y2() {
    }

    public <E extends CoroutineContext.Element> E c(CoroutineContext.a<E> aVar) {
        return CoroutineContext.Element.a.b(this, aVar);
    }

    public CoroutineContext e0(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.a.d(this, coroutineContext);
    }

    public CoroutineContext.a<?> getKey() {
        return this;
    }

    public CoroutineContext u0(CoroutineContext.a<?> aVar) {
        return CoroutineContext.Element.a.c(this, aVar);
    }

    public <R> R v0(R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineContext.Element.a.a(this, r10, function2);
    }
}
