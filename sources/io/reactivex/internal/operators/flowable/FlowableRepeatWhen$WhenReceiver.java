package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.l;
import rn.a;
import rn.c;

final class FlowableRepeatWhen$WhenReceiver<T, U> extends AtomicInteger implements l<Object>, c {
    private static final long serialVersionUID = 2827772011130406689L;
    final AtomicLong requested = new AtomicLong();
    final a<T> source;
    FlowableRepeatWhen$WhenSourceSubscriber<T, U> subscriber;
    final AtomicReference<c> upstream = new AtomicReference<>();

    FlowableRepeatWhen$WhenReceiver(a<T> aVar) {
        this.source = aVar;
    }

    public void cancel() {
        SubscriptionHelper.a(this.upstream);
    }

    public void d(Object obj) {
        if (getAndIncrement() == 0) {
            while (this.upstream.get() != SubscriptionHelper.CANCELLED) {
                this.source.a(this.subscriber);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public void e(c cVar) {
        SubscriptionHelper.c(this.upstream, this.requested, cVar);
    }

    public void onComplete() {
        this.subscriber.cancel();
        this.subscriber.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.subscriber.cancel();
        this.subscriber.downstream.onError(th2);
    }

    public void r(long j10) {
        SubscriptionHelper.b(this.upstream, this.requested, j10);
    }
}
