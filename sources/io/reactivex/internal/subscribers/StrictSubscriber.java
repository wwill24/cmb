package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.l;
import rn.b;
import rn.c;

public class StrictSubscriber<T> extends AtomicInteger implements l<T>, c {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final b<? super T> downstream;
    final AtomicThrowable error = new AtomicThrowable();
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<c> upstream = new AtomicReference<>();

    public StrictSubscriber(b<? super T> bVar) {
        this.downstream = bVar;
    }

    public void cancel() {
        if (!this.done) {
            SubscriptionHelper.a(this.upstream);
        }
    }

    public void d(T t10) {
        e.f(this.downstream, t10, this, this.error);
    }

    public void e(c cVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.e(this);
            SubscriptionHelper.c(this.upstream, this.requested, cVar);
            return;
        }
        cVar.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void onComplete() {
        this.done = true;
        e.b(this.downstream, this, this.error);
    }

    public void onError(Throwable th2) {
        this.done = true;
        e.d(this.downstream, th2, this, this.error);
    }

    public void r(long j10) {
        if (j10 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j10));
            return;
        }
        SubscriptionHelper.b(this.upstream, this.requested, j10);
    }
}
