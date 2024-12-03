package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import qj.s;
import qj.u;
import tj.b;
import vj.l;

public final class b0<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final l<? super T> f30405b;

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30406a;

        /* renamed from: b  reason: collision with root package name */
        final l<? super T> f30407b;

        /* renamed from: c  reason: collision with root package name */
        b f30408c;

        /* renamed from: d  reason: collision with root package name */
        boolean f30409d;

        a(u<? super T> uVar, l<? super T> lVar) {
            this.f30406a = uVar;
            this.f30407b = lVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30408c, bVar)) {
                this.f30408c = bVar;
                this.f30406a.a(this);
            }
        }

        public boolean c() {
            return this.f30408c.c();
        }

        public void d(T t10) {
            if (!this.f30409d) {
                this.f30406a.d(t10);
                try {
                    if (this.f30407b.test(t10)) {
                        this.f30409d = true;
                        this.f30408c.dispose();
                        this.f30406a.onComplete();
                    }
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    this.f30408c.dispose();
                    onError(th2);
                }
            }
        }

        public void dispose() {
            this.f30408c.dispose();
        }

        public void onComplete() {
            if (!this.f30409d) {
                this.f30409d = true;
                this.f30406a.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f30409d) {
                this.f30409d = true;
                this.f30406a.onError(th2);
                return;
            }
            bk.a.s(th2);
        }
    }

    public b0(s<T> sVar, l<? super T> lVar) {
        super(sVar);
        this.f30405b = lVar;
    }

    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(uVar, this.f30405b));
    }
}
