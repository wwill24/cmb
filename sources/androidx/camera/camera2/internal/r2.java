package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.annotation.NonNull;
import java.util.List;
import o.h;

public interface r2 {

    public static abstract class a {
        /* access modifiers changed from: package-private */
        public void n(@NonNull r2 r2Var) {
        }

        /* access modifiers changed from: package-private */
        public void o(@NonNull r2 r2Var) {
        }

        public void p(@NonNull r2 r2Var) {
        }

        public void q(@NonNull r2 r2Var) {
        }

        /* access modifiers changed from: package-private */
        public void r(@NonNull r2 r2Var) {
        }

        /* access modifiers changed from: package-private */
        public void s(@NonNull r2 r2Var) {
        }

        /* access modifiers changed from: package-private */
        public void t(@NonNull r2 r2Var) {
        }

        /* access modifiers changed from: package-private */
        public void u(@NonNull r2 r2Var, @NonNull Surface surface) {
        }
    }

    @NonNull
    a c();

    void close();

    void d();

    void e() throws CameraAccessException;

    @NonNull
    CameraDevice f();

    int g(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int j(@NonNull List<CaptureRequest> list, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    @NonNull
    h k();

    void l() throws CameraAccessException;

    @NonNull
    zf.a<Void> m();
}
