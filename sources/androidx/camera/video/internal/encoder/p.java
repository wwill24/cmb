package androidx.camera.video.internal.encoder;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f3341a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f3342b;

    public /* synthetic */ p(EncoderImpl encoderImpl, d1 d1Var) {
        this.f3341a = encoderImpl;
        this.f3342b = d1Var;
    }

    public final void run() {
        this.f3341a.H(this.f3342b);
    }
}
