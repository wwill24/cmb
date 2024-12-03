package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.m;
import io.reactivex.subjects.a;
import j5.x;
import qj.q;

public class CmbImageButton extends m {

    /* renamed from: d  reason: collision with root package name */
    private final a<x> f11480d = a.C0();

    public CmbImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public q<x> a() {
        return this.f11480d.P();
    }

    public boolean performClick() {
        this.f11480d.d(x.a());
        return super.performClick();
    }
}
