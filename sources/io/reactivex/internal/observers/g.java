package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import qj.d;
import rn.b;
import rn.c;

public final class g<T> implements d, c {

    /* renamed from: a  reason: collision with root package name */
    final b<? super T> f30097a;

    /* renamed from: b  reason: collision with root package name */
    tj.b f30098b;

    public g(b<? super T> bVar) {
        this.f30097a = bVar;
    }

    public void a(tj.b bVar) {
        if (DisposableHelper.k(this.f30098b, bVar)) {
            this.f30098b = bVar;
            this.f30097a.e(this);
        }
    }

    public void cancel() {
        this.f30098b.dispose();
    }

    public void onComplete() {
        this.f30097a.onComplete();
    }

    public void onError(Throwable th2) {
        this.f30097a.onError(th2);
    }

    public void r(long j10) {
    }
}
