package f0;

import android.os.Build;
import androidx.camera.core.impl.q1;

public class a implements q1 {
    private static boolean b() {
        return "Sony".equalsIgnoreCase(Build.BRAND) && "G3125".equalsIgnoreCase(Build.MODEL);
    }

    static boolean c() {
        return b();
    }
}
