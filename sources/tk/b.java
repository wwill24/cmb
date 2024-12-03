package tk;

import kotlin.jvm.internal.j;
import wk.l;

final class b<T> implements d<Object, T> {

    /* renamed from: a  reason: collision with root package name */
    private T f33873a;

    public T getValue(Object obj, l<?> lVar) {
        j.g(lVar, "property");
        T t10 = this.f33873a;
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("Property " + lVar.getName() + " should be initialized before get.");
    }

    public void setValue(Object obj, l<?> lVar, T t10) {
        j.g(lVar, "property");
        j.g(t10, "value");
        this.f33873a = t10;
    }
}
