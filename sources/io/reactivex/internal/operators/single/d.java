package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.EmptyDisposable;
import qj.b0;
import qj.w;
import qj.z;
import tj.b;
import vj.f;

public final class d<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30564a;

    /* renamed from: b  reason: collision with root package name */
    final f<? super b> f30565b;

    static final class a<T> implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        final z<? super T> f30566a;

        /* renamed from: b  reason: collision with root package name */
        final f<? super b> f30567b;

        /* renamed from: c  reason: collision with root package name */
        boolean f30568c;

        a(z<? super T> zVar, f<? super b> fVar) {
            this.f30566a = zVar;
            this.f30567b = fVar;
        }

        public void a(b bVar) {
            try {
                this.f30567b.accept(bVar);
                this.f30566a.a(bVar);
            } catch (Throwable th2) {
                uj.a.b(th2);
                this.f30568c = true;
                bVar.dispose();
                EmptyDisposable.j(th2, this.f30566a);
            }
        }

        public void onError(Throwable th2) {
            if (this.f30568c) {
                bk.a.s(th2);
            } else {
                this.f30566a.onError(th2);
            }
        }

        public void onSuccess(T t10) {
            if (!this.f30568c) {
                this.f30566a.onSuccess(t10);
            }
        }
    }

    public d(b0<T> b0Var, f<? super b> fVar) {
        this.f30564a = b0Var;
        this.f30565b = fVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30564a.f(new a(zVar, this.f30565b));
    }
}
