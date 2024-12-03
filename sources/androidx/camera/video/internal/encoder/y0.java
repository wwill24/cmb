package androidx.camera.video.internal.encoder;

import android.view.Surface;
import androidx.camera.video.internal.encoder.j;

public final /* synthetic */ class y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j.c.a f3377a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Surface f3378b;

    public /* synthetic */ y0(j.c.a aVar, Surface surface) {
        this.f3377a = aVar;
        this.f3378b = surface;
    }

    public final void run() {
        this.f3377a.a(this.f3378b);
    }
}
