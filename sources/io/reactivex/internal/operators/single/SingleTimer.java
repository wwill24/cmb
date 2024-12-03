package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import qj.v;
import qj.w;
import qj.z;
import tj.b;

public final class SingleTimer extends w<Long> {

    /* renamed from: a  reason: collision with root package name */
    final long f30539a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f30540b;

    /* renamed from: c  reason: collision with root package name */
    final v f30541c;

    static final class TimerDisposable extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final z<? super Long> downstream;

        TimerDisposable(z<? super Long> zVar) {
            this.downstream = zVar;
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            DisposableHelper.d(this, bVar);
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void run() {
            this.downstream.onSuccess(0L);
        }
    }

    public SingleTimer(long j10, TimeUnit timeUnit, v vVar) {
        this.f30539a = j10;
        this.f30540b = timeUnit;
        this.f30541c = vVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super Long> zVar) {
        TimerDisposable timerDisposable = new TimerDisposable(zVar);
        zVar.a(timerDisposable);
        timerDisposable.a(this.f30541c.d(timerDisposable, this.f30539a, this.f30540b));
    }
}
