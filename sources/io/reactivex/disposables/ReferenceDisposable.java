package io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;
import tj.b;

abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    ReferenceDisposable(T t10) {
        super(xj.b.e(t10, "value is null"));
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t10);

    public final boolean c() {
        return get() == null;
    }

    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet((Object) null)) != null) {
            a(andSet);
        }
    }
}
