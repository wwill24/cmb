package p;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;

class h extends f {
    h(int i10, @NonNull Surface surface) {
        this(new OutputConfiguration(i10, surface));
    }

    static h j(@NonNull OutputConfiguration outputConfiguration) {
        return new h(outputConfiguration);
    }

    public void c(String str) {
        ((OutputConfiguration) f()).setPhysicalCameraId(str);
    }

    public String d() {
        return null;
    }

    @NonNull
    public Object f() {
        androidx.core.util.h.a(this.f16888a instanceof OutputConfiguration);
        return this.f16888a;
    }

    h(@NonNull Object obj) {
        super(obj);
    }
}
