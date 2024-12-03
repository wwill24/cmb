package q;

import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.q1;
import androidx.camera.core.v1;
import com.coffeemeetsbagel.util.RequestCode;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class n implements q1 {
    @NonNull
    private List<Size> c(@NonNull String str, int i10) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && (i10 == 34 || i10 == 35)) {
            arrayList.add(new Size(720, 720));
            arrayList.add(new Size(400, 400));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> d(@NonNull String str, int i10) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && i10 == 256) {
            arrayList.add(new Size(4160, 3120));
            arrayList.add(new Size(4000, RequestCode.OVERFLOW_ACTIVITY));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> e(@NonNull String str, int i10) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && i10 == 256) {
            arrayList.add(new Size(4160, 3120));
            arrayList.add(new Size(4000, RequestCode.OVERFLOW_ACTIVITY));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> f(@NonNull String str, int i10) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0")) {
            if (i10 == 34) {
                arrayList.add(new Size(4128, 3096));
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            } else if (i10 == 35) {
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            }
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && (i10 == 34 || i10 == 35)) {
            arrayList.add(new Size(2576, 1932));
            arrayList.add(new Size(2560, 1440));
            arrayList.add(new Size(1920, 1920));
            arrayList.add(new Size(2048, 1536));
            arrayList.add(new Size(2048, 1152));
            arrayList.add(new Size(1920, 1080));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> g(@NonNull String str, int i10) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0")) {
            if (i10 == 34) {
                arrayList.add(new Size(4128, 3096));
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            } else if (i10 == 35) {
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            }
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && (i10 == 34 || i10 == 35)) {
            arrayList.add(new Size(3264, 2448));
            arrayList.add(new Size(3264, 1836));
            arrayList.add(new Size(2448, 2448));
            arrayList.add(new Size(1920, 1920));
            arrayList.add(new Size(2048, 1536));
            arrayList.add(new Size(2048, 1152));
            arrayList.add(new Size(1920, 1080));
        }
        return arrayList;
    }

    private static boolean h() {
        return "HUAWEI".equalsIgnoreCase(Build.BRAND) && "HWANE".equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean i() {
        return "OnePlus".equalsIgnoreCase(Build.BRAND) && "OnePlus6".equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean j() {
        return "OnePlus".equalsIgnoreCase(Build.BRAND) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean k() {
        String str = Build.BRAND;
        Locale locale = Locale.US;
        if (!"SAMSUNG".equalsIgnoreCase(str.toUpperCase(locale)) || !"J7XELTE".equalsIgnoreCase(Build.DEVICE.toUpperCase(locale)) || Build.VERSION.SDK_INT < 27) {
            return false;
        }
        return true;
    }

    private static boolean l() {
        String str = Build.BRAND;
        Locale locale = Locale.US;
        if (!"SAMSUNG".equalsIgnoreCase(str.toUpperCase(locale)) || !"ON7XELTE".equalsIgnoreCase(Build.DEVICE.toUpperCase(locale)) || Build.VERSION.SDK_INT < 27) {
            return false;
        }
        return true;
    }

    static boolean m() {
        if (i() || j() || h() || l() || k()) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<Size> b(@NonNull String str, int i10) {
        if (i()) {
            return d(str, i10);
        }
        if (j()) {
            return e(str, i10);
        }
        if (h()) {
            return c(str, i10);
        }
        if (l()) {
            return g(str, i10);
        }
        if (k()) {
            return f(str, i10);
        }
        v1.l("ExcludedSupportedSizesQuirk", "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.emptyList();
    }
}
