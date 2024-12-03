package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import zf.a;

public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2568a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f2569b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f2570c;

    public /* synthetic */ n0(a aVar, CallbackToFutureAdapter.a aVar2, long j10) {
        this.f2568a = aVar;
        this.f2569b = aVar2;
        this.f2570c = j10;
    }

    public final void run() {
        o0.g(this.f2568a, this.f2569b, this.f2570c);
    }
}
