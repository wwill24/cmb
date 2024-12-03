package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import qj.u;
import tj.b;
import yj.d;

public abstract class a<T, R> implements u<T>, d<R> {

    /* renamed from: a  reason: collision with root package name */
    protected final u<? super R> f30082a;

    /* renamed from: b  reason: collision with root package name */
    protected b f30083b;

    /* renamed from: c  reason: collision with root package name */
    protected d<T> f30084c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f30085d;

    /* renamed from: e  reason: collision with root package name */
    protected int f30086e;

    public a(u<? super R> uVar) {
        this.f30082a = uVar;
    }

    public final void a(b bVar) {
        if (DisposableHelper.k(this.f30083b, bVar)) {
            this.f30083b = bVar;
            if (bVar instanceof d) {
                this.f30084c = (d) bVar;
            }
            if (f()) {
                this.f30082a.a(this);
                e();
            }
        }
    }

    public boolean c() {
        return this.f30083b.c();
    }

    public void clear() {
        this.f30084c.clear();
    }

    public void dispose() {
        this.f30083b.dispose();
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    /* access modifiers changed from: protected */
    public boolean f() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void g(Throwable th2) {
        uj.a.b(th2);
        this.f30083b.dispose();
        onError(th2);
    }

    /* access modifiers changed from: protected */
    public final int h(int i10) {
        d<T> dVar = this.f30084c;
        if (dVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int b10 = dVar.b(i10);
        if (b10 != 0) {
            this.f30086e = b10;
        }
        return b10;
    }

    public boolean isEmpty() {
        return this.f30084c.isEmpty();
    }

    public final boolean offer(R r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f30085d) {
            this.f30085d = true;
            this.f30082a.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f30085d) {
            bk.a.s(th2);
            return;
        }
        this.f30085d = true;
        this.f30082a.onError(th2);
    }
}
