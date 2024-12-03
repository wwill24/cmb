package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.google.firebase.analytics.FirebaseAnalytics;

final class AFa1zSDK {
    private IntentFilter AFInAppEventType = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    static final class AFa1vSDK {
        static final AFa1zSDK AFKeystoreWrapper = new AFa1zSDK();
    }

    static final class AFa1wSDK {
        final float AFInAppEventParameterName;
        final String AFInAppEventType;

        AFa1wSDK(float f10, String str) {
            this.AFInAppEventParameterName = f10;
            this.AFInAppEventType = str;
        }
    }

    AFa1zSDK() {
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final AFa1wSDK values(Context context) {
        boolean z10;
        String str = null;
        float f10 = 0.0f;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, this.AFInAppEventType);
            if (registerReceiver != null) {
                if (2 == registerReceiver.getIntExtra("status", -1)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    if (intExtra == 1) {
                        str = "ac";
                    } else if (intExtra == 2) {
                        str = "usb";
                    } else if (intExtra != 4) {
                        str = "other";
                    } else {
                        str = "wireless";
                    }
                } else {
                    str = "no";
                }
                int intExtra2 = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
                int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra2 || -1 == intExtra3)) {
                    f10 = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
                }
            }
        } catch (Throwable th2) {
            AFLogger.afErrorLogForExcManagerOnly("Device that failed to register receiver", th2);
        }
        return new AFa1wSDK(f10, str);
    }
}
