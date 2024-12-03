package q;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.q1;
import o.c0;

public class b implements q1 {
    static boolean b(@NonNull c0 c0Var) {
        if (!Build.BRAND.equalsIgnoreCase("SAMSUNG") || Build.VERSION.SDK_INT >= 33 || ((Integer) c0Var.a(CameraCharacteristics.LENS_FACING)).intValue() != 0) {
            return false;
        }
        return true;
    }
}
