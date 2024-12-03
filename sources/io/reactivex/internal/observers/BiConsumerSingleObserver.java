package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.z;
import tj.b;
import uj.a;

public final class BiConsumerSingleObserver<T> extends AtomicReference<b> implements z<T>, b {
    private static final long serialVersionUID = 4943102778943297569L;
    final vj.b<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(vj.b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    public void a(b bVar) {
        DisposableHelper.i(this, bVar);
    }

    public boolean c() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public void onError(Throwable th2) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.accept(null, th2);
        } catch (Throwable th3) {
            a.b(th3);
            bk.a.s(new CompositeException(th2, th3));
        }
    }

    public void onSuccess(T t10) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.accept(t10, null);
        } catch (Throwable th2) {
            a.b(th2);
            bk.a.s(th2);
        }
    }
}
