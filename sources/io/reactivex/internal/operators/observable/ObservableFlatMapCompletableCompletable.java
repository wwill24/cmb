package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.a;
import qj.d;
import qj.f;
import qj.q;
import qj.s;
import qj.u;
import tj.b;
import vj.j;
import yj.c;

public final class ObservableFlatMapCompletableCompletable<T> extends a implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    final s<T> f30344a;

    /* renamed from: b  reason: collision with root package name */
    final j<? super T, ? extends f> f30345b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f30346c;

    static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements b, u<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final d downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final j<? super T, ? extends f> mapper;
        final tj.a set = new tj.a();
        b upstream;

        final class InnerObserver extends AtomicReference<b> implements d, b {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerObserver() {
            }

            public void a(b bVar) {
                DisposableHelper.i(this, bVar);
            }

            public boolean c() {
                return DisposableHelper.b((b) get());
            }

            public void dispose() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                FlatMapCompletableMainObserver.this.b(this);
            }

            public void onError(Throwable th2) {
                FlatMapCompletableMainObserver.this.e(this, th2);
            }
        }

        FlatMapCompletableMainObserver(d dVar, j<? super T, ? extends f> jVar, boolean z10) {
            this.downstream = dVar;
            this.mapper = jVar;
            this.delayErrors = z10;
            lazySet(1);
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.set.b(innerObserver);
            onComplete();
        }

        public boolean c() {
            return this.upstream.c();
        }

        public void d(T t10) {
            try {
                f fVar = (f) xj.b.e(this.mapper.apply(t10), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.disposed && this.set.a(innerObserver)) {
                    fVar.e(innerObserver);
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        /* access modifiers changed from: package-private */
        public void e(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th2) {
            this.set.b(innerObserver);
            onError(th2);
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b10 = this.errors.b();
                if (b10 != null) {
                    this.downstream.onError(b10);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                bk.a.s(th2);
            } else if (!this.delayErrors) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.downstream.onError(this.errors.b());
                }
            } else if (decrementAndGet() == 0) {
                this.downstream.onError(this.errors.b());
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(s<T> sVar, j<? super T, ? extends f> jVar, boolean z10) {
        this.f30344a = sVar;
        this.f30345b = jVar;
        this.f30346c = z10;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        this.f30344a.e(new FlatMapCompletableMainObserver(dVar, this.f30345b, this.f30346c));
    }

    public q<T> h() {
        return bk.a.n(new ObservableFlatMapCompletable(this.f30344a, this.f30345b, this.f30346c));
    }
}
