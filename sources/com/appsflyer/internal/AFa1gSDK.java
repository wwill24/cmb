package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;

final class AFa1gSDK {

    static final class AFa1vSDK {
        static final AFa1gSDK AFInAppEventType = new AFa1gSDK();
    }

    static final class AFa1xSDK {
        final String AFInAppEventType;
        final String AFKeystoreWrapper;
        final String values;

        AFa1xSDK(@NonNull String str, String str2, String str3) {
            this.AFKeystoreWrapper = str;
            this.values = str2;
            this.AFInAppEventType = str3;
        }
    }

    AFa1gSDK() {
    }

    private static boolean AFInAppEventParameterName(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    static AFa1xSDK AFInAppEventType(@NonNull Context context) {
        String str;
        String str2;
        String str3;
        String str4 = "unknown";
        String str5 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                Network[] allNetworks = connectivityManager.getAllNetworks();
                int length = allNetworks.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i10]);
                    if (!AFInAppEventParameterName(networkInfo)) {
                        i10++;
                    } else if (1 == networkInfo.getType()) {
                        str4 = "WIFI";
                    } else if (networkInfo.getType() == 0) {
                        str4 = "MOBILE";
                    }
                }
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager.getSimOperatorName();
            try {
                str2 = telephonyManager.getNetworkOperatorName();
                if ((str2 == null || str2.isEmpty()) && 2 == telephonyManager.getPhoneType()) {
                    str2 = "CDMA";
                }
            } catch (Throwable th2) {
                th = th2;
                String str6 = str;
                str3 = null;
                str5 = str6;
                AFLogger.afErrorLog("Exception while collecting network info. ", th);
                String str7 = str3;
                str = str5;
                str2 = str7;
                return new AFa1xSDK(str4, str2, str);
            }
        } catch (Throwable th3) {
            th = th3;
            str3 = null;
            AFLogger.afErrorLog("Exception while collecting network info. ", th);
            String str72 = str3;
            str = str5;
            str2 = str72;
            return new AFa1xSDK(str4, str2, str);
        }
        return new AFa1xSDK(str4, str2, str);
    }
}
