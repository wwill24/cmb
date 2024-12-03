package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class p0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.e f3343a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodec.BufferInfo f3344b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaCodec f3345c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f3346d;

    public /* synthetic */ p0(EncoderImpl.e eVar, MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i10) {
        this.f3343a = eVar;
        this.f3344b = bufferInfo;
        this.f3345c = mediaCodec;
        this.f3346d = i10;
    }

    public final void run() {
        this.f3343a.m(this.f3344b, this.f3345c, this.f3346d);
    }
}
