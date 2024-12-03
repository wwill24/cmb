package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import qj.s;
import qj.u;
import tj.b;
import vj.f;

public final class d<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final f<? super T> f30420b;

    /* renamed from: c  reason: collision with root package name */
    final f<? super Throwable> f30421c;

    /* renamed from: d  reason: collision with root package name */
    final vj.a f30422d;

    /* renamed from: e  reason: collision with root package name */
    final vj.a f30423e;

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30424a;

        /* renamed from: b  reason: collision with root package name */
        final f<? super T> f30425b;

        /* renamed from: c  reason: collision with root package name */
        final f<? super Throwable> f30426c;

        /* renamed from: d  reason: collision with root package name */
        final vj.a f30427d;

        /* renamed from: e  reason: collision with root package name */
        final vj.a f30428e;

        /* renamed from: f  reason: collision with root package name */
        b f30429f;

        /* renamed from: g  reason: collision with root package name */
        boolean f30430g;

        a(u<? super T> uVar, f<? super T> fVar, f<? super Throwable> fVar2, vj.a aVar, vj.a aVar2) {
            this.f30424a = uVar;
            this.f30425b = fVar;
            this.f30426c = fVar2;
            this.f30427d = aVar;
            this.f30428e = aVar2;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30429f, bVar)) {
                this.f30429f = bVar;
                this.f30424a.a(this);
            }
        }

        public boolean c() {
            return this.f30429f.c();
        }

        public void d(T t10) {
            if (!this.f30430g) {
                try {
                    this.f30425b.accept(t10);
                    this.f30424a.d(t10);
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    this.f30429f.dispose();
                    onError(th2);
                }
            }
        }

        public void dispose() {
            this.f30429f.dispose();
        }

        public void onComplete() {
            if (!this.f30430g) {
                try {
                    this.f30427d.run();
                    this.f30430g = true;
                    this.f30424a.onComplete();
                    try {
                        this.f30428e.run();
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        bk.a.s(th2);
                    }
                } catch (Throwable th3) {
                    uj.a.b(th3);
                    onError(th3);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f30430g) {
                bk.a.s(th2);
                return;
            }
            this.f30430g = true;
            try {
                this.f30426c.accept(th2);
            } catch (Throwable th3) {
                uj.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f30424a.onError(th2);
            try {
                this.f30428e.run();
            } catch (Throwable th4) {
                uj.a.b(th4);
                bk.a.s(th4);
            }
        }
    }

    public d(s<T> sVar, f<? super T> fVar, f<? super Throwable> fVar2, vj.a aVar, vj.a aVar2) {
        super(sVar);
        this.f30420b = fVar;
        this.f30421c = fVar2;
        this.f30422d = aVar;
        this.f30423e = aVar2;
    }

    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(uVar, this.f30420b, this.f30421c, this.f30422d, this.f30423e));
    }
}
