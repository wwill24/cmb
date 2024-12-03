package com.skydoves.balloon;

import android.view.View;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f22790a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Balloon f22791b;

    public /* synthetic */ b(m mVar, Balloon balloon) {
        this.f22790a = mVar;
        this.f22791b = balloon;
    }

    public final void onClick(View view) {
        Balloon.s0(this.f22790a, this.f22791b, view);
    }
}
