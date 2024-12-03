package f0;

import android.os.Build;
import androidx.camera.core.impl.q1;
import java.util.Arrays;
import java.util.List;

public class g implements q1 {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f14632a = Arrays.asList(new String[]{"SM-N9208", "SM-G920V"});

    static boolean b() {
        if (f14632a.contains(Build.MODEL.toUpperCase())) {
            return true;
        }
        return false;
    }
}
