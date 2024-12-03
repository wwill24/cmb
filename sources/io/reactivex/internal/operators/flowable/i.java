package io.reactivex.internal.operators.flowable;

import qj.h;
import vj.l;
import yj.f;

public final class i<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final l<? super T> f30271c;

    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final l<? super T> f30272f;

        a(yj.a<? super T> aVar, l<? super T> lVar) {
            super(aVar);
            this.f30272f = lVar;
        }

        public int b(int i10) {
            return h(i10);
        }

        public void d(T t10) {
            if (!f(t10)) {
                this.f30693b.r(1);
            }
        }

        public boolean f(T t10) {
            if (this.f30695d) {
                return false;
            }
            if (this.f30696e != 0) {
                return this.f30692a.f(null);
            }
            try {
                if (!this.f30272f.test(t10) || !this.f30692a.f(t10)) {
                    return false;
                }
                return true;
            } catch (Throwable th2) {
                g(th2);
                return true;
            }
        }

        public T poll() throws Exception {
            f<T> fVar = this.f30694c;
            l<? super T> lVar = this.f30272f;
            while (true) {
                T poll = fVar.poll();
                if (poll == null) {
                    return null;
                }
                if (lVar.test(poll)) {
                    return poll;
                }
                if (this.f30696e == 2) {
                    fVar.r(1);
                }
            }
        }
    }

    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> implements yj.a<T> {

        /* renamed from: f  reason: collision with root package name */
        final l<? super T> f30273f;

        b(rn.b<? super T> bVar, l<? super T> lVar) {
            super(bVar);
            this.f30273f = lVar;
        }

        public int b(int i10) {
            return h(i10);
        }

        public void d(T t10) {
            if (!f(t10)) {
                this.f30698b.r(1);
            }
        }

        public boolean f(T t10) {
            if (this.f30700d) {
                return false;
            }
            if (this.f30701e != 0) {
                this.f30697a.d(null);
                return true;
            }
            try {
                boolean test = this.f30273f.test(t10);
                if (test) {
                    this.f30697a.d(t10);
                }
                return test;
            } catch (Throwable th2) {
                g(th2);
                return true;
            }
        }

        public T poll() throws Exception {
            f<T> fVar = this.f30699c;
            l<? super T> lVar = this.f30273f;
            while (true) {
                T poll = fVar.poll();
                if (poll == null) {
                    return null;
                }
                if (lVar.test(poll)) {
                    return poll;
                }
                if (this.f30701e == 2) {
                    fVar.r(1);
                }
            }
        }
    }

    public i(h<T> hVar, l<? super T> lVar) {
        super(hVar);
        this.f30271c = lVar;
    }

    /* access modifiers changed from: protected */
    public void n0(rn.b<? super T> bVar) {
        if (bVar instanceof yj.a) {
            this.f30214b.m0(new a((yj.a) bVar, this.f30271c));
        } else {
            this.f30214b.m0(new b(bVar, this.f30271c));
        }
    }
}
