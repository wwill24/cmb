package qn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class b<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<K, Set<V>> f41808a = new HashMap();

    public Set<V> a(K k10) {
        return this.f41808a.get(k10);
    }

    public Set<K> b() {
        return this.f41808a.keySet();
    }

    public void c(K k10, V v10) {
        Set set = this.f41808a.get(k10);
        if (set == null) {
            set = new HashSet();
            this.f41808a.put(k10, set);
        }
        set.add(v10);
    }

    public void d(K k10, Set<V> set) {
        for (V c10 : set) {
            c(k10, c10);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.f41808a.equals(((b) obj).f41808a);
    }

    public int hashCode() {
        return this.f41808a.hashCode();
    }
}
