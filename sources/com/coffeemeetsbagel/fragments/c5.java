package com.coffeemeetsbagel.fragments;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public final /* synthetic */ class c5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e5 f13618a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13619b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13620c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13621d;

    public /* synthetic */ c5(e5 e5Var, CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3) {
        this.f13618a = e5Var;
        this.f13619b = cmbTextView;
        this.f13620c = cmbTextView2;
        this.f13621d = cmbTextView3;
    }

    public final void onClick(View view) {
        this.f13618a.W1(this.f13619b, this.f13620c, this.f13621d, view);
    }
}
