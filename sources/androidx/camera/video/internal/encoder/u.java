package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f3363a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f3364b;

    public /* synthetic */ u(EncoderImpl encoderImpl, CallbackToFutureAdapter.a aVar) {
        this.f3363a = encoderImpl;
        this.f3364b = aVar;
    }

    public final void run() {
        this.f3363a.F(this.f3364b);
    }
}
