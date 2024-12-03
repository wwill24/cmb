package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import qj.h;
import qj.l;
import rn.b;
import rn.c;
import uj.a;

public final class FlowableToList<T, U extends Collection<? super T>> extends a<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final Callable<U> f30206c;

    static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements l<T>, c {
        private static final long serialVersionUID = -8134157938864266736L;
        c upstream;

        /* JADX WARNING: type inference failed for: r2v0, types: [T, U] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ToListSubscriber(rn.b<? super U> r1, U r2) {
            /*
                r0 = this;
                r0.<init>(r1)
                r0.value = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableToList.ToListSubscriber.<init>(rn.b, java.util.Collection):void");
        }

        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        public void d(T t10) {
            Collection collection = (Collection) this.value;
            if (collection != null) {
                collection.add(t10);
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
            c(this.value);
        }

        public void onError(Throwable th2) {
            this.value = null;
            this.downstream.onError(th2);
        }
    }

    public FlowableToList(h<T> hVar, Callable<U> callable) {
        super(hVar);
        this.f30206c = callable;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super U> bVar) {
        try {
            this.f30214b.m0(new ToListSubscriber(bVar, (Collection) xj.b.e(this.f30206c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            a.b(th2);
            EmptySubscription.c(th2, bVar);
        }
    }
}
