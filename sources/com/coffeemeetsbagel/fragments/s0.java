package com.coffeemeetsbagel.fragments;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public final /* synthetic */ class s0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f13826a;

    public /* synthetic */ s0(ImageView imageView) {
        this.f13826a = imageView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return u0.L0(this.f13826a, view, motionEvent);
    }
}
