package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.a;
import qj.d;
import qj.f;
import qj.v;
import tj.b;

public final class CompletableObserveOn extends a {

    /* renamed from: a  reason: collision with root package name */
    final f f30106a;

    /* renamed from: b  reason: collision with root package name */
    final v f30107b;

    static final class ObserveOnCompletableObserver extends AtomicReference<b> implements d, b, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final d downstream;
        Throwable error;
        final v scheduler;

        ObserveOnCompletableObserver(d dVar, v vVar) {
            this.downstream = dVar;
            this.scheduler = vVar;
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
            DisposableHelper.d(this, this.scheduler.c(this));
        }

        public void onError(Throwable th2) {
            this.error = th2;
            DisposableHelper.d(this, this.scheduler.c(this));
        }

        public void run() {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.error = null;
                this.downstream.onError(th2);
                return;
            }
            this.downstream.onComplete();
        }
    }

    public CompletableObserveOn(f fVar, v vVar) {
        this.f30106a = fVar;
        this.f30107b = vVar;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        this.f30106a.e(new ObserveOnCompletableObserver(dVar, this.f30107b));
    }
}
