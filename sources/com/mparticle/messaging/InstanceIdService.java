package com.mparticle.messaging;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.mparticle.internal.Logger;
import com.mparticle.internal.PushRegistrationHelper;

public class InstanceIdService extends FirebaseMessagingService {
    public void onNewToken(String str) {
        try {
            PushRegistrationHelper.requestInstanceId(getApplicationContext());
        } catch (Exception e10) {
            Logger.error("Error refreshing Instance ID: " + e10.getMessage());
        }
    }
}
