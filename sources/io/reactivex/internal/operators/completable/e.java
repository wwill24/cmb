package io.reactivex.internal.operators.completable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import qj.d;
import qj.l;
import rn.c;
import tj.b;

public final class e<T> extends qj.a {

    /* renamed from: a  reason: collision with root package name */
    final rn.a<T> f30116a;

    static final class a<T> implements l<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final d f30117a;

        /* renamed from: b  reason: collision with root package name */
        c f30118b;

        a(d dVar) {
            this.f30117a = dVar;
        }

        public boolean c() {
            return this.f30118b == SubscriptionHelper.CANCELLED;
        }

        public void d(T t10) {
        }

        public void dispose() {
            this.f30118b.cancel();
            this.f30118b = SubscriptionHelper.CANCELLED;
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.f30118b, cVar)) {
                this.f30118b = cVar;
                this.f30117a.a(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.f30117a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30117a.onError(th2);
        }
    }

    public e(rn.a<T> aVar) {
        this.f30116a = aVar;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        this.f30116a.a(new a(dVar));
    }
}
