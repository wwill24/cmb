package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
import qj.d;
import qj.f;
import qj.h;
import qj.l;
import rn.b;
import rn.c;
import tj.a;
import vj.j;

public final class FlowableFlatMapCompletable<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final j<? super T, ? extends f> f30167c;

    /* renamed from: d  reason: collision with root package name */
    final int f30168d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f30169e;

    static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements l<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        volatile boolean cancelled;
        final boolean delayErrors;
        final b<? super T> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final j<? super T, ? extends f> mapper;
        final int maxConcurrency;
        final a set = new a();
        c upstream;

        final class InnerConsumer extends AtomicReference<tj.b> implements d, tj.b {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerConsumer() {
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
                FlatMapCompletableMainSubscriber.this.c(this);
            }

            public void onError(Throwable th2) {
                FlatMapCompletableMainSubscriber.this.g(this, th2);
            }
        }

        FlatMapCompletableMainSubscriber(b<? super T> bVar, j<? super T, ? extends f> jVar, boolean z10, int i10) {
            this.downstream = bVar;
            this.mapper = jVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
            lazySet(1);
        }

        public int b(int i10) {
            return i10 & 2;
        }

        /* access modifiers changed from: package-private */
        public void c(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
            this.set.b(innerConsumer);
            onComplete();
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        public void clear() {
        }

        public void d(T t10) {
            try {
                f fVar = (f) xj.b.e(this.mapper.apply(t10), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerConsumer innerConsumer = new InnerConsumer();
                if (!this.cancelled && this.set.a(innerConsumer)) {
                    fVar.e(innerConsumer);
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.e(this);
                int i10 = this.maxConcurrency;
                if (i10 == Integer.MAX_VALUE) {
                    cVar.r(Long.MAX_VALUE);
                } else {
                    cVar.r((long) i10);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th2) {
            this.set.b(innerConsumer);
            onError(th2);
        }

        public boolean isEmpty() {
            return true;
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
                cancel();
                if (getAndSet(0) > 0) {
                    this.downstream.onError(this.errors.b());
                }
            } else if (decrementAndGet() == 0) {
                this.downstream.onError(this.errors.b());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.r(1);
            }
        }

        public T poll() throws Exception {
            return null;
        }

        public void r(long j10) {
        }
    }

    public FlowableFlatMapCompletable(h<T> hVar, j<? super T, ? extends f> jVar, boolean z10, int i10) {
        super(hVar);
        this.f30167c = jVar;
        this.f30169e = z10;
        this.f30168d = i10;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new FlatMapCompletableMainSubscriber(bVar, this.f30167c, this.f30169e, this.f30168d));
    }
}
