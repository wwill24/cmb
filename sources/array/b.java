package array;

import co.a;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import ml.a;
import p004do.c;

public final class b implements a, co.a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f7658a = new b();

    private b() {
    }

    public Object d(Object obj, Object obj2, f fVar) {
        j.g(fVar, "evaluator");
        List<Object> c10 = p004do.a.c(obj);
        List<Object> e10 = f7658a.e(c10, obj2, fVar);
        Map<String, Object> a10 = c.a(c10);
        if (a10 == null || e10 == null) {
            return null;
        }
        for (T next : e10) {
            if (j.b(fVar.a(a10, next), Boolean.TRUE)) {
                return next;
            }
        }
        return null;
    }

    public List<Object> e(List<? extends Object> list, Object obj, f fVar) {
        return a.C0514a.a(this, list, obj, fVar);
    }
}
