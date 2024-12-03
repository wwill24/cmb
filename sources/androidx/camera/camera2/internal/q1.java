package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class q1 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CaptureSession f1922a;

    public /* synthetic */ q1(CaptureSession captureSession) {
        this.f1922a = captureSession;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f1922a.t(aVar);
    }
}
