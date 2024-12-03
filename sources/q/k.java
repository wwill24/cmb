package q;

import android.os.Build;
import androidx.camera.core.impl.q1;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class k implements q1 {

    /* renamed from: a  reason: collision with root package name */
    static final List<String> f17077a = Arrays.asList(new String[]{"SM-A3000", "SM-A3009", "SM-A300F", "SM-A300FU", "SM-A300G", "SM-A300H", "SM-A300M", "SM-A300X", "SM-A300XU", "SM-A300XZ", "SM-A300Y", "SM-A300YZ", "SM-J510FN", "5059X"});

    static boolean b() {
        return f17077a.contains(Build.MODEL.toUpperCase(Locale.US));
    }
}
