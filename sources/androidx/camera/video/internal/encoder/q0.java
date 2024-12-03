package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class q0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.e f3350a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3351b;

    public /* synthetic */ q0(EncoderImpl.e eVar, int i10) {
        this.f3350a = eVar;
        this.f3351b = i10;
    }

    public final void run() {
        this.f3350a.k(this.f3351b);
    }
}
