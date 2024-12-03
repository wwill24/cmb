package io.reactivex.internal.operators.flowable;

import bk.a;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import qj.h;
import qj.l;
import rn.b;
import rn.c;

public final class FlowableElementAt<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f30157c;

    /* renamed from: d  reason: collision with root package name */
    final T f30158d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f30159e;

    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements l<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;
        c upstream;

        ElementAtSubscriber(b<? super T> bVar, long j10, T t10, boolean z10) {
            super(bVar);
            this.index = j10;
            this.defaultValue = t10;
            this.errorOnFewer = z10;
        }

        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        public void d(T t10) {
            if (!this.done) {
                long j10 = this.count;
                if (j10 == this.index) {
                    this.done = true;
                    this.upstream.cancel();
                    c(t10);
                    return;
                }
                this.count = j10 + 1;
            }
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.e(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                T t10 = this.defaultValue;
                if (t10 != null) {
                    c(t10);
                } else if (this.errorOnFewer) {
                    this.downstream.onError(new NoSuchElementException());
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                a.s(th2);
                return;
            }
            this.done = true;
            this.downstream.onError(th2);
        }
    }

    public FlowableElementAt(h<T> hVar, long j10, T t10, boolean z10) {
        super(hVar);
        this.f30157c = j10;
        this.f30158d = t10;
        this.f30159e = z10;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new ElementAtSubscriber(bVar, this.f30157c, this.f30158d, this.f30159e));
    }
}
