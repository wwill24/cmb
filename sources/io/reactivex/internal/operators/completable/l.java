package io.reactivex.internal.operators.completable;

import java.util.concurrent.Callable;
import qj.d;
import qj.f;
import qj.w;
import qj.z;
import tj.b;

public final class l<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final f f30141a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends T> f30142b;

    /* renamed from: c  reason: collision with root package name */
    final T f30143c;

    final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private final z<? super T> f30144a;

        a(z<? super T> zVar) {
            this.f30144a = zVar;
        }

        public void a(b bVar) {
            this.f30144a.a(bVar);
        }

        public void onComplete() {
            T t10;
            l lVar = l.this;
            Callable<? extends T> callable = lVar.f30142b;
            if (callable != null) {
                try {
                    t10 = callable.call();
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    this.f30144a.onError(th2);
                    return;
                }
            } else {
                t10 = lVar.f30143c;
            }
            if (t10 == null) {
                this.f30144a.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.f30144a.onSuccess(t10);
            }
        }

        public void onError(Throwable th2) {
            this.f30144a.onError(th2);
        }
    }

    public l(f fVar, Callable<? extends T> callable, T t10) {
        this.f30141a = fVar;
        this.f30143c = t10;
        this.f30142b = callable;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30141a.e(new a(zVar));
    }
}
