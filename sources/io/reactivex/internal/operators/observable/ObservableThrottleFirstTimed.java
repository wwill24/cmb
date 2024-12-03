package io.reactivex.internal.operators.observable;

import ak.c;
import bk.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import qj.s;
import qj.u;
import qj.v;
import tj.b;

public final class ObservableThrottleFirstTimed<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f30385b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f30386c;

    /* renamed from: d  reason: collision with root package name */
    final v f30387d;

    static final class DebounceTimedObserver<T> extends AtomicReference<b> implements u<T>, b, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        boolean done;
        final u<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final TimeUnit unit;
        b upstream;
        final v.c worker;

        DebounceTimedObserver(u<? super T> uVar, long j10, TimeUnit timeUnit, v.c cVar) {
            this.downstream = uVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a(this);
            }
        }

        public boolean c() {
            return this.worker.c();
        }

        public void d(T t10) {
            if (!this.gate && !this.done) {
                this.gate = true;
                this.downstream.d(t10);
                b bVar = (b) get();
                if (bVar != null) {
                    bVar.dispose();
                }
                DisposableHelper.d(this, this.worker.d(this, this.timeout, this.unit));
            }
        }

        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                a.s(th2);
                return;
            }
            this.done = true;
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        public void run() {
            this.gate = false;
        }
    }

    public ObservableThrottleFirstTimed(s<T> sVar, long j10, TimeUnit timeUnit, v vVar) {
        super(sVar);
        this.f30385b = j10;
        this.f30386c = timeUnit;
        this.f30387d = vVar;
    }

    public void l0(u<? super T> uVar) {
        this.f30395a.e(new DebounceTimedObserver(new c(uVar), this.f30385b, this.f30386c, this.f30387d.b()));
    }
}
