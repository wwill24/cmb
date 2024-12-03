package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;
import u.a;

public final /* synthetic */ class l2 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProcessingCaptureSession f1843a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f1844b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f1845c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d3 f1846d;

    public /* synthetic */ l2(ProcessingCaptureSession processingCaptureSession, SessionConfig sessionConfig, CameraDevice cameraDevice, d3 d3Var) {
        this.f1843a = processingCaptureSession;
        this.f1844b = sessionConfig;
        this.f1845c = cameraDevice;
        this.f1846d = d3Var;
    }

    public final zf.a apply(Object obj) {
        return this.f1843a.q(this.f1844b, this.f1845c, this.f1846d, (List) obj);
    }
}
