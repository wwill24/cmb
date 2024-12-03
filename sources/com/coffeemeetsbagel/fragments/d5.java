package com.coffeemeetsbagel.fragments;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public final /* synthetic */ class d5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e5 f13647a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13649c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13650d;

    public /* synthetic */ d5(e5 e5Var, CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3) {
        this.f13647a = e5Var;
        this.f13648b = cmbTextView;
        this.f13649c = cmbTextView2;
        this.f13650d = cmbTextView3;
    }

    public final void onClick(View view) {
        this.f13647a.X1(this.f13648b, this.f13649c, this.f13650d, view);
    }
}
