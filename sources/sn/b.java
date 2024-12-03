package sn;

import io.reactivex.exceptions.CompositeException;
import qj.q;
import qj.u;
import retrofit2.d;
import retrofit2.r;

final class b<T> extends q<r<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final retrofit2.b<T> f42446a;

    private static final class a<T> implements tj.b, d<T> {

        /* renamed from: a  reason: collision with root package name */
        private final retrofit2.b<?> f42447a;

        /* renamed from: b  reason: collision with root package name */
        private final u<? super r<T>> f42448b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f42449c;

        /* renamed from: d  reason: collision with root package name */
        boolean f42450d = false;

        a(retrofit2.b<?> bVar, u<? super r<T>> uVar) {
            this.f42447a = bVar;
            this.f42448b = uVar;
        }

        public boolean c() {
            return this.f42449c;
        }

        public void dispose() {
            this.f42449c = true;
            this.f42447a.cancel();
        }

        public void onFailure(retrofit2.b<T> bVar, Throwable th2) {
            if (!bVar.m()) {
                try {
                    this.f42448b.onError(th2);
                } catch (Throwable th3) {
                    uj.a.b(th3);
                    bk.a.s(new CompositeException(th2, th3));
                }
            }
        }

        public void onResponse(retrofit2.b<T> bVar, r<T> rVar) {
            if (!this.f42449c) {
                try {
                    this.f42448b.d(rVar);
                    if (!this.f42449c) {
                        this.f42450d = true;
                        this.f42448b.onComplete();
                    }
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    bk.a.s(new CompositeException(th, th2));
                }
            }
        }
    }

    b(retrofit2.b<T> bVar) {
        this.f42446a = bVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super r<T>> uVar) {
        retrofit2.b<T> clone = this.f42446a.clone();
        a aVar = new a(clone, uVar);
        uVar.a(aVar);
        if (!aVar.c()) {
            clone.L(aVar);
        }
    }
}
