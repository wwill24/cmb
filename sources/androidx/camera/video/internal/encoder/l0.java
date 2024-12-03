package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f3329a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f3330b;

    public /* synthetic */ l0(EncoderImpl.d dVar, CallbackToFutureAdapter.a aVar) {
        this.f3329a = dVar;
        this.f3330b = aVar;
    }

    public final void run() {
        this.f3329a.w(this.f3330b);
    }
}
