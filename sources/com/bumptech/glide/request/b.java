package com.bumptech.glide.request;

import b4.a;
import com.bumptech.glide.request.RequestCoordinator;

public final class b implements RequestCoordinator, a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f9562a;

    /* renamed from: b  reason: collision with root package name */
    private final RequestCoordinator f9563b;

    /* renamed from: c  reason: collision with root package name */
    private volatile a f9564c;

    /* renamed from: d  reason: collision with root package name */
    private volatile a f9565d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f9566e;

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f9567f;

    public b(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f9566e = requestState;
        this.f9567f = requestState;
        this.f9562a = obj;
        this.f9563b = requestCoordinator;
    }

    private boolean k(a aVar) {
        if (aVar.equals(this.f9564c) || (this.f9566e == RequestCoordinator.RequestState.FAILED && aVar.equals(this.f9565d))) {
            return true;
        }
        return false;
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f9563b;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f9563b;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    private boolean n() {
        RequestCoordinator requestCoordinator = this.f9563b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public boolean a() {
        boolean z10;
        synchronized (this.f9562a) {
            if (!this.f9564c.a()) {
                if (!this.f9565d.a()) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public boolean b(a aVar) {
        boolean z10;
        synchronized (this.f9562a) {
            if (!l() || !k(aVar)) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean c(a aVar) {
        boolean z10;
        synchronized (this.f9562a) {
            if (!n() || !k(aVar)) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    public void clear() {
        synchronized (this.f9562a) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f9566e = requestState;
            this.f9564c.clear();
            if (this.f9567f != requestState) {
                this.f9567f = requestState;
                this.f9565d.clear();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(b4.a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f9562a
            monitor-enter(r0)
            b4.a r1 = r2.f9565d     // Catch:{ all -> 0x002b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x001e
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002b }
            r2.f9566e = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f9567f     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002b }
            if (r3 == r1) goto L_0x001c
            r2.f9567f = r1     // Catch:{ all -> 0x002b }
            b4.a r3 = r2.f9565d     // Catch:{ all -> 0x002b }
            r3.j()     // Catch:{ all -> 0x002b }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x001e:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002b }
            r2.f9567f = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f9563b     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0029
            r3.d(r2)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.b.d(b4.a):void");
    }

    public boolean e(a aVar) {
        if (!(aVar instanceof b)) {
            return false;
        }
        b bVar = (b) aVar;
        if (!this.f9564c.e(bVar.f9564c) || !this.f9565d.e(bVar.f9565d)) {
            return false;
        }
        return true;
    }

    public boolean f() {
        boolean z10;
        synchronized (this.f9562a) {
            RequestCoordinator.RequestState requestState = this.f9566e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            if (requestState == requestState2 && this.f9567f == requestState2) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void g(a aVar) {
        synchronized (this.f9562a) {
            if (aVar.equals(this.f9564c)) {
                this.f9566e = RequestCoordinator.RequestState.SUCCESS;
            } else if (aVar.equals(this.f9565d)) {
                this.f9567f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.f9563b;
            if (requestCoordinator != null) {
                requestCoordinator.g(this);
            }
        }
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.f9562a) {
            RequestCoordinator requestCoordinator2 = this.f9563b;
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
        synchronized (this.f9562a) {
            RequestCoordinator.RequestState requestState = this.f9566e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (requestState != requestState2) {
                if (this.f9567f != requestState2) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public boolean i(a aVar) {
        boolean z10;
        synchronized (this.f9562a) {
            if (!m() || !k(aVar)) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean isRunning() {
        boolean z10;
        synchronized (this.f9562a) {
            RequestCoordinator.RequestState requestState = this.f9566e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                if (this.f9567f != requestState2) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public void j() {
        synchronized (this.f9562a) {
            RequestCoordinator.RequestState requestState = this.f9566e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.f9566e = requestState2;
                this.f9564c.j();
            }
        }
    }

    public void o(a aVar, a aVar2) {
        this.f9564c = aVar;
        this.f9565d = aVar2;
    }

    public void pause() {
        synchronized (this.f9562a) {
            RequestCoordinator.RequestState requestState = this.f9566e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.f9566e = RequestCoordinator.RequestState.PAUSED;
                this.f9564c.pause();
            }
            if (this.f9567f == requestState2) {
                this.f9567f = RequestCoordinator.RequestState.PAUSED;
                this.f9565d.pause();
            }
        }
    }
}
