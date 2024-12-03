package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t f1851a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f1852b;

    public /* synthetic */ n(t tVar, CallbackToFutureAdapter.a aVar) {
        this.f1851a = tVar;
        this.f1852b = aVar;
    }

    public final void run() {
        this.f1851a.X(this.f1852b);
    }
}
