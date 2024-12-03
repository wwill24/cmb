package com.leanplum;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.leanplum.internal.LeanplumManifestHelper;
import com.leanplum.internal.Log;

public class LeanplumPushReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            try {
                Log.e("Received a null intent.", new Object[0]);
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        } else {
            String parseNotificationMetadata = LeanplumManifestHelper.parseNotificationMetadata();
            if (parseNotificationMetadata == null) {
                Log.d("Custom broadcast receiver class not set, using default one.", new Object[0]);
                LeanplumPushService.openNotification(context, intent);
                return;
            }
            Log.d("Custom broadcast receiver class found, using it to handle push notifications.", new Object[0]);
            Intent intent2 = new Intent();
            intent2.setAction(LeanplumPushService.LEANPLUM_NOTIFICATION);
            intent2.setClassName(context, parseNotificationMetadata);
            intent2.putExtras(intent.getExtras());
            context.sendBroadcast(intent2);
        }
    }
}
