package q;

import android.os.Build;
import androidx.annotation.NonNull;
import o.c0;
import x.d;

public final class g0 implements d {
    private static boolean b() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "MotoG3".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean c() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "SM-G532F".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean d() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "SM-J700F".equalsIgnoreCase(Build.MODEL);
    }

    static boolean e(@NonNull c0 c0Var) {
        return b() || c() || d();
    }
}
