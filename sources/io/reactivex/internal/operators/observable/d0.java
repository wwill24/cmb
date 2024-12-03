package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;
import qj.q;
import qj.s;
import qj.u;
import qj.w;
import qj.z;
import tj.b;
import yj.c;

public final class d0<T, U extends Collection<? super T>> extends w<U> implements c<U> {

    /* renamed from: a  reason: collision with root package name */
    final s<T> f30431a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f30432b;

    static final class a<T, U extends Collection<? super T>> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final z<? super U> f30433a;

        /* renamed from: b  reason: collision with root package name */
        U f30434b;

        /* renamed from: c  reason: collision with root package name */
        b f30435c;

        a(z<? super U> zVar, U u10) {
            this.f30433a = zVar;
            this.f30434b = u10;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30435c, bVar)) {
                this.f30435c = bVar;
                this.f30433a.a(this);
            }
        }

        public boolean c() {
            return this.f30435c.c();
        }

        public void d(T t10) {
            this.f30434b.add(t10);
        }

        public void dispose() {
            this.f30435c.dispose();
        }

        public void onComplete() {
            U u10 = this.f30434b;
            this.f30434b = null;
            this.f30433a.onSuccess(u10);
        }

        public void onError(Throwable th2) {
            this.f30434b = null;
            this.f30433a.onError(th2);
        }
    }

    public d0(s<T> sVar, int i10) {
        this.f30431a = sVar;
        this.f30432b = xj.a.c(i10);
    }

    public void J(z<? super U> zVar) {
        try {
            this.f30431a.e(new a(zVar, (Collection) xj.b.e(this.f30432b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            uj.a.b(th2);
            EmptyDisposable.j(th2, zVar);
        }
    }

    public q<U> h() {
        return bk.a.n(new c0(this.f30431a, this.f30432b));
    }
}
