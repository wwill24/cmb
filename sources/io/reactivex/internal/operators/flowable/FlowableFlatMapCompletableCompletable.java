package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.a;
import qj.d;
import qj.f;
import qj.h;
import qj.l;
import rn.c;
import vj.j;
import yj.b;

public final class FlowableFlatMapCompletableCompletable<T> extends a implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    final h<T> f30170a;

    /* renamed from: b  reason: collision with root package name */
    final j<? super T, ? extends f> f30171b;

    /* renamed from: c  reason: collision with root package name */
    final int f30172c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30173d;

    static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements l<T>, tj.b {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final d downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final j<? super T, ? extends f> mapper;
        final int maxConcurrency;
        final tj.a set = new tj.a();
        c upstream;

        final class InnerObserver extends AtomicReference<tj.b> implements d, tj.b {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerObserver() {
            }

            public void a(tj.b bVar) {
                DisposableHelper.i(this, bVar);
            }

            public boolean c() {
                return DisposableHelper.b((tj.b) get());
            }

            public void dispose() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                FlatMapCompletableMainSubscriber.this.a(this);
            }

            public void onError(Throwable th2) {
                FlatMapCompletableMainSubscriber.this.b(this, th2);
            }
        }

        FlatMapCompletableMainSubscriber(d dVar, j<? super T, ? extends f> jVar, boolean z10, int i10) {
            this.downstream = dVar;
            this.mapper = jVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
            lazySet(1);
        }

        /* access modifiers changed from: package-private */
        public void a(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
            this.set.b(innerObserver);
            onComplete();
        }

        /* access modifiers changed from: package-private */
        public void b(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th2) {
            this.set.b(innerObserver);
            onError(th2);
        }

        public boolean c() {
            return this.set.c();
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
                this.upstream.cancel();
                onError(th2);
            }
        }

        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.a(this);
                int i10 = this.maxConcurrency;
                if (i10 == Integer.MAX_VALUE) {
                    cVar.r(Long.MAX_VALUE);
                } else {
                    cVar.r((long) i10);
                }
            }
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b10 = this.errors.b();
                if (b10 != null) {
                    this.downstream.onError(b10);
                } else {
                    this.downstream.onComplete();
                }
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.r(1);
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
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.r(1);
            }
        }
    }

    public FlowableFlatMapCompletableCompletable(h<T> hVar, j<? super T, ? extends f> jVar, boolean z10, int i10) {
        this.f30170a = hVar;
        this.f30171b = jVar;
        this.f30173d = z10;
        this.f30172c = i10;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        this.f30170a.m0(new FlatMapCompletableMainSubscriber(dVar, this.f30171b, this.f30173d, this.f30172c));
    }

    public h<T> i() {
        return bk.a.l(new FlowableFlatMapCompletable(this.f30170a, this.f30171b, this.f30173d, this.f30172c));
    }
}
