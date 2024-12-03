package androidx.camera.video;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.video.g0;

public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0.b f3140a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionConfig.b f3141b;

    public /* synthetic */ h0(g0.b bVar, SessionConfig.b bVar2) {
        this.f3140a = bVar;
        this.f3141b = bVar2;
    }

    public final void run() {
        this.f3140a.e(this.f3141b);
    }
}
