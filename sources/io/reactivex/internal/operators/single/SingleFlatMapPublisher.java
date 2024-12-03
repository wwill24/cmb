package io.reactivex.internal.operators.single;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.h;
import qj.l;
import qj.z;
import rn.a;
import rn.c;
import tj.b;
import vj.j;

public final class SingleFlatMapPublisher<T, R> extends h<R> {

    /* renamed from: b  reason: collision with root package name */
    final b0<T> f30526b;

    /* renamed from: c  reason: collision with root package name */
    final j<? super T, ? extends a<? extends R>> f30527c;

    static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements z<S>, l<T>, c {
        private static final long serialVersionUID = 7759721921468635667L;
        b disposable;
        final rn.b<? super T> downstream;
        final j<? super S, ? extends a<? extends T>> mapper;
        final AtomicReference<c> parent = new AtomicReference<>();

        SingleFlatMapPublisherObserver(rn.b<? super T> bVar, j<? super S, ? extends a<? extends T>> jVar) {
            this.downstream = bVar;
            this.mapper = jVar;
        }

        public void a(b bVar) {
            this.disposable = bVar;
            this.downstream.e(this);
        }

        public void cancel() {
            this.disposable.dispose();
            SubscriptionHelper.a(this.parent);
        }

        public void d(T t10) {
            this.downstream.d(t10);
        }

        public void e(c cVar) {
            SubscriptionHelper.c(this.parent, this, cVar);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSuccess(S s10) {
            try {
                ((a) xj.b.e(this.mapper.apply(s10), "the mapper returned a null Publisher")).a(this);
            } catch (Throwable th2) {
                uj.a.b(th2);
                this.downstream.onError(th2);
            }
        }

        public void r(long j10) {
            SubscriptionHelper.b(this.parent, this, j10);
        }
    }

    public SingleFlatMapPublisher(b0<T> b0Var, j<? super T, ? extends a<? extends R>> jVar) {
        this.f30526b = b0Var;
        this.f30527c = jVar;
    }

    /* access modifiers changed from: protected */
    public void n0(rn.b<? super R> bVar) {
        this.f30526b.f(new SingleFlatMapPublisherObserver(bVar, this.f30527c));
    }
}
