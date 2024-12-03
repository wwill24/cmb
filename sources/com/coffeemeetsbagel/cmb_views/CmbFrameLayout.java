package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import io.reactivex.subjects.a;
import j5.x;

public class CmbFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final a<x> f11479a = a.C0();

    public CmbFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean performClick() {
        this.f11479a.d(x.a());
        return super.performClick();
    }
}
