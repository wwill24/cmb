package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;
import yj.f;

public abstract class BasicQueueSubscription<T> extends AtomicLong implements f<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
