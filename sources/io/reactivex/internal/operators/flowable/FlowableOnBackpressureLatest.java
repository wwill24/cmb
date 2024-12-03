package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.h;
import qj.l;
import rn.b;
import rn.c;

public final class FlowableOnBackpressureLatest<T> extends a<T, T> {

    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements l<T>, c {
        private static final long serialVersionUID = 163080509307634843L;
        volatile boolean cancelled;
        final AtomicReference<T> current = new AtomicReference<>();
        volatile boolean done;
        final b<? super T> downstream;
        Throwable error;
        final AtomicLong requested = new AtomicLong();
        c upstream;

        BackpressureLatestSubscriber(b<? super T> bVar) {
            this.downstream = bVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z10, boolean z11, b<?> bVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet((Object) null);
                return true;
            } else if (!z10) {
                return false;
            } else {
                Throwable th2 = this.error;
                if (th2 != null) {
                    atomicReference.lazySet((Object) null);
                    bVar.onError(th2);
                    return true;
                } else if (!z11) {
                    return false;
                } else {
                    bVar.onComplete();
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            boolean z10;
            boolean z11;
            if (getAndIncrement() == 0) {
                b<? super T> bVar = this.downstream;
                AtomicLong atomicLong = this.requested;
                AtomicReference<T> atomicReference = this.current;
                int i10 = 1;
                do {
                    long j10 = 0;
                    while (true) {
                        z10 = false;
                        if (j10 == atomicLong.get()) {
                            break;
                        }
                        boolean z12 = this.done;
                        T andSet = atomicReference.getAndSet((Object) null);
                        if (andSet == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!a(z12, z11, bVar, atomicReference)) {
                            if (z11) {
                                break;
                            }
                            bVar.d(andSet);
                            j10++;
                        } else {
                            return;
                        }
                    }
                    if (j10 == atomicLong.get()) {
                        boolean z13 = this.done;
                        if (atomicReference.get() == null) {
                            z10 = true;
                        }
                        if (a(z13, z10, bVar, atomicReference)) {
                            return;
                        }
                    }
                    if (j10 != 0) {
                        io.reactivex.internal.util.b.c(atomicLong, j10);
                    }
                    i10 = addAndGet(-i10);
                } while (i10 != 0);
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.current.lazySet((Object) null);
                }
            }
        }

        public void d(T t10) {
            this.current.lazySet(t10);
            b();
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.e(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.done = true;
            b();
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            b();
        }

        public void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }
    }

    public FlowableOnBackpressureLatest(h<T> hVar) {
        super(hVar);
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new BackpressureLatestSubscriber(bVar));
    }
}
