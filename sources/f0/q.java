package f0;

import android.os.Build;
import androidx.annotation.NonNull;

public class q implements s {
    private static boolean b() {
        return "positivo".equalsIgnoreCase(Build.BRAND) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }

    static boolean c() {
        return b();
    }

    public boolean a(@NonNull androidx.camera.video.q qVar) {
        if (!b() || qVar != androidx.camera.video.q.f3403a) {
            return false;
        }
        return true;
    }
}
