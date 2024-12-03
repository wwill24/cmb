package tl;

import java.util.List;
import kotlin.jvm.internal.j;

public interface c {

    public static final class a {
        private static Object a(c cVar, Object obj) {
            String str;
            String obj2;
            Object j10;
            Object obj3 = null;
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = null;
            }
            if (str != null && (j10 = q.j(str)) != null) {
                obj3 = j10;
            } else if (str != null) {
                obj3 = p.i(str);
            }
            if (obj3 == null || (obj2 = obj3.toString()) == null) {
                return obj;
            }
            return obj2;
        }

        private static Object b(c cVar, Object obj) {
            if (!(obj instanceof List)) {
                return obj;
            }
            List list = (List) obj;
            return list.size() == 1 ? b(cVar, CollectionsKt___CollectionsKt.P(list)) : obj;
        }

        public static Object c(c cVar, Object obj) {
            Object b10 = b(cVar, obj);
            if (!j.b(b10, obj)) {
                return new b(a(cVar, b10));
            }
            return a(cVar, obj);
        }
    }

    Object e(Object obj);
}
