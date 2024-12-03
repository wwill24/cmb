package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import qj.s;
import qj.u;
import tj.b;
import vj.j;

public final class v<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final j<? super Throwable, ? extends T> f30493b;

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30494a;

        /* renamed from: b  reason: collision with root package name */
        final j<? super Throwable, ? extends T> f30495b;

        /* renamed from: c  reason: collision with root package name */
        b f30496c;

        a(u<? super T> uVar, j<? super Throwable, ? extends T> jVar) {
            this.f30494a = uVar;
            this.f30495b = jVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30496c, bVar)) {
                this.f30496c = bVar;
                this.f30494a.a(this);
            }
        }

        public boolean c() {
            return this.f30496c.c();
        }

        public void d(T t10) {
            this.f30494a.d(t10);
        }

        public void dispose() {
            this.f30496c.dispose();
        }

        public void onComplete() {
            this.f30494a.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f30495b.apply(th2);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th2);
                    this.f30494a.onError(nullPointerException);
                    return;
                }
                this.f30494a.d(apply);
                this.f30494a.onComplete();
            } catch (Throwable th3) {
                uj.a.b(th3);
                this.f30494a.onError(new CompositeException(th2, th3));
            }
        }
    }

    public v(s<T> sVar, j<? super Throwable, ? extends T> jVar) {
        super(sVar);
        this.f30493b = jVar;
    }

    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(uVar, this.f30493b));
    }
}
