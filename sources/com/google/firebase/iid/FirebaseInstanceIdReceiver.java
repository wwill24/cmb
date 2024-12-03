package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.a;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;
import java.util.concurrent.ExecutionException;

public final class FirebaseInstanceIdReceiver extends a {
    private static final String TAG = "FirebaseMessaging";

    private static Intent createServiceIntent(@NonNull Context context, @NonNull String str, @NonNull Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    /* access modifiers changed from: protected */
    public int onMessageReceive(@NonNull Context context, @NonNull CloudMessage cloudMessage) {
        try {
            return ((Integer) Tasks.await(new FcmBroadcastProcessor(context).process(cloudMessage.S()))).intValue();
        } catch (InterruptedException | ExecutionException unused) {
            return 500;
        }
    }

    /* access modifiers changed from: protected */
    public void onNotificationDismissed(@NonNull Context context, @NonNull Bundle bundle) {
        Intent createServiceIntent = createServiceIntent(context, "com.google.firebase.messaging.NOTIFICATION_DISMISS", bundle);
        if (MessagingAnalytics.shouldUploadScionMetrics(createServiceIntent)) {
            MessagingAnalytics.logNotificationDismiss(createServiceIntent);
        }
    }
}
