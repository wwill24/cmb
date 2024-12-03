package q;

import android.os.Build;
import androidx.camera.core.impl.q1;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class a0 implements q1 {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f17073a = Arrays.asList(new String[]{"sunfish", "bramble", "redfin", "barbet"});

    static boolean b() {
        if (!"Google".equals(Build.MANUFACTURER) || !f17073a.contains(Build.DEVICE.toLowerCase(Locale.getDefault()))) {
            return false;
        }
        return true;
    }
}
