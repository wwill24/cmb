package kotlin.collections.builders;

import com.coffeemeetsbagel.models.NetworkProfile;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.ranges.IntRange;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class MapBuilder<K, V> implements Map<K, V>, Serializable, qk.d {

    /* renamed from: a  reason: collision with root package name */
    private static final a f32042a = new a((DefaultConstructorMarker) null);
    private hk.c<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    /* access modifiers changed from: private */
    public K[] keysArray;
    private hk.d<K> keysView;
    /* access modifiers changed from: private */
    public int length;
    private int maxProbeDistance;
    /* access modifiers changed from: private */
    public int[] presenceArray;
    private int size;
    /* access modifiers changed from: private */
    public V[] valuesArray;
    private hk.e<V> valuesView;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int c(int i10) {
            return Integer.highestOneBit(j.c(i10, 1) * 3);
        }

        /* access modifiers changed from: private */
        public final int d(int i10) {
            return Integer.numberOfLeadingZeros(i10) + 1;
        }
    }

    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, qk.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            j.g(mapBuilder, "map");
        }

        /* renamed from: h */
        public c<K, V> next() {
            if (a() < d().length) {
                int a10 = a();
                f(a10 + 1);
                g(a10);
                c<K, V> cVar = new c<>(d(), c());
                e();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void j(StringBuilder sb2) {
            j.g(sb2, "sb");
            if (a() < d().length) {
                int a10 = a();
                f(a10 + 1);
                g(a10);
                Object obj = d().keysArray[c()];
                if (j.b(obj, d())) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj);
                }
                sb2.append(SignatureVisitor.INSTANCEOF);
                Object[] e10 = d().valuesArray;
                j.d(e10);
                Object obj2 = e10[c()];
                if (j.b(obj2, d())) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj2);
                }
                e();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int k() {
            int i10;
            if (a() < d().length) {
                int a10 = a();
                f(a10 + 1);
                g(a10);
                Object obj = d().keysArray[c()];
                int i11 = 0;
                if (obj != null) {
                    i10 = obj.hashCode();
                } else {
                    i10 = 0;
                }
                Object[] e10 = d().valuesArray;
                j.d(e10);
                Object obj2 = e10[c()];
                if (obj2 != null) {
                    i11 = obj2.hashCode();
                }
                int i12 = i10 ^ i11;
                e();
                return i12;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class c<K, V> implements Map.Entry<K, V>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private final MapBuilder<K, V> f32043a;

        /* renamed from: b  reason: collision with root package name */
        private final int f32044b;

        public c(MapBuilder<K, V> mapBuilder, int i10) {
            j.g(mapBuilder, "map");
            this.f32043a = mapBuilder;
            this.f32044b = i10;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (!j.b(entry.getKey(), getKey()) || !j.b(entry.getValue(), getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public K getKey() {
            return this.f32043a.keysArray[this.f32044b];
        }

        public V getValue() {
            V[] e10 = this.f32043a.valuesArray;
            j.d(e10);
            return e10[this.f32044b];
        }

        public int hashCode() {
            Object key = getKey();
            int i10 = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            if (value != null) {
                i10 = value.hashCode();
            }
            return hashCode ^ i10;
        }

        public V setValue(V v10) {
            this.f32043a.k();
            V[] a10 = this.f32043a.h();
            int i10 = this.f32044b;
            V v11 = a10[i10];
            a10[i10] = v10;
            return v11;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append(SignatureVisitor.INSTANCEOF);
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    public static class d<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final MapBuilder<K, V> f32045a;

        /* renamed from: b  reason: collision with root package name */
        private int f32046b;

        /* renamed from: c  reason: collision with root package name */
        private int f32047c = -1;

        public d(MapBuilder<K, V> mapBuilder) {
            j.g(mapBuilder, "map");
            this.f32045a = mapBuilder;
            e();
        }

        public final int a() {
            return this.f32046b;
        }

        public final int c() {
            return this.f32047c;
        }

        public final MapBuilder<K, V> d() {
            return this.f32045a;
        }

        public final void e() {
            while (this.f32046b < this.f32045a.length) {
                int[] d10 = this.f32045a.presenceArray;
                int i10 = this.f32046b;
                if (d10[i10] < 0) {
                    this.f32046b = i10 + 1;
                } else {
                    return;
                }
            }
        }

        public final void f(int i10) {
            this.f32046b = i10;
        }

        public final void g(int i10) {
            this.f32047c = i10;
        }

        public final boolean hasNext() {
            return this.f32046b < this.f32045a.length;
        }

        public final void remove() {
            boolean z10;
            if (this.f32047c != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f32045a.k();
                this.f32045a.N(this.f32047c);
                this.f32047c = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    public static final class e<K, V> extends d<K, V> implements Iterator<K>, qk.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            j.g(mapBuilder, "map");
        }

        public K next() {
            if (a() < d().length) {
                int a10 = a();
                f(a10 + 1);
                g(a10);
                K k10 = d().keysArray[c()];
                e();
                return k10;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class f<K, V> extends d<K, V> implements Iterator<V>, qk.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            j.g(mapBuilder, "map");
        }

        public V next() {
            if (a() < d().length) {
                int a10 = a();
                f(a10 + 1);
                g(a10);
                V[] e10 = d().valuesArray;
                j.d(e10);
                V v10 = e10[c()];
                e();
                return v10;
            }
            throw new NoSuchElementException();
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i10, int i11) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i10;
        this.length = i11;
        this.hashShift = f32042a.d(x());
    }

    private final int B(K k10) {
        return ((k10 != null ? k10.hashCode() : 0) * -1640531527) >>> this.hashShift;
    }

    private final boolean G(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z10 = false;
        if (collection.isEmpty()) {
            return false;
        }
        q(collection.size());
        for (Map.Entry H : collection) {
            if (H(H)) {
                z10 = true;
            }
        }
        return z10;
    }

    private final boolean H(Map.Entry<? extends K, ? extends V> entry) {
        int g10 = g(entry.getKey());
        Object[] h10 = h();
        if (g10 >= 0) {
            h10[g10] = entry.getValue();
            return true;
        }
        int i10 = (-g10) - 1;
        if (j.b(entry.getValue(), h10[i10])) {
            return false;
        }
        h10[i10] = entry.getValue();
        return true;
    }

    private final boolean I(int i10) {
        int B = B(this.keysArray[i10]);
        int i11 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[B] == 0) {
                iArr[B] = i10 + 1;
                this.presenceArray[i10] = B;
                return true;
            }
            i11--;
            if (i11 < 0) {
                return false;
            }
            int i12 = B - 1;
            if (B == 0) {
                B = x() - 1;
            } else {
                B = i12;
            }
        }
    }

    private final void J(int i10) {
        if (this.length > size()) {
            l();
        }
        int i11 = 0;
        if (i10 != x()) {
            this.hashArray = new int[i10];
            this.hashShift = f32042a.d(i10);
        } else {
            k.l(this.hashArray, 0, 0, x());
        }
        while (i11 < this.length) {
            int i12 = i11 + 1;
            if (I(i11)) {
                i11 = i12;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final void L(int i10) {
        int g10 = j.g(this.maxProbeDistance * 2, x() / 2);
        int i11 = 0;
        int i12 = i10;
        do {
            int i13 = i10 - 1;
            if (i10 == 0) {
                i10 = x() - 1;
            } else {
                i10 = i13;
            }
            i11++;
            if (i11 > this.maxProbeDistance) {
                this.hashArray[i12] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i14 = iArr[i10];
            if (i14 == 0) {
                iArr[i12] = 0;
                return;
            }
            if (i14 < 0) {
                iArr[i12] = -1;
            } else {
                int i15 = i14 - 1;
                if (((B(this.keysArray[i15]) - i10) & (x() - 1)) >= i11) {
                    this.hashArray[i12] = i14;
                    this.presenceArray[i15] = i12;
                }
                g10--;
            }
            i12 = i10;
            i11 = 0;
            g10--;
        } while (g10 >= 0);
        this.hashArray[i12] = -1;
    }

    /* access modifiers changed from: private */
    public final void N(int i10) {
        hk.b.f(this.keysArray, i10);
        L(this.presenceArray[i10]);
        this.presenceArray[i10] = -1;
        this.size = size() - 1;
    }

    /* access modifiers changed from: private */
    public final V[] h() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] d10 = hk.b.d(v());
        this.valuesArray = d10;
        return d10;
    }

    private final void l() {
        int i10;
        V[] vArr = this.valuesArray;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.length;
            if (i11 >= i10) {
                break;
            }
            if (this.presenceArray[i11] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i12] = kArr[i11];
                if (vArr != null) {
                    vArr[i12] = vArr[i11];
                }
                i12++;
            }
            i11++;
        }
        hk.b.g(this.keysArray, i12, i10);
        if (vArr != null) {
            hk.b.g(vArr, i12, this.length);
        }
        this.length = i12;
    }

    private final boolean o(Map<?, ?> map) {
        return size() == map.size() && m(map.entrySet());
    }

    private final void p(int i10) {
        V[] vArr;
        if (i10 < 0) {
            throw new OutOfMemoryError();
        } else if (i10 > v()) {
            int v10 = (v() * 3) / 2;
            if (i10 <= v10) {
                i10 = v10;
            }
            this.keysArray = hk.b.e(this.keysArray, i10);
            V[] vArr2 = this.valuesArray;
            if (vArr2 != null) {
                vArr = hk.b.e(vArr2, i10);
            } else {
                vArr = null;
            }
            this.valuesArray = vArr;
            int[] copyOf = Arrays.copyOf(this.presenceArray, i10);
            j.f(copyOf, "copyOf(this, newSize)");
            this.presenceArray = copyOf;
            int a10 = f32042a.c(i10);
            if (a10 > x()) {
                J(a10);
            }
        } else if ((this.length + i10) - size() > v()) {
            J(x());
        }
    }

    private final void q(int i10) {
        p(this.length + i10);
    }

    private final int s(K k10) {
        int B = B(k10);
        int i10 = this.maxProbeDistance;
        while (true) {
            int i11 = this.hashArray[B];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (j.b(this.keysArray[i12], k10)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            int i13 = B - 1;
            if (B == 0) {
                B = x() - 1;
            } else {
                B = i13;
            }
        }
    }

    private final int t(V v10) {
        int i10 = this.length;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.presenceArray[i10] >= 0) {
                V[] vArr = this.valuesArray;
                j.d(vArr);
                if (j.b(vArr[i10], v10)) {
                    return i10;
                }
            }
        }
    }

    private final int v() {
        return this.keysArray.length;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    private final int x() {
        return this.hashArray.length;
    }

    public Collection<V> A() {
        hk.e<V> eVar = this.valuesView;
        if (eVar != null) {
            return eVar;
        }
        hk.e<V> eVar2 = new hk.e<>(this);
        this.valuesView = eVar2;
        return eVar2;
    }

    public final boolean C() {
        return this.isReadOnly;
    }

    public final e<K, V> D() {
        return new e<>(this);
    }

    public final boolean K(Map.Entry<? extends K, ? extends V> entry) {
        j.g(entry, "entry");
        k();
        int s10 = s(entry.getKey());
        if (s10 < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        j.d(vArr);
        if (!j.b(vArr[s10], entry.getValue())) {
            return false;
        }
        N(s10);
        return true;
    }

    public final int M(K k10) {
        k();
        int s10 = s(k10);
        if (s10 < 0) {
            return -1;
        }
        N(s10);
        return s10;
    }

    public final boolean P(V v10) {
        k();
        int t10 = t(v10);
        if (t10 < 0) {
            return false;
        }
        N(t10);
        return true;
    }

    public final f<K, V> Q() {
        return new f<>(this);
    }

    public void clear() {
        k();
        b0 g10 = new IntRange(0, this.length - 1).iterator();
        while (g10.hasNext()) {
            int nextInt = g10.nextInt();
            int[] iArr = this.presenceArray;
            int i10 = iArr[nextInt];
            if (i10 >= 0) {
                this.hashArray[i10] = 0;
                iArr[nextInt] = -1;
            }
        }
        hk.b.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            hk.b.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    public boolean containsKey(Object obj) {
        return s(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return t(obj) >= 0;
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return w();
    }

    public boolean equals(Object obj) {
        if (obj == this || ((obj instanceof Map) && o((Map) obj))) {
            return true;
        }
        return false;
    }

    public final int g(K k10) {
        k();
        while (true) {
            int B = B(k10);
            int g10 = j.g(this.maxProbeDistance * 2, x() / 2);
            int i10 = 0;
            while (true) {
                int i11 = this.hashArray[B];
                if (i11 <= 0) {
                    if (this.length >= v()) {
                        q(1);
                    } else {
                        int i12 = this.length;
                        int i13 = i12 + 1;
                        this.length = i13;
                        this.keysArray[i12] = k10;
                        this.presenceArray[i12] = B;
                        this.hashArray[B] = i13;
                        this.size = size() + 1;
                        if (i10 > this.maxProbeDistance) {
                            this.maxProbeDistance = i10;
                        }
                        return i12;
                    }
                } else if (j.b(this.keysArray[i11 - 1], k10)) {
                    return -i11;
                } else {
                    i10++;
                    if (i10 > g10) {
                        J(x() * 2);
                        break;
                    }
                    int i14 = B - 1;
                    if (B == 0) {
                        B = x() - 1;
                    } else {
                        B = i14;
                    }
                }
            }
        }
    }

    public V get(Object obj) {
        int s10 = s(obj);
        if (s10 < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        j.d(vArr);
        return vArr[s10];
    }

    public int hashCode() {
        b r10 = r();
        int i10 = 0;
        while (r10.hasNext()) {
            i10 += r10.k();
        }
        return i10;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final Map<K, V> j() {
        k();
        this.isReadOnly = true;
        return this;
    }

    public final void k() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    public final /* bridge */ Set<K> keySet() {
        return y();
    }

    public final boolean m(Collection<?> collection) {
        j.g(collection, NetworkProfile.MALE);
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!n((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean n(Map.Entry<? extends K, ? extends V> entry) {
        j.g(entry, "entry");
        int s10 = s(entry.getKey());
        if (s10 < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        j.d(vArr);
        return j.b(vArr[s10], entry.getValue());
    }

    public V put(K k10, V v10) {
        k();
        int g10 = g(k10);
        V[] h10 = h();
        if (g10 < 0) {
            int i10 = (-g10) - 1;
            V v11 = h10[i10];
            h10[i10] = v10;
            return v11;
        }
        h10[g10] = v10;
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        j.g(map, "from");
        k();
        G(map.entrySet());
    }

    public final b<K, V> r() {
        return new b<>(this);
    }

    public V remove(Object obj) {
        int M = M(obj);
        if (M < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        j.d(vArr);
        V v10 = vArr[M];
        hk.b.f(vArr, M);
        return v10;
    }

    public final /* bridge */ int size() {
        return z();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        b r10 = r();
        int i10 = 0;
        while (r10.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            r10.j(sb2);
            i10++;
        }
        sb2.append("}");
        String sb3 = sb2.toString();
        j.f(sb3, "sb.toString()");
        return sb3;
    }

    public final /* bridge */ Collection<V> values() {
        return A();
    }

    public Set<Map.Entry<K, V>> w() {
        hk.c<K, V> cVar = this.entriesView;
        if (cVar != null) {
            return cVar;
        }
        hk.c<K, V> cVar2 = new hk.c<>(this);
        this.entriesView = cVar2;
        return cVar2;
    }

    public Set<K> y() {
        hk.d<K> dVar = this.keysView;
        if (dVar != null) {
            return dVar;
        }
        hk.d<K> dVar2 = new hk.d<>(this);
        this.keysView = dVar2;
        return dVar2;
    }

    public int z() {
        return this.size;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i10) {
        this(hk.b.d(i10), (V[]) null, new int[i10], new int[f32042a.c(i10)], 2, 0);
    }
}
