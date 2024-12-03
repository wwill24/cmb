package androidx.camera.core;

import android.media.MediaCodec;

public final /* synthetic */ class h3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2339a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodec f2340b;

    public /* synthetic */ h3(boolean z10, MediaCodec mediaCodec) {
        this.f2339a = z10;
        this.f2340b = mediaCodec;
    }

    public final void run() {
        VideoCapture.S(this.f2339a, this.f2340b);
    }
}
