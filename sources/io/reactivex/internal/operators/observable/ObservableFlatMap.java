package io.reactivex.internal.operators.observable;

import bk.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.s;
import qj.u;
import tj.b;
import vj.j;
import yj.d;
import yj.h;
import yj.i;

public final class ObservableFlatMap<T, U> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final j<? super T, ? extends s<? extends U>> f30335b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f30336c;

    /* renamed from: d  reason: collision with root package name */
    final int f30337d;

    /* renamed from: e  reason: collision with root package name */
    final int f30338e;

    static final class InnerObserver<T, U> extends AtomicReference<b> implements u<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;

        /* renamed from: id  reason: collision with root package name */
        final long f30339id;
        final MergeObserver<T, U> parent;
        volatile i<U> queue;

        InnerObserver(MergeObserver<T, U> mergeObserver, long j10) {
            this.f30339id = j10;
            this.parent = mergeObserver;
        }

        public void a(b bVar) {
            if (DisposableHelper.i(this, bVar) && (bVar instanceof d)) {
                d dVar = (d) bVar;
                int b10 = dVar.b(7);
                if (b10 == 1) {
                    this.fusionMode = b10;
                    this.queue = dVar;
                    this.done = true;
                    this.parent.g();
                } else if (b10 == 2) {
                    this.fusionMode = b10;
                    this.queue = dVar;
                }
            }
        }

        public void b() {
            DisposableHelper.a(this);
        }

        public void d(U u10) {
            if (this.fusionMode == 0) {
                this.parent.l(u10, this);
            } else {
                this.parent.g();
            }
        }

        public void onComplete() {
            this.done = true;
            this.parent.g();
        }

        public void onError(Throwable th2) {
            if (this.parent.errors.a(th2)) {
                MergeObserver<T, U> mergeObserver = this.parent;
                if (!mergeObserver.delayErrors) {
                    mergeObserver.f();
                }
                this.done = true;
                this.parent.g();
                return;
            }
            a.s(th2);
        }
    }

    static final class MergeObserver<T, U> extends AtomicInteger implements b, u<T> {

        /* renamed from: a  reason: collision with root package name */
        static final InnerObserver<?, ?>[] f30340a = new InnerObserver[0];

        /* renamed from: b  reason: collision with root package name */
        static final InnerObserver<?, ?>[] f30341b = new InnerObserver[0];
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final u<? super U> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final j<? super T, ? extends s<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile h<U> queue;
        Queue<s<? extends U>> sources;
        long uniqueId;
        b upstream;
        int wip;

        MergeObserver(u<? super U> uVar, j<? super T, ? extends s<? extends U>> jVar, boolean z10, int i10, int i11) {
            this.downstream = uVar;
            this.mapper = jVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
            this.bufferSize = i11;
            if (i10 != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i10);
            }
            this.observers = new AtomicReference<>(f30340a);
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a(this);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.observers.get();
                if (innerObserverArr == f30341b) {
                    innerObserver.b();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[(length + 1)];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!androidx.camera.view.h.a(this.observers, innerObserverArr, innerObserverArr2));
            return true;
        }

        public boolean c() {
            return this.cancelled;
        }

        public void d(T t10) {
            if (!this.done) {
                try {
                    s sVar = (s) xj.b.e(this.mapper.apply(t10), "The mapper returned a null ObservableSource");
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            int i10 = this.wip;
                            if (i10 == this.maxConcurrency) {
                                this.sources.offer(sVar);
                                return;
                            }
                            this.wip = i10 + 1;
                        }
                    }
                    j(sVar);
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    this.upstream.dispose();
                    onError(th2);
                }
            }
        }

        public void dispose() {
            Throwable b10;
            if (!this.cancelled) {
                this.cancelled = true;
                if (f() && (b10 = this.errors.b()) != null && b10 != ExceptionHelper.f30712a) {
                    a.s(b10);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            if (this.cancelled) {
                return true;
            }
            Throwable th2 = (Throwable) this.errors.get();
            if (this.delayErrors || th2 == null) {
                return false;
            }
            f();
            Throwable b10 = this.errors.b();
            if (b10 != ExceptionHelper.f30712a) {
                this.downstream.onError(b10);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            InnerObserver<?, ?>[] innerObserverArr;
            this.upstream.dispose();
            InnerObserver<?, ?>[] innerObserverArr2 = (InnerObserver[]) this.observers.get();
            InnerObserver<?, ?>[] innerObserverArr3 = f30341b;
            if (innerObserverArr2 == innerObserverArr3 || (innerObserverArr = (InnerObserver[]) this.observers.getAndSet(innerObserverArr3)) == innerObserverArr3) {
                return false;
            }
            for (InnerObserver<?, ?> b10 : innerObserverArr) {
                b10.b();
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            if (getAndIncrement() == 0) {
                h();
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int i10;
            int i11;
            u<? super U> uVar = this.downstream;
            int i12 = 1;
            while (!e()) {
                h<U> hVar = this.queue;
                int i13 = 0;
                if (hVar != null) {
                    while (!e()) {
                        U poll = hVar.poll();
                        if (poll != null) {
                            uVar.d(poll);
                            i13++;
                        }
                    }
                    return;
                }
                if (i13 == 0) {
                    boolean z10 = this.done;
                    h<U> hVar2 = this.queue;
                    InnerObserver[] innerObserverArr = (InnerObserver[]) this.observers.get();
                    int length = innerObserverArr.length;
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i10 = this.sources.size();
                        }
                    } else {
                        i10 = 0;
                    }
                    if (!z10 || !((hVar2 == null || hVar2.isEmpty()) && length == 0 && i10 == 0)) {
                        if (length != 0) {
                            long j10 = this.lastId;
                            int i14 = this.lastIndex;
                            if (length <= i14 || innerObserverArr[i14].f30339id != j10) {
                                if (length <= i14) {
                                    i14 = 0;
                                }
                                for (int i15 = 0; i15 < length && innerObserverArr[i14].f30339id != j10; i15++) {
                                    i14++;
                                    if (i14 == length) {
                                        i14 = 0;
                                    }
                                }
                                this.lastIndex = i14;
                                this.lastId = innerObserverArr[i14].f30339id;
                            }
                            int i16 = 0;
                            while (i16 < length) {
                                if (!e()) {
                                    InnerObserver innerObserver = innerObserverArr[i14];
                                    i<U> iVar = innerObserver.queue;
                                    if (iVar != null) {
                                        while (true) {
                                            try {
                                                U poll2 = iVar.poll();
                                                if (poll2 == null) {
                                                    break;
                                                }
                                                uVar.d(poll2);
                                                if (e()) {
                                                    return;
                                                }
                                            } catch (Throwable th2) {
                                                uj.a.b(th2);
                                                innerObserver.b();
                                                this.errors.a(th2);
                                                if (!e()) {
                                                    i(innerObserver);
                                                    i13++;
                                                    i11 = i14 + 1;
                                                    if (i11 != length) {
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                    boolean z11 = innerObserver.done;
                                    i<U> iVar2 = innerObserver.queue;
                                    if (z11 && (iVar2 == null || iVar2.isEmpty())) {
                                        i(innerObserver);
                                        if (!e()) {
                                            i13++;
                                        } else {
                                            return;
                                        }
                                    }
                                    i11 = i14 + 1;
                                    if (i11 != length) {
                                        i16++;
                                    }
                                    i11 = 0;
                                    i16++;
                                } else {
                                    return;
                                }
                            }
                            this.lastIndex = i14;
                            this.lastId = innerObserverArr[i14].f30339id;
                        }
                        if (i13 == 0) {
                            i12 = addAndGet(-i12);
                            if (i12 == 0) {
                                return;
                            }
                        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                            k(i13);
                        }
                    } else {
                        Throwable b10 = this.errors.b();
                        if (b10 == ExceptionHelper.f30712a) {
                            return;
                        }
                        if (b10 == null) {
                            uVar.onComplete();
                            return;
                        } else {
                            uVar.onError(b10);
                            return;
                        }
                    }
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    k(i13);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i(InnerObserver<T, U> innerObserver) {
            InnerObserver<T, U>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.observers.get();
                int length = innerObserverArr.length;
                if (length != 0) {
                    int i10 = -1;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        } else if (innerObserverArr[i11] == innerObserver) {
                            i10 = i11;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i10 >= 0) {
                        if (length == 1) {
                            innerObserverArr2 = f30340a;
                        } else {
                            InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[(length - 1)];
                            System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i10);
                            System.arraycopy(innerObserverArr, i10 + 1, innerObserverArr3, i10, (length - i10) - 1);
                            innerObserverArr2 = innerObserverArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!androidx.camera.view.h.a(this.observers, innerObserverArr, innerObserverArr2));
        }

        /* access modifiers changed from: package-private */
        public void j(s<? extends U> sVar) {
            s<? extends U> poll;
            while (sVar instanceof Callable) {
                if (m((Callable) sVar) && this.maxConcurrency != Integer.MAX_VALUE) {
                    boolean z10 = false;
                    synchronized (this) {
                        poll = this.sources.poll();
                        if (poll == null) {
                            this.wip--;
                            z10 = true;
                        }
                    }
                    if (z10) {
                        g();
                        return;
                    }
                    sVar = poll;
                } else {
                    return;
                }
            }
            long j10 = this.uniqueId;
            this.uniqueId = 1 + j10;
            InnerObserver innerObserver = new InnerObserver(this, j10);
            if (b(innerObserver)) {
                sVar.e(innerObserver);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(int i10) {
            while (true) {
                int i11 = i10 - 1;
                if (i10 != 0) {
                    synchronized (this) {
                        s poll = this.sources.poll();
                        if (poll == null) {
                            this.wip--;
                        } else {
                            j(poll);
                        }
                    }
                    i10 = i11;
                } else {
                    return;
                }
            }
            while (true) {
            }
        }

        /* access modifiers changed from: package-private */
        public void l(U u10, InnerObserver<T, U> innerObserver) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                i iVar = innerObserver.queue;
                if (iVar == null) {
                    iVar = new io.reactivex.internal.queue.a(this.bufferSize);
                    innerObserver.queue = iVar;
                }
                iVar.offer(u10);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.downstream.d(u10);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            h();
        }

        /* access modifiers changed from: package-private */
        public boolean m(Callable<? extends U> callable) {
            try {
                Object call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    h<U> hVar = this.queue;
                    if (hVar == null) {
                        if (this.maxConcurrency == Integer.MAX_VALUE) {
                            hVar = new io.reactivex.internal.queue.a<>(this.bufferSize);
                        } else {
                            hVar = new SpscArrayQueue<>(this.maxConcurrency);
                        }
                        this.queue = hVar;
                    }
                    if (!hVar.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.downstream.d(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                h();
                return true;
            } catch (Throwable th2) {
                uj.a.b(th2);
                this.errors.a(th2);
                g();
                return true;
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                g();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                a.s(th2);
            } else if (this.errors.a(th2)) {
                this.done = true;
                g();
            } else {
                a.s(th2);
            }
        }
    }

    public ObservableFlatMap(s<T> sVar, j<? super T, ? extends s<? extends U>> jVar, boolean z10, int i10, int i11) {
        super(sVar);
        this.f30335b = jVar;
        this.f30336c = z10;
        this.f30337d = i10;
        this.f30338e = i11;
    }

    public void l0(u<? super U> uVar) {
        if (!ObservableScalarXMap.b(this.f30395a, uVar, this.f30335b)) {
            this.f30395a.e(new MergeObserver(uVar, this.f30335b, this.f30336c, this.f30337d, this.f30338e));
        }
    }
}
