package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.n;
import qj.o;
import qj.w;
import qj.z;
import tj.b;

public final class MaybeSwitchIfEmptySingle<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final o<T> f30305a;

    /* renamed from: b  reason: collision with root package name */
    final b0<? extends T> f30306b;

    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<b> implements n<T>, b {
        private static final long serialVersionUID = 4603919676453758899L;
        final z<? super T> downstream;
        final b0<? extends T> other;

        static final class a<T> implements z<T> {

            /* renamed from: a  reason: collision with root package name */
            final z<? super T> f30307a;

            /* renamed from: b  reason: collision with root package name */
            final AtomicReference<b> f30308b;

            a(z<? super T> zVar, AtomicReference<b> atomicReference) {
                this.f30307a = zVar;
                this.f30308b = atomicReference;
            }

            public void a(b bVar) {
                DisposableHelper.i(this.f30308b, bVar);
            }

            public void onError(Throwable th2) {
                this.f30307a.onError(th2);
            }

            public void onSuccess(T t10) {
                this.f30307a.onSuccess(t10);
            }
        }

        SwitchIfEmptyMaybeObserver(z<? super T> zVar, b0<? extends T> b0Var) {
            this.downstream = zVar;
            this.other = b0Var;
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
            b bVar = (b) get();
            if (bVar != DisposableHelper.DISPOSED && compareAndSet(bVar, (Object) null)) {
                this.other.f(new a(this.downstream, this));
            }
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }
    }

    public MaybeSwitchIfEmptySingle(o<T> oVar, b0<? extends T> b0Var) {
        this.f30305a = oVar;
        this.f30306b = b0Var;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30305a.a(new SwitchIfEmptyMaybeObserver(zVar, this.f30306b));
    }
}
