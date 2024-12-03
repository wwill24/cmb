package kotlin.collections;

import com.google.android.gms.common.api.a;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.j;

class g0 extends f0 {
    public static <K, V> Map<K, V> b(Map<K, V> map) {
        j.g(map, "builder");
        return ((MapBuilder) map).j();
    }

    public static <K, V> Map<K, V> c() {
        return new MapBuilder();
    }

    public static <K, V> Map<K, V> d(int i10) {
        return new MapBuilder(i10);
    }

    public static int e(int i10) {
        return i10 < 0 ? i10 : i10 < 3 ? i10 + 1 : i10 < 1073741824 ? (int) ((((float) i10) / 0.75f) + 1.0f) : a.e.API_PRIORITY_OTHER;
    }

    public static <K, V> Map<K, V> f(Pair<? extends K, ? extends V> pair) {
        j.g(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.c(), pair.d());
        j.f(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> g(Map<? extends K, ? extends V> map) {
        j.g(map, "<this>");
        Map.Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        j.f(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static <K extends Comparable<? super K>, V> SortedMap<K, V> h(Map<? extends K, ? extends V> map) {
        j.g(map, "<this>");
        return new TreeMap(map);
    }
}
