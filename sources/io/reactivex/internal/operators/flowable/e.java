package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import qj.h;
import qj.l;
import rn.b;
import rn.c;
import vj.f;
import vj.k;

public final class e<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    private final f<? super c> f30252c;

    /* renamed from: d  reason: collision with root package name */
    private final k f30253d;

    /* renamed from: e  reason: collision with root package name */
    private final vj.a f30254e;

    static final class a<T> implements l<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final b<? super T> f30255a;

        /* renamed from: b  reason: collision with root package name */
        final f<? super c> f30256b;

        /* renamed from: c  reason: collision with root package name */
        final k f30257c;

        /* renamed from: d  reason: collision with root package name */
        final vj.a f30258d;

        /* renamed from: e  reason: collision with root package name */
        c f30259e;

        a(b<? super T> bVar, f<? super c> fVar, k kVar, vj.a aVar) {
            this.f30255a = bVar;
            this.f30256b = fVar;
            this.f30258d = aVar;
            this.f30257c = kVar;
        }

        public void cancel() {
            c cVar = this.f30259e;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (cVar != subscriptionHelper) {
                this.f30259e = subscriptionHelper;
                try {
                    this.f30258d.run();
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    bk.a.s(th2);
                }
                cVar.cancel();
            }
        }

        public void d(T t10) {
            this.f30255a.d(t10);
        }

        public void e(c cVar) {
            try {
                this.f30256b.accept(cVar);
                if (SubscriptionHelper.k(this.f30259e, cVar)) {
                    this.f30259e = cVar;
                    this.f30255a.e(this);
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                cVar.cancel();
                this.f30259e = SubscriptionHelper.CANCELLED;
                EmptySubscription.c(th2, this.f30255a);
            }
        }

        public void onComplete() {
            if (this.f30259e != SubscriptionHelper.CANCELLED) {
                this.f30255a.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f30259e != SubscriptionHelper.CANCELLED) {
                this.f30255a.onError(th2);
            } else {
                bk.a.s(th2);
            }
        }

        public void r(long j10) {
            try {
                this.f30257c.accept(j10);
            } catch (Throwable th2) {
                uj.a.b(th2);
                bk.a.s(th2);
            }
            this.f30259e.r(j10);
        }
    }

    public e(h<T> hVar, f<? super c> fVar, k kVar, vj.a aVar) {
        super(hVar);
        this.f30252c = fVar;
        this.f30253d = kVar;
        this.f30254e = aVar;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new a(bVar, this.f30252c, this.f30253d, this.f30254e));
    }
}
