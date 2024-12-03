package com.mparticle.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PushAnalyticsReceiver extends BroadcastReceiver implements PushAnalyticsReceiverCallback {
    public boolean onNotificationReceived(ProviderCloudMessage providerCloudMessage) {
        return false;
    }

    public boolean onNotificationTapped(ProviderCloudMessage providerCloudMessage) {
        return false;
    }

    public final void onReceive(Context context, Intent intent) {
        MPMessagingRouter.onReceive(context, intent, this);
    }
}
