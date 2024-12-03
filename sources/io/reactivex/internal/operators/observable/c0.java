package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;
import qj.s;
import qj.u;
import tj.b;

public final class c0<T, U extends Collection<? super T>> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f30416b;

    static final class a<T, U extends Collection<? super T>> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super U> f30417a;

        /* renamed from: b  reason: collision with root package name */
        b f30418b;

        /* renamed from: c  reason: collision with root package name */
        U f30419c;

        a(u<? super U> uVar, U u10) {
            this.f30417a = uVar;
            this.f30419c = u10;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30418b, bVar)) {
                this.f30418b = bVar;
                this.f30417a.a(this);
            }
        }

        public boolean c() {
            return this.f30418b.c();
        }

        public void d(T t10) {
            this.f30419c.add(t10);
        }

        public void dispose() {
            this.f30418b.dispose();
        }

        public void onComplete() {
            U u10 = this.f30419c;
            this.f30419c = null;
            this.f30417a.d(u10);
            this.f30417a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30419c = null;
            this.f30417a.onError(th2);
        }
    }

    public c0(s<T> sVar, Callable<U> callable) {
        super(sVar);
        this.f30416b = callable;
    }

    public void l0(u<? super U> uVar) {
        try {
            this.f30395a.e(new a(uVar, (Collection) xj.b.e(this.f30416b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            uj.a.b(th2);
            EmptyDisposable.i(th2, uVar);
        }
    }
}
