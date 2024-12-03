package com.clevertap.android.sdk.pushnotification;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import i4.x;

public class f {
    public static PendingIntent a(@NonNull Bundle bundle, @NonNull Context context) {
        Intent intent;
        if (!bundle.containsKey("wzrk_dl") || bundle.getString("wzrk_dl") == null) {
            intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (intent == null) {
                return null;
            }
        } else {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(bundle.getString("wzrk_dl")));
            x.w(context, intent);
        }
        intent.setFlags(872415232);
        intent.putExtras(bundle);
        intent.removeExtra("wzrk_acts");
        return PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 201326592);
    }

    public static PendingIntent b(@NonNull Bundle bundle, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return a(bundle, context);
        }
        Intent intent = new Intent(context, CTPushNotificationReceiver.class);
        intent.putExtras(bundle);
        intent.removeExtra("wzrk_acts");
        return PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, 201326592);
    }
}
