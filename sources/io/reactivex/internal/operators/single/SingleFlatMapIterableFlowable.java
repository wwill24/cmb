package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import qj.b0;
import qj.h;
import qj.z;
import rn.b;
import uj.a;
import vj.j;

public final class SingleFlatMapIterableFlowable<T, R> extends h<R> {

    /* renamed from: b  reason: collision with root package name */
    final b0<T> f30524b;

    /* renamed from: c  reason: collision with root package name */
    final j<? super T, ? extends Iterable<? extends R>> f30525c;

    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements z<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final b<? super R> downstream;
        volatile Iterator<? extends R> it;
        final j<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested = new AtomicLong();
        tj.b upstream;

        FlatMapIterableObserver(b<? super R> bVar, j<? super T, ? extends Iterable<? extends R>> jVar) {
            this.downstream = bVar;
            this.mapper = jVar;
        }

        public void a(tj.b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.e(this);
            }
        }

        public int b(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                b<? super R> bVar = this.downstream;
                Iterator<? extends R> it2 = this.it;
                if (!this.outputFused || it2 == null) {
                    int i10 = 1;
                    while (true) {
                        if (it2 != null) {
                            long j10 = this.requested.get();
                            if (j10 == Long.MAX_VALUE) {
                                g(bVar, it2);
                                return;
                            }
                            long j11 = 0;
                            while (j11 != j10) {
                                if (!this.cancelled) {
                                    try {
                                        bVar.d(xj.b.e(it2.next(), "The iterator returned a null value"));
                                        if (!this.cancelled) {
                                            j11++;
                                            try {
                                                if (!it2.hasNext()) {
                                                    bVar.onComplete();
                                                    return;
                                                }
                                            } catch (Throwable th2) {
                                                a.b(th2);
                                                bVar.onError(th2);
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } catch (Throwable th3) {
                                        a.b(th3);
                                        bVar.onError(th3);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (j11 != 0) {
                                io.reactivex.internal.util.b.c(this.requested, j11);
                            }
                        }
                        i10 = addAndGet(-i10);
                        if (i10 != 0) {
                            if (it2 == null) {
                                it2 = this.it;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    bVar.d(null);
                    bVar.onComplete();
                }
            }
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        public void clear() {
            this.it = null;
        }

        /* access modifiers changed from: package-private */
        public void g(b<? super R> bVar, Iterator<? extends R> it2) {
            while (!this.cancelled) {
                try {
                    bVar.d(it2.next());
                    if (!this.cancelled) {
                        try {
                            if (!it2.hasNext()) {
                                bVar.onComplete();
                                return;
                            }
                        } catch (Throwable th2) {
                            a.b(th2);
                            bVar.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    a.b(th3);
                    bVar.onError(th3);
                    return;
                }
            }
        }

        public boolean isEmpty() {
            return this.it == null;
        }

        public void onError(Throwable th2) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th2);
        }

        public void onSuccess(T t10) {
            try {
                Iterator<? extends R> it2 = ((Iterable) this.mapper.apply(t10)).iterator();
                if (!it2.hasNext()) {
                    this.downstream.onComplete();
                    return;
                }
                this.it = it2;
                c();
            } catch (Throwable th2) {
                a.b(th2);
                this.downstream.onError(th2);
            }
        }

        public R poll() throws Exception {
            Iterator<? extends R> it2 = this.it;
            if (it2 == null) {
                return null;
            }
            R e10 = xj.b.e(it2.next(), "The iterator returned a null value");
            if (!it2.hasNext()) {
                this.it = null;
            }
            return e10;
        }

        public void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                c();
            }
        }
    }

    public SingleFlatMapIterableFlowable(b0<T> b0Var, j<? super T, ? extends Iterable<? extends R>> jVar) {
        this.f30524b = b0Var;
        this.f30525c = jVar;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super R> bVar) {
        this.f30524b.f(new FlatMapIterableObserver(bVar, this.f30525c));
    }
}
