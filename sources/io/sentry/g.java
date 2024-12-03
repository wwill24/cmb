package io.sentry;

import io.sentry.vendor.gson.internal.bind.util.a;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class g {
    public static long a(Date date) {
        return h(date.getTime());
    }

    public static double b(Date date) {
        return i((double) date.getTime());
    }

    public static Date c() {
        return Calendar.getInstance(a.f31745a).getTime();
    }

    public static Date d(long j10) {
        Calendar instance = Calendar.getInstance(a.f31745a);
        instance.setTimeInMillis(j10);
        return instance.getTime();
    }

    public static Date e(String str) throws IllegalArgumentException {
        try {
            return a.f(str, new ParsePosition(0));
        } catch (ParseException unused) {
            throw new IllegalArgumentException("timestamp is not ISO format " + str);
        }
    }

    public static Date f(String str) throws IllegalArgumentException {
        try {
            return d(new BigDecimal(str).setScale(3, RoundingMode.DOWN).movePointRight(3).longValue());
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("timestamp is not millis format " + str);
        }
    }

    public static String g(Date date) {
        return a.b(date, true);
    }

    public static long h(long j10) {
        return j10 * 1000000;
    }

    public static double i(double d10) {
        return d10 / 1000.0d;
    }

    public static Date j(long j10) {
        return d(Double.valueOf(k(Double.valueOf((double) j10).doubleValue())).longValue());
    }

    public static double k(double d10) {
        return d10 / 1000000.0d;
    }

    public static double l(long j10) {
        return Double.valueOf((double) j10).doubleValue() / 1.0E9d;
    }

    public static long m(long j10) {
        return j10 * 1000000000;
    }

    public static Date n(u2 u2Var) {
        if (u2Var == null) {
            return null;
        }
        return o(u2Var);
    }

    public static Date o(u2 u2Var) {
        return j(u2Var.h());
    }
}
