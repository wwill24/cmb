package q;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.c0;

public class t implements f0 {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f17087a = Arrays.asList(new String[]{"itel w6004"});

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f17088b = Arrays.asList(new String[]{"sm-j700f", "sm-j710f"});

    static boolean b(@NonNull c0 c0Var) {
        boolean z10;
        List<String> list = f17088b;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        if (!list.contains(str.toLowerCase(locale)) || ((Integer) c0Var.a(CameraCharacteristics.LENS_FACING)).intValue() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean contains = f17087a.contains(str.toLowerCase(locale));
        if (z10 || contains) {
            return true;
        }
        return false;
    }
}
