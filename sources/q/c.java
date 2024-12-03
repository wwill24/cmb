package q;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.q1;
import o.c0;

public class c implements q1 {
    static boolean c(@NonNull c0 c0Var) {
        Integer num = (Integer) c0Var.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        return false;
    }

    public int b() {
        return 2;
    }
}
