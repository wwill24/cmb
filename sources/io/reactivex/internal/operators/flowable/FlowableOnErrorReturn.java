package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import qj.h;
import rn.b;
import uj.a;
import vj.j;

public final class FlowableOnErrorReturn<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final j<? super Throwable, ? extends T> f30193c;

    static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        final j<? super Throwable, ? extends T> valueSupplier;

        OnErrorReturnSubscriber(b<? super T> bVar, j<? super Throwable, ? extends T> jVar) {
            super(bVar);
            this.valueSupplier = jVar;
        }

        public void d(T t10) {
            this.produced++;
            this.downstream.d(t10);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                a(xj.b.e(this.valueSupplier.apply(th2), "The valueSupplier returned a null value"));
            } catch (Throwable th3) {
                a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }
    }

    public FlowableOnErrorReturn(h<T> hVar, j<? super Throwable, ? extends T> jVar) {
        super(hVar);
        this.f30193c = jVar;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new OnErrorReturnSubscriber(bVar, this.f30193c));
    }
}
