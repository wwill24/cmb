package vl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface b {

    public static final class a {
        private static Object a(b bVar, Object obj) {
            while (!(obj instanceof Number)) {
                if (obj instanceof String) {
                    return p.i((String) obj);
                }
                if (!(obj instanceof List)) {
                    return null;
                }
                obj = CollectionsKt___CollectionsKt.P((List) obj);
            }
            return Double.valueOf(((Number) obj).doubleValue());
        }

        public static List<Object> b(b bVar, Object obj) {
            List<Object> c10 = p004do.a.c(obj);
            ArrayList arrayList = new ArrayList(r.t(c10, 10));
            Iterator<T> it = c10.iterator();
            while (it.hasNext()) {
                arrayList.add(a(bVar, it.next()));
            }
            return arrayList;
        }
    }
}
