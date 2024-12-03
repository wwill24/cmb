package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.Executor;

class y extends z {
    y(@NonNull CameraCaptureSession cameraCaptureSession) {
        super(cameraCaptureSession, (Object) null);
    }

    public int b(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16759a.captureBurstRequests(list, executor, captureCallback);
    }

    public int c(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16759a.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }
}
