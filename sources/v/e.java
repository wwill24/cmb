package v;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.a;

public final /* synthetic */ class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Surface f18035a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f18036b;

    public /* synthetic */ e(Surface surface, SurfaceTexture surfaceTexture) {
        this.f18035a = surface;
        this.f18036b = surfaceTexture;
    }

    public final void accept(Object obj) {
        CameraUseCaseAdapter.F(this.f18035a, this.f18036b, (SurfaceRequest.e) obj);
    }
}
