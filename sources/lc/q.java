package lc;

import android.app.Activity;
import android.location.LocationManager;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import java.util.Arrays;
import java.util.Locale;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f41115a = {"ABK", "AF", "AX", "AL", "DZ", "AS", "AD", "AO", "AI", "AG", "AR", "AM", "AW", "AU", "AT", "AZ", "BS", "BH", "BD", "BB", "BY", "BE", "BZ", "BJ", "BM", "BT", "BO", "BQ", "BA", "BW", "BR", "IO", "VG", "BN", "BG", "BF", "BI", "KH", "CM", "CA", "CV", "KY", "CF", "TD", "CL", "CN", "CX", "CC", "CO", "KM", "CG", "CD", "CK", "CR", "HR", "CU", "CW", "CY", "CZ", "DK", "DJ", "DM", "DO", "TL", "EC", "EG", "SV", "GQ", "ER", "EE", "ET", "FO", "FK", "FJ", "FI", "FR", "GF", "PF", "TF", "GA", "GM", "GE", "DE", "GH", "GI", "GR", "GL", "GD", "GP", "GU", "GT", "GG", "GN", "GW", "GY", "HT", "VA", "HN", "HK", "HU", "IS", "IN", "ID", "IR", "IQ", "IE", "IM", "IL", "IT", "CI", "JM", "JP", "JE", "JO", "KZ", "KE", "KI", "KOS", "KW", "KG", "LA", "LV", "LB", "LS", "LR", "LY", "LI", "LT", "LU", "MO", "MK", "MG", "MW", "MY", "MV", "ML", "MT", "MH", "MQ", "MR", "MU", "YT", "MX", "FM", "MD", "MC", "MN", "ME", "MS", "MA", "MZ", "MM", "NAG", "NA", "NR", "NP", "AN", "NL", "NC", "NZ", "NI", "NE", "NG", "NU", "NF", "KP", "NCY", "MP", "NO", "OM", "PK", "PW", "PS", "PA", "PG", "PY", "PE", "PH", "PN", "PL", "PT", "PR", "PUN", "QA", "RO", "RU", "RW", "RE", "BQ", "BL", "KN", "SH", "LC", "MF", "PM", "VC", "WS", "SM", "ST", "SA", "SN", "RS", "SC", "SL", "SG", "BQ", "SX", "SK", "SI", "SB", "SO", "SO", "ZA", "GS", "KR", "SOS", "SS", "ES", "LK", "SD", "SR", "SZ", "SE", "CH", "SY", "TW", "TJ", "TZ", "TH", "TG", "TK", "TO", "TRA", "TT", "TN", "TR", "TM", "TC", "TV", "UG", "UA", "AE", "GB", "GB", "US", "US", "US", "VI", "VI", "UY", "UZ", "VU", "VE", "VN", "WF", "EH", "YE", "ZM", "ZW"};

    public static int a(String str) {
        return Arrays.asList(f41115a).indexOf(str);
    }

    public static String b(int i10) {
        return f41115a[i10];
    }

    public static String c(String str) {
        int d10 = d(str);
        if (d10 != -1) {
            return b(d10);
        }
        if (a(str) != -1) {
            return str;
        }
        return null;
    }

    public static int d(String str) {
        return Arrays.asList(Bakery.w().getResources().getStringArray(R.array.country_names_array)).indexOf(str);
    }

    public static String e() {
        return Locale.getDefault().getCountry();
    }

    public static boolean f(Activity activity) {
        return ((LocationManager) activity.getSystemService("location")).isProviderEnabled("network");
    }
}
