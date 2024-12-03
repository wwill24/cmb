package b0;

import androidx.camera.video.Recorder;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.a;

public final /* synthetic */ class j implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f7694a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f7695b;

    public /* synthetic */ j(Recorder recorder, CallbackToFutureAdapter.a aVar) {
        this.f7694a = recorder;
        this.f7695b = aVar;
    }

    public final void accept(Object obj) {
        this.f7694a.K(this.f7695b, (Throwable) obj);
    }
}
