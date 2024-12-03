package f0;

import android.os.Build;
import androidx.camera.core.impl.q1;

public class r implements q1 {
    static boolean b() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && Build.VERSION.SDK_INT < 29;
    }
}
