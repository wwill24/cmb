package com.mparticle.messaging;

public interface PushAnalyticsReceiverCallback {
    boolean onNotificationReceived(ProviderCloudMessage providerCloudMessage);

    boolean onNotificationTapped(ProviderCloudMessage providerCloudMessage);
}
