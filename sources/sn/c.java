package sn;

import io.reactivex.exceptions.CompositeException;
import qj.q;
import qj.u;
import retrofit2.b;
import retrofit2.r;

final class c<T> extends q<r<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T> f42451a;

    private static final class a implements tj.b {

        /* renamed from: a  reason: collision with root package name */
        private final b<?> f42452a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f42453b;

        a(b<?> bVar) {
            this.f42452a = bVar;
        }

        public boolean c() {
            return this.f42453b;
        }

        public void dispose() {
            this.f42453b = true;
            this.f42452a.cancel();
        }
    }

    c(b<T> bVar) {
        this.f42451a = bVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super r<T>> uVar) {
        boolean z10;
        b<T> clone = this.f42451a.clone();
        a aVar = new a(clone);
        uVar.a(aVar);
        if (!aVar.c()) {
            try {
                r<T> f10 = clone.f();
                if (!aVar.c()) {
                    uVar.d(f10);
                }
                if (!aVar.c()) {
                    try {
                        uVar.onComplete();
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = true;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z10 = false;
                uj.a.b(th);
                if (z10) {
                    bk.a.s(th);
                } else if (!aVar.c()) {
                    try {
                        uVar.onError(th);
                    } catch (Throwable th4) {
                        uj.a.b(th4);
                        bk.a.s(new CompositeException(th, th4));
                    }
                }
            }
        }
    }
}
