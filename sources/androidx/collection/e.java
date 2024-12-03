package androidx.collection;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class e<E> implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f3591e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private boolean f3592a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f3593b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f3594c;

    /* renamed from: d  reason: collision with root package name */
    private int f3595d;

    public e() {
        this(10);
    }

    private void d() {
        int i10 = this.f3595d;
        long[] jArr = this.f3593b;
        Object[] objArr = this.f3594c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f3591e) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f3592a = false;
        this.f3595d = i11;
    }

    public void a() {
        int i10 = this.f3595d;
        Object[] objArr = this.f3594c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f3595d = 0;
        this.f3592a = false;
    }

    /* renamed from: b */
    public e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.f3593b = (long[]) this.f3593b.clone();
            eVar.f3594c = (Object[]) this.f3594c.clone();
            return eVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean c(long j10) {
        return i(j10) >= 0;
    }

    public E e(long j10) {
        return h(j10, (Object) null);
    }

    public E h(long j10, E e10) {
        E e11;
        int b10 = c.b(this.f3593b, this.f3595d, j10);
        if (b10 < 0 || (e11 = this.f3594c[b10]) == f3591e) {
            return e10;
        }
        return e11;
    }

    public int i(long j10) {
        if (this.f3592a) {
            d();
        }
        return c.b(this.f3593b, this.f3595d, j10);
    }

    public boolean j() {
        return q() == 0;
    }

    public long k(int i10) {
        if (this.f3592a) {
            d();
        }
        return this.f3593b[i10];
    }

    public void l(long j10, E e10) {
        int b10 = c.b(this.f3593b, this.f3595d, j10);
        if (b10 >= 0) {
            this.f3594c[b10] = e10;
            return;
        }
        int i10 = ~b10;
        int i11 = this.f3595d;
        if (i10 < i11) {
            Object[] objArr = this.f3594c;
            if (objArr[i10] == f3591e) {
                this.f3593b[i10] = j10;
                objArr[i10] = e10;
                return;
            }
        }
        if (this.f3592a && i11 >= this.f3593b.length) {
            d();
            i10 = ~c.b(this.f3593b, this.f3595d, j10);
        }
        int i12 = this.f3595d;
        if (i12 >= this.f3593b.length) {
            int f10 = c.f(i12 + 1);
            long[] jArr = new long[f10];
            Object[] objArr2 = new Object[f10];
            long[] jArr2 = this.f3593b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f3594c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f3593b = jArr;
            this.f3594c = objArr2;
        }
        int i13 = this.f3595d;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.f3593b;
            int i14 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i14, i13 - i10);
            Object[] objArr4 = this.f3594c;
            System.arraycopy(objArr4, i10, objArr4, i14, this.f3595d - i10);
        }
        this.f3593b[i10] = j10;
        this.f3594c[i10] = e10;
        this.f3595d++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.f3594c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f3593b
            int r1 = r2.f3595d
            int r3 = androidx.collection.c.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.f3594c
            r0 = r4[r3]
            java.lang.Object r1 = f3591e
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f3592a = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.e.o(long):void");
    }

    public void p(int i10) {
        Object[] objArr = this.f3594c;
        Object obj = objArr[i10];
        Object obj2 = f3591e;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f3592a = true;
        }
    }

    public int q() {
        if (this.f3592a) {
            d();
        }
        return this.f3595d;
    }

    public E r(int i10) {
        if (this.f3592a) {
            d();
        }
        return this.f3594c[i10];
    }

    public String toString() {
        if (q() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f3595d * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f3595d; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(k(i10));
            sb2.append(SignatureVisitor.INSTANCEOF);
            Object r10 = r(i10);
            if (r10 != this) {
                sb2.append(r10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public e(int i10) {
        this.f3592a = false;
        if (i10 == 0) {
            this.f3593b = c.f3586b;
            this.f3594c = c.f3587c;
            return;
        }
        int f10 = c.f(i10);
        this.f3593b = new long[f10];
        this.f3594c = new Object[f10];
    }
}
