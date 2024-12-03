package com.leanplum;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.i;
import com.leanplum.internal.Log;

public class LeanplumJobStartReceiver extends BroadcastReceiver {
    public static final String LP_EXTRA_JOB_ID = "com.leanplum.service_job_id";
    public static final String LP_EXTRA_SERVICE_CLASS = "com.leanplum.service_class";

    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getExtras() == null) {
                Log.d("Cannot enqueue work on JobIntentService, no extras in intent.", new Object[0]);
                return;
            }
            String stringExtra = intent.getStringExtra(LP_EXTRA_SERVICE_CLASS);
            int intExtra = intent.getIntExtra(LP_EXTRA_JOB_ID, 0);
            Class<?> cls = Class.forName(stringExtra);
            if (!i.class.isAssignableFrom(cls)) {
                Log.d("The service provided is not a type of JobIntentService.", new Object[0]);
                return;
            }
            intent.setClass(context, cls);
            i.enqueueWork(context, cls, intExtra, intent);
        } catch (Exception e10) {
            Log.exception(e10);
        }
    }
}
