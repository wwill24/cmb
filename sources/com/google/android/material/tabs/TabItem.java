package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.h1;
import bf.l;

public class TabItem extends View {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f20146a;

    /* renamed from: b  reason: collision with root package name */
    public final Drawable f20147b;

    /* renamed from: c  reason: collision with root package name */
    public final int f20148c;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h1 u10 = h1.u(context, attributeSet, l.TabItem);
        this.f20146a = u10.p(l.TabItem_android_text);
        this.f20147b = u10.g(l.TabItem_android_icon);
        this.f20148c = u10.n(l.TabItem_android_layout, 0);
        u10.w();
    }
}
