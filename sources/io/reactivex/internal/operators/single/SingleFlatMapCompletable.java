package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.a;
import qj.b0;
import qj.d;
import qj.f;
import qj.z;
import tj.b;
import vj.j;

public final class SingleFlatMapCompletable<T> extends a {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30522a;

    /* renamed from: b  reason: collision with root package name */
    final j<? super T, ? extends f> f30523b;

    static final class FlatMapCompletableObserver<T> extends AtomicReference<b> implements z<T>, d, b {
        private static final long serialVersionUID = -2177128922851101253L;
        final d downstream;
        final j<? super T, ? extends f> mapper;

        FlatMapCompletableObserver(d dVar, j<? super T, ? extends f> jVar) {
            this.downstream = dVar;
            this.mapper = jVar;
        }

        public void a(b bVar) {
            DisposableHelper.d(this, bVar);
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSuccess(T t10) {
            try {
                f fVar = (f) xj.b.e(this.mapper.apply(t10), "The mapper returned a null CompletableSource");
                if (!c()) {
                    fVar.e(this);
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                onError(th2);
            }
        }
    }

    public SingleFlatMapCompletable(b0<T> b0Var, j<? super T, ? extends f> jVar) {
        this.f30522a = b0Var;
        this.f30523b = jVar;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(dVar, this.f30523b);
        dVar.a(flatMapCompletableObserver);
        this.f30522a.f(flatMapCompletableObserver);
    }
}
