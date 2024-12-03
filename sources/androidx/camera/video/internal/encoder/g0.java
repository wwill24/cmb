package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.l1;
import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f3309a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l1.a f3310b;

    public /* synthetic */ g0(EncoderImpl.d dVar, l1.a aVar) {
        this.f3309a = dVar;
        this.f3310b = aVar;
    }

    public final void run() {
        this.f3309a.y(this.f3310b);
    }
}
