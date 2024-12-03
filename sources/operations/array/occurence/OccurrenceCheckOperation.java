package operations.array.occurence;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import ol.a;
import operations.array.b;
import tl.d;

public interface OccurrenceCheckOperation extends b, d {

    public static final class DefaultImpls {
        public static Object b(OccurrenceCheckOperation occurrenceCheckOperation, Object obj, Object obj2, f fVar) {
            j.g(fVar, "evaluator");
            return occurrenceCheckOperation.b(obj, obj2, fVar, new OccurrenceCheckOperation$checkOccurrence$1(occurrenceCheckOperation));
        }

        public static a c(OccurrenceCheckOperation occurrenceCheckOperation, List<? extends Object> list, Object obj, f fVar) {
            j.g(list, "expressionValues");
            j.g(fVar, "evaluator");
            return b.a.a(occurrenceCheckOperation, list, obj, fVar);
        }

        /* access modifiers changed from: private */
        public static Object d(OccurrenceCheckOperation occurrenceCheckOperation, a aVar, f fVar, Function2<? super c, ? super f, ? extends Object> function2) {
            Object invoke;
            c g10 = g(occurrenceCheckOperation, aVar);
            if (g10 == null || (invoke = function2.invoke(g10, fVar)) == null) {
                return aVar.c();
            }
            return invoke;
        }

        public static Boolean e(OccurrenceCheckOperation occurrenceCheckOperation, Map<String, ? extends Object> map, List<? extends Object> list) {
            j.g(list, "expressionValues");
            return Boolean.FALSE;
        }

        public static Object f(OccurrenceCheckOperation occurrenceCheckOperation, Object obj, Object obj2, f fVar, Function2<? super a, ? super f, ? extends Object> function2) {
            j.g(fVar, "evaluator");
            j.g(function2, "arrayOperation");
            return b.a.c(occurrenceCheckOperation, obj, obj2, fVar, function2);
        }

        private static c g(OccurrenceCheckOperation occurrenceCheckOperation, a aVar) {
            if (aVar.a() == null || aVar.b() == null || !(!aVar.b().isEmpty())) {
                return null;
            }
            return new c(aVar.b(), aVar.a(), aVar.c());
        }

        public static List<Object> h(OccurrenceCheckOperation occurrenceCheckOperation, List<? extends Object> list, Object obj, f fVar) {
            j.g(list, "expression");
            j.g(fVar, "evaluator");
            return b.a.d(occurrenceCheckOperation, list, obj, fVar);
        }

        public static boolean i(OccurrenceCheckOperation occurrenceCheckOperation, Object obj) {
            return d.a.a(occurrenceCheckOperation, obj);
        }
    }

    Object g(c cVar, f fVar);
}
