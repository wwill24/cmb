package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.e0;
import java.util.Map;

class g0 implements f0 {
    g0() {
    }

    private static <K, V> int i(int i10, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        e0 e0Var = (e0) obj2;
        int i11 = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : mapFieldLite.entrySet()) {
            i11 += e0Var.a(i10, entry.getKey(), entry.getValue());
        }
        return i11;
    }

    private static <K, V> MapFieldLite<K, V> j(Object obj, Object obj2) {
        MapFieldLite<K, V> mapFieldLite = (MapFieldLite) obj;
        MapFieldLite mapFieldLite2 = (MapFieldLite) obj2;
        if (!mapFieldLite2.isEmpty()) {
            if (!mapFieldLite.k()) {
                mapFieldLite = mapFieldLite.p();
            }
            mapFieldLite.o(mapFieldLite2);
        }
        return mapFieldLite;
    }

    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    public e0.a<?, ?> b(Object obj) {
        return ((e0) obj).c();
    }

    public Map<?, ?> c(Object obj) {
        return (MapFieldLite) obj;
    }

    public Object d(Object obj) {
        return MapFieldLite.d().p();
    }

    public Map<?, ?> e(Object obj) {
        return (MapFieldLite) obj;
    }

    public Object f(Object obj) {
        ((MapFieldLite) obj).l();
        return obj;
    }

    public int g(int i10, Object obj, Object obj2) {
        return i(i10, obj, obj2);
    }

    public boolean h(Object obj) {
        return !((MapFieldLite) obj).k();
    }
}
