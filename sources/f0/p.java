package f0;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.video.q;

public class p implements s {
    private static boolean b() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "HMA-L29".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean c() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "LYA-AL00".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean d() {
        return "Vivo".equalsIgnoreCase(Build.BRAND) && "vivo 1820".equalsIgnoreCase(Build.MODEL);
    }

    static boolean e() {
        return b() || c() || d();
    }

    public boolean a(@NonNull q qVar) {
        if (b() || c()) {
            if (qVar == q.f3406d) {
                return true;
            }
            return false;
        } else if (!d()) {
            return false;
        } else {
            if (qVar == q.f3404b || qVar == q.f3405c) {
                return true;
            }
            return false;
        }
    }
}
