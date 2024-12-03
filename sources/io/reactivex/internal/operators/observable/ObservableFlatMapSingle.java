package io.reactivex.internal.operators.observable;

import androidx.camera.view.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.a;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.q;
import qj.s;
import qj.u;
import qj.z;
import tj.b;
import vj.j;

public final class ObservableFlatMapSingle<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final j<? super T, ? extends b0<? extends R>> f30347b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f30348c;

    static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements u<T>, b {
        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active = new AtomicInteger(1);
        volatile boolean cancelled;
        final boolean delayErrors;
        final u<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final j<? super T, ? extends b0<? extends R>> mapper;
        final AtomicReference<a<R>> queue = new AtomicReference<>();
        final tj.a set = new tj.a();
        b upstream;

        final class InnerObserver extends AtomicReference<b> implements z<R>, b {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            public void a(b bVar) {
                DisposableHelper.i(this, bVar);
            }

            public boolean c() {
                return DisposableHelper.b((b) get());
            }

            public void dispose() {
                DisposableHelper.a(this);
            }

            public void onError(Throwable th2) {
                FlatMapSingleObserver.this.h(this, th2);
            }

            public void onSuccess(R r10) {
                FlatMapSingleObserver.this.i(this, r10);
            }
        }

        FlatMapSingleObserver(u<? super R> uVar, j<? super T, ? extends b0<? extends R>> jVar, boolean z10) {
            this.downstream = uVar;
            this.mapper = jVar;
            this.delayErrors = z10;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            a aVar = this.queue.get();
            if (aVar != null) {
                aVar.clear();
            }
        }

        public boolean c() {
            return this.cancelled;
        }

        public void d(T t10) {
            try {
                b0 b0Var = (b0) xj.b.e(this.mapper.apply(t10), "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.cancelled && this.set.a(innerObserver)) {
                    b0Var.f(innerObserver);
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (getAndIncrement() == 0) {
                f();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            boolean z10;
            Object obj;
            u<? super R> uVar = this.downstream;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<a<R>> atomicReference = this.queue;
            int i10 = 1;
            while (!this.cancelled) {
                if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                    boolean z11 = false;
                    if (atomicInteger.get() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    a aVar = atomicReference.get();
                    if (aVar != null) {
                        obj = aVar.poll();
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        z11 = true;
                    }
                    if (z10 && z11) {
                        Throwable b10 = this.errors.b();
                        if (b10 != null) {
                            uVar.onError(b10);
                            return;
                        } else {
                            uVar.onComplete();
                            return;
                        }
                    } else if (z11) {
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        uVar.d(obj);
                    }
                } else {
                    Throwable b11 = this.errors.b();
                    b();
                    uVar.onError(b11);
                    return;
                }
            }
            b();
        }

        /* access modifiers changed from: package-private */
        public a<R> g() {
            a<R> aVar;
            do {
                a<R> aVar2 = this.queue.get();
                if (aVar2 != null) {
                    return aVar2;
                }
                aVar = new a<>(q.j());
            } while (!h.a(this.queue, (Object) null, aVar));
            return aVar;
        }

        /* access modifiers changed from: package-private */
        public void h(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.set.b(innerObserver);
            if (this.errors.a(th2)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    this.set.dispose();
                }
                this.active.decrementAndGet();
                e();
                return;
            }
            bk.a.s(th2);
        }

        /* access modifiers changed from: package-private */
        public void i(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, R r10) {
            this.set.b(innerObserver);
            if (get() == 0) {
                boolean z10 = false;
                if (compareAndSet(0, 1)) {
                    this.downstream.d(r10);
                    if (this.active.decrementAndGet() == 0) {
                        z10 = true;
                    }
                    a aVar = this.queue.get();
                    if (!z10 || (aVar != null && !aVar.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        f();
                    }
                    Throwable b10 = this.errors.b();
                    if (b10 != null) {
                        this.downstream.onError(b10);
                        return;
                    } else {
                        this.downstream.onComplete();
                        return;
                    }
                }
            }
            a g10 = g();
            synchronized (g10) {
                g10.offer(r10);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            f();
        }

        public void onComplete() {
            this.active.decrementAndGet();
            e();
        }

        public void onError(Throwable th2) {
            this.active.decrementAndGet();
            if (this.errors.a(th2)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                e();
                return;
            }
            bk.a.s(th2);
        }
    }

    public ObservableFlatMapSingle(s<T> sVar, j<? super T, ? extends b0<? extends R>> jVar, boolean z10) {
        super(sVar);
        this.f30347b = jVar;
        this.f30348c = z10;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super R> uVar) {
        this.f30395a.e(new FlatMapSingleObserver(uVar, this.f30347b, this.f30348c));
    }
}
