package hk;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.e;
import kotlin.jvm.internal.j;

public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends e<E> {
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return d((Map.Entry) obj);
    }

    public final boolean d(E e10) {
        j.g(e10, "element");
        return f(e10);
    }

    public abstract boolean f(Map.Entry<? extends K, ? extends V> entry);

    public /* bridge */ boolean g(Map.Entry<?, ?> entry) {
        return super.remove(entry);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return g((Map.Entry) obj);
    }
}
