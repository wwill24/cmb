package androidx.camera.video;

import androidx.camera.video.Recorder;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f3414a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder.h f3415b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f3416c;

    public /* synthetic */ s(Recorder recorder, Recorder.h hVar, long j10) {
        this.f3414a = recorder;
        this.f3415b = hVar;
        this.f3416c = j10;
    }

    public final void run() {
        this.f3414a.T(this.f3415b, this.f3416c);
    }
}
