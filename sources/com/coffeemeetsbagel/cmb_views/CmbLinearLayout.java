package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import io.reactivex.subjects.PublishSubject;
import j5.x;
import qj.q;

public class CmbLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<x> f11482a = PublishSubject.C0();

    public CmbLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public q<x> a() {
        return this.f11482a.P();
    }

    public boolean performClick() {
        this.f11482a.d(x.a());
        return super.performClick();
    }
}
