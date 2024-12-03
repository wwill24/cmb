package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class CoroutineContext$plus$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {

    /* renamed from: a  reason: collision with root package name */
    public static final CoroutineContext$plus$1 f32069a = new CoroutineContext$plus$1();

    CoroutineContext$plus$1() {
        super(2);
    }

    /* renamed from: a */
    public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        CombinedContext combinedContext;
        j.g(coroutineContext, "acc");
        j.g(element, "element");
        CoroutineContext u02 = coroutineContext.u0(element.getKey());
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f32070a;
        if (u02 == emptyCoroutineContext) {
            return element;
        }
        d.b bVar = d.f32074s;
        d dVar = (d) u02.c(bVar);
        if (dVar == null) {
            combinedContext = new CombinedContext(u02, element);
        } else {
            CoroutineContext u03 = u02.u0(bVar);
            if (u03 == emptyCoroutineContext) {
                return new CombinedContext(element, dVar);
            }
            combinedContext = new CombinedContext(new CombinedContext(u03, element), dVar);
        }
        return combinedContext;
    }
}
