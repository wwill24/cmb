package q;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.q1;
import o.c0;

public class i implements q1 {
    static boolean b(@NonNull c0 c0Var) {
        Integer num = (Integer) c0Var.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }
}
