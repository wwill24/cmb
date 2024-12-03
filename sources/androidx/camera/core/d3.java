package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.a;

public final /* synthetic */ class d3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2219a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Surface f2220b;

    public /* synthetic */ d3(a aVar, Surface surface) {
        this.f2219a = aVar;
        this.f2220b = surface;
    }

    public final void run() {
        this.f2219a.accept(SurfaceRequest.e.c(4, this.f2220b));
    }
}
