package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;
import u.a;

public final /* synthetic */ class p1 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CaptureSession f1903a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f1904b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f1905c;

    public /* synthetic */ p1(CaptureSession captureSession, SessionConfig sessionConfig, CameraDevice cameraDevice) {
        this.f1903a = captureSession;
        this.f1904b = sessionConfig;
        this.f1905c = cameraDevice;
    }

    public final zf.a apply(Object obj) {
        return this.f1903a.s(this.f1904b, this.f1905c, (List) obj);
    }
}
