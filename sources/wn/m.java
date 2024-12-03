package wn;

import java.util.List;

public interface m {

    public static final class a {
        public static String a(m mVar, Object obj) {
            List<Object> c10 = p004do.a.c(obj);
            if (c10.size() > 1) {
                return null;
            }
            Object P = CollectionsKt___CollectionsKt.P(c10);
            if (P instanceof String) {
                return (String) P;
            }
            return null;
        }
    }
}
