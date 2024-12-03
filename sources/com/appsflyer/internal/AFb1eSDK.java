package com.appsflyer.internal;

import android.content.SharedPreferences;
import com.appsflyer.AFLogger;

public final class AFb1eSDK implements AFb1gSDK {
    private final SharedPreferences values;

    public AFb1eSDK(SharedPreferences sharedPreferences) {
        this.values = sharedPreferences;
    }

    public final void AFInAppEventParameterName(String str, String str2) {
        this.values.edit().putString(str, str2).apply();
    }

    public final void AFInAppEventType(String str, long j10) {
        this.values.edit().putLong(str, j10).apply();
    }

    public final void AFKeystoreWrapper(String str) {
        this.values.edit().remove(str).apply();
    }

    public final String valueOf(String str, String str2) {
        try {
            return this.values.getString(str, str2);
        } catch (ClassCastException e10) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e10);
            return str2;
        }
    }

    public final void AFInAppEventParameterName(String str, int i10) {
        this.values.edit().putInt(str, i10).apply();
    }

    public final int AFInAppEventType(String str, int i10) {
        try {
            return this.values.getInt(str, i10);
        } catch (ClassCastException e10) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e10);
            return i10;
        }
    }

    public final boolean valueOf(String str) {
        try {
            return this.values.getBoolean(str, false);
        } catch (ClassCastException e10) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e10);
            return false;
        }
    }

    public final void valueOf(String str, boolean z10) {
        this.values.edit().putBoolean(str, z10).apply();
    }

    public final long valueOf(String str, long j10) {
        try {
            return this.values.getLong(str, j10);
        } catch (ClassCastException e10) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e10);
            return j10;
        }
    }
}
