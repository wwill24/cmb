package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import qj.h;
import qj.l;
import qj.w;
import qj.z;
import rn.c;
import yj.b;

public final class q<T> extends w<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    final h<T> f30289a;

    /* renamed from: b  reason: collision with root package name */
    final T f30290b;

    static final class a<T> implements l<T>, tj.b {

        /* renamed from: a  reason: collision with root package name */
        final z<? super T> f30291a;

        /* renamed from: b  reason: collision with root package name */
        final T f30292b;

        /* renamed from: c  reason: collision with root package name */
        c f30293c;

        /* renamed from: d  reason: collision with root package name */
        boolean f30294d;

        /* renamed from: e  reason: collision with root package name */
        T f30295e;

        a(z<? super T> zVar, T t10) {
            this.f30291a = zVar;
            this.f30292b = t10;
        }

        public boolean c() {
            return this.f30293c == SubscriptionHelper.CANCELLED;
        }

        public void d(T t10) {
            if (!this.f30294d) {
                if (this.f30295e != null) {
                    this.f30294d = true;
                    this.f30293c.cancel();
                    this.f30293c = SubscriptionHelper.CANCELLED;
                    this.f30291a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f30295e = t10;
            }
        }

        public void dispose() {
            this.f30293c.cancel();
            this.f30293c = SubscriptionHelper.CANCELLED;
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.f30293c, cVar)) {
                this.f30293c = cVar;
                this.f30291a.a(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.f30294d) {
                this.f30294d = true;
                this.f30293c = SubscriptionHelper.CANCELLED;
                T t10 = this.f30295e;
                this.f30295e = null;
                if (t10 == null) {
                    t10 = this.f30292b;
                }
                if (t10 != null) {
                    this.f30291a.onSuccess(t10);
                } else {
                    this.f30291a.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f30294d) {
                bk.a.s(th2);
                return;
            }
            this.f30294d = true;
            this.f30293c = SubscriptionHelper.CANCELLED;
            this.f30291a.onError(th2);
        }
    }

    public q(h<T> hVar, T t10) {
        this.f30289a = hVar;
        this.f30290b = t10;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30289a.m0(new a(zVar, this.f30290b));
    }

    public h<T> i() {
        return bk.a.l(new FlowableSingle(this.f30289a, this.f30290b, true));
    }
}
