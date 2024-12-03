package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.q;
import qj.u;
import qj.v;
import tj.b;

public final class ObservableThrottleLatest<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f30388b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f30389c;

    /* renamed from: d  reason: collision with root package name */
    final v f30390d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f30391e;

    static final class ThrottleLatestObserver<T> extends AtomicInteger implements u<T>, b, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final u<? super T> downstream;
        final boolean emitLast;
        Throwable error;
        final AtomicReference<T> latest = new AtomicReference<>();
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        b upstream;
        final v.c worker;

        ThrottleLatestObserver(u<? super T> uVar, long j10, TimeUnit timeUnit, v.c cVar, boolean z10) {
            this.downstream = uVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
            this.emitLast = z10;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            boolean z10;
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.latest;
                u<? super T> uVar = this.downstream;
                int i10 = 1;
                while (!this.cancelled) {
                    boolean z11 = this.done;
                    if (!z11 || this.error == null) {
                        if (atomicReference.get() == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z11) {
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (!z10 && this.emitLast) {
                                uVar.d(andSet);
                            }
                            uVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        if (z10) {
                            if (this.timerFired) {
                                this.timerRunning = false;
                                this.timerFired = false;
                            }
                        } else if (!this.timerRunning || this.timerFired) {
                            uVar.d(atomicReference.getAndSet((Object) null));
                            this.timerFired = false;
                            this.timerRunning = true;
                            this.worker.d(this, this.timeout, this.unit);
                        }
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        uVar.onError(this.error);
                        this.worker.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public boolean c() {
            return this.cancelled;
        }

        public void d(T t10) {
            this.latest.set(t10);
            b();
        }

        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet((Object) null);
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

        public void run() {
            this.timerFired = true;
            b();
        }
    }

    public ObservableThrottleLatest(q<T> qVar, long j10, TimeUnit timeUnit, v vVar, boolean z10) {
        super(qVar);
        this.f30388b = j10;
        this.f30389c = timeUnit;
        this.f30390d = vVar;
        this.f30391e = z10;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        this.f30395a.e(new ThrottleLatestObserver(uVar, this.f30388b, this.f30389c, this.f30390d.b(), this.f30391e));
    }
}
