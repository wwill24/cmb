package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import qj.s;
import qj.u;
import tj.b;

public final class e<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f30436b;

    /* renamed from: c  reason: collision with root package name */
    final T f30437c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30438d;

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30439a;

        /* renamed from: b  reason: collision with root package name */
        final long f30440b;

        /* renamed from: c  reason: collision with root package name */
        final T f30441c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f30442d;

        /* renamed from: e  reason: collision with root package name */
        b f30443e;

        /* renamed from: f  reason: collision with root package name */
        long f30444f;

        /* renamed from: g  reason: collision with root package name */
        boolean f30445g;

        a(u<? super T> uVar, long j10, T t10, boolean z10) {
            this.f30439a = uVar;
            this.f30440b = j10;
            this.f30441c = t10;
            this.f30442d = z10;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30443e, bVar)) {
                this.f30443e = bVar;
                this.f30439a.a(this);
            }
        }

        public boolean c() {
            return this.f30443e.c();
        }

        public void d(T t10) {
            if (!this.f30445g) {
                long j10 = this.f30444f;
                if (j10 == this.f30440b) {
                    this.f30445g = true;
                    this.f30443e.dispose();
                    this.f30439a.d(t10);
                    this.f30439a.onComplete();
                    return;
                }
                this.f30444f = j10 + 1;
            }
        }

        public void dispose() {
            this.f30443e.dispose();
        }

        public void onComplete() {
            if (!this.f30445g) {
                this.f30445g = true;
                T t10 = this.f30441c;
                if (t10 != null || !this.f30442d) {
                    if (t10 != null) {
                        this.f30439a.d(t10);
                    }
                    this.f30439a.onComplete();
                    return;
                }
                this.f30439a.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th2) {
            if (this.f30445g) {
                bk.a.s(th2);
                return;
            }
            this.f30445g = true;
            this.f30439a.onError(th2);
        }
    }

    public e(s<T> sVar, long j10, T t10, boolean z10) {
        super(sVar);
        this.f30436b = j10;
        this.f30437c = t10;
        this.f30438d = z10;
    }

    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(uVar, this.f30436b, this.f30437c, this.f30438d));
    }
}
