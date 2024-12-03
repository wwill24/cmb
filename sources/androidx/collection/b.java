package androidx.collection;

import androidx.annotation.NonNull;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: d  reason: collision with root package name */
    private static Object[] f3575d;

    /* renamed from: e  reason: collision with root package name */
    private static int f3576e;

    /* renamed from: f  reason: collision with root package name */
    private static Object[] f3577f;

    /* renamed from: g  reason: collision with root package name */
    private static int f3578g;

    /* renamed from: h  reason: collision with root package name */
    private static final Object f3579h = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static final Object f3580j = new Object();

    /* renamed from: a  reason: collision with root package name */
    private int[] f3581a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f3582b;

    /* renamed from: c  reason: collision with root package name */
    int f3583c;

    private class a extends d<E> {
        a() {
            super(b.this.f3583c);
        }

        /* access modifiers changed from: protected */
        public E a(int i10) {
            return b.this.n(i10);
        }

        /* access modifiers changed from: protected */
        public void c(int i10) {
            b.this.m(i10);
        }
    }

    public b() {
        this(0);
    }

    private void b(int i10) {
        if (i10 == 8) {
            synchronized (f3580j) {
                Object[] objArr = f3577f;
                if (objArr != null) {
                    try {
                        this.f3582b = objArr;
                        f3577f = (Object[]) objArr[0];
                        int[] iArr = (int[]) objArr[1];
                        this.f3581a = iArr;
                        if (iArr != null) {
                            objArr[1] = null;
                            objArr[0] = null;
                            f3578g--;
                            return;
                        }
                    } catch (ClassCastException unused) {
                    }
                    System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr[0] + " [1]=" + objArr[1]);
                    f3577f = null;
                    f3578g = 0;
                }
            }
        } else if (i10 == 4) {
            synchronized (f3579h) {
                Object[] objArr2 = f3575d;
                if (objArr2 != null) {
                    try {
                        this.f3582b = objArr2;
                        f3575d = (Object[]) objArr2[0];
                        int[] iArr2 = (int[]) objArr2[1];
                        this.f3581a = iArr2;
                        if (iArr2 != null) {
                            objArr2[1] = null;
                            objArr2[0] = null;
                            f3576e--;
                            return;
                        }
                    } catch (ClassCastException unused2) {
                    }
                    System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr2[0] + " [1]=" + objArr2[1]);
                    f3575d = null;
                    f3576e = 0;
                }
            }
        }
        this.f3581a = new int[i10];
        this.f3582b = new Object[i10];
    }

    private int d(int i10) {
        try {
            return c.a(this.f3581a, this.f3583c, i10);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void g(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (f3580j) {
                if (f3578g < 10) {
                    objArr[0] = f3577f;
                    objArr[1] = iArr;
                    for (int i11 = i10 - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f3577f = objArr;
                    f3578g++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (f3579h) {
                if (f3576e < 10) {
                    objArr[0] = f3575d;
                    objArr[1] = iArr;
                    for (int i12 = i10 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f3575d = objArr;
                    f3576e++;
                }
            }
        }
    }

    private int i(Object obj, int i10) {
        int i11 = this.f3583c;
        if (i11 == 0) {
            return -1;
        }
        int d10 = d(i10);
        if (d10 < 0 || obj.equals(this.f3582b[d10])) {
            return d10;
        }
        int i12 = d10 + 1;
        while (i12 < i11 && this.f3581a[i12] == i10) {
            if (obj.equals(this.f3582b[i12])) {
                return i12;
            }
            i12++;
        }
        int i13 = d10 - 1;
        while (i13 >= 0 && this.f3581a[i13] == i10) {
            if (obj.equals(this.f3582b[i13])) {
                return i13;
            }
            i13--;
        }
        return ~i12;
    }

    private int j() {
        int i10 = this.f3583c;
        if (i10 == 0) {
            return -1;
        }
        int d10 = d(0);
        if (d10 < 0 || this.f3582b[d10] == null) {
            return d10;
        }
        int i11 = d10 + 1;
        while (i11 < i10 && this.f3581a[i11] == 0) {
            if (this.f3582b[i11] == null) {
                return i11;
            }
            i11++;
        }
        int i12 = d10 - 1;
        while (i12 >= 0 && this.f3581a[i12] == 0) {
            if (this.f3582b[i12] == null) {
                return i12;
            }
            i12--;
        }
        return ~i11;
    }

    public boolean add(E e10) {
        int i10;
        int i11;
        int i12 = this.f3583c;
        if (e10 == null) {
            i11 = j();
            i10 = 0;
        } else {
            int hashCode = e10.hashCode();
            i10 = hashCode;
            i11 = i(e10, hashCode);
        }
        if (i11 >= 0) {
            return false;
        }
        int i13 = ~i11;
        int[] iArr = this.f3581a;
        if (i12 >= iArr.length) {
            int i14 = 4;
            if (i12 >= 8) {
                i14 = (i12 >> 1) + i12;
            } else if (i12 >= 4) {
                i14 = 8;
            }
            Object[] objArr = this.f3582b;
            b(i14);
            if (i12 == this.f3583c) {
                int[] iArr2 = this.f3581a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f3582b, 0, objArr.length);
                }
                g(iArr, objArr, i12);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i13 < i12) {
            int[] iArr3 = this.f3581a;
            int i15 = i13 + 1;
            int i16 = i12 - i13;
            System.arraycopy(iArr3, i13, iArr3, i15, i16);
            Object[] objArr2 = this.f3582b;
            System.arraycopy(objArr2, i13, objArr2, i15, i16);
        }
        int i17 = this.f3583c;
        if (i12 == i17) {
            int[] iArr4 = this.f3581a;
            if (i13 < iArr4.length) {
                iArr4[i13] = i10;
                this.f3582b[i13] = e10;
                this.f3583c = i17 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        f(this.f3583c + collection.size());
        boolean z10 = false;
        for (Object add : collection) {
            z10 |= add(add);
        }
        return z10;
    }

    public void clear() {
        int i10 = this.f3583c;
        if (i10 != 0) {
            int[] iArr = this.f3581a;
            Object[] objArr = this.f3582b;
            this.f3581a = c.f3585a;
            this.f3582b = c.f3587c;
            this.f3583c = 0;
            g(iArr, objArr, i10);
        }
        if (this.f3583c != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i10 = 0;
            while (i10 < this.f3583c) {
                try {
                    if (!set.contains(n(i10))) {
                        return false;
                    }
                    i10++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public void f(int i10) {
        int i11 = this.f3583c;
        int[] iArr = this.f3581a;
        if (iArr.length < i10) {
            Object[] objArr = this.f3582b;
            b(i10);
            int i12 = this.f3583c;
            if (i12 > 0) {
                System.arraycopy(iArr, 0, this.f3581a, 0, i12);
                System.arraycopy(objArr, 0, this.f3582b, 0, this.f3583c);
            }
            g(iArr, objArr, this.f3583c);
        }
        if (this.f3583c != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public int hashCode() {
        int[] iArr = this.f3581a;
        int i10 = this.f3583c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public int indexOf(Object obj) {
        return obj == null ? j() : i(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f3583c <= 0;
    }

    @NonNull
    public Iterator<E> iterator() {
        return new a();
    }

    public E m(int i10) {
        int i11 = this.f3583c;
        E[] eArr = this.f3582b;
        E e10 = eArr[i10];
        if (i11 <= 1) {
            clear();
        } else {
            int i12 = i11 - 1;
            int[] iArr = this.f3581a;
            int i13 = 8;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                if (i10 < i12) {
                    int i14 = i10 + 1;
                    int i15 = i12 - i10;
                    System.arraycopy(iArr, i14, iArr, i10, i15);
                    Object[] objArr = this.f3582b;
                    System.arraycopy(objArr, i14, objArr, i10, i15);
                }
                this.f3582b[i12] = null;
            } else {
                if (i11 > 8) {
                    i13 = i11 + (i11 >> 1);
                }
                b(i13);
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f3581a, 0, i10);
                    System.arraycopy(eArr, 0, this.f3582b, 0, i10);
                }
                if (i10 < i12) {
                    int i16 = i10 + 1;
                    int i17 = i12 - i10;
                    System.arraycopy(iArr, i16, this.f3581a, i10, i17);
                    System.arraycopy(eArr, i16, this.f3582b, i10, i17);
                }
            }
            if (i11 == this.f3583c) {
                this.f3583c = i12;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return e10;
    }

    public E n(int i10) {
        return this.f3582b[i10];
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        m(indexOf);
        return true;
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean z10 = false;
        for (Object remove : collection) {
            z10 |= remove(remove);
        }
        return z10;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z10 = false;
        for (int i10 = this.f3583c - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f3582b[i10])) {
                m(i10);
                z10 = true;
            }
        }
        return z10;
    }

    public int size() {
        return this.f3583c;
    }

    @NonNull
    public Object[] toArray() {
        int i10 = this.f3583c;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f3582b, 0, objArr, 0, i10);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f3583c * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f3583c; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object n10 = n(i10);
            if (n10 != this) {
                sb2.append(n10);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public b(int i10) {
        if (i10 == 0) {
            this.f3581a = c.f3585a;
            this.f3582b = c.f3587c;
        } else {
            b(i10);
        }
        this.f3583c = 0;
    }

    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.f3583c) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f3583c);
        }
        System.arraycopy(this.f3582b, 0, tArr, 0, this.f3583c);
        int length = tArr.length;
        int i10 = this.f3583c;
        if (length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }
}
