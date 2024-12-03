package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.f2;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f1740a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1741b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f1742c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ f2 f1743d;

    public /* synthetic */ f0(Camera2CameraImpl camera2CameraImpl, String str, SessionConfig sessionConfig, f2 f2Var) {
        this.f1740a = camera2CameraImpl;
        this.f1741b = str;
        this.f1742c = sessionConfig;
        this.f1743d = f2Var;
    }

    public final void run() {
        this.f1740a.T(this.f1741b, this.f1742c, this.f1743d);
    }
}
