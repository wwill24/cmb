package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import qj.h;
import qj.l;
import qj.w;
import qj.z;
import rn.c;
import yj.b;

public final class f<T> extends w<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    final h<T> f30260a;

    /* renamed from: b  reason: collision with root package name */
    final long f30261b;

    /* renamed from: c  reason: collision with root package name */
    final T f30262c;

    static final class a<T> implements l<T>, tj.b {

        /* renamed from: a  reason: collision with root package name */
        final z<? super T> f30263a;

        /* renamed from: b  reason: collision with root package name */
        final long f30264b;

        /* renamed from: c  reason: collision with root package name */
        final T f30265c;

        /* renamed from: d  reason: collision with root package name */
        c f30266d;

        /* renamed from: e  reason: collision with root package name */
        long f30267e;

        /* renamed from: f  reason: collision with root package name */
        boolean f30268f;

        a(z<? super T> zVar, long j10, T t10) {
            this.f30263a = zVar;
            this.f30264b = j10;
            this.f30265c = t10;
        }

        public boolean c() {
            return this.f30266d == SubscriptionHelper.CANCELLED;
        }

        public void d(T t10) {
            if (!this.f30268f) {
                long j10 = this.f30267e;
                if (j10 == this.f30264b) {
                    this.f30268f = true;
                    this.f30266d.cancel();
                    this.f30266d = SubscriptionHelper.CANCELLED;
                    this.f30263a.onSuccess(t10);
                    return;
                }
                this.f30267e = j10 + 1;
            }
        }

        public void dispose() {
            this.f30266d.cancel();
            this.f30266d = SubscriptionHelper.CANCELLED;
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.f30266d, cVar)) {
                this.f30266d = cVar;
                this.f30263a.a(this);
                cVar.r(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.f30266d = SubscriptionHelper.CANCELLED;
            if (!this.f30268f) {
                this.f30268f = true;
                T t10 = this.f30265c;
                if (t10 != null) {
                    this.f30263a.onSuccess(t10);
                } else {
                    this.f30263a.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f30268f) {
                bk.a.s(th2);
                return;
            }
            this.f30268f = true;
            this.f30266d = SubscriptionHelper.CANCELLED;
            this.f30263a.onError(th2);
        }
    }

    public f(h<T> hVar, long j10, T t10) {
        this.f30260a = hVar;
        this.f30261b = j10;
        this.f30262c = t10;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30260a.m0(new a(zVar, this.f30261b, this.f30262c));
    }

    public h<T> i() {
        return bk.a.l(new FlowableElementAt(this.f30260a, this.f30261b, this.f30262c, true));
    }
}
