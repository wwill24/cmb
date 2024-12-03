package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import qj.a;
import qj.d;
import qj.f;
import tj.b;

public final class CompletableDoFinally extends a {

    /* renamed from: a  reason: collision with root package name */
    final f f30104a;

    /* renamed from: b  reason: collision with root package name */
    final vj.a f30105b;

    static final class DoFinallyObserver extends AtomicInteger implements d, b {
        private static final long serialVersionUID = 4109457741734051389L;
        final d downstream;
        final vj.a onFinally;
        b upstream;

        DoFinallyObserver(d dVar, vj.a aVar) {
            this.downstream = dVar;
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

        public void onComplete() {
            this.downstream.onComplete();
            b();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            b();
        }
    }

    public CompletableDoFinally(f fVar, vj.a aVar) {
        this.f30104a = fVar;
        this.f30105b = aVar;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        this.f30104a.e(new DoFinallyObserver(dVar, this.f30105b));
    }
}
