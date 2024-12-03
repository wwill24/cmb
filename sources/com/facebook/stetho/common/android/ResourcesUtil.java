package com.facebook.stetho.common.android;

import android.content.res.Resources;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.stetho.common.LogUtil;
import com.google.firebase.sessions.settings.RemoteSettings;

public class ResourcesUtil {
    private ResourcesUtil() {
    }

    private static String getFallbackIdString(int i10) {
        return "#" + Integer.toHexString(i10);
    }

    public static String getIdString(Resources resources, int i10) throws Resources.NotFoundException {
        String str;
        if (resources == null) {
            return getFallbackIdString(i10);
        }
        String str2 = "";
        if (getResourcePackageId(i10) != 127) {
            str2 = resources.getResourcePackageName(i10);
            str = CertificateUtil.DELIMITER;
        } else {
            str = str2;
        }
        String resourceTypeName = resources.getResourceTypeName(i10);
        String resourceEntryName = resources.getResourceEntryName(i10);
        StringBuilder sb2 = new StringBuilder(str2.length() + 1 + str.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb2.append("@");
        sb2.append(str2);
        sb2.append(str);
        sb2.append(resourceTypeName);
        sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb2.append(resourceEntryName);
        return sb2.toString();
    }

    public static String getIdStringQuietly(Object obj, Resources resources, int i10) {
        try {
            return getIdString(resources, i10);
        } catch (Resources.NotFoundException unused) {
            String fallbackIdString = getFallbackIdString(i10);
            LogUtil.w("Unknown identifier encountered on " + obj + ": " + fallbackIdString);
            return fallbackIdString;
        }
    }

    private static int getResourcePackageId(int i10) {
        return (i10 >>> 24) & 255;
    }
}
