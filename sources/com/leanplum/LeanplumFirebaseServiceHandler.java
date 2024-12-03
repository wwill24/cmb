package com.leanplum;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.leanplum.internal.Constants;
import com.leanplum.internal.Log;
import com.leanplum.migration.MigrationManager;
import com.leanplum.migration.push.FcmMigrationHandler;
import java.util.Map;

public final class LeanplumFirebaseServiceHandler {
    private Bundle getBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
        }
        return bundle;
    }

    public void onCreate(Context context) {
        Leanplum.setApplicationContext(context);
    }

    public void onMessageReceived(RemoteMessage remoteMessage, Context context) {
        String str;
        try {
            Map<String, String> data = remoteMessage.getData();
            FcmMigrationHandler fcmHandler = MigrationManager.getWrapper().getFcmHandler();
            if (fcmHandler == null || !fcmHandler.getForwardingEnabled() || !fcmHandler.createNotification(context.getApplicationContext(), remoteMessage)) {
                if (data.containsKey(Constants.Keys.PUSH_MESSAGE_SILENT_TRACK)) {
                    str = "FCM_SILENT_TRACK";
                } else {
                    str = FirebaseMessaging.INSTANCE_ID_SCOPE;
                }
                if (data.containsKey(Constants.Keys.PUSH_MESSAGE_TEXT)) {
                    Bundle bundle = getBundle(data);
                    bundle.putString(Constants.Keys.CHANNEL_INTERNAL_KEY, str);
                    LeanplumPushService.handleNotification(context, bundle);
                }
                Log.i("Received push notification message: %s", data.toString());
                return;
            }
            Log.i("Push notification message forwarded to CleverTap SDK: %s", data.toString());
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public void onNewToken(String str, Context context) {
        LeanplumPushService.getPushProviders().setRegistrationId(PushProviderType.FCM, str);
        FcmMigrationHandler fcmHandler = MigrationManager.getWrapper().getFcmHandler();
        if (fcmHandler != null) {
            fcmHandler.onNewToken(context.getApplicationContext(), str);
        }
    }
}
