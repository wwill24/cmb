package operations.numeric.compare;

import java.util.List;
import kotlin.jvm.functions.Function2;
import ml.b;
import operations.numeric.compare.a;

public final class LessThanOrEqualTo implements b, a {

    /* renamed from: a  reason: collision with root package name */
    public static final LessThanOrEqualTo f33510a = new LessThanOrEqualTo();

    private LessThanOrEqualTo() {
    }

    public boolean b(List<? extends Object> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
        return a.C0387a.b(this, list, function2);
    }

    public Boolean c(Object obj) {
        return a.C0387a.f(this, obj);
    }

    public List<Comparable<?>> d(Comparable<?> comparable, Comparable<?> comparable2) {
        return a.C0387a.e(this, comparable, comparable2);
    }

    public boolean e(List<? extends Object> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
        return a.C0387a.c(this, list, function2);
    }

    public Object f(Object obj, Object obj2) {
        return Boolean.valueOf(e(p004do.a.c(obj), LessThanOrEqualTo$evaluateLogic$1.f33511a));
    }

    public List<Comparable<?>> g(Comparable<?> comparable, Comparable<?> comparable2) {
        return a.C0387a.d(this, comparable, comparable2);
    }
}
