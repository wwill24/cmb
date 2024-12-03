package com.clevertap.android.sdk.pushnotification.fcm;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.q;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import v4.d;

public class c implements d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CleverTapInstanceConfig f10720a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f10721b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.clevertap.android.sdk.pushnotification.c f10722c;

    /* renamed from: d  reason: collision with root package name */
    private q f10723d;

    class a implements OnCompleteListener<String> {
        a() {
        }

        public void onComplete(@NonNull Task<String> task) {
            String str = null;
            if (!task.isSuccessful()) {
                CleverTapInstanceConfig a10 = c.this.f10720a;
                a10.B("PushProvider", PushConstants.f10708a + "FCM token using googleservices.json failed", task.getException());
                c.this.f10722c.a((String) null, c.this.getPushType());
                return;
            }
            if (task.getResult() != null) {
                str = task.getResult();
            }
            CleverTapInstanceConfig a11 = c.this.f10720a;
            a11.A("PushProvider", PushConstants.f10708a + "FCM token using googleservices.json - " + str);
            c.this.f10722c.a(str, c.this.getPushType());
        }
    }

    public c(com.clevertap.android.sdk.pushnotification.c cVar, Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f10721b = context;
        this.f10720a = cleverTapInstanceConfig;
        this.f10722c = cVar;
        this.f10723d = q.h(context);
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return FirebaseApp.getInstance().getOptions().getGcmSenderId();
    }

    public PushConstants.PushType getPushType() {
        return PushConstants.PushType.FCM;
    }

    public boolean isAvailable() {
        try {
            if (!d.a(this.f10721b)) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f10720a;
                cleverTapInstanceConfig.A("PushProvider", PushConstants.f10708a + "Google Play services is currently unavailable.");
                return false;
            } else if (!TextUtils.isEmpty(c())) {
                return true;
            } else {
                CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f10720a;
                cleverTapInstanceConfig2.A("PushProvider", PushConstants.f10708a + "The FCM sender ID is not set. Unable to register for FCM.");
                return false;
            }
        } catch (Throwable th2) {
            CleverTapInstanceConfig cleverTapInstanceConfig3 = this.f10720a;
            cleverTapInstanceConfig3.B("PushProvider", PushConstants.f10708a + "Unable to register with FCM.", th2);
            return false;
        }
    }

    public boolean isSupported() {
        return d.b(this.f10721b);
    }

    public void requestToken() {
        try {
            CleverTapInstanceConfig cleverTapInstanceConfig = this.f10720a;
            cleverTapInstanceConfig.A("PushProvider", PushConstants.f10708a + "Requesting FCM token using googleservices.json");
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new a());
        } catch (Throwable th2) {
            CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f10720a;
            cleverTapInstanceConfig2.B("PushProvider", PushConstants.f10708a + "Error requesting FCM token", th2);
            this.f10722c.a((String) null, getPushType());
        }
    }
}
