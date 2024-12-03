package kotlin.coroutines;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.j;

public interface d extends CoroutineContext.Element {

    /* renamed from: s  reason: collision with root package name */
    public static final b f32074s = b.f32075a;

    public static final class a {
        public static <E extends CoroutineContext.Element> E a(d dVar, CoroutineContext.a<E> aVar) {
            j.g(aVar, SDKConstants.PARAM_KEY);
            if (aVar instanceof b) {
                b bVar = (b) aVar;
                if (!bVar.a(dVar.getKey())) {
                    return null;
                }
                E b10 = bVar.b(dVar);
                if (b10 instanceof CoroutineContext.Element) {
                    return b10;
                }
                return null;
            } else if (d.f32074s != aVar) {
                return null;
            } else {
                j.e(dVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return dVar;
            }
        }

        public static CoroutineContext b(d dVar, CoroutineContext.a<?> aVar) {
            j.g(aVar, SDKConstants.PARAM_KEY);
            if (aVar instanceof b) {
                b bVar = (b) aVar;
                if (!bVar.a(dVar.getKey()) || bVar.b(dVar) == null) {
                    return dVar;
                }
                return EmptyCoroutineContext.f32070a;
            } else if (d.f32074s == aVar) {
                return EmptyCoroutineContext.f32070a;
            } else {
                return dVar;
            }
        }
    }

    public static final class b implements CoroutineContext.a<d> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f32075a = new b();

        private b() {
        }
    }

    void e(c<?> cVar);

    <T> c<T> g(c<? super T> cVar);
}
