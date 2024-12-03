package v4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class d {
    public static boolean a(@NonNull Context context) {
        try {
            String str = GooglePlayServicesUtil.GMS_ERROR_DIALOG;
            if (com.google.android.gms.common.d.h().i(context) == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean b(@NonNull Context context) {
        return d(context, "com.android.vending") || d(context, "com.google.market");
    }

    private static boolean c(Context context, Intent intent) {
        return (intent == null || context.getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private static boolean d(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean e(Context context) {
        try {
            if (!"xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
                return false;
            }
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.miui.ui.version.code"});
            if (str != null && !TextUtils.isEmpty(str.trim())) {
                return true;
            }
            if (c(context, new Intent("miui.intent.action.OP_AUTO_START").addCategory("android.intent.category.DEFAULT")) || c(context, new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"))) || c(context, new Intent("miui.intent.action.POWER_HIDE_MODE_APP_LIST").addCategory("android.intent.category.DEFAULT")) || c(context, new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.powercenter.PowerSettings")))) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
