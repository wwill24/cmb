package androidx.camera.video.internal.encoder;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f3375a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f3376b;

    public /* synthetic */ y(EncoderImpl encoderImpl, long j10) {
        this.f3375a = encoderImpl;
        this.f3376b = j10;
    }

    public final void run() {
        this.f3375a.O(this.f3376b);
    }
}
