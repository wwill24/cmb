package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

class q {

    /* renamed from: c  reason: collision with root package name */
    private static final q f19666c = new q((Long) null, (TimeZone) null);

    /* renamed from: a  reason: collision with root package name */
    private final Long f19667a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeZone f19668b;

    private q(Long l10, TimeZone timeZone) {
        this.f19667a = l10;
        this.f19668b = timeZone;
    }

    static q c() {
        return f19666c;
    }

    /* access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f19668b);
    }

    /* access modifiers changed from: package-private */
    public Calendar b(TimeZone timeZone) {
        Calendar calendar;
        if (timeZone == null) {
            calendar = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(timeZone);
        }
        Long l10 = this.f19667a;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        return calendar;
    }
}
