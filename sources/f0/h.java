package f0;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.video.q;

public class h implements s {
    private static boolean b() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-J400G".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean c() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-J710MN".equalsIgnoreCase(Build.MODEL) && Build.VERSION.SDK_INT >= 27;
    }

    private static boolean d() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-G610M".equalsIgnoreCase(Build.MODEL) && Build.VERSION.SDK_INT >= 27;
    }

    static boolean e() {
        return b() || d() || c();
    }

    public boolean a(@NonNull q qVar) {
        if (b()) {
            if (qVar == q.f3405c || qVar == q.f3406d) {
                return true;
            }
            return false;
        } else if (!d() && !c()) {
            return false;
        } else {
            if (qVar == q.f3405c) {
                return true;
            }
            return false;
        }
    }
}
