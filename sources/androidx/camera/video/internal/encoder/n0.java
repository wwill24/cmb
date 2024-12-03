package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.e f3334a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodec.CodecException f3335b;

    public /* synthetic */ n0(EncoderImpl.e eVar, MediaCodec.CodecException codecException) {
        this.f3334a = eVar;
        this.f3335b = codecException;
    }

    public final void run() {
        this.f3334a.j(this.f3335b);
    }
}
