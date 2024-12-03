package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.processors.a;
import qj.l;
import rn.b;
import rn.c;

abstract class FlowableRepeatWhen$WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements l<T> {
    private static final long serialVersionUID = -5604623027276966720L;
    protected final b<? super T> downstream;
    protected final a<U> processor;
    private long produced;
    protected final c receiver;

    FlowableRepeatWhen$WhenSourceSubscriber(b<? super T> bVar, a<U> aVar, c cVar) {
        super(false);
        this.downstream = bVar;
        this.processor = aVar;
        this.receiver = cVar;
    }

    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    public final void d(T t10) {
        this.produced++;
        this.downstream.d(t10);
    }

    public final void e(c cVar) {
        g(cVar);
    }

    /* access modifiers changed from: protected */
    public final void h(U u10) {
        g(EmptySubscription.INSTANCE);
        long j10 = this.produced;
        if (j10 != 0) {
            this.produced = 0;
            c(j10);
        }
        this.receiver.r(1);
        this.processor.d(u10);
    }
}
