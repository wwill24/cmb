package com.leanplum.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.leanplum.Leanplum;
import com.leanplum.LeanplumPushService;

public class LeanplumManifestHelper {
    public static boolean disableComponent(Context context, PackageManager packageManager, String str) {
        if (!(context == null || packageManager == null || str == null)) {
            try {
                packageManager.setComponentEnabledSetting(new ComponentName(context, str), 2, 1);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean enableComponent(Context context, PackageManager packageManager, Class cls) {
        if (!(cls == null || context == null || packageManager == null)) {
            try {
                packageManager.setComponentEnabledSetting(new ComponentName(context, cls), 1, 1);
                return true;
            } catch (Throwable unused) {
                Log.i("Could not enable component: %s", cls.getName());
            }
        }
        return false;
    }

    public static boolean enableServiceAndStart(Context context, PackageManager packageManager, Class cls) {
        if (!enableComponent(context, packageManager, cls)) {
            return false;
        }
        try {
            context.startService(new Intent(context, cls));
            return true;
        } catch (Throwable unused) {
            Log.i("Could not start service for class: %s", cls.getName());
            return false;
        }
    }

    public static Class getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String parseNotificationMetadata() {
        try {
            Context context = Leanplum.getContext();
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(LeanplumPushService.LEANPLUM_NOTIFICATION);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r2 = r3.getComponentEnabledSetting(new android.content.ComponentName(r2, r4));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean wasComponentEnabled(android.content.Context r2, android.content.pm.PackageManager r3, java.lang.Class r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0019
            if (r2 == 0) goto L_0x0019
            if (r3 != 0) goto L_0x0008
            goto L_0x0019
        L_0x0008:
            android.content.ComponentName r1 = new android.content.ComponentName
            r1.<init>(r2, r4)
            int r2 = r3.getComponentEnabledSetting(r1)
            if (r2 == 0) goto L_0x0019
            r3 = 2
            if (r3 != r2) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r2 = 1
            return r2
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.LeanplumManifestHelper.wasComponentEnabled(android.content.Context, android.content.pm.PackageManager, java.lang.Class):boolean");
    }
}
