package androidx.camera.video.internal.encoder;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f3372a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f3373b;

    public /* synthetic */ x(EncoderImpl encoderImpl, long j10) {
        this.f3372a = encoderImpl;
        this.f3373b = j10;
    }

    public final void run() {
        this.f3372a.K(this.f3373b);
    }
}
