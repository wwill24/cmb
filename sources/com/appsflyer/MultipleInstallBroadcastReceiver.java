package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.appsflyer.internal.AFb1zSDK;

public class MultipleInstallBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            try {
                str = intent.getStringExtra("referrer");
            } catch (Throwable th2) {
                AFLogger.afErrorLog("error in BroadcastReceiver ", th2);
                str = null;
            }
            if (str == null || AFb1zSDK.AFInAppEventType(context).getString("referrer", (String) null) == null) {
                AFLogger.afInfoLog("MultipleInstallBroadcastReceiver called");
                AFb1zSDK.AFInAppEventType().values(context, intent);
                for (ResolveInfo next : context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.vending.INSTALL_REFERRER"), 0)) {
                    String action = intent.getAction();
                    if (next.activityInfo.packageName.equals(context.getPackageName()) && "com.android.vending.INSTALL_REFERRER".equals(action) && !getClass().getName().equals(next.activityInfo.name)) {
                        StringBuilder sb2 = new StringBuilder("trigger onReceive: class: ");
                        sb2.append(next.activityInfo.name);
                        AFLogger.afInfoLog(sb2.toString());
                        try {
                            ((BroadcastReceiver) Class.forName(next.activityInfo.name).newInstance()).onReceive(context, intent);
                        } catch (Throwable th3) {
                            StringBuilder sb3 = new StringBuilder("error in BroadcastReceiver ");
                            sb3.append(next.activityInfo.name);
                            AFLogger.afErrorLog(sb3.toString(), th3);
                        }
                    }
                }
                return;
            }
            AFb1zSDK.AFInAppEventType().AFInAppEventParameterName(context, str);
        }
    }
}
