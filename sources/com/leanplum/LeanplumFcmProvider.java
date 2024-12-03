package com.leanplum;

import com.leanplum.internal.Constants;
import com.leanplum.internal.Log;

class LeanplumFcmProvider extends LeanplumCloudMessagingProvider {
    /* access modifiers changed from: protected */
    public String getSharedPrefsPropertyName() {
        return Constants.Defaults.PROPERTY_FCM_TOKEN_ID;
    }

    public PushProviderType getType() {
        return PushProviderType.FCM;
    }

    public void unregister() {
        try {
            FirebaseUtilKt.unregister();
        } catch (Throwable th2) {
            Log.e("Error unregistering from FCM", th2);
        }
    }

    public void updateRegistrationId() {
        try {
            FirebaseUtilKt.updateRegistrationId(this);
        } catch (Throwable th2) {
            Log.e("Error getting FCM token", th2);
        }
    }
}
