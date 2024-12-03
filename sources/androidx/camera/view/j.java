package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.view.PreviewView;

public final /* synthetic */ class j implements SurfaceRequest.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreviewView.a f3490a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraInternal f3491b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f3492c;

    public /* synthetic */ j(PreviewView.a aVar, CameraInternal cameraInternal, SurfaceRequest surfaceRequest) {
        this.f3490a = aVar;
        this.f3491b = cameraInternal;
        this.f3492c = surfaceRequest;
    }

    public final void a(SurfaceRequest.f fVar) {
        this.f3490a.f(this.f3491b, this.f3492c, fVar);
    }
}
