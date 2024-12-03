package operations.array;

import co.a;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import p004do.c;

public interface a extends co.a {

    /* renamed from: operations.array.a$a  reason: collision with other inner class name */
    public static final class C0383a {
        public static ol.a a(a aVar, List<? extends Object> list, Object obj, f fVar) {
            j.g(list, "expressionValues");
            j.g(fVar, "evaluator");
            List<Object> e10 = aVar.e(list, obj, fVar);
            Map<String, Object> a10 = c.a(list);
            return new ol.a(e10, a10, aVar.a(a10, list));
        }

        public static Object b(a aVar, Map<String, ? extends Object> map, List<? extends Object> list) {
            j.g(list, "expressionValues");
            if (map == null) {
                return c.b(list);
            }
            return null;
        }

        public static List<Object> c(a aVar, List<? extends Object> list, Object obj, f fVar) {
            j.g(list, "expression");
            j.g(fVar, "evaluator");
            return a.C0514a.a(aVar, list, obj, fVar);
        }
    }

    Object a(Map<String, ? extends Object> map, List<? extends Object> list);

    ol.a c(List<? extends Object> list, Object obj, f fVar);
}
