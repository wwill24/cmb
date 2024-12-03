package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import qj.d;
import qj.f;
import tj.b;

public final class j extends qj.a {

    /* renamed from: a  reason: collision with root package name */
    final f f30130a;

    /* renamed from: b  reason: collision with root package name */
    final vj.f<? super b> f30131b;

    /* renamed from: c  reason: collision with root package name */
    final vj.f<? super Throwable> f30132c;

    /* renamed from: d  reason: collision with root package name */
    final vj.a f30133d;

    /* renamed from: e  reason: collision with root package name */
    final vj.a f30134e;

    /* renamed from: f  reason: collision with root package name */
    final vj.a f30135f;

    /* renamed from: g  reason: collision with root package name */
    final vj.a f30136g;

    final class a implements d, b {

        /* renamed from: a  reason: collision with root package name */
        final d f30137a;

        /* renamed from: b  reason: collision with root package name */
        b f30138b;

        a(d dVar) {
            this.f30137a = dVar;
        }

        public void a(b bVar) {
            try {
                j.this.f30131b.accept(bVar);
                if (DisposableHelper.k(this.f30138b, bVar)) {
                    this.f30138b = bVar;
                    this.f30137a.a(this);
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                bVar.dispose();
                this.f30138b = DisposableHelper.DISPOSED;
                EmptyDisposable.h(th2, this.f30137a);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            try {
                j.this.f30135f.run();
            } catch (Throwable th2) {
                uj.a.b(th2);
                bk.a.s(th2);
            }
        }

        public boolean c() {
            return this.f30138b.c();
        }

        public void dispose() {
            try {
                j.this.f30136g.run();
            } catch (Throwable th2) {
                uj.a.b(th2);
                bk.a.s(th2);
            }
            this.f30138b.dispose();
        }

        public void onComplete() {
            if (this.f30138b != DisposableHelper.DISPOSED) {
                try {
                    j.this.f30133d.run();
                    j.this.f30134e.run();
                    this.f30137a.onComplete();
                    b();
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    this.f30137a.onError(th2);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f30138b == DisposableHelper.DISPOSED) {
                bk.a.s(th2);
                return;
            }
            try {
                j.this.f30132c.accept(th2);
                j.this.f30134e.run();
            } catch (Throwable th3) {
                uj.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f30137a.onError(th2);
            b();
        }
    }

    public j(f fVar, vj.f<? super b> fVar2, vj.f<? super Throwable> fVar3, vj.a aVar, vj.a aVar2, vj.a aVar3, vj.a aVar4) {
        this.f30130a = fVar;
        this.f30131b = fVar2;
        this.f30132c = fVar3;
        this.f30133d = aVar;
        this.f30134e = aVar2;
        this.f30135f = aVar3;
        this.f30136g = aVar4;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        this.f30130a.e(new a(dVar));
    }
}
