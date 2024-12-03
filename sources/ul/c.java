package ul;

import java.util.List;
import ml.b;
import vl.a;

public final class c implements b, a {

    /* renamed from: a  reason: collision with root package name */
    public static final c f33893a = new c();

    private c() {
    }

    private final Double b(Double d10, Double d11) {
        if (d10 == null || d11 == null) {
            return null;
        }
        return Double.valueOf(d10.doubleValue() - d11.doubleValue());
    }

    /* renamed from: a */
    public Double f(Object obj, Object obj2) {
        List<Double> c10 = c(obj);
        int size = c10.size();
        if (size == 0) {
            return null;
        }
        if (size != 1) {
            return f33893a.b((Double) CollectionsKt___CollectionsKt.N(c10), c10.get(1));
        }
        Double d10 = (Double) CollectionsKt___CollectionsKt.N(c10);
        if (d10 != null) {
            return Double.valueOf(-d10.doubleValue());
        }
        return null;
    }

    public List<Double> c(Object obj) {
        return a.C0400a.c(this, obj);
    }
}
