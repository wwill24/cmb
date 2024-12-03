package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.h;
import qj.j;
import qj.k;
import rn.b;
import rn.c;

public final class FlowableCreate<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    final k<T> f30154b;

    /* renamed from: c  reason: collision with root package name */
    final BackpressureStrategy f30155c;

    static abstract class BaseEmitter<T> extends AtomicLong implements j<T>, c {
        private static final long serialVersionUID = 7326289992464377023L;
        final b<? super T> downstream;
        final SequentialDisposable serial = new SequentialDisposable();

        BaseEmitter(b<? super T> bVar) {
            this.downstream = bVar;
        }

        public final void a(tj.b bVar) {
            this.serial.b(bVar);
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (!isCancelled()) {
                try {
                    this.downstream.onComplete();
                } finally {
                    this.serial.dispose();
                }
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        public boolean c(Throwable th2) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.downstream.onError(th2);
                this.serial.dispose();
                return true;
            } catch (Throwable th3) {
                this.serial.dispose();
                throw th3;
            }
        }

        public final void cancel() {
            this.serial.dispose();
            g();
        }

        public final void e(Throwable th2) {
            if (!h(th2)) {
                bk.a.s(th2);
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
        }

        /* access modifiers changed from: package-private */
        public void g() {
        }

        public boolean h(Throwable th2) {
            return c(th2);
        }

        public final boolean isCancelled() {
            return this.serial.c();
        }

        public final void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(this, j10);
                f();
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicInteger wip = new AtomicInteger();

        BufferAsyncEmitter(b<? super T> bVar, int i10) {
            super(bVar);
            this.queue = new io.reactivex.internal.queue.a<>(i10);
        }

        public void d(T t10) {
            if (!this.done && !isCancelled()) {
                if (t10 == null) {
                    e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.queue.offer(t10);
                i();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            i();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public boolean h(Throwable th2) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th2;
            this.done = true;
            i();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int i10;
            boolean z10;
            if (this.wip.getAndIncrement() == 0) {
                b<? super T> bVar = this.downstream;
                io.reactivex.internal.queue.a<T> aVar = this.queue;
                int i11 = 1;
                do {
                    long j10 = get();
                    long j11 = 0;
                    while (true) {
                        i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                        if (i10 == 0) {
                            break;
                        } else if (isCancelled()) {
                            aVar.clear();
                            return;
                        } else {
                            boolean z11 = this.done;
                            T poll = aVar.poll();
                            if (poll == null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z11 && z10) {
                                Throwable th2 = this.error;
                                if (th2 != null) {
                                    c(th2);
                                    return;
                                } else {
                                    b();
                                    return;
                                }
                            } else if (z10) {
                                break;
                            } else {
                                bVar.d(poll);
                                j11++;
                            }
                        }
                    }
                    if (i10 == 0) {
                        if (isCancelled()) {
                            aVar.clear();
                            return;
                        }
                        boolean z12 = this.done;
                        boolean isEmpty = aVar.isEmpty();
                        if (z12 && isEmpty) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                c(th3);
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                    }
                    if (j11 != 0) {
                        io.reactivex.internal.util.b.c(this, j11);
                    }
                    i11 = this.wip.addAndGet(-i11);
                } while (i11 != 0);
            }
        }
    }

    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        DropAsyncEmitter(b<? super T> bVar) {
            super(bVar);
        }

        /* access modifiers changed from: package-private */
        public void i() {
        }
    }

    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(b<? super T> bVar) {
            super(bVar);
        }

        /* access modifiers changed from: package-private */
        public void i() {
            e(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();

        LatestAsyncEmitter(b<? super T> bVar) {
            super(bVar);
        }

        public void d(T t10) {
            if (!this.done && !isCancelled()) {
                if (t10 == null) {
                    e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.queue.set(t10);
                i();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            i();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet((Object) null);
            }
        }

        public boolean h(Throwable th2) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th2 == null) {
                e(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th2;
            this.done = true;
            i();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int i10;
            boolean z10;
            boolean z11;
            if (this.wip.getAndIncrement() == 0) {
                b<? super T> bVar = this.downstream;
                AtomicReference<T> atomicReference = this.queue;
                int i11 = 1;
                do {
                    long j10 = get();
                    long j11 = 0;
                    while (true) {
                        i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                        z10 = false;
                        if (i10 == 0) {
                            break;
                        } else if (isCancelled()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        } else {
                            boolean z12 = this.done;
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (andSet == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                Throwable th2 = this.error;
                                if (th2 != null) {
                                    c(th2);
                                    return;
                                } else {
                                    b();
                                    return;
                                }
                            } else if (z11) {
                                break;
                            } else {
                                bVar.d(andSet);
                                j11++;
                            }
                        }
                    }
                    if (i10 == 0) {
                        if (isCancelled()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        }
                        boolean z13 = this.done;
                        if (atomicReference.get() == null) {
                            z10 = true;
                        }
                        if (z13 && z10) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                c(th3);
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                    }
                    if (j11 != 0) {
                        io.reactivex.internal.util.b.c(this, j11);
                    }
                    i11 = this.wip.addAndGet(-i11);
                } while (i11 != 0);
            }
        }
    }

    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(b<? super T> bVar) {
            super(bVar);
        }

        public void d(T t10) {
            long j10;
            if (!isCancelled()) {
                if (t10 != null) {
                    this.downstream.d(t10);
                    do {
                        j10 = get();
                        if (j10 == 0 || compareAndSet(j10, j10 - 1)) {
                            return;
                        }
                        j10 = get();
                        return;
                    } while (compareAndSet(j10, j10 - 1));
                    return;
                }
                e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        NoOverflowBaseAsyncEmitter(b<? super T> bVar) {
            super(bVar);
        }

        public final void d(T t10) {
            if (!isCancelled()) {
                if (t10 == null) {
                    e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else if (get() != 0) {
                    this.downstream.d(t10);
                    io.reactivex.internal.util.b.c(this, 1);
                } else {
                    i();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void i();
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30156a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.BackpressureStrategy[] r0 = io.reactivex.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30156a = r0
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30156a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30156a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f30156a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.a.<clinit>():void");
        }
    }

    public FlowableCreate(k<T> kVar, BackpressureStrategy backpressureStrategy) {
        this.f30154b = kVar;
        this.f30155c = backpressureStrategy;
    }

    public void n0(b<? super T> bVar) {
        BaseEmitter baseEmitter;
        int i10 = a.f30156a[this.f30155c.ordinal()];
        if (i10 == 1) {
            baseEmitter = new MissingEmitter(bVar);
        } else if (i10 == 2) {
            baseEmitter = new ErrorAsyncEmitter(bVar);
        } else if (i10 == 3) {
            baseEmitter = new DropAsyncEmitter(bVar);
        } else if (i10 != 4) {
            baseEmitter = new BufferAsyncEmitter(bVar, h.j());
        } else {
            baseEmitter = new LatestAsyncEmitter(bVar);
        }
        bVar.e(baseEmitter);
        try {
            this.f30154b.a(baseEmitter);
        } catch (Throwable th2) {
            uj.a.b(th2);
            baseEmitter.e(th2);
        }
    }
}
