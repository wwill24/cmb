package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.a;
import io.reactivex.internal.schedulers.j;
import qj.s;
import qj.u;
import qj.v;
import tj.b;
import yj.d;
import yj.i;

public final class ObservableObserveOn<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final v f30354b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f30355c;

    /* renamed from: d  reason: collision with root package name */
    final int f30356d;

    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements u<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final u<? super T> downstream;
        Throwable error;
        boolean outputFused;
        i<T> queue;
        int sourceMode;
        b upstream;
        final v.c worker;

        ObserveOnObserver(u<? super T> uVar, v.c cVar, boolean z10, int i10) {
            this.downstream = uVar;
            this.worker = cVar;
            this.delayError = z10;
            this.bufferSize = i10;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof d) {
                    d dVar = (d) bVar;
                    int b10 = dVar.b(7);
                    if (b10 == 1) {
                        this.sourceMode = b10;
                        this.queue = dVar;
                        this.done = true;
                        this.downstream.a(this);
                        h();
                        return;
                    } else if (b10 == 2) {
                        this.sourceMode = b10;
                        this.queue = dVar;
                        this.downstream.a(this);
                        return;
                    }
                }
                this.queue = new a(this.bufferSize);
                this.downstream.a(this);
            }
        }

        public int b(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public boolean c() {
            return this.disposed;
        }

        public void clear() {
            this.queue.clear();
        }

        public void d(T t10) {
            if (!this.done) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t10);
                }
                h();
            }
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.upstream.dispose();
                this.worker.dispose();
                if (!this.outputFused && getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e(boolean z10, boolean z11, u<? super T> uVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            } else if (!z10) {
                return false;
            } else {
                Throwable th2 = this.error;
                if (this.delayError) {
                    if (!z11) {
                        return false;
                    }
                    this.disposed = true;
                    if (th2 != null) {
                        uVar.onError(th2);
                    } else {
                        uVar.onComplete();
                    }
                    this.worker.dispose();
                    return true;
                } else if (th2 != null) {
                    this.disposed = true;
                    this.queue.clear();
                    uVar.onError(th2);
                    this.worker.dispose();
                    return true;
                } else if (!z11) {
                    return false;
                } else {
                    this.disposed = true;
                    uVar.onComplete();
                    this.worker.dispose();
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            int i10 = 1;
            while (!this.disposed) {
                boolean z10 = this.done;
                Throwable th2 = this.error;
                if (this.delayError || !z10 || th2 == null) {
                    this.downstream.d(null);
                    if (z10) {
                        this.disposed = true;
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            this.downstream.onError(th3);
                        } else {
                            this.downstream.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    this.disposed = true;
                    this.downstream.onError(this.error);
                    this.worker.dispose();
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            boolean z10;
            i<T> iVar = this.queue;
            u<? super T> uVar = this.downstream;
            int i10 = 1;
            while (!e(this.done, iVar.isEmpty(), uVar)) {
                while (true) {
                    boolean z11 = this.done;
                    try {
                        T poll = iVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!e(z11, z10, uVar)) {
                            if (z10) {
                                i10 = addAndGet(-i10);
                                if (i10 == 0) {
                                    return;
                                }
                            } else {
                                uVar.d(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        this.disposed = true;
                        this.upstream.dispose();
                        iVar.clear();
                        uVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            if (getAndIncrement() == 0) {
                this.worker.b(this);
            }
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                h();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                bk.a.s(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            h();
        }

        public T poll() throws Exception {
            return this.queue.poll();
        }

        public void run() {
            if (this.outputFused) {
                f();
            } else {
                g();
            }
        }
    }

    public ObservableObserveOn(s<T> sVar, v vVar, boolean z10, int i10) {
        super(sVar);
        this.f30354b = vVar;
        this.f30355c = z10;
        this.f30356d = i10;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        v vVar = this.f30354b;
        if (vVar instanceof j) {
            this.f30395a.e(uVar);
            return;
        }
        this.f30395a.e(new ObserveOnObserver(uVar, vVar.b(), this.f30355c, this.f30356d));
    }
}
