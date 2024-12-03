package com.bumptech.glide.request;

import b4.a;
import com.bumptech.glide.request.RequestCoordinator;

public class c implements RequestCoordinator, a {

    /* renamed from: a  reason: collision with root package name */
    private final RequestCoordinator f9568a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f9569b;

    /* renamed from: c  reason: collision with root package name */
    private volatile a f9570c;

    /* renamed from: d  reason: collision with root package name */
    private volatile a f9571d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f9572e;

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f9573f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9574g;

    public c(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f9572e = requestState;
        this.f9573f = requestState;
        this.f9569b = obj;
        this.f9568a = requestCoordinator;
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.f9568a;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f9568a;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f9568a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public boolean a() {
        boolean z10;
        synchronized (this.f9569b) {
            if (!this.f9571d.a()) {
                if (!this.f9570c.a()) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public boolean b(a aVar) {
        boolean z10;
        synchronized (this.f9569b) {
            if (!k() || !aVar.equals(this.f9570c) || this.f9572e == RequestCoordinator.RequestState.PAUSED) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean c(a aVar) {
        boolean z10;
        synchronized (this.f9569b) {
            if (!m() || (!aVar.equals(this.f9570c) && this.f9572e == RequestCoordinator.RequestState.SUCCESS)) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    public void clear() {
        synchronized (this.f9569b) {
            this.f9574g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f9572e = requestState;
            this.f9573f = requestState;
            this.f9571d.clear();
            this.f9570c.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(b4.a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f9569b
            monitor-enter(r0)
            b4.a r1 = r2.f9570c     // Catch:{ all -> 0x001e }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001e }
            r2.f9573f = r3     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001e }
            r2.f9572e = r3     // Catch:{ all -> 0x001e }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f9568a     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            r3.d(r2)     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.c.d(b4.a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(b4.a r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.request.c
            r1 = 0
            if (r0 == 0) goto L_0x002e
            com.bumptech.glide.request.c r4 = (com.bumptech.glide.request.c) r4
            b4.a r0 = r3.f9570c
            if (r0 != 0) goto L_0x0010
            b4.a r0 = r4.f9570c
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            b4.a r0 = r3.f9570c
            b4.a r2 = r4.f9570c
            boolean r0 = r0.e(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            b4.a r0 = r3.f9571d
            if (r0 != 0) goto L_0x0023
            b4.a r4 = r4.f9571d
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            b4.a r0 = r3.f9571d
            b4.a r4 = r4.f9571d
            boolean r4 = r0.e(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.c.e(b4.a):boolean");
    }

    public boolean f() {
        boolean z10;
        synchronized (this.f9569b) {
            if (this.f9572e == RequestCoordinator.RequestState.CLEARED) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(b4.a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f9569b
            monitor-enter(r0)
            b4.a r1 = r2.f9571d     // Catch:{ all -> 0x002b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002b }
            r2.f9573f = r3     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002b }
            r2.f9572e = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f9568a     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x001c
            r3.g(r2)     // Catch:{ all -> 0x002b }
        L_0x001c:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f9573f     // Catch:{ all -> 0x002b }
            boolean r3 = r3.a()     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x0029
            b4.a r3 = r2.f9571d     // Catch:{ all -> 0x002b }
            r3.clear()     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.c.g(b4.a):void");
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.f9569b) {
            RequestCoordinator requestCoordinator2 = this.f9568a;
            if (requestCoordinator2 != null) {
                requestCoordinator = requestCoordinator2.getRoot();
            } else {
                requestCoordinator = this;
            }
        }
        return requestCoordinator;
    }

    public boolean h() {
        boolean z10;
        synchronized (this.f9569b) {
            if (this.f9572e == RequestCoordinator.RequestState.SUCCESS) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean i(a aVar) {
        boolean z10;
        synchronized (this.f9569b) {
            if (!l() || !aVar.equals(this.f9570c) || a()) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean isRunning() {
        boolean z10;
        synchronized (this.f9569b) {
            if (this.f9572e == RequestCoordinator.RequestState.RUNNING) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void j() {
        RequestCoordinator.RequestState requestState;
        RequestCoordinator.RequestState requestState2;
        synchronized (this.f9569b) {
            this.f9574g = true;
            try {
                if (!(this.f9572e == RequestCoordinator.RequestState.SUCCESS || this.f9573f == (requestState2 = RequestCoordinator.RequestState.RUNNING))) {
                    this.f9573f = requestState2;
                    this.f9571d.j();
                }
                if (this.f9574g && this.f9572e != (requestState = RequestCoordinator.RequestState.RUNNING)) {
                    this.f9572e = requestState;
                    this.f9570c.j();
                }
            } finally {
                this.f9574g = false;
            }
        }
    }

    public void n(a aVar, a aVar2) {
        this.f9570c = aVar;
        this.f9571d = aVar2;
    }

    public void pause() {
        synchronized (this.f9569b) {
            if (!this.f9573f.a()) {
                this.f9573f = RequestCoordinator.RequestState.PAUSED;
                this.f9571d.pause();
            }
            if (!this.f9572e.a()) {
                this.f9572e = RequestCoordinator.RequestState.PAUSED;
                this.f9570c.pause();
            }
        }
    }
}
