package q;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.impl.q1;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class q implements q1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<Pair<String, String>> f17084a = new HashSet(Arrays.asList(new Pair[]{new Pair("sprd", "lemp")}));

    static boolean b() {
        Set<Pair<String, String>> set = f17084a;
        String str = Build.MANUFACTURER;
        Locale locale = Locale.US;
        return set.contains(new Pair(str.toLowerCase(locale), Build.MODEL.toLowerCase(locale)));
    }
}
