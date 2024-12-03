package a0;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.a;

public final /* synthetic */ class j implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f52a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f53b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Surface f54c;

    public /* synthetic */ j(k kVar, SurfaceTexture surfaceTexture, Surface surface) {
        this.f52a = kVar;
        this.f53b = surfaceTexture;
        this.f54c = surface;
    }

    public final void accept(Object obj) {
        this.f52a.n(this.f53b, this.f54c, (SurfaceRequest.e) obj);
    }
}
