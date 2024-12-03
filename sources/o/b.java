package o;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.annotation.NonNull;

public class b {
    public static void a(@NonNull CameraCaptureSession.StateCallback stateCallback, @NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
        stateCallback.onSurfacePrepared(cameraCaptureSession, surface);
    }
}
