package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.w;
import qj.z;
import tj.b;
import vj.j;

public final class SingleFlatMap<T, R> extends w<R> {

    /* renamed from: a  reason: collision with root package name */
    final b0<? extends T> f30518a;

    /* renamed from: b  reason: collision with root package name */
    final j<? super T, ? extends b0<? extends R>> f30519b;

    static final class SingleFlatMapCallback<T, R> extends AtomicReference<b> implements z<T>, b {
        private static final long serialVersionUID = 3258103020495908596L;
        final z<? super R> downstream;
        final j<? super T, ? extends b0<? extends R>> mapper;

        static final class a<R> implements z<R> {

            /* renamed from: a  reason: collision with root package name */
            final AtomicReference<b> f30520a;

            /* renamed from: b  reason: collision with root package name */
            final z<? super R> f30521b;

            a(AtomicReference<b> atomicReference, z<? super R> zVar) {
                this.f30520a = atomicReference;
                this.f30521b = zVar;
            }

            public void a(b bVar) {
                DisposableHelper.d(this.f30520a, bVar);
            }

            public void onError(Throwable th2) {
                this.f30521b.onError(th2);
            }

            public void onSuccess(R r10) {
                this.f30521b.onSuccess(r10);
            }
        }

        SingleFlatMapCallback(z<? super R> zVar, j<? super T, ? extends b0<? extends R>> jVar) {
            this.downstream = zVar;
            this.mapper = jVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.i(this, bVar)) {
                this.downstream.a(this);
            }
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSuccess(T t10) {
            try {
                b0 b0Var = (b0) xj.b.e(this.mapper.apply(t10), "The single returned by the mapper is null");
                if (!c()) {
                    b0Var.f(new a(this, this.downstream));
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public SingleFlatMap(b0<? extends T> b0Var, j<? super T, ? extends b0<? extends R>> jVar) {
        this.f30519b = jVar;
        this.f30518a = b0Var;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super R> zVar) {
        this.f30518a.f(new SingleFlatMapCallback(zVar, this.f30519b));
    }
}
