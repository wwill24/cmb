package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import io.reactivex.subjects.PublishSubject;
import j5.x;
import qj.q;

public class CmbImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<x> f11481a = PublishSubject.C0();

    public CmbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public q<x> c() {
        return this.f11481a.P();
    }

    public boolean performClick() {
        this.f11481a.d(x.a());
        return super.performClick();
    }
}
