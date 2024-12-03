package org.bouncycastle.util;

import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;

public class IPAddress {
    private static boolean isMaskValue(String str, int i10) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt >= 0 && parseInt <= i10;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isValid(String str) {
        return isValidIPv4(str) || isValidIPv6(str);
    }

    public static boolean isValidIPv4(String str) {
        int indexOf;
        if (str.length() == 0) {
            return false;
        }
        String str2 = str + ".";
        int i10 = 0;
        int i11 = 0;
        while (i10 < str2.length() && (indexOf = str2.indexOf(46, i10)) > i10) {
            if (i11 == 4) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(str2.substring(i10, indexOf));
                if (parseInt >= 0 && parseInt <= 255) {
                    i10 = indexOf + 1;
                    i11++;
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return i11 == 4;
    }

    public static boolean isValidIPv4WithNetmask(String str) {
        int indexOf = str.indexOf(RemoteSettings.FORWARD_SLASH_STRING);
        String substring = str.substring(indexOf + 1);
        if (indexOf <= 0 || !isValidIPv4(str.substring(0, indexOf))) {
            return false;
        }
        return isValidIPv4(substring) || isMaskValue(substring, 32);
    }

    public static boolean isValidIPv6(String str) {
        int indexOf;
        if (str.length() == 0) {
            return false;
        }
        String str2 = str + CertificateUtil.DELIMITER;
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        while (i10 < str2.length() && (indexOf = str2.indexOf(58, i10)) >= i10) {
            if (i11 == 8) {
                return false;
            }
            if (i10 != indexOf) {
                String substring = str2.substring(i10, indexOf);
                if (indexOf != str2.length() - 1 || substring.indexOf(46) <= 0) {
                    try {
                        int parseInt = Integer.parseInt(str2.substring(i10, indexOf), 16);
                        if (parseInt >= 0 && parseInt <= 65535) {
                        }
                    } catch (NumberFormatException unused) {
                    }
                    return false;
                } else if (!isValidIPv4(substring)) {
                    return false;
                } else {
                    i11++;
                }
            } else if (indexOf != 1 && indexOf != str2.length() - 1 && z10) {
                return false;
            } else {
                z10 = true;
            }
            i10 = indexOf + 1;
            i11++;
        }
        return i11 == 8 || z10;
    }

    public static boolean isValidIPv6WithNetmask(String str) {
        int indexOf = str.indexOf(RemoteSettings.FORWARD_SLASH_STRING);
        String substring = str.substring(indexOf + 1);
        if (indexOf <= 0 || !isValidIPv6(str.substring(0, indexOf))) {
            return false;
        }
        return isValidIPv6(substring) || isMaskValue(substring, 128);
    }

    public static boolean isValidWithNetMask(String str) {
        return isValidIPv4WithNetmask(str) || isValidIPv6WithNetmask(str);
    }
}
