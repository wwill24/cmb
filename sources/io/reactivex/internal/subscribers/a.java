package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import rn.c;
import yj.f;

public abstract class a<T, R> implements yj.a<T>, f<R> {

    /* renamed from: a  reason: collision with root package name */
    protected final yj.a<? super R> f30692a;

    /* renamed from: b  reason: collision with root package name */
    protected c f30693b;

    /* renamed from: c  reason: collision with root package name */
    protected f<T> f30694c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f30695d;

    /* renamed from: e  reason: collision with root package name */
    protected int f30696e;

    public a(yj.a<? super R> aVar) {
        this.f30692a = aVar;
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public void cancel() {
        this.f30693b.cancel();
    }

    public void clear() {
        this.f30694c.clear();
    }

    public final void e(c cVar) {
        if (SubscriptionHelper.k(this.f30693b, cVar)) {
            this.f30693b = cVar;
            if (cVar instanceof f) {
                this.f30694c = (f) cVar;
            }
            if (c()) {
                this.f30692a.e(this);
                a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void g(Throwable th2) {
        uj.a.b(th2);
        this.f30693b.cancel();
        onError(th2);
    }

    /* access modifiers changed from: protected */
    public final int h(int i10) {
        f<T> fVar = this.f30694c;
        if (fVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int b10 = fVar.b(i10);
        if (b10 != 0) {
            this.f30696e = b10;
        }
        return b10;
    }

    public boolean isEmpty() {
        return this.f30694c.isEmpty();
    }

    public final boolean offer(R r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f30695d) {
            this.f30695d = true;
            this.f30692a.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f30695d) {
            bk.a.s(th2);
            return;
        }
        this.f30695d = true;
        this.f30692a.onError(th2);
    }

    public void r(long j10) {
        this.f30693b.r(j10);
    }
}
