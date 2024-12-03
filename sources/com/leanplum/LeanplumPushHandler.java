package com.leanplum;

import android.content.Context;
import android.os.Bundle;

public class LeanplumPushHandler {
    public static void handleNotification(Context context, Bundle bundle) {
        LeanplumPushService.handleNotification(context, bundle);
    }

    public static String parseMessageId(Bundle bundle) {
        return LeanplumPushService.getMessageId(bundle);
    }
}
