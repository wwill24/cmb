package wk;

import kotlin.jvm.functions.Function2;

public interface k<D, E, V> extends l<V>, Function2<D, E, V> {

    public interface a<D, E, V> extends g, Function2<D, E, V> {
    }

    a<D, E, V> b();

    V x(D d10, E e10);
}
