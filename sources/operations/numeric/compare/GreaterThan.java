package operations.numeric.compare;

import java.util.List;
import kotlin.jvm.functions.Function2;
import ml.b;
import nl.c;
import p004do.a;

public final class GreaterThan implements b, c {

    /* renamed from: a  reason: collision with root package name */
    public static final GreaterThan f33504a = new GreaterThan();

    private GreaterThan() {
    }

    public boolean b(List<? extends Object> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
        return c.a.b(this, list, function2);
    }

    public Boolean c(Object obj) {
        return c.a.f(this, obj);
    }

    public List<Comparable<?>> d(Comparable<?> comparable, Comparable<?> comparable2) {
        return c.a.e(this, comparable, comparable2);
    }

    public Object f(Object obj, Object obj2) {
        return Boolean.valueOf(b(a.c(obj), GreaterThan$evaluateLogic$1.f33505a));
    }

    public List<Comparable<?>> g(Comparable<?> comparable, Comparable<?> comparable2) {
        return c.a.d(this, comparable, comparable2);
    }
}
