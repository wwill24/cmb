package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.j;

class h0 extends g0 {
    public static <K, V> Map<K, V> i() {
        EmptyMap emptyMap = EmptyMap.f32017a;
        j.e(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static <K, V> V j(Map<K, ? extends V> map, K k10) {
        j.g(map, "<this>");
        return f0.a(map, k10);
    }

    public static <K, V> HashMap<K, V> k(Pair<? extends K, ? extends V>... pairArr) {
        j.g(pairArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(g0.e(pairArr.length));
        r(hashMap, pairArr);
        return hashMap;
    }

    public static <K, V> Map<K, V> l(Pair<? extends K, ? extends V>... pairArr) {
        j.g(pairArr, "pairs");
        return pairArr.length > 0 ? v(pairArr, new LinkedHashMap(g0.e(pairArr.length))) : i();
    }

    public static <K, V> Map<K, V> m(Pair<? extends K, ? extends V>... pairArr) {
        j.g(pairArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.e(pairArr.length));
        r(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> n(Map<K, ? extends V> map) {
        j.g(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return i();
        }
        if (size != 1) {
            return map;
        }
        return g0.g(map);
    }

    public static <K, V> Map<K, V> o(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        j.g(map, "<this>");
        j.g(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> p(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        j.g(map, "<this>");
        j.g(pair, "pair");
        if (map.isEmpty()) {
            return g0.f(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.c(), pair.d());
        return linkedHashMap;
    }

    public static final <K, V> void q(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        j.g(map, "<this>");
        j.g(iterable, "pairs");
        for (Pair pair : iterable) {
            map.put(pair.a(), pair.b());
        }
    }

    public static final <K, V> void r(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        j.g(map, "<this>");
        j.g(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.a(), pair.b());
        }
    }

    public static <K, V> Map<K, V> s(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Object obj;
        j.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return n(t(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return i();
        }
        if (size != 1) {
            return t(iterable, new LinkedHashMap(g0.e(collection.size())));
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return g0.f((Pair) obj);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M t(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m10) {
        j.g(iterable, "<this>");
        j.g(m10, "destination");
        q(m10, iterable);
        return m10;
    }

    public static <K, V> Map<K, V> u(Map<? extends K, ? extends V> map) {
        j.g(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return i();
        }
        if (size != 1) {
            return w(map);
        }
        return g0.g(map);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M v(Pair<? extends K, ? extends V>[] pairArr, M m10) {
        j.g(pairArr, "<this>");
        j.g(m10, "destination");
        r(m10, pairArr);
        return m10;
    }

    public static <K, V> Map<K, V> w(Map<? extends K, ? extends V> map) {
        j.g(map, "<this>");
        return new LinkedHashMap(map);
    }
}
