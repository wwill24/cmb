package com.coffeemeetsbagel.dialogs;

import android.view.View;
import android.widget.NumberPicker;
import z9.c;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f12121a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NumberPicker f12122b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NumberPicker f12123c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f12124d;

    public /* synthetic */ m(n nVar, NumberPicker numberPicker, NumberPicker numberPicker2, c cVar) {
        this.f12121a = nVar;
        this.f12122b = numberPicker;
        this.f12123c = numberPicker2;
        this.f12124d = cVar;
    }

    public final void onClick(View view) {
        this.f12121a.b(this.f12122b, this.f12123c, this.f12124d, view);
    }
}
