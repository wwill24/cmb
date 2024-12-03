package com.mparticle.kits;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.mparticle.MParticle;
import com.mparticle.internal.MPUtility;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public final class KitUtils {
    @TargetApi(3)
    public static String getAndroidID(Context context) {
        if (!MParticle.isAndroidIdDisabled()) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        return null;
    }

    public static BigInteger hashFnv1a(byte[] bArr) {
        return MPUtility.hashFnv1A(bArr);
    }

    public static int hashForFiltering(String str) {
        return MPUtility.mpHash(str);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return MPUtility.isEmpty(charSequence);
    }

    public static boolean isServiceAvailable(Context context, Class<?> cls) {
        if (context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0) {
            return true;
        }
        return false;
    }

    public static String join(List<String> list) {
        return join(list, AppsFlyerKit.COMMA);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r1 = r1.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean parseBooleanSetting(java.util.Map<java.lang.String, java.lang.String> r1, java.lang.String r2, boolean r3) {
        /*
            if (r1 == 0) goto L_0x0025
            boolean r0 = r1.containsKey(r2)
            if (r0 == 0) goto L_0x0025
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0025
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0025
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0025:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.KitUtils.parseBooleanSetting(java.util.Map, java.lang.String, boolean):boolean");
    }

    public static String sanitizeAttributeKey(String str) {
        if (!MPUtility.isEmpty((CharSequence) str) && str.startsWith("$")) {
            return str.substring(1);
        }
        return str;
    }

    public static String join(List<String> list, String str) {
        if (list == null || str == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String append : list) {
            sb2.append(append);
            sb2.append(str);
        }
        if (sb2.length() > 0) {
            return sb2.substring(0, sb2.length() - str.length());
        }
        return sb2.toString();
    }

    public static boolean parseBooleanSetting(Map<String, String> map, String str) {
        return parseBooleanSetting(map, str, false);
    }
}
