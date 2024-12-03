package io.reactivex.internal.operators.flowable;

import bk.a;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import qj.h;
import qj.l;
import qj.v;
import rn.b;
import rn.c;
import yj.f;
import yj.i;

public final class FlowableObserveOn<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final v f30183c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30184d;

    /* renamed from: e  reason: collision with root package name */
    final int f30185e;

    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements l<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        i<T> queue;
        final AtomicLong requested = new AtomicLong();
        int sourceMode;
        c upstream;
        final v.c worker;

        BaseObserveOnSubscriber(v.c cVar, boolean z10, int i10) {
            this.worker = cVar;
            this.delayError = z10;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
        }

        public final int b(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        /* access modifiers changed from: package-private */
        public final boolean c(boolean z10, boolean z11, b<?> bVar) {
            if (this.cancelled) {
                clear();
                return true;
            } else if (!z10) {
                return false;
            } else {
                if (!this.delayError) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.cancelled = true;
                        clear();
                        bVar.onError(th2);
                        this.worker.dispose();
                        return true;
                    } else if (!z11) {
                        return false;
                    } else {
                        this.cancelled = true;
                        bVar.onComplete();
                        this.worker.dispose();
                        return true;
                    }
                } else if (!z11) {
                    return false;
                } else {
                    this.cancelled = true;
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        bVar.onError(th3);
                    } else {
                        bVar.onComplete();
                    }
                    this.worker.dispose();
                    return true;
                }
            }
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                this.worker.dispose();
                if (!this.outputFused && getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public final void clear() {
            this.queue.clear();
        }

        public final void d(T t10) {
            if (!this.done) {
                if (this.sourceMode == 2) {
                    j();
                    return;
                }
                if (!this.queue.offer(t10)) {
                    this.upstream.cancel();
                    this.error = new MissingBackpressureException("Queue is full?!");
                    this.done = true;
                }
                j();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void g();

        /* access modifiers changed from: package-private */
        public abstract void h();

        /* access modifiers changed from: package-private */
        public abstract void i();

        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public final void j() {
            if (getAndIncrement() == 0) {
                this.worker.b(this);
            }
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                j();
            }
        }

        public final void onError(Throwable th2) {
            if (this.done) {
                a.s(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            j();
        }

        public final void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                j();
            }
        }

        public final void run() {
            if (this.outputFused) {
                h();
            } else if (this.sourceMode == 1) {
                i();
            } else {
                g();
            }
        }
    }

    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        long consumed;
        final yj.a<? super T> downstream;

        ObserveOnConditionalSubscriber(yj.a<? super T> aVar, v.c cVar, boolean z10, int i10) {
            super(cVar, z10, i10);
            this.downstream = aVar;
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof f) {
                    f fVar = (f) cVar;
                    int b10 = fVar.b(7);
                    if (b10 == 1) {
                        this.sourceMode = 1;
                        this.queue = fVar;
                        this.done = true;
                        this.downstream.e(this);
                        return;
                    } else if (b10 == 2) {
                        this.sourceMode = 2;
                        this.queue = fVar;
                        this.downstream.e(this);
                        cVar.r((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.e(this);
                cVar.r((long) this.prefetch);
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int i10;
            boolean z10;
            yj.a<? super T> aVar = this.downstream;
            i<T> iVar = this.queue;
            long j10 = this.produced;
            long j11 = this.consumed;
            int i11 = 1;
            while (true) {
                long j12 = this.requested.get();
                while (true) {
                    i10 = (j10 > j12 ? 1 : (j10 == j12 ? 0 : -1));
                    if (i10 == 0) {
                        break;
                    }
                    boolean z11 = this.done;
                    try {
                        T poll = iVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!c(z11, z10, aVar)) {
                            if (z10) {
                                break;
                            }
                            if (aVar.f(poll)) {
                                j10++;
                            }
                            j11++;
                            if (j11 == ((long) this.limit)) {
                                this.upstream.r(j11);
                                j11 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        iVar.clear();
                        aVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (i10 != 0 || !c(this.done, iVar.isEmpty(), aVar)) {
                    int i12 = get();
                    if (i11 == i12) {
                        this.produced = j10;
                        this.consumed = j11;
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        i11 = i12;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int i10 = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                this.downstream.d(null);
                if (z10) {
                    this.cancelled = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            yj.a<? super T> aVar = this.downstream;
            i<T> iVar = this.queue;
            long j10 = this.produced;
            int i10 = 1;
            while (true) {
                long j11 = this.requested.get();
                while (j10 != j11) {
                    try {
                        T poll = iVar.poll();
                        if (!this.cancelled) {
                            if (poll == null) {
                                this.cancelled = true;
                                aVar.onComplete();
                                this.worker.dispose();
                                return;
                            } else if (aVar.f(poll)) {
                                j10++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        aVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (!this.cancelled) {
                    if (iVar.isEmpty()) {
                        this.cancelled = true;
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    int i11 = get();
                    if (i10 == i11) {
                        this.produced = j10;
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        i10 = i11;
                    }
                } else {
                    return;
                }
            }
        }

        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (!(poll == null || this.sourceMode == 1)) {
                long j10 = this.consumed + 1;
                if (j10 == ((long) this.limit)) {
                    this.consumed = 0;
                    this.upstream.r(j10);
                } else {
                    this.consumed = j10;
                }
            }
            return poll;
        }
    }

    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final b<? super T> downstream;

        ObserveOnSubscriber(b<? super T> bVar, v.c cVar, boolean z10, int i10) {
            super(cVar, z10, i10);
            this.downstream = bVar;
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof f) {
                    f fVar = (f) cVar;
                    int b10 = fVar.b(7);
                    if (b10 == 1) {
                        this.sourceMode = 1;
                        this.queue = fVar;
                        this.done = true;
                        this.downstream.e(this);
                        return;
                    } else if (b10 == 2) {
                        this.sourceMode = 2;
                        this.queue = fVar;
                        this.downstream.e(this);
                        cVar.r((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.e(this);
                cVar.r((long) this.prefetch);
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int i10;
            boolean z10;
            b<? super T> bVar = this.downstream;
            i<T> iVar = this.queue;
            long j10 = this.produced;
            int i11 = 1;
            while (true) {
                long j11 = this.requested.get();
                while (true) {
                    i10 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
                    if (i10 == 0) {
                        break;
                    }
                    boolean z11 = this.done;
                    try {
                        T poll = iVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!c(z11, z10, bVar)) {
                            if (z10) {
                                break;
                            }
                            bVar.d(poll);
                            j10++;
                            if (j10 == ((long) this.limit)) {
                                if (j11 != Long.MAX_VALUE) {
                                    j11 = this.requested.addAndGet(-j10);
                                }
                                this.upstream.r(j10);
                                j10 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        iVar.clear();
                        bVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (i10 != 0 || !c(this.done, iVar.isEmpty(), bVar)) {
                    int i12 = get();
                    if (i11 == i12) {
                        this.produced = j10;
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        i11 = i12;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int i10 = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                this.downstream.d(null);
                if (z10) {
                    this.cancelled = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            b<? super T> bVar = this.downstream;
            i<T> iVar = this.queue;
            long j10 = this.produced;
            int i10 = 1;
            while (true) {
                long j11 = this.requested.get();
                while (j10 != j11) {
                    try {
                        T poll = iVar.poll();
                        if (!this.cancelled) {
                            if (poll == null) {
                                this.cancelled = true;
                                bVar.onComplete();
                                this.worker.dispose();
                                return;
                            }
                            bVar.d(poll);
                            j10++;
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        bVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (!this.cancelled) {
                    if (iVar.isEmpty()) {
                        this.cancelled = true;
                        bVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    int i11 = get();
                    if (i10 == i11) {
                        this.produced = j10;
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        i10 = i11;
                    }
                } else {
                    return;
                }
            }
        }

        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (!(poll == null || this.sourceMode == 1)) {
                long j10 = this.produced + 1;
                if (j10 == ((long) this.limit)) {
                    this.produced = 0;
                    this.upstream.r(j10);
                } else {
                    this.produced = j10;
                }
            }
            return poll;
        }
    }

    public FlowableObserveOn(h<T> hVar, v vVar, boolean z10, int i10) {
        super(hVar);
        this.f30183c = vVar;
        this.f30184d = z10;
        this.f30185e = i10;
    }

    public void n0(b<? super T> bVar) {
        v.c b10 = this.f30183c.b();
        if (bVar instanceof yj.a) {
            this.f30214b.m0(new ObserveOnConditionalSubscriber((yj.a) bVar, b10, this.f30184d, this.f30185e));
        } else {
            this.f30214b.m0(new ObserveOnSubscriber(bVar, b10, this.f30184d, this.f30185e));
        }
    }
}
