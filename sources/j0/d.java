package j0;

import android.os.Build;
import androidx.camera.core.impl.q1;

public class d implements q1 {
    private static boolean b() {
        if (!"LENOVO".equalsIgnoreCase(Build.MANUFACTURER) || !"Q706F".equalsIgnoreCase(Build.DEVICE)) {
            return false;
        }
        return true;
    }

    private static boolean c() {
        if (!"OPPO".equalsIgnoreCase(Build.MANUFACTURER) || !"OP4E75L1".equalsIgnoreCase(Build.DEVICE)) {
            return false;
        }
        return true;
    }

    private static boolean d() {
        if ("SAMSUNG".equalsIgnoreCase(Build.MANUFACTURER)) {
            String str = Build.DEVICE;
            if ("F2Q".equalsIgnoreCase(str) || "Q2Q".equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    static boolean e() {
        if (Build.VERSION.SDK_INT >= 33 || (!d() && !c() && !b())) {
            return false;
        }
        return true;
    }
}
