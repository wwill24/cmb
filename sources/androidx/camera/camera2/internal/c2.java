package androidx.camera.camera2.internal;

import androidx.camera.core.f0;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class c2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g2 f1697a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f1698b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f0 f1699c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f1700d;

    public /* synthetic */ c2(g2 g2Var, CallbackToFutureAdapter.a aVar, f0 f0Var, long j10) {
        this.f1697a = g2Var;
        this.f1698b = aVar;
        this.f1699c = f0Var;
        this.f1700d = j10;
    }

    public final void run() {
        this.f1697a.G(this.f1698b, this.f1699c, this.f1700d);
    }
}
