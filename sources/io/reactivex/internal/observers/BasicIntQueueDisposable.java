package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;
import yj.d;

public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements d<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
