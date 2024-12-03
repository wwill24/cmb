package sn;

import io.reactivex.exceptions.CompositeException;
import qj.q;
import qj.u;
import retrofit2.r;
import tj.b;

final class e<T> extends q<d<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final q<r<T>> f42456a;

    private static class a<R> implements u<r<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final u<? super d<R>> f42457a;

        a(u<? super d<R>> uVar) {
            this.f42457a = uVar;
        }

        public void a(b bVar) {
            this.f42457a.a(bVar);
        }

        /* renamed from: b */
        public void d(r<R> rVar) {
            this.f42457a.d(d.b(rVar));
        }

        public void onComplete() {
            this.f42457a.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                this.f42457a.d(d.a(th2));
                this.f42457a.onComplete();
            } catch (Throwable th3) {
                uj.a.b(th3);
                bk.a.s(new CompositeException(th, th3));
            }
        }
    }

    e(q<r<T>> qVar) {
        this.f42456a = qVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super d<T>> uVar) {
        this.f42456a.e(new a(uVar));
    }
}
