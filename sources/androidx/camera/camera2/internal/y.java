package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.f2;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f2041a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2042b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f2043c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ f2 f2044d;

    public /* synthetic */ y(Camera2CameraImpl camera2CameraImpl, String str, SessionConfig sessionConfig, f2 f2Var) {
        this.f2041a = camera2CameraImpl;
        this.f2042b = str;
        this.f2043c = sessionConfig;
        this.f2044d = f2Var;
    }

    public final void run() {
        this.f2041a.R(this.f2042b, this.f2043c, this.f2044d);
    }
}
