package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import qj.h;
import qj.l;
import rn.a;
import rn.b;
import rn.c;
import vj.j;

public final class FlowableOnErrorNext<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final j<? super Throwable, ? extends a<? extends T>> f30191c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30192d;

    static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements l<T> {
        private static final long serialVersionUID = 4063763155303814625L;
        final boolean allowFatal;
        boolean done;
        final b<? super T> downstream;
        final j<? super Throwable, ? extends a<? extends T>> nextSupplier;
        boolean once;
        long produced;

        OnErrorNextSubscriber(b<? super T> bVar, j<? super Throwable, ? extends a<? extends T>> jVar, boolean z10) {
            super(false);
            this.downstream = bVar;
            this.nextSupplier = jVar;
            this.allowFatal = z10;
        }

        public void d(T t10) {
            if (!this.done) {
                if (!this.once) {
                    this.produced++;
                }
                this.downstream.d(t10);
            }
        }

        public void e(c cVar) {
            g(cVar);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.once = true;
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.once) {
                this.once = true;
                if (!this.allowFatal || (th2 instanceof Exception)) {
                    try {
                        a aVar = (a) xj.b.e(this.nextSupplier.apply(th2), "The nextSupplier returned a null Publisher");
                        long j10 = this.produced;
                        if (j10 != 0) {
                            c(j10);
                        }
                        aVar.a(this);
                    } catch (Throwable th3) {
                        uj.a.b(th3);
                        this.downstream.onError(new CompositeException(th2, th3));
                    }
                } else {
                    this.downstream.onError(th2);
                }
            } else if (this.done) {
                bk.a.s(th2);
            } else {
                this.downstream.onError(th2);
            }
        }
    }

    public FlowableOnErrorNext(h<T> hVar, j<? super Throwable, ? extends a<? extends T>> jVar, boolean z10) {
        super(hVar);
        this.f30191c = jVar;
        this.f30192d = z10;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(bVar, this.f30191c, this.f30192d);
        bVar.e(onErrorNextSubscriber);
        this.f30214b.m0(onErrorNextSubscriber);
    }
}
