package com.coffeemeetsbagel.fragments;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public final /* synthetic */ class m4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e5 f13775a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13776b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13777c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13778d;

    public /* synthetic */ m4(e5 e5Var, CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3) {
        this.f13775a = e5Var;
        this.f13776b = cmbTextView;
        this.f13777c = cmbTextView2;
        this.f13778d = cmbTextView3;
    }

    public final void onClick(View view) {
        this.f13775a.Y1(this.f13776b, this.f13777c, this.f13778d, view);
    }
}
