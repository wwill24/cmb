package com.skydoves.balloon;

import android.widget.PopupWindow;

public final /* synthetic */ class e implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Balloon f22797a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f22798b;

    public /* synthetic */ e(Balloon balloon, n nVar) {
        this.f22797a = balloon;
        this.f22798b = nVar;
    }

    public final void onDismiss() {
        Balloon.u0(this.f22797a, this.f22798b);
    }
}
