package androidx.collection;

import androidx.annotation.NonNull;
import java.util.ConcurrentModificationException;
import java.util.Map;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class g<K, V> {

    /* renamed from: d  reason: collision with root package name */
    static Object[] f3596d;

    /* renamed from: e  reason: collision with root package name */
    static int f3597e;

    /* renamed from: f  reason: collision with root package name */
    static Object[] f3598f;

    /* renamed from: g  reason: collision with root package name */
    static int f3599g;

    /* renamed from: a  reason: collision with root package name */
    int[] f3600a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f3601b;

    /* renamed from: c  reason: collision with root package name */
    int f3602c;

    public g() {
        this.f3600a = c.f3585a;
        this.f3601b = c.f3587c;
        this.f3602c = 0;
    }

    private void a(int i10) {
        Class<g> cls = g.class;
        if (i10 == 8) {
            synchronized (cls) {
                Object[] objArr = f3598f;
                if (objArr != null) {
                    this.f3601b = objArr;
                    f3598f = (Object[]) objArr[0];
                    this.f3600a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f3599g--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (cls) {
                Object[] objArr2 = f3596d;
                if (objArr2 != null) {
                    this.f3601b = objArr2;
                    f3596d = (Object[]) objArr2[0];
                    this.f3600a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f3597e--;
                    return;
                }
            }
        }
        this.f3600a = new int[i10];
        this.f3601b = new Object[(i10 << 1)];
    }

    private static int b(int[] iArr, int i10, int i11) {
        try {
            return c.a(iArr, i10, i11);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i10) {
        Class<g> cls = g.class;
        if (iArr.length == 8) {
            synchronized (cls) {
                if (f3599g < 10) {
                    objArr[0] = f3598f;
                    objArr[1] = iArr;
                    for (int i11 = (i10 << 1) - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f3598f = objArr;
                    f3599g++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (cls) {
                if (f3597e < 10) {
                    objArr[0] = f3596d;
                    objArr[1] = iArr;
                    for (int i12 = (i10 << 1) - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f3596d = objArr;
                    f3597e++;
                }
            }
        }
    }

    public void c(int i10) {
        int i11 = this.f3602c;
        int[] iArr = this.f3600a;
        if (iArr.length < i10) {
            Object[] objArr = this.f3601b;
            a(i10);
            if (this.f3602c > 0) {
                System.arraycopy(iArr, 0, this.f3600a, 0, i11);
                System.arraycopy(objArr, 0, this.f3601b, 0, i11 << 1);
            }
            d(iArr, objArr, i11);
        }
        if (this.f3602c != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i10 = this.f3602c;
        if (i10 > 0) {
            int[] iArr = this.f3600a;
            Object[] objArr = this.f3601b;
            this.f3600a = c.f3585a;
            this.f3601b = c.f3587c;
            this.f3602c = 0;
            d(iArr, objArr, i10);
        }
        if (this.f3602c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    /* access modifiers changed from: package-private */
    public int e(Object obj, int i10) {
        int i11 = this.f3602c;
        if (i11 == 0) {
            return -1;
        }
        int b10 = b(this.f3600a, i11, i10);
        if (b10 < 0 || obj.equals(this.f3601b[b10 << 1])) {
            return b10;
        }
        int i12 = b10 + 1;
        while (i12 < i11 && this.f3600a[i12] == i10) {
            if (obj.equals(this.f3601b[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        int i13 = b10 - 1;
        while (i13 >= 0 && this.f3600a[i13] == i10) {
            if (obj.equals(this.f3601b[i13 << 1])) {
                return i13;
            }
            i13--;
        }
        return ~i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (size() != gVar.size()) {
                    return false;
                }
                for (int i10 = 0; i10 < this.f3602c; i10++) {
                    Object j10 = j(i10);
                    Object n10 = n(i10);
                    Object obj2 = gVar.get(j10);
                    if (n10 == null) {
                        if (obj2 != null || !gVar.containsKey(j10)) {
                            return false;
                        }
                    } else if (!n10.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (size() != map.size()) {
                    return false;
                }
                for (int i11 = 0; i11 < this.f3602c; i11++) {
                    Object j11 = j(i11);
                    Object n11 = n(i11);
                    Object obj3 = map.get(j11);
                    if (n11 == null) {
                        if (obj3 != null || !map.containsKey(j11)) {
                            return false;
                        }
                    } else if (!n11.equals(obj3)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
        }
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int g() {
        int i10 = this.f3602c;
        if (i10 == 0) {
            return -1;
        }
        int b10 = b(this.f3600a, i10, 0);
        if (b10 < 0 || this.f3601b[b10 << 1] == null) {
            return b10;
        }
        int i11 = b10 + 1;
        while (i11 < i10 && this.f3600a[i11] == 0) {
            if (this.f3601b[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        int i12 = b10 - 1;
        while (i12 >= 0 && this.f3600a[i12] == 0) {
            if (this.f3601b[i12 << 1] == null) {
                return i12;
            }
            i12--;
        }
        return ~i11;
    }

    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v10) {
        int f10 = f(obj);
        if (f10 >= 0) {
            return this.f3601b[(f10 << 1) + 1];
        }
        return v10;
    }

    /* access modifiers changed from: package-private */
    public int h(Object obj) {
        int i10 = this.f3602c * 2;
        Object[] objArr = this.f3601b;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int i10;
        int[] iArr = this.f3600a;
        Object[] objArr = this.f3601b;
        int i11 = this.f3602c;
        int i12 = 1;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Object obj = objArr[i12];
            int i15 = iArr[i13];
            if (obj == null) {
                i10 = 0;
            } else {
                i10 = obj.hashCode();
            }
            i14 += i10 ^ i15;
            i13++;
            i12 += 2;
        }
        return i14;
    }

    public boolean isEmpty() {
        return this.f3602c <= 0;
    }

    public K j(int i10) {
        return this.f3601b[i10 << 1];
    }

    public void k(@NonNull g<? extends K, ? extends V> gVar) {
        int i10 = gVar.f3602c;
        c(this.f3602c + i10);
        if (this.f3602c != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(gVar.j(i11), gVar.n(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(gVar.f3600a, 0, this.f3600a, 0, i10);
            System.arraycopy(gVar.f3601b, 0, this.f3601b, 0, i10 << 1);
            this.f3602c = i10;
        }
    }

    public V l(int i10) {
        V[] vArr = this.f3601b;
        int i11 = i10 << 1;
        V v10 = vArr[i11 + 1];
        int i12 = this.f3602c;
        if (i12 <= 1) {
            clear();
        } else {
            int i13 = i12 - 1;
            int[] iArr = this.f3600a;
            int i14 = 8;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                if (i10 < i13) {
                    int i15 = i10 + 1;
                    int i16 = i13 - i10;
                    System.arraycopy(iArr, i15, iArr, i10, i16);
                    Object[] objArr = this.f3601b;
                    System.arraycopy(objArr, i15 << 1, objArr, i11, i16 << 1);
                }
                Object[] objArr2 = this.f3601b;
                int i17 = i13 << 1;
                objArr2[i17] = null;
                objArr2[i17 + 1] = null;
            } else {
                if (i12 > 8) {
                    i14 = i12 + (i12 >> 1);
                }
                a(i14);
                if (i12 == this.f3602c) {
                    if (i10 > 0) {
                        System.arraycopy(iArr, 0, this.f3600a, 0, i10);
                        System.arraycopy(vArr, 0, this.f3601b, 0, i11);
                    }
                    if (i10 < i13) {
                        int i18 = i10 + 1;
                        int i19 = i13 - i10;
                        System.arraycopy(iArr, i18, this.f3600a, i10, i19);
                        System.arraycopy(vArr, i18 << 1, this.f3601b, i11, i19 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            if (i12 == this.f3602c) {
                this.f3602c = i13;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return v10;
    }

    public V m(int i10, V v10) {
        int i11 = (i10 << 1) + 1;
        V[] vArr = this.f3601b;
        V v11 = vArr[i11];
        vArr[i11] = v10;
        return v11;
    }

    public V n(int i10) {
        return this.f3601b[(i10 << 1) + 1];
    }

    public V put(K k10, V v10) {
        int i10;
        int i11;
        int i12 = this.f3602c;
        if (k10 == null) {
            i11 = g();
            i10 = 0;
        } else {
            int hashCode = k10.hashCode();
            i10 = hashCode;
            i11 = e(k10, hashCode);
        }
        if (i11 >= 0) {
            int i13 = (i11 << 1) + 1;
            V[] vArr = this.f3601b;
            V v11 = vArr[i13];
            vArr[i13] = v10;
            return v11;
        }
        int i14 = ~i11;
        int[] iArr = this.f3600a;
        if (i12 >= iArr.length) {
            int i15 = 4;
            if (i12 >= 8) {
                i15 = (i12 >> 1) + i12;
            } else if (i12 >= 4) {
                i15 = 8;
            }
            Object[] objArr = this.f3601b;
            a(i15);
            if (i12 == this.f3602c) {
                int[] iArr2 = this.f3600a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f3601b, 0, objArr.length);
                }
                d(iArr, objArr, i12);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i14 < i12) {
            int[] iArr3 = this.f3600a;
            int i16 = i14 + 1;
            System.arraycopy(iArr3, i14, iArr3, i16, i12 - i14);
            Object[] objArr2 = this.f3601b;
            System.arraycopy(objArr2, i14 << 1, objArr2, i16 << 1, (this.f3602c - i14) << 1);
        }
        int i17 = this.f3602c;
        if (i12 == i17) {
            int[] iArr4 = this.f3600a;
            if (i14 < iArr4.length) {
                iArr4[i14] = i10;
                Object[] objArr3 = this.f3601b;
                int i18 = i14 << 1;
                objArr3[i18] = k10;
                objArr3[i18 + 1] = v10;
                this.f3602c = i17 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k10, V v10) {
        V v11 = get(k10);
        if (v11 == null) {
            return put(k10, v10);
        }
        return v11;
    }

    public V remove(Object obj) {
        int f10 = f(obj);
        if (f10 >= 0) {
            return l(f10);
        }
        return null;
    }

    public V replace(K k10, V v10) {
        int f10 = f(k10);
        if (f10 >= 0) {
            return m(f10, v10);
        }
        return null;
    }

    public int size() {
        return this.f3602c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f3602c * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f3602c; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object j10 = j(i10);
            if (j10 != this) {
                sb2.append(j10);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append(SignatureVisitor.INSTANCEOF);
            Object n10 = n(i10);
            if (n10 != this) {
                sb2.append(n10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int f10 = f(obj);
        if (f10 < 0) {
            return false;
        }
        Object n10 = n(f10);
        if (obj2 != n10 && (obj2 == null || !obj2.equals(n10))) {
            return false;
        }
        l(f10);
        return true;
    }

    public boolean replace(K k10, V v10, V v11) {
        int f10 = f(k10);
        if (f10 < 0) {
            return false;
        }
        V n10 = n(f10);
        if (n10 != v10 && (v10 == null || !v10.equals(n10))) {
            return false;
        }
        m(f10, v11);
        return true;
    }

    public g(int i10) {
        if (i10 == 0) {
            this.f3600a = c.f3585a;
            this.f3601b = c.f3587c;
        } else {
            a(i10);
        }
        this.f3602c = 0;
    }

    public g(g<K, V> gVar) {
        this();
        if (gVar != null) {
            k(gVar);
        }
    }
}
