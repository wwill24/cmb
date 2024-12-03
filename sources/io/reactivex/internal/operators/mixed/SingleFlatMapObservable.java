package io.reactivex.internal.operators.mixed;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.q;
import qj.s;
import qj.u;
import qj.z;
import tj.b;
import uj.a;
import vj.j;

public final class SingleFlatMapObservable<T, R> extends q<R> {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30317a;

    /* renamed from: b  reason: collision with root package name */
    final j<? super T, ? extends s<? extends R>> f30318b;

    static final class FlatMapObserver<T, R> extends AtomicReference<b> implements u<R>, z<T>, b {
        private static final long serialVersionUID = -8948264376121066672L;
        final u<? super R> downstream;
        final j<? super T, ? extends s<? extends R>> mapper;

        FlatMapObserver(u<? super R> uVar, j<? super T, ? extends s<? extends R>> jVar) {
            this.downstream = uVar;
            this.mapper = jVar;
        }

        public void a(b bVar) {
            DisposableHelper.d(this, bVar);
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void d(R r10) {
            this.downstream.d(r10);
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
                ((s) xj.b.e(this.mapper.apply(t10), "The mapper returned a null Publisher")).e(this);
            } catch (Throwable th2) {
                a.b(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public SingleFlatMapObservable(b0<T> b0Var, j<? super T, ? extends s<? extends R>> jVar) {
        this.f30317a = b0Var;
        this.f30318b = jVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super R> uVar) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(uVar, this.f30318b);
        uVar.a(flatMapObserver);
        this.f30317a.f(flatMapObserver);
    }
}
