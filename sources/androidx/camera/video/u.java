package androidx.camera.video;

import androidx.camera.video.Recorder;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class u implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f3418a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder.h f3419b;

    public /* synthetic */ u(Recorder recorder, Recorder.h hVar) {
        this.f3418a = recorder;
        this.f3419b = hVar;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f3418a.J(this.f3419b, aVar);
    }
}
