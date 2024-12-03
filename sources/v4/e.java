package v4;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import com.clevertap.android.sdk.p;
import java.net.URLDecoder;
import org.json.b;

public final class e {
    public static Bundle a(String str, boolean z10) {
        if (str == null) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        try {
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            urlQuerySanitizer.parseUrl(str);
            for (String next : urlQuerySanitizer.getParameterSet()) {
                String e10 = e(next, urlQuerySanitizer, false);
                if (e10 != null) {
                    if (!z10) {
                        if (!next.equals("wzrk_c2a")) {
                            bundle.putString(next, URLDecoder.decode(e10, "UTF-8"));
                        }
                    }
                    bundle.putString(next, e10);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    public static b b(Uri uri) {
        b bVar = new b();
        try {
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.parseUrl(uri.toString());
            String c10 = c("source", urlQuerySanitizer);
            String c11 = c("medium", urlQuerySanitizer);
            String c12 = c("campaign", urlQuerySanitizer);
            bVar.put("us", (Object) c10);
            bVar.put("um", (Object) c11);
            bVar.put("uc", (Object) c12);
            String f10 = f("medium", urlQuerySanitizer);
            if (f10 != null && f10.matches("^email$|^social$|^search$")) {
                bVar.put("wm", (Object) f10);
            }
            p.a("Referrer data: " + bVar.toString(4));
        } catch (Throwable unused) {
        }
        return bVar;
    }

    private static String c(String str, UrlQuerySanitizer urlQuerySanitizer) {
        String d10 = d(str, urlQuerySanitizer);
        if (d10 == null && (d10 = f(str, urlQuerySanitizer)) == null) {
            return null;
        }
        return d10;
    }

    private static String d(String str, UrlQuerySanitizer urlQuerySanitizer) {
        return e("utm_" + str, urlQuerySanitizer, true);
    }

    private static String e(String str, UrlQuerySanitizer urlQuerySanitizer, boolean z10) {
        if (!(str == null || urlQuerySanitizer == null)) {
            try {
                String value = urlQuerySanitizer.getValue(str);
                if (value == null) {
                    return null;
                }
                if (!z10 || value.length() <= 120) {
                    return value;
                }
                return value.substring(0, 120);
            } catch (Throwable th2) {
                p.r("Couldn't parse the URI", th2);
            }
        }
        return null;
    }

    private static String f(String str, UrlQuerySanitizer urlQuerySanitizer) {
        return e("wzrk_" + str, urlQuerySanitizer, true);
    }
}
