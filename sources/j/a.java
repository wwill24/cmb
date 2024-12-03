package j;

import androidx.annotation.NonNull;
import j.b;
import java.util.HashMap;
import java.util.Map;

public class a<K, V> extends b<K, V> {

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<K, b.c<K, V>> f15527e = new HashMap<>();

    public boolean contains(K k10) {
        return this.f15527e.containsKey(k10);
    }

    /* access modifiers changed from: protected */
    public b.c<K, V> d(K k10) {
        return this.f15527e.get(k10);
    }

    public V j(@NonNull K k10, @NonNull V v10) {
        b.c d10 = d(k10);
        if (d10 != null) {
            return d10.f15533b;
        }
        this.f15527e.put(k10, i(k10, v10));
        return null;
    }

    public V m(@NonNull K k10) {
        V m10 = super.m(k10);
        this.f15527e.remove(k10);
        return m10;
    }

    public Map.Entry<K, V> n(K k10) {
        if (contains(k10)) {
            return this.f15527e.get(k10).f15535d;
        }
        return null;
    }
}
