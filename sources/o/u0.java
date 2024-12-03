package o;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.concurrent.Executor;

class u0 extends t0 {
    u0(@NonNull Context context) {
        super(context);
    }

    @NonNull
    public CameraCharacteristics b(@NonNull String str) throws CameraAccessExceptionCompat {
        try {
            return this.f16755a.getCameraCharacteristics(str);
        } catch (CameraAccessException e10) {
            throw CameraAccessExceptionCompat.e(e10);
        }
    }

    public void c(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        try {
            this.f16755a.openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e10) {
            throw CameraAccessExceptionCompat.e(e10);
        }
    }
}
