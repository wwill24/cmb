package f0;

import android.os.Build;
import androidx.camera.core.impl.q1;

public class o implements q1 {
    private static boolean b() {
        if (!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) || !"HUAWEI ALE-L04".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean c() {
        return "OPPO".equalsIgnoreCase(Build.MANUFACTURER) && "A37F".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean d() {
        if (!"Samsung".equalsIgnoreCase(Build.MANUFACTURER) || !"sm-j111f".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean e() {
        if (!"Samsung".equalsIgnoreCase(Build.MANUFACTURER) || !"sm-j320f".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean f() {
        if (!"Samsung".equalsIgnoreCase(Build.MANUFACTURER) || !"sm-j700f".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    static boolean g() {
        if (b() || e() || f() || d() || c()) {
            return true;
        }
        return false;
    }
}
