package io.reactivex.internal.operators.observable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import qj.l;
import qj.q;
import qj.u;
import rn.c;
import tj.b;

public final class n<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final rn.a<? extends T> f30477a;

    static final class a<T> implements l<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30478a;

        /* renamed from: b  reason: collision with root package name */
        c f30479b;

        a(u<? super T> uVar) {
            this.f30478a = uVar;
        }

        public boolean c() {
            return this.f30479b == SubscriptionHelper.CANCELLED;
        }

        public void d(T t10) {
            this.f30478a.d(t10);
        }

        public void dispose() {
            this.f30479b.cancel();
            this.f30479b = SubscriptionHelper.CANCELLED;
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.f30479b, cVar)) {
                this.f30479b = cVar;
                this.f30478a.a(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.f30478a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30478a.onError(th2);
        }
    }

    public n(rn.a<? extends T> aVar) {
        this.f30477a = aVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        this.f30477a.a(new a(uVar));
    }
}
