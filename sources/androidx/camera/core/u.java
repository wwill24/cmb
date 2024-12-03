package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraX f2911a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f2912b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f2913c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f2914d;

    public /* synthetic */ u(CameraX cameraX, Executor executor, long j10, CallbackToFutureAdapter.a aVar) {
        this.f2911a = cameraX;
        this.f2912b = executor;
        this.f2913c = j10;
        this.f2914d = aVar;
    }

    public final void run() {
        this.f2911a.l(this.f2912b, this.f2913c, this.f2914d);
    }
}
