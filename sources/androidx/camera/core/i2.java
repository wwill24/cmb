package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class i2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j2 f2349a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f2350b;

    public /* synthetic */ i2(j2 j2Var, CallbackToFutureAdapter.a aVar) {
        this.f2349a = j2Var;
        this.f2350b = aVar;
    }

    public final void run() {
        this.f2349a.p(this.f2350b);
    }
}
