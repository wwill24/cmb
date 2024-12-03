package q;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.c0;

public class w implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f17091a = Arrays.asList(new String[]{"sm-a260f", "sm-j530f", "sm-j600g", "sm-j701f", "sm-g610f", "sm-j710mn"});

    static boolean b(@NonNull c0 c0Var) {
        if (!f17091a.contains(Build.MODEL.toLowerCase(Locale.US)) || ((Integer) c0Var.a(CameraCharacteristics.LENS_FACING)).intValue() != 1) {
            return false;
        }
        return true;
    }
}
