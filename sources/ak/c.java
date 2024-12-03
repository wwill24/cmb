package ak;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import qj.u;
import tj.b;

public final class c<T> implements u<T>, b {

    /* renamed from: a  reason: collision with root package name */
    final u<? super T> f24894a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f24895b;

    /* renamed from: c  reason: collision with root package name */
    b f24896c;

    /* renamed from: d  reason: collision with root package name */
    boolean f24897d;

    /* renamed from: e  reason: collision with root package name */
    a<Object> f24898e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f24899f;

    public c(u<? super T> uVar) {
        this(uVar, false);
    }

    public void a(b bVar) {
        if (DisposableHelper.k(this.f24896c, bVar)) {
            this.f24896c = bVar;
            this.f24894a.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f24898e;
                if (aVar == null) {
                    this.f24897d = false;
                    return;
                }
                this.f24898e = null;
            }
        } while (!aVar.a(this.f24894a));
    }

    public boolean c() {
        return this.f24896c.c();
    }

    public void d(T t10) {
        if (!this.f24899f) {
            if (t10 == null) {
                this.f24896c.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f24899f) {
                    if (this.f24897d) {
                        a<Object> aVar = this.f24898e;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f24898e = aVar;
                        }
                        aVar.c(NotificationLite.o(t10));
                        return;
                    }
                    this.f24897d = true;
                    this.f24894a.d(t10);
                    b();
                }
            }
        }
    }

    public void dispose() {
        this.f24896c.dispose();
    }

    public void onComplete() {
        if (!this.f24899f) {
            synchronized (this) {
                if (!this.f24899f) {
                    if (this.f24897d) {
                        a<Object> aVar = this.f24898e;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f24898e = aVar;
                        }
                        aVar.c(NotificationLite.d());
                        return;
                    }
                    this.f24899f = true;
                    this.f24897d = true;
                    this.f24894a.onComplete();
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
        r2.f24894a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f24899f
            if (r0 == 0) goto L_0x0008
            bk.a.s(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f24899f     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f24897d     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f24899f = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.internal.util.a<java.lang.Object> r0 = r2.f24898e     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.a r0 = new io.reactivex.internal.util.a     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f24898e = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.h(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f24895b     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.c(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.e(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f24899f = r1     // Catch:{ all -> 0x0044 }
            r2.f24897d = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            bk.a.s(r3)
            return
        L_0x003e:
            qj.u<? super T> r0 = r2.f24894a
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ak.c.onError(java.lang.Throwable):void");
    }

    public c(u<? super T> uVar, boolean z10) {
        this.f24894a = uVar;
        this.f24895b = z10;
    }
}
