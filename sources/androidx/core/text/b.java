package androidx.core.text;

import android.icu.util.ULocale;
import androidx.annotation.NonNull;
import java.util.Locale;

public final class b {

    static class a {
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    public static String a(@NonNull Locale locale) {
        return a.c(a.a(a.b(locale)));
    }
}
