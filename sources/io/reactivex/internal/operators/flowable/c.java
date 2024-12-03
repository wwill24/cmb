package io.reactivex.internal.operators.flowable;

import qj.h;
import vj.d;
import vj.j;

public final class c<T, K> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final j<? super T, K> f30230c;

    /* renamed from: d  reason: collision with root package name */
    final d<? super K, ? super K> f30231d;

    static final class a<T, K> extends io.reactivex.internal.subscribers.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final j<? super T, K> f30232f;

        /* renamed from: g  reason: collision with root package name */
        final d<? super K, ? super K> f30233g;

        /* renamed from: h  reason: collision with root package name */
        K f30234h;

        /* renamed from: j  reason: collision with root package name */
        boolean f30235j;

        a(yj.a<? super T> aVar, j<? super T, K> jVar, d<? super K, ? super K> dVar) {
            super(aVar);
            this.f30232f = jVar;
            this.f30233g = dVar;
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
                return this.f30692a.f(t10);
            }
            try {
                K apply = this.f30232f.apply(t10);
                if (this.f30235j) {
                    boolean test = this.f30233g.test(this.f30234h, apply);
                    this.f30234h = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.f30235j = true;
                    this.f30234h = apply;
                }
                this.f30692a.d(t10);
                return true;
            } catch (Throwable th2) {
                g(th2);
                return true;
            }
        }

        public T poll() throws Exception {
            while (true) {
                T poll = this.f30694c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f30232f.apply(poll);
                if (!this.f30235j) {
                    this.f30235j = true;
                    this.f30234h = apply;
                    return poll;
                } else if (!this.f30233g.test(this.f30234h, apply)) {
                    this.f30234h = apply;
                    return poll;
                } else {
                    this.f30234h = apply;
                    if (this.f30696e != 1) {
                        this.f30693b.r(1);
                    }
                }
            }
        }
    }

    static final class b<T, K> extends io.reactivex.internal.subscribers.b<T, T> implements yj.a<T> {

        /* renamed from: f  reason: collision with root package name */
        final j<? super T, K> f30236f;

        /* renamed from: g  reason: collision with root package name */
        final d<? super K, ? super K> f30237g;

        /* renamed from: h  reason: collision with root package name */
        K f30238h;

        /* renamed from: j  reason: collision with root package name */
        boolean f30239j;

        b(rn.b<? super T> bVar, j<? super T, K> jVar, d<? super K, ? super K> dVar) {
            super(bVar);
            this.f30236f = jVar;
            this.f30237g = dVar;
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
                this.f30697a.d(t10);
                return true;
            }
            try {
                K apply = this.f30236f.apply(t10);
                if (this.f30239j) {
                    boolean test = this.f30237g.test(this.f30238h, apply);
                    this.f30238h = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.f30239j = true;
                    this.f30238h = apply;
                }
                this.f30697a.d(t10);
                return true;
            } catch (Throwable th2) {
                g(th2);
                return true;
            }
        }

        public T poll() throws Exception {
            while (true) {
                T poll = this.f30699c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f30236f.apply(poll);
                if (!this.f30239j) {
                    this.f30239j = true;
                    this.f30238h = apply;
                    return poll;
                } else if (!this.f30237g.test(this.f30238h, apply)) {
                    this.f30238h = apply;
                    return poll;
                } else {
                    this.f30238h = apply;
                    if (this.f30701e != 1) {
                        this.f30698b.r(1);
                    }
                }
            }
        }
    }

    public c(h<T> hVar, j<? super T, K> jVar, d<? super K, ? super K> dVar) {
        super(hVar);
        this.f30230c = jVar;
        this.f30231d = dVar;
    }

    /* access modifiers changed from: protected */
    public void n0(rn.b<? super T> bVar) {
        if (bVar instanceof yj.a) {
            this.f30214b.m0(new a((yj.a) bVar, this.f30230c, this.f30231d));
        } else {
            this.f30214b.m0(new b(bVar, this.f30230c, this.f30231d));
        }
    }
}
