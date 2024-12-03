package com.clevertap.android.sdk.pushnotification.fcm;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.h;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.messaging.RemoteMessage;
import o4.c;

public class a {
    private final c<RemoteMessage> mParser;

    public a() {
        this(new b());
    }

    public boolean createNotification(Context context, RemoteMessage remoteMessage) {
        Bundle a10 = this.mParser.a(remoteMessage);
        if (a10 == null) {
            return false;
        }
        a10.putString("wzrk_pn_h", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        if (!a10.containsKey("nh_source")) {
            a10.putString("nh_source", "FcmMessageListenerService");
        }
        return h.d().c(context, a10, PushConstants.PushType.FCM.toString());
    }

    public boolean onNewToken(Context context, String str) {
        try {
            h.d().a(context, str, PushConstants.PushType.FCM.h());
            p.b("PushProvider", PushConstants.f10708a + "New token received from FCM - " + str);
            return true;
        } catch (Throwable th2) {
            p.c("PushProvider", PushConstants.f10708a + "Error onNewToken", th2);
            return false;
        }
    }

    a(c<RemoteMessage> cVar) {
        this.mParser = cVar;
    }

    public void processPushAmp(Context context, @NonNull RemoteMessage remoteMessage) {
        Bundle a10 = this.mParser.a(remoteMessage);
        if (a10 != null) {
            CleverTapAPI.R(context, a10);
        }
    }
}
