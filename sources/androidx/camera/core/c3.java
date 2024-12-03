package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.a;

public final /* synthetic */ class c3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2206a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Surface f2207b;

    public /* synthetic */ c3(a aVar, Surface surface) {
        this.f2206a = aVar;
        this.f2207b = surface;
    }

    public final void run() {
        this.f2206a.accept(SurfaceRequest.e.c(3, this.f2207b));
    }
}
