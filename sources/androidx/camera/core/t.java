package androidx.camera.core;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraX f2897a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f2898b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f2899c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f2900d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f2901e;

    public /* synthetic */ t(CameraX cameraX, Context context, Executor executor, CallbackToFutureAdapter.a aVar, long j10) {
        this.f2897a = cameraX;
        this.f2898b = context;
        this.f2899c = executor;
        this.f2900d = aVar;
        this.f2901e = j10;
    }

    public final void run() {
        this.f2897a.m(this.f2898b, this.f2899c, this.f2900d, this.f2901e);
    }
}
