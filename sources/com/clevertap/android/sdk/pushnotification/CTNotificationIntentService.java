package com.clevertap.android.sdk.pushnotification;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.p;
import i4.x;
import o4.a;
import o4.d;

@Deprecated(since = "4.3.0")
public class CTNotificationIntentService extends IntentService {
    public static final String MAIN_ACTION = "com.clevertap.PUSH_EVENT";
    public static final String TYPE_BUTTON_CLICK = "com.clevertap.ACTION_BUTTON_CLICK";
    private a mActionButtonClickHandler;

    public CTNotificationIntentService() {
        super("CTNotificationIntentService");
    }

    @SuppressLint({"MissingPermission"})
    private void handleActionButtonClick(Bundle bundle) {
        Intent intent;
        NotificationManager notificationManager;
        try {
            boolean z10 = bundle.getBoolean("autoCancel", false);
            int i10 = bundle.getInt("notificationId", -1);
            String string = bundle.getString("dl");
            Context applicationContext = getApplicationContext();
            if (!this.mActionButtonClickHandler.b(applicationContext, bundle, i10) && Build.VERSION.SDK_INT < 31) {
                if (string != null) {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(string));
                    x.w(applicationContext, intent);
                } else {
                    intent = applicationContext.getPackageManager().getLaunchIntentForPackage(applicationContext.getPackageName());
                }
                if (intent == null) {
                    p.o("CTNotificationService: create launch intent.");
                    return;
                }
                intent.setFlags(872415232);
                intent.putExtras(bundle);
                intent.removeExtra("dl");
                String string2 = bundle.getString("pt_dismiss_on_click", "");
                if (z10 && i10 > -1 && string2.isEmpty() && (notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification")) != null) {
                    notificationManager.cancel(i10);
                }
                sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                startActivity(intent);
            }
        } catch (Throwable th2) {
            p.o("CTNotificationService: unable to process action button click:  " + th2.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            d A = CleverTapAPI.A();
            if (!h.e(extras) || A == null) {
                this.mActionButtonClickHandler = (a) h.d();
            } else {
                this.mActionButtonClickHandler = (a) A;
            }
            if (TYPE_BUTTON_CLICK.equals(extras.getString("ct_type"))) {
                p.o("CTNotificationIntentService handling com.clevertap.ACTION_BUTTON_CLICK");
                handleActionButtonClick(extras);
                return;
            }
            p.o("CTNotificationIntentService: unhandled intent " + intent.getAction());
        }
    }
}
