package d0;

import androidx.camera.video.internal.AudioSource;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioSource f14395a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f14396b;

    public /* synthetic */ g(AudioSource audioSource, CallbackToFutureAdapter.a aVar) {
        this.f14395a = audioSource;
        this.f14396b = aVar;
    }

    public final void run() {
        this.f14395a.q(this.f14396b);
    }
}
