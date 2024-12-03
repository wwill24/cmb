package b0;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.Recorder;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f7689a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f7690b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Timebase f7691c;

    public /* synthetic */ h(Recorder recorder, SurfaceRequest surfaceRequest, Timebase timebase) {
        this.f7689a = recorder;
        this.f7690b = surfaceRequest;
        this.f7691c = timebase;
    }

    public final void run() {
        this.f7689a.P(this.f7690b, this.f7691c);
    }
}
