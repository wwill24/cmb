package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import bf.l;
import qf.c;

final class b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final a f19591a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final a f19592b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final a f19593c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final a f19594d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    final a f19595e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    final a f19596f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    final a f19597g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    final Paint f19598h;

    b(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(qf.b.d(context, bf.b.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), l.MaterialCalendar);
        this.f19591a = a.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_dayStyle, 0));
        this.f19597g = a.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_dayInvalidStyle, 0));
        this.f19592b = a.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_daySelectedStyle, 0));
        this.f19593c = a.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a10 = c.a(context, obtainStyledAttributes, l.MaterialCalendar_rangeFillColor);
        this.f19594d = a.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_yearStyle, 0));
        this.f19595e = a.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_yearSelectedStyle, 0));
        this.f19596f = a.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f19598h = paint;
        paint.setColor(a10.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
