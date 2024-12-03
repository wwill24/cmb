package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.k0;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b&\u0010'J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0018\u0010\u0013J\u0017\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001eR$\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00068F@BX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\u000f\u0010\nR\u0011\u0010%\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lkotlinx/coroutines/internal/j0;", "Lkotlinx/coroutines/internal/k0;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "i", "", "l", "(I)V", "k", "", "f", "()[Lkotlinx/coroutines/internal/k0;", "j", "m", "(II)V", "e", "()Lkotlinx/coroutines/internal/k0;", "node", "", "g", "(Lkotlinx/coroutines/internal/k0;)Z", "b", "index", "h", "(I)Lkotlinx/coroutines/internal/k0;", "a", "(Lkotlinx/coroutines/internal/k0;)V", "[Lkotlinx/coroutines/internal/k0;", "value", "c", "()I", "size", "d", "()Z", "isEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class j0<T extends k0 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a  reason: collision with root package name */
    private T[] f32541a;

    private final T[] f() {
        T[] tArr = this.f32541a;
        if (tArr == null) {
            T[] tArr2 = new k0[4];
            this.f32541a = tArr2;
            return tArr2;
        } else if (c() < tArr.length) {
            return tArr;
        } else {
            T[] copyOf = Arrays.copyOf(tArr, c() * 2);
            j.f(copyOf, "copyOf(this, newSize)");
            T[] tArr3 = (k0[]) copyOf;
            this.f32541a = tArr3;
            return tArr3;
        }
    }

    private final void j(int i10) {
        this._size = i10;
    }

    private final void k(int i10) {
        while (true) {
            int i11 = (i10 * 2) + 1;
            if (i11 < c()) {
                T[] tArr = this.f32541a;
                j.d(tArr);
                int i12 = i11 + 1;
                if (i12 < c()) {
                    T t10 = tArr[i12];
                    j.d(t10);
                    T t11 = tArr[i11];
                    j.d(t11);
                    if (((Comparable) t10).compareTo(t11) < 0) {
                        i11 = i12;
                    }
                }
                T t12 = tArr[i10];
                j.d(t12);
                T t13 = tArr[i11];
                j.d(t13);
                if (((Comparable) t12).compareTo(t13) > 0) {
                    m(i10, i11);
                    i10 = i11;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final void l(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f32541a;
            j.d(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            j.d(t10);
            T t11 = tArr[i10];
            j.d(t11);
            if (((Comparable) t10).compareTo(t11) > 0) {
                m(i10, i11);
                i10 = i11;
            } else {
                return;
            }
        }
    }

    private final void m(int i10, int i11) {
        T[] tArr = this.f32541a;
        j.d(tArr);
        T t10 = tArr[i11];
        j.d(t10);
        T t11 = tArr[i10];
        j.d(t11);
        tArr[i10] = t10;
        tArr[i11] = t11;
        t10.setIndex(i10);
        t11.setIndex(i11);
    }

    public final void a(T t10) {
        t10.a(this);
        k0[] f10 = f();
        int c10 = c();
        j(c10 + 1);
        f10[c10] = t10;
        t10.setIndex(c10);
        l(c10);
    }

    public final T b() {
        T[] tArr = this.f32541a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b10;
        synchronized (this) {
            b10 = b();
        }
        return b10;
    }

    public final boolean g(T t10) {
        boolean z10;
        synchronized (this) {
            if (t10.b() == null) {
                z10 = false;
            } else {
                h(t10.getIndex());
                z10 = true;
            }
        }
        return z10;
    }

    public final T h(int i10) {
        T[] tArr = this.f32541a;
        j.d(tArr);
        j(c() - 1);
        if (i10 < c()) {
            m(i10, c());
            int i11 = (i10 - 1) / 2;
            if (i10 > 0) {
                T t10 = tArr[i10];
                j.d(t10);
                T t11 = tArr[i11];
                j.d(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    m(i10, i11);
                    l(i11);
                }
            }
            k(i10);
        }
        T t12 = tArr[c()];
        j.d(t12);
        t12.a((j0<?>) null);
        t12.setIndex(-1);
        tArr[c()] = null;
        return t12;
    }

    public final T i() {
        T t10;
        synchronized (this) {
            if (c() > 0) {
                t10 = h(0);
            } else {
                t10 = null;
            }
        }
        return t10;
    }
}
