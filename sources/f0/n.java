package f0;

import android.os.Build;
import androidx.camera.core.impl.q1;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class n implements q1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f14633a = new HashSet(Arrays.asList(new String[]{"HWELE", "HW-02L", "HWVOG", "HWYAL", "HWLYA", "HWCOL", "HWPAR"}));

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f14634b = new HashSet(Arrays.asList(new String[]{"ELS-AN00", "ELS-TN00", "ELS-NX9", "ELS-N04"}));

    static boolean b() {
        if ("Huawei".equalsIgnoreCase(Build.MANUFACTURER)) {
            Set<String> set = f14633a;
            String str = Build.DEVICE;
            Locale locale = Locale.US;
            if (set.contains(str.toUpperCase(locale)) || f14634b.contains(Build.MODEL.toUpperCase(locale))) {
                return true;
            }
        }
        return false;
    }
}
