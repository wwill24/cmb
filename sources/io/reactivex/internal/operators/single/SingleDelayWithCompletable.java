package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.d;
import qj.f;
import qj.w;
import qj.z;
import tj.b;

public final class SingleDelayWithCompletable<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30514a;

    /* renamed from: b  reason: collision with root package name */
    final f f30515b;

    static final class OtherObserver<T> extends AtomicReference<b> implements d, b {
        private static final long serialVersionUID = -8565274649390031272L;
        final z<? super T> downstream;
        final b0<T> source;

        OtherObserver(z<? super T> zVar, b0<T> b0Var) {
            this.downstream = zVar;
            this.source = b0Var;
        }

        public void a(b bVar) {
            if (DisposableHelper.i(this, bVar)) {
                this.downstream.a(this);
            }
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.source.f(new io.reactivex.internal.observers.f(this, this.downstream));
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }
    }

    public SingleDelayWithCompletable(b0<T> b0Var, f fVar) {
        this.f30514a = b0Var;
        this.f30515b = fVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30515b.e(new OtherObserver(zVar, this.f30514a));
    }
}
