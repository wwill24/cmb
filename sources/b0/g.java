package b0;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.Recorder;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f7686a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f7687b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Timebase f7688c;

    public /* synthetic */ g(Recorder recorder, SurfaceRequest surfaceRequest, Timebase timebase) {
        this.f7686a = recorder;
        this.f7687b = surfaceRequest;
        this.f7688c = timebase;
    }

    public final void run() {
        this.f7686a.O(this.f7687b, this.f7688c);
    }
}
