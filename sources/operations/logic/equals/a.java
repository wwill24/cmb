package operations.logic.equals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import nl.c;
import tl.a;
import tl.c;

public interface a extends c, tl.a, tl.c {

    /* renamed from: operations.logic.equals.a$a  reason: collision with other inner class name */
    public static final class C0384a {
        public static boolean a(a aVar, Object obj, Function2<? super Integer, ? super Integer, Boolean> function2) {
            boolean z10;
            boolean z11;
            j.g(function2, "operator");
            List<Object> c10 = p004do.a.c(obj);
            Object e10 = aVar.e(CollectionsKt___CollectionsKt.P(c10));
            Object e11 = aVar.e(p004do.c.b(c10));
            sl.a aVar2 = sl.a.f33850a;
            List<Object> a10 = aVar2.a(e10);
            List<Object> a11 = aVar2.a(e11);
            if (a10 == null && a11 == null) {
                ArrayList arrayList = new ArrayList(r.t(c10, 10));
                Iterator<T> it = c10.iterator();
                while (it.hasNext()) {
                    arrayList.add(aVar.a(it.next()));
                }
                return aVar.b(arrayList, function2);
            }
            if (a10 != null) {
                z10 = a10.contains(e11);
            } else {
                z10 = false;
            }
            if (!z10) {
                if (a11 != null) {
                    z11 = a11.contains(e10);
                } else {
                    z11 = false;
                }
                if (z11) {
                    return true;
                }
                return false;
            }
            return true;
        }

        public static boolean b(a aVar, List<? extends Object> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
            j.g(function2, "operator");
            return c.a.b(aVar, list, function2);
        }

        public static List<Comparable<?>> c(a aVar, Comparable<?> comparable, Comparable<?> comparable2) {
            return c.a.d(aVar, comparable, comparable2);
        }

        public static List<Comparable<?>> d(a aVar, Comparable<?> comparable, Comparable<?> comparable2) {
            return c.a.e(aVar, comparable, comparable2);
        }

        public static Object e(a aVar, Object obj) {
            return c.a.c(aVar, obj);
        }

        public static Object f(a aVar, Object obj) {
            return a.C0398a.c(aVar, obj);
        }

        public static Boolean g(a aVar, Object obj) {
            return c.a.f(aVar, obj);
        }
    }
}
