package b0;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.video.Recorder;
import androidx.camera.video.internal.encoder.j;

public final /* synthetic */ class i implements j.c.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f7692a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f7693b;

    public /* synthetic */ i(Recorder recorder, SurfaceRequest surfaceRequest) {
        this.f7692a = recorder;
        this.f7693b = surfaceRequest;
    }

    public final void a(Surface surface) {
        this.f7692a.R(this.f7693b, surface);
    }
}
