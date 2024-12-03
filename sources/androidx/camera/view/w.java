package androidx.camera.view;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import zf.a;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f3520a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Surface f3521b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f3522c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f3523d;

    public /* synthetic */ w(z zVar, Surface surface, a aVar, SurfaceRequest surfaceRequest) {
        this.f3520a = zVar;
        this.f3521b = surface;
        this.f3522c = aVar;
        this.f3523d = surfaceRequest;
    }

    public final void run() {
        this.f3520a.r(this.f3521b, this.f3522c, this.f3523d);
    }
}
