package androidx.camera.video.internal.encoder;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f3336a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f3337b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f3338c;

    public /* synthetic */ o(EncoderImpl encoderImpl, long j10, long j11) {
        this.f3336a = encoderImpl;
        this.f3337b = j10;
        this.f3338c = j11;
    }

    public final void run() {
        this.f3336a.R(this.f3337b, this.f3338c);
    }
}
