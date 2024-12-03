package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import zf.a;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f3301a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f3302b;

    public /* synthetic */ e0(EncoderImpl.d dVar, a aVar) {
        this.f3301a = dVar;
        this.f3302b = aVar;
    }

    public final void run() {
        this.f3301a.r(this.f3302b);
    }
}
