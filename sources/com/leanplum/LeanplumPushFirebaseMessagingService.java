package com.leanplum;

import androidx.annotation.NonNull;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class LeanplumPushFirebaseMessagingService extends FirebaseMessagingService {
    private final LeanplumFirebaseServiceHandler handler = new LeanplumFirebaseServiceHandler();

    public void onCreate() {
        super.onCreate();
        this.handler.onCreate(getApplicationContext());
    }

    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        this.handler.onMessageReceived(remoteMessage, getApplicationContext());
    }

    public void onNewToken(@NonNull String str) {
        super.onNewToken(str);
        this.handler.onNewToken(str, getApplicationContext());
    }
}
