package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.j;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import qj.q;
import qj.u;
import qj.v;
import tj.b;

public final class ObservableInterval extends q<Long> {

    /* renamed from: a  reason: collision with root package name */
    final v f30349a;

    /* renamed from: b  reason: collision with root package name */
    final long f30350b;

    /* renamed from: c  reason: collision with root package name */
    final long f30351c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f30352d;

    static final class IntervalObserver extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final u<? super Long> downstream;

        IntervalObserver(u<? super Long> uVar) {
            this.downstream = uVar;
        }

        public void a(b bVar) {
            DisposableHelper.i(this, bVar);
        }

        public boolean c() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                u<? super Long> uVar = this.downstream;
                long j10 = this.count;
                this.count = 1 + j10;
                uVar.d(Long.valueOf(j10));
            }
        }
    }

    public ObservableInterval(long j10, long j11, TimeUnit timeUnit, v vVar) {
        this.f30350b = j10;
        this.f30351c = j11;
        this.f30352d = timeUnit;
        this.f30349a = vVar;
    }

    public void l0(u<? super Long> uVar) {
        IntervalObserver intervalObserver = new IntervalObserver(uVar);
        uVar.a(intervalObserver);
        v vVar = this.f30349a;
        if (vVar instanceof j) {
            v.c b10 = vVar.b();
            intervalObserver.a(b10);
            b10.e(intervalObserver, this.f30350b, this.f30351c, this.f30352d);
            return;
        }
        intervalObserver.a(vVar.e(intervalObserver, this.f30350b, this.f30351c, this.f30352d));
    }
}
