package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.UnicastProcessor;
import qj.h;
import rn.a;
import rn.b;
import rn.c;
import vj.j;

public final class FlowableRetryWhen<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final j<? super h<Throwable>, ? extends a<?>> f30196c;

    static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        RetryWhenSubscriber(b<? super T> bVar, io.reactivex.processors.a<Throwable> aVar, c cVar) {
            super(bVar, aVar, cVar);
        }

        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            h(th2);
        }
    }

    public FlowableRetryWhen(h<T> hVar, j<? super h<Throwable>, ? extends a<?>> jVar) {
        super(hVar);
        this.f30196c = jVar;
    }

    public void n0(b<? super T> bVar) {
        ek.a aVar = new ek.a(bVar);
        io.reactivex.processors.a A0 = UnicastProcessor.C0(8).A0();
        try {
            a aVar2 = (a) xj.b.e(this.f30196c.apply(A0), "handler returned a null Publisher");
            FlowableRepeatWhen$WhenReceiver flowableRepeatWhen$WhenReceiver = new FlowableRepeatWhen$WhenReceiver(this.f30214b);
            RetryWhenSubscriber retryWhenSubscriber = new RetryWhenSubscriber(aVar, A0, flowableRepeatWhen$WhenReceiver);
            flowableRepeatWhen$WhenReceiver.subscriber = retryWhenSubscriber;
            bVar.e(retryWhenSubscriber);
            aVar2.a(flowableRepeatWhen$WhenReceiver);
            flowableRepeatWhen$WhenReceiver.d(0);
        } catch (Throwable th2) {
            uj.a.b(th2);
            EmptySubscription.c(th2, bVar);
        }
    }
}
