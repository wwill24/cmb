package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.n;
import androidx.core.util.h;

final class l1 extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a  reason: collision with root package name */
    private final n f1842a;

    l1(n nVar) {
        if (nVar != null) {
            this.f1842a = nVar;
            return;
        }
        throw new NullPointerException("cameraCaptureCallback is null");
    }

    public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        a2 a2Var;
        super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        Object tag = captureRequest.getTag();
        if (tag != null) {
            h.b(tag instanceof a2, "The tagBundle object from the CaptureResult is not a TagBundle object.");
            a2Var = (a2) tag;
        } else {
            a2Var = a2.a();
        }
        this.f1842a.b(new e(a2Var, totalCaptureResult));
    }

    public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
        super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        this.f1842a.c(new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR));
    }
}
