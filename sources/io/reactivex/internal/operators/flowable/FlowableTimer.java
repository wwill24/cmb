package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import qj.h;
import qj.v;
import rn.c;
import tj.b;

public final class FlowableTimer extends h<Long> {

    /* renamed from: b  reason: collision with root package name */
    final v f30203b;

    /* renamed from: c  reason: collision with root package name */
    final long f30204c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f30205d;

    static final class TimerSubscriber extends AtomicReference<b> implements c, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final rn.b<? super Long> downstream;
        volatile boolean requested;

        TimerSubscriber(rn.b<? super Long> bVar) {
            this.downstream = bVar;
        }

        public void a(b bVar) {
            DisposableHelper.j(this, bVar);
        }

        public void cancel() {
            DisposableHelper.a(this);
        }

        public void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                this.requested = true;
            }
        }

        public void run() {
            if (get() == DisposableHelper.DISPOSED) {
                return;
            }
            if (this.requested) {
                this.downstream.d(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onComplete();
                return;
            }
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }
    }

    public FlowableTimer(long j10, TimeUnit timeUnit, v vVar) {
        this.f30204c = j10;
        this.f30205d = timeUnit;
        this.f30203b = vVar;
    }

    public void n0(rn.b<? super Long> bVar) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(bVar);
        bVar.e(timerSubscriber);
        timerSubscriber.a(this.f30203b.d(timerSubscriber, this.f30204c, this.f30205d));
    }
}
