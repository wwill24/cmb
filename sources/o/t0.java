package o;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.concurrent.Executor;

class t0 extends v0 {
    t0(@NonNull Context context) {
        super(context, (Object) null);
    }

    static t0 h(@NonNull Context context) {
        return new t0(context);
    }

    private boolean i(@NonNull Throwable th2) {
        return Build.VERSION.SDK_INT == 28 && j(th2);
    }

    private static boolean j(@NonNull Throwable th2) {
        StackTraceElement[] stackTrace;
        if (!th2.getClass().equals(RuntimeException.class) || (stackTrace = th2.getStackTrace()) == null || stackTrace.length < 0) {
            return false;
        }
        return "_enableShutterSound".equals(stackTrace[0].getMethodName());
    }

    private void k(@NonNull Throwable th2) throws CameraAccessExceptionCompat {
        throw new CameraAccessExceptionCompat(10001, th2);
    }

    public void a(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.f16755a.registerAvailabilityCallback(executor, availabilityCallback);
    }

    @NonNull
    public CameraCharacteristics b(@NonNull String str) throws CameraAccessExceptionCompat {
        try {
            return super.b(str);
        } catch (RuntimeException e10) {
            if (i(e10)) {
                k(e10);
            }
            throw e10;
        }
    }

    public void c(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        try {
            this.f16755a.openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e10) {
            throw CameraAccessExceptionCompat.e(e10);
        } catch (IllegalArgumentException | SecurityException e11) {
            throw e11;
        } catch (RuntimeException e12) {
            if (i(e12)) {
                k(e12);
            }
            throw e12;
        }
    }

    public void e(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.f16755a.unregisterAvailabilityCallback(availabilityCallback);
    }
}
