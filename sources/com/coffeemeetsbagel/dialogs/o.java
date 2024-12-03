package com.coffeemeetsbagel.dialogs;

import android.view.View;
import android.widget.NumberPicker;
import z9.c;

public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f12125a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NumberPicker f12126b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f12127c;

    public /* synthetic */ o(p pVar, NumberPicker numberPicker, c cVar) {
        this.f12125a = pVar;
        this.f12126b = numberPicker;
        this.f12127c = cVar;
    }

    public final void onClick(View view) {
        this.f12125a.b(this.f12126b, this.f12127c, view);
    }
}
