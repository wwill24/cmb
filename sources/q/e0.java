package q;

import android.os.Build;
import androidx.camera.core.impl.q1;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class e0 implements q1 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f17075a = Arrays.asList(new String[]{"mi a1", "mi a2", "mi a2 lite", "redmi 4x", "redmi 5a", "redmi 6 pro"});

    static boolean b() {
        return f17075a.contains(Build.MODEL.toLowerCase(Locale.US));
    }
}
