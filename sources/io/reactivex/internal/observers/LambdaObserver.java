package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.u;
import tj.b;
import vj.a;
import vj.f;

public final class LambdaObserver<T> extends AtomicReference<b> implements u<T>, b {
    private static final long serialVersionUID = -7251123623727029452L;
    final a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onNext;
    final f<? super b> onSubscribe;

    public LambdaObserver(f<? super T> fVar, f<? super Throwable> fVar2, a aVar, f<? super b> fVar3) {
        this.onNext = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
        this.onSubscribe = fVar3;
    }

    public void a(b bVar) {
        if (DisposableHelper.i(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th2) {
                uj.a.b(th2);
                bVar.dispose();
                onError(th2);
            }
        }
    }

    public boolean c() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void d(T t10) {
        if (!c()) {
            try {
                this.onNext.accept(t10);
            } catch (Throwable th2) {
                uj.a.b(th2);
                ((b) get()).dispose();
                onError(th2);
            }
        }
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public void onComplete() {
        if (!c()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onComplete.run();
            } catch (Throwable th2) {
                uj.a.b(th2);
                bk.a.s(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (!c()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onError.accept(th2);
            } catch (Throwable th3) {
                uj.a.b(th3);
                bk.a.s(new CompositeException(th2, th3));
            }
        } else {
            bk.a.s(th2);
        }
    }
}
