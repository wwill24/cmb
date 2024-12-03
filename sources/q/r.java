package q;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.c0;

public class r implements f0 {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f17085a = Arrays.asList(new String[]{"PIXEL 3A", "PIXEL 3A XL"});

    static boolean b(@NonNull c0 c0Var) {
        if (!f17085a.contains(Build.MODEL.toUpperCase(Locale.US)) || ((Integer) c0Var.a(CameraCharacteristics.LENS_FACING)).intValue() != 1) {
            return false;
        }
        return true;
    }
}
