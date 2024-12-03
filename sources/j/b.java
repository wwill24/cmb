package j;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f15528a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f15529b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakHashMap<f<K, V>, Boolean> f15530c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f15531d = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f15535d;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> d(c<K, V> cVar) {
            return cVar.f15534c;
        }
    }

    /* renamed from: j.b$b  reason: collision with other inner class name */
    private static class C0163b<K, V> extends e<K, V> {
        C0163b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f15534c;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> d(c<K, V> cVar) {
            return cVar.f15535d;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final K f15532a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        final V f15533b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f15534c;

        /* renamed from: d  reason: collision with root package name */
        c<K, V> f15535d;

        c(@NonNull K k10, @NonNull V v10) {
            this.f15532a = k10;
            this.f15533b = v10;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f15532a.equals(cVar.f15532a) || !this.f15533b.equals(cVar.f15533b)) {
                return false;
            }
            return true;
        }

        @NonNull
        public K getKey() {
            return this.f15532a;
        }

        @NonNull
        public V getValue() {
            return this.f15533b;
        }

        public int hashCode() {
            return this.f15532a.hashCode() ^ this.f15533b.hashCode();
        }

        public V setValue(V v10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f15532a + "=" + this.f15533b;
        }
    }

    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private c<K, V> f15536a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f15537b = true;

        d() {
        }

        /* access modifiers changed from: package-private */
        public void a(@NonNull c<K, V> cVar) {
            boolean z10;
            c<K, V> cVar2 = this.f15536a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f15535d;
                this.f15536a = cVar3;
                if (cVar3 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f15537b = z10;
            }
        }

        /* renamed from: c */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f15537b) {
                this.f15537b = false;
                this.f15536a = b.this.f15528a;
            } else {
                c<K, V> cVar2 = this.f15536a;
                if (cVar2 != null) {
                    cVar = cVar2.f15534c;
                } else {
                    cVar = null;
                }
                this.f15536a = cVar;
            }
            return this.f15536a;
        }

        public boolean hasNext() {
            if (!this.f15537b) {
                c<K, V> cVar = this.f15536a;
                if (cVar == null || cVar.f15534c == null) {
                    return false;
                }
                return true;
            } else if (b.this.f15528a != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f15539a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f15540b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f15539a = cVar2;
            this.f15540b = cVar;
        }

        private c<K, V> f() {
            c<K, V> cVar = this.f15540b;
            c<K, V> cVar2 = this.f15539a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        public void a(@NonNull c<K, V> cVar) {
            if (this.f15539a == cVar && cVar == this.f15540b) {
                this.f15540b = null;
                this.f15539a = null;
            }
            c<K, V> cVar2 = this.f15539a;
            if (cVar2 == cVar) {
                this.f15539a = c(cVar2);
            }
            if (this.f15540b == cVar) {
                this.f15540b = f();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract c<K, V> c(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> d(c<K, V> cVar);

        /* renamed from: e */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f15540b;
            this.f15540b = f();
            return cVar;
        }

        public boolean hasNext() {
            return this.f15540b != null;
        }
    }

    public static abstract class f<K, V> {
        /* access modifiers changed from: package-private */
        public abstract void a(@NonNull c<K, V> cVar);
    }

    public Map.Entry<K, V> b() {
        return this.f15528a;
    }

    /* access modifiers changed from: protected */
    public c<K, V> d(K k10) {
        c<K, V> cVar = this.f15528a;
        while (cVar != null && !cVar.f15532a.equals(k10)) {
            cVar = cVar.f15534c;
        }
        return cVar;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0163b bVar = new C0163b(this.f15529b, this.f15528a);
        this.f15530c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    @NonNull
    public b<K, V>.defpackage.d f() {
        b<K, V>.defpackage.d dVar = new d();
        this.f15530c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> g() {
        return this.f15529b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((Map.Entry) it.next()).hashCode();
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public c<K, V> i(@NonNull K k10, @NonNull V v10) {
        c<K, V> cVar = new c<>(k10, v10);
        this.f15531d++;
        c<K, V> cVar2 = this.f15529b;
        if (cVar2 == null) {
            this.f15528a = cVar;
            this.f15529b = cVar;
            return cVar;
        }
        cVar2.f15534c = cVar;
        cVar.f15535d = cVar2;
        this.f15529b = cVar;
        return cVar;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f15528a, this.f15529b);
        this.f15530c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V j(@NonNull K k10, @NonNull V v10) {
        c d10 = d(k10);
        if (d10 != null) {
            return d10.f15533b;
        }
        i(k10, v10);
        return null;
    }

    public V m(@NonNull K k10) {
        c d10 = d(k10);
        if (d10 == null) {
            return null;
        }
        this.f15531d--;
        if (!this.f15530c.isEmpty()) {
            for (f<K, V> a10 : this.f15530c.keySet()) {
                a10.a(d10);
            }
        }
        c<K, V> cVar = d10.f15535d;
        if (cVar != null) {
            cVar.f15534c = d10.f15534c;
        } else {
            this.f15528a = d10.f15534c;
        }
        c<K, V> cVar2 = d10.f15534c;
        if (cVar2 != null) {
            cVar2.f15535d = cVar;
        } else {
            this.f15529b = cVar;
        }
        d10.f15534c = null;
        d10.f15535d = null;
        return d10.f15533b;
    }

    public int size() {
        return this.f15531d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb2.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
