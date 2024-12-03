package f0;

import android.os.Build;
import androidx.camera.core.impl.q1;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class c implements q1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f14630a = new HashSet(Arrays.asList(new String[]{"samsungexynos7570", "samsungexynos7870", "qcom"}));

    static boolean b() {
        if (!"SAMSUNG".equalsIgnoreCase(Build.BRAND) || !f14630a.contains(Build.HARDWARE.toLowerCase())) {
            return false;
        }
        return true;
    }
}
