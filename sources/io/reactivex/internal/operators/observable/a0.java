package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import qj.s;
import qj.u;
import tj.b;

public final class a0<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f30396b;

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30397a;

        /* renamed from: b  reason: collision with root package name */
        boolean f30398b;

        /* renamed from: c  reason: collision with root package name */
        b f30399c;

        /* renamed from: d  reason: collision with root package name */
        long f30400d;

        a(u<? super T> uVar, long j10) {
            this.f30397a = uVar;
            this.f30400d = j10;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30399c, bVar)) {
                this.f30399c = bVar;
                if (this.f30400d == 0) {
                    this.f30398b = true;
                    bVar.dispose();
                    EmptyDisposable.e(this.f30397a);
                    return;
                }
                this.f30397a.a(this);
            }
        }

        public boolean c() {
            return this.f30399c.c();
        }

        public void d(T t10) {
            boolean z10;
            if (!this.f30398b) {
                long j10 = this.f30400d;
                long j11 = j10 - 1;
                this.f30400d = j11;
                if (j10 > 0) {
                    if (j11 == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f30397a.d(t10);
                    if (z10) {
                        onComplete();
                    }
                }
            }
        }

        public void dispose() {
            this.f30399c.dispose();
        }

        public void onComplete() {
            if (!this.f30398b) {
                this.f30398b = true;
                this.f30399c.dispose();
                this.f30397a.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f30398b) {
                bk.a.s(th2);
                return;
            }
            this.f30398b = true;
            this.f30399c.dispose();
            this.f30397a.onError(th2);
        }
    }

    public a0(s<T> sVar, long j10) {
        super(sVar);
        this.f30396b = j10;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(uVar, this.f30396b));
    }
}
