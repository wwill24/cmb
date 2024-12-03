package com.google.android.material.datepicker;

import android.content.Context;
import android.text.format.DateUtils;
import androidx.core.util.d;
import bf.j;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class g {
    static d<String, String> a(Long l10, Long l11) {
        return b(l10, l11, (SimpleDateFormat) null);
    }

    static d<String, String> b(Long l10, Long l11, SimpleDateFormat simpleDateFormat) {
        if (l10 == null && l11 == null) {
            return d.a(null, null);
        }
        if (l10 == null) {
            return d.a(null, d(l11.longValue(), simpleDateFormat));
        }
        if (l11 == null) {
            return d.a(d(l10.longValue(), simpleDateFormat), null);
        }
        Calendar j10 = r.j();
        Calendar l12 = r.l();
        l12.setTimeInMillis(l10.longValue());
        Calendar l13 = r.l();
        l13.setTimeInMillis(l11.longValue());
        if (simpleDateFormat != null) {
            return d.a(simpleDateFormat.format(new Date(l10.longValue())), simpleDateFormat.format(new Date(l11.longValue())));
        } else if (l12.get(1) != l13.get(1)) {
            return d.a(n(l10.longValue(), Locale.getDefault()), n(l11.longValue(), Locale.getDefault()));
        } else {
            if (l12.get(1) == j10.get(1)) {
                return d.a(g(l10.longValue(), Locale.getDefault()), g(l11.longValue(), Locale.getDefault()));
            }
            return d.a(g(l10.longValue(), Locale.getDefault()), n(l11.longValue(), Locale.getDefault()));
        }
    }

    static String c(long j10) {
        return d(j10, (SimpleDateFormat) null);
    }

    static String d(long j10, SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j10));
        }
        if (q(j10)) {
            return f(j10);
        }
        return m(j10);
    }

    static String e(Context context, long j10, boolean z10, boolean z11, boolean z12) {
        String j11 = j(j10);
        if (z10) {
            j11 = String.format(context.getString(j.mtrl_picker_today_description), new Object[]{j11});
        }
        if (z11) {
            return String.format(context.getString(j.mtrl_picker_start_date_description), new Object[]{j11});
        } else if (!z12) {
            return j11;
        } else {
            return String.format(context.getString(j.mtrl_picker_end_date_description), new Object[]{j11});
        }
    }

    static String f(long j10) {
        return g(j10, Locale.getDefault());
    }

    static String g(long j10, Locale locale) {
        return r.b(locale).format(new Date(j10));
    }

    static String h(long j10) {
        return i(j10, Locale.getDefault());
    }

    static String i(long j10, Locale locale) {
        return r.c(locale).format(new Date(j10));
    }

    static String j(long j10) {
        if (q(j10)) {
            return h(j10);
        }
        return o(j10);
    }

    static String k(Context context, int i10) {
        if (r.j().get(1) == i10) {
            return String.format(context.getString(j.mtrl_picker_navigate_to_current_year_description), new Object[]{Integer.valueOf(i10)});
        }
        return String.format(context.getString(j.mtrl_picker_navigate_to_year_description), new Object[]{Integer.valueOf(i10)});
    }

    static String l(long j10) {
        return DateUtils.formatDateTime((Context) null, j10, 8228);
    }

    static String m(long j10) {
        return n(j10, Locale.getDefault());
    }

    static String n(long j10, Locale locale) {
        return r.n(locale).format(new Date(j10));
    }

    static String o(long j10) {
        return p(j10, Locale.getDefault());
    }

    static String p(long j10, Locale locale) {
        return r.o(locale).format(new Date(j10));
    }

    private static boolean q(long j10) {
        Calendar j11 = r.j();
        Calendar l10 = r.l();
        l10.setTimeInMillis(j10);
        if (j11.get(1) == l10.get(1)) {
            return true;
        }
        return false;
    }
}
