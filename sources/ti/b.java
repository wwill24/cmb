package ti;

import android.content.res.Resources;
import java.util.Locale;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import net.bytebuddy.utility.JavaConstant;

public final class b {
    public static final double a(double d10) {
        return d10 * ((double) Resources.getSystem().getDisplayMetrics().density);
    }

    public static final String b(String str) {
        j.g(str, "<this>");
        Locale locale = Locale.US;
        j.f(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        j.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return new Regex("[- ]").f(lowerCase, JavaConstant.Dynamic.DEFAULT_NAME);
    }

    public static final double c(double d10) {
        return d10 / ((double) Resources.getSystem().getDisplayMetrics().density);
    }

    public static final double d(double d10) {
        return d10 * ((double) Resources.getSystem().getDisplayMetrics().scaledDensity);
    }
}
