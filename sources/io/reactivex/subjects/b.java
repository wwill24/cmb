package io.reactivex.subjects;

import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import qj.u;

final class b<T> extends c<T> implements a.C0358a<Object> {

    /* renamed from: a  reason: collision with root package name */
    final c<T> f30773a;

    /* renamed from: b  reason: collision with root package name */
    boolean f30774b;

    /* renamed from: c  reason: collision with root package name */
    a<Object> f30775c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f30776d;

    b(c<T> cVar) {
        this.f30773a = cVar;
    }

    /* access modifiers changed from: package-private */
    public void B0() {
        a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f30775c;
                if (aVar == null) {
                    this.f30774b = false;
                    return;
                }
                this.f30775c = null;
            }
            aVar.d(this);
        }
        while (true) {
        }
    }

    public void a(tj.b bVar) {
        boolean z10 = true;
        if (!this.f30776d) {
            synchronized (this) {
                if (!this.f30776d) {
                    if (this.f30774b) {
                        a<Object> aVar = this.f30775c;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f30775c = aVar;
                        }
                        aVar.c(NotificationLite.e(bVar));
                        return;
                    }
                    this.f30774b = true;
                    z10 = false;
                }
            }
        }
        if (z10) {
            bVar.dispose();
            return;
        }
        this.f30773a.a(bVar);
        B0();
    }

    public void d(T t10) {
        if (!this.f30776d) {
            synchronized (this) {
                if (!this.f30776d) {
                    if (this.f30774b) {
                        a<Object> aVar = this.f30775c;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f30775c = aVar;
                        }
                        aVar.c(NotificationLite.o(t10));
                        return;
                    }
                    this.f30774b = true;
                    this.f30773a.d(t10);
                    B0();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        this.f30773a.e(uVar);
    }

    public void onComplete() {
        if (!this.f30776d) {
            synchronized (this) {
                if (!this.f30776d) {
                    this.f30776d = true;
                    if (this.f30774b) {
                        a<Object> aVar = this.f30775c;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f30775c = aVar;
                        }
                        aVar.c(NotificationLite.d());
                        return;
                    }
                    this.f30774b = true;
                    this.f30773a.onComplete();
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
        r2.f30773a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f30776d
            if (r0 == 0) goto L_0x0008
            bk.a.s(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f30776d     // Catch:{ all -> 0x003b }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002e
        L_0x000f:
            r2.f30776d = r1     // Catch:{ all -> 0x003b }
            boolean r0 = r2.f30774b     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x002a
            io.reactivex.internal.util.a<java.lang.Object> r0 = r2.f30775c     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.a r0 = new io.reactivex.internal.util.a     // Catch:{ all -> 0x003b }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            r2.f30775c = r0     // Catch:{ all -> 0x003b }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.h(r3)     // Catch:{ all -> 0x003b }
            r0.e(r3)     // Catch:{ all -> 0x003b }
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return
        L_0x002a:
            r0 = 0
            r2.f30774b = r1     // Catch:{ all -> 0x003b }
            r1 = r0
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0035
            bk.a.s(r3)
            return
        L_0x0035:
            io.reactivex.subjects.c<T> r0 = r2.f30773a
            r0.onError(r3)
            return
        L_0x003b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.b.onError(java.lang.Throwable):void");
    }

    public boolean test(Object obj) {
        return NotificationLite.b(obj, this.f30773a);
    }
}
