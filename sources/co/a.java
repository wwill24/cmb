package co;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;

public interface a {

    /* renamed from: co.a$a  reason: collision with other inner class name */
    public static final class C0514a {
        public static List<Object> a(a aVar, List<? extends Object> list, Object obj, f fVar) {
            j.g(list, "expression");
            j.g(fVar, "evaluator");
            Object b10 = b(aVar, CollectionsKt___CollectionsKt.P(list), obj, fVar);
            if (b10 instanceof List) {
                return (List) b10;
            }
            return null;
        }

        private static Object b(a aVar, Object obj, Object obj2, f fVar) {
            if (obj instanceof List) {
                Iterable<Object> iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(r.t(iterable, 10));
                for (Object b10 : iterable) {
                    arrayList.add(b(aVar, b10, obj2, fVar));
                }
                return arrayList;
            } else if (!p004do.a.f(obj)) {
                return obj;
            } else {
                j.e(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                return fVar.a((Map) obj, obj2);
            }
        }
    }

    List<Object> e(List<? extends Object> list, Object obj, f fVar);
}
