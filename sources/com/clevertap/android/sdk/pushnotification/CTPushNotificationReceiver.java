package com.clevertap.android.sdk.pushnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.p;
import i4.x;

@Deprecated(since = "4.3.0")
public class CTPushNotificationReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent intent2;
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (extras.containsKey("wzrk_dl")) {
                    intent2 = new Intent("android.intent.action.VIEW", Uri.parse(intent.getStringExtra("wzrk_dl")));
                    x.w(context, intent2);
                } else {
                    intent2 = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                    if (intent2 == null) {
                        return;
                    }
                }
                CleverTapAPI.E(context, extras);
                intent2.setFlags(872415232);
                intent2.putExtras(extras);
                intent2.putExtra("wzrk_from", "CTPushNotificationReceiver");
                if (extras.containsKey("close_system_dialogs") && extras.getBoolean("close_system_dialogs")) {
                    context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                }
                context.startActivity(intent2);
                p.a("CTPushNotificationReceiver: handled notification: " + extras.toString());
            }
        } catch (Throwable th2) {
            p.r("CTPushNotificationReceiver: error handling notification", th2);
        }
    }
}
