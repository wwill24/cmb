package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import qj.h;
import qj.l;
import rn.b;
import rn.c;

public final class r<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f30296c;

    static final class a<T> implements l<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final b<? super T> f30297a;

        /* renamed from: b  reason: collision with root package name */
        long f30298b;

        /* renamed from: c  reason: collision with root package name */
        c f30299c;

        a(b<? super T> bVar, long j10) {
            this.f30297a = bVar;
            this.f30298b = j10;
        }

        public void cancel() {
            this.f30299c.cancel();
        }

        public void d(T t10) {
            long j10 = this.f30298b;
            if (j10 != 0) {
                this.f30298b = j10 - 1;
            } else {
                this.f30297a.d(t10);
            }
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.f30299c, cVar)) {
                long j10 = this.f30298b;
                this.f30299c = cVar;
                this.f30297a.e(this);
                cVar.r(j10);
            }
        }

        public void onComplete() {
            this.f30297a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30297a.onError(th2);
        }

        public void r(long j10) {
            this.f30299c.r(j10);
        }
    }

    public r(h<T> hVar, long j10) {
        super(hVar);
        this.f30296c = j10;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new a(bVar, this.f30296c));
    }
}
