package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import qk.a;

public final class z<T> implements Iterable<IndexedValue<? extends T>>, a {

    /* renamed from: a  reason: collision with root package name */
    private final Function0<Iterator<T>> f32066a;

    public z(Function0<? extends Iterator<? extends T>> function0) {
        j.g(function0, "iteratorFactory");
        this.f32066a = function0;
    }

    public Iterator<IndexedValue<T>> iterator() {
        return new a0(this.f32066a.invoke());
    }
}
