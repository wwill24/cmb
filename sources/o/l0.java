package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.core.util.h;
import p.k;

class l0 extends j0 {
    l0(@NonNull CameraDevice cameraDevice) {
        super((CameraDevice) h.g(cameraDevice), (Object) null);
    }

    public void a(@NonNull k kVar) throws CameraAccessExceptionCompat {
        SessionConfiguration sessionConfiguration = (SessionConfiguration) kVar.j();
        h.g(sessionConfiguration);
        try {
            this.f16717a.createCaptureSession(sessionConfiguration);
        } catch (CameraAccessException e10) {
            throw CameraAccessExceptionCompat.e(e10);
        }
    }
}
