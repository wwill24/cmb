package q;

import android.os.Build;
import androidx.camera.core.impl.q1;
import java.util.Locale;

public class c0 implements q1 {
    static boolean b() {
        String str = Build.MANUFACTURER;
        Locale locale = Locale.US;
        if (!"SAMSUNG".equals(str.toUpperCase(locale)) || !Build.MODEL.toUpperCase(locale).startsWith("SM-A716")) {
            return false;
        }
        return true;
    }
}
