package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import java.util.concurrent.Executor;

public final /* synthetic */ class u0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.e f3365a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f3366b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f3367c;

    public /* synthetic */ u0(EncoderImpl.e eVar, Executor executor, k kVar) {
        this.f3365a = eVar;
        this.f3366b = executor;
        this.f3367c = kVar;
    }

    public final void run() {
        this.f3365a.l(this.f3366b, this.f3367c);
    }
}
