package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import qj.s;
import qj.u;
import qj.w;
import qj.z;
import tj.b;

public final class y<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final s<? extends T> f30502a;

    /* renamed from: b  reason: collision with root package name */
    final T f30503b;

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final z<? super T> f30504a;

        /* renamed from: b  reason: collision with root package name */
        final T f30505b;

        /* renamed from: c  reason: collision with root package name */
        b f30506c;

        /* renamed from: d  reason: collision with root package name */
        T f30507d;

        /* renamed from: e  reason: collision with root package name */
        boolean f30508e;

        a(z<? super T> zVar, T t10) {
            this.f30504a = zVar;
            this.f30505b = t10;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30506c, bVar)) {
                this.f30506c = bVar;
                this.f30504a.a(this);
            }
        }

        public boolean c() {
            return this.f30506c.c();
        }

        public void d(T t10) {
            if (!this.f30508e) {
                if (this.f30507d != null) {
                    this.f30508e = true;
                    this.f30506c.dispose();
                    this.f30504a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f30507d = t10;
            }
        }

        public void dispose() {
            this.f30506c.dispose();
        }

        public void onComplete() {
            if (!this.f30508e) {
                this.f30508e = true;
                T t10 = this.f30507d;
                this.f30507d = null;
                if (t10 == null) {
                    t10 = this.f30505b;
                }
                if (t10 != null) {
                    this.f30504a.onSuccess(t10);
                } else {
                    this.f30504a.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f30508e) {
                bk.a.s(th2);
                return;
            }
            this.f30508e = true;
            this.f30504a.onError(th2);
        }
    }

    public y(s<? extends T> sVar, T t10) {
        this.f30502a = sVar;
        this.f30503b = t10;
    }

    public void J(z<? super T> zVar) {
        this.f30502a.e(new a(zVar, this.f30503b));
    }
}
