package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import qj.l;
import rn.b;
import rn.c;

public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements l<T>, c {
    private static final long serialVersionUID = 7917814472626990048L;
    protected final b<? super R> downstream;
    protected long produced;
    protected c upstream;
    protected R value;

    public SinglePostCompleteSubscriber(b<? super R> bVar) {
        this.downstream = bVar;
    }

    /* access modifiers changed from: protected */
    public final void a(R r10) {
        long j10 = this.produced;
        if (j10 != 0) {
            io.reactivex.internal.util.b.c(this, j10);
        }
        while (true) {
            long j11 = get();
            if ((j11 & Long.MIN_VALUE) != 0) {
                b(r10);
                return;
            } else if ((j11 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.downstream.d(r10);
                this.downstream.onComplete();
                return;
            } else {
                this.value = r10;
                if (!compareAndSet(0, Long.MIN_VALUE)) {
                    this.value = null;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(R r10) {
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void e(c cVar) {
        if (SubscriptionHelper.k(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.e(this);
        }
    }

    public final void r(long j10) {
        long j11;
        if (SubscriptionHelper.j(j10)) {
            do {
                j11 = get();
                if ((j11 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.downstream.d(this.value);
                        this.downstream.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j11, io.reactivex.internal.util.b.b(j11, j10)));
            this.upstream.r(j10);
        }
    }
}
