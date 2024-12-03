package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.view.View;
import android.widget.EditText;

public final /* synthetic */ class e implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f27577a;

    public /* synthetic */ e(EditText editText) {
        this.f27577a = editText;
    }

    public final void onFocusChange(View view, boolean z10) {
        InputsKt.w(this.f27577a, view, z10);
    }
}
