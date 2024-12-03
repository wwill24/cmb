package org.apache.commons.validator;

import java.io.Serializable;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.CreditCardValidator;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.UrlValidator;

public class GenericValidator implements Serializable {
    private static final CreditCardValidator CREDIT_CARD_VALIDATOR = new CreditCardValidator();
    private static final UrlValidator URL_VALIDATOR = new UrlValidator();
    private static final long serialVersionUID = -7212095066891517618L;

    private static int adjustForLineEnding(String str, int i10) {
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < str.length(); i13++) {
            if (str.charAt(i13) == 10) {
                i11++;
            }
            if (str.charAt(i13) == 13) {
                i12++;
            }
        }
        return (i10 * i11) - (i12 + i11);
    }

    public static boolean isBlankOrNull(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isByte(String str) {
        return GenericTypeValidator.formatByte(str) != null;
    }

    public static boolean isCreditCard(String str) {
        return CREDIT_CARD_VALIDATOR.isValid(str);
    }

    public static boolean isDate(String str, Locale locale) {
        return DateValidator.getInstance().isValid(str, locale);
    }

    public static boolean isDouble(String str) {
        return GenericTypeValidator.formatDouble(str) != null;
    }

    public static boolean isEmail(String str) {
        return EmailValidator.getInstance().isValid(str);
    }

    public static boolean isFloat(String str) {
        return GenericTypeValidator.formatFloat(str) != null;
    }

    public static boolean isInRange(byte b10, byte b11, byte b12) {
        return b10 >= b11 && b10 <= b12;
    }

    public static boolean isInRange(double d10, double d11, double d12) {
        return d10 >= d11 && d10 <= d12;
    }

    public static boolean isInRange(float f10, float f11, float f12) {
        return f10 >= f11 && f10 <= f12;
    }

    public static boolean isInRange(int i10, int i11, int i12) {
        return i10 >= i11 && i10 <= i12;
    }

    public static boolean isInRange(long j10, long j11, long j12) {
        return j10 >= j11 && j10 <= j12;
    }

    public static boolean isInRange(short s10, short s11, short s12) {
        return s10 >= s11 && s10 <= s12;
    }

    public static boolean isInt(String str) {
        return GenericTypeValidator.formatInt(str) != null;
    }

    public static boolean isLong(String str) {
        return GenericTypeValidator.formatLong(str) != null;
    }

    public static boolean isShort(String str) {
        return GenericTypeValidator.formatShort(str) != null;
    }

    public static boolean isUrl(String str) {
        return URL_VALIDATOR.isValid(str);
    }

    public static boolean matchRegexp(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return false;
        }
        return Pattern.matches(str2, str);
    }

    public static boolean maxLength(String str, int i10) {
        return str.length() <= i10;
    }

    public static boolean maxValue(double d10, double d11) {
        return d10 <= d11;
    }

    public static boolean maxValue(float f10, float f11) {
        return f10 <= f11;
    }

    public static boolean maxValue(int i10, int i11) {
        return i10 <= i11;
    }

    public static boolean maxValue(long j10, long j11) {
        return j10 <= j11;
    }

    public static boolean minLength(String str, int i10) {
        return str.length() >= i10;
    }

    public static boolean minValue(double d10, double d11) {
        return d10 >= d11;
    }

    public static boolean minValue(float f10, float f11) {
        return f10 >= f11;
    }

    public static boolean minValue(int i10, int i11) {
        return i10 >= i11;
    }

    public static boolean minValue(long j10, long j11) {
        return j10 >= j11;
    }

    public static boolean isDate(String str, String str2, boolean z10) {
        return DateValidator.getInstance().isValid(str, str2, z10);
    }

    public static boolean maxLength(String str, int i10, int i11) {
        return str.length() + adjustForLineEnding(str, i11) <= i10;
    }

    public static boolean minLength(String str, int i10, int i11) {
        return str.length() + adjustForLineEnding(str, i11) >= i10;
    }
}
