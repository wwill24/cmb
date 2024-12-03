package q;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.q1;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.c0;

public class s implements q1 {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f17086a = Arrays.asList(new String[]{"sm-j700f", "sm-j710f"});

    static boolean b(@NonNull c0 c0Var) {
        if (!f17086a.contains(Build.MODEL.toLowerCase(Locale.US)) || ((Integer) c0Var.a(CameraCharacteristics.LENS_FACING)).intValue() != 0) {
            return false;
        }
        return true;
    }
}
