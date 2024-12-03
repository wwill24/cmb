package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.v;
import qj.w;
import qj.z;
import tj.b;

public final class SingleSubscribeOn<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<? extends T> f30532a;

    /* renamed from: b  reason: collision with root package name */
    final v f30533b;

    static final class SubscribeOnObserver<T> extends AtomicReference<b> implements z<T>, b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final z<? super T> downstream;
        final b0<? extends T> source;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnObserver(z<? super T> zVar, b0<? extends T> b0Var) {
            this.downstream = zVar;
            this.source = b0Var;
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

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }

        public void run() {
            this.source.f(this);
        }
    }

    public SingleSubscribeOn(b0<? extends T> b0Var, v vVar) {
        this.f30532a = b0Var;
        this.f30533b = vVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(zVar, this.f30532a);
        zVar.a(subscribeOnObserver);
        subscribeOnObserver.task.a(this.f30533b.c(subscribeOnObserver));
    }
}
