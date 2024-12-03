package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import zf.a;

public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executor f2562a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f2563b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f2564c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f2565d;

    public /* synthetic */ l0(Executor executor, a aVar, CallbackToFutureAdapter.a aVar2, long j10) {
        this.f2562a = executor;
        this.f2563b = aVar;
        this.f2564c = aVar2;
        this.f2565d = j10;
    }

    public final void run() {
        this.f2562a.execute(new n0(this.f2563b, this.f2564c, this.f2565d));
    }
}
