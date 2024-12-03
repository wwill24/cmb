package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.c;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.q;
import qj.s;
import qj.u;
import tj.b;
import uj.a;
import vj.j;

public final class ObservableRetryWhen<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final j<? super q<Throwable>, ? extends s<?>> f30379b;

    static final class RepeatWhenObserver<T> extends AtomicInteger implements u<T>, b {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final u<? super T> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
        final c<Throwable> signaller;
        final s<T> source;
        final AtomicReference<b> upstream = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();

        final class InnerRepeatObserver extends AtomicReference<b> implements u<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            InnerRepeatObserver() {
            }

            public void a(b bVar) {
                DisposableHelper.i(this, bVar);
            }

            public void d(Object obj) {
                RepeatWhenObserver.this.f();
            }

            public void onComplete() {
                RepeatWhenObserver.this.b();
            }

            public void onError(Throwable th2) {
                RepeatWhenObserver.this.e(th2);
            }
        }

        RepeatWhenObserver(u<? super T> uVar, c<Throwable> cVar, s<T> sVar) {
            this.downstream = uVar;
            this.signaller = cVar;
            this.source = sVar;
        }

        public void a(b bVar) {
            DisposableHelper.d(this.upstream, bVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            DisposableHelper.a(this.upstream);
            e.a(this.downstream, this, this.error);
        }

        public boolean c() {
            return DisposableHelper.b(this.upstream.get());
        }

        public void d(T t10) {
            e.e(this.downstream, t10, this, this.error);
        }

        public void dispose() {
            DisposableHelper.a(this.upstream);
            DisposableHelper.a(this.inner);
        }

        /* access modifiers changed from: package-private */
        public void e(Throwable th2) {
            DisposableHelper.a(this.upstream);
            e.c(this.downstream, th2, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public void f() {
            g();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            if (this.wip.getAndIncrement() == 0) {
                while (!c()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.e(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            DisposableHelper.a(this.inner);
            e.a(this.downstream, this, this.error);
        }

        public void onError(Throwable th2) {
            DisposableHelper.d(this.upstream, (b) null);
            this.active = false;
            this.signaller.d(th2);
        }
    }

    public ObservableRetryWhen(s<T> sVar, j<? super q<Throwable>, ? extends s<?>> jVar) {
        super(sVar);
        this.f30379b = jVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        c A0 = PublishSubject.C0().A0();
        try {
            s sVar = (s) xj.b.e(this.f30379b.apply(A0), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(uVar, A0, this.f30395a);
            uVar.a(repeatWhenObserver);
            sVar.e(repeatWhenObserver.inner);
            repeatWhenObserver.g();
        } catch (Throwable th2) {
            a.b(th2);
            EmptyDisposable.i(th2, uVar);
        }
    }
}
