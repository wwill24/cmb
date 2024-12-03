package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.n;

final class m1 extends n {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureSession.CaptureCallback f1848a;

    private m1(CameraCaptureSession.CaptureCallback captureCallback) {
        if (captureCallback != null) {
            this.f1848a = captureCallback;
            return;
        }
        throw new NullPointerException("captureCallback is null");
    }

    static m1 d(CameraCaptureSession.CaptureCallback captureCallback) {
        return new m1(captureCallback);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CameraCaptureSession.CaptureCallback e() {
        return this.f1848a;
    }
}
