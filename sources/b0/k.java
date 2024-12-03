package b0;

import androidx.camera.video.Recorder;
import androidx.camera.video.internal.encoder.j;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f7696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f7697b;

    public /* synthetic */ k(Recorder recorder, j jVar) {
        this.f7696a = recorder;
        this.f7697b = jVar;
    }

    public final void run() {
        this.f7696a.V(this.f7697b);
    }
}
