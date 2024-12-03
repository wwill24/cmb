package com.mparticle.messaging;

import android.content.Context;
import android.content.Intent;
import com.mparticle.a0;

public class MPMessagingRouter {
    public static boolean onReceive(Context context, Intent intent, PushAnalyticsReceiverCallback pushAnalyticsReceiverCallback) {
        if (MPMessagingAPI.BROADCAST_NOTIFICATION_TAPPED.equalsIgnoreCase(intent.getAction())) {
            ProviderCloudMessage providerCloudMessage = (ProviderCloudMessage) intent.getParcelableExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA);
            if (!pushAnalyticsReceiverCallback.onNotificationTapped(providerCloudMessage)) {
                intent.putExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA, providerCloudMessage);
                a0.a(context, intent);
            }
            return true;
        } else if (!MPMessagingAPI.BROADCAST_NOTIFICATION_RECEIVED.equalsIgnoreCase(intent.getAction())) {
            return false;
        } else {
            ProviderCloudMessage providerCloudMessage2 = (ProviderCloudMessage) intent.getParcelableExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA);
            if (!pushAnalyticsReceiverCallback.onNotificationReceived(providerCloudMessage2)) {
                intent.putExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA, providerCloudMessage2);
                a0.a(context, intent);
            }
            return true;
        }
    }
}
