package androidx.collection;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class h<E> implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f3603e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private boolean f3604a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f3605b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f3606c;

    /* renamed from: d  reason: collision with root package name */
    private int f3607d;

    public h() {
        this(10);
    }

    private void d() {
        int i10 = this.f3607d;
        int[] iArr = this.f3605b;
        Object[] objArr = this.f3606c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f3603e) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f3604a = false;
        this.f3607d = i11;
    }

    public void a(int i10, E e10) {
        int i11 = this.f3607d;
        if (i11 == 0 || i10 > this.f3605b[i11 - 1]) {
            if (this.f3604a && i11 >= this.f3605b.length) {
                d();
            }
            int i12 = this.f3607d;
            if (i12 >= this.f3605b.length) {
                int e11 = c.e(i12 + 1);
                int[] iArr = new int[e11];
                Object[] objArr = new Object[e11];
                int[] iArr2 = this.f3605b;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f3606c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f3605b = iArr;
                this.f3606c = objArr;
            }
            this.f3605b[i12] = i10;
            this.f3606c[i12] = e10;
            this.f3607d = i12 + 1;
            return;
        }
        k(i10, e10);
    }

    public void b() {
        int i10 = this.f3607d;
        Object[] objArr = this.f3606c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f3607d = 0;
        this.f3604a = false;
    }

    /* renamed from: c */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f3605b = (int[]) this.f3605b.clone();
            hVar.f3606c = (Object[]) this.f3606c.clone();
            return hVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public E e(int i10) {
        return h(i10, (Object) null);
    }

    public E h(int i10, E e10) {
        E e11;
        int a10 = c.a(this.f3605b, this.f3607d, i10);
        if (a10 < 0 || (e11 = this.f3606c[a10]) == f3603e) {
            return e10;
        }
        return e11;
    }

    public int i(E e10) {
        if (this.f3604a) {
            d();
        }
        for (int i10 = 0; i10 < this.f3607d; i10++) {
            if (this.f3606c[i10] == e10) {
                return i10;
            }
        }
        return -1;
    }

    public int j(int i10) {
        if (this.f3604a) {
            d();
        }
        return this.f3605b[i10];
    }

    public void k(int i10, E e10) {
        int a10 = c.a(this.f3605b, this.f3607d, i10);
        if (a10 >= 0) {
            this.f3606c[a10] = e10;
            return;
        }
        int i11 = ~a10;
        int i12 = this.f3607d;
        if (i11 < i12) {
            Object[] objArr = this.f3606c;
            if (objArr[i11] == f3603e) {
                this.f3605b[i11] = i10;
                objArr[i11] = e10;
                return;
            }
        }
        if (this.f3604a && i12 >= this.f3605b.length) {
            d();
            i11 = ~c.a(this.f3605b, this.f3607d, i10);
        }
        int i13 = this.f3607d;
        if (i13 >= this.f3605b.length) {
            int e11 = c.e(i13 + 1);
            int[] iArr = new int[e11];
            Object[] objArr2 = new Object[e11];
            int[] iArr2 = this.f3605b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f3606c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f3605b = iArr;
            this.f3606c = objArr2;
        }
        int i14 = this.f3607d;
        if (i14 - i11 != 0) {
            int[] iArr3 = this.f3605b;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr4 = this.f3606c;
            System.arraycopy(objArr4, i11, objArr4, i15, this.f3607d - i11);
        }
        this.f3605b[i11] = i10;
        this.f3606c[i11] = e10;
        this.f3607d++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.f3606c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.f3605b
            int r1 = r3.f3607d
            int r4 = androidx.collection.c.a(r0, r1, r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.f3606c
            r1 = r0[r4]
            java.lang.Object r2 = f3603e
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.f3604a = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.h.l(int):void");
    }

    public int o() {
        if (this.f3604a) {
            d();
        }
        return this.f3607d;
    }

    public E p(int i10) {
        if (this.f3604a) {
            d();
        }
        return this.f3606c[i10];
    }

    public String toString() {
        if (o() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f3607d * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f3607d; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(j(i10));
            sb2.append(SignatureVisitor.INSTANCEOF);
            Object p10 = p(i10);
            if (p10 != this) {
                sb2.append(p10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public h(int i10) {
        this.f3604a = false;
        if (i10 == 0) {
            this.f3605b = c.f3585a;
            this.f3606c = c.f3587c;
            return;
        }
        int e10 = c.e(i10);
        this.f3605b = new int[e10];
        this.f3606c = new Object[e10];
    }
}
