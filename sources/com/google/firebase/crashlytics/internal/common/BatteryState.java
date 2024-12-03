package com.google.firebase.crashlytics.internal.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.Logger;

class BatteryState {
    static final int VELOCITY_CHARGING = 2;
    static final int VELOCITY_FULL = 3;
    static final int VELOCITY_UNPLUGGED = 1;
    private final Float level;
    private final boolean powerConnected;

    private BatteryState(Float f10, boolean z10) {
        this.powerConnected = z10;
        this.level = f10;
    }

    public static BatteryState get(Context context) {
        Float f10 = null;
        boolean z10 = false;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z10 = isPowerConnected(registerReceiver);
                f10 = getLevel(registerReceiver);
            }
        } catch (IllegalStateException e10) {
            Logger.getLogger().e("An error occurred getting battery state.", e10);
        }
        return new BatteryState(f10, z10);
    }

    private static Float getLevel(Intent intent) {
        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(((float) intExtra) / ((float) intExtra2));
    }

    public Float getBatteryLevel() {
        return this.level;
    }

    public int getBatteryVelocity() {
        Float f10;
        if (!this.powerConnected || (f10 = this.level) == null) {
            return 1;
        }
        if (((double) f10.floatValue()) < 0.99d) {
            return 2;
        }
        return 3;
    }

    /* access modifiers changed from: package-private */
    public boolean isPowerConnected() {
        return this.powerConnected;
    }

    private static boolean isPowerConnected(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }
}
