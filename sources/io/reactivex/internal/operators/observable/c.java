package io.reactivex.internal.operators.observable;

import qj.s;
import qj.u;
import vj.d;
import vj.j;

public final class c<T, K> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final j<? super T, K> f30410b;

    /* renamed from: c  reason: collision with root package name */
    final d<? super K, ? super K> f30411c;

    static final class a<T, K> extends io.reactivex.internal.observers.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final j<? super T, K> f30412f;

        /* renamed from: g  reason: collision with root package name */
        final d<? super K, ? super K> f30413g;

        /* renamed from: h  reason: collision with root package name */
        K f30414h;

        /* renamed from: j  reason: collision with root package name */
        boolean f30415j;

        a(u<? super T> uVar, j<? super T, K> jVar, d<? super K, ? super K> dVar) {
            super(uVar);
            this.f30412f = jVar;
            this.f30413g = dVar;
        }

        public int b(int i10) {
            return h(i10);
        }

        public void d(T t10) {
            if (!this.f30085d) {
                if (this.f30086e != 0) {
                    this.f30082a.d(t10);
                    return;
                }
                try {
                    K apply = this.f30412f.apply(t10);
                    if (this.f30415j) {
                        boolean test = this.f30413g.test(this.f30414h, apply);
                        this.f30414h = apply;
                        if (test) {
                            return;
                        }
                    } else {
                        this.f30415j = true;
                        this.f30414h = apply;
                    }
                    this.f30082a.d(t10);
                } catch (Throwable th2) {
                    g(th2);
                }
            }
        }

        public T poll() throws Exception {
            while (true) {
                T poll = this.f30084c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f30412f.apply(poll);
                if (!this.f30415j) {
                    this.f30415j = true;
                    this.f30414h = apply;
                    return poll;
                } else if (!this.f30413g.test(this.f30414h, apply)) {
                    this.f30414h = apply;
                    return poll;
                } else {
                    this.f30414h = apply;
                }
            }
        }
    }

    public c(s<T> sVar, j<? super T, K> jVar, d<? super K, ? super K> dVar) {
        super(sVar);
        this.f30410b = jVar;
        this.f30411c = dVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(uVar, this.f30410b, this.f30411c));
    }
}
