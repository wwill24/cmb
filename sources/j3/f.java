package j3;

import androidx.annotation.NonNull;
import f4.j;
import j3.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final e.a<?> f15559b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f15560a = new HashMap();

    class a implements e.a<Object> {
        a() {
        }

        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @NonNull
        public e<Object> b(@NonNull Object obj) {
            return new b(obj);
        }
    }

    private static final class b implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f15561a;

        b(@NonNull Object obj) {
            this.f15561a = obj;
        }

        @NonNull
        public Object a() {
            return this.f15561a;
        }

        public void b() {
        }
    }

    @NonNull
    public synchronized <T> e<T> a(@NonNull T t10) {
        e.a<?> aVar;
        j.d(t10);
        aVar = this.f15560a.get(t10.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f15560a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t10.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f15559b;
        }
        return aVar.b(t10);
    }

    public synchronized void b(@NonNull e.a<?> aVar) {
        this.f15560a.put(aVar.a(), aVar);
    }
}
