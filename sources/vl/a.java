package vl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p004do.b;

public interface a {

    /* renamed from: vl.a$a  reason: collision with other inner class name */
    public static final class C0400a {
        private static Double a(a aVar, Object obj) {
            if (obj instanceof Number) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            if (obj instanceof String) {
                return p.i((String) obj);
            }
            if (obj instanceof List) {
                return b(aVar, (List) obj);
            }
            if (obj instanceof Boolean) {
                return Double.valueOf(b.a(((Boolean) obj).booleanValue()));
            }
            if (obj == null) {
                return Double.valueOf(0.0d);
            }
            return null;
        }

        private static Double b(a aVar, List<?> list) {
            int size = list.size();
            if (size == 0) {
                return Double.valueOf(0.0d);
            }
            if (size != 1) {
                return null;
            }
            return a(aVar, CollectionsKt___CollectionsKt.N(list));
        }

        public static List<Double> c(a aVar, Object obj) {
            List<Object> c10 = p004do.a.c(obj);
            ArrayList arrayList = new ArrayList(r.t(c10, 10));
            Iterator<T> it = c10.iterator();
            while (it.hasNext()) {
                arrayList.add(a(aVar, it.next()));
            }
            return arrayList;
        }
    }
}
