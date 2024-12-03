package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

public final class k1 {
    @NonNull
    public static CameraUnavailableException a(@NonNull CameraAccessExceptionCompat cameraAccessExceptionCompat) {
        int d10 = cameraAccessExceptionCompat.d();
        int i10 = 5;
        if (d10 == 1) {
            i10 = 1;
        } else if (d10 == 2) {
            i10 = 2;
        } else if (d10 == 3) {
            i10 = 3;
        } else if (d10 == 4) {
            i10 = 4;
        } else if (d10 != 5) {
            if (d10 != 10001) {
                i10 = 0;
            } else {
                i10 = 6;
            }
        }
        return new CameraUnavailableException(i10, cameraAccessExceptionCompat);
    }
}
