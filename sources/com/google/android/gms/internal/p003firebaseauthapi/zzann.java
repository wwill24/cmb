package com.google.android.gms.internal.p003firebaseauthapi;

import com.coffeemeetsbagel.models.util.DateUtils;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzann  reason: invalid package */
final class zzann extends ThreadLocal {
    zzann() {
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
