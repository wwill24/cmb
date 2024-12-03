package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import qj.d;
import qj.h;
import qj.l;
import rn.c;
import yj.b;

public final class m<T> extends qj.a implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    final h<T> f30280a;

    static final class a<T> implements l<T>, tj.b {

        /* renamed from: a  reason: collision with root package name */
        final d f30281a;

        /* renamed from: b  reason: collision with root package name */
        c f30282b;

        a(d dVar) {
            this.f30281a = dVar;
        }

        public boolean c() {
            return this.f30282b == SubscriptionHelper.CANCELLED;
        }

        public void d(T t10) {
        }

        public void dispose() {
            this.f30282b.cancel();
            this.f30282b = SubscriptionHelper.CANCELLED;
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.f30282b, cVar)) {
                this.f30282b = cVar;
                this.f30281a.a(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.f30282b = SubscriptionHelper.CANCELLED;
            this.f30281a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30282b = SubscriptionHelper.CANCELLED;
            this.f30281a.onError(th2);
        }
    }

    public m(h<T> hVar) {
        this.f30280a = hVar;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        this.f30280a.m0(new a(dVar));
    }

    public h<T> i() {
        return bk.a.l(new l(this.f30280a));
    }
}
