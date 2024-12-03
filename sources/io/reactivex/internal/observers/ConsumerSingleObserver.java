package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.z;
import tj.b;
import uj.a;
import vj.f;

public final class ConsumerSingleObserver<T> extends AtomicReference<b> implements z<T>, b {
    private static final long serialVersionUID = -7012088219455310787L;
    final f<? super Throwable> onError;
    final f<? super T> onSuccess;

    public ConsumerSingleObserver(f<? super T> fVar, f<? super Throwable> fVar2) {
        this.onSuccess = fVar;
        this.onError = fVar2;
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
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            a.b(th3);
            bk.a.s(new CompositeException(th2, th3));
        }
    }

    public void onSuccess(T t10) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t10);
        } catch (Throwable th2) {
            a.b(th2);
            bk.a.s(th2);
        }
    }
}
