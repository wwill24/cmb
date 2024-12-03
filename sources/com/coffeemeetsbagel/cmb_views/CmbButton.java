package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import io.reactivex.subjects.a;
import j5.x;
import qj.q;

public class CmbButton extends AppCompatButton {

    /* renamed from: d  reason: collision with root package name */
    private final a<x> f11475d = a.C0();

    public CmbButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public q<x> a() {
        return this.f11475d.P();
    }

    public boolean performClick() {
        this.f11475d.d(x.a());
        return super.performClick();
    }
}
