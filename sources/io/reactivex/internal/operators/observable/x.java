package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import qj.m;
import qj.n;
import qj.s;
import qj.u;
import tj.b;

public final class x<T> extends m<T> {

    /* renamed from: a  reason: collision with root package name */
    final s<T> f30497a;

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final n<? super T> f30498a;

        /* renamed from: b  reason: collision with root package name */
        b f30499b;

        /* renamed from: c  reason: collision with root package name */
        T f30500c;

        /* renamed from: d  reason: collision with root package name */
        boolean f30501d;

        a(n<? super T> nVar) {
            this.f30498a = nVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30499b, bVar)) {
                this.f30499b = bVar;
                this.f30498a.a(this);
            }
        }

        public boolean c() {
            return this.f30499b.c();
        }

        public void d(T t10) {
            if (!this.f30501d) {
                if (this.f30500c != null) {
                    this.f30501d = true;
                    this.f30499b.dispose();
                    this.f30498a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f30500c = t10;
            }
        }

        public void dispose() {
            this.f30499b.dispose();
        }

        public void onComplete() {
            if (!this.f30501d) {
                this.f30501d = true;
                T t10 = this.f30500c;
                this.f30500c = null;
                if (t10 == null) {
                    this.f30498a.onComplete();
                } else {
                    this.f30498a.onSuccess(t10);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f30501d) {
                bk.a.s(th2);
                return;
            }
            this.f30501d = true;
            this.f30498a.onError(th2);
        }
    }

    public x(s<T> sVar) {
        this.f30497a = sVar;
    }

    public void f(n<? super T> nVar) {
        this.f30497a.e(new a(nVar));
    }
}
