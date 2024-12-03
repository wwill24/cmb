package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.s;
import qj.u;
import qj.v;
import tj.b;

public final class ObservableSubscribeOn<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final v f30382b;

    static final class SubscribeOnObserver<T> extends AtomicReference<b> implements u<T>, b {
        private static final long serialVersionUID = 8094547886072529208L;
        final u<? super T> downstream;
        final AtomicReference<b> upstream = new AtomicReference<>();

        SubscribeOnObserver(u<? super T> uVar) {
            this.downstream = uVar;
        }

        public void a(b bVar) {
            DisposableHelper.i(this.upstream, bVar);
        }

        /* access modifiers changed from: package-private */
        public void b(b bVar) {
            DisposableHelper.i(this, bVar);
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void d(T t10) {
            this.downstream.d(t10);
        }

        public void dispose() {
            DisposableHelper.a(this.upstream);
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }
    }

    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final SubscribeOnObserver<T> f30383a;

        a(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f30383a = subscribeOnObserver;
        }

        public void run() {
            ObservableSubscribeOn.this.f30395a.e(this.f30383a);
        }
    }

    public ObservableSubscribeOn(s<T> sVar, v vVar) {
        super(sVar);
        this.f30382b = vVar;
    }

    public void l0(u<? super T> uVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(uVar);
        uVar.a(subscribeOnObserver);
        subscribeOnObserver.b(this.f30382b.c(new a(subscribeOnObserver)));
    }
}
