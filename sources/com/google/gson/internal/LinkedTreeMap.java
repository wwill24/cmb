package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<Comparable> f21310a = new a();
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.defpackage.b entrySet;
    final e<K, V> header;
    private LinkedTreeMap<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    class a implements Comparator<Comparable> {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet<Map.Entry<K, V>> {

        class a extends LinkedTreeMap<K, V>.defpackage.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            /* renamed from: c */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.c((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            e c10;
            if (!(obj instanceof Map.Entry) || (c10 = LinkedTreeMap.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.f(c10, true);
            return true;
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    final class c extends AbstractSet<K> {

        class a extends LinkedTreeMap<K, V>.defpackage.d<K> {
            a() {
                super();
            }

            public K next() {
                return a().f21324f;
            }
        }

        c() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            return LinkedTreeMap.this.g(obj) != null;
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    private abstract class d<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        e<K, V> f21315a;

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f21316b = null;

        /* renamed from: c  reason: collision with root package name */
        int f21317c;

        d() {
            this.f21315a = LinkedTreeMap.this.header.f21322d;
            this.f21317c = LinkedTreeMap.this.modCount;
        }

        /* access modifiers changed from: package-private */
        public final e<K, V> a() {
            e<K, V> eVar = this.f21315a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar == linkedTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedTreeMap.modCount == this.f21317c) {
                this.f21315a = eVar.f21322d;
                this.f21316b = eVar;
                return eVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            return this.f21315a != LinkedTreeMap.this.header;
        }

        public final void remove() {
            e<K, V> eVar = this.f21316b;
            if (eVar != null) {
                LinkedTreeMap.this.f(eVar, true);
                this.f21316b = null;
                this.f21317c = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static {
        Class<LinkedTreeMap> cls = LinkedTreeMap.class;
    }

    public LinkedTreeMap() {
        this(f21310a, true);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void e(e<K, V> eVar, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f21320b;
            e<K, V> eVar3 = eVar.f21321c;
            int i14 = 0;
            if (eVar2 != null) {
                i10 = eVar2.f21327j;
            } else {
                i10 = 0;
            }
            if (eVar3 != null) {
                i11 = eVar3.f21327j;
            } else {
                i11 = 0;
            }
            int i15 = i10 - i11;
            if (i15 == -2) {
                e<K, V> eVar4 = eVar3.f21320b;
                e<K, V> eVar5 = eVar3.f21321c;
                if (eVar5 != null) {
                    i13 = eVar5.f21327j;
                } else {
                    i13 = 0;
                }
                if (eVar4 != null) {
                    i14 = eVar4.f21327j;
                }
                int i16 = i14 - i13;
                if (i16 == -1 || (i16 == 0 && !z10)) {
                    j(eVar);
                } else {
                    k(eVar3);
                    j(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i15 == 2) {
                e<K, V> eVar6 = eVar2.f21320b;
                e<K, V> eVar7 = eVar2.f21321c;
                if (eVar7 != null) {
                    i12 = eVar7.f21327j;
                } else {
                    i12 = 0;
                }
                if (eVar6 != null) {
                    i14 = eVar6.f21327j;
                }
                int i17 = i14 - i12;
                if (i17 == 1 || (i17 == 0 && !z10)) {
                    k(eVar);
                } else {
                    j(eVar2);
                    k(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i15 == 0) {
                eVar.f21327j = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f21327j = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f21319a;
        }
    }

    private void h(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f21319a;
        eVar.f21319a = null;
        if (eVar2 != null) {
            eVar2.f21319a = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.f21320b == eVar) {
            eVar3.f21320b = eVar2;
        } else {
            eVar3.f21321c = eVar2;
        }
    }

    private void j(e<K, V> eVar) {
        int i10;
        int i11;
        e<K, V> eVar2 = eVar.f21320b;
        e<K, V> eVar3 = eVar.f21321c;
        e<K, V> eVar4 = eVar3.f21320b;
        e<K, V> eVar5 = eVar3.f21321c;
        eVar.f21321c = eVar4;
        if (eVar4 != null) {
            eVar4.f21319a = eVar;
        }
        h(eVar, eVar3);
        eVar3.f21320b = eVar;
        eVar.f21319a = eVar3;
        int i12 = 0;
        if (eVar2 != null) {
            i10 = eVar2.f21327j;
        } else {
            i10 = 0;
        }
        if (eVar4 != null) {
            i11 = eVar4.f21327j;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        eVar.f21327j = max;
        if (eVar5 != null) {
            i12 = eVar5.f21327j;
        }
        eVar3.f21327j = Math.max(max, i12) + 1;
    }

    private void k(e<K, V> eVar) {
        int i10;
        int i11;
        e<K, V> eVar2 = eVar.f21320b;
        e<K, V> eVar3 = eVar.f21321c;
        e<K, V> eVar4 = eVar2.f21320b;
        e<K, V> eVar5 = eVar2.f21321c;
        eVar.f21320b = eVar5;
        if (eVar5 != null) {
            eVar5.f21319a = eVar;
        }
        h(eVar, eVar2);
        eVar2.f21321c = eVar;
        eVar.f21319a = eVar2;
        int i12 = 0;
        if (eVar3 != null) {
            i10 = eVar3.f21327j;
        } else {
            i10 = 0;
        }
        if (eVar5 != null) {
            i11 = eVar5.f21327j;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        eVar.f21327j = max;
        if (eVar4 != null) {
            i12 = eVar4.f21327j;
        }
        eVar2.f21327j = Math.max(max, i12) + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    /* access modifiers changed from: package-private */
    public e<K, V> b(K k10, boolean z10) {
        int i10;
        e<K, V> eVar;
        Comparable comparable;
        e<K, V> eVar2;
        Comparator<? super K> comparator2 = this.comparator;
        e<K, V> eVar3 = this.root;
        if (eVar3 != null) {
            if (comparator2 == f21310a) {
                comparable = (Comparable) k10;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i10 = comparable.compareTo(eVar3.f21324f);
                } else {
                    i10 = comparator2.compare(k10, eVar3.f21324f);
                }
                if (i10 == 0) {
                    return eVar3;
                }
                if (i10 < 0) {
                    eVar2 = eVar3.f21320b;
                } else {
                    eVar2 = eVar3.f21321c;
                }
                if (eVar2 == null) {
                    break;
                }
                eVar3 = eVar2;
            }
        } else {
            i10 = 0;
        }
        if (!z10) {
            return null;
        }
        e<K, V> eVar4 = this.header;
        if (eVar3 != null) {
            eVar = new e<>(this.allowNullValues, eVar3, k10, eVar4, eVar4.f21323e);
            if (i10 < 0) {
                eVar3.f21320b = eVar;
            } else {
                eVar3.f21321c = eVar;
            }
            e(eVar3, true);
        } else if (comparator2 != f21310a || (k10 instanceof Comparable)) {
            eVar = new e<>(this.allowNullValues, eVar3, k10, eVar4, eVar4.f21323e);
            this.root = eVar;
        } else {
            throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public e<K, V> c(Map.Entry<?, ?> entry) {
        boolean z10;
        e<K, V> d10 = d(entry.getKey());
        if (d10 == null || !a(d10.f21326h, entry.getValue())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return d10;
        }
        return null;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f21323e = eVar;
        eVar.f21322d = eVar;
    }

    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* access modifiers changed from: package-private */
    public e<K, V> d(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.defpackage.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.defpackage.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    /* access modifiers changed from: package-private */
    public void f(e<K, V> eVar, boolean z10) {
        e<K, V> eVar2;
        int i10;
        if (z10) {
            e<K, V> eVar3 = eVar.f21323e;
            eVar3.f21322d = eVar.f21322d;
            eVar.f21322d.f21323e = eVar3;
        }
        e<K, V> eVar4 = eVar.f21320b;
        e<K, V> eVar5 = eVar.f21321c;
        e<K, V> eVar6 = eVar.f21319a;
        int i11 = 0;
        if (eVar4 == null || eVar5 == null) {
            if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f21320b = null;
            } else if (eVar5 != null) {
                h(eVar, eVar5);
                eVar.f21321c = null;
            } else {
                h(eVar, (e<K, V>) null);
            }
            e(eVar6, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (eVar4.f21327j > eVar5.f21327j) {
            eVar2 = eVar4.b();
        } else {
            eVar2 = eVar5.a();
        }
        f(eVar2, false);
        e<K, V> eVar7 = eVar.f21320b;
        if (eVar7 != null) {
            i10 = eVar7.f21327j;
            eVar2.f21320b = eVar7;
            eVar7.f21319a = eVar2;
            eVar.f21320b = null;
        } else {
            i10 = 0;
        }
        e<K, V> eVar8 = eVar.f21321c;
        if (eVar8 != null) {
            i11 = eVar8.f21327j;
            eVar2.f21321c = eVar8;
            eVar8.f21319a = eVar2;
            eVar.f21321c = null;
        }
        eVar2.f21327j = Math.max(i10, i11) + 1;
        h(eVar, eVar2);
    }

    /* access modifiers changed from: package-private */
    public e<K, V> g(Object obj) {
        e<K, V> d10 = d(obj);
        if (d10 != null) {
            f(d10, true);
        }
        return d10;
    }

    public V get(Object obj) {
        e d10 = d(obj);
        if (d10 != null) {
            return d10.f21326h;
        }
        return null;
    }

    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    public V put(K k10, V v10) {
        if (k10 == null) {
            throw new NullPointerException("key == null");
        } else if (v10 != null || this.allowNullValues) {
            e b10 = b(k10, true);
            V v11 = b10.f21326h;
            b10.f21326h = v10;
            return v11;
        } else {
            throw new NullPointerException("value == null");
        }
    }

    public V remove(Object obj) {
        e g10 = g(obj);
        if (g10 != null) {
            return g10.f21326h;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    public LinkedTreeMap(boolean z10) {
        this(f21310a, z10);
    }

    public LinkedTreeMap(Comparator<? super K> comparator2, boolean z10) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator2 == null ? f21310a : comparator2;
        this.allowNullValues = z10;
        this.header = new e<>(z10);
    }

    static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        e<K, V> f21319a;

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f21320b;

        /* renamed from: c  reason: collision with root package name */
        e<K, V> f21321c;

        /* renamed from: d  reason: collision with root package name */
        e<K, V> f21322d;

        /* renamed from: e  reason: collision with root package name */
        e<K, V> f21323e;

        /* renamed from: f  reason: collision with root package name */
        final K f21324f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f21325g;

        /* renamed from: h  reason: collision with root package name */
        V f21326h;

        /* renamed from: j  reason: collision with root package name */
        int f21327j;

        e(boolean z10) {
            this.f21324f = null;
            this.f21325g = z10;
            this.f21323e = this;
            this.f21322d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f21320b; eVar2 != null; eVar2 = eVar2.f21320b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f21321c; eVar2 != null; eVar2 = eVar2.f21321c) {
                eVar = eVar2;
            }
            return eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.f21324f
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.f21326h
                if (r0 != 0) goto L_0x0027
                java.lang.Object r4 = r4.getValue()
                if (r4 != 0) goto L_0x0032
                goto L_0x0031
            L_0x0027:
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0032
            L_0x0031:
                r1 = 1
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.e.equals(java.lang.Object):boolean");
        }

        public K getKey() {
            return this.f21324f;
        }

        public V getValue() {
            return this.f21326h;
        }

        public int hashCode() {
            int i10;
            K k10 = this.f21324f;
            int i11 = 0;
            if (k10 == null) {
                i10 = 0;
            } else {
                i10 = k10.hashCode();
            }
            V v10 = this.f21326h;
            if (v10 != null) {
                i11 = v10.hashCode();
            }
            return i10 ^ i11;
        }

        public V setValue(V v10) {
            if (v10 != null || this.f21325g) {
                V v11 = this.f21326h;
                this.f21326h = v10;
                return v11;
            }
            throw new NullPointerException("value == null");
        }

        public String toString() {
            return this.f21324f + "=" + this.f21326h;
        }

        e(boolean z10, e<K, V> eVar, K k10, e<K, V> eVar2, e<K, V> eVar3) {
            this.f21319a = eVar;
            this.f21324f = k10;
            this.f21325g = z10;
            this.f21327j = 1;
            this.f21322d = eVar2;
            this.f21323e = eVar3;
            eVar3.f21322d = this;
            eVar2.f21323e = this;
        }
    }
}
