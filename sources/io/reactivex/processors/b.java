package io.reactivex.processors;

import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import rn.c;

final class b<T> extends a<T> {

    /* renamed from: b  reason: collision with root package name */
    final a<T> f30736b;

    /* renamed from: c  reason: collision with root package name */
    boolean f30737c;

    /* renamed from: d  reason: collision with root package name */
    a<Object> f30738d;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f30739e;

    b(a<T> aVar) {
        this.f30736b = aVar;
    }

    /* access modifiers changed from: package-private */
    public void B0() {
        a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f30738d;
                if (aVar == null) {
                    this.f30737c = false;
                    return;
                }
                this.f30738d = null;
            }
            aVar.b(this.f30736b);
        }
        while (true) {
        }
    }

    public void d(T t10) {
        if (!this.f30739e) {
            synchronized (this) {
                if (!this.f30739e) {
                    if (this.f30737c) {
                        a<Object> aVar = this.f30738d;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f30738d = aVar;
                        }
                        aVar.c(NotificationLite.o(t10));
                        return;
                    }
                    this.f30737c = true;
                    this.f30736b.d(t10);
                    B0();
                }
            }
        }
    }

    public void e(c cVar) {
        boolean z10 = true;
        if (!this.f30739e) {
            synchronized (this) {
                if (!this.f30739e) {
                    if (this.f30737c) {
                        a<Object> aVar = this.f30738d;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f30738d = aVar;
                        }
                        aVar.c(NotificationLite.p(cVar));
                        return;
                    }
                    this.f30737c = true;
                    z10 = false;
                }
            }
        }
        if (z10) {
            cVar.cancel();
            return;
        }
        this.f30736b.e(cVar);
        B0();
    }

    /* access modifiers changed from: protected */
    public void n0(rn.b<? super T> bVar) {
        this.f30736b.a(bVar);
    }

    public void onComplete() {
        if (!this.f30739e) {
            synchronized (this) {
                if (!this.f30739e) {
                    this.f30739e = true;
                    if (this.f30737c) {
                        a<Object> aVar = this.f30738d;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f30738d = aVar;
                        }
                        aVar.c(NotificationLite.d());
                        return;
                    }
                    this.f30737c = true;
                    this.f30736b.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r1 == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        bk.a.s(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        r2.f30736b.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f30739e
            if (r0 == 0) goto L_0x0008
            bk.a.s(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f30739e     // Catch:{ all -> 0x003b }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002e
        L_0x000f:
            r2.f30739e = r1     // Catch:{ all -> 0x003b }
            boolean r0 = r2.f30737c     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x002a
            io.reactivex.internal.util.a<java.lang.Object> r0 = r2.f30738d     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.a r0 = new io.reactivex.internal.util.a     // Catch:{ all -> 0x003b }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            r2.f30738d = r0     // Catch:{ all -> 0x003b }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.h(r3)     // Catch:{ all -> 0x003b }
            r0.e(r3)     // Catch:{ all -> 0x003b }
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return
        L_0x002a:
            r0 = 0
            r2.f30737c = r1     // Catch:{ all -> 0x003b }
            r1 = r0
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0035
            bk.a.s(r3)
            return
        L_0x0035:
            io.reactivex.processors.a<T> r0 = r2.f30736b
            r0.onError(r3)
            return
        L_0x003b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.b.onError(java.lang.Throwable):void");
    }
}
