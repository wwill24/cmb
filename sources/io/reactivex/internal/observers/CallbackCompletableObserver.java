package io.reactivex.internal.observers;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.d;
import tj.b;
import vj.a;
import vj.f;

public final class CallbackCompletableObserver extends AtomicReference<b> implements d, b, f<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    final a onComplete;
    final f<? super Throwable> onError;

    public CallbackCompletableObserver(a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    public void a(b bVar) {
        DisposableHelper.i(this, bVar);
    }

    /* renamed from: b */
    public void accept(Throwable th2) {
        bk.a.s(new OnErrorNotImplementedException(th2));
    }

    public boolean c() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            uj.a.b(th2);
            bk.a.s(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable th2) {
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            uj.a.b(th3);
            bk.a.s(th3);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public CallbackCompletableObserver(f<? super Throwable> fVar, a aVar) {
        this.onError = fVar;
        this.onComplete = aVar;
    }
}
