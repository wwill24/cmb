package androidx.camera.video.internal.encoder;

import java.util.List;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f3347a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f3348b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f3349c;

    public /* synthetic */ q(EncoderImpl encoderImpl, List list, Runnable runnable) {
        this.f3347a = encoderImpl;
        this.f3348b = list;
        this.f3349c = runnable;
    }

    public final void run() {
        this.f3347a.S(this.f3348b, this.f3349c);
    }
}
