package com.leanplum;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.leanplum.internal.Constants;
import com.leanplum.internal.Log;
import java.util.HashMap;
import java.util.Map;

public class PushTracking {
    static final String CHANNEL_FCM = "FCM";
    static final String CHANNEL_FCM_SILENT_TRACK = "FCM_SILENT_TRACK";
    static final String CHANNEL_HMS = "HMS";
    static final String CHANNEL_MIPUSH = "MIPUSH";

    static boolean isFcmSilentPush(@NonNull Bundle bundle) {
        return CHANNEL_FCM_SILENT_TRACK.equals(bundle.getString(Constants.Keys.CHANNEL_INTERNAL_KEY));
    }

    public static void trackDelivery(@NonNull Context context, @NonNull Bundle bundle) {
        if (!Leanplum.isPushDeliveryTrackingEnabled()) {
            Log.d("Push delivery tracking is disabled for " + LeanplumPushService.getMessageId(bundle), new Object[0]);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.Keys.PUSH_METRIC_MESSAGE_ID, LeanplumPushService.getMessageId(bundle));
        String string = bundle.getString(Constants.Keys.PUSH_OCCURRENCE_ID);
        if (!TextUtils.isEmpty(string)) {
            hashMap.put(Constants.Keys.PUSH_METRIC_OCCURRENCE_ID, string);
        }
        String string2 = bundle.getString(Constants.Keys.PUSH_SENT_TIME);
        if (!TextUtils.isEmpty(string2)) {
            hashMap.put(Constants.Keys.PUSH_METRIC_SENT_TIME, string2);
        }
        String string3 = bundle.getString(Constants.Keys.CHANNEL_INTERNAL_KEY);
        if (!TextUtils.isEmpty(string3)) {
            hashMap.put("channel", string3);
        }
        hashMap.put(Constants.Keys.PUSH_METRIC_NOTIFICATIONS_ENABLED, Boolean.toString(LeanplumNotificationHelper.areNotificationsEnabled(context, bundle)));
        Leanplum.track(Constants.PUSH_DELIVERED_EVENT_NAME, (Map<String, ?>) hashMap);
    }

    public static void trackOpen(@NonNull Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.Keys.PUSH_METRIC_MESSAGE_ID, LeanplumPushService.getMessageId(bundle));
        String string = bundle.getString(Constants.Keys.PUSH_OCCURRENCE_ID);
        if (!TextUtils.isEmpty(string)) {
            hashMap.put(Constants.Keys.PUSH_METRIC_OCCURRENCE_ID, string);
        }
        String string2 = bundle.getString(Constants.Keys.PUSH_SENT_TIME);
        if (!TextUtils.isEmpty(string2)) {
            hashMap.put(Constants.Keys.PUSH_METRIC_SENT_TIME, string2);
        }
        String string3 = bundle.getString(Constants.Keys.CHANNEL_INTERNAL_KEY);
        if (!TextUtils.isEmpty(string3)) {
            hashMap.put("channel", string3);
        }
        Leanplum.track(Constants.PUSH_OPENED_EVENT_NAME, (Map<String, ?>) hashMap);
    }
}
