package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private static final MapFieldLite f5152a;
    private boolean isMutable = true;

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        f5152a = mapFieldLite;
        mapFieldLite.l();
    }

    private MapFieldLite() {
    }

    static <K, V> int a(Map<K, V> map) {
        int i10 = 0;
        for (Map.Entry next : map.entrySet()) {
            i10 += b(next.getValue()) ^ b(next.getKey());
        }
        return i10;
    }

    private static int b(Object obj) {
        if (obj instanceof byte[]) {
            return w.d((byte[]) obj);
        }
        if (!(obj instanceof w.c)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private static void c(Map<?, ?> map) {
        for (Object next : map.keySet()) {
            w.a(next);
            w.a(map.get(next));
        }
    }

    public static <K, V> MapFieldLite<K, V> d() {
        return f5152a;
    }

    private void e() {
        if (!k()) {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean h(Object obj, Object obj2) {
        if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
            return obj.equals(obj2);
        }
        return Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <K, V> boolean j(java.util.Map<K, V> r4, java.util.Map<K, V> r5) {
        /*
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.size()
            int r2 = r5.size()
            r3 = 0
            if (r1 == r2) goto L_0x0010
            return r3
        L_0x0010:
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0018:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0042
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            boolean r2 = r5.containsKey(r2)
            if (r2 != 0) goto L_0x002f
            return r3
        L_0x002f:
            java.lang.Object r2 = r1.getValue()
            java.lang.Object r1 = r1.getKey()
            java.lang.Object r1 = r5.get(r1)
            boolean r1 = h(r2, r1)
            if (r1 != 0) goto L_0x0018
            return r3
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MapFieldLite.j(java.util.Map, java.util.Map):boolean");
    }

    public void clear() {
        e();
        super.clear();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && j(this, (Map) obj);
    }

    public int hashCode() {
        return a(this);
    }

    public boolean k() {
        return this.isMutable;
    }

    public void l() {
        this.isMutable = false;
    }

    public void o(MapFieldLite<K, V> mapFieldLite) {
        e();
        if (!mapFieldLite.isEmpty()) {
            putAll(mapFieldLite);
        }
    }

    public MapFieldLite<K, V> p() {
        return isEmpty() ? new MapFieldLite<>() : new MapFieldLite<>(this);
    }

    public V put(K k10, V v10) {
        e();
        w.a(k10);
        w.a(v10);
        return super.put(k10, v10);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        e();
        c(map);
        super.putAll(map);
    }

    public V remove(Object obj) {
        e();
        return super.remove(obj);
    }

    private MapFieldLite(Map<K, V> map) {
        super(map);
    }
}
