package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import qj.h;
import rn.b;
import rn.c;
import yj.f;

public final class l<T> extends a<T, T> {

    static final class a<T> implements qj.l<T>, f<T> {

        /* renamed from: a  reason: collision with root package name */
        final b<? super T> f30278a;

        /* renamed from: b  reason: collision with root package name */
        c f30279b;

        a(b<? super T> bVar) {
            this.f30278a = bVar;
        }

        public int b(int i10) {
            return i10 & 2;
        }

        public void cancel() {
            this.f30279b.cancel();
        }

        public void clear() {
        }

        public void d(T t10) {
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.f30279b, cVar)) {
                this.f30279b = cVar;
                this.f30278a.e(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean offer(T t10) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public void onComplete() {
            this.f30278a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30278a.onError(th2);
        }

        public T poll() {
            return null;
        }

        public void r(long j10) {
        }
    }

    public l(h<T> hVar) {
        super(hVar);
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new a(bVar));
    }
}
