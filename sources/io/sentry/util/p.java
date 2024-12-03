package io.sentry.util;

import io.sentry.SentryLevel;
import io.sentry.h0;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f31726a = Charset.forName("UTF-8");

    public static String a(String str, h0 h0Var) {
        if (str != null && !str.isEmpty()) {
            try {
                return new StringBuilder(new BigInteger(1, MessageDigest.getInstance("SHA-1").digest(str.getBytes(f31726a))).toString(16)).toString();
            } catch (NoSuchAlgorithmException e10) {
                h0Var.b(SentryLevel.INFO, "SHA-1 isn't available to calculate the hash.", e10);
            } catch (Throwable th2) {
                h0Var.c(SentryLevel.INFO, "string: %s could not calculate its hash", th2, str);
            }
        }
        return null;
    }

    public static String b(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        String substring = str.substring(0, 1);
        Locale locale = Locale.ROOT;
        sb2.append(substring.toUpperCase(locale));
        sb2.append(str.substring(1).toLowerCase(locale));
        return sb2.toString();
    }

    public static String c(String str) {
        int i10;
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0 || str.length() <= (i10 = lastIndexOf + 1)) {
            return str;
        }
        return str.substring(i10);
    }

    public static String d(String str) {
        return str.equals("0000-0000") ? "00000000-0000-0000-0000-000000000000" : str;
    }

    public static String e(String str, String str2) {
        if (str == null || str2 == null || !str.startsWith(str2) || !str.endsWith(str2)) {
            return str;
        }
        return str.substring(str2.length(), str.length() - str2.length());
    }
}
