package x;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.q1;

public final class c implements q1 {
    private static boolean b() {
        return "HONOR".equalsIgnoreCase(Build.BRAND) && "STK-LX1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean c() {
        return "HUAWEI".equalsIgnoreCase(Build.BRAND) && "SNE-LX1".equalsIgnoreCase(Build.MODEL);
    }

    static boolean e() {
        return c() || b();
    }

    public boolean d(@NonNull Config.a<?> aVar) {
        return aVar != d0.f2485h;
    }
}
