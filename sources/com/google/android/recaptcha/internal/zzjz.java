package com.google.android.recaptcha.internal;

import com.coffeemeetsbagel.models.util.DateUtils;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

final class zzjz extends ThreadLocal {
    zzjz() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.DATE_WITH_TIME_PATTERN_ISO_8601, Locale.ENGLISH);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat;
    }
}
