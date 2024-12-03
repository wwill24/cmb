package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.z;
import tj.b;

public final class f<T> implements z<T> {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<b> f30095a;

    /* renamed from: b  reason: collision with root package name */
    final z<? super T> f30096b;

    public f(AtomicReference<b> atomicReference, z<? super T> zVar) {
        this.f30095a = atomicReference;
        this.f30096b = zVar;
    }

    public void a(b bVar) {
        DisposableHelper.d(this.f30095a, bVar);
    }

    public void onError(Throwable th2) {
        this.f30096b.onError(th2);
    }

    public void onSuccess(T t10) {
        this.f30096b.onSuccess(t10);
    }
}
