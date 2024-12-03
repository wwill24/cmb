package org.apache.commons.validator;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GenericTypeValidator implements Serializable {
    private static final Log LOG = LogFactory.getLog(GenericTypeValidator.class);
    private static final long serialVersionUID = 5487162314134261703L;

    public static Byte formatByte(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Byte(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Long formatCreditCard(String str) {
        if (GenericValidator.isCreditCard(str)) {
            return new Long(str);
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r5 = r1.parse(r5);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date formatDate(java.lang.String r5, java.util.Locale r6) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 2
            r2 = 3
            if (r6 == 0) goto L_0x0011
            java.text.DateFormat r2 = java.text.DateFormat.getDateInstance(r2, r6)     // Catch:{ ParseException -> 0x0033 }
            java.text.DateFormat r1 = java.text.DateFormat.getDateInstance(r1, r6)     // Catch:{ ParseException -> 0x0033 }
            goto L_0x0021
        L_0x0011:
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ ParseException -> 0x0033 }
            java.text.DateFormat r2 = java.text.DateFormat.getDateInstance(r2, r3)     // Catch:{ ParseException -> 0x0033 }
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ ParseException -> 0x0033 }
            java.text.DateFormat r1 = java.text.DateFormat.getDateInstance(r1, r3)     // Catch:{ ParseException -> 0x0033 }
        L_0x0021:
            r3 = 0
            r2.setLenient(r3)     // Catch:{ ParseException -> 0x0033 }
            r1.setLenient(r3)     // Catch:{ ParseException -> 0x0033 }
            java.util.Date r5 = r2.parse(r5)     // Catch:{ ParseException -> 0x002e }
        L_0x002c:
            r0 = r5
            goto L_0x0065
        L_0x002e:
            java.util.Date r5 = r1.parse(r5)     // Catch:{ ParseException -> 0x0033 }
            goto L_0x002c
        L_0x0033:
            r1 = move-exception
            org.apache.commons.logging.Log r2 = LOG
            boolean r3 = r2.isDebugEnabled()
            if (r3 == 0) goto L_0x0065
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Date parse failed value=["
            r3.append(r4)
            r3.append(r5)
            java.lang.String r5 = "], "
            r3.append(r5)
            java.lang.String r5 = "locale=["
            r3.append(r5)
            r3.append(r6)
            java.lang.String r5 = "] "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r5 = r3.toString()
            r2.debug(r5)
        L_0x0065:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.validator.GenericTypeValidator.formatDate(java.lang.String, java.util.Locale):java.util.Date");
    }

    public static Double formatDouble(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Double(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float formatFloat(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Float(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Integer formatInt(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Integer(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Long formatLong(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Long(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Short formatShort(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Short(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Byte formatByte(String str, Locale locale) {
        NumberFormat numberFormat;
        if (str != null) {
            if (locale != null) {
                numberFormat = NumberFormat.getNumberInstance(locale);
            } else {
                numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
            }
            numberFormat.setParseIntegerOnly(true);
            ParsePosition parsePosition = new ParsePosition(0);
            Number parse = numberFormat.parse(str, parsePosition);
            if (parsePosition.getErrorIndex() == -1 && parsePosition.getIndex() == str.length() && parse.doubleValue() >= -128.0d && parse.doubleValue() <= 127.0d) {
                return new Byte(parse.byteValue());
            }
        }
        return null;
    }

    public static Double formatDouble(String str, Locale locale) {
        NumberFormat numberFormat;
        if (str != null) {
            if (locale != null) {
                numberFormat = NumberFormat.getInstance(locale);
            } else {
                numberFormat = NumberFormat.getInstance(Locale.getDefault());
            }
            ParsePosition parsePosition = new ParsePosition(0);
            Number parse = numberFormat.parse(str, parsePosition);
            if (parsePosition.getErrorIndex() == -1 && parsePosition.getIndex() == str.length() && parse.doubleValue() >= -1.7976931348623157E308d && parse.doubleValue() <= Double.MAX_VALUE) {
                return new Double(parse.doubleValue());
            }
        }
        return null;
    }

    public static Float formatFloat(String str, Locale locale) {
        NumberFormat numberFormat;
        if (str != null) {
            if (locale != null) {
                numberFormat = NumberFormat.getInstance(locale);
            } else {
                numberFormat = NumberFormat.getInstance(Locale.getDefault());
            }
            ParsePosition parsePosition = new ParsePosition(0);
            Number parse = numberFormat.parse(str, parsePosition);
            if (parsePosition.getErrorIndex() == -1 && parsePosition.getIndex() == str.length() && parse.doubleValue() >= -3.4028234663852886E38d && parse.doubleValue() <= 3.4028234663852886E38d) {
                return new Float(parse.floatValue());
            }
        }
        return null;
    }

    public static Integer formatInt(String str, Locale locale) {
        NumberFormat numberFormat;
        if (str != null) {
            if (locale != null) {
                numberFormat = NumberFormat.getNumberInstance(locale);
            } else {
                numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
            }
            numberFormat.setParseIntegerOnly(true);
            ParsePosition parsePosition = new ParsePosition(0);
            Number parse = numberFormat.parse(str, parsePosition);
            if (parsePosition.getErrorIndex() == -1 && parsePosition.getIndex() == str.length() && parse.doubleValue() >= -2.147483648E9d && parse.doubleValue() <= 2.147483647E9d) {
                return new Integer(parse.intValue());
            }
        }
        return null;
    }

    public static Long formatLong(String str, Locale locale) {
        NumberFormat numberFormat;
        if (str != null) {
            if (locale != null) {
                numberFormat = NumberFormat.getNumberInstance(locale);
            } else {
                numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
            }
            numberFormat.setParseIntegerOnly(true);
            ParsePosition parsePosition = new ParsePosition(0);
            Number parse = numberFormat.parse(str, parsePosition);
            if (parsePosition.getErrorIndex() == -1 && parsePosition.getIndex() == str.length() && parse.doubleValue() >= -9.223372036854776E18d && parse.doubleValue() <= 9.223372036854776E18d) {
                return new Long(parse.longValue());
            }
        }
        return null;
    }

    public static Short formatShort(String str, Locale locale) {
        NumberFormat numberFormat;
        if (str != null) {
            if (locale != null) {
                numberFormat = NumberFormat.getNumberInstance(locale);
            } else {
                numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
            }
            numberFormat.setParseIntegerOnly(true);
            ParsePosition parsePosition = new ParsePosition(0);
            Number parse = numberFormat.parse(str, parsePosition);
            if (parsePosition.getErrorIndex() == -1 && parsePosition.getIndex() == str.length() && parse.doubleValue() >= -32768.0d && parse.doubleValue() <= 32767.0d) {
                return new Short(parse.shortValue());
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date formatDate(java.lang.String r6, java.lang.String r7, boolean r8) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x0069
            if (r7 == 0) goto L_0x0069
            int r1 = r7.length()
            if (r1 != 0) goto L_0x000c
            goto L_0x0069
        L_0x000c:
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0028 }
            r1.<init>(r7)     // Catch:{ ParseException -> 0x0028 }
            r2 = 0
            r1.setLenient(r2)     // Catch:{ ParseException -> 0x0028 }
            java.util.Date r1 = r1.parse(r6)     // Catch:{ ParseException -> 0x0028 }
            if (r8 == 0) goto L_0x0068
            int r2 = r7.length()     // Catch:{ ParseException -> 0x0026 }
            int r6 = r6.length()     // Catch:{ ParseException -> 0x0026 }
            if (r2 == r6) goto L_0x0068
            goto L_0x0069
        L_0x0026:
            r0 = move-exception
            goto L_0x002c
        L_0x0028:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x002c:
            org.apache.commons.logging.Log r2 = LOG
            boolean r3 = r2.isDebugEnabled()
            if (r3 == 0) goto L_0x0068
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Date parse failed value=["
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = "], "
            r3.append(r6)
            java.lang.String r4 = "pattern=["
            r3.append(r4)
            r3.append(r7)
            r3.append(r6)
            java.lang.String r6 = "strict=["
            r3.append(r6)
            r3.append(r8)
            java.lang.String r6 = "] "
            r3.append(r6)
            r3.append(r0)
            java.lang.String r6 = r3.toString()
            r2.debug(r6)
        L_0x0068:
            r0 = r1
        L_0x0069:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.validator.GenericTypeValidator.formatDate(java.lang.String, java.lang.String, boolean):java.util.Date");
    }
}
