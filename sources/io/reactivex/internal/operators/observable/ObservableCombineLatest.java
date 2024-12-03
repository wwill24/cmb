package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.a;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.q;
import qj.s;
import qj.u;
import tj.b;
import vj.j;

public final class ObservableCombineLatest<T, R> extends q<R> {

    /* renamed from: a  reason: collision with root package name */
    final s<? extends T>[] f30319a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends s<? extends T>> f30320b;

    /* renamed from: c  reason: collision with root package name */
    final j<? super Object[], ? extends R> f30321c;

    /* renamed from: d  reason: collision with root package name */
    final int f30322d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f30323e;

    static final class CombinerObserver<T, R> extends AtomicReference<b> implements u<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final LatestCoordinator<T, R> parent;

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i10) {
            this.parent = latestCoordinator;
            this.index = i10;
        }

        public void a(b bVar) {
            DisposableHelper.i(this, bVar);
        }

        public void b() {
            DisposableHelper.a(this);
        }

        public void d(T t10) {
            this.parent.g(this.index, t10);
        }

        public void onComplete() {
            this.parent.e(this.index);
        }

        public void onError(Throwable th2) {
            this.parent.f(this.index, th2);
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements b {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final j<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final u<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        Object[] latest;
        final CombinerObserver<T, R>[] observers;
        final a<Object[]> queue;

        LatestCoordinator(u<? super R> uVar, j<? super Object[], ? extends R> jVar, int i10, int i11, boolean z10) {
            this.downstream = uVar;
            this.combiner = jVar;
            this.delayError = z10;
            this.latest = new Object[i10];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                combinerObserverArr[i12] = new CombinerObserver<>(this, i12);
            }
            this.observers = combinerObserverArr;
            this.queue = new a<>(i11);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            for (CombinerObserver<T, R> b10 : this.observers) {
                b10.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(a<?> aVar) {
            synchronized (this) {
                this.latest = null;
            }
            aVar.clear();
        }

        public boolean c() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z10;
            if (getAndIncrement() == 0) {
                a<Object[]> aVar = this.queue;
                u<? super R> uVar = this.downstream;
                boolean z11 = this.delayError;
                int i10 = 1;
                while (!this.cancelled) {
                    if (z11 || this.errors.get() == null) {
                        boolean z12 = this.done;
                        Object[] poll = aVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z12 && z10) {
                            b(aVar);
                            Throwable b10 = this.errors.b();
                            if (b10 == null) {
                                uVar.onComplete();
                                return;
                            } else {
                                uVar.onError(b10);
                                return;
                            }
                        } else if (z10) {
                            i10 = addAndGet(-i10);
                            if (i10 == 0) {
                                return;
                            }
                        } else {
                            try {
                                uVar.d(xj.b.e(this.combiner.apply(poll), "The combiner returned a null value"));
                            } catch (Throwable th2) {
                                uj.a.b(th2);
                                this.errors.a(th2);
                                a();
                                b(aVar);
                                uVar.onError(this.errors.b());
                                return;
                            }
                        }
                    } else {
                        a();
                        b(aVar);
                        uVar.onError(this.errors.b());
                        return;
                    }
                }
                b(aVar);
            }
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                a();
                if (getAndIncrement() == 0) {
                    b(this.queue);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            if (r2 == r0.length) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
            if (r4 == false) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
            d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch:{ all -> 0x0025 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                return
            L_0x0007:
                r4 = r0[r4]     // Catch:{ all -> 0x0025 }
                r1 = 1
                if (r4 != 0) goto L_0x000e
                r4 = r1
                goto L_0x000f
            L_0x000e:
                r4 = 0
            L_0x000f:
                if (r4 != 0) goto L_0x0019
                int r2 = r3.complete     // Catch:{ all -> 0x0025 }
                int r2 = r2 + r1
                r3.complete = r2     // Catch:{ all -> 0x0025 }
                int r0 = r0.length     // Catch:{ all -> 0x0025 }
                if (r2 != r0) goto L_0x001b
            L_0x0019:
                r3.done = r1     // Catch:{ all -> 0x0025 }
            L_0x001b:
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                if (r4 == 0) goto L_0x0021
                r3.a()
            L_0x0021:
                r3.d()
                return
            L_0x0025:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.e(int):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            if (r1 == r4.length) goto L_0x0025;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
            r0 = r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.internal.util.AtomicThrowable r0 = r2.errors
                boolean r0 = r0.a(r4)
                if (r0 == 0) goto L_0x0036
                boolean r4 = r2.delayError
                r0 = 1
                if (r4 == 0) goto L_0x002d
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.latest     // Catch:{ all -> 0x002a }
                if (r4 != 0) goto L_0x0014
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                return
            L_0x0014:
                r3 = r4[r3]     // Catch:{ all -> 0x002a }
                if (r3 != 0) goto L_0x001a
                r3 = r0
                goto L_0x001b
            L_0x001a:
                r3 = 0
            L_0x001b:
                if (r3 != 0) goto L_0x0025
                int r1 = r2.complete     // Catch:{ all -> 0x002a }
                int r1 = r1 + r0
                r2.complete = r1     // Catch:{ all -> 0x002a }
                int r4 = r4.length     // Catch:{ all -> 0x002a }
                if (r1 != r4) goto L_0x0027
            L_0x0025:
                r2.done = r0     // Catch:{ all -> 0x002a }
            L_0x0027:
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                r0 = r3
                goto L_0x002d
            L_0x002a:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                throw r3
            L_0x002d:
                if (r0 == 0) goto L_0x0032
                r2.a()
            L_0x0032:
                r2.d()
                goto L_0x0039
            L_0x0036:
                bk.a.s(r4)
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.f(int, java.lang.Throwable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            if (r4 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(int r4, T r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch:{ all -> 0x0029 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                return
            L_0x0007:
                r1 = r0[r4]     // Catch:{ all -> 0x0029 }
                int r2 = r3.active     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0011
                int r2 = r2 + 1
                r3.active = r2     // Catch:{ all -> 0x0029 }
            L_0x0011:
                r0[r4] = r5     // Catch:{ all -> 0x0029 }
                int r4 = r0.length     // Catch:{ all -> 0x0029 }
                if (r2 != r4) goto L_0x0021
                io.reactivex.internal.queue.a<java.lang.Object[]> r4 = r3.queue     // Catch:{ all -> 0x0029 }
                java.lang.Object r5 = r0.clone()     // Catch:{ all -> 0x0029 }
                r4.offer(r5)     // Catch:{ all -> 0x0029 }
                r4 = 1
                goto L_0x0022
            L_0x0021:
                r4 = 0
            L_0x0022:
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                if (r4 == 0) goto L_0x0028
                r3.d()
            L_0x0028:
                return
            L_0x0029:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.g(int, java.lang.Object):void");
        }

        public void h(s<? extends T>[] sVarArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            this.downstream.a(this);
            for (int i10 = 0; i10 < length && !this.done && !this.cancelled; i10++) {
                sVarArr[i10].e(combinerObserverArr[i10]);
            }
        }
    }

    public ObservableCombineLatest(s<? extends T>[] sVarArr, Iterable<? extends s<? extends T>> iterable, j<? super Object[], ? extends R> jVar, int i10, boolean z10) {
        this.f30319a = sVarArr;
        this.f30320b = iterable;
        this.f30321c = jVar;
        this.f30322d = i10;
        this.f30323e = z10;
    }

    public void l0(u<? super R> uVar) {
        int i10;
        s<? extends T>[] sVarArr = this.f30319a;
        if (sVarArr == null) {
            sVarArr = new s[8];
            i10 = 0;
            for (s<? extends T> sVar : this.f30320b) {
                if (i10 == sVarArr.length) {
                    s<? extends T>[] sVarArr2 = new s[((i10 >> 2) + i10)];
                    System.arraycopy(sVarArr, 0, sVarArr2, 0, i10);
                    sVarArr = sVarArr2;
                }
                sVarArr[i10] = sVar;
                i10++;
            }
        } else {
            i10 = sVarArr.length;
        }
        int i11 = i10;
        if (i11 == 0) {
            EmptyDisposable.e(uVar);
            return;
        }
        new LatestCoordinator(uVar, this.f30321c, i11, this.f30322d, this.f30323e).h(sVarArr);
    }
}
