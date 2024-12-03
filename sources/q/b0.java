package q;

import android.os.Build;
import androidx.camera.core.impl.q1;

public class b0 implements q1 {
    public static boolean b() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL);
    }

    static boolean c() {
        return b();
    }
}
