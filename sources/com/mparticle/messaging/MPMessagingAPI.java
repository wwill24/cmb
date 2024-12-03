package com.mparticle.messaging;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.mparticle.MPService;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.internal.PushRegistrationHelper;
import com.mparticle.internal.b;
import n1.a;

public class MPMessagingAPI {
    @NonNull
    public static final String BROADCAST_NOTIFICATION_RECEIVED = "com.mparticle.push.RECEIVE";
    @NonNull
    public static final String BROADCAST_NOTIFICATION_TAPPED = "com.mparticle.push.TAP";
    @NonNull
    public static final String CLOUD_MESSAGE_EXTRA = "mp-push-message";
    private final Context mContext;

    private MPMessagingAPI() {
        this.mContext = null;
    }

    public void disablePushNotifications() {
        b.a(this.mContext).d();
    }

    public void displayPushNotificationByDefault(Boolean bool) {
        b.a(this.mContext).a(bool);
    }

    public void enablePushNotifications(@NonNull String str) {
        b.a(this.mContext).c(str);
        if (!MPUtility.isFirebaseAvailable()) {
            Logger.error("Push is enabled but Firebase Cloud Messaging library not found - you must add com.google.firebase:firebase-messaging:10.2.1 or later to your application.");
        } else if (!MPUtility.isServiceAvailable(this.mContext, MPService.class)) {
            Logger.error("Push is enabled but you have not added <service android:name=\"com.mparticle.MPService\" /> to the <application> section of your AndroidManifest.xml.");
        } else if (!MPUtility.checkPermission(this.mContext, "com.google.android.c2dm.permission.RECEIVE")) {
            Logger.error("Attempted to enable push notifications without required permission: ", "\"com.google.android.c2dm.permission.RECEIVE\".");
        } else {
            PushRegistrationHelper.requestInstanceId(this.mContext, str);
        }
    }

    public void registerPushAnalyticsReceiver(@NonNull PushAnalyticsReceiver pushAnalyticsReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_NOTIFICATION_RECEIVED);
        intentFilter.addAction(BROADCAST_NOTIFICATION_TAPPED);
        a.b(this.mContext).c(pushAnalyticsReceiver, intentFilter);
    }

    public void unregisterPushAnalyticsReceiver(PushAnalyticsReceiver pushAnalyticsReceiver) {
        a.b(this.mContext).e(pushAnalyticsReceiver);
    }

    public MPMessagingAPI(@NonNull Context context) {
        this.mContext = context;
    }
}
