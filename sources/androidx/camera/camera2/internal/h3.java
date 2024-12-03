package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class h3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i3 f1786a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f1787b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f1788c;

    public /* synthetic */ h3(i3 i3Var, CallbackToFutureAdapter.a aVar, boolean z10) {
        this.f1786a = i3Var;
        this.f1787b = aVar;
        this.f1788c = z10;
    }

    public final void run() {
        this.f1786a.g(this.f1787b, this.f1788c);
    }
}
