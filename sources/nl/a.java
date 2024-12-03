package nl;

public interface a {

    /* renamed from: nl.a$a  reason: collision with other inner class name */
    public static final class C0377a {
        public static Boolean a(a aVar, Object obj) {
            Double i10;
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            boolean z10 = true;
            if (obj instanceof Number) {
                if (((Number) obj).longValue() <= 0) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            } else if (!(obj instanceof String) || (i10 = p.i((String) obj)) == null) {
                return null;
            } else {
                if (((long) i10.doubleValue()) <= 0) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }
    }

    Boolean c(Object obj);
}
