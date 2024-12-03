package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import qj.l;
import rn.b;
import rn.c;
import vj.a;
import yj.h;

public final class FlowableOnBackpressureBuffer<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final int f30186c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30187d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f30188e;

    /* renamed from: f  reason: collision with root package name */
    final a f30189f;

    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements l<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final b<? super T> downstream;
        Throwable error;
        final a onOverflow;
        boolean outputFused;
        final h<T> queue;
        final AtomicLong requested = new AtomicLong();
        c upstream;

        BackpressureBufferSubscriber(b<? super T> bVar, int i10, boolean z10, boolean z11, a aVar) {
            h<T> hVar;
            this.downstream = bVar;
            this.onOverflow = aVar;
            this.delayError = z11;
            if (z10) {
                hVar = new io.reactivex.internal.queue.a<>(i10);
            } else {
                hVar = new SpscArrayQueue<>(i10);
            }
            this.queue = hVar;
        }

        public int b(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        /* access modifiers changed from: package-private */
        public boolean c(boolean z10, boolean z11, b<? super T> bVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            } else if (!z10) {
                return false;
            } else {
                if (!this.delayError) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        bVar.onError(th2);
                        return true;
                    } else if (!z11) {
                        return false;
                    } else {
                        bVar.onComplete();
                        return true;
                    }
                } else if (!z11) {
                    return false;
                } else {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        bVar.onError(th3);
                    } else {
                        bVar.onComplete();
                    }
                    return true;
                }
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (!this.outputFused && getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void clear() {
            this.queue.clear();
        }

        public void d(T t10) {
            if (!this.queue.offer(t10)) {
                this.upstream.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.onOverflow.run();
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    missingBackpressureException.initCause(th2);
                }
                onError(missingBackpressureException);
            } else if (this.outputFused) {
                this.downstream.d(null);
            } else {
                g();
            }
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.e(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int i10;
            boolean z10;
            if (getAndIncrement() == 0) {
                h<T> hVar = this.queue;
                b<? super T> bVar = this.downstream;
                int i11 = 1;
                while (!c(this.done, hVar.isEmpty(), bVar)) {
                    long j10 = this.requested.get();
                    long j11 = 0;
                    while (true) {
                        i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                        if (i10 == 0) {
                            break;
                        }
                        boolean z11 = this.done;
                        T poll = hVar.poll();
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
                            j11++;
                        } else {
                            return;
                        }
                    }
                    if (i10 != 0 || !c(this.done, hVar.isEmpty(), bVar)) {
                        if (!(j11 == 0 || j10 == Long.MAX_VALUE)) {
                            this.requested.addAndGet(-j11);
                        }
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.downstream.onComplete();
            } else {
                g();
            }
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onError(th2);
            } else {
                g();
            }
        }

        public T poll() throws Exception {
            return this.queue.poll();
        }

        public void r(long j10) {
            if (!this.outputFused && SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                g();
            }
        }
    }

    public FlowableOnBackpressureBuffer(qj.h<T> hVar, int i10, boolean z10, boolean z11, a aVar) {
        super(hVar);
        this.f30186c = i10;
        this.f30187d = z10;
        this.f30188e = z11;
        this.f30189f = aVar;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new BackpressureBufferSubscriber(bVar, this.f30186c, this.f30187d, this.f30188e, this.f30189f));
    }
}
