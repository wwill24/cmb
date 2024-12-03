package com.mparticle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.mparticle.messaging.MPMessagingAPI;
import com.mparticle.messaging.ProviderCloudMessage;

public class MPReceiver extends BroadcastReceiver {
    @NonNull
    public static final String MPARTICLE_IGNORE = "mparticle_ignore";

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                Class.forName("android.os.AsyncTask");
            } catch (ClassNotFoundException e10) {
                e10.printStackTrace();
            }
        }
    }

    public MPReceiver() {
        new Handler(Looper.getMainLooper()).post(new a());
    }

    /* access modifiers changed from: protected */
    public boolean onNotificationReceived(@NonNull ProviderCloudMessage providerCloudMessage) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onNotificationTapped(@NonNull ProviderCloudMessage providerCloudMessage) {
        return false;
    }

    public final void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (!MPARTICLE_IGNORE.equals(intent.getAction()) && !intent.getBooleanExtra(MPARTICLE_IGNORE, false)) {
            if (MPMessagingAPI.BROADCAST_NOTIFICATION_TAPPED.equalsIgnoreCase(intent.getAction())) {
                if (!onNotificationTapped((ProviderCloudMessage) intent.getParcelableExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA))) {
                    a0.a(context, intent);
                }
            } else if (!MPMessagingAPI.BROADCAST_NOTIFICATION_RECEIVED.equalsIgnoreCase(intent.getAction())) {
                a0.a(context, intent);
            } else if (!onNotificationReceived((ProviderCloudMessage) intent.getParcelableExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA))) {
                a0.a(context, intent);
            }
        }
    }
}
