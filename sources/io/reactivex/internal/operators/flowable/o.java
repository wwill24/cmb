package io.reactivex.internal.operators.flowable;

import qj.h;
import vj.j;

public final class o<T, U> extends a<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final j<? super T, ? extends U> f30284c;

    static final class a<T, U> extends io.reactivex.internal.subscribers.a<T, U> {

        /* renamed from: f  reason: collision with root package name */
        final j<? super T, ? extends U> f30285f;

        a(yj.a<? super U> aVar, j<? super T, ? extends U> jVar) {
            super(aVar);
            this.f30285f = jVar;
        }

        public int b(int i10) {
            return h(i10);
        }

        public void d(T t10) {
            if (!this.f30695d) {
                if (this.f30696e != 0) {
                    this.f30692a.d(null);
                    return;
                }
                try {
                    this.f30692a.d(xj.b.e(this.f30285f.apply(t10), "The mapper function returned a null value."));
                } catch (Throwable th2) {
                    g(th2);
                }
            }
        }

        public boolean f(T t10) {
            if (this.f30695d) {
                return false;
            }
            try {
                return this.f30692a.f(xj.b.e(this.f30285f.apply(t10), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                g(th2);
                return true;
            }
        }

        public U poll() throws Exception {
            T poll = this.f30694c.poll();
            if (poll != null) {
                return xj.b.e(this.f30285f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    static final class b<T, U> extends io.reactivex.internal.subscribers.b<T, U> {

        /* renamed from: f  reason: collision with root package name */
        final j<? super T, ? extends U> f30286f;

        b(rn.b<? super U> bVar, j<? super T, ? extends U> jVar) {
            super(bVar);
            this.f30286f = jVar;
        }

        public int b(int i10) {
            return h(i10);
        }

        public void d(T t10) {
            if (!this.f30700d) {
                if (this.f30701e != 0) {
                    this.f30697a.d(null);
                    return;
                }
                try {
                    this.f30697a.d(xj.b.e(this.f30286f.apply(t10), "The mapper function returned a null value."));
                } catch (Throwable th2) {
                    g(th2);
                }
            }
        }

        public U poll() throws Exception {
            T poll = this.f30699c.poll();
            if (poll != null) {
                return xj.b.e(this.f30286f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public o(h<T> hVar, j<? super T, ? extends U> jVar) {
        super(hVar);
        this.f30284c = jVar;
    }

    /* access modifiers changed from: protected */
    public void n0(rn.b<? super U> bVar) {
        if (bVar instanceof yj.a) {
            this.f30214b.m0(new a((yj.a) bVar, this.f30284c));
        } else {
            this.f30214b.m0(new b(bVar, this.f30284c));
        }
    }
}
