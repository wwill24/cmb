package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.CompositeException;
import qj.d;
import qj.f;
import tj.b;
import vj.l;

public final class i extends qj.a {

    /* renamed from: a  reason: collision with root package name */
    final f f30126a;

    /* renamed from: b  reason: collision with root package name */
    final l<? super Throwable> f30127b;

    final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private final d f30128a;

        a(d dVar) {
            this.f30128a = dVar;
        }

        public void a(b bVar) {
            this.f30128a.a(bVar);
        }

        public void onComplete() {
            this.f30128a.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                if (i.this.f30127b.test(th2)) {
                    this.f30128a.onComplete();
                } else {
                    this.f30128a.onError(th2);
                }
            } catch (Throwable th3) {
                uj.a.b(th3);
                this.f30128a.onError(new CompositeException(th2, th3));
            }
        }
    }

    public i(f fVar, l<? super Throwable> lVar) {
        this.f30126a = fVar;
        this.f30127b = lVar;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        this.f30126a.e(new a(dVar));
    }
}
