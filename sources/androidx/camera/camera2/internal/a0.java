package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.f2;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f1670a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f1672c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ f2 f1673d;

    public /* synthetic */ a0(Camera2CameraImpl camera2CameraImpl, String str, SessionConfig sessionConfig, f2 f2Var) {
        this.f1670a = camera2CameraImpl;
        this.f1671b = str;
        this.f1672c = sessionConfig;
        this.f1673d = f2Var;
    }

    public final void run() {
        this.f1670a.U(this.f1671b, this.f1672c, this.f1673d);
    }
}
