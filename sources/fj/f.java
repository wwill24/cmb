package fj;

import fj.a;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class f<K, V> extends a<K, V, V> {

    /* renamed from: b  reason: collision with root package name */
    private static final fk.a<Map<Object, Object>> f29648b = e.a(Collections.emptyMap());

    public static final class b<K, V> extends a.C0341a<K, V, V> {
        public f<K, V> b() {
            return new f<>(this.f29642a);
        }

        public b<K, V> c(K k10, fk.a<V> aVar) {
            super.a(k10, aVar);
            return this;
        }

        private b(int i10) {
            super(i10);
        }
    }

    public static <K, V> b<K, V> b(int i10) {
        return new b<>(i10);
    }

    /* renamed from: c */
    public Map<K, V> get() {
        LinkedHashMap c10 = b.c(a().size());
        for (Map.Entry entry : a().entrySet()) {
            c10.put(entry.getKey(), ((fk.a) entry.getValue()).get());
        }
        return Collections.unmodifiableMap(c10);
    }

    private f(Map<K, fk.a<V>> map) {
        super(map);
    }
}
