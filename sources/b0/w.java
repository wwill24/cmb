package b0;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.n;
import androidx.camera.video.g0;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f7718a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionConfig.b f7719b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f7720c;

    public /* synthetic */ w(AtomicBoolean atomicBoolean, SessionConfig.b bVar, n nVar) {
        this.f7718a = atomicBoolean;
        this.f7719b = bVar;
        this.f7720c = nVar;
    }

    public final void run() {
        g0.r0(this.f7718a, this.f7719b, this.f7720c);
    }
}
