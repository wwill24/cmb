package io.reactivex.internal.observers;

import bk.a;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.d;
import tj.b;

public final class EmptyCompletableObserver extends AtomicReference<b> implements d, b {
    private static final long serialVersionUID = -7545121636549663526L;

    public void a(b bVar) {
        DisposableHelper.i(this, bVar);
    }

    public boolean c() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        a.s(new OnErrorNotImplementedException(th2));
    }
}
