package operations.numeric.compare;

import java.util.List;
import kotlin.jvm.functions.Function2;
import ml.b;
import operations.numeric.compare.a;

public final class LessThan implements b, a {

    /* renamed from: a  reason: collision with root package name */
    public static final LessThan f33508a = new LessThan();

    private LessThan() {
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
        return Boolean.valueOf(e(p004do.a.c(obj), LessThan$evaluateLogic$1.f33509a));
    }

    public List<Comparable<?>> g(Comparable<?> comparable, Comparable<?> comparable2) {
        return a.C0387a.d(this, comparable, comparable2);
    }
}
