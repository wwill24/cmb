package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import qj.s;
import qj.u;
import tj.b;

public final class p<T> extends a<T, T> {

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30481a;

        /* renamed from: b  reason: collision with root package name */
        b f30482b;

        a(u<? super T> uVar) {
            this.f30481a = uVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30482b, bVar)) {
                this.f30482b = bVar;
                this.f30481a.a(this);
            }
        }

        public boolean c() {
            return this.f30482b.c();
        }

        public void d(T t10) {
            this.f30481a.d(t10);
        }

        public void dispose() {
            this.f30482b.dispose();
        }

        public void onComplete() {
            this.f30481a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30481a.onError(th2);
        }
    }

    public p(s<T> sVar) {
        super(sVar);
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(uVar));
    }
}
