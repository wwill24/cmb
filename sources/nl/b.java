package nl;

import java.util.List;
import nl.a;

public interface b extends a {

    public static final class a {
        public static List<Comparable<?>> a(b bVar, Comparable<?> comparable, Comparable<?> comparable2) {
            boolean z10 = comparable instanceof Number;
            if (z10 && (comparable2 instanceof Number)) {
                return q.m(Double.valueOf(((Number) comparable).doubleValue()), Double.valueOf(((Number) comparable2).doubleValue()));
            } else if ((comparable instanceof String) && (comparable2 instanceof Number)) {
                return q.m(p.i((String) comparable), Double.valueOf(((Number) comparable2).doubleValue()));
            } else if (z10 && (comparable2 instanceof String)) {
                return q.m(Double.valueOf(((Number) comparable).doubleValue()), p.i((String) comparable2));
            } else if (!(comparable instanceof Boolean) && !(comparable2 instanceof Boolean)) {
                return bVar.d(comparable, comparable2);
            } else {
                return q.m(bVar.c(comparable), bVar.c(comparable2));
            }
        }

        public static List<Comparable<?>> b(b bVar, Comparable<?> comparable, Comparable<?> comparable2) {
            if (comparable != null && comparable2 != null && comparable.getClass() == comparable2.getClass()) {
                return q.m(comparable, comparable2);
            } else if (comparable != null || comparable2 != null) {
                return null;
            } else {
                return q.m((Void) comparable, (Void) comparable2);
            }
        }

        public static Boolean c(b bVar, Object obj) {
            return a.C0377a.a(bVar, obj);
        }
    }

    List<Comparable<?>> d(Comparable<?> comparable, Comparable<?> comparable2);

    List<Comparable<?>> g(Comparable<?> comparable, Comparable<?> comparable2);
}
