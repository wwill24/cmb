package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import qj.l;
import rn.c;
import uj.a;
import yj.f;

public abstract class b<T, R> implements l<T>, f<R> {

    /* renamed from: a  reason: collision with root package name */
    protected final rn.b<? super R> f30697a;

    /* renamed from: b  reason: collision with root package name */
    protected c f30698b;

    /* renamed from: c  reason: collision with root package name */
    protected f<T> f30699c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f30700d;

    /* renamed from: e  reason: collision with root package name */
    protected int f30701e;

    public b(rn.b<? super R> bVar) {
        this.f30697a = bVar;
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public void cancel() {
        this.f30698b.cancel();
    }

    public void clear() {
        this.f30699c.clear();
    }

    public final void e(c cVar) {
        if (SubscriptionHelper.k(this.f30698b, cVar)) {
            this.f30698b = cVar;
            if (cVar instanceof f) {
                this.f30699c = (f) cVar;
            }
            if (c()) {
                this.f30697a.e(this);
                a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void g(Throwable th2) {
        a.b(th2);
        this.f30698b.cancel();
        onError(th2);
    }

    /* access modifiers changed from: protected */
    public final int h(int i10) {
        f<T> fVar = this.f30699c;
        if (fVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int b10 = fVar.b(i10);
        if (b10 != 0) {
            this.f30701e = b10;
        }
        return b10;
    }

    public boolean isEmpty() {
        return this.f30699c.isEmpty();
    }

    public final boolean offer(R r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f30700d) {
            this.f30700d = true;
            this.f30697a.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f30700d) {
            bk.a.s(th2);
            return;
        }
        this.f30700d = true;
        this.f30697a.onError(th2);
    }

    public void r(long j10) {
        this.f30698b.r(j10);
    }
}
