package androidx.camera.video.internal.encoder;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f3256a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3257b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f3258c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Throwable f3259d;

    public /* synthetic */ b0(EncoderImpl encoderImpl, int i10, String str, Throwable th2) {
        this.f3256a = encoderImpl;
        this.f3257b = i10;
        this.f3258c = str;
        this.f3259d = th2;
    }

    public final void run() {
        this.f3256a.G(this.f3257b, this.f3258c, this.f3259d);
    }
}
