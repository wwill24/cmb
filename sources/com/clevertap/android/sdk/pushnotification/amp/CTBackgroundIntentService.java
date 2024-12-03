package com.clevertap.android.sdk.pushnotification.amp;

import android.app.IntentService;
import android.content.Intent;
import com.clevertap.android.sdk.CleverTapAPI;

public class CTBackgroundIntentService extends IntentService {
    public CTBackgroundIntentService() {
        super("CTBackgroundIntentService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        CleverTapAPI.Z(getApplicationContext());
    }
}
