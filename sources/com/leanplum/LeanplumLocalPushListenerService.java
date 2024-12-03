package com.leanplum;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.i;
import com.leanplum.internal.Constants;
import com.leanplum.internal.Log;

public class LeanplumLocalPushListenerService extends i {
    private static final String LP_CLASS_NAME = LeanplumLocalPushListenerService.class.getName();
    private static final int LP_JOB_ID = 1;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.putExtra(LeanplumJobStartReceiver.LP_EXTRA_SERVICE_CLASS, LP_CLASS_NAME);
        intent.putExtra(LeanplumJobStartReceiver.LP_EXTRA_JOB_ID, 1);
        intent.setClass(context, LeanplumJobStartReceiver.class);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onHandleWork(@NonNull Intent intent) {
        if (intent == null) {
            try {
                Log.e("The intent cannot be null", new Object[0]);
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        } else {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey(Constants.Keys.PUSH_MESSAGE_TEXT)) {
                LeanplumPushService.handleNotification(this, extras);
            }
        }
    }
}
