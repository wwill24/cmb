package j0;

import android.os.Build;
import androidx.camera.core.impl.q1;

public class c implements q1 {
    static boolean b() {
        if (!"XIAOMI".equalsIgnoreCase(Build.MANUFACTURER) || !"M2101K7AG".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }
}
