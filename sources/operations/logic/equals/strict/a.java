package operations.logic.equals.strict;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import operations.logic.equals.a;

public interface a extends operations.logic.equals.a {

    /* renamed from: operations.logic.equals.strict.a$a  reason: collision with other inner class name */
    public static final class C0385a {
        public static boolean a(a aVar, Object obj, Function2<? super Integer, ? super Integer, Boolean> function2) {
            j.g(function2, "operator");
            List<Object> c10 = p004do.a.c(obj);
            if (c10.size() == 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList(r.t(c10, 10));
            Iterator<T> it = c10.iterator();
            while (it.hasNext()) {
                arrayList.add(aVar.a(it.next()));
            }
            return aVar.b(arrayList, function2);
        }

        public static boolean b(a aVar, List<? extends Object> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
            j.g(function2, "operator");
            return a.C0384a.b(aVar, list, function2);
        }

        public static List<Comparable<?>> c(a aVar, Comparable<?> comparable, Comparable<?> comparable2) {
            return aVar.d(comparable, comparable2);
        }

        public static List<Comparable<?>> d(a aVar, Comparable<?> comparable, Comparable<?> comparable2) {
            return a.C0384a.d(aVar, comparable, comparable2);
        }

        public static Object e(a aVar, Object obj) {
            return a.C0384a.e(aVar, obj);
        }

        public static Object f(a aVar, Object obj) {
            Number number = obj instanceof Number ? (Number) obj : null;
            return number != null ? Double.valueOf(number.doubleValue()) : obj;
        }

        public static Boolean g(a aVar, Object obj) {
            return a.C0384a.g(aVar, obj);
        }
    }

    Object a(Object obj);
}
