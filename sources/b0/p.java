package b0;

import androidx.camera.video.Recorder;
import androidx.camera.video.VideoOutput;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f7700a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoOutput.SourceState f7701b;

    public /* synthetic */ p(Recorder recorder, VideoOutput.SourceState sourceState) {
        this.f7700a = recorder;
        this.f7701b = sourceState;
    }

    public final void run() {
        this.f7700a.N(this.f7701b);
    }
}
