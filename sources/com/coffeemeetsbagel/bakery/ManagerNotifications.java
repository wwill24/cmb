package com.coffeemeetsbagel.bakery;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.b;
import b2.g;
import b2.m;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.notifications.NotificationWorkManagerWorker;
import com.coffeemeetsbagel.models.constants.Extra;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.leanplum.LeanplumPushHandler;
import com.leanplum.internal.Constants;
import java.util.HashMap;
import r8.a;

public class ManagerNotifications extends a implements y8.a {

    /* renamed from: a  reason: collision with root package name */
    private static NotificationManager f11060a;

    public static void d() {
        try {
            f().cancelAll();
        } catch (SecurityException e10) {
            fa.a.i(e10);
        }
    }

    private b e(Intent intent) {
        Bundle extras = intent.getExtras();
        b.a aVar = new b.a();
        if (extras != null) {
            for (String next : extras.keySet()) {
                Object obj = extras.get(next);
                if (obj instanceof String) {
                    aVar.j(next, (String) obj);
                } else if (obj instanceof Integer) {
                    aVar.h(next, ((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    aVar.e(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Float) {
                    aVar.g(next, ((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    aVar.f(next, ((Double) obj).doubleValue());
                } else if (obj instanceof Long) {
                    aVar.i(next, ((Long) obj).longValue());
                }
            }
        }
        return aVar.a();
    }

    public static NotificationManager f() {
        if (f11060a == null) {
            f11060a = (NotificationManager) Bakery.w().getSystemService("notification");
        }
        return f11060a;
    }

    public void a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra(Extra.BAGEL_ID, str);
        intent.putExtra("title", Bakery.w().getApplicationContext().getString(R.string.chat_failed_push_title, new Object[]{str2}));
        intent.putExtra("message", Bakery.w().getApplicationContext().getString(R.string.chat_failed_push));
        g.a aVar = new g.a(NotificationWorkManagerWorker.class);
        aVar.j(e(intent));
        if (Build.VERSION.SDK_INT >= 31) {
            aVar.h(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST);
        }
        m.c(Bakery.w().getApplicationContext()).a(aVar.a());
        Bakery.w().z().d("Send Chat Failed Local Push");
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent = remoteMessage.toIntent();
        Bundle extras = intent.getExtras();
        HashMap hashMap = new HashMap();
        if (extras != null) {
            hashMap.put("cmb push id", extras.getString("cmb_push_id"));
            String parseMessageId = LeanplumPushHandler.parseMessageId(extras);
            hashMap.put(Constants.Keys.PUSH_MESSAGE_ID, parseMessageId);
            intent.putExtra(Constants.Keys.PUSH_MESSAGE_ID, parseMessageId);
        }
        if (Bakery.w().g().isLoggedIn() && !TextUtils.isEmpty(Bakery.w().g().getProfileId())) {
            hashMap.put("profile id", Bakery.w().g().getProfileId());
        }
        Bakery.w().z().trackEvent("Push Received", hashMap);
        Bakery.w().t().trackEvent("Push Received", hashMap);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("#push onReceive intent=");
        sb2.append(intent);
        if (extras == null || !extras.containsKey(Constants.Keys.PUSH_VERSION)) {
            if (extras != null && extras.containsKey("campaign")) {
                intent.putExtra("campaign", extras.getString("campaign"));
            }
            g.a aVar = new g.a(NotificationWorkManagerWorker.class);
            aVar.j(e(intent));
            if (Build.VERSION.SDK_INT >= 31) {
                aVar.h(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST);
            }
            m.c(Bakery.w().getApplicationContext()).a(aVar.a());
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("#push handing off to LeanplumPushHandler ");
        sb3.append(extras);
        LeanplumPushHandler.handleNotification(this, extras);
    }

    public void onNewToken(String str) {
        super.onNewToken(str);
        new com.coffeemeetsbagel.token.g(new com.coffeemeetsbagel.token.a(Bakery.w().K()), Bakery.w().M().a(), FirebaseMessaging.getInstance(), Bakery.w().g()).start();
    }
}
