package com.clevertap.android.sdk.pushnotification.fcm;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import o4.c;

class b implements c<RemoteMessage> {
    b() {
    }

    /* renamed from: b */
    public Bundle a(@NonNull RemoteMessage remoteMessage) {
        try {
            Bundle bundle = new Bundle();
            for (Map.Entry next : remoteMessage.getData().entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            p.b("PushProvider", PushConstants.f10708a + "Found Valid Notification Message ");
            return bundle;
        } catch (Throwable th2) {
            th2.printStackTrace();
            p.c("PushProvider", PushConstants.f10708a + "Invalid Notification Message ", th2);
            return null;
        }
    }
}
