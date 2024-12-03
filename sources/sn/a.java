package sn;

import io.reactivex.exceptions.CompositeException;
import qj.q;
import qj.u;
import retrofit2.adapter.rxjava2.HttpException;
import retrofit2.r;
import tj.b;

final class a<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    private final q<r<T>> f42443a;

    /* renamed from: sn.a$a  reason: collision with other inner class name */
    private static class C0519a<R> implements u<r<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final u<? super R> f42444a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f42445b;

        C0519a(u<? super R> uVar) {
            this.f42444a = uVar;
        }

        public void a(b bVar) {
            this.f42444a.a(bVar);
        }

        /* renamed from: b */
        public void d(r<R> rVar) {
            if (rVar.g()) {
                this.f42444a.d(rVar.a());
                return;
            }
            this.f42445b = true;
            HttpException httpException = new HttpException(rVar);
            try {
                this.f42444a.onError(httpException);
            } catch (Throwable th2) {
                uj.a.b(th2);
                bk.a.s(new CompositeException(httpException, th2));
            }
        }

        public void onComplete() {
            if (!this.f42445b) {
                this.f42444a.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f42445b) {
                this.f42444a.onError(th2);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th2);
            bk.a.s(assertionError);
        }
    }

    a(q<r<T>> qVar) {
        this.f42443a = qVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        this.f42443a.e(new C0519a(uVar));
    }
}
