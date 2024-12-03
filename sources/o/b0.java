package o;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import o.c0;

class b0 implements c0.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    protected final CameraCharacteristics f16677a;

    b0(@NonNull CameraCharacteristics cameraCharacteristics) {
        this.f16677a = cameraCharacteristics;
    }

    public <T> T a(@NonNull CameraCharacteristics.Key<T> key) {
        return this.f16677a.get(key);
    }
}
