package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.e f3356a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaFormat f3357b;

    public /* synthetic */ r0(EncoderImpl.e eVar, MediaFormat mediaFormat) {
        this.f3356a = eVar;
        this.f3357b = mediaFormat;
    }

    public final void run() {
        this.f3356a.p(this.f3357b);
    }
}
