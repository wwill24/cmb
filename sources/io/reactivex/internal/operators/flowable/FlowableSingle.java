package io.reactivex.internal.operators.flowable;

import bk.a;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import qj.h;
import qj.l;
import rn.b;
import rn.c;

public final class FlowableSingle<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final T f30197c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30198d;

    static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements l<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        final boolean failOnEmpty;
        c upstream;

        SingleElementSubscriber(b<? super T> bVar, T t10, boolean z10) {
            super(bVar);
            this.defaultValue = t10;
            this.failOnEmpty = z10;
        }

        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        public void d(T t10) {
            if (!this.done) {
                if (this.value != null) {
                    this.done = true;
                    this.upstream.cancel();
                    this.downstream.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.value = t10;
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
                T t10 = this.value;
                this.value = null;
                if (t10 == null) {
                    t10 = this.defaultValue;
                }
                if (t10 != null) {
                    c(t10);
                } else if (this.failOnEmpty) {
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

    public FlowableSingle(h<T> hVar, T t10, boolean z10) {
        super(hVar);
        this.f30197c = t10;
        this.f30198d = z10;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30214b.m0(new SingleElementSubscriber(bVar, this.f30197c, this.f30198d));
    }
}
