package androidx.core.os;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Locale;

public class a {
    protected static boolean a(@NonNull String str, @NonNull String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        if (str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) >= 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static boolean b() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean c() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33 || (i10 >= 32 && a("Tiramisu", Build.VERSION.CODENAME))) {
            return true;
        }
        return false;
    }
}
