package com.coffeemeetsbagel.models.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateFormat;
import androidx.collection.f;
import com.coffeemeetsbagel.models.R;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import fa.a;
import j$.time.LocalDateTime;
import j$.time.OffsetDateTime;
import j$.time.ZoneId;
import j$.time.format.DateTimeFormatter;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_PATTERN_FRIENDLY_LONG_MONTH = "MMMM d, yyyy";
    public static final String DATE_PATTERN_FRIENDLY_SHORT_MONTH = "MMM d, yyyy";
    public static final String DATE_PATTERN_NUMBERS_SLASHES_DEFAULT = "MM/dd/yyyy";
    public static final String DATE_PATTERN_NUMBERS_SLASHES_NON_US = "dd/MM/yyyy";
    public static final String DATE_PATTERN_NUMBERS_SLASHES_SHORT = "MM/dd";
    public static final String DATE_PATTERN_NUMBERS_SLASHES_SHORT_NON_US = "dd/MM";
    public static final String DATE_WITH_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_WITH_TIME_PATTERN_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_WITH_TIME_PATTERN_ISO_8601_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String DATE_WITH_TIME_PATTERN_ISO_8601_Z_MS = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_WITH_TIME_PATTERN_MS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final long HOURS_IN_DAY = 24;
    private static final int MAX_NUM_TIMESTAMPS_CACHED_BLOCKING = 200;
    private static final int MAX_NUM_TIMESTAMPS_CACHED_NON_BLOCKING = 300;
    public static final long MILLIS_IN_DAY = 86400000;
    public static final long MILLIS_IN_HOUR = 3600000;
    public static final long MILLIS_IN_MINUTE = 60000;
    public static final long MILLIS_IN_SEC = 1000;
    public static final long MILLIS_IN_WEEK = 604800000;
    public static final long MIN_IN_HOUR = 60;
    public static final long SEC_IN_HOUR = 3600;
    public static final long SEC_IN_MINUTE = 60;
    public static final String TIME_PATTERN_NO_SECONDS = "h:mma";
    private static final int USE_PLURAL_THRESHOLD = 1;
    private static final String UTC_TIMEZONE_STRING = "UTC";
    private static final Map<String, SimpleDateFormat> dateFormatCacheBlocking = new HashMap();
    private static final Map<String, SimpleDateFormat> dateFormatCacheNonBlocking = new HashMap();
    private static final f<String, Long> parsedUtcTimestampCacheBlocking = new f<>(200);
    private static final f<String, Long> parsedUtcTimestampCacheNonBlocking = new f<>(300);

    public static int getAgeFromBirthday(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Date parse = new SimpleDateFormat(DATE_PATTERN, Locale.getDefault()).parse(str);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTime(parse);
                int i10 = gregorianCalendar.get(1);
                int i11 = gregorianCalendar.get(2);
                int i12 = gregorianCalendar.get(5);
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                gregorianCalendar2.setTimeInMillis(System.currentTimeMillis());
                int i13 = gregorianCalendar2.get(1);
                int i14 = gregorianCalendar2.get(2);
                int i15 = gregorianCalendar2.get(5);
                int i16 = i13 - i10;
                if (i14 < i11 || (i14 == i11 && i15 < i12)) {
                    return i16 - 1;
                }
                return i16;
            } catch (ParseException unused) {
            }
        }
        return -1;
    }

    public static Calendar getCalendarFromStringDate(String str) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeZone(DesugarTimeZone.getTimeZone(UTC_TIMEZONE_STRING));
        gregorianCalendar.setTimeInMillis(getMillisFromUtc(str).longValue());
        return gregorianCalendar;
    }

    public static String getCountdownTimerFromSeconds(int i10) {
        String str;
        String str2;
        String str3;
        long j10 = (long) i10;
        long j11 = j10 % 60;
        long j12 = (j10 / 60) % 60;
        long j13 = j10 / SEC_IN_HOUR;
        if (j11 < 10) {
            str = "0" + String.valueOf(j11);
        } else {
            str = String.valueOf(j11);
        }
        if (j12 < 10) {
            str2 = "0" + String.valueOf(j12);
        } else {
            str2 = String.valueOf(j12);
        }
        if (j13 < 10) {
            str3 = "0" + String.valueOf(j13);
        } else {
            str3 = String.valueOf(j13);
        }
        return str3 + CertificateUtil.DELIMITER + str2 + CertificateUtil.DELIMITER + str;
    }

    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    public static Date getDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new Date(getMillisFromUtc(str).longValue());
    }

    public static Date getDateFromMongooseTimestamp(String str) {
        return getDateWithPattern(str, DATE_WITH_TIME_PATTERN_ISO_8601_Z_MS);
    }

    public static Date getDateWithPattern(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static String getDaysUntilExpiration(long j10, Resources resources) {
        StringBuilder sb2 = new StringBuilder();
        long j11 = j10 / 86400000;
        sb2.append(j11);
        sb2.append(" ");
        if (j11 > 1) {
            sb2.append(resources.getString(R.string.days));
        } else {
            sb2.append(resources.getString(R.string.day));
        }
        return sb2.toString();
    }

    public static String getFormattedDate(Date date, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(date);
    }

    public static String getFormattedLocalDate(String str, String str2, String str3) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(UTC_TIMEZONE_STRING));
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e10) {
            a.i(e10);
            date = null;
        }
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        if (isUsingUSDatePatternOnNonUSDevice(str3)) {
            str3 = DATE_PATTERN_NUMBERS_SLASHES_NON_US;
        }
        return new SimpleDateFormat(str3, Locale.getDefault()).format(date);
    }

    public static String getFormattedTimestampThreeDaysPrior() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -3);
        instance.getTime();
        return getFormattedUtcDate(instance.getTime(), DATE_WITH_TIME_PATTERN_ISO_8601_Z_MS);
    }

    public static String getFormattedUtcDate(Date date, String str) {
        if (isUsingUSDatePatternOnNonUSDevice(str)) {
            return getFormattedUtcDate(date.getTime(), DATE_PATTERN_NUMBERS_SLASHES_NON_US);
        }
        return getFormattedUtcDate(date.getTime(), str);
    }

    public static String getFormattedUtcDateTimeFromOffsetDateTime(OffsetDateTime offsetDateTime) {
        return offsetDateTime.format(DateTimeFormatter.ofPattern(DATE_WITH_TIME_PATTERN));
    }

    private static String getLanguageLocale() {
        return Locale.getDefault().toString();
    }

    public static String getLastActivityDateString(Context context, String str) {
        Date date;
        if (str == null || (date = getDate(str)) == null) {
            return null;
        }
        long currentTimestamp = getCurrentTimestamp() - date.getTime();
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(date.getTime());
        int i10 = instance.get(6);
        int i11 = instance2.get(6);
        int i12 = instance.get(1);
        int i13 = instance2.get(1);
        if (i11 == i10) {
            return getFormattedLocalDate(str, DATE_WITH_TIME_PATTERN, TIME_PATTERN_NO_SECONDS);
        }
        if (i11 == i10 - 1 || (i12 == i13 + 1 && i10 == 1 && (i11 == 365 || i11 == 364))) {
            return context.getString(R.string.yesterday);
        }
        if (currentTimestamp >= MILLIS_IN_WEEK) {
            return getFormattedLocalDate(str, DATE_WITH_TIME_PATTERN, DATE_PATTERN_NUMBERS_SLASHES_DEFAULT);
        }
        int i14 = (int) (currentTimestamp / 86400000);
        return context.getResources().getQuantityString(R.plurals.days_ago, i14, new Object[]{Integer.valueOf(i14)});
    }

    public static Date getLocalDate(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(UTC_TIMEZONE_STRING));
        try {
            return new Date(simpleDateFormat.parse(str).getTime() + ((long) TimeZone.getDefault().getOffset(new Date(System.currentTimeMillis()).getTime())));
        } catch (ParseException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String getLocalizedDateFromStringDate(Context context, String str, String str2) {
        try {
            return DateFormat.getDateFormat(context).format(new SimpleDateFormat(str2, Locale.getDefault()).parse(str));
        } catch (ParseException unused) {
            return null;
        }
    }

    public static Long getMillisFromUtc(String str) {
        return getMillisFromUtc(str, new String[]{DATE_WITH_TIME_PATTERN, DATE_PATTERN, DATE_PATTERN_NUMBERS_SLASHES_DEFAULT});
    }

    public static long getNumberOfDaysRegisteredFromToday(String str) {
        try {
            Date parse = new SimpleDateFormat(DATE_WITH_TIME_PATTERN, Locale.US).parse(str);
            return TimeUnit.DAYS.convert(new Date().getTime() - parse.getTime(), TimeUnit.MILLISECONDS);
        } catch (ParseException unused) {
            return 0;
        }
    }

    public static OffsetDateTime getOffsetDateTimeForFormattedUtcDateTime(String str) {
        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(DATE_WITH_TIME_PATTERN)).atZone(ZoneId.of(UTC_TIMEZONE_STRING)).toOffsetDateTime();
    }

    public static String getReadableDate(String str) {
        Calendar calendarFromStringDate = getCalendarFromStringDate(str);
        return (calendarFromStringDate.get(2) + 1) + RemoteSettings.FORWARD_SLASH_STRING + calendarFromStringDate.get(5) + RemoteSettings.FORWARD_SLASH_STRING + (calendarFromStringDate.get(1) % 100);
    }

    public static Date getRegistrationDate(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_WITH_TIME_PATTERN, Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(UTC_TIMEZONE_STRING));
            return simpleDateFormat.parse(str);
        } catch (ParseException e10) {
            a.i(e10);
            return null;
        }
    }

    public static long getRemainingTime(String str, long j10) {
        Date date = getDate(str);
        if (date == null) {
            return -1;
        }
        return date.getTime() - j10;
    }

    public static long getTimeElapsed(String str) {
        Date date = getDate(str);
        if (date == null) {
            return -1;
        }
        return getCurrentTimestamp() - date.getTime();
    }

    public static long getTimestampForLastNoon() {
        return getTimestampForNextNoon(System.currentTimeMillis()) - 86400000;
    }

    public static long getTimestampForNextNoon() {
        return getTimestampForNextNoon(Calendar.getInstance().getTimeInMillis());
    }

    public static String getUtcFromMillis(long j10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_WITH_TIME_PATTERN, Locale.getDefault());
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(UTC_TIMEZONE_STRING));
        return simpleDateFormat.format(new Date(j10));
    }

    private static boolean isCurrentLocaleUS() {
        return getLanguageLocale().toLowerCase().equals("en_us");
    }

    public static boolean isEligibleForFirstLike(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_WITH_TIME_PATTERN, Locale.US);
        try {
            Date parse = simpleDateFormat.parse(str);
            Date parse2 = simpleDateFormat.parse("2023-06-08 00:00:00");
            if (TimeUnit.DAYS.convert(parse.getTime() - parse2.getTime(), TimeUnit.MILLISECONDS) > 0) {
                return true;
            }
            return false;
        } catch (ParseException unused) {
            return false;
        }
    }

    private static boolean isUsingUSDatePatternOnNonUSDevice(String str) {
        return str.equals(DATE_PATTERN_NUMBERS_SLASHES_DEFAULT) && !isCurrentLocaleUS();
    }

    public static Long getMillisFromUtc(String str, String str2) {
        return getMillisFromUtc(str, new String[]{str2});
    }

    public static String getFormattedDate(Date date, String str, Locale locale) {
        return new SimpleDateFormat(str, locale).format(date);
    }

    private static Long getMillisFromUtc(String str, String[] strArr) {
        Long millisFromUtc;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return getMillisFromUtc(str, strArr, dateFormatCacheNonBlocking, parsedUtcTimestampCacheNonBlocking);
        }
        Map<String, SimpleDateFormat> map = dateFormatCacheBlocking;
        synchronized (map) {
            millisFromUtc = getMillisFromUtc(str, strArr, map, parsedUtcTimestampCacheBlocking);
        }
        return millisFromUtc;
    }

    public static long getTimestampForNextNoon(long j10) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j10);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j10);
        gregorianCalendar2.set(11, 12);
        gregorianCalendar2.set(12, 0);
        gregorianCalendar2.set(13, 0);
        gregorianCalendar2.set(14, 0);
        if (gregorianCalendar2.before(gregorianCalendar) || gregorianCalendar2.equals(gregorianCalendar)) {
            gregorianCalendar2.add(5, 1);
        }
        return gregorianCalendar2.getTimeInMillis();
    }

    public static String getFormattedUtcDate(long j10, String str) {
        if (j10 == 0) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeZone(DesugarTimeZone.getTimeZone(UTC_TIMEZONE_STRING));
        gregorianCalendar.setTimeInMillis(j10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(gregorianCalendar.getTimeZone());
        return simpleDateFormat.format(gregorianCalendar.getTime());
    }

    public static String getFormattedDate(int i10, int i11, int i12) {
        return getFormattedDate(i10, i11, i12, isCurrentLocaleUS() ? DATE_PATTERN_NUMBERS_SLASHES_DEFAULT : DATE_PATTERN_NUMBERS_SLASHES_NON_US);
    }

    private static String getFormattedDate(int i10, int i11, int i12, String str) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(i10, i11, i12);
        Date time = gregorianCalendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        simpleDateFormat.setTimeZone(gregorianCalendar.getTimeZone());
        return simpleDateFormat.format(time);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054 A[Catch:{ ParseException -> 0x0017 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Long getMillisFromUtc(java.lang.String r4, java.lang.String[] r5, java.util.Map<java.lang.String, java.text.SimpleDateFormat> r6, androidx.collection.f<java.lang.String, java.lang.Long> r7) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r7 == 0) goto L_0x000f
            java.lang.Object r1 = r7.get(r4)
            java.lang.Long r1 = (java.lang.Long) r1
            if (r1 == 0) goto L_0x000f
            return r1
        L_0x000f:
            java.util.List r5 = java.util.Arrays.asList(r5)
            java.util.Iterator r5 = r5.iterator()
        L_0x0017:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0060
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            if (r6 == 0) goto L_0x0032
            boolean r2 = r6.containsKey(r1)     // Catch:{ ParseException -> 0x0017 }
            if (r2 == 0) goto L_0x0032
            java.lang.Object r1 = r6.get(r1)     // Catch:{ ParseException -> 0x0017 }
            java.text.SimpleDateFormat r1 = (java.text.SimpleDateFormat) r1     // Catch:{ ParseException -> 0x0017 }
            goto L_0x0041
        L_0x0032:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0017 }
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ ParseException -> 0x0017 }
            r2.<init>(r1, r3)     // Catch:{ ParseException -> 0x0017 }
            if (r6 == 0) goto L_0x0040
            r6.put(r1, r2)     // Catch:{ ParseException -> 0x0017 }
        L_0x0040:
            r1 = r2
        L_0x0041:
            java.lang.String r2 = "UTC"
            java.util.TimeZone r2 = j$.util.DesugarTimeZone.getTimeZone(r2)     // Catch:{ ParseException -> 0x0017 }
            r1.setTimeZone(r2)     // Catch:{ ParseException -> 0x0017 }
            java.util.Date r1 = r1.parse(r4)     // Catch:{ ParseException -> 0x0017 }
            long r1 = r1.getTime()     // Catch:{ ParseException -> 0x0017 }
            if (r7 == 0) goto L_0x005b
            java.lang.Long r3 = java.lang.Long.valueOf(r1)     // Catch:{ ParseException -> 0x0017 }
            r7.put(r4, r3)     // Catch:{ ParseException -> 0x0017 }
        L_0x005b:
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ ParseException -> 0x0017 }
            return r4
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.models.util.DateUtils.getMillisFromUtc(java.lang.String, java.lang.String[], java.util.Map, androidx.collection.f):java.lang.Long");
    }

    public static String getFormattedLocalDate(String str, String str2, String str3, String str4) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(UTC_TIMEZONE_STRING));
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e10) {
            a.i(e10);
            date = null;
        }
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        if (isCurrentLocaleUS()) {
            str3 = str4;
        }
        return new SimpleDateFormat(str3, Locale.getDefault()).format(date);
    }
}
