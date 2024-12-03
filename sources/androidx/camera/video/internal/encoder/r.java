package androidx.camera.video.internal.encoder;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f3352a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3353b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f3354c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Throwable f3355d;

    public /* synthetic */ r(k kVar, int i10, String str, Throwable th2) {
        this.f3352a = kVar;
        this.f3353b = i10;
        this.f3354c = str;
        this.f3355d = th2;
    }

    public final void run() {
        this.f3352a.f(new EncodeException(this.f3353b, this.f3354c, this.f3355d));
    }
}
