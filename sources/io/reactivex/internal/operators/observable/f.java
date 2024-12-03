package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import qj.q;
import qj.s;
import qj.u;
import qj.w;
import qj.z;
import tj.b;
import yj.c;

public final class f<T> extends w<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    final s<T> f30446a;

    /* renamed from: b  reason: collision with root package name */
    final long f30447b;

    /* renamed from: c  reason: collision with root package name */
    final T f30448c;

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final z<? super T> f30449a;

        /* renamed from: b  reason: collision with root package name */
        final long f30450b;

        /* renamed from: c  reason: collision with root package name */
        final T f30451c;

        /* renamed from: d  reason: collision with root package name */
        b f30452d;

        /* renamed from: e  reason: collision with root package name */
        long f30453e;

        /* renamed from: f  reason: collision with root package name */
        boolean f30454f;

        a(z<? super T> zVar, long j10, T t10) {
            this.f30449a = zVar;
            this.f30450b = j10;
            this.f30451c = t10;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30452d, bVar)) {
                this.f30452d = bVar;
                this.f30449a.a(this);
            }
        }

        public boolean c() {
            return this.f30452d.c();
        }

        public void d(T t10) {
            if (!this.f30454f) {
                long j10 = this.f30453e;
                if (j10 == this.f30450b) {
                    this.f30454f = true;
                    this.f30452d.dispose();
                    this.f30449a.onSuccess(t10);
                    return;
                }
                this.f30453e = j10 + 1;
            }
        }

        public void dispose() {
            this.f30452d.dispose();
        }

        public void onComplete() {
            if (!this.f30454f) {
                this.f30454f = true;
                T t10 = this.f30451c;
                if (t10 != null) {
                    this.f30449a.onSuccess(t10);
                } else {
                    this.f30449a.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f30454f) {
                bk.a.s(th2);
                return;
            }
            this.f30454f = true;
            this.f30449a.onError(th2);
        }
    }

    public f(s<T> sVar, long j10, T t10) {
        this.f30446a = sVar;
        this.f30447b = j10;
        this.f30448c = t10;
    }

    public void J(z<? super T> zVar) {
        this.f30446a.e(new a(zVar, this.f30447b, this.f30448c));
    }

    public q<T> h() {
        return bk.a.n(new e(this.f30446a, this.f30447b, this.f30448c, true));
    }
}
