package coil.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a0\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000\u001a\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000¨\u0006\u0007"}, d2 = {"K", "V", "", "b", "T", "", "a", "coil-base_release"}, k = 2, mv = {1, 7, 1})
public final class c {
    public static final <T> List<T> a(List<? extends T> list) {
        int size = list.size();
        if (size == 0) {
            return q.j();
        }
        if (size != 1) {
            return Collections.unmodifiableList(new ArrayList(list));
        }
        return Collections.singletonList(CollectionsKt___CollectionsKt.N(list));
    }

    public static final <K, V> Map<K, V> b(Map<K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return h0.i();
        }
        if (size != 1) {
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) CollectionsKt___CollectionsKt.M(map.entrySet());
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }
}
