package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import androidx.core.view.n0;
import bf.l;
import qf.c;
import tf.g;
import tf.k;

final class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Rect f19585a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f19586b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f19587c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f19588d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19589e;

    /* renamed from: f  reason: collision with root package name */
    private final k f19590f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, k kVar, @NonNull Rect rect) {
        h.d(rect.left);
        h.d(rect.top);
        h.d(rect.right);
        h.d(rect.bottom);
        this.f19585a = rect;
        this.f19586b = colorStateList2;
        this.f19587c = colorStateList;
        this.f19588d = colorStateList3;
        this.f19589e = i10;
        this.f19590f = kVar;
    }

    @NonNull
    static a a(@NonNull Context context, int i10) {
        boolean z10;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.b(z10, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, l.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a10 = c.a(context, obtainStyledAttributes, l.MaterialCalendarItem_itemFillColor);
        ColorStateList a11 = c.a(context, obtainStyledAttributes, l.MaterialCalendarItem_itemTextColor);
        ColorStateList a12 = c.a(context, obtainStyledAttributes, l.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(l.MaterialCalendarItem_itemStrokeWidth, 0);
        k m10 = k.b(context, obtainStyledAttributes.getResourceId(l.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(l.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        obtainStyledAttributes.recycle();
        return new a(a10, a11, a12, dimensionPixelSize, m10, rect);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f19585a.bottom;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f19585a.top;
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull TextView textView) {
        e(textView, (ColorStateList) null);
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull TextView textView, ColorStateList colorStateList) {
        g gVar = new g();
        g gVar2 = new g();
        gVar.setShapeAppearanceModel(this.f19590f);
        gVar2.setShapeAppearanceModel(this.f19590f);
        if (colorStateList == null) {
            colorStateList = this.f19587c;
        }
        gVar.b0(colorStateList);
        gVar.i0((float) this.f19589e, this.f19588d);
        textView.setTextColor(this.f19586b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f19586b.withAlpha(30), gVar, gVar2);
        Rect rect = this.f19585a;
        n0.w0(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
