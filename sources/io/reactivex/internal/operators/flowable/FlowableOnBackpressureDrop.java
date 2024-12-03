package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import qj.h;
import qj.l;
import rn.b;
import rn.c;
import uj.a;
import vj.f;

public final class FlowableOnBackpressureDrop<T> extends a<T, T> implements f<T> {

    /* renamed from: c  reason: collision with root package name */
    final f<? super T> f30190c = this;

    static final class BackpressureDropSubscriber<T> extends AtomicLong implements l<T>, c {
        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final b<? super T> downstream;
        final f<? super T> onDrop;
        c upstream;

        BackpressureDropSubscriber(b<? super T> bVar, f<? super T> fVar) {
            this.downstream = bVar;
            this.onDrop = fVar;
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
                try {
                    this.onDrop.accept(t10);
                } catch (Throwable th2) {
                    a.b(th2);
                    cancel();
                    onError(th2);
                }
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
                bk.a.s(th2);
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

    public FlowableOnBackpressureDrop(h<T> hVar) {
        super(hVar);
    }

    public void accept(T t10) {
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new BackpressureDropSubscriber(bVar, this.f30190c));
    }
}
