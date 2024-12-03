package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;

public final /* synthetic */ class f implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText[] f19609a;

    public /* synthetic */ f(EditText[] editTextArr) {
        this.f19609a = editTextArr;
    }

    public final void onFocusChange(View view, boolean z10) {
        DateSelector.N0(this.f19609a, view, z10);
    }
}
