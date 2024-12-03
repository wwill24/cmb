package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ArrayListSupplier;
import java.util.Collection;
import java.util.concurrent.Callable;
import qj.h;
import qj.l;
import qj.w;
import qj.z;
import rn.c;
import yj.b;

public final class s<T, U extends Collection<? super T>> extends w<U> implements b<U> {

    /* renamed from: a  reason: collision with root package name */
    final h<T> f30300a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f30301b;

    static final class a<T, U extends Collection<? super T>> implements l<T>, tj.b {

        /* renamed from: a  reason: collision with root package name */
        final z<? super U> f30302a;

        /* renamed from: b  reason: collision with root package name */
        c f30303b;

        /* renamed from: c  reason: collision with root package name */
        U f30304c;

        a(z<? super U> zVar, U u10) {
            this.f30302a = zVar;
            this.f30304c = u10;
        }

        public boolean c() {
            return this.f30303b == SubscriptionHelper.CANCELLED;
        }

        public void d(T t10) {
            this.f30304c.add(t10);
        }

        public void dispose() {
            this.f30303b.cancel();
            this.f30303b = SubscriptionHelper.CANCELLED;
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.f30303b, cVar)) {
                this.f30303b = cVar;
                this.f30302a.a(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.f30303b = SubscriptionHelper.CANCELLED;
            this.f30302a.onSuccess(this.f30304c);
        }

        public void onError(Throwable th2) {
            this.f30304c = null;
            this.f30303b = SubscriptionHelper.CANCELLED;
            this.f30302a.onError(th2);
        }
    }

    public s(h<T> hVar) {
        this(hVar, ArrayListSupplier.b());
    }

    /* access modifiers changed from: protected */
    public void J(z<? super U> zVar) {
        try {
            this.f30300a.m0(new a(zVar, (Collection) xj.b.e(this.f30301b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            uj.a.b(th2);
            EmptyDisposable.j(th2, zVar);
        }
    }

    public h<U> i() {
        return bk.a.l(new FlowableToList(this.f30300a, this.f30301b));
    }

    public s(h<T> hVar, Callable<U> callable) {
        this.f30300a = hVar;
        this.f30301b = callable;
    }
}
