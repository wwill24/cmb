package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import qj.q;
import qj.u;
import qj.v;
import tj.b;

public final class ObservableTimer extends q<Long> {

    /* renamed from: a  reason: collision with root package name */
    final v f30392a;

    /* renamed from: b  reason: collision with root package name */
    final long f30393b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f30394c;

    static final class TimerObserver extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final u<? super Long> downstream;

        TimerObserver(u<? super Long> uVar) {
            this.downstream = uVar;
        }

        public void a(b bVar) {
            DisposableHelper.j(this, bVar);
        }

        public boolean c() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void run() {
            if (!c()) {
                this.downstream.d(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onComplete();
            }
        }
    }

    public ObservableTimer(long j10, TimeUnit timeUnit, v vVar) {
        this.f30393b = j10;
        this.f30394c = timeUnit;
        this.f30392a = vVar;
    }

    public void l0(u<? super Long> uVar) {
        TimerObserver timerObserver = new TimerObserver(uVar);
        uVar.a(timerObserver);
        timerObserver.a(this.f30392a.d(timerObserver, this.f30393b, this.f30394c));
    }
}
