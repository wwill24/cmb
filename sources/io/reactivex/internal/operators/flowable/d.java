package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import qj.h;
import vj.f;

public final class d<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final f<? super T> f30240c;

    /* renamed from: d  reason: collision with root package name */
    final f<? super Throwable> f30241d;

    /* renamed from: e  reason: collision with root package name */
    final vj.a f30242e;

    /* renamed from: f  reason: collision with root package name */
    final vj.a f30243f;

    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final f<? super T> f30244f;

        /* renamed from: g  reason: collision with root package name */
        final f<? super Throwable> f30245g;

        /* renamed from: h  reason: collision with root package name */
        final vj.a f30246h;

        /* renamed from: j  reason: collision with root package name */
        final vj.a f30247j;

        a(yj.a<? super T> aVar, f<? super T> fVar, f<? super Throwable> fVar2, vj.a aVar2, vj.a aVar3) {
            super(aVar);
            this.f30244f = fVar;
            this.f30245g = fVar2;
            this.f30246h = aVar2;
            this.f30247j = aVar3;
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
                    this.f30244f.accept(t10);
                    this.f30692a.d(t10);
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
                this.f30244f.accept(t10);
                return this.f30692a.f(t10);
            } catch (Throwable th2) {
                g(th2);
                return false;
            }
        }

        public void onComplete() {
            if (!this.f30695d) {
                try {
                    this.f30246h.run();
                    this.f30695d = true;
                    this.f30692a.onComplete();
                    try {
                        this.f30247j.run();
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        bk.a.s(th2);
                    }
                } catch (Throwable th3) {
                    g(th3);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f30695d) {
                bk.a.s(th2);
                return;
            }
            boolean z10 = true;
            this.f30695d = true;
            try {
                this.f30245g.accept(th2);
            } catch (Throwable th3) {
                uj.a.b(th3);
                this.f30692a.onError(new CompositeException(th2, th3));
                z10 = false;
            }
            if (z10) {
                this.f30692a.onError(th2);
            }
            try {
                this.f30247j.run();
            } catch (Throwable th4) {
                uj.a.b(th4);
                bk.a.s(th4);
            }
        }

        public T poll() throws Exception {
            try {
                T poll = this.f30694c.poll();
                if (poll != null) {
                    try {
                        this.f30244f.accept(poll);
                        this.f30247j.run();
                    } catch (Throwable th2) {
                        throw new CompositeException(th, th2);
                    }
                } else if (this.f30696e == 1) {
                    this.f30246h.run();
                    this.f30247j.run();
                }
                return poll;
            } catch (Throwable th3) {
                throw new CompositeException(th, th3);
            }
        }
    }

    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final f<? super T> f30248f;

        /* renamed from: g  reason: collision with root package name */
        final f<? super Throwable> f30249g;

        /* renamed from: h  reason: collision with root package name */
        final vj.a f30250h;

        /* renamed from: j  reason: collision with root package name */
        final vj.a f30251j;

        b(rn.b<? super T> bVar, f<? super T> fVar, f<? super Throwable> fVar2, vj.a aVar, vj.a aVar2) {
            super(bVar);
            this.f30248f = fVar;
            this.f30249g = fVar2;
            this.f30250h = aVar;
            this.f30251j = aVar2;
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
                    this.f30248f.accept(t10);
                    this.f30697a.d(t10);
                } catch (Throwable th2) {
                    g(th2);
                }
            }
        }

        public void onComplete() {
            if (!this.f30700d) {
                try {
                    this.f30250h.run();
                    this.f30700d = true;
                    this.f30697a.onComplete();
                    try {
                        this.f30251j.run();
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        bk.a.s(th2);
                    }
                } catch (Throwable th3) {
                    g(th3);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f30700d) {
                bk.a.s(th2);
                return;
            }
            boolean z10 = true;
            this.f30700d = true;
            try {
                this.f30249g.accept(th2);
            } catch (Throwable th3) {
                uj.a.b(th3);
                this.f30697a.onError(new CompositeException(th2, th3));
                z10 = false;
            }
            if (z10) {
                this.f30697a.onError(th2);
            }
            try {
                this.f30251j.run();
            } catch (Throwable th4) {
                uj.a.b(th4);
                bk.a.s(th4);
            }
        }

        public T poll() throws Exception {
            try {
                T poll = this.f30699c.poll();
                if (poll != null) {
                    try {
                        this.f30248f.accept(poll);
                        this.f30251j.run();
                    } catch (Throwable th2) {
                        throw new CompositeException(th, th2);
                    }
                } else if (this.f30701e == 1) {
                    this.f30250h.run();
                    this.f30251j.run();
                }
                return poll;
            } catch (Throwable th3) {
                throw new CompositeException(th, th3);
            }
        }
    }

    public d(h<T> hVar, f<? super T> fVar, f<? super Throwable> fVar2, vj.a aVar, vj.a aVar2) {
        super(hVar);
        this.f30240c = fVar;
        this.f30241d = fVar2;
        this.f30242e = aVar;
        this.f30243f = aVar2;
    }

    /* access modifiers changed from: protected */
    public void n0(rn.b<? super T> bVar) {
        if (bVar instanceof yj.a) {
            this.f30214b.m0(new a((yj.a) bVar, this.f30240c, this.f30241d, this.f30242e, this.f30243f));
            return;
        }
        this.f30214b.m0(new b(bVar, this.f30240c, this.f30241d, this.f30242e, this.f30243f));
    }
}
