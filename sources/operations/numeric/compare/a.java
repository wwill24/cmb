package operations.numeric.compare;

import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import nl.c;

public interface a extends c {

    /* renamed from: operations.numeric.compare.a$a  reason: collision with other inner class name */
    public static final class C0387a {
        private static boolean a(a aVar, List<? extends Comparable<?>> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
            boolean b10 = aVar.b(q.m((Comparable) CollectionsKt___CollectionsKt.P(list), (Comparable) p004do.c.b(list)), function2);
            boolean b11 = aVar.b(q.m((Comparable) p004do.c.b(list), (Comparable) p004do.c.c(list)), function2);
            if (!b10 || !b11) {
                return false;
            }
            return true;
        }

        public static boolean b(a aVar, List<? extends Object> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
            j.g(function2, "operator");
            return c.a.b(aVar, list, function2);
        }

        public static boolean c(a aVar, List<? extends Object> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
            List<Comparable<?>> d10;
            boolean a10;
            j.g(function2, "operator");
            if (list == null || (d10 = p004do.a.d(list)) == null) {
                return false;
            }
            if (d10.size() == 2) {
                a10 = aVar.b(d10, function2);
            } else if (d10.size() <= 2) {
                return false;
            } else {
                a10 = a(aVar, d10, function2);
            }
            return a10;
        }

        public static List<Comparable<?>> d(a aVar, Comparable<?> comparable, Comparable<?> comparable2) {
            return c.a.d(aVar, comparable, comparable2);
        }

        public static List<Comparable<?>> e(a aVar, Comparable<?> comparable, Comparable<?> comparable2) {
            return c.a.e(aVar, comparable, comparable2);
        }

        public static Boolean f(a aVar, Object obj) {
            return c.a.f(aVar, obj);
        }
    }
}
