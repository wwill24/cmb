package ql;

import java.util.List;

public interface a {

    /* renamed from: ql.a$a  reason: collision with other inner class name */
    public static final class C0395a {
        private static boolean a(a aVar, Object obj) {
            return q.m(null, "", q.j()).contains(obj);
        }

        public static List<String> b(a aVar, Object obj) {
            String obj2;
            if (obj instanceof List) {
                obj = d(aVar, (List) obj);
            }
            List<String> list = null;
            if (obj instanceof List) {
                return null;
            }
            if (!(obj == null || (obj2 = obj.toString()) == null)) {
                list = StringsKt__StringsKt.C0(obj2, new String[]{"."}, false, 0, 6, (Object) null);
            }
            if (list == null) {
                return q.j();
            }
            return list;
        }

        private static Object c(a aVar, List<?> list) {
            Object d10;
            if (list.size() <= 1 && (d10 = d(aVar, list)) != null) {
                return d10;
            }
            return list;
        }

        private static Object d(a aVar, List<?> list) {
            Object P = CollectionsKt___CollectionsKt.P(list);
            if (P instanceof List) {
                return c(aVar, (List) P);
            }
            if (a(aVar, P)) {
                return null;
            }
            return P;
        }
    }
}
