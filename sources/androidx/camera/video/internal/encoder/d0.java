package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import zf.a;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f3290a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f3291b;

    public /* synthetic */ d0(EncoderImpl.d dVar, a aVar) {
        this.f3290a = dVar;
        this.f3291b = aVar;
    }

    public final void run() {
        this.f3290a.q(this.f3291b);
    }
}
