package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SessionConfig.c f2048a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f2049b;

    public /* synthetic */ z(SessionConfig.c cVar, SessionConfig sessionConfig) {
        this.f2048a = cVar;
        this.f2049b = sessionConfig;
    }

    public final void run() {
        this.f2048a.a(this.f2049b, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
    }
}
