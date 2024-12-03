package io.reactivex.internal.queue;

import io.reactivex.internal.util.g;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import net.bytebuddy.jar.asm.Opcodes;
import yj.h;

public final class a<T> implements h<T> {

    /* renamed from: j  reason: collision with root package name */
    static final int f30592j = Integer.getInteger("jctools.spsc.max.lookahead.step", Opcodes.ACC_SYNTHETIC).intValue();

    /* renamed from: k  reason: collision with root package name */
    private static final Object f30593k = new Object();

    /* renamed from: a  reason: collision with root package name */
    final AtomicLong f30594a = new AtomicLong();

    /* renamed from: b  reason: collision with root package name */
    int f30595b;

    /* renamed from: c  reason: collision with root package name */
    long f30596c;

    /* renamed from: d  reason: collision with root package name */
    final int f30597d;

    /* renamed from: e  reason: collision with root package name */
    AtomicReferenceArray<Object> f30598e;

    /* renamed from: f  reason: collision with root package name */
    final int f30599f;

    /* renamed from: g  reason: collision with root package name */
    AtomicReferenceArray<Object> f30600g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicLong f30601h = new AtomicLong();

    public a(int i10) {
        int a10 = g.a(Math.max(8, i10));
        int i11 = a10 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a10 + 1);
        this.f30598e = atomicReferenceArray;
        this.f30597d = i11;
        a(a10);
        this.f30600g = atomicReferenceArray;
        this.f30599f = i11;
        this.f30596c = (long) (i11 - 1);
        q(0);
    }

    private void a(int i10) {
        this.f30595b = Math.min(i10 / 4, f30592j);
    }

    private static int c(int i10) {
        return i10;
    }

    private static int d(long j10, int i10) {
        return c(((int) j10) & i10);
    }

    private long e() {
        return this.f30601h.get();
    }

    private long f() {
        return this.f30594a.get();
    }

    private long g() {
        return this.f30601h.get();
    }

    private static <E> Object h(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    private AtomicReferenceArray<Object> i(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        int c10 = c(i10);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) h(atomicReferenceArray, c10);
        o(atomicReferenceArray, c10, (Object) null);
        return atomicReferenceArray2;
    }

    private long j() {
        return this.f30594a.get();
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10) {
        this.f30600g = atomicReferenceArray;
        int d10 = d(j10, i10);
        T h10 = h(atomicReferenceArray, d10);
        if (h10 != null) {
            o(atomicReferenceArray, d10, (Object) null);
            n(j10 + 1);
        }
        return h10;
    }

    private void m(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10, T t10, long j11) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f30598e = atomicReferenceArray2;
        this.f30596c = (j11 + j10) - 1;
        o(atomicReferenceArray2, i10, t10);
        p(atomicReferenceArray, atomicReferenceArray2);
        o(atomicReferenceArray, i10, f30593k);
        q(j10 + 1);
    }

    private void n(long j10) {
        this.f30601h.lazySet(j10);
    }

    private static void o(AtomicReferenceArray<Object> atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    private void p(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        o(atomicReferenceArray, c(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void q(long j10) {
        this.f30594a.lazySet(j10);
    }

    private boolean r(AtomicReferenceArray<Object> atomicReferenceArray, T t10, long j10, int i10) {
        o(atomicReferenceArray, i10, t10);
        q(j10 + 1);
        return true;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return j() == g();
    }

    public boolean l(T t10, T t11) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f30598e;
        long j10 = j();
        int i10 = this.f30597d;
        long j11 = 2 + j10;
        if (h(atomicReferenceArray, d(j11, i10)) == null) {
            int d10 = d(j10, i10);
            o(atomicReferenceArray, d10 + 1, t11);
            o(atomicReferenceArray, d10, t10);
            q(j11);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f30598e = atomicReferenceArray2;
        int d11 = d(j10, i10);
        o(atomicReferenceArray2, d11 + 1, t11);
        o(atomicReferenceArray2, d11, t10);
        p(atomicReferenceArray, atomicReferenceArray2);
        o(atomicReferenceArray, d11, f30593k);
        q(j11);
        return true;
    }

    public boolean offer(T t10) {
        if (t10 != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f30598e;
            long f10 = f();
            int i10 = this.f30597d;
            int d10 = d(f10, i10);
            if (f10 < this.f30596c) {
                return r(atomicReferenceArray, t10, f10, d10);
            }
            long j10 = ((long) this.f30595b) + f10;
            if (h(atomicReferenceArray, d(j10, i10)) == null) {
                this.f30596c = j10 - 1;
                return r(atomicReferenceArray, t10, f10, d10);
            } else if (h(atomicReferenceArray, d(1 + f10, i10)) == null) {
                return r(atomicReferenceArray, t10, f10, d10);
            } else {
                m(atomicReferenceArray, f10, d10, t10, (long) i10);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    public T poll() {
        boolean z10;
        AtomicReferenceArray<Object> atomicReferenceArray = this.f30600g;
        long e10 = e();
        int i10 = this.f30599f;
        int d10 = d(e10, i10);
        T h10 = h(atomicReferenceArray, d10);
        if (h10 == f30593k) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (h10 != null && !z10) {
            o(atomicReferenceArray, d10, (Object) null);
            n(e10 + 1);
            return h10;
        } else if (z10) {
            return k(i(atomicReferenceArray, i10 + 1), e10, i10);
        } else {
            return null;
        }
    }
}
