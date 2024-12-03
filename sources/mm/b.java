package mm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jxmpp.util.cache.LruCache;

public class b<K, V> implements a<K, V>, Map<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<K, c<V>> f23796a;

    /* renamed from: b  reason: collision with root package name */
    private long f23797b;

    /* renamed from: mm.b$b  reason: collision with other inner class name */
    private static class C0286b<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final K f23798a;

        /* renamed from: b  reason: collision with root package name */
        private V f23799b;

        C0286b(K k10, V v10) {
            this.f23798a = k10;
            this.f23799b = v10;
        }

        public K getKey() {
            return this.f23798a;
        }

        public V getValue() {
            return this.f23799b;
        }

        public V setValue(V v10) {
            V v11 = this.f23799b;
            this.f23799b = v10;
            return v11;
        }
    }

    private static class c<V> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final V f23800a;

        /* renamed from: b  reason: collision with root package name */
        private final long f23801b;

        /* access modifiers changed from: private */
        public boolean c() {
            return System.currentTimeMillis() > this.f23801b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return this.f23800a.equals(((c) obj).f23800a);
        }

        public int hashCode() {
            return this.f23800a.hashCode();
        }

        private c(V v10, long j10) {
            this.f23800a = v10;
            this.f23801b = System.currentTimeMillis() + j10;
        }
    }

    public b(int i10, long j10) {
        this.f23796a = new LruCache<>(i10);
        c(j10);
    }

    public V a(K k10) {
        return get(k10);
    }

    public V b(K k10, V v10, long j10) {
        c put = this.f23796a.put(k10, new c(v10, j10));
        if (put == null) {
            return null;
        }
        return put.f23800a;
    }

    public void c(long j10) {
        if (j10 > 0) {
            this.f23797b = j10;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void clear() {
        this.f23796a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f23796a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f23796a.containsValue(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        HashSet hashSet = new HashSet();
        for (Map.Entry next : this.f23796a.entrySet()) {
            hashSet.add(new C0286b(next.getKey(), ((c) next.getValue()).f23800a));
        }
        return hashSet;
    }

    public V get(Object obj) {
        c cVar = this.f23796a.get(obj);
        if (cVar == null) {
            return null;
        }
        if (!cVar.c()) {
            return cVar.f23800a;
        }
        remove(obj);
        return null;
    }

    public boolean isEmpty() {
        return this.f23796a.isEmpty();
    }

    public Set<K> keySet() {
        return this.f23796a.keySet();
    }

    public V put(K k10, V v10) {
        return b(k10, v10, this.f23797b);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public V remove(Object obj) {
        c remove = this.f23796a.remove(obj);
        if (remove == null) {
            return null;
        }
        return remove.f23800a;
    }

    public int size() {
        return this.f23796a.size();
    }

    public Collection<V> values() {
        HashSet hashSet = new HashSet();
        for (c<V> a10 : this.f23796a.values()) {
            hashSet.add(a10.f23800a);
        }
        return hashSet;
    }
}
