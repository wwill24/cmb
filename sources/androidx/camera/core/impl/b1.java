package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f1 f2467a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f2468b;

    public /* synthetic */ b1(f1 f1Var, CallbackToFutureAdapter.a aVar) {
        this.f2467a = f1Var;
        this.f2468b = aVar;
    }

    public final void run() {
        this.f2467a.j(this.f2468b);
    }
}
