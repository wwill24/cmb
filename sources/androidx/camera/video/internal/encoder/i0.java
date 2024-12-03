package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.l1;
import androidx.camera.video.internal.encoder.EncoderImpl;
import java.util.concurrent.Executor;

public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f3320a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l1.a f3321b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f3322c;

    public /* synthetic */ i0(EncoderImpl.d dVar, l1.a aVar, Executor executor) {
        this.f3320a = dVar;
        this.f3321b = aVar;
        this.f3322c = executor;
    }

    public final void run() {
        this.f3320a.v(this.f3321b, this.f3322c);
    }
}
