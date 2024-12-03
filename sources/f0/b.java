package f0;

import android.os.Build;
import androidx.camera.core.impl.q1;

public class b implements q1 {
    private static boolean b() {
        return "Xiaomi".equalsIgnoreCase(Build.BRAND) && "Redmi 6A".equalsIgnoreCase(Build.MODEL);
    }

    static boolean c() {
        return b();
    }
}
