package operations.array;

import gk.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import ml.a;
import operations.array.a;

public final class c implements a, a {

    /* renamed from: a  reason: collision with root package name */
    public static final c f33481a = new c();

    private c() {
    }

    private final Object f(ol.a aVar, Object obj, f fVar) {
        List<Object> b10 = aVar.b();
        if (b10 == null) {
            return obj;
        }
        Iterator<T> it = b10.iterator();
        Object obj2 = obj;
        while (it.hasNext()) {
            obj2 = f33481a.h(fVar, obj2, it.next(), aVar.a());
            if (obj2 == null) {
                return aVar.c();
            }
        }
        if (obj2 == null) {
            return obj;
        }
        return obj2;
    }

    private final Object h(f fVar, Object obj, Object obj2, Map<String, ? extends Object> map) {
        if (map != null) {
            return fVar.a(map, f33481a.i(obj, obj2));
        }
        return null;
    }

    private final Map<String, Object> i(Object obj, Object obj2) {
        return h0.l(h.a("accumulator", obj), h.a("current", obj2));
    }

    public Object a(Map<String, ? extends Object> map, List<? extends Object> list) {
        return a.C0383a.b(this, map, list);
    }

    public ol.a c(List<? extends Object> list, Object obj, f fVar) {
        return a.C0383a.a(this, list, obj, fVar);
    }

    public Object d(Object obj, Object obj2, f fVar) {
        j.g(fVar, "evaluator");
        List<Object> c10 = p004do.a.c(obj);
        c cVar = f33481a;
        return cVar.f(cVar.c(c10, obj2, fVar), p004do.c.c(c10), fVar);
    }

    public List<Object> e(List<? extends Object> list, Object obj, f fVar) {
        return a.C0383a.c(this, list, obj, fVar);
    }
}
