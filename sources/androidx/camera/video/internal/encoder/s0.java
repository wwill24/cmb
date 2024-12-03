package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;

public final /* synthetic */ class s0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f3359a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaFormat f3360b;

    public /* synthetic */ s0(k kVar, MediaFormat mediaFormat) {
        this.f3359a = kVar;
        this.f3360b = mediaFormat;
    }

    public final void run() {
        this.f3359a.a(new w0(this.f3360b));
    }
}
