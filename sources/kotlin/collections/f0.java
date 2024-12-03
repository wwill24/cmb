package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;

class f0 {
    public static final <K, V> V a(Map<K, ? extends V> map, K k10) {
        j.g(map, "<this>");
        if (map instanceof d0) {
            return ((d0) map).i(k10);
        }
        V v10 = map.get(k10);
        if (v10 != null || map.containsKey(k10)) {
            return v10;
        }
        throw new NoSuchElementException("Key " + k10 + " is missing in the map.");
    }
}
