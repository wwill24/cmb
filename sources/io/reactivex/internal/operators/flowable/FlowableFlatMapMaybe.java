package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.h;
import qj.l;
import qj.n;
import qj.o;
import rn.b;
import rn.c;
import vj.j;

public final class FlowableFlatMapMaybe<T, R> extends a<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final j<? super T, ? extends o<? extends R>> f30174c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30175d;

    /* renamed from: e  reason: collision with root package name */
    final int f30176e;

    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements l<T>, c {
        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active = new AtomicInteger(1);
        volatile boolean cancelled;
        final boolean delayErrors;
        final b<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final j<? super T, ? extends o<? extends R>> mapper;
        final int maxConcurrency;
        final AtomicReference<a<R>> queue = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final tj.a set = new tj.a();
        c upstream;

        final class InnerObserver extends AtomicReference<tj.b> implements n<R>, tj.b {
            private static final long serialVersionUID = -502562646270949838L;

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
                FlatMapMaybeSubscriber.this.h(this);
            }

            public void onError(Throwable th2) {
                FlatMapMaybeSubscriber.this.i(this, th2);
            }

            public void onSuccess(R r10) {
                FlatMapMaybeSubscriber.this.j(this, r10);
            }
        }

        FlatMapMaybeSubscriber(b<? super R> bVar, j<? super T, ? extends o<? extends R>> jVar, boolean z10, int i10) {
            this.downstream = bVar;
            this.mapper = jVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            a aVar = this.queue.get();
            if (aVar != null) {
                aVar.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            int i10;
            boolean z10;
            boolean z11;
            boolean z12;
            Object obj;
            boolean z13;
            b<? super R> bVar = this.downstream;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<a<R>> atomicReference = this.queue;
            int i11 = 1;
            do {
                long j10 = this.requested.get();
                long j11 = 0;
                while (true) {
                    i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                    z10 = false;
                    if (i10 == 0) {
                        break;
                    } else if (this.cancelled) {
                        a();
                        return;
                    } else if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                        if (atomicInteger.get() == 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        a aVar = atomicReference.get();
                        if (aVar != null) {
                            obj = aVar.poll();
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (z12 && z13) {
                            Throwable b10 = this.errors.b();
                            if (b10 != null) {
                                bVar.onError(b10);
                                return;
                            } else {
                                bVar.onComplete();
                                return;
                            }
                        } else if (z13) {
                            break;
                        } else {
                            bVar.d(obj);
                            j11++;
                        }
                    } else {
                        Throwable b11 = this.errors.b();
                        a();
                        bVar.onError(b11);
                        return;
                    }
                }
                if (i10 == 0) {
                    if (this.cancelled) {
                        a();
                        return;
                    } else if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                        if (atomicInteger.get() == 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        a aVar2 = atomicReference.get();
                        if (aVar2 == null || aVar2.isEmpty()) {
                            z10 = true;
                        }
                        if (z11 && z10) {
                            Throwable b12 = this.errors.b();
                            if (b12 != null) {
                                bVar.onError(b12);
                                return;
                            } else {
                                bVar.onComplete();
                                return;
                            }
                        }
                    } else {
                        Throwable b13 = this.errors.b();
                        a();
                        bVar.onError(b13);
                        return;
                    }
                }
                if (j11 != 0) {
                    io.reactivex.internal.util.b.c(this.requested, j11);
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.r(j11);
                    }
                }
                i11 = addAndGet(-i11);
            } while (i11 != 0);
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        public void d(T t10) {
            try {
                o oVar = (o) xj.b.e(this.mapper.apply(t10), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.cancelled && this.set.a(innerObserver)) {
                    oVar.a(innerObserver);
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
        public a<R> g() {
            a<R> aVar;
            do {
                a<R> aVar2 = this.queue.get();
                if (aVar2 != null) {
                    return aVar2;
                }
                aVar = new a<>(h.j());
            } while (!androidx.camera.view.h.a(this.queue, (Object) null, aVar));
            return aVar;
        }

        /* access modifiers changed from: package-private */
        public void h(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.set.b(innerObserver);
            if (get() == 0) {
                boolean z10 = false;
                if (compareAndSet(0, 1)) {
                    if (this.active.decrementAndGet() == 0) {
                        z10 = true;
                    }
                    a aVar = this.queue.get();
                    if (!z10 || (aVar != null && !aVar.isEmpty())) {
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.upstream.r(1);
                        }
                        if (decrementAndGet() != 0) {
                            c();
                            return;
                        }
                        return;
                    }
                    Throwable b10 = this.errors.b();
                    if (b10 != null) {
                        this.downstream.onError(b10);
                        return;
                    } else {
                        this.downstream.onComplete();
                        return;
                    }
                }
            }
            this.active.decrementAndGet();
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.r(1);
            }
            b();
        }

        /* access modifiers changed from: package-private */
        public void i(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.set.b(innerObserver);
            if (this.errors.a(th2)) {
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    this.set.dispose();
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.r(1);
                }
                this.active.decrementAndGet();
                b();
                return;
            }
            bk.a.s(th2);
        }

        /* access modifiers changed from: package-private */
        public void j(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r10) {
            this.set.b(innerObserver);
            if (get() == 0) {
                boolean z10 = false;
                if (compareAndSet(0, 1)) {
                    if (this.active.decrementAndGet() == 0) {
                        z10 = true;
                    }
                    if (this.requested.get() != 0) {
                        this.downstream.d(r10);
                        a aVar = this.queue.get();
                        if (!z10 || (aVar != null && !aVar.isEmpty())) {
                            io.reactivex.internal.util.b.c(this.requested, 1);
                            if (this.maxConcurrency != Integer.MAX_VALUE) {
                                this.upstream.r(1);
                            }
                        } else {
                            Throwable b10 = this.errors.b();
                            if (b10 != null) {
                                this.downstream.onError(b10);
                                return;
                            } else {
                                this.downstream.onComplete();
                                return;
                            }
                        }
                    } else {
                        a g10 = g();
                        synchronized (g10) {
                            g10.offer(r10);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    c();
                }
            }
            a g11 = g();
            synchronized (g11) {
                g11.offer(r10);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        public void onComplete() {
            this.active.decrementAndGet();
            b();
        }

        public void onError(Throwable th2) {
            this.active.decrementAndGet();
            if (this.errors.a(th2)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                b();
                return;
            }
            bk.a.s(th2);
        }

        public void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }
    }

    public FlowableFlatMapMaybe(h<T> hVar, j<? super T, ? extends o<? extends R>> jVar, boolean z10, int i10) {
        super(hVar);
        this.f30174c = jVar;
        this.f30175d = z10;
        this.f30176e = i10;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super R> bVar) {
        this.f30214b.m0(new FlatMapMaybeSubscriber(bVar, this.f30174c, this.f30175d, this.f30176e));
    }
}
