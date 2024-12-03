package wk;

import kotlin.jvm.functions.Function1;

public interface j<T, V> extends l<V>, Function1<T, V> {

    public interface a<T, V> extends g, Function1<T, V> {
    }

    a<T, V> b();

    V get(T t10);
}
