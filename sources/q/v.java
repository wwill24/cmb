package q;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.c0;

public class v implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f17090a = Arrays.asList(new String[]{"SM-G9300", "SM-G930R", "SM-G930A", "SM-G930V", "SM-G930T", "SM-G930U", "SM-G930P", "SM-SC02H", "SM-SCV33", "SM-G9350", "SM-G935R", "SM-G935A", "SM-G935V", "SM-G935T", "SM-G935U", "SM-G935P"});

    static boolean b(@NonNull c0 c0Var) {
        if (!f17090a.contains(Build.MODEL.toUpperCase(Locale.US)) || ((Integer) c0Var.a(CameraCharacteristics.LENS_FACING)).intValue() != 1) {
            return false;
        }
        return true;
    }
}
