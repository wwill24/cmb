package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import qj.h;
import qj.l;
import qj.v;
import rn.b;
import rn.c;

public final class FlowableUnsubscribeOn<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final v f30207c;

    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements l<T>, c {
        private static final long serialVersionUID = 1015244841293359600L;
        final b<? super T> downstream;
        final v scheduler;
        c upstream;

        final class a implements Runnable {
            a() {
            }

            public void run() {
                UnsubscribeSubscriber.this.upstream.cancel();
            }
        }

        UnsubscribeSubscriber(b<? super T> bVar, v vVar) {
            this.downstream = bVar;
            this.scheduler = vVar;
        }

        public void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.c(new a());
            }
        }

        public void d(T t10) {
            if (!get()) {
                this.downstream.d(t10);
            }
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.e(this);
            }
        }

        public void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get()) {
                bk.a.s(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        public void r(long j10) {
            this.upstream.r(j10);
        }
    }

    public FlowableUnsubscribeOn(h<T> hVar, v vVar) {
        super(hVar);
        this.f30207c = vVar;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new UnsubscribeSubscriber(bVar, this.f30207c));
    }
}
