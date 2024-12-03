package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreviewView.a f3488a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f3489b;

    public /* synthetic */ i(PreviewView.a aVar, SurfaceRequest surfaceRequest) {
        this.f3488a = aVar;
        this.f3489b = surfaceRequest;
    }

    public final void run() {
        this.f3488a.e(this.f3489b);
    }
}
