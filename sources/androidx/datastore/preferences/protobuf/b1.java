package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.s;
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

class b1<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final int f5201a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<b1<K, V>.defpackage.e> f5202b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Map<K, V> f5203c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5204d;

    /* renamed from: e  reason: collision with root package name */
    private volatile b1<K, V>.defpackage.g f5205e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<K, V> f5206f;

    /* renamed from: g  reason: collision with root package name */
    private volatile b1<K, V>.c f5207g;

    static class a extends b1<FieldDescriptorType, Object> {
        a(int i10) {
            super(i10, (a) null);
        }

        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return b1.super.put((s.b) obj, obj2);
        }

        public void q() {
            if (!p()) {
                for (int i10 = 0; i10 < l(); i10++) {
                    Map.Entry k10 = k(i10);
                    if (((s.b) k10.getKey()).f()) {
                        k10.setValue(Collections.unmodifiableList((List) k10.getValue()));
                    }
                }
                for (Map.Entry entry : n()) {
                    if (((s.b) entry.getKey()).f()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            b1.super.q();
        }
    }

    private class c extends b1<K, V>.defpackage.g {
        private c() {
            super(b1.this, (a) null);
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(b1.this, (a) null);
        }

        /* synthetic */ c(b1 b1Var, a aVar) {
            this();
        }
    }

    private static class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f5212a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f5213b = new b();

        static class a implements Iterator<Object> {
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

        static class b implements Iterable<Object> {
            b() {
            }

            public Iterator<Object> iterator() {
                return d.f5212a;
            }
        }

        static <T> Iterable<T> b() {
            return f5213b;
        }
    }

    private class e implements Map.Entry<K, V>, Comparable<b1<K, V>.defpackage.e> {

        /* renamed from: a  reason: collision with root package name */
        private final K f5214a;

        /* renamed from: b  reason: collision with root package name */
        private V f5215b;

        e(b1 b1Var, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        private boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        /* renamed from: a */
        public int compareTo(b1<K, V>.defpackage.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        /* renamed from: c */
        public K getKey() {
            return this.f5214a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!b(this.f5214a, entry.getKey()) || !b(this.f5215b, entry.getValue())) {
                return false;
            }
            return true;
        }

        public V getValue() {
            return this.f5215b;
        }

        public int hashCode() {
            K k10 = this.f5214a;
            int i10 = 0;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f5215b;
            if (v10 != null) {
                i10 = v10.hashCode();
            }
            return hashCode ^ i10;
        }

        public V setValue(V v10) {
            b1.this.g();
            V v11 = this.f5215b;
            this.f5215b = v10;
            return v11;
        }

        public String toString() {
            return this.f5214a + "=" + this.f5215b;
        }

        e(K k10, V v10) {
            this.f5214a = k10;
            this.f5215b = v10;
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
            b1.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            b1.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = b1.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 == value || (obj2 != null && obj2.equals(value))) {
                return true;
            }
            return false;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(b1.this, (a) null);
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            b1.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return b1.this.size();
        }

        /* synthetic */ g(b1 b1Var, a aVar) {
            this();
        }
    }

    /* synthetic */ b1(int i10, a aVar) {
        this(i10);
    }

    private int f(K k10) {
        int size = this.f5202b.size() - 1;
        if (size >= 0) {
            int compareTo = k10.compareTo(this.f5202b.get(size).getKey());
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
            int compareTo2 = k10.compareTo(this.f5202b.get(i11).getKey());
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
        if (this.f5204d) {
            throw new UnsupportedOperationException();
        }
    }

    private void j() {
        g();
        if (this.f5202b.isEmpty() && !(this.f5202b instanceof ArrayList)) {
            this.f5202b = new ArrayList(this.f5201a);
        }
    }

    private SortedMap<K, V> o() {
        g();
        if (this.f5203c.isEmpty() && !(this.f5203c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f5203c = treeMap;
            TreeMap treeMap2 = treeMap;
            this.f5206f = treeMap.descendingMap();
        }
        return (SortedMap) this.f5203c;
    }

    static <FieldDescriptorType extends s.b<FieldDescriptorType>> b1<FieldDescriptorType, Object> r(int i10) {
        return new a(i10);
    }

    /* access modifiers changed from: private */
    public V t(int i10) {
        g();
        V value = this.f5202b.remove(i10).getValue();
        if (!this.f5203c.isEmpty()) {
            Iterator it = o().entrySet().iterator();
            this.f5202b.add(new e(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void clear() {
        g();
        if (!this.f5202b.isEmpty()) {
            this.f5202b.clear();
        }
        if (!this.f5203c.isEmpty()) {
            this.f5203c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (f(comparable) >= 0 || this.f5203c.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f5205e == null) {
            this.f5205e = new g(this, (a) null);
        }
        return this.f5205e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b1)) {
            return super.equals(obj);
        }
        b1 b1Var = (b1) obj;
        int size = size();
        if (size != b1Var.size()) {
            return false;
        }
        int l10 = l();
        if (l10 != b1Var.l()) {
            return entrySet().equals(b1Var.entrySet());
        }
        for (int i10 = 0; i10 < l10; i10++) {
            if (!k(i10).equals(b1Var.k(i10))) {
                return false;
            }
        }
        if (l10 != size) {
            return this.f5203c.equals(b1Var.f5203c);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int f10 = f(comparable);
        if (f10 >= 0) {
            return this.f5202b.get(f10).getValue();
        }
        return this.f5203c.get(comparable);
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> h() {
        if (this.f5207g == null) {
            this.f5207g = new c(this, (a) null);
        }
        return this.f5207g;
    }

    public int hashCode() {
        int l10 = l();
        int i10 = 0;
        for (int i11 = 0; i11 < l10; i11++) {
            i10 += this.f5202b.get(i11).hashCode();
        }
        if (m() > 0) {
            return i10 + this.f5203c.hashCode();
        }
        return i10;
    }

    public Map.Entry<K, V> k(int i10) {
        return this.f5202b.get(i10);
    }

    public int l() {
        return this.f5202b.size();
    }

    public int m() {
        return this.f5203c.size();
    }

    public Iterable<Map.Entry<K, V>> n() {
        if (this.f5203c.isEmpty()) {
            return d.b();
        }
        return this.f5203c.entrySet();
    }

    public boolean p() {
        return this.f5204d;
    }

    public void q() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f5204d) {
            if (this.f5203c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f5203c);
            }
            this.f5203c = map;
            if (this.f5206f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f5206f);
            }
            this.f5206f = map2;
            this.f5204d = true;
        }
    }

    public V remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int f10 = f(comparable);
        if (f10 >= 0) {
            return t(f10);
        }
        if (this.f5203c.isEmpty()) {
            return null;
        }
        return this.f5203c.remove(comparable);
    }

    /* renamed from: s */
    public V put(K k10, V v10) {
        g();
        int f10 = f(k10);
        if (f10 >= 0) {
            return this.f5202b.get(f10).setValue(v10);
        }
        j();
        int i10 = -(f10 + 1);
        if (i10 >= this.f5201a) {
            return o().put(k10, v10);
        }
        int size = this.f5202b.size();
        int i11 = this.f5201a;
        if (size == i11) {
            e remove = this.f5202b.remove(i11 - 1);
            o().put(remove.getKey(), remove.getValue());
        }
        this.f5202b.add(i10, new e(k10, v10));
        return null;
    }

    public int size() {
        return this.f5202b.size() + this.f5203c.size();
    }

    private class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private int f5208a;

        /* renamed from: b  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f5209b;

        private b() {
            this.f5208a = b1.this.f5202b.size();
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f5209b == null) {
                this.f5209b = b1.this.f5206f.entrySet().iterator();
            }
            return this.f5209b;
        }

        /* renamed from: c */
        public Map.Entry<K, V> next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List b10 = b1.this.f5202b;
            int i10 = this.f5208a - 1;
            this.f5208a = i10;
            return (Map.Entry) b10.get(i10);
        }

        public boolean hasNext() {
            int i10 = this.f5208a;
            return (i10 > 0 && i10 <= b1.this.f5202b.size()) || a().hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* synthetic */ b(b1 b1Var, a aVar) {
            this();
        }
    }

    private class f implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private int f5217a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5218b;

        /* renamed from: c  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f5219c;

        private f() {
            this.f5217a = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f5219c == null) {
                this.f5219c = b1.this.f5203c.entrySet().iterator();
            }
            return this.f5219c;
        }

        /* renamed from: c */
        public Map.Entry<K, V> next() {
            this.f5218b = true;
            int i10 = this.f5217a + 1;
            this.f5217a = i10;
            if (i10 < b1.this.f5202b.size()) {
                return (Map.Entry) b1.this.f5202b.get(this.f5217a);
            }
            return (Map.Entry) a().next();
        }

        public boolean hasNext() {
            if (this.f5217a + 1 < b1.this.f5202b.size()) {
                return true;
            }
            if (b1.this.f5203c.isEmpty() || !a().hasNext()) {
                return false;
            }
            return true;
        }

        public void remove() {
            if (this.f5218b) {
                this.f5218b = false;
                b1.this.g();
                if (this.f5217a < b1.this.f5202b.size()) {
                    b1 b1Var = b1.this;
                    int i10 = this.f5217a;
                    this.f5217a = i10 - 1;
                    Object unused = b1Var.t(i10);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ f(b1 b1Var, a aVar) {
            this();
        }
    }

    private b1(int i10) {
        this.f5201a = i10;
        this.f5202b = Collections.emptyList();
        this.f5203c = Collections.emptyMap();
        this.f5206f = Collections.emptyMap();
    }
}
