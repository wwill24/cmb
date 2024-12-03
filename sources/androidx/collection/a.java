package androidx.collection;

import androidx.annotation.NonNull;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: h  reason: collision with root package name */
    a<K, V>.defpackage.a f3563h;

    /* renamed from: j  reason: collision with root package name */
    a<K, V>.c f3564j;

    /* renamed from: k  reason: collision with root package name */
    a<K, V>.defpackage.e f3565k;

    /* renamed from: androidx.collection.a$a  reason: collision with other inner class name */
    final class C0026a extends AbstractSet<Map.Entry<K, V>> {
        C0026a() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public int size() {
            return a.this.f3602c;
        }
    }

    final class b extends d<K> {
        b() {
            super(a.this.f3602c);
        }

        /* access modifiers changed from: protected */
        public K a(int i10) {
            return a.this.j(i10);
        }

        /* access modifiers changed from: protected */
        public void c(int i10) {
            a.this.l(i10);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        int f3569a;

        /* renamed from: b  reason: collision with root package name */
        int f3570b = -1;

        /* renamed from: c  reason: collision with root package name */
        boolean f3571c;

        d() {
            this.f3569a = a.this.f3602c - 1;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f3570b++;
                this.f3571c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.f3571c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!c.c(entry.getKey(), a.this.j(this.f3570b)) || !c.c(entry.getValue(), a.this.n(this.f3570b))) {
                    return false;
                }
                return true;
            }
        }

        public K getKey() {
            if (this.f3571c) {
                return a.this.j(this.f3570b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f3571c) {
                return a.this.n(this.f3570b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f3570b < this.f3569a;
        }

        public int hashCode() {
            int i10;
            if (this.f3571c) {
                Object j10 = a.this.j(this.f3570b);
                Object n10 = a.this.n(this.f3570b);
                int i11 = 0;
                if (j10 == null) {
                    i10 = 0;
                } else {
                    i10 = j10.hashCode();
                }
                if (n10 != null) {
                    i11 = n10.hashCode();
                }
                return i10 ^ i11;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f3571c) {
                a.this.l(this.f3570b);
                this.f3570b--;
                this.f3569a--;
                this.f3571c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v10) {
            if (this.f3571c) {
                return a.this.m(this.f3570b, v10);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class f extends d<V> {
        f() {
            super(a.this.f3602c);
        }

        /* access modifiers changed from: protected */
        public V a(int i10) {
            return a.this.n(i10);
        }

        /* access modifiers changed from: protected */
        public void c(int i10) {
            a.this.l(i10);
        }
    }

    public a() {
    }

    static <T> boolean p(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @NonNull
    public Set<Map.Entry<K, V>> entrySet() {
        a<K, V>.defpackage.a aVar = this.f3563h;
        if (aVar != null) {
            return aVar;
        }
        a<K, V>.defpackage.a aVar2 = new C0026a();
        this.f3563h = aVar2;
        return aVar2;
    }

    @NonNull
    public Set<K> keySet() {
        a<K, V>.c cVar = this.f3564j;
        if (cVar != null) {
            return cVar;
        }
        a<K, V>.c cVar2 = new c();
        this.f3564j = cVar2;
        return cVar2;
    }

    public boolean o(@NonNull Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public void putAll(@NonNull Map<? extends K, ? extends V> map) {
        c(this.f3602c + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean q(@NonNull Collection<?> collection) {
        int i10 = this.f3602c;
        for (Object remove : collection) {
            remove(remove);
        }
        if (i10 != this.f3602c) {
            return true;
        }
        return false;
    }

    public boolean r(@NonNull Collection<?> collection) {
        int i10 = this.f3602c;
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (!collection.contains(j(i11))) {
                l(i11);
            }
        }
        if (i10 != this.f3602c) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public <T> T[] s(T[] tArr, int i10) {
        int i11 = this.f3602c;
        if (tArr.length < i11) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i11);
        }
        for (int i12 = 0; i12 < i11; i12++) {
            tArr[i12] = this.f3601b[(i12 << 1) + i10];
        }
        if (tArr.length > i11) {
            tArr[i11] = null;
        }
        return tArr;
    }

    @NonNull
    public Collection<V> values() {
        a<K, V>.defpackage.e eVar = this.f3565k;
        if (eVar != null) {
            return eVar;
        }
        a<K, V>.defpackage.e eVar2 = new e();
        this.f3565k = eVar2;
        return eVar2;
    }

    public a(int i10) {
        super(i10);
    }

    final class c implements Set<K> {
        c() {
        }

        public boolean add(K k10) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            a.this.clear();
        }

        public boolean contains(Object obj) {
            return a.this.containsKey(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return a.this.o(collection);
        }

        public boolean equals(Object obj) {
            return a.p(this, obj);
        }

        public int hashCode() {
            int i10;
            int i11 = 0;
            for (int i12 = a.this.f3602c - 1; i12 >= 0; i12--) {
                Object j10 = a.this.j(i12);
                if (j10 == null) {
                    i10 = 0;
                } else {
                    i10 = j10.hashCode();
                }
                i11 += i10;
            }
            return i11;
        }

        public boolean isEmpty() {
            return a.this.isEmpty();
        }

        public Iterator<K> iterator() {
            return new b();
        }

        public boolean remove(Object obj) {
            int f10 = a.this.f(obj);
            if (f10 < 0) {
                return false;
            }
            a.this.l(f10);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return a.this.q(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return a.this.r(collection);
        }

        public int size() {
            return a.this.f3602c;
        }

        public Object[] toArray() {
            int i10 = a.this.f3602c;
            Object[] objArr = new Object[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                objArr[i11] = a.this.j(i11);
            }
            return objArr;
        }

        public <T> T[] toArray(T[] tArr) {
            return a.this.s(tArr, 0);
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        public boolean add(V v10) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            a.this.clear();
        }

        public boolean contains(Object obj) {
            return a.this.h(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return a.this.isEmpty();
        }

        public Iterator<V> iterator() {
            return new f();
        }

        public boolean remove(Object obj) {
            int h10 = a.this.h(obj);
            if (h10 < 0) {
                return false;
            }
            a.this.l(h10);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i10 = a.this.f3602c;
            int i11 = 0;
            boolean z10 = false;
            while (i11 < i10) {
                if (collection.contains(a.this.n(i11))) {
                    a.this.l(i11);
                    i11--;
                    i10--;
                    z10 = true;
                }
                i11++;
            }
            return z10;
        }

        public boolean retainAll(Collection<?> collection) {
            int i10 = a.this.f3602c;
            int i11 = 0;
            boolean z10 = false;
            while (i11 < i10) {
                if (!collection.contains(a.this.n(i11))) {
                    a.this.l(i11);
                    i11--;
                    i10--;
                    z10 = true;
                }
                i11++;
            }
            return z10;
        }

        public int size() {
            return a.this.f3602c;
        }

        public Object[] toArray() {
            int i10 = a.this.f3602c;
            Object[] objArr = new Object[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                objArr[i11] = a.this.n(i11);
            }
            return objArr;
        }

        public <T> T[] toArray(T[] tArr) {
            return a.this.s(tArr, 1);
        }
    }

    public a(g gVar) {
        super(gVar);
    }
}
