package fj;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

abstract class a<K, V, V2> implements d<Map<K, V2>> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<K, fk.a<V>> f29641a;

    /* renamed from: fj.a$a  reason: collision with other inner class name */
    public static abstract class C0341a<K, V, V2> {

        /* renamed from: a  reason: collision with root package name */
        final LinkedHashMap<K, fk.a<V>> f29642a;

        C0341a(int i10) {
            this.f29642a = b.c(i10);
        }

        /* access modifiers changed from: package-private */
        public C0341a<K, V, V2> a(K k10, fk.a<V> aVar) {
            this.f29642a.put(g.c(k10, SDKConstants.PARAM_KEY), g.c(aVar, "provider"));
            return this;
        }
    }

    a(Map<K, fk.a<V>> map) {
        this.f29641a = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, fk.a<V>> a() {
        return this.f29641a;
    }
}
