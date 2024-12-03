package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import qj.q;
import qj.u;
import qj.v;
import tj.b;
import vj.f;
import wj.c;
import zj.a;

public final class ObservableRefCount<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final a<T> f30361a;

    /* renamed from: b  reason: collision with root package name */
    final int f30362b;

    /* renamed from: c  reason: collision with root package name */
    final long f30363c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f30364d;

    /* renamed from: e  reason: collision with root package name */
    final v f30365e;

    /* renamed from: f  reason: collision with root package name */
    RefConnection f30366f;

    static final class RefConnection extends AtomicReference<b> implements Runnable, f<b> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        b timer;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        /* renamed from: a */
        public void accept(b bVar) throws Exception {
            DisposableHelper.d(this, bVar);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((c) this.parent.f30361a).f(bVar);
                }
            }
        }

        public void run() {
            this.parent.E0(this);
        }
    }

    static final class RefCountObserver<T> extends AtomicBoolean implements u<T>, b {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final u<? super T> downstream;
        final ObservableRefCount<T> parent;
        b upstream;

        RefCountObserver(u<? super T> uVar, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.downstream = uVar;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a(this);
            }
        }

        public boolean c() {
            return this.upstream.c();
        }

        public void d(T t10) {
            this.downstream.d(t10);
        }

        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.A0(this.connection);
            }
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.D0(this.connection);
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (compareAndSet(false, true)) {
                this.parent.D0(this.connection);
                this.downstream.onError(th2);
                return;
            }
            bk.a.s(th2);
        }
    }

    public ObservableRefCount(a<T> aVar) {
        this(aVar, 1, 0, TimeUnit.NANOSECONDS, (v) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A0(io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection r0 = r5.f30366f     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            if (r0 == r6) goto L_0x0008
            goto L_0x003d
        L_0x0008:
            long r0 = r6.subscriberCount     // Catch:{ all -> 0x003f }
            r2 = 1
            long r0 = r0 - r2
            r6.subscriberCount = r0     // Catch:{ all -> 0x003f }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003b
            boolean r0 = r6.connected     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x001a
            goto L_0x003b
        L_0x001a:
            long r0 = r5.f30363c     // Catch:{ all -> 0x003f }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0025
            r5.E0(r6)     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0025:
            io.reactivex.internal.disposables.SequentialDisposable r0 = new io.reactivex.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            r6.timer = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            qj.v r1 = r5.f30365e
            long r2 = r5.f30363c
            java.util.concurrent.TimeUnit r4 = r5.f30364d
            tj.b r6 = r1.d(r6, r2, r4)
            r0.a(r6)
            return
        L_0x003b:
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x003d:
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableRefCount.A0(io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection):void");
    }

    /* access modifiers changed from: package-private */
    public void B0(RefConnection refConnection) {
        b bVar = refConnection.timer;
        if (bVar != null) {
            bVar.dispose();
            refConnection.timer = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void C0(RefConnection refConnection) {
        a<T> aVar = this.f30361a;
        if (aVar instanceof b) {
            ((b) aVar).dispose();
        } else if (aVar instanceof c) {
            ((c) aVar).f((b) refConnection.get());
        }
    }

    /* access modifiers changed from: package-private */
    public void D0(RefConnection refConnection) {
        synchronized (this) {
            if (this.f30361a instanceof w) {
                RefConnection refConnection2 = this.f30366f;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f30366f = null;
                    B0(refConnection);
                }
                long j10 = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j10;
                if (j10 == 0) {
                    C0(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.f30366f;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    B0(refConnection);
                    long j11 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j11;
                    if (j11 == 0) {
                        this.f30366f = null;
                        C0(refConnection);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void E0(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.f30366f) {
                this.f30366f = null;
                b bVar = (b) refConnection.get();
                DisposableHelper.a(refConnection);
                a<T> aVar = this.f30361a;
                if (aVar instanceof b) {
                    ((b) aVar).dispose();
                } else if (aVar instanceof c) {
                    if (bVar == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((c) aVar).f(bVar);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        RefConnection refConnection;
        boolean z10;
        b bVar;
        synchronized (this) {
            refConnection = this.f30366f;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f30366f = refConnection;
            }
            long j10 = refConnection.subscriberCount;
            if (j10 == 0 && (bVar = refConnection.timer) != null) {
                bVar.dispose();
            }
            long j11 = j10 + 1;
            refConnection.subscriberCount = j11;
            z10 = true;
            if (refConnection.connected || j11 != ((long) this.f30362b)) {
                z10 = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.f30361a.e(new RefCountObserver(uVar, this, refConnection));
        if (z10) {
            this.f30361a.A0(refConnection);
        }
    }

    public ObservableRefCount(a<T> aVar, int i10, long j10, TimeUnit timeUnit, v vVar) {
        this.f30361a = aVar;
        this.f30362b = i10;
        this.f30363c = j10;
        this.f30364d = timeUnit;
        this.f30365e = vVar;
    }
}
