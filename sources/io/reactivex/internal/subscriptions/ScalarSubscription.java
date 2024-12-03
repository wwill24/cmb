package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import rn.b;
import yj.f;

public final class ScalarSubscription<T> extends AtomicInteger implements f<T> {
    private static final long serialVersionUID = -3830916580126663321L;
    final b<? super T> subscriber;
    final T value;

    public ScalarSubscription(b<? super T> bVar, T t10) {
        this.subscriber = bVar;
        this.value = t10;
    }

    public int b(int i10) {
        return i10 & 1;
    }

    public void cancel() {
        lazySet(2);
    }

    public void clear() {
        lazySet(1);
    }

    public boolean isEmpty() {
        return get() != 0;
    }

    public boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    public void r(long j10) {
        if (SubscriptionHelper.j(j10) && compareAndSet(0, 1)) {
            b<? super T> bVar = this.subscriber;
            bVar.d(this.value);
            if (get() != 2) {
                bVar.onComplete();
            }
        }
    }
}
