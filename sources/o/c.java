package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.annotation.NonNull;

public class c {
    public static void a(@NonNull CameraCaptureSession.CaptureCallback captureCallback, @NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j10) {
        captureCallback.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j10);
    }
}
