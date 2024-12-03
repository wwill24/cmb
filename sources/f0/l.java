package f0;

import android.os.Build;
import androidx.camera.core.impl.q1;

public class l implements q1 {
    public static boolean b() {
        return "itel".equalsIgnoreCase(Build.BRAND) && "itel w6004".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean c() {
        return "positivo".equalsIgnoreCase(Build.BRAND) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }

    static boolean d() {
        return c() || b();
    }
}
