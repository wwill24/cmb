package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.l;
import rn.a;
import rn.c;
import tj.b;
import vj.j;
import yj.f;
import yj.h;
import yj.i;

public final class FlowableFlatMap<T, U> extends a<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final j<? super T, ? extends a<? extends U>> f30160c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30161d;

    /* renamed from: e  reason: collision with root package name */
    final int f30162e;

    /* renamed from: f  reason: collision with root package name */
    final int f30163f;

    static final class InnerSubscriber<T, U> extends AtomicReference<c> implements l<U>, b {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;

        /* renamed from: id  reason: collision with root package name */
        final long f30164id;
        final int limit;
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile i<U> queue;

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j10) {
            this.f30164id = j10;
            this.parent = mergeSubscriber;
            int i10 = mergeSubscriber.bufferSize;
            this.bufferSize = i10;
            this.limit = i10 >> 2;
        }

        /* access modifiers changed from: package-private */
        public void a(long j10) {
            if (this.fusionMode != 1) {
                long j11 = this.produced + j10;
                if (j11 >= ((long) this.limit)) {
                    this.produced = 0;
                    ((c) get()).r(j11);
                    return;
                }
                this.produced = j11;
            }
        }

        public boolean c() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void d(U u10) {
            if (this.fusionMode != 2) {
                this.parent.n(u10, this);
            } else {
                this.parent.h();
            }
        }

        public void dispose() {
            SubscriptionHelper.a(this);
        }

        public void e(c cVar) {
            if (SubscriptionHelper.h(this, cVar)) {
                if (cVar instanceof f) {
                    f fVar = (f) cVar;
                    int b10 = fVar.b(7);
                    if (b10 == 1) {
                        this.fusionMode = b10;
                        this.queue = fVar;
                        this.done = true;
                        this.parent.h();
                        return;
                    } else if (b10 == 2) {
                        this.fusionMode = b10;
                        this.queue = fVar;
                    }
                }
                cVar.r((long) this.bufferSize);
            }
        }

        public void onComplete() {
            this.done = true;
            this.parent.h();
        }

        public void onError(Throwable th2) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.l(this, th2);
        }
    }

    static final class MergeSubscriber<T, U> extends AtomicInteger implements l<T>, c {

        /* renamed from: a  reason: collision with root package name */
        static final InnerSubscriber<?, ?>[] f30165a = new InnerSubscriber[0];

        /* renamed from: b  reason: collision with root package name */
        static final InnerSubscriber<?, ?>[] f30166b = new InnerSubscriber[0];
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final rn.b<? super U> downstream;
        final AtomicThrowable errs = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final j<? super T, ? extends a<? extends U>> mapper;
        final int maxConcurrency;
        volatile h<U> queue;
        final AtomicLong requested;
        int scalarEmitted;
        final int scalarLimit;
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers;
        long uniqueId;
        c upstream;

        MergeSubscriber(rn.b<? super U> bVar, j<? super T, ? extends a<? extends U>> jVar, boolean z10, int i10, int i11) {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
            this.subscribers = atomicReference;
            this.requested = new AtomicLong();
            this.downstream = bVar;
            this.mapper = jVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
            this.bufferSize = i11;
            this.scalarLimit = Math.max(1, i10 >> 1);
            atomicReference.lazySet(f30165a);
        }

        /* access modifiers changed from: package-private */
        public boolean a(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                if (innerSubscriberArr == f30166b) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!androidx.camera.view.h.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            if (this.cancelled) {
                c();
                return true;
            } else if (this.delayErrors || this.errs.get() == null) {
                return false;
            } else {
                c();
                Throwable b10 = this.errs.b();
                if (b10 != ExceptionHelper.f30712a) {
                    this.downstream.onError(b10);
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            h<U> hVar = this.queue;
            if (hVar != null) {
                hVar.clear();
            }
        }

        public void cancel() {
            h<U> hVar;
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                g();
                if (getAndIncrement() == 0 && (hVar = this.queue) != null) {
                    hVar.clear();
                }
            }
        }

        public void d(T t10) {
            if (!this.done) {
                try {
                    a aVar = (a) xj.b.e(this.mapper.apply(t10), "The mapper returned a null Publisher");
                    if (aVar instanceof Callable) {
                        try {
                            Object call = ((Callable) aVar).call();
                            if (call != null) {
                                o(call);
                            } else if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                                int i10 = this.scalarEmitted + 1;
                                this.scalarEmitted = i10;
                                int i11 = this.scalarLimit;
                                if (i10 == i11) {
                                    this.scalarEmitted = 0;
                                    this.upstream.r((long) i11);
                                }
                            }
                        } catch (Throwable th2) {
                            uj.a.b(th2);
                            this.errs.a(th2);
                            h();
                        }
                    } else {
                        long j10 = this.uniqueId;
                        this.uniqueId = 1 + j10;
                        InnerSubscriber innerSubscriber = new InnerSubscriber(this, j10);
                        if (a(innerSubscriber)) {
                            aVar.a(innerSubscriber);
                        }
                    }
                } catch (Throwable th3) {
                    uj.a.b(th3);
                    this.upstream.cancel();
                    onError(th3);
                }
            }
        }

        public void e(c cVar) {
            if (SubscriptionHelper.k(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.e(this);
                if (!this.cancelled) {
                    int i10 = this.maxConcurrency;
                    if (i10 == Integer.MAX_VALUE) {
                        cVar.r(Long.MAX_VALUE);
                    } else {
                        cVar.r((long) i10);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = (InnerSubscriber[]) this.subscribers.get();
            InnerSubscriber<?, ?>[] innerSubscriberArr3 = f30166b;
            if (innerSubscriberArr2 != innerSubscriberArr3 && (innerSubscriberArr = (InnerSubscriber[]) this.subscribers.getAndSet(innerSubscriberArr3)) != innerSubscriberArr3) {
                for (InnerSubscriber<?, ?> dispose : innerSubscriberArr) {
                    dispose.dispose();
                }
                Throwable b10 = this.errs.b();
                if (b10 != null && b10 != ExceptionHelper.f30712a) {
                    bk.a.s(b10);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            if (getAndIncrement() == 0) {
                i();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            boolean z10;
            long j10;
            boolean z11;
            long j11;
            long j12;
            int i10;
            int i11;
            long j13;
            rn.b<? super U> bVar = this.downstream;
            int i12 = 1;
            while (!b()) {
                h<U> hVar = this.queue;
                long j14 = this.requested.get();
                if (j14 == Long.MAX_VALUE) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                long j15 = 0;
                long j16 = 0;
                if (hVar != null) {
                    while (true) {
                        long j17 = 0;
                        U u10 = null;
                        while (true) {
                            if (j14 == 0) {
                                break;
                            }
                            U poll = hVar.poll();
                            if (!b()) {
                                if (poll == null) {
                                    u10 = poll;
                                    break;
                                }
                                bVar.d(poll);
                                j16++;
                                j17++;
                                j14--;
                                u10 = poll;
                            } else {
                                return;
                            }
                        }
                        if (j17 != 0) {
                            if (z10) {
                                j14 = Long.MAX_VALUE;
                            } else {
                                j14 = this.requested.addAndGet(-j17);
                            }
                        }
                        if (j14 == 0 || u10 == null) {
                            break;
                        }
                    }
                }
                boolean z12 = this.done;
                h<U> hVar2 = this.queue;
                InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (!z12 || ((hVar2 != null && !hVar2.isEmpty()) || length != 0)) {
                    int i13 = i12;
                    if (length != 0) {
                        long j18 = this.lastId;
                        int i14 = this.lastIndex;
                        if (length <= i14 || innerSubscriberArr[i14].f30164id != j18) {
                            if (length <= i14) {
                                i14 = 0;
                            }
                            for (int i15 = 0; i15 < length && innerSubscriberArr[i14].f30164id != j18; i15++) {
                                i14++;
                                if (i14 == length) {
                                    i14 = 0;
                                }
                            }
                            this.lastIndex = i14;
                            this.lastId = innerSubscriberArr[i14].f30164id;
                        }
                        int i16 = i14;
                        boolean z13 = false;
                        int i17 = 0;
                        while (true) {
                            if (i17 >= length) {
                                z11 = z13;
                                break;
                            } else if (!b()) {
                                InnerSubscriber innerSubscriber = innerSubscriberArr[i16];
                                U u11 = null;
                                while (!b()) {
                                    i<U> iVar = innerSubscriber.queue;
                                    if (iVar == null) {
                                        i10 = length;
                                    } else {
                                        i10 = length;
                                        U u12 = u11;
                                        long j19 = j15;
                                        while (true) {
                                            if (j10 == j15) {
                                                break;
                                            }
                                            try {
                                                U poll2 = iVar.poll();
                                                if (poll2 == null) {
                                                    u12 = poll2;
                                                    j15 = 0;
                                                    break;
                                                }
                                                bVar.d(poll2);
                                                if (!b()) {
                                                    j10--;
                                                    j19++;
                                                    u12 = poll2;
                                                    j15 = 0;
                                                } else {
                                                    return;
                                                }
                                            } catch (Throwable th2) {
                                                Throwable th3 = th2;
                                                uj.a.b(th3);
                                                innerSubscriber.dispose();
                                                this.errs.a(th3);
                                                if (!this.delayErrors) {
                                                    this.upstream.cancel();
                                                }
                                                if (!b()) {
                                                    m(innerSubscriber);
                                                    i17++;
                                                    z13 = true;
                                                    i11 = 1;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        if (j19 != j15) {
                                            if (!z10) {
                                                j10 = this.requested.addAndGet(-j19);
                                            } else {
                                                j10 = Long.MAX_VALUE;
                                            }
                                            innerSubscriber.a(j19);
                                            j13 = 0;
                                        } else {
                                            j13 = j15;
                                        }
                                        if (!(j10 == j13 || u12 == null)) {
                                            length = i10;
                                            u11 = u12;
                                            j15 = 0;
                                        }
                                    }
                                    boolean z14 = innerSubscriber.done;
                                    i<U> iVar2 = innerSubscriber.queue;
                                    if (z14 && (iVar2 == null || iVar2.isEmpty())) {
                                        m(innerSubscriber);
                                        if (!b()) {
                                            j16++;
                                            z13 = true;
                                        } else {
                                            return;
                                        }
                                    }
                                    if (j10 == 0) {
                                        z11 = z13;
                                        break;
                                    }
                                    i16++;
                                    if (i16 == i10) {
                                        i16 = 0;
                                    }
                                    i11 = 1;
                                    i17 += i11;
                                    length = i10;
                                    j15 = 0;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                        this.lastIndex = i16;
                        this.lastId = innerSubscriberArr[i16].f30164id;
                        j12 = j16;
                        j11 = 0;
                    } else {
                        j11 = 0;
                        j12 = j16;
                        z11 = false;
                    }
                    if (j12 != j11 && !this.cancelled) {
                        this.upstream.r(j12);
                    }
                    if (z11) {
                        i12 = i13;
                    } else {
                        i12 = addAndGet(-i13);
                        if (i12 == 0) {
                            return;
                        }
                    }
                } else {
                    Throwable b10 = this.errs.b();
                    if (b10 == ExceptionHelper.f30712a) {
                        return;
                    }
                    if (b10 == null) {
                        bVar.onComplete();
                        return;
                    } else {
                        bVar.onError(b10);
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public i<U> j(InnerSubscriber<T, U> innerSubscriber) {
            i<U> iVar = innerSubscriber.queue;
            if (iVar != null) {
                return iVar;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
            innerSubscriber.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        /* access modifiers changed from: package-private */
        public i<U> k() {
            h<U> hVar = this.queue;
            if (hVar == null) {
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    hVar = new io.reactivex.internal.queue.a<>(this.bufferSize);
                } else {
                    hVar = new SpscArrayQueue<>(this.maxConcurrency);
                }
                this.queue = hVar;
            }
            return hVar;
        }

        /* access modifiers changed from: package-private */
        public void l(InnerSubscriber<T, U> innerSubscriber, Throwable th2) {
            if (this.errs.a(th2)) {
                innerSubscriber.done = true;
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    for (InnerSubscriber dispose : (InnerSubscriber[]) this.subscribers.getAndSet(f30166b)) {
                        dispose.dispose();
                    }
                }
                h();
                return;
            }
            bk.a.s(th2);
        }

        /* access modifiers changed from: package-private */
        public void m(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<T, U>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length != 0) {
                    int i10 = -1;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        } else if (innerSubscriberArr[i11] == innerSubscriber) {
                            i10 = i11;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i10 >= 0) {
                        if (length == 1) {
                            innerSubscriberArr2 = f30165a;
                        } else {
                            InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[(length - 1)];
                            System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i10);
                            System.arraycopy(innerSubscriberArr, i10 + 1, innerSubscriberArr3, i10, (length - i10) - 1);
                            innerSubscriberArr2 = innerSubscriberArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!androidx.camera.view.h.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }

        /* access modifiers changed from: package-private */
        public void n(U u10, InnerSubscriber<T, U> innerSubscriber) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                i iVar = innerSubscriber.queue;
                if (iVar == null) {
                    iVar = new SpscArrayQueue(this.bufferSize);
                    innerSubscriber.queue = iVar;
                }
                if (!iVar.offer(u10)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                long j10 = this.requested.get();
                i<U> iVar2 = innerSubscriber.queue;
                if (j10 == 0 || (iVar2 != null && !iVar2.isEmpty())) {
                    if (iVar2 == null) {
                        iVar2 = j(innerSubscriber);
                    }
                    if (!iVar2.offer(u10)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.downstream.d(u10);
                    if (j10 != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    innerSubscriber.a(1);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            i();
        }

        /* access modifiers changed from: package-private */
        public void o(U u10) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j10 = this.requested.get();
                i iVar = this.queue;
                if (j10 == 0 || (iVar != null && !iVar.isEmpty())) {
                    if (iVar == null) {
                        iVar = k();
                    }
                    if (!iVar.offer(u10)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.downstream.d(u10);
                    if (j10 != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i10 = this.scalarEmitted + 1;
                        this.scalarEmitted = i10;
                        int i11 = this.scalarLimit;
                        if (i10 == i11) {
                            this.scalarEmitted = 0;
                            this.upstream.r((long) i11);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!k().offer(u10)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            i();
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
            } else if (this.errs.a(th2)) {
                this.done = true;
                if (!this.delayErrors) {
                    for (InnerSubscriber dispose : (InnerSubscriber[]) this.subscribers.getAndSet(f30166b)) {
                        dispose.dispose();
                    }
                }
                h();
            } else {
                bk.a.s(th2);
            }
        }

        public void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                h();
            }
        }
    }

    public FlowableFlatMap(qj.h<T> hVar, j<? super T, ? extends a<? extends U>> jVar, boolean z10, int i10, int i11) {
        super(hVar);
        this.f30160c = jVar;
        this.f30161d = z10;
        this.f30162e = i10;
        this.f30163f = i11;
    }

    public static <T, U> l<T> A0(rn.b<? super U> bVar, j<? super T, ? extends a<? extends U>> jVar, boolean z10, int i10, int i11) {
        return new MergeSubscriber(bVar, jVar, z10, i10, i11);
    }

    /* access modifiers changed from: protected */
    public void n0(rn.b<? super U> bVar) {
        if (!p.b(this.f30214b, bVar, this.f30160c)) {
            this.f30214b.m0(A0(bVar, this.f30160c, this.f30161d, this.f30162e, this.f30163f));
        }
    }
}
