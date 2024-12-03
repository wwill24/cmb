package com.squareup.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<Comparable> f22884a = new a();
    final Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.defpackage.d entrySet;
    final g<K, V> header;
    private LinkedHashTreeMap<K, V>.defpackage.e keySet;
    int modCount;
    int size;
    g<K, V>[] table;
    int threshold;

    class a implements Comparator<Comparable> {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    static final class b<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private g<K, V> f22885a;

        /* renamed from: b  reason: collision with root package name */
        private int f22886b;

        /* renamed from: c  reason: collision with root package name */
        private int f22887c;

        /* renamed from: d  reason: collision with root package name */
        private int f22888d;

        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(g<K, V> gVar) {
            gVar.f22900c = null;
            gVar.f22898a = null;
            gVar.f22899b = null;
            gVar.f22906j = 1;
            int i10 = this.f22886b;
            if (i10 > 0) {
                int i11 = this.f22888d;
                if ((i11 & 1) == 0) {
                    this.f22888d = i11 + 1;
                    this.f22886b = i10 - 1;
                    this.f22887c++;
                }
            }
            gVar.f22898a = this.f22885a;
            this.f22885a = gVar;
            int i12 = this.f22888d + 1;
            this.f22888d = i12;
            int i13 = this.f22886b;
            if (i13 > 0 && (i12 & 1) == 0) {
                this.f22888d = i12 + 1;
                this.f22886b = i13 - 1;
                this.f22887c++;
            }
            int i14 = 4;
            while (true) {
                int i15 = i14 - 1;
                if ((this.f22888d & i15) == i15) {
                    int i16 = this.f22887c;
                    if (i16 == 0) {
                        g<K, V> gVar2 = this.f22885a;
                        g<K, V> gVar3 = gVar2.f22898a;
                        g<K, V> gVar4 = gVar3.f22898a;
                        gVar3.f22898a = gVar4.f22898a;
                        this.f22885a = gVar3;
                        gVar3.f22899b = gVar4;
                        gVar3.f22900c = gVar2;
                        gVar3.f22906j = gVar2.f22906j + 1;
                        gVar4.f22898a = gVar3;
                        gVar2.f22898a = gVar3;
                    } else if (i16 == 1) {
                        g<K, V> gVar5 = this.f22885a;
                        g<K, V> gVar6 = gVar5.f22898a;
                        this.f22885a = gVar6;
                        gVar6.f22900c = gVar5;
                        gVar6.f22906j = gVar5.f22906j + 1;
                        gVar5.f22898a = gVar6;
                        this.f22887c = 0;
                    } else if (i16 == 2) {
                        this.f22887c = 0;
                    }
                    i14 *= 2;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i10) {
            this.f22886b = ((Integer.highestOneBit(i10) * 2) - 1) - i10;
            this.f22888d = 0;
            this.f22887c = 0;
            this.f22885a = null;
        }

        /* access modifiers changed from: package-private */
        public g<K, V> c() {
            g<K, V> gVar = this.f22885a;
            if (gVar.f22898a == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    static class c<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private g<K, V> f22889a;

        c() {
        }

        public g<K, V> a() {
            g<K, V> gVar = this.f22889a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.f22898a;
            gVar.f22898a = null;
            g<K, V> gVar3 = gVar.f22900c;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                g<K, V> gVar5 = gVar4;
                if (gVar2 != null) {
                    gVar2.f22898a = gVar5;
                    gVar3 = gVar2.f22899b;
                } else {
                    this.f22889a = gVar5;
                    return gVar;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (gVar != null) {
                gVar.f22898a = gVar2;
                gVar2 = gVar;
                gVar = gVar.f22899b;
            }
            this.f22889a = gVar2;
        }
    }

    final class d extends AbstractSet<Map.Entry<K, V>> {

        class a extends LinkedHashTreeMap<K, V>.defpackage.f<Map.Entry<K, V>> {
            a() {
                super();
            }

            /* renamed from: c */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        d() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.e((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            g e10;
            if (!(obj instanceof Map.Entry) || (e10 = LinkedHashTreeMap.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.h(e10, true);
            return true;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    final class e extends AbstractSet<K> {

        class a extends LinkedHashTreeMap<K, V>.defpackage.f<K> {
            a() {
                super();
            }

            public K next() {
                return a().f22903f;
            }
        }

        e() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.j(obj) != null;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    abstract class f<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        g<K, V> f22894a;

        /* renamed from: b  reason: collision with root package name */
        g<K, V> f22895b = null;

        /* renamed from: c  reason: collision with root package name */
        int f22896c;

        f() {
            this.f22894a = LinkedHashTreeMap.this.header.f22901d;
            this.f22896c = LinkedHashTreeMap.this.modCount;
        }

        /* access modifiers changed from: package-private */
        public final g<K, V> a() {
            g<K, V> gVar = this.f22894a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (gVar == linkedHashTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedHashTreeMap.modCount == this.f22896c) {
                this.f22894a = gVar.f22901d;
                this.f22895b = gVar;
                return gVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            return this.f22894a != LinkedHashTreeMap.this.header;
        }

        public final void remove() {
            g<K, V> gVar = this.f22895b;
            if (gVar != null) {
                LinkedHashTreeMap.this.h(gVar, true);
                this.f22895b = null;
                this.f22896c = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static {
        Class<LinkedHashTreeMap> cls = LinkedHashTreeMap.class;
    }

    LinkedHashTreeMap() {
        this((Comparator) null);
    }

    private void a() {
        g<K, V>[] b10 = b(this.table);
        this.table = b10;
        this.threshold = (b10.length / 2) + (b10.length / 4);
    }

    static <K, V> g<K, V>[] b(g<K, V>[] gVarArr) {
        g<K, V> gVar;
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[(length * 2)];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i10 = 0; i10 < length; i10++) {
            g<K, V> gVar2 = gVarArr[i10];
            if (gVar2 != null) {
                cVar.b(gVar2);
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    g a10 = cVar.a();
                    if (a10 == null) {
                        break;
                    } else if ((a10.f22904g & length) == 0) {
                        i11++;
                    } else {
                        i12++;
                    }
                }
                bVar.b(i11);
                bVar2.b(i12);
                cVar.b(gVar2);
                while (true) {
                    g a11 = cVar.a();
                    if (a11 == null) {
                        break;
                    } else if ((a11.f22904g & length) == 0) {
                        bVar.a(a11);
                    } else {
                        bVar2.a(a11);
                    }
                }
                g<K, V> gVar3 = null;
                if (i11 > 0) {
                    gVar = bVar.c();
                } else {
                    gVar = null;
                }
                gVarArr2[i10] = gVar;
                int i13 = i10 + length;
                if (i12 > 0) {
                    gVar3 = bVar2.c();
                }
                gVarArr2[i13] = gVar3;
            }
        }
        return gVarArr2;
    }

    private boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void g(g<K, V> gVar, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        while (gVar != null) {
            g<K, V> gVar2 = gVar.f22899b;
            g<K, V> gVar3 = gVar.f22900c;
            int i14 = 0;
            if (gVar2 != null) {
                i10 = gVar2.f22906j;
            } else {
                i10 = 0;
            }
            if (gVar3 != null) {
                i11 = gVar3.f22906j;
            } else {
                i11 = 0;
            }
            int i15 = i10 - i11;
            if (i15 == -2) {
                g<K, V> gVar4 = gVar3.f22899b;
                g<K, V> gVar5 = gVar3.f22900c;
                if (gVar5 != null) {
                    i13 = gVar5.f22906j;
                } else {
                    i13 = 0;
                }
                if (gVar4 != null) {
                    i14 = gVar4.f22906j;
                }
                int i16 = i14 - i13;
                if (i16 != -1 && (i16 != 0 || z10)) {
                    m(gVar3);
                }
                l(gVar);
                if (z10) {
                    return;
                }
            } else if (i15 == 2) {
                g<K, V> gVar6 = gVar2.f22899b;
                g<K, V> gVar7 = gVar2.f22900c;
                if (gVar7 != null) {
                    i12 = gVar7.f22906j;
                } else {
                    i12 = 0;
                }
                if (gVar6 != null) {
                    i14 = gVar6.f22906j;
                }
                int i17 = i14 - i12;
                if (i17 != 1 && (i17 != 0 || z10)) {
                    l(gVar2);
                }
                m(gVar);
                if (z10) {
                    return;
                }
            } else if (i15 == 0) {
                gVar.f22906j = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                gVar.f22906j = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            gVar = gVar.f22898a;
        }
    }

    private void k(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.f22898a;
        gVar.f22898a = null;
        if (gVar2 != null) {
            gVar2.f22898a = gVar3;
        }
        if (gVar3 == null) {
            int i10 = gVar.f22904g;
            g<K, V>[] gVarArr = this.table;
            gVarArr[i10 & (gVarArr.length - 1)] = gVar2;
        } else if (gVar3.f22899b == gVar) {
            gVar3.f22899b = gVar2;
        } else {
            gVar3.f22900c = gVar2;
        }
    }

    private void l(g<K, V> gVar) {
        int i10;
        int i11;
        g<K, V> gVar2 = gVar.f22899b;
        g<K, V> gVar3 = gVar.f22900c;
        g<K, V> gVar4 = gVar3.f22899b;
        g<K, V> gVar5 = gVar3.f22900c;
        gVar.f22900c = gVar4;
        if (gVar4 != null) {
            gVar4.f22898a = gVar;
        }
        k(gVar, gVar3);
        gVar3.f22899b = gVar;
        gVar.f22898a = gVar3;
        int i12 = 0;
        if (gVar2 != null) {
            i10 = gVar2.f22906j;
        } else {
            i10 = 0;
        }
        if (gVar4 != null) {
            i11 = gVar4.f22906j;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        gVar.f22906j = max;
        if (gVar5 != null) {
            i12 = gVar5.f22906j;
        }
        gVar3.f22906j = Math.max(max, i12) + 1;
    }

    private void m(g<K, V> gVar) {
        int i10;
        int i11;
        g<K, V> gVar2 = gVar.f22899b;
        g<K, V> gVar3 = gVar.f22900c;
        g<K, V> gVar4 = gVar2.f22899b;
        g<K, V> gVar5 = gVar2.f22900c;
        gVar.f22899b = gVar5;
        if (gVar5 != null) {
            gVar5.f22898a = gVar;
        }
        k(gVar, gVar2);
        gVar2.f22900c = gVar;
        gVar.f22898a = gVar2;
        int i12 = 0;
        if (gVar3 != null) {
            i10 = gVar3.f22906j;
        } else {
            i10 = 0;
        }
        if (gVar5 != null) {
            i11 = gVar5.f22906j;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        gVar.f22906j = max;
        if (gVar4 != null) {
            i12 = gVar4.f22906j;
        }
        gVar2.f22906j = Math.max(max, i12) + 1;
    }

    private static int n(int i10) {
        int i11 = i10 ^ ((i10 >>> 20) ^ (i10 >>> 12));
        return (i11 >>> 4) ^ ((i11 >>> 7) ^ i11);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        g<K, V> gVar = this.header;
        g<K, V> gVar2 = gVar.f22901d;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.f22901d;
            gVar2.f22902e = null;
            gVar2.f22901d = null;
            gVar2 = gVar3;
        }
        gVar.f22902e = gVar;
        gVar.f22901d = gVar;
    }

    public boolean containsKey(Object obj) {
        return f(obj) != null;
    }

    /* access modifiers changed from: package-private */
    public g<K, V> d(K k10, boolean z10) {
        int i10;
        g<K, V> gVar;
        Comparable comparable;
        g<K, V> gVar2;
        Comparator<? super K> comparator2 = this.comparator;
        g<K, V>[] gVarArr = this.table;
        int n10 = n(k10.hashCode());
        int length = (gVarArr.length - 1) & n10;
        g<K, V> gVar3 = gVarArr[length];
        if (gVar3 != null) {
            if (comparator2 == f22884a) {
                comparable = (Comparable) k10;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i10 = comparable.compareTo(gVar3.f22903f);
                } else {
                    i10 = comparator2.compare(k10, gVar3.f22903f);
                }
                if (i10 == 0) {
                    return gVar3;
                }
                if (i10 < 0) {
                    gVar2 = gVar3.f22899b;
                } else {
                    gVar2 = gVar3.f22900c;
                }
                if (gVar2 == null) {
                    break;
                }
                gVar3 = gVar2;
            }
        } else {
            i10 = 0;
        }
        g<K, V> gVar4 = gVar3;
        int i11 = i10;
        if (!z10) {
            return null;
        }
        g<K, V> gVar5 = this.header;
        if (gVar4 != null) {
            gVar = new g<>(gVar4, k10, n10, gVar5, gVar5.f22902e);
            if (i11 < 0) {
                gVar4.f22899b = gVar;
            } else {
                gVar4.f22900c = gVar;
            }
            g(gVar4, true);
        } else if (comparator2 != f22884a || (k10 instanceof Comparable)) {
            gVar = new g<>(gVar4, k10, n10, gVar5, gVar5.f22902e);
            gVarArr[length] = gVar;
        } else {
            throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
        }
        int i12 = this.size;
        this.size = i12 + 1;
        if (i12 > this.threshold) {
            a();
        }
        this.modCount++;
        return gVar;
    }

    /* access modifiers changed from: package-private */
    public g<K, V> e(Map.Entry<?, ?> entry) {
        boolean z10;
        g<K, V> f10 = f(entry.getKey());
        if (f10 == null || !c(f10.f22905h, entry.getValue())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return f10;
        }
        return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.defpackage.d dVar = this.entrySet;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.defpackage.d dVar2 = new d();
        this.entrySet = dVar2;
        return dVar2;
    }

    /* access modifiers changed from: package-private */
    public g<K, V> f(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return d(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public V get(Object obj) {
        g f10 = f(obj);
        if (f10 != null) {
            return f10.f22905h;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void h(g<K, V> gVar, boolean z10) {
        g<K, V> gVar2;
        int i10;
        if (z10) {
            g<K, V> gVar3 = gVar.f22902e;
            gVar3.f22901d = gVar.f22901d;
            gVar.f22901d.f22902e = gVar3;
            gVar.f22902e = null;
            gVar.f22901d = null;
        }
        g<K, V> gVar4 = gVar.f22899b;
        g<K, V> gVar5 = gVar.f22900c;
        g<K, V> gVar6 = gVar.f22898a;
        int i11 = 0;
        if (gVar4 == null || gVar5 == null) {
            if (gVar4 != null) {
                k(gVar, gVar4);
                gVar.f22899b = null;
            } else if (gVar5 != null) {
                k(gVar, gVar5);
                gVar.f22900c = null;
            } else {
                k(gVar, (g<K, V>) null);
            }
            g(gVar6, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (gVar4.f22906j > gVar5.f22906j) {
            gVar2 = gVar4.b();
        } else {
            gVar2 = gVar5.a();
        }
        h(gVar2, false);
        g<K, V> gVar7 = gVar.f22899b;
        if (gVar7 != null) {
            i10 = gVar7.f22906j;
            gVar2.f22899b = gVar7;
            gVar7.f22898a = gVar2;
            gVar.f22899b = null;
        } else {
            i10 = 0;
        }
        g<K, V> gVar8 = gVar.f22900c;
        if (gVar8 != null) {
            i11 = gVar8.f22906j;
            gVar2.f22900c = gVar8;
            gVar8.f22898a = gVar2;
            gVar.f22900c = null;
        }
        gVar2.f22906j = Math.max(i10, i11) + 1;
        k(gVar, gVar2);
    }

    /* access modifiers changed from: package-private */
    public g<K, V> j(Object obj) {
        g<K, V> f10 = f(obj);
        if (f10 != null) {
            h(f10, true);
        }
        return f10;
    }

    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.defpackage.e eVar = this.keySet;
        if (eVar != null) {
            return eVar;
        }
        LinkedHashTreeMap<K, V>.defpackage.e eVar2 = new e();
        this.keySet = eVar2;
        return eVar2;
    }

    public V put(K k10, V v10) {
        if (k10 != null) {
            g d10 = d(k10, true);
            V v11 = d10.f22905h;
            d10.f22905h = v10;
            return v11;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object obj) {
        g j10 = j(obj);
        if (j10 != null) {
            return j10.f22905h;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    LinkedHashTreeMap(Comparator<? super K> comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator2 == null ? f22884a : comparator2;
        this.header = new g<>();
        g<K, V>[] gVarArr = new g[16];
        this.table = gVarArr;
        this.threshold = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    static final class g<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        g<K, V> f22898a;

        /* renamed from: b  reason: collision with root package name */
        g<K, V> f22899b;

        /* renamed from: c  reason: collision with root package name */
        g<K, V> f22900c;

        /* renamed from: d  reason: collision with root package name */
        g<K, V> f22901d;

        /* renamed from: e  reason: collision with root package name */
        g<K, V> f22902e;

        /* renamed from: f  reason: collision with root package name */
        final K f22903f;

        /* renamed from: g  reason: collision with root package name */
        final int f22904g;

        /* renamed from: h  reason: collision with root package name */
        V f22905h;

        /* renamed from: j  reason: collision with root package name */
        int f22906j;

        g() {
            this.f22903f = null;
            this.f22904g = -1;
            this.f22902e = this;
            this.f22901d = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f22899b; gVar2 != null; gVar2 = gVar2.f22899b) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f22900c; gVar2 != null; gVar2 = gVar2.f22900c) {
                gVar = gVar2;
            }
            return gVar;
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
                K r0 = r3.f22903f
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.f22905h
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
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.LinkedHashTreeMap.g.equals(java.lang.Object):boolean");
        }

        public K getKey() {
            return this.f22903f;
        }

        public V getValue() {
            return this.f22905h;
        }

        public int hashCode() {
            K k10 = this.f22903f;
            int i10 = 0;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f22905h;
            if (v10 != null) {
                i10 = v10.hashCode();
            }
            return hashCode ^ i10;
        }

        public V setValue(V v10) {
            V v11 = this.f22905h;
            this.f22905h = v10;
            return v11;
        }

        public String toString() {
            return this.f22903f + "=" + this.f22905h;
        }

        g(g<K, V> gVar, K k10, int i10, g<K, V> gVar2, g<K, V> gVar3) {
            this.f22898a = gVar;
            this.f22903f = k10;
            this.f22904g = i10;
            this.f22906j = 1;
            this.f22901d = gVar2;
            this.f22902e = gVar3;
            gVar3.f22901d = this;
            gVar2.f22902e = this;
        }
    }
}
