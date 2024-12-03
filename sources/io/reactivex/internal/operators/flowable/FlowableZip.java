package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.h;
import qj.l;
import rn.a;
import rn.b;
import rn.c;
import vj.j;
import yj.f;
import yj.i;

public final class FlowableZip<T, R> extends h<R> {

    /* renamed from: b  reason: collision with root package name */
    final a<? extends T>[] f30209b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<? extends a<? extends T>> f30210c;

    /* renamed from: d  reason: collision with root package name */
    final j<? super Object[], ? extends R> f30211d;

    /* renamed from: e  reason: collision with root package name */
    final int f30212e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f30213f;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements c {
        private static final long serialVersionUID = -2434867452883857743L;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final b<? super R> downstream;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final j<? super Object[], ? extends R> zipper;

        ZipCoordinator(b<? super R> bVar, j<? super Object[], ? extends R> jVar, int i10, int i11, boolean z10) {
            this.downstream = bVar;
            this.zipper = jVar;
            this.delayErrors = z10;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                zipSubscriberArr[i12] = new ZipSubscriber<>(this, i11);
            }
            this.current = new Object[i10];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            for (ZipSubscriber<T, R> cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int i10;
            T t10;
            boolean z10;
            T t11;
            boolean z11;
            if (getAndIncrement() == 0) {
                b<? super R> bVar = this.downstream;
                ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
                int length = zipSubscriberArr.length;
                Object[] objArr = this.current;
                int i11 = 1;
                do {
                    long j10 = this.requested.get();
                    long j11 = 0;
                    while (true) {
                        i10 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
                        if (i10 == 0) {
                            break;
                        } else if (!this.cancelled) {
                            if (this.delayErrors || this.errors.get() == null) {
                                boolean z12 = false;
                                for (int i12 = 0; i12 < length; i12++) {
                                    ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i12];
                                    if (objArr[i12] == null) {
                                        try {
                                            boolean z13 = zipSubscriber.done;
                                            i<T> iVar = zipSubscriber.queue;
                                            if (iVar != null) {
                                                t11 = iVar.poll();
                                            } else {
                                                t11 = null;
                                            }
                                            if (t11 == null) {
                                                z11 = true;
                                            } else {
                                                z11 = false;
                                            }
                                            if (!z13 || !z11) {
                                                if (!z11) {
                                                    objArr[i12] = t11;
                                                }
                                                z12 = true;
                                            } else {
                                                a();
                                                if (((Throwable) this.errors.get()) != null) {
                                                    bVar.onError(this.errors.b());
                                                    return;
                                                } else {
                                                    bVar.onComplete();
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            uj.a.b(th2);
                                            this.errors.a(th2);
                                            if (!this.delayErrors) {
                                                a();
                                                bVar.onError(this.errors.b());
                                                return;
                                            }
                                        }
                                    }
                                }
                                if (z12) {
                                    break;
                                }
                                try {
                                    bVar.d(xj.b.e(this.zipper.apply(objArr.clone()), "The zipper returned a null value"));
                                    j11++;
                                    Arrays.fill(objArr, (Object) null);
                                } catch (Throwable th3) {
                                    uj.a.b(th3);
                                    a();
                                    this.errors.a(th3);
                                    bVar.onError(this.errors.b());
                                    return;
                                }
                            } else {
                                a();
                                bVar.onError(this.errors.b());
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (i10 == 0) {
                        if (!this.cancelled) {
                            if (this.delayErrors || this.errors.get() == null) {
                                for (int i13 = 0; i13 < length; i13++) {
                                    ZipSubscriber<T, R> zipSubscriber2 = zipSubscriberArr[i13];
                                    if (objArr[i13] == null) {
                                        try {
                                            boolean z14 = zipSubscriber2.done;
                                            i<T> iVar2 = zipSubscriber2.queue;
                                            if (iVar2 != null) {
                                                t10 = iVar2.poll();
                                            } else {
                                                t10 = null;
                                            }
                                            if (t10 == null) {
                                                z10 = true;
                                            } else {
                                                z10 = false;
                                            }
                                            if (z14 && z10) {
                                                a();
                                                if (((Throwable) this.errors.get()) != null) {
                                                    bVar.onError(this.errors.b());
                                                    return;
                                                } else {
                                                    bVar.onComplete();
                                                    return;
                                                }
                                            } else if (!z10) {
                                                objArr[i13] = t10;
                                            }
                                        } catch (Throwable th4) {
                                            uj.a.b(th4);
                                            this.errors.a(th4);
                                            if (!this.delayErrors) {
                                                a();
                                                bVar.onError(this.errors.b());
                                                return;
                                            }
                                        }
                                    }
                                }
                            } else {
                                a();
                                bVar.onError(this.errors.b());
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (j11 != 0) {
                        for (ZipSubscriber<T, R> r10 : zipSubscriberArr) {
                            r10.r(j11);
                        }
                        if (j10 != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j11);
                        }
                    }
                    i11 = addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(ZipSubscriber<T, R> zipSubscriber, Throwable th2) {
            if (this.errors.a(th2)) {
                zipSubscriber.done = true;
                b();
                return;
            }
            bk.a.s(th2);
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(a<? extends T>[] aVarArr, int i10) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            int i11 = 0;
            while (i11 < i10 && !this.cancelled) {
                if (this.delayErrors || this.errors.get() == null) {
                    aVarArr[i11].a(zipSubscriberArr[i11]);
                    i11++;
                } else {
                    return;
                }
            }
        }

        public void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }
    }

    static final class ZipSubscriber<T, R> extends AtomicReference<c> implements l<T>, c {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        i<T> queue;
        int sourceMode;

        ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i10) {
            this.parent = zipCoordinator;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.a(this);
        }

        public void d(T t10) {
            if (this.sourceMode != 2) {
                this.queue.offer(t10);
            }
            this.parent.b();
        }

        public void e(c cVar) {
            if (SubscriptionHelper.h(this, cVar)) {
                if (cVar instanceof f) {
                    f fVar = (f) cVar;
                    int b10 = fVar.b(7);
                    if (b10 == 1) {
                        this.sourceMode = b10;
                        this.queue = fVar;
                        this.done = true;
                        this.parent.b();
                        return;
                    } else if (b10 == 2) {
                        this.sourceMode = b10;
                        this.queue = fVar;
                        cVar.r((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                cVar.r((long) this.prefetch);
            }
        }

        public void onComplete() {
            this.done = true;
            this.parent.b();
        }

        public void onError(Throwable th2) {
            this.parent.c(this, th2);
        }

        public void r(long j10) {
            if (this.sourceMode != 1) {
                long j11 = this.produced + j10;
                if (j11 >= ((long) this.limit)) {
                    this.produced = 0;
                    ((c) get()).r(j11);
                    return;
                }
                this.produced = j11;
            }
        }
    }

    public FlowableZip(a<? extends T>[] aVarArr, Iterable<? extends a<? extends T>> iterable, j<? super Object[], ? extends R> jVar, int i10, boolean z10) {
        this.f30209b = aVarArr;
        this.f30210c = iterable;
        this.f30211d = jVar;
        this.f30212e = i10;
        this.f30213f = z10;
    }

    public void n0(b<? super R> bVar) {
        int i10;
        a<? extends T>[] aVarArr = this.f30209b;
        if (aVarArr == null) {
            aVarArr = new a[8];
            i10 = 0;
            for (a<? extends T> aVar : this.f30210c) {
                if (i10 == aVarArr.length) {
                    a<? extends T>[] aVarArr2 = new a[((i10 >> 2) + i10)];
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, i10);
                    aVarArr = aVarArr2;
                }
                aVarArr[i10] = aVar;
                i10++;
            }
        } else {
            i10 = aVarArr.length;
        }
        int i11 = i10;
        if (i11 == 0) {
            EmptySubscription.a(bVar);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(bVar, this.f30211d, i11, this.f30212e, this.f30213f);
        bVar.e(zipCoordinator);
        zipCoordinator.d(aVarArr, i11);
    }
}
