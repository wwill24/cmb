package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.o;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.h;
import qj.l;
import rn.b;
import rn.c;
import vj.j;

public final class FlowableCombineLatest<T, R> extends h<R> {

    /* renamed from: b  reason: collision with root package name */
    final rn.a<? extends T>[] f30146b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<? extends rn.a<? extends T>> f30147c = null;

    /* renamed from: d  reason: collision with root package name */
    final j<? super Object[], ? extends R> f30148d;

    /* renamed from: e  reason: collision with root package name */
    final int f30149e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f30150f;

    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        volatile boolean cancelled;
        final j<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final b<? super R> downstream;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final io.reactivex.internal.queue.a<Object> queue;
        final AtomicLong requested;
        final CombineLatestInnerSubscriber<T>[] subscribers;

        CombineLatestCoordinator(b<? super R> bVar, j<? super Object[], ? extends R> jVar, int i10, int i11, boolean z10) {
            this.downstream = bVar;
            this.combiner = jVar;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                combineLatestInnerSubscriberArr[i12] = new CombineLatestInnerSubscriber<>(this, i12, i11);
            }
            this.subscribers = combineLatestInnerSubscriberArr;
            this.latest = new Object[i10];
            this.queue = new io.reactivex.internal.queue.a<>(i11);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z10;
        }

        public int b(int i10) {
            boolean z10 = false;
            if ((i10 & 4) != 0) {
                return 0;
            }
            int i11 = i10 & 2;
            if (i11 != 0) {
                z10 = true;
            }
            this.outputFused = z10;
            return i11;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            for (CombineLatestInnerSubscriber<T> a10 : this.subscribers) {
                a10.a();
            }
        }

        public void cancel() {
            this.cancelled = true;
            c();
        }

        public void clear() {
            this.queue.clear();
        }

        /* access modifiers changed from: package-private */
        public boolean g(boolean z10, boolean z11, b<?> bVar, io.reactivex.internal.queue.a<?> aVar) {
            if (this.cancelled) {
                c();
                aVar.clear();
                return true;
            } else if (!z10) {
                return false;
            } else {
                if (!this.delayErrors) {
                    Throwable b10 = ExceptionHelper.b(this.error);
                    if (b10 != null && b10 != ExceptionHelper.f30712a) {
                        c();
                        aVar.clear();
                        bVar.onError(b10);
                        return true;
                    } else if (!z11) {
                        return false;
                    } else {
                        c();
                        bVar.onComplete();
                        return true;
                    }
                } else if (!z11) {
                    return false;
                } else {
                    c();
                    Throwable b11 = ExceptionHelper.b(this.error);
                    if (b11 == null || b11 == ExceptionHelper.f30712a) {
                        bVar.onComplete();
                    } else {
                        bVar.onError(b11);
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    j();
                } else {
                    i();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int i10;
            boolean z10;
            b<? super R> bVar = this.downstream;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            int i11 = 1;
            do {
                long j10 = this.requested.get();
                long j11 = 0;
                while (true) {
                    i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                    if (i10 == 0) {
                        break;
                    }
                    boolean z11 = this.done;
                    Object poll = aVar.poll();
                    if (poll == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!g(z11, z10, bVar, aVar)) {
                        if (z10) {
                            break;
                        }
                        try {
                            bVar.d(xj.b.e(this.combiner.apply((Object[]) aVar.poll()), "The combiner returned a null value"));
                            ((CombineLatestInnerSubscriber) poll).b();
                            j11++;
                        } catch (Throwable th2) {
                            uj.a.b(th2);
                            c();
                            ExceptionHelper.a(this.error, th2);
                            bVar.onError(ExceptionHelper.b(this.error));
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (i10 != 0 || !g(this.done, aVar.isEmpty(), bVar, aVar)) {
                    if (!(j11 == 0 || j10 == Long.MAX_VALUE)) {
                        this.requested.addAndGet(-j11);
                    }
                    i11 = addAndGet(-i11);
                } else {
                    return;
                }
            } while (i11 != 0);
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void j() {
            b<? super R> bVar = this.downstream;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            int i10 = 1;
            while (!this.cancelled) {
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    aVar.clear();
                    bVar.onError(th2);
                    return;
                }
                boolean z10 = this.done;
                boolean isEmpty = aVar.isEmpty();
                if (!isEmpty) {
                    bVar.d(null);
                }
                if (!z10 || !isEmpty) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    bVar.onComplete();
                    return;
                }
            }
            aVar.clear();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
            h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void k(int r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                java.lang.Object[] r0 = r2.latest     // Catch:{ all -> 0x001c }
                r3 = r0[r3]     // Catch:{ all -> 0x001c }
                r1 = 1
                if (r3 == 0) goto L_0x0015
                int r3 = r2.completedSources     // Catch:{ all -> 0x001c }
                int r3 = r3 + r1
                int r0 = r0.length     // Catch:{ all -> 0x001c }
                if (r3 != r0) goto L_0x0011
                r2.done = r1     // Catch:{ all -> 0x001c }
                goto L_0x0017
            L_0x0011:
                r2.completedSources = r3     // Catch:{ all -> 0x001c }
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                return
            L_0x0015:
                r2.done = r1     // Catch:{ all -> 0x001c }
            L_0x0017:
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                r2.h()
                return
            L_0x001c:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCombineLatest.CombineLatestCoordinator.k(int):void");
        }

        /* access modifiers changed from: package-private */
        public void l(int i10, Throwable th2) {
            if (!ExceptionHelper.a(this.error, th2)) {
                bk.a.s(th2);
            } else if (!this.delayErrors) {
                c();
                this.done = true;
                h();
            } else {
                k(i10);
            }
        }

        /* access modifiers changed from: package-private */
        public void m(int i10, T t10) {
            boolean z10;
            synchronized (this) {
                Object[] objArr = this.latest;
                int i11 = this.nonEmptySources;
                if (objArr[i10] == null) {
                    i11++;
                    this.nonEmptySources = i11;
                }
                objArr[i10] = t10;
                if (objArr.length == i11) {
                    this.queue.l(this.subscribers[i10], objArr.clone());
                    z10 = false;
                } else {
                    z10 = true;
                }
            }
            if (z10) {
                this.subscribers[i10].b();
            } else {
                h();
            }
        }

        /* access modifiers changed from: package-private */
        public void n(rn.a<? extends T>[] aVarArr, int i10) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.subscribers;
            for (int i11 = 0; i11 < i10 && !this.done && !this.cancelled; i11++) {
                aVarArr[i11].a(combineLatestInnerSubscriberArr[i11]);
            }
        }

        public R poll() throws Exception {
            Object poll = this.queue.poll();
            if (poll == null) {
                return null;
            }
            R e10 = xj.b.e(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).b();
            return e10;
        }

        public void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                h();
            }
        }
    }

    static final class CombineLatestInnerSubscriber<T> extends AtomicReference<c> implements l<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i10, int i11) {
            this.parent = combineLatestCoordinator;
            this.index = i10;
            this.prefetch = i11;
            this.limit = i11 - (i11 >> 2);
        }

        public void a() {
            SubscriptionHelper.a(this);
        }

        public void b() {
            int i10 = this.produced + 1;
            if (i10 == this.limit) {
                this.produced = 0;
                ((c) get()).r((long) i10);
                return;
            }
            this.produced = i10;
        }

        public void d(T t10) {
            this.parent.m(this.index, t10);
        }

        public void e(c cVar) {
            SubscriptionHelper.i(this, cVar, (long) this.prefetch);
        }

        public void onComplete() {
            this.parent.k(this.index);
        }

        public void onError(Throwable th2) {
            this.parent.l(this.index, th2);
        }
    }

    final class a implements j<T, R> {
        a() {
        }

        public R apply(T t10) throws Exception {
            return FlowableCombineLatest.this.f30148d.apply(new Object[]{t10});
        }
    }

    public FlowableCombineLatest(rn.a<? extends T>[] aVarArr, j<? super Object[], ? extends R> jVar, int i10, boolean z10) {
        this.f30146b = aVarArr;
        this.f30148d = jVar;
        this.f30149e = i10;
        this.f30150f = z10;
    }

    public void n0(b<? super R> bVar) {
        int i10;
        rn.a<? extends T>[] aVarArr = this.f30146b;
        if (aVarArr == null) {
            aVarArr = new rn.a[8];
            try {
                Iterator it = (Iterator) xj.b.e(this.f30147c.iterator(), "The iterator returned is null");
                i10 = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            rn.a<? extends T> aVar = (rn.a) xj.b.e(it.next(), "The publisher returned by the iterator is null");
                            if (i10 == aVarArr.length) {
                                rn.a<? extends T>[] aVarArr2 = new rn.a[((i10 >> 2) + i10)];
                                System.arraycopy(aVarArr, 0, aVarArr2, 0, i10);
                                aVarArr = aVarArr2;
                            }
                            aVarArr[i10] = aVar;
                            i10++;
                        } catch (Throwable th2) {
                            uj.a.b(th2);
                            EmptySubscription.c(th2, bVar);
                            return;
                        }
                    } catch (Throwable th3) {
                        uj.a.b(th3);
                        EmptySubscription.c(th3, bVar);
                        return;
                    }
                }
            } catch (Throwable th4) {
                uj.a.b(th4);
                EmptySubscription.c(th4, bVar);
                return;
            }
        } else {
            i10 = aVarArr.length;
        }
        int i11 = i10;
        if (i11 == 0) {
            EmptySubscription.a(bVar);
        } else if (i11 == 1) {
            aVarArr[0].a(new o.b(bVar, new a()));
        } else {
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(bVar, this.f30148d, i11, this.f30149e, this.f30150f);
            bVar.e(combineLatestCoordinator);
            combineLatestCoordinator.n(aVarArr, i11);
        }
    }
}
