package ek;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import qj.l;
import rn.b;
import rn.c;

public final class a<T> implements l<T>, c {

    /* renamed from: a  reason: collision with root package name */
    final b<? super T> f29610a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f29611b;

    /* renamed from: c  reason: collision with root package name */
    c f29612c;

    /* renamed from: d  reason: collision with root package name */
    boolean f29613d;

    /* renamed from: e  reason: collision with root package name */
    io.reactivex.internal.util.a<Object> f29614e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f29615f;

    public a(b<? super T> bVar) {
        this(bVar, false);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        io.reactivex.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f29614e;
                if (aVar == null) {
                    this.f29613d = false;
                    return;
                }
                this.f29614e = null;
            }
        } while (!aVar.b(this.f29610a));
    }

    public void cancel() {
        this.f29612c.cancel();
    }

    public void d(T t10) {
        if (!this.f29615f) {
            if (t10 == null) {
                this.f29612c.cancel();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f29615f) {
                    if (this.f29613d) {
                        io.reactivex.internal.util.a<Object> aVar = this.f29614e;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.f29614e = aVar;
                        }
                        aVar.c(NotificationLite.o(t10));
                        return;
                    }
                    this.f29613d = true;
                    this.f29610a.d(t10);
                    a();
                }
            }
        }
    }

    public void e(c cVar) {
        if (SubscriptionHelper.k(this.f29612c, cVar)) {
            this.f29612c = cVar;
            this.f29610a.e(this);
        }
    }

    public void onComplete() {
        if (!this.f29615f) {
            synchronized (this) {
                if (!this.f29615f) {
                    if (this.f29613d) {
                        io.reactivex.internal.util.a<Object> aVar = this.f29614e;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.f29614e = aVar;
                        }
                        aVar.c(NotificationLite.d());
                        return;
                    }
                    this.f29615f = true;
                    this.f29613d = true;
                    this.f29610a.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        bk.a.s(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f29610a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f29615f
            if (r0 == 0) goto L_0x0008
            bk.a.s(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f29615f     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f29613d     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f29615f = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.internal.util.a<java.lang.Object> r0 = r2.f29614e     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.a r0 = new io.reactivex.internal.util.a     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f29614e = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.h(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f29611b     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.c(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.e(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f29615f = r1     // Catch:{ all -> 0x0044 }
            r2.f29613d = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            bk.a.s(r3)
            return
        L_0x003e:
            rn.b<? super T> r0 = r2.f29610a
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ek.a.onError(java.lang.Throwable):void");
    }

    public void r(long j10) {
        this.f29612c.r(j10);
    }

    public a(b<? super T> bVar, boolean z10) {
        this.f29610a = bVar;
        this.f29611b = z10;
    }
}
