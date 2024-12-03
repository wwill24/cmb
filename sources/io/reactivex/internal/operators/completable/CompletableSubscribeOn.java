package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import qj.a;
import qj.d;
import qj.f;
import qj.v;
import tj.b;

public final class CompletableSubscribeOn extends a {

    /* renamed from: a  reason: collision with root package name */
    final f f30110a;

    /* renamed from: b  reason: collision with root package name */
    final v f30111b;

    static final class SubscribeOnObserver extends AtomicReference<b> implements d, b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final d downstream;
        final f source;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnObserver(d dVar, f fVar) {
            this.downstream = dVar;
            this.source = fVar;
        }

        public void a(b bVar) {
            DisposableHelper.i(this, bVar);
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void dispose() {
            DisposableHelper.a(this);
            this.task.dispose();
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void run() {
            this.source.e(this);
        }
    }

    public CompletableSubscribeOn(f fVar, v vVar) {
        this.f30110a = fVar;
        this.f30111b = vVar;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(dVar, this.f30110a);
        dVar.a(subscribeOnObserver);
        subscribeOnObserver.task.a(this.f30111b.c(subscribeOnObserver));
    }
}
