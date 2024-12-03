package kotlin.coroutines;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;

public interface CoroutineContext {

    public static final class DefaultImpls {
        public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            j.g(coroutineContext2, IdentityHttpResponse.CONTEXT);
            if (coroutineContext2 == EmptyCoroutineContext.f32070a) {
                return coroutineContext;
            }
            return (CoroutineContext) coroutineContext2.v0(coroutineContext, CoroutineContext$plus$1.f32069a);
        }
    }

    public interface Element extends CoroutineContext {

        public static final class a {
            public static <R> R a(Element element, R r10, Function2<? super R, ? super Element, ? extends R> function2) {
                j.g(function2, "operation");
                return function2.invoke(r10, element);
            }

            public static <E extends Element> E b(Element element, a<E> aVar) {
                j.g(aVar, SDKConstants.PARAM_KEY);
                if (!j.b(element.getKey(), aVar)) {
                    return null;
                }
                j.e(element, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return element;
            }

            public static CoroutineContext c(Element element, a<?> aVar) {
                j.g(aVar, SDKConstants.PARAM_KEY);
                return j.b(element.getKey(), aVar) ? EmptyCoroutineContext.f32070a : element;
            }

            public static CoroutineContext d(Element element, CoroutineContext coroutineContext) {
                j.g(coroutineContext, IdentityHttpResponse.CONTEXT);
                return DefaultImpls.a(element, coroutineContext);
            }
        }

        <E extends Element> E c(a<E> aVar);

        a<?> getKey();
    }

    public interface a<E extends Element> {
    }

    <E extends Element> E c(a<E> aVar);

    CoroutineContext e0(CoroutineContext coroutineContext);

    CoroutineContext u0(a<?> aVar);

    <R> R v0(R r10, Function2<? super R, ? super Element, ? extends R> function2);
}
