package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.NonNull;
import com.mparticle.kits.AppsFlyerKit;
import java.util.Locale;

public final class j {

    /* renamed from: b  reason: collision with root package name */
    private static final j f4636b = a(new Locale[0]);

    /* renamed from: a  reason: collision with root package name */
    private final k f4637a;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Locale[] f4638a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale equals : f4638a) {
                if (equals.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static boolean c(@NonNull Locale locale, @NonNull Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String a10 = androidx.core.text.b.a(locale);
            if (!a10.isEmpty()) {
                return a10.equals(androidx.core.text.b.a(locale2));
            }
            String country = locale.getCountry();
            if (country.isEmpty() || country.equals(locale2.getCountry())) {
                return true;
            }
            return false;
        }
    }

    static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private j(k kVar) {
        this.f4637a = kVar;
    }

    @NonNull
    public static j a(@NonNull Locale... localeArr) {
        return h(b.a(localeArr));
    }

    @NonNull
    public static j b(String str) {
        if (str == null || str.isEmpty()) {
            return d();
        }
        String[] split = str.split(AppsFlyerKit.COMMA, -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i10 = 0; i10 < length; i10++) {
            localeArr[i10] = a.a(split[i10]);
        }
        return a(localeArr);
    }

    @NonNull
    public static j d() {
        return f4636b;
    }

    @NonNull
    public static j h(@NonNull LocaleList localeList) {
        return new j(new l(localeList));
    }

    public Locale c(int i10) {
        return this.f4637a.get(i10);
    }

    public boolean e() {
        return this.f4637a.isEmpty();
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && this.f4637a.equals(((j) obj).f4637a);
    }

    public int f() {
        return this.f4637a.size();
    }

    @NonNull
    public String g() {
        return this.f4637a.a();
    }

    public int hashCode() {
        return this.f4637a.hashCode();
    }

    @NonNull
    public String toString() {
        return this.f4637a.toString();
    }
}
