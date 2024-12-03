package operations.logic.equals;

import java.util.List;
import kotlin.jvm.functions.Function2;
import ml.b;
import operations.logic.equals.a;

public final class Equals implements b, a {

    /* renamed from: a  reason: collision with root package name */
    public static final Equals f33488a = new Equals();

    private Equals() {
    }

    public Object a(Object obj) {
        return a.C0384a.f(this, obj);
    }

    public boolean b(List<? extends Object> list, Function2<? super Integer, ? super Integer, Boolean> function2) {
        return a.C0384a.b(this, list, function2);
    }

    public Boolean c(Object obj) {
        return a.C0384a.g(this, obj);
    }

    public List<Comparable<?>> d(Comparable<?> comparable, Comparable<?> comparable2) {
        return a.C0384a.d(this, comparable, comparable2);
    }

    public Object e(Object obj) {
        return a.C0384a.e(this, obj);
    }

    public List<Comparable<?>> g(Comparable<?> comparable, Comparable<?> comparable2) {
        return a.C0384a.c(this, comparable, comparable2);
    }

    public boolean h(Object obj, Function2<? super Integer, ? super Integer, Boolean> function2) {
        return a.C0384a.a(this, obj, function2);
    }

    /* renamed from: i */
    public Boolean f(Object obj, Object obj2) {
        return Boolean.valueOf(h(obj, Equals$evaluateLogic$1.f33489a));
    }
}
