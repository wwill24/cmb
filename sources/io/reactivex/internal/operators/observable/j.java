package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import qj.s;
import qj.u;
import tj.b;

public final class j<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final vj.j<? super T, ? extends Iterable<? extends R>> f30459b;

    static final class a<T, R> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super R> f30460a;

        /* renamed from: b  reason: collision with root package name */
        final vj.j<? super T, ? extends Iterable<? extends R>> f30461b;

        /* renamed from: c  reason: collision with root package name */
        b f30462c;

        a(u<? super R> uVar, vj.j<? super T, ? extends Iterable<? extends R>> jVar) {
            this.f30460a = uVar;
            this.f30461b = jVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30462c, bVar)) {
                this.f30462c = bVar;
                this.f30460a.a(this);
            }
        }

        public boolean c() {
            return this.f30462c.c();
        }

        public void d(T t10) {
            if (this.f30462c != DisposableHelper.DISPOSED) {
                try {
                    u<? super R> uVar = this.f30460a;
                    for (Object e10 : (Iterable) this.f30461b.apply(t10)) {
                        try {
                            try {
                                uVar.d(xj.b.e(e10, "The iterator returned a null value"));
                            } catch (Throwable th2) {
                                uj.a.b(th2);
                                this.f30462c.dispose();
                                onError(th2);
                                return;
                            }
                        } catch (Throwable th3) {
                            uj.a.b(th3);
                            this.f30462c.dispose();
                            onError(th3);
                            return;
                        }
                    }
                } catch (Throwable th4) {
                    uj.a.b(th4);
                    this.f30462c.dispose();
                    onError(th4);
                }
            }
        }

        public void dispose() {
            this.f30462c.dispose();
            this.f30462c = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            b bVar = this.f30462c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                this.f30462c = disposableHelper;
                this.f30460a.onComplete();
            }
        }

        public void onError(Throwable th2) {
            b bVar = this.f30462c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                bk.a.s(th2);
                return;
            }
            this.f30462c = disposableHelper;
            this.f30460a.onError(th2);
        }
    }

    public j(s<T> sVar, vj.j<? super T, ? extends Iterable<? extends R>> jVar) {
        super(sVar);
        this.f30459b = jVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super R> uVar) {
        this.f30395a.e(new a(uVar, this.f30459b));
    }
}
