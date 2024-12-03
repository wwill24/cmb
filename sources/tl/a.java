package tl;

import java.util.List;
import p004do.b;

public interface a {

    /* renamed from: tl.a$a  reason: collision with other inner class name */
    public static final class C0398a {
        private static Object a(a aVar, List<?> list) {
            if (p004do.a.g(list)) {
                return Double.valueOf(0.0d);
            }
            if (list.isEmpty()) {
                return "";
            }
            return b(aVar, list);
        }

        private static Object b(a aVar, List<?> list) {
            List<?> list2;
            boolean z10 = true;
            if (list.size() != 1 || (CollectionsKt___CollectionsKt.P(list) instanceof Boolean)) {
                z10 = false;
            }
            if (z10) {
                list2 = list;
            } else {
                list2 = null;
            }
            if (list2 != null) {
                return aVar.a(CollectionsKt___CollectionsKt.P(list));
            }
            return null;
        }

        public static Object c(a aVar, Object obj) {
            Object a10;
            if (obj instanceof Number) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            if (obj instanceof String) {
                a10 = p.i((String) obj);
                if (a10 == null) {
                    return obj;
                }
            } else if (obj instanceof List) {
                a10 = a(aVar, (List) obj);
                if (a10 == null) {
                    return obj;
                }
            } else if (obj instanceof Boolean) {
                return Double.valueOf(b.a(((Boolean) obj).booleanValue()));
            } else {
                return obj;
            }
            return a10;
        }
    }

    Object a(Object obj);
}
