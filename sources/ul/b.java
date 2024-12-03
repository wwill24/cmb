package ul;

import java.util.List;
import kotlin.jvm.internal.j;
import vl.a;

public final class b implements ml.b, a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f33892a = new b();

    private b() {
    }

    /* renamed from: a */
    public Double f(Object obj, Object obj2) {
        boolean z10;
        List<Double> b10 = b(obj);
        if (b10.size() >= 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            b10 = null;
        }
        if (b10 == null) {
            return null;
        }
        Double d10 = b10.get(1);
        Double d11 = (Double) CollectionsKt___CollectionsKt.N(b10);
        if (d11 == null || d10 == null || j.a(d10, 0.0d)) {
            return null;
        }
        return Double.valueOf(d11.doubleValue() % d10.doubleValue());
    }

    public List<Double> b(Object obj) {
        return a.C0400a.c(this, obj);
    }
}
