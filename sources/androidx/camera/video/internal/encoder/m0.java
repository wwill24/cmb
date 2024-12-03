package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f3331a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f3332b;

    public /* synthetic */ m0(EncoderImpl.d dVar, CallbackToFutureAdapter.a aVar) {
        this.f3331a = dVar;
        this.f3332b = aVar;
    }

    public final void run() {
        this.f3331a.s(this.f3332b);
    }
}
