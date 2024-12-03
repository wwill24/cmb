package com.coffeemeetsbagel.dialogs;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbEditText;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f12128a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbEditText f12129b;

    public /* synthetic */ q(r rVar, CmbEditText cmbEditText) {
        this.f12128a = rVar;
        this.f12129b = cmbEditText;
    }

    public final void onClick(View view) {
        this.f12128a.b(this.f12129b, view);
    }
}
