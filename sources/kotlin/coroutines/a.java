package kotlin.coroutines;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;

public abstract class a implements CoroutineContext.Element {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext.a<?> f32071a;

    public a(CoroutineContext.a<?> aVar) {
        j.g(aVar, SDKConstants.PARAM_KEY);
        this.f32071a = aVar;
    }

    public <E extends CoroutineContext.Element> E c(CoroutineContext.a<E> aVar) {
        return CoroutineContext.Element.a.b(this, aVar);
    }

    public CoroutineContext e0(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.a.d(this, coroutineContext);
    }

    public CoroutineContext.a<?> getKey() {
        return this.f32071a;
    }

    public CoroutineContext u0(CoroutineContext.a<?> aVar) {
        return CoroutineContext.Element.a.c(this, aVar);
    }

    public <R> R v0(R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineContext.Element.a.a(this, r10, function2);
    }
}
