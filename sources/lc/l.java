package lc;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.coffeemeetsbagel.bakery.Bakery;
import java.util.Locale;

public class l {
    public static boolean a(String str) {
        for (ApplicationInfo applicationInfo : Bakery.w().getPackageManager().getInstalledApplications(0)) {
            if (applicationInfo.packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static String b() {
        return Locale.getDefault().toString();
    }

    public static void c(Activity activity) {
        try {
            a.c(activity, new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + activity.getApplicationContext().getPackageName())));
        } catch (ActivityNotFoundException unused) {
            a.c(activity, new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + activity.getApplicationContext().getPackageName())));
        }
    }

    public static void d(Activity activity, String str) {
        Uri parse = Uri.parse("https://play.google.com/store/account/subscriptions");
        if (!TextUtils.isEmpty(str)) {
            parse = parse.buildUpon().appendQueryParameter("package", activity.getPackageName()).appendQueryParameter("sku", str).build();
        }
        a.c(activity, new Intent("android.intent.action.VIEW", parse));
    }

    public static boolean e() {
        if (((TelephonyManager) Bakery.w().getSystemService("phone")).getSimState() != 1) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        return b().toLowerCase().equals("en_us");
    }
}
