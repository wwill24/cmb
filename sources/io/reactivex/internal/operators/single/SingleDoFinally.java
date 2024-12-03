package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import qj.b0;
import qj.w;
import qj.z;
import tj.b;
import vj.a;

public final class SingleDoFinally<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30516a;

    /* renamed from: b  reason: collision with root package name */
    final a f30517b;

    static final class DoFinallyObserver<T> extends AtomicInteger implements z<T>, b {
        private static final long serialVersionUID = 4109457741734051389L;
        final z<? super T> downstream;
        final a onFinally;
        b upstream;

        DoFinallyObserver(z<? super T> zVar, a aVar) {
            this.downstream = zVar;
            this.onFinally = aVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    bk.a.s(th2);
                }
            }
        }

        public boolean c() {
            return this.upstream.c();
        }

        public void dispose() {
            this.upstream.dispose();
            b();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            b();
        }

        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
            b();
        }
    }

    public SingleDoFinally(b0<T> b0Var, a aVar) {
        this.f30516a = b0Var;
        this.f30517b = aVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30516a.f(new DoFinallyObserver(zVar, this.f30517b));
    }
}
