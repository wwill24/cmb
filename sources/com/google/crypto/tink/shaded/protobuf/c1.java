package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.t;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class c1<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final int f20751a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<c1<K, V>.defpackage.e> f20752b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Map<K, V> f20753c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20754d;

    /* renamed from: e  reason: collision with root package name */
    private volatile c1<K, V>.defpackage.g f20755e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<K, V> f20756f;

    /* renamed from: g  reason: collision with root package name */
    private volatile c1<K, V>.c f20757g;

    class a extends c1<FieldDescriptorType, Object> {
        a(int i10) {
            super(i10, (a) null);
        }

        public void q() {
            if (!p()) {
                for (int i10 = 0; i10 < l(); i10++) {
                    Map.Entry k10 = k(i10);
                    if (((t.b) k10.getKey()).f()) {
                        k10.setValue(Collections.unmodifiableList((List) k10.getValue()));
                    }
                }
                for (Map.Entry entry : n()) {
                    if (((t.b) entry.getKey()).f()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            c1.super.q();
        }
    }

    private class c extends c1<K, V>.defpackage.g {
        private c() {
            super(c1.this, (a) null);
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(c1.this, (a) null);
        }

        /* synthetic */ c(c1 c1Var, a aVar) {
            this();
        }
    }

    private static class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f20762a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f20763b = new b();

        class a implements Iterator<Object> {
            a() {
            }

            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        class b implements Iterable<Object> {
            b() {
            }

            public Iterator<Object> iterator() {
                return d.f20762a;
            }
        }

        static <T> Iterable<T> b() {
            return f20763b;
        }
    }

    private class e implements Map.Entry<K, V>, Comparable<c1<K, V>.defpackage.e> {

        /* renamed from: a  reason: collision with root package name */
        private final K f20764a;

        /* renamed from: b  reason: collision with root package name */
        private V f20765b;

        e(c1 c1Var, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        private boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        /* renamed from: a */
        public int compareTo(c1<K, V>.defpackage.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        /* renamed from: c */
        public K getKey() {
            return this.f20764a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!b(this.f20764a, entry.getKey()) || !b(this.f20765b, entry.getValue())) {
                return false;
            }
            return true;
        }

        public V getValue() {
            return this.f20765b;
        }

        public int hashCode() {
            K k10 = this.f20764a;
            int i10 = 0;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f20765b;
            if (v10 != null) {
                i10 = v10.hashCode();
            }
            return hashCode ^ i10;
        }

        public V setValue(V v10) {
            c1.this.g();
            V v11 = this.f20765b;
            this.f20765b = v10;
            return v11;
        }

        public String toString() {
            return this.f20764a + "=" + this.f20765b;
        }

        e(K k10, V v10) {
            this.f20764a = k10;
            this.f20765b = v10;
        }
    }

    private class g extends AbstractSet<Map.Entry<K, V>> {
        private g() {
        }

        /* renamed from: b */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            c1.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            c1.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = c1.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 == value || (obj2 != null && obj2.equals(value))) {
                return true;
            }
            return false;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(c1.this, (a) null);
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            c1.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return c1.this.size();
        }

        /* synthetic */ g(c1 c1Var, a aVar) {
            this();
        }
    }

    /* synthetic */ c1(int i10, a aVar) {
        this(i10);
    }

    private int f(K k10) {
        int size = this.f20752b.size() - 1;
        if (size >= 0) {
            int compareTo = k10.compareTo(this.f20752b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) / 2;
            int compareTo2 = k10.compareTo(this.f20752b.get(i11).getKey());
            if (compareTo2 < 0) {
                size = i11 - 1;
            } else if (compareTo2 <= 0) {
                return i11;
            } else {
                i10 = i11 + 1;
            }
        }
        return -(i10 + 1);
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.f20754d) {
            throw new UnsupportedOperationException();
        }
    }

    private void j() {
        g();
        if (this.f20752b.isEmpty() && !(this.f20752b instanceof ArrayList)) {
            this.f20752b = new ArrayList(this.f20751a);
        }
    }

    private SortedMap<K, V> o() {
        g();
        if (this.f20753c.isEmpty() && !(this.f20753c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f20753c = treeMap;
            TreeMap treeMap2 = treeMap;
            this.f20756f = treeMap.descendingMap();
        }
        return (SortedMap) this.f20753c;
    }

    static <FieldDescriptorType extends t.b<FieldDescriptorType>> c1<FieldDescriptorType, Object> r(int i10) {
        return new a(i10);
    }

    /* access modifiers changed from: private */
    public V t(int i10) {
        g();
        V value = this.f20752b.remove(i10).getValue();
        if (!this.f20753c.isEmpty()) {
            Iterator it = o().entrySet().iterator();
            this.f20752b.add(new e(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void clear() {
        g();
        if (!this.f20752b.isEmpty()) {
            this.f20752b.clear();
        }
        if (!this.f20753c.isEmpty()) {
            this.f20753c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (f(comparable) >= 0 || this.f20753c.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f20755e == null) {
            this.f20755e = new g(this, (a) null);
        }
        return this.f20755e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return super.equals(obj);
        }
        c1 c1Var = (c1) obj;
        int size = size();
        if (size != c1Var.size()) {
            return false;
        }
        int l10 = l();
        if (l10 != c1Var.l()) {
            return entrySet().equals(c1Var.entrySet());
        }
        for (int i10 = 0; i10 < l10; i10++) {
            if (!k(i10).equals(c1Var.k(i10))) {
                return false;
            }
        }
        if (l10 != size) {
            return this.f20753c.equals(c1Var.f20753c);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int f10 = f(comparable);
        if (f10 >= 0) {
            return this.f20752b.get(f10).getValue();
        }
        return this.f20753c.get(comparable);
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> h() {
        if (this.f20757g == null) {
            this.f20757g = new c(this, (a) null);
        }
        return this.f20757g;
    }

    public int hashCode() {
        int l10 = l();
        int i10 = 0;
        for (int i11 = 0; i11 < l10; i11++) {
            i10 += this.f20752b.get(i11).hashCode();
        }
        if (m() > 0) {
            return i10 + this.f20753c.hashCode();
        }
        return i10;
    }

    public Map.Entry<K, V> k(int i10) {
        return this.f20752b.get(i10);
    }

    public int l() {
        return this.f20752b.size();
    }

    public int m() {
        return this.f20753c.size();
    }

    public Iterable<Map.Entry<K, V>> n() {
        if (this.f20753c.isEmpty()) {
            return d.b();
        }
        return this.f20753c.entrySet();
    }

    public boolean p() {
        return this.f20754d;
    }

    public void q() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f20754d) {
            if (this.f20753c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f20753c);
            }
            this.f20753c = map;
            if (this.f20756f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f20756f);
            }
            this.f20756f = map2;
            this.f20754d = true;
        }
    }

    public V remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int f10 = f(comparable);
        if (f10 >= 0) {
            return t(f10);
        }
        if (this.f20753c.isEmpty()) {
            return null;
        }
        return this.f20753c.remove(comparable);
    }

    /* renamed from: s */
    public V put(K k10, V v10) {
        g();
        int f10 = f(k10);
        if (f10 >= 0) {
            return this.f20752b.get(f10).setValue(v10);
        }
        j();
        int i10 = -(f10 + 1);
        if (i10 >= this.f20751a) {
            return o().put(k10, v10);
        }
        int size = this.f20752b.size();
        int i11 = this.f20751a;
        if (size == i11) {
            e remove = this.f20752b.remove(i11 - 1);
            o().put(remove.getKey(), remove.getValue());
        }
        this.f20752b.add(i10, new e(k10, v10));
        return null;
    }

    public int size() {
        return this.f20752b.size() + this.f20753c.size();
    }

    private class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private int f20758a;

        /* renamed from: b  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f20759b;

        private b() {
            this.f20758a = c1.this.f20752b.size();
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f20759b == null) {
                this.f20759b = c1.this.f20756f.entrySet().iterator();
            }
            return this.f20759b;
        }

        /* renamed from: c */
        public Map.Entry<K, V> next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List b10 = c1.this.f20752b;
            int i10 = this.f20758a - 1;
            this.f20758a = i10;
            return (Map.Entry) b10.get(i10);
        }

        public boolean hasNext() {
            int i10 = this.f20758a;
            return (i10 > 0 && i10 <= c1.this.f20752b.size()) || a().hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* synthetic */ b(c1 c1Var, a aVar) {
            this();
        }
    }

    private class f implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private int f20767a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f20768b;

        /* renamed from: c  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f20769c;

        private f() {
            this.f20767a = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f20769c == null) {
                this.f20769c = c1.this.f20753c.entrySet().iterator();
            }
            return this.f20769c;
        }

        /* renamed from: c */
        public Map.Entry<K, V> next() {
            this.f20768b = true;
            int i10 = this.f20767a + 1;
            this.f20767a = i10;
            if (i10 < c1.this.f20752b.size()) {
                return (Map.Entry) c1.this.f20752b.get(this.f20767a);
            }
            return (Map.Entry) a().next();
        }

        public boolean hasNext() {
            if (this.f20767a + 1 < c1.this.f20752b.size()) {
                return true;
            }
            if (c1.this.f20753c.isEmpty() || !a().hasNext()) {
                return false;
            }
            return true;
        }

        public void remove() {
            if (this.f20768b) {
                this.f20768b = false;
                c1.this.g();
                if (this.f20767a < c1.this.f20752b.size()) {
                    c1 c1Var = c1.this;
                    int i10 = this.f20767a;
                    this.f20767a = i10 - 1;
                    Object unused = c1Var.t(i10);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ f(c1 c1Var, a aVar) {
            this();
        }
    }

    private c1(int i10) {
        this.f20751a = i10;
        this.f20752b = Collections.emptyList();
        this.f20753c = Collections.emptyMap();
        this.f20756f = Collections.emptyMap();
    }
}
