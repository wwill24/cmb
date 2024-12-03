package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.List;
import o.h;
import o.m0;
import p.a;
import p.b;
import p.k;

class j0 extends i0 {
    j0(@NonNull CameraDevice cameraDevice, Object obj) {
        super(cameraDevice, obj);
    }

    static j0 e(@NonNull CameraDevice cameraDevice, @NonNull Handler handler) {
        return new j0(cameraDevice, new m0.a(handler));
    }

    public void a(@NonNull k kVar) throws CameraAccessExceptionCompat {
        m0.c(this.f16717a, kVar);
        h.c cVar = new h.c(kVar.a(), kVar.e());
        List<b> c10 = kVar.c();
        Handler handler = ((m0.a) androidx.core.util.h.g((m0.a) this.f16718b)).f16719a;
        a b10 = kVar.b();
        if (b10 != null) {
            try {
                InputConfiguration inputConfiguration = (InputConfiguration) b10.a();
                androidx.core.util.h.g(inputConfiguration);
                this.f16717a.createReprocessableCaptureSessionByConfigurations(inputConfiguration, k.h(c10), cVar, handler);
            } catch (CameraAccessException e10) {
                throw CameraAccessExceptionCompat.e(e10);
            }
        } else if (kVar.d() == 1) {
            this.f16717a.createConstrainedHighSpeedCaptureSession(m0.d(c10), cVar, handler);
        } else {
            this.f16717a.createCaptureSessionByOutputConfigurations(k.h(c10), cVar, handler);
        }
    }
}
