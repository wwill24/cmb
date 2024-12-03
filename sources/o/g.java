package o;

import android.hardware.camera2.CameraManager;
import androidx.annotation.NonNull;

public class g {
    public static void a(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        availabilityCallback.onCameraAccessPrioritiesChanged();
    }
}
