package f4;

import androidx.collection.a;
import androidx.collection.g;

public final class b<K, V> extends a<K, V> {

    /* renamed from: l  reason: collision with root package name */
    private int f14709l;

    public void clear() {
        this.f14709l = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.f14709l == 0) {
            this.f14709l = super.hashCode();
        }
        return this.f14709l;
    }

    public void k(g<? extends K, ? extends V> gVar) {
        this.f14709l = 0;
        super.k(gVar);
    }

    public V l(int i10) {
        this.f14709l = 0;
        return super.l(i10);
    }

    public V m(int i10, V v10) {
        this.f14709l = 0;
        return super.m(i10, v10);
    }

    public V put(K k10, V v10) {
        this.f14709l = 0;
        return super.put(k10, v10);
    }
}
