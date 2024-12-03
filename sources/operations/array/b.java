package operations.array;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import operations.array.a;

public interface b extends a {

    public static final class a {
        public static ol.a a(b bVar, List<? extends Object> list, Object obj, f fVar) {
            j.g(list, "expressionValues");
            j.g(fVar, "evaluator");
            return a.C0383a.a(bVar, list, obj, fVar);
        }

        public static Object b(b bVar, Map<String, ? extends Object> map, List<? extends Object> list) {
            j.g(list, "expressionValues");
            return a.C0383a.b(bVar, map, list);
        }

        public static Object c(b bVar, Object obj, Object obj2, f fVar, Function2<? super ol.a, ? super f, ? extends Object> function2) {
            j.g(fVar, "evaluator");
            j.g(function2, "arrayOperation");
            return function2.invoke(bVar.c(p004do.a.c(obj), obj2, fVar), fVar);
        }

        public static List<Object> d(b bVar, List<? extends Object> list, Object obj, f fVar) {
            j.g(list, "expression");
            j.g(fVar, "evaluator");
            return a.C0383a.c(bVar, list, obj, fVar);
        }
    }

    Object b(Object obj, Object obj2, f fVar, Function2<? super ol.a, ? super f, ? extends Object> function2);
}
