package m3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m3.l;

class g<K extends l, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f16286a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f16287b = new HashMap();

    private static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f16288a;

        /* renamed from: b  reason: collision with root package name */
        private List<V> f16289b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f16290c;

        /* renamed from: d  reason: collision with root package name */
        a<K, V> f16291d;

        a() {
            this((Object) null);
        }

        public void a(V v10) {
            if (this.f16289b == null) {
                this.f16289b = new ArrayList();
            }
            this.f16289b.add(v10);
        }

        public V b() {
            int c10 = c();
            if (c10 > 0) {
                return this.f16289b.remove(c10 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f16289b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k10) {
            this.f16291d = this;
            this.f16290c = this;
            this.f16288a = k10;
        }
    }

    g() {
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f16286a;
        aVar.f16291d = aVar2;
        aVar.f16290c = aVar2.f16290c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f16286a;
        aVar.f16291d = aVar2.f16291d;
        aVar.f16290c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f16291d;
        aVar2.f16290c = aVar.f16290c;
        aVar.f16290c.f16291d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f16290c.f16291d = aVar;
        aVar.f16291d.f16290c = aVar;
    }

    public V a(K k10) {
        a aVar = this.f16287b.get(k10);
        if (aVar == null) {
            aVar = new a(k10);
            this.f16287b.put(k10, aVar);
        } else {
            k10.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k10, V v10) {
        a aVar = this.f16287b.get(k10);
        if (aVar == null) {
            aVar = new a(k10);
            c(aVar);
            this.f16287b.put(k10, aVar);
        } else {
            k10.a();
        }
        aVar.a(v10);
    }

    public V f() {
        for (a<K, V> aVar = this.f16286a.f16291d; !aVar.equals(this.f16286a); aVar = aVar.f16291d) {
            V b10 = aVar.b();
            if (b10 != null) {
                return b10;
            }
            e(aVar);
            this.f16287b.remove(aVar.f16288a);
            ((l) aVar.f16288a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        boolean z10 = false;
        for (a<K, V> aVar = this.f16286a.f16290c; !aVar.equals(this.f16286a); aVar = aVar.f16290c) {
            z10 = true;
            sb2.append('{');
            sb2.append(aVar.f16288a);
            sb2.append(':');
            sb2.append(aVar.c());
            sb2.append("}, ");
        }
        if (z10) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }
}
