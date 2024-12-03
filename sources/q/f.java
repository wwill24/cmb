package q;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.c0;

public class f implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f17076a = Arrays.asList(new String[]{"SM-N9200", "SM-N9208", "SAMSUNG-SM-N920A", "SM-N920C", "SM-N920F", "SM-N920G", "SM-N920I", "SM-N920K", "SM-N920L", "SM-N920P", "SM-N920R4", "SM-N920R6", "SM-N920R7", "SM-N920S", "SM-N920T", "SM-N920V", "SM-N920W8", "SM-N920X", "SM-J510FN"});

    static boolean b(@NonNull c0 c0Var) {
        if (!f17076a.contains(Build.MODEL.toUpperCase(Locale.US)) || ((Integer) c0Var.a(CameraCharacteristics.LENS_FACING)).intValue() != 1) {
            return false;
        }
        return true;
    }
}
