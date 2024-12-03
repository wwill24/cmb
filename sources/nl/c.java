package nl;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import nl.b;

public interface c extends b {

    public static final class a {
        private static boolean a(c cVar, List<? extends Comparable<?>> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
            Integer c10 = c(cVar, (Comparable) CollectionsKt___CollectionsKt.P(list), (Comparable) p004do.c.b(list));
            if (c10 != null) {
                return function2.invoke(Integer.valueOf(c10.intValue()), 0).booleanValue();
            }
            return false;
        }

        public static boolean b(c cVar, List<? extends Object> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
            List<Comparable<?>> d10;
            j.g(function2, "operator");
            if (list == null || (d10 = p004do.a.d(list)) == null) {
                return false;
            }
            return a(cVar, d10, function2);
        }

        private static Integer c(c cVar, Comparable<?> comparable, Comparable<?> comparable2) {
            boolean z10;
            Integer valueOf;
            boolean z11;
            boolean z12;
            List<Comparable<?>> g10 = cVar.g(comparable, comparable2);
            if (g10 == null) {
                return null;
            }
            boolean z13 = false;
            if (!g10.isEmpty()) {
                Iterator<T> it = g10.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((Comparable) it.next()) == null) {
                        z12 = true;
                        continue;
                    } else {
                        z12 = false;
                        continue;
                    }
                    if (!z12) {
                        z10 = false;
                        break;
                    }
                }
            }
            z10 = true;
            if (z10) {
                valueOf = Integer.valueOf(b.a((Comparable) CollectionsKt___CollectionsKt.P(g10), (Comparable) p004do.c.b(g10)));
            } else {
                if (!g10.isEmpty()) {
                    Iterator<T> it2 = g10.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((Comparable) it2.next()) == null) {
                                z11 = true;
                                continue;
                            } else {
                                z11 = false;
                                continue;
                            }
                            if (z11) {
                                z13 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z13) {
                    return null;
                }
                valueOf = Integer.valueOf(b.a((Comparable) CollectionsKt___CollectionsKt.P(g10), (Comparable) p004do.c.b(g10)));
            }
            return valueOf;
        }

        public static List<Comparable<?>> d(c cVar, Comparable<?> comparable, Comparable<?> comparable2) {
            return b.a.a(cVar, comparable, comparable2);
        }

        public static List<Comparable<?>> e(c cVar, Comparable<?> comparable, Comparable<?> comparable2) {
            return b.a.b(cVar, comparable, comparable2);
        }

        public static Boolean f(c cVar, Object obj) {
            return b.a.c(cVar, obj);
        }
    }

    boolean b(List<? extends Object> list, Function2<? super Integer, ? super Integer, Boolean> function2);
}
