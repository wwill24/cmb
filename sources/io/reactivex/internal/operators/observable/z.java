package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import qj.s;
import qj.u;
import tj.b;

public final class z<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f30509b;

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30510a;

        /* renamed from: b  reason: collision with root package name */
        long f30511b;

        /* renamed from: c  reason: collision with root package name */
        b f30512c;

        a(u<? super T> uVar, long j10) {
            this.f30510a = uVar;
            this.f30511b = j10;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30512c, bVar)) {
                this.f30512c = bVar;
                this.f30510a.a(this);
            }
        }

        public boolean c() {
            return this.f30512c.c();
        }

        public void d(T t10) {
            long j10 = this.f30511b;
            if (j10 != 0) {
                this.f30511b = j10 - 1;
            } else {
                this.f30510a.d(t10);
            }
        }

        public void dispose() {
            this.f30512c.dispose();
        }

        public void onComplete() {
            this.f30510a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30510a.onError(th2);
        }
    }

    public z(s<T> sVar, long j10) {
        super(sVar);
        this.f30509b = j10;
    }

    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(uVar, this.f30509b));
    }
}
