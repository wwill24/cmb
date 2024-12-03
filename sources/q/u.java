package q;

import android.os.Build;
import androidx.camera.core.impl.q1;
import java.util.Arrays;
import java.util.List;

public class u implements q1 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f17089a = Arrays.asList(new String[]{"Pixel 2", "Pixel 2 XL", "Pixel 3", "Pixel 3 XL"});

    static boolean b() {
        if (!f17089a.contains(Build.MODEL) || !"Google".equals(Build.MANUFACTURER) || Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return true;
    }
}
