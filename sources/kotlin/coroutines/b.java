package kotlin.coroutines;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public abstract class b<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.a<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<CoroutineContext.Element, E> f32072a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext.a<?> f32073b;

    public b(CoroutineContext.a<B> aVar, Function1<? super CoroutineContext.Element, ? extends E> function1) {
        j.g(aVar, "baseKey");
        j.g(function1, "safeCast");
        this.f32072a = function1;
        this.f32073b = aVar instanceof b ? ((b) aVar).f32073b : aVar;
    }

    public final boolean a(CoroutineContext.a<?> aVar) {
        j.g(aVar, SDKConstants.PARAM_KEY);
        return aVar == this || this.f32073b == aVar;
    }

    public final E b(CoroutineContext.Element element) {
        j.g(element, "element");
        return (CoroutineContext.Element) this.f32072a.invoke(element);
    }
}
