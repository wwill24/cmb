package com.skydoves.balloon;

import android.view.View;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f22795a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Balloon f22796b;

    public /* synthetic */ d(q qVar, Balloon balloon) {
        this.f22795a = qVar;
        this.f22796b = balloon;
    }

    public final void onClick(View view) {
        Balloon.x0(this.f22795a, this.f22796b, view);
    }
}
