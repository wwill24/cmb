package operations.numeric;

import java.util.List;
import kotlin.jvm.functions.Function1;
import ml.b;
import operations.numeric.a;
import vl.b;

public final class Multiplication implements b, a, vl.b {

    /* renamed from: a  reason: collision with root package name */
    public static final Multiplication f33502a = new Multiplication();

    private Multiplication() {
    }

    public Double a(Object obj, Function1<? super List<Double>, Double> function1) {
        return a.C0386a.a(this, obj, function1);
    }

    public List<Object> b(Object obj) {
        return b.a.b(this, obj);
    }

    public Object f(Object obj, Object obj2) {
        List<Object> c10 = p004do.a.c(obj);
        int size = c10.size();
        if (size == 0) {
            return null;
        }
        if (size != 1) {
            return a(b(obj), Multiplication$evaluateLogic$1.f33503a);
        }
        return CollectionsKt___CollectionsKt.N(c10);
    }
}
