package androidx.camera.video;

import androidx.camera.video.Recorder;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class v implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f3420a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder.h f3421b;

    public /* synthetic */ v(Recorder recorder, Recorder.h hVar) {
        this.f3420a = recorder;
        this.f3421b = hVar;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f3420a.L(this.f3421b, aVar);
    }
}
