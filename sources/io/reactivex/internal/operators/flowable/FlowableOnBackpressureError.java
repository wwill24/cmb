package io.reactivex.internal.operators.flowable;

import bk.a;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import qj.h;
import qj.l;
import rn.b;
import rn.c;

public final class FlowableOnBackpressureError<T> extends a<T, T> {

    static final class BackpressureErrorSubscriber<T> extends AtomicLong implements l<T>, c {
        private static final long serialVersionUID = -3176480756392482682L;
        boolean done;
        final b<? super T> downstream;
        c upstream;

        BackpressureErrorSubscriber(b<? super T> bVar) {
            this.downstream = bVar;
        }

        public void cancel() {
            this.upstream.cancel();
        }

        public void d(T t10) {
            if (!this.done) {
                if (get() != 0) {
                    this.downstream.d(t10);
                    io.reactivex.internal.util.b.c(this, 1);
                    return;
                }
                this.upstream.cancel();
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            }
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.e(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                a.s(th2);
                return;
            }
            this.done = true;
            this.downstream.onError(th2);
        }

        public void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(this, j10);
            }
        }
    }

    public FlowableOnBackpressureError(h<T> hVar) {
        super(hVar);
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new BackpressureErrorSubscriber(bVar));
    }
}
