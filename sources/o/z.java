package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.Executor;
import o.h;

class z implements h.a {

    /* renamed from: a  reason: collision with root package name */
    final CameraCaptureSession f16759a;

    /* renamed from: b  reason: collision with root package name */
    final Object f16760b;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final Handler f16761a;

        a(@NonNull Handler handler) {
            this.f16761a = handler;
        }
    }

    z(@NonNull CameraCaptureSession cameraCaptureSession, Object obj) {
        this.f16759a = (CameraCaptureSession) androidx.core.util.h.g(cameraCaptureSession);
        this.f16760b = obj;
    }

    static h.a d(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Handler handler) {
        return new z(cameraCaptureSession, new a(handler));
    }

    @NonNull
    public CameraCaptureSession a() {
        return this.f16759a;
    }

    public int b(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16759a.captureBurst(list, new h.b(executor, captureCallback), ((a) this.f16760b).f16761a);
    }

    public int c(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16759a.setRepeatingRequest(captureRequest, new h.b(executor, captureCallback), ((a) this.f16760b).f16761a);
    }
}
